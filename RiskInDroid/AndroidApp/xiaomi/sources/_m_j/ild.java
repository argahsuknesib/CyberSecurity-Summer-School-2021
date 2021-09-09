package _m_j;

import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ild {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Charset f1434O000000o = Charset.forName("utf-8");

    private static byte[] O00000Oo(byte[] bArr, byte[] bArr2) {
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, new SecretKeySpec(bArr2, "AES"));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String O000000o(byte[] bArr, byte[] bArr2) {
        return new String(O00000Oo(bArr, bArr2));
    }
}
