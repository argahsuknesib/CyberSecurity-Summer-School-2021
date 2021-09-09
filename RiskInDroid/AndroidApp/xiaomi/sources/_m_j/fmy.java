package _m_j;

import _m_j.fnu;
import _m_j.hlz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miui.FindDeviceDialogActivity;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class fmy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Long f16674O000000o = 1000L;
    public static BleDevice O00000o = null;
    private static volatile fmy O0000o00 = null;
    public volatile boolean O00000Oo = false;
    public volatile Disposable O00000o0 = null;
    public long O00000oO = 0;
    public Set<String> O00000oo;
    public Set<String> O0000O0o;
    public Map<String, Long> O0000OOo = new HashMap();
    public boolean O0000Oo;
    public Handler O0000Oo0 = new Handler();
    public BroadcastReceiver O0000OoO = new BroadcastReceiver() {
        /* class _m_j.fmy.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            dct.O00000Oo("onReceive BLE_REFRESH_CHOOSE");
            fmy.this.O000000o();
        }
    };
    public Runnable O0000Ooo = new Runnable() {
        /* class _m_j.fmy.AnonymousClass2 */

        public final void run() {
            dct.O00000Oo("resume syn ble list");
            fmy.this.O000000o();
        }
    };
    private Map<String, Long> O0000o0;
    private boolean O0000o0O = true;
    private final Runnable O0000o0o = new Runnable() {
        /* class _m_j.fmy.AnonymousClass3 */

        public final void run() {
            dct.O00000Oo("mBleSearch run");
            if (fmy.this.O0000Oo) {
                fmy.this.O00000Oo();
            }
        }
    };

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d3, code lost:
        if (r6.f6871O000000o.O00000oo != false) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0048 A[SYNTHETIC] */
    public final void O000000o() {
        boolean z;
        Integer num;
        MiotBleAdvPacket O00000Oo2;
        dct.O00000Oo("synBleList");
        List<BleDeviceGroup> O000000o2 = fob.O000000o();
        StringBuilder sb = new StringBuilder("scanned ble group size =");
        sb.append(O000000o2 == null ? 0 : O000000o2.size());
        dct.O00000Oo(sb.toString());
        ArrayList arrayList = new ArrayList();
        if (O000000o2 != null && O000000o2.size() > 0) {
            for (BleDeviceGroup O0000OoO2 : O000000o2) {
                for (BleDevice next : O0000OoO2.O0000OoO()) {
                    dct.O00000oo("device scanned : " + next.name + " rssi = " + next.rssi + " model = " + next.model);
                    boolean z2 = true;
                    if (!(next == null || (O00000Oo2 = next.O00000Oo()) == null)) {
                        if (!O00000Oo2.O000000o() || TextUtils.isEmpty(O00000Oo2.O00000oo)) {
                            if (O00000Oo2.f6871O000000o != null) {
                                if (O00000Oo2.f6871O000000o.O0000Oo0 <= 4) {
                                    dct.O00000o("ble v4 or lower, not fit request");
                                } else if (O00000Oo2.f6871O000000o.O0000Oo0 == 5) {
                                    if (O00000Oo2.f6871O000000o.O00000oO) {
                                        if (O00000Oo2.O0000OoO.O00000Oo != 0) {
                                            dct.O00000o("mesh bind, not fit request");
                                        }
                                    } else if (feb.O000000o(next.model) == 2) {
                                        dct.O00000o("ble v5 weak bind, not fit request");
                                    }
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                            fmk O000000o3 = fmk.O000000o();
                            String str = next.model;
                            int i = next.rssi;
                            if (TextUtils.isEmpty(str) || !O000000o3.O00000Oo.containsKey(str) || (num = O000000o3.O00000Oo.get(str)) == null || i <= num.intValue()) {
                                z2 = false;
                            }
                            if (z2) {
                                BleDeviceGroup bleDeviceGroup = new BleDeviceGroup();
                                bleDeviceGroup.O000000o(next);
                                bleDeviceGroup.rssi = next.rssi;
                                arrayList.add(bleDeviceGroup);
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
        }
        O000000o(arrayList);
    }

    public final void O00000Oo() {
        if (fob.O00000Oo()) {
            dct.O00000Oo("startBleScan");
            fob.O000000o(new SearchRequest.O000000o().O00000Oo(4000, 1).O000000o(), (fon) null);
        }
        this.O0000Oo0.removeCallbacks(this.O0000o0o);
        this.O0000Oo0.postDelayed(this.O0000o0o, 6000);
    }

    public static fmy O00000o0() {
        if (O0000o00 == null) {
            synchronized (fmy.class) {
                if (O0000o00 == null) {
                    O0000o00 = new fmy();
                }
            }
        }
        return O0000o00;
    }

    private fmy() {
        SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("mainconnect_sp", 0);
        Set<String> stringSet = sharedPreferences.getStringSet("ignore_mac_set", new HashSet());
        Set<String> stringSet2 = sharedPreferences.getStringSet("ignore_combo_key_set", new HashSet());
        this.O00000oo = new HashSet(stringSet);
        this.O0000O0o = new HashSet(stringSet2);
        this.O0000o0 = new HashMap();
    }

    public final void O000000o(String str) {
        dct.O00000Oo("recordComboDeviceDismissTime");
        if (!TextUtils.isEmpty(str)) {
            this.O0000o0.put(str.toUpperCase(Locale.ENGLISH), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final boolean O00000Oo(String str) {
        dct.O00000Oo("isComboTimeEnough");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.O0000o0.containsKey(str.toUpperCase(Locale.ENGLISH)) && this.O0000o0.get(str) != null && currentTimeMillis - this.O0000o0.get(str.toUpperCase(Locale.ENGLISH)).longValue() < 300000) {
            return false;
        }
        for (Long longValue : this.O0000o0.values()) {
            if (currentTimeMillis - longValue.longValue() < f16674O000000o.longValue()) {
                return false;
            }
        }
        return true;
    }

    public final void O000000o(BleDevice bleDevice) {
        dct.O00000Oo("recordBleDeviceDismissTime");
        if (bleDevice == null) {
            dct.O00000o0("ble is null");
            return;
        }
        String str = bleDevice.mac;
        if (TextUtils.isEmpty(str)) {
            dct.O00000o0("mac is empty");
            return;
        }
        this.O0000OOo.put(str, Long.valueOf(System.currentTimeMillis()));
        if (DeviceFactory.O00000Oo(bleDevice)) {
            O000000o(bleDevice.O00000Oo().O00000oo);
        }
        dcp O000000o2 = dcp.O000000o();
        dct.O00000Oo("setMiuiDissPop");
        if (O000000o2.O00000oO != null) {
            O000000o2.O00000oO.O0000O0o(str);
        } else {
            dct.O00000o0("miuiService is null!");
        }
    }

    private void O000000o(List<BleDevice> list) {
        if (this.O0000Oo && list.size() != 0) {
            LogType logType = LogType.KUAILIAN;
            gsy.O00000o0(logType, "mainconnect", "filterAndNotifyDevice devices size = " + list.size());
            for (final BleDevice next : list) {
                LogType logType2 = LogType.KUAILIAN;
                gsy.O00000o0(logType2, "mainconnect", "Device rssi > -50 model = " + next.model + " rssi = " + next.rssi);
                if (O00000Oo(next)) {
                    if (dcp.O000000o().O00000o0()) {
                        gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "miui is connecting device, return");
                        return;
                    } else if (O00000o != null) {
                        gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "has device showing dialog, return");
                        return;
                    } else if (FindDeviceDialogActivity.sResumed) {
                        gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "FindDeviceDialogActivity sResumed");
                        return;
                    } else if (fnu.O000000o.f16724O000000o.O000000o()) {
                        gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "XiaoMiRouterConnectionManager dialog isShowing");
                        return;
                    } else {
                        LogType logType3 = LogType.KUAILIAN;
                        gsy.O00000o0(logType3, "mainconnect", "showDeviceDialog bleDevice model = " + next.model);
                        O00000o = next;
                        hlz.O000000o(next.model, new fsm<hlz.O000000o, fso>() {
                            /* class _m_j.fmy.AnonymousClass5 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                hlz.O000000o o000000o = (hlz.O000000o) obj;
                                if (fmy.this.O00000oO != 0) {
                                    gsy.O000000o(6, "mainconnect", "pop time  = " + (System.currentTimeMillis() - fmy.this.O00000oO));
                                    LogType logType = LogType.KUAILIAN;
                                    gsy.O00000o0(logType, "mainconnect", "pop time  = " + (System.currentTimeMillis() - fmy.this.O00000oO));
                                }
                                LogType logType2 = LogType.KUAILIAN;
                                gsy.O00000o0(logType2, "mainconnect", "requestDeviceImage onSuccess, url =" + o000000o.f19057O000000o);
                                hxc.O000000o().O000000o(next.model, 7);
                                Intent intent = new Intent(CommonApplication.getAppContext(), FindDeviceDialogActivity.class);
                                intent.putExtra("device_name", BleDevice.O00000Oo(next.model));
                                intent.putExtra("model", next.model);
                                intent.putExtra("image_url", o000000o.f19057O000000o);
                                intent.putExtra("video_url", o000000o.O00000Oo);
                                intent.addFlags(268435456);
                                intent.addFlags(536870912);
                                hxr hxr = hxi.O00000oO;
                                String str = next.model;
                                hxr.f958O000000o.O000000o("find_device_pop", "model", str);
                                CommonApplication.getAppContext().startActivity(intent);
                            }

                            public final void onFailure(fso fso) {
                                LogType logType = LogType.KUAILIAN;
                                gsy.O00000o0(logType, "mainconnect", "requestDeviceImage failed, error :" + fso.O00000Oo);
                                fmy.O00000o = null;
                            }
                        });
                        return;
                    }
                }
            }
        }
    }

    public final void O00000o0(String str) {
        dct.O00000Oo("addIgnoreComboKeyList");
        if (!TextUtils.isEmpty(str)) {
            this.O0000O0o.add(str.toUpperCase(Locale.ENGLISH));
            CommonApplication.getAppContext().getSharedPreferences("mainconnect_sp", 0).edit().putStringSet("ignore_combo_key_set", this.O0000O0o).apply();
            dcp O000000o2 = dcp.O000000o();
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            dct.O00000Oo("setComboKeyIgnoreInMiui");
            if (O000000o2.O00000oO != null) {
                O000000o2.O00000oO.O0000Oo0(upperCase);
            } else {
                dct.O00000o0("miuiService is null!");
            }
        }
    }

    public final boolean O00000o(String str) {
        boolean z;
        dct.O00000Oo("isInIgnoredComboKeyList");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.O0000O0o.contains(str.toUpperCase(Locale.ENGLISH))) {
            return true;
        }
        dcp O000000o2 = dcp.O000000o();
        dct.O00000Oo("isComboKeyIgnore");
        if (O000000o2.O00000oO != null) {
            z = O000000o2.O00000oO.O00000o(str);
        } else {
            dct.O00000o0("miuiService is null!");
            z = false;
        }
        dct.O00000Oo("isIgnore = ".concat(String.valueOf(z)));
        if (z) {
            return true;
        }
        return false;
    }

    public static boolean O000000o(MiotBleAdvPacket miotBleAdvPacket) {
        boolean z;
        int i;
        if (miotBleAdvPacket == null || miotBleAdvPacket.f6871O000000o == null) {
            z = true;
            i = 0;
        } else {
            i = miotBleAdvPacket.f6871O000000o.O0000OOo;
            if (!fea.O000000o(miotBleAdvPacket.f6871O000000o.O0000Oo0)) {
                dct.O00000oo(" support version = " + miotBleAdvPacket.f6871O000000o.O0000Oo0);
                z = false;
            } else {
                z = true;
            }
        }
        if ((i == 0 || i == 2) && z) {
            dct.O00000oo(" support authMode = ".concat(String.valueOf(i)));
            return true;
        }
        dct.O00000oo("don't support authMode = ".concat(String.valueOf(i)));
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb  */
    private boolean O00000Oo(BleDevice bleDevice) {
        boolean z;
        boolean z2;
        LogType logType = LogType.KUAILIAN;
        gsy.O00000o0(logType, "mainconnect", "filterIgnoreAndTimeLimitDevice: " + bleDevice.model);
        if (TextUtils.equals(bleDevice.model, "yeelink.uwb.tag1")) {
            return false;
        }
        String str = bleDevice.mac;
        if (DeviceFactory.O00000Oo(bleDevice)) {
            if (O00000o(bleDevice.O00000Oo().O00000oo)) {
                gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "this combo device is ignored, don't show");
                return false;
            } else if (!O00000Oo(bleDevice.O00000Oo().O00000oo)) {
                gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "this combo device is shown in 5min");
                return false;
            }
        }
        if (!TextUtils.isEmpty(str) && !this.O00000oo.contains(bleDevice.mac)) {
            dcp O000000o2 = dcp.O000000o();
            String str2 = bleDevice.mac;
            dct.O00000Oo("getMiuiIngorDevice");
            if (O000000o2.O00000oO != null) {
                z = O000000o2.O00000oO.O00000oo(str2);
            } else {
                dct.O00000o0("miuiService is null!");
                z = false;
            }
            dct.O00000Oo("getMiuiIngorDevice result = ".concat(String.valueOf(z)));
            if (!z) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.O0000OOo.containsKey(str) || currentTimeMillis - this.O0000OOo.get(str).longValue() >= 300000) {
                    dcp O000000o3 = dcp.O000000o();
                    dct.O00000Oo("getMiuiDissPop");
                    long j = -1;
                    if (O000000o3.O00000oO != null) {
                        j = O000000o3.O00000oO.O0000OOo(str);
                    } else {
                        dct.O00000o0("miuiService is null!");
                    }
                    dct.O00000Oo("miui dismiss time = ".concat(String.valueOf(j)));
                    if (currentTimeMillis - j >= 300000) {
                        z2 = false;
                        if (!z2) {
                            gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "time 5min limit, don't show");
                            return false;
                        }
                        for (Long longValue : this.O0000OOo.values()) {
                            if (currentTimeMillis - longValue.longValue() < f16674O000000o.longValue()) {
                                gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "time 1s limit, don't show");
                                return false;
                            }
                        }
                        return true;
                    }
                }
                z2 = true;
                if (!z2) {
                }
            }
        }
        gsy.O00000o0(LogType.KUAILIAN, "mainconnect", "mac is null or in ignore set, don't show");
        return false;
    }
}
