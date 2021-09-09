package _m_j;

import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;

public final class ihg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final idm f1294O000000o;
    public idh O00000Oo;

    public ihg(idm idm) {
        this.f1294O000000o = idm;
    }

    private float O000000o(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float O00000Oo2 = O00000Oo(i, i2, i3, i4);
        int i6 = i - (i3 - i);
        int i7 = 0;
        if (i6 < 0) {
            f = ((float) i) / ((float) (i - i6));
            i5 = 0;
        } else if (i6 >= this.f1294O000000o.f1214O000000o) {
            f = ((float) ((this.f1294O000000o.f1214O000000o - 1) - i)) / ((float) (i6 - i));
            i5 = this.f1294O000000o.f1214O000000o - 1;
        } else {
            i5 = i6;
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i8 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i8 < 0) {
            f2 = f3 / ((float) (i2 - i8));
        } else if (i8 >= this.f1294O000000o.O00000Oo) {
            f2 = ((float) ((this.f1294O000000o.O00000Oo - 1) - i2)) / ((float) (i8 - i2));
            i7 = this.f1294O000000o.O00000Oo - 1;
        } else {
            i7 = i8;
            f2 = 1.0f;
        }
        return (O00000Oo2 + O00000Oo(i, i2, (int) (((float) i) + (((float) (i5 - i)) * f2)), i7)) - 1.0f;
    }

    private float O00000Oo(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        ihg ihg;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i5 = i;
            i7 = i2;
            i6 = i3;
            i8 = i4;
        } else {
            i7 = i;
            i5 = i2;
            i8 = i3;
            i6 = i4;
        }
        int abs = Math.abs(i8 - i7);
        int abs2 = Math.abs(i6 - i5);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i7 < i8 ? 1 : -1;
        if (i5 < i6) {
            i12 = 1;
        }
        int i14 = i8 + i13;
        int i15 = i5;
        int i16 = i11;
        int i17 = 0;
        int i18 = i7;
        while (true) {
            if (i18 == i14) {
                i9 = i14;
                break;
            }
            int i19 = z3 ? i15 : i18;
            int i20 = z3 ? i18 : i15;
            if (i17 == i10) {
                ihg = this;
                z = z3;
                i9 = i14;
                z2 = true;
            } else {
                ihg = this;
                z = z3;
                i9 = i14;
                z2 = false;
            }
            if (z2 == ihg.f1294O000000o.O000000o(i19, i20)) {
                if (i17 == 2) {
                    return idw.O000000o(i18, i15, i7, i5);
                }
                i17++;
            }
            i16 += abs2;
            if (i16 > 0) {
                if (i15 == i6) {
                    break;
                }
                i15 += i12;
                i16 -= abs;
            }
            i18 += i13;
            i14 = i9;
            z3 = z;
            i10 = 1;
        }
        if (i17 == 2) {
            return idw.O000000o(i9, i6, i7, i5);
        }
        return Float.NaN;
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0255  */
    public idq O000000o(ihi ihi) throws NotFoundException, FormatException {
        int i;
        ihe ihe;
        float f;
        float f2;
        float f3;
        int i2;
        int i3;
        float f4;
        int i4;
        ihe ihe2;
        ihe O000000o2;
        ihi ihi2 = ihi;
        ihh ihh = ihi2.O00000Oo;
        ihh ihh2 = ihi2.O00000o0;
        ihh ihh3 = ihi2.f1295O000000o;
        float O000000o3 = (O000000o(ihh, ihh2) + O000000o(ihh, ihh3)) / 2.0f;
        if (O000000o3 >= 1.0f) {
            int O000000o4 = ((idw.O000000o(idg.O000000o(ihh, ihh2) / O000000o3) + idw.O000000o(idg.O000000o(ihh, ihh3) / O000000o3)) / 2) + 7;
            int i5 = O000000o4 & 3;
            int i6 = 3;
            if (i5 == 0) {
                O000000o4++;
            } else if (i5 == 2) {
                O000000o4--;
            } else if (i5 == 3) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i7 = O000000o4;
            ihd O000000o5 = ihd.O000000o(i7);
            int O000000o6 = O000000o5.O000000o() - 7;
            ihe ihe3 = null;
            int i8 = 0;
            int i9 = 1;
            if (O000000o5.O00000Oo.length > 0) {
                float f5 = (ihh2.f1209O000000o - ihh.f1209O000000o) + ihh3.f1209O000000o;
                float f6 = (ihh2.O00000Oo - ihh.O00000Oo) + ihh3.O00000Oo;
                float f7 = 1.0f - (3.0f / ((float) O000000o6));
                int i10 = (int) (ihh.f1209O000000o + ((f5 - ihh.f1209O000000o) * f7));
                int i11 = (int) (ihh.O00000Oo + (f7 * (f6 - ihh.O00000Oo)));
                int i12 = 4;
                loop0:
                while (true) {
                    if (i12 > 16) {
                        break;
                    }
                    int i13 = (int) (((float) i12) * O000000o3);
                    try {
                        int max = Math.max(i8, i10 - i13);
                        int min = Math.min(this.f1294O000000o.f1214O000000o - i9, i10 + i13) - max;
                        float f8 = O000000o3 * 3.0f;
                        if (((float) min) >= f8) {
                            int max2 = Math.max(i8, i11 - i13);
                            int min2 = Math.min(this.f1294O000000o.O00000Oo - i9, i13 + i11) - max2;
                            if (((float) min2) >= f8) {
                                i2 = i12;
                                int i14 = max;
                                i4 = i10;
                                i = i7;
                                try {
                                    ihf ihf = new ihf(this.f1294O000000o, i14, max2, min, min2, O000000o3, this.O00000Oo);
                                    int i15 = ihf.O00000o0;
                                    int i16 = ihf.O00000oo;
                                    int i17 = ihf.O00000oO + i15;
                                    int i18 = ihf.O00000o + (i16 / 2);
                                    int[] iArr = new int[i6];
                                    int i19 = 0;
                                    while (true) {
                                        if (i19 < i16) {
                                            int i20 = ((i19 & 1) == 0 ? (i19 + 1) / 2 : -((i19 + 1) / 2)) + i18;
                                            iArr[0] = 0;
                                            iArr[1] = 0;
                                            iArr[2] = 0;
                                            int i21 = i15;
                                            while (i21 < i17 && !ihf.f1293O000000o.O000000o(i21, i20)) {
                                                i21++;
                                            }
                                            int i22 = 0;
                                            while (i21 < i17) {
                                                f4 = O000000o3;
                                                try {
                                                    if (!ihf.f1293O000000o.O000000o(i21, i20)) {
                                                        i3 = i11;
                                                        if (i22 == 1) {
                                                            i22++;
                                                        }
                                                        iArr[i22] = iArr[i22] + 1;
                                                    } else if (i22 == 1) {
                                                        iArr[1] = iArr[1] + 1;
                                                        i3 = i11;
                                                    } else if (i22 == 2) {
                                                        if (ihf.O000000o(iArr) && (O000000o2 = ihf.O000000o(iArr, i20, i21)) != null) {
                                                            ihe3 = O000000o2;
                                                            break loop0;
                                                        }
                                                        iArr[0] = iArr[2];
                                                        iArr[1] = 1;
                                                        iArr[2] = 0;
                                                        i3 = i11;
                                                        i22 = 1;
                                                    } else {
                                                        i22++;
                                                        i3 = i11;
                                                        try {
                                                            iArr[i22] = iArr[i22] + 1;
                                                        } catch (NotFoundException unused) {
                                                        }
                                                    }
                                                    i21++;
                                                    O000000o3 = f4;
                                                    i11 = i3;
                                                } catch (NotFoundException unused2) {
                                                    i3 = i11;
                                                    i12 = i2 << 1;
                                                    i10 = i4;
                                                    O000000o3 = f4;
                                                    i11 = i3;
                                                    i7 = i;
                                                    i9 = 1;
                                                    i8 = 0;
                                                    i6 = 3;
                                                }
                                            }
                                            float f9 = O000000o3;
                                            int i23 = i11;
                                            if (ihf.O000000o(iArr) && (ihe2 = ihf.O000000o(iArr, i20, i17)) != null) {
                                                break loop0;
                                            }
                                            i19++;
                                            O000000o3 = f9;
                                            i11 = i23;
                                        } else {
                                            float f10 = O000000o3;
                                            int i24 = i11;
                                            if (!ihf.O00000Oo.isEmpty()) {
                                                ihe2 = ihf.O00000Oo.get(0);
                                            } else {
                                                throw NotFoundException.getNotFoundInstance();
                                            }
                                        }
                                    }
                                } catch (NotFoundException unused3) {
                                    f4 = O000000o3;
                                    i3 = i11;
                                    i12 = i2 << 1;
                                    i10 = i4;
                                    O000000o3 = f4;
                                    i11 = i3;
                                    i7 = i;
                                    i9 = 1;
                                    i8 = 0;
                                    i6 = 3;
                                }
                            } else {
                                float f11 = O000000o3;
                                int i25 = i11;
                                int i26 = i12;
                                int i27 = i10;
                                int i28 = i7;
                                throw NotFoundException.getNotFoundInstance();
                            }
                        } else {
                            float f12 = O000000o3;
                            int i29 = i11;
                            int i30 = i12;
                            int i31 = i10;
                            int i32 = i7;
                            throw NotFoundException.getNotFoundInstance();
                        }
                    } catch (NotFoundException unused4) {
                        f4 = O000000o3;
                        i3 = i11;
                        i2 = i12;
                        i4 = i10;
                        i = i7;
                    }
                    i12 = i2 << 1;
                    i10 = i4;
                    O000000o3 = f4;
                    i11 = i3;
                    i7 = i;
                    i9 = 1;
                    i8 = 0;
                    i6 = 3;
                }
                ihe3 = ihe2;
                ihe = ihe3;
                int i33 = i;
                float f13 = ((float) i33) - 3.5f;
                if (ihe == null) {
                    f2 = ihe.f1209O000000o;
                    f = ihe.O00000Oo;
                    f3 = f13 - 3.0f;
                } else {
                    f2 = (ihh2.f1209O000000o - ihh.f1209O000000o) + ihh3.f1209O000000o;
                    f = (ihh2.O00000Oo - ihh.O00000Oo) + ihh3.O00000Oo;
                    f3 = f13;
                }
                return new idq(ids.O000000o().O000000o(this.f1294O000000o, i33, i33, idu.O000000o(3.5f, 3.5f, f13, 3.5f, f3, f3, 3.5f, f13, ihh.f1209O000000o, ihh.O00000Oo, ihh2.f1209O000000o, ihh2.O00000Oo, f2, f, ihh3.f1209O000000o, ihh3.O00000Oo)), ihe != null ? new idg[]{ihh3, ihh, ihh2} : new idg[]{ihh3, ihh, ihh2, ihe});
            }
            i = i7;
            ihe = ihe3;
            int i332 = i;
            float f132 = ((float) i332) - 3.5f;
            if (ihe == null) {
            }
            return new idq(ids.O000000o().O000000o(this.f1294O000000o, i332, i332, idu.O000000o(3.5f, 3.5f, f132, 3.5f, f3, f3, 3.5f, f132, ihh.f1209O000000o, ihh.O00000Oo, ihh2.f1209O000000o, ihh2.O00000Oo, f2, f, ihh3.f1209O000000o, ihh3.O00000Oo)), ihe != null ? new idg[]{ihh3, ihh, ihh2} : new idg[]{ihh3, ihh, ihh2, ihe});
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private float O000000o(idg idg, idg idg2) {
        float O000000o2 = O000000o((int) idg.f1209O000000o, (int) idg.O00000Oo, (int) idg2.f1209O000000o, (int) idg2.O00000Oo);
        float O000000o3 = O000000o((int) idg2.f1209O000000o, (int) idg2.O00000Oo, (int) idg.f1209O000000o, (int) idg.O00000Oo);
        if (Float.isNaN(O000000o2)) {
            return O000000o3 / 7.0f;
        }
        return Float.isNaN(O000000o3) ? O000000o2 / 7.0f : (O000000o2 + O000000o3) / 14.0f;
    }
}
