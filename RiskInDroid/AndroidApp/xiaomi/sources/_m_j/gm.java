package _m_j;

public final class gm implements gx {

    /* renamed from: O000000o  reason: collision with root package name */
    final gx f18009O000000o;
    int O00000Oo = 0;
    int O00000o = -1;
    int O00000o0 = -1;
    Object O00000oO = null;

    public gm(gx gxVar) {
        this.f18009O000000o = gxVar;
    }

    public final void O000000o() {
        int i = this.O00000Oo;
        if (i != 0) {
            if (i == 1) {
                this.f18009O000000o.O000000o(this.O00000o0, this.O00000o);
            } else if (i == 2) {
                this.f18009O000000o.O00000Oo(this.O00000o0, this.O00000o);
            } else if (i == 3) {
                this.f18009O000000o.O000000o(this.O00000o0, this.O00000o, this.O00000oO);
            }
            this.O00000oO = null;
            this.O00000Oo = 0;
        }
    }

    public final void O000000o(int i, int i2) {
        int i3;
        if (this.O00000Oo == 1 && i >= (i3 = this.O00000o0)) {
            int i4 = this.O00000o;
            if (i <= i3 + i4) {
                this.O00000o = i4 + i2;
                this.O00000o0 = Math.min(i, i3);
                return;
            }
        }
        O000000o();
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000Oo = 1;
    }

    public final void O00000Oo(int i, int i2) {
        int i3;
        if (this.O00000Oo != 2 || (i3 = this.O00000o0) < i || i3 > i + i2) {
            O000000o();
            this.O00000o0 = i;
            this.O00000o = i2;
            this.O00000Oo = 2;
            return;
        }
        this.O00000o += i2;
        this.O00000o0 = i;
    }

    public final void O00000o0(int i, int i2) {
        O000000o();
        this.f18009O000000o.O00000o0(i, i2);
    }

    public final void O000000o(int i, int i2, Object obj) {
        int i3;
        if (this.O00000Oo == 3) {
            int i4 = this.O00000o0;
            int i5 = this.O00000o;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.O00000oO == obj) {
                this.O00000o0 = Math.min(i, i4);
                this.O00000o = Math.max(i5 + i4, i3) - this.O00000o0;
                return;
            }
        }
        O000000o();
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = obj;
        this.O00000Oo = 3;
    }
}
