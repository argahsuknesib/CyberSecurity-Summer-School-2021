package _m_j;

import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import java.util.List;

public final class fob {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f16735O000000o = "ble_refresh_choose";

    public static BleDeviceGroup O000000o(String str) {
        return DeviceRouterFactory.getBleManager().getBleDeviceGroup(str);
    }

    public static void O000000o(String str, String str2) {
        DeviceRouterFactory.getBleManager().removeCombDevice(str, str2);
    }

    public static List<BleDeviceGroup> O000000o() {
        return DeviceRouterFactory.getBleManager().getChooseBleDeviceList();
    }

    public static BleDevice O00000Oo(String str) {
        return DeviceRouterFactory.getBleManager().getDeviceByDid(str);
    }

    public static boolean O00000Oo() {
        return DeviceRouterFactory.getBleManager().isSearchStopped();
    }

    public static void O000000o(fon fon) {
        DeviceRouterFactory.getBleManager().searchBleDevice(fon);
    }

    public static void O000000o(SearchRequest searchRequest, fon fon) {
        DeviceRouterFactory.getBleManager().searchBleDevice(searchRequest, fon);
    }

    public static void O00000o0() {
        DeviceRouterFactory.getBleManager().stopSearchBleDevice();
    }

    public static void O000000o(Device device) {
        DeviceRouterFactory.getBleManager().unbindMeshDevice(device);
    }

    public static void O000000o(BleDevice bleDevice) {
        DeviceRouterFactory.getBleManager().unbindBluetoothDevice(bleDevice);
    }

    public static BleDevice O00000o0(String str) {
        return DeviceRouterFactory.getBleManager().getDeviceByMac(str);
    }

    public static void O000000o(String str, boolean z) {
        DeviceRouterFactory.getBleManager().setDeviceNew(str, z);
    }

    public static boolean O00000Oo(BleDevice bleDevice) {
        return DeviceRouterFactory.getBleManager().containsInSmartHome(bleDevice);
    }

    public static void O000000o(boolean z) {
        DeviceRouterFactory.getBleManager().refreshSmartHomeDeviceList(z);
    }

    public static void O00000Oo(Device device) {
        DeviceRouterFactory.getBleManager().removeCacheMeshDevice(device);
    }
}
