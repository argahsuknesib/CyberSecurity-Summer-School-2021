package _m_j;

final class iqx {

    /* renamed from: O000000o  reason: collision with root package name */
    static iqw f1573O000000o;
    static long O00000Oo;

    private iqx() {
    }

    static iqw O000000o() {
        synchronized (iqx.class) {
            if (f1573O000000o == null) {
                return new iqw();
            }
            iqw iqw = f1573O000000o;
            f1573O000000o = iqw.O00000oo;
            iqw.O00000oo = null;
            O00000Oo -= 8192;
            return iqw;
        }
    }

    static void O000000o(iqw iqw) {
        if (iqw.O00000oo != null || iqw.O0000O0o != null) {
            throw new IllegalArgumentException();
        } else if (!iqw.O00000o) {
            synchronized (iqx.class) {
                if (O00000Oo + 8192 <= 65536) {
                    O00000Oo += 8192;
                    iqw.O00000oo = f1573O000000o;
                    iqw.O00000o0 = 0;
                    iqw.O00000Oo = 0;
                    f1573O000000o = iqw;
                }
            }
        }
    }
}
