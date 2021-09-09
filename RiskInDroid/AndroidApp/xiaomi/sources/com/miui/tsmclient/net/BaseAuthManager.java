package com.miui.tsmclient.net;

import android.content.Context;
import com.miui.tsmclient.account.AccountInfo;
import com.miui.tsmclient.account.AccountManagerFactory;
import com.miui.tsmclient.account.IAccountManager;
import com.miui.tsmclient.common.net.HttpLifecycleManager;
import com.miui.tsmclient.common.net.host.AuthHost;
import com.miui.tsmclient.common.net.host.Host;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.NetworkUtil;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import java.io.IOException;

public class BaseAuthManager {
    protected IAccountManager mAccountManager = AccountManagerFactory.createAccountManager();
    private IAuthClient mAuthClient = AuthClientFactory.createAuthClient();
    protected Host mHost;

    public BaseAuthManager() {
        initHost();
    }

    /* access modifiers changed from: protected */
    public Object sendRequest(Context context, AccountInfo accountInfo, AuthRequest authRequest) throws AuthApiException {
        return sendRequestMiddle(context, accountInfo, authRequest, "POST");
    }

    /* access modifiers changed from: protected */
    public Object sendGetRequest(Context context, AccountInfo accountInfo, AuthRequest authRequest) throws AuthApiException {
        return sendRequestMiddle(context, accountInfo, authRequest, "GET");
    }

    private Object sendRequestMiddle(Context context, AccountInfo accountInfo, AuthRequest authRequest, String str) throws AuthApiException {
        if (NetworkUtil.isConnected(context)) {
            String requestFullUrl = authRequest.getRequestFullUrl();
            try {
                HttpLifecycleManager.getInstance().onStart(requestFullUrl);
                Object sendRequestInternal = sendRequestInternal(context, accountInfo, authRequest, str);
                HttpLifecycleManager.getInstance().onStop(requestFullUrl, 200);
                LogUtils.t("BaseAuthManager request_url:" + requestFullUrl + " response:" + sendRequestInternal);
                return sendRequestInternal;
            } catch (AuthApiException e) {
                throw e;
            } catch (Throwable th) {
                HttpLifecycleManager.getInstance().onStop(requestFullUrl, -1);
                LogUtils.t("BaseAuthManager request_url:" + requestFullUrl + " response:" + ((Object) null));
                throw th;
            }
        } else {
            throw new AuthApiException(2);
        }
    }

    private Object sendRequestInternal(Context context, AccountInfo accountInfo, AuthRequest authRequest, String str) throws AuthApiException {
        try {
            if ("POST".equals(str)) {
                return this.mAuthClient.sendPostRequest(accountInfo, authRequest);
            }
            if ("GET".equals(str)) {
                return this.mAuthClient.sendGetRequest(accountInfo, authRequest);
            }
            throw new AuthApiException(7);
        } catch (AccessDeniedException e) {
            LogUtils.e(authRequest.getClass().getName() + " send failed with an AccessDeniedException!So return null!", e);
        } catch (AuthenticationFailureException e2) {
            LogUtils.e(authRequest.getClass().getName() + " send failed with an AuthenticationFailureException!Now retry", e2);
            return retry(context, accountInfo, authRequest, false);
        } catch (InvalidResponseException | IOException e3) {
            LogUtils.e(authRequest.getClass().getName() + " send failed! So return null!", e3);
            throw new AuthApiException(2);
        } catch (CipherException e4) {
            LogUtils.e(authRequest.getClass().getName() + " send failed with a CipherException!So return null!", e4);
        }
    }

    /* access modifiers changed from: protected */
    public void initHost() {
        this.mHost = new AuthHost();
    }

    /* access modifiers changed from: protected */
    public AccountInfo getAccountInfo(Context context) throws AuthApiException {
        AccountInfo loadAccountInfo = this.mAccountManager.loadAccountInfo(context, this.mHost.getServiceId());
        if (loadAccountInfo != null && loadAccountInfo.isValid()) {
            return loadAccountInfo;
        }
        throw new AuthApiException(14);
    }

    private Object retry(Context context, AccountInfo accountInfo, AuthRequest authRequest, boolean z) throws AuthApiException {
        this.mAccountManager.resetAccount(context, accountInfo.getAuthToken());
        AccountInfo accountInfo2 = getAccountInfo(context);
        if (!z) {
            return this.mAuthClient.sendGetRequest(accountInfo2, authRequest);
        }
        try {
            return this.mAuthClient.sendPostRequest(accountInfo2, authRequest);
        } catch (IOException unused) {
            throw new AuthApiException(2);
        } catch (Exception e) {
            LogUtils.e("An AuthenticationFailureException happened, so retry, but still failed!", e);
            throw new AuthApiException(7);
        }
    }
}
