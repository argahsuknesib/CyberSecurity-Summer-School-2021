package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.chr;
import _m_j.chx;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.Callback;

public class ViewSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    chx mCameraProperties;
    SettingsItemView mCorrectLensDistortItem;
    BaseDevice.StateChangedListener mListener = new BaseDevice.StateChangedListener() {
        /* class com.xiaomi.smarthome.camera.activity.setting.ViewSettingActivity.AnonymousClass3 */

        public void onStateChanged(BaseDevice baseDevice) {
            ViewSettingActivity.this.refreshUI();
        }
    };
    SettingsItemView mRoteItem;
    SettingsItemView mWatermarkItem;
    SettingsItemView mWdrItem;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_setting_acitivity);
        this.mCameraProperties = (chx) this.mCameraDevice.O000000o();
        initView();
        this.mCameraDevice.addStateChangedListener(this.mListener);
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.setting_view);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mWatermarkItem = (SettingsItemView) findViewById(R.id.watermark);
        this.mCorrectLensDistortItem = (SettingsItemView) findViewById(R.id.camera_correct_lens_distort);
        this.mRoteItem = (SettingsItemView) findViewById(R.id.settings_rote);
        this.mWdrItem = (SettingsItemView) findViewById(R.id.settings_wdr);
        this.mWatermarkItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.ViewSettingActivity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(false);
                chr.O000000o(chr.O0000oO);
                ViewSettingActivity.this.mCameraProperties.O000000o("watermark", z, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.ViewSettingActivity.AnonymousClass1.AnonymousClass1 */

                    public void onSuccess(Void voidR) {
                        if (!ViewSettingActivity.this.isFinishing()) {
                            ViewSettingActivity.this.refreshUI();
                            ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(true);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!ViewSettingActivity.this.isFinishing()) {
                            ViewSettingActivity.this.refreshUI();
                            ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(true);
                        }
                    }
                });
            }
        });
        this.mCorrectLensDistortItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.ViewSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O0000oOO);
                ViewSettingActivity.this.mCameraDevice.O00000oO().O000000o(z);
            }
        });
        this.mRoteItem.setOnClickListener(this);
        this.mWdrItem.setOnClickListener(this);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void refreshUI() {
        this.mWatermarkItem.setChecked(this.mCameraProperties.O000000o("watermark", false));
        this.mCorrectLensDistortItem.setChecked(this.mCameraDevice.O00000oO().O0000OOo);
        this.mWdrItem.setInfo(getString(this.mCameraProperties.O000000o("wdr", false) ? R.string.setting_open_status : R.string.setting_close_status));
    }

    public void onResume() {
        super.onResume();
        refreshUI();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.settings_wdr) {
            chr.O000000o(chr.O0000ooo);
            startActivity(new Intent(this, WdrSettingActivity.class));
        } else if (id == R.id.settings_rote) {
            chr.O000000o(chr.O00oOooo);
            startActivity(new Intent(this, RoteSettingActivity.class));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mCameraDevice != null) {
            this.mCameraDevice.removeStateChangedListener(this.mListener);
        }
    }
}
