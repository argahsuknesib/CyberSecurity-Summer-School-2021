package com.hzy.tvmao.ir.encode;

import android.content.Context;

public class IrDevice {
    public static native synchronized void createRemote(int i, byte[] bArr);

    private static native synchronized int[] enc(byte[] bArr);

    public static native synchronized int getFrequency();

    public static native synchronized boolean init(Context context, String str);

    static {
        try {
            System.loadLibrary("kksdk");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int[] getPulsePattern(byte[] bArr) {
        return enc(bArr);
    }

    public static int[] getTimePattern(byte[] bArr) {
        int[] enc = enc(bArr);
        int frequency = 1000000 / getFrequency();
        for (int i = 0; i < enc.length; i++) {
            enc[i] = enc[i] * frequency;
        }
        return enc;
    }
}
