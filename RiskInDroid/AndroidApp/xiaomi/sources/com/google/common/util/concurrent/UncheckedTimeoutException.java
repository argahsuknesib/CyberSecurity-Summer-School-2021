package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(String str) {
        super(str);
    }

    public UncheckedTimeoutException(Throwable th) {
        super(th);
    }

    public UncheckedTimeoutException(String str, Throwable th) {
        super(str, th);
    }
}
