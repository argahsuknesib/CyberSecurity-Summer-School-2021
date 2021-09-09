package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.Type;

public final class beh implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final beh f12903O000000o = new beh();

    public final int O000000o() {
        return 4;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o();
            return null;
        } else if (O0000O0o.O00000o0() == 4) {
            String O0000oO0 = O0000O0o.O0000oO0();
            O0000O0o.O000000o(16);
            return bih.O000000o(O0000oO0);
        } else {
            throw new JSONException("expect className");
        }
    }
}
