package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfRotatedRect extends Mat {
    public MatOfRotatedRect() {
    }

    protected MatOfRotatedRect(long j) {
        super(j);
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public static MatOfRotatedRect fromNativeAddr(long j) {
        return new MatOfRotatedRect(j);
    }

    public MatOfRotatedRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRotatedRect(RotatedRect... rotatedRectArr) {
        fromArray(rotatedRectArr);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 5));
        }
    }

    public void fromArray(RotatedRect... rotatedRectArr) {
        if (rotatedRectArr != null && rotatedRectArr.length != 0) {
            int length = rotatedRectArr.length;
            alloc(length);
            float[] fArr = new float[(length * 5)];
            for (int i = 0; i < length; i++) {
                RotatedRect rotatedRect = rotatedRectArr[i];
                int i2 = i * 5;
                fArr[i2 + 0] = (float) rotatedRect.center.x;
                fArr[i2 + 1] = (float) rotatedRect.center.y;
                fArr[i2 + 2] = (float) rotatedRect.size.width;
                fArr[i2 + 3] = (float) rotatedRect.size.height;
                fArr[i2 + 4] = (float) rotatedRect.angle;
            }
            put(0, 0, fArr);
        }
    }

    public RotatedRect[] toArray() {
        int i = (int) total();
        RotatedRect[] rotatedRectArr = new RotatedRect[i];
        if (i == 0) {
            return rotatedRectArr;
        }
        float[] fArr = new float[5];
        for (int i2 = 0; i2 < i; i2++) {
            get(i2, 0, fArr);
            rotatedRectArr[i2] = new RotatedRect(new Point((double) fArr[0], (double) fArr[1]), new Size((double) fArr[2], (double) fArr[3]), (double) fArr[4]);
        }
        return rotatedRectArr;
    }

    public void fromList(List<RotatedRect> list) {
        fromArray((RotatedRect[]) list.toArray(new RotatedRect[0]));
    }

    public List<RotatedRect> toList() {
        return Arrays.asList(toArray());
    }
}
