package _m_j;

import java.util.HashMap;
import java.util.Map;

public final class hmz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<String, String> f19064O000000o;

    static {
        HashMap hashMap = new HashMap();
        f19064O000000o = hashMap;
        hashMap.put("xiaomi.router.r3600", "R3600");
    }

    public static boolean O000000o(String str) {
        return f19064O000000o.containsKey(str);
    }

    public static String O00000Oo(String str) {
        return f19064O000000o.get(str);
    }
}
