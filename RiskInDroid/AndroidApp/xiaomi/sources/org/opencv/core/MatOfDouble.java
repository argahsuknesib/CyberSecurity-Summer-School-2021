package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfDouble extends Mat {
    public MatOfDouble() {
    }

    protected MatOfDouble(long j) {
        super(j);
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public static MatOfDouble fromNativeAddr(long j) {
        return new MatOfDouble(j);
    }

    public MatOfDouble(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfDouble(double... dArr) {
        fromArray(dArr);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(6, 1));
        }
    }

    public void fromArray(double... dArr) {
        if (dArr != null && dArr.length != 0) {
            alloc(dArr.length / 1);
            put(0, 0, dArr);
        }
    }

    public double[] toArray() {
        int checkVector = checkVector(1, 6);
        if (checkVector >= 0) {
            double[] dArr = new double[(checkVector * 1)];
            if (checkVector == 0) {
                return dArr;
            }
            get(0, 0, dArr);
            return dArr;
        }
        throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
    }

    public void fromList(List<Double> list) {
        if (list != null && list.size() != 0) {
            Double[] dArr = (Double[]) list.toArray(new Double[0]);
            double[] dArr2 = new double[dArr.length];
            for (int i = 0; i < dArr.length; i++) {
                dArr2[i] = dArr[i].doubleValue();
            }
            fromArray(dArr2);
        }
    }

    public List<Double> toList() {
        double[] array = toArray();
        Double[] dArr = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            dArr[i] = Double.valueOf(array[i]);
        }
        return Arrays.asList(dArr);
    }
}
