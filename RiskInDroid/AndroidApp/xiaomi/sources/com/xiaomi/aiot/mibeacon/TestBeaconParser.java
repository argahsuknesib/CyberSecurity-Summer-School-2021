package com.xiaomi.aiot.mibeacon;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.xiaomi.aiot.mibeacon.MiBeacon;
import com.xiaomi.aiot.mibeacon.utils.MacUtils;

public class TestBeaconParser implements IBeaconParser {
    String[] supportMac;

    public TestBeaconParser(String[] strArr) {
        this.supportMac = strArr;
    }

    public MiBeacon fromScanData(byte[] bArr, int i, BluetoothDevice bluetoothDevice) {
        if (!isDeviceHit(bluetoothDevice)) {
            return null;
        }
        return new MiBeacon.Builder().bluetoothAddress(bluetoothDevice.getAddress()).bluetoothName(bluetoothDevice.getName()).rssi((double) i).txPower(-59).wifiMac(MacUtils.btMacToWifiMac(bluetoothDevice.getAddress())).build();
    }

    private boolean isDeviceHit(BluetoothDevice bluetoothDevice) {
        String address = bluetoothDevice.getAddress();
        for (String equals : this.supportMac) {
            if (TextUtils.equals(equals, address)) {
                return true;
            }
        }
        return false;
    }
}
