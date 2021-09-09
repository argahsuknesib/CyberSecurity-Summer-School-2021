package com.xiaomi.smarthome.framework.page.privacyandlicense;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fob;
import _m_j.fsl;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gof;
import _m_j.gva;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.BleMeshDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import org.json.JSONException;
import org.json.JSONObject;

public class LicenseAndPrivacyActivity extends BaseActivity {
    public Device mDevice;

    public void onCreate(Bundle bundle) {
        Spanned spanned;
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        setContentView((int) R.layout.activity_license_and_privacy_2);
        String stringExtra = getIntent().getStringExtra("did");
        this.mDevice = fno.O000000o().O000000o(stringExtra);
        if (this.mDevice == null) {
            this.mDevice = fno.O000000o().O00000Oo(stringExtra);
            if (this.mDevice == null) {
                finish();
                return;
            }
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass1 */

            public final void onClick(View view) {
                LicenseAndPrivacyActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.law_infos);
        final fbt fbt = new fbt(this, "PluginLicenseActivity");
        final String stringExtra2 = getIntent().getStringExtra("licenseContentUri");
        final String stringExtra3 = getIntent().getStringExtra("privacyContentUri");
        final String stringExtra4 = getIntent().getStringExtra("licenseContentHtml");
        final String stringExtra5 = getIntent().getStringExtra("privacyContentHtml");
        final String stringExtra6 = getIntent().getStringExtra("licenseContenttitle");
        final String stringExtra7 = getIntent().getStringExtra("privacyContenttitle");
        final Spanned spanned2 = (Spanned) getIntent().getCharSequenceExtra("licenseContent");
        final Spanned spanned3 = (Spanned) getIntent().getCharSequenceExtra("privacyContent");
        final int intExtra = getIntent().getIntExtra("licenseContentHtmlRes", -1);
        final int intExtra2 = getIntent().getIntExtra("privacyContentHtmlRes", -1);
        if (stringExtra4 != null && stringExtra5 != null) {
            findViewById(R.id.license).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass10 */

                public final void onClick(View view) {
                    fbt.O000000o("title", TextUtils.isEmpty(stringExtra6) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_license) : stringExtra6);
                    fbt.O000000o("license_html_content", stringExtra4);
                    fbs.O000000o(fbt);
                }
            });
            findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass11 */

