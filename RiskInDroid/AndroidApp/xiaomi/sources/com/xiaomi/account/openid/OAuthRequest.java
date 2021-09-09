package com.xiaomi.account.openid;

import android.accounts.AuthenticatorException;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.xiaomi.account.http.HttpClient;
import com.xiaomi.account.http.Request;
import com.xiaomi.account.http.Response;
import com.xiaomi.account.http.UrlConnHttpFactory;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.account.openid.OpenIdAuthService;
import com.xiaomi.account.utils.OAuthUrlPaser;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

class OAuthRequest {
    private static final String AUTHORIZE_PATH = (XiaomiOAuthConstants.OAUTH2_HOST + "/oauth2/authorize");
    public boolean mIsLogin;
    private OauthAccount mOauthAccount = OauthAccountManager.getOauthAccount();

    OAuthRequest() {
    }

    public Bundle quietOAuth(String str, String str2) throws AuthenticatorException, IOException, OpenIdAuthService.OAuthException {
        return getOAuthResult(str, str2);
    }

    private Bundle getOAuthResult(String str, String str2) throws AuthenticatorException, IOException, OpenIdAuthService.OAuthException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        OauthAccount oauthAccount = this.mOauthAccount;
        if (oauthAccount != null) {
            oauthAccount.getLoginStatus(new ValueCallback<Boolean>() {
                /* class com.xiaomi.account.openid.OAuthRequest.AnonymousClass1 */

                public void onReceiveValue(Boolean bool) {
                    OAuthRequest.this.mIsLogin = bool.booleanValue();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.mIsLogin) {
                int i = 0;
                while (i < 2) {
                    HttpClient createHttpClient = new UrlConnHttpFactory().createHttpClient();
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("userId", this.mOauthAccount.getUserId());
                    hashMap2.put("serviceToken", this.mOauthAccount.getServiceToken());
                    hashMap.put("Cookie", OAuthUtils.cookieToString(hashMap2));
                    Response excute = createHttpClient.excute(new Request.Builder().url(getUrl(str)).followRedirects(false).headers(hashMap).build());
                    if (excute.location == null) {
                        throw new AuthenticatorException();
                    } else if (excute.location.startsWith(str2)) {
                        return OAuthUrlPaser.parse(excute.location);
                    } else {
                        this.mOauthAccount.invalideServiceToken();
                        i++;
                    }
                }
            }
            throw new AuthenticatorException();
        }
        throw new AuthenticatorException();
    }

    private String getUrl(String str) {
        return AUTHORIZE_PATH + "?" + str;
    }
}
