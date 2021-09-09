package _m_j;

import _m_j.fgs;
import android.os.Bundle;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;

public final class fgx extends fgv {
    private fgt O0000Oo = new fgt(this.O0000OOo);

    public fgx(String str, int i, byte[] bArr, BleConnectOptions bleConnectOptions) {
        super(str, i, bArr, bleConnectOptions);
    }

    public final fgm O00000o0() {
        return this.O0000Oo;
    }

    public final void O000000o(final int i, Bundle bundle) {
        if (!O00000o()) {
            O000000o("action.ble.bind", 0);
            O00000Oo(i);
            return;
        }
        int O00000oO = O00000oO();
        if (O00000oO == 1) {
            fte.O00000Oo("loginForStrongBind ".concat(String.valueOf(i)));
            O000000o("action.ble.bind", 0);
            O00000Oo(i);
        } else if (O00000oO != 2) {
            throw new IllegalStateException("impossible here");
        } else if (ffr.O0000o0(this.O00000Oo) != 2) {
            fte.O00000Oo("loginForWeakBind, remoteBinded false");
            O000000o(new fgs.O000000o() {
                /* class _m_j.fgx.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    fgx.this.O00000o0(i);
                    fgx.this.O000000o("action.ble.bind", i);
                    fgx.this.O00000Oo(i);
                }
            });
        } else {
            fte.O00000Oo("loginForWeakBind, remoteBinded true");
            O000000o("action.ble.bind", 0);
            O00000Oo(i);
        }
        if (i == 0) {
            O000000o(this.O00000Oo);
        }
    }
}
