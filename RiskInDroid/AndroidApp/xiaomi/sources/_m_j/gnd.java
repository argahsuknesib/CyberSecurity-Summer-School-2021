package _m_j;

import android.bluetooth.BluetoothAdapter;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.util.UUID;

public class gnd {

    /* renamed from: O000000o  reason: collision with root package name */
    protected BluetoothAdapter f18040O000000o;
    protected gna O00000Oo;
    protected UUID[] O00000o0;

    /* access modifiers changed from: protected */
    public void O000000o(UUID[] uuidArr, gna gna) {
        this.O00000o0 = uuidArr;
        this.O00000Oo = gna;
        gna gna2 = this.O00000Oo;
        if (gna2 != null) {
            gna2.O000000o();
        }
    }

    public final void O000000o(BluetoothSearchResult bluetoothSearchResult) {
        gna gna = this.O00000Oo;
        if (gna != null) {
            gna.O000000o(bluetoothSearchResult);
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o() {
        gna gna = this.O00000Oo;
        if (gna != null) {
            gna.O00000Oo();
        }
        this.O00000Oo = null;
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        gna gna = this.O00000Oo;
        if (gna != null) {
            gna.O00000o0();
        }
        this.O00000Oo = null;
    }
}
