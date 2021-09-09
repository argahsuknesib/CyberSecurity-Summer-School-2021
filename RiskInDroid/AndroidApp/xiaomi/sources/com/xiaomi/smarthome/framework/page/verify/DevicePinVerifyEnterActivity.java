package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fqx;
import _m_j.fso;
import _m_j.fwb;
import _m_j.fwg;
import _m_j.gqg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil;

public class DevicePinVerifyEnterActivity extends DevicePinVerifyActivity {
    TextView O0000oo;
    private boolean O0000ooO = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O00000Oo(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        O00000Oo(intent);
    }

    private void O00000Oo(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("verfy_pincode_first", false);
        this.O0000ooO = intent.getBooleanExtra("from_system_ui", false);
        if (!this.O0000oO0 || this.O0000oO == null) {
            if (this.O0000O0o != null && booleanExtra) {
                if (this.O0000o == null || !fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
                    if (this.O0000O0o.O00000Oo(this.f7933O000000o)) {
                        fwb.O000000o(this, this.f7933O000000o, this.O00000oo, false);
                    }
                } else if (!TextUtils.isEmpty(LockSecurePinUtil.getPropLtmk(this.O0000o.mac)) && !TextUtils.isEmpty(LockSecurePinUtil.getPropPincode(this.O0000o.mac)) && this.O0000O0o.O00000Oo(this.f7933O000000o)) {
                    fwb.O000000o(this, this.f7933O000000o, this.O00000oo, false);
                }
            }
        } else if (this.O0000oO.O00000Oo(CoreApi.O000000o().O0000o0())) {
            fwb.O000000o(this, this.f7933O000000o, this.O00000oo, true);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        super.O00000o();
        if (getIntent().getBooleanExtra("fromSettingPage", false)) {
            this.O0000oo = (TextView) findViewById(R.id.xiaomi_sm_tv_forget_pincode);
            this.O0000oo.setVisibility(0);
            this.O0000oo.getPaint().setFlags(8);
            this.O0000oo.getPaint().setAntiAlias(true);
            this.O0000oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyEnterActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    DevicePinVerifyEnterActivity.this.O0000oO.O000000o(DevicePinVerifyEnterActivity.this, (String) null, new fwg<Boolean>() {
                        /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyEnterActivity.AnonymousClass1.AnonymousClass1 */

                        public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        }

                        public final void onFailure(fso fso) {
                            if (fso.f17063O000000o == -4005001) {
                                DevicePinVerifyEnterActivity.this.O00000o0(fso.O00000Oo);
                                return;
                            }
                            gqg.O00000Oo(fso.toString());
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(String str) {
        fbt fbt = new fbt(this, "AuthTokenActivity");
        fbt.O000000o(100);
        fbt.O000000o("url", str);
        fbs.O000000o(fbt);
    }

    public void onPause() {
        super.onPause();
        if (this.O0000oo != null) {
            O000000o(0);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        if (this.O0000oO0) {
            this.O00000Oo = getString(R.string.device_more_verify_enter_title);
            this.O00000o0 = getString(R.string.device_more_verify_enter_device_desc);
            this.O00000oO = getString(R.string.device_more_verify_pin_error);
            return;
        }
        if (fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
            this.O00000Oo = getString(R.string.ble_secure_pin_verify_title);
        } else {
            this.O00000Oo = getString(R.string.device_more_verify_enter_title);
        }
        if (fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
            this.O00000o0 = getString(R.string.ble_secure_pin_open_title);
            if (TextUtils.isEmpty(LockSecurePinUtil.getPropLtmk(this.O0000o.mac)) || TextUtils.isEmpty(LockSecurePinUtil.getPropPincode(this.O0000o.mac))) {
                this.vSubHint.setVisibility(0);
                this.vSubHint.setText((int) R.string.ble_secure_pin_open_exception_tips2);
            }
        } else {
            this.O00000o0 = getString(R.string.device_more_verify_enter_device_desc);
        }
        this.O00000oO = getString(R.string.device_more_verify_pin_error);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        if (!this.O0000ooO || this.O0000o == null || TextUtils.isEmpty(this.O0000o.did)) {
            Intent intent = new Intent();
            intent.putExtra("pincode", str);
            if (this.O0000o != null) {
                intent.putExtra("extra_device_did", this.O0000o.did);
            }
            setResult(-1, intent);
        } else {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$DevicePinVerifyEnterActivity$joTDicGqOSX6u8hMZYrxA_is68 */

                public final void run() {
                    DevicePinVerifyEnterActivity.this.O0000Oo();
                }
            }, 600);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Oo() {
        XmPluginHostApi.instance().openCameraFloatingView(this.O0000o.did);
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(String str, Bundle bundle) {
        if (!CoreApi.O000000o().O0000o(this.O0000o.model)) {
            return false;
        }
        if (!this.O0000ooO || this.O0000o == null || TextUtils.isEmpty(this.O0000o.did)) {
            Intent intent = new Intent();
            intent.putExtra("pincode", str);
            if (this.O0000o != null) {
                intent.putExtra("extra_device_did", this.O0000o.did);
            }
            intent.putExtra("login_response_bundle", bundle);
            setResult(-1, intent);
        } else {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$DevicePinVerifyEnterActivity$ZRAr40Qxg46ev8zhA0sM8x1SxXk */

                public final void run() {
                    DevicePinVerifyEnterActivity.this.O0000Oo0();
                }
            }, 600);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Oo0() {
        XmPluginHostApi.instance().openCameraFloatingView(this.O0000o.did);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 100) {
            if (i == 10000 && intent != null && !intent.getBooleanExtra("back_for_pincode_verify", false)) {
                if (this.O0000o != null) {
                    intent.putExtra("extra_device_did", this.O0000o.did);
                }
                setResult(i2, intent);
                finish();
            }
        } else if (intent != null) {
            this.O0000oO.O000000o(this, intent.getStringExtra("arg_auth_token"), new fwg<Boolean>() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyEnterActivity.AnonymousClass2 */

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
                    if (((Boolean) obj).booleanValue()) {
                        Intent intent = new Intent();
                        intent.putExtra("forgetPinCode", true);
                        DevicePinVerifyEnterActivity.this.setResult(-1, intent);
                        DevicePinVerifyEnterActivity.this.finish();
                    }
                }

                public final void onFailure(fso fso) {
                    gqg.O00000Oo(fso.toString());
                    if (fso.f17063O000000o == -4005001) {
                        DevicePinVerifyEnterActivity.this.O00000o0(fso.O00000Oo);
                    }
                }
            });
        }
    }
}
