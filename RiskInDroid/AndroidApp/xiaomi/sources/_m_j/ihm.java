package _m_j;

final class ihm {
    static boolean O000000o(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean O000000o(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }

    static int O000000o(ihk ihk, boolean z) {
        int i;
        int i2;
        if (z) {
            i = ihk.O00000o0;
        } else {
            i = ihk.O00000Oo;
        }
        if (z) {
            i2 = ihk.O00000Oo;
        } else {
            i2 = ihk.O00000o0;
        }
        byte[][] bArr = ihk.f1297O000000o;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3;
            int i6 = 0;
            byte b = -1;
            for (int i7 = 0; i7 < i2; i7++) {
                byte b2 = z ? bArr[i4][i7] : bArr[i7][i4];
                if (b2 == b) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i5 += (i6 - 5) + 3;
                    }
                    i6 = 1;
                    b = b2;
                }
            }
            if (i6 >= 5) {
                i5 += (i6 - 5) + 3;
            }
            i3 = i5;
        }
        return i3;
    }
}
