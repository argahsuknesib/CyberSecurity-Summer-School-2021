package _m_j;

import java.lang.reflect.Type;
import java.util.Map;

public final class bet extends ben {
    public final int O000000o() {
        return 2;
    }

    public bet(Class<?> cls, bid bid) {
        super(cls, bid);
    }

    public final void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 2) {
            int O0000o0O = O0000O0o.O0000o0O();
            O0000O0o.O000000o(16);
            if (obj == null) {
                map.put(this.f12908O000000o.f12989O000000o, Integer.valueOf(O0000o0O));
            } else {
                O000000o(obj, Integer.valueOf(O0000o0O));
            }
        } else {
            Integer num = null;
            if (O0000O0o.O00000o0() == 8) {
                O0000O0o.O000000o(16);
            } else {
                num = bih.O0000Oo(bdo.O000000o((Object) null));
            }
            if (num != null || O00000o() != Integer.TYPE) {
                if (obj == null) {
                    map.put(this.f12908O000000o.f12989O000000o, num);
                } else {
                    O000000o(obj, num);
                }
            }
        }
    }
}
