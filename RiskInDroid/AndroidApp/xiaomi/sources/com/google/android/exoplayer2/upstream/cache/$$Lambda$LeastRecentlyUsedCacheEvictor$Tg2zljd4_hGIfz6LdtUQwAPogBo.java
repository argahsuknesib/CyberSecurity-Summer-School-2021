package com.google.android.exoplayer2.upstream.cache;

import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.upstream.cache.-$$Lambda$LeastRecentlyUsedCacheEvictor$Tg2zljd4_hGIfz6LdtUQwAPogBo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$LeastRecentlyUsedCacheEvictor$Tg2zljd4_hGIfz6LdtUQwAPogBo implements Comparator {
    public static final /* synthetic */ $$Lambda$LeastRecentlyUsedCacheEvictor$Tg2zljd4_hGIfz6LdtUQwAPogBo INSTANCE = new $$Lambda$LeastRecentlyUsedCacheEvictor$Tg2zljd4_hGIfz6LdtUQwAPogBo();

    private /* synthetic */ $$Lambda$LeastRecentlyUsedCacheEvictor$Tg2zljd4_hGIfz6LdtUQwAPogBo() {
    }

    public final int compare(Object obj, Object obj2) {
        return LeastRecentlyUsedCacheEvictor.compare((CacheSpan) obj, (CacheSpan) obj2);
    }
}
