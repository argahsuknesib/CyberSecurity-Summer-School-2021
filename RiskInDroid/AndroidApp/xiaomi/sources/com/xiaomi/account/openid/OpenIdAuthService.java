package com.xiaomi.account.openid;

import android.accounts.Account;
import android.accounts.AuthenticatorException;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.IXiaomiAuthService;
import com.xiaomi.account.openid.ui.OAuthPresenter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OpenIdAuthService extends Service {
    public static final ExecutorService sExecutorService = Executors.newCachedThreadPool();
    private Transport mTransport = new Transport();

    public IBinder onBind(Intent intent) {
        return this.mTransport.asBinder();
    }

    class Transport extends IXiaomiAuthService.Stub {
        public int getVersionNum() {
            return 0;
        }

        public boolean supportResponseWay() throws RemoteException {
            return true;
        }

        private Transport() {
        }

        public Bundle getMiCloudUserInfo(Account account, Bundle bundle) throws RemoteException {
            throw new IllegalStateException("will not reach here");
        }

        public Bundle getMiCloudAccessToken(Account account, Bundle bundle) throws RemoteException {
            throw new IllegalStateException("will not reach here");
        }

        public Bundle getSnsAccessToken(Account account, Bundle bundle) throws RemoteException {
            throw new IllegalStateException("will not reach here");
        }

        public void invalidateAccessToken(Account account, Bundle bundle) throws RemoteException {
            throw new IllegalStateException("will not reach here");
        }

        public boolean isSupport(String str) throws RemoteException {
            if (!str.equals("FEATURE_SHUIDI") && !str.equals("FEATURE_DEV_DEVICEID")) {
                return false;
            }
            return true;
        }

        public void getAccessTokenInResponse(final IXiaomiAuthResponse iXiaomiAuthResponse, final Bundle bundle, int i, int i2) throws RemoteException {
            Log.v("OpenIdAuthService", String.format("getAccessToken called from oauth jar version %s.%s", Integer.valueOf(i), Integer.valueOf(i2)));
            OpenIdAuthService.sExecutorService.execute(new Runnable() {
                /* class com.xiaomi.account.openid.OpenIdAuthService.Transport.AnonymousClass1 */

                public void run() {
                    Bundle bundle;
                    try {
                        bundle = OpenIdAuthService.this.getCodeOrAccessToken(bundle, iXiaomiAuthResponse);
                        bundle.putInt("extra_error_code", 0);
                        bundle.putString("extra_error_description", "success");
                    } catch (OAuthException e) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("extra_error_code", e.errCode);
                        bundle2.putString("extra_error_description", e.msg);
                        if (e.intent != null) {
                            bundle2.putParcelable("extra_intent", e.intent);
                        }
                        bundle = bundle2;
                    }
                    try {
                        iXiaomiAuthResponse.onResult(bundle);
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    public Bundle getCodeOrAccessToken(Bundle bundle, IXiaomiAuthResponse iXiaomiAuthResponse) throws OAuthException {
        String string = bundle.getString("extra_client_id");
        String string2 = bundle.getString("extra_redirect_uri");
        boolean z = bundle.getBoolean("extra_native_oauth");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            throw new OAuthException(-1003, "null or empty clientId or redirectUrl");
        }
        try {
            return new OAuthRequest().quietOAuth(makeQueryParams(bundle), string2);
        } catch (AuthenticatorException | IOException unused) {
            if (z) {
                throw new OAuthException(-1003, "not support");
            }
            throw new OAuthException(OAuthPresenter.makeOAuthIntent(this, string2, makeQueryParams(bundle), iXiaomiAuthResponse), "need authorized by user");
        }
    }

    private String makeQueryParams(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("client_id", bundle.getString("extra_client_id"));
        bundle2.putString("redirect_uri", bundle.getString("extra_redirect_uri"));
        bundle2.putString("response_type", bundle.getString("extra_response_type"));
        bundle2.putString("scope", bundle.getString("extra_scope"));
        bundle2.putString("state", bundle.getString("extra_state"));
        bundle2.putString("skip_confirm", String.valueOf(bundle.getBoolean("extra_skip_confirm")));
        bundle2.putString("pt", String.valueOf(bundle.getInt("extra_platform")));
        String string = bundle.getString("extra_deviceid");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string.trim())) {
            bundle2.putString("device_id", bundle.getString("extra_deviceid"));
        }
        String string2 = bundle.getString("extra_hide_switch");
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string2.trim())) {
            bundle2.putString("_hideSwitch", string2);
        }
        String string3 = bundle.getString("extra_display");
        if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string3.trim())) {
            bundle2.putString("display", string3);
        }
        bundle2.putString("_locale", OAuthUtils.getLocaleString());
        return OAuthUtils.makeUrlQueryParams(bundle2);
    }

    static class OAuthException extends Exception {
        final int errCode;
        final Intent intent;
        final String msg;

        OAuthException(int i, String str) {
            this.errCode = i;
            this.msg = str;
            this.intent = null;
        }

        OAuthException(Intent intent2, String str) {
            this.errCode = -1001;
            this.msg = str;
            this.intent = intent2;
        }
    }
}
