package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.chr;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.frame.plugin.host.PluginActivityHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import org.json.JSONObject;

public class SleepSettingActivity extends CameraBaseActivity {
    private SettingsItemView mSleepAutoTimer;
    public SettingsItemView mSleepStatus;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_setting_sleep);
        TextView textView = (TextView) findViewById(R.id.title_bar_title);
        if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            textView.setText((int) R.string.setting_wulizhebi_setting);
        } else {
            textView.setText((int) R.string.setting_sleep_setting);
        }
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.SleepSettingActivity.AnonymousClass1 */

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
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.SleepSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O0000o0O);
                SleepSettingActivity.this.mSleepStatus.setSwitchEnable(false);
                if (SleepSettingActivity.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = SleepSettingActivity.this.mCameraSpecDevice.O000000o("camera-control");
                    SpecProperty O000000o3 = SleepSettingActivity.this.mCameraSpecDevice.O000000o(O000000o2, "on");
                    if (O000000o2 == null || O000000o3 == null) {
                        SleepSettingActivity.this.mSleepStatus.setChecked(!SleepSettingActivity.this.mSleepStatus.isChecked());
                        SleepSettingActivity.this.mSleepStatus.setSwitchEnable(true);
                        return;
                    }
                    faw.O000000o().setDeviceProp(SleepSettingActivity.this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(!z), new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.SleepSettingActivity.AnonymousClass2.AnonymousClass1 */

                        public void onSuccess(JSONObject jSONObject) {
                            if (!SleepSettingActivity.this.isFinishing()) {
                                Object propertyValueFromCache = SleepSettingActivity.this.getPropertyValueFromCache("camera-control", "on");
                                SleepSettingActivity.this.mCameraDevice.O000000o().O00000Oo("power", Boolean.valueOf(propertyValueFromCache != null ? ((Boolean) propertyValueFromCache).booleanValue() : true));
                                SleepSettingActivity.this.mSleepStatus.setSwitchEnable(true);
                            }
                        }

                        public void onFailure(fso fso) {
                            if (!SleepSettingActivity.this.isFinishing()) {
                                SleepSettingActivity.this.mSleepStatus.setChecked(!SleepSettingActivity.this.mSleepStatus.isChecked());
                                SleepSettingActivity.this.mSleepStatus.setSwitchEnable(true);
                            }
                        }
                    });
                    return;
                }
                SleepSettingActivity.this.mCameraDevice.O000000o().O000000o("power", !z, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.SleepSettingActivity.AnonymousClass2.AnonymousClass2 */

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
        if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            this.mSleepAutoTimer.setTitle(getString(R.string.camera_setting_wulizhebi_auto));
            this.mSleepStatus.setTitle(getString(R.string.camera_setting_wulizhebi_title));
        }
        this.mSleepAutoTimer.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.SleepSettingActivity.AnonymousClass3 */

            public void onClick(View view) {
                chr.O000000o(chr.O0000o0o);
                if (XmPluginHostApi.instance().getApiLevel() < 58) {
                    PluginActivityHostApi pluginActivityHostApi = fsp.O000000o().O0000Oo;
                    SleepSettingActivity sleepSettingActivity = SleepSettingActivity.this;
                    pluginActivityHostApi.startSetTimerList(sleepSettingActivity, sleepSettingActivity.mDeviceStat.did, "set_power", "off", "set_power", "on", SleepSettingActivity.this.mDeviceStat.did, SleepSettingActivity.this.getString(R.string.auto_sleep), SleepSettingActivity.this.getString(R.string.auto_sleep_title));
                } else if (DeviceConstant.isSupportAiNative(SleepSettingActivity.this.mCameraDevice.getModel())) {
                    PluginActivityHostApi pluginActivityHostApi2 = fsp.O000000o().O0000Oo;
                    SleepSettingActivity sleepSettingActivity2 = SleepSettingActivity.this;
                    pluginActivityHostApi2.startSetTimerListV2(sleepSettingActivity2, sleepSettingActivity2.mDeviceStat.did, "set_power", "off", "set_power", "on", SleepSettingActivity.this.mDeviceStat.did, SleepSettingActivity.this.getString(R.string.camera_setting_wulizhebi_auto), SleepSettingActivity.this.getString(R.string.camera_setting_wulizhebi_settime), true, SleepSettingActivity.this.getString(R.string.start_time), SleepSettingActivity.this.getString(R.string.end_time), SleepSettingActivity.this.getString(R.string.wulizhebi_auto_item_title));
                } else {
                    PluginActivityHostApi pluginActivityHostApi3 = fsp.O000000o().O0000Oo;
                    SleepSettingActivity sleepSettingActivity3 = SleepSettingActivity.this;
                    pluginActivityHostApi3.startSetTimerListV2(sleepSettingActivity3, sleepSettingActivity3.mDeviceStat.did, "set_power", "off", "set_power", "on", SleepSettingActivity.this.mDeviceStat.did, SleepSettingActivity.this.getString(R.string.auto_sleep), SleepSettingActivity.this.getString(R.string.auto_sleep_title), true, SleepSettingActivity.this.getString(R.string.sleep_auto_on_time), SleepSettingActivity.this.getString(R.string.sleep_auto_off_time), SleepSettingActivity.this.getString(R.string.sleep_auto_item_title));
                }
            }
        });
    }
}
