package _m_j;

import com.xiaomi.smarthome.core.entity.device.BtDevice;

public class ffd implements ffj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ffj[] f16211O000000o = {fff.O000000o(), ffg.O000000o(), ffe.O000000o(), ffi.O000000o()};
    private static volatile ffd O00000Oo;

    public static ffd O000000o() {
        if (O00000Oo == null) {
            synchronized (ffd.class) {
                if (O00000Oo == null) {
                    O00000Oo = new ffd();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(BtDevice btDevice) {
        for (ffj O000000o2 : f16211O000000o) {
            O000000o2.O000000o(btDevice);
        }
    }
}
