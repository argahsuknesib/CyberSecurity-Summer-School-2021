package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ifg extends ifc {
    private static final int[] O0000O0o = {1, 10, 34, 70, 126};
    private static final int[] O0000OOo = {4, 20, 48, 81};
    private static final int[] O0000Oo = {0, 336, 1036, 1516};
    private static final int[] O0000Oo0 = {0, 161, 961, 2015, 2715};
    private static final int[] O0000OoO = {8, 6, 4, 3, 1};
    private static final int[] O0000Ooo = {2, 4, 6, 8};
    private static final int[][] O0000o00 = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<iff> O0000o0 = new ArrayList();
    private final List<iff> O0000o0O = new ArrayList();

    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException {
        O000000o(this.O0000o0, O000000o(idl, false, i, map));
        idl.O00000o0();
        O000000o(this.O0000o0O, O000000o(idl, true, i, map));
        idl.O00000o0();
        for (iff next : this.O0000o0) {
            if (next.O00000o > 1) {
                for (iff next2 : this.O0000o0O) {
                    if (next2.O00000o > 1) {
                        int i2 = (next.O00000Oo + (next2.O00000Oo * 16)) % 79;
                        int i3 = (next.O00000o0.f1257O000000o * 9) + next2.O00000o0.f1257O000000o;
                        if (i3 > 72) {
                            i3--;
                        }
                        if (i3 > 8) {
                            i3--;
                        }
                        if (i2 == i3) {
                            String valueOf = String.valueOf((((long) next.f1256O000000o) * 4537077) + ((long) next2.f1256O000000o));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - valueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(valueOf);
                            int i4 = 0;
                            for (int i5 = 0; i5 < 13; i5++) {
                                int charAt = sb.charAt(i5) - '0';
                                if ((i5 & 1) == 0) {
                                    charAt *= 3;
                                }
                                i4 += charAt;
                            }
                            int i6 = 10 - (i4 % 10);
                            if (i6 == 10) {
                                i6 = 0;
                            }
                            sb.append(i6);
                            idg[] idgArr = next.O00000o0.O00000o0;
                            idg[] idgArr2 = next2.O00000o0.O00000o0;
                            return new idf(String.valueOf(sb.toString()), null, new idg[]{idgArr[0], idgArr[1], idgArr2[0], idgArr2[1]}, BarcodeFormat.RSS_14);
                        }
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void O000000o(Collection<iff> collection, iff iff) {
        if (iff != null) {
            boolean z = false;
            Iterator<iff> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                iff next = it.next();
                if (next.f1256O000000o == iff.f1256O000000o) {
                    next.O000000o();
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(iff);
            }
        }
    }

    public final void O000000o() {
        this.O0000o0.clear();
        this.O0000o0O.clear();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ifg.O000000o(_m_j.idl, _m_j.ife, boolean):_m_j.ifd
     arg types: [_m_j.idl, _m_j.ife, int]
     candidates:
      _m_j.ifg.O000000o(int, _m_j.idl, java.util.Map<com.xiaomi.zxing.DecodeHintType, ?>):_m_j.idf
      _m_j.iev.O000000o(int[], int[], float):float
      _m_j.iev.O000000o(_m_j.idl, int, int[]):void
      _m_j.iev.O000000o(int, _m_j.idl, java.util.Map<com.xiaomi.zxing.DecodeHintType, ?>):_m_j.idf
      _m_j.ifg.O000000o(_m_j.idl, _m_j.ife, boolean):_m_j.ifd */
    private iff O000000o(idl idl, boolean z, int i, Map<DecodeHintType, ?> map) {
        int i2;
        int i3;
        idh idh;
        idl idl2 = idl;
        boolean z2 = z;
        Map<DecodeHintType, ?> map2 = map;
        try {
            int[] iArr = this.f1255O000000o;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            int i4 = idl2.O00000Oo;
            int i5 = 0;
            boolean z3 = false;
            while (i5 < i4) {
                z3 = !idl2.O000000o(i5);
                if (z2 == z3) {
                    break;
                }
                i5++;
            }
            int i6 = i5;
            int i7 = 0;
            while (i5 < i4) {
                if (idl2.O000000o(i5) ^ z3) {
                    iArr[i7] = iArr[i7] + 1;
                    int i8 = i;
                } else {
                    if (i7 != 3) {
                        int i9 = i;
                        i7++;
                    } else if (O000000o(iArr)) {
                        int[] iArr2 = {i6, i5};
                        boolean O000000o2 = idl2.O000000o(iArr2[0]);
                        int i10 = iArr2[0] - 1;
                        while (i10 >= 0 && (idl2.O000000o(i10) ^ O000000o2)) {
                            i10--;
                        }
                        int i11 = i10 + 1;
                        int[] iArr3 = this.f1255O000000o;
                        System.arraycopy(iArr3, 0, iArr3, 1, iArr3.length - 1);
                        iArr3[0] = iArr2[0] - i11;
                        int O000000o3 = O000000o(iArr3, O0000o00);
                        int i12 = iArr2[1];
                        if (z2) {
                            i3 = (idl2.O00000Oo - 1) - i11;
                            i2 = (idl2.O00000Oo - 1) - i12;
                        } else {
                            i2 = i12;
                            i3 = i11;
                        }
                        ife ife = new ife(O000000o3, new int[]{i11, iArr2[1]}, i3, i2, i);
                        if (map2 == null) {
                            idh = null;
                        } else {
                            idh = (idh) map2.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                        }
                        if (idh != null) {
                            float f = ((float) (iArr2[0] + iArr2[1])) / 2.0f;
                            if (z2) {
                                f = ((float) (idl2.O00000Oo - 1)) - f;
                            }
                            idh.O000000o(new idg(f, (float) i));
                        }
                        ifd O000000o4 = O000000o(idl2, ife, true);
                        ifd O000000o5 = O000000o(idl2, ife, false);
                        return new iff((O000000o4.f1256O000000o * 1597) + O000000o5.f1256O000000o, O000000o4.O00000Oo + (O000000o5.O00000Oo * 4), ife);
                    } else {
                        int i13 = i;
                        i6 += iArr[0] + iArr[1];
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = 0;
                        iArr[3] = 0;
                        i7--;
                    }
                    iArr[i7] = 1;
                    z3 = !z3;
                }
                i5++;
            }
            throw NotFoundException.getNotFoundInstance();
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private ifd O000000o(idl idl, ife ife, boolean z) throws NotFoundException {
        idl idl2 = idl;
        ife ife2 = ife;
        boolean z2 = z;
        int[] iArr = this.O00000Oo;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
        if (z2) {
            O00000Oo(idl2, ife2.O00000Oo[0], iArr);
        } else {
            O000000o(idl2, ife2.O00000Oo[1] + 1, iArr);
            int i = 0;
            for (int length = iArr.length - 1; i < length; length--) {
                int i2 = iArr[i];
                iArr[i] = iArr[length];
                iArr[length] = i2;
                i++;
            }
        }
        int i3 = z2 ? 16 : 15;
        float O000000o2 = ((float) idw.O000000o(iArr)) / ((float) i3);
        int[] iArr2 = this.O00000oO;
        int[] iArr3 = this.O00000oo;
        float[] fArr = this.O00000o0;
        float[] fArr2 = this.O00000o;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f = ((float) iArr[i4]) / O000000o2;
            int i5 = (int) (f + 0.5f);
            if (i5 <= 0) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                iArr2[i6] = i5;
                fArr[i6] = f - ((float) i5);
            } else {
                iArr3[i6] = i5;
                fArr2[i6] = f - ((float) i5);
            }
        }
        O000000o(z2, i3);
        int i7 = 0;
        int i8 = 0;
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            i7 = (i7 * 9) + iArr2[length2];
            i8 += iArr2[length2];
        }
        int i9 = 0;
        int i10 = 0;
        for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
            i9 = (i9 * 9) + iArr3[length3];
            i10 += iArr3[length3];
        }
        int i11 = i7 + (i9 * 3);
        if (z2) {
            if ((i8 & 1) != 0 || i8 > 12 || i8 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i12 = (12 - i8) / 2;
            int i13 = O0000OoO[i12];
            return new ifd((ifh.O000000o(iArr2, i13, false) * O0000O0o[i12]) + ifh.O000000o(iArr3, 9 - i13, true) + O0000Oo0[i12], i11);
        } else if ((i10 & 1) != 0 || i10 > 10 || i10 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i14 = (10 - i10) / 2;
            int i15 = O0000Ooo[i14];
            return new ifd((ifh.O000000o(iArr3, 9 - i15, false) * O0000OOo[i14]) + ifh.O000000o(iArr2, i15, true) + O0000Oo[i14], i11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        if (r1 < 4) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    private void O000000o(boolean z, int i) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int O000000o2 = idw.O000000o(this.O00000oO);
        int O000000o3 = idw.O000000o(this.O00000oo);
        int i2 = (O000000o2 + O000000o3) - i;
        boolean z7 = false;
        boolean z8 = (O000000o2 & true) == z;
        boolean z9 = (O000000o3 & 1) == 1;
        if (z) {
            if (O000000o2 > 12) {
                z6 = false;
                z5 = true;
            } else {
                z6 = O000000o2 < 4;
                z5 = false;
            }
            if (O000000o3 > 12) {
                z2 = z6;
                z3 = z5;
            } else if (O000000o3 < 4) {
                z2 = z6;
                z3 = z5;
                z7 = true;
                z4 = false;
                if (i2 != 1) {
                    if (i2 == -1) {
                        if (z8) {
                            if (!z9) {
                                z2 = true;
                            } else {
                                throw NotFoundException.getNotFoundInstance();
                            }
                        } else if (z9) {
                            z7 = true;
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    } else if (i2 != 0) {
                        throw NotFoundException.getNotFoundInstance();
                    } else if (z8) {
                        if (!z9) {
                            throw NotFoundException.getNotFoundInstance();
                        } else if (O000000o2 < O000000o3) {
                            z2 = true;
                            z4 = true;
                        } else {
                            z7 = true;
                        }
                    } else if (z9) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (z2) {
                    }
                    if (z3) {
                    }
                    if (z7) {
                    }
                    if (z4) {
                    }
                } else if (!z8) {
                    if (!z9) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z4 = true;
                    if (z2) {
                        if (!z3) {
                            O000000o(this.O00000oO, this.O00000o0);
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                    if (z3) {
                        O00000Oo(this.O00000oO, this.O00000o0);
                    }
                    if (z7) {
                        if (!z4) {
                            O000000o(this.O00000oo, this.O00000o0);
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                    if (z4) {
                        O00000Oo(this.O00000oo, this.O00000o);
                        return;
                    }
                    return;
                } else if (z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z3 = true;
                if (z2) {
                }
                if (z3) {
                }
                if (z7) {
                }
                if (z4) {
                }
            } else {
                z2 = z6;
                z3 = z5;
                z4 = false;
                if (i2 != 1) {
                }
                z3 = true;
                if (z2) {
                }
                if (z3) {
                }
                if (z7) {
                }
                if (z4) {
                }
            }
        } else {
            if (O000000o2 > 11) {
                z2 = false;
                z3 = true;
            } else {
                z2 = O000000o2 < 5;
                z3 = false;
            }
            if (O000000o3 <= 10) {
            }
        }
        z4 = true;
        if (i2 != 1) {
        }
        z3 = true;
        if (z2) {
        }
        if (z3) {
        }
        if (z7) {
        }
        if (z4) {
        }
    }
}
