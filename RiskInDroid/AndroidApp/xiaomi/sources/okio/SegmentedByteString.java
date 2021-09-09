package okio;

import _m_j.jax;
import _m_j.jbk;
import _m_j.jbp;
import java.util.Arrays;

public final class SegmentedByteString extends ByteString {
    final transient byte[][] O00000oO;
    final transient int[] O00000oo;

    public SegmentedByteString(jax jax, int i) {
        super(null);
        jbp.O000000o(jax.O00000Oo, 0, (long) i);
        int i2 = 0;
        jbk jbk = jax.f1718O000000o;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (jbk.O00000o0 != jbk.O00000Oo) {
                i3 += jbk.O00000o0 - jbk.O00000Oo;
                i4++;
                jbk = jbk.O00000oo;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.O00000oO = new byte[i4][];
        this.O00000oo = new int[(i4 * 2)];
        jbk jbk2 = jax.f1718O000000o;
        int i5 = 0;
        while (i2 < i) {
            this.O00000oO[i5] = jbk2.f1738O000000o;
            i2 += jbk2.O00000o0 - jbk2.O00000Oo;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.O00000oo;
            iArr[i5] = i2;
            iArr[this.O00000oO.length + i5] = jbk2.O00000Oo;
            jbk2.O00000o = true;
            i5++;
            jbk2 = jbk2.O00000oo;
        }
    }

    public final String O000000o() {
        return O0000OoO().O000000o();
    }

    public final String O00000Oo() {
        return O0000OoO().O00000Oo();
    }

    public final String O00000oo() {
        return O0000OoO().O00000oo();
    }

    public final ByteString O0000O0o() {
        return O0000OoO().O0000O0o();
    }

    public final ByteString O00000o0() {
        return O0000OoO().O00000o0();
    }

    public final ByteString O00000o() {
        return O0000OoO().O00000o();
    }

    public final ByteString O00000oO() {
        return O0000OoO().O00000oO();
    }

    public final ByteString O000000o(int i, int i2) {
        return O0000OoO().O000000o(i, i2);
    }

    public final byte O000000o(int i) {
        int i2;
        jbp.O000000o((long) this.O00000oo[this.O00000oO.length - 1], (long) i, 1);
        int O00000Oo = O00000Oo(i);
        if (O00000Oo == 0) {
            i2 = 0;
        } else {
            i2 = this.O00000oo[O00000Oo - 1];
        }
        int[] iArr = this.O00000oo;
        byte[][] bArr = this.O00000oO;
        return bArr[O00000Oo][(i - i2) + iArr[bArr.length + O00000Oo]];
    }

    private int O00000Oo(int i) {
        int binarySearch = Arrays.binarySearch(this.O00000oo, 0, this.O00000oO.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public final int O0000OOo() {
        return this.O00000oo[this.O00000oO.length - 1];
    }

    public final byte[] O0000Oo0() {
        int[] iArr = this.O00000oo;
        byte[][] bArr = this.O00000oO;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.O00000oo;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.O00000oO[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(jax jax) {
        int length = this.O00000oO.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.O00000oo;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            jbk jbk = new jbk(this.O00000oO[i], i3, (i3 + i4) - i2, true, false);
            if (jax.f1718O000000o == null) {
                jbk.O0000O0o = jbk;
                jbk.O00000oo = jbk;
                jax.f1718O000000o = jbk;
            } else {
                jax.f1718O000000o.O0000O0o.O000000o(jbk);
            }
            i++;
            i2 = i4;
        }
        jax.O00000Oo += (long) i2;
    }

    public final boolean O000000o(int i, ByteString byteString, int i2, int i3) {
        int i4;
        if (O0000OOo() - i3 < 0) {
            return false;
        }
        int O00000Oo = O00000Oo(0);
        while (i3 > 0) {
            if (O00000Oo == 0) {
                i4 = 0;
            } else {
                i4 = this.O00000oo[O00000Oo - 1];
            }
            int min = Math.min(i3, ((this.O00000oo[O00000Oo] - i4) + i4) - i);
            int[] iArr = this.O00000oo;
            byte[][] bArr = this.O00000oO;
            if (!byteString.O000000o(i2, bArr[O00000Oo], (i - i4) + iArr[bArr.length + O00000Oo], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            O00000Oo++;
        }
        return true;
    }

    public final boolean O000000o(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > O0000OOo() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int O00000Oo = O00000Oo(i);
        while (i3 > 0) {
            if (O00000Oo == 0) {
                i4 = 0;
            } else {
                i4 = this.O00000oo[O00000Oo - 1];
            }
            int min = Math.min(i3, ((this.O00000oo[O00000Oo] - i4) + i4) - i);
            int[] iArr = this.O00000oo;
            byte[][] bArr2 = this.O00000oO;
            if (!jbp.O000000o(bArr2[O00000Oo], (i - i4) + iArr[bArr2.length + O00000Oo], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            O00000Oo++;
        }
        return true;
    }

    private ByteString O0000OoO() {
        return new ByteString(O0000Oo0());
    }

    /* access modifiers changed from: package-private */
    public final byte[] O0000Oo() {
        return O0000Oo0();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.O0000OOo() == O0000OOo() && O000000o(0, byteString, 0, O0000OOo());
        }
    }

    public final int hashCode() {
        int i = this.O00000o0;
        if (i != 0) {
            return i;
        }
        int length = this.O00000oO.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.O00000oO[i2];
            int[] iArr = this.O00000oo;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.O00000o0 = i3;
        return i3;
    }

    public final String toString() {
        return O0000OoO().toString();
    }

    private Object writeReplace() {
        return O0000OoO();
    }
}
