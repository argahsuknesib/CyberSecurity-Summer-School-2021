package _m_j;

import java.lang.reflect.Type;
import java.util.Map;

public final class bfb extends ben {
    private final bff O00000o0;

    public bfb(bdu bdu, Class<?> cls, bid bid) {
        super(cls, bid);
        this.O00000o0 = bdu.O000000o(bid);
    }

    public final void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 2) {
            long O0000oo0 = O0000O0o.O0000oo0();
            O0000O0o.O000000o(16);
            if (obj == null) {
                map.put(this.f12908O000000o.f12989O000000o, Long.valueOf(O0000oo0));
            } else {
                O000000o(obj, Long.valueOf(O0000oo0));
            }
        } else {
            Long l = null;
            if (O0000O0o.O00000o0() == 8) {
                O0000O0o.O000000o(16);
            } else {
                l = bih.O0000Oo0(bdo.O000000o((Object) null));
            }
            if (l != null || O00000o() != Long.TYPE) {
                if (obj == null) {
                    map.put(this.f12908O000000o.f12989O000000o, l);
                } else {
                    O000000o(obj, l);
                }
            }
        }
    }

    public final int O000000o() {
        return this.O00000o0.O000000o();
    }
}
