package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

public class CacheSpan implements Comparable<CacheSpan> {
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastTouchTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(String str, long j, long j2) {
        this(str, j, j2, -9223372036854775807L, null);
    }

    public CacheSpan(String str, long j, long j2, long j3, File file2) {
        this.key = str;
        this.position = j;
        this.length = j2;
        this.isCached = file2 != null;
        this.file = file2;
        this.lastTouchTimestamp = j3;
    }

    public boolean isOpenEnded() {
        return this.length == -1;
    }

    public boolean isHoleSpan() {
        return !this.isCached;
    }

    public int compareTo(CacheSpan cacheSpan) {
        if (!this.key.equals(cacheSpan.key)) {
            return this.key.compareTo(cacheSpan.key);
        }
        long j = this.position - cacheSpan.position;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }
}
