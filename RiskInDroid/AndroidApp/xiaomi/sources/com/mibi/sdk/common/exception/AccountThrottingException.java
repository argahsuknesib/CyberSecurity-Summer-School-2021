package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class AccountThrottingException extends AccountException {
    public int getErrorCode() {
        return 15;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_account_throtting;
    }
}
