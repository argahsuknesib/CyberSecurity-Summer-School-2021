package _m_j;

import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import java.util.List;

public interface fmp {
    BleDevice allocDevice(String str);

    void clearExpiredDevice();

    boolean containsInSmartHome(BleDevice bleDevice);

    BleDeviceGroup getBleDeviceGroup(String str);

    List<BleDeviceGroup> getChooseBleDeviceList();

    BleDevice getDeviceByDid(String str);

    BleDevice getDeviceByMac(String str);

    boolean isSearchStopped();

    void refreshSmartHomeDeviceList(boolean z);

    void removeCacheMeshDevice(Device device);

    void removeCombDevice(String str, String str2);

    void searchBleDevice(fon fon);

    void searchBleDevice(SearchRequest searchRequest, fon fon);

    void setDeviceNew(String str, boolean z);

    void stopSearchBleDevice();

    void unbindBluetoothDevice(BleDevice bleDevice);

    void unbindMeshDevice(Device device);
}
