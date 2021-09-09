package com.xiaomi.aiot.mibeacon.distance;

import com.xiaomi.aiot.mibeacon.logging.LogManager;

public class CurveFittedDistanceCalculator implements DistanceCalculator {
    private double mCoefficient1;
    private double mCoefficient2;
    private double mCoefficient3;

    public CurveFittedDistanceCalculator(double d, double d2, double d3) {
        this.mCoefficient1 = d;
        this.mCoefficient2 = d2;
        this.mCoefficient3 = d3;
    }

    public double calculateDistance(int i, double d) {
        double d2;
        if (d == 0.0d) {
            return -1.0d;
        }
        LogManager.d("CurveFittedDistanceCalculator", "calculating distance based on mRssi of %s and txPower of %s", Double.valueOf(d), Integer.valueOf(i));
        double d3 = (double) i;
        Double.isNaN(d3);
        double d4 = d / d3;
        if (d4 < 1.0d) {
            d2 = Math.pow(d4, 10.0d);
        } else {
            d2 = this.mCoefficient3 + (this.mCoefficient1 * Math.pow(d4, this.mCoefficient2));
        }
        LogManager.d("CurveFittedDistanceCalculator", "avg mRssi: %s distance: %s", Double.valueOf(d), Double.valueOf(d2));
        return d2;
    }
}
