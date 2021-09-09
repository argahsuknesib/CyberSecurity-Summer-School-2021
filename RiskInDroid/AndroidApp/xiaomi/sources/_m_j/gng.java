package _m_j;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.util.UUID;

public final class gng extends gnd {
    private O00000Oo O00000o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static gng f18041O000000o = new gng((byte) 0);
    }

    /* synthetic */ gng(byte b) {
        this();
    }

    private gng() {
        this.f18040O000000o = gnl.O00000o();
    }

    public final void O000000o(UUID[] uuidArr, gna gna) {
        super.O000000o(uuidArr, gna);
        if (this.O00000o == null) {
            this.O00000o = new O00000Oo(this, (byte) 0);
            glc.O0000O0o.registerReceiver(this.O00000o, new IntentFilter("android.bluetooth.device.action.FOUND"));
        }
        if (this.f18040O000000o.isDiscovering()) {
            gsy.O000000o(4, "stopScan", "BCS cancelDiscovery");
            this.f18040O000000o.cancelDiscovery();
        }
        gsy.O000000o(4, "startScan", "BCS startDiscovery");
        this.f18040O000000o.startDiscovery();
    }

    public final void O000000o() {
        O00000o0();
        if (this.f18040O000000o.isDiscovering()) {
            gsy.O000000o(4, "stopScan", "BCS cancelDiscovery");
            this.f18040O000000o.cancelDiscovery();
        }
        super.O000000o();
    }

    public final void O00000Oo() {
        O00000o0();
        if (this.f18040O000000o.isDiscovering()) {
            gsy.O000000o(4, "stopScan", "BCS cancelDiscovery");
            this.f18040O000000o.cancelDiscovery();
        }
        super.O00000Oo();
    }

    private void O00000o0() {
        if (this.O00000o != null) {
            glc.O0000O0o.unregisterReceiver(this.O00000o);
            this.O00000o = null;
        }
    }

    class O00000Oo extends BroadcastReceiver {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(gng gng, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.device.action.FOUND")) {
                BluetoothSearchResult bluetoothSearchResult = new BluetoothSearchResult((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE), null);
                bluetoothSearchResult.O00000o = 1;
                gng.this.O000000o(bluetoothSearchResult);
            }
        }
    }
}
