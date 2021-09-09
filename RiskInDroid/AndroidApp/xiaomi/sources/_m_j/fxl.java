package _m_j;

import com.xiaomi.smarthome.device.Device;

public final class fxl {
    public static Device O000000o(String str, String str2) {
        Device device = new Device();
        device.did = str;
        device.model = str2;
        device.isOnline = true;
        device.name = str;
        device.setOwner(true);
        return device;
    }
}
