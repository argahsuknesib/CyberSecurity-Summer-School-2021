package _m_j;

import java.lang.reflect.Type;

public final class bee implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bee f12900O000000o = new bee();

    public final int O000000o() {
        return 4;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 4) {
            String O0000oO0 = O0000O0o.O0000oO0();
            O0000O0o.O000000o(16);
            return O0000oO0.toCharArray();
        } else if (O0000O0o.O00000o0() == 2) {
            Number O0000O0o2 = O0000O0o.O0000O0o();
            O0000O0o.O000000o(16);
            return O0000O0o2.toString().toCharArray();
        } else {
            Object O000000o2 = bdo.O000000o((Object) null);
            if (O000000o2 == null) {
                return null;
            }
            return bdf.O000000o(O000000o2).toCharArray();
        }
    }
}
