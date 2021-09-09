package _m_j;

import java.util.Arrays;

public final class idm implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f1214O000000o;
    public final int O00000Oo;
    public final int[] O00000o;
    public final int O00000o0;

    public idm(int i) {
        this(i, i);
    }

    public idm(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f1214O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = (i + 31) / 32;
        this.O00000o = new int[(this.O00000o0 * i2)];
    }

    private idm(int i, int i2, int i3, int[] iArr) {
        this.f1214O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
        this.O00000o = iArr;
    }

    public final boolean O000000o(int i, int i2) {
        return ((this.O00000o[(i2 * this.O00000o0) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public final void O00000Oo(int i, int i2) {
        int i3 = (i2 * this.O00000o0) + (i / 32);
        int[] iArr = this.O00000o;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public final void O00000o0(int i, int i2) {
        int i3 = (i2 * this.O00000o0) + (i / 32);
        int[] iArr = this.O00000o;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.O00000Oo || i5 > this.f1214O000000o) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.O00000o0 * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.O00000o;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public final int[] O000000o() {
        int i = 0;
        while (true) {
            int[] iArr = this.O00000o;
            if (i >= iArr.length || iArr[i] != 0) {
                int[] iArr2 = this.O00000o;
            } else {
                i++;
            }
        }
        int[] iArr22 = this.O00000o;
        if (i == iArr22.length) {
            return null;
        }
        int i2 = this.O00000o0;
        int i3 = i / i2;
        int i4 = (i % i2) * 32;
        int i5 = iArr22[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public final int[] O00000Oo() {
        int length = this.O00000o.length - 1;
        while (length >= 0 && this.O00000o[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.O00000o0;
        int i2 = length / i;
        int i3 = (length % i) * 32;
        int i4 = 31;
        while ((this.O00000o[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof idm)) {
            return false;
        }
        idm idm = (idm) obj;
        if (this.f1214O000000o == idm.f1214O000000o && this.O00000Oo == idm.O00000Oo && this.O00000o0 == idm.O00000o0 && Arrays.equals(this.O00000o, idm.O00000o)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f1214O000000o;
        return (((((((i * 31) + i) * 31) + this.O00000Oo) * 31) + this.O00000o0) * 31) + Arrays.hashCode(this.O00000o);
    }

    /* renamed from: O00000o0 */
    public final idm clone() {
        return new idm(this.f1214O000000o, this.O00000Oo, this.O00000o0, (int[]) this.O00000o.clone());
    }

    public final idl O000000o(int i, idl idl) {
        if (idl == null || idl.O00000Oo < this.f1214O000000o) {
            idl = new idl(this.f1214O000000o);
        } else {
            idl.O00000Oo();
        }
        int i2 = i * this.O00000o0;
        for (int i3 = 0; i3 < this.O00000o0; i3++) {
            idl.f1213O000000o[(i3 * 32) / 32] = this.O00000o[i2 + i3];
        }
        return idl;
    }

    public final void O00000Oo(int i, idl idl) {
        int[] iArr = idl.f1213O000000o;
        int[] iArr2 = this.O00000o;
        int i2 = this.O00000o0;
        System.arraycopy(iArr, 0, iArr2, i * i2, i2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.O00000Oo * (this.f1214O000000o + 1));
        for (int i = 0; i < this.O00000Oo; i++) {
            for (int i2 = 0; i2 < this.f1214O000000o; i2++) {
                sb.append(O000000o(i2, i) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
