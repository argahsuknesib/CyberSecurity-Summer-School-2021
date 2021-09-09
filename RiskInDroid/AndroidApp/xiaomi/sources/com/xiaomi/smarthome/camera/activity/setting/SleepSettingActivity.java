package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.fsp;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.frame.plugin.host.PluginActivityHostApi;

public class SleepSettingActivity extends CameraBaseActivity {
    private SettingsItemView mSleepAutoTimer;
    public SettingsItemView mSleepStatus;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_setting_sleep);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.setting_sleep_setting);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SleepSettingActivity.AnonymousClass1 */

            public void onClick(View view) {
                SleepSettingActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        initView();
    }

    public void onResume() {
        super.onResume();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    private void initView() {
        this.mSleepStatus = (SettingsItemView) findViewById(R.id.sleep_status);
        this.mSleepStatus.setChecked(!this.mCameraDevice.O000000o().O000000o("power", true));
        this.mSleepStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SleepSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SleepSettingActivity.this.mSleepStatus.setSwitchEnable(false);
                SleepSettingActivity.this.mCameraDevice.O000000o().O000000o("power", !z, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.SleepSettingActivity.AnonymousClass2.AnonymousClass1 */

                    public void onSuccess(Void voidR) {
                        if (!SleepSettingActivity.this.isFinishing()) {
                            SleepSettingActivity.this.mSleepStatus.setSwitchEnable(true);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!SleepSettingActivity.this.isFinishing()) {
                            SleepSettingActivity.this.mSleepStatus.setChecked(!SleepSettingActivity.this.mSleepStatus.isChecked());
                            SleepSettingActivity.this.mSleepStatus.setSwitchEnable(true);
                        }
                    }
                });
            }
        });
        this.mSleepAutoTimer = (SettingsItemView) findViewById(R.id.sleep_auto_timer);
        this.mSleepAutoTimer.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SleepSettingActivity.AnonymousClass3 */

            public void onClick(View view) {
                PluginActivityHostApi pluginActivityHostApi = fsp.O000000o().O0000Oo;
                SleepSettingActivity sleepSettingActivity = SleepSettingActivity.this;
                pluginActivityHostApi.startSetTimerListV2(sleepSettingActivity, sleepSettingActivity.mDid, "set_power", "off", "set_power", "on", SleepSettingActivity.this.mDid, SleepSettingActivity.this.getString(R.string.auto_sleep), SleepSettingActivity.this.getString(R.string.auto_sleep_title), true, SleepSettingActivity.this.getString(R.string.sleep_auto_on_time), SleepSettingActivity.this.getString(R.string.sleep_auto_off_time), "");
            }
        });
    }
}
