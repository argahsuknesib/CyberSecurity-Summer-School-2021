package com.xiaomi.smarthome.frame.login.ui;

import _m_j.fsp;
import _m_j.ft;
import _m_j.fta;
import _m_j.fth;
import _m_j.fti;
import _m_j.gsy;
import _m_j.gyl;
import _m_j.ibq;
import _m_j.ici;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity;
import com.xiaomi.smarthome.frame.login.ui.LoginTransitActivity;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import java.util.Map;

public class LoginMiuiActivity extends LoginBaseActivity {
    boolean O00000oO = true;
    private final BroadcastReceiver O00000oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "action_other_login_method_result") && intent.getBooleanExtra("arg_other_login_method_result", false)) {
                LoginMiuiActivity.this.finish();
            }
        }
    };

    interface O000000o {
        void O000000o();
    }

    /* access modifiers changed from: protected */
    public final boolean O00000oO() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    public final void O000000o() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("account_id");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = ici.O00000Oo(this.f7534O000000o);
        }
        ((TextView) findViewById(R.id.account_name)).setText(stringExtra);
        boolean z = true;
        if (intent.getIntExtra("login_type", 1) == 3) {
            if (System.currentTimeMillis() - intent.getLongExtra("login_timestamp", 0) > 10000) {
                fsp.O000000o().O00000oo.O000000o(this);
                if (!z) {
                    finish();
                    return;
                }
                findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity.AnonymousClass1 */

                    public final void onClick(View view) {
                        LoginMiuiActivity.this.startLogin();
                    }
                });
                findViewById(R.id.change_account).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity.AnonymousClass2 */

                    public final void onClick(View view) {
                        LoginMiuiActivity.this.changeAccount();
                    }
                });
                gyl.O000000o(stringExtra, (SimpleDraweeView) findViewById(R.id.account_profile));
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    public void startLogin() {
        this.O00000o0.setMessage(getString(R.string.mj_login_passport_login_waiting));
        this.O00000o0.show();
        this.O00000o.O000000o(this, new ibq() {
            /* class com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity.AnonymousClass3 */

            public final void O000000o(LoginMiAccount loginMiAccount) {
                if (LoginMiuiActivity.this.isValid()) {
                    LoginMiuiActivity.this.O00000Oo();
                    LoginMiuiActivity.this.O00000o0();
                }
            }

            public final void O000000o(int i, String str, Map<String, String> map) {
                String str2;
                if (LoginMiuiActivity.this.isValid()) {
                    LoginMiuiActivity.this.O00000Oo();
                    if (!(i == -2013 || i == -2012 || i == -2010 || i == -2001)) {
                        switch (i) {
                            case -2008:
                            case -2007:
                            case -2006:
                                break;
                            default:
                                str2 = fti.O000000o(LoginMiuiActivity.this.getString(R.string.login_passport_login_fail), i, str);
                                break;
                        }
                        fta fta = fta.O000000o.f17086O000000o;
                        fta.O000000o(str2);
                        LoginMiuiActivity.O00000o();
                        LoginBaseActivity.O000000o("MIUI", i, str);
                    }
                    str2 = fti.O000000o(LoginMiuiActivity.this.getString(R.string.login_systemaccount_login_fail), i, str);
                    fta fta2 = fta.O000000o.f17086O000000o;
                    fta.O000000o(str2);
                    LoginMiuiActivity.O00000o();
                    LoginBaseActivity.O000000o("MIUI", i, str);
                }
            }
        });
    }

    public void changeAccount() {
        if (this.O00000oO) {
            this.O00000oO = false;
            final $$Lambda$LoginMiuiActivity$59aJqRvOGwM8UixDyTWLasu9XVI r0 = new Runnable() {
                /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginMiuiActivity$59aJqRvOGwM8UixDyTWLasu9XVI */

                public final void run() {
                    LoginMiuiActivity.this.O00000oo();
                }
            };
            final AnonymousClass5 r1 = new O000000o() {
                /* class com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity.AnonymousClass5 */

                public final void O000000o() {
                }
            };
            MiAccountManager O00000Oo = MiAccountManager.O00000Oo(this);
            O00000Oo.O00000oO();
            if (O00000Oo.O00000oo() == null) {
                r0.run();
                return;
            }
            gsy.O00000Oo("LoginMiuiActivity", "ensureNoLocalAccount: local account exist,remove first.");
            O00000Oo.O000000o(new AccountManagerCallback<Boolean>() {
                /* class com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity.AnonymousClass6 */

                public final void run(AccountManagerFuture<Boolean> accountManagerFuture) {
                    try {
                        accountManagerFuture.getResult();
                        gsy.O00000Oo("LoginMiuiActivity", "ensureNoLocalAccount: local account exist,remove success.");
                        r0.run();
                        LoginMiuiActivity loginMiuiActivity = LoginMiuiActivity.this;
                        O000000o o000000o = r1;
                        o000000o.getClass();
                        loginMiuiActivity.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$YqnUM2U49U3GdqzZDaZzVm_32og */

                            public final void run() {
                                LoginMiuiActivity.O000000o.this.O000000o();
                            }
                        });
                    } catch (Exception e) {
                        LoginMiuiActivity loginMiuiActivity2 = LoginMiuiActivity.this;
                        O000000o o000000o2 = r1;
                        o000000o2.getClass();
                        loginMiuiActivity2.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$YqnUM2U49U3GdqzZDaZzVm_32og */

                            public final void run() {
                                LoginMiuiActivity.O000000o.this.O000000o();
                            }
                        });
                        gsy.O00000Oo("LoginMiuiActivity", "ensureNoLocalAccount local account exist,remove error: " + Log.getStackTraceString(e));
                    }
                }
            }, (Handler) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo() {
        LoginTransitActivity.startLogin(this, LoginTransitActivity.LoginMethod.PWD, 1);
        ft.O000000o(getApplicationContext()).O000000o(this.O00000oo, new IntentFilter("action_other_login_method_result"));
        getWindow().getDecorView().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginMiuiActivity$5oi4IZjSszpwDUu2zeJWD1m_tU */

            public final void run() {
                LoginMiuiActivity.this.O0000O0o();
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000O0o() {
        this.O00000oO = true;
    }

    public void onDestroy() {
        super.onDestroy();
        ft.O000000o(getApplicationContext()).O000000o(this.O00000oo);
    }

    public void onBackPressed() {
        super.onBackPressed();
        fth.O000000o(this.f7534O000000o, false);
    }
}
