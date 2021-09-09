package _m_j;

import android.bluetooth.BluetoothGattCharacteristic;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.WriteCharacterListener;
import java.util.UUID;

public final class gmp extends gmj implements WriteCharacterListener {
    public gmp(UUID uuid, UUID uuid2, byte[] bArr, gma gma) {
        super(gma);
        this.O00000o = uuid;
        this.O00000oO = uuid2;
        this.O00000oo = bArr;
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
        if (!writeCharacteristic(this.O00000o, this.O00000oO, this.O00000oo)) {
            O00000Oo(-1);
        } else {
            O00000o0();
        }
    }

    public final void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        O00000o();
        if (i == 0) {
            O00000Oo(0);
        } else {
            O00000Oo(-1);
        }
    }
}
