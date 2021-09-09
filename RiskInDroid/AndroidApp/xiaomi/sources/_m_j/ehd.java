package _m_j;

import com.xiaomi.passport.ui.internal.PhoneWrapper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "Lcom/xiaomi/passport/ui/internal/BaseAuthCredential;", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "ticket", "", "sid", "(Lcom/xiaomi/passport/ui/internal/PhoneWrapper;Ljava/lang/String;Ljava/lang/String;)V", "newPsw", "getNewPsw", "()Ljava/lang/String;", "setNewPsw", "(Ljava/lang/String;)V", "getPhone", "()Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "getTicket", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public class ehd extends efv {
    String O0000O0o;
    public final PhoneWrapper O0000OOo;
    final String O0000Oo0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ehd(PhoneWrapper phoneWrapper, String str, String str2) {
        super("PHONE_SMS_AUTH_PROVIDER", str2);
        ixe.O00000o0(phoneWrapper, "phone");
        ixe.O00000o0(str, "ticket");
        ixe.O00000o0(str2, "sid");
        this.O0000OOo = phoneWrapper;
        this.O0000Oo0 = str;
    }
}
