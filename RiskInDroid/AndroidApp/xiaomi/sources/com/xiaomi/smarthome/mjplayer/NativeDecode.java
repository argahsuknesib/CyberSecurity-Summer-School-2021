package com.xiaomi.smarthome.mjplayer;

import android.view.Surface;

public class NativeDecode {
    public static native int[] decode(long j, byte[] bArr, long j2);

    public static native byte[] decodeYuv(long j, byte[] bArr, long j2);

    public static native long init(boolean z, Surface surface, String str, String str2, int i, int i2, int i3, boolean z2);

    public static native boolean isGPUDecode(long j);

    public static native boolean release(long j);

    public static native void setDid(long j, String str);

    public static native void setSuperResolutionPath(long j, boolean z, String str, String str2);

    public static native int[] toTexture(long j, int i, int i2, int i3, boolean z, int i4, int i5);

    static {
        System.loadLibrary("mjplayer");
        System.loadLibrary("ijkffmpeg");
        System.loadLibrary("mijia_native_log");
    }
}
