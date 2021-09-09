package _m_j;

import _m_j.ddt;
import android.app.Dialog;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.xiaomi.miconnect.MiConnectConfigActivity;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.RandomUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class hzq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Set<String> f1019O000000o = new HashSet();

    public static boolean O000000o(String str) {
        return TextUtils.equals(str, "yeelink.uwb.tag1");
    }

    public static Device O000000o(UwbScanDevice uwbScanDevice) {
        for (Map.Entry next : fno.O000000o().O00000oO().entrySet()) {
            if (UwbDeviceUtil.isUwbHashEnd(uwbScanDevice.getDidInfo().getDid(), ((Device) next.getValue()).did)) {
                return (Device) next.getValue();
            }
        }
        UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "matchDevice: " + fno.O000000o().O00000oO().keySet() + ", UwbScanDevice:" + uwbScanDevice);
        return null;
    }

    public static List<Device> O000000o() {
        List<Device> O00000oo = fno.O000000o().O00000oo();
        ArrayList arrayList = new ArrayList(O00000oo.size());
        for (int i = 0; i < O00000oo.size(); i++) {
            Device device = O00000oo.get(i);
            if (TextUtils.equals(device.model, "yeelink.uwb.tag1")) {
                arrayList.add(device);
            }
        }
        if (arrayList.isEmpty()) {
            Map<String, Device> O00000oO = fno.O000000o().O00000oO();
            UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "getTagDevices all devices count:" + O00000oO.size() + ", extra size:" + O00000oo.size());
        }
        return arrayList;
    }

    public static List<Device> O00000Oo(String str) {
        List<Device> O000000o2 = O000000o();
        ArrayList arrayList = new ArrayList();
        for (Device next : O000000o2) {
            Home O0000o0 = ggb.O00000Oo().O0000o0(next.did);
            if (O0000o0 != null && TextUtils.equals(str, O0000o0.getId())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static List<Device> O00000o() {
        ArrayList arrayList = new ArrayList();
        Collection<Device> values = fno.O000000o().O00000oO().values();
        ArrayList arrayList2 = new ArrayList(values.size());
        UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "getAllBindableDevices allDevices:" + values.size());
        arrayList2.addAll(values);
        for (int i = 0; i < arrayList2.size(); i++) {
            arrayList.add((Device) arrayList2.get(i));
        }
        return arrayList;
    }

    public static boolean O00000Oo(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.w("Mijia-UWB-UwbTagUtils", "UwbLogUtilPlus isMember device: ".concat(String.valueOf(uwbScanDevice)));
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        String accountInfo = uwbScanDevice.getAccountInfo();
        if (UwbDeviceUtil.isMitvDeviceTagType(uwbScanDevice)) {
            accountInfo = uwbScanDevice.getTagState().getTvAccountInfo();
        }
        if (accountInfo.equalsIgnoreCase(UwbDeviceUtil.getUwbHashFirst3B(CoreApi.O000000o().O0000o0()))) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            String uwbHashFirst3B = UwbDeviceUtil.getUwbHashFirst3B(String.valueOf(list.get(i).getOwnerUid()));
            UwbLogUtil.w("Mijia-UWB-UwbTagUtils", "UwbLogUtilPlus getUwbHashFirst3B: ".concat(String.valueOf(uwbHashFirst3B)));
            if (accountInfo.equalsIgnoreCase(uwbHashFirst3B)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000o0(UwbScanDevice uwbScanDevice) {
        String str;
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            return false;
        }
        if (UwbDeviceUtil.isMitvDeviceTagType(uwbScanDevice)) {
            str = uwbScanDevice.getTagState().getTvAccountInfo();
        } else {
            str = uwbScanDevice.getAccountInfo();
        }
        if (!TextUtils.isEmpty(str) && TextUtils.equals(UwbDeviceUtil.getUwbHashFirst3B(CoreApi.O000000o().O0000o0()), str)) {
            return true;
        }
        return false;
    }

    public static String O00000o(UwbScanDevice uwbScanDevice) {
        Device O0000OOo = O0000OOo(uwbScanDevice);
        if (O0000OOo != null) {
            return O0000OOo.getDid();
        }
        return null;
    }

    private static void O000000o(Home home, List<String> list) {
        if (home.getDids() != null) {
            list.addAll(home.getDids());
        }
        List<Room> roomList = home.getRoomList();
        if (roomList != null) {
            for (int i = 0; i < roomList.size(); i++) {
                Room room = roomList.get(i);
                if (!(room == null || room.getDids() == null)) {
                    list.addAll(room.getDids());
                }
            }
        }
    }

    public static String O00000oO(UwbScanDevice uwbScanDevice) {
        if (UwbDeviceUtil.isBuiltinDeviceType(uwbScanDevice.getDeviceType())) {
            return null;
        }
        if (uwbScanDevice.getDidInfo() == null) {
            return "";
        }
        String did = uwbScanDevice.getDidInfo().getDid();
        if (TextUtils.isEmpty(did)) {
            return "";
        }
        for (String next : fno.O000000o().O00000oO().keySet()) {
            if (TextUtils.equals(did, UwbDeviceUtil.getUwbHashFirst3B(next))) {
                return next;
            }
        }
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.clear();
            O000000o(list.get(i), arrayList);
            if (!arrayList.isEmpty()) {
                for (String str : arrayList) {
                    if (TextUtils.equals(did, UwbDeviceUtil.getUwbHashFirst3B(str))) {
                        return str;
                    }
                }
                continue;
            }
        }
        return "";
    }

    public static String O00000o0(String str) {
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "getDidByDidHashFromHome for ".concat(String.valueOf(str)));
        }
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.clear();
            O000000o(list.get(i), arrayList);
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "getDidByDidHashFromHome home dids:" + Arrays.toString(arrayList.toArray()));
            }
            UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "UwbLogUtilPlus getDidByDidHashFromHome dids:" + Arrays.toString(arrayList.toArray()));
            if (!arrayList.isEmpty()) {
                for (String str2 : arrayList) {
                    if (TextUtils.equals(str, UwbDeviceUtil.getUwbHashFirst3B(str2))) {
                        return str2;
                    }
                }
                continue;
            }
        }
        return "";
    }

    public static String O00000oo(UwbScanDevice uwbScanDevice) {
        Device O0000OOo = O0000OOo(uwbScanDevice);
        if (O0000OOo != null) {
            return O0000OOo.getDid();
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hzq.O000000o(com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, boolean):java.lang.String
     arg types: [com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, int]
     candidates:
      _m_j.hzq.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>):void
      _m_j.hzq.O000000o(java.lang.String, java.lang.String):boolean
      _m_j.hzq.O000000o(com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, boolean):java.lang.String */
    public static String O0000O0o(UwbScanDevice uwbScanDevice) {
        return O000000o(uwbScanDevice, false);
    }

    public static String O000000o(UwbScanDevice uwbScanDevice, boolean z) {
        String deviceAccountId = UwbDeviceUtil.getDeviceAccountId(uwbScanDevice);
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        String did = uwbScanDevice.getDidInfo() == null ? null : uwbScanDevice.getDidInfo().getDid();
        if (!TextUtils.isEmpty(did)) {
            for (int i = 0; i < list.size(); i++) {
                Home home = list.get(i);
                if (home != null) {
                    for (String uwbHashFirst3B : home.getAllDids()) {
                        if (TextUtils.equals(did, UwbDeviceUtil.getUwbHashFirst3B(uwbHashFirst3B))) {
                            return home.getId();
                        }
                    }
                    continue;
                }
            }
        }
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Home home2 = list.get(i2);
                if (home2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(home2.getOwnerUid());
                    if (TextUtils.equals(deviceAccountId, UwbDeviceUtil.getUwbHashFirst3B(sb.toString()))) {
                        return home2.getId();
                    }
                }
            }
        }
        return null;
    }

    private static Device O0000OOo(UwbScanDevice uwbScanDevice) {
        if (uwbScanDevice != null && uwbScanDevice.getDidInfo() != null && !TextUtils.isEmpty(uwbScanDevice.getDidInfo().getDid())) {
            List<Device> O00000o = O00000o();
            if (!O00000o.isEmpty()) {
                List<Device> O000000o2 = O000000o();
                O00000o.addAll(O000000o2);
                UwbLogUtil.e("Mijia-UWB-UwbTagUtils", "getDeviceWithLoaded tagDevices size:" + O000000o2.size());
                String did = uwbScanDevice.getDidInfo().getDid();
                boolean hasRealDid = UwbDeviceUtil.hasRealDid(uwbScanDevice);
                if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                    UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "getTagDevice list:" + O00000o.size() + ",scanDidHash=" + did);
                }
                List<ddt.O00000o0> O00000Oo = ddt.O0000O0o.O00000Oo();
                Iterator<Device> it = O00000o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Device next = it.next();
                    String uwbHashFirst3B = UwbDeviceUtil.getUwbHashFirst3B(next.did);
                    if (!TextUtils.isEmpty(uwbHashFirst3B) && uwbHashFirst3B.endsWith(did)) {
                        if (hasRealDid) {
                            return next;
                        }
                        UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "getDeviceWithLoaded queryResults size=" + O00000Oo.size());
                        for (ddt.O00000o0 next2 : O00000Oo) {
                            if (TextUtils.equals(next2.O00000Oo, next.did)) {
                                for (Device next3 : O000000o2) {
                                    if (TextUtils.equals(next3.getDid(), next2.f14521O000000o) && O000000o(next3.getMac(), uwbScanDevice.getBleAddress())) {
                                        return next3;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                }
            } else {
                UwbLogUtil.e("Mijia-UWB-UwbTagUtils", "no tag devices found");
                return null;
            }
        }
        return null;
    }

    private static boolean O000000o(String str, String str2) {
        try {
            int lastIndexOf = str.lastIndexOf(":");
            int lastIndexOf2 = str2.lastIndexOf(":");
            if (lastIndexOf != lastIndexOf2 || !TextUtils.equals(str.substring(0, lastIndexOf), str2.substring(0, lastIndexOf2))) {
                return false;
            }
            String substring = str.substring(lastIndexOf + 1);
            String substring2 = str2.substring(lastIndexOf2 + 1);
            if ((Integer.parseInt(substring, 16) + 2) % 256 == Integer.parseInt(substring2, 16)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            UwbLogUtil.e("Mijia-UWB-UwbTagUtils", "isWifiAndBlePair exception " + e.getMessage());
        }
    }

    public static String O00000Oo() {
        if (!TextUtils.isEmpty(CoreApi.O000000o().O0000o0())) {
            return CoreApi.O000000o().O0000o0();
        }
        return String.valueOf(RandomUtils.nextLong(1000000, Long.MAX_VALUE));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c A[Catch:{ Exception -> 0x0044 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0015 A[SYNTHETIC] */
    private static List<String> O00000oO() {
        boolean z;
        Collection<Device> values = fno.O000000o().O00000oO().values();
        ArrayList arrayList = new ArrayList();
        try {
            for (Device next : values) {
                if (next != null) {
                    if (!TextUtils.isEmpty(next.getModel())) {
                        z = next.getModel().startsWith("xiaomi.tv.");
                        if (!z) {
                            arrayList.add(next.getDid());
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static Set<String> O00000o0() {
        List<Device> O000000o2 = O000000o();
        List<Device> O0000Oo = ggb.O00000Oo().O0000Oo(ggb.O00000Oo().O0000OOo());
        HashSet hashSet = new HashSet();
        for (Device did : O000000o2) {
            hashSet.add(did.getDid());
        }
        for (Device next : O0000Oo) {
            if ((next.getComFlag() & 8) != 0) {
                hashSet.add(next.getDid());
            }
        }
        hashSet.addAll(O00000oO());
        if (hashSet.isEmpty()) {
            UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "getAllDidForUwbPermit devices count: " + fno.O000000o().O00000oO().size() + ", trace empty:" + Log.getStackTraceString(new Exception()));
        }
        return hashSet;
    }

    public static Dialog O000000o(BaseActivity baseActivity, String str, SmartConfigStep.O000000o o000000o) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "wifi is valid for binding model: ".concat(String.valueOf(str)));
                return null;
            }
            WifiManager wifiManager = (WifiManager) baseActivity.getApplicationContext().getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                str2 = "";
            } else {
                str2 = connectionInfo.getSSID();
            }
            if (TextUtils.isEmpty(str2) || str2.contains("unknown ssid")) {
                str2 = BaseWifiSettingUtils.O000000o(baseActivity, wifiManager);
            }
            if (str2.startsWith(jdn.f1779O000000o) && str2.length() > 2) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            if (MiConnectConfigActivity.checkWifiCondition(str, connectionInfo, str2)) {
                String O00000o0 = dcp.O000000o().O00000o0(str2);
                UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "wifi is valid for binding " + str + ",ssid=" + str2 + ",miuiPwd" + O00000o0);
                if (!TextUtils.isEmpty(O00000o0)) {
                    htr.O000000o().O00000Oo("selected_ap_ssid", str2);
                    htr.O000000o().O00000Oo("selected_ap_passwd", O00000o0);
                    return null;
                }
            }
            UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "wifi is not valid for binding " + str + ", show wifi choose");
            htr.O000000o().O00000Oo("device_model", str);
            hwo hwo = new hwo();
            View O00000Oo = hwo.O00000Oo(baseActivity);
            hwo.O00000o0(baseActivity);
            MLAlertDialog O00000o = new MLAlertDialog.Builder(baseActivity).O000000o(O00000Oo).O000000o(true).O00000o();
            hwo.O000OOo0 = o000000o;
            hwo.O00000Oo();
            O00000o.show();
            return O00000o;
        } catch (Exception e) {
            UwbLogUtil.d("Mijia-UWB-UwbTagUtils", "wifi is not valid for binding error: " + e.getLocalizedMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static boolean O00000o(String str) {
        if (f1019O000000o.isEmpty()) {
            f1019O000000o.add("yeelink.light.sp1grp");
            f1019O000000o.add("yeelink.light.mb1grp");
            f1019O000000o.add("yeelink.light.mb2grp");
            f1019O000000o.add("yeelink.light.dn2grp");
            f1019O000000o.add("philips.light.virtual");
            f1019O000000o.add("yeelink.light.virtual");
        }
        return f1019O000000o.contains(str);
    }
}
