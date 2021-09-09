package _m_j;

public final class ckz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13979O000000o = 0;
    public int O00000Oo = 10;
    public int O00000o = 17;
    public int O00000o0 = 0;
    public int O00000oO = 0;
    public int O00000oo = 1;
    public int O0000O0o = 5;

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ckz)) {
            return false;
        }
        ckz ckz = (ckz) obj;
        int i = this.f13979O000000o;
        if (i != ckz.f13979O000000o || this.O00000oo != ckz.O00000oo || this.O0000O0o != ckz.O0000O0o) {
            return false;
        }
        if (i == 0 || i == 1) {
            return true;
        }
        if (this.O00000Oo == ckz.O00000Oo && this.O00000o0 == ckz.O00000o0 && this.O00000o == ckz.O00000o && this.O00000oO == ckz.O00000oO) {
            return true;
        }
        return false;
    }

    public final void O000000o(ckz ckz) {
        this.f13979O000000o = ckz.f13979O000000o;
        this.O00000Oo = ckz.O00000Oo;
        this.O00000o0 = ckz.O00000o0;
        this.O00000o = ckz.O00000o;
        this.O00000oO = ckz.O00000oO;
        this.O00000oo = ckz.O00000oo;
        this.O0000O0o = ckz.O0000O0o;
    }
}
