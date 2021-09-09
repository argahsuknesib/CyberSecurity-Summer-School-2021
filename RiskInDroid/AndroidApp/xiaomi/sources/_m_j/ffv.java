package _m_j;

import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class ffv implements ffz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final fgg[] f16247O000000o = {fgl.O00000o0(), fgh.O00000o0(), fgi.O00000o0(), fgj.O00000o0(), new fge(), fgk.O00000o0()};

    private ffv() {
    }

    public static ffv O000000o() {
        return new ffv();
    }

    public final ffw O000000o(BluetoothSearchResult bluetoothSearchResult) {
        for (fgg fgg : f16247O000000o) {
            if (!fgg.O00000Oo() && fgg.O000000o(bluetoothSearchResult)) {
                return new ffw(fgg.O000000o());
            }
        }
        return null;
    }
}
