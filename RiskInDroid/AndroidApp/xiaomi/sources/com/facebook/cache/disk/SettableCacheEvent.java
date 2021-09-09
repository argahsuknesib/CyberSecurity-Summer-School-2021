package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;

public class SettableCacheEvent implements CacheEvent {
    private static final Object RECYCLER_LOCK = new Object();
    private static SettableCacheEvent sFirstRecycledEvent;
    private static int sRecycledCount;
    private CacheKey mCacheKey;
    private long mCacheLimit;
    private long mCacheSize;
    private CacheEventListener.EvictionReason mEvictionReason;
    private IOException mException;
    private long mItemSize;
    private SettableCacheEvent mNextRecycledEvent;
    private String mResourceId;

    @ReturnsOwnership
    public static SettableCacheEvent obtain() {
        synchronized (RECYCLER_LOCK) {
            if (sFirstRecycledEvent == null) {
                return new SettableCacheEvent();
            }
            SettableCacheEvent settableCacheEvent = sFirstRecycledEvent;
            sFirstRecycledEvent = settableCacheEvent.mNextRecycledEvent;
            settableCacheEvent.mNextRecycledEvent = null;
            sRecycledCount--;
            return settableCacheEvent;
        }
    }

    private SettableCacheEvent() {
    }

    public CacheKey getCacheKey() {
        return this.mCacheKey;
    }

    public SettableCacheEvent setCacheKey(CacheKey cacheKey) {
        this.mCacheKey = cacheKey;
        return this;
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public SettableCacheEvent setResourceId(String str) {
        this.mResourceId = str;
        return this;
    }

    public long getItemSize() {
        return this.mItemSize;
    }

    public SettableCacheEvent setItemSize(long j) {
        this.mItemSize = j;
        return this;
    }

    public long getCacheSize() {
        return this.mCacheSize;
    }

    public SettableCacheEvent setCacheSize(long j) {
        this.mCacheSize = j;
        return this;
    }

    public long getCacheLimit() {
        return this.mCacheLimit;
    }

    public SettableCacheEvent setCacheLimit(long j) {
        this.mCacheLimit = j;
        return this;
    }

    public IOException getException() {
        return this.mException;
    }

    public SettableCacheEvent setException(IOException iOException) {
        this.mException = iOException;
        return this;
    }

    public CacheEventListener.EvictionReason getEvictionReason() {
        return this.mEvictionReason;
    }

    public SettableCacheEvent setEvictionReason(CacheEventListener.EvictionReason evictionReason) {
        this.mEvictionReason = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (RECYCLER_LOCK) {
            if (sRecycledCount < 5) {
                reset();
                sRecycledCount++;
                if (sFirstRecycledEvent != null) {
                    this.mNextRecycledEvent = sFirstRecycledEvent;
                }
                sFirstRecycledEvent = this;
            }
        }
    }

    private void reset() {
        this.mCacheKey = null;
        this.mResourceId = null;
        this.mItemSize = 0;
        this.mCacheLimit = 0;
        this.mCacheSize = 0;
        this.mException = null;
        this.mEvictionReason = null;
    }
}
