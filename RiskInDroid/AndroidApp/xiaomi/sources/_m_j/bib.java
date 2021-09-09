package _m_j;

import java.util.Arrays;

public final class bib {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final char[] f12987O000000o = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static final int[] O00000Oo;

    static {
        int[] iArr = new int[256];
        O00000Oo = iArr;
        Arrays.fill(iArr, -1);
        int length = f12987O000000o.length;
        for (int i = 0; i < length; i++) {
            O00000Oo[f12987O000000o[i]] = i;
        }
        O00000Oo[61] = 0;
    }

    public static final byte[] O000000o(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        while (i < i5 && O00000Oo[str.charAt(i)] < 0) {
            i++;
        }
        while (i5 > 0 && O00000Oo[str.charAt(i5)] < 0) {
            i5--;
        }
        int i6 = str.charAt(i5) == '=' ? str.charAt(i5 + -1) == '=' ? 2 : 1 : 0;
        int i7 = (i5 - i) + 1;
        if (i2 > 76) {
            i3 = (str.charAt(76) == 13 ? i7 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i8 = (((i7 - i3) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = i;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            int i13 = i10 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = (O00000Oo[str.charAt(i10)] << 18) | (O00000Oo[str.charAt(i13)] << 12) | (O00000Oo[str.charAt(i14)] << 6) | O00000Oo[str.charAt(i15)];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i3 <= 0 || (i12 = i12 + 1) != 19) {
                i10 = i16;
            } else {
                i10 = i16 + 2;
                i12 = 0;
            }
            i11 = i20;
        }
        if (i11 < i8) {
            int i21 = 0;
            while (i10 <= i5 - i6) {
                i4 |= O00000Oo[str.charAt(i10)] << (18 - (i21 * 6));
                i21++;
                i10++;
            }
            int i22 = 16;
            while (i11 < i8) {
                bArr[i11] = (byte) (i4 >> i22);
                i22 -= 8;
                i11++;
            }
        }
        return bArr;
    }
}
