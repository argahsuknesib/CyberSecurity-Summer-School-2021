package com.ximalaya.ting.android.opensdk.auth.exception;

public class XmlyException extends RuntimeException {
    public XmlyException() {
    }

    public XmlyException(String str) {
        super(str);
    }

    public XmlyException(String str, Throwable th) {
        super(str, th);
    }

    public XmlyException(Throwable th) {
        super(th);
    }
}
