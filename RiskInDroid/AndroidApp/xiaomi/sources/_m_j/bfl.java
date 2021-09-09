package _m_j;

import java.lang.reflect.Type;
import java.util.Map;

public final class bfl extends ben {
    private final bff O00000o0;

    public bfl(bdu bdu, Class<?> cls, bid bid) {
        super(cls, bid);
        this.O00000o0 = bdu.O000000o(bid);
    }

    public final void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map) {
        bdp O0000O0o = bdo.O0000O0o();
        String str = null;
        if (O0000O0o.O00000o0() == 4) {
            str = O0000O0o.O0000oO0();
            O0000O0o.O000000o(16);
        } else {
            Object O000000o2 = bdo.O000000o((Object) null);
            if (O000000o2 != null) {
                str = O000000o2.toString();
            }
        }
        if (obj == null) {
            map.put(this.f12908O000000o.f12989O000000o, str);
        } else {
            O000000o(obj, str);
        }
    }

    public final int O000000o() {
        return this.O00000o0.O000000o();
    }
}
