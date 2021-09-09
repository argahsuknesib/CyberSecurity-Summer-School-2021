package com.tutk;

public class CameraException extends Exception {
    int mError;

    public CameraException(int i, String str) {
        super(str);
        this.mError = i;
    }

    public int getError() {
        return this.mError;
    }
}
