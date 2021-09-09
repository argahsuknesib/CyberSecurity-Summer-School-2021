package com.ximalaya.ting.android.sdkdownloader.exception;

import android.text.TextUtils;

public class HttpException extends BaseException {
    private static final long serialVersionUID = 1;
    private int code;
    private String customMessage;
    private String errorCode;
    private String result;

    public HttpException(int i, String str) {
        super(str);
        this.code = i;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.customMessage = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrorCode() {
        String str = this.errorCode;
        return str == null ? String.valueOf(this.code) : str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getMessage() {
        if (!TextUtils.isEmpty(this.customMessage)) {
            return this.customMessage;
        }
        return super.getMessage();
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public String toString() {
        return "errorCode: " + getErrorCode() + ", msg: " + getMessage() + ", result: " + this.result;
    }
}
