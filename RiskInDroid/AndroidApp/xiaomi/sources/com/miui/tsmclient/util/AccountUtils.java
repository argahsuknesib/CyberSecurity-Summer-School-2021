package com.miui.tsmclient.util;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.miui.tsmclient.account.TSMAccountManager;
import com.tsmclient.smartcard.Coder;

public class AccountUtils {
    private static String sTime = "";

    public static void setLastAccountSnapshot(Context context, String str) {
        sTime = Long.toString(System.currentTimeMillis());
        PrefUtils.putString(context, PrefUtils.PREF_KEY_LAST_USER_NAME, getSnapshot(str));
    }

    public static String getLastAccountSnapshot(Context context) {
        return PrefUtils.getString(context, PrefUtils.PREF_KEY_LAST_USER_NAME, "");
    }

    public static String getSnapshot(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Coder.encodeMD5(str) + sTime;
    }

    public static boolean isChanged(Context context, String str) {
        Account account = new TSMAccountManager().getAccount(context);
        if (!TextUtils.isEmpty(str)) {
            return account == null || !TextUtils.equals(str, getSnapshot(account.name));
        }
        return false;
    }

    private AccountUtils() {
    }
}
