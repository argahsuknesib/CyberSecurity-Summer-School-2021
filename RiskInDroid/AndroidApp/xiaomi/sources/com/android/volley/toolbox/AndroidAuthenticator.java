package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.AuthFailureError;

public class AndroidAuthenticator implements Authenticator {
    private final Account mAccount;
    private final String mAuthTokenType;
    private final Context mContext;
    private final boolean mNotifyAuthFailure;

    public AndroidAuthenticator(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    public AndroidAuthenticator(Context context, Account account, String str, boolean z) {
        this.mContext = context;
        this.mAccount = account;
        this.mAuthTokenType = str;
        this.mNotifyAuthFailure = z;
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> authToken = AccountManager.get(this.mContext).getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, null, null);
        try {
            Bundle result = authToken.getResult();
            String str = null;
            if (authToken.isDone() && !authToken.isCancelled()) {
                if (!result.containsKey("intent")) {
                    str = result.getString("authtoken");
                } else {
                    throw new AuthFailureError((Intent) result.getParcelable("intent"));
                }
            }
            if (str != null) {
                return str;
            }
            throw new AuthFailureError("Got null auth token for type: " + this.mAuthTokenType);
        } catch (Exception e) {
            throw new AuthFailureError("Error while retrieving auth token", e);
        }
    }

    public void invalidateAuthToken(String str) {
        AccountManager.get(this.mContext).invalidateAuthToken(this.mAccount.type, str);
    }
}
