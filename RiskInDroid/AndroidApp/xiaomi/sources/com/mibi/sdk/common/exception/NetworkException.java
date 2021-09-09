package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class NetworkException extends PaymentException {
    public int getErrorCode() {
        return 3;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_network_summary;
    }

    public String getIdentifier() {
        return "NT";
    }

    public NetworkException() {
    }

    public NetworkException(Throwable th) {
        super(th);
    }

    public NetworkException(String str) {
        super(str);
    }

    public NetworkException(String str, Throwable th) {
        super(str, th);
    }
}
