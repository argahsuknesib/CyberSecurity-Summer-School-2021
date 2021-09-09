package _m_j;

import android.support.v4.app.NotificationCompat;

final class dwo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f15004O000000o = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
    private static final char[] O00000Oo = new char[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f15004O000000o[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f15004O000000o[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f15004O000000o[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f15004O000000o[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f15004O000000o;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            O00000Oo[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            O00000Oo[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            O00000Oo[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = O00000Oo;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static String O000000o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[((i != 0 ? i2 + 1 : i2) * 4)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            byte b = bArr[i4];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            byte b6 = (byte) ((b & Byte.MIN_VALUE) == 0 ? b >> 2 : (b >> 2) ^ 192);
            byte b7 = (byte) ((b2 & Byte.MIN_VALUE) == 0 ? b2 >> 4 : (b2 >> 4) ^ 240);
            int i9 = (b3 & Byte.MIN_VALUE) == 0 ? b3 >> 6 : (b3 >> 6) ^ 252;
            int i10 = i5 + 1;
            char[] cArr2 = O00000Oo;
            cArr[i5] = cArr2[b6];
            int i11 = i10 + 1;
            cArr[i10] = cArr2[(b5 << 4) | b7];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[(b4 << 2) | ((byte) i9)];
            cArr[i12] = cArr2[b3 & 63];
            i3++;
            i5 = i12 + 1;
            i4 = i8;
        }
        if (i == 8) {
            byte b8 = bArr[i4];
            byte b9 = (byte) (b8 & 3);
            int i13 = (b8 & Byte.MIN_VALUE) == 0 ? b8 >> 2 : (b8 >> 2) ^ 192;
            int i14 = i5 + 1;
            char[] cArr3 = O00000Oo;
            cArr[i5] = cArr3[(byte) i13];
            int i15 = i14 + 1;
            cArr[i14] = cArr3[b9 << 4];
            cArr[i15] = '=';
            cArr[i15 + 1] = '=';
        } else if (i == 16) {
            byte b10 = bArr[i4];
            byte b11 = bArr[i4 + 1];
            byte b12 = (byte) (b11 & 15);
            byte b13 = (byte) (b10 & 3);
            byte b14 = (byte) ((b10 & Byte.MIN_VALUE) == 0 ? b10 >> 2 : (b10 >> 2) ^ 192);
            int i16 = (b11 & Byte.MIN_VALUE) == 0 ? b11 >> 4 : (b11 >> 4) ^ 240;
            int i17 = i5 + 1;
            char[] cArr4 = O00000Oo;
            cArr[i5] = cArr4[b14];
            int i18 = i17 + 1;
            cArr[i17] = cArr4[((byte) i16) | (b13 << 4)];
            cArr[i18] = cArr4[b12 << 2];
            cArr[i18 + 1] = '=';
        }
        return new String(cArr);
    }
}
