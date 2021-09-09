package com.xiaomi.accountsdk.utils;

public class FidNonceBase {
    public final String plain;
    public final String sign;

    protected FidNonceBase(String str, String str2) {
        this.plain = str;
        this.sign = str2;
    }
}
