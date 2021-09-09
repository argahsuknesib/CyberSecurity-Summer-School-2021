package _m_j;

public final class xt {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f2598O000000o;
    private final int O00000Oo;
    private final int O00000o;
    private final int O00000o0;
    private final String O00000oO;
    private final xq O00000oo;

    public xt(int i, int i2, int i3, int i4, String str, xq xqVar) {
        this.f2598O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
        this.O00000o = i4;
        this.O00000oO = str;
        this.O00000oo = xqVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xt xtVar = (xt) obj;
        if (this.O00000o != xtVar.O00000o || this.O00000o0 != xtVar.O00000o0 || this.f2598O000000o != xtVar.f2598O000000o || this.O00000Oo != xtVar.O00000Oo) {
            return false;
        }
        xq xqVar = this.O00000oo;
        if (xqVar == null ? xtVar.O00000oo != null : !xqVar.equals(xtVar.O00000oo)) {
            return false;
        }
        String str = this.O00000oO;
        return str == null ? xtVar.O00000oO == null : str.equals(xtVar.O00000oO);
    }

    public final int hashCode() {
        int i = ((((((this.f2598O000000o * 31) + this.O00000Oo) * 31) + this.O00000o0) * 31) + this.O00000o) * 31;
        String str = this.O00000oO;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        xq xqVar = this.O00000oo;
        if (xqVar != null) {
            i2 = xqVar.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x: ");
        sb.append(this.f2598O000000o);
        sb.append(" y: ");
        sb.append(this.O00000Oo);
        sb.append(" width: ");
        sb.append(this.O00000o0);
        sb.append(" height: ");
        sb.append(this.O00000o);
        if (this.O00000oO != null) {
            sb.append(" name: ");
            sb.append(this.O00000oO);
        }
        if (this.O00000oo != null) {
            sb.append(" age: ");
            sb.append(this.O00000oo.O000000o());
        }
        return sb.toString();
    }
}
