package _m_j;

import android.content.Context;
import android.util.DisplayMetrics;

public final class chp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13827O000000o = 0;
    public static int O00000Oo = 0;
    public static int O00000o = 0;
    public static float O00000o0 = 0.0f;
    private static String O00000oO = "";
    private static boolean O00000oo = false;
    private static boolean O0000O0o = false;
    private static boolean O0000OOo = false;

    public static synchronized boolean O000000o() {
        boolean z;
        synchronized (chp.class) {
            z = O0000O0o;
        }
        return z;
    }

    public static synchronized boolean O00000Oo() {
        boolean z;
        synchronized (chp.class) {
            z = O0000OOo;
        }
        return z;
    }

    public static void O000000o(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (context.getResources().getConfiguration().orientation == 2) {
            f13827O000000o = displayMetrics.heightPixels;
            O00000Oo = displayMetrics.widthPixels;
        } else {
            f13827O000000o = displayMetrics.widthPixels;
            O00000Oo = displayMetrics.heightPixels;
        }
        O00000o0 = displayMetrics.density;
        O00000o = displayMetrics.densityDpi;
        O00000oo = (context.getApplicationInfo().flags & 2) != 0;
    }
}
