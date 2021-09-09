package com.ximalaya.ting.android.opensdk.util;

import _m_j.ilo;
import android.content.Context;

public class EncryptUtilForSDK {

    /* renamed from: O000000o  reason: collision with root package name */
    private static EncryptUtilForSDK f12231O000000o;
    private Context O00000Oo;

    public native byte[] decryptByPublicKey2(Context context, byte[] bArr, String str, String str2, String str3) throws Exception;

    public native String decryptRc4ByPublicKey(Context context, String str, String str2, String str3) throws Exception;

    static {
        try {
            System.loadLibrary("xmopendatacrypto");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void O000000o() {
        f12231O000000o = null;
    }

    public static synchronized EncryptUtilForSDK O00000Oo() {
        EncryptUtilForSDK encryptUtilForSDK;
        synchronized (EncryptUtilForSDK.class) {
            if (f12231O000000o == null) {
                synchronized (EncryptUtilForSDK.class) {
                    if (f12231O000000o == null) {
                        f12231O000000o = new EncryptUtilForSDK();
                    }
                }
            }
            encryptUtilForSDK = f12231O000000o;
        }
        return encryptUtilForSDK;
    }

    public final void O000000o(Context context) {
        if (context != null) {
            this.O00000Oo = context.getApplicationContext();
        }
    }

    public final byte[] O000000o(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            return decryptByPublicKey2(this.O00000Oo, bArr, ilo.O00000Oo(), ilo.O00000o0(), this.O00000Oo.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return bArr2;
        }
    }

    public final String O000000o(String str) {
        try {
            return decryptRc4ByPublicKey(this.O00000Oo, str, ilo.O000000o(), this.O00000Oo.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
