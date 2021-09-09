package com.xiaomi.accountsdk.account.exception;

public class UserRestrictedException extends Exception {
    public UserRestrictedException() {
        super("User has been restricted by server");
    }

    public UserRestrictedException(String str) {
        super(str);
    }
}
