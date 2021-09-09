package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.Type;
import java.sql.Time;

public final class bfn implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfn f12927O000000o = new bfn();

    public final int O000000o() {
        return 2;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        long j;
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 16) {
            O0000O0o.O000000o(4);
            if (O0000O0o.O00000o0() == 4) {
                O0000O0o.O00000Oo(2);
                if (O0000O0o.O00000o0() == 2) {
                    long O0000oo0 = O0000O0o.O0000oo0();
                    O0000O0o.O000000o(13);
                    if (O0000O0o.O00000o0() == 13) {
                        O0000O0o.O000000o(16);
                        return new Time(O0000oo0);
                    }
                    throw new JSONException("syntax error");
                }
                throw new JSONException("syntax error");
            }
            throw new JSONException("syntax error");
        }
        T O000000o2 = bdo.O000000o((Object) null);
        if (O000000o2 == null) {
            return null;
        }
        if (O000000o2 instanceof Time) {
            return O000000o2;
        }
        if (O000000o2 instanceof Number) {
            return new Time(((Number) O000000o2).longValue());
        }
        if (O000000o2 instanceof String) {
            String str = (String) O000000o2;
            if (str.length() == 0) {
                return null;
            }
            bdq bdq = new bdq(str);
            if (bdq.O0000ooo()) {
                j = bdq.O0000o0().getTimeInMillis();
            } else {
                j = Long.parseLong(str);
            }
            bdq.close();
            return new Time(j);
        }
        throw new JSONException("parse error");
    }
}
