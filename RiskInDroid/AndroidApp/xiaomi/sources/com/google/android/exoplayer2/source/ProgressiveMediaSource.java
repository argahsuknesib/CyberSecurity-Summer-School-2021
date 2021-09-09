package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    private final int continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource.Factory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final ExtractorsFactory extractorsFactory;
    private final LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private final Object tag;
    private long timelineDurationUs = -9223372036854775807L;
    private boolean timelineIsLive;
    private boolean timelineIsPlaceholder = true;
    private boolean timelineIsSeekable;
    private TransferListener transferListener;
    private final Uri uri;

    public final void maybeThrowSourceInfoRefreshError() {
    }

    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes;
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;
        private DrmSessionManager drmSessionManager;
        private ExtractorsFactory extractorsFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private Object tag;

        @Deprecated
        public /* synthetic */ MediaSourceFactory setStreamKeys(List<StreamKey> list) {
            return MediaSourceFactory.CC.$default$setStreamKeys(this, list);
        }

        public Factory(DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory2) {
            this.dataSourceFactory = factory;
            this.extractorsFactory = extractorsFactory2;
            this.drmSessionManager = DrmSessionManager.CC.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.continueLoadingCheckIntervalBytes = ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
        }

        @Deprecated
        public final Factory setExtractorsFactory(ExtractorsFactory extractorsFactory2) {
            if (extractorsFactory2 == null) {
                extractorsFactory2 = new DefaultExtractorsFactory();
            }
            this.extractorsFactory = extractorsFactory2;
            return this;
        }

        @Deprecated
        public final Factory setCustomCacheKey(String str) {
            this.customCacheKey = str;
            return this;
        }

        @Deprecated
        public final Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public final Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            if (loadErrorHandlingPolicy2 == null) {
                loadErrorHandlingPolicy2 = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            return this;
        }

        public final Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.continueLoadingCheckIntervalBytes = i;
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
        public final ProgressiveMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setSourceUri(uri).build());
        }

        public final ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.playbackProperties);
            return new ProgressiveMediaSource(mediaItem.playbackProperties.sourceUri, this.dataSourceFactory, this.extractorsFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, mediaItem.playbackProperties.customCacheKey != null ? mediaItem.playbackProperties.customCacheKey : this.customCacheKey, this.continueLoadingCheckIntervalBytes, mediaItem.playbackProperties.tag != null ? mediaItem.playbackProperties.tag : this.tag);
        }

        public final int[] getSupportedTypes() {
            return new int[]{3};
        }
    }

    ProgressiveMediaSource(Uri uri2, DataSource.Factory factory, ExtractorsFactory extractorsFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, String str, int i, Object obj) {
        this.uri = uri2;
        this.dataSourceFactory = factory;
        this.extractorsFactory = extractorsFactory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadableLoadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i;
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    /* access modifiers changed from: protected */
    public final void prepareSourceInternal(TransferListener transferListener2) {
        this.transferListener = transferListener2;
        this.drmSessionManager.prepare();
        notifySourceInfoRefreshed();
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        DataSource createDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener2 = this.transferListener;
        if (transferListener2 != null) {
            createDataSource.addTransferListener(transferListener2);
        }
        return new ProgressiveMediaPeriod(this.uri, createDataSource, this.extractorsFactory.createExtractors(), this.drmSessionManager, this.loadableLoadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this, allocator, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).release();
    }

    /* access modifiers changed from: protected */
    public final void releaseSourceInternal() {
        this.drmSessionManager.release();
    }

    public final void onSourceInfoRefreshed(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.timelineDurationUs;
        }
        if (this.timelineIsPlaceholder || this.timelineDurationUs != j || this.timelineIsSeekable != z || this.timelineIsLive != z2) {
            this.timelineDurationUs = j;
            this.timelineIsSeekable = z;
            this.timelineIsLive = z2;
            this.timelineIsPlaceholder = false;
            notifySourceInfoRefreshed();
        }
    }

    private void notifySourceInfoRefreshed() {
        SinglePeriodTimeline singlePeriodTimeline = new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.timelineIsLive, null, this.tag);
        refreshSourceInfo(this.timelineIsPlaceholder ? new ForwardingTimeline(singlePeriodTimeline) {
            /* class com.google.android.exoplayer2.source.ProgressiveMediaSource.AnonymousClass1 */

            public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
                super.getWindow(i, window, j);
                window.isPlaceholder = true;
                return window;
            }
        } : singlePeriodTimeline);
    }
}
