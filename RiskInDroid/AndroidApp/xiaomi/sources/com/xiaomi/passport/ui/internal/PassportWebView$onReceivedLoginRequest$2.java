package com.xiaomi.passport.ui.internal;

import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/xiaomi/passport/servicetoken/ServiceTokenResult;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportWebView$onReceivedLoginRequest$2 extends Lambda implements iwc<ServiceTokenResult, iuh> {
    final /* synthetic */ PassportWebView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportWebView$onReceivedLoginRequest$2(PassportWebView passportWebView) {
        super(1);
        this.this$0 = passportWebView;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final /* synthetic */ Object invoke(Object obj) {
        ServiceTokenResult serviceTokenResult = (ServiceTokenResult) obj;
        if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE) {
            PassportWebView passportWebView = this.this$0;
            String str = serviceTokenResult.O00000Oo;
            ixe.O000000o((Object) str, "it.serviceToken");
            passportWebView.loadUrl(str);
        }
        return iuh.f1631O000000o;
    }
}
