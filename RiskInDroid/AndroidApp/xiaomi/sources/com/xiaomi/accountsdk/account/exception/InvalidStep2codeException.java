package com.xiaomi.accountsdk.account.exception;

public class InvalidStep2codeException extends Exception {
    public InvalidStep2codeException() {
        super("wrong step2 code");
    }
}
