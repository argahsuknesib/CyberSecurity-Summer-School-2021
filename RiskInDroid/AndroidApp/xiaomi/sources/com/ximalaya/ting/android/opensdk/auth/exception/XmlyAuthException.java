package com.ximalaya.ting.android.opensdk.auth.exception;

public class XmlyAuthException extends XmlyException {
    private String mErrorCode;
    private String mErrorDesc;

    public XmlyAuthException(String str, String str2, String str3) {
        super(str);
        this.mErrorCode = str2;
        this.mErrorDesc = str3;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDesc() {
        return this.mErrorDesc;
    }
}
