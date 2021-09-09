package com.xiaomi.passport.accountmanager;

import _m_j.eev;
import _m_j.eew;
import _m_j.efe;
import _m_j.eks;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.xiaomi.accounts.AccountManager;
import com.xiaomi.accounts.AccountManagerService;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;
import net.sqlcipher.database.SQLiteDatabase;

class LocalAccountManagerAdapter implements eev {

    /* renamed from: O000000o  reason: collision with root package name */
    private AccountManager f6193O000000o;
    private final efe O00000Oo = new eew();

    public LocalAccountManagerAdapter(Context context) {
        this.f6193O000000o = AccountManager.O000000o(context);
    }

    public final String O000000o(Account account) {
        return this.f6193O000000o.O000000o(account);
    }

    public final String O000000o(Account account, String str) {
        return this.f6193O000000o.O000000o(account, str);
    }

    public final Account[] O000000o() {
        return this.f6193O000000o.O000000o();
    }

    public final Account[] O000000o(String str) {
        return this.f6193O000000o.O000000o(str);
    }

    public final boolean O000000o(Account account, String str, Bundle bundle) {
        AccountManager accountManager = this.f6193O000000o;
        if (account != null) {
            return accountManager.O00000Oo.O000000o(account, str, bundle);
        }
        throw new IllegalArgumentException("account is null");
    }

    public final AccountManagerFuture<Boolean> O000000o(Account account, final AccountManagerCallback<Boolean> accountManagerCallback, Handler handler) {
        AccountManager accountManager = this.f6193O000000o;
        AnonymousClass1 r1 = new AccountManagerCallback<Boolean>() {
            /* class com.xiaomi.passport.accountmanager.LocalAccountManagerAdapter.AnonymousClass1 */

            public final void run(AccountManagerFuture<Boolean> accountManagerFuture) {
                AccountManagerCallback accountManagerCallback = accountManagerCallback;
                if (accountManagerCallback != null) {
                    accountManagerCallback.run(accountManagerFuture);
                }
                eks.O00000Oo(XMPassportSettings.getApplicationContext());
            }
        };
        if (account != null) {
            return new AccountManager.Future2Task<Boolean>(handler, r1, account) {
                /* class com.xiaomi.accounts.AccountManager.AnonymousClass4 */
                final /* synthetic */ Account val$account;

                {
                    this.val$account = r4;
                }

                public void doWork() {
                    AccountManagerService accountManagerService = AccountManager.this.O00000Oo;
                    IAccountManagerResponse iAccountManagerResponse = this.mResponse;
                    Account account = this.val$account;
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "removeAccount: " + account + ", response " + iAccountManagerResponse + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
                    }
                    if (iAccountManagerResponse == null) {
                        throw new IllegalArgumentException("response is null");
                    } else if (account != null) {
                        new AccountManagerService.RemoveAccountSession(accountManagerService.O000000o(), iAccountManagerResponse, account).bind();
                    } else {
                        throw new IllegalArgumentException("account is null");
                    }
                }

                public Boolean bundleToResult(Bundle bundle) {
                    if (bundle.containsKey("booleanResult")) {
                        return Boolean.valueOf(bundle.getBoolean("booleanResult"));
                    }
                    throw new AuthenticatorException("no result in response");
                }
            }.start();
        }
        throw new IllegalArgumentException("account is null");
    }

    public final void O000000o(String str, String str2) {
        this.f6193O000000o.O000000o(str, str2);
    }

    public final void O00000Oo(Account account, String str) {
        AccountManager accountManager = this.f6193O000000o;
        if (account != null) {
            AccountManagerService accountManagerService = accountManager.O00000Oo;
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "setPassword: " + account + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
            }
            if (account != null) {
                accountManagerService.O000000o(accountManagerService.O000000o(), account, str);
                return;
            }
            throw new IllegalArgumentException("account is null");
        }
        throw new IllegalArgumentException("account is null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    public final void O000000o(Account account, String str, String str2) {
        AccountManager accountManager = this.f6193O000000o;
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            AccountManagerService accountManagerService = accountManager.O00000Oo;
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "setUserData: " + account + ", key " + str + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
            }
            if (str == null) {
                throw new IllegalArgumentException("key is null");
            } else if (account != null) {
                AccountManagerService.O00000o0 O000000o2 = accountManagerService.O000000o();
                if (account != null && str != null) {
                    synchronized (O000000o2.O00000o0) {
                        SQLiteDatabase O000000o3 = O000000o2.O00000Oo.O000000o();
                        O000000o3.beginTransaction();
                        try {
                            long O000000o4 = AccountManagerService.O000000o(O000000o3, account);
                            if (O000000o4 >= 0) {
                                long O000000o5 = AccountManagerService.O000000o(O000000o3, O000000o4, str);
                                if (O000000o5 >= 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("value", str2);
                                    if (1 != O000000o3.update("extras", contentValues, "_id=".concat(String.valueOf(O000000o5)), null)) {
                                        O000000o3.endTransaction();
                                    }
                                } else if (AccountManagerService.O000000o(O000000o3, O000000o4, str, str2) < 0) {
                                    O000000o3.endTransaction();
                                }
                                AccountManagerService.O000000o(O000000o2, O000000o3, account, str, str2);
                                O000000o3.setTransactionSuccessful();
                                O000000o3.endTransaction();
                            }
                        } finally {
                            O000000o3.endTransaction();
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("account is null");
            }
        } else {
            throw new IllegalArgumentException("key is null");
        }
    }

    public final void O00000Oo(Account account, String str, String str2) {
        AccountManager accountManager = this.f6193O000000o;
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            AccountManagerService accountManagerService = accountManager.O00000Oo;
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "setAuthToken: " + account + ", authTokenType " + str + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
            }
            if (account == null) {
                throw new IllegalArgumentException("account is null");
            } else if (str != null) {
                accountManagerService.O000000o(accountManagerService.O000000o(), account, str, str2);
            } else {
                throw new IllegalArgumentException("authTokenType is null");
            }
        } else {
            throw new IllegalArgumentException("authTokenType is null");
        }
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.f6193O000000o.O000000o(account, str, bundle, activity, accountManagerCallback, handler);
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.f6193O000000o.O000000o(account, str, bundle, z, accountManagerCallback, handler);
    }

    public final AccountManagerFuture<Bundle> O000000o(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.f6193O000000o.O000000o(str, str2, strArr, bundle, activity, accountManagerCallback, handler);
    }

    public final ServiceTokenFuture O000000o(Context context, String str) {
        return this.O00000Oo.O00000Oo(context, str);
    }

    public final ServiceTokenFuture O000000o(Context context, ServiceTokenResult serviceTokenResult) {
        return this.O00000Oo.O000000o(context, serviceTokenResult);
    }

    public final MiAccountManagerFuture<XmAccountVisibility> O000000o(Context context) {
        return this.O00000Oo.O00000o0(context);
    }
}
