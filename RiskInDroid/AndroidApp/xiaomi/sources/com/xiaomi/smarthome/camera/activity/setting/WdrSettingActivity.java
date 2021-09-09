package com.xiaomi.smarthome.camera.activity.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class WdrSettingActivity extends CameraBaseActivity {
    SettingsItemView mWdrItem;
    public XQProgressDialog progressDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_setting_wdr);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mWdrItem = (SettingsItemView) findViewById(R.id.wdr_setting);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.WdrSettingActivity.AnonymousClass1 */

            public void onClick(View view) {
                WdrSettingActivity.this.onBackPressed();
            }
        });
        TextView textView = (TextView) findViewById(R.id.title_bar_title);
        textView.setText((int) R.string.setting_wdr);
        textView.setMaxLines(2);
        this.mWdrItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.WdrSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WdrSettingActivity.this.mWdrItem.setSwitchEnable(false);
                if (WdrSettingActivity.this.progressDialog == null) {
                    WdrSettingActivity wdrSettingActivity = WdrSettingActivity.this;
                    wdrSettingActivity.progressDialog = new XQProgressDialog(wdrSettingActivity.activity());
                }
                WdrSettingActivity.this.progressDialog.show();
                WdrSettingActivity.this.mCameraDevice.O000000o().O000000o("wdr", z, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.WdrSettingActivity.AnonymousClass2.AnonymousClass1 */

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
        this.mWdrItem.setChecked(this.mCameraDevice.O000000o().O000000o("wdr", false));
    }
}
