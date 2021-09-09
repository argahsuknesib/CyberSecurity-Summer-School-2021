package com.qti.location.sdk;

public class IZatIllegalArgumentException extends RuntimeException {
    public IZatIllegalArgumentException() {
    }

    public IZatIllegalArgumentException(String str) {
        super(str);
    }

    public IZatIllegalArgumentException(String str, Throwable th) {
        super(str, th);
    }
}
