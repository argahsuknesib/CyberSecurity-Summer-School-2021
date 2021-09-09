package _m_j;

import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class fjl extends fjf {

    /* renamed from: O000000o  reason: collision with root package name */
    List<Device> f16478O000000o = Collections.synchronizedList(new ArrayList());

    public final List<Device> O000000o(List<Device> list) {
        ArrayList<Device> arrayList = new ArrayList<>();
        for (Device next : this.f16478O000000o) {
            next.setLocation(Device.Location.REMOTE);
            arrayList.add(next);
        }
        if (list == null) {
            this.f16478O000000o.clear();
            return arrayList;
        }
        for (Device next2 : list) {
            boolean z = false;
            for (Device device : arrayList) {
                if (!(next2.getDid() == null || device.getDid() == null || !next2.getDid().equalsIgnoreCase(device.getDid()))) {
                    device.setLocation(Device.Location.LOCAL);
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(next2);
            }
        }
        this.f16478O000000o.clear();
        this.f16478O000000o.addAll(list);
        return arrayList;
    }

    public final List<Device> O000000o() {
        return new ArrayList(this.f16478O000000o);
    }
}
