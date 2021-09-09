package com.google.android.gms.common.api;

public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARNING: Illegal instructions before constructor call */
    public ApiException(Status status) {
        super(r3.toString());
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage() != null ? status.getStatusMessage() : "";
        StringBuilder sb = new StringBuilder(String.valueOf(statusMessage).length() + 13);
        sb.append(statusCode);
        sb.append(": ");
        sb.append(statusMessage);
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
