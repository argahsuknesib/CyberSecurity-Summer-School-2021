package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.HashMap;

public class flz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile flz f16596O000000o;
    private HashMap<String, BleDevice> O00000Oo = new HashMap<>();
    private final Object O00000o = new Object();
    private HashMap<String, BleDevice> O00000o0 = new HashMap<>();

    public static flz O000000o() {
        if (f16596O000000o == null) {
            synchronized (flz.class) {
                if (f16596O000000o == null) {
                    f16596O000000o = new flz();
                }
            }
        }
        return f16596O000000o;
    }

    private flz() {
    }

    public static BleDevice O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("%s allocDevice: mac null", "BleDevicePool"));
            return null;
        }
        try {
            BleDevice bleDevice = (BleDevice) fdb.O000000o(BleDevice.class, new Object[0]);
            bleDevice.pid = Device.PID_BLUETOOTH;
            bleDevice.userId = CoreApi.O000000o().O0000o0();
            bleDevice.isOnline = true;
            bleDevice.canAuth = true;
            bleDevice.mac = str;
            String O000000o2 = foc.O000000o(str);
            if (TextUtils.isEmpty(O000000o2)) {
                O000000o2 = str;
            }
            bleDevice.did = O000000o2;
            bleDevice.canUseNotBind = true;
            bleDevice.ownerId = foc.O00000oO(str);
            Bundle bundle = new Bundle();
            CoreApi.O000000o().O000000o(str, 16, bundle);
            bleDevice.ownerName = bundle.getString("extra.result", "");
            Bundle bundle2 = new Bundle();
            CoreApi.O000000o().O000000o(str, 15, bundle2);
            bleDevice.permitLevel = bundle2.getInt("extra.result", 0);
            if (bleDevice.permitLevel == 0) {
                bleDevice.setOwner(true);
            }
            bleDevice.model = foc.O00000o(str);
            Bundle bundle3 = new Bundle();
            CoreApi.O000000o().O000000o(str, 1, bundle3);
            String string = bundle3.getString("extra.result", "");
            if (TextUtils.isEmpty(string)) {
                string = BleDevice.O00000Oo(bleDevice.model);
            }
            bleDevice.name = string;
            return bleDevice;
        } catch (Throwable th) {
            Log.e("BleDevicePool", "fatal allocDevice", th);
            gnk.O00000Oo(gnk.O00000Oo(th));
            return null;
        }
    }
}
