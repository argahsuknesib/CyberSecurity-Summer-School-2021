package _m_j;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.inuker.bluetooth.library.search.SearchResult;

public final class bku extends bks {
    private O00000Oo O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static bku f13024O000000o = new bku((byte) 0);
    }

    /* synthetic */ bku(byte b) {
        this();
    }

    private bku() {
        this.f13023O000000o = bkz.O00000o0();
    }

    public final void O000000o(bkw bkw) {
        super.O000000o(bkw);
        if (this.O00000o0 == null) {
            this.O00000o0 = new O00000Oo(this, (byte) 0);
            bkz.O000000o(this.O00000o0, new IntentFilter("android.bluetooth.device.action.FOUND"));
        }
        if (this.f13023O000000o.isDiscovering()) {
            this.f13023O000000o.cancelDiscovery();
        }
        this.f13023O000000o.startDiscovery();
    }

    public final void O000000o() {
        O00000o0();
        if (this.f13023O000000o.isDiscovering()) {
            this.f13023O000000o.cancelDiscovery();
        }
        super.O000000o();
    }

    public final void O00000Oo() {
        O00000o0();
        if (this.f13023O000000o.isDiscovering()) {
            this.f13023O000000o.cancelDiscovery();
        }
        super.O00000Oo();
    }

    private void O00000o0() {
        O00000Oo o00000Oo = this.O00000o0;
        if (o00000Oo != null) {
            bij.f13001O000000o.unregisterReceiver(o00000Oo);
            this.O00000o0 = null;
        }
    }

    class O00000Oo extends BroadcastReceiver {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(bku bku, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.device.action.FOUND")) {
                bku.this.O000000o(new SearchResult((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE), null));
            }
        }
    }
}
