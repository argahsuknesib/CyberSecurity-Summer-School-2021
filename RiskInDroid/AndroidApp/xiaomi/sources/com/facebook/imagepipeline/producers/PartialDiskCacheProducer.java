package com.facebook.imagepipeline.producers;

import _m_j.ko;
import _m_j.kq;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class PartialDiskCacheProducer implements Producer<EncodedImage> {
    private final ByteArrayPool mByteArrayPool;
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public PartialDiskCacheProducer(BufferedDiskCache bufferedDiskCache, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        producerContext.getListener().onProducerStart(producerContext.getId(), "PartialDiskCacheProducer");
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, createUriForPartialCacheKey(imageRequest), producerContext.getCallerContext());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mDefaultBufferedDiskCache.get(encodedCacheKey, atomicBoolean).O000000o((ko) onFinishDiskReads(consumer, producerContext, encodedCacheKey));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }

    private ko<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        final Consumer<EncodedImage> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        final CacheKey cacheKey2 = cacheKey;
        return new ko<EncodedImage, Void>() {
            /* class com.facebook.imagepipeline.producers.PartialDiskCacheProducer.AnonymousClass1 */

            public Void then(kq<EncodedImage> kqVar) throws Exception {
                if (PartialDiskCacheProducer.isTaskCancelled(kqVar)) {
                    listener.onProducerFinishWithCancellation(id, "PartialDiskCacheProducer", null);
                    consumer2.onCancellation();
                } else if (kqVar.O00000o()) {
                    listener.onProducerFinishWithFailure(id, "PartialDiskCacheProducer", kqVar.O00000oo(), null);
                    PartialDiskCacheProducer.this.startInputProducer(consumer2, producerContext2, cacheKey2, null);
                } else {
                    EncodedImage O00000oO = kqVar.O00000oO();
                    if (O00000oO != null) {
                        ProducerListener producerListener = listener;
                        String str = id;
                        producerListener.onProducerFinishWithSuccess(str, "PartialDiskCacheProducer", PartialDiskCacheProducer.getExtraMap(producerListener, str, true, O00000oO.getSize()));
                        BytesRange max = BytesRange.toMax(O00000oO.getSize() - 1);
                        O00000oO.setBytesRange(max);
                        int size = O00000oO.getSize();
                        ImageRequest imageRequest = producerContext2.getImageRequest();
                        if (max.contains(imageRequest.getBytesRange())) {
                            listener.onUltimateProducerReached(id, "PartialDiskCacheProducer", true);
                            consumer2.onNewResult(O00000oO, 9);
                        } else {
                            consumer2.onNewResult(O00000oO, 8);
                            PartialDiskCacheProducer.this.startInputProducer(consumer2, new SettableProducerContext(ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(BytesRange.from(size - 1)).build(), producerContext2), cacheKey2, O00000oO);
                        }
                    } else {
                        ProducerListener producerListener2 = listener;
                        String str2 = id;
                        producerListener2.onProducerFinishWithSuccess(str2, "PartialDiskCacheProducer", PartialDiskCacheProducer.getExtraMap(producerListener2, str2, false, 0));
                        PartialDiskCacheProducer.this.startInputProducer(consumer2, producerContext2, cacheKey2, O00000oO);
                    }
                }
                return null;
            }
        };
    }

    public void startInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey, EncodedImage encodedImage) {
        this.mInputProducer.produceResults(new PartialDiskCacheConsumer(consumer, this.mDefaultBufferedDiskCache, cacheKey, this.mPooledByteBufferFactory, this.mByteArrayPool, encodedImage), producerContext);
    }

    public static boolean isTaskCancelled(kq<?> kqVar) {
        if (!kqVar.O00000o0()) {
            return kqVar.O00000o() && (kqVar.O00000oo() instanceof CancellationException);
        }
        return true;
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
            /* class com.facebook.imagepipeline.producers.PartialDiskCacheProducer.AnonymousClass2 */

            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri createUriForPartialCacheKey(ImageRequest imageRequest) {
        return imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final ByteArrayPool mByteArrayPool;
        private final BufferedDiskCache mDefaultBufferedDiskCache;
        private final EncodedImage mPartialEncodedImageFromCache;
        private final CacheKey mPartialImageCacheKey;
        private final PooledByteBufferFactory mPooledByteBufferFactory;

        private PartialDiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, EncodedImage encodedImage) {
            super(consumer);
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mPartialImageCacheKey = cacheKey;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
            this.mByteArrayPool = byteArrayPool;
            this.mPartialEncodedImageFromCache = encodedImage;
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (!isNotLast(i)) {
                if (this.mPartialEncodedImageFromCache == null || encodedImage.getBytesRange() == null) {
                    if (statusHasFlag(i, 8) && isLast(i)) {
                        this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, encodedImage);
                    }
                    getConsumer().onNewResult(encodedImage, i);
                    return;
                }
                try {
                    sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, encodedImage));
                } catch (IOException e) {
                    FLog.e("PartialDiskCacheProducer", "Error while merging image data", e);
                    getConsumer().onFailure(e);
                } catch (Throwable th) {
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                    throw th;
                }
                encodedImage.close();
                this.mPartialEncodedImageFromCache.close();
                this.mDefaultBufferedDiskCache.remove(this.mPartialImageCacheKey);
            }
        }

        private PooledByteBufferOutputStream merge(EncodedImage encodedImage, EncodedImage encodedImage2) throws IOException {
            PooledByteBufferOutputStream newOutputStream = this.mPooledByteBufferFactory.newOutputStream(encodedImage2.getSize() + encodedImage2.getBytesRange().from);
            copy(encodedImage.getInputStream(), newOutputStream, encodedImage2.getBytesRange().from);
            copy(encodedImage2.getInputStream(), newOutputStream, encodedImage2.getSize());
            return newOutputStream;
        }

        private void copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = (byte[]) this.mByteArrayPool.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i2 -= read;
                    }
                } catch (Throwable th) {
                    this.mByteArrayPool.release(bArr);
                    throw th;
                }
            }
            this.mByteArrayPool.release(bArr);
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void sendFinalResultToConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream) {
            EncodedImage encodedImage;
            Throwable th;
            CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
            try {
                encodedImage = new EncodedImage(of);
                try {
                    encodedImage.parseMetaData();
                    getConsumer().onNewResult(encodedImage, 1);
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                } catch (Throwable th2) {
                    th = th2;
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                encodedImage = null;
                th = th4;
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(of);
                throw th;
            }
        }
    }
}
