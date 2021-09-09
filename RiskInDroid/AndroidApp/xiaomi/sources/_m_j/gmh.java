package _m_j;

import android.bluetooth.BluetoothGattCharacteristic;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.ReadCharacterListener;
import java.util.UUID;

public final class gmh extends gmj implements ReadCharacterListener {
    public gmh(UUID uuid, UUID uuid2, gma gma) {
        super(gma);
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
        if (!readCharacteristic(this.O00000o, this.O00000oO)) {
            O00000Oo(-1);
        } else {
            O00000o0();
        }
    }

    public final void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        O00000o();
        if (i == 0) {
            O000000o("key_bytes", bArr);
            O00000Oo(0);
            return;
        }
        O00000Oo(-1);
    }
}
