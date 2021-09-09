package _m_j;

import _m_j.ihd;
import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class igy {

    /* renamed from: O000000o  reason: collision with root package name */
    final int f1285O000000o;
    final byte[] O00000Oo;

    private igy(int i, byte[] bArr) {
        this.f1285O000000o = i;
        this.O00000Oo = bArr;
    }

    static igy[] O000000o(byte[] bArr, ihd ihd, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length == ihd.O00000o0) {
            ihd.O00000Oo O000000o2 = ihd.O000000o(errorCorrectionLevel);
            ihd.O000000o[] o000000oArr = O000000o2.O00000Oo;
            int i = 0;
            for (ihd.O000000o o000000o : o000000oArr) {
                i += o000000o.f1291O000000o;
            }
            igy[] igyArr = new igy[i];
            int length = o000000oArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                ihd.O000000o o000000o2 = o000000oArr[i2];
                int i4 = i3;
                int i5 = 0;
                while (i5 < o000000o2.f1291O000000o) {
                    int i6 = o000000o2.O00000Oo;
                    igyArr[i4] = new igy(i6, new byte[(O000000o2.f1292O000000o + i6)]);
                    i5++;
                    i4++;
                }
                i2++;
                i3 = i4;
            }
            int length2 = igyArr[0].O00000Oo.length;
            int length3 = igyArr.length - 1;
            while (length3 >= 0 && igyArr[length3].O00000Oo.length != length2) {
                length3--;
            }
            int i7 = length3 + 1;
            int i8 = length2 - O000000o2.f1292O000000o;
            int i9 = 0;
            int i10 = 0;
            while (i9 < i8) {
                int i11 = i10;
                int i12 = 0;
                while (i12 < i3) {
                    igyArr[i12].O00000Oo[i9] = bArr[i11];
                    i12++;
                    i11++;
                }
                i9++;
                i10 = i11;
            }
            int i13 = i7;
            while (i13 < i3) {
                igyArr[i13].O00000Oo[i8] = bArr[i10];
                i13++;
                i10++;
            }
            int length4 = igyArr[0].O00000Oo.length;
            while (i8 < length4) {
                int i14 = i10;
                int i15 = 0;
                while (i15 < i3) {
                    igyArr[i15].O00000Oo[i15 < i7 ? i8 : i8 + 1] = bArr[i14];
                    i15++;
                    i14++;
                }
                i8++;
                i10 = i14;
            }
            return igyArr;
        }
        throw new IllegalArgumentException();
    }
}
