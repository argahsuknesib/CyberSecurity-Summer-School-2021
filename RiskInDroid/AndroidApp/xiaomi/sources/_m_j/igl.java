package _m_j;

import java.util.Formatter;

final class igl {

    /* renamed from: O000000o  reason: collision with root package name */
    final igh f1274O000000o;
    final igm[] O00000Oo = new igm[(this.O00000o + 2)];
    final int O00000o;
    igj O00000o0;

    igl(igh igh, igj igj) {
        this.f1274O000000o = igh;
        this.O00000o = igh.f1270O000000o;
        this.O00000o0 = igj;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(igm igm) {
        idg idg;
        idg idg2;
        if (igm != null) {
            ign ign = (ign) igm;
            igh igh = this.f1274O000000o;
            igk[] igkArr = ign.O00000Oo;
            for (igk igk : ign.O00000Oo) {
                if (igk != null) {
                    igk.O00000Oo();
                }
            }
            ign.O000000o(igkArr, igh);
            igj igj = ign.f1275O000000o;
            if (ign.O00000o0) {
                idg = igj.O00000Oo;
            } else {
                idg = igj.O00000o;
            }
            if (ign.O00000o0) {
                idg2 = igj.O00000o0;
            } else {
                idg2 = igj.O00000oO;
            }
            int O00000Oo2 = ign.O00000Oo((int) idg.O00000Oo);
            int O00000Oo3 = ign.O00000Oo((int) idg2.O00000Oo);
            int i = igh.O00000oO;
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (O00000Oo2 < O00000Oo3) {
                if (igkArr[O00000Oo2] != null) {
                    igk igk2 = igkArr[O00000Oo2];
                    int i5 = igk2.O00000oO - i2;
                    if (i5 == 0) {
                        i3++;
                    } else {
                        if (i5 == 1) {
                            i4 = Math.max(i4, i3);
                            i2 = igk2.O00000oO;
                        } else if (i5 < 0 || igk2.O00000oO >= igh.O00000oO || i5 > O00000Oo2) {
                            igkArr[O00000Oo2] = null;
                        } else {
                            if (i4 > 2) {
                                i5 *= i4 - 2;
                            }
                            boolean z = i5 >= O00000Oo2;
                            for (int i6 = 1; i6 <= i5 && !z; i6++) {
                                z = igkArr[O00000Oo2 - i6] != null;
                            }
                            if (z) {
                                igkArr[O00000Oo2] = null;
                            } else {
                                i2 = igk2.O00000oO;
                            }
                        }
                        i3 = 1;
                    }
                }
                O00000Oo2++;
            }
        }
    }

    static int O000000o(int i, int i2, igk igk) {
        if (igk == null || igk.O000000o()) {
            return i2;
        }
        if (!igk.O000000o(i)) {
            return i2 + 1;
        }
        igk.O00000oO = i;
        return 0;
    }

    public final String toString() {
        igm[] igmArr = this.O00000Oo;
        igm igm = igmArr[0];
        if (igm == null) {
            igm = igmArr[this.O00000o + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < igm.O00000Oo.length; i++) {
            formatter.format("CW %3d:", Integer.valueOf(i));
            for (int i2 = 0; i2 < this.O00000o + 2; i2++) {
                igm[] igmArr2 = this.O00000Oo;
                if (igmArr2[i2] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    igk igk = igmArr2[i2].O00000Oo[i];
                    if (igk == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(igk.O00000oO), Integer.valueOf(igk.O00000o));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
