package _m_j;

import com.xiaomi.smarthome.device.Device;
import java.util.HashMap;
import java.util.Map;

public class fxk {
    private static volatile fxk O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, Device> f17374O000000o = new HashMap();

    private fxk() {
        this.f17374O000000o.put("mock.did.xiaomi.demo", fxl.O000000o("mock.did.xiaomi.demo", "mock.model.xiaomi.demo"));
        this.f17374O000000o.put("mock.did.miot.curtain", fxl.O000000o("mock.did.miot.curtain", "mock.model.miot.curtain"));
        this.f17374O000000o.put("mock.did.miot.plug", fxl.O000000o("mock.did.miot.plug", "mock.model.miot.plug"));
        this.f17374O000000o.put("mock.did.miot.light", fxl.O000000o("mock.did.miot.light", "mock.model.miot.light"));
    }

    public static fxk O000000o() {
        if (O00000Oo == null) {
            synchronized (fxk.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fxk();
                }
            }
        }
        return O00000Oo;
    }
}
