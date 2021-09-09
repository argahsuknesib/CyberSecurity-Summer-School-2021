package _m_j;

import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class fgi extends fgf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f16258O000000o = gqb.O000000o(fec.O00000Oo(), (int) R.string.roidmi_car_bluetooth_player_v2);

    public final String O000000o() {
        return "roidmi.btfm.m1";
    }

    private fgi() {
    }

    public static fgi O00000o0() {
        return new fgi();
    }

    public final boolean O000000o(BluetoothSearchResult bluetoothSearchResult) {
        return f16258O000000o.equalsIgnoreCase(bluetoothSearchResult.O00000oO);
    }
}
