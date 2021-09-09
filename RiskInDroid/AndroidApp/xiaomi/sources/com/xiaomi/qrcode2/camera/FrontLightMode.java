package com.xiaomi.qrcode2.camera;

import android.content.SharedPreferences;

public enum FrontLightMode {
    ON,
    AUTO,
    OFF;

    private static FrontLightMode parse(String str) {
        return str == null ? OFF : valueOf(str);
    }

    public static FrontLightMode readPref(SharedPreferences sharedPreferences) {
        return parse(OFF.toString());
    }
}
