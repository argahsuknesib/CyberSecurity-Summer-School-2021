package com.xiaomi.mico.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class VersionUtils {
    public static long versionCodeToLong(String str, int i) {
        long j = 0;
        if (!(str == null || str.length() == 0)) {
            String[] split = str.split("\\.");
            int i2 = 1;
            for (int length = split.length - 1; length >= 0; length--) {
                try {
                    j += (long) (Integer.valueOf(split[length]).intValue() * i2);
                } catch (Exception unused) {
                }
                i2 *= i;
            }
        }
        return j;
    }

    public static String formatVersionCode(String str, int i) {
        int intValue = Integer.valueOf(str).intValue();
        int i2 = intValue % i;
        int i3 = intValue / i;
        int i4 = i3 % i;
        return String.format("%d.%d.%d", Integer.valueOf((i3 / i) % i), Integer.valueOf(i4), Integer.valueOf(i2));
    }

    public static String getVersionName(Context context) {
        try {
            return formatVersionCode(String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode), 1000);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        return getVersionCode(context, context.getPackageName());
    }

    public static int getVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
