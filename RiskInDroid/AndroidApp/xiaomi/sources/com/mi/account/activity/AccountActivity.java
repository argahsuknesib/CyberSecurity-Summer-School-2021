package com.mi.account.activity;

import _m_j.bxq;
import _m_j.bxr;
import _m_j.bxs;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ceh;
import _m_j.cej;
import _m_j.cem;
import _m_j.cen;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import com.mi.account.LoginDialog;
import com.mi.activity.BaseActivity;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;
import com.xiaomi.smarthome.R;

public class AccountActivity extends BaseActivity {
    public static final String TAG = "AccountActivity";
    private LoginDialog dialog;

    /* access modifiers changed from: protected */
    public void onLocalLoginFailed() {
    }

    public void gotoAccount() {
        final String[] strArr;
        if (Build.VERSION.SDK_INT < 26) {
            strArr = new String[]{"android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE"};
        } else {
            strArr = new String[]{"android.permission.READ_PHONE_STATE"};
        }
        if (!cem.O000000o(this, strArr)) {
            AnonymousClass1 r1 = new DialogInterface.OnClickListener() {
                /* class com.mi.account.activity.AccountActivity.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    cem.O000000o(AccountActivity.this, new cen() {
                        /* class com.mi.account.activity.AccountActivity.AnonymousClass1.AnonymousClass1 */

                        public final void O00000Oo() {
                        }

                        public final void O000000o() {
                            AccountActivity.this.goLogin();
                        }
                    }, strArr);
                }
            };
            cem.O000000o(this, bxr.O000000o(this) + " " + getResources().getString(R.string.explain_contact_permission), r1);
            return;
        }
        goLogin();
    }

    /* access modifiers changed from: protected */
    public void goLogin() {
        if (!isMiui(getApplicationContext()) || Build.VERSION.SDK_INT < 26) {
            showLogin();
        } else {
            canAccessAccount();
        }
    }

    public static boolean isMiui(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [com.mi.account.activity.AccountActivity, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public void showLogin() {
        bxq O000000o2 = bxq.O000000o();
        O000000o2.O00000o.O000000o(MiAccountManager.AccountAuthenticator.SYSTEM);
        if (!O000000o2.O0000O0o() || !cej.O00000Oo.O000000o((Context) this, "pref_miui_account_available", false)) {
            gotoLogin();
        } else {
            showSystemLoginDialog();
        }
    }

    private void showSystemLoginDialog() {
        if (this.dialog == null) {
            this.dialog = new LoginDialog(this);
            this.dialog.f4549O000000o = new LoginDialog.O000000o() {
                /* class com.mi.account.activity.AccountActivity.AnonymousClass2 */

                public final void O000000o() {
                    ceh.O000000o(new Runnable() {
                        /* class com.mi.account.activity.AccountActivity.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            bxq O000000o2 = bxq.O000000o();
                            bxs.O000000o.O00000Oo();
                            String O000000o3 = O000000o2.O000000o(bxs.O000000o.O00000o0(), true);
                            if (!TextUtils.isEmpty(O000000o3)) {
                                bxq.O000000o().O00000o(O000000o3);
                            } else {
                                cec.O000000o(AccountActivity.this, (int) R.string.login_system_failed, 0);
                            }
                        }
                    });
                }

                public final void O00000Oo() {
                    bxq.O000000o().O000000o(false);
                    AccountActivity.this.gotoLogin();
                }
            };
        }
        try {
            if (!isFinishing() && !isDestroyed()) {
                this.dialog.show();
            }
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    public void gotoLogin() {
        MiAccountManager miAccountManager = bxq.O000000o().O00000o;
        miAccountManager.O000000o(MiAccountManager.AccountAuthenticator.LOCAL);
        doLocalLogin(miAccountManager);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010 && i2 == -1) {
            intent.getStringExtra("authAccount");
            String stringExtra = intent.getStringExtra("accountType");
            AccountLog.i(TAG, "accountType: ".concat(String.valueOf(stringExtra)));
            if (TextUtils.equals(stringExtra, "com.xiaomi")) {
                cej.O00000Oo.O00000Oo(getApplicationContext(), "pref_miui_account_available", true);
                showLogin();
                return;
            }
            return;
        }
        AccountLog.i(TAG, "newChooseAccount cancelled");
    }

    private void doLocalLogin(MiAccountManager miAccountManager) {
        bxs.O000000o.O00000Oo();
        miAccountManager.O000000o("com.xiaomi", bxs.O000000o.O00000o0(), null, new Bundle(), this, new AccountManagerCallback<Bundle>() {
            /* class com.mi.account.activity.AccountActivity.AnonymousClass3 */

            public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                try {
                    Bundle result = accountManagerFuture.getResult();
                    if (result != null) {
                        ccr.O00000Oo(AccountActivity.TAG, "get bundle:".concat(String.valueOf(result)));
                    }
                    if (result.getBoolean("booleanResult")) {
                        ccr.O00000Oo(AccountActivity.TAG, "Add account succeed!");
                        ceh.O000000o(new Runnable() {
                            /* class com.mi.account.activity.AccountActivity.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                bxq.O000000o().O0000Oo0();
                            }
                        });
                        return;
                    }
                    ccr.O00000Oo(AccountActivity.TAG, "Add account failed or not finished!");
                    AccountActivity.this.onLocalLoginFailed();
                } catch (Exception e) {
                    String str = AccountActivity.TAG;
                    ccr.O00000Oo(str, "get Exception:" + e.toString());
                    e.printStackTrace();
                }
            }
        }, null);
    }

    public boolean checkLogin() {
        return loginPassport();
    }

    private boolean loginPassport() {
        if (bxq.O000000o().O00000oo()) {
            return true;
        }
        gotoAccount();
        return false;
    }

    private void canAccessAccount() {
        final MiAccountManager miAccountManager = bxq.O000000o().O00000o;
        miAccountManager.O000000o(MiAccountManager.AccountAuthenticator.SYSTEM);
        final MiAccountManagerFuture<XmAccountVisibility> O000000o2 = miAccountManager.O000000o(getApplicationContext());
        new AsyncTask<Void, Void, XmAccountVisibility>() {
            /* class com.mi.account.activity.AccountActivity.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
             arg types: [android.content.Context, java.lang.String, int]
             candidates:
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                XmAccountVisibility xmAccountVisibility = (XmAccountVisibility) obj;
                super.onPostExecute(xmAccountVisibility);
                if (xmAccountVisibility != null) {
                    int i = AnonymousClass5.f4560O000000o[xmAccountVisibility.f6203O000000o.ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            MiAccountManager miAccountManager = miAccountManager;
                            bxs.O000000o.O00000Oo();
                            miAccountManager.O000000o("com.xiaomi", bxs.O000000o.O00000o0(), null, null, AccountActivity.this, new AccountManagerCallback<Bundle>() {
                                /* class com.mi.account.activity.AccountActivity.AnonymousClass4.AnonymousClass1 */

                                public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                }
                            }, null);
                            return;
                        } else if (i == 3) {
                            Intent intent = xmAccountVisibility.O00000oo;
                            if (intent != null) {
                                intent.putExtra("descriptionTextOverride", AccountActivity.this.getString(R.string.tips_mi_account_login));
                                AccountActivity.this.startActivityForResult(intent, 1010);
                                return;
                            }
                            return;
                        }
                    } else if (xmAccountVisibility.O00000o0) {
                        cej.O00000Oo.O00000Oo(AccountActivity.this.getApplicationContext(), "pref_miui_account_available", true);
                        AccountActivity.this.showLogin();
                        return;
                    } else {
                        return;
                    }
                }
                AccountActivity.this.gotoLogin();
            }

            private XmAccountVisibility O000000o() {
                try {
                    return (XmAccountVisibility) O000000o2.get();
                } catch (Exception e) {
                    AccountLog.w(AccountActivity.TAG, e);
                    return null;
                }
            }
        }.execute(new Void[0]);
    }

    /* renamed from: com.mi.account.activity.AccountActivity$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f4560O000000o = new int[XmAccountVisibility.ErrorCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f4560O000000o[XmAccountVisibility.ErrorCode.ERROR_NONE.ordinal()] = 1;
            f4560O000000o[XmAccountVisibility.ErrorCode.ERROR_NO_ACCOUNT.ordinal()] = 2;
            f4560O000000o[XmAccountVisibility.ErrorCode.ERROR_NOT_SUPPORT.ordinal()] = 3;
            try {
                f4560O000000o[XmAccountVisibility.ErrorCode.ERROR_NO_PERMISSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
