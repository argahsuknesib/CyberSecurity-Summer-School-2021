package com.xiaomi.smarthome.camera.v4.activity.alarm;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefHelper {
    private String mDid;
    private SharedPreferences mSharedPreferences;

    public SharePrefHelper(Context context, String str, String str2) {
        this.mSharedPreferences = context.getSharedPreferences(str, 0);
        this.mDid = str2;
    }

    public void putValue(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(str + this.mDid, str2);
        edit.apply();
    }

    public void putBln(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean(str + this.mDid, z);
        edit.apply();
    }

    public void putGlobalBln(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public void putGlobalInt(String str, int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void putLong(String str, long j) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putLong(str + this.mDid, j);
        edit.apply();
    }

    public void putInt(String str, int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt(str + this.mDid, i);
        edit.apply();
    }

    public void putFloat(String str, float f) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putFloat(str + this.mDid, f);
        edit.apply();
    }

    public float getFloatValue(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences.getFloat(str + this.mDid, 0.0f);
    }

    public String getStrValue(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences.getString(str + this.mDid, null);
    }

    public boolean getBlnValue(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences.getBoolean(str + this.mDid, false);
    }

    public boolean getGlobalBlnValue(String str) {
        return this.mSharedPreferences.getBoolean(str, false);
    }

    public int getGlobalIntValue(String str) {
        return this.mSharedPreferences.getInt(str, 0);
    }

    public long getLongValue(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences.getLong(str + this.mDid, 0);
    }

    public int getIntValue(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences.getInt(str + this.mDid, 0);
    }

    public int getIntValue(String str, int i) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences.getInt(str + this.mDid, i);
    }
}
