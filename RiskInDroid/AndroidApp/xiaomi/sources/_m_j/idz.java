package _m_j;

public final class idz {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int[] f1222O000000o;
    private final idy O00000Oo;

    public idz(idy idy, int[] iArr) {
        if (iArr.length != 0) {
            this.O00000Oo = idy;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f1222O000000o = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f1222O000000o = new int[]{0};
                return;
            }
            this.f1222O000000o = new int[(length - i)];
            int[] iArr2 = this.f1222O000000o;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        return this.f1222O000000o[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(int i) {
        int[] iArr = this.f1222O000000o;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo(int i) {
        if (i == 0) {
            return O000000o(0);
        }
        int[] iArr = this.f1222O000000o;
        int length = iArr.length;
        if (i == 1) {
            int i2 = 0;
            for (int O00000Oo2 : iArr) {
                i2 = idy.O00000Oo(i2, O00000Oo2);
            }
            return i2;
        }
        int i3 = iArr[0];
        for (int i4 = 1; i4 < length; i4++) {
            i3 = idy.O00000Oo(this.O00000Oo.O00000o0(i, i3), this.f1222O000000o[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final idz O000000o(idz idz) {
        if (!this.O00000Oo.equals(idz.O00000Oo)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (O000000o()) {
            return idz;
        } else {
            if (idz.O000000o()) {
                return this;
            }
            int[] iArr = this.f1222O000000o;
            int[] iArr2 = idz.f1222O000000o;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = idy.O00000Oo(iArr[i - length], iArr2[i]);
            }
            return new idz(this.O00000Oo, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public final idz O00000Oo(idz idz) {
        if (!this.O00000Oo.equals(idz.O00000Oo)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (O000000o() || idz.O000000o()) {
            return this.O00000Oo.O0000Oo;
        } else {
            int[] iArr = this.f1222O000000o;
            int length = iArr.length;
            int[] iArr2 = idz.f1222O000000o;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = idy.O00000Oo(iArr3[i4], this.O00000Oo.O00000o0(i2, iArr2[i3]));
                }
            }
            return new idz(this.O00000Oo, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public final idz O00000o0(int i) {
        if (i == 0) {
            return this.O00000Oo.O0000Oo;
        }
        if (i == 1) {
            return this;
        }
        int length = this.f1222O000000o.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.O00000Oo.O00000o0(this.f1222O000000o[i2], i);
        }
        return new idz(this.O00000Oo, iArr);
    }

    public final idz O000000o(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.O00000Oo.O0000Oo;
        } else {
            int length = this.f1222O000000o.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.O00000Oo.O00000o0(this.f1222O000000o[i3], i2);
            }
            return new idz(this.O00000Oo, iArr);
        }
    }

    public final idz[] O00000o0(idz idz) {
        if (!this.O00000Oo.equals(idz.O00000Oo)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!idz.O000000o()) {
            idz idz2 = this.O00000Oo.O0000Oo;
            int O00000Oo2 = this.O00000Oo.O00000Oo(idz.O000000o(idz.f1222O000000o.length - 1));
            idz idz3 = idz2;
            idz idz4 = this;
            while (idz4.f1222O000000o.length - 1 >= idz.f1222O000000o.length - 1 && !idz4.O000000o()) {
                int[] iArr = idz4.f1222O000000o;
                int length = (iArr.length - 1) - (idz.f1222O000000o.length - 1);
                int O00000o0 = this.O00000Oo.O00000o0(idz4.O000000o(iArr.length - 1), O00000Oo2);
                idz O000000o2 = idz.O000000o(length, O00000o0);
                idz3 = idz3.O000000o(this.O00000Oo.O000000o(length, O00000o0));
                idz4 = idz4.O000000o(O000000o2);
            }
            return new idz[]{idz3, idz4};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f1222O000000o.length - 1) * 8);
        for (int length = this.f1222O000000o.length - 1; length >= 0; length--) {
            int O000000o2 = O000000o(length);
            if (O000000o2 != 0) {
                if (O000000o2 < 0) {
                    sb.append(" - ");
                    O000000o2 = -O000000o2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || O000000o2 != 1) {
                    int O000000o3 = this.O00000Oo.O000000o(O000000o2);
                    if (O000000o3 == 0) {
                        sb.append('1');
                    } else if (O000000o3 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(O000000o3);
                    }
                }
                if (length != 0) {
                    if (length == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(length);
                    }
                }
            }
        }
        return sb.toString();
    }
}
