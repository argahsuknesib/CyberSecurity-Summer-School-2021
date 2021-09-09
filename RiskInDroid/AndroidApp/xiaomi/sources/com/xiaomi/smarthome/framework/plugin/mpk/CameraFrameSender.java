package com.xiaomi.smarthome.framework.plugin.mpk;

public class CameraFrameSender {
    private static CameraFrameSender _instance;
    private FrameSender sender = new LocalSocketSender();

    public static CameraFrameSender instance() {
        if (_instance == null) {
            _instance = new CameraFrameSender();
        }
        return _instance;
    }

    private CameraFrameSender() {
    }

    public void initCameraFrame(String str) {
        this.sender.initCameraFrame(str);
    }

    public void sendCameraFrame(String str, byte[] bArr, long j, int i, long j2, boolean z, int i2, int i3) {
        this.sender.sendCameraFrame(str, bArr, j, i, j2, 1, z, i2, i3);
    }

    public void sendCameraFrame(String str, byte[] bArr, long j, int i, long j2, int i2, boolean z, int i3, int i4) {
        this.sender.sendCameraFrame(str, bArr, j, i, j2, i2, z, i3, i4);
    }

    public void closeCameraFrame(String str) {
        this.sender.closeCameraFrame(str);
    }
}
