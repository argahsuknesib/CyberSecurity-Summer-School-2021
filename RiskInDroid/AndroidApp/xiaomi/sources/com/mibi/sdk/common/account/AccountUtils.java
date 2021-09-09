package com.mibi.sdk.common.account;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.account.loader.AccountLoader;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.account.loader.MiAccountLoader;

public class AccountUtils {
    private AccountUtils() {
    }

    public static AccountLoader newMiAccountLoader(Account account) {
        return new MiAccountLoader(account);
    }

    public static AccountLoader newFakeAccountLoader() {
        return new FakeAccountLoader();
    }

    public static Account getMiAccount() {
        IAccountProvider accountProvider = AccountRegistry.getAccountProvider();
        if (accountProvider == null) {
            return null;
        }
        Account[] accountsByType = accountProvider.getAccountsByType("com.xiaomi");
        if (accountsByType.length == 0) {
            return null;
        }
        return accountsByType[0];
    }

    public static String getMiUserId() {
        Account miAccount = getMiAccount();
        return miAccount != null ? miAccount.name : "";
    }

    public static AccountLoader getCurrentAccountLoader() {
        Account miAccount = getMiAccount();
        if (miAccount != null) {
            return newMiAccountLoader(miAccount);
        }
        return newFakeAccountLoader();
    }

    public static void checkAndPostAccountChange(Context context) {
        String miUserId = getMiUserId();
        if (!TextUtils.equals(Utils.getStringPref(context, "userId", ""), miUserId)) {
            Utils.setStringPref(context, "userId", miUserId);
            Log.d("AccountUtils", "removeAllCookies");
            CookieManager.getInstance().removeAllCookie();
        }
    }
}
