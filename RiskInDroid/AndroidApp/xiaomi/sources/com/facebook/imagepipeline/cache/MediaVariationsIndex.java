package com.facebook.imagepipeline.cache;

import _m_j.kq;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.MediaVariations;

public interface MediaVariationsIndex {
    kq<MediaVariations> getCachedVariants(String str, MediaVariations.Builder builder);

    void saveCachedVariant(String str, ImageRequest.CacheChoice cacheChoice, CacheKey cacheKey, EncodedImage encodedImage);
}
