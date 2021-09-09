package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.aiot.mibeacon.BeaconManager;
import com.xiaomi.aiot.mibeacon.MiBeacon;
import com.xiaomi.aiot.mibeacon.RangeNotifier;
import com.xiaomi.miot.DeviceInfo;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.DeviceCategory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class hsg implements RangeNotifier {

    /* renamed from: O000000o  reason: collision with root package name */
    public final BeaconManager f592O000000o = BeaconManager.getInstanceForApplication(ServiceApplication.getAppContext());
    public final Map<String, MiBeacon> O00000Oo = new HashMap();
    public final Object O00000o = new Object();
    public final Map<String, MiBeacon> O00000o0 = new HashMap();
    public Map<String, Device> O00000oO = new HashMap();
    public long O00000oo;
    public Runnable O0000O0o = new Runnable() {
        /* class _m_j.hsg.AnonymousClass1 */

        public final void run() {
            synchronized (hsg.this.O00000o) {
                if (hsg.this.O00000oO.size() > 0) {
                    try {
                        hsg.this.O00000oo = System.currentTimeMillis();
                        hsg.this.O000000o(new ArrayList(hsg.this.O00000oO.values()));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    public Runnable O0000OOo = new Runnable() {
        /* class _m_j.hsg.AnonymousClass2 */

        public final void run() {
            gsy.O000000o(4, "MiuiService", "GetNearListTask stop apsize:" + hsg.this.O00000o0.size() + " btsize:" + hsg.this.O00000Oo.size());
            hsg.this.f592O000000o.stopRangingBeaconsForeground();
            ServiceApplication.getGlobalWorkerHandler().removeCallbacks(hsg.this.O0000O0o);
            ServiceApplication.getGlobalWorkerHandler().removeCallbacks(hsg.this.O0000OOo);
        }
    };
    private boolean O0000Oo;
    private ICallback O0000Oo0;
    private Map<String, Device> O0000OoO;
    private boolean O0000Ooo;

    public final void didRangeBeaconsInScan(Collection<MiBeacon> collection) {
        if (collection != null && this.O0000Oo0 != null && this.O0000OoO != null) {
            gsy.O000000o(4, "MiuiService", "GetNearListTask didRangeBeaconsInScan: collection:" + collection.size());
            boolean z = false;
            try {
                for (MiBeacon next : collection) {
                    String btMac = next.getBtMac();
                    String wifiMac = next.getWifiMac();
                    Device device = null;
                    if (!TextUtils.isEmpty(btMac) && this.O00000Oo.get(btMac) == null) {
                        device = this.O0000OoO.get(btMac);
                    }
                    if (device == null && !TextUtils.isEmpty(wifiMac) && this.O00000o0.get(wifiMac) == null) {
                        device = this.O0000OoO.get(wifiMac);
                    }
                    this.O00000Oo.put(btMac, next);
                    this.O00000o0.put(wifiMac, next);
                    if (device != null) {
                        gsy.O000000o(4, "MiuiService", "GetNearListTask didRangeBeaconsInScan: collection item: ble:" + Base64.encodeToString(String.valueOf(btMac).getBytes(), 2) + " ap" + Base64.encodeToString(String.valueOf(wifiMac).getBytes(), 2) + " dd" + Base64.encodeToString(String.valueOf(device.did).getBytes(), 2));
                        synchronized (this.O00000o) {
                            if (this.O00000oO.get(device.did) == null) {
                                z = true;
                                this.O00000oO.put(device.did, device);
                            }
                        }
                    } else {
                        gsy.O000000o(4, "MiuiService", "GetNearListTask didRangeBeaconsInScan: collection item: ble" + Base64.encodeToString(String.valueOf(btMac).getBytes(), 2) + " ap" + Base64.encodeToString(String.valueOf(wifiMac).getBytes(), 2) + " not match device");
                    }
                }
                if (z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Math.abs(currentTimeMillis - this.O00000oo) > 450) {
                        ServiceApplication.getGlobalWorkerHandler().removeCallbacks(this.O0000O0o);
                        this.O00000oo = currentTimeMillis;
                        O000000o(new ArrayList(this.O00000oO.values()));
                        return;
                    }
                    ServiceApplication.getGlobalWorkerHandler().removeCallbacks(this.O0000O0o);
                    ServiceApplication.getGlobalWorkerHandler().postDelayed(this.O0000O0o, 350);
                }
            } catch (Throwable th) {
                gsy.O000000o(6, "MiuiService", Log.getStackTraceString(th));
            }
        }
    }

    public final void O000000o(ArrayList<Device> arrayList) throws RemoteException {
        Bundle bundle = new Bundle();
        ArrayList<DeviceInfo> O000000o2 = O000000o(arrayList, this.O0000Oo);
        bundle.putString("current_uid", CoreApi.O000000o().O0000o0());
        bundle.setClassLoader(DeviceInfo.class.getClassLoader());
        gsy.O000000o(4, "MiuiService", "GetNearListTask onSuccess devicesize:" + O000000o2.size() + " apsize:" + this.O00000o0.size() + " btsize:" + this.O00000Oo.size());
        bundle.putParcelableArrayList("device_infos", O000000o2);
        this.O0000Oo0.onSuccess(bundle);
    }

    public final void O000000o(boolean z, boolean z2, int i, ICallback iCallback, boolean z3) {
        gsy.O000000o(3, "MiuiService", "scanNearList, onlyOnline = " + z + ", forceRefresh = " + z2 + ", timeout = " + i);
        try {
            this.O0000Ooo = z3;
            this.O0000Oo0 = iCallback;
            this.O0000Oo = z;
            Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
            this.O0000OoO = new HashMap();
            for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
                Device device = (Device) value.getValue();
                this.O0000OoO.put(device.mac, device);
            }
            this.O00000oO = new HashMap();
            this.O00000oo = System.currentTimeMillis();
            if (z2) {
                this.O00000Oo.clear();
                this.O00000o0.clear();
            } else {
                for (Map.Entry<String, MiBeacon> key : this.O00000Oo.entrySet()) {
                    Device device2 = this.O0000OoO.get(key.getKey());
                    if (device2 != null) {
                        this.O00000oO.put(device2.did, device2);
                    }
                }
                for (Map.Entry<String, MiBeacon> key2 : this.O00000o0.entrySet()) {
                    Device device3 = this.O0000OoO.get(key2.getKey());
                    if (device3 != null) {
                        this.O00000oO.put(device3.did, device3);
                    }
                }
                if (this.O00000oO.size() > 0) {
                    O000000o(new ArrayList(this.O00000oO.values()));
                }
            }
            this.f592O000000o.startRangingBeaconsForeground(this);
            ServiceApplication.getGlobalWorkerHandler().postDelayed(this.O0000OOo, (long) i);
        } catch (Throwable th) {
            gsy.O000000o(6, "MiuiService", Log.getStackTraceString(th));
        }
    }

    private ArrayList<DeviceInfo> O000000o(List<Device> list, boolean z) {
        ArrayList<DeviceInfo> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (Device next : list) {
            if (next == null) {
                gsy.O000000o(6, "MiuiService", "GetNearListTask createDeviceInfo data is null");
            } else if (!z || DeviceCategory.fromPid(next.pid) == DeviceCategory.Bluetooth || next.isOnline) {
                arrayList.add(hsf.O000000o(next, next.name, this.O0000Ooo));
            } else {
                gsy.O000000o(6, "MiuiService", "GetNearListTask createDeviceInfo device offline model:" + next.model + " dd" + Base64.encodeToString(String.valueOf(next.did).getBytes(), 2));
            }
        }
        return arrayList;
    }
}
