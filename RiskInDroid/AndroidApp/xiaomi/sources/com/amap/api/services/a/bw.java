package com.amap.api.services.a;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bw {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return bz.e(c(str));
    }

    public static String a(byte[] bArr) {
        return bz.e(b(bArr));
    }

    public static String b(String str) {
        return bz.f(d(str));
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            ci.a(th, "MD5", "gmb");
            return null;
        }
    }

    private static byte[] b(byte[] bArr) {
        return a(bArr, "MD5");
    }

    public static byte[] c(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            ci.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] d(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bz.a(str));
        return instance.digest();
    }
}
