package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;

public final class fgq extends fgn {
    private fgr O0000Oo0;

    public fgq(String str, int i, BleComboWifiConfig bleComboWifiConfig, BleConnectOptions bleConnectOptions) {
        super(str, i, bleConnectOptions);
        this.O0000Oo0 = new fgr(this.O0000OOo, bleComboWifiConfig);
    }

    public final fgm O00000o0() {
        return this.O0000Oo0;
    }

    public final void O000000o(int i, Bundle bundle) {
        if (this.O00000oo != null) {
            this.O00000oo.putString("key_device_did", this.O0000Oo0.O0000o0());
        }
        if (i == 0) {
            O000000o("action.ble.bind", 0);
        }
        O00000Oo(i);
    }
}
