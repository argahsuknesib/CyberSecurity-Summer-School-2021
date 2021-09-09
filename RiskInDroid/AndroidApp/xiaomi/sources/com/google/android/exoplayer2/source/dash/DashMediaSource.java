package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DashMediaSource extends BaseMediaSource {
    @Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS = 30000;
    @Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_PREFER_MANIFEST_MS = -1;
    private final DashChunkSource.Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private DataSource dataSource;
    private final DrmSessionManager drmSessionManager;
    private long elapsedRealtimeOffsetMs;
    private long expiredManifestPublishTimeUs;
    private int firstPeriodId;
    private Handler handler;
    private Uri initialManifestUri;
    private final long livePresentationDelayMs;
    private final boolean livePresentationDelayOverridesManifest;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    public Loader loader;
    private DashManifest manifest;
    private final ManifestCallback manifestCallback;
    private final DataSource.Factory manifestDataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    public IOException manifestFatalError;
    private long manifestLoadEndTimestampMs;
    private final LoaderErrorThrower manifestLoadErrorThrower;
    private boolean manifestLoadPending;
    private long manifestLoadStartTimestampMs;
    private final ParsingLoadable.Parser<? extends DashManifest> manifestParser;
    private Uri manifestUri;
    private final Object manifestUriLock;
    private TransferListener mediaTransferListener;
    private final SparseArray<DashMediaPeriod> periodsById;
    private final PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback;
    private final Runnable refreshManifestRunnable;
    private final boolean sideloadedManifest;
    private final Runnable simulateManifestRefreshRunnable;
    private int staleManifestReloadAttempt;
    private final Object tag;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    public static final class Factory implements MediaSourceFactory {
        private final DashChunkSource.Factory chunkSourceFactory;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManager drmSessionManager;
        private long livePresentationDelayMs;
        private boolean livePresentationDelayOverridesManifest;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final DataSource.Factory manifestDataSourceFactory;
        private ParsingLoadable.Parser<? extends DashManifest> manifestParser;
        private List<StreamKey> streamKeys;
        private Object tag;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        public Factory(DashChunkSource.Factory factory, DataSource.Factory factory2) {
            this.chunkSourceFactory = (DashChunkSource.Factory) Assertions.checkNotNull(factory);
            this.manifestDataSourceFactory = factory2;
            this.drmSessionManager = DrmSessionManager.CC.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.livePresentationDelayMs = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
            this.streamKeys = Collections.emptyList();
        }

        @Deprecated
        public final Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        @Deprecated
        public final Factory setStreamKeys(List<StreamKey> list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.streamKeys = list;
            return this;
        }

        public final Factory setDrmSessionManager(DrmSessionManager drmSessionManager2) {
            if (drmSessionManager2 == null) {
                drmSessionManager2 = DrmSessionManager.CC.getDummyDrmSessionManager();
            }
            this.drmSessionManager = drmSessionManager2;
            return this;
        }

        @Deprecated
        public final Factory setMinLoadableRetryCount(int i) {
            return setLoadErrorHandlingPolicy((LoadErrorHandlingPolicy) new DefaultLoadErrorHandlingPolicy(i));
        }

        public final Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            if (loadErrorHandlingPolicy2 == null) {
                loadErrorHandlingPolicy2 = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            return this;
        }

        @Deprecated
        public final Factory setLivePresentationDelayMs(long j) {
            if (j == -1) {
                return setLivePresentationDelayMs(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, false);
            }
            return setLivePresentationDelayMs(j, true);
        }

        public final Factory setLivePresentationDelayMs(long j, boolean z) {
            this.livePresentationDelayMs = j;
            this.livePresentationDelayOverridesManifest = z;
            return this;
        }

        public final Factory setManifestParser(ParsingLoadable.Parser<? extends DashManifest> parser) {
            this.manifestParser = parser;
            return this;
        }

        public final Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2) {
            if (compositeSequenceableLoaderFactory2 == null) {
                compositeSequenceableLoaderFactory2 = new DefaultCompositeSequenceableLoaderFactory();
            }
            this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
            return this;
        }

        public final DashMediaSource createMediaSource(DashManifest dashManifest) {
            Assertions.checkArgument(!dashManifest.dynamic);
            if (!this.streamKeys.isEmpty()) {
                dashManifest = dashManifest.copy(this.streamKeys);
            }
            return new DashMediaSource(dashManifest, null, null, null, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, this.livePresentationDelayOverridesManifest, this.tag);
        }

        @Deprecated
        public final DashMediaSource createMediaSource(DashManifest dashManifest, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            DashMediaSource createMediaSource = createMediaSource(dashManifest);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Deprecated
        public final DashMediaSource createMediaSource(Uri uri, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            DashMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Deprecated
        public final DashMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setSourceUri(uri).build());
        }

        public final DashMediaSource createMediaSource(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.checkNotNull(mediaItem2.playbackProperties);
            ParsingLoadable.Parser parser = this.manifestParser;
            if (parser == null) {
                parser = new DashManifestParser();
            }
            List<StreamKey> list = !mediaItem2.playbackProperties.streamKeys.isEmpty() ? mediaItem2.playbackProperties.streamKeys : this.streamKeys;
            return new DashMediaSource(null, mediaItem2.playbackProperties.sourceUri, this.manifestDataSourceFactory, !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, this.livePresentationDelayOverridesManifest, mediaItem2.playbackProperties.tag != null ? mediaItem2.playbackProperties.tag : this.tag);
        }

        public final int[] getSupportedTypes() {
            return new int[]{0};
        }
    }

    @Deprecated
    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
        this(dashManifest, factory, 3, handler2, mediaSourceEventListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DashMediaSource(DashManifest dashManifest, DashChunkSource.Factory factory, int i, Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
        this(dashManifest, null, null, null, factory, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.CC.getDummyDrmSessionManager(), new DefaultLoadErrorHandlingPolicy(i), DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, false, null);
        Handler handler3 = handler2;
        MediaSourceEventListener mediaSourceEventListener2 = mediaSourceEventListener;
        if (handler3 != null && mediaSourceEventListener2 != null) {
            addEventListener(handler3, mediaSourceEventListener2);
        }
    }

    @Deprecated
    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, -1, handler2, mediaSourceEventListener);
    }

    @Deprecated
    public DashMediaSource(Uri uri, DataSource.Factory factory, DashChunkSource.Factory factory2, int i, long j, Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new DashManifestParser(), factory2, i, j, handler2, mediaSourceEventListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DashMediaSource(Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, int i, long j, Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.CC.getDummyDrmSessionManager(), new DefaultLoadErrorHandlingPolicy(i), j == -1 ? 30000 : j, j != -1, null);
        Handler handler3 = handler2;
        MediaSourceEventListener mediaSourceEventListener2 = mediaSourceEventListener;
        if (handler3 != null && mediaSourceEventListener2 != null) {
            addEventListener(handler3, mediaSourceEventListener2);
        }
    }

    private DashMediaSource(DashManifest dashManifest, Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, long j, boolean z, Object obj) {
        this.initialManifestUri = uri;
        this.manifest = dashManifest;
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.livePresentationDelayMs = j;
        this.livePresentationDelayOverridesManifest = z;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.tag = obj;
        this.sideloadedManifest = dashManifest != null;
        this.manifestEventDispatcher = createEventDispatcher(null);
        this.manifestUriLock = new Object();
        this.periodsById = new SparseArray<>();
        this.playerEmsgCallback = new DefaultPlayerEmsgCallback();
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.elapsedRealtimeOffsetMs = -9223372036854775807L;
        if (this.sideloadedManifest) {
            Assertions.checkState(!dashManifest.dynamic);
            this.manifestCallback = null;
            this.refreshManifestRunnable = null;
            this.simulateManifestRefreshRunnable = null;
            this.manifestLoadErrorThrower = new LoaderErrorThrower.Dummy();
            return;
        }
        this.manifestCallback = new ManifestCallback();
        this.manifestLoadErrorThrower = new ManifestLoadErrorThrower();
        this.refreshManifestRunnable = new Runnable() {
            /* class com.google.android.exoplayer2.source.dash.$$Lambda$DashMediaSource$QbzYvqCY1TT8f0KClkalovGOxc */

            public final void run() {
                DashMediaSource.this.startLoadingManifest();
            }
        };
        this.simulateManifestRefreshRunnable = new Runnable() {
            /* class com.google.android.exoplayer2.source.dash.$$Lambda$DashMediaSource$e1nzBO4m3YSG1BkxQDKPaNvDa8 */

            public final void run() {
                DashMediaSource.this.lambda$new$0$DashMediaSource();
            }
        };
    }

    public /* synthetic */ void lambda$new$0$DashMediaSource() {
        processManifest(false);
    }

    public final void replaceManifestUri(Uri uri) {
        synchronized (this.manifestUriLock) {
            this.manifestUri = uri;
            this.initialManifestUri = uri;
        }
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.prepare();
        if (this.sideloadedManifest) {
            processManifest(false);
            return;
        }
        this.dataSource = this.manifestDataSourceFactory.createDataSource();
        this.loader = new Loader("Loader:DashMediaSource");
        this.handler = Util.createHandler();
        startLoadingManifest();
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoadErrorThrower.maybeThrowError();
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        int intValue = ((Integer) mediaPeriodId2.periodUid).intValue() - this.firstPeriodId;
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId2, this.manifest.getPeriod(intValue).startMs);
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(this.firstPeriodId + intValue, this.manifest, intValue, this.chunkSourceFactory, this.mediaTransferListener, this.drmSessionManager, this.loadErrorHandlingPolicy, createEventDispatcher, this.elapsedRealtimeOffsetMs, this.manifestLoadErrorThrower, allocator, this.compositeSequenceableLoaderFactory, this.playerEmsgCallback);
        this.periodsById.put(dashMediaPeriod.id, dashMediaPeriod);
        return dashMediaPeriod;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.release();
        this.periodsById.remove(dashMediaPeriod.id);
    }

    public final void releaseSourceInternal() {
        this.manifestLoadPending = false;
        this.dataSource = null;
        Loader loader2 = this.loader;
        if (loader2 != null) {
            loader2.release();
            this.loader = null;
        }
        this.manifestLoadStartTimestampMs = 0;
        this.manifestLoadEndTimestampMs = 0;
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestUri = this.initialManifestUri;
        this.manifestFatalError = null;
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.elapsedRealtimeOffsetMs = -9223372036854775807L;
        this.staleManifestReloadAttempt = 0;
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.firstPeriodId = 0;
        this.periodsById.clear();
        this.drmSessionManager.release();
    }

    /* access modifiers changed from: package-private */
    public final void onDashManifestRefreshRequested() {
        this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
        startLoadingManifest();
    }

    /* access modifiers changed from: package-private */
    public final void onDashManifestPublishTimeExpired(long j) {
        long j2 = this.expiredManifestPublishTimeUs;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.expiredManifestPublishTimeUs = j;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7  */
    public final void onManifestLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
        boolean z;
        ParsingLoadable<DashManifest> parsingLoadable2 = parsingLoadable;
        long j3 = j;
        this.manifestEventDispatcher.loadCompleted(parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable2.type, j, j2, parsingLoadable.bytesLoaded());
        DashManifest result = parsingLoadable.getResult();
        DashManifest dashManifest = this.manifest;
        boolean z2 = false;
        int periodCount = dashManifest == null ? 0 : dashManifest.getPeriodCount();
        long j4 = result.getPeriod(0).startMs;
        int i = 0;
        while (i < periodCount && this.manifest.getPeriod(i).startMs < j4) {
            i++;
        }
        if (result.dynamic) {
            if (periodCount - i > result.getPeriodCount()) {
                Log.w("DashMediaSource", "Loaded out of sync manifest");
            } else if (this.expiredManifestPublishTimeUs == -9223372036854775807L || result.publishTimeMs * 1000 > this.expiredManifestPublishTimeUs) {
                z = false;
                if (!z) {
                    int i2 = this.staleManifestReloadAttempt;
                    this.staleManifestReloadAttempt = i2 + 1;
                    if (i2 < this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable2.type)) {
                        scheduleManifestRefresh(getManifestLoadRetryDelayMillis());
                        return;
                    } else {
                        this.manifestFatalError = new DashManifestStaleException();
                        return;
                    }
                } else {
                    this.staleManifestReloadAttempt = 0;
                }
            } else {
                Log.w("DashMediaSource", "Loaded stale dynamic manifest: " + result.publishTimeMs + ", " + this.expiredManifestPublishTimeUs);
            }
            z = true;
            if (!z) {
            }
        }
        this.manifest = result;
        this.manifestLoadPending &= this.manifest.dynamic;
        this.manifestLoadStartTimestampMs = j3 - j2;
        this.manifestLoadEndTimestampMs = j3;
        synchronized (this.manifestUriLock) {
            if (parsingLoadable2.dataSpec.uri == this.manifestUri) {
                z2 = true;
            }
            if (z2) {
                this.manifestUri = this.manifest.location != null ? this.manifest.location : parsingLoadable.getUri();
            }
        }
        if (periodCount != 0) {
            this.firstPeriodId += i;
            processManifest(true);
        } else if (!this.manifest.dynamic) {
            processManifest(true);
        } else if (this.manifest.utcTiming != null) {
            resolveUtcTimingElement(this.manifest.utcTiming);
        } else {
            loadNtpTimeOffset();
        }
    }

    /* access modifiers changed from: package-private */
    public final Loader.LoadErrorAction onManifestLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<DashManifest> parsingLoadable2 = parsingLoadable;
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(4, j2, iOException, i);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        this.manifestEventDispatcher.loadError(parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable2.type, j, j2, parsingLoadable.bytesLoaded(), iOException, !loadErrorAction.isRetry());
        return loadErrorAction;
    }

    /* access modifiers changed from: package-private */
    public final void onUtcTimestampLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        this.manifestEventDispatcher.loadCompleted(parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable2.type, j, j2, parsingLoadable.bytesLoaded());
        onUtcTimestampResolved(parsingLoadable.getResult().longValue() - j);
    }

    /* access modifiers changed from: package-private */
    public final Loader.LoadErrorAction onUtcTimestampLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.manifestEventDispatcher;
        DataSpec dataSpec = parsingLoadable2.dataSpec;
        Uri uri = parsingLoadable.getUri();
        Map<String, List<String>> responseHeaders = parsingLoadable.getResponseHeaders();
        int i = parsingLoadable2.type;
        eventDispatcher.loadError(dataSpec, uri, responseHeaders, i, j, j2, parsingLoadable.bytesLoaded(), iOException, true);
        onUtcTimestampResolutionError(iOException);
        return Loader.DONT_RETRY;
    }

    /* access modifiers changed from: package-private */
    public final void onLoadCanceled(ParsingLoadable<?> parsingLoadable, long j, long j2) {
        ParsingLoadable<?> parsingLoadable2 = parsingLoadable;
        this.manifestEventDispatcher.loadCanceled(parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable2.type, j, j2, parsingLoadable.bytesLoaded());
    }

    private void resolveUtcTimingElement(UtcTimingElement utcTimingElement) {
        String str = utcTimingElement.schemeIdUri;
        if (Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            resolveUtcTimingElementDirect(utcTimingElement);
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            resolveUtcTimingElementHttp(utcTimingElement, new Iso8601Parser());
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            resolveUtcTimingElementHttp(utcTimingElement, new XsDateTimeParser());
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2012")) {
            loadNtpTimeOffset();
        } else {
            onUtcTimestampResolutionError(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void resolveUtcTimingElementDirect(UtcTimingElement utcTimingElement) {
        try {
            onUtcTimestampResolved(Util.parseXsDateTime(utcTimingElement.value) - this.manifestLoadEndTimestampMs);
        } catch (ParserException e) {
            onUtcTimestampResolutionError(e);
        }
    }

    private void resolveUtcTimingElementHttp(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        startLoading(new ParsingLoadable(this.dataSource, Uri.parse(utcTimingElement.value), 5, parser), new UtcTimestampCallback(), 1);
    }

    private void loadNtpTimeOffset() {
        SntpClient.initialize(this.loader, new SntpClient.InitializationCallback() {
            /* class com.google.android.exoplayer2.source.dash.DashMediaSource.AnonymousClass1 */

            public void onInitialized() {
                DashMediaSource.this.onUtcTimestampResolved(SntpClient.getElapsedRealtimeOffsetMs());
            }

            public void onInitializationFailed(IOException iOException) {
                DashMediaSource.this.onUtcTimestampResolutionError(iOException);
            }
        });
    }

    public final void onUtcTimestampResolved(long j) {
        this.elapsedRealtimeOffsetMs = j;
        processManifest(true);
    }

    public final void onUtcTimestampResolutionError(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        processManifest(true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private void processManifest(boolean z) {
        long j;
        boolean z2;
        long j2;
        long j3;
        for (int i = 0; i < this.periodsById.size(); i++) {
            int keyAt = this.periodsById.keyAt(i);
            if (keyAt >= this.firstPeriodId) {
                this.periodsById.valueAt(i).updateManifest(this.manifest, keyAt - this.firstPeriodId);
            }
        }
        int periodCount = this.manifest.getPeriodCount() - 1;
        PeriodSeekInfo createPeriodSeekInfo = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(0), this.manifest.getPeriodDurationUs(0));
        PeriodSeekInfo createPeriodSeekInfo2 = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(periodCount), this.manifest.getPeriodDurationUs(periodCount));
        long j4 = createPeriodSeekInfo.availableStartTimeUs;
        long j5 = createPeriodSeekInfo2.availableEndTimeUs;
        if (!this.manifest.dynamic || createPeriodSeekInfo2.isIndexExplicit) {
            j = j4;
            z2 = false;
        } else {
            j5 = Math.min((C.msToUs(Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs)) - C.msToUs(this.manifest.availabilityStartTimeMs)) - C.msToUs(this.manifest.getPeriod(periodCount).startMs), j5);
            if (this.manifest.timeShiftBufferDepthMs != -9223372036854775807L) {
                long msToUs = j5 - C.msToUs(this.manifest.timeShiftBufferDepthMs);
                while (msToUs < 0 && periodCount > 0) {
                    periodCount--;
                    msToUs += this.manifest.getPeriodDurationUs(periodCount);
                }
                if (periodCount == 0) {
                    j3 = Math.max(j4, msToUs);
                } else {
                    j3 = this.manifest.getPeriodDurationUs(0);
                }
                j4 = j3;
            }
            j = j4;
            z2 = true;
        }
        long j6 = j5 - j;
        for (int i2 = 0; i2 < this.manifest.getPeriodCount() - 1; i2++) {
            j6 += this.manifest.getPeriodDurationUs(i2);
        }
        if (this.manifest.dynamic) {
            long j7 = this.livePresentationDelayMs;
            if (!this.livePresentationDelayOverridesManifest && this.manifest.suggestedPresentationDelayMs != -9223372036854775807L) {
                j7 = this.manifest.suggestedPresentationDelayMs;
            }
            long msToUs2 = j6 - C.msToUs(j7);
            if (msToUs2 < 5000000) {
                msToUs2 = Math.min(5000000L, j6 / 2);
            }
            j2 = msToUs2;
        } else {
            j2 = 0;
        }
        refreshSourceInfo(new DashTimeline(this.manifest.availabilityStartTimeMs, this.manifest.availabilityStartTimeMs != -9223372036854775807L ? this.manifest.availabilityStartTimeMs + this.manifest.getPeriod(0).startMs + C.usToMs(j) : -9223372036854775807L, this.elapsedRealtimeOffsetMs, this.firstPeriodId, j, j6, j2, this.manifest, this.tag));
        if (!this.sideloadedManifest) {
            this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
            if (z2) {
                this.handler.postDelayed(this.simulateManifestRefreshRunnable, 5000);
            }
            if (this.manifestLoadPending) {
                startLoadingManifest();
            } else if (z && this.manifest.dynamic && this.manifest.minUpdatePeriodMs != -9223372036854775807L) {
                long j8 = this.manifest.minUpdatePeriodMs;
                if (j8 == 0) {
                    j8 = 5000;
                }
                scheduleManifestRefresh(Math.max(0L, (this.manifestLoadStartTimestampMs + j8) - SystemClock.elapsedRealtime()));
            }
        }
    }

    private void scheduleManifestRefresh(long j) {
        this.handler.postDelayed(this.refreshManifestRunnable, j);
    }

    /* access modifiers changed from: private */
    public void startLoadingManifest() {
        Uri uri;
        this.handler.removeCallbacks(this.refreshManifestRunnable);
        if (!this.loader.hasFatalError()) {
            if (this.loader.isLoading()) {
                this.manifestLoadPending = true;
                return;
            }
            synchronized (this.manifestUriLock) {
                uri = this.manifestUri;
            }
            this.manifestLoadPending = false;
            startLoading(new ParsingLoadable(this.dataSource, uri, 4, this.manifestParser), this.manifestCallback, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(4));
        }
    }

    private long getManifestLoadRetryDelayMillis() {
        return (long) Math.min((this.staleManifestReloadAttempt - 1) * 1000, 5000);
    }

    private <T> void startLoading(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i) {
        this.manifestEventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.loader.startLoading(parsingLoadable, callback, i));
    }

    static final class PeriodSeekInfo {
        public final long availableEndTimeUs;
        public final long availableStartTimeUs;
        public final boolean isIndexExplicit;

        public static PeriodSeekInfo createPeriodSeekInfo(Period period, long j) {
            boolean z;
            int i;
            boolean z2;
            Period period2 = period;
            long j2 = j;
            int size = period2.adaptationSets.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                }
                int i4 = period2.adaptationSets.get(i3).type;
                if (i4 == 1 || i4 == 2) {
                    z = true;
                } else {
                    i3++;
                }
            }
            long j3 = Long.MAX_VALUE;
            int i5 = 0;
            boolean z3 = false;
            boolean z4 = false;
            long j4 = 0;
            while (i5 < size) {
                AdaptationSet adaptationSet = period2.adaptationSets.get(i5);
                if (!z || adaptationSet.type != 3) {
                    DashSegmentIndex index = adaptationSet.representations.get(i2).getIndex();
                    if (index == null) {
                        return new PeriodSeekInfo(true, 0, j);
                    }
                    boolean isExplicit = index.isExplicit() | z4;
                    int segmentCount = index.getSegmentCount(j2);
                    if (segmentCount == 0) {
                        i = size;
                        z2 = z;
                        z4 = isExplicit;
                        z3 = true;
                        j4 = 0;
                        j3 = 0;
                    } else {
                        if (!z3) {
                            z2 = z;
                            long firstSegmentNum = index.getFirstSegmentNum();
                            i = size;
                            long max = Math.max(j4, index.getTimeUs(firstSegmentNum));
                            if (segmentCount != -1) {
                                long j5 = (firstSegmentNum + ((long) segmentCount)) - 1;
                                j4 = max;
                                j3 = Math.min(j3, index.getTimeUs(j5) + index.getDurationUs(j5, j2));
                            } else {
                                j4 = max;
                            }
                        } else {
                            i = size;
                            z2 = z;
                        }
                        z4 = isExplicit;
                    }
                } else {
                    i = size;
                    z2 = z;
                }
                i5++;
                i2 = 0;
                period2 = period;
                z = z2;
                size = i;
            }
            return new PeriodSeekInfo(z4, j4, j3);
        }

        private PeriodSeekInfo(boolean z, long j, long j2) {
            this.isIndexExplicit = z;
            this.availableStartTimeUs = j;
            this.availableEndTimeUs = j2;
        }
    }

    static final class DashTimeline extends Timeline {
        private final long elapsedRealtimeEpochOffsetMs;
        private final int firstPeriodId;
        private final DashManifest manifest;
        private final long offsetInFirstPeriodUs;
        private final long presentationStartTimeMs;
        private final long windowDefaultStartPositionUs;
        private final long windowDurationUs;
        private final long windowStartTimeMs;
        private final Object windowTag;

        public final int getWindowCount() {
            return 1;
        }

        public DashTimeline(long j, long j2, long j3, int i, long j4, long j5, long j6, DashManifest dashManifest, Object obj) {
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.elapsedRealtimeEpochOffsetMs = j3;
            this.firstPeriodId = i;
            this.offsetInFirstPeriodUs = j4;
            this.windowDurationUs = j5;
            this.windowDefaultStartPositionUs = j6;
            this.manifest = dashManifest;
            this.windowTag = obj;
        }

        public final int getPeriodCount() {
            return this.manifest.getPeriodCount();
        }

        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Assertions.checkIndex(i, 0, getPeriodCount());
            Integer num = null;
            String str = z ? this.manifest.getPeriod(i).id : null;
            if (z) {
                num = Integer.valueOf(this.firstPeriodId + i);
            }
            return period.set(str, num, 0, this.manifest.getPeriodDurationUs(i), C.msToUs(this.manifest.getPeriod(i).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
        }

        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            Assertions.checkIndex(i, 0, 1);
            long adjustedWindowDefaultStartPositionUs = getAdjustedWindowDefaultStartPositionUs(j);
            Object obj = Timeline.Window.SINGLE_WINDOW_UID;
            Object obj2 = this.windowTag;
            DashManifest dashManifest = this.manifest;
            return window.set(obj, obj2, dashManifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, true, isMovingLiveWindow(dashManifest), this.manifest.dynamic, adjustedWindowDefaultStartPositionUs, this.windowDurationUs, 0, getPeriodCount() - 1, this.offsetInFirstPeriodUs);
        }

        public final int getIndexOfPeriod(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.firstPeriodId) >= 0 && intValue < getPeriodCount()) {
                return intValue;
            }
            return -1;
        }

        private long getAdjustedWindowDefaultStartPositionUs(long j) {
            DashSegmentIndex index;
            long j2 = this.windowDefaultStartPositionUs;
            if (!isMovingLiveWindow(this.manifest)) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.windowDurationUs) {
                    return -9223372036854775807L;
                }
            }
            long periodDurationUs = this.manifest.getPeriodDurationUs(0);
            long j3 = this.offsetInFirstPeriodUs + j2;
            int i = 0;
            while (i < this.manifest.getPeriodCount() - 1 && j3 >= periodDurationUs) {
                j3 -= periodDurationUs;
                i++;
                periodDurationUs = this.manifest.getPeriodDurationUs(i);
            }
            Period period = this.manifest.getPeriod(i);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            return (adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationUs) == 0) ? j2 : (j2 + index.getTimeUs(index.getSegmentNum(j3, periodDurationUs))) - j3;
        }

        public final Object getUidOfPeriod(int i) {
            Assertions.checkIndex(i, 0, getPeriodCount());
            return Integer.valueOf(this.firstPeriodId + i);
        }

        private static boolean isMovingLiveWindow(DashManifest dashManifest) {
            return dashManifest.dynamic && dashManifest.minUpdatePeriodMs != -9223372036854775807L && dashManifest.durationMs == -9223372036854775807L;
        }
    }

    final class DefaultPlayerEmsgCallback implements PlayerEmsgHandler.PlayerEmsgCallback {
        private DefaultPlayerEmsgCallback() {
        }

        public final void onDashManifestRefreshRequested() {
            DashMediaSource.this.onDashManifestRefreshRequested();
        }

        public final void onDashManifestPublishTimeExpired(long j) {
            DashMediaSource.this.onDashManifestPublishTimeExpired(j);
        }
    }

    final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        private ManifestCallback() {
        }

        public final /* bridge */ /* synthetic */ void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
            onLoadCanceled((ParsingLoadable<DashManifest>) ((ParsingLoadable) loadable), j, j2, z);
        }

        public final /* bridge */ /* synthetic */ void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
            onLoadCompleted((ParsingLoadable<DashManifest>) ((ParsingLoadable) loadable), j, j2);
        }

        public final /* bridge */ /* synthetic */ Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
            return onLoadError((ParsingLoadable<DashManifest>) ((ParsingLoadable) loadable), j, j2, iOException, i);
        }

        public final void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2) {
            DashMediaSource.this.onManifestLoadCompleted(parsingLoadable, j, j2);
        }

        public final void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j, j2);
        }

        public final Loader.LoadErrorAction onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.onManifestLoadError(parsingLoadable, j, j2, iOException, i);
        }
    }

    final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        private UtcTimestampCallback() {
        }

        public final /* bridge */ /* synthetic */ void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
            onLoadCanceled((ParsingLoadable<Long>) ((ParsingLoadable) loadable), j, j2, z);
        }

        public final /* bridge */ /* synthetic */ void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
            onLoadCompleted((ParsingLoadable<Long>) ((ParsingLoadable) loadable), j, j2);
        }

        public final /* bridge */ /* synthetic */ Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
            return onLoadError((ParsingLoadable<Long>) ((ParsingLoadable) loadable), j, j2, iOException, i);
        }

        public final void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j, long j2) {
            DashMediaSource.this.onUtcTimestampLoadCompleted(parsingLoadable, j, j2);
        }

        public final void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j, long j2, boolean z) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j, j2);
        }

        public final Loader.LoadErrorAction onLoadError(ParsingLoadable<Long> parsingLoadable, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.onUtcTimestampLoadError(parsingLoadable, j, j2, iOException);
        }
    }

    static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        private XsDateTimeParser() {
        }

        public final Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {
        private static final Pattern TIMESTAMP_WITH_TIMEZONE_PATTERN = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        Iso8601Parser() {
        }

        public final Long parse(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8"))).readLine();
            try {
                Matcher matcher = TIMESTAMP_WITH_TIMEZONE_PATTERN.matcher(readLine);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    long time = simpleDateFormat.parse(group).getTime();
                    if (!"Z".equals(matcher.group(2))) {
                        long j = "+".equals(matcher.group(4)) ? 1 : -1;
                        long parseLong = Long.parseLong(matcher.group(5));
                        String group2 = matcher.group(7);
                        time -= j * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0 : Long.parseLong(group2))) * 60) * 1000);
                    }
                    return Long.valueOf(time);
                }
                throw new ParserException("Couldn't parse timestamp: ".concat(String.valueOf(readLine)));
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }

    final class ManifestLoadErrorThrower implements LoaderErrorThrower {
        ManifestLoadErrorThrower() {
        }

        public final void maybeThrowError() throws IOException {
            DashMediaSource.this.loader.maybeThrowError();
            maybeThrowManifestError();
        }

        public final void maybeThrowError(int i) throws IOException {
            DashMediaSource.this.loader.maybeThrowError(i);
            maybeThrowManifestError();
        }

        private void maybeThrowManifestError() throws IOException {
            if (DashMediaSource.this.manifestFatalError != null) {
                throw DashMediaSource.this.manifestFatalError;
            }
        }
    }
}
