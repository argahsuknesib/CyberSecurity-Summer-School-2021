package _m_j;

public final class igs {

    /* renamed from: O000000o  reason: collision with root package name */
    public final igr f1280O000000o;
    public final int[] O00000Oo;

    public igs(igr igr, int[] iArr) {
        if (iArr.length != 0) {
            this.f1280O000000o = igr;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.O00000Oo = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.O00000Oo = new int[]{0};
                return;
            }
            this.O00000Oo = new int[(length - i)];
            int[] iArr2 = this.O00000Oo;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final boolean O000000o() {
        return this.O00000Oo[0] == 0;
    }

    public final int O000000o(int i) {
        int[] iArr = this.O00000Oo;
        return iArr[(iArr.length - 1) - i];
    }

    public final int O00000Oo(int i) {
        if (i == 0) {
            return O000000o(0);
        }
        int[] iArr = this.O00000Oo;
        int length = iArr.length;
        if (i == 1) {
            int i2 = 0;
            for (int O00000Oo2 : iArr) {
                i2 = this.f1280O000000o.O00000Oo(i2, O00000Oo2);
            }
            return i2;
        }
        int i3 = iArr[0];
        for (int i4 = 1; i4 < length; i4++) {
            igr igr = this.f1280O000000o;
            i3 = igr.O00000Oo(igr.O00000o(i, i3), this.O00000Oo[i4]);
        }
        return i3;
    }

    public final igs O000000o(igs igs) {
        if (!this.f1280O000000o.equals(igs.f1280O000000o)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (O000000o()) {
            return igs;
        } else {
            if (igs.O000000o()) {
                return this;
            }
            int[] iArr = this.O00000Oo;
            int[] iArr2 = igs.O00000Oo;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = this.f1280O000000o.O00000Oo(iArr[i - length], iArr2[i]);
            }
            return new igs(this.f1280O000000o, iArr4);
        }
    }

    public final igs O00000Oo(igs igs) {
        if (!this.f1280O000000o.equals(igs.f1280O000000o)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (igs.O000000o()) {
            return this;
        } else {
            return O000000o(igs.O00000Oo());
        }
    }

    public final igs O00000o0(igs igs) {
        if (!this.f1280O000000o.equals(igs.f1280O000000o)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (O000000o() || igs.O000000o()) {
            return this.f1280O000000o.O00000o;
        } else {
            int[] iArr = this.O00000Oo;
            int length = iArr.length;
            int[] iArr2 = igs.O00000Oo;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    igr igr = this.f1280O000000o;
                    iArr3[i4] = igr.O00000Oo(iArr3[i4], igr.O00000o(i2, iArr2[i3]));
                }
            }
            return new igs(this.f1280O000000o, iArr3);
        }
    }

    public final igs O00000Oo() {
        int length = this.O00000Oo.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f1280O000000o.O00000o0(0, this.O00000Oo[i]);
        }
        return new igs(this.f1280O000000o, iArr);
    }

    public final igs O00000o0(int i) {
        if (i == 0) {
            return this.f1280O000000o.O00000o;
        }
        if (i == 1) {
            return this;
        }
        int length = this.O00000Oo.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f1280O000000o.O00000o(this.O00000Oo[i2], i);
        }
        return new igs(this.f1280O000000o, iArr);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.O00000Oo.length - 1) * 8);
        for (int length = this.O00000Oo.length - 1; length >= 0; length--) {
            int O000000o2 = O000000o(length);
            if (O000000o2 != 0) {
                if (O000000o2 < 0) {
                    sb.append(" - ");
                    O000000o2 = -O000000o2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || O000000o2 != 1) {
                    sb.append(O000000o2);
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
