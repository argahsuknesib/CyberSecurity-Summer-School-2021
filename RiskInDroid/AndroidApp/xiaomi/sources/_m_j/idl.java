package _m_j;

import java.util.Arrays;

public final class idl implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    public int[] f1213O000000o;
    public int O00000Oo;

    public idl() {
        this.O00000Oo = 0;
        this.f1213O000000o = new int[1];
    }

    public idl(int i) {
        this.O00000Oo = i;
        this.f1213O000000o = O00000oo(i);
    }

    private idl(int[] iArr, int i) {
        this.f1213O000000o = iArr;
        this.O00000Oo = i;
    }

    public final int O000000o() {
        return (this.O00000Oo + 7) / 8;
    }

    private void O00000oO(int i) {
        if (i > this.f1213O000000o.length * 32) {
            int[] O00000oo = O00000oo(i);
            int[] iArr = this.f1213O000000o;
            System.arraycopy(iArr, 0, O00000oo, 0, iArr.length);
            this.f1213O000000o = O00000oo;
        }
    }

    public final boolean O000000o(int i) {
        return ((1 << (i & 31)) & this.f1213O000000o[i / 32]) != 0;
    }

    public final void O00000Oo(int i) {
        int[] iArr = this.f1213O000000o;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public final int O00000o0(int i) {
        int i2 = this.O00000Oo;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (((1 << (i & 31)) - 1) ^ -1) & this.f1213O000000o[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f1213O000000o;
            if (i3 == iArr.length) {
                return this.O00000Oo;
            }
            i4 = iArr[i3];
        }
        int numberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.O00000Oo;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public final int O00000o(int i) {
        int i2 = this.O00000Oo;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (((1 << (i & 31)) - 1) ^ -1) & (this.f1213O000000o[i3] ^ -1);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f1213O000000o;
            if (i3 == iArr.length) {
                return this.O00000Oo;
            }
            i4 = iArr[i3] ^ -1;
        }
        int numberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.O00000Oo;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public final void O00000Oo() {
        int length = this.f1213O000000o.length;
        for (int i = 0; i < length; i++) {
            this.f1213O000000o[i] = 0;
        }
    }

    public final boolean O000000o(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.O00000Oo) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                if ((((2 << i7) - (1 << i8)) & this.f1213O000000o[i6]) != 0) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public final void O000000o(boolean z) {
        O00000oO(this.O00000Oo + 1);
        if (z) {
            int[] iArr = this.f1213O000000o;
            int i = this.O00000Oo;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.O00000Oo++;
    }

    public final void O00000Oo(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        O00000oO(this.O00000Oo + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            O000000o(z);
            i2--;
        }
    }

    public final void O000000o(idl idl) {
        int i = idl.O00000Oo;
        O00000oO(this.O00000Oo + i);
        for (int i2 = 0; i2 < i; i2++) {
            O000000o(idl.O000000o(i2));
        }
    }

    public final void O000000o(int i, byte[] bArr, int i2) {
        int i3 = i;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i3;
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (O000000o(i5)) {
                    i6 |= 1 << (7 - i7);
                }
                i5++;
            }
            bArr[i4 + 0] = (byte) i6;
            i4++;
            i3 = i5;
        }
    }

    public final void O00000o0() {
        int[] iArr = new int[this.f1213O000000o.length];
        int i = (this.O00000Oo - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = (long) this.f1213O000000o[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.O00000Oo;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.f1213O000000o = iArr;
    }

    private static int[] O00000oo(int i) {
        return new int[((i + 31) / 32)];
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof idl)) {
            return false;
        }
        idl idl = (idl) obj;
        if (this.O00000Oo != idl.O00000Oo || !Arrays.equals(this.f1213O000000o, idl.f1213O000000o)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.O00000Oo * 31) + Arrays.hashCode(this.f1213O000000o);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.O00000Oo);
        for (int i = 0; i < this.O00000Oo; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(O000000o(i) ? 'X' : '.');
        }
        return sb.toString();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new idl((int[]) this.f1213O000000o.clone(), this.O00000Oo);
    }
}
