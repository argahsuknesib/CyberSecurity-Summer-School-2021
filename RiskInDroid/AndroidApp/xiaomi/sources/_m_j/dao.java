package _m_j;

import android.content.res.Resources;

public final class dao {

    /* renamed from: O000000o  reason: collision with root package name */
    public float f14418O000000o = Resources.getSystem().getDisplayMetrics().density;

    public static int O000000o(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float O000000o(int i) {
        return ((float) i) / Resources.getSystem().getDisplayMetrics().density;
    }

    public final int O00000Oo(float f) {
        return (int) ((f * this.f14418O000000o) + 0.5f);
    }
}
