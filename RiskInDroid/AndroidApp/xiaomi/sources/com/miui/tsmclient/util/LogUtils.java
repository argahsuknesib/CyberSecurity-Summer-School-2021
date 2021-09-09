package com.miui.tsmclient.util;

import android.util.Log;

public class LogUtils {
    public static void i(String str) {
        Log.i("TSMClient", str);
    }

    public static void i(String str, String str2) {
        Log.i("TSMClient.".concat(String.valueOf(str)), str2);
    }

    public static void e(String str) {
        Log.e("TSMClient", str);
    }

    public static void e(String str, Throwable th) {
        Log.e("TSMClient", str, th);
    }

    public static void w(String str) {
        Log.w("TSMClient", str);
    }

    public static void w(String str, String str2) {
        Log.w("TSMClient.".concat(String.valueOf(str)), str2);
    }

    public static void d(String str) {
        Log.d("TSMClient", str);
    }

    public static void d(String str, String str2) {
        Log.d("TSMClient.".concat(String.valueOf(str)), str2);
    }

    public static void v(String str) {
        Log.v("TSMClient", str);
    }

    public static void t(String str) {
        if (EnvironmentConfig.isStaging()) {
            Log.v("TSMClientStaging", str);
        }
    }

    private LogUtils() {
    }
}
