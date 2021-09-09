package _m_j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class gpp {
    public static String O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                byte b = digest[i];
                int i2 = (b & Byte.MAX_VALUE) + (b < 0 ? (byte) 128 : 0);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i2 < 16 ? "0" : "");
                sb2.append(Integer.toHexString(i2).toLowerCase());
                sb.append(sb2.toString());
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String O00000Oo(String str) {
        return O000000o(str).subSequence(8, 24).toString();
    }
}
