package com.xiaomi.passport.ui.internal;

import _m_j.efz;
import _m_j.ega;
import _m_j.egs;
import _m_j.eif;
import _m_j.iwb;
import _m_j.ixe;
import android.graphics.Bitmap;
import android.util.Pair;
import com.xiaomi.accountsdk.account.data.SendPhoneTicketParams;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.passport.uicontroller.PhoneLoginController;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportRepoImpl$sendPhoneTicket$1 extends Lambda implements iwb<String> {
    final /* synthetic */ PhoneWrapper $authCredential;
    final /* synthetic */ ega $captchaCode;
    final /* synthetic */ eif $verificationCode;
    final /* synthetic */ egs this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportRepoImpl$sendPhoneTicket$1(egs egs, PhoneWrapper phoneWrapper, ega ega, eif eif) {
        super(0);
        this.this$0 = egs;
        this.$authCredential = phoneWrapper;
        this.$captchaCode = ega;
        this.$verificationCode = eif;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public String invoke() {
        String str;
        String str2;
        String str3;
        SendPhoneTicketParams.Builder serviceId = new SendPhoneTicketParams.Builder().serviceId(this.$authCredential.O00000o0);
        ega ega = this.$captchaCode;
        String str4 = null;
        if (ega != null) {
            str = ega.f15239O000000o;
        } else {
            str = null;
        }
        ega ega2 = this.$captchaCode;
        if (ega2 != null) {
            str2 = ega2.O00000Oo;
        } else {
            str2 = null;
        }
        SendPhoneTicketParams.Builder captchaCode = serviceId.captchaCode(str, str2);
        eif eif = this.$verificationCode;
        if (eif != null) {
            str3 = eif.f15316O000000o;
        } else {
            str3 = null;
        }
        SendPhoneTicketParams.Builder builder = captchaCode.token(str3);
        eif eif2 = this.$verificationCode;
        if (eif2 != null) {
            str4 = eif2.O00000Oo;
        }
        SendPhoneTicketParams.Builder action = builder.action(str4);
        if (this.$authCredential.f6255O000000o != null) {
            egs.O00000o0(this.$authCredential.f6255O000000o);
            action.phone(this.$authCredential.f6255O000000o);
        } else {
            action.phoneHashActivatorToken(this.$authCredential.O00000Oo);
        }
        try {
            new PhoneLoginController().O000000o(action.build(), new O000000o()).get();
            return "success";
        } catch (ExecutionException e) {
            if (e.getCause() instanceof NeedCaptchaException) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.accountsdk.account.exception.NeedCaptchaException");
                }
                String captchaUrl = ((NeedCaptchaException) cause).getCaptchaUrl();
                ixe.O000000o((Object) captchaUrl, "url");
                Pair<Bitmap, String> O00000o = egs.O00000o(captchaUrl);
                Object obj = O00000o.second;
                ixe.O000000o(obj, "captcha.second");
                throw new CaptchaException(new efz((Bitmap) O00000o.first, (String) obj, captchaUrl));
            }
            Throwable cause2 = e.getCause();
            if (cause2 == null) {
                ixe.O000000o();
            }
            throw cause2;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"com/xiaomi/passport/ui/internal/PassportRepoImpl$sendPhoneTicket$1$future$1", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$SendPhoneTicketExtensionCallback;", "()V", "onActivatorTokenExpired", "", "onNeedCaptchaCode", "p0", "", "onPhoneNumInvalid", "onSMSReachLimit", "onSentFailed", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$ErrorCode;", "p1", "onSentSuccess", "", "onServerError", "p2", "Lcom/xiaomi/accountsdk/account/ServerError;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o implements PhoneLoginController.O00000o {
        O000000o() {
        }
    }
}
