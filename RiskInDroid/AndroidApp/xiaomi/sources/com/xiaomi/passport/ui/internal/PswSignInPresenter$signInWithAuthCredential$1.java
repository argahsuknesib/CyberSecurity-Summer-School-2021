package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.egk;
import _m_j.ehk;
import _m_j.iuh;
import _m_j.iuj;
import _m_j.ivb;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PswSignInPresenter$signInWithAuthCredential$1 extends Lambda implements iwc<AccountInfo, iuh> {
    final /* synthetic */ egk $authCredential;
    final /* synthetic */ ehk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PswSignInPresenter$signInWithAuthCredential$1(ehk ehk, egk egk) {
        super(1);
        this.this$0 = ehk;
        this.$authCredential = egk;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iun.O00000Oo(java.lang.Object[], java.util.Collection):C
     arg types: [java.lang.String[], java.util.HashSet]
     candidates:
      _m_j.iun.O00000Oo(java.lang.Object[], java.lang.Object):int
      _m_j.iun.O00000Oo(java.lang.Object[], java.util.Collection):C */
    public final /* synthetic */ Object invoke(Object obj) {
        AccountInfo accountInfo = (AccountInfo) obj;
        ixe.O00000o0(accountInfo, "it");
        this.this$0.O00000o0.O00000oo();
        this.this$0.O00000o0.O000000o(accountInfo);
        ehk ehk = this.this$0;
        egk egk = this.$authCredential;
        ixe.O00000o0(egk, "credential");
        String[] O000000o2 = ehk.O000000o();
        ixe.O00000o0(O000000o2, "receiver$0");
        HashSet hashSet = (HashSet) iuj.O00000Oo((Object[]) O000000o2, (Collection) new HashSet(ivb.O000000o(O000000o2.length)));
        hashSet.add(egk.O00000oo);
        ehk.O00000Oo.getSharedPreferences("passport_ui", 0).edit().putStringSet("sign_in_user_id", hashSet).apply();
        efn.O000000o("password_login_success");
        return iuh.f1631O000000o;
    }
}
