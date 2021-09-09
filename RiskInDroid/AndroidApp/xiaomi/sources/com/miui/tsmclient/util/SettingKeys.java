package com.miui.tsmclient.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

public class SettingKeys {
    public static int getSecureInt(Context context, String str) throws Settings.SettingNotFoundException {
        return context.getSharedPreferences("pref_com_miui_tsmclient_secure", 0).getInt(str, -1);
    }

    public static String getSecureString(Context context, String str) {
        return context.getSharedPreferences("pref_com_miui_tsmclient_secure", 0).getString(str, "");
    }

    public static boolean putSecureInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_miui_tsmclient_secure", 0).edit();
        edit.putInt(str, i);
        edit.apply();
        return true;
    }

    public static boolean putSecureString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_miui_tsmclient_secure", 0).edit();
        edit.putString(str, str2);
        edit.apply();
        return true;
    }
}
