package _m_j;

import java.security.MessageDigest;

public final class dbu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f14460O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String O000000o(String str) {
        try {
            return O000000o(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O000000o(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            char[] cArr = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr[i] = f14460O000000o[(b >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = f14460O000000o[b & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
