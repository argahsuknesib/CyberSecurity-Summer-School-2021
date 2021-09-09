package _m_j;

public class fwx {
    private static volatile fwx O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f17339O000000o;
    public long O00000Oo;
    public boolean O00000o = false;
    public long O00000o0;
    public boolean O00000oO = false;

    private fwx() {
    }

    public static fwx O000000o() {
        if (O00000oo == null) {
            synchronized (fwx.class) {
                if (O00000oo == null) {
                    O00000oo = new fwx();
                }
            }
        }
        return O00000oo;
    }
}
