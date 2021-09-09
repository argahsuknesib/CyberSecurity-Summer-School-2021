package com.polidea.rxandroidble.exceptions;

import android.bluetooth.BluetoothGattCharacteristic;

public class BleCannotSetCharacteristicNotificationException extends BleException {
    private final BluetoothGattCharacteristic bluetoothGattCharacteristic;

    public BleCannotSetCharacteristicNotificationException(BluetoothGattCharacteristic bluetoothGattCharacteristic2) {
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
    }

    public BluetoothGattCharacteristic getBluetoothGattCharacteristic() {
        return this.bluetoothGattCharacteristic;
    }

    public String toString() {
        return "BleCannotSetCharacteristicNotificationException{bluetoothGattCharacteristic=" + this.bluetoothGattCharacteristic.getUuid() + '}';
    }
}
