package com.tencent.wxop.stat;

public class MtaSDkException extends Exception {
    public MtaSDkException() {
    }

    public MtaSDkException(String str) {
        super(str);
    }

    public MtaSDkException(String str, Throwable th) {
        super(str, th);
    }

    public MtaSDkException(Throwable th) {
        super(th);
    }
}
