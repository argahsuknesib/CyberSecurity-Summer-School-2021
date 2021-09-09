package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class fge extends fgf {

    /* renamed from: O000000o  reason: collision with root package name */
    private String[] f16256O000000o = {" "};

    public final String O000000o() {
        return "ninebot.balscooter.v1";
    }

    public final boolean O000000o(BluetoothSearchResult bluetoothSearchResult) {
        String str = bluetoothSearchResult.O00000oO;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String startsWith : this.f16256O000000o) {
            if (str.startsWith(startsWith) && str.length() > 1) {
                return true;
            }
        }
        return false;
    }
}
