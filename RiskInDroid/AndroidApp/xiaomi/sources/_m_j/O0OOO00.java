package _m_j;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class O0OOO00 {

    /* renamed from: O000000o  reason: collision with root package name */
    public final PublicKey f6671O000000o;

    public O0OOO00(InputStream inputStream) {
        this.f6671O000000o = (PublicKey) new ObjectInputStream(inputStream).readObject();
    }

    public static byte[] O000000o(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
