package _m_j;

import _m_j.eht;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PswSignInContract;", "", "()V", "Presenter", "View", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehi {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&J \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0004H&J0\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H&¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PswSignInContract$Presenter;", "", "getSignedInUserIds", "", "", "()[Ljava/lang/String;", "signInIdAndPsw", "", "id", "psw", "signInIdAndPswWithCountryCode", "cc", "signInPhoneAndPsw", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "signInVStep2", "step1Token", "metaLoginData", "Lcom/xiaomi/accountsdk/account/data/MetaLoginData;", "step2code", "trustCurrentEnv", "", "signInWithAuthCredential", "authCredential", "Lcom/xiaomi/passport/ui/internal/IdPswBaseAuthCredential;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public interface O000000o {
        void O000000o(String str, String str2, MetaLoginData metaLoginData, String str3, boolean z);

        void O000000o(String str, String str2, String str3);

        String[] O000000o();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PswSignInContract$View;", "Lcom/xiaomi/passport/ui/internal/SignInContract$View;", "showPswError", "", "msg", "", "showUserNameError", "showVStep2Code", "authCredential", "Lcom/xiaomi/passport/ui/internal/IdPswBaseAuthCredential;", "step1Token", "metaLoginData", "Lcom/xiaomi/accountsdk/account/data/MetaLoginData;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public interface O00000Oo extends eht.O000000o {
        void O000000o(egk egk, String str, MetaLoginData metaLoginData);

        void O000000o(String str);

        void O00000Oo(String str);
    }
}
