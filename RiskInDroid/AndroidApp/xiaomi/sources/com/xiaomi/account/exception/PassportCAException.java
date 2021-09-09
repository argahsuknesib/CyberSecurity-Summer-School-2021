package com.xiaomi.account.exception;

public class PassportCAException extends Exception {
    public PassportCAException(Throwable th) {
        super(th);
    }

    public PassportCAException(String str) {
        super(str);
    }
}
