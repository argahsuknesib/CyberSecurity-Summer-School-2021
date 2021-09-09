package com.ximalaya.ting.android.opensdk.httputil;

import java.util.HashMap;
import java.util.Map;

public class XimalayaException extends Exception {
    public static final Map<Integer, String> ERR_MESSAGE_MAP = new HashMap<Integer, String>() {
        /* class com.ximalaya.ting.android.opensdk.httputil.XimalayaException.AnonymousClass1 */

        {
            put(1001, "request url is empty");
            put(1002, "exception occurs when caculate signature");
            put(1003, "Form encoded body must have at least one part");
            put(1004, "you must call #XiMaLaYa.init");
            put(1005, "get appkey error from AndroidManifest.xml metaData");
            put(1009, "parse data error");
            put(1010, "get accesstoken fail");
            put(1012, "request url parse error");
            put(1013, "token invalid");
            put(1014, "login need");
            put(1011, "http error");
            put(1015, "create dh ke error");
            put(1016, "create dh request fail");
        }
    };
    private int mErrorCode;
    private String mErrorMessage;

    public XimalayaException(int i, String str) {
        this.mErrorCode = i;
        this.mErrorMessage = str;
    }

    public static final XimalayaException getExceptionByCode(int i) {
        return new XimalayaException(i, ERR_MESSAGE_MAP.get(Integer.valueOf(i)));
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }
}
