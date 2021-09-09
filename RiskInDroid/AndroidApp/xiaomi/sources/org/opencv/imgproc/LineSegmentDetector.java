package org.opencv.imgproc;

import org.opencv.core.Algorithm;

public class LineSegmentDetector extends Algorithm {
    private static native int compareSegments_0(long j, double d, double d2, long j2, long j3, long j4);

    private static native int compareSegments_1(long j, double d, double d2, long j2, long j3);

    private static native void delete(long j);

    private static native void detect_0(long j, long j2, long j3, long j4, long j5, long j6);

    private static native void detect_1(long j, long j2, long j3, long j4, long j5);

    private static native void detect_2(long j, long j2, long j3, long j4);

    private static native void detect_3(long j, long j2, long j3);

    private static native void drawSegments_0(long j, long j2, long j3);

    private LineSegmentDetector(long j) {
        super(j);
    }

    public static LineSegmentDetector O000000o(long j) {
        return new LineSegmentDetector(j);
    }

    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
