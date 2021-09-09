package _m_j;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.xiaomi.accounts.AccountManager;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;

public final class eew implements efd, efe {

    /* renamed from: O000000o  reason: collision with root package name */
    private final efe f15194O000000o;
    private final efb O00000Oo = new efb();

    public eew() {
        efh.O000000o();
        this.f15194O000000o = efh.O000000o(this);
    }

    public final AccountManagerFuture<Bundle> O000000o(Context context, String str, Account account, Bundle bundle) {
        return AccountManager.O000000o(context).O000000o(account, str, (Bundle) null, (Activity) null, (AccountManagerCallback<Bundle>) null, (Handler) null);
    }

    public final String O000000o(Context context, String str, Account account) {
        AccountManager O000000o2 = AccountManager.O000000o(context);
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            return O000000o2.O00000Oo.O00000Oo(account, str);
        } else {
            throw new IllegalArgumentException("authTokenType is null");
        }
    }

    public final Account O000000o(Context context) {
        return eks.O000000o(context);
    }

    public final void O000000o(Context context, String str) {
        AccountManager.O000000o(context).O000000o(efb.O000000o(), str);
    }

    public final String O000000o(Context context, Account account) {
        return AccountManager.O000000o(context).O000000o(account, efb.O00000Oo());
    }

    public final String O00000Oo(Context context, String str, Account account) {
        return AccountManager.O000000o(context).O000000o(account, efb.O000000o(str));
    }

    public final String O00000o0(Context context, String str, Account account) {
        return AccountManager.O000000o(context).O000000o(account, efb.O00000Oo(str));
    }

    public final ServiceTokenFuture O00000Oo(Context context, String str) {
        return this.f15194O000000o.O00000Oo(context, str);
    }

    public final ServiceTokenFuture O000000o(Context context, ServiceTokenResult serviceTokenResult) {
        return this.f15194O000000o.O000000o(context, serviceTokenResult);
    }

    public final boolean O00000Oo(Context context) {
        return this.f15194O000000o.O00000Oo(context);
    }

    public final MiAccountManagerFuture<XmAccountVisibility> O00000o0(Context context) {
        return this.f15194O000000o.O00000o0(context);
    }
}
