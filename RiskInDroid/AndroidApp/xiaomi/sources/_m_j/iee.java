package _m_j;

import _m_j.ieg;

final class iee {

    /* renamed from: O000000o  reason: collision with root package name */
    final int f1229O000000o;
    final byte[] O00000Oo;

    private iee(int i, byte[] bArr) {
        this.f1229O000000o = i;
        this.O00000Oo = bArr;
    }

    static iee[] O000000o(byte[] bArr, ieg ieg) {
        ieg.O00000Oo o00000Oo = ieg.O00000oo;
        ieg.O000000o[] o000000oArr = o00000Oo.O00000Oo;
        int i = 0;
        for (ieg.O000000o o000000o : o000000oArr) {
            i += o000000o.f1232O000000o;
        }
        iee[] ieeArr = new iee[i];
        int length = o000000oArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            ieg.O000000o o000000o2 = o000000oArr[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < o000000o2.f1232O000000o) {
                int i6 = o000000o2.O00000Oo;
                ieeArr[i4] = new iee(i6, new byte[(o00000Oo.f1233O000000o + i6)]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = ieeArr[0].O00000Oo.length - o00000Oo.f1233O000000o;
        int i7 = length2 - 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i9;
            int i11 = 0;
            while (i11 < i3) {
                ieeArr[i11].O00000Oo[i8] = bArr[i10];
                i11++;
                i10++;
            }
            i8++;
            i9 = i10;
        }
        boolean z = ieg.f1231O000000o == 24;
        int i12 = z ? 8 : i3;
        int i13 = i9;
        int i14 = 0;
        while (i14 < i12) {
            ieeArr[i14].O00000Oo[i7] = bArr[i13];
            i14++;
            i13++;
        }
        int length3 = ieeArr[0].O00000Oo.length;
        while (length2 < length3) {
            int i15 = 0;
            while (i15 < i3) {
                int i16 = z ? (i15 + 8) % i3 : i15;
                ieeArr[i16].O00000Oo[(!z || i16 <= 7) ? length2 : length2 - 1] = bArr[i13];
                i15++;
                i13++;
            }
            length2++;
        }
        if (i13 == bArr.length) {
            return ieeArr;
        }
        throw new IllegalArgumentException();
    }
}
