package com.qti.location.sdk;

public class IZatServiceUnavailableException extends RuntimeException {
    public IZatServiceUnavailableException() {
    }

    public IZatServiceUnavailableException(String str) {
        super(str);
    }

    public IZatServiceUnavailableException(String str, Throwable th) {
        super(str, th);
    }
}
