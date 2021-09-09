package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class bmm {

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bmm f13102O000000o = new bmm();
    }

    public static String O000000o() {
        int i;
        int i2;
        int i3;
        Context context = blw.f13081O000000o;
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            i2 = displayMetrics.widthPixels;
            try {
                i = displayMetrics.heightPixels;
                try {
                    i3 = displayMetrics.densityDpi;
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i = 0;
                i3 = 0;
                return String.format(Locale.CHINA, "%d,%d,%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3));
            }
        } catch (Exception unused3) {
            i2 = 0;
            i = 0;
            i3 = 0;
            return String.format(Locale.CHINA, "%d,%d,%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3));
        }
        return String.format(Locale.CHINA, "%d,%d,%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3));
    }

    public static void O000000o(blh blh) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                blh.O000o0oo = Long.valueOf(statFs.getAvailableBytes());
                blh.O000o = Long.valueOf(statFs.getFreeBytes());
                blh.O000oO00 = Long.valueOf(statFs.getTotalBytes());
            }
        } catch (Exception unused) {
        }
    }
}
