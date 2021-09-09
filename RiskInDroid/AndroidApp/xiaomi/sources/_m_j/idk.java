package _m_j;

import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.common.reedsolomon.ReedSolomonException;

public final class idk {
    private static final int[] O0000O0o = {3808, 476, 2107, 1799};

    /* renamed from: O000000o  reason: collision with root package name */
    private final idm f1211O000000o;
    private boolean O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;

    public idk(idm idm) {
        this.f1211O000000o = idm;
    }

    public final idi O000000o(boolean z) throws NotFoundException {
        idg[] O000000o2 = O000000o(O000000o());
        if (z) {
            idg idg = O000000o2[0];
            O000000o2[0] = O000000o2[2];
            O000000o2[2] = idg;
        }
        O000000o(O000000o2);
        idm idm = this.f1211O000000o;
        int i = this.O00000oo;
        return new idi(O000000o(idm, O000000o2[i % 4], O000000o2[(i + 1) % 4], O000000o2[(i + 2) % 4], O000000o2[(i + 3) % 4]), O00000Oo(O000000o2), this.O00000Oo, this.O00000o, this.O00000o0);
    }

    private void O000000o(idg[] idgArr) throws NotFoundException {
        long j;
        long j2;
        if (!O000000o(idgArr[0]) || !O000000o(idgArr[1]) || !O000000o(idgArr[2]) || !O000000o(idgArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = this.O00000oO * 2;
        int[] iArr = {O000000o(idgArr[0], idgArr[1], i), O000000o(idgArr[1], idgArr[2], i), O000000o(idgArr[2], idgArr[3], i), O000000o(idgArr[3], idgArr[0], i)};
        this.O00000oo = O000000o(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.O00000oo + i2) % 4];
            if (this.O00000Oo) {
                j2 = j3 << 7;
                j = (long) ((i3 >> 1) & 127);
            } else {
                j2 = j3 << 10;
                j = (long) (((i3 >> 2) & 992) + ((i3 >> 1) & 31));
            }
            j3 = j2 + j;
        }
        int O000000o2 = O000000o(j3, this.O00000Oo);
        if (this.O00000Oo) {
            this.O00000o0 = (O000000o2 >> 6) + 1;
            this.O00000o = (O000000o2 & 63) + 1;
            return;
        }
        this.O00000o0 = (O000000o2 >> 11) + 1;
        this.O00000o = (O000000o2 & 2047) + 1;
    }

