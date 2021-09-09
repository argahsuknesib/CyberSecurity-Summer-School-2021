package com.xiaomi.smarthome.library.bluetooth.connect.listener;

import android.bluetooth.BluetoothGattCharacteristic;

public interface WriteCharacterListener extends GattResponseListener {
    void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr);
}
