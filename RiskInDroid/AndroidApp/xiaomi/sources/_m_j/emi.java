package _m_j;

import android.support.v4.app.NotificationCompat;

public final class emi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15630O000000o = System.getProperty("line.separator");
    private static char[] O00000Oo = new char[64];
    private static byte[] O00000o0 = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            O00000Oo[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            O00000Oo[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            O00000Oo[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char[] cArr = O00000Oo;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        int i2 = 0;
        while (true) {
            byte[] bArr = O00000o0;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            O00000o0[O00000Oo[i3]] = (byte) i3;
        }
    }

    public static String O000000o(String str) {
        return new String(O000000o(str.getBytes()));
    }

    public static char[] O000000o(byte[] bArr) {
        return O000000o(bArr, bArr.length);
    }

    private static char[] O000000o(byte[] bArr, int i) {
        int i2;
        byte b;
        int i3;
        byte b2;
        int i4 = ((i * 4) + 2) / 3;
        char[] cArr = new char[(((i + 2) / 3) * 4)];
        int i5 = i + 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = i6 + 1;
            byte b3 = bArr[i6] & 255;
            if (i8 < i5) {
                i2 = i8 + 1;
                b = bArr[i8] & 255;
            } else {
                i2 = i8;
                b = 0;
            }
            if (i2 < i5) {
                i3 = i2 + 1;
                b2 = bArr[i2] & 255;
            } else {
                i3 = i2;
                b2 = 0;
            }
            int i9 = b3 >>> 2;
            int i10 = ((b3 & 3) << 4) | (b >>> 4);
            int i11 = ((b & 15) << 2) | (b2 >>> 6);
            byte b4 = b2 & 63;
            int i12 = i7 + 1;
            char[] cArr2 = O00000Oo;
            cArr[i7] = cArr2[i9];
            int i13 = i12 + 1;
            cArr[i12] = cArr2[i10];
            char c = '=';
            cArr[i13] = i13 < i4 ? cArr2[i11] : '=';
            int i14 = i13 + 1;
            if (i14 < i4) {
                c = O00000Oo[b4];
            }
            cArr[i14] = c;
            i7 = i14 + 1;
            i6 = i3;
        }
        return cArr;
    }

    public static byte[] O00000Oo(String str) {
        int i;
        char c;
        int i2;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        if (length % 4 == 0) {
            while (length > 0 && charArray[(length + 0) - 1] == '=') {
                length--;
            }
            int i3 = (length * 3) / 4;
            byte[] bArr = new byte[i3];
            int i4 = length + 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6 = i) {
                int i7 = i6 + 1;
                char c2 = charArray[i6];
                int i8 = i7 + 1;
                char c3 = charArray[i7];
                char c4 = 'A';
                if (i8 < i4) {
                    i = i8 + 1;
                    c = charArray[i8];
                } else {
                    i = i8;
                    c = 'A';
                }
                if (i < i4) {
                    char c5 = charArray[i];
                    i++;
                    c4 = c5;
                }
                if (c2 > 127 || c3 > 127 || c > 127 || c4 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = O00000o0;
                byte b = bArr2[c2];
                byte b2 = bArr2[c3];
                byte b3 = bArr2[c];
                byte b4 = bArr2[c4];
                if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i9 = (b << 2) | (b2 >>> 4);
                int i10 = ((b2 & 15) << 4) | (b3 >>> 2);
                byte b5 = ((b3 & 3) << 6) | b4;
                int i11 = i5 + 1;
                bArr[i5] = (byte) i9;
                if (i11 < i3) {
                    i2 = i11 + 1;
                    bArr[i11] = (byte) i10;
                } else {
                    i2 = i11;
                }
                if (i2 < i3) {
                    i5 = i2 + 1;
                    bArr[i2] = (byte) b5;
                } else {
                    i5 = i2;
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
}
