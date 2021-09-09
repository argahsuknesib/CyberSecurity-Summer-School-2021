package com.miui.tsmclient.sesdk;

public class NotSupportedException extends RuntimeException {
    public NotSupportedException() {
    }

    public NotSupportedException(String str) {
        super(str);
    }

    public NotSupportedException(String str, Throwable th) {
        super(str, th);
    }

    public NotSupportedException(Throwable th) {
        super(th);
    }
}
