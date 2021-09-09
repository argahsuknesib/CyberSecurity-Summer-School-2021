package com.xiaomi.passport.ui.internal;

import _m_j.ega;
import _m_j.eha;
import _m_j.iuh;
import _m_j.iwn;
import _m_j.ixe;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "captchaCode", "", "lastIck", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhTicketSignInFragment$showVerification$1$onVerifyFail$1 extends Lambda implements iwn<String, String, iuh> {
    final /* synthetic */ eha.O0000o this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhTicketSignInFragment$showVerification$1$onVerifyFail$1(eha.O0000o o0000o) {
        super(2);
        this.this$0 = o0000o;
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        ixe.O00000o0(str, "captchaCode");
        ixe.O00000o0(str2, "lastIck");
        eha.O000000o(this.this$0.f15271O000000o).O000000o(this.this$0.O00000Oo, new ega(str, str2), null);
        return iuh.f1631O000000o;
    }
}
