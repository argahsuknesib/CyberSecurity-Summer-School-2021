package _m_j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;

public interface gfu extends gze {
    Fragment createGlobalShopFragment();

    Class<? extends Fragment> getFragmentClass();

    void initMiShopGlobalSDK(boolean z);

    boolean isShowGlobalShop(Context context);

    void onChangeServer(ServerBean serverBean);

    void onLoginSuccess();

    void onLogout();

    void setCanCheckPermission(boolean z);

    boolean showPrivacyDiaglogIfNeed(Activity activity, View view);
}
