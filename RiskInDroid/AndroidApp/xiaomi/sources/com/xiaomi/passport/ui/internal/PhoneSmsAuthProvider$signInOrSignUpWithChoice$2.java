package com.xiaomi.passport.ui.internal;

import _m_j.egb;
import _m_j.ehe;
import _m_j.iwb;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhoneSmsAuthProvider$signInOrSignUpWithChoice$2 extends Lambda implements iwb<AccountInfo> {
    final /* synthetic */ egb $credential;
    final /* synthetic */ ehe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneSmsAuthProvider$signInOrSignUpWithChoice$2(ehe ehe, egb egb) {
        super(0);
        this.this$0 = ehe;
        this.$credential = egb;
    }

    public final /* synthetic */ Object invoke() {
        return this.this$0.O00000Oo.O000000o(this.$credential);
    }
}
