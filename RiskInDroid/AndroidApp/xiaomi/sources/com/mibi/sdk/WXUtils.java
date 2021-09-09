package com.mibi.sdk;

import android.content.Context;
import android.content.SharedPreferences;

public class WXUtils {
    public static void putString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mibi_wxpay_shared_preference", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static String getString(Context context, String str) {
        return context.getSharedPreferences("mibi_wxpay_shared_preference", 0).getString(str, "");
    }

    public static void removeString(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mibi_wxpay_shared_preference", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static void clearWXData(Context context) {
        context.getSharedPreferences("mibi_wxpay_shared_preference", 0).edit().clear().apply();
    }
}
