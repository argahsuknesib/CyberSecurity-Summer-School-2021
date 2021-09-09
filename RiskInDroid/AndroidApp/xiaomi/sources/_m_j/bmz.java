package _m_j;

import android.util.Log;

public final class bmz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13126O000000o = false;
    private static int O00000Oo = 5;

    private static String O000000o(String str, Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] instanceof String[]) {
                objArr[i] = O000000o((String[]) objArr[i]);
            }
        }
        String format = String.format(str, objArr);
        return "[" + Thread.currentThread().getId() + "] " + format;
    }

    private static String O000000o(String[] strArr) {
        if (strArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int length = strArr.length - 1;
        for (int i = 0; i < length; i++) {
            sb.append(strArr[i]);
            sb.append(", ");
        }
        sb.append(strArr[length]);
        sb.append("]");
        return sb.toString();
    }

    public static void O000000o(String str, String str2, Object... objArr) {
        if (f13126O000000o && O00000Oo <= 3) {
            Log.d(str, O000000o(str2, objArr));
        }
    }

    public static void O000000o(Throwable th) {
        if (f13126O000000o) {
            th.printStackTrace();
        }
    }

    public static void O00000Oo(String str, String str2, Object... objArr) {
        if (f13126O000000o && O00000Oo <= 4) {
            Log.i(str, O000000o(str2, objArr));
        }
    }

    public static void O00000o(String str, String str2, Object... objArr) {
        if (f13126O000000o && O00000Oo <= 6) {
            Log.e(str, O000000o(str2, objArr));
        }
    }

    public static void O00000o0(String str, String str2, Object... objArr) {
        if (f13126O000000o && O00000Oo <= 5) {
            Log.w(str, O000000o(str2, objArr));
        }
    }
}
