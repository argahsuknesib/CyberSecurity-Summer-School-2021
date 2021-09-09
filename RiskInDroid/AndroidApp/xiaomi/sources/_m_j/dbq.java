package _m_j;

public final class dbq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static char[] f14458O000000o = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] O00000Oo = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            O00000Oo[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            O00000Oo[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            O00000Oo[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            O00000Oo[i4] = (byte) ((i4 + 52) - 48);
        }
        byte[] bArr = O00000Oo;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] O000000o(byte[] bArr) {
        boolean z;
        byte[] bArr2 = new byte[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                z = true;
            } else {
                z = false;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 < bArr.length) {
                i5 |= bArr[i6] & 255;
            } else {
                z2 = false;
            }
            int i7 = 64;
            bArr2[i2 + 3] = (byte) f14458O000000o[z2 ? i5 & 63 : 64];
            int i8 = i5 >> 6;
            int i9 = i2 + 2;
            char[] cArr = f14458O000000o;
            if (z) {
                i7 = i8 & 63;
            }
            bArr2[i9] = (byte) cArr[i7];
            int i10 = i8 >> 6;
            char[] cArr2 = f14458O000000o;
            bArr2[i2 + 1] = (byte) cArr2[i10 & 63];
            bArr2[i2 + 0] = (byte) cArr2[(i10 >> 6) & 63];
            i += 3;
            i2 += 4;
        }
        return bArr2;
    }
}
