package _m_j;

import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.pdf417.decoder.DecodedBitStreamParser;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class igp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final igq f1277O000000o = new igq();

    private static boolean O000000o(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.igp.O000000o(_m_j.idm, _m_j.igj, _m_j.idg, boolean, int, int):_m_j.ign
     arg types: [_m_j.idm, _m_j.igj, _m_j.idg, int, int, int]
     candidates:
      _m_j.igp.O000000o(_m_j.idm, int, int, boolean, int, int):int[]
      _m_j.igp.O000000o(_m_j.idm, _m_j.igj, _m_j.idg, boolean, int, int):_m_j.ign */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r3.O00000oO != r4.O00000oO) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x00c0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    public static ido O000000o(idm idm, idg idg, idg idg2, idg idg3, idg idg4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        ign ign;
        int i3;
        int i4;
        igk[] igkArr;
        boolean z;
        int i5;
        igm igm;
        igk igk;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        igh igh;
        igj igj = new igj(idm, idg, idg2, idg3, idg4);
        int i12 = 0;
        ign ign2 = null;
        igl igl = null;
        ign ign3 = null;
        while (true) {
            if (i12 >= 2) {
                ign = ign2;
                break;
            }
            if (idg != null) {
                ign2 = O000000o(idm, igj, idg, true, i, i2);
            }
            ign = ign2;
            if (idg3 != null) {
                ign3 = O000000o(idm, igj, idg3, false, i, i2);
            }
            if (!(ign == null && ign3 == null)) {
                if (ign != null && (igh = ign.O00000Oo()) != null) {
                    if (ign3 != null) {
                        igh O00000Oo = ign3.O00000Oo();
                        if (O00000Oo != null) {
                            if (igh.f1270O000000o != O00000Oo.f1270O000000o) {
                                if (igh.O00000Oo != O00000Oo.O00000Oo) {
                                }
                            }
                        }
                    }
                    if (igh != null) {
                    }
                } else if (ign3 != null) {
                    igh = ign3.O00000Oo();
                    if (igh != null) {
                        igj O000000o2 = O000000o(ign);
                        igj O000000o3 = O000000o(ign3);
                        if (O000000o2 == null) {
                            O000000o2 = O000000o3;
                        } else if (O000000o3 != null) {
                            O000000o2 = new igj(O000000o2.f1272O000000o, O000000o2.O00000Oo, O000000o2.O00000o0, O000000o3.O00000o, O000000o3.O00000oO);
                        }
                        igl = new igl(igh, O000000o2);
                        if (igl != null) {
                            throw NotFoundException.getNotFoundInstance();
                        } else if (i12 != 0 || igl.O00000o0 == null || (igl.O00000o0.O0000OOo >= igj.O0000OOo && igl.O00000o0.O0000Oo0 <= igj.O0000Oo0)) {
                            igl.O00000o0 = igj;
                        } else {
                            igj = igl.O00000o0;
                            i12++;
                            ign2 = ign;
                        }
                    }
                }
                igh = null;
                if (igh != null) {
                }
            }
            igl = null;
            if (igl != null) {
            }
        }
        igl.O00000o0 = igj;
        int i13 = igl.O00000o + 1;
        igl.O00000Oo[0] = ign;
        igl.O00000Oo[i13] = ign3;
        boolean z2 = ign != null;
        int i14 = i;
        int i15 = i2;
        int i16 = 1;
        while (i16 <= i13) {
            int i17 = z2 ? i16 : i13 - i16;
            if (igl.O00000Oo[i17] == null) {
                if (i17 == 0 || i17 == i13) {
                    igm = new ign(igj, i17 == 0);
                } else {
                    igm = new igm(igj);
                }
                igl.O00000Oo[i17] = igm;
                int i18 = i15;
                int i19 = i14;
                int i20 = igj.O0000OOo;
                int i21 = -1;
                while (i20 <= igj.O0000Oo0) {
                    int i22 = z2 ? 1 : -1;
                    int i23 = i17 - i22;
                    if (O000000o(igl, i23)) {
                        igk = igl.O00000Oo[i23].O00000o0(i20);
                    } else {
                        igk = null;
                    }
                    if (igk == null) {
                        igk O000000o4 = igl.O00000Oo[i17].O000000o(i20);
                        if (O000000o4 == null) {
                            if (O000000o(igl, i23)) {
                                O000000o4 = igl.O00000Oo[i23].O000000o(i20);
                            }
                            if (O000000o4 == null) {
                                int i24 = i17;
                                int i25 = 0;
                                while (true) {
                                    int i26 = i24 - i22;
                                    if (O000000o(igl, i26)) {
                                        igk[] igkArr2 = igl.O00000Oo[i26].O00000Oo;
                                        int length = igkArr2.length;
                                        int i27 = i26;
                                        int i28 = 0;
                                        while (i28 < length) {
                                            i6 = i13;
                                            igk igk2 = igkArr2[i28];
                                            if (igk2 != null) {
                                                if (z2) {
                                                    i11 = igk2.O00000Oo;
                                                } else {
                                                    i11 = igk2.f1273O000000o;
                                                }
                                                i7 = (i22 * i25 * (igk2.O00000Oo - igk2.f1273O000000o)) + i11;
                                            } else {
                                                i28++;
                                                i13 = i6;
                                            }
                                        }
                                        i25++;
                                        i24 = i27;
                                    } else {
                                        i6 = i13;
                                        if (z2) {
                                            i7 = igl.O00000o0.O00000oo;
                                        } else {
                                            i7 = igl.O00000o0.O0000O0o;
                                        }
                                    }
                                }
                                if (i7 < 0 && i7 <= igj.O0000O0o) {
                                    i10 = i7;
                                } else if (i21 == -1) {
                                    i10 = i21;
                                } else {
                                    i9 = i21;
                                    i8 = i18;
                                    i21 = i9;
                                    i18 = i8;
                                    i20++;
                                    i13 = i6;
                                }
                                i9 = i21;
                                i8 = i18;
                                igk O000000o5 = O000000o(idm, igj.O00000oo, igj.O0000O0o, z2, i10, i20, i19, i8);
                                if (O000000o5 != null) {
                                    igm.O000000o(i20, O000000o5);
                                    i19 = Math.min(i19, O000000o5.O00000o0());
                                    i18 = Math.max(i8, O000000o5.O00000o0());
                                    i21 = i10;
                                    i20++;
                                    i13 = i6;
                                }
                                i21 = i9;
                                i18 = i8;
                                i20++;
                                i13 = i6;
                            } else if (z2) {
                                i7 = O000000o4.O00000Oo;
                            } else {
                                i7 = O000000o4.f1273O000000o;
                            }
                        } else if (z2) {
                            i7 = O000000o4.f1273O000000o;
                        } else {
                            i7 = O000000o4.O00000Oo;
                        }
                    } else if (z2) {
                        i7 = igk.O00000Oo;
                    } else {
                        i7 = igk.f1273O000000o;
                    }
                    i6 = i13;
                    if (i7 < 0) {
                    }
                    if (i21 == -1) {
                    }
                }
                i5 = i13;
                i14 = i19;
                i15 = i18;
            } else {
                i5 = i13;
            }
            i16++;
            i13 = i5;
        }
        igi[][] igiArr = (igi[][]) Array.newInstance(igi.class, igl.f1274O000000o.O00000oO, igl.O00000o + 2);
        for (int i29 = 0; i29 < igiArr.length; i29++) {
            for (int i30 = 0; i30 < igiArr[i29].length; i30++) {
                igiArr[i29][i30] = new igi();
            }
        }
        char c = 0;
        igl.O000000o(igl.O00000Oo[0]);
        int i31 = 1;
        igl.O000000o(igl.O00000Oo[igl.O00000o + 1]);
        int i32 = 928;
        while (true) {
            if (!(igl.O00000Oo[c] == null || igl.O00000Oo[igl.O00000o + i31] == null)) {
                igk[] igkArr3 = igl.O00000Oo[c].O00000Oo;
                igk[] igkArr4 = igl.O00000Oo[igl.O00000o + i31].O00000Oo;
                for (int i33 = 0; i33 < igkArr3.length; i33++) {
                    if (!(igkArr3[i33] == null || igkArr4[i33] == null || igkArr3[i33].O00000oO != igkArr4[i33].O00000oO)) {
                        for (int i34 = 1; i34 <= igl.O00000o; i34++) {
                            igk igk3 = igl.O00000Oo[i34].O00000Oo[i33];
                            if (igk3 != null) {
                                igk3.O00000oO = igkArr3[i33].O00000oO;
                                if (!igk3.O000000o()) {
                                    igl.O00000Oo[i34].O00000Oo[i33] = null;
                                }
                            }
                        }
                    }
                }
            }
            int i35 = 0;
            if (igl.O00000Oo[0] != null) {
                igk[] igkArr5 = igl.O00000Oo[0].O00000Oo;
                int i36 = 0;
                for (int i37 = 0; i37 < igkArr5.length; i37++) {
                    if (igkArr5[i37] != null) {
                        int i38 = igkArr5[i37].O00000oO;
                        int i39 = i36;
                        int i40 = 0;
                        for (int i41 = 1; i41 < igl.O00000o + 1 && i40 < 2; i41++) {
                            igk igk4 = igl.O00000Oo[i41].O00000Oo[i37];
                            if (igk4 != null) {
                                i40 = igl.O000000o(i38, i40, igk4);
                                if (!igk4.O000000o()) {
                                    i39++;
                                }
                            }
                        }
                        i36 = i39;
                    }
                }
                i35 = i36;
            }
            int i42 = 1;
            if (igl.O00000Oo[igl.O00000o + 1] == null) {
                i3 = 0;
            } else {
                igk[] igkArr6 = igl.O00000Oo[igl.O00000o + 1].O00000Oo;
                int i43 = 0;
                i3 = 0;
                while (i43 < igkArr6.length) {
                    if (igkArr6[i43] != null) {
                        int i44 = igkArr6[i43].O00000oO;
                        int i45 = 0;
                        for (int i46 = igl.O00000o + i42; i46 > 0 && i45 < 2; i46--) {
                            igk igk5 = igl.O00000Oo[i46].O00000Oo[i43];
                            if (igk5 != null) {
                                i45 = igl.O000000o(i44, i45, igk5);
                                if (!igk5.O000000o()) {
                                    i3++;
                                }
                            }
                        }
                    }
                    i43++;
                    i42 = 1;
                }
            }
            int i47 = i35 + i3;
            if (i47 == 0) {
                i47 = 0;
            } else {
                for (int i48 = 1; i48 < igl.O00000o + 1; i48++) {
                    igk[] igkArr7 = igl.O00000Oo[i48].O00000Oo;
                    for (int i49 = 0; i49 < igkArr7.length; i49++) {
                        if (igkArr7[i49] != null && !igkArr7[i49].O000000o()) {
                            igk igk6 = igkArr7[i49];
                            igk[] igkArr8 = igl.O00000Oo[i48 - 1].O00000Oo;
                            int i50 = i48 + 1;
                            if (igl.O00000Oo[i50] != null) {
                                igkArr = igl.O00000Oo[i50].O00000Oo;
                            } else {
                                igkArr = igkArr8;
                            }
                            igk[] igkArr9 = new igk[14];
                            igkArr9[2] = igkArr8[i49];
                            igkArr9[3] = igkArr[i49];
                            if (i49 > 0) {
                                int i51 = i49 - 1;
                                igkArr9[0] = igkArr7[i51];
                                igkArr9[4] = igkArr8[i51];
                                igkArr9[5] = igkArr[i51];
                            }
                            if (i49 > 1) {
                                int i52 = i49 - 2;
                                igkArr9[8] = igkArr7[i52];
                                igkArr9[10] = igkArr8[i52];
                                igkArr9[11] = igkArr[i52];
                            }
                            if (i49 < igkArr7.length - 1) {
                                int i53 = i49 + 1;
                                igkArr9[1] = igkArr7[i53];
                                igkArr9[6] = igkArr8[i53];
                                igkArr9[7] = igkArr[i53];
                            }
                            if (i49 < igkArr7.length - 2) {
                                int i54 = i49 + 2;
                                igkArr9[9] = igkArr7[i54];
                                igkArr9[12] = igkArr8[i54];
                                igkArr9[13] = igkArr[i54];
                            }
                            for (int i55 = 0; i55 < 14; i55++) {
                                igk igk7 = igkArr9[i55];
                                if (igk7 == null || !igk7.O000000o() || igk7.O00000o0 != igk6.O00000o0) {
                                    z = false;
                                } else {
                                    igk6.O00000oO = igk7.O00000oO;
                                    z = true;
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (i47 <= 0 || i47 >= i32) {
                int i56 = 0;
            } else {
                i32 = i47;
                c = 0;
                i31 = 1;
            }
        }
        int i562 = 0;
        for (igm igm2 : igl.O00000Oo) {
            if (igm2 != null) {
                for (igk igk8 : igm2.O00000Oo) {
                    if (igk8 != null && (i4 = igk8.O00000oO) >= 0 && i4 < igiArr.length) {
                        igiArr[i4][i562].O000000o(igk8.O00000o);
                    }
                }
            }
            i562++;
        }
        int[] O000000o6 = igiArr[0][1].O000000o();
        int i57 = (igl.O00000o * igl.f1274O000000o.O00000oO) - (2 << igl.f1274O000000o.O00000Oo);
        if (O000000o6.length == 0) {
            if (i57 <= 0 || i57 > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            igiArr[0][1].O000000o(i57);
        } else if (O000000o6[0] != i57) {
            igiArr[0][1].O000000o(i57);
        }
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(igl.f1274O000000o.O00000oO * igl.O00000o)];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i58 = 0; i58 < igl.f1274O000000o.O00000oO; i58++) {
            int i59 = 0;
            while (i59 < igl.O00000o) {
                int i60 = i59 + 1;
                int[] O000000o7 = igiArr[i58][i60].O000000o();
                int i61 = (igl.O00000o * i58) + i59;
                if (O000000o7.length == 0) {
                    arrayList.add(Integer.valueOf(i61));
                } else if (O000000o7.length == 1) {
                    iArr[i61] = O000000o7[0];
                } else {
                    arrayList3.add(Integer.valueOf(i61));
                    arrayList2.add(O000000o7);
                }
                i59 = i60;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i62 = 0; i62 < iArr2.length; i62++) {
            iArr2[i62] = (int[]) arrayList2.get(i62);
        }
        return O000000o(igl.f1274O000000o.O00000Oo, iArr, ige.O000000o(arrayList), ige.O000000o(arrayList3), iArr2);
    }

    private static igj O000000o(ign ign) throws NotFoundException, FormatException {
        int[] O000000o2;
        if (ign == null || (O000000o2 = ign.O000000o()) == null) {
            return null;
        }
        int O000000o3 = O000000o(O000000o2);
        int i = 0;
        int i2 = 0;
        for (int i3 : O000000o2) {
            i2 += O000000o3 - i3;
            if (i3 > 0) {
                break;
            }
        }
        igk[] igkArr = ign.O00000Oo;
        int i4 = 0;
        while (i2 > 0 && igkArr[i4] == null) {
            i2--;
            i4++;
        }
        for (int length = O000000o2.length - 1; length >= 0; length--) {
            i += O000000o3 - O000000o2[length];
            if (O000000o2[length] > 0) {
                break;
            }
        }
        int length2 = igkArr.length - 1;
        while (i > 0 && igkArr[length2] == null) {
            i--;
            length2--;
        }
        return ign.f1275O000000o.O000000o(i2, i, ign.O00000o0);
    }

    private static int O000000o(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static ign O000000o(idm idm, igj igj, idg idg, boolean z, int i, int i2) {
        igj igj2 = igj;
        idg idg2 = idg;
        boolean z2 = z;
        ign ign = new ign(igj2, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int i5 = (int) idg2.f1209O000000o;
            int i6 = (int) idg2.O00000Oo;
            while (i6 <= igj2.O0000Oo0 && i6 >= igj2.O0000OOo) {
                igk O000000o2 = O000000o(idm, 0, idm.f1214O000000o, z, i5, i6, i, i2);
                if (O000000o2 != null) {
                    ign.O000000o(i6, O000000o2);
                    if (z2) {
                        i5 = O000000o2.f1273O000000o;
                    } else {
                        i5 = O000000o2.O00000Oo;
                    }
                }
                i6 += i4;
            }
            i3++;
        }
        return ign;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0220, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0226, code lost:
        throw com.xiaomi.zxing.ChecksumException.getChecksumInstance();
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x025d A[SYNTHETIC] */
    private static ido O000000o(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int i2;
        int i3;
        int i4;
        igs igs;
        int i5;
        igs igs2;
        int[] iArr5 = iArr;
        int[] iArr6 = iArr2;
        int[] iArr7 = iArr3;
        int[] iArr8 = new int[iArr7.length];
        int i6 = 100;
        while (true) {
            int i7 = i6 - 1;
            if (i6 > 0) {
                for (int i8 = 0; i8 < iArr8.length; i8++) {
                    iArr5[iArr7[i8]] = iArr4[i8][iArr8[i8]];
                }
                int i9 = 1;
                try {
                    if (iArr5.length != 0) {
                        i3 = 1 << (i + 1);
                        if ((iArr6 == null || iArr6.length <= (i3 / 2) + 3) && i3 >= 0 && i3 <= 512) {
                            igq igq = f1277O000000o;
                            igs igs3 = new igs(igq.f1278O000000o, iArr5);
                            int[] iArr9 = new int[i3];
                            boolean z = false;
                            for (int i10 = i3; i10 > 0; i10--) {
                                int O00000Oo = igs3.O00000Oo(igq.f1278O000000o.O00000Oo[i10]);
                                iArr9[i3 - i10] = O00000Oo;
                                if (O00000Oo != 0) {
                                    z = true;
                                }
                            }
                            if (!z) {
                                int i11 = i7;
                                i4 = 0;
                                break;
                            }
                            igs igs4 = igq.f1278O000000o.O00000oO;
                            int i12 = 2;
                            if (iArr6 != null) {
                                int length = iArr6.length;
                                igs igs5 = igs4;
                                int i13 = 0;
                                while (i13 < length) {
                                    int i14 = iArr6[i13];
                                    int i15 = igq.f1278O000000o.O00000Oo[(iArr5.length - i9) - i14];
                                    igr igr = igq.f1278O000000o;
                                    int[] iArr10 = new int[i12];
                                    iArr10[0] = igq.f1278O000000o.O00000o0(0, i15);
                                    iArr10[1] = 1;
                                    igs5 = igs5.O00000o0(new igs(igr, iArr10));
                                    i13++;
                                    int[] iArr11 = iArr3;
                                    i9 = 1;
                                    i12 = 2;
                                }
                            }
                            igs igs6 = new igs(igq.f1278O000000o, iArr9);
                            igs O000000o2 = igq.f1278O000000o.O000000o(i3, 1);
                            if (O000000o2.O00000Oo.length - 1 >= igs6.O00000Oo.length - 1) {
                                igs igs7 = O000000o2;
                                O000000o2 = igs6;
                                igs6 = igs7;
                            }
                            igs igs8 = O000000o2;
                            igs igs9 = igs6;
                            igs igs10 = igs8;
                            igs igs11 = igq.f1278O000000o.O00000o;
                            igs igs12 = igq.f1278O000000o.O00000oO;
                            while (igs10.O00000Oo.length - 1 >= i3 / 2) {
                                if (!igs10.O000000o()) {
                                    igs igs13 = igq.f1278O000000o.O00000o;
                                    int O000000o3 = igq.f1278O000000o.O000000o(igs10.O000000o(igs10.O00000Oo.length - 1));
                                    while (igs9.O00000Oo.length - 1 >= igs10.O00000Oo.length - 1 && !igs9.O000000o()) {
                                        int length2 = (igs9.O00000Oo.length - 1) - (igs10.O00000Oo.length - 1);
                                        int O00000o = igq.f1278O000000o.O00000o(igs9.O000000o(igs9.O00000Oo.length - 1), O000000o3);
                                        igs O000000o4 = igs13.O000000o(igq.f1278O000000o.O000000o(length2, O00000o));
                                        if (length2 >= 0) {
                                            if (O00000o == 0) {
                                                igs2 = igs10.f1280O000000o.O00000o;
                                                i5 = i7;
                                                igs = O000000o4;
                                            } else {
                                                int length3 = igs10.O00000Oo.length;
                                                int[] iArr12 = new int[(length2 + length3)];
                                                int i16 = 0;
                                                while (i16 < length3) {
                                                    i2 = i7;
                                                    try {
                                                        iArr12[i16] = igs10.f1280O000000o.O00000o(igs10.O00000Oo[i16], O00000o);
                                                        i16++;
                                                        i7 = i2;
                                                        O000000o4 = O000000o4;
                                                    } catch (ChecksumException unused) {
                                                        if (iArr8.length == 0) {
                                                            int i17 = 0;
                                                            while (true) {
                                                                if (i17 >= iArr8.length) {
                                                                    break;
                                                                } else if (iArr8[i17] < iArr4[i17].length - 1) {
                                                                    iArr8[i17] = iArr8[i17] + 1;
                                                                    break;
                                                                } else {
                                                                    iArr8[i17] = 0;
                                                                    if (i17 != iArr8.length - 1) {
                                                                        i17++;
                                                                    } else {
                                                                        throw ChecksumException.getChecksumInstance();
                                                                    }
                                                                }
                                                            }
                                                            iArr7 = iArr3;
                                                            i6 = i2;
                                                        } else {
                                                            throw ChecksumException.getChecksumInstance();
                                                        }
                                                    }
                                                }
                                                i5 = i7;
                                                igs = O000000o4;
                                                igs2 = new igs(igs10.f1280O000000o, iArr12);
                                            }
                                            igs9 = igs9.O00000Oo(igs2);
                                            i7 = i5;
                                            igs13 = igs;
                                        } else {
                                            int i18 = i7;
                                            throw new IllegalArgumentException();
                                        }
                                    }
                                    igs11 = igs12;
                                    igs12 = igs13.O00000o0(igs12).O00000Oo(igs11).O00000Oo();
                                    i7 = i7;
                                    igs igs14 = igs9;
                                    igs9 = igs10;
                                    igs10 = igs14;
                                } else {
                                    int i19 = i7;
                                    throw ChecksumException.getChecksumInstance();
                                }
                            }
                            int i20 = i7;
                            int O000000o5 = igs12.O000000o(0);
                            if (O000000o5 != 0) {
                                int O000000o6 = igq.f1278O000000o.O000000o(O000000o5);
                                igs[] igsArr = {igs12.O00000o0(O000000o6), igs10.O00000o0(O000000o6)};
                                igs igs15 = igsArr[0];
                                igs igs16 = igsArr[1];
                                int[] O000000o7 = igq.O000000o(igs15);
                                int[] O000000o8 = igq.O000000o(igs16, igs15, O000000o7);
                                int i21 = 0;
                                while (i21 < O000000o7.length) {
                                    int length4 = iArr5.length - 1;
                                    igr igr2 = igq.f1278O000000o;
                                    int i22 = O000000o7[i21];
                                    if (i22 != 0) {
                                        int i23 = length4 - igr2.O00000o0[i22];
                                        if (i23 >= 0) {
                                            iArr5[i23] = igq.f1278O000000o.O00000o0(iArr5[i23], O000000o8[i21]);
                                            i21++;
                                        } else {
                                            throw ChecksumException.getChecksumInstance();
                                        }
                                    } else {
                                        throw new IllegalArgumentException();
                                    }
                                }
                                i4 = O000000o7.length;
                            } else {
                                throw ChecksumException.getChecksumInstance();
                            }
                        }
                    } else {
                        int i24 = i7;
                        throw FormatException.getFormatInstance();
                    }
                } catch (ChecksumException unused2) {
                    i2 = i7;
                    if (iArr8.length == 0) {
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
            iArr7 = iArr3;
            i6 = i2;
        }
        if (iArr5.length >= 4) {
            int i25 = iArr5[0];
            if (i25 <= iArr5.length) {
                if (i25 == 0) {
                    if (i3 < iArr5.length) {
                        iArr5[0] = iArr5.length - i3;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                ido O000000o9 = DecodedBitStreamParser.O000000o(iArr5, String.valueOf(i));
                O000000o9.O00000oO = Integer.valueOf(i4);
                O000000o9.O00000oo = Integer.valueOf(iArr6.length);
                return O000000o9;
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }

    private static igk O000000o(idm idm, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int O000000o2;
        int O000000o3;
        int O00000Oo = O00000Oo(idm, i, i2, z, i3, i4);
        int[] O000000o4 = O000000o(idm, i, i2, z, O00000Oo, i4);
        if (O000000o4 == null) {
            return null;
        }
        int O000000o5 = idw.O000000o(O000000o4);
        if (z) {
            int i8 = O00000Oo;
            O00000Oo += O000000o5;
            i7 = i8;
        } else {
            for (int i9 = 0; i9 < O000000o4.length / 2; i9++) {
                int i10 = O000000o4[i9];
                O000000o4[i9] = O000000o4[(O000000o4.length - 1) - i9];
                O000000o4[(O000000o4.length - 1) - i9] = i10;
            }
            i7 = O00000Oo - O000000o5;
        }
        if (O000000o(O000000o5, i5, i6) && (O000000o3 = ige.O000000o((O000000o2 = igo.O000000o(O000000o4)))) != -1) {
            return new igk(i7, O00000Oo, O00000Oo(O000000o2), O000000o3);
        }
        return null;
    }

    private static int[] O000000o(idm idm, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= 8) {
                break;
            } else if (idm.O000000o(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (!(i3 == i && i6 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    private static int O00000Oo(idm idm, int i, int i2, boolean z, int i3, int i4) {
        boolean z2 = z;
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z2) {
                    if (i6 >= i2) {
                        break;
                    }
                } else if (i6 < i) {
                    break;
                }
                if (z2 != idm.O000000o(i6, i4)) {
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z2 = !z2;
        }
        return i6;
    }

    private static int[] O000000o(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int O00000Oo(int i) {
        return O00000Oo(O000000o(i));
    }

    private static int O00000Oo(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static boolean O000000o(igl igl, int i) {
        return i >= 0 && i <= igl.O00000o + 1;
    }
}
