package _m_j;

import com.xiaomi.smarthome.device.Device;
import java.util.HashMap;
import java.util.Map;

public final class ham {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, Long> f18709O000000o = new HashMap();

    public static void O000000o(Device device, int i, int i2) {
        if (device != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 0) {
                f18709O000000o.put(device.did, Long.valueOf(currentTimeMillis));
                return;
            }
            Long l = null;
            if (i == 1) {
                l = f18709O000000o.get(device.did);
            } else if (i == 2) {
                l = f18709O000000o.get(device.did);
            }
            f18709O000000o.remove(device.did);
            if (l != null) {
                hxk hxk = hxi.O00000o;
                String str = device.model;
                hxk.f952O000000o.O000000o("plugin_quick_result", "code", Integer.valueOf(i2), "model", str, "time", Long.valueOf(System.currentTimeMillis() - l.longValue()));
            }
        }
    }
}
