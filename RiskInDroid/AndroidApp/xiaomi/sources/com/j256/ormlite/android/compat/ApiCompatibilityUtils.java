package com.j256.ormlite.android.compat;

import android.os.Build;

public class ApiCompatibilityUtils {
    private static ApiCompatibility compatibility;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            compatibility = new JellyBeanApiCompatibility();
        } else {
            compatibility = new BasicApiCompatibility();
        }
    }

    public static ApiCompatibility getCompatibility() {
        return compatibility;
    }
}
