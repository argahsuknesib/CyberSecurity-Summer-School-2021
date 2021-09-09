package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cbm;
import _m_j.cbw;
import _m_j.ccn;
import _m_j.ccr;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

public class FacebookLoginActivity extends BaseActivity {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [com.mi.global.shop.activity.FacebookLoginActivity, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    public void onCreate(Bundle bundle) {
        ccr.O00000Oo("FacebookLoginActivity", "onCreate");
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra("FacebookLogin", false)) {
            ccr.O00000Oo("FacebookLoginActivity", "get null fb info");
        } else {
            ccr.O00000Oo("FacebookLoginActivity", "get userId:" + intent.getStringExtra("FacebookUid"));
            ccr.O00000Oo("FacebookLoginActivity", "get serviceToken:" + intent.getStringExtra("FacebookServiceToken"));
            String stringExtra = intent.getStringExtra("FacebookUid");
            String stringExtra2 = intent.getStringExtra("FacebookServiceToken");
            cbm.O00000o0.O000000o(this, "pref_uid", stringExtra);
            cbm.O00000o0.O000000o(this, "pref_extended_token", ExtendedAuthToken.build(stringExtra2, "Security").toPlain());
            cbm.O00000o0.O00000Oo((Context) this, "pref_login_system", false);
            ccn.O0000o00().O000000o(stringExtra, stringExtra2, "Security");
            cbw.O000000o();
            cbw.O00000o(byl.O00000oO());
            cbw.O00000o0(byl.O00000oO());
        }
        finish();
    }
}
