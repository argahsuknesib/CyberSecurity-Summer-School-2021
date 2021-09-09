package _m_j;

public final class idy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final idy f1221O000000o = new idy(4201, 4096, 1);
    public static final idy O00000Oo = new idy(1033, 1024, 1);
    public static final idy O00000o = new idy(19, 16, 1);
    public static final idy O00000o0 = new idy(67, 64, 1);
    public static final idy O00000oO = new idy(285, 256, 0);
    public static final idy O00000oo;
    public static final idy O0000O0o;
    public static final idy O0000OOo = O00000o0;
    final idz O0000Oo;
    final int[] O0000Oo0;
    final idz O0000OoO;
    final int O0000Ooo;
    private final int[] O0000o0;
    final int O0000o00;
    private final int O0000o0O;

    static int O00000Oo(int i, int i2) {
        return i ^ i2;
    }

    static {
        idy idy = new idy(301, 256, 1);
        O00000oo = idy;
        O0000O0o = idy;
    }

    private idy(int i, int i2, int i3) {
        this.O0000o0O = i;
        this.O0000Ooo = i2;
        this.O0000o00 = i3;
        this.O0000Oo0 = new int[i2];
        this.O0000o0 = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.O0000Oo0[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.O0000o0[this.O0000Oo0[i6]] = i6;
        }
        this.O0000Oo = new idz(this, new int[]{0});
        this.O0000OoO = new idz(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    public final idz O000000o(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.O0000Oo;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new idz(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(int i) {
        if (i != 0) {
            return this.O0000o0[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo(int i) {
        if (i != 0) {
            return this.O0000Oo0[(this.O0000Ooo - this.O0000o0[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public final int O00000o0(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.O0000Oo0;
        int[] iArr2 = this.O0000o0;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.O0000Ooo - 1)];
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.O0000o0O) + ',' + this.O0000Ooo + ')';
    }
}
