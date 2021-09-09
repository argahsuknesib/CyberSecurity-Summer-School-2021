package _m_j;

import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.push.PushType;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RouterService
public class gee implements ezn {
    private static final gee INSTANCE = new gee();

    @cug
    public static gee provideInstance() {
        return INSTANCE;
    }

    public void dispatchMessage(String str, String str2, boolean z) {
        geb.O000000o(str2, z, null);
    }

    public void getPushManagerInstance() {
        gdz.O000000o();
    }

    public void registerPushService() {
        gdz.O000000o().O00000o0();
    }

    public void unregisterPushService() {
        gdz O000000o2 = gdz.O000000o();
        gsy.O00000Oo(LogType.GENERAL, "SmartHome-Push", "unregisterPushService: ");
        O000000o2.f17571O000000o = null;
        dzs.O0000O0o(O000000o2.O0000O0o);
        synchronized (O000000o2.O0000OOo) {
            O000000o2.O0000Oo0 = false;
        }
    }

    public void registerPushListener(PushType pushType, gdy gdy) {
        gdz.O000000o().O000000o(pushType, gdy);
    }

    public void unregisterPushListener(PushType pushType, gdy gdy) {
        gdz O000000o2 = gdz.O000000o();
        O000000o2.O00000oo.remove(pushType.getValue());
    }

    public void registerPushId() {
        gdz.O000000o().O00000o();
    }

    public String getPushId() {
        return gdz.O000000o().f17571O000000o;
    }

    public void clearRegedPushIDAndDeviceID() {
        gpv.O00000Oo(gdz.O000000o().O0000O0o, "sh_pref_key_reged_pushid_deviceid");
    }

    public fsn unregisterPushId(fsm<Void, fso> fsm) {
        gdz O000000o2 = gdz.O000000o();
        gsy.O00000Oo(LogType.GENERAL, "SmartHome-Push", "unregisterPushId: ");
        if (CoreApi.O000000o().O0000Ooo()) {
            boolean O0000O0o = ftn.O0000O0o(O000000o2.O0000O0o);
            grr.O000000o();
            String O000000o3 = grr.O000000o(O000000o2.O0000O0o, O0000O0o);
            ged.O000000o();
            return ged.O000000o(O000000o2.O0000O0o, O000000o2.f17571O000000o, O000000o3, fsm);
        }
        if (fsm != null) {
            fsm.sendFailureMessage(new fso(-9999, ""));
        }
        return new fsn(null);
    }

    public void registerDevicePushListener(Device device, ezm ezm) {
        gek O000000o2 = gek.O000000o();
        String str = device.did + "_" + device.model;
        ArrayList arrayList = O000000o2.f17597O000000o.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            O000000o2.f17597O000000o.put(str, arrayList);
        }
        synchronized (arrayList) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ezm ezm2 = (ezm) ((WeakReference) arrayList.get(size)).get();
                if (ezm2 == null) {
                    arrayList.remove(size);
                } else if (ezm2 == ezm) {
                    return;
                }
            }
            arrayList.add(new WeakReference(ezm));
        }
    }

    public void unregisterDevicePushListener(Device device, ezm ezm) {
        gek O000000o2 = gek.O000000o();
        String str = device.did + "_" + device.model;
        ArrayList arrayList = O000000o2.f17597O000000o.get(str);
        if (arrayList != null) {
            synchronized (arrayList) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ezm ezm2 = (ezm) ((WeakReference) arrayList.get(size)).get();
                    if (ezm2 == null || ezm2 == ezm) {
                        arrayList.remove(size);
                    }
                }
            }
            if (arrayList.size() == 0) {
                O000000o2.f17597O000000o.remove(str);
            }
        }
    }

    public void unregisterDevicePushListener(Device device) {
        gek O000000o2 = gek.O000000o();
        O000000o2.f17597O000000o.remove(device.did + "_" + device.model);
    }
}
