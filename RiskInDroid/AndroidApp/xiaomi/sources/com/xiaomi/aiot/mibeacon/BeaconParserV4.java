package com.xiaomi.aiot.mibeacon;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.aiot.mibeacon.MiBeacon;
import com.xiaomi.aiot.mibeacon.bluetooth.BleAdvertisement;
import com.xiaomi.aiot.mibeacon.bluetooth.Pdu;
import com.xiaomi.aiot.mibeacon.utils.StringUtils;

public class BeaconParserV4 implements IBeaconParser {
    public MiBeacon fromScanData(byte[] bArr, int i, BluetoothDevice bluetoothDevice) {
        MiBeacon miBeacon = null;
        for (Pdu parseMIPdu : new BleAdvertisement(bArr).getPdus()) {
            MiPacket parseMIPdu2 = parseMIPdu(parseMIPdu);
            if (parseMIPdu2 != null) {
                miBeacon = new MiBeacon.Builder().bluetoothAddress(bluetoothDevice.getAddress()).bluetoothName(bluetoothDevice.getName()).rssi((double) i).txPower(parseMIPdu2.txPower).wifiMac(parseMIPdu2.wifiMac).pid0(parseMIPdu2.pid0).pid1(parseMIPdu2.pid1).pid2(parseMIPdu2.pid2).build();
            }
        }
        return miBeacon;
    }

    public MiPacket parseMIPdu(Pdu pdu) {
        int declaredLength;
        MiPacket miPacket = new MiPacket();
        if (pdu.getType() != 255 || (declaredLength = pdu.getDeclaredLength()) < 15 || pdu.getDeclaredLength() - 1 != pdu.getBytes().length) {
            return null;
        }
        int i = declaredLength - 3;
        PacketReader packetReader = new PacketReader(pdu);
        if (packetReader.getByte() != 143 || packetReader.getByte() != 3) {
            return null;
        }
        while (true) {
            int i2 = packetReader.getByte();
            int i3 = i2 + 2;
            if (i < i3) {
                return null;
            }
            int i4 = packetReader.getByte();
            if (i2 == 10 && i4 == 16) {
                miPacket.pid0 = packetReader.getByte();
                miPacket.pid1 = packetReader.getByte();
                miPacket.pid2 = packetReader.getByte();
                String[] strArr = new String[6];
                for (int i5 = 5; i5 >= 0; i5--) {
                    strArr[i5] = String.format("%02x", Integer.valueOf(packetReader.getByte())).toUpperCase();
                }
                miPacket.wifiMac = StringUtils.join(strArr, ":");
                miPacket.txPower = packetReader.getTXPower();
                return miPacket;
            } else if (i <= i3) {
                return null;
            } else {
                for (int i6 = 0; i6 < i2; i6++) {
                    packetReader.getByte();
                }
                i = (i - i2) - 2;
            }
        }
    }

    class MiPacket {
        int pid0;
        int pid1;
        int pid2;
        int txPower;
        String wifiMac;

        MiPacket() {
        }
    }
}
