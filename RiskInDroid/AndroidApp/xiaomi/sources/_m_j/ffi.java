package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.device.BtDevice;

public class ffi implements ffj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ffi f16216O000000o;

    public static ffi O000000o() {
        if (f16216O000000o == null) {
            synchronized (ffi.class) {
                if (f16216O000000o == null) {
                    f16216O000000o = new ffi();
                }
            }
        }
        return f16216O000000o;
    }

    public final void O000000o(BtDevice btDevice) {
        String O00000o = ffr.O00000o(btDevice.getMac());
        if (!TextUtils.isEmpty(O00000o)) {
            btDevice.setOwnerId(O00000o);
        }
        String O00000Oo = ffr.O00000Oo(btDevice.getMac());
        if (!TextUtils.isEmpty(O00000Oo)) {
            btDevice.setOwnerName(O00000Oo);
        }
        btDevice.setPermitLevel(ffr.O00000oO(btDevice.getMac()));
    }
}
