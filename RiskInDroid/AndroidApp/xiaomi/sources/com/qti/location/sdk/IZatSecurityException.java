package com.qti.location.sdk;

public class IZatSecurityException extends RuntimeException {
    public IZatSecurityException() {
    }

    public IZatSecurityException(String str) {
        super(str);
    }

    public IZatSecurityException(String str, Throwable th) {
        super(str, th);
    }
}
