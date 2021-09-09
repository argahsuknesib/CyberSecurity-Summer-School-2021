package com.xiaomi.accountsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    private final SharedPreferences mSharedPreferences;

    public SharedPreferencesUtil(Context context, String str) {
        this.mSharedPreferences = context.getSharedPreferences(str, 0);
    }

    public String getString(String str) {
        return this.mSharedPreferences.getString(str, null);
    }

    public long getLong(String str, long j) {
        return this.mSharedPreferences.getLong(str, j);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mSharedPreferences.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        return this.mSharedPreferences.getInt(str, i);
    }

    public void saveString(String str, String str2) {
        this.mSharedPreferences.edit().putString(str, str2).commit();
    }

    public void saveLong(String str, long j) {
        this.mSharedPreferences.edit().putLong(str, j).commit();
    }

    public void saveBoolean(String str, boolean z) {
        this.mSharedPreferences.edit().putBoolean(str, z).commit();
    }

    public void saveInt(String str, int i) {
        this.mSharedPreferences.edit().putInt(str, i).commit();
    }

    public void remove(String str) {
        this.mSharedPreferences.edit().remove(str).commit();
    }

    public void clear() {
        this.mSharedPreferences.edit().clear().commit();
    }
}
