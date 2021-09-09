package com.xiaomi.passport.accountmanager;

import _m_j.eev;
import _m_j.efe;
import _m_j.efh;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.accountsdk.utils.MiuiOsBuildReflection;
import com.xiaomi.accountsdk.utils.MiuiVersionStable;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;

class SystemAccountManagerAdapter implements eev {

    /* renamed from: O000000o  reason: collision with root package name */
    private final efe f6198O000000o;
    private AccountManager O00000Oo;
    private final Context O00000o0;

    public SystemAccountManagerAdapter(Context context) {
        efe efe;
        this.O00000Oo = AccountManager.get(context);
        this.O00000o0 = context.getApplicationContext();
        boolean z = !TextUtils.equals(context.getPackageName(), "com.xiaomi.account");
        if (z && MiuiOsBuildReflection.isStable(false) && MiuiVersionStable.earlyThan(new MiuiVersionStable(8, 0), false) && context.getPackageManager().checkSignatures(context.getPackageName(), "com.xiaomi.account") == 0) {
            z = false;
        }
        efh.O000000o();
        if (z) {
            efe = efh.O00000Oo();
        } else {
            efe = efh.O000000o(efh.O00000o0());
        }
        this.f6198O000000o = efe;
    }

    public final String O000000o(Account account) {
        return this.O00000Oo.getPassword(account);
    }

    public final String O000000o(Account account, String str) {
        return this.O00000Oo.getUserData(account, str);
    }

    public final Account[] O000000o() {
        return this.O00000Oo.getAccounts();
    }

    public final Account[] O000000o(String str) {
        return this.O00000Oo.getAccountsByType(str);
    }

    public final boolean O000000o(Account account, String str, Bundle bundle) {
        return this.O00000Oo.addAccountExplicitly(account, str, bundle);
    }

    public final AccountManagerFuture<Boolean> O000000o(Account account, AccountManagerCallback<Boolean> accountManagerCallback, Handler handler) {
        return this.O00000Oo.removeAccount(account, accountManagerCallback, handler);
    }

    public final void O000000o(String str, String str2) {
        this.O00000Oo.invalidateAuthToken(str, str2);
    }

    public final void O00000Oo(Account account, String str) {
        this.O00000Oo.setPassword(account, str);
    }

    public final void O000000o(Account account, String str, String str2) {
        this.O00000Oo.setUserData(account, str, str2);
    }

    public final void O00000Oo(Account account, String str, String str2) {
        this.O00000Oo.setAuthToken(account, str, str2);
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        if (!O000000o(bundle, accountManagerCallback, handler) || activity != null) {
            return this.O00000Oo.getAuthToken(account, str, bundle, activity, accountManagerCallback, handler);
        }
        return AMFutureConverter.O000000o(O000000o(this.O00000o0, str));
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        if (!O000000o(bundle, accountManagerCallback, handler) || z) {
            return this.O00000Oo.getAuthToken(account, str, bundle, z, accountManagerCallback, handler);
        }
        return AMFutureConverter.O000000o(O000000o(this.O00000o0, str));
    }

    public final AccountManagerFuture<Bundle> O000000o(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.O00000Oo.addAccount(str, str2, strArr, bundle, activity, accountManagerCallback, handler);
    }

    public final ServiceTokenFuture O000000o(Context context, String str) {
        return this.f6198O000000o.O00000Oo(context, str);
    }

    public final ServiceTokenFuture O000000o(Context context, ServiceTokenResult serviceTokenResult) {
        return this.f6198O000000o.O000000o(context, serviceTokenResult);
    }

    private static boolean O000000o(Bundle bundle, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        if (accountManagerCallback == null && handler == null && bundle != null && bundle.getBoolean("getAuthTokenImplVer2", false) && bundle.keySet().size() == 1) {
            return true;
        }
        return false;
    }

    public final MiAccountManagerFuture<XmAccountVisibility> O000000o(Context context) {
        return this.f6198O000000o.O00000o0(context);
    }
}
