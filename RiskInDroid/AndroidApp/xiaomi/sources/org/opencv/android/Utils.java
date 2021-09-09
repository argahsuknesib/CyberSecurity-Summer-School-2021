package org.opencv.android;

import android.graphics.Bitmap;
import org.opencv.core.Mat;

public class Utils {
    private static native void nBitmapToMat2(Bitmap bitmap, long j, boolean z);

    private static native void nMatToBitmap2(long j, Bitmap bitmap, boolean z);

    public static void O000000o(Bitmap bitmap, Mat mat) {
        if (bitmap != null) {
            nBitmapToMat2(bitmap, mat.nativeObj, false);
            return;
        }
        throw new IllegalArgumentException("bmp == null");
    }

    public static void O000000o(Mat mat, Bitmap bitmap) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        } else if (bitmap != null) {
            nMatToBitmap2(mat.nativeObj, bitmap, false);
        } else {
            throw new IllegalArgumentException("bmp == null");
        }
    }
}
