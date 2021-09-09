package com.xiaomi.passport.ui.internal;

import _m_j.efn;
import _m_j.egk;
import _m_j.egt;
import _m_j.ehi;
import _m_j.ehk;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.iwn;
import _m_j.ixe;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PswSignInPresenter$signInWithAuthCredential$2 extends Lambda implements iwc<Throwable, iuh> {
    final /* synthetic */ egk $authCredential;
    final /* synthetic */ ehk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PswSignInPresenter$signInWithAuthCredential$2(ehk ehk, egk egk) {
        super(1);
        this.this$0 = ehk;
        this.$authCredential = egk;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.xiaomi.accountsdk.account.data.MetaLoginData, java.lang.String]
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
            efn.O000000o("password_io_exception");
            AccountLog.e(this.this$0.f15293O000000o, "", th);
            this.this$0.O00000o0.O000000o((IOException) th);
        } else if (th instanceof NeedNotificationException) {
            efn.O000000o("password_need_notification_exception");
            ehi.O00000Oo o00000Oo = this.this$0.O00000o0;
            String notificationUrl = ((NeedNotificationException) th).getNotificationUrl();
            ixe.O000000o((Object) notificationUrl, "it.notificationUrl");
            o00000Oo.O00000o(notificationUrl);
        } else if (th instanceof NeedBindSnsException) {
            this.this$0.O00000o0.O000000o((NeedBindSnsException) th);
        } else if (th instanceof InvalidUserNameException) {
            efn.O000000o("password_invalid_user_name_exception");
            String string = this.this$0.O00000Oo.getString(R.string.passport_error_user_name);
            egt egt = egt.f15254O000000o;
            if (egt.O00000oO()) {
                string = string + this.this$0.O00000Oo.getString(R.string.passport_international_phone_password_login_tip);
            }
            ehi.O00000Oo o00000Oo2 = this.this$0.O00000o0;
            ixe.O000000o((Object) string, "msg");
            o00000Oo2.O000000o(string);
        } else if (th instanceof InvalidCredentialException) {
            efn.O000000o("password_invalid_credential_exception");
            String string2 = this.this$0.O00000Oo.getString(R.string.passport_bad_authentication);
            egt egt2 = egt.f15254O000000o;
            if (egt.O00000oO()) {
                string2 = string2 + this.this$0.O00000Oo.getString(R.string.passport_international_phone_password_login_tip);
            }
            ehi.O00000Oo o00000Oo3 = this.this$0.O00000o0;
            ixe.O000000o((Object) string2, "msg");
            o00000Oo3.O00000Oo(string2);
        } else if (th instanceof CaptchaException) {
            efn.O000000o("password_captcha_exception");
            this.this$0.O00000o0.O000000o(((CaptchaException) th).getCaptcha(), new iwn<String, String, iuh>(this) {
                /* class com.xiaomi.passport.ui.internal.PswSignInPresenter$signInWithAuthCredential$2.AnonymousClass1 */
                final /* synthetic */ PswSignInPresenter$signInWithAuthCredential$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final /* synthetic */ Object invoke(Object obj, Object obj2) {
                    String str = (String) obj;
                    String str2 = (String) obj2;
                    ixe.O00000o0(str, "captchaCode");
                    ixe.O00000o0(str2, "lastIck");
                    egk egk = this.this$0.$authCredential;
                    ixe.O00000o0(str, "captchaCode");
                    ixe.O00000o0(str2, "captchaIck");
                    egk.f15233O000000o = str;
                    egk.O00000Oo = str2;
                    this.this$0.this$0.O000000o(this.this$0.$authCredential);
                    return iuh.f1631O000000o;
                }
            });
        } else if (th instanceof NeedVerificationException) {
            efn.O000000o("password_need_verification_exception");
            NeedVerificationException needVerificationException = (NeedVerificationException) th;
            if (needVerificationException.getStep1Token() == null) {
                Toast.makeText(this.this$0.O00000Oo, (int) R.string.passport_v_code_error, 1).show();
            } else {
                ehi.O00000Oo o00000Oo4 = this.this$0.O00000o0;
                egk egk = this.$authCredential;
                String step1Token = needVerificationException.getStep1Token();
                ixe.O000000o((Object) step1Token, "it.step1Token");
                MetaLoginData metaLoginData = needVerificationException.getMetaLoginData();
                ixe.O000000o((Object) metaLoginData, "it.metaLoginData");
                o00000Oo4.O000000o(egk, step1Token, metaLoginData);
            }
        } else {
            efn.O000000o("password_unknow_error");
            AccountLog.e(this.this$0.f15293O000000o, "", th);
            this.this$0.O00000o0.O000000o(th);
        }
        return iuh.f1631O000000o;
    }
}
