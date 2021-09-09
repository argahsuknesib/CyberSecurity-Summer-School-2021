package _m_j;

import android.bluetooth.BluetoothGattDescriptor;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.WriteDescriptorListener;
import java.util.UUID;

public final class gmm extends gmj implements WriteDescriptorListener {
    public gmm(UUID uuid, UUID uuid2) {
        super(null);
        this.O00000o = uuid;
        this.O00000oO = uuid2;
    }

    public final void O000000o() {
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            O00000Oo(-1);
        } else if (currentStatus == 2) {
            O00000Oo();
        } else if (currentStatus != 19) {
            O00000Oo(-1);
        } else {
            O00000Oo();
        }
    }

    private void O00000Oo() {
        if (!setCharacteristicNotification(this.O00000o, this.O00000oO, false)) {
            O00000Oo(-1);
        } else {
            O00000o0();
        }
    }

    public final void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        O00000o();
        if (i == 0) {
            O00000Oo(0);
        } else {
            O00000Oo(-1);
        }
    }
}
