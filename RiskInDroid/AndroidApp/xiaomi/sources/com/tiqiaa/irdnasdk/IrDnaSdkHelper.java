package com.tiqiaa.irdnasdk;

import android.content.Context;
import java.util.Locale;

public final class IrDnaSdkHelper {
    private static Context mContext;

    public static final class IrData {
        public byte[] data;
        public int freq;
        public int quality;
    }

    private static native byte[] avc(Context context, int i);

    private static native byte[] buildIrCode(Context context, int i, int[] iArr);

    private static native byte[] convertIrCode(Context context, int i, byte[] bArr);

    private static native String createToken(Context context, String str, int i);

    private static native void initSdk(Context context, String str, int i);

    private static native byte[] parseIrCode(Context context, int i, byte[] bArr);

    private IrDnaSdkHelper() {
    }

    public static void init(Context context, String str, int i, int i2) {
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        initSdk(applicationContext, str, (i & 65535) | ((i2 & 65535) << 16));
    }

    public static String getToken(int i) {
        return createToken(mContext, Locale.getDefault().toString(), i);
    }

    public static byte[] getIrCode(int i, byte[] bArr) {
        return parseIrCode(mContext, i, bArr);
    }

    public static byte[] getAirVMCode(int i) {
        return avc(mContext, i);
    }

    private static IrData unpack(byte[] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        if (length < 9) {
            return null;
        }
        IrData irData = new IrData();
        irData.freq = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        irData.quality = bArr[4];
        int i = length - 5;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 5, bArr2, 0, i);
        irData.data = bArr2;
        return irData;
    }

    public static IrData convertIrCode(int i, byte[] bArr) {
        return unpack(convertIrCode(mContext, i, bArr));
    }

    public static IrData buildIrCode(int i, int[] iArr) {
        return unpack(buildIrCode(mContext, i, iArr));
    }

    static final class Language {
        Language() {
        }
    }
}
