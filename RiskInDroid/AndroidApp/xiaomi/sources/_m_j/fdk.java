package _m_j;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.account.AccountType;
import com.xiaomi.smarthome.core.entity.account.OAuthAccount;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;

public final class fdk {
    private static Object O00000o = new Object();
    private static volatile fdk O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    LoginMiAccount f16103O000000o;
    volatile long O00000Oo = 0;
    private boolean O00000oO = false;
    private SharedPreferences O00000oo;
    private Context O0000O0o = CommonApplication.getAppContext();
    private AccountType O0000OOo;
    private OAuthAccount O0000Oo0;

    private fdk() {
        O00000Oo();
    }

    public static fdk O000000o() {
        if (O00000o0 == null) {
            synchronized (O00000o) {
                if (O00000o0 == null) {
                    O00000o0 = new fdk();
                }
            }
        }
        return O00000o0;
    }

    public final void O00000Oo() {
        boolean z;
        gsy.O00000Oo("AccountManager", "AccountManager init:mIsInitialized=" + this.O00000oO + ",CoreService.getAppContext=" + CommonApplication.getAppContext() + ",mAppContext=" + this.O0000O0o);
        synchronized (O00000o) {
            z = this.O00000oO;
            if (!this.O00000oO) {
                this.O00000oO = true;
            }
        }
        if (!z) {
            if (this.O0000O0o == null) {
                this.O0000O0o = CommonApplication.getAppContext();
            }
            Context context = this.O0000O0o;
            if (context != null) {
                this.O00000oo = context.getSharedPreferences("com.xiaomi.smarthome.account", 0);
                gsy.O00000Oo("AccountManager", "mAccountPrefs1:" + this.O00000oo);
                String str = "";
                try {
                    str = O000000o(O00000Oo(this.O0000O0o, this.O00000oo.getString("mi_account_encrypt", "")), "mi_account", "mi_account_encrypt");
                } catch (Exception e) {
                    LogType logType = LogType.LOGIN;
                    gsy.O00000Oo(logType, "AccountManager", "read from mmkv exception1:" + e.getMessage());
                    O0000o0();
                }
                this.f16103O000000o = LoginMiAccount.O00000o0(str);
                this.O00000Oo = 0;
                gsy.O00000Oo(LogType.LOGIN, "AccountManager", "miAccountStr=".concat(String.valueOf(str)));
                String str2 = "";
                try {
                    str2 = O000000o(O00000Oo(this.O0000O0o, this.O00000oo.getString("oauth_account_encrypt", "")), "oauth_account", "oauth_account_encrypt");
                } catch (Exception e2) {
                    LogType logType2 = LogType.LOGIN;
                    gsy.O00000Oo(logType2, "AccountManager", "read from mmkv exception12" + e2.getMessage());
                    O0000o0O();
                }
                this.O0000Oo0 = OAuthAccount.O000000o(str2);
                if (this.f16103O000000o != null) {
                    this.O0000OOo = AccountType.MI;
                    this.O0000Oo0 = null;
                } else if (this.O0000Oo0 != null) {
                    this.O0000OOo = AccountType.OAUTH;
                    this.f16103O000000o = null;
                }
            }
        }
    }

