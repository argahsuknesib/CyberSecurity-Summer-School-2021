package _m_j;

import java.lang.reflect.Type;
import java.util.Map;

public final class bec extends ben {
    public final int O000000o() {
        return 6;
    }

    public bec(Class<?> cls, bid bid) {
        super(cls, bid);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ben.O000000o(java.lang.Object, boolean):void
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.ben.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.ben.O000000o(java.lang.Object, boolean):void */
    public final void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map) {
        bdp O0000O0o = bdo.O0000O0o();
        boolean z = true;
        if (O0000O0o.O00000o0() == 6) {
            O0000O0o.O000000o(16);
            if (obj == null) {
                map.put(this.f12908O000000o.f12989O000000o, Boolean.TRUE);
            } else {
                O000000o(obj, true);
            }
        } else if (O0000O0o.O00000o0() == 2) {
            int O0000o0O = O0000O0o.O0000o0O();
            O0000O0o.O000000o(16);
            if (O0000o0O != 1) {
                z = false;
            }
            if (obj == null) {
                map.put(this.f12908O000000o.f12989O000000o, Boolean.valueOf(z));
            } else {
                O000000o(obj, z);
            }
        } else if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o(16);
            if (O00000o() != Boolean.TYPE && obj != null) {
                O000000o(obj, (Object) null);
            }
        } else if (O0000O0o.O00000o0() == 7) {
            O0000O0o.O000000o(16);
            if (obj == null) {
                map.put(this.f12908O000000o.f12989O000000o, Boolean.FALSE);
            } else {
                O000000o(obj, false);
            }
        } else {
            Boolean O0000OoO = bih.O0000OoO(bdo.O000000o((Object) null));
            if (O0000OoO != null || O00000o() != Boolean.TYPE) {
                if (obj == null) {
                    map.put(this.f12908O000000o.f12989O000000o, O0000OoO);
                } else {
                    O000000o(obj, O0000OoO);
                }
            }
        }
    }
}
