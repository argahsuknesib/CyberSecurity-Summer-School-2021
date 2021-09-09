package _m_j;

import com.xiaomi.zxing.common.reedsolomon.ReedSolomonException;

public final class iea {

    /* renamed from: O000000o  reason: collision with root package name */
    private final idy f1225O000000o;

    public iea(idy idy) {
        this.f1225O000000o = idy;
    }

    public final void O000000o(int[] iArr, int i) throws ReedSolomonException {
        idz idz = new idz(this.f1225O000000o, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < i; i3++) {
            idy idy = this.f1225O000000o;
            int O00000Oo = idz.O00000Oo(idy.O0000Oo0[idy.O0000o00 + i3]);
            iArr2[(iArr2.length - 1) - i3] = O00000Oo;
            if (O00000Oo != 0) {
                z = false;
            }
        }
        if (!z) {
            idz[] O000000o2 = O000000o(this.f1225O000000o.O000000o(i, 1), new idz(this.f1225O000000o, iArr2), i);
            idz idz2 = O000000o2[0];
            idz idz3 = O000000o2[1];
            int[] O000000o3 = O000000o(idz2);
            int[] O000000o4 = O000000o(idz3, O000000o3);
            while (i2 < O000000o3.length) {
                int length = (iArr.length - 1) - this.f1225O000000o.O000000o(O000000o3[i2]);
                if (length >= 0) {
                    iArr[length] = idy.O00000Oo(iArr[length], O000000o4[i2]);
                    i2++;
                } else {
                    throw new ReedSolomonException("Bad error location");
                }
            }
        }
    }

    private int[] O000000o(idz idz, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int O00000Oo = this.f1225O000000o.O00000Oo(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int O00000o0 = this.f1225O000000o.O00000o0(iArr[i3], O00000Oo);
                    i2 = this.f1225O000000o.O00000o0(i2, (O00000o0 & 1) == 0 ? O00000o0 | 1 : O00000o0 & -2);
                }
            }
            iArr2[i] = this.f1225O000000o.O00000o0(idz.O00000Oo(O00000Oo), this.f1225O000000o.O00000Oo(i2));
            if (this.f1225O000000o.O0000o00 != 0) {
                iArr2[i] = this.f1225O000000o.O00000o0(iArr2[i], O00000Oo);
            }
        }
        return iArr2;
    }

    private idz[] O000000o(idz idz, idz idz2, int i) throws ReedSolomonException {
        if (idz.f1222O000000o.length - 1 < idz2.f1222O000000o.length - 1) {
            idz idz3 = idz2;
            idz2 = idz;
            idz = idz3;
        }
        idz idz4 = this.f1225O000000o.O0000Oo;
        idz idz5 = this.f1225O000000o.O0000OoO;
        do {
            idz idz6 = r12;
            r12 = idz;
            idz = idz6;
            idz idz7 = idz5;
            idz idz8 = idz4;
            idz4 = idz7;
            if (idz.f1222O000000o.length - 1 < i / 2) {
                int O000000o2 = idz4.O000000o(0);
                if (O000000o2 != 0) {
                    int O00000Oo = this.f1225O000000o.O00000Oo(O000000o2);
                    return new idz[]{idz4.O00000o0(O00000Oo), idz.O00000o0(O00000Oo)};
                }
                throw new ReedSolomonException("sigmaTilde(0) was zero");
            } else if (!idz.O000000o()) {
                idz idz9 = this.f1225O000000o.O0000Oo;
                int O00000Oo2 = this.f1225O000000o.O00000Oo(idz.O000000o(idz.f1222O000000o.length - 1));
                while (r12.f1222O000000o.length - 1 >= idz.f1222O000000o.length - 1 && !r12.O000000o()) {
                    int length = (r12.f1222O000000o.length - 1) - (idz.f1222O000000o.length - 1);
                    int O00000o0 = this.f1225O000000o.O00000o0(r12.O000000o(r12.f1222O000000o.length - 1), O00000Oo2);
                    idz9 = idz9.O000000o(this.f1225O000000o.O000000o(length, O00000o0));
                    r12 = r12.O000000o(idz.O000000o(length, O00000o0));
                }
                idz5 = idz9.O00000Oo(idz4).O000000o(idz8);
            } else {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
        } while (r12.f1222O000000o.length - 1 < idz.f1222O000000o.length - 1);
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    private int[] O000000o(idz idz) throws ReedSolomonException {
        int length = idz.f1222O000000o.length - 1;
        int i = 0;
        if (length == 1) {
            return new int[]{idz.O000000o(1)};
        }
        int[] iArr = new int[length];
        for (int i2 = 1; i2 < this.f1225O000000o.O0000Ooo && i < length; i2++) {
            if (idz.O00000Oo(i2) == 0) {
                iArr[i] = this.f1225O000000o.O00000Oo(i2);
                i++;
            }
        }
        if (i == length) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }
}
