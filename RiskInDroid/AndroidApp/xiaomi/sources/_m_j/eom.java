package _m_j;

public class eom {
    private static volatile eom O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public eol f15678O000000o;

    public static eom O000000o() {
        if (O00000Oo == null) {
            synchronized (eom.class) {
                if (O00000Oo == null) {
                    O00000Oo = new eom();
                }
            }
        }
        return O00000Oo;
    }
}
