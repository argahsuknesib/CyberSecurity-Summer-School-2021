package _m_j;

final class iqw {

    /* renamed from: O000000o  reason: collision with root package name */
    final byte[] f1572O000000o;
    int O00000Oo;
    boolean O00000o;
    int O00000o0;
    boolean O00000oO;
    iqw O00000oo;
    iqw O0000O0o;

    iqw() {
        this.f1572O000000o = new byte[8192];
        this.O00000oO = true;
        this.O00000o = false;
    }

    iqw(iqw iqw) {
        this(iqw.f1572O000000o, iqw.O00000Oo, iqw.O00000o0);
        iqw.O00000o = true;
    }

    private iqw(byte[] bArr, int i, int i2) {
        this.f1572O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000oO = false;
        this.O00000o = true;
    }

    public final iqw O000000o() {
        iqw iqw = this.O00000oo;
        if (iqw == this) {
            iqw = null;
        }
        iqw iqw2 = this.O0000O0o;
        iqw2.O00000oo = this.O00000oo;
        this.O00000oo.O0000O0o = iqw2;
        this.O00000oo = null;
        this.O0000O0o = null;
        return iqw;
    }

    public final iqw O000000o(iqw iqw) {
        iqw.O0000O0o = this;
        iqw.O00000oo = this.O00000oo;
        this.O00000oo.O0000O0o = iqw;
        this.O00000oo = iqw;
        return iqw;
    }

    public final void O000000o(iqw iqw, int i) {
        if (iqw.O00000oO) {
            int i2 = iqw.O00000o0;
            if (i2 + i > 8192) {
                if (!iqw.O00000o) {
                    int i3 = iqw.O00000Oo;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = iqw.f1572O000000o;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        iqw.O00000o0 -= iqw.O00000Oo;
                        iqw.O00000Oo = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f1572O000000o, this.O00000Oo, iqw.f1572O000000o, iqw.O00000o0, i);
            iqw.O00000o0 += i;
            this.O00000Oo += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
