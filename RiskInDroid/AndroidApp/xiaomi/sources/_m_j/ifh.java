package _m_j;

public final class ifh {
    public static int O000000o(int[] iArr, int i, boolean z) {
        int[] iArr2 = iArr;
        int i2 = i;
        int length = iArr2.length;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int i5 = i3;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = length - 1;
            if (i6 >= i9) {
                return i7;
            }
            int i10 = 1 << i6;
            int i11 = i8 | i10;
            int i12 = i7;
            int i13 = 1;
            while (i13 < iArr2[i6]) {
                int i14 = i5 - i13;
                int i15 = length - i6;
                int i16 = i15 - 2;
                int O000000o2 = O000000o(i14 - 1, i16);
                if (z && i11 == 0) {
                    int i17 = i15 - 1;
                    if (i14 - i17 >= i17) {
                        O000000o2 -= O000000o(i14 - i15, i16);
                    }
                }
                if (i15 - 1 > 1) {
                    int i18 = 0;
                    for (int i19 = i14 - i16; i19 > i2; i19--) {
                        i18 += O000000o((i14 - i19) - 1, i15 - 3);
                    }
                    O000000o2 -= i18 * (i9 - i6);
                } else if (i14 > i2) {
                    O000000o2--;
                }
                i12 += O000000o2;
                i13++;
                i11 &= i10 ^ -1;
                iArr2 = iArr;
            }
            i5 -= i13;
            i6++;
            iArr2 = iArr;
            i7 = i12;
            i8 = i11;
        }
    }

    private static int O000000o(int i, int i2) {
        int i3 = i - i2;
        if (i3 > i2) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i > i2) {
            i5 *= i;
            if (i6 <= i3) {
                i5 /= i6;
                i6++;
            }
            i--;
        }
        while (i6 <= i3) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }
}
