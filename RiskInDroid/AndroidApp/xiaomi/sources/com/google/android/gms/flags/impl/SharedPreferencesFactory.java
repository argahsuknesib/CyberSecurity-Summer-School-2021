package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.flags.impl.util.StrictModeUtil;

public class SharedPreferencesFactory {
    private static SharedPreferences zzacv;

    public static SharedPreferences getSharedPreferences(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zzacv == null) {
                zzacv = (SharedPreferences) StrictModeUtil.runWithLaxStrictMode(new zze(context));
            }
            sharedPreferences = zzacv;
        }
        return sharedPreferences;
    }
}
