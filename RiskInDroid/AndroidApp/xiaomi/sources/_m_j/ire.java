package _m_j;

import android.util.Log;

public final class ire {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f1579O000000o;

    public static void O000000o(String str, String str2, Object... objArr) {
        if (f1579O000000o <= 0) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.v(str, str2);
        }
    }

    public static void O000000o(String str, String str2) {
        if (f1579O000000o <= 1) {
            Log.d(str, str2);
        }
    }

    public static void O00000Oo(String str, String str2, Object... objArr) {
        if (f1579O000000o <= 1) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }
    }

    public static void O00000Oo(String str, String str2) {
        if (f1579O000000o <= 2) {
            Log.i(str, str2);
        }
    }

    public static void O00000o0(String str, String str2, Object... objArr) {
        if (f1579O000000o <= 2) {
            Log.i(str, String.format(str2, objArr));
        }
    }

    public static void O00000o0(String str, String str2) {
        if (f1579O000000o <= 4) {
            Log.e(str, str2);
        }
    }
}
