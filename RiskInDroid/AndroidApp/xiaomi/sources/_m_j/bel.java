package _m_j;

import _m_j.bdo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public final class bel extends ben {
    private bff O00000o0;

    public bel(Class<?> cls, bid bid) {
        super(cls, bid);
    }

    public final void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map) {
        if (this.O00000o0 == null) {
            this.O00000o0 = bdo.O00000o0().O000000o(this.f12908O000000o);
        }
        if (type instanceof ParameterizedType) {
            bdo.O00000o().O00000o0 = type;
        }
        Object O000000o2 = this.O00000o0.O000000o(bdo, O00000oO(), this.f12908O000000o.f12989O000000o);
        if (bdo.O0000O0o == 1) {
            bdo.O000000o O00000oO = bdo.O00000oO();
            O00000oO.O00000o0 = this;
            O00000oO.O00000o = bdo.O00000o();
            bdo.O0000O0o = 0;
        } else if (obj == null) {
            map.put(this.f12908O000000o.f12989O000000o, O000000o2);
        } else {
            O000000o(obj, O000000o2);
        }
    }

    public final int O000000o() {
        bff bff = this.O00000o0;
        if (bff != null) {
            return bff.O000000o();
        }
        return 2;
    }
}
