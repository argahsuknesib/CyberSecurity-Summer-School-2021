package _m_j;

import _m_j.fgs;
import android.os.Bundle;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;

public final class fgy extends fgv {
    private fgw O0000Oo = new fgw(this.O0000OOo);
    private final fgs.O000000o O0000OoO = new fgs.O000000o() {
        /* class _m_j.fgy.AnonymousClass1 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            if (i == 0) {
                fgy.this.O00000oo();
                fgy fgy = fgy.this;
                fgy.O000000o(fgy.O00000Oo);
            }
            ffr.O00000o(fgy.this.O00000Oo, i == 0 ? 2 : 0);
            fgy.this.O000000o("action.ble.bind", i);
            fgy.this.O00000Oo(i);
        }
    };

    public fgy(String str, int i, BleConnectOptions bleConnectOptions) {
        super(str, i, bleConnectOptions);
    }

    public final fgm O00000o0() {
        return this.O0000Oo;
    }

    public final void O000000o(int i, Bundle bundle) {
        this.O00000o0 = this.O00000oo.getByteArray("key_token");
        if (!O00000o()) {
            O00000oo();
            O000000o("action.ble.bind", 0);
            O00000Oo(i);
            return;
        }
        O000000o(this.O0000OoO);
    }

    public final void O00000oo() {
        ffr.O00000Oo(this.O00000Oo, this.O00000o0);
    }

    public final void O000000o(gle gle) {
        fec.O00000o().O000000o(3);
        super.O000000o(gle);
    }
}
