package com.xiaomi.accountsdk.utils;

import java.util.Locale;

public class VersionUtils {
    public static boolean isMiuiStable = false;
    public static String versionValue = String.format(Locale.US, "accountsdk-%s.%s.%s", "2020", "01", "09");

    public static void setToMiuiStableVersion() {
        isMiuiStable = true;
    }

    public static boolean isMiuiStableVersion() {
        return isMiuiStable;
    }

    public static String getVersion() {
        return versionValue;
    }
}
