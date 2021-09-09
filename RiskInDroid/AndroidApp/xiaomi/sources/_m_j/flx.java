package _m_j;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class flx extends DeviceSearch<MiioDeviceV2> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<MiioDeviceV2> f16594O000000o = Collections.synchronizedList(new ArrayList());
    protected List<MiioDeviceV2> O00000Oo = Collections.synchronizedList(new ArrayList());
    protected boolean O00000o = false;
    protected Handler O00000o0 = new Handler(Looper.getMainLooper());
    protected boolean O00000oO = false;
    protected boolean O00000oo = false;

    public final int O00000oO() {
        return 7;
    }

    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        if (!this.O0000Oo0) {
            return;
        }
        if (remotestate == DeviceSearch.REMOTESTATE.REMOTE_SUCCESS) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Device device : collection) {
                if ((device instanceof MiioDeviceV2) && device.pid == 7) {
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

    private void O000000o(List<MiioDeviceV2> list) {
        if (list != null) {
            this.O00000Oo.clear();
            this.O00000Oo.addAll(list);
        }
        this.O00000o = false;
    }

    public final synchronized void O000000o() {
        this.f16594O000000o.clear();
        this.f16594O000000o.addAll(this.O00000Oo);
    }

    public final synchronized List<MiioDeviceV2> O00000o0() {
        for (int i = 0; i < this.f16594O000000o.size(); i++) {
            Device device = this.f16594O000000o.get(i);
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device.model);
            if (O00000oO2 == null || O00000oO2.O00000o() != 9) {
                ScanResult deviceScanResult = DeviceRouterFactory.getApDeviceManager().getDeviceScanResult(device.mac);
                device.canAuth = false;
                if (deviceScanResult != null) {
                    device.isOnline = true;
                    try {
                        JSONObject jSONObject = new JSONObject(device.extra);
                        jSONObject.put("ssid", deviceScanResult.SSID);
                        jSONObject.put("bssid", deviceScanResult.BSSID);
                        device.extra = jSONObject.toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    device.desc = CommonApplication.getAppContext().getString(R.string.list_device_online);
                } else {
                    device.isOnline = false;
                    device.desc = CommonApplication.getAppContext().getString(R.string.list_device_offline);
                }
            } else {
                device.isOnline = true;
            }
        }
        return this.f16594O000000o;
    }

    public final synchronized void O00000o() {
        this.O00000Oo.clear();
        this.f16594O000000o.clear();
    }

    public final void O000000o(Device device) {
        if ((device instanceof MiioDeviceV2) && !(device instanceof RouterDevice) && device.pid == 7) {
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
        if (!this.O00000o) {
            this.O00000o = true;
            this.O00000oO = false;
            this.O00000oo = false;
        }
    }
}
