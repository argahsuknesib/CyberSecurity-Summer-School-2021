package _m_j;

import android.util.Log;

public final class bxb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13374O000000o = false;
    private static String O00000Oo = "AirkanUwb";

    public static void O000000o(String str) {
        if (f13374O000000o) {
            Log.w(O00000Oo, str);
        }
    }

    public static void O00000Oo(String str) {
        if (f13374O000000o) {
            Log.e(O00000Oo, str);
        }
    }

    public static void O000000o() {
        f13374O000000o = true;
    }
}
