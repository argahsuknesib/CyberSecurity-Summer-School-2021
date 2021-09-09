package _m_j;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public final class beb implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final beb f12898O000000o = new beb();

    public final int O000000o() {
        return 6;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        T t;
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 6) {
            O0000O0o.O000000o(16);
            t = Boolean.TRUE;
        } else if (O0000O0o.O00000o0() == 7) {
            O0000O0o.O000000o(16);
            t = Boolean.FALSE;
        } else if (O0000O0o.O00000o0() == 2) {
            int O0000o0O = O0000O0o.O0000o0O();
            O0000O0o.O000000o(16);
            if (O0000o0O == 1) {
                t = Boolean.TRUE;
            } else {
                t = Boolean.FALSE;
            }
        } else {
            Object O000000o2 = bdo.O000000o((Object) null);
            if (O000000o2 == null) {
                return null;
            }
            t = bih.O0000OoO(O000000o2);
        }
        return type == AtomicBoolean.class ? new AtomicBoolean(t.booleanValue()) : t;
    }
}
