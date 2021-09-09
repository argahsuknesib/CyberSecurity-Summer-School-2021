package _m_j;

import java.util.HashMap;
import java.util.Map;

public final class czg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<Class, Object> f14401O000000o = new HashMap();

    public static <I, T extends I> T O000000o(Class<I> cls, cyy cyy) throws Exception {
        if (cls == null) {
            return null;
        }
        if (cyy == null) {
            cyy = cux.O000000o();
        }
        T O00000Oo = O00000Oo(cls, cyy);
        Object[] objArr = {cls, O00000Oo};
        cvb.O00000o();
        return O00000Oo;
    }

    private static Object O00000Oo(Class cls, cyy cyy) throws Exception {
        Object obj;
        Object obj2 = f14401O000000o.get(cls);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (f14401O000000o) {
            obj = f14401O000000o.get(cls);
            if (obj == null) {
                new Object[1][0] = cls;
                cvb.O00000o();
                obj = cyy.O000000o(cls);
                if (obj != null) {
                    f14401O000000o.put(cls, obj);
                }
            }
        }
        return obj;
    }
}
