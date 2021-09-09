package com.tsmclient.smartcard;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtils {
    private PrefUtils() {
    }

    public static void putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        putString(context, "pref_com_tsmclient_smartcard", str, str2);
    }

    public static void putString(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).getString(str, str2);
    }

    public static void putInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).getInt(str, i);
    }

    public static void putLong(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static long getLong(Context context, String str, long j) {
        return context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).getLong(str, j);
    }

    public static boolean contains(Context context, String str) {
        return context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).contains(str);
    }

    public static boolean remove(Context context, String str) {
        return context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).edit().remove(str).commit();
    }

    public static void clear(Context context) {
        context.getSharedPreferences("pref_com_tsmclient_smartcard", 0).edit().clear().commit();
    }
}
