package _m_j;

import android.util.Base64;

public final class dlq {
    /* JADX WARN: Type inference failed for: r8v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r6v2, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static byte[] O000000o(byte[] bArr, byte[] r8) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = r8.length;
        if (length <= 0 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        for (int i = 0; i < 256; i++) {
            iArr[i] = i;
            iArr2[i] = r8[i % length];
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + iArr[i3] + iArr2[i3]) & 255;
            int i4 = iArr[i3];
            iArr[i3] = iArr[i2];
            iArr[i2] = i4;
        }
        byte[] bArr2 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i5 = (i5 + 1) & 255;
            i6 = (i6 + iArr[i5]) & 255;
            int i8 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i8;
            bArr2[i7] = (byte) (iArr[(iArr[i5] + iArr[i6]) & 255] ^ bArr[i7]);
        }
        return bArr2;
    }

    public static byte[] O000000o(byte[] bArr) {
        return O000000o(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }

    public static byte[] O00000Oo(byte[] bArr) {
        return O000000o(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }
}
