package com.xiaomi.idm.tap.dispatcher.utils;

import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class IDMTapLogger {
    private static int sLevel;
    private static LoggerProvider sLogger = new LoggerProvider() {
        /* class com.xiaomi.idm.tap.dispatcher.utils.IDMTapLogger.AnonymousClass1 */

        public final void log(int i, String str, String str2, Throwable th) {
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface Level {
    }

    public interface LoggerProvider {
        void log(int i, String str, String str2, Throwable th);
    }

    public static void setLevel(int i) {
        sLevel = i;
    }

    public static void setLogger(LoggerProvider loggerProvider) {
        sLogger = loggerProvider;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (sLevel >= 5) {
            String formatString = formatString(str2, objArr);
            Log.v(str, formatString);
            sLogger.log(5, str, formatString, null);
        }
    }

    public static void v(Throwable th, String str, String str2, Object... objArr) {
        if (sLevel >= 5) {
            String formatString = formatString(str2, objArr);
            Log.v(str, formatString, th);
            sLogger.log(5, str, formatString, th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        v(th, str, str2, new Object[0]);
    }

    public static void d(String str, String str2, Object... objArr) {
        if (sLevel >= 4) {
            String formatString = formatString(str2, objArr);
            Log.d(str, formatString);
            sLogger.log(4, str, formatString, null);
        }
    }

    public static void d(Throwable th, String str, String str2, Object... objArr) {
        if (sLevel >= 4) {
            String formatString = formatString(str2, objArr);
            Log.d(str, formatString, th);
            sLogger.log(4, str, formatString, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        d(th, str, str2, new Object[0]);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (sLevel >= 3) {
            String formatString = formatString(str2, objArr);
            Log.i(str, formatString);
            sLogger.log(3, str, formatString, null);
        }
    }

    public static void i(Throwable th, String str, String str2, Object... objArr) {
        if (sLevel >= 3) {
            String formatString = formatString(str2, objArr);
            Log.i(str, formatString, th);
            sLogger.log(3, str, formatString, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        i(th, str, str2, new Object[0]);
    }

    public static void w(String str, String str2, Object... objArr) {
        if (sLevel >= 2) {
            String formatString = formatString(str2, objArr);
            Log.w(str, formatString);
            sLogger.log(2, str, formatString, null);
        }
    }

    public static void w(Throwable th, String str, String str2, Object... objArr) {
        if (sLevel >= 2) {
            String formatString = formatString(str2, objArr);
            Log.w(str, formatString, th);
            sLogger.log(2, str, formatString, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        w(th, str, str2, new Object[0]);
    }

    public static void e(String str, String str2, Object... objArr) {
        if (sLevel > 0) {
            String formatString = formatString(str2, objArr);
            Log.e(str, formatString);
            sLogger.log(2, str, formatString, null);
        }
    }

    public static void e(Throwable th, String str, String str2, Object... objArr) {
        if (sLevel > 0) {
            String formatString = formatString(str2, objArr);
            Log.e(str, formatString, th);
            sLogger.log(2, str, formatString, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        e(th, str, str2, new Object[0]);
    }

    private static String formatString(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }
}
