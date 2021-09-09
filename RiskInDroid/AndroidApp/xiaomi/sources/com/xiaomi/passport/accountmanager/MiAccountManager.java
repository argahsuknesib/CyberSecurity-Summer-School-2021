package com.xiaomi.passport.accountmanager;

import _m_j.eev;
import _m_j.eex;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorDescription;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;

public class MiAccountManager implements eev {
    private static volatile MiAccountManager O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f6195O000000o;
    public boolean O00000Oo;
    private eev O00000o;
    private LocalAccountManagerAdapter O00000oO;
    private SystemAccountManagerAdapter O00000oo;
    private boolean O0000O0o;
    private AccountAuthenticator O0000OOo;

    public enum AccountAuthenticator {
        LOCAL,
        SYSTEM
    }

    private MiAccountManager(Context context) {
        AccountAuthenticator accountAuthenticator;
        this.f6195O000000o = context.getApplicationContext();
        XMPassportSettings.ensureApplicationContext((Application) this.f6195O000000o);
        boolean z = true;
        XMPassportSettings.setNonNullApplicationContextContract(true);
        this.O00000Oo = O00000o0(context);
        this.O0000O0o = context.getPackageManager().resolveService(new Intent("com.xiaomi.account.action.SERVICE_TOKEN_OP").setPackage("com.xiaomi.account"), 0) == null ? false : z;
        int i = eex.O000000o(this.f6195O000000o).O000000o().getInt("authenticator", -1);
        AccountAuthenticator[] values = AccountAuthenticator.values();
        if (i < 0 || i >= values.length) {
            accountAuthenticator = null;
        } else {
            accountAuthenticator = values[i];
        }
        O000000o(accountAuthenticator == null ? AccountAuthenticator.SYSTEM : accountAuthenticator);
    }

    public final boolean O00000Oo() {
        return this.O0000OOo == AccountAuthenticator.SYSTEM;
    }

    public final boolean O00000o0() {
        return this.O0000OOo == AccountAuthenticator.LOCAL;
    }

    public final void O00000o() {
        O000000o(AccountAuthenticator.SYSTEM);
    }

    public final void O00000oO() {
        O000000o(AccountAuthenticator.LOCAL);
    }

    /* renamed from: com.xiaomi.passport.accountmanager.MiAccountManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f6196O000000o = new int[AccountAuthenticator.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f6196O000000o[AccountAuthenticator.SYSTEM.ordinal()] = 1;
            f6196O000000o[AccountAuthenticator.LOCAL.ordinal()] = 2;
        }
    }

    private static void O00000Oo(AccountAuthenticator accountAuthenticator) {
        int i = AnonymousClass1.f6196O000000o[accountAuthenticator.ordinal()];
        if (i == 1) {
            HashedDeviceIdUtil.GlobalConfig.getInstance().setPolicy(HashedDeviceIdUtil.DeviceIdPolicy.RUNTIME_DEVICE_ID_ONLY);
        } else if (i == 2) {
            HashedDeviceIdUtil.GlobalConfig.getInstance().setPolicy(HashedDeviceIdUtil.DeviceIdPolicy.CACHED_THEN_RUNTIME_THEN_PSEUDO);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void O000000o(AccountAuthenticator accountAuthenticator) {
        int i = AnonymousClass1.f6196O000000o[accountAuthenticator.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.O0000OOo = AccountAuthenticator.LOCAL;
            } else {
                throw new IllegalArgumentException();
            }
        } else if (this.O00000Oo) {
            this.O0000OOo = AccountAuthenticator.SYSTEM;
        } else {
            this.O0000OOo = AccountAuthenticator.LOCAL;
        }
        int i2 = AnonymousClass1.f6196O000000o[this.O0000OOo.ordinal()];
        if (i2 == 1) {
            if (this.O00000oo == null) {
                this.O00000oo = new SystemAccountManagerAdapter(this.f6195O000000o);
            }
            this.O00000o = this.O00000oo;
        } else if (i2 == 2) {
            if (this.O00000oO == null) {
                this.O00000oO = new LocalAccountManagerAdapter(this.f6195O000000o);
            }
            this.O00000o = this.O00000oO;
        } else {
            throw new IllegalArgumentException();
        }
        O00000Oo(this.O0000OOo);
        eex.O000000o(this.f6195O000000o).O000000o(this.O0000OOo);
    }

    private static boolean O00000o0(Context context) {
        for (AuthenticatorDescription authenticatorDescription : AccountManager.get(context).getAuthenticatorTypes()) {
            if (TextUtils.equals(authenticatorDescription.type, "com.xiaomi") && TextUtils.equals(authenticatorDescription.packageName, "com.xiaomi.account")) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public final MiAccountManagerFuture<XmAccountVisibility> O000000o(Context context) {
        return this.O00000o.O000000o(context);
    }

    public static MiAccountManager O00000Oo(Context context) {
        if (context != null) {
            if (O00000o0 == null) {
                synchronized (MiAccountManager.class) {
                    if (O00000o0 == null) {
                        O00000o0 = new MiAccountManager(context);
                    }
                }
            }
            return O00000o0;
        }
        throw new IllegalArgumentException("context is null");
    }

    public final Account[] O000000o() {
        return this.O00000o.O000000o();
    }

    public final Account[] O000000o(String str) {
        return this.O00000o.O000000o(str);
    }

    public final AccountManagerFuture<Boolean> O000000o(Account account, AccountManagerCallback<Boolean> accountManagerCallback, Handler handler) {
        return this.O00000o.O000000o(account, accountManagerCallback, handler);
    }

    public final void O000000o(String str, String str2) {
        this.O00000o.O000000o(str, str2);
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.O00000o.O000000o(account, str, bundle, activity, accountManagerCallback, handler);
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.O00000o.O000000o(account, str, bundle, z, accountManagerCallback, handler);
    }

    public final AccountManagerFuture<Bundle> O000000o(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.O00000o.O000000o(str, str2, strArr, bundle, activity, accountManagerCallback, handler);
    }

    public final ServiceTokenFuture O000000o(Context context, String str) {
        return this.O00000o.O000000o(context, str);
    }

    public final ServiceTokenFuture O000000o(Context context, ServiceTokenResult serviceTokenResult) {
        return this.O00000o.O000000o(context, serviceTokenResult);
    }

    public final Account O00000oo() {
        Account[] O000000o2 = this.O00000o.O000000o("com.xiaomi");
        if (O000000o2.length > 0) {
            return O000000o2[0];
        }
        return null;
    }

    public final void O000000o(AccountManagerCallback<Boolean> accountManagerCallback, Handler handler) {
        for (Account account : O000000o()) {
            if (TextUtils.equals(account.type, "com.xiaomi")) {
                O000000o(account, accountManagerCallback, handler);
            }
        }
    }

    public final String O000000o(Account account) {
        return this.O00000o.O000000o(account);
    }

    public final String O000000o(Account account, String str) {
        return this.O00000o.O000000o(account, str);
    }

    public final boolean O000000o(Account account, String str, Bundle bundle) {
        return this.O00000o.O000000o(account, str, bundle);
    }

    public final void O00000Oo(Account account, String str) {
        this.O00000o.O00000Oo(account, str);
    }

    public final void O000000o(Account account, String str, String str2) {
        this.O00000o.O000000o(account, str, str2);
    }

    public final void O00000Oo(Account account, String str, String str2) {
        this.O00000o.O00000Oo(account, str, str2);
    }
}
