package com.xiaomi.smarthome.framework.plugin.mpk;

public interface FrameSender {
    void closeCameraFrame(String str);

    void initCameraFrame(String str);

    void sendCameraFrame(String str, byte[] bArr, long j, int i, long j2, int i2, boolean z, int i3, int i4);
}
