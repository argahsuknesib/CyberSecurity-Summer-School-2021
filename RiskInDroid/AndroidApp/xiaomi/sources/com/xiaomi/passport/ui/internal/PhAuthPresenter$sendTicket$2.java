package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.egr;
import _m_j.egx;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.content.Context;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.TokenExpiredException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhAuthPresenter$sendTicket$2 extends Lambda implements iwc<Throwable, iuh> {
    final /* synthetic */ PhoneWrapper $phone;
    final /* synthetic */ egx this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhAuthPresenter$sendTicket$2(egx egx, PhoneWrapper phoneWrapper) {
        super(1);
        this.this$0 = egx;
        this.$phone = phoneWrapper;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        ixe.O00000o0(th, "it");
        this.this$0.O00000o.O00000oo();
        if (th instanceof CaptchaException) {
            efn.O000000o("sms_send_ticket_captcha_exception");
            AccountLog.i(this.this$0.f15261O000000o, "CaptchaException");
            this.this$0.O00000o.O000000o(((CaptchaException) th).getCaptcha(), this.$phone);
        } else if (th instanceof IOException) {
            efn.O000000o("sms_send_ticket_io_exception");
            this.this$0.O00000o.O000000o((IOException) th);
        } else if (th instanceof ReachLimitException) {
            efn.O000000o("sms_send_ticket_reachlimit_exception");
            this.this$0.O00000o.O00000Oo(R.string.passport_send_too_many_sms);
        } else if (th instanceof InvalidPhoneNumException) {
            efn.O000000o("sms_send_ticket_invalid_phonenum_exception");
            this.this$0.O00000o.O00000Oo(R.string.passport_error_phone_error);
        } else if (th instanceof TokenExpiredException) {
            efn.O000000o("sms_send_ticket_tokenexpired_exception");
            egx egx = this.this$0;
            Context context = egx.O00000o0;
            PhoneWrapper phoneWrapper = this.$phone;
            egr egr = egx.O00000Oo;
            ActivatorPhoneInfo activatorPhoneInfo = phoneWrapper.O00000Oo;
            if (activatorPhoneInfo == null) {
                ixe.O000000o();
            }
            egr.O000000o(context, activatorPhoneInfo.slotId);
            Toast.makeText(this.this$0.O00000o0, (int) R.string.passport_activate_token_expired, 0).show();
            this.this$0.O00000o.O00000Oo();
        } else {
            efn.O000000o("sms_send_ticket_unknow_error");
            AccountLog.e(this.this$0.f15261O000000o, "", th);
            this.this$0.O00000o.O000000o(th);
        }
        return iuh.f1631O000000o;
    }
}
