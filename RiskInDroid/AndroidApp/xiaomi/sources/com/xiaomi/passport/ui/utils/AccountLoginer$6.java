package com.xiaomi.passport.ui.utils;

import _m_j.eko;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.PhoneTokenRegisterParams;
import com.xiaomi.passport.ui.data.PhoneAccount;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberManagerFactory;
import java.util.concurrent.Callable;

public class AccountLoginer$6 implements Callable<AccountInfo> {
    final /* synthetic */ eko this$0;
    final /* synthetic */ PhoneAccount val$phoneAccount;
    final /* synthetic */ PhoneTokenRegisterParams val$registerParams;
    final /* synthetic */ String val$sid;

    public AccountLoginer$6(eko eko, PhoneTokenRegisterParams phoneTokenRegisterParams, String str, PhoneAccount phoneAccount) {
        this.this$0 = eko;
        this.val$registerParams = phoneTokenRegisterParams;
        this.val$sid = str;
        this.val$phoneAccount = phoneAccount;
    }

    public AccountInfo call() throws Exception {
        try {
            return XMPassport.regByPhoneWithToken(this.val$registerParams);
        } finally {
            AccountPhoneNumberManagerFactory.createProperManager(this.this$0.O00000Oo).invalidateAccountCertification(this.this$0.O00000Oo, this.val$sid, this.val$phoneAccount.f6215O000000o);
        }
    }
}
