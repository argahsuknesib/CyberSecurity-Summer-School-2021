package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

public class DefaultCacheKeyFactory implements CacheKeyFactory {
    private static DefaultCacheKeyFactory sInstance;

    /* access modifiers changed from: protected */
    public Uri getCacheKeySourceUri(Uri uri) {
        return uri;
    }

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory getInstance() {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        synchronized (DefaultCacheKeyFactory.class) {
            if (sInstance == null) {
                sInstance = new DefaultCacheKeyFactory();
            }
            defaultCacheKeyFactory = sInstance;
        }
        return defaultCacheKeyFactory;
    }

    public CacheKey getBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        return new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), null, null, obj);
    }

    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        String str;
        CacheKey cacheKey;
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor != null) {
            CacheKey postprocessorCacheKey = postprocessor.getPostprocessorCacheKey();
            str = postprocessor.getClass().getName();
            cacheKey = postprocessorCacheKey;
        } else {
            cacheKey = null;
            str = null;
        }
        return new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), cacheKey, str, obj);
    }

    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, Object obj) {
        return getEncodedCacheKey(imageRequest, imageRequest.getSourceUri(), obj);
    }

    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, Object obj) {
        return new SimpleCacheKey(getCacheKeySourceUri(uri).toString());
    }
}
