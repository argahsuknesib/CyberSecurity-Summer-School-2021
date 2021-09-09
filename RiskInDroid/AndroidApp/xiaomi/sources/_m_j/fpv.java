package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class fpv {
    public static fpv O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<String> f16891O000000o = new ArrayList();

    public static fpv O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new fpv();
        }
        return O00000Oo;
    }

    public final boolean O000000o(String str) {
        return this.f16891O000000o.contains(str);
    }
}
