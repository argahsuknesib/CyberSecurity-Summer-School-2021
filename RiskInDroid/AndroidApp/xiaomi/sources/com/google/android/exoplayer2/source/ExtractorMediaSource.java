package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;

@Deprecated
public final class ExtractorMediaSource extends CompositeMediaSource<Void> {
    @Deprecated
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    private final ProgressiveMediaSource progressiveMediaSource;

    @Deprecated
    public interface EventListener {
        void onLoadError(IOException iOException);
    }

    @Deprecated
    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes = ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;
        private ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private Object tag;

        @Deprecated
        public /* synthetic */ MediaSourceFactory setStreamKeys(List<StreamKey> list) {
            return MediaSourceFactory.CC.$default$setStreamKeys(this, list);
        }

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        public final Factory setExtractorsFactory(ExtractorsFactory extractorsFactory2) {
            if (extractorsFactory2 == null) {
                extractorsFactory2 = new DefaultExtractorsFactory();
            }
            this.extractorsFactory = extractorsFactory2;
            return this;
        }

        public final Factory setCustomCacheKey(String str) {
            this.customCacheKey = str;
            return this;
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

        public final Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.continueLoadingCheckIntervalBytes = i;
            return this;
        }

        @Deprecated
        public final Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final ExtractorMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setSourceUri(uri).build());
        }

        public final ExtractorMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.playbackProperties);
            return new ExtractorMediaSource(mediaItem.playbackProperties.sourceUri, this.dataSourceFactory, this.extractorsFactory, this.loadErrorHandlingPolicy, this.customCacheKey, this.continueLoadingCheckIntervalBytes, mediaItem.playbackProperties.tag != null ? mediaItem.playbackProperties.tag : this.tag);
        }

        @Deprecated
        public final ExtractorMediaSource createMediaSource(Uri uri, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            ExtractorMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        public final int[] getSupportedTypes() {
            return new int[]{3};
        }
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener) {
        this(uri, factory, extractorsFactory, handler, eventListener, null);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener, String str) {
        this(uri, factory, extractorsFactory, handler, eventListener, str, (int) DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener, String str, int i) {
        this(uri, factory, extractorsFactory, new DefaultLoadErrorHandlingPolicy(), str, i, (Object) null);
        if (eventListener != null && handler != null) {
            addEventListener(handler, new EventListenerWrapper(eventListener));
        }
    }

    private ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, String str, int i, Object obj) {
        this.progressiveMediaSource = new ProgressiveMediaSource(uri, factory, extractorsFactory, DrmSessionManager.CC.getDummyDrmSessionManager(), loadErrorHandlingPolicy, str, i, obj);
    }

    public final Object getTag() {
        return this.progressiveMediaSource.getTag();
    }

    /* access modifiers changed from: protected */
    public final void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.progressiveMediaSource);
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource, Timeline timeline) {
        refreshSourceInfo(timeline);
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return this.progressiveMediaSource.createPeriod(mediaPeriodId, allocator, j);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        this.progressiveMediaSource.releasePeriod(mediaPeriod);
    }

    @Deprecated
    static final class EventListenerWrapper implements MediaSourceEventListener {
        private final EventListener eventListener;

        public /* synthetic */ void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onDownstreamFormatChanged(this, i, mediaPeriodId, mediaLoadData);
        }

        public /* synthetic */ void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onLoadCanceled(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public /* synthetic */ void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onLoadCompleted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public /* synthetic */ void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onLoadStarted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public /* synthetic */ void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSourceEventListener.CC.$default$onMediaPeriodCreated(this, i, mediaPeriodId);
        }

        public /* synthetic */ void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSourceEventListener.CC.$default$onMediaPeriodReleased(this, i, mediaPeriodId);
        }

        public /* synthetic */ void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSourceEventListener.CC.$default$onReadingStarted(this, i, mediaPeriodId);
        }

        public /* synthetic */ void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            MediaSourceEventListener.CC.$default$onUpstreamDiscarded(this, i, mediaPeriodId, mediaLoadData);
        }

        public EventListenerWrapper(EventListener eventListener2) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener2);
        }

        public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            this.eventListener.onLoadError(iOException);
        }
    }
}
