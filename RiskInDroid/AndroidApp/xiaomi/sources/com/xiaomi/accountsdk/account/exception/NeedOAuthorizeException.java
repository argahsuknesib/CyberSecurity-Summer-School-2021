package com.xiaomi.accountsdk.account.exception;

public class NeedOAuthorizeException extends Exception {
    private static final long serialVersionUID = 7115909744658066787L;

    public NeedOAuthorizeException() {
    }

    public NeedOAuthorizeException(String str) {
        super(str);
    }
}
