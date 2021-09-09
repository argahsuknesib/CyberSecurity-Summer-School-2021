package _m_j;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ecd {
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ThreadLocal f15160O000000o = new eci();

    public static boolean O000000o(String str) {
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt != ' ' && charAt != 9 && charAt != 13 && charAt != 10) {
                    return false;
                }
            }
        }
        return true;
    }

    public static byte[] O000000o(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "".getBytes() : ebr.O000000o(bArr, "*7^%4)KIjh17sd98");
    }

    public static String O00000Oo(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }
}
