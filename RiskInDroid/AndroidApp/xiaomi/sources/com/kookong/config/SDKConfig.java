package com.kookong.config;

public class SDKConfig {
    public static volatile int st = -1;

    public static boolean init(int i) {
        if (i == 0 || i == 1) {
            st = i;
            return true;
        }
        throw new IllegalArgumentException("isForeign 不能为".concat(String.valueOf(i)));
    }

    public static boolean isST() {
        return st == 1;
    }
}
