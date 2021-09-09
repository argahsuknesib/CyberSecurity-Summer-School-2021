package com.mibi.sdk.common.utils;

import android.util.Log;
import com.mibi.sdk.common.CommonConstants;

public final class MibiLog {
    private MibiLog() {
    }

    public static int v(String str, String str2) {
        return Log.v(str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        return CommonConstants.DEBUG ? Log.v(str, str2, th) : Log.v(str, str2);
    }

    public static int d(String str, String str2) {
        return Log.d(str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return CommonConstants.DEBUG ? Log.d(str, str2, th) : Log.d(str, str2);
    }

    public static int i(String str, String str2) {
        return Log.i(str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        return CommonConstants.DEBUG ? Log.i(str, str2, th) : Log.i(str, str2);
    }

    public static int w(String str, String str2) {
        return Log.w(str, str2);
    }

    public static int w(String str, String str2, Throwable th) {
        return CommonConstants.DEBUG ? Log.w(str, str2, th) : Log.w(str, str2);
    }

    public static int w(String str, Throwable th) {
        if (CommonConstants.DEBUG) {
            return Log.w(str, th);
        }
        return 0;
    }

    public static boolean isLoggable(String str, int i) {
        return Log.isLoggable(str, i);
    }

    public static int e(String str, String str2) {
        return Log.e(str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        return CommonConstants.DEBUG ? Log.e(str, str2, th) : Log.e(str, str2);
    }

    public static int wtf(String str, String str2) {
        return Log.wtf(str, str2);
    }

    public static int wtf(String str, Throwable th) {
        if (CommonConstants.DEBUG) {
            return Log.wtf(str, th);
        }
        return 0;
    }

    public static int wtf(String str, String str2, Throwable th) {
        return CommonConstants.DEBUG ? Log.wtf(str, str2, th) : Log.wtf(str, str2);
    }
}
