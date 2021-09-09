package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.NotFoundException;

public final class iep extends ifa {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[] f1242O000000o = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] O0000O0o = new int[4];

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[]
     arg types: [_m_j.idl, int, int, int[]]
     candidates:
      _m_j.ifa.O000000o(_m_j.idl, int[], int, int[][]):int
      _m_j.ifa.O000000o(int, _m_j.idl, int[], java.util.Map<com.xiaomi.zxing.DecodeHintType, ?>):_m_j.idf
      _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[] */
    /* access modifiers changed from: protected */
    public final int O000000o(idl idl, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.O0000O0o;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = idl.O00000Oo;
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < i) {
            int O000000o2 = O000000o(idl, iArr2, i2, O00000oo);
            sb.append((char) ((O000000o2 % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (O000000o2 >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        for (int i7 = 0; i7 < 10; i7++) {
            if (i4 == f1242O000000o[i7]) {
                sb.insert(0, (char) (i7 + 48));
                int i8 = O000000o(idl, i2, true, O00000o0)[1];
                int i9 = 0;
                while (i9 < 6 && i8 < i) {
                    sb.append((char) (O000000o(idl, iArr2, i8, O00000oO) + 48));
                    int i10 = i8;
                    for (int i11 : iArr2) {
                        i10 += i11;
                    }
                    i9++;
                    i8 = i10;
                }
                return i8;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* access modifiers changed from: package-private */
    public final BarcodeFormat O00000Oo() {
        return BarcodeFormat.EAN_13;
    }
}
