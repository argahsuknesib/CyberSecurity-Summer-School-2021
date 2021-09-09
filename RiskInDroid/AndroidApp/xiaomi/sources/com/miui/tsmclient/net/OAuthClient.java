package com.miui.tsmclient.net;

import com.miui.tsmclient.account.AccountInfo;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import java.io.IOException;

class OAuthClient extends BaseAuthClient {
    OAuthClient() {
    }

    public Object sendPostRequest(AccountInfo accountInfo, AuthRequest authRequest) throws AccessDeniedException, AuthenticationFailureException, IOException, AuthApiException {
        if (accountInfo == null) {
            return null;
        }
        authRequest.addParams("clientId", EnvironmentConfig.getClientId());
        authRequest.addParams("token", accountInfo.getAuthToken());
        authRequest.addParams("userId", accountInfo.getUserId());
        return handleResult(SimpleRequest.postAsString(authRequest.getRequestFullUrl(), authRequest.getParams(), authRequest.getCookies(), true).getBody(), authRequest.getRespContentType());
    }

    public Object sendGetRequest(AccountInfo accountInfo, AuthRequest authRequest) throws AccessDeniedException, AuthenticationFailureException, IOException, AuthApiException {
        if (accountInfo == null) {
            return null;
        }
        authRequest.addParams("clientId", EnvironmentConfig.getClientId());
        authRequest.addParams("token", accountInfo.getAuthToken());
        authRequest.addParams("userId", accountInfo.getUserId());
        return handleResult(SimpleRequest.getAsString(authRequest.getRequestFullUrl(), authRequest.getParams(), authRequest.getCookies(), true).getBody(), authRequest.getRespContentType());
    }
}
