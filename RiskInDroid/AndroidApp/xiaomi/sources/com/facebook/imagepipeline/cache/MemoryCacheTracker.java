package com.facebook.imagepipeline.cache;

public interface MemoryCacheTracker<K> {
    void onCacheHit(Object obj);

    void onCacheMiss();

    void onCachePut();
}
