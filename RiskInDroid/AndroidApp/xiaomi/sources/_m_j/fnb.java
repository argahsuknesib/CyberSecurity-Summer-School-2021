package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class fnb extends fnf {
    public final int O00000oO() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        boolean z;
        if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_SUCCESS) {
            ArrayList arrayList = new ArrayList();
            ArrayList<MiioDeviceV2> arrayList2 = new ArrayList<>();
            for (Device device : collection) {
                if (device instanceof MiTVDevice) {
                    if (device.isOwner()) {
                        device.userId = CoreApi.O000000o().O0000o0();
                        arrayList.add((MiioDeviceV2) device);
                    } else {
                        arrayList2.add((MiioDeviceV2) device);
                    }
                    ((MiTVDevice) device).isLocalSearchDevice = false;
                } else if (device instanceof MiioDeviceV2) {
                    if (device.isBinded()) {
                        device.userId = CoreApi.O000000o().O0000o0();
                        arrayList.add((MiioDeviceV2) device);
                    } else {
                        arrayList2.add((MiioDeviceV2) device);
                    }
                }
            }
            fnh.O000000o().O00000o.clear();
            for (MiioDeviceV2 miioDeviceV2 : arrayList2) {
                if (miioDeviceV2 instanceof MiTVDevice) {
                    fnh O000000o2 = fnh.O000000o();
                    String str = miioDeviceV2.did;
                    if (O000000o2.O00000Oo == null) {
                        z = false;
                    } else {
                        z = O000000o2.O00000Oo.contains(str);
                    }
                    if (!z) {
                        arrayList.add(miioDeviceV2);
                    } else {
                        fnh.O000000o().O00000o.add((MiTVDevice) miioDeviceV2);
                    }
                } else {
                    arrayList.add(miioDeviceV2);
                }
            }
            O000000o(arrayList);
        } else if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_FAILED) {
            O000000o((List<MiioDeviceV2>) null);
        } else if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_NOT_LOGIN) {
            O000000o((List<MiioDeviceV2>) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oo() {
        goq.O000000o(new Runnable() {
            /* class _m_j.fnb.AnonymousClass1 */

            public final void run() {
                if (gog.O000000o(CommonApplication.getAppContext()) != null) {
                    int i = 0;
                    while (i < fnb.this.f16693O000000o.size()) {
                        try {
                            MiioDeviceV2 miioDeviceV2 = (MiioDeviceV2) fnb.this.f16693O000000o.get(i);
                            if (miioDeviceV2 instanceof MiTVDevice) {
                                MiTVDevice miTVDevice = (MiTVDevice) miioDeviceV2;
                                miTVDevice.O000000o(miTVDevice.ip);
                            }
                            i++;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            }
        });
    }
}
