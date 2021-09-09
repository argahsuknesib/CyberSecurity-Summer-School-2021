package _m_j;

class jdz {
    static Class O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    String f1782O000000o;
    int O00000Oo;

    jdz(String str) {
        this.f1782O000000o = str;
        this.O00000Oo = str.hashCode();
    }

    public final int hashCode() {
        return this.O00000Oo;
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Class<?> cls = O00000o0;
        if (cls == null) {
            cls = O000000o("_m_j.jdz");
            O00000o0 = cls;
        }
        if (cls == obj.getClass()) {
            return this.f1782O000000o.equals(((jdz) obj).f1782O000000o);
        }
        return false;
    }
}
