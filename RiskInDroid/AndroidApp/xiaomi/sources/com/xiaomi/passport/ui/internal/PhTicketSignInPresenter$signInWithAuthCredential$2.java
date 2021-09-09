package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.egz;
import _m_j.ehb;
import _m_j.ehd;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.InvalidVerifyCodeException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.TokenExpiredException;
import com.xiaomi.accountsdk.account.exception.UserRestrictedException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhTicketSignInPresenter$signInWithAuthCredential$2 extends Lambda implements iwc<Throwable, iuh> {
    final /* synthetic */ ehd $authCredential;
    final /* synthetic */ ehb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhTicketSignInPresenter$signInWithAuthCredential$2(ehb ehb, ehd ehd) {
        super(1);
        this.this$0 = ehb;
        this.$authCredential = ehd;
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
        Throwable th = (Throwable) obj;
        ixe.O00000o0(th, "it");
        this.this$0.O00000o0.O00000oo();
        if (th instanceof IOException) {
            efn.O000000o("sms_ticket_login_io_exception");
            AccountLog.e(this.this$0.f15274O000000o, "", th);
            this.this$0.O00000o0.O000000o((IOException) th);
        } else if (th instanceof NeedNotificationException) {
            efn.O000000o("sms_ticket_login_need_notification_exception");
            egz.O00000Oo o00000Oo = this.this$0.O00000o0;
            String notificationUrl = ((NeedNotificationException) th).getNotificationUrl();
            ixe.O000000o((Object) notificationUrl, "it.notificationUrl");
            o00000Oo.O00000o(notificationUrl);
        } else if (th instanceof NeedBindSnsException) {
            this.this$0.O00000o0.O000000o((NeedBindSnsException) th);
        } else if (th instanceof InvalidVerifyCodeException) {
            efn.O000000o("sms_ticket_login_invalid_verifycode_exception");
            this.this$0.O00000o0.O00000o0();
        } else if (th instanceof InvalidPhoneNumException) {
            efn.O000000o("sms_ticket_login_invalid_phonenum_exception");
            this.this$0.O00000o0.O00000Oo((int) R.string.passport_error_phone_error);
        } else if (th instanceof PhoneRecycleException) {
            efn.O000000o("sms_ticket_login_phone_recycle_exception");
            PhoneRecycleException phoneRecycleException = (PhoneRecycleException) th;
            this.this$0.O00000o0.O000000o(phoneRecycleException.getAuthCredential(), phoneRecycleException.getUserInfo());
        } else if (th instanceof UserRestrictedException) {
            efn.O000000o("sms_ticket_login_user_restricted_exception");
            this.this$0.O00000o0.O00000Oo((int) R.string.phone_bind_too_many);
        } else if (th instanceof TokenExpiredException) {
            efn.O000000o("sms_ticket_login_token_expired_exception");
            ehb ehb = this.this$0;
            ehb.O000000o(ehb.O00000Oo, this.$authCredential.O0000OOo);
            Toast.makeText(this.this$0.O00000Oo, (int) R.string.passport_activate_token_expired, 0).show();
        } else if (th instanceof NeedSetPswException) {
            efn.O000000o("sms_ticket_login_need_set_psw_exception");
            this.this$0.O00000o0.O00000Oo(((NeedSetPswException) th).getAuthCredential());
        } else if (th instanceof SetPswIllegalException) {
            efn.O000000o("sms_ticket_login_set_psw_illegal_exception");
            this.this$0.O00000o0.O000000o(((SetPswIllegalException) th).getAuthCredential());
        } else {
            efn.O000000o("sms_ticket_login_unknow_error");
            AccountLog.e(this.this$0.f15274O000000o, "", th);
            this.this$0.O00000o0.O000000o(th);
        }
        return iuh.f1631O000000o;
    }
}
