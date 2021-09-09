package com.miui.tsmclient.net;

import com.miui.tsmclient.account.AccountInfo;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequest;
import java.io.IOException;
import java.net.CookieHandler;

class TSMAuthClient extends BaseAuthClient {
    TSMAuthClient() {
    }

    public Object sendPostRequest(AccountInfo accountInfo, AuthRequest authRequest) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, AuthApiException {
        if (accountInfo == null) {
            return null;
        }
        CookieHandler cookieHandler = CookieHandler.getDefault();
        try {
            authRequest.addParams("userId", accountInfo.getUserId());
            return handleResult(SecureRequest.postAsString(authRequest.getRequestFullUrl(), authRequest.getParams(), authRequest.getCookies(), true, accountInfo.getSecurity()).getBody(), authRequest.getRespContentType());
        } finally {
            CookieHandler.setDefault(cookieHandler);
        }
    }

    public Object sendGetRequest(AccountInfo accountInfo, AuthRequest authRequest) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, AuthApiException {
        if (accountInfo == null) {
            return null;
        }
        CookieHandler cookieHandler = CookieHandler.getDefault();
        try {
            authRequest.addParams("userId", accountInfo.getUserId());
            return handleResult(SecureRequest.getAsString(authRequest.getRequestFullUrl(), authRequest.getParams(), authRequest.getCookies(), true, accountInfo.getSecurity()).getBody(), authRequest.getRespContentType());
        } finally {
            CookieHandler.setDefault(cookieHandler);
        }
    }
}
