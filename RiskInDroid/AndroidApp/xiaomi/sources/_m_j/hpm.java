package _m_j;

import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.ArrayList;
import java.util.List;

public final class hpm extends BaseDevice {

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<String> f470O000000o = new ArrayList();
    protected List<String> O00000Oo = new ArrayList();

    public hpm(DeviceStat deviceStat) {
        super(deviceStat);
    }

    public final int hashCode() {
        if (this.mDeviceStat == null) {
            return 0;
        }
        return this.mDeviceStat.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof hpm) && ((hpm) obj).hashCode() == hashCode();
    }
}
