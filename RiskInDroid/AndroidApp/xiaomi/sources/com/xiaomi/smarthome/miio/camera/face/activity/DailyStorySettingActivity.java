package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.cla;
import _m_j.cle;
import _m_j.gsy;
import _m_j.hxi;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemViewMultiLine;
import com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyStorySettingActivity extends CameraBaseActivity implements View.OnClickListener {
    private cla alarmConfigV2 = new cla();
    private cle alarmManagerV2 = null;
    private SettingsItemViewMultiLine settingItemEverydayStory;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_daily_story_setting);
        this.alarmManagerV2 = this.mCameraDevice.O0000o0o();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.daily_story);
        this.settingItemEverydayStory = (SettingsItemViewMultiLine) findViewById(R.id.setting_everyday_story);
        this.settingItemEverydayStory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStorySettingActivity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                hxi.O00000o.f952O000000o.O000000o("MonitoringSetting_DailyStory_Status", "type", Integer.valueOf(z ? 1 : 2));
                DailyStoryNetUtils.getInstance().switchDailyStory(DailyStorySettingActivity.this.mDid, DailyStorySettingActivity.this.mCameraDevice.getModel(), z);
            }
        });
        getAlarmConfig();
    }

    public void getAlarmConfig() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            this.alarmManagerV2.O000000o(this.mCameraDevice.getModel(), jSONObject, new cle.O000000o() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStorySettingActivity.AnonymousClass2 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!DailyStorySettingActivity.this.isFinishing()) {
                        DailyStorySettingActivity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    gsy.O00000Oo("DailyStoryNetUtils", i + " - " + str);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void refreshUI() {
        this.alarmConfigV2.O000000o(this.alarmManagerV2.f14020O000000o);
        this.settingItemEverydayStory.setChecked(this.alarmConfigV2.O0000Oo);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        }
    }

    public void onRestart() {
        getAlarmConfig();
        super.onRestart();
    }

    public void onBackPressed() {
        setResult(-1);
        finish();
    }
}
