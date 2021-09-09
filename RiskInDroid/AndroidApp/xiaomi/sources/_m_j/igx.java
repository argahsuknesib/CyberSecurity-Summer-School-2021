package _m_j;

import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.qrcode.decoder.DataMask;

final class igx {

    /* renamed from: O000000o  reason: collision with root package name */
    final idm f1284O000000o;
    ihd O00000Oo;
    boolean O00000o;
    ihb O00000o0;

    igx(idm idm) throws FormatException {
        int i = idm.O00000Oo;
        if (i < 21 || (i & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f1284O000000o = idm;
    }

    /* access modifiers changed from: package-private */
    public final ihb O000000o() throws FormatException {
        ihb ihb = this.O00000o0;
        if (ihb != null) {
            return ihb;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = O000000o(i3, 8, i2);
        }
        int O000000o2 = O000000o(8, 7, O000000o(8, 8, O000000o(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            O000000o2 = O000000o(8, i4, O000000o2);
        }
        int i5 = this.f1284O000000o.O00000Oo;
        int i6 = i5 - 7;
        for (int i7 = i5 - 1; i7 >= i6; i7--) {
            i = O000000o(8, i7, i);
        }
        for (int i8 = i5 - 8; i8 < i5; i8++) {
            i = O000000o(i8, 8, i);
        }
        this.O00000o0 = ihb.O00000Oo(O000000o2, i);
        ihb ihb2 = this.O00000o0;
        if (ihb2 != null) {
            return ihb2;
        }
        throw FormatException.getFormatInstance();
    }

    /* access modifiers changed from: package-private */
    public final ihd O00000Oo() throws FormatException {
        ihd ihd = this.O00000Oo;
        if (ihd != null) {
            return ihd;
        }
        int i = this.f1284O000000o.O00000Oo;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return ihd.O00000Oo(i2);
        }
        int i3 = i - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                i5 = O000000o(i7, i6, i5);
            }
        }
        ihd O00000o02 = ihd.O00000o0(i5);
        if (O00000o02 == null || O00000o02.O000000o() != i) {
            for (int i8 = 5; i8 >= 0; i8--) {
                for (int i9 = i - 9; i9 >= i3; i9--) {
                    i4 = O000000o(i8, i9, i4);
                }
            }
            ihd O00000o03 = ihd.O00000o0(i4);
            if (O00000o03 == null || O00000o03.O000000o() != i) {
                throw FormatException.getFormatInstance();
            }
            this.O00000Oo = O00000o03;
            return O00000o03;
        }
        this.O00000Oo = O00000o02;
        return O00000o02;
    }

    private int O000000o(int i, int i2, int i3) {
        return this.O00000o ? this.f1284O000000o.O000000o(i2, i) : this.f1284O000000o.O000000o(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* access modifiers changed from: package-private */
    public final byte[] O00000o0() throws FormatException {
        int i;
        ihb O000000o2 = O000000o();
        ihd O00000Oo2 = O00000Oo();
        DataMask dataMask = DataMask.values()[O000000o2.O00000Oo];
        int i2 = this.f1284O000000o.O00000Oo;
        dataMask.unmaskBitMatrix(this.f1284O000000o, i2);
        int O000000o3 = O00000Oo2.O000000o();
        idm idm = new idm(O000000o3);
        idm.O000000o(0, 0, 9, 9);
        int i3 = O000000o3 - 8;
        idm.O000000o(i3, 0, 8, 9);
        idm.O000000o(0, i3, 9, 8);
        int length = O00000Oo2.O00000Oo.length;
        int i4 = 0;
        while (true) {
            i = 2;
            if (i4 >= length) {
                break;
            }
            int i5 = O00000Oo2.O00000Oo[i4] - 2;
            for (int i6 = 0; i6 < length; i6++) {
                if (!((i4 == 0 && (i6 == 0 || i6 == length - 1)) || (i4 == length - 1 && i6 == 0))) {
                    idm.O000000o(O00000Oo2.O00000Oo[i6] - 2, i5, 5, 5);
                }
            }
            i4++;
        }
        int i7 = O000000o3 - 17;
        int i8 = 6;
        idm.O000000o(6, 9, 1, i7);
        idm.O000000o(9, 6, i7, 1);
        if (O00000Oo2.f1290O000000o > 6) {
            int i9 = O000000o3 - 11;
            idm.O000000o(i9, 0, 3, 6);
            idm.O000000o(0, i9, 6, 3);
        }
        byte[] bArr = new byte[O00000Oo2.O00000o0];
        int i10 = i2 - 1;
        int i11 = i10;
        int i12 = 0;
        boolean z = true;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == i8) {
                i11--;
            }
            int i15 = i14;
            int i16 = i13;
            int i17 = i12;
            int i18 = 0;
            while (i18 < i2) {
                int i19 = z ? i10 - i18 : i18;
                int i20 = i15;
                int i21 = i16;
                int i22 = i17;
                int i23 = 0;
                while (i23 < i) {
                    int i24 = i11 - i23;
                    if (!idm.O000000o(i24, i19)) {
                        i21++;
                        int i25 = i20 << 1;
                        int i26 = this.f1284O000000o.O000000o(i24, i19) ? i25 | 1 : i25;
                        if (i21 == 8) {
                            bArr[i22] = (byte) i26;
                            i22++;
                            i21 = 0;
                            i20 = 0;
                        } else {
                            i20 = i26;
                        }
                    }
                    i23++;
                    i = 2;
                }
                i18++;
                i17 = i22;
                i16 = i21;
                i15 = i20;
                i = 2;
            }
            z = !z;
            i11 -= 2;
            i12 = i17;
            i13 = i16;
            i14 = i15;
            i8 = 6;
            i = 2;
        }
        if (i12 == O00000Oo2.O00000o0) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
