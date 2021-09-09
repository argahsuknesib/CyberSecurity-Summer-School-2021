package com.alipay.android.phone.mrpc.core;

public class HttpException extends Exception {
    private static final long serialVersionUID = -6320569206365033676L;
    private int mCode;
    private String mMsg;

    /* JADX WARNING: Illegal instructions before constructor call */
    public HttpException(Integer num, String str) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("Http Transport error");
        if (num != null) {
            sb.append("[");
            sb.append(num);
            sb.append("]");
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    public HttpException(String str) {
        super(str);
        this.mCode = 0;
        this.mMsg = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }
}
