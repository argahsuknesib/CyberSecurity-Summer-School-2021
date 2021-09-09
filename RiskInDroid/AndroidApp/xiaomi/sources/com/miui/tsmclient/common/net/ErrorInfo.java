package com.miui.tsmclient.common.net;

public class ErrorInfo {
    public static final ErrorInfo DEFAULT_ERROR_INFO = new ErrorInfo(-1, null);
    public final int mErrorCode;
    public final String mErrorDesc;

    public ErrorInfo(int i, String str) {
        this.mErrorCode = i;
        this.mErrorDesc = str;
    }

    public String toString() {
        return "errorCode:" + this.mErrorCode + ", errorDesc:" + this.mErrorDesc;
    }
}
