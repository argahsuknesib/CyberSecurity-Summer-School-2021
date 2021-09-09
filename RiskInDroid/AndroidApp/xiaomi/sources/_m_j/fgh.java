package _m_j;

import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class fgh extends fgf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f16257O000000o = gqb.O000000o(fec.O00000Oo(), (int) R.string.roidmi_car_bluetooth_player);

    public final String O000000o() {
        return "roidmi.btfm.v1";
    }

    private fgh() {
    }

    public static fgh O00000o0() {
        return new fgh();
    }

    public final boolean O000000o(BluetoothSearchResult bluetoothSearchResult) {
        return f16257O000000o.equalsIgnoreCase(bluetoothSearchResult.O00000oO);
    }
}
