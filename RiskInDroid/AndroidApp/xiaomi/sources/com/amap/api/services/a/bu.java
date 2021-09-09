package com.amap.api.services.a;

import android.support.v4.app.NotificationCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class bu {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f3353a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] b = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];

    static {
        for (int i = 0; i < 128; i++) {
            b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            b[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            b[i4] = (byte) ((i4 - 48) + 52);
        }
        byte[] bArr = b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey d = bz.d();
        if (d == null) {
            return null;
        }
        byte[] a2 = a(encoded, d);
        byte[] a3 = a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        return bArr2;
    }

    public static String b(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            ci.a(th, "er", "e64");
            return null;
        }
    }

    public static String a(String str) {
        return bz.a(b(str));
    }

    public static String c(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return b(bArr, bArr2);
        } catch (Throwable th) {
            ci.a(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        return d(bArr, bArr2, bArr3);
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return c(bArr, bArr2, bz.c());
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return c(bArr, bArr2, bArr3);
    }

    private static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return instance.doFinal(bArr2);
    }

    private static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr2);
    }

    static byte[] a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(bz.c(cg.f3362a));
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[LOOP:2: B:11:0x0024->B:14:0x0031, LOOP_START, PHI: r4 10  PHI: (r4v1 int) = (r4v0 int), (r4v8 int) binds: [B:10:0x0022, B:14:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A[EDGE_INSN: B:49:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096 A[EDGE_INSN: B:51:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    public static byte[] b(String str) {
        byte b2;
        byte b3;
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] a2 = bz.a(str);
        int length = a2.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                b2 = b[a2[i]];
                if (i2 >= length || b2 != -1) {
                    if (b2 != -1) {
                        break;
                    }
                    while (true) {
                        int i3 = i2 + 1;
                        b3 = b[a2[i2]];
                        if (i3 >= length || b3 != -1) {
                            if (b3 != -1) {
                                break;
                            }
                            byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
                            while (i3 != length) {
                                int i4 = i3 + 1;
                                byte b4 = a2[i3];
                                if (b4 == 61) {
                                    return byteArrayOutputStream.toByteArray();
                                }
                                byte b5 = b[b4];
                                if (i4 >= length || b5 != -1) {
                                    if (b5 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(((b3 & 15) << 4) | ((b5 & 60) >>> 2));
                                    while (i4 != length) {
                                        int i5 = i4 + 1;
                                        byte b6 = a2[i4];
                                        if (b6 == 61) {
                                            return byteArrayOutputStream.toByteArray();
                                        }
                                        byte b7 = b[b6];
                                        if (i5 >= length || b7 != -1) {
                                            if (b7 == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(b7 | ((b5 & 3) << 6));
                                            i = i5;
                                        } else {
                                            i4 = i5;
                                        }
                                    }
                                    return byteArrayOutputStream.toByteArray();
                                }
                                i3 = i4;
                            }
                            return byteArrayOutputStream.toByteArray();
                        }
                        i2 = i3;
                    }
                    if (b3 != -1) {
                    }
                } else {
                    i = i2;
                }
            }
            if (b2 != -1) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            byte b2 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(f3353a[b2 >>> 2]);
                stringBuffer.append(f3353a[(b2 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i3 = i2 + 1;
            byte b3 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(f3353a[b2 >>> 2]);
                stringBuffer.append(f3353a[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                stringBuffer.append(f3353a[(b3 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i4 = i3 + 1;
            byte b4 = bArr[i3] & 255;
            stringBuffer.append(f3353a[b2 >>> 2]);
            stringBuffer.append(f3353a[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
            stringBuffer.append(f3353a[((b3 & 15) << 2) | ((b4 & 192) >>> 6)]);
            stringBuffer.append(f3353a[b4 & 63]);
            i = i4;
        }
        return stringBuffer.toString();
    }
}
