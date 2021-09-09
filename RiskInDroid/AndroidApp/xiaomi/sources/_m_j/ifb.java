package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;

public final class ifb extends ifa {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[] f1254O000000o = {56, 52, 50, 49, 44, 38, 35, 42, 41, 37};
    private static final int[] O0000O0o = {1, 1, 1, 1, 1, 1};
    private static final int[][] O0000OOo = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] O0000Oo0 = new int[4];

    /* access modifiers changed from: protected */
    public final int O000000o(idl idl, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.O0000Oo0;
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
        for (int i7 = 0; i7 <= 1; i7++) {
            for (int i8 = 0; i8 < 10; i8++) {
                if (i4 == O0000OOo[i7][i8]) {
                    sb.insert(0, (char) (i7 + 48));
                    sb.append((char) (i8 + 48));
                    return i2;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[]
     arg types: [_m_j.idl, int, int, int[]]
     candidates:
      _m_j.ifa.O000000o(_m_j.idl, int[], int, int[][]):int
      _m_j.ifa.O000000o(int, _m_j.idl, int[], java.util.Map<com.xiaomi.zxing.DecodeHintType, ?>):_m_j.idf
      _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[] */
    /* access modifiers changed from: protected */
    public final int[] O000000o(idl idl, int i) throws NotFoundException {
        return O000000o(idl, i, true, O0000O0o);
    }

    /* access modifiers changed from: package-private */
    public final BarcodeFormat O00000Oo() {
        return BarcodeFormat.UPC_E;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(String str) throws FormatException {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        sb.append(str.charAt(7));
        return super.O000000o(sb.toString());
    }
}