                public final void onClick(View view) {
                    fbt.O000000o("title", TextUtils.isEmpty(stringExtra7) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_privacy) : stringExtra7);
                    fbt.O000000o("license_html_content", stringExtra5);
                    fbs.O000000o(fbt);
                }
            });
        } else if (stringExtra2 != null && stringExtra3 != null) {
            findViewById(R.id.license).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass12 */

                public final void onClick(View view) {
                    fbt.O000000o("title", TextUtils.isEmpty(stringExtra6) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_license) : stringExtra6);
                    fbt.O000000o("license_uri", stringExtra2);
                    fbs.O000000o(fbt);
                }
            });
            findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass13 */

                public final void onClick(View view) {
                    fbt.O000000o("title", TextUtils.isEmpty(stringExtra7) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_privacy) : stringExtra7);
                    fbt.O000000o("license_uri", stringExtra3);
                    fbs.O000000o(fbt);
                }
            });
        } else if (spanned2 != null && spanned3 != null) {
            findViewById(R.id.license).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass14 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                 arg types: [java.lang.String, android.text.Spanned]
                 candidates:
                  _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                  _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt */
                public final void onClick(View view) {
                    if (spanned2 != null) {
                        fbt.O000000o("title", TextUtils.isEmpty(stringExtra6) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_license) : stringExtra6);
                        fbt.O000000o("license_content", (CharSequence) spanned2);
                        fbs.O000000o(fbt);
                    }
                }
            });
            findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass15 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                 arg types: [java.lang.String, android.text.Spanned]
                 candidates:
                  _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                  _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt */
                public final void onClick(View view) {
                    if (spanned3 != null) {
                        fbt.O000000o("title", TextUtils.isEmpty(stringExtra7) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_privacy) : stringExtra7);
                        fbt.O000000o("license_content", (CharSequence) spanned3);
                        fbs.O000000o(fbt);
                    }
                }
            });
        } else if (intExtra <= 0 || intExtra2 <= 0) {
            boolean booleanExtra = getIntent().getBooleanExtra("useDefaultLicense", false);
            if (booleanExtra) {
                findViewById(R.id.license).setVisibility(8);
            } else {
                findViewById(R.id.license).setVisibility(0);
                final Spanned spanned4 = (Spanned) getIntent().getCharSequenceExtra("licenseContent");
                findViewById(R.id.license).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass2 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                     arg types: [java.lang.String, android.text.Spanned]
                     candidates:
                      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt */
                    public final void onClick(View view) {
                        if (spanned4 != null) {
                            fbt.O000000o("title", TextUtils.isEmpty(stringExtra6) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_license) : stringExtra6);
                            fbt.O000000o("license_content", (CharSequence) spanned4);
                            fbs.O000000o(fbt);
                        }
                    }
                });
            }
            if (booleanExtra) {
                spanned = Html.fromHtml(getString(R.string.user_privacy_new));
            } else {
                spanned = (Spanned) getIntent().getCharSequenceExtra("privacyContent");
            }
            final Spanned spanned5 = spanned;
            final String str = stringExtra7;
            findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass3 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                 arg types: [java.lang.String, android.text.Spanned]
                 candidates:
                  _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                  _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt */
                public final void onClick(View view) {
                    if (stringExtra3 != null) {
                        fbt.O000000o("title", TextUtils.isEmpty(str) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_privacy) : str);
                        fbt.O000000o("license_uri", stringExtra3);
                        fbs.O000000o(fbt);
                    } else if (spanned5 != null) {
                        fbt.O000000o("title", TextUtils.isEmpty(str) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_privacy) : str);
                        fbt.O000000o("license_content", (CharSequence) spanned5);
                        fbs.O000000o(fbt);
                    }
                }
            });
        } else {
            findViewById(R.id.license).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass16 */

                public final void onClick(View view) {
                    fbt.O000000o("title", TextUtils.isEmpty(stringExtra6) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_license) : stringExtra6);
                    fbt.O000000o("license_html_content_res", intExtra);
                    fbs.O000000o(fbt);
                }
            });
            findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass17 */

                public final void onClick(View view) {
                    fbt.O000000o("title", TextUtils.isEmpty(stringExtra7) ? LicenseAndPrivacyActivity.this.getString(R.string.device_more_activity_privacy) : stringExtra7);
                    fbt.O000000o("license_html_content_res", intExtra2);
                    fbs.O000000o(fbt);
                }
            });
        }
        View findViewById = findViewById(R.id.usr_exp_plan_container);
        if (findViewById != null && getIntent().getBooleanExtra("enable_privacy_setting", false)) {
            findViewById.setVisibility(0);
            SwitchButton switchButton = (SwitchButton) findViewById(R.id.right_arrow);
            switchButton.setChecked(fsl.O000000o(getApplicationContext(), this.mDevice.did));
            switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass4 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    fsl.O000000o(LicenseAndPrivacyActivity.this.getApplicationContext(), LicenseAndPrivacyActivity.this.mDevice.did, z);
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    fbt fbt = new fbt(LicenseAndPrivacyActivity.this, "/userCenter/UsrExpPlanActivity");
                    fbt.O000000o(LicenseAndPrivacyActivity.this.getIntent().getExtras());
                    fbs.O000000o(fbt);
                }
            });
        }
        findViewById(R.id.cancel_license_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass6 */

            public final void onClick(View view) {
                LicenseAndPrivacyActivity.this.showReassureDialog();
            }
        });
    }

    public void showReassureDialog() {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.reassure_dialog_title).O00000Oo((int) R.string.reassure_dialog_content_new).O000000o((int) R.string.reassure_ok, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                LicenseAndPrivacyActivity.this.removeLicense();
                gva.O000000o().removeDeviceAllPushMessages(LicenseAndPrivacyActivity.this.mDevice.did);
            }
        }).O00000Oo((int) R.string.reassure_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).O00000o().show();
    }

    public void removeLicense() {
        if (getIntent().getBooleanExtra("need_delete_server_data", true)) {
            final XQProgressDialog xQProgressDialog = new XQProgressDialog(this);
            xQProgressDialog.setMessage(getString(R.string.smarthome_deleting));
            xQProgressDialog.setCancelable(false);
            xQProgressDialog.show();
            DeviceApi.getInstance().setUserLicenseConfig(this, this.mDevice.did, "remove", new fsm<String, fso>() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.LicenseAndPrivacyActivity.AnonymousClass9 */

                /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
                /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
                public final /* synthetic */ void onSuccess(Object obj) {
                    boolean z;
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int optInt = jSONObject.optInt("code");
                            String optString = jSONObject.optString("result");
                            if (optInt == 0 && "ok".equals(optString)) {
                                z = true;
                                try {
                                    xQProgressDialog.dismiss();
                                    LicenseAndPrivacyActivity.this.removeLicenseSuccess();
                                } catch (JSONException e) {
                                    e = e;
                                }
                                if (!z) {
                                    xQProgressDialog.dismiss();
                                    izb.O000000o(LicenseAndPrivacyActivity.this, (int) R.string.bind_error, 0).show();
                                    return;
                                }
                                return;
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            z = false;
                            e.printStackTrace();
                            if (!z) {
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }

                public final void onFailure(fso fso) {
                    xQProgressDialog.dismiss();
                    if (fso.f17063O000000o == -7) {
                        LicenseAndPrivacyActivity.this.removeLicenseSuccess();
                    } else if (!gof.O00000o0()) {
                        izb.O000000o(LicenseAndPrivacyActivity.this, (int) R.string.network_disable, 0).show();
                    } else {
                        izb.O000000o(LicenseAndPrivacyActivity.this, (int) R.string.bind_error, 0).show();
                    }
                }
            });
            return;
        }
        removeLicenseSuccess();
    }

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
    public void removeLicenseSuccess() {
        Device device = this.mDevice;
        if (device instanceof BleDevice) {
            fob.O000000o((BleDevice) device);
        } else if (device instanceof BleMeshDevice) {
            fob.O000000o(device);
        }
        izb.O000000o(this, (int) R.string.bind_success, 0).show();
        fno.O000000o().O00000Oo(this.mDevice);
        Intent intent = new Intent();
        intent.putExtra("result_data", "removedLicense");
        intent.putExtra("finish", true);
        setResult(-1, intent);
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
    }
}
