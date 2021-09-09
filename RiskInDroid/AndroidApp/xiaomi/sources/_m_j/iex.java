package _m_j;

import com.tencent.mmkv.MMKVRecoverStrategic;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ResultMetadataType;
import java.util.EnumMap;

final class iex {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int[] f1249O000000o = new int[4];
    private final StringBuilder O00000Oo = new StringBuilder();

    iex() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.xiaomi.zxing.ResultMetadataType, java.lang.Integer]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    /* access modifiers changed from: package-private */
    public final idf O000000o(int i, idl idl, int[] iArr) throws NotFoundException {
        EnumMap enumMap;
        idl idl2 = idl;
        StringBuilder sb = this.O00000Oo;
        sb.setLength(0);
        int[] iArr2 = this.f1249O000000o;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = idl2.O00000Oo;
        int i3 = iArr[1];
        int i4 = 0;
        int i5 = 0;
        while (i4 < 2 && i3 < i2) {
            int O000000o2 = ifa.O000000o(idl2, iArr2, i3, ifa.O00000oo);
            sb.append((char) ((O000000o2 % 10) + 48));
            int i6 = i3;
            for (int i7 : iArr2) {
                i6 += i7;
            }
            if (O000000o2 >= 10) {
                i5 = (1 << (1 - i4)) | i5;
            }
            i3 = i4 != 1 ? idl2.O00000o(idl2.O00000o0(i6)) : i6;
            i4++;
        }
        if (sb.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        } else if (Integer.parseInt(sb.toString()) % 4 == i5) {
            String sb2 = sb.toString();
            if (sb2.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(ResultMetadataType.class);
                enumMap.put((MMKVRecoverStrategic) ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(sb2));
            }
            float f = (float) i;
            idf idf = new idf(sb2, null, new idg[]{new idg(((float) (iArr[0] + iArr[1])) / 2.0f, f), new idg((float) i3, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                idf.O000000o(enumMap);
            }
            return idf;
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
