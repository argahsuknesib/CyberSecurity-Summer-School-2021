package com.xiaomi.passport.snscorelib.internal.exception;

import com.xiaomi.accountsdk.account.ServerError;

public class SNSLoginException extends Exception {
    private int code = -1;
    private ServerError serverError = null;

    public SNSLoginException(int i, String str) {
        super(str);
        this.code = i;
    }

    public SNSLoginException(int i, String str, ServerError serverError2) {
        super(str);
        this.code = i;
        this.serverError = serverError2;
    }

    public int getCode() {
        return this.code;
    }

    public ServerError getServerError() {
        return this.serverError;
    }
}
