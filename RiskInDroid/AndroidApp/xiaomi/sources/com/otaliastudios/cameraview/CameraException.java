package com.otaliastudios.cameraview;

public class CameraException extends RuntimeException {
    private int reason = 0;

    public CameraException(Throwable th, int i) {
        super(th);
        this.reason = i;
    }

    public int getReason() {
        return this.reason;
    }
}
