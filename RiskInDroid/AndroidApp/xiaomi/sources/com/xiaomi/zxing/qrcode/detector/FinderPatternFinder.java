package com.xiaomi.zxing.qrcode.detector;

import _m_j.idh;
import _m_j.idm;
import _m_j.ihh;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class FinderPatternFinder {

    /* renamed from: O000000o  reason: collision with root package name */
    public final idm f12119O000000o;
    public final List<ihh> O00000Oo = new ArrayList();
    private final int[] O00000o = new int[5];
    public boolean O00000o0;
    private final idh O00000oO;

    public FinderPatternFinder(idm idm, idh idh) {
        this.f12119O000000o = idm;
        this.O00000oO = idh;
    }

    private static float O000000o(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    public static boolean O000000o(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    private int[] O00000Oo() {
        int[] iArr = this.O00000o;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e7 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00e3 A[ADDED_TO_REGION, EDGE_INSN: B:93:0x00e3->B:64:0x00e3 ?: BREAK  , SYNTHETIC] */
    private boolean O000000o(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int[] O00000Oo2 = O00000Oo();
        int i13 = 0;
        while (i10 >= i13 && i11 >= i13 && this.f12119O000000o.O000000o(i11 - i13, i10 - i13)) {
            O00000Oo2[2] = O00000Oo2[2] + 1;
            i13++;
        }
        if (i10 >= i13 && i11 >= i13) {
            while (i10 >= i13 && i11 >= i13 && !this.f12119O000000o.O000000o(i11 - i13, i10 - i13) && O00000Oo2[1] <= i12) {
                O00000Oo2[1] = O00000Oo2[1] + 1;
                i13++;
            }
            if (i10 >= i13 && i11 >= i13 && O00000Oo2[1] <= i12) {
                while (i10 >= i13 && i11 >= i13 && this.f12119O000000o.O000000o(i11 - i13, i10 - i13) && O00000Oo2[0] <= i12) {
                    O00000Oo2[0] = O00000Oo2[0] + 1;
                    i13++;
                }
                if (O00000Oo2[0] > i12) {
                    return false;
                }
                int i14 = this.f12119O000000o.O00000Oo;
                int i15 = this.f12119O000000o.f1214O000000o;
                int i16 = 1;
                while (true) {
                    int i17 = i10 + i16;
                    if (i17 < i14 && (i9 = i11 + i16) < i15 && this.f12119O000000o.O000000o(i9, i17)) {
                        O00000Oo2[2] = O00000Oo2[2] + 1;
                        i16++;
                    } else if (i17 < i14 && i11 + i16 < i15) {
                        while (true) {
                            i5 = i10 + i16;
                            if (i5 < i14 && (i8 = i11 + i16) < i15 && !this.f12119O000000o.O000000o(i8, i5) && O00000Oo2[3] < i12) {
                                O00000Oo2[3] = O00000Oo2[3] + 1;
                                i16++;
                            } else if (i5 < i14 && i11 + i16 < i15 && O00000Oo2[3] < i12) {
                                while (true) {
                                    i6 = i10 + i16;
                                    if (i6 >= i14 && (i7 = i11 + i16) < i15 && this.f12119O000000o.O000000o(i7, i6) && O00000Oo2[4] < i12) {
                                        O00000Oo2[4] = O00000Oo2[4] + 1;
                                        i16++;
                                    }
                                }
                                if (O00000Oo2[4] >= i12 && Math.abs(((((O00000Oo2[0] + O00000Oo2[1]) + O00000Oo2[2]) + O00000Oo2[3]) + O00000Oo2[4]) - i4) < i4 * 2 && O000000o(O00000Oo2)) {
                                }
                            }
                        }
                        while (true) {
                            i6 = i10 + i16;
                            if (i6 >= i14) {
                                break;
                            }
                            break;
                            O00000Oo2[4] = O00000Oo2[4] + 1;
                            i16++;
                        }
                        return O00000Oo2[4] >= i12;
                    }
                }
                while (true) {
                    i5 = i10 + i16;
                    if (i5 < i14) {
                        break;
                    }
                    break;
                    O00000Oo2[3] = O00000Oo2[3] + 1;
                    i16++;
                }
                while (true) {
                    i6 = i10 + i16;
                    if (i6 >= i14) {
                    }
                    O00000Oo2[4] = O00000Oo2[4] + 1;
                    i16++;
                }
                if (O00000Oo2[4] >= i12) {
                }
            }
        }
        return false;
    }

    private float O00000Oo(int i, int i2, int i3, int i4) {
        idm idm = this.f12119O000000o;
        int i5 = idm.O00000Oo;
        int[] O00000Oo2 = O00000Oo();
        int i6 = i;
        while (i6 >= 0 && idm.O000000o(i2, i6)) {
            O00000Oo2[2] = O00000Oo2[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !idm.O000000o(i2, i6) && O00000Oo2[1] <= i3) {
            O00000Oo2[1] = O00000Oo2[1] + 1;
            i6--;
        }
        if (i6 >= 0 && O00000Oo2[1] <= i3) {
            while (i6 >= 0 && idm.O000000o(i2, i6) && O00000Oo2[0] <= i3) {
                O00000Oo2[0] = O00000Oo2[0] + 1;
                i6--;
            }
            if (O00000Oo2[0] > i3) {
                return Float.NaN;
            }
            int i7 = i + 1;
            while (i7 < i5 && idm.O000000o(i2, i7)) {
                O00000Oo2[2] = O00000Oo2[2] + 1;
                i7++;
            }
            if (i7 == i5) {
                return Float.NaN;
            }
            while (i7 < i5 && !idm.O000000o(i2, i7) && O00000Oo2[3] < i3) {
                O00000Oo2[3] = O00000Oo2[3] + 1;
                i7++;
            }
            if (i7 != i5 && O00000Oo2[3] < i3) {
                while (i7 < i5 && idm.O000000o(i2, i7) && O00000Oo2[4] < i3) {
                    O00000Oo2[4] = O00000Oo2[4] + 1;
                    i7++;
                }
                if (O00000Oo2[4] < i3 && Math.abs(((((O00000Oo2[0] + O00000Oo2[1]) + O00000Oo2[2]) + O00000Oo2[3]) + O00000Oo2[4]) - i4) * 5 < i4 * 2 && O000000o(O00000Oo2)) {
                    return O000000o(O00000Oo2, i7);
                }
            }
        }
        return Float.NaN;
    }

    private float O00000o0(int i, int i2, int i3, int i4) {
        idm idm = this.f12119O000000o;
        int i5 = idm.f1214O000000o;
        int[] O00000Oo2 = O00000Oo();
        int i6 = i;
        while (i6 >= 0 && idm.O000000o(i6, i2)) {
            O00000Oo2[2] = O00000Oo2[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !idm.O000000o(i6, i2) && O00000Oo2[1] <= i3) {
            O00000Oo2[1] = O00000Oo2[1] + 1;
            i6--;
        }
        if (i6 >= 0 && O00000Oo2[1] <= i3) {
            while (i6 >= 0 && idm.O000000o(i6, i2) && O00000Oo2[0] <= i3) {
                O00000Oo2[0] = O00000Oo2[0] + 1;
                i6--;
            }
            if (O00000Oo2[0] > i3) {
                return Float.NaN;
            }
            int i7 = i + 1;
            while (i7 < i5 && idm.O000000o(i7, i2)) {
                O00000Oo2[2] = O00000Oo2[2] + 1;
                i7++;
            }
            if (i7 == i5) {
                return Float.NaN;
            }
            while (i7 < i5 && !idm.O000000o(i7, i2) && O00000Oo2[3] < i3) {
                O00000Oo2[3] = O00000Oo2[3] + 1;
                i7++;
            }
            if (i7 != i5 && O00000Oo2[3] < i3) {
                while (i7 < i5 && idm.O000000o(i7, i2) && O00000Oo2[4] < i3) {
                    O00000Oo2[4] = O00000Oo2[4] + 1;
                    i7++;
                }
                if (O00000Oo2[4] < i3 && Math.abs(((((O00000Oo2[0] + O00000Oo2[1]) + O00000Oo2[2]) + O00000Oo2[3]) + O00000Oo2[4]) - i4) * 5 < i4 && O000000o(O00000Oo2)) {
                    return O000000o(O00000Oo2, i7);
                }
            }
        }
        return Float.NaN;
    }

    public boolean O000000o(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int O000000o2 = (int) O000000o(iArr, i2);
        float O00000Oo2 = O00000Oo(i, O000000o2, iArr[2], i3);
        if (!Float.isNaN(O00000Oo2)) {
            int i4 = (int) O00000Oo2;
            float O00000o02 = O00000o0(O000000o2, i4, iArr[2], i3);
            if (!Float.isNaN(O00000o02) && (!z || O000000o(i4, (int) O00000o02, iArr[2], i3))) {
                float f = ((float) i3) / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.O00000Oo.size()) {
                        break;
                    }
                    ihh ihh = this.O00000Oo.get(i5);
                    if (ihh.O000000o(f, O00000Oo2, O00000o02)) {
                        this.O00000Oo.set(i5, ihh.O00000Oo(O00000Oo2, O00000o02, f));
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    ihh ihh2 = new ihh(O00000o02, O00000Oo2, f);
                    this.O00000Oo.add(ihh2);
                    idh idh = this.O00000oO;
                    if (idh != null) {
                        idh.O000000o(ihh2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean O000000o() {
        int size = this.O00000Oo.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (ihh next : this.O00000Oo) {
            if (next.O00000o >= 2) {
                i++;
                f2 += next.O00000o0;
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (ihh ihh : this.O00000Oo) {
            f += Math.abs(ihh.O00000o0 - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    public static final class FurthestFromAverageComparator implements Serializable, Comparator<ihh> {
        private final float average;

        public /* synthetic */ FurthestFromAverageComparator(float f, byte b) {
            this(f);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            float abs = Math.abs(((ihh) obj2).O00000o0 - this.average);
            float abs2 = Math.abs(((ihh) obj).O00000o0 - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }
    }

    public static final class CenterComparator implements Serializable, Comparator<ihh> {
        private final float average;

        public /* synthetic */ CenterComparator(float f, byte b) {
            this(f);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            ihh ihh = (ihh) obj;
            ihh ihh2 = (ihh) obj2;
            if (ihh2.O00000o != ihh.O00000o) {
                return ihh2.O00000o - ihh.O00000o;
            }
            float abs = Math.abs(ihh2.O00000o0 - this.average);
            float abs2 = Math.abs(ihh.O00000o0 - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }

        private CenterComparator(float f) {
            this.average = f;
        }
    }
}
