package _m_j;

import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class fme extends DeviceSearch<CameraDevice> {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap<String, CameraDevice> f16606O000000o = null;
    private List<CameraDevice> O00000Oo = Collections.synchronizedList(new ArrayList());
    private List<CameraDevice> O00000o0 = Collections.synchronizedList(new ArrayList());

    public final int O00000oO() {
        return 1;
    }

    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        if (!this.O0000Oo0) {
            return;
        }
        if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_SUCCESS) {
            ArrayList arrayList = new ArrayList();
            for (Device device : collection) {
                if (device instanceof CameraDevice) {
                    arrayList.add((CameraDevice) device);
                }
            }
            this.O00000Oo.clear();
            this.O00000Oo.addAll(arrayList);
        } else if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_FAILED) {
            this.O0000O0o = true;
            this.O0000OOo = false;
        } else {
            DeviceSearch.REMOTESTATE remotestate2 = DeviceSearch.REMOTESTATE.REMOTE_NOT_LOGIN;
        }
    }

    public final void O00000Oo() {
        this.O0000O0o = false;
    }

    public final List<CameraDevice> O00000o0() {
        return this.O00000o0;
    }

    public final void O00000Oo(Device device) {
        this.O00000o0.remove(device);
        this.O00000Oo.remove(device);
    }

    public final void O00000o() {
        this.O00000o0.clear();
        this.O00000Oo.clear();
    }

    public final void O000000o() {
        this.O00000o0.clear();
        this.O00000o0.addAll(this.O00000Oo);
    }

    public final void O000000o(Device device) {
        if ((device instanceof CameraDevice) && device.pid == 1) {
            Iterator<CameraDevice> it = this.O00000Oo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Device next = it.next();
                if (device.did != null && next.did != null && device.did.equalsIgnoreCase(next.did)) {
                    this.O00000Oo.remove(next);
                    break;
                }
            }
            this.O00000Oo.add((CameraDevice) device);
        }
    }
}
