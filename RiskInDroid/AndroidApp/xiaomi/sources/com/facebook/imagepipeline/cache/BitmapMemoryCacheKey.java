package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;

public class BitmapMemoryCacheKey implements CacheKey {
    private final long mCacheTime;
    private final Object mCallerContext;
    private final int mHash;
    private final ImageDecodeOptions mImageDecodeOptions;
    private final CacheKey mPostprocessorCacheKey;
    private final String mPostprocessorName;
    private final ResizeOptions mResizeOptions;
    private final RotationOptions mRotationOptions;
    private final String mSourceString;

    public BitmapMemoryCacheKey(String str, ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, CacheKey cacheKey, String str2, Object obj) {
        this.mSourceString = (String) Preconditions.checkNotNull(str);
        this.mResizeOptions = resizeOptions;
        this.mRotationOptions = rotationOptions;
        this.mImageDecodeOptions = imageDecodeOptions;
        this.mPostprocessorCacheKey = cacheKey;
        this.mPostprocessorName = str2;
        this.mHash = HashCodeUtil.hashCode(Integer.valueOf(str.hashCode()), Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0), Integer.valueOf(rotationOptions.hashCode()), this.mImageDecodeOptions, this.mPostprocessorCacheKey, str2);
        this.mCallerContext = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitmapMemoryCacheKey)) {
            return false;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        if (this.mHash != bitmapMemoryCacheKey.mHash || !this.mSourceString.equals(bitmapMemoryCacheKey.mSourceString) || !Objects.equal(this.mResizeOptions, bitmapMemoryCacheKey.mResizeOptions) || !Objects.equal(this.mRotationOptions, bitmapMemoryCacheKey.mRotationOptions) || !Objects.equal(this.mImageDecodeOptions, bitmapMemoryCacheKey.mImageDecodeOptions) || !Objects.equal(this.mPostprocessorCacheKey, bitmapMemoryCacheKey.mPostprocessorCacheKey) || !Objects.equal(this.mPostprocessorName, bitmapMemoryCacheKey.mPostprocessorName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.mHash;
    }

    public boolean containsUri(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    public String getUriString() {
        return this.mSourceString;
    }

    public String getPostprocessorName() {
        return this.mPostprocessorName;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mSourceString, this.mResizeOptions, this.mRotationOptions, this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash));
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public long getInBitmapCacheSince() {
        return this.mCacheTime;
    }
}
