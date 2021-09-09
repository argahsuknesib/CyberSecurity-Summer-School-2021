package com.miui.tsmclient.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class TSMAccountManager implements IAccountManager {
    IAccountManager mAccountManager = new OAuthAccountManager();

    public AccountInfo loadAccountInfo(Context context) {
        return loadAccountInfo(context, "tsm-auth");
    }

    public AccountInfo loadAccountInfo(Context context, String str) {
        return this.mAccountManager.loadAccountInfo(context, str);
    }

    public void resetAccount(Context context, String str) {
        this.mAccountManager.resetAccount(context, str);
    }

    public Account getAccount(Context context) {
        return this.mAccountManager.getAccount(context);
    }

    public AccountManagerFuture<Bundle> addAccount(Activity activity, AccountManagerCallback accountManagerCallback) {
        return this.mAccountManager.addAccount(activity, accountManagerCallback);
    }

    public AccountManagerFuture<Bundle> confirmCredentials(Activity activity, AccountManagerCallback accountManagerCallback) {
        return this.mAccountManager.confirmCredentials(activity, accountManagerCallback);
    }
}
