package com.xiaomi.account.auth;

import android.text.TextUtils;

public class OAuthFactory {
    public static XiaomiOAuth createOAuth(OAuthConfig oAuthConfig) {
        checkOauthParams(oAuthConfig);
        if (oAuthConfig.notUseMiui) {
            return new WebViewOauth(oAuthConfig.context, oAuthConfig.appId, oAuthConfig.redirectUrl);
        }
        return new MiuiOauth(oAuthConfig.context, oAuthConfig.appId, oAuthConfig.redirectUrl);
    }

    private static void checkOauthParams(OAuthConfig oAuthConfig) {
        if (oAuthConfig.context == null) {
            throw new IllegalArgumentException("not set Context or Activity!!!");
        } else if (TextUtils.isEmpty(oAuthConfig.appId)) {
            throw new IllegalArgumentException("client id is error!!!");
        } else if (TextUtils.isEmpty(oAuthConfig.redirectUrl)) {
            throw new IllegalArgumentException("redirect url is empty!!!");
        }
    }
}
