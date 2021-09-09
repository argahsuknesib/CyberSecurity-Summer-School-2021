package com.xiaomi.youpin.login;

import _m_j.ft;
import _m_j.ich;
import android.accounts.Account;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LoginRouter$1 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ ich f12064O000000o;

    public LoginRouter$1(ich ich) {
        this.f12064O000000o = ich;
    }

    public final void onReceive(Context context, Intent intent) {
        ft.O000000o(context.getApplicationContext()).O000000o(this);
        if (intent.getBooleanExtra("mijia.access.xm_account.param.is_success", false)) {
            this.f12064O000000o.O000000o(new Account(intent.getStringExtra("mijia.access.xm_account.param.account_name"), intent.getStringExtra("mijia.access.xm_account.param.account_type")));
            return;
        }
        this.f12064O000000o.O000000o(-1, "");
    }
}
