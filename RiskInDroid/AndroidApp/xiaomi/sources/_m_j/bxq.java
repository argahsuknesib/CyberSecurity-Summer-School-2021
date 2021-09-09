package _m_j;

import _m_j.bxs;
import _m_j.cej;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accountsdk.account.IXiaomiAccountService;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bxq {
    public static Set<O000000o> O00000Oo = Collections.newSetFromMap(new ConcurrentHashMap());
    protected static bxq O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f13384O000000o;
    public MiAccountManager O00000o;
    private O00000Oo O00000oO;
    private BroadcastReceiver O00000oo = new BroadcastReceiver() {
        /* class _m_j.bxq.AnonymousClass3 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
         arg types: [android.content.Context, java.lang.String, int]
         candidates:
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED")) {
                int intExtra = intent.getIntExtra("extra_update_type", -1);
                if (TextUtils.equals(((Account) intent.getParcelableExtra("extra_account")).type, "com.xiaomi") && intExtra != 2 && intExtra == 1) {
                    cej.O00000Oo.O00000Oo(bxq.this.f13384O000000o, "pref_system_uid");
                    cej.O00000Oo.O00000Oo(bxq.this.f13384O000000o, "pref_system_extended_token");
                    if (cej.O00000Oo.O000000o(bxq.this.f13384O000000o, "pref_login_system", false)) {
                        bxq.this.O000000o(false);
                        bxq.O00000oO();
                    }
                }
            }
        }
    };

    public interface O000000o {
        void onLogin(String str, String str2, String str3);

        void onLogout();
    }

    public interface O00000Oo {
    }

    protected bxq(Context context) {
        this.f13384O000000o = context.getApplicationContext();
        context.registerReceiver(this.O00000oo, new IntentFilter("android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED"));
        this.O00000o = MiAccountManager.O00000Oo(this.f13384O000000o);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        this.f13384O000000o.unregisterReceiver(this.O00000oo);
    }

    public static void O000000o(Context context) {
        MiAccountManager.O00000Oo(context);
        if (cdz.O00000Oo) {
            URLs.setLocalUsePreview(context, true);
        } else {
            URLs.setLocalUsePreview(context, false);
        }
        bxs.O000000o.O000000o();
        if (O00000o0 == null) {
            O00000o0 = new bxq(context);
        }
    }

    public static bxq O000000o() {
        return O00000o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final String O00000Oo() {
        if (cej.O00000Oo.O000000o(this.f13384O000000o, "pref_login_system", false)) {
            return cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_uid", (String) null);
        }
        return cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_uid", (String) null);
    }

    public String O00000o0() {
        String O00000Oo2 = cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_extended_token", (String) null);
        if (ExtendedAuthToken.parse(O00000Oo2) != null) {
            return ExtendedAuthToken.parse(O00000Oo2).authToken;
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final ExtendedAuthToken O000000o(String str) {
        String str2;
        if (cej.O00000Oo.O000000o(this.f13384O000000o, "pref_login_system", false)) {
            bxs.O000000o.O00000Oo();
            if (TextUtils.equals(str, bxs.O000000o.O00000o0())) {
                String O00000Oo2 = cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_extended_token", "");
                str2 = TextUtils.isEmpty(O00000Oo2) ? O000000o(str, true) : O00000Oo2;
            } else {
                str2 = O000000o(str, true);
            }
        } else {
            bxs.O000000o.O00000Oo();
            str2 = TextUtils.equals(str, bxs.O000000o.O00000o0()) ? cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_extended_token", "") : null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return ExtendedAuthToken.parse(str2);
    }

    public final void O000000o(boolean z) {
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_login_system", z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final boolean O00000o() {
        return cej.O00000Oo.O000000o(this.f13384O000000o, "pref_login_system", true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        return;
     */
    public final synchronized void O000000o(O000000o o000000o) {
        if (o000000o != null) {
            if (!O00000Oo.contains(o000000o)) {
                O00000Oo.add(o000000o);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return;
     */
    public final synchronized void O00000Oo(O000000o o000000o) {
        if (o000000o != null) {
            if (O00000Oo != null) {
                O00000Oo.remove(o000000o);
            }
        }
    }

    public void O000000o(String str, String str2, String str3) {
        ccr.O00000Oo("LoginManager", "mAccountLsteners:" + O00000Oo + ",mAccountLsteners.size:" + O00000Oo.size());
        Set<O000000o> set = O00000Oo;
        if (set != null && !set.isEmpty()) {
            for (O000000o onLogin : O00000Oo) {
                onLogin.onLogin(str, str2, str3);
            }
        }
    }

    protected static void O00000oO() {
        Set<O000000o> set = O00000Oo;
        if (set != null && !set.isEmpty()) {
            for (O000000o onLogout : O00000Oo) {
                onLogout.onLogout();
            }
        }
        Log.d("LoginManager", "account has logout");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final boolean O00000oo() {
        if (cej.O00000Oo.O000000o(this.f13384O000000o, "pref_login_system", false)) {
            return !TextUtils.isEmpty(O0000OOo());
        }
        return !TextUtils.isEmpty(cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_uid", "")) && !TextUtils.isEmpty(cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_extended_token", ""));
    }

    public final boolean O0000O0o() {
        return !TextUtils.isEmpty(O0000OOo());
    }

    public final String O0000OOo() {
        Account[] O000000o2 = this.O00000o.O000000o("com.xiaomi");
        if (O000000o2.length > 0) {
            return O000000o2[0].name;
        }
        return null;
    }

    private String O00000Oo(final boolean z) {
        final Account[] O000000o2 = this.O00000o.O000000o("com.xiaomi");
        if (O000000o2.length <= 0) {
            return null;
        }
        try {
            String O000000o3 = this.O00000o.O000000o(O000000o2[0], "encrypted_user_id");
            if (z) {
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_system_c_uid", O000000o3);
            } else {
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_c_uid", O000000o3);
            }
            return O000000o3;
        } catch (SecurityException unused) {
            Intent intent = new Intent("android.intent.action.BIND_XIAOMI_ACCOUNT_SERVICE");
            intent.setPackage("com.xiaomi.account");
            this.f13384O000000o.bindService(intent, new ServiceConnection() {
                /* class _m_j.bxq.AnonymousClass1 */

                public final void onServiceDisconnected(ComponentName componentName) {
                }

                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        String encryptedUserId = IXiaomiAccountService.Stub.asInterface(iBinder).getEncryptedUserId(O000000o2[0]);
                        if (z) {
                            cej.O00000Oo.O000000o(bxq.this.f13384O000000o, "pref_system_c_uid", encryptedUserId);
                        } else {
                            cej.O00000Oo.O000000o(bxq.this.f13384O000000o, "pref_c_uid", encryptedUserId);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }, 1);
            return null;
        }
    }

    public final AccountInfo O00000Oo(String str) {
        String str2;
        ExtendedAuthToken parse;
        try {
            Account O00000oo2 = this.O00000o.O00000oo();
            if (O00000oo2 != null) {
                String O000000o2 = MiAccountManager.O00000Oo(this.f13384O000000o).O000000o(O00000oo2);
                if (TextUtils.isEmpty(O000000o2) || (parse = ExtendedAuthToken.parse(O000000o2)) == null) {
                    str2 = null;
                } else {
                    str2 = parse.authToken;
                }
                ccr.O00000Oo("LoginManager", "passToken  loginSystem save :".concat(String.valueOf(str2)));
                if (!TextUtils.isEmpty(str2)) {
                    return ekq.getServiceTokenByPassToken(O00000Oo(), str2, str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.passport.accountmanager.MiAccountManager.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>
     arg types: [android.accounts.Account, java.lang.String, ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.passport.accountmanager.MiAccountManager.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>
      _m_j.eev.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>
      com.xiaomi.passport.accountmanager.MiAccountManager.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle> */
    public final String O000000o(String str, boolean z) {
        Bundle result;
        try {
            AccountManagerFuture<Bundle> O000000o2 = this.O00000o.O000000o(this.O00000o.O00000oo(), str, (Bundle) null, true, (AccountManagerCallback<Bundle>) null, (Handler) null);
            if (O000000o2 == null || (result = O000000o2.getResult()) == null) {
                return null;
            }
            for (String next : result.keySet()) {
                ccr.O00000Oo("LoginManager", "bundle-key:" + next + ", value:" + result.get(next) + "|||||");
            }
            String string = result.getString("authtoken");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            if (!z) {
                return null;
            }
            O0000Oo();
            return null;
        }
    }

    public final String O00000o0(String str) {
        if (this.O00000o.O00000oo() == null) {
            return "";
        }
        MiAccountManager miAccountManager = this.O00000o;
        return miAccountManager.O000000o(miAccountManager.O00000oo(), str);
    }

    public final void O0000Oo0() {
        Bundle result;
        ccr.O00000Oo("LoginManager", "local login");
        try {
            O000000o(false);
            MiAccountManager miAccountManager = this.O00000o;
            Account O00000oo2 = this.O00000o.O00000oo();
            bxs.O000000o.O00000Oo();
            AccountManagerFuture<Bundle> O000000o2 = miAccountManager.O000000o(O00000oo2, bxs.O000000o.O00000o0(), (Bundle) null, (Activity) null, (AccountManagerCallback<Bundle>) null, (Handler) null);
            if (O000000o2 != null && (result = O000000o2.getResult()) != null) {
                String string = result.getString("authAccount");
                String string2 = result.getString("authtoken");
                O00000Oo(false);
                ExtendedAuthToken parse = ExtendedAuthToken.parse(string2);
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_uid", string);
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_extended_token", parse.toPlain());
                O000000o(string, parse.authToken, parse.security);
            }
        } catch (OperationCanceledException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (AuthenticatorException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void O00000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            ccr.O00000Oo("LoginManager", "system login");
            O000000o(true);
            String O0000OOo = O0000OOo();
            ExtendedAuthToken parse = ExtendedAuthToken.parse(str);
            cej.O00000Oo.O000000o(this.f13384O000000o, "pref_system_uid", O0000OOo);
            cej.O00000Oo.O000000o(this.f13384O000000o, "pref_system_extended_token", str);
            cej.O00000Oo.O000000o(this.f13384O000000o, "pref_extended_token", str);
            O000000o(O0000OOo, parse.authToken, parse.security);
            try {
                String O00000Oo2 = O00000Oo(true);
                ccr.O00000Oo("LoginManager", "system login userId:" + O0000OOo + ",cUid:" + O00000Oo2 + ",authToken:" + str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O0000Oo() {
        this.O00000oO = null;
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_c_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_c_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_extended_token");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_pass_token");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_extended_token");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_key_user_ecryption_id");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_last_refresh_serviceToken_time");
        if (O00000o()) {
            this.O00000o.O000000o(MiAccountManager.AccountAuthenticator.SYSTEM);
        } else {
            this.O00000o.O000000o(MiAccountManager.AccountAuthenticator.LOCAL);
        }
        try {
            O0000OoO();
            AnonymousClass2 r1 = new AccountManagerCallback<Boolean>() {
                /* class _m_j.bxq.AnonymousClass2 */

                public final void run(AccountManagerFuture<Boolean> accountManagerFuture) {
                    try {
                        ccr.O00000Oo("LoginManager", "future.getResult():" + accountManagerFuture.getResult().booleanValue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            for (Account account : this.O00000o.O000000o()) {
                ccr.O00000Oo("LoginManager", "removeXiaomiAccount:" + account.toString());
                if (TextUtils.equals(account.type, "com.xiaomi")) {
                    this.O00000o.O000000o(account, r1, (Handler) null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_login_system");
        O00000oO();
    }

    public final void O0000OoO() {
        String O00000Oo2 = cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_extended_token", (String) null);
        ccr.O00000Oo("LoginManager", "old extended token plain:".concat(String.valueOf(O00000Oo2)));
        this.O00000o.O000000o("com.xiaomi", O00000Oo2);
    }

    public final String O0000Ooo() {
        MiAccountManager miAccountManager = this.O00000o;
        if (O00000o()) {
            miAccountManager.O000000o(MiAccountManager.AccountAuthenticator.SYSTEM);
        } else {
            miAccountManager.O000000o(MiAccountManager.AccountAuthenticator.LOCAL);
        }
        bxq bxq = O00000o0;
        bxs.O000000o.O00000Oo();
        return bxq.O000000o(bxs.O000000o.O00000o0(), true);
    }
}
