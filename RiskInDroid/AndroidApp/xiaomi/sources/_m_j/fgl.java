package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public final class fgl extends fgf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f16261O000000o = {"4e20", "0248", "012f"};

    public final String O000000o() {
        return "yeelink.light.ble1";
    }

    private fgl() {
    }

    public static fgl O00000o0() {
        return new fgl();
    }

    public final boolean O000000o(BluetoothSearchResult bluetoothSearchResult) {
        String str = bluetoothSearchResult.O00000oO;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String contains : f16261O000000o) {
            if (lowerCase.contains(contains)) {
                return false;
            }
        }
        if (str.contains("XMCTD_")) {
            return true;
        }
        return false;
    }
}
