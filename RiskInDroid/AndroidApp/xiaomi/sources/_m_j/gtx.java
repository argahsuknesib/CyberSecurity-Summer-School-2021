package _m_j;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiAccountInfo;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.List;
import org.json.JSONObject;

public interface gtx extends gze {

    public static class O000000o {
        public void O000000o() {
        }
    }

    String atThirdAccountName(String str);

    void canAccessAccount(ibh ibh);

    void getAccount(Context context, String str, ibh<AccountInfo, Error> ibh);

    List<Home> getAllHomes();

    int getAllThirdAccountDeviceNum();

    void getAuthorizationCode(Activity activity, String str, int[] iArr, String str2, ibr ibr);

    Class<?> getLoginMiuiActivity();

    Class<?> getLoginTransitActivity();

    String getMiSystemAccountId();

    void getMiUserInfoAndProfile(LoginMiAccount loginMiAccount, ibn<MiAccountInfo> ibn);

    String getOauthServiceToken();

    String getOauthUserId();

    String getServerMachineCode();

    JSONObject getThirdAccountDeviceById(String str);

    Class<?> getThirdAccountGroupListActivity();

    int getThirdAccountIndex(String str);

    boolean hasMiSystemAccount();

    void initAccount();

    void initThirdAccountBind(ibh<Void, Error> ibh);

    void invalideOauthServiceToken();

    boolean isCoreReady();

    boolean isMiLoggedIn();

    icc logout(ibh<Void, Error> ibh, String str);

    void logoutWitoutCleanPluginRecord(ibh<Void, Error> ibh);

    void queryFacebookBind(ibh<Boolean, Error> ibh);

    void queryWxBind(ibh<Boolean, Error> ibh);

    void refreshServiceToken(String str, ibh<MiServiceTokenInfo, Error> ibh);

    void setIcon(SimpleDraweeView simpleDraweeView, String str);

    boolean shouldInitFacebookSdk();

    Dialog showLoginDialog(Activity activity, boolean z);

    void startLogin(Context context, int i, O000000o o000000o);

    void startLoginMiByOAuth(Activity activity, int[] iArr);

    icc startLogout(boolean z, ibh<Void, Error> ibh);

    void startMiuiLogin(Context context, Activity activity, ibq ibq);

    void startPwdLogin(Context context, String str, O000000o o000000o);

    void startSyncHomes();
}
