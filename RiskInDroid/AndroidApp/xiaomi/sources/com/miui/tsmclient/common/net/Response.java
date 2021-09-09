package com.miui.tsmclient.common.net;

public class Response<T> {
    private ErrorInfo mErrorInfo;
    private T mResult;

    public static <T> Response<T> success(T t) {
        return new Response<>(t, new ErrorInfo(200, null));
    }

    public static <T> Response<T> error(int i, String str) {
        return new Response<>(null, new ErrorInfo(i, str));
    }

    public boolean isSuccess() {
        return this.mErrorInfo.mErrorCode == 200;
    }

    private Response(T t, ErrorInfo errorInfo) {
        this.mResult = t;
        this.mErrorInfo = errorInfo;
    }

    public String toString() {
        T t = this.mResult;
        return t != null ? t.toString() : this.mErrorInfo.toString();
    }

    public T getResult() {
        return this.mResult;
    }

    public ErrorInfo getErrorInfo() {
        return this.mErrorInfo;
    }
}
