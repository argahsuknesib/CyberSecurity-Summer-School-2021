package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    private final boolean allowChunklessPreparation;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Uri manifestUri;
    private TransferListener mediaTransferListener;
    private final int metadataType;
    private final HlsPlaylistTracker playlistTracker;
    private final Object tag;
    private final boolean useSessionKeys;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    public static final class Factory implements MediaSourceFactory {
        private boolean allowChunklessPreparation;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManager drmSessionManager;
        private HlsExtractorFactory extractorFactory;
        private final HlsDataSourceFactory hlsDataSourceFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private int metadataType;
        private HlsPlaylistParserFactory playlistParserFactory;
        private HlsPlaylistTracker.Factory playlistTrackerFactory;
        private List<StreamKey> streamKeys;
        private Object tag;
        private boolean useSessionKeys;

        public Factory(DataSource.Factory factory) {
            this(new DefaultHlsDataSourceFactory(factory));
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory2) {
            this.hlsDataSourceFactory = (HlsDataSourceFactory) Assertions.checkNotNull(hlsDataSourceFactory2);
            this.playlistParserFactory = new DefaultHlsPlaylistParserFactory();
            this.playlistTrackerFactory = DefaultHlsPlaylistTracker.FACTORY;
            this.extractorFactory = HlsExtractorFactory.DEFAULT;
            this.drmSessionManager = DrmSessionManager.CC.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
            this.metadataType = 1;
            this.streamKeys = Collections.emptyList();
        }

        @Deprecated
        public final Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public final Factory setExtractorFactory(HlsExtractorFactory hlsExtractorFactory) {
            if (hlsExtractorFactory == null) {
                hlsExtractorFactory = HlsExtractorFactory.DEFAULT;
            }
            this.extractorFactory = hlsExtractorFactory;
            return this;
        }

        public final Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            if (loadErrorHandlingPolicy2 == null) {
                loadErrorHandlingPolicy2 = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            return this;
        }

        @Deprecated
        public final Factory setMinLoadableRetryCount(int i) {
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy(i);
            return this;
        }

        public final Factory setPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            if (hlsPlaylistParserFactory == null) {
                hlsPlaylistParserFactory = new DefaultHlsPlaylistParserFactory();
            }
            this.playlistParserFactory = hlsPlaylistParserFactory;
            return this;
        }

        public final Factory setPlaylistTrackerFactory(HlsPlaylistTracker.Factory factory) {
            if (factory == null) {
                factory = DefaultHlsPlaylistTracker.FACTORY;
            }
            this.playlistTrackerFactory = factory;
            return this;
        }

        public final Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2) {
            if (compositeSequenceableLoaderFactory2 == null) {
                compositeSequenceableLoaderFactory2 = new DefaultCompositeSequenceableLoaderFactory();
            }
            this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
            return this;
        }

        public final Factory setAllowChunklessPreparation(boolean z) {
            this.allowChunklessPreparation = z;
            return this;
        }

        public final Factory setMetadataType(int i) {
            this.metadataType = i;
            return this;
        }

        public final Factory setUseSessionKeys(boolean z) {
            this.useSessionKeys = z;
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
        public final HlsMediaSource createMediaSource(Uri uri, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            HlsMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Deprecated
        public final HlsMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setSourceUri(uri).build());
        }

        public final HlsMediaSource createMediaSource(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.checkNotNull(mediaItem2.playbackProperties);
            HlsPlaylistParserFactory hlsPlaylistParserFactory = this.playlistParserFactory;
            List<StreamKey> list = !mediaItem2.playbackProperties.streamKeys.isEmpty() ? mediaItem2.playbackProperties.streamKeys : this.streamKeys;
            if (!list.isEmpty()) {
                hlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list);
            }
            Uri uri = mediaItem2.playbackProperties.sourceUri;
            HlsDataSourceFactory hlsDataSourceFactory2 = this.hlsDataSourceFactory;
            HlsExtractorFactory hlsExtractorFactory = this.extractorFactory;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2 = this.compositeSequenceableLoaderFactory;
            DrmSessionManager drmSessionManager2 = this.drmSessionManager;
            LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
            return new HlsMediaSource(uri, hlsDataSourceFactory2, hlsExtractorFactory, compositeSequenceableLoaderFactory2, drmSessionManager2, loadErrorHandlingPolicy2, this.playlistTrackerFactory.createTracker(hlsDataSourceFactory2, loadErrorHandlingPolicy2, hlsPlaylistParserFactory), this.allowChunklessPreparation, this.metadataType, this.useSessionKeys, mediaItem2.playbackProperties.tag != null ? mediaItem2.playbackProperties.tag : this.tag);
        }

        public final int[] getSupportedTypes() {
            return new int[]{2};
        }
    }

    private HlsMediaSource(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, HlsPlaylistTracker hlsPlaylistTracker, boolean z, int i, boolean z2, Object obj) {
        this.manifestUri = uri;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.playlistTracker = hlsPlaylistTracker;
        this.allowChunklessPreparation = z;
        this.metadataType = i;
        this.useSessionKeys = z2;
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.prepare();
        this.playlistTracker.start(this.manifestUri, createEventDispatcher(null), this);
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.mediaTransferListener, this.drmSessionManager, this.loadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), allocator, this.compositeSequenceableLoaderFactory, this.allowChunklessPreparation, this.metadataType, this.useSessionKeys);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }

    public final void releaseSourceInternal() {
        this.playlistTracker.stop();
        this.drmSessionManager.release();
    }

    public final void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        SinglePeriodTimeline singlePeriodTimeline;
        long j;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        long usToMs = hlsMediaPlaylist2.hasProgramDateTime ? C.usToMs(hlsMediaPlaylist2.startTimeUs) : -9223372036854775807L;
        long j2 = (hlsMediaPlaylist2.playlistType == 2 || hlsMediaPlaylist2.playlistType == 1) ? usToMs : -9223372036854775807L;
        long j3 = hlsMediaPlaylist2.startOffsetUs;
        HlsManifest hlsManifest = new HlsManifest((HlsMasterPlaylist) Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist()), hlsMediaPlaylist2);
        if (this.playlistTracker.isLive()) {
            long initialStartTimeUs = hlsMediaPlaylist2.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
            long j4 = hlsMediaPlaylist2.hasEndTag ? initialStartTimeUs + hlsMediaPlaylist2.durationUs : -9223372036854775807L;
            List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist2.segments;
            if (j3 != -9223372036854775807L) {
                j = j3;
            } else if (!list.isEmpty()) {
                int max = Math.max(0, list.size() - 3);
                long j5 = hlsMediaPlaylist2.durationUs - (hlsMediaPlaylist2.targetDurationUs * 2);
                while (max > 0 && list.get(max).relativeStartTimeUs > j5) {
                    max--;
                }
                j = list.get(max).relativeStartTimeUs;
            } else {
                j = 0;
            }
            singlePeriodTimeline = new SinglePeriodTimeline(j2, usToMs, -9223372036854775807L, j4, hlsMediaPlaylist2.durationUs, initialStartTimeUs, j, true, !hlsMediaPlaylist2.hasEndTag, true, hlsManifest, this.tag);
        } else {
            singlePeriodTimeline = new SinglePeriodTimeline(j2, usToMs, -9223372036854775807L, hlsMediaPlaylist2.durationUs, hlsMediaPlaylist2.durationUs, 0, j3 == -9223372036854775807L ? 0 : j3, true, false, false, hlsManifest, this.tag);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }
}
