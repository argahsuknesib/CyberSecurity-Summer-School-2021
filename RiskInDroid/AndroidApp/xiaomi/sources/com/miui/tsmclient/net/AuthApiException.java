package com.miui.tsmclient.net;

public class AuthApiException extends Exception {
    public int mErrorCode;
    public String mErrorMsg;

    public AuthApiException() {
    }

    public AuthApiException(int i) {
        this.mErrorCode = i;
    }

    public AuthApiException(int i, String str) {
        this.mErrorCode = i;
        this.mErrorMsg = str;
    }
}
