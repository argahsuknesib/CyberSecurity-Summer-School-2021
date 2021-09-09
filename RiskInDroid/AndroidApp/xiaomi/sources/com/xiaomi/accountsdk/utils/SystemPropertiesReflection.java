package com.xiaomi.accountsdk.utils;

import java.lang.reflect.InvocationTargetException;

public class SystemPropertiesReflection {
    private SystemPropertiesReflection() {
    }

    public static String get(String str, String str2) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
    }

    public static int getInt(String str, int i) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i))).intValue();
    }
}
