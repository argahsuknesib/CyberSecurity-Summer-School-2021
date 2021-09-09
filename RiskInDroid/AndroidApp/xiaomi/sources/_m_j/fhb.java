package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;

public final class fhb extends fgn {
    private fhc O0000Oo0 = new fhc(this.O0000OOo);

    public fhb(String str, int i, BleConnectOptions bleConnectOptions) {
        super(str, i, bleConnectOptions);
    }

    public final fgm O00000o0() {
        return this.O0000Oo0;
    }

    public final void O000000o(final int i, Bundle bundle) {
        if (i == 0) {
            ffr.O00000oO(this.O00000Oo, this.O0000Oo0.O0000o0o);
        }
        fgo.O000000o(this.O00000Oo, this.O0000Oo0.O0000o0o, new feo<Void, fes>() {
            /* class _m_j.fhb.AnonymousClass1 */

            public final void O000000o(fes fes) {
                if (fes != null) {
                    fte.O00000Oo("report version failed: " + fes.toString());
                }
                fhb.this.O00000o0(i);
            }

            public final /* synthetic */ void O000000o(Object obj) {
                fte.O00000Oo("report version success");
                fhb.this.O00000o0(i);
            }
        });
    }

    public final void O00000o0(int i) {
        O000000o("action.ble.bind", 0);
        O00000Oo(i);
        this.O0000Oo0.O000000o();
    }

    public final void O000000o(gle gle) {
        fec.O00000o().O000000o(3);
        super.O000000o(gle);
    }
}
