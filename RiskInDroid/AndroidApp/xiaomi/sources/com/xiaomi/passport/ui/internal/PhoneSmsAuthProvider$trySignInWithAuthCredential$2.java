package com.xiaomi.passport.ui.internal;

import _m_j.egb;
import _m_j.ehd;
import _m_j.ehe;
import _m_j.ehf;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "it", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhoneSmsAuthProvider$trySignInWithAuthCredential$2 extends Lambda implements iwc<RegisterUserInfo, AccountInfo> {
    final /* synthetic */ ehd $authCredential;
    final /* synthetic */ ehe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneSmsAuthProvider$trySignInWithAuthCredential$2(ehe ehe, ehd ehd) {
        super(1);
        this.this$0 = ehe;
        this.$authCredential = ehd;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        RegisterUserInfo registerUserInfo = (RegisterUserInfo) obj;
        ixe.O00000o0(registerUserInfo, "it");
        RegisterUserInfo.RegisterStatus registerStatus = registerUserInfo.status;
        if (registerStatus != null) {
            int i = ehf.f15277O000000o[registerStatus.ordinal()];
            if (i == 1) {
                return this.this$0.O00000Oo.O000000o(new egb(this.$authCredential, registerUserInfo, false));
            }
            if (i == 2) {
                return this.this$0.O00000Oo.O00000Oo(new egb(this.$authCredential, registerUserInfo, true));
            }
        }
        throw new PhoneRecycleException(this.$authCredential, registerUserInfo);
    }
}
