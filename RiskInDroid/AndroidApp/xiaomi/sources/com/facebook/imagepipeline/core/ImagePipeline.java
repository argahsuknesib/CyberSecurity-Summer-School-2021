package com.facebook.imagepipeline.core;

import _m_j.ko;
import _m_j.kq;
import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;

public class ImagePipeline {
    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private AtomicLong mIdCounter = new AtomicLong();
    private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    private final BufferedDiskCache mMainBufferedDiskCache;
    private final ProducerSequenceFactory mProducerSequenceFactory;
    private final RequestListener mRequestListener;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;
    private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2) {
        this.mProducerSequenceFactory = producerSequenceFactory;
        this.mRequestListener = new ForwardingRequestListener(set);
        this.mIsPrefetchEnabledSupplier = supplier;
        this.mBitmapMemoryCache = memoryCache;
        this.mEncodedMemoryCache = memoryCache2;
        this.mMainBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mSuppressBitmapPrefetchingSupplier = supplier2;
    }

    private String generateUniqueFutureId() {
        return String.valueOf(this.mIdCounter.getAndIncrement());
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object obj, final ImageRequest.RequestLevel requestLevel) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() {
            /* class com.facebook.imagepipeline.core.ImagePipeline.AnonymousClass1 */

            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel);
            }

            public String toString() {
                return Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
            }
        };
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest imageRequest, final Object obj) {
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() {
            /* class com.facebook.imagepipeline.core.ImagePipeline.AnonymousClass2 */

            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, obj);
            }

            public String toString() {
                return Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
            }
        };
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj) {
        Preconditions.checkNotNull(imageRequest.getSourceUri());
        try {
            Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.mProducerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj) {
        Producer<Void> producer;
        if (!this.mIsPrefetchEnabledSupplier.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            if (this.mSuppressBitmapPrefetchingSupplier.get().booleanValue()) {
                producer = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
            } else {
                producer = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
            }
            return submitPrefetchRequest(producer, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM);
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mIsPrefetchEnabledSupplier.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public void evictFromMemoryCache(Uri uri) {
        Predicate<CacheKey> predicateForUri = predicateForUri(uri);
        this.mBitmapMemoryCache.removeAll(predicateForUri);
        this.mEncodedMemoryCache.removeAll(predicateForUri);
    }

    public void evictFromDiskCache(Uri uri) {
        evictFromDiskCache(ImageRequest.fromUri(uri));
    }

    public void evictFromDiskCache(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        this.mMainBufferedDiskCache.remove(encodedCacheKey);
        this.mSmallImageBufferedDiskCache.remove(encodedCacheKey);
    }

    public void evictFromCache(Uri uri) {
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public void clearMemoryCaches() {
        AnonymousClass3 r0 = new Predicate<CacheKey>() {
            /* class com.facebook.imagepipeline.core.ImagePipeline.AnonymousClass3 */

            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        };
        this.mBitmapMemoryCache.removeAll(r0);
        this.mEncodedMemoryCache.removeAll(r0);
    }

    public void clearDiskCaches() {
        this.mMainBufferedDiskCache.clearAll();
        this.mSmallImageBufferedDiskCache.clearAll();
    }

    public void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mBitmapMemoryCache.contains(predicateForUri(uri));
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.mBitmapMemoryCache;
    }

    public boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CloseableReference<CloseableImage> closeableReference = this.mBitmapMemoryCache.get(this.mCacheKeyFactory.getBitmapCacheKey(imageRequest, null));
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public boolean isInDiskCacheSync(Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT);
    }

    public boolean isInDiskCacheSync(Uri uri, ImageRequest.CacheChoice cacheChoice) {
        return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build());
    }

    public boolean isInDiskCacheSync(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        int i = AnonymousClass7.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[imageRequest.getCacheChoice().ordinal()];
        if (i == 1) {
            return this.mMainBufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        if (i != 2) {
            return false;
        }
        return this.mSmallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
    }

    /* renamed from: com.facebook.imagepipeline.core.ImagePipeline$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice = new int[ImageRequest.CacheChoice.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
        }
    }

    public DataSource<Boolean> isInDiskCache(Uri uri) {
        return isInDiskCache(ImageRequest.fromUri(uri));
    }

    public DataSource<Boolean> isInDiskCache(ImageRequest imageRequest) {
        final CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final SimpleDataSource create = SimpleDataSource.create();
        this.mMainBufferedDiskCache.contains(encodedCacheKey).O000000o(new ko<Boolean, kq<Boolean>>() {
            /* class com.facebook.imagepipeline.core.ImagePipeline.AnonymousClass5 */

            public kq<Boolean> then(kq<Boolean> kqVar) throws Exception {
                if (kqVar.O00000o0() || kqVar.O00000o() || !kqVar.O00000oO().booleanValue()) {
                    return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(encodedCacheKey);
                }
                return kq.O000000o(Boolean.TRUE);
            }
        }, kq.O00000Oo).O000000o((ko) new ko<Boolean, Void>() {
            /* class com.facebook.imagepipeline.core.ImagePipeline.AnonymousClass4 */

            public Void then(kq<Boolean> kqVar) throws Exception {
                create.setResult(Boolean.valueOf(!kqVar.O00000o0() && !kqVar.O00000o() && kqVar.O00000oO().booleanValue()));
                return null;
            }
        });
        return create;
    }

    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z;
        RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest);
        try {
            ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
            String generateUniqueFutureId = generateUniqueFutureId();
            if (!imageRequest.getProgressiveRenderingEnabled() && imageRequest.getMediaVariations() == null) {
                if (UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                    z = false;
                    return CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListenerForRequest, obj, max, false, z, imageRequest.getPriority()), requestListenerForRequest);
                }
            }
            z = true;
            return CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListenerForRequest, obj, max, false, z, imageRequest.getPriority()), requestListenerForRequest);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    private DataSource<Void> submitPrefetchRequest(Producer<Void> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest);
        try {
            return ProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), requestListenerForRequest, obj, ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel), true, false, priority), requestListenerForRequest);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    private RequestListener getRequestListenerForRequest(ImageRequest imageRequest) {
        if (imageRequest.getRequestListener() == null) {
            return this.mRequestListener;
        }
        return new ForwardingRequestListener(this.mRequestListener, imageRequest.getRequestListener());
    }

    private Predicate<CacheKey> predicateForUri(final Uri uri) {
        return new Predicate<CacheKey>() {
            /* class com.facebook.imagepipeline.core.ImagePipeline.AnonymousClass6 */

            public boolean apply(CacheKey cacheKey) {
                return cacheKey.containsUri(uri);
            }
        };
    }

    public void pause() {
        this.mThreadHandoffProducerQueue.startQueueing();
    }

    public void resume() {
        this.mThreadHandoffProducerQueue.stopQueuing();
    }

    public boolean isPaused() {
        return this.mThreadHandoffProducerQueue.isQueueing();
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }
}
