package _m_j;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

public final class bjy extends BluetoothGattCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    private bix f13014O000000o;

    public bjy(bix bix) {
        this.f13014O000000o = bix;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f13014O000000o.O000000o(i, i2);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        this.f13014O000000o.O000000o(i);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f13014O000000o.O000000o(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f13014O000000o.O00000Oo(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f13014O000000o.O000000o(bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.f13014O000000o.O000000o(bluetoothGattDescriptor, i);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.f13014O000000o.O000000o(bluetoothGattDescriptor, i, bluetoothGattDescriptor.getValue());
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f13014O000000o.O00000Oo(i, i2);
    }
}
