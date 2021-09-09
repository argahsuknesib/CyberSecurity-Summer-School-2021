package _m_j;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.inuker.bluetooth.library.search.SearchResult;

public final class bkv extends bks {
    private final BluetoothAdapter.LeScanCallback O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static bkv f13027O000000o = new bkv((byte) 0);
    }

    /* synthetic */ bkv(byte b) {
        this();
    }

    private bkv() {
        this.O00000o0 = new BluetoothAdapter.LeScanCallback() {
            /* class _m_j.bkv.AnonymousClass1 */

            public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                bkv.this.O000000o(new SearchResult(bluetoothDevice, i, bArr));
            }
        };
        this.f13023O000000o = bkz.O00000o0();
    }

    @TargetApi(18)
    public final void O000000o(bkw bkw) {
        super.O000000o(bkw);
        this.f13023O000000o.startLeScan(this.O00000o0);
    }

    @TargetApi(18)
    public final void O000000o() {
        try {
            this.f13023O000000o.stopLeScan(this.O00000o0);
        } catch (Exception e) {
            bky.O000000o(e);
        }
        super.O000000o();
    }

    @TargetApi(18)
    public final void O00000Oo() {
        this.f13023O000000o.stopLeScan(this.O00000o0);
        super.O00000Oo();
    }
}
