package _m_j;

import com.xiaomi.zxing.NotFoundException;

public final class idx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final idm f1220O000000o;
    private final int O00000Oo;
    private final int O00000o;
    private final int O00000o0;
    private final int O00000oO;
    private final int O00000oo;
    private final int O0000O0o;

    public idx(idm idm, int i, int i2, int i3) throws NotFoundException {
        this.f1220O000000o = idm;
        this.O00000Oo = idm.O00000Oo;
        this.O00000o0 = idm.f1214O000000o;
        int i4 = i / 2;
        this.O00000o = i2 - i4;
        this.O00000oO = i2 + i4;
        this.O0000O0o = i3 - i4;
        this.O00000oo = i3 + i4;
        if (this.O0000O0o < 0 || this.O00000o < 0 || this.O00000oo >= this.O00000Oo || this.O00000oO >= this.O00000o0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.idx.O000000o(int, int, int, boolean):boolean
     arg types: [int, int, int, int]
     candidates:
      _m_j.idx.O000000o(float, float, float, float):_m_j.idg
      _m_j.idx.O000000o(_m_j.idg, _m_j.idg, _m_j.idg, _m_j.idg):_m_j.idg[]
      _m_j.idx.O000000o(int, int, int, boolean):boolean */
    public final idg[] O000000o() throws NotFoundException {
        int i = this.O00000o;
        int i2 = this.O00000oO;
        int i3 = this.O0000O0o;
        int i4 = this.O00000oo;
        boolean z = false;
        int i5 = i;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i2 < this.O00000o0) {
                    z8 = O000000o(i3, i4, i2, false);
                    if (z8) {
                        i2++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i2++;
                    }
                }
            }
            if (i2 >= this.O00000o0) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i4 < this.O00000Oo) {
                    z10 = O000000o(i5, i2, i4, true);
                    if (z10) {
                        i4++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.O00000Oo) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i5 >= 0) {
                    z11 = O000000o(i3, i4, i5, false);
                    if (z11) {
                        i5--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i5--;
                    }
                }
            }
            if (i5 < 0) {
                break;
            }
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i3 >= 0) {
                    z12 = O000000o(i5, i2, i3, true);
                    if (z12) {
                        i3--;
                        z7 = true;
                        z9 = true;
                    } else if (!z7) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                break;
            }
            if (z9) {
                z6 = true;
            }
            z2 = z9;
        }
        z = true;
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i2 - i5;
        idg idg = null;
        idg idg2 = null;
        for (int i7 = 1; i7 < i6; i7++) {
            idg2 = O000000o((float) i5, (float) (i4 - i7), (float) (i5 + i7), (float) i4);
            if (idg2 != null) {
                break;
            }
        }
        if (idg2 != null) {
            idg idg3 = null;
            for (int i8 = 1; i8 < i6; i8++) {
                idg3 = O000000o((float) i5, (float) (i3 + i8), (float) (i5 + i8), (float) i3);
                if (idg3 != null) {
                    break;
                }
            }
            if (idg3 != null) {
                idg idg4 = null;
                for (int i9 = 1; i9 < i6; i9++) {
                    idg4 = O000000o((float) i2, (float) (i3 + i9), (float) (i2 - i9), (float) i3);
                    if (idg4 != null) {
                        break;
                    }
                }
                if (idg4 != null) {
                    for (int i10 = 1; i10 < i6; i10++) {
                        idg = O000000o((float) i2, (float) (i4 - i10), (float) (i2 - i10), (float) i4);
                        if (idg != null) {
                            break;
                        }
                    }
                    if (idg != null) {
                        return O000000o(idg, idg2, idg4, idg3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private idg O000000o(float f, float f2, float f3, float f4) {
        int O000000o2 = idw.O000000o(idw.O000000o(f, f2, f3, f4));
        float f5 = (float) O000000o2;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < O000000o2; i++) {
            float f8 = (float) i;
            int O000000o3 = idw.O000000o((f8 * f6) + f);
            int O000000o4 = idw.O000000o((f8 * f7) + f2);
            if (this.f1220O000000o.O000000o(O000000o3, O000000o4)) {
                return new idg((float) O000000o3, (float) O000000o4);
            }
        }
        return null;
    }

    private boolean O000000o(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f1220O000000o.O000000o(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f1220O000000o.O000000o(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public idx(idm idm) throws NotFoundException {
        this(idm, 10, idm.f1214O000000o / 2, idm.O00000Oo / 2);
    }

    private idg[] O000000o(idg idg, idg idg2, idg idg3, idg idg4) {
        float f = idg.f1209O000000o;
        float f2 = idg.O00000Oo;
        float f3 = idg2.f1209O000000o;
        float f4 = idg2.O00000Oo;
        float f5 = idg3.f1209O000000o;
        float f6 = idg3.O00000Oo;
        float f7 = idg4.f1209O000000o;
        float f8 = idg4.O00000Oo;
        if (f < ((float) this.O00000o0) / 2.0f) {
            return new idg[]{new idg(f7 - 1.0f, f8 + 1.0f), new idg(f3 + 1.0f, f4 + 1.0f), new idg(f5 - 1.0f, f6 - 1.0f), new idg(f + 1.0f, f2 - 1.0f)};
        }
        return new idg[]{new idg(f7 + 1.0f, f8 + 1.0f), new idg(f3 + 1.0f, f4 - 1.0f), new idg(f5 - 1.0f, f6 + 1.0f), new idg(f - 1.0f, f2 - 1.0f)};
    }
}
