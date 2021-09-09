package _m_j;

import java.lang.reflect.Type;
import java.util.Locale;

public final class bez implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bez f12918O000000o = new bez();

    public final int O000000o() {
        return 4;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        String str = (String) bdo.O000000o((Object) null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("_");
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        if (split.length == 2) {
            return new Locale(split[0], split[1]);
        }
        return new Locale(split[0], split[1], split[2]);
    }
}
