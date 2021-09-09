package _m_j;

import java.lang.reflect.Type;

public final class bfe implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfe f12921O000000o = new bfe();

    public final int O000000o() {
        return 2;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String O0000OOo = O0000O0o.O0000OOo();
                O0000O0o.O000000o(16);
                return Double.valueOf(Double.parseDouble(O0000OOo));
            }
            long O0000oo0 = O0000O0o.O0000oo0();
            O0000O0o.O000000o(16);
            if (type == Short.TYPE || type == Short.class) {
                return Short.valueOf((short) ((int) O0000oo0));
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return Byte.valueOf((byte) ((int) O0000oo0));
            }
            if (O0000oo0 < -2147483648L || O0000oo0 > 2147483647L) {
                return Long.valueOf(O0000oo0);
            }
            return Integer.valueOf((int) O0000oo0);
        } else if (O0000O0o.O00000o0() != 3) {
            Object O000000o2 = bdo.O000000o((Object) null);
            if (O000000o2 == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return bih.O0000OOo(O000000o2);
            }
            if (type == Short.TYPE || type == Short.class) {
                return bih.O00000o(O000000o2);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return bih.O00000Oo(O000000o2);
            }
            return bih.O00000oO(O000000o2);
        } else if (type == Double.TYPE || type == Double.class) {
            String O0000OOo2 = O0000O0o.O0000OOo();
            O0000O0o.O000000o(16);
            return Double.valueOf(Double.parseDouble(O0000OOo2));
        } else {
            T O0000oo = O0000O0o.O0000oo();
            O0000O0o.O000000o(16);
            if (type == Short.TYPE || type == Short.class) {
                return Short.valueOf(O0000oo.shortValue());
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return Byte.valueOf(O0000oo.byteValue());
            }
            return O0000oo;
        }
    }
}
