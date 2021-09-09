package com.qti.location.sdk;

public class IZatStaleDataException extends RuntimeException {
    public IZatStaleDataException() {
    }

    public IZatStaleDataException(String str) {
        super(str);
    }

    public IZatStaleDataException(String str, Throwable th) {
        super(str, th);
    }
}