    private static int O000000o(int[] iArr, int i) throws NotFoundException {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[i3];
            i2 = (i2 << 3) + ((i4 >> (i - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(O0000O0o[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int O000000o(long j, boolean z) throws NotFoundException {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new iea(idy.O00000o).O000000o(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private idg[] O000000o(O000000o o000000o) throws NotFoundException {
        this.O00000oO = 1;
        O000000o o000000o2 = o000000o;
        O000000o o000000o3 = o000000o2;
        O000000o o000000o4 = o000000o3;
        O000000o o000000o5 = o000000o4;
        boolean z = true;
        while (this.O00000oO < 9) {
            O000000o O000000o2 = O000000o(o000000o2, z, 1, -1);
            O000000o O000000o3 = O000000o(o000000o3, z, 1, 1);
            O000000o O000000o4 = O000000o(o000000o4, z, -1, 1);
            O000000o O000000o5 = O000000o(o000000o5, z, -1, -1);
            if (this.O00000oO > 2) {
                double O00000Oo2 = (double) ((O00000Oo(O000000o5, O000000o2) * ((float) this.O00000oO)) / (O00000Oo(o000000o5, o000000o2) * ((float) (this.O00000oO + 2))));
                if (O00000Oo2 < 0.75d || O00000Oo2 > 1.25d || !O000000o(O000000o2, O000000o3, O000000o4, O000000o5)) {
                    break;
                }
            }
            z = !z;
            this.O00000oO++;
            o000000o5 = O000000o5;
            o000000o2 = O000000o2;
            o000000o3 = O000000o3;
            o000000o4 = O000000o4;
        }
        int i = this.O00000oO;
        if (i == 5 || i == 7) {
            this.O00000Oo = this.O00000oO == 5;
            idg[] idgArr = {new idg(((float) o000000o2.f1212O000000o) + 0.5f, ((float) o000000o2.O00000Oo) - 0.5f), new idg(((float) o000000o3.f1212O000000o) + 0.5f, ((float) o000000o3.O00000Oo) + 0.5f), new idg(((float) o000000o4.f1212O000000o) - 0.5f, ((float) o000000o4.O00000Oo) + 0.5f), new idg(((float) o000000o5.f1212O000000o) - 0.5f, ((float) o000000o5.O00000Oo) - 0.5f)};
            int i2 = this.O00000oO;
            return O000000o(idgArr, (float) ((i2 * 2) - 3), (float) (i2 * 2));
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.idk.O000000o(_m_j.idk$O000000o, boolean, int, int):_m_j.idk$O000000o
     arg types: [_m_j.idk$O000000o, int, int, int]
     candidates:
      _m_j.idk.O000000o(_m_j.idk$O000000o, _m_j.idk$O000000o, _m_j.idk$O000000o, _m_j.idk$O000000o):boolean
      _m_j.idk.O000000o(_m_j.idk$O000000o, boolean, int, int):_m_j.idk$O000000o */
    private O000000o O000000o() {
        idg idg;
        idg idg2;
        idg idg3;
        idg idg4;
        idg idg5;
        idg idg6;
        idg idg7;
        idg idg8;
        try {
            idg[] O000000o2 = new idx(this.f1211O000000o).O000000o();
            idg3 = O000000o2[0];
            idg2 = O000000o2[1];
            idg = O000000o2[2];
            idg4 = O000000o2[3];
        } catch (NotFoundException unused) {
            int i = this.f1211O000000o.f1214O000000o / 2;
            int i2 = this.f1211O000000o.O00000Oo / 2;
            int i3 = i + 7;
            int i4 = i2 - 7;
            idg O000000o3 = O000000o(new O000000o(i3, i4), false, 1, -1).O000000o();
            int i5 = i2 + 7;
            idg O000000o4 = O000000o(new O000000o(i3, i5), false, 1, 1).O000000o();
            int i6 = i - 7;
            idg O000000o5 = O000000o(new O000000o(i6, i5), false, -1, 1).O000000o();
            idg4 = O000000o(new O000000o(i6, i4), false, -1, -1).O000000o();
            idg idg9 = O000000o4;
            idg = O000000o5;
            idg3 = O000000o3;
            idg2 = idg9;
        }
        int O000000o6 = idw.O000000o((((idg3.f1209O000000o + idg4.f1209O000000o) + idg2.f1209O000000o) + idg.f1209O000000o) / 4.0f);
        int O000000o7 = idw.O000000o((((idg3.O00000Oo + idg4.O00000Oo) + idg2.O00000Oo) + idg.O00000Oo) / 4.0f);
        try {
            idg[] O000000o8 = new idx(this.f1211O000000o, 15, O000000o6, O000000o7).O000000o();
            idg6 = O000000o8[0];
            idg5 = O000000o8[1];
            idg7 = O000000o8[2];
            idg8 = O000000o8[3];
        } catch (NotFoundException unused2) {
            int i7 = O000000o6 + 7;
            int i8 = O000000o7 - 7;
            idg6 = O000000o(new O000000o(i7, i8), false, 1, -1).O000000o();
            int i9 = O000000o7 + 7;
            idg5 = O000000o(new O000000o(i7, i9), false, 1, 1).O000000o();
            int i10 = O000000o6 - 7;
            idg7 = O000000o(new O000000o(i10, i9), false, -1, 1).O000000o();
            idg8 = O000000o(new O000000o(i10, i8), false, -1, -1).O000000o();
        }
        return new O000000o(idw.O000000o((((idg6.f1209O000000o + idg8.f1209O000000o) + idg5.f1209O000000o) + idg7.f1209O000000o) / 4.0f), idw.O000000o((((idg6.O00000Oo + idg8.O00000Oo) + idg5.O00000Oo) + idg7.O00000Oo) / 4.0f));
    }

    private idg[] O00000Oo(idg[] idgArr) {
        return O000000o(idgArr, (float) (this.O00000oO * 2), (float) O00000Oo());
    }

    private idm O000000o(idm idm, idg idg, idg idg2, idg idg3, idg idg4) throws NotFoundException {
        idg idg5 = idg;
        idg idg6 = idg2;
        idg idg7 = idg3;
        idg idg8 = idg4;
        ids O000000o2 = ids.O000000o();
        int O00000Oo2 = O00000Oo();
        int i = O00000Oo2;
        int i2 = O00000Oo2;
        float f = ((float) O00000Oo2) / 2.0f;
        int i3 = this.O00000oO;
        float f2 = f - ((float) i3);
        float f3 = f + ((float) i3);
        return O000000o2.O000000o(idm, i2, i, f2, f2, f3, f2, f3, f3, f2, f3, idg5.f1209O000000o, idg5.O00000Oo, idg6.f1209O000000o, idg6.O00000Oo, idg7.f1209O000000o, idg7.O00000Oo, idg8.f1209O000000o, idg8.O00000Oo);
    }

    private int O000000o(idg idg, idg idg2, int i) {
        float O000000o2 = O000000o(idg, idg2);
        float f = O000000o2 / ((float) i);
        float f2 = idg.f1209O000000o;
        float f3 = idg.O00000Oo;
        float f4 = ((idg2.f1209O000000o - idg.f1209O000000o) * f) / O000000o2;
        float f5 = (f * (idg2.O00000Oo - idg.O00000Oo)) / O000000o2;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f6 = (float) i3;
            if (this.f1211O000000o.O000000o(idw.O000000o((f6 * f4) + f2), idw.O000000o((f6 * f5) + f3))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private boolean O000000o(O000000o o000000o, O000000o o000000o2, O000000o o000000o3, O000000o o000000o4) {
        O000000o o000000o5 = new O000000o(o000000o.f1212O000000o - 3, o000000o.O00000Oo + 3);
        O000000o o000000o6 = new O000000o(o000000o2.f1212O000000o - 3, o000000o2.O00000Oo - 3);
        O000000o o000000o7 = new O000000o(o000000o3.f1212O000000o + 3, o000000o3.O00000Oo - 3);
        O000000o o000000o8 = new O000000o(o000000o4.f1212O000000o + 3, o000000o4.O00000Oo + 3);
        int O000000o2 = O000000o(o000000o8, o000000o5);
        if (O000000o2 != 0 && O000000o(o000000o5, o000000o6) == O000000o2 && O000000o(o000000o6, o000000o7) == O000000o2 && O000000o(o000000o7, o000000o8) == O000000o2) {
            return true;
        }
        return false;
    }

    private int O000000o(O000000o o000000o, O000000o o000000o2) {
        float O00000Oo2 = O00000Oo(o000000o, o000000o2);
        float f = ((float) (o000000o2.f1212O000000o - o000000o.f1212O000000o)) / O00000Oo2;
        float f2 = ((float) (o000000o2.O00000Oo - o000000o.O00000Oo)) / O00000Oo2;
        boolean O000000o2 = this.f1211O000000o.O000000o(o000000o.f1212O000000o, o000000o.O00000Oo);
        boolean z = false;
        float f3 = (float) o000000o.f1212O000000o;
        float f4 = (float) o000000o.O00000Oo;
        int i = 0;
        for (int i2 = 0; ((float) i2) < O00000Oo2; i2++) {
            f3 += f;
            f4 += f2;
            if (this.f1211O000000o.O000000o(idw.O000000o(f3), idw.O000000o(f4)) != O000000o2) {
                i++;
            }
        }
        float f5 = ((float) i) / O00000Oo2;
        if (f5 > 0.1f && f5 < 0.9f) {
            return 0;
        }
        if (f5 <= 0.1f) {
            z = true;
        }
        return z == O000000o2 ? 1 : -1;
    }

    private static idg[] O000000o(idg[] idgArr, float f, float f2) {
        float f3 = f2 / (f * 2.0f);
        float f4 = idgArr[0].f1209O000000o - idgArr[2].f1209O000000o;
        float f5 = idgArr[0].O00000Oo - idgArr[2].O00000Oo;
        float f6 = (idgArr[0].f1209O000000o + idgArr[2].f1209O000000o) / 2.0f;
        float f7 = (idgArr[0].O00000Oo + idgArr[2].O00000Oo) / 2.0f;
        float f8 = f4 * f3;
        float f9 = f5 * f3;
        idg idg = new idg(f6 + f8, f7 + f9);
        idg idg2 = new idg(f6 - f8, f7 - f9);
        float f10 = idgArr[1].f1209O000000o - idgArr[3].f1209O000000o;
        float f11 = idgArr[1].O00000Oo - idgArr[3].O00000Oo;
        float f12 = (idgArr[1].f1209O000000o + idgArr[3].f1209O000000o) / 2.0f;
        float f13 = (idgArr[1].O00000Oo + idgArr[3].O00000Oo) / 2.0f;
        float f14 = f10 * f3;
        float f15 = f3 * f11;
        return new idg[]{idg, new idg(f12 + f14, f13 + f15), idg2, new idg(f12 - f14, f13 - f15)};
    }

    private boolean O000000o(int i, int i2) {
        return i >= 0 && i < this.f1211O000000o.f1214O000000o && i2 > 0 && i2 < this.f1211O000000o.O00000Oo;
    }

    private int O00000Oo() {
        if (this.O00000Oo) {
            return (this.O00000o0 * 4) + 11;
        }
        int i = this.O00000o0;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f1212O000000o;
        final int O00000Oo;

        /* access modifiers changed from: package-private */
        public final idg O000000o() {
            return new idg((float) this.f1212O000000o, (float) this.O00000Oo);
        }

        O000000o(int i, int i2) {
            this.f1212O000000o = i;
            this.O00000Oo = i2;
        }

        public final String toString() {
            return "<" + this.f1212O000000o + ' ' + this.O00000Oo + '>';
        }
    }

    private O000000o O000000o(O000000o o000000o, boolean z, int i, int i2) {
        int i3 = o000000o.f1212O000000o + i;
        int i4 = o000000o.O00000Oo;
        while (true) {
            i4 += i2;
            if (!O000000o(i3, i4) || this.f1211O000000o.O000000o(i3, i4) != z) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
            } else {
                i3 += i;
            }
        }
        int i52 = i3 - i;
        int i62 = i4 - i2;
        while (O000000o(i52, i62) && this.f1211O000000o.O000000o(i52, i62) == z) {
            i52 += i;
        }
        int i7 = i52 - i;
        while (O000000o(i7, i62) && this.f1211O000000o.O000000o(i7, i62) == z) {
            i62 += i2;
        }
        return new O000000o(i7, i62 - i2);
    }

    private boolean O000000o(idg idg) {
        return O000000o(idw.O000000o(idg.f1209O000000o), idw.O000000o(idg.O00000Oo));
    }

    private static float O00000Oo(O000000o o000000o, O000000o o000000o2) {
        return idw.O000000o(o000000o.f1212O000000o, o000000o.O00000Oo, o000000o2.f1212O000000o, o000000o2.O00000Oo);
    }

    private static float O000000o(idg idg, idg idg2) {
        return idw.O000000o(idg.f1209O000000o, idg.O00000Oo, idg2.f1209O000000o, idg2.O00000Oo);
    }
}
