package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;

public class EncodedMemoryCacheFactory {
    public static MemoryCache<CacheKey, PooledByteBuffer> get(CountingMemoryCache<CacheKey, PooledByteBuffer> countingMemoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerEncodedMemoryCache(countingMemoryCache);
        return new InstrumentedMemoryCache(countingMemoryCache, new MemoryCacheTracker<CacheKey>() {
            /* class com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.AnonymousClass1 */

            public final void onCacheHit(CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCacheHit(cacheKey);
            }

            public final void onCacheMiss() {
                imageCacheStatsTracker.onMemoryCacheMiss();
            }

            public final void onCachePut() {
                imageCacheStatsTracker.onMemoryCachePut();
            }
        });
    }
}
