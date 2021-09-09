package com.xiaomi.accountsdk.account.exception;

public class CryptoException extends Exception {
    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Throwable th) {
        super(str, th);
    }

    public CryptoException(Throwable th) {
        super(th);
    }
}
