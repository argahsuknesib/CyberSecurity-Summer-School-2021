package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;

public final class fgz extends fgn {
    private fha O0000Oo0;

    public fgz(String str, int i, byte[] bArr, BleConnectOptions bleConnectOptions) {
        super(str, i, bArr, bleConnectOptions);
        this.O0000Oo0 = new fha(this.O0000OOo, bArr);
    }

    public final fgm O00000o0() {
        return this.O0000Oo0;
    }

    public final void O000000o(int i, Bundle bundle) {
        ffr.O00000o(this.O00000Oo, bundle.getByteArray("session_key"));
        fhe.O000000o(this.O00000Oo);
        O000000o("action.ble.bind", i);
        O00000Oo(i);
    }
}
