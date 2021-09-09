package com.xiaomi.idm.uwb.util;

import _m_j.gsy;
import android.util.Log;

public class LogUtil {
    private static boolean sIsDebug = true;

    public static void setDebug(boolean z) {
        sIsDebug = z;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (sIsDebug) {
            gsy.O000000o(2, str, formatString(str2, objArr));
        }
    }

    public static void v(Throwable th, String str, String str2, Object... objArr) {
        if (sIsDebug) {
            Log.v(str, formatString(str2, objArr), th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        v(th, str, str2, new Object[0]);
    }

    public static void d(String str, String str2, Object... objArr) {
        if (sIsDebug) {
            gsy.O000000o(3, str, formatString(str2, objArr));
        }
    }

    public static void d(Throwable th, String str, String str2, Object... objArr) {
        if (sIsDebug) {
            Log.d(str, formatString(str2, objArr), th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        d(th, str, str2, new Object[0]);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (sIsDebug) {
            gsy.O000000o(4, str, formatString(str2, objArr));
        }
    }

    public static void i(Throwable th, String str, String str2, Object... objArr) {
        if (sIsDebug) {
            Log.i(str, formatString(str2, objArr), th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        i(th, str, str2, new Object[0]);
    }

    public static void w(String str, String str2, Object... objArr) {
        if (sIsDebug) {
            gsy.O000000o(5, str, formatString(str2, objArr));
        }
    }

    public static void w(Throwable th, String str, String str2, Object... objArr) {
        if (sIsDebug) {
            Log.w(str, formatString(str2, objArr), th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        w(th, str, str2, new Object[0]);
    }

    public static void e(String str, String str2, Object... objArr) {
        if (sIsDebug) {
            gsy.O000000o(6, str, formatString(str2, objArr));
        }
    }

    public static void e(Throwable th, String str, String str2, Object... objArr) {
        if (sIsDebug) {
            Log.e(str, formatString(str2, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        e(th, str, str2, new Object[0]);
    }

    private static String formatString(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }
}
