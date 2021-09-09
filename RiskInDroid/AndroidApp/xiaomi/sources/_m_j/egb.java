package _m_j;

import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/ChoosePhoneSmsAuthCredential;", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "originAuthCredential", "userInfo", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "signIn", "", "(Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;Z)V", "getSignIn", "()Z", "getUserInfo", "()Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egb extends ehd {
    final RegisterUserInfo O00000oO;
    final boolean O00000oo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public egb(ehd ehd, RegisterUserInfo registerUserInfo, boolean z) {
        super(ehd.O0000OOo, ehd.O0000Oo0, ehd.O00000o);
        ixe.O00000o0(ehd, "originAuthCredential");
        ixe.O00000o0(registerUserInfo, "userInfo");
        this.O00000oO = registerUserInfo;
        this.O00000oo = z;
        this.O0000O0o = ehd.O0000O0o;
    }
}
