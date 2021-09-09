package com.facebook.imagepipeline.producers;

import _m_j.ko;
import _m_j.kq;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MediaVariationsIndex;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.MediaVariations;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaVariationsFallbackProducer implements Producer<EncodedImage> {
    public final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    public final MediaVariationsIndex mMediaVariationsIndex;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public MediaVariationsFallbackProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, MediaVariationsIndex mediaVariationsIndex, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mMediaVariationsIndex = mediaVariationsIndex;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final ResizeOptions resizeOptions = imageRequest.getResizeOptions();
        final MediaVariations mediaVariations = imageRequest.getMediaVariations();
        if (!imageRequest.isDiskCacheEnabled() || resizeOptions == null || resizeOptions.height <= 0 || resizeOptions.width <= 0 || imageRequest.getBytesRange() != null) {
            startInputProducerWithExistingConsumer(consumer, producerContext);
        } else if (mediaVariations == null) {
            startInputProducerWithExistingConsumer(consumer, producerContext);
        } else {
            producerContext.getListener().onProducerStart(producerContext.getId(), "MediaVariationsFallbackProducer");
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            if (mediaVariations.getVariantsCount() > 0) {
                chooseFromVariants(consumer, producerContext, imageRequest, mediaVariations, resizeOptions, atomicBoolean);
            } else {
                final Consumer<EncodedImage> consumer2 = consumer;
                final ProducerContext producerContext2 = producerContext;
                final AtomicBoolean atomicBoolean2 = atomicBoolean;
                this.mMediaVariationsIndex.getCachedVariants(mediaVariations.getMediaId(), MediaVariations.newBuilderForMediaId(mediaVariations.getMediaId()).setForceRequestForSpecifiedUri(mediaVariations.shouldForceRequestForSpecifiedUri()).setSource("index_db")).O000000o((ko) new ko<MediaVariations, Object>() {
                    /* class com.facebook.imagepipeline.producers.MediaVariationsFallbackProducer.AnonymousClass1 */

                    public Object then(kq<MediaVariations> kqVar) throws Exception {
                        if (kqVar.O00000o0() || kqVar.O00000o()) {
                            return kqVar;
                        }
                        try {
                            if (kqVar.O00000oO() != null) {
                                return MediaVariationsFallbackProducer.this.chooseFromVariants(consumer2, producerContext2, imageRequest, kqVar.O00000oO(), resizeOptions, atomicBoolean2);
                            }
                            MediaVariationsFallbackProducer.this.startInputProducerWithWrappedConsumer(consumer2, producerContext2, mediaVariations.getMediaId());
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                });
            }
            subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
        }
    }

    public kq chooseFromVariants(Consumer<EncodedImage> consumer, ProducerContext producerContext, ImageRequest imageRequest, MediaVariations mediaVariations, ResizeOptions resizeOptions, AtomicBoolean atomicBoolean) {
        if (mediaVariations.getVariantsCount() == 0) {
            return kq.O000000o((Object) null).O000000o((ko) onFinishDiskReads(consumer, producerContext, imageRequest, mediaVariations, Collections.emptyList(), 0, atomicBoolean));
        }
        return attemptCacheReadForVariant(consumer, producerContext, imageRequest, mediaVariations, mediaVariations.getSortedVariants(new VariantComparator(resizeOptions)), 0, atomicBoolean);
    }

    public kq attemptCacheReadForVariant(Consumer<EncodedImage> consumer, ProducerContext producerContext, ImageRequest imageRequest, MediaVariations mediaVariations, List<MediaVariations.Variant> list, int i, AtomicBoolean atomicBoolean) {
        ImageRequest.CacheChoice cacheChoice;
        MediaVariations.Variant variant = list.get(i);
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, variant.getUri(), producerContext.getCallerContext());
        if (variant.getCacheChoice() == null) {
            cacheChoice = imageRequest.getCacheChoice();
        } else {
            cacheChoice = variant.getCacheChoice();
        }
        return (cacheChoice == ImageRequest.CacheChoice.SMALL ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache).get(encodedCacheKey, atomicBoolean).O000000o((ko) onFinishDiskReads(consumer, producerContext, imageRequest, mediaVariations, list, i, atomicBoolean));
    }

    public static boolean isBigEnoughForRequestedSize(MediaVariations.Variant variant, ResizeOptions resizeOptions) {
        return variant.getWidth() >= resizeOptions.width && variant.getHeight() >= resizeOptions.height;
    }

    private ko<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext, ImageRequest imageRequest, MediaVariations mediaVariations, List<MediaVariations.Variant> list, int i, AtomicBoolean atomicBoolean) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        final Consumer<EncodedImage> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        final MediaVariations mediaVariations2 = mediaVariations;
        final List<MediaVariations.Variant> list2 = list;
        final int i2 = i;
        final ImageRequest imageRequest2 = imageRequest;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        return new ko<EncodedImage, Void>() {
            /* class com.facebook.imagepipeline.producers.MediaVariationsFallbackProducer.AnonymousClass2 */

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x00f5  */
            public Void then(kq<EncodedImage> kqVar) throws Exception {
                boolean z;
                SettableProducerContext settableProducerContext;
                boolean z2 = true;
                if (MediaVariationsFallbackProducer.isTaskCancelled(kqVar)) {
                    listener.onProducerFinishWithCancellation(id, "MediaVariationsFallbackProducer", null);
                    consumer2.onCancellation();
                } else {
                    if (kqVar.O00000o()) {
                        listener.onProducerFinishWithFailure(id, "MediaVariationsFallbackProducer", kqVar.O00000oo(), null);
                        MediaVariationsFallbackProducer.this.startInputProducerWithWrappedConsumer(consumer2, producerContext2, mediaVariations2.getMediaId());
                    } else {
                        EncodedImage O00000oO = kqVar.O00000oO();
                        if (O00000oO != null) {
                            boolean z3 = !mediaVariations2.shouldForceRequestForSpecifiedUri() && MediaVariationsFallbackProducer.isBigEnoughForRequestedSize((MediaVariations.Variant) list2.get(i2), imageRequest2.getResizeOptions());
                            ProducerListener producerListener = listener;
                            String str = id;
                            producerListener.onProducerFinishWithSuccess(str, "MediaVariationsFallbackProducer", MediaVariationsFallbackProducer.getExtraMap(producerListener, str, true, list2.size(), mediaVariations2.getSource(), z3));
                            if (z3) {
                                listener.onUltimateProducerReached(id, "MediaVariationsFallbackProducer", true);
                                consumer2.onProgressUpdate(1.0f);
                            }
                            int turnOnStatusFlag = BaseConsumer.turnOnStatusFlag(BaseConsumer.simpleStatusForIsLast(z3), 2);
                            if (!z3) {
                                turnOnStatusFlag = BaseConsumer.turnOnStatusFlag(turnOnStatusFlag, 4);
                            }
                            consumer2.onNewResult(O00000oO, turnOnStatusFlag);
                            O00000oO.close();
                            z2 = !z3;
                            z = false;
                            if (z2) {
                                if (!producerContext2.isIntermediateResultExpected() || z) {
                                    settableProducerContext = producerContext2;
                                } else {
                                    SettableProducerContext settableProducerContext2 = new SettableProducerContext(producerContext2);
                                    settableProducerContext2.setIsIntermediateResultExpected(false);
                                    settableProducerContext = settableProducerContext2;
                                }
                                MediaVariationsFallbackProducer.this.startInputProducerWithWrappedConsumer(consumer2, settableProducerContext, mediaVariations2.getMediaId());
                            }
                            return null;
                        } else if (i2 < list2.size() - 1) {
                            MediaVariationsFallbackProducer.this.attemptCacheReadForVariant(consumer2, producerContext2, imageRequest2, mediaVariations2, list2, i2 + 1, atomicBoolean2);
                        } else {
                            ProducerListener producerListener2 = listener;
                            String str2 = id;
                            producerListener2.onProducerFinishWithSuccess(str2, "MediaVariationsFallbackProducer", MediaVariationsFallbackProducer.getExtraMap(producerListener2, str2, false, list2.size(), mediaVariations2.getSource(), false));
                        }
                    }
                    z = true;
                    if (z2) {
                    }
                    return null;
                }
                z = false;
                z2 = false;
                if (z2) {
                }
                return null;
            }
        };
    }

    private void startInputProducerWithExistingConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(consumer, producerContext);
    }

    public void startInputProducerWithWrappedConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, String str) {
        this.mInputProducer.produceResults(new MediaVariationsConsumer(consumer, producerContext, str), producerContext);
    }

    public static boolean isTaskCancelled(kq<?> kqVar) {
        if (!kqVar.O00000o0()) {
            return kqVar.O00000o() && (kqVar.O00000oo() instanceof CancellationException);
        }
        return true;
    }

    @VisibleForTesting
    static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z, int i, String str2, boolean z2) {
        if (!producerListener.requiresExtraMap(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", "true", "cached_value_used_as_last", String.valueOf(z2), "variants_count", String.valueOf(i), "variants_source", str2);
        }
        return ImmutableMap.of("cached_value_found", "false", "variants_count", String.valueOf(i), "variants_source", str2);
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            /* class com.facebook.imagepipeline.producers.MediaVariationsFallbackProducer.AnonymousClass3 */

            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    @VisibleForTesting
    class MediaVariationsConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final String mMediaId;
        private final ProducerContext mProducerContext;

        public MediaVariationsConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, String str) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mMediaId = str;
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (isLast(i) && encodedImage != null && !statusHasFlag(i, 8)) {
                storeResultInDatabase(encodedImage);
            }
            getConsumer().onNewResult(encodedImage, i);
        }

        private void storeResultInDatabase(EncodedImage encodedImage) {
            ImageRequest.CacheChoice cacheChoice;
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            if (imageRequest.isDiskCacheEnabled() && this.mMediaId != null) {
                if (imageRequest.getCacheChoice() == null) {
                    cacheChoice = ImageRequest.CacheChoice.DEFAULT;
                } else {
                    cacheChoice = imageRequest.getCacheChoice();
                }
                MediaVariationsFallbackProducer.this.mMediaVariationsIndex.saveCachedVariant(this.mMediaId, cacheChoice, MediaVariationsFallbackProducer.this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, this.mProducerContext.getCallerContext()), encodedImage);
            }
        }
    }

    @VisibleForTesting
    static class VariantComparator implements Comparator<MediaVariations.Variant> {
        private final ResizeOptions mResizeOptions;

        VariantComparator(ResizeOptions resizeOptions) {
            this.mResizeOptions = resizeOptions;
        }

        public int compare(MediaVariations.Variant variant, MediaVariations.Variant variant2) {
            boolean isBigEnoughForRequestedSize = MediaVariationsFallbackProducer.isBigEnoughForRequestedSize(variant, this.mResizeOptions);
            boolean isBigEnoughForRequestedSize2 = MediaVariationsFallbackProducer.isBigEnoughForRequestedSize(variant2, this.mResizeOptions);
            if (isBigEnoughForRequestedSize && isBigEnoughForRequestedSize2) {
                return variant.getWidth() - variant2.getWidth();
            }
            if (isBigEnoughForRequestedSize) {
                return -1;
            }
            if (isBigEnoughForRequestedSize2) {
                return 1;
            }
            return variant2.getWidth() - variant.getWidth();
        }
    }
}
