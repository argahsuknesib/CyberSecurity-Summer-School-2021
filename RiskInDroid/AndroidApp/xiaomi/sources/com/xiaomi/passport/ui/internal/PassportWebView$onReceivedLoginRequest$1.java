package com.xiaomi.passport.ui.internal;

import _m_j.iwb;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/xiaomi/passport/servicetoken/ServiceTokenResult;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportWebView$onReceivedLoginRequest$1 extends Lambda implements iwb<ServiceTokenResult> {
    final /* synthetic */ ServiceTokenFuture $serviceToken;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportWebView$onReceivedLoginRequest$1(ServiceTokenFuture serviceTokenFuture) {
        super(0);
        this.$serviceToken = serviceTokenFuture;
    }

    public final /* synthetic */ Object invoke() {
        return this.$serviceToken.get();
    }
}
