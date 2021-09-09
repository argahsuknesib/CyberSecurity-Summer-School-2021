package _m_j;

import androidx.fragment.app.Fragment;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AddAccountListener;", "", "goBack", "", "closeWebView", "", "gotoFragment", "fragment", "Landroidx/fragment/app/Fragment;", "addToBackStack", "loginCancelled", "loginSuccess", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public interface efp {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    public static final class O000000o {
    }

    void goBack(boolean z);

    void gotoFragment(Fragment fragment, boolean z);

    void loginCancelled();

    void loginSuccess(AccountInfo accountInfo);
}
