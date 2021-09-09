package com.xiaomi.accountsdk.account.exception;

public class InvalidParameterException extends AccountException {
    public String paramType;

    public InvalidParameterException(String str) {
        this((String) null, str);
    }

    public InvalidParameterException(String str, String str2) {
        super(-1, str2);
        this.paramType = str;
    }

    public InvalidParameterException(int i, String str) {
        super(i, str);
    }
}
