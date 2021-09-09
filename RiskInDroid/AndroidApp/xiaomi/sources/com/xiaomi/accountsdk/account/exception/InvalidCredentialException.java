package com.xiaomi.accountsdk.account.exception;

import com.xiaomi.accountsdk.account.data.MetaLoginData;

public class InvalidCredentialException extends AccountException {
    private static final long serialVersionUID = 1;
    public String captchaUrl;
    public final boolean hasPwd;
    public MetaLoginData metaLoginData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidCredentialException(boolean z) {
        super(z ? 70016 : 70002, z ? "password error or passToken invalid" : "no password");
        this.hasPwd = z;
    }

    public InvalidCredentialException(int i, String str, boolean z) {
        super(i, str);
        this.hasPwd = z;
    }

    public InvalidCredentialException metaLoginData(MetaLoginData metaLoginData2) {
        this.metaLoginData = metaLoginData2;
        return this;
    }

    public InvalidCredentialException captchaUrl(String str) {
        this.captchaUrl = str;
        return this;
    }

    public MetaLoginData getMetaLoginData() {
        return this.metaLoginData;
    }

    public String getCaptchaUrl() {
        return this.captchaUrl;
    }

    public boolean getHasPwd() {
        return this.hasPwd;
    }
}
