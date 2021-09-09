package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.NotFoundException;

public final class ieq extends ifa {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int[] f1243O000000o = new int[4];

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[]
     arg types: [_m_j.idl, int, int, int[]]
     candidates:
      _m_j.ifa.O000000o(_m_j.idl, int[], int, int[][]):int
      _m_j.ifa.O000000o(int, _m_j.idl, int[], java.util.Map<com.xiaomi.zxing.DecodeHintType, ?>):_m_j.idf
      _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[] */
    /* access modifiers changed from: protected */
    public final int O000000o(idl idl, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f1243O000000o;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = idl.O00000Oo;
        int i2 = iArr[1];
        int i3 = 0;
        while (i3 < 4 && i2 < i) {
            sb.append((char) (O000000o(idl, iArr2, i2, O00000oO) + 48));
            int i4 = i2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            i3++;
            i2 = i4;
        }
        int i6 = O000000o(idl, i2, true, O00000o0)[1];
        int i7 = 0;
        while (i7 < 4 && i6 < i) {
            sb.append((char) (O000000o(idl, iArr2, i6, O00000oO) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public final BarcodeFormat O00000Oo() {
        return BarcodeFormat.EAN_8;
    }
}
