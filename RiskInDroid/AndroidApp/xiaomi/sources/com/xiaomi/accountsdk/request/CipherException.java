package com.xiaomi.accountsdk.request;

public class CipherException extends Exception {
    private static final long serialVersionUID = -1479750857131098427L;

    public CipherException(String str) {
        super(str);
    }

    public CipherException(String str, Throwable th) {
        super(str, th);
    }

    public CipherException(Throwable th) {
        super(th);
    }
}
