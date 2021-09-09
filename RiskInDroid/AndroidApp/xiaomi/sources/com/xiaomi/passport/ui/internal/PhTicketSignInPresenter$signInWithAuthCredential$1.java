package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.ehb;
import _m_j.ehd;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhTicketSignInPresenter$signInWithAuthCredential$1 extends Lambda implements iwc<AccountInfo, iuh> {
    final /* synthetic */ ehd $authCredential;
    final /* synthetic */ ehb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhTicketSignInPresenter$signInWithAuthCredential$1(ehb ehb, ehd ehd) {
        super(1);
        this.this$0 = ehb;
        this.$authCredential = ehd;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        AccountInfo accountInfo = (AccountInfo) obj;
        ixe.O00000o0(accountInfo, "it");
        this.this$0.O00000o0.O00000oo();
        this.this$0.O00000o0.O000000o(accountInfo);
        efn.O000000o("sms_ticket_login_success");
        if (this.$authCredential.O0000OOo.O00000Oo != null) {
            ehb ehb = this.this$0;
            ehb.O000000o(ehb.O00000Oo, this.$authCredential.O0000OOo);
        }
        return iuh.f1631O000000o;
    }
}
