package _m_j;

import java.lang.reflect.Type;
import java.util.TimeZone;

public final class bfo implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfo f12928O000000o = new bfo();

    public final int O000000o() {
        return 4;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        String str = (String) bdo.O000000o((Object) null);
        if (str == null) {
            return null;
        }
        return TimeZone.getTimeZone(str);
    }
}
