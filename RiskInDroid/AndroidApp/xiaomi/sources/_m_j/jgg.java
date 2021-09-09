package _m_j;

import java.util.ArrayList;
import java.util.List;

final class jgg {
    private static final List<jgg> O00000o = new ArrayList();

    /* renamed from: O000000o  reason: collision with root package name */
    Object f1820O000000o;
    jgm O00000Oo;
    jgg O00000o0;

    private jgg(Object obj, jgm jgm) {
        this.f1820O000000o = obj;
        this.O00000Oo = jgm;
    }

    static jgg O000000o(jgm jgm, Object obj) {
        synchronized (O00000o) {
            int size = O00000o.size();
            if (size <= 0) {
                return new jgg(obj, jgm);
            }
            jgg remove = O00000o.remove(size - 1);
            remove.f1820O000000o = obj;
            remove.O00000Oo = jgm;
            remove.O00000o0 = null;
            return remove;
        }
    }

    static void O000000o(jgg jgg) {
        jgg.f1820O000000o = null;
        jgg.O00000Oo = null;
        jgg.O00000o0 = null;
        synchronized (O00000o) {
            if (O00000o.size() < 10000) {
                O00000o.add(jgg);
            }
        }
    }
}
