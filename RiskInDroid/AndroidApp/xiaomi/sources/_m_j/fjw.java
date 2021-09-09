package _m_j;

import com.xiaomi.smarthome.R;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class fjw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final fkv<Object, Object> f16503O000000o = $$Lambda$fjw$tOaNG6D_i1JIQF_MSPlGwPbCimI.INSTANCE;
    public static final Map<String, Map<String, fkv<Object, Object>>> O00000Oo;
    public static final Map<String, Integer> O00000o0;

    /* access modifiers changed from: private */
    public static /* synthetic */ Object O00000o0(Object obj) throws RuntimeException {
        return obj;
    }

    static {
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, false);
        linkedHashMap.put("℃", f16503O000000o);
        linkedHashMap.put("°F", $$Lambda$fjw$t0rqAFjuP1Ew3Vc4tGEQdiEnl4.INSTANCE);
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        o0o0ooo0.put("℃", unmodifiableMap);
        o0o0ooo0.put("°C", unmodifiableMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(0, 0.75f, false);
        linkedHashMap2.put("℃", $$Lambda$fjw$JUJ8_M9ZAvOu6WYEgIPVairmRXg.INSTANCE);
        linkedHashMap2.put("°F", f16503O000000o);
        o0o0ooo0.put("°F", Collections.unmodifiableMap(linkedHashMap2));
        O00000Oo = Collections.unmodifiableMap(o0o0ooo0);
        o0O0OOO0 o0o0ooo02 = new o0O0OOO0();
        o0o0ooo02.put("℃", Integer.valueOf((int) R.string.mj_unit_temp_centigrade));
        o0o0ooo02.put("°F", Integer.valueOf((int) R.string.mj_unit_temp_fahrenheit));
        O00000o0 = Collections.unmodifiableMap(o0o0ooo02);
    }
}
