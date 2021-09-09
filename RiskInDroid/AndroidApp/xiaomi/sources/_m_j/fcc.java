package _m_j;

import java.util.HashSet;
import java.util.Set;

public class fcc {
    private static volatile fcc O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Set<String> f16073O000000o = new HashSet();

    private fcc() {
    }

    public static fcc O000000o() {
        if (O00000Oo == null) {
            synchronized (fcc.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fcc();
                }
            }
        }
        return O00000Oo;
    }
}
