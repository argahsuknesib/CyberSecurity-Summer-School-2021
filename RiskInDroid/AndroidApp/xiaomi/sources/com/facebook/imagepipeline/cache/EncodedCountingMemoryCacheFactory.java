package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

public class EncodedCountingMemoryCacheFactory {
    public static CountingMemoryCache<CacheKey, PooledByteBuffer> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, PlatformBitmapFactory platformBitmapFactory) {
        CountingMemoryCache countingMemoryCache = new CountingMemoryCache(new ValueDescriptor<PooledByteBuffer>() {
            /* class com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.AnonymousClass1 */

            public final int getSizeInBytes(PooledByteBuffer pooledByteBuffer) {
                return pooledByteBuffer.size();
            }
        }, new NativeMemoryCacheTrimStrategy(), supplier, platformBitmapFactory, false);
        memoryTrimmableRegistry.registerMemoryTrimmable(countingMemoryCache);
        return countingMemoryCache;
    }
}
