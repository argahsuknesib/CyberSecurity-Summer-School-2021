package com.google.android.gms.common.oob;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

@VisibleForTesting
public class SignUp {
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = BaseGmsClient.GOOGLE_PLUS_REQUIRED_FEATURES;

    private SignUp() {
    }

    public static AccountManagerFuture<Boolean> checkSignUpState(Context context, String str, String[] strArr, AccountManagerCallback<Boolean> accountManagerCallback, Handler handler) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "The accountName is required");
        Preconditions.checkArgument(strArr != null, "The requiredFeatures parameter is required");
        AccountManager accountManager = AccountManager.get(context);
        boolean z = false;
        for (Account account : accountManager.getAccountsByType("com.google")) {
            if (str.equals(account.name)) {
                z = true;
            }
        }
        if (z) {
            return accountManager.hasFeatures(new Account(str, "com.google"), strArr, accountManagerCallback, handler);
        }
        throw new IllegalStateException("Given account does not exist on the device");
    }

    public static boolean isSignedUpBlocking(Context context, String str, String[] strArr) throws AuthenticatorException, OperationCanceledException, IOException {
        return checkSignUpState(context, str, strArr, null, null).getResult().booleanValue();
    }

    public static Intent newSignUpIntent(String str) {
        return newSignUpIntent(str, null);
    }

    public static Intent newSignUpIntent(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction("com.google.android.gms.common.oob.OOB_SIGN_UP");
        intent.putExtra("com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME", str);
        intent.putExtra("com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME", str2);
        return intent;
    }

    public static Intent newSignUpIntent(String str, String str2, String str3, String str4) {
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction("com.google.android.gms.common.oob.OOB_SIGN_UP");
        intent.putExtra("com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME", str);
        intent.putExtra("com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME", str2);
        intent.putExtra("com.google.android.gms.common.oob.EXTRAS_PROMO_APP_PACKAGE", str3);
        intent.putExtra("com.google.android.gms.common.oob.EXTRAS_PROMO_APP_TEXT", str4);
        return intent;
    }
}
