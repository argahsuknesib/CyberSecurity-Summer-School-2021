package com.xiaomi.safedata.util;

public class SafeHolder {
    public static native String checkHookByMap();

    public static native String checkHookByPackage();

    public static native int checkMoreOpenByUid();

    public static native int checkSubstrateBySo();

    static {
        System.loadLibrary("xmsafe-lib");
    }
}
