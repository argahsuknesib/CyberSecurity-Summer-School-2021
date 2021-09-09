package com.miui.tsmclientsdk;

public class UnSupportedException extends Exception {
    public UnSupportedException() {
    }

    public UnSupportedException(String str) {
        super(str);
    }

    public UnSupportedException(String str, Throwable th) {
        super(str, th);
    }

    public UnSupportedException(Throwable th) {
        super(th);
    }
}
