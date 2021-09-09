package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;

public final class CacheDataSinkFactory implements DataSink.Factory {
    private final int bufferSize;
    private final Cache cache;
    private final long fragmentSize;

    public CacheDataSinkFactory(Cache cache2, long j) {
        this(cache2, j, 20480);
    }

    public CacheDataSinkFactory(Cache cache2, long j, int i) {
        this.cache = cache2;
        this.fragmentSize = j;
        this.bufferSize = i;
    }

    public final DataSink createDataSink() {
        return new CacheDataSink(this.cache, this.fragmentSize, this.bufferSize);
    }
}
