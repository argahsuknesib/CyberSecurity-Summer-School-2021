package com.facebook.imagepipeline.cache;

public class MemoryCacheParams {
    public final int maxCacheEntries;
    public final int maxCacheEntrySize;
    public final int maxCacheSize;
    public final int maxEvictionQueueEntries;
    public final int maxEvictionQueueSize;

    public MemoryCacheParams(int i, int i2, int i3, int i4, int i5) {
        this.maxCacheSize = i;
        this.maxCacheEntries = i2;
        this.maxEvictionQueueSize = i3;
        this.maxEvictionQueueEntries = i4;
        this.maxCacheEntrySize = i5;
    }
}
