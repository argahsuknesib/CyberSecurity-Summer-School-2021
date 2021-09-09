package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapMemoryCacheFactory {
    public static MemoryCache<CacheKey, CloseableImage> get(CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerBitmapMemoryCache(countingMemoryCache);
        return new InstrumentedMemoryCache(countingMemoryCache, new MemoryCacheTracker<CacheKey>() {
            /* class com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory.AnonymousClass1 */

            public final void onCacheHit(CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCacheHit(cacheKey);
            }

            public final void onCacheMiss() {
                imageCacheStatsTracker.onBitmapCacheMiss();
            }

            public final void onCachePut() {
                imageCacheStatsTracker.onBitmapCachePut();
            }
        });
    }
}
