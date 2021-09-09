package _m_j;

import java.lang.reflect.Type;
import java.util.UUID;

public final class bfs implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfs f12932O000000o = new bfs();

    public final int O000000o() {
        return 4;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        String str = (String) bdo.O000000o((Object) null);
        if (str == null) {
            return null;
        }
        return UUID.fromString(str);
    }
}
