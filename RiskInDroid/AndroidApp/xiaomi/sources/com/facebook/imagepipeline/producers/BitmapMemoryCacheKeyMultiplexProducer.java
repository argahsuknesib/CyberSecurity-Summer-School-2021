package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;

public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, CloseableReference<CloseableImage>> {
    private final CacheKeyFactory mCacheKeyFactory;

    public /* bridge */ /* synthetic */ Closeable cloneOrNull(Closeable closeable) {
        return cloneOrNull((CloseableReference<CloseableImage>) ((CloseableReference) closeable));
    }

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(producer);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* access modifiers changed from: protected */
    public Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel());
    }

    public CloseableReference<CloseableImage> cloneOrNull(CloseableReference<CloseableImage> closeableReference) {
        return CloseableReference.cloneOrNull(closeableReference);
    }
}
