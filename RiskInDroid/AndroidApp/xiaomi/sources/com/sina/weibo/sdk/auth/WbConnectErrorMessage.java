package com.sina.weibo.sdk.auth;

public class WbConnectErrorMessage {
    private String errorCode = "8000";
    private String errorMessage = "not install weibo client!!!!!";

    public WbConnectErrorMessage() {
    }

    public WbConnectErrorMessage(String str, String str2) {
        this.errorMessage = str;
        this.errorCode = str2;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }
}
