package _m_j;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class grw {
    public static String O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(O00000o0(str));
            return String.format("%1$040X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String O00000Oo(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(O00000o0(str));
            return String.format("%1$040X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] O00000o0(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }
}
