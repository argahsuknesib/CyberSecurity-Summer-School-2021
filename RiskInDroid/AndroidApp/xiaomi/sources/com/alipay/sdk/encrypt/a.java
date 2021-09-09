package com.alipay.sdk.encrypt;

import android.support.v4.app.NotificationCompat;

public final class a {
    private static final byte[] i = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
    private static final char[] j = new char[64];

    private static boolean a(char c) {
        return c == ' ' || c == 13 || c == 10 || c == 9;
    }

    private static boolean b(char c) {
        return c == '=';
    }

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            i[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            i[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            i[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            i[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = i;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            j[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            j[i2] = (char) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            j[i3] = (char) (i4 + 48);
            i3++;
            i4++;
        }
        char[] cArr = j;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private static boolean c(char c) {
        return c < 128 && i[c] != -1;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[((i2 != 0 ? i3 + 1 : i3) * 4)];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = i5 + 1;
            byte b = bArr[i5];
            int i8 = i7 + 1;
            byte b2 = bArr[i7];
            int i9 = i8 + 1;
            byte b3 = bArr[i8];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            byte b6 = (byte) ((b & Byte.MIN_VALUE) == 0 ? b >> 2 : (b >> 2) ^ 192);
            byte b7 = (byte) ((b2 & Byte.MIN_VALUE) == 0 ? b2 >> 4 : (b2 >> 4) ^ 240);
            int i10 = (b3 & Byte.MIN_VALUE) == 0 ? b3 >> 6 : (b3 >> 6) ^ 252;
            int i11 = i6 + 1;
            char[] cArr2 = j;
            cArr[i6] = cArr2[b6];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[(b5 << 4) | b7];
            int i13 = i12 + 1;
            cArr[i12] = cArr2[(b4 << 2) | ((byte) i10)];
            cArr[i13] = cArr2[b3 & 63];
            i4++;
            i6 = i13 + 1;
            i5 = i9;
        }
        if (i2 == 8) {
            byte b8 = bArr[i5];
            byte b9 = (byte) (b8 & 3);
            int i14 = (b8 & Byte.MIN_VALUE) == 0 ? b8 >> 2 : (b8 >> 2) ^ 192;
            int i15 = i6 + 1;
            char[] cArr3 = j;
            cArr[i6] = cArr3[(byte) i14];
            int i16 = i15 + 1;
            cArr[i15] = cArr3[b9 << 4];
            cArr[i16] = '=';
            cArr[i16 + 1] = '=';
        } else if (i2 == 16) {
            byte b10 = bArr[i5];
            byte b11 = bArr[i5 + 1];
            byte b12 = (byte) (b11 & 15);
            byte b13 = (byte) (b10 & 3);
            byte b14 = (byte) ((b10 & Byte.MIN_VALUE) == 0 ? b10 >> 2 : (b10 >> 2) ^ 192);
            int i17 = (b11 & Byte.MIN_VALUE) == 0 ? b11 >> 4 : (b11 >> 4) ^ 240;
            int i18 = i6 + 1;
            char[] cArr4 = j;
            cArr[i6] = cArr4[b14];
            int i19 = i18 + 1;
            cArr[i18] = cArr4[((byte) i17) | (b13 << 4)];
            cArr[i19] = cArr4[b12 << 2];
            cArr[i19 + 1] = '=';
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a2 = a(charArray);
        if (a2 % 4 != 0) {
            return null;
        }
        int i2 = a2 / 4;
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(i2 * 3)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2 - 1) {
            int i6 = i4 + 1;
            char c = charArray[i4];
            if (c(c)) {
                int i7 = i6 + 1;
                char c2 = charArray[i6];
                if (c(c2)) {
                    int i8 = i7 + 1;
                    char c3 = charArray[i7];
                    if (c(c3)) {
                        int i9 = i8 + 1;
                        char c4 = charArray[i8];
                        if (c(c4)) {
                            byte[] bArr2 = i;
                            byte b = bArr2[c];
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((b << 2) | (b2 >> 4));
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i5 = i11 + 1;
                            bArr[i11] = (byte) ((b3 << 6) | b4);
                            i3++;
                            i4 = i9;
                        }
                    }
                }
            }
            return null;
        }
        int i12 = i4 + 1;
        char c5 = charArray[i4];
        if (!c(c5)) {
            return null;
        }
        int i13 = i12 + 1;
        char c6 = charArray[i12];
        if (!c(c6)) {
            return null;
        }
        byte[] bArr3 = i;
        byte b5 = bArr3[c5];
        byte b6 = bArr3[c6];
        int i14 = i13 + 1;
        char c7 = charArray[i13];
        char c8 = charArray[i14];
        if (c(c7) && c(c8)) {
            byte[] bArr4 = i;
            byte b7 = bArr4[c7];
            byte b8 = bArr4[c8];
            int i15 = i5 + 1;
            bArr[i5] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr[i15] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
            bArr[i15 + 1] = (byte) (b8 | (b7 << 6));
            return bArr;
        } else if (!b(c7) || !b(c8)) {
            if (b(c7) || !b(c8)) {
                return null;
            }
            byte b9 = i[c7];
            if ((b9 & 3) != 0) {
                return null;
            }
            int i16 = i3 * 3;
            byte[] bArr5 = new byte[(i16 + 2)];
            System.arraycopy(bArr, 0, bArr5, 0, i16);
            bArr5[i5] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr5[i5 + 1] = (byte) (((b9 >> 2) & 15) | ((b6 & 15) << 4));
            return bArr5;
        } else if ((b6 & 15) != 0) {
            return null;
        } else {
            int i17 = i3 * 3;
            byte[] bArr6 = new byte[(i17 + 1)];
            System.arraycopy(bArr, 0, bArr6, 0, i17);
            bArr6[i5] = (byte) ((b5 << 2) | (b6 >> 4));
            return bArr6;
        }
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!a(cArr[i3])) {
                cArr[i2] = cArr[i3];
                i2++;
            }
        }
        return i2;
    }
}
