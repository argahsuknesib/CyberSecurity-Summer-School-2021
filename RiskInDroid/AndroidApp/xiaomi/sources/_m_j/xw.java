package _m_j;

public final class xw {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f2601O000000o;
    private final xr O00000Oo;

    public xw(int i, xr xrVar) {
        this.f2601O000000o = i;
        this.O00000Oo = xrVar;
    }

    public final String O000000o() {
        return this.O00000Oo.O0000o(this.f2601O000000o);
    }

    public final String toString() {
        String O0000oO = this.O00000Oo.O0000oO(this.f2601O000000o);
        if (O0000oO == null) {
            O0000oO = this.O00000Oo.O0000o0(this.f2601O000000o) + " (unable to formulate description)";
        }
        return "[" + this.O00000Oo.O000000o() + "] " + O000000o() + " - " + O0000oO;
    }
}
