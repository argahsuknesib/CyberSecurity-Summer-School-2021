package _m_j;

public final class re {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f2423O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public String O00000oo;
    public long O0000O0o;
    public boolean O0000OOo = false;
    public op O0000Oo0;

    public re(boolean z, String str, long j, int i, int i2, int i3, int i4) {
        this.f2423O000000o = z;
        this.O00000oo = str;
        this.O0000O0o = j;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = i3;
        this.O00000oO = i4;
    }

    public final String toString() {
        double d;
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.f2423O000000o);
        sb.append("@");
        sb.append(this.O00000oo);
        sb.append("@");
        sb.append(this.O00000Oo);
        sb.append("@");
        sb.append(this.O00000o0);
        sb.append("@");
        sb.append(this.O00000oO);
        sb.append("@");
        sb.append(this.O0000OOo);
        sb.append("@");
        op opVar = this.O0000Oo0;
        double d2 = 0.0d;
        if (opVar != null) {
            d = opVar.O00000Oo;
        } else {
            d = 0.0d;
        }
        sb.append(d);
        sb.append("@");
        op opVar2 = this.O0000Oo0;
        if (opVar2 != null) {
            d2 = opVar2.f2369O000000o;
        }
        sb.append(d2);
        sb.append('}');
        return sb.toString();
    }
}
