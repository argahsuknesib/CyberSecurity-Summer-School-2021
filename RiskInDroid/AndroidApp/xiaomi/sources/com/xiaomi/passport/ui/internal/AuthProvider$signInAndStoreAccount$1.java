package com.xiaomi.passport.ui.internal;

import _m_j.eft;
import _m_j.eks;
import _m_j.iwc;
import _m_j.ixe;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "it", "invoke"}, k = 3, mv = {1, 1, 10})
public final class AuthProvider$signInAndStoreAccount$1 extends Lambda implements iwc<AccountInfo, AccountInfo> {
    final /* synthetic */ Context $context;
    final /* synthetic */ eft this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthProvider$signInAndStoreAccount$1(eft eft, Context context) {
        super(1);
        this.this$0 = eft;
        this.$context = context;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        AccountInfo accountInfo = (AccountInfo) obj;
        ixe.O00000o0(accountInfo, "it");
        Context context = this.$context;
        if (!TextUtils.isEmpty(accountInfo != null ? accountInfo.passToken : null)) {
            eks.O00000Oo(context, accountInfo);
        }
        return accountInfo;
    }
}
