package _m_j;

import android.util.Log;
import java.util.Locale;

public final class did {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f14660O000000o = "CrashReport";
    public static boolean O00000Oo = false;
    private static String O00000o0 = "CrashReportInfo";

    private static boolean O000000o(int i, String str, Object... objArr) {
        if (!O00000Oo) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (!(objArr == null || objArr.length == 0)) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i == 0) {
            Log.i(f14660O000000o, str);
            return true;
        } else if (i == 1) {
            Log.d(f14660O000000o, str);
            return true;
        } else if (i == 2) {
            Log.w(f14660O000000o, str);
            return true;
        } else if (i == 3) {
            Log.e(f14660O000000o, str);
            return true;
        } else if (i != 5) {
            return false;
        } else {
            Log.i(O00000o0, str);
            return true;
        }
    }

    public static boolean O000000o(String str, Object... objArr) {
        return O000000o(0, str, objArr);
    }

    public static boolean O000000o(Class cls, String str, Object... objArr) {
        return O000000o(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean O00000Oo(String str, Object... objArr) {
        return O000000o(5, str, objArr);
    }

    public static boolean O00000o0(String str, Object... objArr) {
        return O000000o(1, str, objArr);
    }

    public static boolean O00000Oo(Class cls, String str, Object... objArr) {
        return O000000o(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean O00000o(String str, Object... objArr) {
        return O000000o(2, str, objArr);
    }

    public static boolean O000000o(Throwable th) {
        if (!O00000Oo) {
            return false;
        }
        return O000000o(2, dif.O000000o(th), new Object[0]);
    }

    public static boolean O00000oO(String str, Object... objArr) {
        return O000000o(3, str, objArr);
    }

    public static boolean O00000Oo(Throwable th) {
        if (!O00000Oo) {
            return false;
        }
        return O000000o(3, dif.O000000o(th), new Object[0]);
    }
}
