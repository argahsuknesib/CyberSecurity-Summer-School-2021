package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class flw {
    private static flw O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ScanResult> f16591O000000o = new ArrayList();
    public List<ScanResult> O00000Oo = new ArrayList();
    public BroadcastReceiver O00000o = new BroadcastReceiver() {
        /* class _m_j.flw.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("wifi_scan_device")) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("wifi_scan_device_result");
                if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() != 0) {
                    CommonApplication.getGlobalHandler().post(new Runnable(parcelableArrayListExtra) {
                        /* class _m_j.flw.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ List f16592O000000o;

                        {
                            this.f16592O000000o = r2;
                        }

                        public final void run() {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<Device> arrayList3 = new ArrayList<>();
                            Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
                            flw.this.O00000o0 = null;
                            for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
                                Device device = (Device) value.getValue();
                                if (device.pid == 7) {
                                    arrayList3.add(device);
                                }
                            }
                            Iterator it = this.f16592O000000o.iterator();
                            while (true) {
                                boolean z = false;
                                if (!it.hasNext()) {
                                    break;
                                }
                                ScanResult scanResult = (ScanResult) it.next();
                                for (Device device2 : arrayList3) {
                                    if (device2.mac.equalsIgnoreCase(scanResult.BSSID)) {
                                        arrayList.add(scanResult);
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    arrayList2.add(scanResult);
                                }
                            }
                            flw.this.O00000Oo.clear();
                            flw.this.O00000Oo.addAll(arrayList);
                            Iterator it2 = arrayList3.iterator();
                            boolean z2 = false;
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Device device3 = (Device) it2.next();
                                Iterator<ScanResult> it3 = flw.this.O00000Oo.iterator();
                                boolean z3 = false;
                                while (true) {
                                    if (!it3.hasNext()) {
                                        break;
                                    } else if (it3.next().BSSID.equalsIgnoreCase(device3.mac)) {
                                        if (!device3.isOnline) {
                                            z2 = true;
                                            break;
                                        }
                                        z3 = true;
                                    }
                                }
                                if (!z2) {
                                    if (!z3) {
                                        z2 = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (z2) {
                                fno.O000000o().O0000OOo();
                            }
                            flw flw = flw.this;
                            Intent intent = new Intent();
                            intent.setAction("ap_device_msg");
                            ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
                            flw.f16591O000000o.clear();
                            flw.f16591O000000o.addAll(arrayList2);
                        }
                    });
                }
            } else if (!intent.getAction().equals("wifi_scan_result_broadcast") && intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                fnv O00000oo = fnv.O00000oo();
                if (intent != null && intent.hasExtra("networkInfo")) {
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
                    WifiInfo connectionInfo = ((WifiManager) fnv.O0000O0o().getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()) || connectionInfo.getSSID().contains("<unknown ssid>")) {
                        O00000oo.f16726O000000o = null;
                    } else if (detailedState != NetworkInfo.DetailedState.CONNECTED || !networkInfo.isConnected()) {
                        O00000oo.f16726O000000o = null;
                    } else if (fnv.O000000o(connectionInfo.getSSID())) {
                        O00000oo.f16726O000000o = fnv.O00000Oo(connectionInfo.getSSID());
                    } else {
                        O00000oo.f16726O000000o = null;
                    }
                    fnv.O0000OOo();
                }
            }
        }
    };
    public ScanResult O00000o0 = null;

    public static flw O000000o() {
        if (O00000oO == null) {
            O00000oO = new flw();
        }
        return O00000oO;
    }

    private flw() {
        fnv O00000oo = fnv.O00000oo();
        String O00000o02 = gog.O00000o0(fnv.O0000O0o());
        if (fnv.O000000o(O00000o02)) {
            O00000oo.f16726O000000o = fnv.O00000Oo(O00000o02);
            fnv.O0000OOo();
        }
    }

    public final synchronized ScanResult O000000o(String str) {
        if (this.O00000o0 == null || !str.equalsIgnoreCase(this.O00000o0.BSSID)) {
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                ScanResult scanResult = this.O00000Oo.get(i);
                if (scanResult.BSSID.equalsIgnoreCase(str)) {
                    return scanResult;
                }
            }
            return null;
        }
        return this.O00000o0;
    }

    public final synchronized void O000000o(ScanResult scanResult) {
        this.O00000o0 = scanResult;
    }
}
