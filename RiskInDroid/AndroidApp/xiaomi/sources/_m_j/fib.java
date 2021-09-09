package _m_j;

public final class fib implements fhy {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f16392O000000o;
    private byte[] O00000Oo;
    private fhw O00000o;
    private int O00000o0;
    private fif O00000oO;
    private int O00000oo;

    public fib(fhw fhw, int i) {
        this(fhw, i, (byte) 0);
    }

    private fib(fhw fhw, int i, byte b) {
        if (i % 8 == 0) {
            this.O00000o = new fic(fhw);
            this.O00000oO = null;
            this.O00000oo = i / 8;
            this.f16392O000000o = new byte[fhw.O000000o()];
            this.O00000Oo = new byte[fhw.O000000o()];
            this.O00000o0 = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    public final void O000000o(fhx fhx) {
        O00000Oo();
        this.O00000o.O000000o(true, fhx);
    }

    public final int O000000o() {
        return this.O00000oo;
    }

    public final void O000000o(byte b) {
        int i = this.O00000o0;
        byte[] bArr = this.O00000Oo;
        if (i == bArr.length) {
            this.O00000o.O000000o(bArr, 0, this.f16392O000000o, 0);
            this.O00000o0 = 0;
        }
        byte[] bArr2 = this.O00000Oo;
        int i2 = this.O00000o0;
        this.O00000o0 = i2 + 1;
        bArr2[i2] = b;
    }

    public final void O000000o(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int O000000o2 = this.O00000o.O000000o();
            int i3 = this.O00000o0;
            int i4 = O000000o2 - i3;
            if (i2 > i4) {
                System.arraycopy(bArr, i, this.O00000Oo, i3, i4);
                this.O00000o.O000000o(this.O00000Oo, 0, this.f16392O000000o, 0);
                this.O00000o0 = 0;
                i2 -= i4;
                i += i4;
                while (i2 > O000000o2) {
                    this.O00000o.O000000o(bArr, i, this.f16392O000000o, 0);
                    i2 -= O000000o2;
                    i += O000000o2;
                }
            }
            System.arraycopy(bArr, i, this.O00000Oo, this.O00000o0, i2);
            this.O00000o0 += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public final int O000000o(byte[] bArr) {
        int O000000o2 = this.O00000o.O000000o();
        if (this.O00000oO == null) {
            while (true) {
                int i = this.O00000o0;
                if (i >= O000000o2) {
                    break;
                }
                this.O00000Oo[i] = 0;
                this.O00000o0 = i + 1;
            }
        } else if (this.O00000o0 == O000000o2) {
            this.O00000o.O000000o(this.O00000Oo, 0, this.f16392O000000o, 0);
            this.O00000o0 = 0;
        }
        this.O00000o.O000000o(this.O00000Oo, 0, this.f16392O000000o, 0);
        System.arraycopy(this.f16392O000000o, 0, bArr, 0, this.O00000oo);
        O00000Oo();
        return this.O00000oo;
    }

    private void O00000Oo() {
        int i = 0;
        while (true) {
            byte[] bArr = this.O00000Oo;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.O00000o0 = 0;
                this.O00000o.O00000Oo();
                return;
            }
        }
    }
}
