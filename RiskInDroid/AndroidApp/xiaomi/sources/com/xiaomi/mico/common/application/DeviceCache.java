package com.xiaomi.mico.common.application;

import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.Cache;
import com.xiaomi.mico.common.util.MD5;

public class DeviceCache {
    public static <T> T get(String str, Class<T> cls) {
        return Cache.get(internalKey(null, str), cls);
    }

    private static String internalKey(String str, String str2) {
        if (str == null) {
            str = MicoManager.getInstance().getCurrentMicoID();
        }
        return String.format("%s_%s", getDevicePrefix(str), str2);
    }

    private static String getDevicePrefix(String str) {
        return MD5.MD5_16(str).substring(0, 8);
    }

    public static void put(String str, String str2, Object obj) {
        Cache.put(internalKey(str, str2), obj);
    }
}
