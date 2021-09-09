package _m_j;

import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import java.util.List;

@RouterService
public class fqi implements fmp {
    private static final fqi INSTANCE = new fqi();

    @cug
    public static fqi provideInstance() {
        return INSTANCE;
    }

    private fqi() {
    }

    public BleDevice allocDevice(String str) {
        flz.O000000o();
        return flz.O000000o(str);
    }

    public BleDevice getDeviceByDid(String str) {
        return fof.O00000o0(str);
    }

    public BleDevice getDeviceByMac(String str) {
        return fof.O00000o(str);
    }

    public void setDeviceNew(String str, boolean z) {
        fof.O000000o(str, z);
    }

    public void searchBleDevice(fon fon) {
        fof.O000000o(fon);
    }

    public void searchBleDevice(SearchRequest searchRequest, fon fon) {
        fof.O000000o(searchRequest, fon);
    }

    public boolean isSearchStopped() {
        return fof.O00000o();
    }

    public void stopSearchBleDevice() {
        fof.O00000oo();
    }

    public BleDeviceGroup getBleDeviceGroup(String str) {
        return fof.O000000o(str);
    }

    public boolean containsInSmartHome(BleDevice bleDevice) {
        return fof.O00000o0(bleDevice);
    }

    public List<BleDeviceGroup> getChooseBleDeviceList() {
        return fof.O00000Oo();
    }

    public void unbindBluetoothDevice(BleDevice bleDevice) {
        fof.O00000Oo(bleDevice);
    }

    public void unbindMeshDevice(Device device) {
        fof.O000000o(device);
    }

    public BleDeviceGroup getComboBleDeviceGroup(String str) {
        return fof.O00000Oo(str);
    }

    public void removeCombDevice(String str, String str2) {
        fof.O000000o(str, str2);
    }

    public void refreshSmartHomeDeviceList(boolean z) {
        fof.O000000o(z);
    }

    public void removeCacheMeshDevice(Device device) {
        fof.O00000Oo(device);
    }

    public void clearExpiredDevice() {
        fof.O00000oO();
    }
}
