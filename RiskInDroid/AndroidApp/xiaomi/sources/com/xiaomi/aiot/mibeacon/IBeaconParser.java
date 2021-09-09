package com.xiaomi.aiot.mibeacon;

import android.bluetooth.BluetoothDevice;

public interface IBeaconParser {
    MiBeacon fromScanData(byte[] bArr, int i, BluetoothDevice bluetoothDevice);
}
