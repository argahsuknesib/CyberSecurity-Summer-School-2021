package com.facebook.imagepipeline.cache;

import _m_j.kq;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.MediaVariations;

public class NoOpMediaVariationsIndex implements MediaVariationsIndex {
    public void saveCachedVariant(String str, ImageRequest.CacheChoice cacheChoice, CacheKey cacheKey, EncodedImage encodedImage) {
    }

    public kq<MediaVariations> getCachedVariants(String str, MediaVariations.Builder builder) {
        return kq.O000000o((Object) null);
    }
}
