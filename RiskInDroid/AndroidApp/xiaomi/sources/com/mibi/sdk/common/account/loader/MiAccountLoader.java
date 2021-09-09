package com.mibi.sdk.common.account.loader;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.account.AccountInteractActivity;
import com.mibi.sdk.common.account.AccountInteractHelper;
import com.mibi.sdk.common.account.AccountRegistry;
import com.mibi.sdk.common.account.AccountToken;
import com.mibi.sdk.common.account.AccountUtils;
import com.mibi.sdk.common.account.ExtendedAuthToken;
import com.mibi.sdk.common.account.IServiceTokenFuture;
import com.mibi.sdk.common.account.IServiceTokenResult;
import com.mibi.sdk.common.exception.AccountChangedException;
import com.mibi.sdk.common.exception.AccountException;
import com.mibi.sdk.common.exception.AccountThrottingException;
import com.mibi.sdk.common.exception.ConnectionException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.utils.MibiLog;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MiAccountLoader implements AccountLoader {
    public static final Parcelable.Creator<AccountLoader> CREATOR = new Parcelable.Creator<AccountLoader>() {
        /* class com.mibi.sdk.common.account.loader.MiAccountLoader.AnonymousClass1 */

        public final AccountLoader createFromParcel(Parcel parcel) {
            return new MiAccountLoader((Account) parcel.readParcelable(null));
        }

        public final AccountLoader[] newArray(int i) {
            return new MiAccountLoader[i];
        }
    };
    private static final AccountToken INVALID_ACCOUNT_TOKEN = new AccountToken("", "", "", "");
    private final Account mAccount;
    private AccountToken mAccountToken;

    public int describeContents() {
        return 0;
    }

    public MiAccountLoader(Account account) {
        this.mAccount = account;
    }

    public String getUserId() {
        return this.mAccount.name;
    }

    public synchronized AccountToken getAccountToken() {
        return this.mAccountToken;
    }

    public boolean isAccountChanged(Context context) {
        return !TextUtils.equals(AccountUtils.getMiUserId(), getUserId());
    }

    public void load(Context context) throws PaymentException {
        if (!isAccountChanged(context)) {
            loadAccountInfo(context);
            return;
        }
        throw new AccountChangedException();
    }

    public void reload(Context context) throws PaymentException {
        if (!isAccountChanged(context)) {
            invalidAuthToken();
            loadAccountInfo(context);
            return;
        }
        throw new AccountChangedException();
    }

    private void invalidAuthToken() {
        String authToken = this.mAccountToken.getAuthToken();
        if (!TextUtils.isEmpty(authToken)) {
            AccountRegistry.getAccountProvider().invalidateAuthToken("com.xiaomi", authToken);
        }
    }

    private synchronized void loadAccountInfo(Context context) throws PaymentException {
        if (TextUtils.isEmpty(CommonConstants.TOKEN_TYPE)) {
            CommonConstants.TOKEN_TYPE = Utils.getStringPref(context, "tokenType", "AUTH_TOKEN");
        }
        if ("SERVICE_TOKEN".equals(CommonConstants.TOKEN_TYPE)) {
            loadAccountInfoByServiceToken(context);
        } else {
            loadAccountInfoByAuthToken(context);
        }
    }

    private void loadAccountInfoByServiceToken(Context context) throws PaymentException {
        MibiLog.d("MiAccountLoader", "load by get service token");
        IServiceTokenFuture serviceToken = AccountRegistry.getAccountProvider().getServiceToken(context, CommonConstants.SERVICE_ID);
        try {
            IServiceTokenResult iServiceTokenResult = serviceToken.get(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, TimeUnit.MILLISECONDS);
            if (serviceToken.isDone() && iServiceTokenResult != null) {
                String userId = iServiceTokenResult.getUserId();
                String serviceToken2 = iServiceTokenResult.getServiceToken();
                if (TextUtils.isEmpty(serviceToken2)) {
                    Intent intent = iServiceTokenResult.getIntent();
                    if (intent == null) {
                        String str = "authtoken is empty dueto error " + iServiceTokenResult.getErrorCodeName() + ": " + iServiceTokenResult.getErrorMessage();
                        MibiLog.d("MiAccountLoader", str);
                        throw new AccountException(new ResultException(str));
                    } else if (waitInteractionResult(context, intent, CommonConstants.SERVICE_ID)) {
                        loadAccountInfoByServiceToken(context);
                    } else {
                        throw new AccountThrottingException();
                    }
                }
                if (TextUtils.isEmpty(userId)) {
                    MibiLog.d("MiAccountLoader", "uid is empty");
                    throw new AccountException(new ResultException("uid is empty"));
                } else if (TextUtils.equals(userId, this.mAccount.name)) {
                    String security = iServiceTokenResult.getSecurity();
                    if (TextUtils.isEmpty(serviceToken2) || TextUtils.isEmpty(security)) {
                        MibiLog.d("MiAccountLoader", "serviceToken or security is empty");
                        throw new AccountException(new ResultException("serviceToken or security is empty"));
                    }
                    this.mAccountToken = new AccountToken(userId, serviceToken2 + "," + security, serviceToken2, security);
                    return;
                } else {
                    throw new AccountChangedException();
                }
            }
        } catch (Exception e) {
            MibiLog.d("MiAccountLoader", "getToken failed : " + e.getMessage());
        }
        throw new AccountException();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mibi.sdk.common.account.IAccountProvider.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>
     arg types: [android.accounts.Account, java.lang.String, ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY]]
     candidates:
      com.mibi.sdk.common.account.IAccountProvider.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>
      com.mibi.sdk.common.account.IAccountProvider.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle> */
    private void loadAccountInfoByAuthToken(Context context) throws PaymentException {
        MibiLog.d("MiAccountLoader", "load by get auth token");
        AccountManagerFuture<Bundle> authToken = AccountRegistry.getAccountProvider().getAuthToken(this.mAccount, CommonConstants.SERVICE_ID, (Bundle) null, true, (AccountManagerCallback<Bundle>) null, (Handler) null);
        try {
            Bundle result = authToken.getResult(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, TimeUnit.MILLISECONDS);
            if (!authToken.isDone() || result == null) {
                throw new AccountException();
            }
            String string = result.getString("authAccount");
            String string2 = result.getString("authtoken");
            if (TextUtils.isEmpty(string2)) {
                Intent intent = (Intent) result.getParcelable("intent");
                if (intent == null) {
                    String str = "authtoken is empty dueto error " + result.getInt("errorCode") + ": " + result.getString("errorMessage");
                    MibiLog.d("MiAccountLoader", str);
                    throw new AccountException(new ResultException(str));
                } else if (waitInteractionResult(context, intent, CommonConstants.SERVICE_ID)) {
                    loadAccountInfoByAuthToken(context);
                } else {
                    throw new AccountThrottingException();
                }
            }
            if (TextUtils.isEmpty(string)) {
                MibiLog.d("MiAccountLoader", "uid is empty");
                throw new AccountException(new ResultException("uid is empty"));
            } else if (TextUtils.equals(string, this.mAccount.name)) {
                ExtendedAuthToken parse = ExtendedAuthToken.parse(string2);
                if (parse == null) {
                    MibiLog.d("MiAccountLoader", "Cannot parse ext token");
                    throw new AccountException(new ResultException("Cannot parse ext token"));
                } else if (TextUtils.isEmpty(parse.authToken) || TextUtils.isEmpty(parse.security)) {
                    MibiLog.d("MiAccountLoader", "serviceToken or security is empty");
                    throw new AccountException(new ResultException("serviceToken or security is empty"));
                } else {
                    this.mAccountToken = new AccountToken(string, string2, parse.authToken, parse.security);
                }
            } else {
                throw new AccountChangedException();
            }
        } catch (OperationCanceledException e) {
            MibiLog.d("MiAccountLoader", "operation canceled : " + e.getMessage());
            throw new AccountException(e);
        } catch (AuthenticatorException e2) {
            MibiLog.d("MiAccountLoader", "authenticator exception : " + e2.getMessage());
            throw new AccountException(e2);
        } catch (IOException e3) {
            MibiLog.d("MiAccountLoader", "IOException : " + e3.getMessage());
            throw new AccountException(new ConnectionException(e3));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAccount, i);
    }

    private boolean waitInteractionResult(Context context, Intent intent, String str) {
        AccountInteractHelper.registerUserInteraction(str);
        try {
            synchronized (AccountInteractHelper.sUserInteractionSet) {
                if (AccountInteractHelper.mInteractionResult) {
                    AccountInteractHelper.unregisterUserInteraction(str);
                    return true;
                }
                AccountInteractHelper.mInteractionResult = false;
                AccountInteractActivity.startActivity(context, intent, 1001);
                MibiLog.d("MiAccountLoader", "go to throttle page");
                synchronized (AccountInteractHelper.sInteractionWaitingLock) {
                    AccountInteractHelper.sInteractionWaitingLock.wait(300000);
                }
                MibiLog.d("MiAccountLoader", "wait interaction result: " + AccountInteractHelper.mInteractionResult);
            }
        } catch (Exception e) {
            MibiLog.e("MiAccountLoader", "throw throttle exception", e);
        }
        boolean z = AccountInteractHelper.mInteractionResult;
        AccountInteractHelper.unregisterUserInteraction(str);
        return z;
    }
}
