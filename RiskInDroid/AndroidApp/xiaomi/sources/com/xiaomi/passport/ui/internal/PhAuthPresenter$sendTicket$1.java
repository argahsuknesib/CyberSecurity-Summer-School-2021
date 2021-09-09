package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.egx;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.accountsdk.utils.AccountLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhAuthPresenter$sendTicket$1 extends Lambda implements iwc<String, iuh> {
    final /* synthetic */ PhoneWrapper $phone;
    final /* synthetic */ egx this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhAuthPresenter$sendTicket$1(egx egx, PhoneWrapper phoneWrapper) {
        super(1);
        this.this$0 = egx;
        this.$phone = phoneWrapper;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        ixe.O00000o0((String) obj, "it");
        efn.O000000o("sms_send_ticket_success");
        this.this$0.O00000o.O00000oo();
        this.this$0.O00000o.O000000o(this.$phone);
        AccountLog.i(this.this$0.f15261O000000o, "sendTicket success");
        return iuh.f1631O000000o;
    }
}
