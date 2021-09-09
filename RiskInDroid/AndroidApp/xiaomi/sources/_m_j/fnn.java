package _m_j;

import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import java.util.List;

public class fnn {
    private static volatile fnn O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public fmq f16706O000000o = DeviceRouterFactory.getDeviceHelper();

    private fnn() {
    }

    public static fnn O000000o() {
        if (O00000Oo == null) {
            synchronized (fnn.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fnn();
                }
            }
        }
        return O00000Oo;
    }

    public final DeviceTagInterface<Device> O00000Oo() {
        return this.f16706O000000o.getDeviceTagManager();
    }

    public final String[] O000000o(fni fni) {
        return this.f16706O000000o.findDeviceIdsByGroupInfo(fni);
    }

    public final void O000000o(int i) {
        this.f16706O000000o.addChangeNetWorkId(i);
    }

    public final List<fni> O00000o0() {
        return this.f16706O000000o.getUsableGroups();
    }

    public final int O00000o() {
        return this.f16706O000000o.getChangeNetworkId();
    }
}
