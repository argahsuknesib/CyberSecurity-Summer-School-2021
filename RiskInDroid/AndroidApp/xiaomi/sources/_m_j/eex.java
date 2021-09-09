package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public final class eex {
    private static eex O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f15195O000000o;

    private eex(Context context) {
        this.f15195O000000o = context;
    }

    public static synchronized eex O000000o(Context context) {
        eex eex;
        synchronized (eex.class) {
            if (context != null) {
                if (O00000Oo == null) {
                    O00000Oo = new eex(context.getApplicationContext());
                }
                eex = O00000Oo;
            } else {
                throw new IllegalArgumentException("context cannot be null");
            }
        }
        return eex;
    }

    public final void O000000o(MiAccountManager.AccountAuthenticator accountAuthenticator) {
        if (accountAuthenticator != null) {
            O000000o().edit().putInt("authenticator", accountAuthenticator.ordinal()).apply();
            return;
        }
        throw new IllegalArgumentException("accountAuthenticator can not be null");
    }

    public final SharedPreferences O000000o() {
        return this.f15195O000000o.getSharedPreferences("MiAccountManagerSettings", 0);
    }
}
