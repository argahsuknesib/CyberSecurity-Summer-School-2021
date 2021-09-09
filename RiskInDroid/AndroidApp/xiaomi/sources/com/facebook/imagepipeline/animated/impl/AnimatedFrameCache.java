package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class AnimatedFrameCache {
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final CountingMemoryCache.EntryStateObserver<CacheKey> mEntryStateObserver = new CountingMemoryCache.EntryStateObserver<CacheKey>() {
        /* class com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.AnonymousClass1 */

        public void onExclusivityChanged(CacheKey cacheKey, boolean z) {
            AnimatedFrameCache.this.onReusabilityChange(cacheKey, z);
        }
    };
    private final LinkedHashSet<CacheKey> mFreeItemsPool = new LinkedHashSet<>();
    private final CacheKey mImageCacheKey;

    @VisibleForTesting
    static class FrameKey implements CacheKey {
        private final int mFrameIndex;
        private final CacheKey mImageCacheKey;

        public String getUriString() {
            return null;
        }

        public FrameKey(CacheKey cacheKey, int i) {
            this.mImageCacheKey = cacheKey;
            this.mFrameIndex = i;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof FrameKey) {
                FrameKey frameKey = (FrameKey) obj;
                return this.mImageCacheKey == frameKey.mImageCacheKey && this.mFrameIndex == frameKey.mFrameIndex;
            }
        }

        public int hashCode() {
            return (this.mImageCacheKey.hashCode() * 1013) + this.mFrameIndex;
        }

        public boolean containsUri(Uri uri) {
            return this.mImageCacheKey.containsUri(uri);
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.mImageCacheKey = cacheKey;
        this.mBackingCache = countingMemoryCache;
    }

    public synchronized void onReusabilityChange(CacheKey cacheKey, boolean z) {
        if (z) {
            this.mFreeItemsPool.add(cacheKey);
        } else {
            this.mFreeItemsPool.remove(cacheKey);
        }
    }

    public CloseableReference<CloseableImage> cache(int i, CloseableReference<CloseableImage> closeableReference) {
        return this.mBackingCache.cache(keyFor(i), closeableReference, this.mEntryStateObserver);
    }

    public CloseableReference<CloseableImage> get(int i) {
        return this.mBackingCache.get(keyFor(i));
    }

    public boolean contains(int i) {
        return this.mBackingCache.contains(keyFor(i));
    }

    public CloseableReference<CloseableImage> getForReuse() {
        CloseableReference<CloseableImage> reuse;
        do {
            CacheKey popFirstFreeItemKey = popFirstFreeItemKey();
            if (popFirstFreeItemKey == null) {
                return null;
            }
            reuse = this.mBackingCache.reuse(popFirstFreeItemKey);
        } while (reuse == null);
        return reuse;
    }

    private synchronized CacheKey popFirstFreeItemKey() {
        CacheKey cacheKey;
        cacheKey = null;
        Iterator<CacheKey> it = this.mFreeItemsPool.iterator();
        if (it.hasNext()) {
            cacheKey = it.next();
            it.remove();
        }
        return cacheKey;
    }

    private FrameKey keyFor(int i) {
        return new FrameKey(this.mImageCacheKey, i);
    }
}
