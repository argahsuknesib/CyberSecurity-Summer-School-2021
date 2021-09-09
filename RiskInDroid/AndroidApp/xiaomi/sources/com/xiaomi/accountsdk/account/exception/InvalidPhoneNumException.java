package com.xiaomi.accountsdk.account.exception;

public class InvalidPhoneNumException extends AccountException {
    public InvalidPhoneNumException(String str) {
        super(70008, str);
    }
}
