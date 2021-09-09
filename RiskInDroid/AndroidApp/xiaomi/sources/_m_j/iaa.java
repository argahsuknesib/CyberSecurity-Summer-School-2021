package _m_j;

import android.support.v4.app.NotificationCompat;

public final class iaa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f1066O000000o = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] O00000Oo = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];

    static {
        for (int i = 0; i < 128; i++) {
            O00000Oo[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            O00000Oo[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            O00000Oo[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            O00000Oo[i4] = (byte) ((i4 - 48) + 52);
        }
        byte[] bArr = O00000Oo;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] O000000o(byte[] bArr) {
        byte[] bArr2;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length % 3;
        if (length == 0) {
            bArr2 = new byte[((bArr.length * 4) / 3)];
        } else {
            bArr2 = new byte[(((bArr.length / 3) + 1) * 4)];
        }
        int length2 = bArr.length - length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            byte b = bArr[i] & 255;
            byte b2 = bArr[i + 1] & 255;
            byte b3 = bArr[i + 2] & 255;
            byte[] bArr3 = f1066O000000o;
            bArr2[i2] = bArr3[(b >>> 2) & 63];
            bArr2[i2 + 1] = bArr3[((b << 4) | (b2 >>> 4)) & 63];
            bArr2[i2 + 2] = bArr3[((b2 << 2) | (b3 >>> 6)) & 63];
            bArr2[i2 + 3] = bArr3[b3 & 63];
            i += 3;
            i2 += 4;
        }
        if (length != 0) {
            if (length == 1) {
                byte b4 = bArr[bArr.length - 1] & 255;
                byte[] bArr4 = f1066O000000o;
                bArr2[bArr2.length - 4] = bArr4[(b4 >>> 2) & 63];
                bArr2[bArr2.length - 3] = bArr4[(b4 << 4) & 63];
                bArr2[bArr2.length - 2] = 61;
                bArr2[bArr2.length - 1] = 61;
            } else if (length == 2) {
                byte b5 = bArr[bArr.length - 2] & 255;
                byte b6 = bArr[bArr.length - 1] & 255;
                byte[] bArr5 = f1066O000000o;
                bArr2[bArr2.length - 4] = bArr5[(b5 >>> 2) & 63];
                bArr2[bArr2.length - 3] = bArr5[((b5 << 4) | (b6 >>> 4)) & 63];
                bArr2[bArr2.length - 2] = bArr5[(b6 << 2) & 63];
                bArr2[bArr2.length - 1] = 61;
            }
        }
        return bArr2;
    }
}
