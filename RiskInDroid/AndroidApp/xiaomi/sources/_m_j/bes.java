package _m_j;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public final class bes implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bes f12913O000000o = new bes();

    public final int O000000o() {
        return 2;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        T t;
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o(16);
            return null;
        }
        if (O0000O0o.O00000o0() == 2) {
            int O0000o0O = O0000O0o.O0000o0O();
            O0000O0o.O000000o(16);
            t = Integer.valueOf(O0000o0O);
        } else if (O0000O0o.O00000o0() == 3) {
            BigDecimal O0000oo = O0000O0o.O0000oo();
            O0000O0o.O000000o(16);
            t = Integer.valueOf(O0000oo.intValue());
        } else {
            t = bih.O0000Oo(bdo.O000000o((Object) null));
        }
        return type == AtomicInteger.class ? new AtomicInteger(t.intValue()) : t;
    }
}
