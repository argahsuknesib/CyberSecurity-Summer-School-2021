package com.mibi.sdk.common.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public interface IAccountProvider {
    AccountManagerFuture<Bundle> addAccount(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler);

    Account[] getAccounts();

    Account[] getAccountsByType(String str);

    AccountManagerFuture<Bundle> getAuthToken(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler);

    AccountManagerFuture<Bundle> getAuthToken(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler);

    IServiceTokenFuture getServiceToken(Context context, String str);

    void invalidateAuthToken(String str, String str2);

    boolean isUseSystem();
}
