package com.xiaomi.account.openid;

public class OauthAccountManager {
    private static OauthAccount oauthAccount;

    public static OauthAccount getOauthAccount() {
        return oauthAccount;
    }

    public static void setOauthAccount(OauthAccount oauthAccount2) {
        oauthAccount = oauthAccount2;
    }
}
