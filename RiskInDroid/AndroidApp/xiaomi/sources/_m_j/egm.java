package _m_j;

import com.xiaomi.accountsdk.account.data.MetaLoginData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/passport/ui/internal/IdPswVStep2AuthCredential;", "Lcom/xiaomi/passport/ui/internal/IdPswBaseAuthCredential;", "id", "", "step1Token", "metaLoginData", "Lcom/xiaomi/accountsdk/account/data/MetaLoginData;", "step2code", "trustCurrentEnv", "", "sid", "(Ljava/lang/String;Ljava/lang/String;Lcom/xiaomi/accountsdk/account/data/MetaLoginData;Ljava/lang/String;ZLjava/lang/String;)V", "getMetaLoginData", "()Lcom/xiaomi/accountsdk/account/data/MetaLoginData;", "getStep1Token", "()Ljava/lang/String;", "getStep2code", "getTrustCurrentEnv", "()Z", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egm extends egk {
    public final String O00000oO;
    public final MetaLoginData O0000O0o;
    public final String O0000OOo;
    public final boolean O0000Oo0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public egm(String str, String str2, MetaLoginData metaLoginData, String str3, boolean z, String str4) {
        super(str, str4);
        ixe.O00000o0(str, "id");
        ixe.O00000o0(str2, "step1Token");
        ixe.O00000o0(metaLoginData, "metaLoginData");
        ixe.O00000o0(str3, "step2code");
        ixe.O00000o0(str4, "sid");
        this.O00000oO = str2;
        this.O0000O0o = metaLoginData;
        this.O0000OOo = str3;
        this.O0000Oo0 = z;
    }
}
