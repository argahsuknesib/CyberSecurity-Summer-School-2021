package _m_j;

import android.util.Base64;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class djj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f14719O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String O000000o(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            diz.O00000Oo("DESUtils", "encryptAES", e);
            return null;
        }
    }

    public static byte[] O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            return instance.digest();
        } catch (Exception e) {
            diz.O00000Oo("DESUtils", "encryptSha", e);
            return null;
        }
    }

    public static String O000000o(byte[] bArr) {
        char[] cArr = new char[32];
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f14719O000000o;
            cArr[i2 + 1] = cArr2[b & 15];
            cArr[i2] = cArr2[((byte) (b >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
