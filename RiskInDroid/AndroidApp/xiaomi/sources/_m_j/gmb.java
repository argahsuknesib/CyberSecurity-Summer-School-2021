package _m_j;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.xiaomi.smarthome.library.bluetooth.connect.IBluetoothGattResponse;

public final class gmb extends BluetoothGattCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    private IBluetoothGattResponse f18011O000000o;

    public gmb(IBluetoothGattResponse iBluetoothGattResponse) {
        this.f18011O000000o = iBluetoothGattResponse;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f18011O000000o.onConnectionStateChange(i, i2);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        this.f18011O000000o.onServicesDiscovered(i);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f18011O000000o.onCharacteristicRead(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f18011O000000o.onCharacteristicWrite(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f18011O000000o.onCharacteristicChanged(bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.f18011O000000o.onDescriptorWrite(bluetoothGattDescriptor, i);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f18011O000000o.onReadRemoteRssi(i, i2);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f18011O000000o.onMtuChanged(i, i2);
    }
}
