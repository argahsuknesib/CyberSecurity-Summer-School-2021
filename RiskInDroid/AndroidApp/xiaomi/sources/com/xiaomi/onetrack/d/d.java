package com.xiaomi.onetrack.d;

import android.text.TextUtils;
import com.xiaomi.onetrack.h.q;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d {
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static MessageDigest a() {
        return a("MD5");
    }

    public static byte[] a(byte[] bArr) {
        return a().digest(bArr);
    }

    public static byte[] b(String str) {
        return a(a(str, "UTF-8"));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String
     arg types: [byte[], int]
     candidates:
      com.xiaomi.onetrack.d.d.a(java.lang.String, java.lang.String):byte[]
      com.xiaomi.onetrack.d.d.a(byte[], char[]):char[]
      com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String */
    public static String b(byte[] bArr) {
        return a(a(bArr), true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String
     arg types: [byte[], int]
     candidates:
      com.xiaomi.onetrack.d.d.a(java.lang.String, java.lang.String):byte[]
      com.xiaomi.onetrack.d.d.a(byte[], char[]):char[]
      com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String */
    public static String c(String str) {
        return a(b(str), true);
    }

    private static MessageDigest b() {
        return a("SHA-256");
    }

    private static MessageDigest c() {
        return a("SHA1");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String
     arg types: [byte[], int]
     candidates:
      com.xiaomi.onetrack.d.d.a(java.lang.String, java.lang.String):byte[]
      com.xiaomi.onetrack.d.d.a(byte[], char[]):char[]
      com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String */
    public static String d(String str) {
        return a(g(str), true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String
     arg types: [byte[], int]
     candidates:
      com.xiaomi.onetrack.d.d.a(java.lang.String, java.lang.String):byte[]
      com.xiaomi.onetrack.d.d.a(byte[], char[]):char[]
      com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String */
    public static String e(String str) {
        return a(f(str), true);
    }

    public static byte[] f(String str) {
        return c(a(str, "UTF-8"));
    }

    public static byte[] c(byte[] bArr) {
        return b().digest(bArr);
    }

    public static byte[] g(String str) {
        return c().digest(a(str, "UTF-8"));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String
     arg types: [byte[], int]
     candidates:
      com.xiaomi.onetrack.d.d.a(java.lang.String, java.lang.String):byte[]
      com.xiaomi.onetrack.d.d.a(byte[], char[]):char[]
      com.xiaomi.onetrack.d.d.a(byte[], boolean):java.lang.String */
    public static String d(byte[] bArr) {
        return a(c(bArr), true);
    }

    public static String a(byte[] bArr, boolean z) {
        return new String(a(bArr, z ? b : c));
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    private static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String e(byte[] bArr) {
        String str;
        if (bArr != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                str = String.format("%1$032X", new BigInteger(1, instance.digest()));
            } catch (Exception e) {
                q.b("DigestUtil", "getMD5 exception: ".concat(String.valueOf(e)));
            }
            return str.toLowerCase();
        }
        str = "";
        return str.toLowerCase();
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return e(str.getBytes());
    }
}
