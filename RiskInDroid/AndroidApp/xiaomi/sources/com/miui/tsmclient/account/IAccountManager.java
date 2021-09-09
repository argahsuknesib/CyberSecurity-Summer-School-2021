package com.miui.tsmclient.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public interface IAccountManager {
    AccountManagerFuture<Bundle> addAccount(Activity activity, AccountManagerCallback accountManagerCallback);

    AccountManagerFuture<Bundle> confirmCredentials(Activity activity, AccountManagerCallback accountManagerCallback);

    Account getAccount(Context context);

    AccountInfo loadAccountInfo(Context context);

    AccountInfo loadAccountInfo(Context context, String str);

    void resetAccount(Context context, String str);
}
