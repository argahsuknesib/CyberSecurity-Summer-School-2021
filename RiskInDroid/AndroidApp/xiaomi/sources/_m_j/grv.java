package _m_j;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class grv {
    public static String O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(O00000Oo(str));
            return String.format("%1$032X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] O00000Oo(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O000000o(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return String.format("%32s", new BigInteger(1, instance.digest()).toString(16)).replace(' ', '0');
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
