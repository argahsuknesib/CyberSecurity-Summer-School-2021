package com.xiaomi.onetrack.d;

import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.q;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class a {
    private static KeyGenerator d;

    static {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            d = instance;
            instance.init((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        } catch (Exception e) {
            q.b(q.a("AES"), "AesUtil e", e);
        }
    }

    public static byte[] a() {
        return d.generateKey().getEncoded();
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            q.b(q.a("AES"), "encrypt exception:", e);
            return null;
        }
    }

    private static byte[] e(String str, String str2) {
        return a(str.getBytes(), str2.getBytes());
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(b(str), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            q.b(q.a("AES"), "decrypt exception:", e);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            q.b("AES", "decrypt exception:", e);
            q.b("AES", "content len=" + bArr.length + ", passwd len=" + bArr2.length);
            return null;
        }
    }

    private static byte[] b(String str) {
        if (str != null) {
            return str.getBytes();
        }
        return null;
    }

    private static byte[] c(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static String a(String str, String str2) {
        return n.a(e(str, str2));
    }

    public static String b(String str, String str2) {
        return Base64.encodeToString(e(str, str2), 10);
    }

    public static String c(String str, String str2) {
        return new String(a(c(str), str2));
    }

    public static String d(String str, String str2) {
        return new String(a(Base64.decode(str, 10), str2));
    }

    public static String a(String str) {
        try {
            char[] charArray = (str + b.f6132a).toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (int i2 = 0; i2 < charArray.length - 1; i2++) {
                    if (charArray[i] < charArray[i2]) {
                        char c = charArray[i];
                        charArray[i] = charArray[i2];
                        charArray[i2] = c;
                    }
                }
            }
            return d.h(new String(charArray));
        } catch (Exception unused) {
            q.b("AES", "encodeFromSalt ".concat(""));
            return "";
        }
    }
}
