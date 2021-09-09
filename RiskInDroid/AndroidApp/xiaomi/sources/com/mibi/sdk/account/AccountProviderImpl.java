package com.mibi.sdk.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.mibi.sdk.common.account.IAccountProvider;
import com.mibi.sdk.common.account.IServiceTokenFuture;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public class AccountProviderImpl implements IAccountProvider {
    private MiAccountManager mAccountManager;

    public AccountProviderImpl(Context context) {
        this.mAccountManager = MiAccountManager.O00000Oo(context);
    }

    public boolean isUseSystem() {
        return this.mAccountManager.O00000Oo();
    }

    public Account[] getAccounts() {
        return this.mAccountManager.O000000o();
    }

    public Account[] getAccountsByType(String str) {
        return this.mAccountManager.O000000o(str);
    }

    public void invalidateAuthToken(String str, String str2) {
        this.mAccountManager.O000000o(str, str2);
    }

    public AccountManagerFuture<Bundle> getAuthToken(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.mAccountManager.O000000o(account, str, bundle, activity, accountManagerCallback, handler);
    }

    public AccountManagerFuture<Bundle> getAuthToken(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.mAccountManager.O000000o(account, str, bundle, z, accountManagerCallback, handler);
    }

    public AccountManagerFuture<Bundle> addAccount(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.mAccountManager.O000000o(str, str2, strArr, bundle, activity, accountManagerCallback, handler);
    }

    public IServiceTokenFuture getServiceToken(Context context, String str) {
        return new ServiceTokenFutureImpl(this.mAccountManager.O000000o(context, str));
    }
}
