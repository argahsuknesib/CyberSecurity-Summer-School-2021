package com.mitv.airkan.opus;

public class Opus {
    private native int nativeDecodeBytes(byte[] bArr, short[] sArr);

    private native boolean nativeInitDecoder();

    private native void test();

    public native int nativeEncodeBytes(short[] sArr, byte[] bArr);

    public native boolean nativeInitEncoder();

    public native boolean nativeRelease();

    static {
        try {
            System.loadLibrary("airkanopus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
