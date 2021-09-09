package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;

public class CertificateDateNotValidException extends NetworkException {
    private Type mType;

    public enum Type {
        NOT_YET_VALID,
        EXPIRED
    }

    public int getErrorCode() {
        return 3;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_cert_date_summary;
    }

    public String getIdentifier() {
        return "CT";
    }

    public CertificateDateNotValidException(Type type, Throwable th) {
        super(th);
        this.mType = type;
    }

    public Type getType() {
        return this.mType;
    }
}
