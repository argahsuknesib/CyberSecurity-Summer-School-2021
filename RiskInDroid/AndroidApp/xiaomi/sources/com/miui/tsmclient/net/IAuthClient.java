package com.miui.tsmclient.net;

import com.miui.tsmclient.account.AccountInfo;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import java.io.IOException;

public interface IAuthClient {
    Object sendGetRequest(AccountInfo accountInfo, AuthRequest authRequest) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, AuthApiException;

    Object sendPostRequest(AccountInfo accountInfo, AuthRequest authRequest) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, AuthApiException;
}
