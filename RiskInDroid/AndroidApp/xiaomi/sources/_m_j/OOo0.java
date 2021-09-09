package _m_j;

public final class OOo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12338O000000o = 0;
    public int O00000Oo = 0;
    public int O00000o = Integer.MIN_VALUE;
    public int O00000o0 = Integer.MIN_VALUE;
    public int O00000oO = 0;
    public int O00000oo = 0;
    public boolean O0000O0o = false;
    public boolean O0000OOo = false;

    public final void O000000o(int i, int i2) {
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O0000OOo = true;
        if (this.O0000O0o) {
            if (i2 != Integer.MIN_VALUE) {
                this.f12338O000000o = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.O00000Oo = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f12338O000000o = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.O00000Oo = i2;
        }
    }

    public final void O00000Oo(int i, int i2) {
        this.O0000OOo = false;
        if (i != Integer.MIN_VALUE) {
            this.O00000oO = i;
            this.f12338O000000o = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.O00000oo = i2;
            this.O00000Oo = i2;
        }
    }
}
