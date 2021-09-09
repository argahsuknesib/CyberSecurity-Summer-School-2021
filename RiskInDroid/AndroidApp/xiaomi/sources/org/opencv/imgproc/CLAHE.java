package org.opencv.imgproc;

import org.opencv.core.Algorithm;

public class CLAHE extends Algorithm {
    private static native void apply_0(long j, long j2, long j3);

    private static native void collectGarbage_0(long j);

    private static native void delete(long j);

    private static native double getClipLimit_0(long j);

    private static native double[] getTilesGridSize_0(long j);

    private static native void setClipLimit_0(long j, double d);

    private static native void setTilesGridSize_0(long j, double d, double d2);

    private CLAHE(long j) {
        super(j);
    }

    public static CLAHE O000000o(long j) {
        return new CLAHE(j);
    }

    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
