package com.ximalaya.ting.android.player;

public class MediadataCrytoUtil {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f12232O000000o = 1024;
    private static MediadataCrytoUtil O00000Oo;
    private long O00000o0;

    private native byte[] decryptData(long j, byte[] bArr, int i);

    private native void destroyEncryptCtx(long j);

    private native byte[] encryptData(long j, byte[] bArr, int i);

    private native long initLogistic();

    public static void O000000o() {
        MediadataCrytoUtil mediadataCrytoUtil = O00000Oo;
        if (mediadataCrytoUtil != null) {
            mediadataCrytoUtil.destroyEncryptCtx(mediadataCrytoUtil.O00000o0);
            O00000Oo = null;
        }
    }

    static {
        try {
            System.loadLibrary("mediadatacryto");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
