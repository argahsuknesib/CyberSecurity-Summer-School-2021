package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfFloat6 extends Mat {
    public MatOfFloat6() {
    }

    protected MatOfFloat6(long j) {
        super(j);
        if (!empty() && checkVector(6, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public static MatOfFloat6 fromNativeAddr(long j) {
        return new MatOfFloat6(j);
    }

    public MatOfFloat6(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(6, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfFloat6(float... fArr) {
        fromArray(fArr);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 6));
        }
    }

    public void fromArray(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            alloc(fArr.length / 6);
            put(0, 0, fArr);
        }
    }

    public float[] toArray() {
        int checkVector = checkVector(6, 5);
        if (checkVector >= 0) {
            float[] fArr = new float[(checkVector * 6)];
            if (checkVector == 0) {
                return fArr;
            }
            get(0, 0, fArr);
            return fArr;
        }
        throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
    }

    public void fromList(List<Float> list) {
        if (list != null && list.size() != 0) {
            Float[] fArr = (Float[]) list.toArray(new Float[0]);
            float[] fArr2 = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                fArr2[i] = fArr[i].floatValue();
            }
            fromArray(fArr2);
        }
    }

    public List<Float> toList() {
        float[] array = toArray();
        Float[] fArr = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            fArr[i] = Float.valueOf(array[i]);
        }
        return Arrays.asList(fArr);
    }
}
