package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class IllegalDeviceException extends PaymentException {
    public int getErrorCode() {
        return 5;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_invalid_device;
    }

    public String getIdentifier() {
        return "ID";
    }

    public IllegalDeviceException() {
    }

    public IllegalDeviceException(Throwable th) {
        super(th);
    }

    public IllegalDeviceException(String str) {
        super(str);
    }
}
