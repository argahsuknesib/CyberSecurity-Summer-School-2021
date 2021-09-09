package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build;
import com.facebook.common.internal.Supplier;
import com.google.android.exoplayer2.source.ExtractorMediaSource;

public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    private final ActivityManager mActivityManager;

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        this.mActivityManager = activityManager;
    }

    public MemoryCacheParams get() {
        return new MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private int getMaxCacheSize() {
        int min = Math.min(this.mActivityManager.getMemoryClass() * ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, Integer.MAX_VALUE);
        if (min < 33554432) {
            return 4194304;
        }
        if (min < 67108864) {
            return 6291456;
        }
        if (Build.VERSION.SDK_INT < 11) {
            return 8388608;
        }
        return min / 4;
    }
}
