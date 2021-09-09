package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import java.util.Map;

public final class ies extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[][] f1245O000000o = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private static final int[] O00000Oo = {6, 8, 10, 12, 14};
    private static final int[] O00000o = {1, 1, 1, 1};
    private static final int[] O00000oO = {1, 1, 3};
    private int O00000o0 = -1;

    private static void O000000o(idl idl, int i, int i2, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            O000000o(idl, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (O000000o(iArr2) + 48));
            sb.append((char) (O000000o(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    private void O000000o(idl idl, int i) throws NotFoundException {
        int i2 = this.O00000o0 * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i - 1;
        while (i2 > 0 && i3 >= 0 && !idl.O000000o(i3)) {
            i2--;
            i3--;
        }
        if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int[] O00000Oo(idl idl) throws NotFoundException {
        idl.O00000o0();
        try {
            int[] O00000o02 = O00000o0(idl, O000000o(idl), O00000oO);
            O000000o(idl, O00000o02[0]);
            int i = O00000o02[0];
            O00000o02[0] = idl.O00000Oo - O00000o02[1];
            O00000o02[1] = idl.O00000Oo - i;
            return O00000o02;
        } finally {
            idl.O00000o0();
        }
    }

    private static int[] O00000o0(idl idl, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = idl.O00000Oo;
        int i3 = i;
        boolean z = false;
        int i4 = 0;
        while (i < i2) {
            if (idl.O000000o(i) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else if (O000000o(iArr2, iArr, 0.78f) < 0.38f) {
                    return new int[]{i3, i};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int O000000o(int[] iArr) throws NotFoundException {
        int length = f1245O000000o.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float O000000o2 = O000000o(iArr, f1245O000000o[i2], 0.78f);
            if (O000000o2 < f) {
                i = i2;
                f = O000000o2;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z;
        int[] O00000o02 = O00000o0(idl, O000000o(idl), O00000o);
        this.O00000o0 = (O00000o02[1] - O00000o02[0]) / 4;
        O000000o(idl, O00000o02[0]);
        int[] O00000Oo2 = O00000Oo(idl);
        StringBuilder sb = new StringBuilder(20);
        O000000o(idl, O00000o02[1], O00000Oo2[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = O00000Oo;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (z) {
            float f = (float) i;
            return new idf(sb2, null, new idg[]{new idg((float) O00000o02[1], f), new idg((float) O00000Oo2[0], f)}, BarcodeFormat.ITF);
        }
        throw FormatException.getFormatInstance();
    }

    private static int O000000o(idl idl) throws NotFoundException {
        int i = idl.O00000Oo;
        int O00000o02 = idl.O00000o0(0);
        if (O00000o02 != i) {
            return O00000o02;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
