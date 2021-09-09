package _m_j;

import _m_j.fno;
import _m_j.ggb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.WatchBandDevice;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gge {
    private static volatile gge O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<Device> f17734O000000o = new ArrayList();
    List<Device> O00000Oo = new ArrayList();
    private Map<String, List<Device>> O00000o = new HashMap();
    private BroadcastReceiver O00000oO = new BroadcastReceiver() {
        /* class _m_j.gge.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.equals(action, "home_room_updated") || TextUtils.equals(action, "home_room_home_changed")) {
                gge.this.O00000o0();
                gge.this.O00000o();
                gge.this.O00000Oo = ggd.O000000o();
                gge.O0000O0o();
            }
        }
    };
    private fno.O000000o O00000oo = new fno.O000000o() {
        /* class _m_j.gge.AnonymousClass2 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                gge.this.O00000o0();
                gge.this.O00000o();
                gge.this.O00000Oo = ggd.O000000o();
                gge.O0000O0o();
            }
        }
    };

    private gge() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("home_room_updated");
        intentFilter.addAction("home_room_home_changed");
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O00000oO, intentFilter);
        fno.O000000o().O000000o(this.O00000oo);
    }

    public static gge O000000o() {
        if (O00000o0 == null) {
            synchronized (gge.class) {
                if (O00000o0 == null) {
                    O00000o0 = new gge();
                }
            }
        }
        return O00000o0;
    }

    public final void O00000Oo() {
        this.O00000o.clear();
        this.f17734O000000o.clear();
        this.O00000Oo.clear();
    }

    public final void O00000o0() {
        HashMap hashMap = new HashMap();
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Home home = list.get(i);
                if (home != null) {
                    hashMap.put(home.getId(), O00000o(home.getId()));
                }
            }
        }
        this.O00000o = hashMap;
    }

    public final void O00000o() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if ((device instanceof MiTVDevice) && !device.isOwner()) {
                arrayList.add(device);
            }
            if ((device instanceof RouterDevice) && !device.isOwner()) {
                arrayList.add(device);
            }
            if (device instanceof GeneralAPDevice) {
                arrayList.add(device);
            }
            if ((device instanceof BleDevice) && ((BleDevice) device).O00000oO()) {
                arrayList.add(device);
            }
            if (device instanceof WatchBandDevice) {
                arrayList.add(device);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ((Device) arrayList.get(i)).freqFlag = false;
        }
        this.f17734O000000o = arrayList;
    }

    public static boolean O000000o(Device device) {
        if (device == null) {
            return false;
        }
        if ((device instanceof MiTVDevice) && !device.isOwner()) {
            return true;
        }
        if ((!(device instanceof RouterDevice) || device.isOwner()) && !(device instanceof GeneralAPDevice)) {
            return ((device instanceof BleDevice) && ((BleDevice) device).O00000oO()) || (device instanceof WatchBandDevice);
        }
        return true;
    }

    public static boolean O00000Oo(Device device) {
        if (device != null && TextUtils.equals("camera", hfa.O00000Oo(device)) && !device.isHideMainList() && !device.model.contains("mxiang.camera.mwc10") && !device.model.contains("mxiang.camera.mwc11") && !device.model.contains("chuangmi.gateway.ipc011")) {
            return true;
        }
        return false;
    }

    public static List<Device> O00000oO() {
        ArrayList<Device> arrayList = new ArrayList<>();
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        if (O0000O0o != null && !O0000O0o.isEmpty()) {
            arrayList.addAll(O0000O0o.values());
        }
        ArrayList<Device> arrayList2 = new ArrayList<>();
        for (Device device : arrayList) {
            if (fno.O000000o().O00000o(device)) {
                arrayList2.add(device);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Device device2 : arrayList2) {
            arrayList3.add(device2.did);
        }
        gsy.O000000o(3, "MultiHomeDeviceManager", "getShareDeviceList: " + Arrays.deepToString(arrayList3.toArray()));
        String O0000OOo = ggb.O00000Oo().O0000OOo();
        if (!TextUtils.isEmpty(O0000OOo)) {
            ggb.O00000o0.O000000o(arrayList2, ggb.O00000o0.O000000o(O0000OOo, "mijia.roomid.share"));
        }
        return arrayList2;
    }

    public static List<Device> O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        ArrayList<Device> arrayList = new ArrayList<>();
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        if (O0000O0o != null && !O0000O0o.isEmpty()) {
            arrayList.addAll(O0000O0o.values());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Device device : arrayList) {
            if (fno.O000000o().O00000o(device)) {
                arrayList2.add(device);
            }
        }
        ggb.O00000o0.O000000o(arrayList2, ggb.O00000o0.O000000o(str, "mijia.roomid.share"));
        return arrayList2;
    }

    public static List<String> O00000oo() {
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        ArrayList<Device> arrayList = new ArrayList<>();
        for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
            Device device = (Device) value.getValue();
            if (device != null && fno.O000000o().O00000o(device)) {
                arrayList.add(device);
            }
        }
        String O0000OOo = ggb.O00000Oo().O0000OOo();
        if (!TextUtils.isEmpty(O0000OOo)) {
            ggb.O00000o0.O000000o(arrayList, ggb.O00000o0.O000000o(O0000OOo, "mijia.roomid.share"));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Device device2 : arrayList) {
            arrayList2.add(device2.did);
        }
        return arrayList2;
    }

    public final Device O00000Oo(String str) {
        Collection<Device> collection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String O0000OOo = ggb.O00000Oo().O0000OOo();
        if (TextUtils.isEmpty(O0000OOo)) {
            collection = fno.O000000o().O0000O0o().values();
        } else {
            collection = this.O00000o.get(O0000OOo);
        }
        if (collection != null) {
            for (Device device : collection) {
                if (TextUtils.equals(device.did, str)) {
                    return device;
                }
            }
        }
        return null;
    }

    public static void O0000O0o() {
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("action_multi_home_device_changed"));
    }

    public final List<Device> O00000o0(String str) {
        if (TextUtils.isEmpty(str) || this.O00000o.get(str) == null) {
            return new ArrayList();
        }
        return this.O00000o.get(str);
    }

    private static List<Device> O00000o(String str) {
        Home O00000o2;
        List<String> dids;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || (O00000o2 = ggb.O00000Oo().O00000o(str)) == null) {
            return arrayList;
        }
        try {
            List<Room> roomList = O00000o2.getRoomList();
            for (int i = 0; i < roomList.size(); i++) {
                Room room = roomList.get(i);
                if (!(room == null || (dids = room.getDids()) == null || dids.isEmpty())) {
                    int i2 = 0;
                    while (i2 < dids.size()) {
                        try {
                            Device O000000o2 = fno.O000000o().O000000o(dids.get(i2));
                            if (O000000o2 != null) {
                                arrayList.add(O000000o2);
                            }
                            i2++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            List<String> dids2 = O00000o2.getDids();
            if (dids2 != null && !dids2.isEmpty()) {
                for (int i3 = 0; i3 < dids2.size(); i3++) {
                    Device O000000o3 = fno.O000000o().O000000o(dids2.get(i3));
                    if (O000000o3 != null) {
                        arrayList.add(O000000o3);
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return arrayList;
    }
}
