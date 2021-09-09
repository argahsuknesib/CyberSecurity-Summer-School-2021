package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ResultMetadataType;
import java.util.Map;

public final class ieh implements ide {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final idg[] f1234O000000o = new idg[0];
    private final iek O00000Oo = new iek();

    public final void O000000o() {
    }

    public final idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        byte[] bArr;
        Map<DecodeHintType, ?> map2 = map;
        if (map2 == null || !map2.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.getNotFoundInstance();
        }
        idm O00000Oo2 = icy.O00000Oo();
        int i = O00000Oo2.f1214O000000o;
        int i2 = -1;
        int i3 = O00000Oo2.O00000Oo;
        int i4 = -1;
        int i5 = i;
        int i6 = 0;
        while (i6 < O00000Oo2.O00000Oo) {
            int i7 = i3;
            int i8 = i5;
            for (int i9 = 0; i9 < O00000Oo2.O00000o0; i9++) {
                int i10 = O00000Oo2.O00000o[(O00000Oo2.O00000o0 * i6) + i9];
                if (i10 != 0) {
                    if (i6 < i7) {
                        i7 = i6;
                    }
                    if (i6 > i4) {
                        i4 = i6;
                    }
                    int i11 = i9 * 32;
                    int i12 = 31;
                    if (i11 < i8) {
                        int i13 = 0;
                        while ((i10 << (31 - i13)) == 0) {
                            i13++;
                        }
                        int i14 = i13 + i11;
                        if (i14 < i8) {
                            i8 = i14;
                        }
                    }
                    if (i11 + 31 > i2) {
                        while ((i10 >>> i12) == 0) {
                            i12--;
                        }
                        int i15 = i11 + i12;
                        if (i15 > i2) {
                            i2 = i15;
                        }
                    }
                }
            }
            i6++;
            i5 = i8;
            i3 = i7;
        }
        int i16 = i2 - i5;
        int i17 = i4 - i3;
        int[] iArr = (i16 < 0 || i17 < 0) ? null : new int[]{i5, i3, i16, i17};
        if (iArr != null) {
            int i18 = iArr[0];
            int i19 = iArr[1];
            int i20 = iArr[2];
            int i21 = iArr[3];
            idm idm = new idm(30, 33);
            int i22 = 0;
            for (int i23 = 33; i22 < i23; i23 = 33) {
                int i24 = (((i22 * i21) + (i21 / 2)) / i23) + i19;
                for (int i25 = 0; i25 < 30; i25++) {
                    if (O00000Oo2.O000000o(i18 + ((((i25 * i20) + (i20 / 2)) + (((i22 & 1) * i20) / 2)) / 30), i24)) {
                        idm.O00000Oo(i25, i22);
                    }
                }
                i22++;
            }
            iek iek = this.O00000Oo;
            iei iei = new iei(idm);
            byte[] bArr2 = new byte[144];
            int i26 = iei.O00000Oo.O00000Oo;
            int i27 = iei.O00000Oo.f1214O000000o;
            for (int i28 = 0; i28 < i26; i28++) {
                int[] iArr2 = iei.f1235O000000o[i28];
                for (int i29 = 0; i29 < i27; i29++) {
                    int i30 = iArr2[i29];
                    if (i30 >= 0 && iei.O00000Oo.O000000o(i29, i28)) {
                        int i31 = i30 / 6;
                        bArr2[i31] = (byte) (bArr2[i31] | ((byte) (1 << (5 - (i30 % 6)))));
                    }
                }
            }
            iek.O000000o(bArr2, 0, 10, 10, 0);
            byte b = bArr2[0] & 15;
            if (b == 2 || b == 3 || b == 4) {
                iek iek2 = iek;
                byte[] bArr3 = bArr2;
                iek2.O000000o(bArr3, 20, 84, 40, 1);
                iek2.O000000o(bArr3, 20, 84, 40, 2);
                bArr = new byte[94];
            } else if (b == 5) {
                iek iek3 = iek;
                byte[] bArr4 = bArr2;
                iek3.O000000o(bArr4, 20, 68, 56, 1);
                iek3.O000000o(bArr4, 20, 68, 56, 2);
                bArr = new byte[78];
            } else {
                throw FormatException.getFormatInstance();
            }
            System.arraycopy(bArr2, 0, bArr, 0, 10);
            System.arraycopy(bArr2, 20, bArr, 10, bArr.length - 10);
            ido O000000o2 = iej.O000000o(bArr, b);
            idf idf = new idf(O000000o2.O00000Oo, O000000o2.f1216O000000o, f1234O000000o, BarcodeFormat.MAXICODE);
            String str = O000000o2.O00000o;
            if (str != null) {
                idf.O000000o(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
            }
            return idf;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
