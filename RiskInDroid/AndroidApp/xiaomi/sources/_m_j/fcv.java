package _m_j;

import com.xiaomi.smarthome.core.server.CoreService;
import java.util.Map;

public final class fcv implements hmh {
    public final int O000000o(int i) {
        return hvg.O000000o(CoreService.getAppContext()).O00000Oo(i);
    }

    public final void O000000o(int i, int i2) {
        hvg.O000000o(CoreService.getAppContext()).O00000o0(i2);
    }

    public final void O00000Oo(int i) {
        hvg.O000000o(CoreService.getAppContext()).O00000o0(0);
    }

    public final void O000000o() {
        hvg.O000000o(CoreService.getAppContext()).O00000o0(8);
    }

    public final void O000000o(int i, String str, String str2) {
        hvg.O000000o(CoreService.getAppContext()).O00000Oo(i, str, str2);
    }

    public final void O000000o(Map<String, String> map) {
        if (map.size() > 0) {
            for (String next : map.keySet()) {
                O000000o(10, next, map.get(next));
            }
        }
    }
}
