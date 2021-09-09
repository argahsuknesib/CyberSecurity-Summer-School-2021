package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import java.util.Map;

public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        ImageRequest imageRequest = producerContext.getImageRequest();
        Object callerContext = producerContext.getCallerContext();
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor == null || postprocessor.getPostprocessorCacheKey() == null) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        listener.onProducerStart(id, getProducerName());
        CacheKey postprocessedBitmapCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
        CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(postprocessedBitmapCacheKey);
        Map map = null;
        if (closeableReference != null) {
            String producerName = getProducerName();
            if (listener.requiresExtraMap(id)) {
                map = ImmutableMap.of("cached_value_found", "true");
            }
            listener.onProducerFinishWithSuccess(id, producerName, map);
            listener.onUltimateProducerReached(id, "PostprocessedBitmapMemoryCacheProducer", true);
            consumer.onProgressUpdate(1.0f);
            consumer.onNewResult(closeableReference, 1);
            closeableReference.close();
            return;
        }
        CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, postprocessedBitmapCacheKey, postprocessor instanceof RepeatedPostprocessor, this.mMemoryCache);
        String producerName2 = getProducerName();
        if (listener.requiresExtraMap(id)) {
            map = ImmutableMap.of("cached_value_found", "false");
        }
        listener.onProducerFinishWithSuccess(id, producerName2, map);
        this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
    }

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final CacheKey mCacheKey;
        private final boolean mIsRepeatedProcessor;
        private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object obj, int i) {
            onNewResultImpl((CloseableReference<CloseableImage>) ((CloseableReference) obj), i);
        }

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache) {
            super(consumer);
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mMemoryCache = memoryCache;
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (closeableReference == null) {
                if (isLast(i)) {
                    getConsumer().onNewResult(null, i);
                }
            } else if (!isNotLast(i) || this.mIsRepeatedProcessor) {
                CloseableReference<CloseableImage> cache = this.mMemoryCache.cache(this.mCacheKey, closeableReference);
                try {
                    getConsumer().onProgressUpdate(1.0f);
                    Consumer consumer = getConsumer();
                    if (cache != null) {
                        closeableReference = cache;
                    }
                    consumer.onNewResult(closeableReference, i);
                } finally {
                    CloseableReference.closeSafely(cache);
                }
            }
        }
    }
}
