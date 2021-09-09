package _m_j;

import android.app.ActivityManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.google.android.exoplayer2.source.ExtractorMediaSource;

public final class cbo implements Supplier<MemoryCacheParams> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ActivityManager f13600O000000o;

    public cbo(ActivityManager activityManager) {
        this.f13600O000000o = activityManager;
    }

    private int O000000o() {
        int min = Math.min(this.f13600O000000o.getMemoryClass() * ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, Integer.MAX_VALUE);
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

    public final /* synthetic */ Object get() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new MemoryCacheParams(O000000o(), NotificationCompat.FLAG_HIGH_PRIORITY, 10, 10, 5);
        }
        return new MemoryCacheParams(O000000o(), NotificationCompat.FLAG_HIGH_PRIORITY, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
}
