package com.xiaomi.account.data;

import android.text.TextUtils;

public class PassportCAToken {
    public static PassportCAToken INVALID_INSTANCE = new PassportCAToken("", "");
    public final String security;
    public final String token;

    public PassportCAToken(String str, String str2) {
        this.token = str;
        this.security = str2;
    }

    public boolean isLegal() {
        return !TextUtils.isEmpty(this.token) && !TextUtils.isEmpty(this.security);
    }
}
