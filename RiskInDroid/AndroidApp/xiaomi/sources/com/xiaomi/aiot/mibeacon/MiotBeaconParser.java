package com.xiaomi.aiot.mibeacon;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.xiaomi.aiot.mibeacon.MiBeacon;
import com.xiaomi.aiot.mibeacon.bluetooth.BleAdvertisement;
import com.xiaomi.aiot.mibeacon.bluetooth.Pdu;
import com.xiaomi.aiot.mibeacon.utils.MacUtils;

public class MiotBeaconParser implements IBeaconParser {
    public MiBeacon fromScanData(byte[] bArr, int i, BluetoothDevice bluetoothDevice) {
        BleAdvertisement bleAdvertisement = new BleAdvertisement(bArr);
        if (bleAdvertisement.getPdus() == null) {
            return null;
        }
        for (Pdu next : bleAdvertisement.getPdus()) {
            if (next.getType() == 22 && new PacketReader(next).getShort() == 65173) {
                Log.i("MiotBeaconParser", "发现miot设备 " + bluetoothDevice.getAddress());
                return new MiBeacon.Builder().bluetoothAddress(bluetoothDevice.getAddress()).bluetoothName(bluetoothDevice.getName()).rssi((double) i).txPower(-59).wifiMac(MacUtils.btMacToWifiMac(bluetoothDevice.getAddress())).build();
            }
        }
        return null;
    }
}
