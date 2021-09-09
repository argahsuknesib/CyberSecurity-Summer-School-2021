package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return "BitmapMemoryCacheProducer";
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        listener.onProducerStart(id, getProducerName());
        CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
        CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(bitmapCacheKey);
        Map map = null;
        if (closeableReference != null) {
            boolean isOfFullQuality = closeableReference.get().getQualityInfo().isOfFullQuality();
            if (isOfFullQuality) {
                listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                listener.onUltimateProducerReached(id, getProducerName(), true);
                consumer.onProgressUpdate(1.0f);
            }
            consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(isOfFullQuality));
            closeableReference.close();
            if (isOfFullQuality) {
                return;
            }
        }
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            listener.onUltimateProducerReached(id, getProducerName(), false);
            consumer.onNewResult(null, 1);
            return;
        }
        Consumer<CloseableReference<CloseableImage>> wrapConsumer = wrapConsumer(consumer, bitmapCacheKey);
        String producerName = getProducerName();
        if (listener.requiresExtraMap(id)) {
            map = ImmutableMap.of("cached_value_found", "false");
        }
        listener.onProducerFinishWithSuccess(id, producerName, map);
        this.mInputProducer.produceResults(wrapConsumer, producerContext);
    }

    /* access modifiers changed from: protected */
    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, final CacheKey cacheKey) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(consumer) {
            /* class com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onNewResultImpl(Object obj, int i) {
                onNewResultImpl((CloseableReference<CloseableImage>) ((CloseableReference) obj), i);
            }

            public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
                CloseableReference<CloseableImage> closeableReference2;
                boolean isLast = isLast(i);
                if (closeableReference == null) {
                    if (isLast) {
                        getConsumer().onNewResult(null, i);
                    }
                } else if (closeableReference.get().isStateful() || statusHasFlag(i, 8)) {
                    getConsumer().onNewResult(closeableReference, i);
                } else {
                    if (!isLast && (closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.get(cacheKey)) != null) {
                        try {
                            QualityInfo qualityInfo = closeableReference.get().getQualityInfo();
                            QualityInfo qualityInfo2 = closeableReference2.get().getQualityInfo();
                            if (qualityInfo2.isOfFullQuality() || qualityInfo2.getQuality() >= qualityInfo.getQuality()) {
                                getConsumer().onNewResult(closeableReference2, i);
                                CloseableReference.closeSafely(closeableReference2);
                                return;
                            }
                        } finally {
                            CloseableReference.closeSafely(closeableReference2);
                        }
                    }
                    CloseableReference<CloseableImage> cache = BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference);
                    if (isLast) {
                        try {
                            getConsumer().onProgressUpdate(1.0f);
                        } catch (Throwable th) {
                            CloseableReference.closeSafely(cache);
                            throw th;
                        }
                    }
                    Consumer consumer = getConsumer();
                    if (cache != null) {
                        closeableReference = cache;
                    }
                    consumer.onNewResult(closeableReference, i);
                    CloseableReference.closeSafely(cache);
                }
            }
        };
    }
}
