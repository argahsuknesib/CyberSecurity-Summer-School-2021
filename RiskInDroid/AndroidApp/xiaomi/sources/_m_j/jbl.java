package _m_j;

final class jbl {

    /* renamed from: O000000o  reason: collision with root package name */
    static jbk f1739O000000o;
    static long O00000Oo;

    private jbl() {
    }

    static jbk O000000o() {
        synchronized (jbl.class) {
            if (f1739O000000o == null) {
                return new jbk();
            }
            jbk jbk = f1739O000000o;
            f1739O000000o = jbk.O00000oo;
            jbk.O00000oo = null;
            O00000Oo -= 8192;
            return jbk;
        }
    }

    static void O000000o(jbk jbk) {
        if (jbk.O00000oo != null || jbk.O0000O0o != null) {
            throw new IllegalArgumentException();
        } else if (!jbk.O00000o) {
            synchronized (jbl.class) {
                if (O00000Oo + 8192 <= 65536) {
                    O00000Oo += 8192;
                    jbk.O00000oo = f1739O000000o;
                    jbk.O00000o0 = 0;
                    jbk.O00000Oo = 0;
                    f1739O000000o = jbk;
                }
            }
        }
    }
}
