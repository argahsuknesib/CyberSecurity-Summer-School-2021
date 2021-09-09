package in.srain.cube.views.ptr.util;

import android.util.Log;

public class PtrCLog {
    private static int sLevel;

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    public static void v(String str, String str2) {
        if (sLevel <= 0) {
            Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (sLevel <= 0) {
            Log.v(str, str2, th);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (sLevel <= 0) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (sLevel <= 1) {
            Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (sLevel <= 1) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sLevel <= 1) {
            Log.d(str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (sLevel <= 2) {
            Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (sLevel <= 2) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (sLevel <= 2) {
            Log.i(str, str2, th);
        }
    }

    public static void w(String str, String str2) {
        if (sLevel <= 3) {
            Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (sLevel <= 3) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sLevel <= 3) {
            Log.w(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (sLevel <= 4) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (sLevel <= 4) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sLevel <= 4) {
            Log.e(str, str2, th);
        }
    }

    public static void f(String str, String str2) {
        if (sLevel <= 5) {
            Log.wtf(str, str2);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (sLevel <= 5) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.wtf(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        if (sLevel <= 5) {
            Log.wtf(str, str2, th);
        }
    }
}
