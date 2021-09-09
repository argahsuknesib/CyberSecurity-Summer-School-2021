package _m_j;

import java.util.HashMap;
import java.util.Map;

public final class ckk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ckk f13969O000000o = new ckk();
    private Map<String, Long> O00000Oo = new HashMap();

    public static ckk O000000o() {
        return f13969O000000o;
    }

    public final void O000000o(String str, String str2, String str3) {
        cki.O00000o0(str, str2 + ":" + str3);
        this.O00000Oo.put(str2, Long.valueOf(System.currentTimeMillis()));
    }

    public final void O00000Oo(String str, String str2, String str3) {
        if (this.O00000Oo.containsKey(str2)) {
            long longValue = this.O00000Oo.remove(str2).longValue();
            cki.O00000o0(str, str2 + ":" + str3 + ":cost:" + (System.currentTimeMillis() - longValue));
        }
    }
}
