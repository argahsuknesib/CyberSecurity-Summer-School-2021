package _m_j;

import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

public final class eio extends Build {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final boolean f15323O000000o = "mocha".equals(DEVICE);
    public static final boolean O00000Oo;
    public static final boolean O00000o0;

    static {
        boolean equals = "flo".equals(DEVICE);
        O00000Oo = equals;
        boolean z = true;
        if (!equals && !f15323O000000o) {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            if (((int) ((((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / displayMetrics.density) + 0.5f)) < 600) {
                z = false;
            }
        }
        O00000o0 = z;
    }
}
