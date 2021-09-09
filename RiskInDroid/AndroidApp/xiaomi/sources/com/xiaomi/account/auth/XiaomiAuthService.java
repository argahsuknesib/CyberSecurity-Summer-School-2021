package com.xiaomi.account.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.IXiaomiAuthService;
import com.xiaomi.account.openauth.AuthorizeActivityBase;
import com.xiaomi.account.openauth.XMAuthericationException;
import java.io.IOException;
import miui.net.IXiaomiAuthService;

public class XiaomiAuthService implements IXiaomiAuthService {
    private IXiaomiAuthService mAuthService;
    private miui.net.IXiaomiAuthService mMiuiV5AuthService;

    public Bundle getMiCloudUserInfo(Account account, Bundle bundle) throws RemoteException {
        return null;
    }

    public Bundle getSnsAccessToken(Account account, Bundle bundle) throws RemoteException {
        return null;
    }

    XiaomiAuthService(IBinder iBinder) {
        try {
            this.mAuthService = IXiaomiAuthService.Stub.asInterface(iBinder);
        } catch (SecurityException unused) {
            this.mMiuiV5AuthService = IXiaomiAuthService.Stub.asInterface(iBinder);
        }
    }

    public Bundle getMiCloudAccessToken(Account account, Bundle bundle) throws RemoteException {
        com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService = this.mAuthService;
        if (iXiaomiAuthService != null) {
            return iXiaomiAuthService.getMiCloudAccessToken(account, bundle);
        }
        miui.net.IXiaomiAuthService iXiaomiAuthService2 = this.mMiuiV5AuthService;
        if (iXiaomiAuthService2 == null) {
            return null;
        }
        iXiaomiAuthService2.invalidateAccessToken(account, bundle);
        return this.mMiuiV5AuthService.getMiCloudAccessToken(account, bundle);
    }

    public void invalidateAccessToken(Account account, Bundle bundle) throws RemoteException {
        miui.net.IXiaomiAuthService iXiaomiAuthService = this.mMiuiV5AuthService;
        if (iXiaomiAuthService != null) {
            iXiaomiAuthService.invalidateAccessToken(account, bundle);
        }
    }

    public boolean supportResponseWay() throws RemoteException {
        com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService = this.mAuthService;
        if (iXiaomiAuthService != null) {
            return iXiaomiAuthService.supportResponseWay();
        }
        return false;
    }

    public void getAccessTokenInResponse(IXiaomiAuthResponse iXiaomiAuthResponse, Bundle bundle, int i, int i2) throws RemoteException {
        com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService = this.mAuthService;
        if (iXiaomiAuthService != null) {
            iXiaomiAuthService.getAccessTokenInResponse(iXiaomiAuthResponse, bundle, i, i2);
        }
    }

    public int getVersionNum() throws RemoteException {
        com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService = this.mAuthService;
        if (iXiaomiAuthService != null) {
            return iXiaomiAuthService.getVersionNum();
        }
        return 0;
    }

    public boolean isSupport(String str) throws RemoteException {
        com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService = this.mAuthService;
        if (iXiaomiAuthService != null) {
            return iXiaomiAuthService.isSupport(str);
        }
        return false;
    }

    public IBinder asBinder() {
        throw new IllegalStateException();
    }

    private boolean supportNativeOAuth() throws RemoteException {
        return getVersionNum() > 0;
    }

