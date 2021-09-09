package com.xiaomi.smarthome.plugin;

public class Error {
    private int mCode;
    private String mDetail;

    public Error(int i, String str) {
        this.mCode = i;
        this.mDetail = str;
    }

    public final int getCode() {
        return this.mCode;
    }

    public final String getDetail() {
        return this.mDetail;
    }

    public String toString() {
        return "Error{mCode=" + this.mCode + ", mDetail='" + this.mDetail + '\'' + '}';
    }
}
