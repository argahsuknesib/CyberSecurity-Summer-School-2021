package com.xiaomi.aiot.mibeacon.distance;

import com.xiaomi.aiot.mibeacon.MiBeacon;

public class SimpleDistanceLevelProcesser implements DistanceLevelProcesser {
    private MiBeacon mDevice;

    public SimpleDistanceLevelProcesser(MiBeacon miBeacon) {
        if (miBeacon != null) {
            this.mDevice = miBeacon;
            return;
        }
        throw new NullPointerException("MiBeacon must not be null.");
    }

    public void setProcessDevice(MiBeacon miBeacon) {
        if (miBeacon != null) {
            this.mDevice = miBeacon;
            return;
        }
        throw new NullPointerException("MiBeacon must not be null.");
    }

    public MiBeacon.DistanceLevel distanceLevel() {
        if (this.mDevice.getDistance() <= 0.2d) {
            return MiBeacon.DistanceLevel.Immediate;
        }
        if (this.mDevice.getDistance() <= 1.0d) {
            return MiBeacon.DistanceLevel.Near;
        }
        if (this.mDevice.getDistance() <= 5.0d) {
            return MiBeacon.DistanceLevel.Far;
        }
        return MiBeacon.DistanceLevel.Unkonwn;
    }
}
