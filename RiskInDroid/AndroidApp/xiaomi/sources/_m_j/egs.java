package _m_j;

import _m_j.eib;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.data.PhoneTicketLoginParams;
import com.xiaomi.accountsdk.account.data.PhoneTokenRegisterParams;
import com.xiaomi.accountsdk.account.data.QueryPhoneInfoParams;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.passport.ui.internal.NeedSetPswException;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$getCaptchaImage$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$getLocalActivatorPhone$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$getPhoneAuthMethod$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$invalidateCachePhoneNum$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$invalidateCachePhoneNum$2;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$loadImage$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$sendPhoneTicket$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$signInIdAndPsw$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$signInIdAndPswWithCountryCode$1;
import com.xiaomi.passport.ui.internal.PassportRepoImpl$signInWithVStep2code$1;
import com.xiaomi.passport.ui.internal.PhoneAuthMethod;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import com.xiaomi.passport.ui.internal.SetPswIllegalException;
import com.xiaomi.passport.uicontroller.PhoneLoginController;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0011\u001a\u00020\nH\u0002J,\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000f2\u0006\u0010\r\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J*\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010'\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u000f2\u0006\u00100\u001a\u000201H\u0016J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u000f2\u0006\u00100\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020/2\u0006\u0010'\u001a\u000205H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020/0\u000f2\u0006\u00100\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020/2\u0006\u0010'\u001a\u000205H\u0016¨\u00069"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportRepoImpl;", "Lcom/xiaomi/passport/ui/internal/PassportRepo;", "()V", "atLeast2True", "", "b1", "b2", "b3", "checkPasswordPattern", "password", "", "checkPhone", "", "phone", "getCaptchaImage", "Lcom/xiaomi/passport/ui/internal/Source;", "Lcom/xiaomi/passport/ui/internal/Captcha;", "url", "getCaptchaImageNullSafe", "Landroid/util/Pair;", "Landroid/graphics/Bitmap;", "getLocalActivatorPhone", "", "Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;", "context", "Landroid/content/Context;", "sid", "queryDisplayPhoneNumber", "getPhoneAuthMethod", "Lcom/xiaomi/passport/ui/internal/PhoneAuthMethod;", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "getXiaomiAccount", "Landroid/accounts/Account;", "invalidateCachePhoneNum", "slotId", "", "loadImage", "queryPhoneUserInfo", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "authCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "sendPhoneTicket", "captchaCode", "Lcom/xiaomi/passport/ui/internal/CaptchaCode;", "verificationCode", "Lcom/xiaomi/passport/ui/internal/VerificationCode;", "signInIdAndPsw", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "credential", "Lcom/xiaomi/passport/ui/internal/IdPswAuthCredential;", "signInIdAndPswWithCountryCode", "Lcom/xiaomi/passport/ui/internal/IdPswCountryCodeAuthCredential;", "signInWithPhone", "Lcom/xiaomi/passport/ui/internal/ChoosePhoneSmsAuthCredential;", "signInWithVStep2code", "Lcom/xiaomi/passport/ui/internal/IdPswVStep2AuthCredential;", "signUpWithPhone", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egs implements egr {
    public final eib<PhoneAuthMethod> O000000o(PhoneWrapper phoneWrapper) {
        ixe.O00000o0(phoneWrapper, "phone");
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$getPhoneAuthMethod$1(phoneWrapper));
    }

    public final eib<AccountInfo> O000000o(egi egi) {
        ixe.O00000o0(egi, "credential");
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$signInIdAndPsw$1(this, egi));
    }

    public final eib<AccountInfo> O000000o(egl egl) {
        ixe.O00000o0(egl, "credential");
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$signInIdAndPswWithCountryCode$1(this, egl));
    }

    public final eib<AccountInfo> O000000o(egm egm) {
        ixe.O00000o0(egm, "credential");
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$signInWithVStep2code$1(this, egm));
    }

    public static void O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidPhoneNumException("empty phone");
        }
    }

    public final eib<String> O000000o(PhoneWrapper phoneWrapper, ega ega, eif eif) {
        ixe.O00000o0(phoneWrapper, "authCredential");
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$sendPhoneTicket$1(this, phoneWrapper, ega, eif));
    }

    public final eib<efz> O000000o(String str) {
        ixe.O00000o0(str, "url");
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$getCaptchaImage$1(this, str));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.util.Pair<android.graphics.Bitmap, java.lang.String>, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public static Pair<Bitmap, String> O00000o(String str) {
        Pair<Bitmap, String> captchaImage = XMPassport.getCaptchaImage(str);
        if (captchaImage == null) {
            captchaImage = Pair.create(null, "");
        }
        ixe.O000000o((Object) captchaImage, "captcha");
        return captchaImage;
    }

    public final eib<Bitmap> O00000Oo(String str) {
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$loadImage$1(str));
    }

    public final AccountInfo O00000Oo(egb egb) {
        ixe.O00000o0(egb, "authCredential");
        PhoneTicketLoginParams.Builder serviceId = new PhoneTicketLoginParams.Builder().serviceId(egb.O00000o);
        if (egb.O0000OOo.f6255O000000o != null) {
            serviceId.phoneTicketToken(egb.O0000OOo.f6255O000000o, egb.O00000oO.ticketToken);
        } else {
            serviceId.activatorPhoneTicket(egb.O0000OOo.O00000Oo, egb.O0000Oo0);
        }
        try {
            Object obj = new PhoneLoginController().O000000o(serviceId.build(), new O00000Oo()).get();
            if (obj != null) {
                return (AccountInfo) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.accountsdk.account.data.AccountInfo");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                ixe.O000000o();
            }
            throw cause;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/xiaomi/passport/ui/internal/PassportRepoImpl$signInWithPhone$future$1", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$TicketLoginCallback;", "()V", "onLoginFailed", "", "p0", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$ErrorCode;", "p1", "", "p2", "", "onLoginSuccess", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onNeedNotification", "onPhoneNumInvalid", "onTicketOrTokenInvalid", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000Oo implements PhoneLoginController.O0000O0o {
        O00000Oo() {
        }
    }

    public final AccountInfo O000000o(egb egb) {
        int length;
        ixe.O00000o0(egb, "authCredential");
        PhoneTokenRegisterParams.Builder serviceId = new PhoneTokenRegisterParams.Builder().serviceId(egb.O00000o);
        if (egb.O00000oO.registerPwd) {
            if (egb.O0000O0o != null) {
                String str = egb.O0000O0o;
                boolean z = false;
                if (str != null && (length = str.length()) >= 8 && length <= 16) {
                    int i = 0;
                    boolean z2 = false;
                    boolean z3 = false;
                    boolean z4 = false;
                    while (true) {
                        if (i < length) {
                            char charAt = str.charAt(i);
                            if (charAt < ' ' || charAt > '~') {
                                break;
                            }
                            if (('a' <= charAt && 'z' >= charAt) || ('A' <= charAt && 'Z' >= charAt)) {
                                z2 = true;
                            } else if ('0' <= charAt && '9' >= charAt) {
                                z3 = true;
                            } else {
                                z4 = true;
                            }
                            i++;
                        } else if ((z2 && z3) || ((z2 && z4) || (z3 && z4))) {
                            z = true;
                        }
                    }
                }
                if (z) {
                    serviceId.password(egb.O0000O0o);
                } else {
                    throw new SetPswIllegalException(egb);
                }
            } else {
                throw new NeedSetPswException(egb);
            }
        }
        if (egb.O0000OOo.f6255O000000o != null) {
            serviceId.phoneTicketToken(egb.O0000OOo.f6255O000000o, egb.O00000oO.ticketToken);
        } else {
            serviceId.phoneHashActivatorToken(egb.O0000OOo.O00000Oo);
        }
        try {
            Object obj = new PhoneLoginController().O000000o(serviceId.build(), new O00000o0()).get();
            if (obj != null) {
                return (AccountInfo) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.accountsdk.account.data.AccountInfo");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                ixe.O000000o();
            }
            throw cause;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"com/xiaomi/passport/ui/internal/PassportRepoImpl$signUpWithPhone$future$1", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$PhoneRegisterCallback;", "()V", "onRegisterFailed", "", "p0", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$ErrorCode;", "p1", "", "onRegisterReachLimit", "onRegisterSuccess", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onTokenExpired", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000o0 implements PhoneLoginController.O000000o {
        O00000o0() {
        }
    }

    public final RegisterUserInfo O000000o(ehd ehd) {
        ixe.O00000o0(ehd, "authCredential");
        QueryPhoneInfoParams.Builder builder = new QueryPhoneInfoParams.Builder();
        if (ehd.O0000OOo.f6255O000000o != null) {
            O00000o0(ehd.O0000OOo.f6255O000000o);
            builder.phoneTicket(ehd.O0000OOo.f6255O000000o, ehd.O0000Oo0);
        } else {
            builder.phoneHashActivatorToken(ehd.O0000OOo.O00000Oo);
        }
        builder.serviceId(ehd.O00000o);
        try {
            Object obj = new PhoneLoginController().O000000o(builder.build(), new O000000o()).get();
            if (obj != null) {
                return (RegisterUserInfo) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.accountsdk.account.data.RegisterUserInfo");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                ixe.O000000o();
            }
            throw cause;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"com/xiaomi/passport/ui/internal/PassportRepoImpl$queryPhoneUserInfo$future$1", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$PhoneUserInfoCallback;", "()V", "onNotRecycledRegisteredPhone", "", "p0", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "onPhoneNumInvalid", "onProbablyRecycleRegisteredPhone", "onQueryFailed", "Lcom/xiaomi/passport/uicontroller/PhoneLoginController$ErrorCode;", "p1", "", "onRecycledOrNotRegisteredPhone", "onTicketOrTokenInvalid", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o implements PhoneLoginController.O00000Oo {
        O000000o() {
        }
    }

    public final eib<List<ActivatorPhoneInfo>> O000000o(Context context, String str, boolean z) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(str, "sid");
        eib.O000000o o000000o = eib.f15310O000000o;
        return eib.O000000o.O000000o(new PassportRepoImpl$getLocalActivatorPhone$1(context, str, z));
    }

    public final void O000000o(Context context, int i) {
        ixe.O00000o0(context, "context");
        eib.O000000o o000000o = eib.f15310O000000o;
        eib.O000000o.O000000o(new PassportRepoImpl$invalidateCachePhoneNum$1(context, i)).O000000o(PassportRepoImpl$invalidateCachePhoneNum$2.f6252O000000o);
    }
}
