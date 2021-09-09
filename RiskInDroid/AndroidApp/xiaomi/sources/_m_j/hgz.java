package _m_j;

public class hgz {
    private static hgz O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f18926O000000o = 0;

    public static hgz O000000o() {
        if (O00000Oo == null) {
            synchronized (hgz.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hgz();
                }
            }
        }
        return O00000Oo;
    }
}
