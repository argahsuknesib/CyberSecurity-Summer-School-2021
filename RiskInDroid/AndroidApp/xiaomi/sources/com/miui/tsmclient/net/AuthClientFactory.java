package com.miui.tsmclient.net;

import com.miui.tsmclient.util.EnvironmentConfig;

public class AuthClientFactory {
    public static IAuthClient createAuthClient() {
        return EnvironmentConfig.isLoginAuth() ? new TSMAuthClient() : new OAuthClient();
    }
}
