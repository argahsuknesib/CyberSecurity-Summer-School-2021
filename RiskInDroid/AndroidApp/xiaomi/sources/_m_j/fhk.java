package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;

public final class fhk extends fgn {
    private fhl O0000Oo0 = new fhl(this.O0000OOo);

    public fhk(String str, int i, BleConnectOptions bleConnectOptions) {
        super(str, i, null, bleConnectOptions);
    }

    public final fgm O00000o0() {
        return this.O0000Oo0;
    }

    public final void O000000o(final int i, final Bundle bundle) {
        if (i == 0) {
            this.O0000Oo0.O000000o(this.O00000Oo, ffr.O00000oo(this.O00000Oo), new feo<Void, fes>() {
                /* class _m_j.fhk.AnonymousClass1 */

                public final void O000000o(fes fes) {
                    fhk.this.O00000Oo(i, bundle);
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    fhk.this.O00000Oo(i, bundle);
                }
            });
            return;
        }
        O00000Oo(i, bundle);
    }

    public final void O00000Oo(int i, Bundle bundle) {
        ffr.O00000o(this.O00000Oo, bundle.getByteArray("session_key"));
        fhe.O000000o(this.O00000Oo);
        O000000o("action.ble.bind", i);
        O00000Oo(i);
    }
}
