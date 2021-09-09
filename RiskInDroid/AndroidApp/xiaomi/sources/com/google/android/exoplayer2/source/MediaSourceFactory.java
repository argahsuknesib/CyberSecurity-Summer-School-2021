package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;

public interface MediaSourceFactory {
    @Deprecated
    MediaSource createMediaSource(Uri uri);

    MediaSource createMediaSource(MediaItem mediaItem);

    int[] getSupportedTypes();

    MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager);

    MediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    @Deprecated
    MediaSourceFactory setStreamKeys(List<StreamKey> list);

    /* renamed from: com.google.android.exoplayer2.source.MediaSourceFactory$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated
        public static MediaSourceFactory $default$setStreamKeys(MediaSourceFactory mediaSourceFactory, List list) {
            return mediaSourceFactory;
        }

        @Deprecated
        public static MediaSource $default$createMediaSource(MediaSourceFactory _this, Uri uri) {
            return _this.createMediaSource(MediaItem.fromUri(uri));
        }
    }
}
