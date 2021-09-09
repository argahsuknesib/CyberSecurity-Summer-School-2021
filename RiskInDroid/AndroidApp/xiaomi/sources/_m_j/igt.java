package _m_j;

import com.xiaomi.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class igt {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f1281O000000o = {0, 4, 1, 5};
    private static final int[] O00000Oo = {6, 2, 7, 3};
    private static final int[] O00000o = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static final int[] O00000o0 = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.igt.O000000o(boolean, _m_j.idm):java.util.List<_m_j.idg[]>
     arg types: [int, _m_j.idm]
     candidates:
      _m_j.igt.O000000o(int[], int[]):float
      _m_j.igt.O000000o(_m_j.icy, boolean):_m_j.igu
      _m_j.igt.O000000o(boolean, _m_j.idm):java.util.List<_m_j.idg[]> */
    public static igu O000000o(icy icy, boolean z) throws NotFoundException {
        idm O00000Oo2 = icy.O00000Oo();
        List<idg[]> O000000o2 = O000000o(false, O00000Oo2);
        if (O000000o2.isEmpty()) {
            O00000Oo2 = O00000Oo2.clone();
            int i = O00000Oo2.f1214O000000o;
            int i2 = O00000Oo2.O00000Oo;
            idl idl = new idl(i);
            idl idl2 = new idl(i);
            for (int i3 = 0; i3 < (i2 + 1) / 2; i3++) {
                idl = O00000Oo2.O000000o(i3, idl);
                int i4 = (i2 - 1) - i3;
                idl2 = O00000Oo2.O000000o(i4, idl2);
                idl.O00000o0();
                idl2.O00000o0();
                O00000Oo2.O00000Oo(i3, idl2);
                O00000Oo2.O00000Oo(i4, idl);
            }
            O000000o2 = O000000o(false, O00000Oo2);
        }
        return new igu(O00000Oo2, O000000o2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r4.hasNext() == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r5 = (_m_j.idg[]) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r5[1] == null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r3 = (int) java.lang.Math.max((float) r3, r5[1].O00000Oo);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r5[3] == null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].O00000Oo);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r5 == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r4 = r0.iterator();
     */
    private static List<idg[]> O000000o(boolean z, idm idm) {
        int i;
        float f;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        loop0:
        while (true) {
            int i3 = 0;
            boolean z2 = false;
            while (true) {
                if (i2 >= idm.O00000Oo) {
                    break loop0;
                }
                idg[] O000000o2 = O000000o(idm, i2, i3);
                if (O000000o2[0] != null || O000000o2[3] != null) {
                    arrayList.add(O000000o2);
                    if (!z) {
                        break loop0;
                    }
                    if (O000000o2[2] != null) {
                        i = (int) O000000o2[2].f1209O000000o;
                        f = O000000o2[2].O00000Oo;
                    } else {
                        i = (int) O000000o2[4].f1209O000000o;
                        f = O000000o2[4].O00000Oo;
                    }
                    i2 = (int) f;
                    i3 = i;
                    z2 = true;
                } else {
                    break;
                }
            }
            i2 += 5;
        }
        return arrayList;
    }

    private static void O000000o(idg[] idgArr, idg[] idgArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            idgArr[iArr[i]] = idgArr2[i];
        }
    }

    private static idg[] O000000o(idm idm, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        boolean z;
        int i6;
        int[] iArr2;
        int i7 = i;
        idg[] idgArr = new idg[4];
        int[] iArr3 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i7) {
                z = false;
                break;
            }
            int[] O000000o2 = O000000o(idm, i4, i8, i2, iArr, iArr3);
            if (O000000o2 != null) {
                while (true) {
                    iArr2 = O000000o2;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    O000000o2 = O000000o(idm, i4, i8, i2, iArr, iArr3);
                    if (O000000o2 == null) {
                        i8++;
                        break;
                    }
                }
                float f = (float) i8;
                idgArr[0] = new idg((float) iArr2[0], f);
                idgArr[1] = new idg((float) iArr2[1], f);
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i9 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) idgArr[0].f1209O000000o, (int) idgArr[1].f1209O000000o};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i7) {
                    i6 = i11;
                    break;
                }
                i6 = i11;
                int[] O000000o3 = O000000o(idm, iArr4[0], i10, i2, iArr, iArr3);
                if (O000000o3 == null || Math.abs(iArr4[0] - O000000o3[0]) >= 5 || Math.abs(iArr4[1] - O000000o3[1]) >= 5) {
                    if (i6 > 25) {
                        break;
                    }
                    i11 = i6 + 1;
                } else {
                    iArr4 = O000000o3;
                    i11 = 0;
                }
                i10++;
            }
            i9 = i10 - (i6 + 1);
            float f2 = (float) i9;
            idgArr[2] = new idg((float) iArr4[0], f2);
            idgArr[3] = new idg((float) iArr4[1], f2);
        }
        if (i9 - i8 < 10) {
            for (i5 = 0; i5 < 4; i5++) {
                idgArr[i5] = null;
            }
        }
        return idgArr;
    }

    private static int[] O000000o(idm idm, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i4 = 0;
        while (idm.O000000o(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (idm.O000000o(i, i2) ^ z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                int i8 = length - 1;
                if (i7 != i8) {
                    i7++;
                } else if (O000000o(iArr2, iArr) < 0.42f) {
                    return new int[]{i6, i};
                } else {
                    i6 += iArr2[0] + iArr2[1];
                    int i9 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || O000000o(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    private static float O000000o(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f = (float) i;
        float f2 = f / ((float) i2);
        float f3 = 0.8f * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f5 = ((float) iArr2[i4]) * f2;
            float f6 = (float) i5;
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }

    private static idg[] O000000o(idm idm, int i, int i2) {
        int i3 = idm.O00000Oo;
        int i4 = idm.f1214O000000o;
        idg[] idgArr = new idg[8];
        O000000o(idgArr, O000000o(idm, i3, i4, i, i2, O00000o0), f1281O000000o);
        if (idgArr[4] != null) {
            i2 = (int) idgArr[4].f1209O000000o;
            i = (int) idgArr[4].O00000Oo;
        }
        O000000o(idgArr, O000000o(idm, i3, i4, i, i2, O00000o), O00000Oo);
        return idgArr;
    }
}
