package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    /* access modifiers changed from: protected */
    public String getProducerName() {
        return "BitmapMemoryCacheGetProducer";
    }

    /* access modifiers changed from: protected */
    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey) {
        return consumer;
    }

    public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        super(memoryCache, cacheKeyFactory, producer);
    }
}
