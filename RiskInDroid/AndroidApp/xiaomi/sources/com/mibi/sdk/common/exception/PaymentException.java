package com.mibi.sdk.common.exception;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.CommonConstants;

public abstract class PaymentException extends Exception {
    private String mFullIdentifier;

    public abstract int getErrorCode();

    public abstract int getErrorSummaryRes();

    public abstract String getIdentifier();

    public PaymentException() {
    }

    public PaymentException(String str) {
        super(str);
    }

    public PaymentException(String str, Throwable th) {
        super(str, th);
    }

    public PaymentException(Throwable th) {
        super(th);
    }

    public String getFullIdentifier() {
        if (TextUtils.isEmpty(this.mFullIdentifier)) {
            String identifier = getIdentifier();
            Throwable cause = getCause();
            if (cause != null && (cause instanceof PaymentException)) {
                identifier = (identifier + "|") + ((PaymentException) cause).getFullIdentifier();
            }
            this.mFullIdentifier = identifier;
        }
        return this.mFullIdentifier;
    }

    public String getErrorSummary(Context context) {
        return context.getString(getErrorSummaryRes());
    }

    public void print() {
        Log.d("PaymentException", "error " + getErrorCode());
        if (CommonConstants.DEBUG) {
            printStackTrace();
        } else {
            printSimpleStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void printSimpleStackTrace() {
        System.err.append((CharSequence) getSimpleStackTrace());
    }

    /* access modifiers changed from: package-private */
    public String getSimpleStackTrace() {
        StringBuilder sb = new StringBuilder();
        for (Throwable th = this; th != null; th = th.getCause()) {
            if (th != this) {
                sb.append("\tCaused by ");
            }
            sb.append(th.toString() + "\n");
        }
        return sb.toString();
    }

    public Throwable getRootCause() {
        Throwable th = null;
        for (Throwable th2 = this; th2 != null; th2 = th2.getCause()) {
            th = th2;
        }
        return th;
    }
}
