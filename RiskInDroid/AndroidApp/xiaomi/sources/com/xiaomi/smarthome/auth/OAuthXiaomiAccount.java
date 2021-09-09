package com.xiaomi.smarthome.auth;

import _m_j.fsp;
import _m_j.ft;
import _m_j.gsy;
import _m_j.gty;
import _m_j.ici;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.xiaomi.account.openid.OauthAccount;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.io.IOException;

public class OAuthXiaomiAccount implements OauthAccount {

    /* renamed from: O000000o  reason: collision with root package name */
    private MiAccountManager f4266O000000o;
    private Context O00000Oo;

    public OAuthXiaomiAccount(Context context) {
        this.O00000Oo = context;
        this.f4266O000000o = MiAccountManager.O00000Oo(context);
    }

    public void getLoginStatus(final ValueCallback<Boolean> valueCallback) {
        CoreApi.O000000o().O000000o(this.O00000Oo, new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.auth.OAuthXiaomiAccount.AnonymousClass1 */

            public final void onCoreReady() {
                gsy.O00000Oo("OAuthXiaomiAccount", "isLogin " + CoreApi.O000000o().O0000Ooo());
                valueCallback.onReceiveValue(Boolean.valueOf(CoreApi.O000000o().O0000Ooo()));
            }
        });
    }

    public void login(Activity activity, final OauthAccount.LoginFinishedListener loginFinishedListener) {
        gsy.O00000Oo("OAuthXiaomiAccount", "login");
        if (loginFinishedListener != null) {
            final ft O000000o2 = ft.O000000o(fsp.O000000o().O00000Oo);
            O000000o2.O000000o(new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.auth.OAuthXiaomiAccount.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    if ("action.passwordlogin.login.complete".equals(intent.getAction())) {
                        O000000o2.O000000o(this);
                        if (intent.getBooleanExtra("login_success", false)) {
                            loginFinishedListener.onSuccess();
                        } else {
                            loginFinishedListener.canceled();
                        }
                    }
                }
            }, new IntentFilter("action.passwordlogin.login.complete"));
            gty.O000000o().startLogin(activity.getApplicationContext(), 6, null);
            return;
        }
        throw new IllegalArgumentException("loginFinishedListener == null");
    }

    public String getUserId() {
        gsy.O00000Oo("OAuthXiaomiAccount", "getUserId " + CoreApi.O000000o().O0000o0());
        return CoreApi.O000000o().O0000o0();
    }

    public String getServiceToken() {
        if (CoreApi.O000000o().O0000oO0()) {
            Bundle bundle = null;
            try {
                bundle = AccountManager.get(this.O00000Oo).getAuthToken(ici.O00000o0(this.O00000Oo), "oauth2.0", true, null, null).getResult();
            } catch (OperationCanceledException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (AuthenticatorException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (bundle != null) {
                String string = bundle.getString("authtoken");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split(",");
                    if (split.length >= 2) {
                        String str = split[0];
                        gsy.O00000Oo("OAuthXiaomiAccount", "getServiceToken ".concat(String.valueOf(str)));
                        return str;
                    }
                }
            }
            gsy.O00000Oo("OAuthXiaomiAccount", "getServiceToken empty");
            return "";
        }
        String str2 = this.f4266O000000o.O000000o(this.O00000Oo, "oauth2.0").get().O00000Oo;
        gsy.O00000Oo("OAuthXiaomiAccount", "getServiceToken ".concat(String.valueOf(str2)));
        return str2;
    }

    public void invalideServiceToken() {
        gsy.O00000Oo("OAuthXiaomiAccount", "invalideServiceToken");
        MiAccountManager.O00000Oo(this.O00000Oo).O000000o(this.O00000Oo, this.f4266O000000o.O000000o(this.O00000Oo, "oauth2.0").get());
    }
}
