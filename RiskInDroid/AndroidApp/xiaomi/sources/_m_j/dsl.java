package _m_j;

public final class dsl {

    /* renamed from: O000000o  reason: collision with root package name */
    public final boolean f14892O000000o = false;
    public final boolean O00000Oo = false;
    public final boolean O00000o = true;
    public final boolean O00000o0 = false;

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfigRenderOptions(");
        if (this.f14892O000000o) {
            sb.append("originComments,");
        }
        if (this.O00000Oo) {
            sb.append("comments,");
        }
        if (this.O00000o0) {
            sb.append("formatted,");
        }
        if (this.O00000o) {
            sb.append("json,");
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }
        sb.append(")");
        return sb.toString();
    }
}
