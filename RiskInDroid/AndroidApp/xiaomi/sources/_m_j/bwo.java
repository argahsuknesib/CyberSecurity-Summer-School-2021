package _m_j;

import android.support.v4.app.NotificationCompat;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class bwo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static byte[] f13340O000000o = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] O00000Oo = {-1835101520, 1886468213, 614966444, 1545358877, 153741611, 1460081543, -1035306422, -708721439};

    private static int O000000o(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 >> 1) | Integer.MIN_VALUE;
        }
        return (i << i2) | ((i & i3) >>> (32 - i2));
    }

    public static String O000000o() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init((int) NotificationCompat.FLAG_HIGH_PRIORITY, secureRandom);
            return bwh.O000000o(instance.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String O000000o(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = (4 - i2) - 1;
            cArr[i3] = (char) ((i >>> (i2 * 8)) & 255);
            char c = cArr[i3];
            String str = " ";
            for (int i4 = 0; i4 < 32; i4++) {
                str = str + (((Integer.MIN_VALUE >>> i4) & c) >>> (31 - i4));
            }
        }
        return new String(cArr);
    }

    public static String O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String O000000o(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                sb.append(O000000o(O000000o(O00000Oo(iArr[i]), i)));
            }
        }
        return sb.toString();
    }

    private static byte[] O000000o(byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f13340O000000o);
            SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o(O00000Oo).getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int O00000Oo(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 15; i3++) {
            i2 = (i2 << 2) | 1;
        }
        return ((i & i2) << 1) | (((i2 << 1) & i) >>> 1);
    }

    public static String O00000Oo(String str) {
        try {
            return bwh.O000000o(O000000o(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] O00000Oo(byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f13340O000000o);
            SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o(O00000Oo).getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String O00000o0(String str) {
        try {
            return new String(O00000Oo(bwh.O000000o(str)), "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }
}
