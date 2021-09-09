package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.ehb;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.TokenExpiredException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhTicketSignInPresenter$sendTicket$2 extends Lambda implements iwc<Throwable, iuh> {
    final /* synthetic */ PhoneWrapper $phone;
    final /* synthetic */ ehb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhTicketSignInPresenter$sendTicket$2(ehb ehb, PhoneWrapper phoneWrapper) {
        super(1);
        this.this$0 = ehb;
        this.$phone = phoneWrapper;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        ixe.O00000o0(th, "it");
        this.this$0.O00000o0.O00000o();
        if (th instanceof CaptchaException) {
            efn.O000000o("sms_regain_send_ticket_captcha_exception");
            this.this$0.O00000o0.O000000o(((CaptchaException) th).getCaptcha(), this.$phone);
        } else if (th instanceof IOException) {
            efn.O000000o("sms_regain_send_ticket_io_exception");
            this.this$0.O00000o0.O000000o((IOException) th);
        } else if (th instanceof ReachLimitException) {
            efn.O000000o("sms_regain_send_ticket_reach_limit_exception");
            this.this$0.O00000o0.O00000Oo((int) R.string.passport_send_too_many_sms);
        } else if (th instanceof InvalidPhoneNumException) {
            efn.O000000o("sms_regain_send_ticket_invalid_phonenum_exception");
            this.this$0.O00000o0.O00000Oo((int) R.string.passport_error_phone_error);
        } else if (th instanceof TokenExpiredException) {
            efn.O000000o("sms_regain_send_ticket_token_expired_exception");
            ehb ehb = this.this$0;
            ehb.O000000o(ehb.O00000Oo, this.$phone);
            Toast.makeText(this.this$0.O00000Oo, (int) R.string.passport_activate_token_expired, 0).show();
        } else {
            efn.O000000o("sms_regain_send_ticket_unknow_error");
            AccountLog.e(this.this$0.f15274O000000o, "", th);
            this.this$0.O00000o0.O000000o(th);
        }
        return iuh.f1631O000000o;
    }
}