    private String O000000o(String str, String str2, String str3) {
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences != null && TextUtils.isEmpty(str)) {
            str = new String(grs.O000000o(sharedPreferences.getString(str2, "")));
            if (!TextUtils.isEmpty(str)) {
                try {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str3, O000000o(this.O0000O0o, str));
                    edit.putString(str2, "");
                    edit.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    public final synchronized AccountType O00000o0() {
        return this.O0000OOo;
    }

    public final synchronized String O00000o() {
        String str;
        str = "0";
        AccountType accountType = AccountType.MI;
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return str;
    }

    public final synchronized void O000000o(String str, String str2, String str3, String str4, String str5, long j) {
        MiServiceTokenInfo miServiceTokenInfo = new MiServiceTokenInfo();
        miServiceTokenInfo.f12086O000000o = str;
        miServiceTokenInfo.O00000Oo = str3;
        miServiceTokenInfo.O00000o0 = str2;
        miServiceTokenInfo.O00000o = str4;
        miServiceTokenInfo.O00000oo = str5;
        miServiceTokenInfo.O00000oO = j;
        if (this.f16103O000000o != null) {
            this.f16103O000000o.O000000o(miServiceTokenInfo);
        }
    }

    public final synchronized MiServiceTokenInfo O000000o(String str) {
        if (this.f16103O000000o == null) {
            return null;
        }
        return this.f16103O000000o.O000000o(str);
    }

    public final synchronized long O00000Oo(String str) {
        if (this.f16103O000000o == null) {
            return 0;
        }
        return this.f16103O000000o.O00000Oo(str);
    }

    public final synchronized LoginMiAccount O00000oO() {
        return this.f16103O000000o;
    }

    public final synchronized void O000000o(LoginMiAccount loginMiAccount) {
        this.O0000OOo = AccountType.MI;
        this.f16103O000000o = loginMiAccount;
        this.O0000Oo0 = null;
        this.O00000Oo = 0;
        fdl.O000000o().f16104O000000o = true;
    }

    public final synchronized void O000000o(OAuthAccount oAuthAccount) {
        this.O0000OOo = AccountType.OAUTH;
        this.f16103O000000o = null;
        this.O0000Oo0 = oAuthAccount;
        this.O00000Oo = 0;
        fdl.O000000o().f16104O000000o = true;
    }

    private synchronized void O0000o0() {
        gsy.O00000Oo(LogType.LOGIN, "AccountManager", "clearMiAccount");
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences == null) {
            gsy.O00000Oo(LogType.LOGIN, "AccountManager", "clearMiAccount:mAccountPrefs is null!!");
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("mi_account");
        edit.remove("mi_account_encrypt");
        edit.commit();
        this.f16103O000000o = null;
        this.O00000Oo = 0;
        fdl.O000000o().f16104O000000o = true;
    }

    private synchronized void O0000o0O() {
        try {
            SharedPreferences sharedPreferences = this.O00000oo;
            if (sharedPreferences == null) {
                gsy.O00000Oo(LogType.LOGIN, "AccountManager", "clearOAuthAccount:mAccountPrefs is null!!");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove("oauth_account");
            edit.remove("oauth_account_encrypt");
            edit.commit();
            this.O0000Oo0 = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void O00000oo() {
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences == null) {
            gsy.O00000Oo(LogType.LOGIN, "AccountManager", "clearAllAccount:mAccountPrefs is null!!");
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("mi_account");
        edit.remove("oauth_account");
        edit.remove("mi_account_encrypt");
        edit.remove("oauth_account_encrypt");
        edit.commit();
        this.O0000OOo = null;
        this.f16103O000000o = null;
        this.O0000Oo0 = null;
        this.O00000Oo = 0;
        fdl.O000000o().f16104O000000o = true;
    }

    private static String O000000o(Context context, String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return gqi.O00000Oo(str, gox.O000000o(context));
    }

    private static String O00000Oo(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String O000000o2 = gqi.O000000o(str, gox.O000000o(context));
        if (TextUtils.isEmpty(O000000o2)) {
            return null;
        }
        return O000000o2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        return;
     */
    public final synchronized void O0000O0o() {
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences == null) {
            gsy.O00000Oo(LogType.LOGIN, "AccountManager", "saveAccount:mAccountPrefs is null!!");
            return;
        }
        if (this.f16103O000000o != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            try {
                edit.putString("mi_account_encrypt", O000000o(this.O0000O0o, this.f16103O000000o.O00000oO()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            edit.commit();
        }
        if (this.O0000Oo0 != null) {
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            try {
                edit2.putString("oauth_account_encrypt", O000000o(this.O0000O0o, this.O0000Oo0.O000000o()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            edit2.commit();
        }
    }

    public final synchronized boolean O0000OOo() {
        if (this.O0000OOo != null) {
            return true;
        }
        return false;
    }

    public final synchronized boolean O0000Oo0() {
        if (this.f16103O000000o != null) {
            return true;
        }
        return false;
    }

    public final synchronized String O0000Oo() {
        if (this.f16103O000000o == null) {
            return "0";
        }
        if (TextUtils.isEmpty(this.f16103O000000o.O000000o())) {
            return "0";
        }
        return this.f16103O000000o.O000000o();
    }

    public final synchronized boolean O0000OoO() {
        if (this.f16103O000000o == null) {
            return false;
        }
        return this.f16103O000000o.O00000Oo();
    }

    public final synchronized String O0000Ooo() {
        if (this.f16103O000000o == null) {
            return "";
        }
        return this.f16103O000000o.O00000o0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        return;
     */
    public final synchronized void O00000o0(String str) {
        if (this.f16103O000000o != null) {
            if (!TextUtils.isEmpty(str)) {
                MiServiceTokenInfo O000000o2 = this.f16103O000000o.O000000o(str);
                if (O000000o2 != null) {
                    AccountManager accountManager = AccountManager.get(this.O0000O0o);
                    accountManager.invalidateAuthToken("com.xiaomi", O000000o2.O00000o0 + "," + O000000o2.O00000o);
                }
            }
        }
    }

    public final synchronized void O0000o00() {
        if (this.f16103O000000o != null) {
            for (MiServiceTokenInfo next : this.f16103O000000o.O00000o()) {
                AccountManager accountManager = AccountManager.get(this.O0000O0o);
                accountManager.invalidateAuthToken("com.xiaomi", next.O00000o0 + "," + next.O00000o);
            }
        }
    }
}
