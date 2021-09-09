package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class PasswordErrorException extends AccountException {
    public int getErrorCode() {
        return 3;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_password_error;
    }

    public String getIdentifier() {
        return "PW";
    }

    public PasswordErrorException() {
    }

    public PasswordErrorException(Throwable th) {
        super(th);
    }

    public PasswordErrorException(String str) {
        super(str);
    }
}
