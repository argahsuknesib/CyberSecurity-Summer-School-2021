package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ResultMetadataType;
import com.xiaomi.zxing.qrcode.detector.FinderPatternFinder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class igv implements ide {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final idg[] f1283O000000o = new idg[0];
    private final iha O00000Oo = new iha();

    public final void O000000o() {
    }

    public final idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        idg[] idgArr;
        ido ido;
        boolean z;
        idh idh;
        int i;
        int i2;
        char c;
        int i3;
        int i4;
        Map<DecodeHintType, ?> map2 = map;
        char c2 = 3;
        int i5 = 0;
        if (map2 == null || !map2.containsKey(DecodeHintType.PURE_BARCODE)) {
            ihg ihg = new ihg(icy.O00000Oo());
            if (map2 == null) {
                idh = null;
            } else {
                idh = (idh) map2.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            ihg.O00000Oo = idh;
            FinderPatternFinder finderPatternFinder = new FinderPatternFinder(ihg.f1294O000000o, ihg.O00000Oo);
            boolean z2 = map2 != null && map2.containsKey(DecodeHintType.TRY_HARDER);
            boolean z3 = map2 != null && map2.containsKey(DecodeHintType.PURE_BARCODE);
            int i6 = finderPatternFinder.f12119O000000o.O00000Oo;
            int i7 = finderPatternFinder.f12119O000000o.f1214O000000o;
            int i8 = (i6 * 3) / 228;
            if (i8 < 3 || z2) {
                i8 = 3;
            }
            int[] iArr = new int[5];
            int i9 = i8 - 1;
            int i10 = i8;
            boolean z4 = false;
            while (i9 < i6 && !z4) {
                iArr[i5] = i5;
                iArr[1] = i5;
                iArr[2] = i5;
                iArr[c2] = i5;
                int i11 = 4;
                iArr[4] = i5;
                boolean z5 = z4;
                int i12 = i10;
                int i13 = 0;
                int i14 = i9;
                int i15 = 0;
                while (i15 < i7) {
                    if (finderPatternFinder.f12119O000000o.O000000o(i15, i14)) {
                        if ((i13 & 1) == 1) {
                            i13++;
                        }
                        iArr[i13] = iArr[i13] + 1;
                    } else if ((i13 & 1) != 0) {
                        iArr[i13] = iArr[i13] + 1;
                    } else if (i13 == i11) {
                        if (!FinderPatternFinder.O000000o(iArr)) {
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = iArr[4];
                            iArr[3] = 1;
                            iArr[4] = 0;
                        } else if (finderPatternFinder.O000000o(iArr, i14, i15, z3)) {
                            if (finderPatternFinder.O00000o0) {
                                z5 = finderPatternFinder.O000000o();
                                i3 = 0;
                                c = 2;
                            } else {
                                if (finderPatternFinder.O00000Oo.size() > 1) {
                                    Iterator<ihh> it = finderPatternFinder.O00000Oo.iterator();
                                    ihh ihh = null;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        ihh next = it.next();
                                        if (next.O00000o >= 2) {
                                            if (ihh != null) {
                                                finderPatternFinder.O00000o0 = true;
                                                c = 2;
                                                i4 = ((int) (Math.abs(ihh.f1209O000000o - next.f1209O000000o) - Math.abs(ihh.O00000Oo - next.O00000Oo))) / 2;
                                                break;
                                            }
                                            ihh = next;
                                        }
                                    }
                                }
                                c = 2;
                                i4 = 0;
                                if (i4 > iArr[c]) {
                                    i14 += (i4 - iArr[c]) - 2;
                                    i15 = i7 - 1;
                                }
                                i3 = 0;
                            }
                            iArr[i3] = i3;
                            iArr[1] = i3;
                            iArr[c] = i3;
                            iArr[3] = i3;
                            iArr[4] = i3;
                            i13 = 0;
                            i12 = 2;
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = iArr[4];
                            iArr[3] = 1;
                            iArr[4] = 0;
                        }
                        i13 = 3;
                    } else {
                        int i16 = i13 + 1;
                        iArr[i16] = iArr[i16] + 1;
                        i13 = i16;
                    }
                    i15++;
                    i11 = 4;
                }
                if (!FinderPatternFinder.O000000o(iArr) || !finderPatternFinder.O000000o(iArr, i14, i7, z3)) {
                    i10 = i12;
                } else {
                    int i17 = iArr[0];
                    if (finderPatternFinder.O00000o0) {
                        z5 = finderPatternFinder.O000000o();
                    }
                    i10 = i17;
                }
                i9 = i14 + i10;
                z4 = z5;
                c2 = 3;
                i5 = 0;
            }
            int size = finderPatternFinder.O00000Oo.size();
            if (size >= 3) {
                float f = 0.0f;
                if (size > 3) {
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    for (ihh ihh2 : finderPatternFinder.O00000Oo) {
                        float f4 = ihh2.O00000o0;
                        f2 += f4;
                        f3 += f4 * f4;
                    }
                    float f5 = (float) size;
                    float f6 = f2 / f5;
                    float sqrt = (float) Math.sqrt((double) ((f3 / f5) - (f6 * f6)));
                    Collections.sort(finderPatternFinder.O00000Oo, new FinderPatternFinder.FurthestFromAverageComparator(f6, (byte) 0));
                    float max = Math.max(0.2f * f6, sqrt);
                    int i18 = 0;
                    while (i18 < finderPatternFinder.O00000Oo.size() && finderPatternFinder.O00000Oo.size() > 3) {
                        if (Math.abs(finderPatternFinder.O00000Oo.get(i18).O00000o0 - f6) > max) {
                            finderPatternFinder.O00000Oo.remove(i18);
                            i18--;
                        }
                        i18++;
                    }
                }
                if (finderPatternFinder.O00000Oo.size() > 3) {
                    for (ihh ihh3 : finderPatternFinder.O00000Oo) {
                        f += ihh3.O00000o0;
                    }
                    i = 0;
                    Collections.sort(finderPatternFinder.O00000Oo, new FinderPatternFinder.CenterComparator(f / ((float) finderPatternFinder.O00000Oo.size()), (byte) 0));
                    i2 = 3;
                    finderPatternFinder.O00000Oo.subList(3, finderPatternFinder.O00000Oo.size()).clear();
                } else {
                    i2 = 3;
                    i = 0;
                }
                ihh[] ihhArr = new ihh[i2];
                ihhArr[i] = finderPatternFinder.O00000Oo.get(i);
                ihhArr[1] = finderPatternFinder.O00000Oo.get(1);
                ihhArr[2] = finderPatternFinder.O00000Oo.get(2);
                idg.O000000o(ihhArr);
                idq O000000o2 = ihg.O000000o(new ihi(ihhArr));
                ido = this.O00000Oo.O000000o(O000000o2.O00000o, map2);
                idgArr = O000000o2.O00000oO;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            idm O00000Oo2 = icy.O00000Oo();
            int[] O000000o3 = O00000Oo2.O000000o();
            int[] O00000Oo3 = O00000Oo2.O00000Oo();
            if (O000000o3 == null || O00000Oo3 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i19 = O00000Oo2.O00000Oo;
            int i20 = O00000Oo2.f1214O000000o;
            int i21 = O000000o3[0];
            int i22 = O000000o3[1];
            boolean z6 = true;
            int i23 = 0;
            while (i21 < i20 && i22 < i19) {
                if (z6 != O00000Oo2.O000000o(i21, i22)) {
                    i23++;
                    if (i23 == 5) {
                        break;
                    }
                    z6 = !z6;
                }
                i21++;
                i22++;
            }
            if (i21 == i20 || i22 == i19) {
                throw NotFoundException.getNotFoundInstance();
            }
            float f7 = ((float) (i21 - O000000o3[0])) / 7.0f;
            int i24 = O000000o3[1];
            int i25 = O00000Oo3[1];
            int i26 = O000000o3[0];
            int i27 = O00000Oo3[0];
            if (i26 >= i27 || i24 >= i25) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i28 = i25 - i24;
            if (i28 == i27 - i26 || (i27 = i26 + i28) < O00000Oo2.f1214O000000o) {
                int round = Math.round(((float) ((i27 - i26) + 1)) / f7);
                int round2 = Math.round(((float) (i28 + 1)) / f7);
                if (round <= 0 || round2 <= 0) {
                    throw NotFoundException.getNotFoundInstance();
                } else if (round2 == round) {
                    int i29 = (int) (f7 / 2.0f);
                    int i30 = i24 + i29;
                    int i31 = i26 + i29;
                    int i32 = (((int) (((float) (round - 1)) * f7)) + i31) - i27;
                    if (i32 > 0) {
                        if (i32 <= i29) {
                            i31 -= i32;
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                    int i33 = (((int) (((float) (round2 - 1)) * f7)) + i30) - i25;
                    if (i33 > 0) {
                        if (i33 <= i29) {
                            i30 -= i33;
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                    idm idm = new idm(round, round2);
                    for (int i34 = 0; i34 < round2; i34++) {
                        int i35 = ((int) (((float) i34) * f7)) + i30;
                        for (int i36 = 0; i36 < round; i36++) {
                            if (O00000Oo2.O000000o(((int) (((float) i36) * f7)) + i31, i35)) {
                                idm.O00000Oo(i36, i34);
                            }
                        }
                    }
                    ido = this.O00000Oo.O000000o(idm, map2);
                    idgArr = f1283O000000o;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (!(ido.O0000O0o instanceof ihc) || !((ihc) ido.O0000O0o).f1289O000000o || idgArr == null || idgArr.length < 3) {
            z = false;
        } else {
            z = false;
            idg idg = idgArr[0];
            idgArr[0] = idgArr[2];
            idgArr[2] = idg;
        }
        idf idf = new idf(ido.O00000Oo, ido.f1216O000000o, idgArr, BarcodeFormat.QR_CODE);
        List<byte[]> list = ido.O00000o0;
        if (list != null) {
            idf.O000000o(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str = ido.O00000o;
        if (str != null) {
            idf.O000000o(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        if (ido.O0000OOo >= 0 && ido.O0000Oo0 >= 0) {
            z = true;
        }
        if (z) {
            idf.O000000o(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(ido.O0000Oo0));
            idf.O000000o(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(ido.O0000OOo));
        }
        return idf;
    }
}
