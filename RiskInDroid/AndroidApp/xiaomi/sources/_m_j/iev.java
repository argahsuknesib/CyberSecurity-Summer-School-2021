package _m_j;

import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ReaderException;
import com.xiaomi.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class iev implements ide {
    public abstract idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    public void O000000o() {
    }

    public idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return O00000Oo(icy, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !icy.f1204O000000o.f1203O000000o.O00000Oo()) {
                throw e;
            }
            icy icy2 = new icy(icy.f1204O000000o.O000000o(icy.f1204O000000o.f1203O000000o.O00000o()));
            idf O00000Oo = O00000Oo(icy2, map);
            Map<ResultMetadataType, Object> map2 = O00000Oo.O00000oO;
            int i = 270;
            if (map2 != null && map2.containsKey(ResultMetadataType.ORIENTATION)) {
                i = (((Integer) map2.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
            }
            O00000Oo.O000000o(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
            idg[] idgArr = O00000Oo.O00000o0;
            if (idgArr != null) {
                int O000000o2 = icy2.O000000o();
                for (int i2 = 0; i2 < idgArr.length; i2++) {
                    idgArr[i2] = new idg((((float) O000000o2) - idgArr[i2].O00000Oo) - 1.0f, idgArr[i2].f1209O000000o);
                }
            }
            return O00000Oo;
        }
    }

    protected static void O000000o(idl idl, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int i2 = idl.O00000Oo;
        if (i < i2) {
            boolean z = !idl.O000000o(i);
            int i3 = 0;
            while (i < i2) {
                if (!(idl.O000000o(i) ^ z)) {
                    i3++;
                    if (i3 == length) {
                        break;
                    }
                    iArr[i3] = 1;
                    z = !z;
                } else {
                    iArr[i3] = iArr[i3] + 1;
                }
                i++;
            }
            if (i3 == length) {
                return;
            }
            if (i3 != length - 1 || i != i2) {
                throw NotFoundException.getNotFoundInstance();
            }
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void O00000Oo(idl idl, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean O000000o2 = idl.O000000o(i);
        while (i > 0 && length >= 0) {
            i--;
            if (idl.O000000o(i) != O000000o2) {
                length--;
                O000000o2 = !O000000o2;
            }
        }
        if (length < 0) {
            O000000o(idl, i + 1, iArr);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static float O000000o(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    private idf O00000Oo(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        idl idl;
        int i2;
        icy icy2 = icy;
        Map<DecodeHintType, ?> map2 = map;
        int i3 = icy2.f1204O000000o.f1203O000000o.f1206O000000o;
        int O000000o2 = icy.O000000o();
        idl idl2 = new idl(i3);
        int i4 = O000000o2 >> 1;
        int i5 = 1;
        boolean z = map2 != null && map2.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, O000000o2 >> (z ? 8 : 5));
        int i6 = z ? O000000o2 : 15;
        EnumMap enumMap = map2;
        int i7 = 0;
        while (i7 < i6) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * max) + i4;
            if (i10 < 0 || i10 >= O000000o2) {
                break;
            }
            try {
                idl O000000o3 = icy2.f1204O000000o.O000000o(i10, idl2);
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i5) {
                        O000000o3.O00000o0();
                        if (enumMap != null && enumMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        idf O000000o4 = O000000o(i10, O000000o3, enumMap);
                        if (i11 == i5) {
                            O000000o4.O000000o(ResultMetadataType.ORIENTATION, 180);
                            idg[] idgArr = O000000o4.O00000o0;
                            if (idgArr != null) {
                                float f = (float) i3;
                                idl = O000000o3;
                                try {
                                    i2 = i3;
                                } catch (ReaderException unused) {
                                    i2 = i3;
                                    i11++;
                                    O000000o3 = idl;
                                    i3 = i2;
                                    i5 = 1;
                                }
                                try {
                                    idgArr[0] = new idg((f - idgArr[0].f1209O000000o) - 1.0f, idgArr[0].O00000Oo);
                                    try {
                                        idgArr[1] = new idg((f - idgArr[1].f1209O000000o) - 1.0f, idgArr[1].O00000Oo);
                                    } catch (ReaderException unused2) {
                                        continue;
                                    }
                                } catch (ReaderException unused3) {
                                    i11++;
                                    O000000o3 = idl;
                                    i3 = i2;
                                    i5 = 1;
                                }
                            }
                        }
                        return O000000o4;
                    } catch (ReaderException unused4) {
                        idl = O000000o3;
                        i2 = i3;
                        i11++;
                        O000000o3 = idl;
                        i3 = i2;
                        i5 = 1;
                    }
                }
                i = i3;
                idl2 = O000000o3;
            } catch (NotFoundException unused5) {
                i = i3;
            }
            icy2 = icy;
            i7 = i8;
            i3 = i;
            i5 = 1;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
