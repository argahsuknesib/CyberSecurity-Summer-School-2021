package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ResultMetadataType;
import com.xiaomi.zxing.datamatrix.detector.Detector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class iec implements ide {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final idg[] f1227O000000o = new idg[0];
    private final ief O00000Oo = new ief();

    public final void O000000o() {
    }

    public final idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        idg[] idgArr;
        ido ido;
        idg idg;
        idm idm;
        Map<DecodeHintType, ?> map2 = map;
        if (map2 == null || !map2.containsKey(DecodeHintType.PURE_BARCODE)) {
            Detector detector = new Detector(icy.O00000Oo());
            idg[] O000000o2 = detector.O00000Oo.O000000o();
            idg idg2 = O000000o2[0];
            idg idg3 = O000000o2[1];
            idg idg4 = O000000o2[2];
            idg idg5 = O000000o2[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(detector.O00000Oo(idg2, idg3));
            arrayList.add(detector.O00000Oo(idg2, idg4));
            arrayList.add(detector.O00000Oo(idg3, idg5));
            arrayList.add(detector.O00000Oo(idg4, idg5));
            Collections.sort(arrayList, new Detector.ResultPointsAndTransitionsComparator((byte) 0));
            Detector.O000000o o000000o = (Detector.O000000o) arrayList.get(0);
            Detector.O000000o o000000o2 = (Detector.O000000o) arrayList.get(1);
            HashMap hashMap = new HashMap();
            Detector.O000000o(hashMap, o000000o.f12115O000000o);
            Detector.O000000o(hashMap, o000000o.O00000Oo);
            Detector.O000000o(hashMap, o000000o2.f12115O000000o);
            Detector.O000000o(hashMap, o000000o2.O00000Oo);
            idg idg6 = null;
            idg idg7 = null;
            idg idg8 = null;
            for (Map.Entry entry : hashMap.entrySet()) {
                idg idg9 = (idg) entry.getKey();
                if (((Integer) entry.getValue()).intValue() == 2) {
                    idg7 = idg9;
                } else if (idg6 == null) {
                    idg6 = idg9;
                } else {
                    idg8 = idg9;
                }
            }
            if (idg6 == null || idg7 == null || idg8 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            idg[] idgArr2 = {idg6, idg7, idg8};
            idg.O000000o(idgArr2);
            idg idg10 = idgArr2[0];
            idg idg11 = idgArr2[1];
            idg idg12 = idgArr2[2];
            if (!hashMap.containsKey(idg2)) {
                idg5 = idg2;
            } else if (!hashMap.containsKey(idg3)) {
                idg5 = idg3;
            } else if (!hashMap.containsKey(idg4)) {
                idg5 = idg4;
            }
            int i = detector.O00000Oo(idg12, idg5).O00000o0;
            int i2 = detector.O00000Oo(idg10, idg5).O00000o0;
            if ((i & 1) == 1) {
                i++;
            }
            int i3 = i + 2;
            if ((i2 & 1) == 1) {
                i2++;
            }
            int i4 = i2 + 2;
            if (i3 * 4 >= i4 * 7 || i4 * 4 >= i3 * 7) {
                float O000000o3 = ((float) Detector.O000000o(idg11, idg10)) / ((float) i3);
                float O000000o4 = (float) Detector.O000000o(idg12, idg5);
                idg idg13 = new idg(idg5.f1209O000000o + (((idg5.f1209O000000o - idg12.f1209O000000o) / O000000o4) * O000000o3), idg5.O00000Oo + (O000000o3 * ((idg5.O00000Oo - idg12.O00000Oo) / O000000o4)));
                float O000000o5 = ((float) Detector.O000000o(idg11, idg12)) / ((float) i4);
                float O000000o6 = (float) Detector.O000000o(idg10, idg5);
                idg = new idg(idg5.f1209O000000o + (((idg5.f1209O000000o - idg10.f1209O000000o) / O000000o6) * O000000o5), idg5.O00000Oo + (O000000o5 * ((idg5.O00000Oo - idg10.O00000Oo) / O000000o6)));
                if (!detector.O000000o(idg13)) {
                    if (!detector.O000000o(idg)) {
                        idg = null;
                    }
                } else if (!detector.O000000o(idg) || Math.abs(i3 - detector.O00000Oo(idg12, idg13).O00000o0) + Math.abs(i4 - detector.O00000Oo(idg10, idg13).O00000o0) <= Math.abs(i3 - detector.O00000Oo(idg12, idg).O00000o0) + Math.abs(i4 - detector.O00000Oo(idg10, idg).O00000o0)) {
                    idg = idg13;
                }
                if (idg == null) {
                    idg = idg5;
                }
                int i5 = detector.O00000Oo(idg12, idg).O00000o0;
                int i6 = detector.O00000Oo(idg10, idg).O00000o0;
                if ((i5 & 1) == 1) {
                    i5++;
                }
                int i7 = i5;
                if ((i6 & 1) == 1) {
                    i6++;
                }
                idm = Detector.O000000o(detector.f12114O000000o, idg12, idg11, idg10, idg, i7, i6);
            } else {
                float min = (float) Math.min(i4, i3);
                float O000000o7 = ((float) Detector.O000000o(idg11, idg10)) / min;
                float O000000o8 = (float) Detector.O000000o(idg12, idg5);
                idg idg14 = new idg(idg5.f1209O000000o + (((idg5.f1209O000000o - idg12.f1209O000000o) / O000000o8) * O000000o7), idg5.O00000Oo + (O000000o7 * ((idg5.O00000Oo - idg12.O00000Oo) / O000000o8)));
                float O000000o9 = ((float) Detector.O000000o(idg11, idg12)) / min;
                float O000000o10 = (float) Detector.O000000o(idg10, idg5);
                idg idg15 = new idg(idg5.f1209O000000o + (((idg5.f1209O000000o - idg10.f1209O000000o) / O000000o10) * O000000o9), idg5.O00000Oo + (O000000o9 * ((idg5.O00000Oo - idg10.O00000Oo) / O000000o10)));
                if (!detector.O000000o(idg14)) {
                    if (!detector.O000000o(idg15)) {
                        idg15 = null;
                    }
                } else if (!detector.O000000o(idg15) || Math.abs(detector.O00000Oo(idg12, idg14).O00000o0 - detector.O00000Oo(idg10, idg14).O00000o0) <= Math.abs(detector.O00000Oo(idg12, idg15).O00000o0 - detector.O00000Oo(idg10, idg15).O00000o0)) {
                    idg15 = idg14;
                }
                if (idg15 != null) {
                    idg5 = idg15;
                }
                int max = Math.max(detector.O00000Oo(idg12, idg5).O00000o0, detector.O00000Oo(idg10, idg5).O00000o0) + 1;
                if ((max & 1) == 1) {
                    max++;
                }
                int i8 = max;
                idm = Detector.O000000o(detector.f12114O000000o, idg12, idg11, idg10, idg5, i8, i8);
                idg = idg5;
            }
            idq idq = new idq(idm, new idg[]{idg12, idg11, idg10, idg});
            ido = this.O00000Oo.O000000o(idq.O00000o);
            idgArr = idq.O00000oO;
        } else {
            idm O00000Oo2 = icy.O00000Oo();
            int[] O000000o11 = O00000Oo2.O000000o();
            int[] O00000Oo3 = O00000Oo2.O00000Oo();
            if (O000000o11 == null || O00000Oo3 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i9 = O00000Oo2.f1214O000000o;
            int i10 = O000000o11[0];
            int i11 = O000000o11[1];
            while (i10 < i9 && O00000Oo2.O000000o(i10, i11)) {
                i10++;
            }
            if (i10 != i9) {
                int i12 = i10 - O000000o11[0];
                if (i12 != 0) {
                    int i13 = O000000o11[1];
                    int i14 = O00000Oo3[1];
                    int i15 = O000000o11[0];
                    int i16 = ((O00000Oo3[0] - i15) + 1) / i12;
                    int i17 = ((i14 - i13) + 1) / i12;
                    if (i16 <= 0 || i17 <= 0) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    int i18 = i12 / 2;
                    int i19 = i13 + i18;
                    int i20 = i15 + i18;
                    idm idm2 = new idm(i16, i17);
                    for (int i21 = 0; i21 < i17; i21++) {
                        int i22 = (i21 * i12) + i19;
                        for (int i23 = 0; i23 < i16; i23++) {
                            if (O00000Oo2.O000000o((i23 * i12) + i20, i22)) {
                                idm2.O00000Oo(i23, i21);
                            }
                        }
                    }
                    ido = this.O00000Oo.O000000o(idm2);
                    idgArr = f1227O000000o;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        idf idf = new idf(ido.O00000Oo, ido.f1216O000000o, idgArr, BarcodeFormat.DATA_MATRIX);
        List<byte[]> list = ido.O00000o0;
        if (list != null) {
            idf.O000000o(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str = ido.O00000o;
        if (str != null) {
            idf.O000000o(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return idf;
    }
}
