package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class AccountException extends PaymentException {
    public int getErrorCode() {
        return 5;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_auth_summary;
    }

    public String getIdentifier() {
        return "AT";
    }

    public AccountException() {
    }

    public AccountException(Throwable th) {
        super(th);
    }

    public AccountException(String str) {
        super(str);
    }
}
