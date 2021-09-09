package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.net.UnknownHostException;

public final class Log {
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    private Log() {
    }

    public static int getLogLevel() {
        return logLevel;
    }

    public final boolean getLogStackTraces() {
        return logStackTraces;
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void setLogStackTraces(boolean z) {
        logStackTraces = z;
    }

    public static void d(String str, String str2) {
        if (logLevel == 0) {
            android.util.Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        d(str, appendThrowableString(str2, th));
    }

    public static void i(String str, String str2) {
        if (logLevel <= 1) {
            android.util.Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        i(str, appendThrowableString(str2, th));
    }

    public static void w(String str, String str2) {
        if (logLevel <= 2) {
            android.util.Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        w(str, appendThrowableString(str2, th));
    }

    public static void e(String str, String str2) {
        if (logLevel <= 3) {
            android.util.Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, appendThrowableString(str2, th));
    }

    public static String getThrowableString(Throwable th) {
        if (th == null) {
            return null;
        }
        if (isCausedByUnknownHostException(th)) {
            return "UnknownHostException (no network)";
        }
        if (!logStackTraces) {
            return th.getMessage();
        }
        return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    private static String appendThrowableString(String str, Throwable th) {
        String throwableString = getThrowableString(th);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        return str + "\n  " + throwableString.replace("\n", "\n  ") + 10;
    }

    private static boolean isCausedByUnknownHostException(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }
}
