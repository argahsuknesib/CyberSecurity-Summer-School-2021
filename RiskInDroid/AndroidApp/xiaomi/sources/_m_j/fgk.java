package _m_j;

import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class fgk extends fgf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f16260O000000o = {"Music Alarm Clock", "Mi Music Alarm Clock"};

    public final String O000000o() {
        return "onemore.soundbox.sm001";
    }

    public final boolean O00000Oo() {
        return false;
    }

    private fgk() {
    }

    public static fgk O00000o0() {
        return new fgk();
    }

    public final boolean O000000o(BluetoothSearchResult bluetoothSearchResult) {
        for (String equals : f16260O000000o) {
            if (equals.equals(bluetoothSearchResult.O00000oO)) {
                return true;
            }
        }
        return false;
    }
}
