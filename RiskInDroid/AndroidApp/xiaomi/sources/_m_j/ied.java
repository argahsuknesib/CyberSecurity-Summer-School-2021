package _m_j;

import com.xiaomi.zxing.FormatException;

final class ied {

    /* renamed from: O000000o  reason: collision with root package name */
    final ieg f1228O000000o;
    private final idm O00000Oo;
    private final idm O00000o0;

    ied(idm idm) throws FormatException {
        int i = idm.O00000Oo;
        if (i < 8 || i > 144 || (i & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.f1228O000000o = ieg.O000000o(idm.O00000Oo, idm.f1214O000000o);
        this.O00000Oo = O000000o(idm);
        this.O00000o0 = new idm(this.O00000Oo.f1214O000000o, this.O00000Oo.O00000Oo);
    }

    /* access modifiers changed from: package-private */
    public final byte[] O000000o() throws FormatException {
        byte[] bArr = new byte[this.f1228O000000o.O0000O0o];
        int i = this.O00000Oo.O00000Oo;
        int i2 = this.O00000Oo.f1214O000000o;
        int i3 = 4;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i3 == i && i4 == 0 && !z) {
                int i6 = i5 + 1;
                int i7 = i - 1;
                int i8 = (O000000o(i7, 0, i, i2) ? 1 : 0) << true;
                if (O000000o(i7, 1, i, i2)) {
                    i8 |= 1;
                }
                int i9 = i8 << 1;
                if (O000000o(i7, 2, i, i2)) {
                    i9 |= 1;
                }
                int i10 = i9 << 1;
                if (O000000o(0, i2 - 2, i, i2)) {
                    i10 |= 1;
                }
                int i11 = i10 << 1;
                int i12 = i2 - 1;
                if (O000000o(0, i12, i, i2)) {
                    i11 |= 1;
                }
                int i13 = i11 << 1;
                if (O000000o(1, i12, i, i2)) {
                    i13 |= 1;
                }
                int i14 = i13 << 1;
                if (O000000o(2, i12, i, i2)) {
                    i14 |= 1;
                }
                int i15 = i14 << 1;
                if (O000000o(3, i12, i, i2)) {
                    i15 |= 1;
                }
                bArr[i5] = (byte) i15;
                i3 -= 2;
                i4 += 2;
                i5 = i6;
                z = true;
            } else {
                int i16 = i - 2;
                if (i3 == i16 && i4 == 0 && (i2 & 3) != 0 && !z2) {
                    int i17 = i5 + 1;
                    int i18 = (O000000o(i + -3, 0, i, i2) ? 1 : 0) << true;
                    if (O000000o(i16, 0, i, i2)) {
                        i18 |= 1;
                    }
                    int i19 = i18 << 1;
                    if (O000000o(i - 1, 0, i, i2)) {
                        i19 |= 1;
                    }
                    int i20 = i19 << 1;
                    if (O000000o(0, i2 - 4, i, i2)) {
                        i20 |= 1;
                    }
                    int i21 = i20 << 1;
                    if (O000000o(0, i2 - 3, i, i2)) {
                        i21 |= 1;
                    }
                    int i22 = i21 << 1;
                    if (O000000o(0, i2 - 2, i, i2)) {
                        i22 |= 1;
                    }
                    int i23 = i22 << 1;
                    int i24 = i2 - 1;
                    if (O000000o(0, i24, i, i2)) {
                        i23 |= 1;
                    }
                    int i25 = i23 << 1;
                    if (O000000o(1, i24, i, i2)) {
                        i25 |= 1;
                    }
                    bArr[i5] = (byte) i25;
                    i3 -= 2;
                    i4 += 2;
                    i5 = i17;
                    z2 = true;
                } else if (i3 == i + 4 && i4 == 2 && (i2 & 7) == 0 && !z3) {
                    int i26 = i5 + 1;
                    int i27 = i - 1;
                    int i28 = (O000000o(i27, 0, i, i2) ? 1 : 0) << true;
                    int i29 = i2 - 1;
                    if (O000000o(i27, i29, i, i2)) {
                        i28 |= 1;
                    }
                    int i30 = i28 << 1;
                    int i31 = i2 - 3;
                    if (O000000o(0, i31, i, i2)) {
                        i30 |= 1;
                    }
                    int i32 = i30 << 1;
                    int i33 = i2 - 2;
                    if (O000000o(0, i33, i, i2)) {
                        i32 |= 1;
                    }
                    int i34 = i26;
                    int i35 = i32 << 1;
                    if (O000000o(0, i29, i, i2)) {
                        i35 |= 1;
                    }
                    int i36 = i35 << 1;
                    if (O000000o(1, i31, i, i2)) {
                        i36 |= 1;
                    }
                    int i37 = i36 << 1;
                    if (O000000o(1, i33, i, i2)) {
                        i37 |= 1;
                    }
                    int i38 = i37 << 1;
                    if (O000000o(1, i29, i, i2)) {
                        i38 |= 1;
                    }
                    bArr[i5] = (byte) i38;
                    i3 -= 2;
                    i4 += 2;
                    i5 = i34;
                    z3 = true;
                } else if (i3 == i16 && i4 == 0 && (i2 & 7) == 4 && !z4) {
                    int i39 = i5 + 1;
                    int i40 = (O000000o(i + -3, 0, i, i2) ? 1 : 0) << true;
                    if (O000000o(i16, 0, i, i2)) {
                        i40 |= 1;
                    }
                    int i41 = i40 << 1;
                    if (O000000o(i - 1, 0, i, i2)) {
                        i41 |= 1;
                    }
                    int i42 = i41 << 1;
                    if (O000000o(0, i2 - 2, i, i2)) {
                        i42 |= 1;
                    }
                    int i43 = i42 << 1;
                    int i44 = i2 - 1;
                    if (O000000o(0, i44, i, i2)) {
                        i43 |= 1;
                    }
                    int i45 = i43 << 1;
                    if (O000000o(1, i44, i, i2)) {
                        i45 |= 1;
                    }
                    int i46 = i45 << 1;
                    if (O000000o(2, i44, i, i2)) {
                        i46 |= 1;
                    }
                    int i47 = i46 << 1;
                    if (O000000o(3, i44, i, i2)) {
                        i47 |= 1;
                    }
                    bArr[i5] = (byte) i47;
                    i3 -= 2;
                    i4 += 2;
                    i5 = i39;
                    z4 = true;
                } else {
                    do {
                        if (i3 < i && i4 >= 0 && !this.O00000o0.O000000o(i4, i3)) {
                            bArr[i5] = (byte) O00000Oo(i3, i4, i, i2);
                            i5++;
                        }
                        i3 -= 2;
                        i4 += 2;
                        if (i3 < 0) {
                            break;
                        }
                    } while (i4 < i2);
                    int i48 = i3 + 1;
                    int i49 = i4 + 3;
                    do {
                        if (i48 >= 0 && i49 < i2 && !this.O00000o0.O000000o(i49, i48)) {
                            bArr[i5] = (byte) O00000Oo(i48, i49, i, i2);
                            i5++;
                        }
                        i48 += 2;
                        i49 -= 2;
                        if (i48 >= i) {
                            break;
                        }
                    } while (i49 >= 0);
                    i3 = i48 + 3;
                    i4 = i49 + 1;
                }
            }
            if (i3 >= i && i4 >= i2) {
                break;
            }
        }
        if (i5 == this.f1228O000000o.O0000O0o) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    private boolean O000000o(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.O00000o0.O00000Oo(i2, i);
        return this.O00000Oo.O000000o(i2, i);
    }

    private int O00000Oo(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (O000000o(i5, i6, i3, i4) ? 1 : 0) << true;
        int i8 = i2 - 1;
        if (O000000o(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (O000000o(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (O000000o(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (O000000o(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (O000000o(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (O000000o(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return O000000o(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private idm O000000o(idm idm) {
        idm idm2 = idm;
        int i = this.f1228O000000o.O00000Oo;
        int i2 = this.f1228O000000o.O00000o0;
        if (idm2.O00000Oo == i) {
            int i3 = this.f1228O000000o.O00000o;
            int i4 = this.f1228O000000o.O00000oO;
            int i5 = i / i3;
            int i6 = i2 / i4;
            idm idm3 = new idm(i6 * i4, i5 * i3);
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = i7 * i3;
                for (int i9 = 0; i9 < i6; i9++) {
                    int i10 = i9 * i4;
                    for (int i11 = 0; i11 < i3; i11++) {
                        int i12 = ((i3 + 2) * i7) + 1 + i11;
                        int i13 = i8 + i11;
                        for (int i14 = 0; i14 < i4; i14++) {
                            if (idm2.O000000o(((i4 + 2) * i9) + 1 + i14, i12)) {
                                idm3.O00000Oo(i10 + i14, i13);
                            }
                        }
                    }
                }
            }
            return idm3;
        }
        throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
    }
}
