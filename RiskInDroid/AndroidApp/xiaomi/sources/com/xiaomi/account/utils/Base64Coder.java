package com.xiaomi.account.utils;

import android.support.v4.app.NotificationCompat;

public class Base64Coder {
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
    private static final String systemLineSeparator = System.getProperty("line.separator");

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            map1[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            map1[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            map1[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char[] cArr = map1;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        int i2 = 0;
        while (true) {
            byte[] bArr = map2;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            map2[map1[i3]] = (byte) i3;
        }
    }

    public static String encodeString(String str) {
        return new String(encode(str.getBytes()));
    }

    public static String encodeLines(byte[] bArr) {
        return encodeLines(bArr, 0, bArr.length, 76, systemLineSeparator);
    }

    public static String encodeLines(byte[] bArr, int i, int i2, int i3, String str) {
        int i4 = (i3 * 3) / 4;
        if (i4 > 0) {
            StringBuilder sb = new StringBuilder((((i2 + 2) / 3) * 4) + ((((i2 + i4) - 1) / i4) * str.length()));
            int i5 = 0;
            while (i5 < i2) {
                int min = Math.min(i2 - i5, i4);
                sb.append(encode(bArr, i + i5, min));
                sb.append(str);
                i5 += min;
            }
            return sb.toString();
        }
        throw new IllegalArgumentException();
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static char[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, i);
    }

    public static char[] encode(byte[] bArr, int i, int i2) {
        int i3;
        byte b;
        int i4;
        byte b2;
        int i5 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i6 = i2 + i;
        int i7 = 0;
        while (i < i6) {
            int i8 = i + 1;
            byte b3 = bArr[i] & 255;
            if (i8 < i6) {
                i3 = i8 + 1;
                b = bArr[i8] & 255;
            } else {
                i3 = i8;
                b = 0;
            }
            if (i3 < i6) {
                i4 = i3 + 1;
                b2 = bArr[i3] & 255;
            } else {
                i4 = i3;
                b2 = 0;
            }
            int i9 = b3 >>> 2;
            int i10 = ((b3 & 3) << 4) | (b >>> 4);
            int i11 = ((b & 15) << 2) | (b2 >>> 6);
            byte b4 = b2 & 63;
            int i12 = i7 + 1;
            char[] cArr2 = map1;
            cArr[i7] = cArr2[i9];
            int i13 = i12 + 1;
            cArr[i12] = cArr2[i10];
            char c = '=';
            cArr[i13] = i13 < i5 ? cArr2[i11] : '=';
            int i14 = i13 + 1;
            if (i14 < i5) {
                c = map1[b4];
            }
            cArr[i14] = c;
            i7 = i14 + 1;
            i = i4;
        }
        return cArr;
    }

    public static String decodeString(String str) {
        return new String(decode(str));
    }

    public static byte[] decodeLines(String str) {
        char[] cArr = new char[str.length()];
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (!(charAt == ' ' || charAt == 13 || charAt == 10 || charAt == 9)) {
                cArr[i] = charAt;
                i++;
            }
        }
        return decode(cArr, 0, i);
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static byte[] decode(char[] cArr) {
        return decode(cArr, 0, cArr.length);
    }

    public static byte[] decode(char[] cArr, int i, int i2) {
        int i3;
        char c;
        int i4;
        if (i2 % 4 == 0) {
            while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
                i2--;
            }
            int i5 = (i2 * 3) / 4;
            byte[] bArr = new byte[i5];
            int i6 = i2 + i;
            int i7 = 0;
            while (i < i6) {
                int i8 = i + 1;
                char c2 = cArr[i];
                int i9 = i8 + 1;
                char c3 = cArr[i8];
                char c4 = 'A';
                if (i9 < i6) {
                    i3 = i9 + 1;
                    c = cArr[i9];
                } else {
                    i3 = i9;
                    c = 'A';
                }
                if (i3 < i6) {
                    char c5 = cArr[i3];
                    i3++;
                    c4 = c5;
                }
                if (c2 > 127 || c3 > 127 || c > 127 || c4 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = map2;
                byte b = bArr2[c2];
                byte b2 = bArr2[c3];
                byte b3 = bArr2[c];
                byte b4 = bArr2[c4];
                if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i10 = (b << 2) | (b2 >>> 4);
                int i11 = ((b2 & 15) << 4) | (b3 >>> 2);
                byte b5 = ((b3 & 3) << 6) | b4;
                int i12 = i7 + 1;
                bArr[i7] = (byte) i10;
                if (i12 < i5) {
                    i4 = i12 + 1;
                    bArr[i12] = (byte) i11;
                } else {
                    i4 = i12;
                }
                if (i4 < i5) {
                    i7 = i4 + 1;
                    bArr[i4] = (byte) b5;
                } else {
                    i7 = i4;
                }
                i = i3;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    private Base64Coder() {
    }
}
