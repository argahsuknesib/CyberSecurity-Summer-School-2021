package _m_j;

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

public final class bwx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f13368O000000o = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] O00000Oo = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];

    static {
        for (int i = 0; i < 128; i++) {
            O00000Oo[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            O00000Oo[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            O00000Oo[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            O00000Oo[i4] = (byte) ((i4 - 48) + 52);
        }
        byte[] bArr = O00000Oo;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String O000000o(String str) {
        return brs.O000000o(O00000Oo(str));
    }

    public static byte[] O000000o(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey O00000o = brs.O00000o();
        if (O00000o == null) {
            return null;
        }
        byte[] O000000o2 = O000000o(encoded, O00000o);
        byte[] O000000o3 = O000000o(encoded, bArr);
        byte[] bArr2 = new byte[(O000000o2.length + O000000o3.length)];
        System.arraycopy(O000000o2, 0, bArr2, 0, O000000o2.length);
        System.arraycopy(O000000o3, 0, bArr2, O000000o2.length, O000000o3.length);
        return bArr2;
    }

    static byte[] O000000o(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(brs.O00000o0(bsa.f13227O000000o));
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            return O00000o0(bArr, bArr2, brs.O00000o0());
        } catch (Throwable th) {
            bsc.O000000o(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr2);
    }

    public static String O00000Oo(byte[] bArr) {
        try {
            return O00000o(bArr);
        } catch (Throwable th) {
            bsc.O000000o(th, "er", "e64");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[LOOP:2: B:11:0x0024->B:14:0x0031, LOOP_START, PHI: r4 10  PHI: (r4v1 int) = (r4v0 int), (r4v8 int) binds: [B:10:0x0022, B:14:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A[EDGE_INSN: B:49:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096 A[EDGE_INSN: B:51:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    public static byte[] O00000Oo(String str) {
        byte b;
        byte b2;
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] O000000o2 = brs.O000000o(str);
        int length = O000000o2.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                b = O00000Oo[O000000o2[i]];
                if (i2 >= length || b != -1) {
                    if (b != -1) {
                        break;
                    }
                    while (true) {
                        int i3 = i2 + 1;
                        b2 = O00000Oo[O000000o2[i2]];
                        if (i3 >= length || b2 != -1) {
                            if (b2 != -1) {
                                break;
                            }
                            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                            while (i3 != length) {
                                int i4 = i3 + 1;
                                byte b3 = O000000o2[i3];
                                if (b3 == 61) {
                                    return byteArrayOutputStream.toByteArray();
                                }
                                byte b4 = O00000Oo[b3];
                                if (i4 >= length || b4 != -1) {
                                    if (b4 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(((b2 & 15) << 4) | ((b4 & 60) >>> 2));
                                    while (i4 != length) {
                                        int i5 = i4 + 1;
                                        byte b5 = O000000o2[i4];
                                        if (b5 == 61) {
                                            return byteArrayOutputStream.toByteArray();
                                        }
                                        byte b6 = O00000Oo[b5];
                                        if (i5 >= length || b6 != -1) {
                                            if (b6 == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(b6 | ((b4 & 3) << 6));
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
                    if (b2 != -1) {
                    }
                } else {
                    i = i2;
                }
            }
            if (b != -1) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return O00000o0(bArr, bArr2, bArr3);
    }

    private static String O00000o(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            byte b = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(f13368O000000o[b >>> 2]);
                stringBuffer.append(f13368O000000o[(b & 3) << 4]);
                str = "==";
                break;
            }
            int i3 = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(f13368O000000o[b >>> 2]);
                stringBuffer.append(f13368O000000o[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                stringBuffer.append(f13368O000000o[(b2 & 15) << 2]);
                str = "=";
                break;
            }
            int i4 = i3 + 1;
            byte b3 = bArr[i3] & 255;
            stringBuffer.append(f13368O000000o[b >>> 2]);
            stringBuffer.append(f13368O000000o[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
            stringBuffer.append(f13368O000000o[((b2 & 15) << 2) | ((b3 & 192) >>> 6)]);
            stringBuffer.append(f13368O000000o[b3 & 63]);
            i = i4;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static String O00000o0(byte[] bArr) {
        try {
            return O00000o(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] O00000o0(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
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
}
