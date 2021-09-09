package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.core.entity.device.BtDevice;

public class ffh implements ffj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ffh f16215O000000o;

    public static ffh O000000o() {
        if (f16215O000000o == null) {
            synchronized (ffh.class) {
                if (f16215O000000o == null) {
                    f16215O000000o = new ffh();
                }
            }
        }
        return f16215O000000o;
    }

    public final void O000000o(BtDevice btDevice) {
        Bundle bundle = new Bundle();
        fec.O000000o(glc.O0000O0o).O000000o(btDevice.getMac(), 15, bundle);
        btDevice.setPermitLevel(bundle.getInt("extra.result", 0));
        if (btDevice.getPermitLevel() == 0) {
            btDevice.setOwner(true);
        }
    }
}
