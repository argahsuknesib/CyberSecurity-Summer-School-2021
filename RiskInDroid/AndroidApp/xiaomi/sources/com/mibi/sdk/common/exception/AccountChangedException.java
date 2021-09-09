package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class AccountChangedException extends AccountException {
    public int getErrorCode() {
        return 10;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_account_changed_summary;
    }

    public String getIdentifier() {
        return "AC";
    }
}
