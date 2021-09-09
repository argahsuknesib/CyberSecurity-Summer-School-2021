package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.passport.ui.internal.PhoneAuthMethod;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J,\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&J.\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H&J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\u0006\u0010&\u001a\u00020'H&J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00032\u0006\u0010&\u001a\u00020)H&J\u0010\u0010*\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020+H&J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020%0\u00032\u0006\u0010&\u001a\u00020-H&J\u0010\u0010.\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020+H&¨\u0006/"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportRepo;", "", "getCaptchaImage", "Lcom/xiaomi/passport/ui/internal/Source;", "Lcom/xiaomi/passport/ui/internal/Captcha;", "url", "", "getLocalActivatorPhone", "", "Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;", "context", "Landroid/content/Context;", "sid", "queryDisplayPhoneNumber", "", "getPhoneAuthMethod", "Lcom/xiaomi/passport/ui/internal/PhoneAuthMethod;", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "getXiaomiAccount", "Landroid/accounts/Account;", "invalidateCachePhoneNum", "", "slotId", "", "loadImage", "Landroid/graphics/Bitmap;", "queryPhoneUserInfo", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "authCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "sendPhoneTicket", "captchaCode", "Lcom/xiaomi/passport/ui/internal/CaptchaCode;", "verificationCode", "Lcom/xiaomi/passport/ui/internal/VerificationCode;", "signInIdAndPsw", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "credential", "Lcom/xiaomi/passport/ui/internal/IdPswAuthCredential;", "signInIdAndPswWithCountryCode", "Lcom/xiaomi/passport/ui/internal/IdPswCountryCodeAuthCredential;", "signInWithPhone", "Lcom/xiaomi/passport/ui/internal/ChoosePhoneSmsAuthCredential;", "signInWithVStep2code", "Lcom/xiaomi/passport/ui/internal/IdPswVStep2AuthCredential;", "signUpWithPhone", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public interface egr {
    eib<AccountInfo> O000000o(egi egi);

    eib<AccountInfo> O000000o(egl egl);

    eib<AccountInfo> O000000o(egm egm);

    eib<List<ActivatorPhoneInfo>> O000000o(Context context, String str, boolean z);

    eib<PhoneAuthMethod> O000000o(PhoneWrapper phoneWrapper);

    eib<String> O000000o(PhoneWrapper phoneWrapper, ega ega, eif eif);

    eib<efz> O000000o(String str);

    AccountInfo O000000o(egb egb);

    RegisterUserInfo O000000o(ehd ehd);

    void O000000o(Context context, int i);

    eib<Bitmap> O00000Oo(String str);

    AccountInfo O00000Oo(egb egb);
}
