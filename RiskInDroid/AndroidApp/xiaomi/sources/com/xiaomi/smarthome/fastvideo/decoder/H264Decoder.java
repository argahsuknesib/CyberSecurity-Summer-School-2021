package com.xiaomi.smarthome.fastvideo.decoder;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public class H264Decoder {
    private long nativeId = 0;
    private long videoType = 0;

    public static native int decodeIFrame(byte[] bArr, int i, int i2, int i3, int i4, Bitmap bitmap);

    private native void init(int i, boolean z);

    private static native void nativeInit();

    public native boolean decode(byte[] bArr, int i, long j);

    public native boolean decodeBuffer(ByteBuffer byteBuffer, int i, long j);

    public native int getHeight();

    public native int getWidth();

    public native void release();

    public native int toBitmap(int i, int i2, int i3);

    public native int toBitmap(Bitmap bitmap);

    public native int toTexture(int i, int i2, int i3);

    public native int toYUV(byte[] bArr);

    static {
        System.loadLibrary("ijkffmpeg");
        System.loadLibrary("h264decoderhome");
        nativeInit();
    }

    public H264Decoder() {
        init(1, true);
    }

    public H264Decoder(int i) {
        init(i, true);
    }

    public H264Decoder(int i, boolean z) {
        init(i, z);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        release();
    }
}
