package _m_j;

import _m_j.eht;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhTicketSignInContract;", "", "()V", "Presenter", "View", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egz {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhTicketSignInContract$Presenter;", "", "chooseSignIn", "", "authCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "userInfo", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "chooseSignUp", "Lcom/xiaomi/passport/ui/internal/ChoosePhoneSmsAuthCredential;", "sendTicket", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "captchaCode", "Lcom/xiaomi/passport/ui/internal/CaptchaCode;", "verificationCode", "Lcom/xiaomi/passport/ui/internal/VerificationCode;", "signInPhoneAndTicket", "ticket", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public interface O000000o {
        void O000000o(egb egb);

        void O000000o(ehd ehd, RegisterUserInfo registerUserInfo);

        void O000000o(PhoneWrapper phoneWrapper, ega ega, eif eif);

        void O000000o(PhoneWrapper phoneWrapper, String str);

        void O00000Oo(ehd ehd, RegisterUserInfo registerUserInfo);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhTicketSignInContract$View;", "Lcom/xiaomi/passport/ui/internal/SignInContract$View;", "chooseToSignInOrSignUp", "", "authCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "userInfo", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "enableSendTicketBtn", "sendTicketSuccess", "showInvalidPsw", "Lcom/xiaomi/passport/ui/internal/ChoosePhoneSmsAuthCredential;", "msg", "", "showInvalidTicket", "showSetPsw", "showVerification", "captcha", "Lcom/xiaomi/passport/ui/internal/Captcha;", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public interface O00000Oo extends eht.O000000o {
        void O000000o(efz efz, PhoneWrapper phoneWrapper);

        void O000000o(egb egb);

        void O000000o(ehd ehd, RegisterUserInfo registerUserInfo);

        void O00000Oo();

        void O00000Oo(int i);

        void O00000Oo(egb egb);

        void O00000o();

        void O00000o0();
    }
}
