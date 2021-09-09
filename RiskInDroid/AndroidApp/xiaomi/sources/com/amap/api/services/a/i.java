package com.amap.api.services.a;

import android.support.v4.app.NotificationCompat;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f3421a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] b = {-1835101520, 1886468213, 614966444, 1545358877, 153741611, 1460081543, -1035306422, -708721439};

    private static int b(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 >> 1) | Integer.MIN_VALUE;
        }
        return (i << i2) | ((i & i3) >>> (32 - i2));
    }

    private static int c(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 15; i3++) {
            i2 = (i2 << 2) | 1;
        }
        return ((i & i2) << 1) | (((i2 << 1) & i) >>> 1);
    }

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                byte b3 = b2 & 255;
                if (b3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b3));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init((int) NotificationCompat.FLAG_HIGH_PRIORITY, secureRandom);
            return f.a(instance.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            return f.a(a(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f3421a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(b).getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            return new String(b(f.a(str)), "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f3421a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(b).getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                sb.append(a(iArr[i], i));
            }
        }
        return sb.toString();
    }

    private static String a(int i, int i2) {
        return a(b(c(i), i2));
    }

    private static String a(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = (4 - i2) - 1;
            cArr[i3] = (char) ((i >>> (i2 * 8)) & 255);
            b(cArr[i3]);
        }
        return new String(cArr);
    }

    private static String b(int i) {
        String str = " ";
        for (int i2 = 0; i2 < 32; i2++) {
            str = str + (((Integer.MIN_VALUE >>> i2) & i) >>> (31 - i2));
        }
        return str;
    }
}
