package _m_j;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

public final class bkc extends bjz {
    private static final String[] O00000o = {"android.bluetooth.device.action.BOND_STATE_CHANGED"};

    private bkc(bkf bkf) {
        super(bkf);
    }

    public static bkc O000000o(bkf bkf) {
        return new bkc(bkf);
    }

    /* access modifiers changed from: package-private */
    public final List<String> O000000o() {
        return Arrays.asList(O00000o);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        if (bluetoothDevice != null) {
            String address = bluetoothDevice.getAddress();
            for (bkm O000000o2 : O000000o(bkk.class)) {
                O000000o2.O000000o(address, Integer.valueOf(intExtra));
            }
        }
        return true;
    }
}
