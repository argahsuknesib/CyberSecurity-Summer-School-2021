package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class fng extends fnf {
    public final int O00000oO() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_SUCCESS) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Device device : collection) {
                if ((device instanceof MiioDeviceV2) && !TextUtils.isEmpty(device.parentId)) {
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
        }
    }
}
