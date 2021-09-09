package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    private long currentSize;
    private final TreeSet<CacheSpan> leastRecentlyUsed = new TreeSet<>($$Lambda$LeastRecentlyUsedCacheEvictor$Tg2zljd4_hGIfz6LdtUQwAPogBo.INSTANCE);
    private final long maxBytes;

    public final void onCacheInitialized() {
    }

    public final boolean requiresCacheSpanTouches() {
        return true;
    }

    public LeastRecentlyUsedCacheEvictor(long j) {
        this.maxBytes = j;
    }

    public final void onStartFile(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            evictCache(cache, j2);
        }
    }

    public final void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        this.currentSize += cacheSpan.length;
        evictCache(cache, 0);
    }

    public final void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        this.currentSize -= cacheSpan.length;
    }

    public final void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    private void evictCache(Cache cache, long j) {
        while (this.currentSize + j > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            try {
                cache.removeSpan(this.leastRecentlyUsed.first());
            } catch (Cache.CacheException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        if (cacheSpan.lastTouchTimestamp - cacheSpan2.lastTouchTimestamp == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return cacheSpan.lastTouchTimestamp < cacheSpan2.lastTouchTimestamp ? -1 : 1;
    }
}
