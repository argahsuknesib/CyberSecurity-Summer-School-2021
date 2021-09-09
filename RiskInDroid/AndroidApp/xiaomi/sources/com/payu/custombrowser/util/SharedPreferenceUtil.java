package com.payu.custombrowser.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

public class SharedPreferenceUtil {
    public static void addStringToSharedPreference(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public static void addIntToSharedPreference(Context context, String str, String str2, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i);
        edit.commit();
    }

    public static void addBooleanToSharedPreference(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z);
        edit.commit();
    }

    public static String getStringFromSharedPreference(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static int getIntFromSharedPreference(Context context, String str, String str2, int i) {
        return context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static boolean getBooleanFromSharedPreference(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static Map<String, ?> getSharedPrefMap(Context context, String str) {
        new HashMap();
        return context.getSharedPreferences(str, 0).getAll();
    }

    public static void removeAllFromSharedPref(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().clear().commit();
    }
}
