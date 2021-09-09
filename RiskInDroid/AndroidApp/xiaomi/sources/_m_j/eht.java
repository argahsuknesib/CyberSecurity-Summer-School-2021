package _m_j;

import androidx.fragment.app.Fragment;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.ui.internal.NeedBindSnsException;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SignInContract;", "", "()V", "View", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eht {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&JH\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00030\u0017H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&¨\u0006\""}, d2 = {"Lcom/xiaomi/passport/ui/internal/SignInContract$View;", "", "dismissProgress", "", "gotoBindSnsFragment", "e", "Lcom/xiaomi/passport/ui/internal/NeedBindSnsException;", "gotoFragment", "fragment", "Landroidx/fragment/app/Fragment;", "addToBackStack", "", "loginCancelled", "loginSuccess", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "openNotificationUrl", "url", "", "showCaptcha", "captcha", "Lcom/xiaomi/passport/ui/internal/Captcha;", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "ick", "showNetworkError", "Ljava/io/IOException;", "showProgress", "showUnKnowError", "tr", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public interface O000000o {

        @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
        /* renamed from: _m_j.eht$O000000o$O000000o  reason: collision with other inner class name */
        public static final class C0103O000000o {
        }

        void O000000o(efz efz, iwn<? super String, ? super String, iuh> iwn);

        void O000000o(Fragment fragment, boolean z);

        void O000000o(AccountInfo accountInfo);

        void O000000o(NeedBindSnsException needBindSnsException);

        void O000000o(IOException iOException);

        void O000000o(Throwable th);

        void O00000o(String str);

        void O00000oO();

        void O00000oo();
    }
}
