package com.xiaomi.passport.ui.utils;

import _m_j.eko;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.PhoneTicketLoginParams;
import com.xiaomi.passport.PassportUserEnvironment;
import com.xiaomi.passport.ui.data.PhoneAccount;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberManagerFactory;
import java.util.concurrent.Callable;

public class AccountLoginer$4 implements Callable<AccountInfo> {
    final /* synthetic */ eko this$0;
    final /* synthetic */ PhoneTicketLoginParams val$loginParams;
    final /* synthetic */ PhoneAccount val$phoneAccount;
    final /* synthetic */ String val$sid;

    public AccountLoginer$4(eko eko, PhoneTicketLoginParams phoneTicketLoginParams, String str, PhoneAccount phoneAccount) {
        this.this$0 = eko;
        this.val$loginParams = phoneTicketLoginParams;
        this.val$sid = str;
        this.val$phoneAccount = phoneAccount;
    }

    public AccountInfo call() throws Exception {
        PhoneTicketLoginParams phoneTicketLoginParams;
        if (this.val$loginParams.hashedEnvFactors == null) {
            phoneTicketLoginParams = PhoneTicketLoginParams.copyFrom(this.val$loginParams).hashedEnvFactors(PassportUserEnvironment.O000000o.O000000o().O000000o(XMPassportSettings.getApplicationContext())).build();
        } else {
            phoneTicketLoginParams = this.val$loginParams;
        }
        try {
            return XMPassport.loginByPhone(phoneTicketLoginParams);
        } finally {
            AccountPhoneNumberManagerFactory.createProperManager(this.this$0.O00000Oo).invalidateAccountCertification(this.this$0.O00000Oo, this.val$sid, this.val$phoneAccount.f6215O000000o);
        }
    }
}
