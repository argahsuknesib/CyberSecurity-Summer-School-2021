package com.xiaomi.smarthome.fastvideo.decoder;

public class Mp4Read {
    private long nativeId = 0;

    private native void init();

    private static native void nativeInit();

    public native int closeFile();

    public native int getVideoFrame(byte[] bArr, int[] iArr, int[] iArr2, int[] iArr3);

    public native int openFile(String str, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7);

    static {
        System.loadLibrary("ijkffmpeg");
        System.loadLibrary("h264decoderhome");
        nativeInit();
    }

    public Mp4Read() {
        init();
    }
}
