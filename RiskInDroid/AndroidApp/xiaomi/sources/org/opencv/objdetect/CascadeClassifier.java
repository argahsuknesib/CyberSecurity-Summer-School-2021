package org.opencv.objdetect;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;

public class CascadeClassifier {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final long f15464O000000o;

    private static native long CascadeClassifier_0(String str);

    private static native long CascadeClassifier_1();

    private static native boolean convert_0(String str, String str2);

    private static native void delete(long j);

    private static native void detectMultiScale2_0(long j, long j2, long j3, long j4, double d, int i, int i2, double d2, double d3, double d4, double d5);

    private static native void detectMultiScale2_1(long j, long j2, long j3, long j4, double d, int i, int i2, double d2, double d3);

    private static native void detectMultiScale2_2(long j, long j2, long j3, long j4, double d, int i, int i2);

    private static native void detectMultiScale2_3(long j, long j2, long j3, long j4, double d, int i);

    private static native void detectMultiScale2_4(long j, long j2, long j3, long j4, double d);

    private static native void detectMultiScale2_5(long j, long j2, long j3, long j4);

    private static native void detectMultiScale3_0(long j, long j2, long j3, long j4, long j5, double d, int i, int i2, double d2, double d3, double d4, double d5, boolean z);

    private static native void detectMultiScale3_1(long j, long j2, long j3, long j4, long j5, double d, int i, int i2, double d2, double d3, double d4, double d5);

    private static native void detectMultiScale3_2(long j, long j2, long j3, long j4, long j5, double d, int i, int i2, double d2, double d3);

    private static native void detectMultiScale3_3(long j, long j2, long j3, long j4, long j5, double d, int i, int i2);

    private static native void detectMultiScale3_4(long j, long j2, long j3, long j4, long j5, double d, int i);

    private static native void detectMultiScale3_5(long j, long j2, long j3, long j4, long j5, double d);

    private static native void detectMultiScale3_6(long j, long j2, long j3, long j4, long j5);

    private static native void detectMultiScale_0(long j, long j2, long j3, double d, int i, int i2, double d2, double d3, double d4, double d5);

    private static native void detectMultiScale_1(long j, long j2, long j3, double d, int i, int i2, double d2, double d3);

    private static native void detectMultiScale_2(long j, long j2, long j3, double d, int i, int i2);

    private static native void detectMultiScale_3(long j, long j2, long j3, double d, int i);

    private static native void detectMultiScale_4(long j, long j2, long j3, double d);

    private static native void detectMultiScale_5(long j, long j2, long j3);

    private static native boolean empty_0(long j);

    private static native int getFeatureType_0(long j);

    private static native double[] getOriginalWindowSize_0(long j);

    private static native boolean isOldFormatCascade_0(long j);

    private static native boolean load_0(long j, String str);

    public CascadeClassifier(String str) {
        this.f15464O000000o = CascadeClassifier_0(str);
    }

    public CascadeClassifier() {
        this.f15464O000000o = CascadeClassifier_1();
    }

    public final boolean O000000o() {
        return empty_0(this.f15464O000000o);
    }

    public final void O000000o(Mat mat, MatOfRect matOfRect, double d, int i, Size size, Size size2) {
        Size size3 = size;
        Size size4 = size2;
        long j = this.f15464O000000o;
        long j2 = j;
        detectMultiScale_0(j2, mat.nativeObj, matOfRect.nativeObj, d, i, 2, size3.width, size3.height, size4.width, size4.height);
    }

    public final void O000000o(Mat mat, MatOfRect matOfRect) {
        detectMultiScale_3(this.f15464O000000o, mat.nativeObj, matOfRect.nativeObj, 1.1d, 2);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        delete(this.f15464O000000o);
    }
}
