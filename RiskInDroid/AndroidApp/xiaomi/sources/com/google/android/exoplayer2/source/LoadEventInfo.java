package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class LoadEventInfo {
    private static final AtomicLong idSource = new AtomicLong();
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final long elapsedRealtimeMs;
    public final long loadDurationMs;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uri;

    public static long getNewId() {
        return idSource.getAndIncrement();
    }

    public LoadEventInfo(DataSpec dataSpec2, Uri uri2, Map<String, List<String>> map, long j, long j2, long j3) {
        this.dataSpec = dataSpec2;
        this.uri = uri2;
        this.responseHeaders = map;
        this.elapsedRealtimeMs = j;
        this.loadDurationMs = j2;
        this.bytesLoaded = j3;
    }
}
