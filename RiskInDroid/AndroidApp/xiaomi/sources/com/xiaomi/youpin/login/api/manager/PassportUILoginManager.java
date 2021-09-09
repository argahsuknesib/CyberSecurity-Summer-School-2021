package com.xiaomi.youpin.login.api.manager;

import _m_j.goq;
import _m_j.gsy;
import _m_j.ibh;
import _m_j.ibp;
import _m_j.ick;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.youpin.login.api.manager.PassportUILoginManager;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.util.List;

public class PassportUILoginManager extends CoreBaseLoginManager {

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    interface O00000Oo {
        void O000000o();
    }

    public PassportUILoginManager(Context context) {
        super(context);
    }

    public final void O000000o(Activity activity, Bundle bundle, String str, ibp ibp, O000000o o000000o) {
        $$Lambda$PassportUILoginManager$dy1iIQR5p9UapLlF7YcdmHa4WCA r0 = new Runnable(bundle, str, activity, o000000o, ibp) {
            /* class com.xiaomi.youpin.login.api.manager.$$Lambda$PassportUILoginManager$dy1iIQR5p9UapLlF7YcdmHa4WCA */
            private final /* synthetic */ Bundle f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ Activity f$3;
            private final /* synthetic */ PassportUILoginManager.O000000o f$4;
            private final /* synthetic */ ibp f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                PassportUILoginManager.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        };
        MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(CommonApplication.getApplication());
        O00000Oo2.O00000oO();
        if (O00000Oo2.O00000oo() == null) {
            r0.run();
            return;
        }
        gsy.O00000Oo("PwdLoginManagerNew", "ensureNoLocalAccount: local account exist,remove first.");
        O00000Oo2.O000000o(new AccountManagerCallback<Boolean>(r0, null, activity) {
            /* class com.xiaomi.youpin.login.api.manager.PassportUILoginManager.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Runnable f12073O000000o;
            final /* synthetic */ O00000Oo O00000Oo = null;
            final /* synthetic */ Activity O00000o0;

            {
                this.f12073O000000o = r2;
                this.O00000o0 = r4;
            }

            public final void run(AccountManagerFuture<Boolean> accountManagerFuture) {
                try {
                    accountManagerFuture.getResult();
                    gsy.O00000Oo("PwdLoginManagerNew", "ensureNoLocalAccount: local account exist,remove success.");
                    this.f12073O000000o.run();
                    if (this.O00000Oo != null) {
                        Activity activity = this.O00000o0;
                        O00000Oo o00000Oo = this.O00000Oo;
                        o00000Oo.getClass();
                        activity.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.youpin.login.api.manager.$$Lambda$jV_lZr7BaMBejy5a4Te5uwM4juw */

                            public final void run() {
                                PassportUILoginManager.O00000Oo.this.O000000o();
                            }
                        });
                    }
                } catch (Exception e) {
                    O00000Oo o00000Oo2 = this.O00000Oo;
                    if (o00000Oo2 != null) {
                        Activity activity2 = this.O00000o0;
                        o00000Oo2.getClass();
                        activity2.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.youpin.login.api.manager.$$Lambda$jV_lZr7BaMBejy5a4Te5uwM4juw */

                            public final void run() {
                                PassportUILoginManager.O00000Oo.this.O000000o();
                            }
                        });
                    }
                    gsy.O00000Oo("PwdLoginManagerNew", "ensureNoLocalAccount local account exist,remove error: " + Log.getStackTraceString(e));
                }
            }
        }, (Handler) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Bundle bundle, String str, Activity activity, O000000o o000000o, ibp ibp) {
        goq.O000000o(new Runnable(bundle, str, activity, o000000o, ibp) {
            /* class com.xiaomi.youpin.login.api.manager.$$Lambda$PassportUILoginManager$JHjXSZW1Un70Cndk8IXUvJ1Mq64 */
            private final /* synthetic */ Bundle f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ Activity f$3;
            private final /* synthetic */ PassportUILoginManager.O000000o f$4;
            private final /* synthetic */ ibp f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                PassportUILoginManager.this.O00000Oo(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Bundle bundle, String str, Activity activity, O000000o o000000o, ibp ibp) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putString("default_auth_provider", "ID_PSW_AUTH_PROVIDER");
        if (!TextUtils.isEmpty(str)) {
            bundle2.putString("default_phone_country_code", str);
        }
        MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(CommonApplication.getApplication());
        O00000Oo2.O00000oO();
        O00000Oo2.O000000o("com.xiaomi", this.O00000o0, null, bundle2, activity, new AccountManagerCallback(o000000o, activity, ibp) {
            /* class com.xiaomi.youpin.login.api.manager.$$Lambda$PassportUILoginManager$JI1eJOK2BJVcJRrt2LswqLBJNw */
            private final /* synthetic */ PassportUILoginManager.O000000o f$1;
            private final /* synthetic */ Activity f$2;
            private final /* synthetic */ ibp f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run(AccountManagerFuture accountManagerFuture) {
                PassportUILoginManager.this.O000000o(this.f$1, this.f$2, this.f$3, accountManagerFuture);
            }
        }, null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final O000000o o000000o, final Activity activity, final ibp ibp, AccountManagerFuture accountManagerFuture) {
        try {
            Bundle bundle = (Bundle) accountManagerFuture.getResult();
            boolean z = bundle.getBoolean("booleanResult");
            int i = bundle.getInt("errorCode");
            if (z) {
                if (o000000o != null) {
                    o000000o.O000000o();
                }
                ick.O000000o(activity, this.O00000o0, new ibh<MiServiceTokenInfo, ExceptionError>() {
                    /* class com.xiaomi.youpin.login.api.manager.PassportUILoginManager.AnonymousClass2 */

                    public final /* synthetic */ void onFailure(Error error) {
                        ExceptionError exceptionError = (ExceptionError) error;
                        gsy.O00000Oo("PwdLoginManagerNew", "loginRequiredSid onFailure: WECHAT_NEW_LOGIN_FAIL_REQUIRED_SID: " + exceptionError.toString());
                        ibp.O000000o(-8202, exceptionError.toString(), null);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                        Account O00000oo = MiAccountManager.O00000Oo(CommonApplication.getApplication()).O00000oo();
                        if (O00000oo == null) {
                            gsy.O00000Oo("PwdLoginManagerNew", "loginRequiredSid: MiAccountManager.get(mContext).getXiaomiAccount should not be null");
                            ibp.O000000o(-998, "npe MiAccountManager.get(mContext).getXiaomiAccount() ", null);
                            return;
                        }
                        LoginMiAccount loginMiAccount = new LoginMiAccount();
                        List list = PassportUILoginManager.this.O0000O0o ? PassportUILoginManager.this.O00000oO : PassportUILoginManager.this.O00000o;
                        PassportUILoginManager passportUILoginManager = PassportUILoginManager.this;
                        Context context = activity;
                        ick.O000000o(context, list, new ibh<List<MiServiceTokenInfo>, ExceptionError>(miServiceTokenInfo, loginMiAccount, O00000oo.name, context, ibp, o000000o) {
                            /* class com.xiaomi.youpin.login.api.manager.PassportUILoginManager.AnonymousClass3 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ MiServiceTokenInfo f12075O000000o;
                            final /* synthetic */ LoginMiAccount O00000Oo;
                            final /* synthetic */ Context O00000o;
                            final /* synthetic */ String O00000o0;
                            final /* synthetic */ ibp O00000oO;
                            final /* synthetic */ O000000o O00000oo;

                            {
                                this.f12075O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                                this.O00000o = r5;
                                this.O00000oO = r6;
                                this.O00000oo = r7;
                            }

                            public final /* synthetic */ void onFailure(Error error) {
                                ExceptionError exceptionError = (ExceptionError) error;
                                gsy.O00000Oo("PwdLoginManagerNew", "loginOptionalSids onFailure: WECHAT_NEW_LOGIN_FAIL_REQUIRED_SID: " + exceptionError.toString());
                                this.O00000oO.O000000o(-8202, exceptionError.toString(), null);
                                O000000o o000000o = this.O00000oo;
                                if (o000000o != null) {
                                    o000000o.O00000Oo();
                                }
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                List list = (List) obj;
                                list.add(this.f12075O000000o);
                                this.O00000Oo.O000000o(this.O00000o0, PassportUILoginManager.O000000o(), false, list);
                                PassportUILoginManager.O000000o(this.O00000Oo, this.O00000oO);
                                O000000o o000000o = this.O00000oo;
                                if (o000000o != null) {
                                    o000000o.O00000Oo();
                                }
                            }
                        });
                    }
                });
            } else if (i == 4) {
                gsy.O00000Oo("PwdLoginManagerNew", "startPassportLoginUI: login cancel by user, code: ".concat(String.valueOf(i)));
                ibp.O000000o(i, "login cancel by user,code: ".concat(String.valueOf(i)), null);
            } else {
                ibp.O000000o(i, "login failed,code: ".concat(String.valueOf(i)), null);
                gsy.O00000Oo("PwdLoginManagerNew", "startPassportLoginUI: login failed with code: ".concat(String.valueOf(i)));
            }
        } catch (Exception e) {
            ibp.O000000o(-998, e.getMessage(), null);
            gsy.O00000Oo("PwdLoginManagerNew", "startPassportLoginUI: login error: " + Log.getStackTraceString(e));
        }
    }

    public static String O000000o() {
        ExtendedAuthToken parse;
        try {
            MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(CommonApplication.getApplication());
            String O000000o2 = O00000Oo2.O000000o(O00000Oo2.O00000oo());
            if (!TextUtils.isEmpty(O000000o2) && (parse = ExtendedAuthToken.parse(O000000o2)) != null) {
                return parse.authToken;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
