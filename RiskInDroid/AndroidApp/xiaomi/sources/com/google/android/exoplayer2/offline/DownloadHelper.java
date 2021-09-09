package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DownloadHelper {
    private static final Constructor<? extends MediaSourceFactory> DASH_FACTORY_CONSTRUCTOR = getConstructor("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory");
    @Deprecated
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    @Deprecated
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT;
    private static final Constructor<? extends MediaSourceFactory> HLS_FACTORY_CONSTRUCTOR = getConstructor("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory");
    private static final Constructor<? extends MediaSourceFactory> SS_FACTORY_CONSTRUCTOR = getConstructor("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory");
    private final String cacheKey;
    private Callback callback;
    private final Handler callbackHandler;
    private final String downloadType;
    private List<TrackSelection>[][] immutableTrackSelectionsByPeriodAndRenderer;
    private boolean isPreparedWithMedia;
    private MappingTrackSelector.MappedTrackInfo[] mappedTrackInfos;
    private MediaPreparer mediaPreparer;
    private final MediaSource mediaSource;
    private final RendererCapabilities[] rendererCapabilities;
    private final SparseIntArray scratchSet = new SparseIntArray();
    private TrackGroupArray[] trackGroupArrays;
    private List<TrackSelection>[][] trackSelectionsByPeriodAndRenderer;
    private final DefaultTrackSelector trackSelector;
    private final Uri uri;
    private final Timeline.Window window;

    public interface Callback {
        void onPrepareError(DownloadHelper downloadHelper, IOException iOException);

        void onPrepared(DownloadHelper downloadHelper);
    }

    public static class LiveContentUnsupportedException extends IOException {
    }

    static /* synthetic */ void lambda$getRendererCapabilities$0(List list) {
    }

    static /* synthetic */ void lambda$getRendererCapabilities$1(Metadata metadata) {
    }

    static /* synthetic */ void lambda$new$2() {
    }

    static {
        DefaultTrackSelector.Parameters build = DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT.buildUpon().setForceHighestSupportedBitrate(true).build();
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT = build;
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT = build;
    }

    public static DefaultTrackSelector.Parameters getDefaultTrackSelectorParameters(Context context) {
        return DefaultTrackSelector.Parameters.getDefaults(context).buildUpon().setForceHighestSupportedBitrate(true).build();
    }

    public static RendererCapabilities[] getRendererCapabilities(RenderersFactory renderersFactory) {
        Renderer[] createRenderers = renderersFactory.createRenderers(Util.createHandler(), new VideoRendererEventListener() {
            /* class com.google.android.exoplayer2.offline.DownloadHelper.AnonymousClass1 */

            public /* synthetic */ void onDroppedFrames(int i, long j) {
                VideoRendererEventListener.CC.$default$onDroppedFrames(this, i, j);
            }

            public /* synthetic */ void onRenderedFirstFrame(Surface surface) {
                VideoRendererEventListener.CC.$default$onRenderedFirstFrame(this, surface);
            }

            public /* synthetic */ void onVideoDecoderInitialized(String str, long j, long j2) {
                VideoRendererEventListener.CC.$default$onVideoDecoderInitialized(this, str, j, j2);
            }

            public /* synthetic */ void onVideoDisabled(DecoderCounters decoderCounters) {
                VideoRendererEventListener.CC.$default$onVideoDisabled(this, decoderCounters);
            }

            public /* synthetic */ void onVideoEnabled(DecoderCounters decoderCounters) {
                VideoRendererEventListener.CC.$default$onVideoEnabled(this, decoderCounters);
            }

            public /* synthetic */ void onVideoFrameProcessingOffset(long j, int i, Format format) {
                VideoRendererEventListener.CC.$default$onVideoFrameProcessingOffset(this, j, i, format);
            }

            public /* synthetic */ void onVideoInputFormatChanged(Format format) {
                VideoRendererEventListener.CC.$default$onVideoInputFormatChanged(this, format);
            }

            public /* synthetic */ void onVideoSizeChanged(int i, int i2, int i3, float f) {
                VideoRendererEventListener.CC.$default$onVideoSizeChanged(this, i, i2, i3, f);
            }
        }, new AudioRendererEventListener() {
            /* class com.google.android.exoplayer2.offline.DownloadHelper.AnonymousClass2 */

            public /* synthetic */ void onAudioDecoderInitialized(String str, long j, long j2) {
                AudioRendererEventListener.CC.$default$onAudioDecoderInitialized(this, str, j, j2);
            }

            public /* synthetic */ void onAudioDisabled(DecoderCounters decoderCounters) {
                AudioRendererEventListener.CC.$default$onAudioDisabled(this, decoderCounters);
            }

            public /* synthetic */ void onAudioEnabled(DecoderCounters decoderCounters) {
                AudioRendererEventListener.CC.$default$onAudioEnabled(this, decoderCounters);
            }

            public /* synthetic */ void onAudioInputFormatChanged(Format format) {
                AudioRendererEventListener.CC.$default$onAudioInputFormatChanged(this, format);
            }

            public /* synthetic */ void onAudioSessionId(int i) {
                AudioRendererEventListener.CC.$default$onAudioSessionId(this, i);
            }

            public /* synthetic */ void onAudioSinkUnderrun(int i, long j, long j2) {
                AudioRendererEventListener.CC.$default$onAudioSinkUnderrun(this, i, j, j2);
            }

            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                AudioRendererEventListener.CC.$default$onSkipSilenceEnabledChanged(this, z);
            }
        }, $$Lambda$DownloadHelper$0a7x31tLEc1BcMkrUga3HdhUR34.INSTANCE, $$Lambda$DownloadHelper$Fi6a9K6MnBh1_hiLG83D6q10Mk0.INSTANCE);
        RendererCapabilities[] rendererCapabilitiesArr = new RendererCapabilities[createRenderers.length];
        for (int i = 0; i < createRenderers.length; i++) {
            rendererCapabilitiesArr[i] = createRenderers[i].getCapabilities();
        }
        return rendererCapabilitiesArr;
    }

    @Deprecated
    public static DownloadHelper forProgressive(Uri uri2) {
        return forProgressive(uri2, (String) null);
    }

    public static DownloadHelper forProgressive(Context context, Uri uri2) {
        return forProgressive(context, uri2, null);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Uri uri2, String str) {
        return new DownloadHelper("progressive", uri2, str, null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT, new RendererCapabilities[0]);
    }

    public static DownloadHelper forProgressive(Context context, Uri uri2, String str) {
        return new DownloadHelper("progressive", uri2, str, null, getDefaultTrackSelectorParameters(context), new RendererCapabilities[0]);
    }

    @Deprecated
    public static DownloadHelper forDash(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forDash(uri2, factory, renderersFactory, null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT);
    }

    public static DownloadHelper forDash(Context context, Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forDash(uri2, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    public static DownloadHelper forDash(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory, DrmSessionManager drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return new DownloadHelper("dash", uri2, null, createMediaSourceInternal(DASH_FACTORY_CONSTRUCTOR, uri2, factory, drmSessionManager, null), parameters, getRendererCapabilities(renderersFactory));
    }

    @Deprecated
    public static DownloadHelper forHls(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forHls(uri2, factory, renderersFactory, null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT);
    }

    public static DownloadHelper forHls(Context context, Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forHls(uri2, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    public static DownloadHelper forHls(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory, DrmSessionManager drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return new DownloadHelper("hls", uri2, null, createMediaSourceInternal(HLS_FACTORY_CONSTRUCTOR, uri2, factory, drmSessionManager, null), parameters, getRendererCapabilities(renderersFactory));
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri2, factory, renderersFactory, null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT);
    }

    public static DownloadHelper forSmoothStreaming(Context context, Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri2, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    public static DownloadHelper forSmoothStreaming(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory, DrmSessionManager drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return new DownloadHelper("ss", uri2, null, createMediaSourceInternal(SS_FACTORY_CONSTRUCTOR, uri2, factory, drmSessionManager, null), parameters, getRendererCapabilities(renderersFactory));
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory) {
        return createMediaSource(downloadRequest, factory, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory, DrmSessionManager drmSessionManager) {
        char c;
        Constructor<? extends MediaSourceFactory> constructor;
        String str = downloadRequest.type;
        int hashCode = str.hashCode();
        if (hashCode != 3680) {
            if (hashCode != 103407) {
                if (hashCode != 3075986) {
                    if (hashCode == 1131547531 && str.equals("progressive")) {
                        c = 3;
                        if (c == 0) {
                            constructor = DASH_FACTORY_CONSTRUCTOR;
                        } else if (c == 1) {
                            constructor = SS_FACTORY_CONSTRUCTOR;
                        } else if (c == 2) {
                            constructor = HLS_FACTORY_CONSTRUCTOR;
                        } else if (c == 3) {
                            return new ProgressiveMediaSource.Factory(factory).setCustomCacheKey(downloadRequest.customCacheKey).createMediaSource(downloadRequest.uri);
                        } else {
                            throw new IllegalStateException("Unsupported type: " + downloadRequest.type);
                        }
                        return createMediaSourceInternal(constructor, downloadRequest.uri, factory, drmSessionManager, downloadRequest.streamKeys);
                    }
                } else if (str.equals("dash")) {
                    c = 0;
                    if (c == 0) {
                    }
                    return createMediaSourceInternal(constructor, downloadRequest.uri, factory, drmSessionManager, downloadRequest.streamKeys);
                }
            } else if (str.equals("hls")) {
                c = 2;
                if (c == 0) {
                }
                return createMediaSourceInternal(constructor, downloadRequest.uri, factory, drmSessionManager, downloadRequest.streamKeys);
            }
        } else if (str.equals("ss")) {
            c = 1;
            if (c == 0) {
            }
            return createMediaSourceInternal(constructor, downloadRequest.uri, factory, drmSessionManager, downloadRequest.streamKeys);
        }
        c = 65535;
        if (c == 0) {
        }
        return createMediaSourceInternal(constructor, downloadRequest.uri, factory, drmSessionManager, downloadRequest.streamKeys);
    }

    public DownloadHelper(String str, Uri uri2, String str2, MediaSource mediaSource2, DefaultTrackSelector.Parameters parameters, RendererCapabilities[] rendererCapabilitiesArr) {
        this.downloadType = str;
        this.uri = uri2;
        this.cacheKey = str2;
        this.mediaSource = mediaSource2;
        this.trackSelector = new DefaultTrackSelector(parameters, new DownloadTrackSelection.Factory());
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.trackSelector.init($$Lambda$DownloadHelper$6I_pm85TqZWQKmPNxsJxDJYO3Ik.INSTANCE, new DummyBandwidthMeter());
        this.callbackHandler = new Handler(Util.getLooper());
        this.window = new Timeline.Window();
    }

    public final void prepare(Callback callback2) {
        Assertions.checkState(this.callback == null);
        this.callback = callback2;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            this.mediaPreparer = new MediaPreparer(mediaSource2, this);
        } else {
            this.callbackHandler.post(new Runnable(callback2) {
                /* class com.google.android.exoplayer2.offline.$$Lambda$DownloadHelper$RArUVj0AG_uAtPAERIixR2buK8 */
                private final /* synthetic */ DownloadHelper.Callback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DownloadHelper.this.lambda$prepare$3$DownloadHelper(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$prepare$3$DownloadHelper(Callback callback2) {
        callback2.onPrepared(this);
    }

    public final void release() {
        MediaPreparer mediaPreparer2 = this.mediaPreparer;
        if (mediaPreparer2 != null) {
            mediaPreparer2.release();
        }
    }

    public final Object getManifest() {
        if (this.mediaSource == null) {
            return null;
        }
        assertPreparedWithMedia();
        if (this.mediaPreparer.timeline.getWindowCount() > 0) {
            return this.mediaPreparer.timeline.getWindow(0, this.window).manifest;
        }
        return null;
    }

    public final int getPeriodCount() {
        if (this.mediaSource == null) {
            return 0;
        }
        assertPreparedWithMedia();
        return this.trackGroupArrays.length;
    }

    public final TrackGroupArray getTrackGroups(int i) {
        assertPreparedWithMedia();
        return this.trackGroupArrays[i];
    }

    public final MappingTrackSelector.MappedTrackInfo getMappedTrackInfo(int i) {
        assertPreparedWithMedia();
        return this.mappedTrackInfos[i];
    }

    public final List<TrackSelection> getTrackSelections(int i, int i2) {
        assertPreparedWithMedia();
        return this.immutableTrackSelectionsByPeriodAndRenderer[i][i2];
    }

    public final void clearTrackSelections(int i) {
        assertPreparedWithMedia();
        for (int i2 = 0; i2 < this.rendererCapabilities.length; i2++) {
            this.trackSelectionsByPeriodAndRenderer[i][i2].clear();
        }
    }

    public final void replaceTrackSelections(int i, DefaultTrackSelector.Parameters parameters) {
        clearTrackSelections(i);
        addTrackSelection(i, parameters);
    }

    public final void addTrackSelection(int i, DefaultTrackSelector.Parameters parameters) {
        assertPreparedWithMedia();
        this.trackSelector.setParameters(parameters);
        runTrackSelection(i);
    }

    public final void addAudioLanguagesToSelection(String... strArr) {
        assertPreparedWithMedia();
        for (int i = 0; i < this.mappedTrackInfos.length; i++) {
            DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.mappedTrackInfos[i];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                if (mappedTrackInfo.getRendererType(i2) != 1) {
                    buildUpon.setRendererDisabled(i2, true);
                }
            }
            for (String preferredAudioLanguage : strArr) {
                buildUpon.setPreferredAudioLanguage(preferredAudioLanguage);
                addTrackSelection(i, buildUpon.build());
            }
        }
    }

    public final void addTextLanguagesToSelection(boolean z, String... strArr) {
        assertPreparedWithMedia();
        for (int i = 0; i < this.mappedTrackInfos.length; i++) {
            DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.mappedTrackInfos[i];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                if (mappedTrackInfo.getRendererType(i2) != 3) {
                    buildUpon.setRendererDisabled(i2, true);
                }
            }
            buildUpon.setSelectUndeterminedTextLanguage(z);
            for (String preferredTextLanguage : strArr) {
                buildUpon.setPreferredTextLanguage(preferredTextLanguage);
                addTrackSelection(i, buildUpon.build());
            }
        }
    }

    public final void addTrackSelectionForSingleRenderer(int i, int i2, DefaultTrackSelector.Parameters parameters, List<DefaultTrackSelector.SelectionOverride> list) {
        assertPreparedWithMedia();
        DefaultTrackSelector.ParametersBuilder buildUpon = parameters.buildUpon();
        int i3 = 0;
        while (i3 < this.mappedTrackInfos[i].getRendererCount()) {
            buildUpon.setRendererDisabled(i3, i3 != i2);
            i3++;
        }
        if (list.isEmpty()) {
            addTrackSelection(i, buildUpon.build());
            return;
        }
        TrackGroupArray trackGroups = this.mappedTrackInfos[i].getTrackGroups(i2);
        for (int i4 = 0; i4 < list.size(); i4++) {
            buildUpon.setSelectionOverride(i2, trackGroups, list.get(i4));
            addTrackSelection(i, buildUpon.build());
        }
    }

    public final DownloadRequest getDownloadRequest(byte[] bArr) {
        return getDownloadRequest(this.uri.toString(), bArr);
    }

    public final DownloadRequest getDownloadRequest(String str, byte[] bArr) {
        if (this.mediaSource == null) {
            return new DownloadRequest(str, this.downloadType, this.uri, Collections.emptyList(), this.cacheKey, bArr);
        }
        assertPreparedWithMedia();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.trackSelectionsByPeriodAndRenderer.length;
        for (int i = 0; i < length; i++) {
            arrayList2.clear();
            for (List<TrackSelection> addAll : this.trackSelectionsByPeriodAndRenderer[i]) {
                arrayList2.addAll(addAll);
            }
            arrayList.addAll(this.mediaPreparer.mediaPeriods[i].getStreamKeys(arrayList2));
        }
        return new DownloadRequest(str, this.downloadType, this.uri, arrayList, this.cacheKey, bArr);
    }

    public final void onMediaPrepared() {
        Assertions.checkNotNull(this.mediaPreparer);
        Assertions.checkNotNull(this.mediaPreparer.mediaPeriods);
        Assertions.checkNotNull(this.mediaPreparer.timeline);
        int length = this.mediaPreparer.mediaPeriods.length;
        int length2 = this.rendererCapabilities.length;
        this.trackSelectionsByPeriodAndRenderer = (List[][]) Array.newInstance(List.class, length, length2);
        this.immutableTrackSelectionsByPeriodAndRenderer = (List[][]) Array.newInstance(List.class, length, length2);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                this.trackSelectionsByPeriodAndRenderer[i][i2] = new ArrayList();
                this.immutableTrackSelectionsByPeriodAndRenderer[i][i2] = Collections.unmodifiableList(this.trackSelectionsByPeriodAndRenderer[i][i2]);
            }
        }
        this.trackGroupArrays = new TrackGroupArray[length];
        this.mappedTrackInfos = new MappingTrackSelector.MappedTrackInfo[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.trackGroupArrays[i3] = this.mediaPreparer.mediaPeriods[i3].getTrackGroups();
            this.trackSelector.onSelectionActivated(runTrackSelection(i3).info);
            this.mappedTrackInfos[i3] = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(this.trackSelector.getCurrentMappedTrackInfo());
        }
        setPreparedWithMedia();
        ((Handler) Assertions.checkNotNull(this.callbackHandler)).post(new Runnable() {
            /* class com.google.android.exoplayer2.offline.$$Lambda$DownloadHelper$RGzi_SXutZT10i6lkzUQpx4TKk */

            public final void run() {
                DownloadHelper.this.lambda$onMediaPrepared$4$DownloadHelper();
            }
        });
    }

    public /* synthetic */ void lambda$onMediaPrepared$4$DownloadHelper() {
        ((Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    public final void onMediaPreparationFailed(IOException iOException) {
        ((Handler) Assertions.checkNotNull(this.callbackHandler)).post(new Runnable(iOException) {
            /* class com.google.android.exoplayer2.offline.$$Lambda$DownloadHelper$gdC3f15Gyrl0mYA4RrbeCvZ9QAw */
            private final /* synthetic */ IOException f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DownloadHelper.this.lambda$onMediaPreparationFailed$5$DownloadHelper(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onMediaPreparationFailed$5$DownloadHelper(IOException iOException) {
        ((Callback) Assertions.checkNotNull(this.callback)).onPrepareError(this, iOException);
    }

    private void setPreparedWithMedia() {
        this.isPreparedWithMedia = true;
    }

    private void assertPreparedWithMedia() {
        Assertions.checkState(this.isPreparedWithMedia);
    }

    private TrackSelectorResult runTrackSelection(int i) {
        boolean z;
        try {
            TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroupArrays[i], new MediaSource.MediaPeriodId(this.mediaPreparer.timeline.getUidOfPeriod(i)), this.mediaPreparer.timeline);
            for (int i2 = 0; i2 < selectTracks.length; i2++) {
                TrackSelection trackSelection = selectTracks.selections.get(i2);
                if (trackSelection != null) {
                    List<TrackSelection> list = this.trackSelectionsByPeriodAndRenderer[i][i2];
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list.size()) {
                            z = false;
                            break;
                        }
                        TrackSelection trackSelection2 = list.get(i3);
                        if (trackSelection2.getTrackGroup() == trackSelection.getTrackGroup()) {
                            this.scratchSet.clear();
                            for (int i4 = 0; i4 < trackSelection2.length(); i4++) {
                                this.scratchSet.put(trackSelection2.getIndexInTrackGroup(i4), 0);
                            }
                            for (int i5 = 0; i5 < trackSelection.length(); i5++) {
                                this.scratchSet.put(trackSelection.getIndexInTrackGroup(i5), 0);
                            }
                            int[] iArr = new int[this.scratchSet.size()];
                            for (int i6 = 0; i6 < this.scratchSet.size(); i6++) {
                                iArr[i6] = this.scratchSet.keyAt(i6);
                            }
                            list.set(i3, new DownloadTrackSelection(trackSelection2.getTrackGroup(), iArr));
                            z = true;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        list.add(trackSelection);
                    }
                }
            }
            return selectTracks;
        } catch (ExoPlaybackException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    private static Constructor<? extends MediaSourceFactory> getConstructor(String str) {
        try {
            return Class.forName(str).asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    private static MediaSource createMediaSourceInternal(Constructor<? extends MediaSourceFactory> constructor, Uri uri2, DataSource.Factory factory, DrmSessionManager drmSessionManager, List<StreamKey> list) {
        if (constructor != null) {
            try {
                MediaSourceFactory mediaSourceFactory = (MediaSourceFactory) constructor.newInstance(factory);
                if (drmSessionManager != null) {
                    mediaSourceFactory.setDrmSessionManager(drmSessionManager);
                }
                if (list != null) {
                    mediaSourceFactory.setStreamKeys(list);
                }
                return (MediaSource) Assertions.checkNotNull(mediaSourceFactory.createMediaSource(uri2));
            } catch (Exception e) {
                throw new IllegalStateException("Failed to instantiate media source.", e);
            }
        } else {
            throw new IllegalStateException("Module missing to create media source.");
        }
    }

    static final class MediaPreparer implements Handler.Callback, MediaPeriod.Callback, MediaSource.MediaSourceCaller {
        private final Allocator allocator = new DefaultAllocator(true, 65536);
        private final DownloadHelper downloadHelper;
        private final Handler downloadHelperHandler = Util.createHandler(new Handler.Callback() {
            /* class com.google.android.exoplayer2.offline.$$Lambda$DownloadHelper$MediaPreparer$gRg5OjhQDuNd7U0rx8tYCna7cs */

            public final boolean handleMessage(Message message) {
                return DownloadHelper.MediaPreparer.this.handleDownloadHelperCallbackMessage(message);
            }
        });
        public MediaPeriod[] mediaPeriods;
        private final MediaSource mediaSource;
        private final Handler mediaSourceHandler;
        private final HandlerThread mediaSourceThread = new HandlerThread("ExoPlayer:DownloadHelper");
        private final ArrayList<MediaPeriod> pendingMediaPeriods = new ArrayList<>();
        private boolean released;
        public Timeline timeline;

        public MediaPreparer(MediaSource mediaSource2, DownloadHelper downloadHelper2) {
            this.mediaSource = mediaSource2;
            this.downloadHelper = downloadHelper2;
            this.mediaSourceThread.start();
            this.mediaSourceHandler = Util.createHandler(this.mediaSourceThread.getLooper(), this);
            this.mediaSourceHandler.sendEmptyMessage(0);
        }

        public final void release() {
            if (!this.released) {
                this.released = true;
                this.mediaSourceHandler.sendEmptyMessage(3);
            }
        }

        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                int i2 = 0;
                if (i == 1) {
                    try {
                        if (this.mediaPeriods == null) {
                            this.mediaSource.maybeThrowSourceInfoRefreshError();
                        } else {
                            while (i2 < this.pendingMediaPeriods.size()) {
                                this.pendingMediaPeriods.get(i2).maybeThrowPrepareError();
                                i2++;
                            }
                        }
                        this.mediaSourceHandler.sendEmptyMessageDelayed(1, 100);
                    } catch (IOException e) {
                        this.downloadHelperHandler.obtainMessage(1, e).sendToTarget();
                    }
                    return true;
                } else if (i == 2) {
                    MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                    if (this.pendingMediaPeriods.contains(mediaPeriod)) {
                        mediaPeriod.continueLoading(0);
                    }
                    return true;
                } else if (i != 3) {
                    return false;
                } else {
                    MediaPeriod[] mediaPeriodArr = this.mediaPeriods;
                    if (mediaPeriodArr != null) {
                        int length = mediaPeriodArr.length;
                        while (i2 < length) {
                            this.mediaSource.releasePeriod(mediaPeriodArr[i2]);
                            i2++;
                        }
                    }
                    this.mediaSource.releaseSource(this);
                    this.mediaSourceHandler.removeCallbacksAndMessages(null);
                    this.mediaSourceThread.quit();
                    return true;
                }
            } else {
                this.mediaSource.prepareSource(this, null);
                this.mediaSourceHandler.sendEmptyMessage(1);
                return true;
            }
        }

        public final void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline2) {
            MediaPeriod[] mediaPeriodArr;
            if (this.timeline == null) {
                if (timeline2.getWindow(0, new Timeline.Window()).isLive) {
                    this.downloadHelperHandler.obtainMessage(1, new LiveContentUnsupportedException()).sendToTarget();
                    return;
                }
                this.timeline = timeline2;
                this.mediaPeriods = new MediaPeriod[timeline2.getPeriodCount()];
                int i = 0;
                while (true) {
                    mediaPeriodArr = this.mediaPeriods;
                    if (i >= mediaPeriodArr.length) {
                        break;
                    }
                    MediaPeriod createPeriod = this.mediaSource.createPeriod(new MediaSource.MediaPeriodId(timeline2.getUidOfPeriod(i)), this.allocator, 0);
                    this.mediaPeriods[i] = createPeriod;
                    this.pendingMediaPeriods.add(createPeriod);
                    i++;
                }
                for (MediaPeriod prepare : mediaPeriodArr) {
                    prepare.prepare(this, 0);
                }
            }
        }

        public final void onPrepared(MediaPeriod mediaPeriod) {
            this.pendingMediaPeriods.remove(mediaPeriod);
            if (this.pendingMediaPeriods.isEmpty()) {
                this.mediaSourceHandler.removeMessages(1);
                this.downloadHelperHandler.sendEmptyMessage(0);
            }
        }

        public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            if (this.pendingMediaPeriods.contains(mediaPeriod)) {
                this.mediaSourceHandler.obtainMessage(2, mediaPeriod).sendToTarget();
            }
        }

        /* access modifiers changed from: private */
        public boolean handleDownloadHelperCallbackMessage(Message message) {
            if (this.released) {
                return false;
            }
            int i = message.what;
            if (i == 0) {
                this.downloadHelper.onMediaPrepared();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                release();
                this.downloadHelper.onMediaPreparationFailed((IOException) Util.castNonNull(message.obj));
                return true;
            }
        }
    }

    static final class DownloadTrackSelection extends BaseTrackSelection {
        public final int getSelectedIndex() {
            return 0;
        }

        public final Object getSelectionData() {
            return null;
        }

        public final int getSelectionReason() {
            return 0;
        }

        public final void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        }

        static final class Factory implements TrackSelection.Factory {
            private Factory() {
            }

            public final TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter) {
                TrackSelection[] trackSelectionArr = new TrackSelection[definitionArr.length];
                for (int i = 0; i < definitionArr.length; i++) {
                    trackSelectionArr[i] = definitionArr[i] == null ? null : new DownloadTrackSelection(definitionArr[i].group, definitionArr[i].tracks);
                }
                return trackSelectionArr;
            }
        }

        public DownloadTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }
    }

    static final class DummyBandwidthMeter implements BandwidthMeter {
        public final void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        }

        public final long getBitrateEstimate() {
            return 0;
        }

        public final TransferListener getTransferListener() {
            return null;
        }

        public final void removeEventListener(BandwidthMeter.EventListener eventListener) {
        }

        private DummyBandwidthMeter() {
        }
    }
}
