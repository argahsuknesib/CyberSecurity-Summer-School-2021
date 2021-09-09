package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class ffu implements ffz {
    ffu() {
    }

    public final ffw O000000o(BluetoothSearchResult bluetoothSearchResult) {
        if (fec.O00000o0().O00000o()) {
            return null;
        }
        boolean z = true;
        if (ffr.O0000o00(bluetoothSearchResult.O000000o()) != 1) {
            z = false;
        }
        if (z) {
            return null;
        }
        String O0000Oo = ffr.O0000Oo(bluetoothSearchResult.O000000o());
        ffw ffw = !TextUtils.isEmpty(O0000Oo) ? new ffw(O0000Oo) : null;
        if (!TextUtils.equals(O0000Oo, "ninebot.balscooter.v1") || !TextUtils.equals(bluetoothSearchResult.O00000oO, " ")) {
            return ffw;
        }
        return null;
    }
}
