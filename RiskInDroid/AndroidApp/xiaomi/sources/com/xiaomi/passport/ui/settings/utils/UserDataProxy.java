package com.xiaomi.passport.ui.settings.utils;

import _m_j.ekj;
import android.accounts.Account;
import android.content.Context;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public class UserDataProxy {

    /* renamed from: O000000o  reason: collision with root package name */
    private final MiAccountManager f6322O000000o;
    private final Context O00000Oo;

    public UserDataProxy(Context context) {
        if (context != null) {
            this.O00000Oo = context;
            this.f6322O000000o = MiAccountManager.O00000Oo(context);
            return;
        }
        throw new IllegalArgumentException("context is null or userId is null");
    }

    public final void O000000o(Account account, String str, String str2) {
        if (account == null) {
            throw new IllegalArgumentException("account cannot be null");
        } else if (this.f6322O000000o.O00000o0()) {
            this.f6322O000000o.O000000o(account, str, str2);
        } else {
            new ekj(this.O00000Oo, account.name).O000000o(str, str2);
        }
    }

    public final String O000000o(Account account, String str) {
        if (account == null) {
            throw new IllegalArgumentException("account cannot be null");
        } else if (this.f6322O000000o.O00000o0()) {
            return this.f6322O000000o.O000000o(account, str);
        } else {
            return new ekj(this.O00000Oo, account.name).O000000o(str);
        }
    }
}
