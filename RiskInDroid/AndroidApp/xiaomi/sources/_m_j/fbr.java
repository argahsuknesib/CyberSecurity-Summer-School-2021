package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;

public final class fbr {

    public interface O000000o {
        void O000000o(String str);
    }

    public static Intent O000000o(Device device, Context context) {
        return ext.O000000o(device).getAction(device, context, null, false, null);
    }

    public static void O000000o(Context context) {
        gty.O000000o().startLogin(context, 1, null);
    }

    public static DeviceStat O000000o(Device device) {
        return DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device);
    }
}
