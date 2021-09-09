package com.xiaomi.smarthome.miio.page.usrexpplan;

import _m_j.fsl;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.gpc;
import _m_j.gwc;
import _m_j.gwg;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class PrivacySettingActivity extends CommonActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f9952O000000o;
    private SwitchButton O00000Oo;
    public String mDid;
    public TextView tvExpPlan;

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.activity_privacy_setting_layout);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.usrexpplan.PrivacySettingActivity.AnonymousClass1 */

            public final void onClick(View view) {
                PrivacySettingActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.privacy_setting);
        this.f9952O000000o = (TextView) findViewById(R.id.app_info);
        this.O00000Oo = (SwitchButton) findViewById(R.id.usr_exp_plan_switch);
        this.tvExpPlan = (TextView) findViewById(R.id.usr_exp_plan_container_tv);
        getWindow().addFlags(524288);
        Intent intent = getIntent();
        if (intent != null) {
            this.mDid = intent.getStringExtra("device_did");
        }
        this.O00000Oo.setChecked(TextUtils.isEmpty(this.mDid) ? fsl.O000000o(getApplicationContext()) : fsl.O000000o(getApplicationContext(), this.mDid));
        this.O00000Oo.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.page.usrexpplan.PrivacySettingActivity.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                privacySettingActivity.toggleUsrExpPlanSwitch(!TextUtils.isEmpty(privacySettingActivity.mDid) ? !fsl.O000000o(PrivacySettingActivity.this.getApplicationContext(), PrivacySettingActivity.this.mDid) : !fsl.O000000o(PrivacySettingActivity.this.getApplicationContext()));
            }
        });
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.miio.page.usrexpplan.PrivacySettingActivity.AnonymousClass5 */

            public final void onCoreReady() {
                if (ftn.O00000oO(CoreApi.O000000o().O0000ooO())) {
                    PrivacySettingActivity.this.tvExpPlan.setText((int) R.string.usr_exp_plan2);
                }
            }
        });
        findViewById(R.id.usr_exp_plan_tip).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.usrexpplan.PrivacySettingActivity.AnonymousClass2 */

            public final void onClick(View view) {
                PrivacySettingActivity.this.gotoUsrExpPlanActivity();
            }
        });
        try {
            String format = String.format(getString(R.string.version_name_string), getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (gfr.O0000o0o) {
                TextView textView = this.f9952O000000o;
                textView.setText(format + " 测试版");
            } else {
                this.f9952O000000o.setText(format);
            }
            if (!gfr.O0000Ooo) {
                this.f9952O000000o.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.usrexpplan.PrivacySettingActivity.AnonymousClass3 */

                    public final boolean onLongClick(View view) {
                        Vibrator vibrator = (Vibrator) PrivacySettingActivity.this.getSystemService("vibrator");
                        if (!vibrator.hasVibrator()) {
                            return false;
                        }
                        vibrator.vibrate(100);
                        return false;
                    }
                });
            }
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                findViewById(R.id.international_icon).setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    public void gotoUsrExpPlanActivity() {
        Intent intent = new Intent(this, UsrExpPlanActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void toggleUsrExpPlanSwitch(boolean z) {
        if (TextUtils.isEmpty(this.mDid)) {
            fsl.O000000o(getApplicationContext(), z);
        } else {
            fsl.O000000o(getApplicationContext(), this.mDid, z);
        }
        this.O00000Oo.setChecked(z);
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public void onContentChanged() {
        super.onContentChanged();
        gwg.O00000o(this);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(gwc.O00000Oo(context));
    }
}
