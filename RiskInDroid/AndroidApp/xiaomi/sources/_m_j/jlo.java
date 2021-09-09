package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;

public final class jlo {
    public static Mat O000000o(List<Mat> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32SC2);
        int[] iArr = new int[(size * 2)];
        for (int i = 0; i < size; i++) {
            long j = list.get(i).nativeObj;
            int i2 = i * 2;
            iArr[i2] = (int) (j >> 32);
            iArr[i2 + 1] = (int) (j & -1);
        }
        mat.put(0, 0, iArr);
        return mat;
    }

    public static void O000000o(Mat mat, List<Mat> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_32SC2 == mat.type() && mat.cols() == 1) {
                list.clear();
                int[] iArr = new int[(rows * 2)];
                mat.get(0, 0, iArr);
                for (int i = 0; i < rows; i++) {
                    int i2 = i * 2;
                    list.add(new Mat((((long) iArr[i2]) << 32) | (((long) iArr[i2 + 1]) & 4294967295L)));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_32SC2 != m.type() ||  m.cols()!=1\n".concat(String.valueOf(mat)));
        }
        throw new IllegalArgumentException("mats == null");
    }

    public static Mat O000000o(List<MatOfPoint> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        for (MatOfPoint add : list) {
            list2.add(add);
        }
        return O000000o(list2);
    }

    public static void O00000Oo(Mat mat, List<MatOfPoint> list) {
        if (list != null) {
            ArrayList<Mat> arrayList = new ArrayList<>(mat.rows());
            O000000o(mat, arrayList);
            for (Mat mat2 : arrayList) {
                list.add(new MatOfPoint(mat2));
                mat2.release();
            }
            arrayList.clear();
            return;
        }
        throw new IllegalArgumentException("Output List can't be null");
    }
}
