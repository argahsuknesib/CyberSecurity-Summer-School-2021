package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class fof extends glc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HashMap<String, BleDevice> f16745O000000o = new HashMap<>();
    public static fon O00000Oo;
    public static volatile Runnable O00000o;
    public static volatile byte O00000o0 = 0;
    public static Runnable O00000oO;
    public static final Handler O00000oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.fof.AnonymousClass4 */

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (fof.O00000oo.hasMessages(2)) {
                    fof.O00000oo.removeMessages(2);
                    fof.O000000o(true);
                }
                fof.O00000oo.sendEmptyMessageDelayed(1, 5000);
            }
        }
    };
    private static HashMap<String, BleDevice> O0000Oo = new HashMap<>();
    private static HashMap<String, List<BleDevice>> O0000Oo0 = new HashMap<>();
    private static final List<BleDeviceGroup> O0000OoO = Collections.synchronizedList(new ArrayList());
    private static final List<BleDevice> O0000Ooo = Collections.synchronizedList(new ArrayList());
    private static Map<String, O000000o> O0000o0 = new HashMap();
    private static final List<Device> O0000o00 = Collections.synchronizedList(new ArrayList());
    private static boolean O0000o0O = true;
    private static final fon O0000o0o = new fon() {
        /* class _m_j.fof.AnonymousClass2 */

        public final /* synthetic */ void O000000o(Object obj) {
            BleDevice bleDevice = (BleDevice) obj;
            BleDevice bleDevice2 = fof.f16745O000000o.get(bleDevice.mac);
            if (bleDevice2 == null || bleDevice2.O00000Oo() == null || bleDevice.O00000Oo() != null) {
                if (foc.O00000Oo(bleDevice.mac) == 0) {
                    fof.O000000o(bleDevice);
                } else if (foc.O00000Oo(bleDevice.mac) == 1 && !DeviceFactory.O000000o(bleDevice)) {
                    fof.O000000o(bleDevice);
                }
                if (fof.O00000Oo != null) {
                    fof.O00000Oo.O000000o(bleDevice);
                }
            } else if (fof.O00000Oo != null) {
                fof.O00000Oo.O000000o(bleDevice);
            }
        }

        public final void O000000o() {
            gnk.O00000o0(String.format("BLEDeviceManager onSearchStarted", new Object[0]));
            fof.O0000O0o();
        }

        public final void O00000Oo() {
            gnk.O00000o0(String.format("BLEDeviceManager onSearchStopped", new Object[0]));
            fof.O00000oO();
            fof.O0000OOo();
        }

        public final void O00000o0() {
            gnk.O00000o0(String.format("BLEDeviceManager onSearchCanceled", new Object[0]));
            fof.O0000Oo0();
        }
    };

    public static List<BleDevice> O000000o() {
        fpo.O000000o();
        ArrayList<BleDevice> arrayList = new ArrayList<>();
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
            Device device = (Device) value.getValue();
            if (device instanceof BleDevice) {
                arrayList.add((BleDevice) device);
            }
        }
        gnk.O00000oO(String.format("getSmartHomeDevices ...", new Object[0]));
        for (BleDevice bleDevice : arrayList) {
            bleDevice.isOnline = true;
            bleDevice.canAuth = bleDevice.O00000o() && bleDevice.isOnline;
            if (TextUtils.isEmpty(bleDevice.did)) {
                bleDevice.did = bleDevice.mac;
            }
            gnk.O00000oO(String.format(">>> %s", bleDevice));
        }
        synchronized (O0000Ooo) {
            O0000Ooo.clear();
            O0000Ooo.addAll(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, Device> value2 : O0000O0o.entrySet()) {
            Device device2 = (Device) value2.getValue();
            if (device2.pid == Device.PID_BLE_MESH) {
                arrayList2.add(device2);
            }
        }
        synchronized (O0000o00) {
            O0000o00.clear();
            O0000o00.addAll(arrayList2);
        }
        return new ArrayList(O0000Ooo);
    }

    public static BleDeviceGroup O000000o(String str) {
        return O000000o(O0000OoO, str);
    }

    public static BleDeviceGroup O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (O0000OoO) {
            for (BleDeviceGroup next : O0000OoO) {
                if (str.equalsIgnoreCase(next.mac)) {
                    return next;
                }
            }
            return null;
        }
    }

    private static BleDeviceGroup O000000o(List<BleDeviceGroup> list, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (BleDeviceGroup next : list) {
            if (next.O00000oO(str)) {
                return next;
            }
        }
        return null;
    }

    public static List<BleDeviceGroup> O00000Oo() {
        ArrayList<BleDeviceGroup> arrayList = new ArrayList<>();
        for (Map.Entry<String, List<BleDevice>> key : O0000Oo0.entrySet()) {
            String str = (String) key.getKey();
            if (!str.equalsIgnoreCase("xiaomi.ble.v1") || !gpn.O000000o(foc.O000000o())) {
                List<BleDevice> list = O0000Oo0.get(str);
                if (!gpn.O000000o(list)) {
                    if (DeviceFactory.O00000Oo((BleDevice) list.get(0))) {
                        for (BleDevice bleDevice : list) {
                            if (!O00000o0(bleDevice) && bleDevice.O00000Oo() != null && !TextUtils.isEmpty(bleDevice.O00000Oo().O00000oo)) {
                                BleDeviceGroup bleDeviceGroup = new BleDeviceGroup();
                                arrayList.add(bleDeviceGroup);
                                bleDeviceGroup.O000000o(bleDevice);
                            }
                        }
                    } else {
                        BleDeviceGroup O000000o2 = O000000o(arrayList, str);
                        if (O000000o2 == null) {
                            O000000o2 = new BleDeviceGroup();
                            arrayList.add(O000000o2);
                        }
                        for (BleDevice bleDevice2 : list) {
                            if (!O00000o0(bleDevice2)) {
                                if (!((bleDevice2 == null || bleDevice2.O00000Oo() == null || bleDevice2.O00000Oo().f6871O000000o == null || !bleDevice2.O00000Oo().f6871O000000o.O00000oo) ? false : true)) {
                                    O000000o2.O000000o(bleDevice2);
                                }
                            }
                        }
                    }
                }
            }
        }
        synchronized (O0000OoO) {
            O0000OoO.clear();
            for (BleDeviceGroup bleDeviceGroup2 : arrayList) {
                if (!bleDeviceGroup2.mDevices.isEmpty()) {
                    O0000OoO.add(bleDeviceGroup2);
                }
            }
        }
        return O0000OoO;
    }

    public static void O000000o(BleDevice bleDevice) {
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(bleDevice.model);
        if (O00000oO2 == null) {
            gnk.O00000oO("addRecognizedDevice pluginRecord is null: ".concat(String.valueOf(bleDevice)));
        } else if (O00000oO2.O0000o() == Device.PID_BLE_MESH && bleDevice.O00000Oo() == null) {
            O000000o o000000o = O0000o0.get(bleDevice.mac);
            if (o000000o != null) {
                o000000o.f16747O000000o--;
            }
        } else {
            O0000o0.put(bleDevice.mac, new O000000o(System.currentTimeMillis()));
            List list = O0000Oo0.get(bleDevice.model);
            if (list == null) {
                list = new ArrayList();
                O0000Oo0.put(bleDevice.model, list);
            }
            list.remove(bleDevice);
            list.add(bleDevice);
            f16745O000000o.put(bleDevice.mac, bleDevice);
            O0000Oo.put(bleDevice.did, bleDevice);
            if (!TextUtils.isEmpty(BleDevice.O00000o(bleDevice.model))) {
                fpo.O00000Oo(BleDevice.O00000o(bleDevice.model));
            } else {
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "BleManagerInternal.addRecognizedDevice getPairIconUrl is null model:" + bleDevice.model);
            }
            if (!bleDevice.O00000oO()) {
                ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent(fob.f16735O000000o));
            }
        }
    }

    public static void O000000o(String str, String str2) {
        if (O0000o0.containsKey(str2)) {
            O0000o0.remove(str2);
        }
        List list = O0000Oo0.get(str);
        int i = 0;
        if (list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                if (!TextUtils.isEmpty(str2) && str2.equals(((BleDevice) list.get(i2)).mac)) {
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        synchronized (O0000OoO) {
            while (i < O0000OoO.size()) {
                if (!TextUtils.isEmpty(str2) && str2.equals(O0000OoO.get(i).mac)) {
                    O0000OoO.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    public static void O00000o0() {
        gnk.O00000o0("BLEDeviceManager clearBleDevices");
        O00000oo();
        O0000o0.clear();
        O0000Oo0.clear();
        synchronized (O0000OoO) {
            O0000OoO.clear();
        }
        f16745O000000o.clear();
        O0000Oo.clear();
        synchronized (O0000Ooo) {
            O0000Ooo.clear();
        }
        synchronized (O0000o00) {
            O0000o00.clear();
        }
        CoreApi.O000000o().O000000o((String) null, 30, (Bundle) null, (IBleResponse) null);
    }

    public static boolean O00000o() {
        byte b = O00000o0;
        return b == 0 || b == 1;
    }

    public static void O000000o(fon fon) {
        O000000o((SearchRequest) null, fon);
    }

    public static void O000000o(final SearchRequest searchRequest, final fon fon) {
        fte.O00000Oo(String.format("BLEDeviceManager searchBleDevice", new Object[0]));
        fpo.O000000o();
        if (O00000o0 != 0) {
            fte.O00000Oo(String.format("Previous search ongoing!", new Object[0]));
            if (O00000o0 == 1) {
                O00000o = new Runnable() {
                    /* class _m_j.fof.AnonymousClass1 */

                    public final void run() {
                        fof.O000000o(searchRequest, fon);
                    }
                };
            }
        } else if (gnl.O00000Oo()) {
            O00000o0 = 3;
            O00000Oo = fon;
            if (searchRequest == null) {
                searchRequest = new SearchRequest.O000000o().O00000Oo(5000, 2).O000000o(C.MSG_CUSTOM_BASE).O000000o();
            }
            gsy.O000000o(4, "startScan", "BDM start");
            fpo.O000000o(searchRequest, O0000o0o);
        } else {
            fte.O00000Oo("Bluetooth not open?");
        }
    }

    public static void O00000oO() {
        gnk.O00000o0(String.format("BLEDeviceManager clearExpiredDevice", new Object[0]));
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, O000000o>> it = O0000o0.entrySet().iterator();
        while (it.hasNext()) {
            O000000o o000000o = (O000000o) it.next().getValue();
            if (o000000o != null) {
                o000000o.f16747O000000o--;
                if (o000000o.f16747O000000o > 0 && Math.abs(currentTimeMillis - o000000o.O00000Oo) <= 180000) {
                }
            }
            it.remove();
        }
        for (Map.Entry<String, List<BleDevice>> value : O0000Oo0.entrySet()) {
            List list = (List) value.getValue();
            if (list != null && list.size() > 0) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (O0000o0.get(((BleDevice) it2.next()).mac) == null) {
                        it2.remove();
                    }
                }
            }
        }
        Iterator<Map.Entry<String, BleDevice>> it3 = f16745O000000o.entrySet().iterator();
        while (it3.hasNext()) {
            if (O0000o0.get(((BleDevice) it3.next().getValue()).mac) == null) {
                it3.remove();
            }
        }
        Iterator<Map.Entry<String, BleDevice>> it4 = O0000Oo.entrySet().iterator();
        while (it4.hasNext()) {
            if (O0000o0.get(((BleDevice) it4.next().getValue()).mac) == null) {
                it4.remove();
            }
        }
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent(fob.f16735O000000o));
    }

    public static void O00000oo() {
        if (O00000o0 == 3 || O00000o0 == 2) {
            O00000o0 = 1;
            fte.O00000Oo(String.format("BLEDeviceManager stopSearchBleDevice", new Object[0]));
            gsy.O000000o(4, "stopScan", "BDM stop");
            fpo.O00000Oo();
            O00000o = null;
            Handler globalWorkerHandler = CommonApplication.getGlobalWorkerHandler();
            AnonymousClass3 r1 = new Runnable() {
                /* class _m_j.fof.AnonymousClass3 */

                public final void run() {
                    fof.O00000o0 = 0;
                    fof.O00000o = null;
                    fof.O00000oO = null;
                    gsy.O00000o0(LogType.BLUETOOTH, "", "error: BLEDeviceManager.stopSearchBleDevice do not callback");
                }
            };
            O00000oO = r1;
            globalWorkerHandler.postDelayed(r1, 3000);
        }
    }

    public static void O0000O0o() {
        O00000o0 = 2;
        fon fon = O00000Oo;
        if (fon != null) {
            fon.O000000o();
        }
    }

    public static void O0000OOo() {
        O00000o0 = 0;
        fon fon = O00000Oo;
        if (fon != null) {
            fon.O00000Oo();
        }
        O00000Oo = null;
        CommonApplication.getGlobalWorkerHandler().removeCallbacks(O00000oO);
        O00000oO = null;
        Runnable runnable = O00000o;
        if (runnable != null) {
            runnable.run();
            O00000o = null;
        }
    }

    public static void O0000Oo0() {
        O00000o0 = 0;
        fon fon = O00000Oo;
        if (fon != null) {
            fon.O00000o0();
        }
        O00000Oo = null;
        CommonApplication.getGlobalWorkerHandler().removeCallbacks(O00000oO);
        O00000oO = null;
        Runnable runnable = O00000o;
        if (runnable != null) {
            runnable.run();
            O00000o = null;
        }
    }

    public static void O000000o(Device device) {
        fte.O00000Oo("unbindMeshDevice " + fte.O000000o(device.mac));
        XmBluetoothManager.getInstance().disconnect(device.mac);
        foc.O0000o(device.mac);
        foc.O000000o(device.mac, "");
        foc.O00000o(device.mac, "");
        foc.O00000Oo(device.mac, "");
        foc.O0000Oo0(device.mac);
        foc.O000000o(device.mac, 0);
        O0000o00.remove(device);
        f16745O000000o.remove(device.mac);
        O0000Oo.remove(device.did);
        List list = O0000Oo0.get(device.model);
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BleDevice bleDevice = (BleDevice) it.next();
                if (TextUtils.equals(bleDevice.mac, device.mac)) {
                    list.remove(bleDevice);
                    break;
                }
            }
        }
        O000000o(true);
    }

    public static void O00000Oo(BleDevice bleDevice) {
        if (bleDevice != null) {
            fte.O00000Oo("unbindBluetoothDevice " + fte.O000000o(bleDevice.mac));
            if ("roidmi.btfm.v1".equalsIgnoreCase(bleDevice.model) || "roidmi.btfm.m1".equalsIgnoreCase(bleDevice.model)) {
                gnl.O00000oO(bleDevice.mac);
            } else if ("onemore.soundbox.sm001".equalsIgnoreCase(bleDevice.model)) {
                gnl.O00000oO(bleDevice.mac);
            } else if ("yeelink.light.ble1".equalsIgnoreCase(bleDevice.model)) {
                fpo.O000000o(bleDevice);
            } else {
                "runmi.suitcase.v1".equalsIgnoreCase(bleDevice.model);
                bleDevice.O00000oo();
            }
            XmBluetoothManager.getInstance().unBindDevice(bleDevice.mac);
            foc.O0000o(bleDevice.mac);
            foc.O000000o(bleDevice.mac, "");
            foc.O00000o(bleDevice.mac, "");
            foc.O00000Oo(bleDevice.mac, "");
            foc.O0000Oo0(bleDevice.mac);
            foc.O000000o(bleDevice.mac, 0);
            O0000Ooo.remove(bleDevice);
            f16745O000000o.remove(bleDevice.mac);
            O0000Oo.remove(bleDevice.did);
            List list = O0000Oo0.get(bleDevice.model);
            if (list != null) {
                list.remove(bleDevice);
            }
            Context context = glc.O0000O0o;
            if (context != null) {
                Intent intent = new Intent("smarthome.miconnect.ble.unbind");
                intent.setPackage(context.getPackageName());
                intent.putExtra("mac", bleDevice.mac);
                if (DeviceFactory.O00000Oo(bleDevice)) {
                    MiotBleAdvPacket O00000Oo2 = bleDevice.O00000Oo();
                    if (O00000Oo2 == null) {
                        gsy.O00000Oo(LogType.BLUETOOTH, "BleManagerInternal", "MiotBleAdvPacket is null".concat(String.valueOf(bleDevice)));
                    } else {
                        intent.putExtra("combo_key", O00000Oo2.O00000oo);
                    }
                }
                context.sendBroadcast(intent);
            }
            O000000o(true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007b A[EDGE_INSN: B:40:0x007b->B:28:0x007b ?: BREAK  , SYNTHETIC] */
    public static BleDevice O00000o0(String str) {
        BleDevice next;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BleDevice bleDevice = O0000Oo.get(str);
        if (bleDevice == null) {
            Iterator it = new HashMap(O0000Oo).entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    BleDevice bleDevice2 = (BleDevice) ((Map.Entry) it.next()).getValue();
                    if (bleDevice2 != null && str.equals(bleDevice2.did)) {
                        bleDevice = bleDevice2;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (bleDevice != null) {
                O0000Oo.remove(bleDevice.mac);
                O0000Oo.put(bleDevice.did, bleDevice);
            } else {
                bleDevice = O00000o(str);
            }
        }
        if (bleDevice == null) {
            synchronized (O0000Ooo) {
                Iterator<BleDevice> it2 = O0000Ooo.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = it2.next();
                        if (str.equals(next.did) || str.equals(next.mac)) {
                            bleDevice = next;
                        }
                        if (!it2.hasNext()) {
                            break;
                        }
                    }
                }
                bleDevice = next;
            }
        }
        return bleDevice;
    }

    public static BleDevice O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BleDevice bleDevice = f16745O000000o.get(str);
        if (bleDevice != null) {
            return bleDevice;
        }
        synchronized (O0000Ooo) {
            Iterator<BleDevice> it = O0000Ooo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BleDevice next = it.next();
                if (str.equals(next.mac)) {
                    bleDevice = next;
                    break;
                }
            }
        }
        return bleDevice;
    }

    public static void O000000o(boolean z) {
        if (!O0000o0O) {
            return;
        }
        if (z) {
            fno.O000000o().O0000OOo();
            return;
        }
        if (!O00000oo.hasMessages(1)) {
            O00000oo.sendEmptyMessage(1);
        }
        O00000oo.sendEmptyMessageDelayed(2, 10000);
    }

    public static void O000000o(String str, boolean z) {
        BleDevice O00000o2 = O00000o(str);
        if (O00000o2 != null) {
            O00000o2.isNew = z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        r3 = _m_j.fof.O0000o00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (_m_j.gpn.O000000o(_m_j.fof.O0000o00) != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
        r1 = _m_j.fof.O0000o00.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006e, code lost:
        if (r1.hasNext() == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007e, code lost:
        if (r1.next().mac.equalsIgnoreCase(r7.mac) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0081, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0083, code lost:
        r1 = _m_j.eyr.O00000Oo();
        r3 = r7.model;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008f, code lost:
        if ("xiaomi.wifispeaker.x08a".equalsIgnoreCase(r3) != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
        if ("xiaomi.wifispeaker.x08c".equalsIgnoreCase(r3) != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009f, code lost:
        if ("xiaomi.wifispeaker.l09a".equalsIgnoreCase(r3) == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a2, code lost:
        r1 = _m_j.eyr.O000000o(r3, true, 100, r1.O0000Oo);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ab, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ac, code lost:
        if (r7 == null) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b2, code lost:
        if (r7.O00000Oo() != null) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b9, code lost:
        if (com.xiaomi.smarthome.device.DeviceFactory.O00000Oo(r7) == false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bb, code lost:
        r3 = _m_j.fno.O000000o().O0000O0o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c7, code lost:
        if (r3.size() == 0) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c9, code lost:
        r3 = r3.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d5, code lost:
        if (r3.hasNext() == false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d7, code lost:
        r4 = (com.xiaomi.smarthome.device.Device) r3.next().getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00eb, code lost:
        if (r7.model.equals(r4.model) == false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ed, code lost:
        r5 = r7.O00000Oo().O00000oo;
        r4 = com.xiaomi.smarthome.device.DeviceFactory.O0000Oo0(r4.mac);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fd, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0103, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0109, code lost:
        if (r5.equalsIgnoreCase(r4) == false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010b, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x010d, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010e, code lost:
        if (r3 == false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0110, code lost:
        if (r1 != false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0112, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0113, code lost:
        r1 = _m_j.fof.f16745O000000o.get(r7.mac);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x011d, code lost:
        if (r1 == null) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0123, code lost:
        if (r1.O00000Oo() == null) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012b, code lost:
        if (r1.O00000Oo().O0000OoO == null) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0136, code lost:
        if (r1.O00000Oo().O0000OoO.O00000Oo != 3) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0138, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x013a, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013b, code lost:
        if (r1 == false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x013e, code lost:
        r1 = com.xiaomi.smarthome.frame.core.CoreApi.O000000o().O00000oO(r7.model);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0148, code lost:
        if (r1 == null) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x014e, code lost:
        if (r1.O0000ooo != 18) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0150, code lost:
        r7 = r7.mac;
        r1 = _m_j.fno.O000000o().O0000O0o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x015e, code lost:
        if (r1.size() == 0) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0160, code lost:
        r1 = r1.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x016c, code lost:
        if (r1.hasNext() == false) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0180, code lost:
        if (android.text.TextUtils.equals(((com.xiaomi.smarthome.device.Device) r1.next().getValue()).mac, r7) == false) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0182, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0184, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0185, code lost:
        if (r7 == false) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0187, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0188, code lost:
        return false;
     */
    public static boolean O00000o0(BleDevice bleDevice) {
        if (bleDevice == null) {
            return false;
        }
        BleDevice bleDevice2 = f16745O000000o.get(bleDevice.mac);
        if ((bleDevice2 == null || bleDevice2.O00000Oo() == null || bleDevice2.O00000Oo().O0000OoO == null || bleDevice2.O00000Oo().O0000OoO.O00000Oo != 0) ? false : true) {
            return false;
        }
        synchronized (O0000Ooo) {
            if (!gpn.O000000o(O0000Ooo)) {
                for (BleDevice bleDevice3 : O0000Ooo) {
                    if (bleDevice3.mac.equalsIgnoreCase(bleDevice.mac)) {
                        return true;
                    }
                }
            }
        }
    }

    public static void O00000Oo(Device device) {
        if (device != null) {
            gnk.O00000o("removeCacheMeshDevice: ".concat(String.valueOf(device)));
            O0000o0.remove(device.mac);
            f16745O000000o.remove(device.mac);
            O0000Oo.remove(device.mac);
            O0000Oo.remove(device.did);
            List<BleDevice> list = O0000Oo0.get(device.model);
            if (list != null && list.size() > 0) {
                for (BleDevice bleDevice : list) {
                    if (TextUtils.equals(bleDevice.mac, device.mac)) {
                        list.remove(bleDevice);
                        return;
                    }
                }
            }
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f16747O000000o = 4;
        public long O00000Oo;

        public O000000o(long j) {
            this.O00000Oo = j;
        }
    }
}
