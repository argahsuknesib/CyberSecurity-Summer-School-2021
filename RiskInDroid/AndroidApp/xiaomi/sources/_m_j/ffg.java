package _m_j;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.device.BtDevice;

public class ffg implements ffj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ffg f16214O000000o;

    public static ffg O000000o() {
        if (f16214O000000o == null) {
            synchronized (ffg.class) {
                if (f16214O000000o == null) {
                    f16214O000000o = new ffg();
                }
            }
        }
        return f16214O000000o;
    }

    public final void O000000o(BtDevice btDevice) {
        BluetoothDevice O00000Oo;
        String O000000o2 = ffr.O000000o(btDevice.getMac());
        if (TextUtils.isEmpty(O000000o2)) {
            String model = btDevice.getModel();
            if (TextUtils.isEmpty(model)) {
                O000000o2 = "";
            } else if ("yeelink.light.ble1".equalsIgnoreCase(model)) {
                O000000o2 = gqb.O000000o(fec.O00000Oo(), (int) R.string.yeelight_name);
            } else if ("zimi.powerbank.v1".equalsIgnoreCase(model)) {
                O000000o2 = gqb.O000000o(fec.O00000Oo(), (int) R.string.zimi_power_name);
            } else if ("xiaomi.ble.v1".equalsIgnoreCase(model)) {
                O000000o2 = gqb.O000000o(fec.O00000Oo(), (int) R.string.xiaomi_bracelet);
            } else {
                O000000o2 = fec.O00000o0().O00000Oo(model);
            }
        }
        if (!TextUtils.isEmpty(O000000o2)) {
            btDevice.setName(O000000o2);
        } else if (TextUtils.isEmpty(btDevice.getName()) && (O00000Oo = gnl.O00000Oo(btDevice.getMac())) != null) {
            btDevice.setName(O00000Oo.getName());
        }
    }
}
