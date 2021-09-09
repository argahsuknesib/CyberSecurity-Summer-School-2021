package com.mibi.sdk.common.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.account.loader.AccountLoader;
import java.io.IOException;

public class LoginHelper {

    interface LoginCallback {
        void onFailed(int i, String str);

        void onSuccess(Account account);
    }

    public interface LoginWithResult {
        void onLoginFailed(int i, String str);

        void onLoginSuccess(AccountLoader accountLoader);
    }

    private LoginHelper() {
    }

    public static void login(Activity activity, LoginWithResult loginWithResult) {
        login(activity, false, loginWithResult);
    }

    public static void login(Activity activity, boolean z, LoginWithResult loginWithResult) {
        if (loginWithResult == null) {
            throw new IllegalArgumentException("login callback not be null");
        } else if (z) {
            loginWithResult.onLoginSuccess(AccountUtils.newFakeAccountLoader());
        } else {
            loginSystem(activity, loginWithResult);
        }
    }

    private static void loginSystem(Activity activity, final LoginWithResult loginWithResult) {
        Account miAccount = AccountUtils.getMiAccount();
        if (miAccount != null) {
            loginWithResult.onLoginSuccess(AccountUtils.newMiAccountLoader(miAccount));
            return;
        }
        AccountRegistry.getAccountProvider().addAccount("com.xiaomi", null, null, null, activity, new AddAccountCallback(activity) {
            /* class com.mibi.sdk.common.account.LoginHelper.AnonymousClass1 */

            public final void onSuccess(Account account) {
                loginWithResult.onLoginSuccess(AccountUtils.newMiAccountLoader(account));
            }

            public final void onFailed(int i, String str) {
                loginWithResult.onLoginFailed(i, str);
            }
        }, null);
    }

    static abstract class AddAccountCallback implements AccountManagerCallback<Bundle>, LoginCallback {
        public AddAccountCallback(Context context) {
        }

        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            if (accountManagerFuture.isDone()) {
                try {
                    if (accountManagerFuture.getResult() == null) {
                        Log.d("LoginHelper", "loginSystem failed : authentication failed");
                        onFailed(5, "authentication failed");
                        return;
                    }
                    Account miAccount = AccountUtils.getMiAccount();
                    if (miAccount == null) {
                        Log.d("LoginHelper", "loginSystem failed : authentication failed");
                        onFailed(5, "authentication failed");
                        return;
                    }
                    onSuccess(miAccount);
                } catch (OperationCanceledException e) {
                    Log.d("LoginHelper", "loginSystem failed : user canceled ".concat(String.valueOf(e)));
                    onFailed(0, e.getMessage());
                } catch (AuthenticatorException e2) {
                    Log.d("LoginHelper", "loginSystem failed : authenticator exception ".concat(String.valueOf(e2)));
                    onFailed(5, e2.getMessage());
                } catch (IOException e3) {
                    Log.d("LoginHelper", "loginSystem failed : io exception ".concat(String.valueOf(e3)));
                    onFailed(3, e3.getMessage());
                }
            }
        }
    }
}
