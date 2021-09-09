package _m_j;

import java.io.UnsupportedEncodingException;

public final class ijh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char f1362O000000o = ((char) Integer.parseInt("00000011", 2));
    private static final char O00000Oo = ((char) Integer.parseInt("00001111", 2));
    private static final char O00000o = ((char) Integer.parseInt("11111100", 2));
    private static final char O00000o0 = ((char) Integer.parseInt("00111111", 2));
    private static final char O00000oO = ((char) Integer.parseInt("11110000", 2));
    private static final char O00000oo = ((char) Integer.parseInt("11000000", 2));
    private static final char[] O0000O0o = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String O000000o(String str) throws UnsupportedEncodingException {
        return O000000o(str.getBytes("UTF-8"));
    }

    public static String O000000o(byte[] bArr) {
        int i;
        int i2;
        double length = (double) bArr.length;
        Double.isNaN(length);
        StringBuffer stringBuffer = new StringBuffer(((int) (length * 1.34d)) + 3);
        int i3 = 0;
        char c = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i3 %= 8;
            while (i3 < 8) {
                if (i3 == 0) {
                    i = ((char) (bArr[i4] & O00000o)) >>> 2;
                } else if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 == 6) {
                            c = (char) (((char) (bArr[i4] & f1362O000000o)) << 4);
                            int i5 = i4 + 1;
                            if (i5 < bArr.length) {
                                i2 = (bArr[i5] & O00000oO) >>> 4;
                            }
                        }
                        stringBuffer.append(O0000O0o[c]);
                        i3 += 6;
                    } else {
                        c = (char) (((char) (bArr[i4] & O00000Oo)) << 2);
                        int i6 = i4 + 1;
                        if (i6 < bArr.length) {
                            i2 = (bArr[i6] & O00000oo) >>> 6;
                        } else {
                            stringBuffer.append(O0000O0o[c]);
                            i3 += 6;
                        }
                    }
                    i = c | i2;
                } else {
                    i = bArr[i4] & O00000o0;
                }
                c = (char) i;
                stringBuffer.append(O0000O0o[c]);
                i3 += 6;
            }
        }
        if (stringBuffer.length() % 4 != 0) {
            for (int length2 = 4 - (stringBuffer.length() % 4); length2 > 0; length2--) {
                stringBuffer.append("=");
            }
        }
        return stringBuffer.toString();
    }
}
