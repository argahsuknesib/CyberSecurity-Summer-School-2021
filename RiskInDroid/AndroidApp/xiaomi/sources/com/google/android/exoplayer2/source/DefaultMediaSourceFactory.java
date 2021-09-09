package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private final DataSource.Factory dataSourceFactory;
    private HttpDataSource.Factory drmHttpDataSourceFactory;
    private DrmSessionManager drmSessionManager = DrmSessionManager.CC.getDummyDrmSessionManager();
    private final SparseArray<MediaSourceFactory> mediaSourceFactories;
    private List<StreamKey> streamKeys;
    private final int[] supportedTypes;
    private final String userAgent;

    @Deprecated
    public /* synthetic */ MediaSource createMediaSource(Uri uri) {
        return MediaSourceFactory.CC.$default$createMediaSource(this, uri);
    }

    public static DefaultMediaSourceFactory newInstance(Context context) {
        return newInstance(context, new DefaultDataSourceFactory(context, Util.getUserAgent(context, "ExoPlayerLib/2.11.4")));
    }

    public static DefaultMediaSourceFactory newInstance(Context context, DataSource.Factory factory) {
        return new DefaultMediaSourceFactory(context, factory);
    }

    private DefaultMediaSourceFactory(Context context, DataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.userAgent = Util.getUserAgent(context, "ExoPlayerLib/2.11.4");
        this.drmHttpDataSourceFactory = new DefaultHttpDataSourceFactory(this.userAgent);
        this.mediaSourceFactories = loadDelegates(factory);
        this.supportedTypes = new int[this.mediaSourceFactories.size()];
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.supportedTypes[i] = this.mediaSourceFactories.keyAt(i);
        }
    }

    public final DefaultMediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
        if (factory == null) {
            factory = new DefaultHttpDataSourceFactory(this.userAgent);
        }
        this.drmHttpDataSourceFactory = factory;
        return this;
    }

    public final DefaultMediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager2) {
        if (drmSessionManager2 == null) {
            drmSessionManager2 = DrmSessionManager.CC.getDummyDrmSessionManager();
        }
        this.drmSessionManager = drmSessionManager2;
        return this;
    }

    public final DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (loadErrorHandlingPolicy == null) {
            loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.mediaSourceFactories.valueAt(i).setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
        }
        return this;
    }

    @Deprecated
    public final DefaultMediaSourceFactory setStreamKeys(List<StreamKey> list) {
        if (list == null || list.isEmpty()) {
            list = null;
        }
        this.streamKeys = list;
        return this;
    }

    public final int[] getSupportedTypes() {
        int[] iArr = this.supportedTypes;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final MediaSource createMediaSource(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        int inferContentType = inferContentType(mediaItem.playbackProperties.sourceUri, mediaItem.playbackProperties.mimeType);
        MediaSourceFactory mediaSourceFactory = this.mediaSourceFactories.get(inferContentType);
        Assertions.checkNotNull(mediaSourceFactory, "No suitable media source factory found for content type: ".concat(String.valueOf(inferContentType)));
        mediaSourceFactory.setDrmSessionManager(createDrmSessionManager(mediaItem));
        mediaSourceFactory.setStreamKeys(!mediaItem.playbackProperties.streamKeys.isEmpty() ? mediaItem.playbackProperties.streamKeys : this.streamKeys);
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        List<MediaItem.Subtitle> list = mediaItem.playbackProperties.subtitles;
        if (list.isEmpty()) {
            return maybeClipMediaSource(mediaItem, createMediaSource);
        }
        MediaSource[] mediaSourceArr = new MediaSource[(list.size() + 1)];
        int i = 0;
        mediaSourceArr[0] = createMediaSource;
        SingleSampleMediaSource.Factory factory = new SingleSampleMediaSource.Factory(this.dataSourceFactory);
        while (i < list.size()) {
            MediaItem.Subtitle subtitle = list.get(i);
            i++;
            mediaSourceArr[i] = factory.createMediaSource(subtitle.uri, new Format.Builder().setSampleMimeType(subtitle.mimeType).setLanguage(subtitle.language).setSelectionFlags(subtitle.selectionFlags).build(), -9223372036854775807L);
        }
        return maybeClipMediaSource(mediaItem, new MergingMediaSource(mediaSourceArr));
    }

    private DrmSessionManager createDrmSessionManager(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        return (mediaItem.playbackProperties.drmConfiguration == null || mediaItem.playbackProperties.drmConfiguration.licenseUri == null || Util.SDK_INT < 18) ? this.drmSessionManager : new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(mediaItem.playbackProperties.drmConfiguration.uuid, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(mediaItem.playbackProperties.drmConfiguration.multiSession).setPlayClearSamplesWithoutKeys(mediaItem.playbackProperties.drmConfiguration.playClearContentWithoutKey).setUseDrmSessionsForClearContent(Util.toArray(mediaItem.playbackProperties.drmConfiguration.sessionForClearTypes)).build(createHttpMediaDrmCallback(mediaItem.playbackProperties.drmConfiguration));
    }

    private MediaDrmCallback createHttpMediaDrmCallback(MediaItem.DrmConfiguration drmConfiguration) {
        Assertions.checkNotNull(drmConfiguration.licenseUri);
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(drmConfiguration.licenseUri.toString(), this.drmHttpDataSourceFactory);
        for (Map.Entry next : drmConfiguration.requestHeaders.entrySet()) {
            httpMediaDrmCallback.setKeyRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        return httpMediaDrmCallback;
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        if (mediaItem.clippingProperties.startPositionMs == 0 && mediaItem.clippingProperties.endPositionMs == Long.MIN_VALUE && !mediaItem.clippingProperties.relativeToDefaultPosition) {
            return mediaSource;
        }
        return new ClippingMediaSource(mediaSource, C.msToUs(mediaItem.clippingProperties.startPositionMs), C.msToUs(mediaItem.clippingProperties.endPositionMs), !mediaItem.clippingProperties.startsAtKeyFrame, mediaItem.clippingProperties.relativeToLiveWindow, mediaItem.clippingProperties.relativeToDefaultPosition);
    }

    private static SparseArray<MediaSourceFactory> loadDelegates(DataSource.Factory factory) {
        SparseArray<MediaSourceFactory> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new ProgressiveMediaSource.Factory(factory));
        return sparseArray;
    }

    private static int inferContentType(Uri uri, String str) {
        if (str == null) {
            return Util.inferContentType(uri);
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -979127466) {
            if (hashCode != -156749520) {
                if (hashCode == 64194685 && str.equals("application/dash+xml")) {
                    c = 0;
                }
            } else if (str.equals("application/vnd.ms-sstr+xml")) {
                c = 2;
            }
        } else if (str.equals("application/x-mpegURL")) {
            c = 1;
        }
        if (c == 0) {
            return 0;
        }
        if (c == 1) {
            return 2;
        }
        if (c != 2) {
            return Util.inferContentType(uri);
        }
        return 1;
    }
}
