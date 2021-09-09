package com.xiaomi.aiot.mibeacon;

import com.xiaomi.aiot.mibeacon.distance.DistanceCalculator;
import com.xiaomi.aiot.mibeacon.distance.DistanceLevelProcesser;
import com.xiaomi.aiot.mibeacon.distance.KalmanRssiProcessor;
import com.xiaomi.aiot.mibeacon.distance.RssiProcessor;
import com.xiaomi.aiot.mibeacon.distance.SimpleDistanceLevelProcesser;

public class MiBeacon {
    private static DistanceCalculator sDistanceCalculator;
    public String mBluetoothAddress = "";
    public String mBluetoothName = "";
    private double mDistance = Double.MAX_VALUE;
    private DistanceLevel mDistanceLevel;
    private DistanceLevelProcesser mDistanceLevelProcessor = new SimpleDistanceLevelProcesser(this);
    private int mPacketCount = 1;
    public double mRssi = Double.MAX_VALUE;
    private RssiProcessor mRssiProcessor = new KalmanRssiProcessor();
    public int mTxPower = Integer.MIN_VALUE;
    public String mWifiMac = "";
    public int pid0;
    public int pid1;
    public int pid2;

    protected MiBeacon() {
    }

    public int getPid0() {
        return this.pid0;
    }

    public int getPid1() {
        return this.pid1;
    }

    public int getPid2() {
        return this.pid2;
    }

    public String getBtMac() {
        return this.mBluetoothAddress;
    }

    public double getRssi() {
        return this.mRssi;
    }

    public String getWifiMac() {
        return this.mWifiMac;
    }

    public double getDistance() {
        return this.mDistance;
    }

    public int getPacketCount() {
        return this.mPacketCount;
    }

    public DistanceLevel getDistanceLevel() {
        return this.mDistanceLevel;
    }

    public void calculateMyDistance() {
        DistanceCalculator distanceCalculator = sDistanceCalculator;
        if (distanceCalculator != null) {
            this.mDistance = distanceCalculator.calculateDistance(this.mTxPower, this.mRssi);
            this.mDistanceLevel = this.mDistanceLevelProcessor.distanceLevel();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("btName[" + this.mBluetoothName + "] ");
        sb.append("btAddress[" + this.mBluetoothAddress + "] ");
        sb.append("packetCount[" + this.mPacketCount + "]");
        sb.append("wifiMac[" + this.mWifiMac + "] ");
        sb.append("rssi[" + String.format("%.2f", Double.valueOf(this.mRssi)) + "]");
        sb.append("txPower[" + this.mTxPower + "]");
        sb.append("distance[" + String.format("%.2f", Double.valueOf(this.mDistance)) + "]");
        sb.append("disLevel[" + this.mDistanceLevel + "]");
        return sb.toString();
    }

    public void addPacket(MiBeacon miBeacon) {
        RssiProcessor rssiProcessor = this.mRssiProcessor;
        if (rssiProcessor != null) {
            this.mRssi = rssiProcessor.calculateRssi(miBeacon.mRssi);
        } else {
            this.mRssi = miBeacon.mRssi;
        }
        this.mPacketCount++;
        calculateMyDistance();
    }

    public static void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        sDistanceCalculator = distanceCalculator;
    }

    public static class Builder {
        private MiBeacon miBeacon = new MiBeacon();

        public MiBeacon build() {
            if (!(this.miBeacon.mTxPower == Integer.MAX_VALUE || Double.compare(this.miBeacon.mRssi, Double.MAX_VALUE) == 0)) {
                this.miBeacon.calculateMyDistance();
            }
            return this.miBeacon;
        }

        public Builder rssi(double d) {
            this.miBeacon.mRssi = d;
            return this;
        }

        public Builder txPower(int i) {
            this.miBeacon.mTxPower = i;
            return this;
        }

        public Builder bluetoothName(String str) {
            this.miBeacon.mBluetoothName = str;
            return this;
        }

        public Builder bluetoothAddress(String str) {
            this.miBeacon.mBluetoothAddress = str;
            return this;
        }

        public Builder wifiMac(String str) {
            this.miBeacon.mWifiMac = str;
            return this;
        }

        public Builder pid0(int i) {
            this.miBeacon.pid0 = i;
            return this;
        }

        public Builder pid1(int i) {
            this.miBeacon.pid1 = i;
            return this;
        }

        public Builder pid2(int i) {
            this.miBeacon.pid2 = i;
            return this;
        }
    }

    public enum DistanceLevel {
        Immediate("Immediate"),
        Near("Near"),
        Far("Far"),
        Unkonwn("Unkonwn");
        
        private String info;

        private DistanceLevel(String str) {
            this.info = str;
        }

        public final String toString() {
            return this.info;
        }
    }
}
