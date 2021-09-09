package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class NetworkFetchProducer implements Producer<EncodedImage> {
    private final ByteArrayPool mByteArrayPool;
    private final NetworkFetcher mNetworkFetcher;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        producerContext.getListener().onProducerStart(producerContext.getId(), "NetworkFetchProducer");
        final FetchState createFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
        this.mNetworkFetcher.fetch(createFetchState, new NetworkFetcher.Callback() {
            /* class com.facebook.imagepipeline.producers.NetworkFetchProducer.AnonymousClass1 */

            public void onResponse(InputStream inputStream, int i) throws IOException {
                NetworkFetchProducer.this.onResponse(createFetchState, inputStream, i);
            }

            public void onFailure(Throwable th) {
                NetworkFetchProducer.this.onFailure(createFetchState, th);
            }

            public void onCancellation() {
                NetworkFetchProducer.this.onCancellation(createFetchState);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResponse(FetchState fetchState, InputStream inputStream, int i) throws IOException {
        PooledByteBufferOutputStream pooledByteBufferOutputStream;
        if (i > 0) {
            pooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(i);
        } else {
            pooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream();
        }
        byte[] bArr = (byte[]) this.mByteArrayPool.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    this.mNetworkFetcher.onFetchCompletion(fetchState, pooledByteBufferOutputStream.size());
                    handleFinalResult(pooledByteBufferOutputStream, fetchState);
                    return;
                } else if (read > 0) {
                    pooledByteBufferOutputStream.write(bArr, 0, read);
                    maybeHandleIntermediateResult(pooledByteBufferOutputStream, fetchState);
                    fetchState.getConsumer().onProgressUpdate(calculateProgress(pooledByteBufferOutputStream.size(), i));
                }
            } finally {
                this.mByteArrayPool.release(bArr);
                pooledByteBufferOutputStream.close();
            }
        }
    }

    protected static float calculateProgress(int i, int i2) {
        if (i2 > 0) {
            return ((float) i) / ((float) i2);
        }
        double d = (double) (-i);
        Double.isNaN(d);
        return 1.0f - ((float) Math.exp(d / 50000.0d));
    }

    /* access modifiers changed from: protected */
    public void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (shouldPropagateIntermediateResults(fetchState) && uptimeMillis - fetchState.getLastIntermediateResultTimeMs() >= 100) {
            fetchState.setLastIntermediateResultTimeMs(uptimeMillis);
            fetchState.getListener().onProducerEvent(fetchState.getId(), "NetworkFetchProducer", "intermediate_result");
            notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer());
        }
    }

    /* access modifiers changed from: protected */
    public void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Map<String, String> extraMap = getExtraMap(fetchState, pooledByteBufferOutputStream.size());
        ProducerListener listener = fetchState.getListener();
        listener.onProducerFinishWithSuccess(fetchState.getId(), "NetworkFetchProducer", extraMap);
        listener.onUltimateProducerReached(fetchState.getId(), "NetworkFetchProducer", true);
        notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer());
    }

    private void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, BytesRange bytesRange, Consumer<EncodedImage> consumer) {
        EncodedImage encodedImage;
        CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
        try {
            encodedImage = new EncodedImage(of);
            try {
                encodedImage.setBytesRange(bytesRange);
                encodedImage.parseMetaData();
                consumer.onNewResult(encodedImage, i);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(of);
            } catch (Throwable th) {
                th = th;
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(of);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            encodedImage = null;
            EncodedImage.closeSafely(encodedImage);
            CloseableReference.closeSafely(of);
            throw th;
        }
    }

    public void onFailure(FetchState fetchState, Throwable th) {
        fetchState.getListener().onProducerFinishWithFailure(fetchState.getId(), "NetworkFetchProducer", th, null);
        fetchState.getListener().onUltimateProducerReached(fetchState.getId(), "NetworkFetchProducer", false);
        fetchState.getConsumer().onFailure(th);
    }

    public void onCancellation(FetchState fetchState) {
        fetchState.getListener().onProducerFinishWithCancellation(fetchState.getId(), "NetworkFetchProducer", null);
        fetchState.getConsumer().onCancellation();
    }

    private boolean shouldPropagateIntermediateResults(FetchState fetchState) {
        if (!fetchState.getContext().isIntermediateResultExpected()) {
            return false;
        }
        return this.mNetworkFetcher.shouldPropagate(fetchState);
    }

    private Map<String, String> getExtraMap(FetchState fetchState, int i) {
        if (!fetchState.getListener().requiresExtraMap(fetchState.getId())) {
            return null;
        }
        return this.mNetworkFetcher.getExtraMap(fetchState, i);
    }
}