    public void oauthInResponse(Context context, IXiaomiAuthResponse iXiaomiAuthResponse, OAuthConfig oAuthConfig) throws RemoteException, XMAuthericationException, FallBackWebOAuthException {
        final Bundle makeOptions = oAuthConfig.makeOptions();
        makeOptions.putString("extra_client_id", String.valueOf(oAuthConfig.appId));
        makeOptions.putString("extra_redirect_uri", oAuthConfig.redirectUrl);
        if (!oAuthConfig.fastOAuth || supportNativeOAuth()) {
            String str = oAuthConfig.deviceID;
            if (oAuthConfig.platform == 1 && !isSupport("FEATURE_SHUIDI")) {
                throw new FallBackWebOAuthException();
            } else if (oAuthConfig.platform == 0 && !isSupport("FEATURE_DEV_DEVICEID") && !TextUtils.isEmpty(str)) {
                throw new FallBackWebOAuthException();
            } else if (supportResponseWay()) {
                this.mAuthService.getAccessTokenInResponse(iXiaomiAuthResponse, makeOptions, 1, 82);
            } else {
                final Context context2 = context;
                final IXiaomiAuthResponse iXiaomiAuthResponse2 = iXiaomiAuthResponse;
                final OAuthConfig oAuthConfig2 = oAuthConfig;
                AsyncTask.execute(new Runnable() {
                    /* class com.xiaomi.account.auth.XiaomiAuthService.AnonymousClass1 */

                    public void run() {
                        try {
                            XiaomiAuthService.this.miuiv5(context2, iXiaomiAuthResponse2, oAuthConfig2, makeOptions);
                        } catch (OperationCanceledException unused) {
                            XiaomiAuthService.this.onCancel(iXiaomiAuthResponse2);
                        } catch (RemoteException e) {
                            Log.e("OAuth", "", e);
                            XiaomiAuthService.this.onCancel(iXiaomiAuthResponse2);
                        } catch (XMAuthericationException e2) {
                            Log.e("OAuth", "", e2);
                            XiaomiAuthService.this.onCancel(iXiaomiAuthResponse2);
                        }
                    }
                });
            }
        } else {
            throw new XMAuthericationException("this version of miui not support fast Oauth");
        }
    }

    public void onCancel(IXiaomiAuthResponse iXiaomiAuthResponse) {
        try {
            iXiaomiAuthResponse.onCancel();
        } catch (RemoteException unused) {
        }
    }

    public void miuiv5(Context context, IXiaomiAuthResponse iXiaomiAuthResponse, OAuthConfig oAuthConfig, Bundle bundle) throws OperationCanceledException, RemoteException, XMAuthericationException {
        Account xiaomiAccount = getXiaomiAccount(context);
        if (xiaomiAccount == null) {
            Intent addXiaomiAccount = addXiaomiAccount(context);
            if (addXiaomiAccount != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("extra_intent", addXiaomiAccount);
                iXiaomiAuthResponse.onResult(bundle2);
            }
            xiaomiAccount = getXiaomiAccount(context);
        }
        if (xiaomiAccount != null) {
            Bundle miCloudAccessToken = this.mMiuiV5AuthService.getMiCloudAccessToken(xiaomiAccount, bundle);
            if (miCloudAccessToken == null) {
                throw new XMAuthericationException("getMiCloudAccessToken return null");
            } else if (!miCloudAccessToken.containsKey("extra_intent")) {
                iXiaomiAuthResponse.onResult(miCloudAccessToken);
            } else {
                Intent intent = (Intent) miCloudAccessToken.getParcelable("extra_intent");
                if (intent != null) {
                    Intent asMiddleActivity = AuthorizeActivityBase.asMiddleActivity(context, intent, iXiaomiAuthResponse, oAuthConfig.authorizeActivityClazz);
                    Bundle bundle3 = (Bundle) miCloudAccessToken.clone();
                    bundle3.putParcelable("extra_intent", asMiddleActivity);
                    iXiaomiAuthResponse.onResult(bundle3);
                    return;
                }
                throw new XMAuthericationException("intent == null");
            }
        } else {
            throw new XMAuthericationException("Xiaomi Account not Login");
        }
    }

    @SuppressLint({"MissingPermission"})
    private Account getXiaomiAccount(Context context) {
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.xiaomi");
            if (accountsByType.length == 0) {
                return null;
            }
            return accountsByType[0];
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private Intent addXiaomiAccount(Context context) throws OperationCanceledException {
        try {
            Bundle result = AccountManager.get(context).addAccount("com.xiaomi", null, null, null, null, null, null).getResult();
            if (result == null || !result.containsKey("intent")) {
                return null;
            }
            return (Intent) result.getParcelable("intent");
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (AuthenticatorException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
