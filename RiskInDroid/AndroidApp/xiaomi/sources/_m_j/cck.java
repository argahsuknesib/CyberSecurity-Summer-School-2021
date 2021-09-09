package _m_j;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public final class cck {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13630O000000o;
    public static int O00000Oo;
    public static int O00000o;
    public static float O00000o0;
    public static int O00000oO;
    private static boolean O00000oo;

    public static void O000000o(Context context) {
        if (!O00000oo && context != null) {
            O00000oo = true;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            f13630O000000o = displayMetrics.widthPixels;
            O00000Oo = displayMetrics.heightPixels;
            O00000o0 = displayMetrics.density;
            O00000o = (int) (((float) f13630O000000o) / displayMetrics.density);
            O00000oO = (int) (((float) O00000Oo) / displayMetrics.density);
        }
    }

    public static int O000000o(float f) {
        return (int) ((f * O00000o0) + 0.5f);
    }
}
