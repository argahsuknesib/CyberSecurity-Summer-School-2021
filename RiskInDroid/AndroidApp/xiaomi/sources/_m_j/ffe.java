package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.device.BtDevice;

public class ffe implements ffj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ffe f16212O000000o;

    public static ffe O000000o() {
        if (f16212O000000o == null) {
            synchronized (ffe.class) {
                if (f16212O000000o == null) {
                    f16212O000000o = new ffe();
                }
            }
        }
        return f16212O000000o;
    }

    public final void O000000o(BtDevice btDevice) {
        String O00000oo = ffr.O00000oo(btDevice.getMac());
        if (!TextUtils.isEmpty(O00000oo)) {
            btDevice.setDid(O00000oo);
        }
        if (TextUtils.isEmpty(btDevice.getDid())) {
            btDevice.setDid(btDevice.getMac());
        }
    }
}
