package com.ximalaya.ting.android.sdkdownloader.exception;

public class BaseRuntimeException extends RuntimeException {
    public BaseRuntimeException() {
    }

    public BaseRuntimeException(String str) {
        super(str);
    }

    public BaseRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    public BaseRuntimeException(Throwable th) {
        super(th);
    }
}
