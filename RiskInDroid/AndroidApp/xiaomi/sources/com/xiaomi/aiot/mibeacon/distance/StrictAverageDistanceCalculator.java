package com.xiaomi.aiot.mibeacon.distance;

import com.xiaomi.aiot.mibeacon.logging.LogManager;
import java.util.ArrayList;
import java.util.List;

public class StrictAverageDistanceCalculator implements DistanceCalculator {
    private DistanceCalculator calculator;
    private int effectiveSampleCount;
    private int maxRssiIndex = 0;
    private int minRssiIndex = 0;
    private List<Double> sampleRssi;

    public StrictAverageDistanceCalculator(int i, DistanceCalculator distanceCalculator) {
        this.effectiveSampleCount = i;
        this.sampleRssi = new ArrayList(this.effectiveSampleCount);
        this.calculator = distanceCalculator;
    }

    public double calculateDistance(int i, double d) {
        addRssi(d);
        logCurState();
        if (this.sampleRssi.size() < this.effectiveSampleCount) {
            LogManager.d("StrictCalculator", "当前采样量不足,返回200", new Object[0]);
            this.sampleRssi.add(Double.valueOf(d));
            return 200.0d;
        }
        return this.calculator.calculateDistance(i, generateAverage());
    }

    private void logCurState() {
        StringBuilder sb = new StringBuilder();
        sb.append("all data: ");
        for (Double doubleValue : this.sampleRssi) {
            sb.append(doubleValue.doubleValue());
            sb.append(" ");
        }
        sb.append("maxIndex[");
        sb.append(this.maxRssiIndex);
        sb.append("]");
        sb.append(" minIndex[");
        sb.append(this.minRssiIndex);
        sb.append("]");
        LogManager.d("StrictCalculator", sb.toString(), new Object[0]);
    }

    private void addRssi(double d) {
        if (this.sampleRssi.size() < this.effectiveSampleCount) {
            this.sampleRssi.add(Double.valueOf(d));
            if (this.sampleRssi.get(this.maxRssiIndex).doubleValue() < d) {
                this.maxRssiIndex = this.sampleRssi.size() - 1;
            }
            if (this.sampleRssi.get(this.minRssiIndex).doubleValue() > d) {
                this.minRssiIndex = this.sampleRssi.size() - 1;
                return;
            }
            return;
        }
        this.sampleRssi.remove(0);
        this.sampleRssi.add(Double.valueOf(d));
        findMaxIndex();
        findMinIndex();
    }

    private void findMaxIndex() {
        int i = 0;
        int i2 = 0;
        for (Double doubleValue : this.sampleRssi) {
            if (this.sampleRssi.get(i).doubleValue() < doubleValue.doubleValue()) {
                i = i2;
            }
            i2++;
        }
        this.maxRssiIndex = i;
    }

    private void findMinIndex() {
        int i = 0;
        int i2 = 0;
        for (Double doubleValue : this.sampleRssi) {
            if (this.sampleRssi.get(i).doubleValue() > doubleValue.doubleValue()) {
                i = i2;
            }
            i2++;
        }
        this.minRssiIndex = i;
    }

    private void removeMaxAndMinRssi() {
        this.sampleRssi.get(0).doubleValue();
        this.sampleRssi.get(0).doubleValue();
        for (Double doubleValue : this.sampleRssi) {
            doubleValue.doubleValue();
        }
        this.sampleRssi.remove(0);
        this.sampleRssi.remove(0);
    }

    private double generateAverage() {
        double d = 0.0d;
        int i = -1;
        for (Double doubleValue : this.sampleRssi) {
            double doubleValue2 = doubleValue.doubleValue();
            i++;
            if (!(i == this.maxRssiIndex || i == this.minRssiIndex)) {
                d += doubleValue2;
            }
        }
        double size = (double) (this.sampleRssi.size() - 2);
        Double.isNaN(size);
        return d / size;
    }
}
