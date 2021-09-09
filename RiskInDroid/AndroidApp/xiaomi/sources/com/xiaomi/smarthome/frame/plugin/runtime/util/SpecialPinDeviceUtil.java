package com.xiaomi.smarthome.frame.plugin.runtime.util;

public class SpecialPinDeviceUtil {
    public static String[] modelList = {"inshow.watch.w1", "xiaomi.aircondition.ma2"};

    public static boolean isSecurityPinNativePlugin(String str) {
        for (String equals : modelList) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
