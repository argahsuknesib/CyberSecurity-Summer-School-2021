package _m_j;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public final class cdc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13651O000000o = false;

    public static void O000000o() {
        f13651O000000o = true;
    }

    private static void O000000o(int i, Throwable th, String str, String str2) {
        String O00000oO = O00000oO(str);
        if (i == 0) {
            Log.e(O00000oO, str2, th);
        } else if (i == 1) {
            Log.w(O00000oO, str2, th);
        } else if (i == 2) {
            Log.i(O00000oO, str2, th);
        } else if (i == 3) {
            Log.d(O00000oO, str2, th);
        } else if (i == 4) {
            Log.v(O00000oO, str2, th);
        }
    }

    private static String O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return "MI_STAT";
        }
        return "MI_STAT_".concat(String.valueOf(str));
    }

    private static String O000000o(String str, Object... objArr) {
        try {
            return String.format(Locale.getDefault(), str, objArr);
        } catch (Exception e) {
            O000000o("log getMessage exception :", e);
            return null;
        }
    }

    public static void O000000o(String str, String str2) {
        if (f13651O000000o) {
            O000000o(4, null, str, str2);
        }
    }

    public static void O000000o(String str) {
        if (f13651O000000o) {
            O000000o(4, null, null, str);
        }
    }

    public static void O000000o(String str, String str2, Throwable th) {
        if (f13651O000000o) {
            O000000o(0, th, str, str2);
        }
    }

    public static void O000000o(String str, Throwable th) {
        if (f13651O000000o) {
            O000000o(0, th, null, str);
        }
    }

    public static void O000000o(String str, String str2, Object... objArr) {
        if (f13651O000000o) {
            Log.d(O00000oO(str), O000000o(str2, objArr), null);
        }
    }

    public static void O00000Oo(String str) {
        if (f13651O000000o) {
            O000000o(3, null, null, str);
        }
    }

    public static void O00000o0(String str) {
        if (f13651O000000o) {
            O000000o(2, null, null, str);
        }
    }

    public static void O00000Oo(String str, String str2, Throwable th) {
        if (f13651O000000o) {
            O000000o(1, th, str, str2);
        }
    }

    public static void O00000o(String str) {
        if (f13651O000000o) {
            O000000o(1, null, null, str);
        }
    }
}
