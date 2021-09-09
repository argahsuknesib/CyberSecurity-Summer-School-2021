package _m_j;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class fnf extends DeviceSearch<MiioDeviceV2> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final List<MiioDeviceV2> f16693O000000o = Collections.synchronizedList(new ArrayList());
    protected List<MiioDeviceV2> O00000Oo = Collections.synchronizedList(new ArrayList());
    protected Handler O00000o = new Handler(Looper.getMainLooper());
    protected HashMap<String, MiioDeviceV2> O00000o0 = new HashMap<>();
    protected boolean O00000oO = false;
    protected boolean O00000oo = false;
    protected boolean O0000Oo = false;

    public int O00000oO() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void O00000oo() {
    }

    /* access modifiers changed from: protected */
    public void O00000Oo(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_SUCCESS) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Device device : collection) {
                if ((device instanceof MiioDeviceV2) && device.pid == O00000oO()) {
                    if (device.isBinded()) {
                        device.userId = CoreApi.O000000o().O0000o0();
                        arrayList.add((MiioDeviceV2) device);
                    } else {
                        arrayList2.add((MiioDeviceV2) device);
                    }
                }
            }
            arrayList.addAll(arrayList2);
            O000000o(arrayList);
        } else if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_FAILED) {
            O000000o((List<MiioDeviceV2>) null);
        } else if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_NOT_LOGIN) {
            O000000o((List<MiioDeviceV2>) null);
        }
    }

    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        if (this.O0000Oo0) {
            O00000Oo(collection, remotestate);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(List<MiioDeviceV2> list) {
        if (list != null) {
            this.O00000Oo.clear();
            this.O00000Oo.addAll(list);
        }
        this.O00000oO = false;
        O00000oo();
    }

    public final void O000000o() {
        synchronized (this.f16693O000000o) {
            this.f16693O000000o.clear();
            this.f16693O000000o.addAll(this.O00000Oo);
        }
    }

    public final List<MiioDeviceV2> O00000o0() {
        return this.f16693O000000o;
    }

    public final void O00000o() {
        this.O00000Oo.clear();
        synchronized (this.f16693O000000o) {
            this.f16693O000000o.clear();
        }
    }

    public final void O000000o(Device device) {
        if ((device instanceof MiioDeviceV2) && !(device instanceof RouterDevice) && device.pid == O00000oO()) {
            Iterator<MiioDeviceV2> it = this.O00000Oo.iterator();
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
            this.O00000Oo.add((MiioDeviceV2) device);
        }
    }

    public final void O00000Oo(Device device) {
        for (Device next : this.O00000Oo) {
            if (device.did != null && next.did != null && device.did.equalsIgnoreCase(next.did)) {
                this.O00000Oo.remove(next);
                return;
            }
        }
    }

    public final void O00000Oo() {
        if (!this.O00000oO) {
            this.O00000oO = true;
            this.O00000oo = false;
            this.O0000Oo = false;
        }
    }
}
