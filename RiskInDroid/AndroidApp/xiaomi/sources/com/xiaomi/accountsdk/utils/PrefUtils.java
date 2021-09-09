package com.xiaomi.accountsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtils {
    private PrefUtils() {
    }

    public static void saveString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_xiaomi_account", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void remove(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_xiaomi_account", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String getString(Context context, String str) {
        return context.getSharedPreferences("pref_com_xiaomi_account", 0).getString(str, null);
    }

    public static void saveLong(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_xiaomi_account", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static long getLong(Context context, String str, long j) {
        return context.getSharedPreferences("pref_com_xiaomi_account", 0).getLong(str, j);
    }

    public static void saveBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_xiaomi_account", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences("pref_com_xiaomi_account", 0).getBoolean(str, z);
    }

    public static void saveInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_xiaomi_account", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences("pref_com_xiaomi_account", 0).getInt(str, i);
    }
}
