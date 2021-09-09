package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

public interface CacheKeyFactory {
    CacheKey getBitmapCacheKey(ImageRequest imageRequest, Object obj);

    CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, Object obj);

    CacheKey getEncodedCacheKey(ImageRequest imageRequest, Object obj);

    CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, Object obj);
}
