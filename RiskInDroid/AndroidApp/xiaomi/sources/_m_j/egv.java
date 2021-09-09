package _m_j;

import _m_j.eht;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhAuthContract;", "", "()V", "Presenter", "View", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egv {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhAuthContract$Presenter;", "", "getPhoneAuthMethod", "", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "sendTicket", "captchaCode", "Lcom/xiaomi/passport/ui/internal/CaptchaCode;", "verificationCode", "Lcom/xiaomi/passport/ui/internal/VerificationCode;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public interface O000000o {
        void O000000o(PhoneWrapper phoneWrapper);

        void O000000o(PhoneWrapper phoneWrapper, ega ega, eif eif);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhAuthContract$View;", "Lcom/xiaomi/passport/ui/internal/SignInContract$View;", "clearPhonePopList", "", "gotoPswSignIn", "userId", "", "gotoTicketSignIn", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "showPhoneNumError", "msgRes", "", "showVerification", "captcha", "Lcom/xiaomi/passport/ui/internal/Captcha;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public interface O00000Oo extends eht.O000000o {
        void O000000o(efz efz, PhoneWrapper phoneWrapper);

        void O000000o(PhoneWrapper phoneWrapper);

        void O000000o(String str);

        void O00000Oo();

        void O00000Oo(int i);
    }
}
