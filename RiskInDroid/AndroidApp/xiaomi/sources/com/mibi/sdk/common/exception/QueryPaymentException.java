package com.mibi.sdk.common.exception;

import android.os.Bundle;

public class QueryPaymentException extends PaymentException {
    private Bundle mArguments;

    public int getErrorCode() {
        return 0;
    }

    public int getErrorSummaryRes() {
        return 0;
    }

    public String getIdentifier() {
        return null;
    }

    public QueryPaymentException(Bundle bundle) {
        this.mArguments = bundle;
    }

    public void setArguments(Bundle bundle) {
        this.mArguments = bundle;
    }

    public Bundle getArguments() {
        return this.mArguments;
    }
}
