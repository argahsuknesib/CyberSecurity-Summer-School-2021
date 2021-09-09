package _m_j;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class bwn {
    public static PublicKey O000000o(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bwh.O000000o(str)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }

    public static byte[] O000000o(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
