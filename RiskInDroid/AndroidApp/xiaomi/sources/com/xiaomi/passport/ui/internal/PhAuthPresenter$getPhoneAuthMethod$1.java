package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.egv;
import _m_j.egx;
import _m_j.egy;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.passport.ui.onetrack.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/xiaomi/passport/ui/internal/PhoneAuthMethod;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhAuthPresenter$getPhoneAuthMethod$1 extends Lambda implements iwc<PhoneAuthMethod, iuh> {
    final /* synthetic */ PhoneWrapper $phone;
    final /* synthetic */ egx this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhAuthPresenter$getPhoneAuthMethod$1(egx egx, PhoneWrapper phoneWrapper) {
        super(1);
        this.this$0 = egx;
        this.$phone = phoneWrapper;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        PhoneAuthMethod phoneAuthMethod = (PhoneAuthMethod) obj;
        ixe.O00000o0(phoneAuthMethod, "it");
        efn.O000000o("sms_get_phone_authmethod_success");
        this.this$0.O00000o.O00000oo();
        int i = egy.f15262O000000o[phoneAuthMethod.ordinal()];
        if (i == 1) {
            efn.O000000o("sms_get_phone_authmethod_sms");
            this.this$0.O000000o(this.$phone, null, null);
            Analytics.O00000Oo("phone_get_sms");
        } else if (i == 2) {
            efn.O000000o("sms_get_phone_authmethod_psw");
            egv.O00000Oo o00000Oo = this.this$0.O00000o;
            String str = this.$phone.f6255O000000o;
            if (str == null) {
                ixe.O000000o();
            }
            o00000Oo.O000000o(str);
        }
        return iuh.f1631O000000o;
    }
}
