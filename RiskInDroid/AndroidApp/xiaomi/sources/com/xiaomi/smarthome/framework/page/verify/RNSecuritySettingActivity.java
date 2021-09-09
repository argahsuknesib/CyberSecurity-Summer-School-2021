package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fqx;
import _m_j.fso;
import _m_j.fwg;
import _m_j.fwn;
import _m_j.gno;
import _m_j.gqg;
import _m_j.hxi;
import _m_j.hxk;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class RNSecuritySettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f7972O000000o;
    Device O00000Oo;
    boolean O00000o = true;
    int O00000o0;
    boolean O00000oO = true;
    boolean O00000oo = false;
    VerifyGlobalManager O0000O0o;
    @BindView(5783)
    ImageView imgArrow;
    @BindView(5786)
    SwitchButton switchButton;
    @BindView(5787)
    TextView tvBigTitle;
    @BindView(5785)
    TextView tvPinStatusTip;
    @BindView(5784)
    View vOpenPinCode;

    public static void startActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, RNSecuritySettingActivity.class);
        intent.putExtra("extra_device_did", str);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_security_setting_rn);
        ButterKnife.bind(this);
        this.tvBigTitle.setTypeface(gno.O000000o(this, "fonts/MI-LANTING--GBK1-Light.ttf"));
        this.f7972O000000o = getIntent().getStringExtra("extra_device_did");
        Device O000000o2 = fno.O000000o().O000000o(this.f7972O000000o);
        if (O000000o2 == null) {
            gqg.O00000Oo("Device不能为空");
            finish();
            return;
        }
        hxk hxk = hxi.O00000o;
        String str = O000000o2.model;
        String str2 = this.f7972O000000o;
        hxk.f952O000000o.O000000o("device.passcode.plug_in.enrty.click", "model", str, "did", str2);
        if (fqx.O000000o(O000000o2.model, O000000o2.version)) {
            SecuritySettingActivity.startActivity(this, this.f7972O000000o, "");
            finish();
            return;
        }
        this.O0000O0o = VerifyGlobalManager.O000000o(this);
    }

    public void onResume() {
        super.onResume();
        this.O00000Oo = fno.O000000o().O000000o(this.f7972O000000o);
        if (this.O00000Oo == null) {
            gqg.O00000Oo("Device不能为空");
            finish();
        }
        hxk hxk = hxi.O00000o;
        String str = this.O00000Oo.model;
        String str2 = this.O00000Oo.did;
        hxk.f952O000000o.O000000o("device.passcode.plug_in.setting.show_up", "model", str, "did", str2);
        O000000o();
        this.O0000O0o.O000000o(this, new fwg<JSONObject>() {
            /* class com.xiaomi.smarthome.framework.page.verify.RNSecuritySettingActivity.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                RNSecuritySettingActivity.this.O00000o0 = jSONObject.optInt("apply2all");
                if (jSONObject.optInt("status") == 2) {
                    if (RNSecuritySettingActivity.this.O00000o) {
                        RNSecuritySettingActivity rNSecuritySettingActivity = RNSecuritySettingActivity.this;
                        rNSecuritySettingActivity.O00000o = false;
                        Intent intent = new Intent(rNSecuritySettingActivity, DevicePinVerifyEnterActivity.class);
                        intent.putExtra("verify_for_global_pin", true);
                        Intent intent2 = RNSecuritySettingActivity.this.getIntent();
                        if (intent2 != null) {
                            intent.putExtras(intent2);
                        }
                        RNSecuritySettingActivity.this.startActivityForResult(intent, 111);
                    }
                    RNSecuritySettingActivity.this.showGlobalPinCodeOpen();
                } else {
                    RNSecuritySettingActivity.this.showGlobalPinCodeClose();
                    RNSecuritySettingActivity.this.O00000oO = false;
                }
                RNSecuritySettingActivity.this.dismissProgressDialog();
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo(fso.toString());
                RNSecuritySettingActivity.this.dismissProgressDialog();
                RNSecuritySettingActivity.this.setActivityResult();
                RNSecuritySettingActivity.this.finish();
            }
        });
    }

    public void setActivityResult() {
        Device device = this.O00000Oo;
        if (device == null || device.isSetPinCode != 1) {
            setResult(212);
        } else {
            setResult(211);
        }
    }

    public void onBackPressed() {
        setActivityResult();
        super.onBackPressed();
    }

    private void O000000o() {
        showProgressDialog(getString(R.string.device_more_security_loading_operation));
    }

    public void showGlobalPinCodeOpen() {
        this.tvPinStatusTip.setText(getString(R.string.device_plugin_security_change_pincode_tip));
        this.imgArrow.setVisibility(8);
        boolean z = false;
        this.switchButton.setVisibility(0);
        int i = this.O00000Oo.pinCodeType & 2;
        SwitchButton switchButton2 = this.switchButton;
        if (i == 2) {
            z = true;
        }
        switchButton2.setChecked(z);
        if (!this.O00000oO && i == 2 && !this.O00000oo) {
            sendSwitchStatusToPlugin(true);
        }
        this.switchButton.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$RNSecuritySettingActivity$wMnR7UkCkZ3ZpQ3Z6c_gj4UhOU */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RNSecuritySettingActivity.this.O000000o(compoundButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
        O000000o();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.O00000Oo.did);
        if (z) {
            this.O0000O0o.O000000o(this, arrayList, this.O00000o0, new fwg<List<String>>() {
                /* class com.xiaomi.smarthome.framework.page.verify.RNSecuritySettingActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (list.isEmpty() || !((String) list.get(0)).equals(RNSecuritySettingActivity.this.O00000Oo.did)) {
                        RNSecuritySettingActivity.this.switchButton.setChecked(false);
                        gqg.O00000Oo((int) R.string.device_more_activity_failed);
                    }
                    gqg.O00000Oo((int) R.string.settings_set_success);
                    RNSecuritySettingActivity.this.O00000Oo.isSetPinCode = 1;
                    RNSecuritySettingActivity.this.O00000Oo.pinCodeType = 2;
                    fno.O000000o().O00000o0(RNSecuritySettingActivity.this.O00000Oo);
                    RNSecuritySettingActivity.this.sendSwitchStatusToPlugin(true);
                    RNSecuritySettingActivity.this.dismissProgressDialog();
                }

                public final void onFailure(fso fso) {
                    RNSecuritySettingActivity.this.switchButton.setChecked(false);
                    gqg.O00000Oo(fso.toString());
                    RNSecuritySettingActivity.this.dismissProgressDialog();
                }
            });
        } else {
            this.O0000O0o.O000000o(this, arrayList, new fwg<List<String>>() {
                /* class com.xiaomi.smarthome.framework.page.verify.RNSecuritySettingActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (list.isEmpty() || !((String) list.get(0)).equals(RNSecuritySettingActivity.this.O00000Oo.did)) {
                        RNSecuritySettingActivity.this.switchButton.setChecked(true);
                        gqg.O00000Oo((int) R.string.device_more_activity_failed);
                    }
                    gqg.O00000Oo((int) R.string.settings_set_success);
                    RNSecuritySettingActivity.this.O00000Oo.isSetPinCode = 0;
                    RNSecuritySettingActivity.this.O00000Oo.pinCodeType = 0;
                    fno.O000000o().O00000o0(RNSecuritySettingActivity.this.O00000Oo);
                    RNSecuritySettingActivity.this.sendSwitchStatusToPlugin(false);
                    RNSecuritySettingActivity.this.dismissProgressDialog();
                }

                public final void onFailure(fso fso) {
                    RNSecuritySettingActivity.this.switchButton.setChecked(true);
                    gqg.O00000Oo(fso.toString());
                    RNSecuritySettingActivity.this.dismissProgressDialog();
                }
            });
        }
        hxk hxk = hxi.O00000o;
        String str = this.O00000Oo.model;
        String str2 = this.O00000Oo.did;
        hxk.f952O000000o.O000000o("device.passcode.plug_in.setting.click", "type", Integer.valueOf(z ? 1 : 0), "model", str, "did", str2);
    }

    public void showGlobalPinCodeClose() {
        this.tvPinStatusTip.setText(getString(R.string.device_plugin_security_open_pincode_tip));
        this.switchButton.setVisibility(8);
        this.imgArrow.setVisibility(0);
        this.vOpenPinCode.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$RNSecuritySettingActivity$ShF6tpehqN8YL7qDVU3mMu2UUg */

            public final void onClick(View view) {
                RNSecuritySettingActivity.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        for (Map.Entry<String, Device> value : fno.O000000o().O00000oO().entrySet()) {
            Device device = (Device) value.getValue();
            if (!fwn.O000000o(device) && (device.pinCodeType & 1) == 1) {
                hxi.O00000o.O000000o((Integer) null);
                new MLAlertDialog.Builder(this).O00000Oo((int) R.string.device_more_security_new_feature_hint).O000000o((int) R.string.dialog_btn_allow, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.verify.RNSecuritySettingActivity.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        fbs.O000000o(new fbt(RNSecuritySettingActivity.this, "DevicePinVerifyClearActivity"));
                        hxi.O00000o.O000000o((Integer) 1);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$RNSecuritySettingActivity$5fOv5FJd3ewat5f_bt_Jfnll5p8.INSTANCE).O00000o0().O00000oo();
                return;
            }
        }
        fbs.O000000o(new fbt(this, "SecuritySettingActivityV2"));
        this.O00000o = false;
    }

    @OnClick({5470})
    public void onClickBack() {
        setActivityResult();
        finish();
    }

    public void sendSwitchStatusToPlugin(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSetPinCode", z);
        Intent intent = new Intent("device_pincode_switch_changed");
        intent.putExtra("did", this.f7972O000000o);
        intent.putExtra("switchStatus", bundle);
        sendBroadcast(intent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 111) {
            return;
        }
        if (i2 != -1) {
            setActivityResult();
            finish();
            return;
        }
        this.O00000oo = true;
    }
}
