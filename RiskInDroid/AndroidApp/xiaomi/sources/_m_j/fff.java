package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.device.BtDevice;

public class fff implements ffj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fff f16213O000000o;

    public static fff O000000o() {
        if (f16213O000000o == null) {
            synchronized (fff.class) {
                if (f16213O000000o == null) {
                    f16213O000000o = new fff();
                }
            }
        }
        return f16213O000000o;
    }

    public final void O000000o(BtDevice btDevice) {
        if (TextUtils.isEmpty(btDevice.getModel())) {
            String O0000Oo = ffr.O0000Oo(btDevice.getMac());
            if (!TextUtils.isEmpty(O0000Oo)) {
                btDevice.setModel(O0000Oo);
            }
        }
    }
}
