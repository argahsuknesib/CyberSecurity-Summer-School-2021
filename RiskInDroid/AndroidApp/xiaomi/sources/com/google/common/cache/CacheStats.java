package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

@GwtCompatible
public final class CacheStats {
    private final long evictionCount;
    private final long hitCount;
    private final long loadExceptionCount;
    private final long loadSuccessCount;
    private final long missCount;
    private final long totalLoadTime;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j;
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        boolean z = true;
        Preconditions.checkArgument(j7 >= 0);
        Preconditions.checkArgument(j8 >= 0);
        Preconditions.checkArgument(j9 >= 0);
        Preconditions.checkArgument(j10 >= 0);
        Preconditions.checkArgument(j11 >= 0);
        Preconditions.checkArgument(j12 < 0 ? false : z);
        this.hitCount = j7;
        this.missCount = j8;
        this.loadSuccessCount = j9;
        this.loadExceptionCount = j10;
        this.totalLoadTime = j11;
        this.evictionCount = j12;
    }

    public final long requestCount() {
        return this.hitCount + this.missCount;
    }

    public final long hitCount() {
        return this.hitCount;
    }

    public final double hitRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        double d = (double) this.hitCount;
        double d2 = (double) requestCount;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long missCount() {
        return this.missCount;
    }

    public final double missRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 0.0d;
        }
        double d = (double) this.missCount;
        double d2 = (double) requestCount;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long loadCount() {
        return this.loadSuccessCount + this.loadExceptionCount;
    }

    public final long loadSuccessCount() {
        return this.loadSuccessCount;
    }

    public final long loadExceptionCount() {
        return this.loadExceptionCount;
    }

    public final double loadExceptionRate() {
        long j = this.loadSuccessCount;
        long j2 = this.loadExceptionCount;
        long j3 = j + j2;
        if (j3 == 0) {
            return 0.0d;
        }
        double d = (double) j2;
        double d2 = (double) j3;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long totalLoadTime() {
        return this.totalLoadTime;
    }

    public final double averageLoadPenalty() {
        long j = this.loadSuccessCount + this.loadExceptionCount;
        if (j == 0) {
            return 0.0d;
        }
        double d = (double) this.totalLoadTime;
        double d2 = (double) j;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long evictionCount() {
        return this.evictionCount;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final CacheStats minus(CacheStats cacheStats) {
        CacheStats cacheStats2 = cacheStats;
        long max = Math.max(0L, this.hitCount - cacheStats2.hitCount);
        long max2 = Math.max(0L, this.missCount - cacheStats2.missCount);
        long max3 = Math.max(0L, this.loadSuccessCount - cacheStats2.loadSuccessCount);
        return new CacheStats(max, max2, max3, Math.max(0L, this.loadExceptionCount - cacheStats2.loadExceptionCount), Math.max(0L, this.totalLoadTime - cacheStats2.totalLoadTime), Math.max(0L, this.evictionCount - cacheStats2.evictionCount));
    }

    public final CacheStats plus(CacheStats cacheStats) {
        CacheStats cacheStats2 = cacheStats;
        return new CacheStats(this.hitCount + cacheStats2.hitCount, this.missCount + cacheStats2.missCount, this.loadSuccessCount + cacheStats2.loadSuccessCount, this.loadExceptionCount + cacheStats2.loadExceptionCount, this.totalLoadTime + cacheStats2.totalLoadTime, this.evictionCount + cacheStats2.evictionCount);
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.hitCount), Long.valueOf(this.missCount), Long.valueOf(this.loadSuccessCount), Long.valueOf(this.loadExceptionCount), Long.valueOf(this.totalLoadTime), Long.valueOf(this.evictionCount));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CacheStats) {
            CacheStats cacheStats = (CacheStats) obj;
            if (this.hitCount == cacheStats.hitCount && this.missCount == cacheStats.missCount && this.loadSuccessCount == cacheStats.loadSuccessCount && this.loadExceptionCount == cacheStats.loadExceptionCount && this.totalLoadTime == cacheStats.totalLoadTime && this.evictionCount == cacheStats.evictionCount) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("hitCount", this.hitCount).add("missCount", this.missCount).add("loadSuccessCount", this.loadSuccessCount).add("loadExceptionCount", this.loadExceptionCount).add("totalLoadTime", this.totalLoadTime).add("evictionCount", this.evictionCount).toString();
    }
}
