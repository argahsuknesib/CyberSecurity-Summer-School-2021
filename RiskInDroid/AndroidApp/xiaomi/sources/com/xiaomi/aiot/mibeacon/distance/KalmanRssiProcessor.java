package com.xiaomi.aiot.mibeacon.distance;

public class KalmanRssiProcessor implements RssiProcessor {
    private double kalmanPLast = 1.0d;
    private double lastKalmanRssi = -9999.0d;

    public double calculateRssi(double d) {
        if (this.lastKalmanRssi == -9999.0d) {
            this.lastKalmanRssi = d;
        }
        double process = process(d);
        this.lastKalmanRssi = process;
        return process;
    }

    private double process(double d) {
        double d2 = this.lastKalmanRssi;
        double d3 = this.kalmanPLast + 0.02d;
        double d4 = d3 / (7.0d + d3);
        double d5 = d2 + ((d - d2) * d4);
        this.kalmanPLast = (1.0d - d4) * d3;
        this.lastKalmanRssi = d5;
        return d5;
    }
}
