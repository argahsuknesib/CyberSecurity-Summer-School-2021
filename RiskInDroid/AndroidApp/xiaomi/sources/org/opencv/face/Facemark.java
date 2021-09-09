package org.opencv.face;

import _m_j.jlo;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfRect;

public class Facemark extends Algorithm {
    private static native void delete(long j);

    private static native boolean fit_0(long j, long j2, long j3, long j4);

    private static native void loadModel_0(long j, String str);

    private Facemark(long j) {
        super(j);
    }

    public static Facemark O000000o(long j) {
        return new Facemark(j);
    }

    public final boolean O000000o(Mat mat, MatOfRect matOfRect, List<MatOfPoint2f> list) {
        Mat mat2 = new Mat();
        boolean fit_0 = fit_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, mat2.nativeObj);
        ArrayList<Mat> arrayList = new ArrayList<>(mat2.rows());
        jlo.O000000o(mat2, arrayList);
        for (Mat mat3 : arrayList) {
            list.add(new MatOfPoint2f(mat3));
            mat3.release();
        }
        arrayList.clear();
        mat2.release();
        return fit_0;
    }

    public final void O000000o(String str) {
        loadModel_0(this.nativeObj, str);
    }

    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
