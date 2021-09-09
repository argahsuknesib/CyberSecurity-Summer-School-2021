package com.xiaomi.smarthome.miio.activity;

import _m_j.eyk;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ftn;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.hgn;
import _m_j.hsl;
import _m_j.hte;
import _m_j.hxi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.page.usrexpplan.UsrExpPlanActivity;
import com.xiaomi.smarthome.newui.onekey_delete.PaperShredderView;
import com.xiaomi.smarthome.operation.js_sdk.share.LoadingDialogHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LicenseChooseActivity extends CommonActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private Disposable f9685O000000o;
    private LoadingDialogHelper O00000Oo = new LoadingDialogHelper(this);

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        setContentView((int) R.layout.activity_license_and_privacy_setting);
        gwg.O00000Oo(getWindow());
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LicenseChooseActivity.AnonymousClass1 */

            public final void onClick(View view) {
                LicenseChooseActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.device_more_activity_license_privacy));
        new Intent(this, UserLicense.class);
        findViewById(R.id.license).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LicenseChooseActivity.AnonymousClass2 */

            public final void onClick(View view) {
                eyk.O000000o(LicenseChooseActivity.this, UserLicense.getUrlByTpye(UserLicense.TYPE_USER_LICENSE));
            }
        });
        findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LicenseChooseActivity.AnonymousClass3 */

            public final void onClick(View view) {
                eyk.O000000o(LicenseChooseActivity.this, UserLicense.getUrlByTpye(UserLicense.TYPE_USER_PRIVACY));
            }
        });
        View findViewById = findViewById(R.id.usr_exp_plan_container);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LicenseChooseActivity.AnonymousClass4 */

            public final void onClick(View view) {
                LicenseChooseActivity.this.startActivity(new Intent(LicenseChooseActivity.this, UsrExpPlanActivity.class));
            }
        });
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.miio.activity.LicenseChooseActivity.AnonymousClass5 */

            public final void onCoreReady() {
                LicenseChooseActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.activity.LicenseChooseActivity.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        if (ftn.O00000oO(CoreApi.O000000o().O0000ooO())) {
                            ((TextView) LicenseChooseActivity.this.findViewById(R.id.usr_exp_plan_container_tv)).setText((int) R.string.usr_exp_plan2);
                        }
                    }
                });
            }
        });
        TextView textView = (TextView) findViewById(R.id.cancel_license_btn);
        if (ftn.O00000oo(this)) {
            textView.setText((int) R.string.device_more_activity_revoke_auth);
        }
        if (!CoreApi.O000000o().O0000Ooo()) {
            textView.setEnabled(false);
            textView.setBackgroundColor(getResources().getColor(R.color.mj_color_black_05_transparent));
        }
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LicenseChooseActivity.AnonymousClass6 */

            public final void onClick(View view) {
                hxi.O00000o.f952O000000o.O000000o("user_private_page", new Object[0]);
                if (ftn.O00000oo(LicenseChooseActivity.this.getContext()) || ftn.O0000o0O(LicenseChooseActivity.this.getContext())) {
                    LicenseChooseActivity.this.startUserRightRevoke();
                } else {
                    fbs.O000000o(new fbt(LicenseChooseActivity.this, "RevokeAuthActivity").O000000o(602));
                }
            }
        });
    }

    public void startUserRightRevoke() {
        LoadingDialogHelper loadingDialogHelper = this.O00000Oo;
        loadingDialogHelper.f10523O000000o = false;
        loadingDialogHelper.O000000o();
        this.f9685O000000o = hgn.O000000o().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$LicenseChooseActivity$kvleGeO6darvYeg9nd6mzWXolQQ */

            public final void accept(Object obj) {
                LicenseChooseActivity.this.O000000o((String) obj);
            }
        }, new Consumer() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$LicenseChooseActivity$Y0IZrBwVdNWwaesw8DSIZLhkChk */

            public final void accept(Object obj) {
                LicenseChooseActivity.this.O000000o((Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str) throws Exception {
        this.O00000Oo.O00000Oo();
        if (TextUtils.isEmpty(str)) {
            gsy.O00000Oo(LogType.GENERAL, "LicenseChooseActivity", "startUserRightRevoke: empty url");
            hte.O000000o(this, (int) R.string.failed);
            return;
        }
        fbs.O000000o(new fbt(this, "RevokeAuthActivityNew").O000000o("url", str).O000000o(602));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Throwable th) throws Exception {
        this.O00000Oo.O00000Oo();
        hte.O000000o(this, (int) R.string.failed);
        LogType logType = LogType.GENERAL;
        gsy.O00000Oo(logType, "LicenseChooseActivity", "startUserRightRevoke: " + Log.getStackTraceString(th));
    }

    public void onResume() {
        super.onResume();
        hxi.O00000o0.f957O000000o.O000000o("user_private_page", new Object[0]);
    }

    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f9685O000000o;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(gwc.O00000Oo(context));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 602) {
            findViewById(R.id.item_group).setVisibility(4);
            findViewById(R.id.clear_group).setVisibility(0);
            PaperShredderView paperShredderView = (PaperShredderView) findViewById(R.id.clear_data_image);
            paperShredderView.setVisibility(0);
            paperShredderView.O000000o();
            ServiceApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.miio.activity.$$Lambda$LicenseChooseActivity$E_EOLcBibxrty42E6y8f8Frv5A */

                public final void run() {
                    LicenseChooseActivity.this.O000000o();
                }
            }, 3000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        hsl.O00000Oo().clearAppData(this);
        finishAffinity();
        Process.killProcess(Process.myPid());
    }
}
