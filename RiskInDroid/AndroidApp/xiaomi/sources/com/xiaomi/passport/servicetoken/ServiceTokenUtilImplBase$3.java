package com.xiaomi.passport.servicetoken;

import _m_j.efi;
import android.content.Context;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;

public class ServiceTokenUtilImplBase$3 extends MiAccountManagerFuture<XmAccountVisibility> {
    final /* synthetic */ efi this$0;
    final /* synthetic */ Context val$context;

    public ServiceTokenUtilImplBase$3(efi efi, Context context) {
        this.this$0 = efi;
        this.val$context = context;
    }

    public XmAccountVisibility doWork() {
        return this.this$0.O000000o(this.val$context);
    }
}
