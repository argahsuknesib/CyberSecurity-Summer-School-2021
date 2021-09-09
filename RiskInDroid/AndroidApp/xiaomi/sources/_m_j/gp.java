package _m_j;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class gp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Comparator<O0000O0o> f18102O000000o = new Comparator<O0000O0o>() {
        /* class _m_j.gp.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            O0000O0o o0000O0o = (O0000O0o) obj;
            O0000O0o o0000O0o2 = (O0000O0o) obj2;
            int i = o0000O0o.f18106O000000o - o0000O0o2.f18106O000000o;
            return i == 0 ? o0000O0o.O00000Oo - o0000O0o2.O00000Oo : i;
        }
    };

    public static abstract class O000000o {
        public abstract int O000000o();

        public abstract boolean O000000o(int i, int i2);

        public abstract int O00000Oo();

        public abstract boolean O00000Oo(int i, int i2);
    }

    public static O00000Oo O000000o(O000000o o000000o) {
        return O000000o(o000000o, true);
    }

    public static O00000Oo O000000o(O000000o o000000o, boolean z) {
        int O000000o2 = o000000o.O000000o();
        int O00000Oo2 = o000000o.O00000Oo();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new O00000o(O000000o2, O00000Oo2));
        int abs = Math.abs(O000000o2 - O00000Oo2) + O000000o2 + O00000Oo2;
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            O00000o o00000o = (O00000o) arrayList2.remove(arrayList2.size() - 1);
            O0000O0o O000000o3 = O000000o(o000000o, o00000o.f18104O000000o, o00000o.O00000Oo, o00000o.O00000o0, o00000o.O00000o, iArr, iArr2, abs);
            if (O000000o3 != null) {
                if (O000000o3.O00000o0 > 0) {
                    arrayList.add(O000000o3);
                }
                O000000o3.f18106O000000o += o00000o.f18104O000000o;
                O000000o3.O00000Oo += o00000o.O00000o0;
                O00000o o00000o2 = arrayList3.isEmpty() ? new O00000o() : (O00000o) arrayList3.remove(arrayList3.size() - 1);
                o00000o2.f18104O000000o = o00000o.f18104O000000o;
                o00000o2.O00000o0 = o00000o.O00000o0;
                if (O000000o3.O00000oO) {
                    o00000o2.O00000Oo = O000000o3.f18106O000000o;
                    o00000o2.O00000o = O000000o3.O00000Oo;
                } else if (O000000o3.O00000o) {
                    o00000o2.O00000Oo = O000000o3.f18106O000000o - 1;
                    o00000o2.O00000o = O000000o3.O00000Oo;
                } else {
                    o00000o2.O00000Oo = O000000o3.f18106O000000o;
                    o00000o2.O00000o = O000000o3.O00000Oo - 1;
                }
                arrayList2.add(o00000o2);
                if (!O000000o3.O00000oO) {
                    o00000o.f18104O000000o = O000000o3.f18106O000000o + O000000o3.O00000o0;
                    o00000o.O00000o0 = O000000o3.O00000Oo + O000000o3.O00000o0;
                } else if (O000000o3.O00000o) {
                    o00000o.f18104O000000o = O000000o3.f18106O000000o + O000000o3.O00000o0 + 1;
                    o00000o.O00000o0 = O000000o3.O00000Oo + O000000o3.O00000o0;
                } else {
                    o00000o.f18104O000000o = O000000o3.f18106O000000o + O000000o3.O00000o0;
                    o00000o.O00000o0 = O000000o3.O00000Oo + O000000o3.O00000o0 + 1;
                }
                arrayList2.add(o00000o);
            } else {
                arrayList3.add(o00000o);
            }
        }
        Collections.sort(arrayList, f18102O000000o);
        return new O00000Oo(o000000o, arrayList, iArr, iArr2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r1[r13 - 1] < r1[r13 + r7]) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        if (r2[r13 - 1] < r2[r13 + 1]) goto L_0x00c7;
     */
    private static O0000O0o O000000o(O000000o o000000o, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        int i11;
        O000000o o000000o2 = o000000o;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i12 = i2 - i;
        int i13 = i4 - i3;
        if (i12 <= 0 || i13 <= 0) {
            return null;
        }
        int i14 = i12 - i13;
        int i15 = 1;
        int i16 = ((i12 + i13) + 1) / 2;
        int i17 = (i5 - i16) - 1;
        int i18 = i5 + i16 + 1;
        Arrays.fill(iArr3, i17, i18, 0);
        Arrays.fill(iArr4, i17 + i14, i18 + i14, i12);
        boolean z3 = i14 % 2 != 0;
        int i19 = 0;
        while (i19 <= i16) {
            int i20 = -i19;
            int i21 = i20;
            while (i21 <= i19) {
                if (i21 != i20) {
                    if (i21 != i19) {
                        int i22 = i5 + i21;
                    }
                    i10 = iArr3[(i5 + i21) - i15] + i15;
                    z2 = true;
                    i11 = i10 - i21;
                    while (i10 < i12 && i11 < i13 && o000000o2.O000000o(i + i10, i3 + i11)) {
                        i10++;
                        i11++;
                    }
                    int i23 = i5 + i21;
                    iArr3[i23] = i10;
                    if (z3 || i21 < (i14 - i19) + 1 || i21 > (i14 + i19) - 1 || iArr3[i23] < iArr4[i23]) {
                        i21 += 2;
                        i15 = 1;
                    } else {
                        O0000O0o o0000O0o = new O0000O0o();
                        o0000O0o.f18106O000000o = iArr4[i23];
                        o0000O0o.O00000Oo = o0000O0o.f18106O000000o - i21;
                        o0000O0o.O00000o0 = iArr3[i23] - iArr4[i23];
                        o0000O0o.O00000o = z2;
                        o0000O0o.O00000oO = false;
                        return o0000O0o;
                    }
                }
                i10 = iArr3[i5 + i21 + i15];
                z2 = false;
                i11 = i10 - i21;
                while (i10 < i12) {
                    i10++;
                    i11++;
                }
                int i232 = i5 + i21;
                iArr3[i232] = i10;
                if (z3) {
                }
                i21 += 2;
                i15 = 1;
            }
            int i24 = i20;
            while (i24 <= i19) {
                int i25 = i24 + i14;
                if (i25 != i19 + i14) {
                    if (i25 != i20 + i14) {
                        int i26 = i5 + i25;
                        i9 = 1;
                    } else {
                        i9 = 1;
                    }
                    i6 = iArr4[(i5 + i25) + i9] - i9;
                    z = true;
                    i7 = i6 - i25;
                    while (true) {
                        if (i6 > 0 && i7 > 0) {
                            i8 = i12;
                            if (!o000000o2.O000000o((i + i6) - 1, (i3 + i7) - 1)) {
                                break;
                            }
                            i6--;
                            i7--;
                            i12 = i8;
                        } else {
                            i8 = i12;
                        }
                    }
                    i8 = i12;
                    int i27 = i5 + i25;
                    iArr4[i27] = i6;
                    if (!z3 || i25 < i20 || i25 > i19 || iArr3[i27] < iArr4[i27]) {
                        i24 += 2;
                        i12 = i8;
                    } else {
                        O0000O0o o0000O0o2 = new O0000O0o();
                        o0000O0o2.f18106O000000o = iArr4[i27];
                        o0000O0o2.O00000Oo = o0000O0o2.f18106O000000o - i25;
                        o0000O0o2.O00000o0 = iArr3[i27] - iArr4[i27];
                        o0000O0o2.O00000o = z;
                        o0000O0o2.O00000oO = true;
                        return o0000O0o2;
                    }
                } else {
                    i9 = 1;
                }
                i6 = iArr4[(i5 + i25) - i9];
                z = false;
                i7 = i6 - i25;
                while (true) {
                    if (i6 > 0) {
                        break;
                    }
                    break;
                    i6--;
                    i7--;
                    i12 = i8;
                }
                i8 = i12;
                int i272 = i5 + i25;
                iArr4[i272] = i6;
                if (!z3) {
                }
                i24 += 2;
                i12 = i8;
            }
            i19++;
            i12 = i12;
            i15 = 1;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }

    static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f18106O000000o;
        int O00000Oo;
        boolean O00000o;
        int O00000o0;
        boolean O00000oO;

        O0000O0o() {
        }
    }

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f18104O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;

        public O00000o() {
        }

        public O00000o(int i, int i2) {
            this.f18104O000000o = 0;
            this.O00000Oo = i;
            this.O00000o0 = 0;
            this.O00000o = i2;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final List<O0000O0o> f18103O000000o;
        private final int[] O00000Oo;
        private final O000000o O00000o;
        private final int[] O00000o0;
        private final int O00000oO;
        private final int O00000oo;
        private final boolean O0000O0o;

        O00000Oo(O000000o o000000o, List<O0000O0o> list, int[] iArr, int[] iArr2, boolean z) {
            this.f18103O000000o = list;
            this.O00000Oo = iArr;
            this.O00000o0 = iArr2;
            Arrays.fill(this.O00000Oo, 0);
            Arrays.fill(this.O00000o0, 0);
            this.O00000o = o000000o;
            this.O00000oO = o000000o.O000000o();
            this.O00000oo = o000000o.O00000Oo();
            this.O0000O0o = z;
            O0000O0o o0000O0o = this.f18103O000000o.isEmpty() ? null : this.f18103O000000o.get(0);
            if (!(o0000O0o != null && o0000O0o.f18106O000000o == 0 && o0000O0o.O00000Oo == 0)) {
                O0000O0o o0000O0o2 = new O0000O0o();
                o0000O0o2.f18106O000000o = 0;
                o0000O0o2.O00000Oo = 0;
                o0000O0o2.O00000o = false;
                o0000O0o2.O00000o0 = 0;
                o0000O0o2.O00000oO = false;
                this.f18103O000000o.add(0, o0000O0o2);
            }
            O000000o();
        }

        private void O000000o() {
            int i = this.O00000oO;
            int i2 = this.O00000oo;
            for (int size = this.f18103O000000o.size() - 1; size >= 0; size--) {
                O0000O0o o0000O0o = this.f18103O000000o.get(size);
                int i3 = o0000O0o.f18106O000000o + o0000O0o.O00000o0;
                int i4 = o0000O0o.O00000Oo + o0000O0o.O00000o0;
                if (this.O0000O0o) {
                    while (i > i3) {
                        if (this.O00000Oo[i - 1] == 0) {
                            O000000o(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.O00000o0[i2 - 1] == 0) {
                            O000000o(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < o0000O0o.O00000o0; i5++) {
                    int i6 = o0000O0o.f18106O000000o + i5;
                    int i7 = o0000O0o.O00000Oo + i5;
                    int i8 = this.O00000o.O00000Oo(i6, i7) ? 1 : 2;
                    this.O00000Oo[i6] = (i7 << 5) | i8;
                    this.O00000o0[i7] = (i6 << 5) | i8;
                }
                i = o0000O0o.f18106O000000o;
                i2 = o0000O0o.O00000Oo;
            }
        }

        private boolean O000000o(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i5 = i;
                i4 = i2;
            } else {
                i5 = i - 1;
                i4 = i5;
            }
            while (i3 >= 0) {
                O0000O0o o0000O0o = this.f18103O000000o.get(i3);
                int i6 = o0000O0o.f18106O000000o + o0000O0o.O00000o0;
                int i7 = o0000O0o.O00000Oo + o0000O0o.O00000o0;
                int i8 = 8;
                if (z) {
                    for (int i9 = i5 - 1; i9 >= i6; i9--) {
                        if (this.O00000o.O000000o(i9, i4)) {
                            if (!this.O00000o.O00000Oo(i9, i4)) {
                                i8 = 4;
                            }
                            this.O00000o0[i4] = (i9 << 5) | 16;
                            this.O00000Oo[i9] = (i4 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i10 = i2 - 1; i10 >= i7; i10--) {
                        if (this.O00000o.O000000o(i4, i10)) {
                            if (!this.O00000o.O00000Oo(i4, i10)) {
                                i8 = 4;
                            }
                            int i11 = i - 1;
                            this.O00000Oo[i11] = (i10 << 5) | 16;
                            this.O00000o0[i10] = (i11 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                }
                i5 = o0000O0o.f18106O000000o;
                i2 = o0000O0o.O00000Oo;
                i3--;
            }
            return false;
        }

        public final void O000000o(RecyclerView.O000000o o000000o) {
            gm gmVar = new gm(new gl(o000000o));
            ArrayList arrayList = new ArrayList();
            int i = this.O00000oO;
            int i2 = this.O00000oo;
            for (int size = this.f18103O000000o.size() - 1; size >= 0; size--) {
                O0000O0o o0000O0o = this.f18103O000000o.get(size);
                int i3 = o0000O0o.O00000o0;
                int i4 = o0000O0o.f18106O000000o + i3;
                int i5 = o0000O0o.O00000Oo + i3;
                if (i4 < i) {
                    O00000Oo(arrayList, gmVar, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    O000000o(arrayList, gmVar, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.O00000Oo[o0000O0o.f18106O000000o + i6] & 31) == 2) {
                        gmVar.O000000o(o0000O0o.f18106O000000o + i6, 1, null);
                    }
                }
                i = o0000O0o.f18106O000000o;
                i2 = o0000O0o.O00000Oo;
            }
            gmVar.O000000o();
        }

        private static O00000o0 O000000o(List<O00000o0> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                O00000o0 o00000o0 = list.get(size);
                if (o00000o0.f18105O000000o == i && o00000o0.O00000o0 == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).O00000Oo += z ? 1 : -1;
                        size++;
                    }
                    return o00000o0;
                }
                size--;
            }
            return null;
        }

        private void O000000o(List<O00000o0> list, gx gxVar, int i, int i2, int i3) {
            if (!this.O0000O0o) {
                gxVar.O000000o(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.O00000o0[i5] & 31;
                if (i6 == 0) {
                    gxVar.O000000o(i, 1);
                    for (O00000o0 o00000o0 : list) {
                        o00000o0.O00000Oo++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    gxVar.O00000o0(O000000o(list, this.O00000o0[i5] >> 5, true).O00000Oo, i);
                    if (i6 == 4) {
                        gxVar.O000000o(i, 1, null);
                    }
                } else if (i6 == 16) {
                    list.add(new O00000o0(i5, i, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString((long) i6));
                }
            }
        }

        private void O00000Oo(List<O00000o0> list, gx gxVar, int i, int i2, int i3) {
            if (!this.O0000O0o) {
                gxVar.O00000Oo(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.O00000Oo[i5] & 31;
                if (i6 == 0) {
                    gxVar.O00000Oo(i + i4, 1);
                    for (O00000o0 o00000o0 : list) {
                        o00000o0.O00000Oo--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    O00000o0 O000000o2 = O000000o(list, this.O00000Oo[i5] >> 5, false);
                    gxVar.O00000o0(i + i4, O000000o2.O00000Oo - 1);
                    if (i6 == 4) {
                        gxVar.O000000o(O000000o2.O00000Oo - 1, 1, null);
                    }
                } else if (i6 == 16) {
                    list.add(new O00000o0(i5, i + i4, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString((long) i6));
                }
            }
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        int f18105O000000o;
        int O00000Oo;
        boolean O00000o0;

        public O00000o0(int i, int i2, boolean z) {
            this.f18105O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = z;
        }
    }
}
