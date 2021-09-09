package _m_j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class brp {
    public static String O000000o(String str) {
        if (str == null) {
            return null;
        }
        return brs.O00000oO(O00000o0(str));
    }

    public static String O000000o(byte[] bArr) {
        return brs.O00000oO(O000000o(bArr, "MD5"));
    }

    public static byte[] O000000o(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            bsc.O000000o(th, "MD5", "gmb");
            return null;
        }
    }

    static byte[] O00000Oo(String str) {
        try {
            return O00000o(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] O00000o(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(brs.O000000o(str));
        return instance.digest();
    }

    private static byte[] O00000o0(String str) {
        try {
            return O00000o(str);
        } catch (Throwable th) {
            bsc.O000000o(th, "MD5", "gmb");
            return new byte[0];
        }
    }
}
