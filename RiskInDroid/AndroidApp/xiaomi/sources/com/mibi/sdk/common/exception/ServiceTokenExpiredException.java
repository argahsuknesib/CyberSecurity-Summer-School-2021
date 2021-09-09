package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class ServiceTokenExpiredException extends PaymentException {
    public int getErrorCode() {
        return 6;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_server_summary;
    }

    public String getIdentifier() {
        return "ST";
    }
}
