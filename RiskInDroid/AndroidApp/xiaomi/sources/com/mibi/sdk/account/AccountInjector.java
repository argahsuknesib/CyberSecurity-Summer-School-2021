package com.mibi.sdk.account;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.common.account.AccountRegistry;

public class AccountInjector {
    public static void inject(Context context) {
        Log.d("AccountInjector", "inject");
        if (AccountRegistry.getAccountProvider() == null) {
            injectDefaultAccountProvider(context);
        }
        if (AccountRegistry.getLoginProvider() == null) {
            AccountRegistry.setLoginProvider(new LoginProviderImpl(context.getApplicationContext()));
        }
    }

    private static void injectDefaultAccountProvider(Context context) {
        AccountRegistry.setAccountProvider(new AccountProviderImpl(context.getApplicationContext()));
    }

    public static void release() {
        Log.d("AccountInjector", "clear");
        AccountRegistry.release();
    }

    public static boolean isLogined(Context context) {
        Log.d("AccountInjector", "isLogined");
        if (AccountRegistry.getAccountProvider() == null) {
            injectDefaultAccountProvider(context);
        }
        return AccountRegistry.getAccountProvider().getAccounts() != null;
    }
}
