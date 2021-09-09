package _m_j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class dvs {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f14977O000000o = {"java.lang.OutOfMemoryError", "No space left on device"};

    private static String O00000Oo(String str) {
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
            throw new RuntimeException("NoSuchAlgorithmException", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UnsupportedEncodingException", e2);
        }
    }

    public static String O000000o(String str) {
        String[] split = str.replaceAll("\\t", "").split("\\n");
        StringBuilder sb = new StringBuilder();
        int min = Math.min(split.length, 20);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            split[i2] = split[i2].replaceAll("((java:)|(length=)|(index=)|(Index:)|(Size:))\\d+", "$1XX").replaceAll("\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}|@[0-9a-fA-F]{1,10}|0x[0-9a-fA-F]{1,10}", "XX").replaceAll("\\d+[B,KB,MB]*", "");
        }
        while (i < min && (!split[i].contains("...") || !split[i].contains("more"))) {
            sb.append(split[i]);
            sb.append(10);
            i++;
        }
        return O00000Oo(sb.toString());
    }
}
