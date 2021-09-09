package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.chr;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import org.json.JSONObject;

public class WdrSettingActivity extends CameraBaseActivity {
    SettingsItemView mWdrItem;
    public XQProgressDialog progressDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_setting_wdr);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mWdrItem = (SettingsItemView) findViewById(R.id.wdr_setting);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.WdrSettingActivity.AnonymousClass1 */

            public void onClick(View view) {
                WdrSettingActivity.this.onBackPressed();
            }
        });
        TextView textView = (TextView) findViewById(R.id.title_bar_title);
        textView.setText((int) R.string.setting_wdr);
        textView.setMaxLines(2);
        this.mWdrItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.WdrSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O00oOooO);
                WdrSettingActivity.this.mWdrItem.setSwitchEnable(false);
                if (WdrSettingActivity.this.progressDialog == null) {
                    WdrSettingActivity wdrSettingActivity = WdrSettingActivity.this;
                    wdrSettingActivity.progressDialog = new XQProgressDialog(wdrSettingActivity);
                }
                WdrSettingActivity.this.progressDialog.show();
                if (WdrSettingActivity.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = WdrSettingActivity.this.mCameraSpecDevice.O000000o("camera-control");
                    SpecProperty O000000o3 = WdrSettingActivity.this.mCameraSpecDevice.O000000o(O000000o2, "wdr-mode");
                    if (O000000o2 == null || O000000o3 == null) {
                        if (WdrSettingActivity.this.progressDialog != null) {
                            WdrSettingActivity.this.progressDialog.dismiss();
                        }
                        WdrSettingActivity.this.refreshUI();
                        WdrSettingActivity.this.mWdrItem.setSwitchEnable(true);
                        return;
                    }
                    faw.O000000o().setDeviceProp(WdrSettingActivity.this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.WdrSettingActivity.AnonymousClass2.AnonymousClass1 */

                        public void onSuccess(JSONObject jSONObject) {
                            if (!WdrSettingActivity.this.isFinishing()) {
                                if (WdrSettingActivity.this.progressDialog != null) {
                                    WdrSettingActivity.this.progressDialog.dismiss();
                                }
                                WdrSettingActivity.this.refreshUI();
                                WdrSettingActivity.this.mWdrItem.setSwitchEnable(true);
                            }
                        }

                        public void onFailure(fso fso) {
                            if (!WdrSettingActivity.this.isFinishing()) {
                                if (WdrSettingActivity.this.progressDialog != null) {
                                    WdrSettingActivity.this.progressDialog.dismiss();
                                }
                                WdrSettingActivity.this.refreshUI();
                                WdrSettingActivity.this.mWdrItem.setSwitchEnable(true);
                            }
                        }
                    });
                    return;
                }
                WdrSettingActivity.this.mCameraDevice.O000000o().O000000o("wdr", z, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.WdrSettingActivity.AnonymousClass2.AnonymousClass2 */

                    public void onSuccess(Void voidR) {
                        if (!WdrSettingActivity.this.isFinishing()) {
                            if (WdrSettingActivity.this.progressDialog != null) {
                                WdrSettingActivity.this.progressDialog.dismiss();
                            }
                            WdrSettingActivity.this.refreshUI();
                            WdrSettingActivity.this.mWdrItem.setSwitchEnable(true);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!WdrSettingActivity.this.isFinishing()) {
                            if (WdrSettingActivity.this.progressDialog != null) {
                                WdrSettingActivity.this.progressDialog.dismiss();
                            }
                            WdrSettingActivity.this.refreshUI();
                            WdrSettingActivity.this.mWdrItem.setSwitchEnable(true);
                        }
                    }
                });
            }
        });
        refreshUI();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void refreshUI() {
        boolean z = false;
        if (this.mCameraSpecDevice != null) {
            Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "wdr-mode");
            SettingsItemView settingsItemView = this.mWdrItem;
            if (propertyValueFromCache != null) {
                z = ((Boolean) propertyValueFromCache).booleanValue();
            }
            settingsItemView.setChecked(z);
            return;
        }
        this.mWdrItem.setChecked(this.mCameraDevice.O000000o().O000000o("wdr", false));
    }
}
