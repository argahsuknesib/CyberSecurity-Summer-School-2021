package _m_j;

import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class fnk extends DeviceSearch<Device> {

    /* renamed from: O000000o  reason: collision with root package name */
    List<Device> f16696O000000o = Collections.synchronizedList(new ArrayList(1));

    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
    }

    public final void O00000Oo() {
        this.f16696O000000o.clear();
        if (fqw.O00000o0()) {
            this.f16696O000000o.add(fqw.O00000Oo());
        }
        this.O0000O0o = true;
    }

    public final List<Device> O00000o0() {
        return this.f16696O000000o;
    }

    public final void O00000o() {
        this.f16696O000000o.clear();
    }
}
