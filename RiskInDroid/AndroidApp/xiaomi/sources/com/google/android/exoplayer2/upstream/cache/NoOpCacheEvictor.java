package com.google.android.exoplayer2.upstream.cache;

public final class NoOpCacheEvictor implements CacheEvictor {
    public final void onCacheInitialized() {
    }

    public final void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
    }

    public final void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
    }

    public final void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public final void onStartFile(Cache cache, String str, long j, long j2) {
    }

    public final boolean requiresCacheSpanTouches() {
        return false;
    }
}
