package com.xiaomi.mi_connect_service.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public class LogUtil {
    private static FileLogger sFileLogger;

    public static void init(Context context) {
        if (!DeviceUtil.isMiTv() || !PropertyUtils.hasProperty("ro.com.google.gmsversion")) {
            FileLogger instance = FileLogger.getInstance();
            sFileLogger = instance;
            instance.init(context);
        }
        i("LogUtil", "LogUtils init, A new application started", new Object[0]);
    }

    public static void v(String str, String str2, Object... objArr) {
        printLog(2, str, str2, null, objArr);
    }

    public static void v(String str, String str2, Throwable th) {
        v(th, str, str2, new Object[0]);
    }

    public static void v(Throwable th, String str, String str2, Object... objArr) {
        printLog(2, str, str2, th, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        printLog(3, str, str2, null, objArr);
    }

    public static void d(String str, String str2, Throwable th) {
        d(th, str, str2, new Object[0]);
    }

    public static void d(Throwable th, String str, String str2, Object... objArr) {
        printLog(3, str, str2, th, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        printLog(4, str, str2, null, objArr);
    }

    public static void i(String str, String str2, Throwable th) {
        i(th, str, str2, new Object[0]);
    }

    public static void i(Throwable th, String str, String str2, Object... objArr) {
        printLog(4, str, str2, th, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        printLog(5, str, str2, null, objArr);
    }

    public static void w(String str, String str2, Throwable th) {
        w(th, str, str2, new Object[0]);
    }

    public static void w(Throwable th, String str, String str2, Object... objArr) {
        printLog(5, str, str2, th, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        printLog(6, str, str2, null, objArr);
    }

    public static void e(String str, String str2, Throwable th) {
        e(th, str, str2, new Object[0]);
    }

    public static void e(Throwable th, String str, String str2, Object... objArr) {
        printLog(6, str, str2, th, objArr);
    }

    private static String formatString(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private static void printLog(int i, String str, String str2, Throwable th, Object... objArr) {
        String str3;
        if (i >= 3) {
            if (TextUtils.isEmpty(str2)) {
                str2 = str2 == null ? "null" : "empty-notnull";
            }
            if (TextUtils.isEmpty(str)) {
                str = str == null ? "nullTag" : "emptyTag";
            }
            String formatString = formatString(str2, objArr);
            if (i == 2) {
                if (th == null) {
                    Log.v(str, formatString);
                } else {
                    Log.v(str, formatString, th);
                }
                str3 = "V";
            } else if (i == 3) {
                if (th == null) {
                    Log.d(str, formatString);
                } else {
                    Log.d(str, formatString, th);
                }
                str3 = "D";
            } else if (i == 4) {
                if (th == null) {
                    Log.i(str, formatString);
                } else {
                    Log.i(str, formatString, th);
                }
                str3 = "I";
            } else if (i == 5) {
                if (th == null) {
                    Log.w(str, formatString);
                } else {
                    Log.w(str, formatString, th);
                }
                str3 = "W";
            } else if (i != 6) {
                str3 = "U";
            } else {
                if (th == null) {
                    Log.e(str, formatString);
                } else {
                    Log.e(str, formatString, th);
                }
                str3 = "E";
            }
            FileLogger fileLogger = sFileLogger;
            if (fileLogger != null) {
                fileLogger.log(str3, str, formatString, th);
            }
        }
    }
}
