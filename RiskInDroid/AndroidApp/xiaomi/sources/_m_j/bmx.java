package _m_j;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class bmx {
    public static String O000000o(String str, byte[] bArr) {
        try {
            return new String(O00000Oo(str, bArr), "utf-8");
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static String O000000o(String str, byte[] bArr, int i) {
        try {
            return new String(O00000Oo(str, bArr, i), "utf-8");
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private static byte[] O00000Oo(String str, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(2, new SecretKeySpec(str.getBytes("utf-8"), "DES"));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static byte[] O00000Oo(String str, byte[] bArr, int i) {
        try {
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(2, new SecretKeySpec(str.getBytes("utf-8"), "DES"));
            byte[] doFinal = instance.doFinal(bArr);
            byte[] bArr2 = new byte[i];
            System.arraycopy(doFinal, 0, bArr2, 0, i);
            return bArr2;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
