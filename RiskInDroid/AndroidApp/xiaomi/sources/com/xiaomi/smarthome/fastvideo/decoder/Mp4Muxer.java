package com.xiaomi.smarthome.fastvideo.decoder;

class Mp4Muxer {
    private long nativeId = 0;

    private static native void nativeInit();

    public native int closeFile();

    public native int initMuxer(String str, int i, int i2, int i3, int i4, int i5);

    public native int writeAudio(byte[] bArr, int i);

    public native int writeAudioWithPts(byte[] bArr, int i, long j);

    public native int writeVideo(byte[] bArr, int i, int i2, boolean z);

    public native int writeVideoWithPts(byte[] bArr, int i, long j, boolean z);

    static {
        System.loadLibrary("ijkffmpeg");
        System.loadLibrary("h264decoderhome");
        nativeInit();
    }

    Mp4Muxer() {
    }
}
