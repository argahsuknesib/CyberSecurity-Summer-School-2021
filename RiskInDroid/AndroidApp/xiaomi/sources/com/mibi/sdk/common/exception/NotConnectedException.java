package com.mibi.sdk.common.exception;

public class NotConnectedException extends NetworkException {
    public String getIdentifier() {
        return "NC";
    }

    public NotConnectedException() {
    }

    public NotConnectedException(Throwable th) {
        super(th);
    }

    public NotConnectedException(String str) {
        super(str);
    }

    public NotConnectedException(String str, Throwable th) {
        super(str, th);
    }
}
