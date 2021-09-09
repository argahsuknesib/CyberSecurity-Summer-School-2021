package _m_j;

import _m_j.guh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class guq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, Boolean> f18318O000000o = new ConcurrentHashMap();

    public static void O000000o() {
        f18318O000000o.clear();
    }

    public static void O000000o(gul gul) {
        if ((gul instanceof guh.O000000o) && gul.O00000o()) {
            f18318O000000o.put(gul.O00000o0(), Boolean.TRUE);
        }
    }

    public static void O000000o(String str) {
        f18318O000000o.remove(str);
    }
}
