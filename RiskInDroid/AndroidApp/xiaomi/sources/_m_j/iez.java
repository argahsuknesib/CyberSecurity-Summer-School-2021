package _m_j;

import com.tencent.mmkv.MMKVRecoverStrategic;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ReaderException;
import com.xiaomi.zxing.ResultMetadataType;
import java.util.EnumMap;

final class iez {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f1251O000000o = {1, 1, 2};
    private final iex O00000Oo = new iex();
    private final iey O00000o0 = new iey();

    iez() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[]
     arg types: [_m_j.idl, int, int, int[]]
     candidates:
      _m_j.ifa.O000000o(_m_j.idl, int[], int, int[][]):int
      _m_j.ifa.O000000o(int, _m_j.idl, int[], java.util.Map<com.xiaomi.zxing.DecodeHintType, ?>):_m_j.idf
      _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.xiaomi.zxing.ResultMetadataType, java.lang.String]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011f A[Catch:{ ReaderException -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0120 A[Catch:{ ReaderException -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0152 A[Catch:{ ReaderException -> 0x016b }] */
    public final idf O000000o(int i, idl idl, int i2) throws NotFoundException {
        EnumMap enumMap;
        String str;
        int i3 = i;
        idl idl2 = idl;
        int[] O000000o2 = ifa.O000000o(idl2, i2, false, f1251O000000o);
        try {
            iey iey = this.O00000o0;
            StringBuilder sb = iey.O00000o0;
            sb.setLength(0);
            int[] iArr = iey.O00000Oo;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            int i4 = idl2.O00000Oo;
            int i5 = O000000o2[1];
            int i6 = 0;
            for (int i7 = 0; i7 < 5 && i5 < i4; i7++) {
                int O000000o3 = ifa.O000000o(idl2, iArr, i5, ifa.O00000oo);
                sb.append((char) ((O000000o3 % 10) + 48));
                int i8 = i5;
                for (int i9 : iArr) {
                    i8 += i9;
                }
                if (O000000o3 >= 10) {
                    i6 = (1 << (4 - i7)) | i6;
                }
                if (i7 != 4) {
                    i8 = idl2.O00000o(idl2.O00000o0(i8));
                }
                i5 = i8;
            }
            if (sb.length() == 5) {
                for (int i10 = 0; i10 < 10; i10++) {
                    if (i6 == iey.f1250O000000o[i10]) {
                        String sb2 = sb.toString();
                        int length = sb2.length();
                        int i11 = 0;
                        for (int i12 = length - 2; i12 >= 0; i12 -= 2) {
                            i11 += sb2.charAt(i12) - '0';
                        }
                        int i13 = i11 * 3;
                        for (int i14 = length - 1; i14 >= 0; i14 -= 2) {
                            i13 += sb2.charAt(i14) - '0';
                        }
                        if ((i13 * 3) % 10 == i10) {
                            String sb3 = sb.toString();
                            if (sb3.length() == 5) {
                                char charAt = sb3.charAt(0);
                                String str2 = "";
                                if (charAt == '0') {
                                    str2 = "£";
                                } else if (charAt == '5') {
                                    str2 = "$";
                                } else if (charAt == '9') {
                                    if ("90000".equals(sb3)) {
                                        str = null;
                                    } else if ("99991".equals(sb3)) {
                                        str = "0.00";
                                    } else if ("99990".equals(sb3)) {
                                        str = "Used";
                                    }
                                    if (str == null) {
                                        enumMap = new EnumMap(ResultMetadataType.class);
                                        enumMap.put((MMKVRecoverStrategic) ResultMetadataType.SUGGESTED_PRICE, (Integer) str);
                                        float f = (float) i3;
                                        idf idf = new idf(sb3, null, new idg[]{new idg(((float) (O000000o2[0] + O000000o2[1])) / 2.0f, f), new idg((float) i5, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
                                        if (enumMap != null) {
                                            idf.O000000o(enumMap);
                                        }
                                        return idf;
                                    }
                                }
                                int parseInt = Integer.parseInt(sb3.substring(1));
                                String valueOf = String.valueOf(parseInt / 100);
                                int i15 = parseInt % 100;
                                str = str2 + valueOf + '.' + (i15 < 10 ? "0".concat(String.valueOf(i15)) : String.valueOf(i15));
                                if (str == null) {
                                }
                            }
                            enumMap = null;
                            float f2 = (float) i3;
                            idf idf2 = new idf(sb3, null, new idg[]{new idg(((float) (O000000o2[0] + O000000o2[1])) / 2.0f, f2), new idg((float) i5, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
                            if (enumMap != null) {
                            }
                            return idf2;
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        } catch (ReaderException unused) {
            return this.O00000Oo.O000000o(i3, idl2, O000000o2);
        }
    }
}
