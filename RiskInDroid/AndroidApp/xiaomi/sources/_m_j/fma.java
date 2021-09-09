package _m_j;

import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.framework.bluetooth.BluetoothReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class fma extends DeviceSearch<BleDevice> {

    /* renamed from: O000000o  reason: collision with root package name */
    Collection<? extends Device> f16597O000000o;
    private List<BleDevice> O00000Oo = Collections.synchronizedList(new ArrayList());
    private Object O00000o0 = new Object();

    public final void O00000Oo() {
        BluetoothReceiver.O00000Oo();
    }

    public final int O00000oO() {
        return Device.PID_BLUETOOTH;
    }

    public final List<BleDevice> O00000o0() {
        ArrayList arrayList;
        synchronized (this.O00000o0) {
            arrayList = new ArrayList(this.O00000Oo);
        }
        return arrayList;
    }

    public final void O00000o() {
        fof.O00000o0();
    }

    public final void O000000o() {
        synchronized (this.O00000o0) {
            this.O00000Oo.clear();
            fof.O000000o();
            if (this.f16597O000000o != null) {
                for (Device device : this.f16597O000000o) {
                    if (device instanceof BleDevice) {
                        this.O00000Oo.add((BleDevice) device);
                    }
                }
            }
        }
    }

    public final void O00000Oo(Device device) {
        if (device.pid == Device.PID_BLUETOOTH && (device instanceof BleDevice)) {
            Collection<? extends Device> collection = this.f16597O000000o;
            if (collection != null) {
                collection.remove(device);
            }
            synchronized (this.O00000o0) {
                this.O00000Oo.remove(device);
            }
        }
    }

    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_SUCCESS) {
            this.f16597O000000o = collection;
        }
    }
}
