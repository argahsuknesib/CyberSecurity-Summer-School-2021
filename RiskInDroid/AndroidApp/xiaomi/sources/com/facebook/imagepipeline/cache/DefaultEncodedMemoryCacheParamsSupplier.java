package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.google.android.exoplayer2.source.ExtractorMediaSource;

public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public MemoryCacheParams get() {
        int maxCacheSize = getMaxCacheSize();
        return new MemoryCacheParams(maxCacheSize, Integer.MAX_VALUE, maxCacheSize, Integer.MAX_VALUE, maxCacheSize / 8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    private int getMaxCacheSize() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
        }
        return min < 33554432 ? 2097152 : 4194304;
    }
}
