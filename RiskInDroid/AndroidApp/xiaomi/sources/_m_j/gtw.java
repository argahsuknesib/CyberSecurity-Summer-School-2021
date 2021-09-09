package _m_j;

import _m_j.gtx;
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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class gtw implements gtx {
    public final String atThirdAccountName(String str) {
        return null;
    }

    public final void canAccessAccount(ibh ibh) {
    }

    public final void getAccount(Context context, String str, ibh<AccountInfo, Error> ibh) {
    }

    public final int getAllThirdAccountDeviceNum() {
        return 0;
    }

    public final void getAuthorizationCode(Activity activity, String str, int[] iArr, String str2, ibr ibr) {
    }

    public final Class<?> getLoginMiuiActivity() {
        return null;
    }

    public final Class<?> getLoginTransitActivity() {
        return null;
    }

    public final String getMiSystemAccountId() {
        return null;
    }

    public final void getMiUserInfoAndProfile(LoginMiAccount loginMiAccount, ibn<MiAccountInfo> ibn) {
    }

    public final String getOauthServiceToken() {
        return null;
    }

    public final String getOauthUserId() {
        return null;
    }

    public final String getServerMachineCode() {
        return "";
    }

    public final JSONObject getThirdAccountDeviceById(String str) {
        return null;
    }

    public final Class<?> getThirdAccountGroupListActivity() {
        return null;
    }

    public final int getThirdAccountIndex(String str) {
        return 0;
    }

    public final boolean hasMiSystemAccount() {
        return false;
    }

    public final void initAccount() {
    }

    public final void initThirdAccountBind(ibh<Void, Error> ibh) {
    }

    public final void invalideOauthServiceToken() {
    }

    public final boolean isCoreReady() {
        return false;
    }

    public final boolean isMiLoggedIn() {
        return false;
    }

    public final icc logout(ibh<Void, Error> ibh, String str) {
        return null;
    }

    public final void logoutWitoutCleanPluginRecord(ibh<Void, Error> ibh) {
    }

    public final void queryFacebookBind(ibh<Boolean, Error> ibh) {
    }

    public final void queryWxBind(ibh<Boolean, Error> ibh) {
    }

    public final void refreshServiceToken(String str, ibh<MiServiceTokenInfo, Error> ibh) {
    }

    public final void setIcon(SimpleDraweeView simpleDraweeView, String str) {
    }

    public final boolean shouldInitFacebookSdk() {
        return false;
    }

    public final Dialog showLoginDialog(Activity activity, boolean z) {
        return null;
    }

    public final void startLogin(Context context, int i, gtx.O000000o o000000o) {
    }

    public final void startLoginMiByOAuth(Activity activity, int[] iArr) {
    }

    public final icc startLogout(boolean z, ibh<Void, Error> ibh) {
        return null;
    }

    public final void startMiuiLogin(Context context, Activity activity, ibq ibq) {
    }

    public final void startPwdLogin(Context context, String str, gtx.O000000o o000000o) {
    }

    public final void startSyncHomes() {
    }

    public final List<Home> getAllHomes() {
        return new ArrayList();
    }
}
