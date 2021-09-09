package _m_j;

import android.util.Log;

public final class ihs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1305O000000o = false;

    public static void O000000o(String str, String str2) {
        if (f1305O000000o) {
            Log.i("HSLog->".concat(String.valueOf(str)), str2);
        }
    }

    public static void O00000Oo(String str, String str2) {
        if (f1305O000000o) {
            Log.e("HSLog->".concat(String.valueOf(str)), str2);
        }
    }

    public static void O000000o(boolean z) {
        f1305O000000o = z;
    }
}
