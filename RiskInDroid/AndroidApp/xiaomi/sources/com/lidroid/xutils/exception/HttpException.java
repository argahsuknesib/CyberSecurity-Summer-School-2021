package com.lidroid.xutils.exception;

public class HttpException extends BaseException {
    private static final long serialVersionUID = 1;
    private int exceptionCode;

    public HttpException() {
    }

    public HttpException(String str) {
        super(str);
    }

    public HttpException(String str, Throwable th) {
        super(str, th);
    }

    public HttpException(Throwable th) {
        super(th);
    }

    public HttpException(int i) {
        this.exceptionCode = i;
    }

    public HttpException(int i, String str) {
        super(str);
        this.exceptionCode = i;
    }

    public HttpException(int i, String str, Throwable th) {
        super(str, th);
        this.exceptionCode = i;
    }

    public HttpException(int i, Throwable th) {
        super(th);
        this.exceptionCode = i;
    }

    public int getExceptionCode() {
        return this.exceptionCode;
    }
}
