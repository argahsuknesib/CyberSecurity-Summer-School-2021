package _m_j;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

public final class bfa implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfa f12919O000000o = new bfa();

    public final int O000000o() {
        return 2;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        T t;
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 2) {
            long O0000oo0 = O0000O0o.O0000oo0();
            O0000O0o.O000000o(16);
            t = Long.valueOf(O0000oo0);
        } else {
            Object O000000o2 = bdo.O000000o((Object) null);
            if (O000000o2 == null) {
                return null;
            }
            t = bih.O0000Oo0(O000000o2);
        }
        return type == AtomicLong.class ? new AtomicLong(t.longValue()) : t;
    }
}
