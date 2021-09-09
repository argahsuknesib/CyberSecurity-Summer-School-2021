package com.xiaomi.zxing;

public final class WriterException extends Exception {
    public WriterException() {
    }

    public WriterException(String str) {
        super(str);
    }

    public WriterException(Throwable th) {
        super(th);
    }
}
