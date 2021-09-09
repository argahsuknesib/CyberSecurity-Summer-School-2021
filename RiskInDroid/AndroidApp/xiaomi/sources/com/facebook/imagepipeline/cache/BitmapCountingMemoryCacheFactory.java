package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapCountingMemoryCacheFactory {
    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, PlatformBitmapFactory platformBitmapFactory, boolean z) {
        return get(supplier, memoryTrimmableRegistry, platformBitmapFactory, z, new BitmapMemoryCacheTrimStrategy());
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, PlatformBitmapFactory platformBitmapFactory, boolean z, CountingMemoryCache.CacheTrimStrategy cacheTrimStrategy) {
        CountingMemoryCache countingMemoryCache = new CountingMemoryCache(new ValueDescriptor<CloseableImage>() {
            /* class com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory.AnonymousClass1 */

            public final int getSizeInBytes(CloseableImage closeableImage) {
                return closeableImage.getSizeInBytes();
            }
        }, cacheTrimStrategy, supplier, platformBitmapFactory, z);
        memoryTrimmableRegistry.registerMemoryTrimmable(countingMemoryCache);
        return countingMemoryCache;
    }
}
