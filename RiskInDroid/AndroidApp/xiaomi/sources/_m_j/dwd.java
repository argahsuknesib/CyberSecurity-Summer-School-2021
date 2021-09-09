package _m_j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class dwd {
    private static final Set<String> O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<String, String> f14995O000000o = new HashMap();
    public final Map<String, String> O00000Oo = new HashMap();

    static {
        HashSet hashSet = new HashSet();
        O00000o0 = hashSet;
        hashSet.add("Last-Modified");
        O00000o0.add("Content-MD5");
        O00000o0.add("Content-Type");
        O00000o0.add("Content-Length");
        O00000o0.add("Content-Encoding");
        O00000o0.add("Cache-Control");
    }

    public final long O000000o() {
        String str = this.O00000Oo.get("Content-Length");
        if (str != null) {
            return Long.parseLong(str);
        }
        return -1;
    }

    public final void O000000o(String str) {
        this.O00000Oo.put("Content-Type", str);
    }
}
