package com.amap.location.security;

import _m_j.om;
import android.content.Context;

public class Core {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f3555O000000o = "Core";

    static {
        String str;
        String str2;
        try {
            System.loadLibrary("apssdk");
        } catch (UnsatisfiedLinkError unused) {
            str = f3555O000000o;
            str2 = "core|link e";
            om.O000000o(str, str2, false, true);
        } catch (Exception unused2) {
            str = f3555O000000o;
            str2 = "core|load fail";
            om.O000000o(str, str2, false, true);
        }
    }

    public static native byte[] avc(Context context, byte[] bArr, int i);

    public static native int cd(int i);

    public static native String ce(double d, int i);

    public static native byte[] cole(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] doEncrypt(int i, byte[] bArr, int i2, int i3);

    public static native long encMac(String str);

    public static native String encode(Context context, String str, int i);

    public static native String gcl(int i, int i2, int i3);

    public static native double gd(int i, int i2, double d, double d2);

    public static native String[] getAuthServers();

    public static native String getNativeUriSegments(int i, int i2);

    public static native String getTag(Context context, String str);

    public static native String gwl(String str, int i, int i2, String str2);

    public static native long ivs(long j);

    public static native String load(Context context, String str, long j);

    public static native float mad(float[] fArr, float[] fArr2);

    public static native void rts();

    public static native float rvd(float[] fArr);

    public static native String saos(String str, String str2, String str3);

    public static native String transfer(Context context, String str, double d);

    public static native byte[] xxt(byte[] bArr, int i);

    public static native String xxtAos(String str, String str2, int i);
}
