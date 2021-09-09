package _m_j;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class grx {
    public static byte[] O000000o(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(bArr);
        return instance.digest();
    }
}
