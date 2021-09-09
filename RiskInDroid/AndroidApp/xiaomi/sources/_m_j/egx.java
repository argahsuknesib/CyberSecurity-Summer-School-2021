package _m_j;

import _m_j.egv;
import android.content.Context;
import com.xiaomi.passport.ui.internal.PhAuthPresenter$getPhoneAuthMethod$1;
import com.xiaomi.passport.ui.internal.PhAuthPresenter$getPhoneAuthMethod$2;
import com.xiaomi.passport.ui.internal.PhAuthPresenter$sendTicket$1;
import com.xiaomi.passport.ui.internal.PhAuthPresenter$sendTicket$2;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005J\u0012\u0010#\u001a\u00020$2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J$\u0010&\u001a\u00020$2\u0006\u0010 \u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0016\u0010\n\u001a\u00020\u00058\u0002XD¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhAuthPresenter;", "Lcom/xiaomi/passport/ui/internal/PhAuthContract$Presenter;", "context", "Landroid/content/Context;", "sid", "", "view", "Lcom/xiaomi/passport/ui/internal/PhAuthContract$View;", "name", "(Landroid/content/Context;Ljava/lang/String;Lcom/xiaomi/passport/ui/internal/PhAuthContract$View;Ljava/lang/String;)V", "TAG", "TAG$annotations", "()V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "passportRepo", "Lcom/xiaomi/passport/ui/internal/PassportRepo;", "getPassportRepo", "()Lcom/xiaomi/passport/ui/internal/PassportRepo;", "setPassportRepo", "(Lcom/xiaomi/passport/ui/internal/PassportRepo;)V", "provider", "Lcom/xiaomi/passport/ui/internal/AuthProvider;", "getProvider", "()Lcom/xiaomi/passport/ui/internal/AuthProvider;", "getSid", "getView", "()Lcom/xiaomi/passport/ui/internal/PhAuthContract$View;", "createAuthCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "ticket", "getPhoneAuthMethod", "", "invalidateCathePhoneNum", "sendTicket", "captchaCode", "Lcom/xiaomi/passport/ui/internal/CaptchaCode;", "verificationCode", "Lcom/xiaomi/passport/ui/internal/VerificationCode;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egx implements egv.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f15261O000000o;
    public egr O00000Oo;
    public final egv.O00000Oo O00000o;
    public final Context O00000o0;
    private final eft O00000oO;
    private final String O00000oo;
    private final String O0000O0o;

    public /* synthetic */ egx(Context context, String str, egv.O00000Oo o00000Oo) {
        this(context, str, o00000Oo, "PHONE_SMS_AUTH_PROVIDER");
    }

    private egx(Context context, String str, egv.O00000Oo o00000Oo, String str2) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(str, "sid");
        ixe.O00000o0(o00000Oo, "view");
        ixe.O00000o0(str2, "name");
        this.O00000o0 = context;
        this.O00000oo = str;
        this.O00000o = o00000Oo;
        this.O0000O0o = str2;
        this.f15261O000000o = "PhTicketSignIn";
        egt egt = egt.f15254O000000o;
        this.O00000oO = egt.O000000o(this.O0000O0o);
        this.O00000Oo = new egs();
    }

    public final void O000000o(PhoneWrapper phoneWrapper) {
        if (phoneWrapper == null) {
            this.O00000o.O00000Oo(R.string.passport_error_phone_error);
            return;
        }
        this.O00000o.O00000oO();
        efn.O000000o("sms_get_phone_authmethod");
        this.O00000Oo.O000000o(phoneWrapper).O000000o(new PhAuthPresenter$getPhoneAuthMethod$1(this, phoneWrapper), new PhAuthPresenter$getPhoneAuthMethod$2(this));
    }

    public final void O000000o(PhoneWrapper phoneWrapper, ega ega, eif eif) {
        ixe.O00000o0(phoneWrapper, "phone");
        this.O00000o.O00000oO();
        efn.O000000o("sms_send_ticket");
        this.O00000Oo.O000000o(phoneWrapper, ega, eif).O000000o(new PhAuthPresenter$sendTicket$1(this, phoneWrapper), new PhAuthPresenter$sendTicket$2(this, phoneWrapper));
    }
}
