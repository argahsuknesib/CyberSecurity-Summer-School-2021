package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultBitmapPoolParams {
    private static final SparseIntArray DEFAULT_BUCKETS = new SparseIntArray(0);

    private DefaultBitmapPoolParams() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    private static int getMaxSizeHardCap() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min > 16777216) {
            return (min / 4) * 3;
        }
        return min / 2;
    }

    public static PoolParams get() {
        return new PoolParams(0, getMaxSizeHardCap(), DEFAULT_BUCKETS);
    }
}
