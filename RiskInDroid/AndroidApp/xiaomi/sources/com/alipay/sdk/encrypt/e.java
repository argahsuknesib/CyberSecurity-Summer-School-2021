package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f3191a = "DESede/CBC/PKCS5Padding";

    public static byte[] a(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher instance = Cipher.getInstance(f3191a);
            instance.init(1, secretKeySpec, new IvParameterSpec(c.a(instance, str2)));
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher instance = Cipher.getInstance(f3191a);
            instance.init(2, secretKeySpec, new IvParameterSpec(c.a(instance, str2)));
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            return a.a(a(str, str2.getBytes(), str3));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        try {
            return new String(b(str, a.a(str2), str3));
        } catch (Exception unused) {
            return null;
        }
    }
}
