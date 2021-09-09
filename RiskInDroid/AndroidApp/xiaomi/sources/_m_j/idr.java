package _m_j;

import com.xiaomi.zxing.NotFoundException;

public class idr extends icx {
    private static final byte[] O00000Oo = new byte[0];
    private final int[] O00000o = new int[32];
    private byte[] O00000o0 = O00000Oo;

    public idr(ida ida) {
        super(ida);
    }

    public icx O000000o(ida ida) {
        return new idr(ida);
    }

    private void O000000o(int i) {
        if (this.O00000o0.length < i) {
            this.O00000o0 = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.O00000o[i2] = 0;
        }
    }

    private static int O000000o(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 > i5) {
            int i10 = i3;
            i3 = i5;
            i5 = i10;
        }
        if (i5 - i3 > length / 16) {
            int i11 = i5 - 1;
            int i12 = i11;
            int i13 = -1;
            while (i11 > i3) {
                int i14 = i11 - i3;
                int i15 = i14 * i14 * (i5 - i11) * (i2 - iArr[i11]);
                if (i15 > i13) {
                    i12 = i11;
                    i13 = i15;
                }
                i11--;
            }
            return i12 << 3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final idl O000000o(int i, idl idl) throws NotFoundException {
        ida ida = this.f1203O000000o;
        int i2 = ida.f1206O000000o;
        if (idl == null || idl.O00000Oo < i2) {
            idl = new idl(i2);
        } else {
            idl.O00000Oo();
        }
        O000000o(i2);
        byte[] O000000o2 = ida.O000000o(i, this.O00000o0);
        int[] iArr = this.O00000o;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (O000000o2[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int O000000o3 = O000000o(iArr);
        if (i2 < 3) {
            for (int i5 = 0; i5 < i2; i5++) {
                if ((O000000o2[i5] & 255) < O000000o3) {
                    idl.O00000Oo(i5);
                }
            }
        } else {
            byte b = O000000o2[1] & 255;
            byte b2 = O000000o2[0] & 255;
            int i6 = 1;
            while (i6 < i2 - 1) {
                int i7 = i6 + 1;
                byte b3 = O000000o2[i7] & 255;
                if ((((b * 4) - b2) - b3) / 2 < O000000o3) {
                    idl.O00000Oo(i6);
                }
                b2 = b;
                i6 = i7;
                b = b3;
            }
        }
        return idl;
    }

    public idm O000000o() throws NotFoundException {
        ida ida = this.f1203O000000o;
        int i = ida.f1206O000000o;
        int i2 = ida.O00000Oo;
        idm idm = new idm(i, i2);
        O000000o(i);
        int[] iArr = this.O00000o;
        for (int i3 = 1; i3 < 5; i3++) {
            byte[] O000000o2 = ida.O000000o((i2 * i3) / 5, this.O00000o0);
            int i4 = (i * 4) / 5;
            for (int i5 = i / 5; i5 < i4; i5++) {
                int i6 = (O000000o2[i5] & 255) >> 3;
                iArr[i6] = iArr[i6] + 1;
            }
        }
        int O000000o3 = O000000o(iArr);
        byte[] O000000o4 = ida.O000000o();
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 * i;
            for (int i9 = 0; i9 < i; i9++) {
                if ((O000000o4[i8 + i9] & 255) < O000000o3) {
                    idm.O00000Oo(i9, i7);
                }
            }
        }
        return idm;
    }
}
