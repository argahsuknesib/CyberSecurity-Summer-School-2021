package _m_j;

import com.xiaomi.zxing.FormatException;

final class ign extends igm {
    final boolean O00000o0;

    ign(igj igj, boolean z) {
        super(igj);
        this.O00000o0 = z;
    }

    /* access modifiers changed from: package-private */
    public final int[] O000000o() throws FormatException {
        idg idg;
        idg idg2;
        int i;
        igh O00000Oo = O00000Oo();
        if (O00000Oo == null) {
            return null;
        }
        igj igj = this.f1275O000000o;
        if (this.O00000o0) {
            idg = igj.O00000Oo;
        } else {
            idg = igj.O00000o;
        }
        if (this.O00000o0) {
            idg2 = igj.O00000o0;
        } else {
            idg2 = igj.O00000oO;
        }
        int O00000Oo2 = O00000Oo((int) idg2.O00000Oo);
        igk[] igkArr = this.O00000Oo;
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        for (int O00000Oo3 = O00000Oo((int) idg.O00000Oo); O00000Oo3 < O00000Oo2; O00000Oo3++) {
            if (igkArr[O00000Oo3] != null) {
                igk igk = igkArr[O00000Oo3];
                igk.O00000Oo();
                int i5 = igk.O00000oO - i2;
                if (i5 == 0) {
                    i3++;
                } else {
                    if (i5 == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = igk.O00000oO;
                    } else if (igk.O00000oO >= O00000Oo.O00000oO) {
                        igkArr[O00000Oo3] = null;
                    } else {
                        i2 = igk.O00000oO;
                    }
                    i3 = 1;
                }
            }
        }
        int[] iArr = new int[O00000Oo.O00000oO];
        for (igk igk2 : this.O00000Oo) {
            if (igk2 != null && (i = igk2.O00000oO) < iArr.length) {
                iArr[i] = iArr[i] + 1;
            }
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public void O000000o(igk[] igkArr, igh igh) {
        for (int i = 0; i < igkArr.length; i++) {
            igk igk = igkArr[i];
            if (igkArr[i] != null) {
                int i2 = igk.O00000o % 30;
                int i3 = igk.O00000oO;
                if (i3 > igh.O00000oO) {
                    igkArr[i] = null;
                } else {
                    if (!this.O00000o0) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != igh.f1270O000000o) {
                                igkArr[i] = null;
                            }
                        } else if (i2 / 3 != igh.O00000Oo || i2 % 3 != igh.O00000o) {
                            igkArr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != igh.O00000o0) {
                        igkArr[i] = null;
                    }
                }
            }
        }
    }

    public final String toString() {
        return "IsLeft: " + this.O00000o0 + 10 + super.toString();
    }

    /* access modifiers changed from: package-private */
    public final igh O00000Oo() {
        igk[] igkArr = this.O00000Oo;
        igi igi = new igi();
        igi igi2 = new igi();
        igi igi3 = new igi();
        igi igi4 = new igi();
        for (igk igk : igkArr) {
            if (igk != null) {
                igk.O00000Oo();
                int i = igk.O00000o % 30;
                int i2 = igk.O00000oO;
                if (!this.O00000o0) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    igi2.O000000o((i * 3) + 1);
                } else if (i3 == 1) {
                    igi4.O000000o(i / 3);
                    igi3.O000000o(i % 3);
                } else if (i3 == 2) {
                    igi.O000000o(i + 1);
                }
            }
        }
        if (igi.O000000o().length == 0 || igi2.O000000o().length == 0 || igi3.O000000o().length == 0 || igi4.O000000o().length == 0 || igi.O000000o()[0] <= 0 || igi2.O000000o()[0] + igi3.O000000o()[0] < 3 || igi2.O000000o()[0] + igi3.O000000o()[0] > 90) {
            return null;
        }
        igh igh = new igh(igi.O000000o()[0], igi2.O000000o()[0], igi3.O000000o()[0], igi4.O000000o()[0]);
        O000000o(igkArr, igh);
        return igh;
    }
}
