package _m_j;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class emk {
    public static String O00000Oo(String str) {
        return O000000o(str).subSequence(8, 24).toString();
    }

    public static byte[] O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            for (int i = 0; i < digest.length; i++) {
                byte b = digest[i];
                int i2 = (b & Byte.MAX_VALUE) + (b < 0 ? (byte) 128 : 0);
                StringBuilder sb = new StringBuilder();
                sb.append(i2 < 16 ? "0" : "");
                sb.append(Integer.toHexString(i2).toLowerCase());
                stringBuffer.append(sb.toString());
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
