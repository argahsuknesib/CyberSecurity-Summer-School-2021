package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
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
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    private final SsChunkSource.Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionManager drmSessionManager;
    private final long livePresentationDelayMs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private SsManifest manifest;
    private DataSource manifestDataSource;
    private final DataSource.Factory manifestDataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    private long manifestLoadStartTimestamp;
    private Loader manifestLoader;
    private LoaderErrorThrower manifestLoaderErrorThrower;
    private final ParsingLoadable.Parser<? extends SsManifest> manifestParser;
    private Handler manifestRefreshHandler;
    private final Uri manifestUri;
    private final ArrayList<SsMediaPeriod> mediaPeriods;
    private TransferListener mediaTransferListener;
    private final boolean sideloadedManifest;
    private final Object tag;

    public final /* bridge */ /* synthetic */ void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        onLoadCanceled((ParsingLoadable<SsManifest>) ((ParsingLoadable) loadable), j, j2, z);
    }

    public final /* bridge */ /* synthetic */ void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        onLoadCompleted((ParsingLoadable<SsManifest>) ((ParsingLoadable) loadable), j, j2);
    }

    public final /* bridge */ /* synthetic */ Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        return onLoadError((ParsingLoadable<SsManifest>) ((ParsingLoadable) loadable), j, j2, iOException, i);
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    public static final class Factory implements MediaSourceFactory {
        private final SsChunkSource.Factory chunkSourceFactory;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManager drmSessionManager;
        private long livePresentationDelayMs;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final DataSource.Factory manifestDataSourceFactory;
        private ParsingLoadable.Parser<? extends SsManifest> manifestParser;
        private List<StreamKey> streamKeys;
        private Object tag;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        public Factory(SsChunkSource.Factory factory, DataSource.Factory factory2) {
            this.chunkSourceFactory = (SsChunkSource.Factory) Assertions.checkNotNull(factory);
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

        public final Factory setLivePresentationDelayMs(long j) {
            this.livePresentationDelayMs = j;
            return this;
        }

        public final Factory setManifestParser(ParsingLoadable.Parser<? extends SsManifest> parser) {
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

        public final Factory setDrmSessionManager(DrmSessionManager drmSessionManager2) {
            if (drmSessionManager2 == null) {
                drmSessionManager2 = DrmSessionManager.CC.getDummyDrmSessionManager();
            }
            this.drmSessionManager = drmSessionManager2;
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

        @Deprecated
        public final SsMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setSourceUri(uri).build());
        }

        public final SsMediaSource createMediaSource(SsManifest ssManifest) {
            Assertions.checkArgument(!ssManifest.isLive);
            if (!this.streamKeys.isEmpty()) {
                ssManifest = ssManifest.copy(this.streamKeys);
            }
            return new SsMediaSource(ssManifest, null, null, null, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, this.tag);
        }

        @Deprecated
        public final SsMediaSource createMediaSource(SsManifest ssManifest, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            SsMediaSource createMediaSource = createMediaSource(ssManifest);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Deprecated
        public final SsMediaSource createMediaSource(Uri uri, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            SsMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        public final SsMediaSource createMediaSource(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.checkNotNull(mediaItem2.playbackProperties);
            ParsingLoadable.Parser parser = this.manifestParser;
            if (parser == null) {
                parser = new SsManifestParser();
            }
            List<StreamKey> list = !mediaItem2.playbackProperties.streamKeys.isEmpty() ? mediaItem2.playbackProperties.streamKeys : this.streamKeys;
            return new SsMediaSource(null, mediaItem2.playbackProperties.sourceUri, this.manifestDataSourceFactory, !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, mediaItem2.playbackProperties.tag != null ? mediaItem2.playbackProperties.tag : this.tag);
        }

        public final int[] getSupportedTypes() {
            return new int[]{1};
        }
    }

    @Deprecated
    public SsMediaSource(SsManifest ssManifest, SsChunkSource.Factory factory, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this(ssManifest, factory, 3, handler, mediaSourceEventListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SsMediaSource(SsManifest ssManifest, SsChunkSource.Factory factory, int i, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this(ssManifest, null, null, null, factory, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.CC.getDummyDrmSessionManager(), new DefaultLoadErrorHandlingPolicy(i), DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, null);
        Handler handler2 = handler;
        MediaSourceEventListener mediaSourceEventListener2 = mediaSourceEventListener;
        if (handler2 != null && mediaSourceEventListener2 != null) {
            addEventListener(handler2, mediaSourceEventListener2);
        }
    }

    @Deprecated
    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, handler, mediaSourceEventListener);
    }

    @Deprecated
    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, int i, long j, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new SsManifestParser(), factory2, i, j, handler, mediaSourceEventListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SsMediaSource(Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, int i, long j, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, new DefaultCompositeSequenceableLoaderFactory(), DrmSessionManager.CC.getDummyDrmSessionManager(), new DefaultLoadErrorHandlingPolicy(i), j, null);
        Handler handler2 = handler;
        MediaSourceEventListener mediaSourceEventListener2 = mediaSourceEventListener;
        if (handler2 != null && mediaSourceEventListener2 != null) {
            addEventListener(handler2, mediaSourceEventListener2);
        }
    }

    private SsMediaSource(SsManifest ssManifest, Uri uri, DataSource.Factory factory, ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, long j, Object obj) {
        Uri uri2;
        boolean z = false;
        Assertions.checkState(ssManifest == null || !ssManifest.isLive);
        this.manifest = ssManifest;
        if (uri == null) {
            uri2 = null;
        } else {
            uri2 = SsUtil.fixManifestUri(uri);
        }
        this.manifestUri = uri2;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.livePresentationDelayMs = j;
        this.manifestEventDispatcher = createEventDispatcher(null);
        this.tag = obj;
        this.sideloadedManifest = ssManifest != null ? true : z;
        this.mediaPeriods = new ArrayList<>();
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.prepare();
        if (this.sideloadedManifest) {
            this.manifestLoaderErrorThrower = new LoaderErrorThrower.Dummy();
            processManifest();
            return;
        }
        this.manifestDataSource = this.manifestDataSourceFactory.createDataSource();
        this.manifestLoader = new Loader("Loader:Manifest");
        this.manifestLoaderErrorThrower = this.manifestLoader;
        this.manifestRefreshHandler = Util.createHandler();
        startLoadingManifest();
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.manifest, this.chunkSourceFactory, this.mediaTransferListener, this.compositeSequenceableLoaderFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this.manifestLoaderErrorThrower, allocator);
        this.mediaPeriods.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ((SsMediaPeriod) mediaPeriod).release();
        this.mediaPeriods.remove(mediaPeriod);
    }

    public final void releaseSourceInternal() {
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestDataSource = null;
        this.manifestLoadStartTimestamp = 0;
        Loader loader = this.manifestLoader;
        if (loader != null) {
            loader.release();
            this.manifestLoader = null;
        }
        Handler handler = this.manifestRefreshHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.manifestRefreshHandler = null;
        }
        this.drmSessionManager.release();
    }

    public final void onLoadCompleted(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        this.manifestEventDispatcher.loadCompleted(parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable2.type, j, j2, parsingLoadable.bytesLoaded());
        this.manifest = parsingLoadable.getResult();
        this.manifestLoadStartTimestamp = j - j2;
        processManifest();
        scheduleManifestRefresh();
    }

    public final void onLoadCanceled(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, boolean z) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        this.manifestEventDispatcher.loadCanceled(parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable2.type, j, j2, parsingLoadable.bytesLoaded());
    }

    public final Loader.LoadErrorAction onLoadError(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(4, j2, iOException, i);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        this.manifestEventDispatcher.loadError(parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable2.type, j, j2, parsingLoadable.bytesLoaded(), iOException, !loadErrorAction.isRetry());
        return loadErrorAction;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    private void processManifest() {
        SinglePeriodTimeline singlePeriodTimeline;
        for (int i = 0; i < this.mediaPeriods.size(); i++) {
            this.mediaPeriods.get(i).updateManifest(this.manifest);
        }
        long j = Long.MIN_VALUE;
        long j2 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.manifest.streamElements) {
            if (streamElement.chunkCount > 0) {
                long min = Math.min(j2, streamElement.getStartTimeUs(0));
                j = Math.max(j, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
                j2 = min;
            }
        }
        if (j2 == Long.MAX_VALUE) {
            singlePeriodTimeline = new SinglePeriodTimeline(this.manifest.isLive ? -9223372036854775807L : 0, 0, 0, 0, true, this.manifest.isLive, this.manifest.isLive, this.manifest, this.tag);
        } else if (this.manifest.isLive) {
            if (this.manifest.dvrWindowLengthUs != -9223372036854775807L && this.manifest.dvrWindowLengthUs > 0) {
                j2 = Math.max(j2, j - this.manifest.dvrWindowLengthUs);
            }
            long j3 = j2;
            long j4 = j - j3;
            long msToUs = j4 - C.msToUs(this.livePresentationDelayMs);
            if (msToUs < 5000000) {
                msToUs = Math.min(5000000L, j4 / 2);
            }
            singlePeriodTimeline = new SinglePeriodTimeline(-9223372036854775807L, j4, j3, msToUs, true, true, true, this.manifest, this.tag);
        } else {
            long j5 = this.manifest.durationUs != -9223372036854775807L ? this.manifest.durationUs : j - j2;
            singlePeriodTimeline = new SinglePeriodTimeline(j2 + j5, j5, j2, 0, true, false, false, this.manifest, this.tag);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private void scheduleManifestRefresh() {
        if (this.manifest.isLive) {
            this.manifestRefreshHandler.postDelayed(new Runnable() {
                /* class com.google.android.exoplayer2.source.smoothstreaming.$$Lambda$SsMediaSource$tFjHmMdOxDkhvkY7QhPdfdPmbtI */

                public final void run() {
                    SsMediaSource.this.startLoadingManifest();
                }
            }, Math.max(0L, (this.manifestLoadStartTimestamp + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void startLoadingManifest() {
        if (!this.manifestLoader.hasFatalError()) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.manifestDataSource, this.manifestUri, 4, this.manifestParser);
            this.manifestEventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.manifestLoader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type)));
        }
    }
}
