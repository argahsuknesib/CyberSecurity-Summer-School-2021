package com.xiaomi.passport.ui.internal;

import _m_j.ehd;
import _m_j.ixe;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhoneRecycleException;", "Lcom/xiaomi/passport/ui/internal/PassportUIException;", "authCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "userInfo", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "(Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;)V", "getAuthCredential", "()Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "getUserInfo", "()Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class PhoneRecycleException extends PassportUIException {
    private final ehd authCredential;
    private final RegisterUserInfo userInfo;

    public PhoneRecycleException(ehd ehd, RegisterUserInfo registerUserInfo) {
        ixe.O00000o0(ehd, "authCredential");
        ixe.O00000o0(registerUserInfo, "userInfo");
        this.authCredential = ehd;
        this.userInfo = registerUserInfo;
    }

    public final ehd getAuthCredential() {
        return this.authCredential;
    }

    public final RegisterUserInfo getUserInfo() {
        return this.userInfo;
    }
}
