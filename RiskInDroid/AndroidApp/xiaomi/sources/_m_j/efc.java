package _m_j;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.xiaomi.accountsdk.utils.AccountLog;

final class efc implements efd {

    /* renamed from: O000000o  reason: collision with root package name */
    private final efb f15209O000000o;

    efc(efb efb) {
        this.f15209O000000o = efb;
    }

    public final Account O000000o(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.xiaomi");
        if (accountsByType == null || accountsByType.length <= 0) {
            return null;
        }
        return accountsByType[0];
    }

    public final void O000000o(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.xiaomi", str);
    }

    public final String O000000o(Context context, Account account) {
        try {
            return AccountManager.get(context).getUserData(account, "encrypted_user_id");
        } catch (SecurityException e) {
            AccountLog.d("AMUtilImpl", "getSlh", e);
            return null;
        }
    }

    public final String O00000Oo(Context context, String str, Account account) {
        try {
            return AccountManager.get(context).getUserData(account, efb.O000000o(str));
        } catch (SecurityException e) {
            AccountLog.d("AMUtilImpl", "getSlh", e);
            return null;
        }
    }

    public final String O00000o0(Context context, String str, Account account) {
        try {
            return AccountManager.get(context).getUserData(account, efb.O00000Oo(str));
        } catch (SecurityException e) {
            AccountLog.d("AMUtilImpl", "getSlh", e);
            return null;
        }
    }

    public final AccountManagerFuture<Bundle> O000000o(Context context, String str, Account account, Bundle bundle) {
        return AccountManager.get(context).getAuthToken(account, str, (Bundle) null, (Activity) null, (AccountManagerCallback<Bundle>) null, (Handler) null);
    }

    public final String O000000o(Context context, String str, Account account) {
        try {
            return AccountManager.get(context).peekAuthToken(account, str);
        } catch (SecurityException e) {
            AccountLog.d("AMUtilImpl", "peedAuthToken", e);
            return null;
        }
    }
}
