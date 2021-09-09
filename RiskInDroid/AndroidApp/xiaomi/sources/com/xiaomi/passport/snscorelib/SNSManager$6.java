package com.xiaomi.passport.snscorelib;

import _m_j.efk;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import java.util.concurrent.Callable;

public class SNSManager$6 implements Callable<SNSBindParameter> {
    final /* synthetic */ efk this$0;
    final /* synthetic */ AccountInfo val$accountInfo;
    final /* synthetic */ String val$code;
    final /* synthetic */ String val$enToken;
    final /* synthetic */ SNSLoginParameter val$snsLoginParameter;
    final /* synthetic */ String val$token;

    public SNSManager$6(efk efk, String str, String str2, SNSLoginParameter sNSLoginParameter, AccountInfo accountInfo, String str3) {
        this.this$0 = efk;
        this.val$enToken = str;
        this.val$token = str2;
        this.val$snsLoginParameter = sNSLoginParameter;
        this.val$accountInfo = accountInfo;
        this.val$code = str3;
    }

    public SNSBindParameter call() throws Exception {
        if (!TextUtils.isEmpty(this.val$enToken) || !TextUtils.isEmpty(this.val$token)) {
            return SNSRequest.O00000Oo(this.val$snsLoginParameter, this.val$accountInfo);
        }
        if (!TextUtils.isEmpty(this.val$code)) {
            return SNSRequest.O000000o(this.val$snsLoginParameter, this.val$accountInfo);
        }
        throw new IllegalArgumentException("code and enToken parameters is null");
    }
}
