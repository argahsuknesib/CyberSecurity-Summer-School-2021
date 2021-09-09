package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import java.util.ArrayList;

public final class fiv extends fgn {
    private fiw O0000Oo0;

    public fiv(String str, int i, BleConnectOptions bleConnectOptions) {
        super(str, i, bleConnectOptions);
        this.O0000Oo0 = new fiw(this.O0000OOo, bleConnectOptions.O00000oO);
    }

    public final fgm O00000o0() {
        return this.O0000Oo0;
    }

    public final void O000000o(final int i, Bundle bundle) {
        if (i == 0) {
            byte[] byteArray = bundle.getByteArray("key_token");
            ffr.O00000o(this.O00000Oo, 2);
            ffr.O00000oO(this.O00000Oo, this.O0000Oo0.O0000o0O());
            ffr.O00000Oo(this.O00000Oo, byteArray);
            this.O0000Oo0.O000000o(this.O00000Oo, this.O0000Oo0.O0000o0O(), new feo<Void, fes>() {
                /* class _m_j.fiv.AnonymousClass1 */

                public final void O000000o(fes fes) {
                    if (fes != null) {
                        fte.O00000Oo("report version failed: " + fes.toString());
                    }
                    fiv.this.O00000o0(i);
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    fte.O00000Oo("report version success");
                    fiv.this.O00000o0(i);
                }
            });
            return;
        }
        O00000Oo(i);
    }

    public final void O00000o0(int i) {
        O000000o("action.ble.bind", 0);
        O00000Oo(i);
        this.O0000Oo0.O000000o();
    }

    public final void O000000o(int i) {
        if (i != 0 && ffr.O0000o0(this.O00000Oo) == 2 && !TextUtils.isEmpty(this.O0000Oo0.O0000o0O())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.O0000Oo0.O0000o0O());
            fec.O00000o0().O000000o(arrayList, new fep() {
                /* class _m_j.fiv.AnonymousClass2 */

                public final void O000000o() {
                    ffr.O00000o(fiv.this.O00000Oo, 0);
                }
            });
        }
    }

    public final void O000000o(gle gle) {
        fec.O00000o().O000000o(3);
        super.O000000o(gle);
    }
}
