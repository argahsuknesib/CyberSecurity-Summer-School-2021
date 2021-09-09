package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfInt extends Mat {
    public MatOfInt() {
    }

    protected MatOfInt(long j) {
        super(j);
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public static MatOfInt fromNativeAddr(long j) {
        return new MatOfInt(j);
    }

    public MatOfInt(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfInt(int... iArr) {
        fromArray(iArr);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(4, 1));
        }
    }

    public void fromArray(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            alloc(iArr.length / 1);
            put(0, 0, iArr);
        }
    }

    public int[] toArray() {
        int checkVector = checkVector(1, 4);
        if (checkVector >= 0) {
            int[] iArr = new int[(checkVector * 1)];
            if (checkVector == 0) {
                return iArr;
            }
            get(0, 0, iArr);
            return iArr;
        }
        throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
    }

    public void fromList(List<Integer> list) {
        if (list != null && list.size() != 0) {
            Integer[] numArr = (Integer[]) list.toArray(new Integer[0]);
            int[] iArr = new int[numArr.length];
            for (int i = 0; i < numArr.length; i++) {
                iArr[i] = numArr[i].intValue();
            }
            fromArray(iArr);
        }
    }

    public List<Integer> toList() {
        int[] array = toArray();
        Integer[] numArr = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            numArr[i] = Integer.valueOf(array[i]);
        }
        return Arrays.asList(numArr);
    }
}
