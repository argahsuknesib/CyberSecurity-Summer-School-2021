package com.xiaomi.smarthome.camera;

public interface XmAAcCodec {
    int decode(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    byte[] encode(byte[] bArr, int i, int i2);

    int getOneFrameSamplesCount();

    void release();
}
