package com.qti.location.sdk;

public class IZatFeatureNotSupportedException extends RuntimeException {
    public IZatFeatureNotSupportedException() {
    }

    public IZatFeatureNotSupportedException(String str) {
        super(str);
    }

    public IZatFeatureNotSupportedException(String str, Throwable th) {
        super(str, th);
    }
}
