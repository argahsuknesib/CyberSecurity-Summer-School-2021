package _m_j;

import java.util.HashMap;

public final class rg {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2425O000000o = 0;
    public HashMap<Long, rf> O00000Oo = new HashMap<>();
    public StringBuilder O00000o = new StringBuilder();
    public int O00000o0 = 0;
    public StringBuilder O00000oO = new StringBuilder();
    public op O00000oo;

    public final String toString() {
        double d;
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.f2425O000000o);
        sb.append("@");
        sb.append(this.O00000o0);
        sb.append("@");
        op opVar = this.O00000oo;
        double d2 = 0.0d;
        if (opVar != null) {
            d = opVar.O00000Oo;
        } else {
            d = 0.0d;
        }
        sb.append(d);
        sb.append("@");
        op opVar2 = this.O00000oo;
        if (opVar2 != null) {
            d2 = opVar2.f2369O000000o;
        }
        sb.append(d2);
        sb.append('}');
        return sb.toString();
    }
}
