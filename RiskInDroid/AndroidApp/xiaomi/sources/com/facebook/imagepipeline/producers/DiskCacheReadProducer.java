package com.facebook.imagepipeline.producers;

import _m_j.ko;
import _m_j.kq;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DiskCacheReadProducer implements Producer<EncodedImage> {
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        producerContext.getListener().onProducerStart(producerContext.getId(), "DiskCacheProducer");
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
        BufferedDiskCache bufferedDiskCache = imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCache.get(encodedCacheKey, atomicBoolean).O000000o((ko) onFinishDiskReads(consumer, producerContext));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }

    private ko<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        final Consumer<EncodedImage> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        return new ko<EncodedImage, Void>() {
            /* class com.facebook.imagepipeline.producers.DiskCacheReadProducer.AnonymousClass1 */

            public Void then(kq<EncodedImage> kqVar) throws Exception {
                if (DiskCacheReadProducer.isTaskCancelled(kqVar)) {
                    listener.onProducerFinishWithCancellation(id, "DiskCacheProducer", null);
                    consumer2.onCancellation();
                } else if (kqVar.O00000o()) {
                    listener.onProducerFinishWithFailure(id, "DiskCacheProducer", kqVar.O00000oo(), null);
                    DiskCacheReadProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
                } else {
                    EncodedImage O00000oO = kqVar.O00000oO();
                    if (O00000oO != null) {
                        ProducerListener producerListener = listener;
                        String str = id;
                        producerListener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener, str, true, O00000oO.getSize()));
                        listener.onUltimateProducerReached(id, "DiskCacheProducer", true);
                        consumer2.onProgressUpdate(1.0f);
                        consumer2.onNewResult(O00000oO, 1);
                        O00000oO.close();
                    } else {
                        ProducerListener producerListener2 = listener;
                        String str2 = id;
                        producerListener2.onProducerFinishWithSuccess(str2, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener2, str2, false, 0));
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
                    }
                }
                return null;
            }
        };
    }

    public static boolean isTaskCancelled(kq<?> kqVar) {
        if (!kqVar.O00000o0()) {
            return kqVar.O00000o() && (kqVar.O00000oo() instanceof CancellationException);
        }
        return true;
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }

    @VisibleForTesting
    static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z, int i) {
        if (!producerListener.requiresExtraMap(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            /* class com.facebook.imagepipeline.producers.DiskCacheReadProducer.AnonymousClass2 */

            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }
}
