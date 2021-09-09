package _m_j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class cnr implements cnp {
    public final String O000000o(String str) {
        return new BigInteger(O000000o(str.getBytes())).abs().toString(36);
    }

    private static byte[] O000000o(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            cou.O000000o(e);
            return null;
        }
    }
}
