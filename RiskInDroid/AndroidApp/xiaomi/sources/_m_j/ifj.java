package _m_j;

final class ifj {

    /* renamed from: O000000o  reason: collision with root package name */
    final ifd f1258O000000o;
    final ifd O00000Oo;
    private final boolean O00000o = true;
    final ife O00000o0;

    ifj(ifd ifd, ifd ifd2, ife ife) {
        this.f1258O000000o = ifd;
        this.O00000Oo = ifd2;
        this.O00000o0 = ife;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f1258O000000o);
        sb.append(" , ");
        sb.append(this.O00000Oo);
        sb.append(" : ");
        ife ife = this.O00000o0;
        if (ife == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(ife.f1257O000000o);
        }
        sb.append(obj);
        sb.append(" ]");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ifj)) {
            return false;
        }
        ifj ifj = (ifj) obj;
        if (!O000000o(this.f1258O000000o, ifj.f1258O000000o) || !O000000o(this.O00000Oo, ifj.O00000Oo) || !O000000o(this.O00000o0, ifj.O00000o0)) {
            return false;
        }
        return true;
    }

    private static boolean O000000o(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final int hashCode() {
        return (O000000o(this.f1258O000000o) ^ O000000o(this.O00000Oo)) ^ O000000o(this.O00000o0);
    }

    private static int O000000o(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
