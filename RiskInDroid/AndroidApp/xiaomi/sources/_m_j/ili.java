package _m_j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ili {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f1439O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static MessageDigest O00000Oo(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String O00000Oo(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = f1439O000000o;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    private static byte[] O00000o0(byte[] bArr) {
        return O00000Oo("MD5").digest(bArr);
    }

    public static String O000000o(String str) {
        return O00000Oo(O00000o0(O00000o0(str)));
    }

    public static String O000000o(byte[] bArr) {
        return O00000Oo(O00000o0(bArr));
    }

    private static byte[] O00000o0(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
