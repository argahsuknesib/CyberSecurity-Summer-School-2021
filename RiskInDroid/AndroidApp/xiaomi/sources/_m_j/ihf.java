package _m_j;

import java.util.ArrayList;
import java.util.List;

final class ihf {

    /* renamed from: O000000o  reason: collision with root package name */
    final idm f1293O000000o;
    final List<ihe> O00000Oo = new ArrayList(5);
    final int O00000o;
    final int O00000o0;
    final int O00000oO;
    final int O00000oo;
    private final float O0000O0o;
    private final int[] O0000OOo;
    private final idh O0000Oo0;

    ihf(idm idm, int i, int i2, int i3, int i4, float f, idh idh) {
        this.f1293O000000o = idm;
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = i3;
        this.O00000oo = i4;
        this.O0000O0o = f;
        this.O0000OOo = new int[3];
        this.O0000Oo0 = idh;
    }

    private static float O000000o(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int[] iArr) {
        float f = this.O0000O0o;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0100 A[SYNTHETIC] */
    public final ihe O000000o(int[] iArr, int i, int i2) {
        boolean z;
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float O000000o2 = O000000o(iArr, i2);
        int i4 = (int) O000000o2;
        int i5 = iArr[1] * 2;
        idm idm = this.f1293O000000o;
        int i6 = idm.O00000Oo;
        int[] iArr2 = this.O0000OOo;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        int i7 = i;
        while (i7 >= 0 && idm.O000000o(i4, i7) && iArr2[1] <= i5) {
            iArr2[1] = iArr2[1] + 1;
            i7--;
        }
        float f = Float.NaN;
        if (i7 >= 0 && iArr2[1] <= i5) {
            while (i7 >= 0 && !idm.O000000o(i4, i7) && iArr2[0] <= i5) {
                iArr2[0] = iArr2[0] + 1;
                i7--;
            }
            if (iArr2[0] <= i5) {
                int i8 = i + 1;
                while (i8 < i6 && idm.O000000o(i4, i8) && iArr2[1] <= i5) {
                    iArr2[1] = iArr2[1] + 1;
                    i8++;
                }
                if (i8 != i6 && iArr2[1] <= i5) {
                    while (i8 < i6 && !idm.O000000o(i4, i8) && iArr2[2] <= i5) {
                        iArr2[2] = iArr2[2] + 1;
                        i8++;
                    }
                    if (iArr2[2] <= i5 && Math.abs(((iArr2[0] + iArr2[1]) + iArr2[2]) - i3) * 5 < i3 * 2 && O000000o(iArr2)) {
                        f = O000000o(iArr2, i8);
                    }
                }
            }
        }
        if (Float.isNaN(f)) {
            return null;
        }
        float f2 = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (ihe next : this.O00000Oo) {
            if (Math.abs(f - next.O00000Oo) <= f2 && Math.abs(O000000o2 - next.f1209O000000o) <= f2) {
                float abs = Math.abs(f2 - next.O00000o0);
                if (abs <= 1.0f || abs <= next.O00000o0) {
                    z = true;
                    continue;
                    if (z) {
                        return new ihe((next.f1209O000000o + O000000o2) / 2.0f, (next.O00000Oo + f) / 2.0f, (next.O00000o0 + f2) / 2.0f);
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        ihe ihe = new ihe(O000000o2, f, f2);
        this.O00000Oo.add(ihe);
        idh idh = this.O0000Oo0;
        if (idh == null) {
            return null;
        }
        idh.O000000o(ihe);
        return null;
    }
}
