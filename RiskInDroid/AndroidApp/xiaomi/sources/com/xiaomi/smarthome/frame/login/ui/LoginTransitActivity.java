package com.xiaomi.smarthome.frame.login.ui;

import _m_j.egt;
import _m_j.fsp;
import _m_j.ft;
import _m_j.fta;
import _m_j.fth;
import _m_j.ftj;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.gpc;
import _m_j.gpz;
import _m_j.gsy;
import _m_j.hsl;
import _m_j.ibp;
import _m_j.ibt;
import _m_j.ici;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.frame.login.ui.LoginTransitActivity;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.youpin.login.api.manager.LoginManager;
import com.xiaomi.youpin.login.api.manager.PassportUILoginManager;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Map;

@RouterService
public class LoginTransitActivity extends BaseActivity {
    private Bundle loginBundle = new Bundle();
    public O000000o mDialog;
    private Disposable mDisposable;
    private LoginMethod mLoginMethod;
    private int mLoginType;
    private MijiaLoginManager mMijiaLoginManager;

    public enum LoginMethod {
        PWD,
        MIUI,
        PHONE,
        AUTO
    }

    public static void startLogin(Context context, LoginMethod loginMethod, int i) {
        Intent intent = new Intent(context, LoginTransitActivity.class);
        if (loginMethod == null) {
            loginMethod = LoginMethod.AUTO;
        }
        intent.putExtra("arg_login_method", loginMethod);
        intent.putExtra("arg_login_type", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
            intent.addFlags(67108864);
        }
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_login_transit);
        processIntent();
    }

    private void processIntent() {
        this.mLoginMethod = (LoginMethod) getIntent().getSerializableExtra("arg_login_method");
        if (this.mLoginMethod == null) {
            this.mLoginMethod = LoginMethod.AUTO;
        }
        this.mLoginType = getIntent().getIntExtra("arg_login_type", 5);
        startLogin();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent();
    }

    private void startLogin() {
        if (this.mLoginMethod == LoginMethod.AUTO || this.mLoginMethod == LoginMethod.MIUI) {
            String O00000Oo = ici.O00000Oo(this);
            if (TextUtils.isEmpty(O00000Oo)) {
                startPassportLoginUI();
            } else {
                startMIUILogin(O00000Oo);
            }
        } else if (this.mLoginMethod == LoginMethod.PWD) {
            startPassportLoginUI();
        }
    }

    private String getRecommendCountryCode() {
        try {
            String str = gpz.O000000o(CommonApplication.getAppContext(), ftn.O00000o0(this).getCountry()).O00000Oo;
            gsy.O00000Oo("LoginTransitActivity", "getRecommendCountryCode: ".concat(String.valueOf(str)));
            if (!TextUtils.isEmpty(str)) {
                return "+".concat(String.valueOf(str));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void startPassportLoginUI() {
        Analytics.O000000o(getApplicationContext());
        initSnsSetting();
        if (hsl.O00000Oo().getServerSelectActivity(this) != null) {
            this.loginBundle.putParcelable("choose_country_intent", new Intent(this, hsl.O00000Oo().getServerSelectActivity(this)));
        }
        refreshRegion(true);
    }

    private void initSnsSetting() {
        ArrayList arrayList = new ArrayList();
        if (ftn.O00000oo(this)) {
            arrayList.add("FACEBOOK_AUTH_PROVIDER");
        } else {
            arrayList.add("WECHAT_AUTH_PROVIDER");
        }
        if (gfr.O0000oO0 || !ftn.O00000oo(this)) {
            egt egt = egt.f15254O000000o;
            egt.O00000oo();
        }
        egt egt2 = egt.f15254O000000o;
        egt.O000000o(arrayList);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        refreshRegion(false);
    }

    private void refreshRegion(boolean z) {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO != null) {
            this.mDisposable = hsl.O00000Oo().getServerName(O0000ooO).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$x8bVwoDcknes3Ja2TTQTQMyz2I */

                public final void accept(Object obj) {
                    LoginTransitActivity.this.lambda$refreshRegion$0$LoginTransitActivity((String) obj);
                }
            }, new Consumer() {
                /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$skn_q9xu6c4yqP5_t97SmZpp7g */

                public final void accept(Object obj) {
                    LoginTransitActivity.this.lambda$refreshRegion$1$LoginTransitActivity((Throwable) obj);
                }
            }, new Action(z) {
                /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$JFvtUYDKAsRmUb3_f2auJdlRItg */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    LoginTransitActivity.this.lambda$refreshRegion$2$LoginTransitActivity(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$refreshRegion$0$LoginTransitActivity(String str) throws Exception {
        this.loginBundle.remove("choose_country_init_text");
        this.loginBundle.putString("choose_country_init_text", str);
    }

    public /* synthetic */ void lambda$refreshRegion$1$LoginTransitActivity(Throwable th) throws Exception {
        this.loginBundle.remove("choose_country_init_text");
        this.loginBundle.putString("choose_country_init_text", "");
        gsy.O000000o(3, "LoginTransitActivity", "refreshRegion: " + Log.getStackTraceString(th));
    }

    public /* synthetic */ void lambda$refreshRegion$2$LoginTransitActivity(boolean z) throws Exception {
        if (z) {
            if (this.mMijiaLoginManager == null) {
                this.mMijiaLoginManager = new MijiaLoginManager(this);
            }
            MijiaLoginManager mijiaLoginManager = this.mMijiaLoginManager;
            Bundle bundle = this.loginBundle;
            String recommendCountryCode = getRecommendCountryCode();
            AnonymousClass1 r0 = new ibp() {
                /* class com.xiaomi.smarthome.frame.login.ui.LoginTransitActivity.AnonymousClass1 */

                public final void O000000o(LoginMiAccount loginMiAccount) {
                    LoginTransitActivity.this.runOnUiThread(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$1$0cO9Yvbu7QVBwNYqFnplJZdOv44 */

                        public final void run() {
                            LoginTransitActivity.AnonymousClass1.this.O000000o();
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    LoginTransitActivity.this.processLoginSuccess(3);
                    LoginTransitActivity.this.finish();
                }

                public final void O000000o(int i, String str, Map<String, String> map) {
                    LoginTransitActivity.this.runOnUiThread(new Runnable(i) {
                        /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$1$3Lh2zAkKY1UOD1LQOMacOOcCKo */
                        private final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            LoginTransitActivity.AnonymousClass1.this.O000000o(this.f$1);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(int i) {
                    if (i != 4) {
                        fta fta = fta.O000000o.f17086O000000o;
                        fta.O000000o((int) R.string.login_fail);
                    }
                    LoginTransitActivity.this.processLoginFail();
                    LoginTransitActivity.this.finish();
                }
            };
            AnonymousClass2 r1 = new PassportUILoginManager.O000000o() {
                /* class com.xiaomi.smarthome.frame.login.ui.LoginTransitActivity.AnonymousClass2 */

                public final void O000000o() {
                    LoginTransitActivity.this.runOnUiThread(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$2$xx7l6ZQ_w4MCjXZkKUwdb_CE72M */

                        public final void run() {
                            LoginTransitActivity.AnonymousClass2.this.O00000o();
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000o() {
                    if (LoginTransitActivity.this.isValid()) {
                        if (LoginTransitActivity.this.mDialog == null) {
                            LoginTransitActivity loginTransitActivity = LoginTransitActivity.this;
                            loginTransitActivity.mDialog = new O000000o(loginTransitActivity);
                        }
                        O000000o o000000o = LoginTransitActivity.this.mDialog;
                        if (o000000o.O00000oO) {
                            o000000o.O00000o = true;
                            o000000o.f7544O000000o.setVisibility(0);
                            o000000o.O00000Oo.animate().setDuration(200).alpha(0.6f).start();
                            o000000o.O00000o0.animate().setDuration(200).translationY(0.0f).start();
                        }
                        LoginTransitActivity.this.notifyMiuiLoginPageResult(true);
                    }
                }

                public final void O00000Oo() {
                    LoginTransitActivity.this.runOnUiThread(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$2$TCPcuEt5z46IpQYeN4vhXi9MhU8 */

                        public final void run() {
                            LoginTransitActivity.AnonymousClass2.this.O00000o0();
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000o0() {
                    if (LoginTransitActivity.this.isValid()) {
                        if (LoginTransitActivity.this.mDialog != null) {
                            LoginTransitActivity.this.mDialog.O000000o();
                        }
                        LoginTransitActivity.this.finish();
                    }
                }
            };
            LoginManager.AnonymousClass1 r4 = new ibp(r0) {
                /* class com.xiaomi.youpin.login.api.manager.LoginManager.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ ibp f12067O000000o;

                {
                    this.f12067O000000o = r2;
                }

                public final void O000000o(LoginMiAccount loginMiAccount) {
                    LoginManager.this.O000000o("Passport", loginMiAccount, null, this.f12067O000000o);
                }

                public final void O000000o(int i, String str, Map<String, String> map) {
                    this.f12067O000000o.O000000o(i, str, map);
                    Map<String, String> O000000o2 = ibt.O000000o(i, str);
                    if (map != null) {
                        O000000o2.putAll(map);
                    }
                    gsy.O00000Oo(4000, "4000.0.1", "");
                    LoginManager.this.O000000o("Passport", i, str, map, this.f12067O000000o);
                }
            };
            if (mijiaLoginManager.O00000oO == null) {
                mijiaLoginManager.O00000oO = new PassportUILoginManager(this);
            }
            mijiaLoginManager.O00000oO.O000000o(this, bundle, recommendCountryCode, r4, new PassportUILoginManager.O000000o(r1) {
                /* class com.xiaomi.youpin.login.api.manager.LoginManager.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ PassportUILoginManager.O000000o f12068O000000o;

                {
                    this.f12068O000000o = r2;
                }

                public final void O000000o() {
                    LoginManager.this.O00000o0();
                    PassportUILoginManager.O000000o o000000o = this.f12068O000000o;
                    if (o000000o != null) {
                        o000000o.O000000o();
                    }
                }

                public final void O00000Oo() {
                    PassportUILoginManager.O000000o o000000o = this.f12068O000000o;
                    if (o000000o != null) {
                        o000000o.O00000Oo();
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        O000000o o000000o = this.mDialog;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        Disposable disposable = this.mDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void onBackPressed() {
        O000000o o000000o = this.mDialog;
        if (o000000o == null || !o000000o.O00000o) {
            super.onBackPressed();
        } else {
            this.mDialog.O00000Oo();
        }
    }

    private void startMIUILogin(String str) {
        Intent intent = new Intent(this, LoginMiuiActivity.class);
        intent.putExtra("account_id", str);
        intent.putExtra("login_timestamp", System.currentTimeMillis());
        intent.putExtra("login_type", this.mLoginType);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void processLoginFail() {
        fsp.O000000o().O00000oo.O00000Oo();
        notifyMiuiLoginPageResult(false);
    }

    public void notifyMiuiLoginPageResult(boolean z) {
        Intent intent = new Intent("action_other_login_method_result");
        intent.putExtra("arg_other_login_method_result", z);
        ft.O000000o(this).O000000o(intent);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f7544O000000o;
        View O00000Oo;
        public boolean O00000o = false;
        View O00000o0;
        boolean O00000oO = false;
        private Activity O00000oo;

        O000000o(Activity activity) {
            this.O00000oo = activity;
            this.O00000oO = O000000o(activity);
            if (!this.O00000oO) {
                this.O00000oo.finish();
            }
        }

        private boolean O000000o(Activity activity) {
            try {
                this.f7544O000000o = activity.findViewById(R.id.mock_dialog);
                this.O00000Oo = activity.findViewById(R.id.mock_mask);
                this.O00000o0 = activity.findViewById(R.id.mock_view);
                this.O00000o0.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$O000000o$TbL4NcQ2Z7M11EiTYhxUZnEb0w */

                    public final void onClick(View view) {
                        LoginTransitActivity.O000000o.this.O000000o(view);
                    }
                });
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            O00000Oo();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gpc.O000000o(android.app.Activity, float):int
         arg types: [android.app.Activity, int]
         candidates:
          _m_j.gpc.O000000o(android.content.Context, float):int
          _m_j.gpc.O000000o(android.view.View, int):void
          _m_j.gpc.O000000o(android.app.Activity, float):int */
        /* access modifiers changed from: package-private */
        public final void O000000o() {
            if (this.O00000o && this.O00000oO) {
                this.O00000Oo.animate().setDuration(200).alpha(0.0f).start();
                this.O00000o0.animate().setDuration(200).translationY((float) gpc.O000000o(this.O00000oo, 500.0f)).withEndAction(new Runnable() {
                    /* class com.xiaomi.smarthome.frame.login.ui.LoginTransitActivity.O000000o.AnonymousClass1 */

                    public final void run() {
                        O000000o.this.f7544O000000o.setVisibility(4);
                        O000000o.this.O00000o = false;
                    }
                });
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gpc.O000000o(android.app.Activity, float):int
         arg types: [android.app.Activity, int]
         candidates:
          _m_j.gpc.O000000o(android.content.Context, float):int
          _m_j.gpc.O000000o(android.view.View, int):void
          _m_j.gpc.O000000o(android.app.Activity, float):int */
        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            if (this.O00000o) {
                if (!this.O00000oO) {
                    Activity activity = this.O00000oo;
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                this.O00000Oo.animate().setDuration(200).alpha(0.0f).start();
                this.O00000o0.animate().setDuration(200).translationY((float) gpc.O000000o(this.O00000oo, 500.0f));
                this.O00000o0.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.frame.login.ui.$$Lambda$LoginTransitActivity$O000000o$twzrNPXyUIkTNfA1_vzDA5e9PQs */

                    public final void run() {
                        LoginTransitActivity.O000000o.this.O00000o0();
                    }
                }, 200);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000o0() {
            this.f7544O000000o.setVisibility(4);
            this.O00000oo.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void processLoginSuccess(int i) {
        try {
            fta fta = fta.O000000o.f17086O000000o;
            fta.O000000o((int) R.string.login_success);
            fsp.O000000o().O00000oo.O000000o(i);
            ftj.O000000o(getApplicationContext());
            setResult(-1);
            fth.O000000o(getApplicationContext(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish();
    }
}
