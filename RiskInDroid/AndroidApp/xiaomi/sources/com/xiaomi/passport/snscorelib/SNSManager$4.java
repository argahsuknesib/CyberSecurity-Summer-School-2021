package com.xiaomi.passport.snscorelib;

import _m_j.efk;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import java.util.concurrent.Callable;

public class SNSManager$4 implements Callable<AccountInfo> {
    final /* synthetic */ efk this$0;
    final /* synthetic */ SNSLoginParameter val$snsLoginParameter;

    SNSManager$4(efk efk, SNSLoginParameter sNSLoginParameter) {
        this.this$0 = efk;
        this.val$snsLoginParameter = sNSLoginParameter;
    }

    public AccountInfo call() throws Exception {
        return SNSRequest.O00000Oo(this.val$snsLoginParameter);
    }
}
