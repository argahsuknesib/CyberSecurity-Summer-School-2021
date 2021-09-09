package _m_j;

public final class igr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final igr f1279O000000o = new igr();
    public final int[] O00000Oo = new int[929];
    public final igs O00000o;
    public final int[] O00000o0 = new int[929];
    public final igs O00000oO;
    final int O00000oo = 929;

    private igr() {
        int i = 1;
        for (int i2 = 0; i2 < 929; i2++) {
            this.O00000Oo[i2] = i;
            i = (i * 3) % 929;
        }
        for (int i3 = 0; i3 < 928; i3++) {
            this.O00000o0[this.O00000Oo[i3]] = i3;
        }
        this.O00000o = new igs(this, new int[]{0});
        this.O00000oO = new igs(this, new int[]{1});
    }

    public final igs O000000o(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.O00000o;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new igs(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo(int i, int i2) {
        return (i + i2) % this.O00000oo;
    }

    public final int O00000o0(int i, int i2) {
        int i3 = this.O00000oo;
        return ((i + i3) - i2) % i3;
    }

    public final int O000000o(int i) {
        if (i != 0) {
            return this.O00000Oo[(this.O00000oo - this.O00000o0[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public final int O00000o(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.O00000Oo;
        int[] iArr2 = this.O00000o0;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.O00000oo - 1)];
    }
}
