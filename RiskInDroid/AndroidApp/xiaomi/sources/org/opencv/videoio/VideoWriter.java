package org.opencv.videoio;

import org.opencv.core.Mat;
import org.opencv.core.Size;

public class VideoWriter {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final long f15465O000000o;

    private static native long VideoWriter_0(String str, int i, int i2, double d, double d2, double d3, boolean z);

    private static native long VideoWriter_1(String str, int i, int i2, double d, double d2, double d3);

    private static native long VideoWriter_2(String str, int i, double d, double d2, double d3, boolean z);

    private static native long VideoWriter_3(String str, int i, double d, double d2, double d3);

    private static native long VideoWriter_4();

    private static native void delete(long j);

    private static native int fourcc_0(char c, char c2, char c3, char c4);

    private static native String getBackendName_0(long j);

    private static native double get_0(long j, int i);

    private static native boolean isOpened_0(long j);

    private static native boolean open_0(long j, String str, int i, int i2, double d, double d2, double d3, boolean z);

    private static native boolean open_1(long j, String str, int i, int i2, double d, double d2, double d3);

    private static native boolean open_2(long j, String str, int i, double d, double d2, double d3, boolean z);

    private static native boolean open_3(long j, String str, int i, double d, double d2, double d3);

    private static native void release_0(long j);

    private static native boolean set_0(long j, int i, double d);

    private static native void write_0(long j, long j2);

    public VideoWriter(String str, int i, Size size) {
        this.f15465O000000o = VideoWriter_3(str, i, 30.0d, size.width, size.height);
    }

    public VideoWriter() {
        this.f15465O000000o = VideoWriter_4();
    }

    public static int O000000o() {
        return fourcc_0('M', 'J', 'P', 'G');
    }

    public final void O00000Oo() {
        release_0(this.f15465O000000o);
    }

    public final void O000000o(Mat mat) {
        write_0(this.f15465O000000o, mat.nativeObj);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        delete(this.f15465O000000o);
    }
}
