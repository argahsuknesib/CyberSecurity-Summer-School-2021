package com.xiaomi.accountsdk.account.exception;

import com.xiaomi.accountsdk.account.data.MetaLoginData;

public class NeedVerificationException extends Exception {
    private static final long serialVersionUID = 1;
    private final MetaLoginData mMetaLoginData;
    private final String mStep1Token;
    private final String mUserId;

    public NeedVerificationException(String str) {
        this(null, null, str);
    }

    public NeedVerificationException(MetaLoginData metaLoginData, String str, String str2) {
        super("Need verification code");
        this.mMetaLoginData = metaLoginData;
        this.mStep1Token = str;
        this.mUserId = str2;
    }

    public MetaLoginData getMetaLoginData() {
        return this.mMetaLoginData;
    }

    public String getStep1Token() {
        return this.mStep1Token;
    }

    public String getUserId() {
        return this.mUserId;
    }
}
