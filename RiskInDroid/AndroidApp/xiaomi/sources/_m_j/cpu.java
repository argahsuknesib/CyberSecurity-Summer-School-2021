package _m_j;

public final class cpu {

    /* renamed from: O000000o  reason: collision with root package name */
    cpv f14217O000000o;
    public byte[] O00000Oo = null;
    int O00000o = 0;
    public long O00000o0 = -1;
    public cpz O00000oO = null;
    int O00000oo = -1;

    cpu(cpv cpv) {
        this.f14217O000000o = cpv;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof cpu) && ((cpu) obj).O00000o0 == this.O00000o0;
    }

    public final void O000000o() {
        cpv cpv = this.f14217O000000o;
        if (cpv != null) {
            cpv.O000000o(this);
        }
        this.O00000Oo = null;
        this.O00000o = 0;
        this.O00000o0 = -1;
        this.O00000oO = null;
        this.O00000oo = -1;
    }
}
