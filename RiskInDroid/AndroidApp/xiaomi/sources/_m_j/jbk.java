package _m_j;

public final class jbk {

    /* renamed from: O000000o  reason: collision with root package name */
    public final byte[] f1738O000000o;
    public int O00000Oo;
    public boolean O00000o;
    public int O00000o0;
    boolean O00000oO;
    public jbk O00000oo;
    public jbk O0000O0o;

    jbk() {
        this.f1738O000000o = new byte[8192];
        this.O00000oO = true;
        this.O00000o = false;
    }

    public jbk(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f1738O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = z;
        this.O00000oO = z2;
    }

    /* access modifiers changed from: package-private */
    public final jbk O000000o() {
        this.O00000o = true;
        return new jbk(this.f1738O000000o, this.O00000Oo, this.O00000o0, true, false);
    }

    /* access modifiers changed from: package-private */
    public final jbk O00000Oo() {
        return new jbk((byte[]) this.f1738O000000o.clone(), this.O00000Oo, this.O00000o0, false, true);
    }

    public final jbk O00000o0() {
        jbk jbk = this.O00000oo;
        if (jbk == this) {
            jbk = null;
        }
        jbk jbk2 = this.O0000O0o;
        jbk2.O00000oo = this.O00000oo;
        this.O00000oo.O0000O0o = jbk2;
        this.O00000oo = null;
        this.O0000O0o = null;
        return jbk;
    }

    public final jbk O000000o(jbk jbk) {
        jbk.O0000O0o = this;
        jbk.O00000oo = this.O00000oo;
        this.O00000oo.O0000O0o = jbk;
        this.O00000oo = jbk;
        return jbk;
    }

    public final void O000000o(jbk jbk, int i) {
        if (jbk.O00000oO) {
            int i2 = jbk.O00000o0;
            if (i2 + i > 8192) {
                if (!jbk.O00000o) {
                    int i3 = jbk.O00000Oo;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = jbk.f1738O000000o;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        jbk.O00000o0 -= jbk.O00000Oo;
                        jbk.O00000Oo = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f1738O000000o, this.O00000Oo, jbk.f1738O000000o, jbk.O00000o0, i);
            jbk.O00000o0 += i;
            this.O00000Oo += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
