package com.xiaomi.smarthome.framework.page.rndebug;

import _m_j.fko;
import _m_j.fvo;
import _m_j.gfr;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hsi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.passport.ui.internal.ProgressDialog;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity;
import com.xiaomi.smarthome.framework.plugin.PluginInfoActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RnDebugOtherSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View.OnClickListener f7910O000000o = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass7 */

        public final void onClick(View view) {
            int id = view.getId();
            if (id == R.id.layout_device_plugin_info) {
                Intent intent = new Intent(RnDebugOtherSettingActivity.this, PluginInfoActivity.class);
                intent.putExtra("type", 1);
                RnDebugOtherSettingActivity.this.startActivity(intent);
            } else if (id == R.id.layout_plugin_install) {
                Intent intent2 = new Intent(RnDebugOtherSettingActivity.this, PluginInfoActivity.class);
                intent2.putExtra("type", 2);
                RnDebugOtherSettingActivity.this.startActivity(intent2);
            } else if (id == R.id.layout_plugin_download) {
                Intent intent3 = new Intent(RnDebugOtherSettingActivity.this, PluginInfoActivity.class);
                intent3.putExtra("type", 3);
                RnDebugOtherSettingActivity.this.startActivity(intent3);
            } else if (id == R.id.layout_plugin_export_log) {
                Observable.just(0).subscribeOn(Schedulers.io()).map($$Lambda$RnDebugOtherSettingActivity$7$1Qigj1W4MOPeR57vGDRNhfWpaHA.INSTANCE).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1(ProgressDialog.O000000o(RnDebugOtherSettingActivity.this, "导出日志", "正在导出日志文件...")) {
                    /* class com.xiaomi.smarthome.framework.page.rndebug.$$Lambda$RnDebugOtherSettingActivity$7$h9EV6y1M3guWSlTkXkEwBzJXaM */
                    private final /* synthetic */ ProgressDialog f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void call(Object obj) {
                        RnDebugOtherSettingActivity.AnonymousClass7.this.O000000o(this.f$1, (Intent) obj);
                    }
                }).subscribe();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(ProgressDialog progressDialog, Intent intent) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (!RnDebugOtherSettingActivity.this.isFinishing()) {
                RnDebugOtherSettingActivity.this.startActivity(intent);
            }
        }
    };
    @BindView(5103)
    EditText mEtLocalPingCount;
    @BindView(5104)
    EditText mEtLocalPingRetryTime;
    @BindView(5257)
    View mExportLog;
    @BindView(5250)
    View mLayoutDevicePluginInfo;
    @BindView(5256)
    View mLayoutPluginDownload;
    @BindView(5258)
    View mLayoutPluginInstall;
    @BindView(5710)
    SwitchButton mSwBtnForceAllModelSupportReuse;
    @BindView(5709)
    SwitchButton mSwBtnForceCloseAllModelSupportReuse;
    @BindView(5711)
    SwitchButton mSwBtnForcePlaintextTransmission;
    @BindView(5712)
    SwitchButton mSwBtnForceUseInnerRnSdk;
    @BindView(5717)
    SwitchButton mSwBtnLocalPing;
    @BindView(5713)
    SwitchButton mSwBtnRnPluginFpsMemory;
    @BindView(5714)
    SwitchButton mSwBtnRnPluginSdkVersionInfo;
    @BindView(5715)
    SwitchButton mSwBtnRnPluginTimeToal;
    @BindView(5716)
    SwitchButton mSwBtnSupportScanDebugReuse;
    @BindView(5718)
    SwitchButton mSwBtnUseOldPluginOnly;
    @BindView(5719)
    SwitchButton mSwBtnUsePreviewAppConfig;
    @BindView(5361)
    TextView tvHeadTitle;
    @BindView(5357)
    View viewHeadLeft;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, RnDebugOtherSettingActivity.class));
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_rn_debug_other_setting);
        ButterKnife.bind(this);
        this.tvHeadTitle.setText("其他设置");
        this.mSwBtnRnPluginTimeToal.setChecked(hsi.O00000Oo());
        SwitchButton switchButton = this.mSwBtnRnPluginSdkVersionInfo;
        fvo.O000000o();
        switchButton.setChecked(fvo.O00000oo());
        this.mSwBtnUseOldPluginOnly.setChecked(fko.O000000o(getContext()));
        this.mSwBtnUsePreviewAppConfig.setChecked(gfr.O0000oo0);
        SwitchButton switchButton2 = this.mSwBtnRnPluginFpsMemory;
        fvo.O000000o();
        switchButton2.setChecked(fvo.O0000O0o());
        if (hsi.O000000o(this) == null) {
            fvo.O000000o();
            fvo.O00000oo(false);
        }
        if (gfr.O0000Oo0) {
            findViewById(R.id.item_force_plaintext_transmission).setVisibility(8);
        }
        SwitchButton switchButton3 = this.mSwBtnForceUseInnerRnSdk;
        fvo.O000000o();
        switchButton3.setChecked(fvo.O0000OOo());
        SwitchButton switchButton4 = this.mSwBtnForcePlaintextTransmission;
        fvo.O000000o();
        switchButton4.setChecked(fvo.O0000Oo0());
        SwitchButton switchButton5 = this.mSwBtnForceAllModelSupportReuse;
        fvo.O000000o();
        switchButton5.setChecked(fvo.O0000Oo());
        SwitchButton switchButton6 = this.mSwBtnForceCloseAllModelSupportReuse;
        fvo.O000000o();
        switchButton6.setChecked(fvo.O0000OoO());
        SwitchButton switchButton7 = this.mSwBtnSupportScanDebugReuse;
        fvo.O000000o();
        switchButton7.setChecked(fvo.O0000Ooo());
        SwitchButton switchButton8 = this.mSwBtnLocalPing;
        fvo.O000000o();
        switchButton8.setChecked(fvo.O0000o0o());
        fvo.O000000o();
        int[] O0000o0O = fvo.O0000o0O();
        EditText editText = this.mEtLocalPingCount;
        String str2 = "";
        if (O0000o0O[0] == 0) {
            str = str2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(O0000o0O[0]);
            str = sb.toString();
        }
        editText.setText(str);
        EditText editText2 = this.mEtLocalPingRetryTime;
        if (O0000o0O[1] != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(O0000o0O[1]);
            str2 = sb2.toString();
        }
        editText2.setText(str2);
        this.viewHeadLeft.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass1 */

            public final void onClick(View view) {
                RnDebugOtherSettingActivity.this.finish();
            }
        });
        this.mSwBtnRnPluginTimeToal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginTimeToal", "RnPluginTimeToal isChecked: ".concat(String.valueOf(z)));
                hsi.O000000o(z);
            }
        });
        this.mSwBtnRnPluginSdkVersionInfo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass9 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginTimeToal", "RnPluginToastSdkVersion isChecked: ".concat(String.valueOf(z)));
                fvo.O000000o();
                fvo.O00000o(z);
            }
        });
        this.mSwBtnUseOldPluginOnly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass10 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                fko.O000000o(RnDebugOtherSettingActivity.this.getContext(), z);
            }
        });
        this.mSwBtnUsePreviewAppConfig.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass11 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gpy.O000000o(CommonApplication.getAppContext(), "appconfig_cache", "debug_use_preview_appconfig", z);
                if (z) {
                    gfr.O0000oo0 = true;
                } else {
                    gfr.O0000oo0 = false;
                }
            }
        });
        this.mSwBtnRnPluginFpsMemory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass12 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginDebug", "Fps and Memory isChecked: ".concat(String.valueOf(z)));
                fvo.O000000o();
                fvo.O00000oO(z);
            }
        });
        this.mSwBtnForceUseInnerRnSdk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass13 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (hsi.O000000o(RnDebugOtherSettingActivity.this) == null) {
                    RnDebugOtherSettingActivity.this.mSwBtnForceUseInnerRnSdk.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass13.AnonymousClass1 */

                        public final void run() {
                            RnDebugOtherSettingActivity.this.mSwBtnForceUseInnerRnSdk.setChecked(false);
                        }
                    }, 600);
                    if (z) {
                        gqg.O00000Oo("没有内置的RN SDK， 无法进行强制选择内置SDK");
                        return;
                    }
                    return;
                }
                fvo.O000000o();
                fvo.O00000oo(z);
            }
        });
        this.mSwBtnForcePlaintextTransmission.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass14 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginDebug", "Force use Plaintext Transmission: ".concat(String.valueOf(z)));
                fvo.O000000o();
                fvo.O0000O0o(z);
            }
        });
        this.mSwBtnForceAllModelSupportReuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass15 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginDebug", "ForceAllModelSupportReuse: ".concat(String.valueOf(z)));
                fvo.O000000o();
                fvo.O0000OOo(z);
            }
        });
        this.mSwBtnForceCloseAllModelSupportReuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginDebug", "ForceAllModelCLoseSupportReuse: ".concat(String.valueOf(z)));
                fvo.O000000o();
                fvo.O0000Oo0(z);
            }
        });
        this.mSwBtnSupportScanDebugReuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass3 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginDebug", "SupportScanDebugReuse: ".concat(String.valueOf(z)));
                fvo.O000000o();
                fvo.O0000Oo(z);
            }
        });
        this.mSwBtnLocalPing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
            /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i;
                int i2 = 0;
                if (z) {
                    String obj = RnDebugOtherSettingActivity.this.mEtLocalPingCount.getText().toString();
                    String obj2 = RnDebugOtherSettingActivity.this.mEtLocalPingRetryTime.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        gqg.O00000Oo("次数不能为空");
                        return;
                    } else if (TextUtils.isEmpty(obj2)) {
                        gqg.O00000Oo("时间不能为空");
                        return;
                    } else {
                        try {
                            i = Integer.parseInt(obj);
                            try {
                                i2 = Integer.parseInt(obj2);
                            } catch (NumberFormatException unused) {
                                gqg.O00000Oo("数据数据不是整数");
                                fvo.O000000o();
                                fvo.O000000o(i, i2, z);
                                if (z) {
                                }
                            }
                        } catch (NumberFormatException unused2) {
                            i = 0;
                            gqg.O00000Oo("数据数据不是整数");
                            fvo.O000000o();
                            fvo.O000000o(i, i2, z);
                            if (z) {
                            }
                        }
                    }
                } else {
                    i = 0;
                }
                fvo.O000000o();
                fvo.O000000o(i, i2, z);
                if (z) {
                    gqg.O00000Oo("设置成功");
                }
            }
        });
        this.mEtLocalPingCount.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass5 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                RnDebugOtherSettingActivity.this.mSwBtnLocalPing.setChecked(false);
            }
        });
        this.mEtLocalPingRetryTime.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugOtherSettingActivity.AnonymousClass6 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                RnDebugOtherSettingActivity.this.mSwBtnLocalPing.setChecked(false);
            }
        });
        this.mLayoutDevicePluginInfo.setOnClickListener(this.f7910O000000o);
        this.mLayoutPluginInstall.setOnClickListener(this.f7910O000000o);
        this.mLayoutPluginDownload.setOnClickListener(this.f7910O000000o);
        this.mExportLog.setOnClickListener(this.f7910O000000o);
    }
}
