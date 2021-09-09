package com.xiaomi.aiot.mibeacon;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.aiot.mibeacon.MiBeacon;
import com.xiaomi.aiot.mibeacon.bluetooth.BleAdvertisement;
import com.xiaomi.aiot.mibeacon.bluetooth.Pdu;
import com.xiaomi.aiot.mibeacon.utils.StringUtils;

public class BeaconParserV3 implements IBeaconParser {
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

    private MiPacket parseMIPdu(Pdu pdu) {
        MiPacket miPacket = new MiPacket();
        if (pdu.getType() != 255 || pdu.getDeclaredLength() != 15) {
            return null;
        }
        PacketReader packetReader = new PacketReader(pdu);
        if (packetReader.getByte() != 143 || packetReader.getByte() != 3 || packetReader.getByte() != 10 || packetReader.getByte() != 16) {
            return null;
        }
        miPacket.pid0 = packetReader.getByte();
        miPacket.pid1 = packetReader.getByte();
        miPacket.pid2 = packetReader.getByte();
        String[] strArr = new String[6];
        for (int i = 5; i >= 0; i--) {
            strArr[i] = String.format("%02x", Integer.valueOf(packetReader.getByte())).toUpperCase();
        }
        miPacket.wifiMac = StringUtils.join(strArr, ":");
        miPacket.txPower = packetReader.getTXPower();
        return miPacket;
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
