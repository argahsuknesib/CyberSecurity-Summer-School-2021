package com.xiaomi.smarthome.mjbuffer;

public class MjBuffer {
    public static native int clear(String str);

    public static native int enableGet(String str, int i, int i2);

    public static native int init(boolean z, String str);

    static {
        System.loadLibrary("mjbuffer");
    }
}
