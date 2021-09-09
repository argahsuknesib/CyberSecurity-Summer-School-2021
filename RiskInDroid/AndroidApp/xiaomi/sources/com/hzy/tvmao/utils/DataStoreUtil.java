package com.hzy.tvmao.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hzy.tvmao.KookongSDK;

public class DataStoreUtil {
    private static DataStoreUtil sDataStoreUtil;
    public final String DATASTORE = "datastore";
    protected SharedPreferences mSharedPreferences;

    public static DataStoreUtil i() {
        return i(null);
    }

    public static DataStoreUtil i(String str) {
        if (sDataStoreUtil == null) {
            sDataStoreUtil = new DataStoreUtil();
        }
        sDataStoreUtil.setPath(str);
        return sDataStoreUtil;
    }

    /* access modifiers changed from: protected */
    public void setPath(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mSharedPreferences = KookongSDK.getContext().getSharedPreferences("datastore", 0);
        } else {
            this.mSharedPreferences = KookongSDK.getContext().getSharedPreferences("datastore_".concat(String.valueOf(str)), 0);
        }
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public boolean getBoolean(String str, Boolean bool) {
        return this.mSharedPreferences.getBoolean(str, bool.booleanValue());
    }

    public void putFloat(String str, float f) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putFloat(str, f);
        edit.commit();
    }

    public float getFloat(String str, float f) {
        return this.mSharedPreferences.getFloat(str, f);
    }

    public void putInt(String str, int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public int getInt(String str, int i) {
        return this.mSharedPreferences.getInt(str, i);
    }

    public boolean putString(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public String getString(String str, String str2) {
        return this.mSharedPreferences.getString(str, str2);
    }

    public String[] getStringArray(String str) {
        return this.mSharedPreferences.getString(str, "").split("#~");
    }

    public void putStringArray(String str, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append("#~");
            }
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putString(str, sb.toString());
            edit.commit();
        }
    }

    public boolean remove(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.remove(str);
        return edit.commit();
    }

    public void clear() {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.clear();
        edit.commit();
    }
}
