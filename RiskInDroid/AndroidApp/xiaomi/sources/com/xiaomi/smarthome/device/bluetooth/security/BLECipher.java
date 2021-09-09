package com.xiaomi.smarthome.device.bluetooth.security;

import _m_j.got;
import android.text.TextUtils;

public class BLECipher {
    private static native int nativeEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    private static native int nativeMixA(byte[] bArr, byte[] bArr2, byte[] bArr3);

    private static native int nativeMixB(byte[] bArr, byte[] bArr2, byte[] bArr3);

    static {
        System.loadLibrary("blecipher");
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        if (got.O00000o(bArr) || got.O00000o(bArr2)) {
            return got.f18097O000000o;
        }
        byte[] bArr3 = new byte[bArr2.length];
        if (nativeEncrypt(bArr, bArr2, bArr3) != 0) {
            return got.f18097O000000o;
        }
        return bArr3;
    }

    public static byte[] O000000o(String str, int i) {
        if (TextUtils.isEmpty(str) || i < 0) {
            return got.f18097O000000o;
        }
        byte[] bArr = new byte[8];
        if (nativeMixA(O000000o(str), O000000o(i), bArr) != 0) {
            return got.f18097O000000o;
        }
        return bArr;
    }

    public static byte[] O00000Oo(String str, int i) {
        if (TextUtils.isEmpty(str) || i < 0) {
            return got.f18097O000000o;
        }
        byte[] bArr = new byte[8];
        if (nativeMixB(O000000o(str), O000000o(i), bArr) != 0) {
            return got.f18097O000000o;
        }
        return bArr;
    }

    private static byte[] O000000o(String str) {
        String[] split = str.split(":");
        int length = split.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[(length - i) - 1] = (byte) (Integer.parseInt(split[i], 16) & 255);
        }
        return bArr;
    }

    private static byte[] O000000o(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >>> 8) & 255)};
    }
}
