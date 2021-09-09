package _m_j;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.util.UUID;

public final class gnh extends gnd {
    private final BluetoothAdapter.LeScanCallback O00000o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static gnh f18044O000000o = new gnh((byte) 0);
    }

    /* synthetic */ gnh(byte b) {
        this();
    }

    private gnh() {
        this.O00000o = new BluetoothAdapter.LeScanCallback() {
            /* class _m_j.gnh.AnonymousClass1 */

            public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                BluetoothSearchResult bluetoothSearchResult = new BluetoothSearchResult(bluetoothDevice, i, bArr);
                bluetoothSearchResult.O00000o = 2;
                gnh.this.O000000o(bluetoothSearchResult);
            }
        };
        this.f18040O000000o = gnl.O00000o();
    }

    @TargetApi(18)
    public final void O000000o(UUID[] uuidArr, gna gna) {
        super.O000000o(uuidArr, gna);
        try {
            gsy.O000000o(4, "startScan", "BLS startLeScan");
            this.f18040O000000o.startLeScan(uuidArr, this.O00000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O000000o() {
        O00000o0();
        super.O000000o();
    }

    public final void O00000Oo() {
        O00000o0();
        super.O00000Oo();
    }

    @TargetApi(18)
    private void O00000o0() {
        try {
            if (this.f18040O000000o != null) {
                gsy.O000000o(4, "stopScan", "BLS stopLeScan");
                this.f18040O000000o.stopLeScan(this.O00000o);
            }
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
        }
    }
}
