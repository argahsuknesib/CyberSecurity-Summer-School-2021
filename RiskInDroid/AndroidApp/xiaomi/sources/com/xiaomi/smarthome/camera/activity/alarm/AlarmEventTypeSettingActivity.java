package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chr;
import _m_j.cla;
import _m_j.cle;
import _m_j.clf;
import _m_j.hny;
import _m_j.hor;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemViewMultiLine;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmEventTypeSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    public cla alarmConfigV2 = new cla();
    public cle alarmManagerV2 = null;
    private hny mListener = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass6 */

        public void onRefreshScenceFailed(int i) {
        }

        public void onRefreshScenceSuccess(int i) {
            if (AlarmEventTypeSettingActivity.this.isValid() && hor.O000000o().getCustomSceneSizeByDid(AlarmEventTypeSettingActivity.this.mCameraDevice.getDid()) > 0) {
                AlarmEventTypeSettingActivity.this.settingItemAIPush.setVisibility(0);
            }
        }
    };
    public SettingsItemViewMultiLine settingItemAIPush;
    private SettingsItemViewMultiLine settingItemBabyCryPush;
    private SettingsItemViewMultiLine settingItemHumanPush;
    private SettingsItemViewMultiLine settingItemMotionPush;
    private SettingsItemViewMultiLine settingItemPetPush;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        this.alarmManagerV2 = this.mCameraDevice.O0000o0o();
        setContentView((int) R.layout.camera_activity_setting_alarm_event_type);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.push_event_type);
        this.settingItemMotionPush = (SettingsItemViewMultiLine) findViewById(R.id.settting_item_area_change);
        this.settingItemMotionPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O00OO0o, "type", Integer.valueOf(z ? 1 : 2));
                AlarmEventTypeSettingActivity.this.setAreaPush(z);
            }
        });
        this.settingItemHumanPush = (SettingsItemViewMultiLine) findViewById(R.id.settting_item_people);
        this.settingItemHumanPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O00OOOo, "type", Integer.valueOf(z ? 1 : 2));
                AlarmEventTypeSettingActivity.this.putHumanPush(z);
            }
        });
        this.settingItemAIPush = (SettingsItemViewMultiLine) findViewById(R.id.settting_item_auto);
        this.settingItemAIPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O00OOo, "type", Integer.valueOf(z ? 1 : 2));
                AlarmEventTypeSettingActivity.this.putAIPush(z);
            }
        });
        this.settingItemAIPush.setVisibility(8);
        this.settingItemBabyCryPush = (SettingsItemViewMultiLine) findViewById(R.id.settting_item_baby_cry);
        this.settingItemBabyCryPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass4 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O00OOo0, "type", Integer.valueOf(z ? 1 : 2));
                AlarmEventTypeSettingActivity.this.putBabyPush(z);
            }
        });
        if (!clf.f14036O000000o || (!this.mCameraDevice.O00000oO().O00000Oo() && !DeviceConstant.isSupportBabyCryNative(this.mCameraDevice.getModel()))) {
            this.settingItemBabyCryPush.setVisibility(8);
        }
        this.settingItemPetPush = (SettingsItemViewMultiLine) findViewById(R.id.setting_item_pet);
        this.settingItemPetPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass5 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmEventTypeSettingActivity.this.putPetPush(z);
            }
        });
        if (!DeviceConstant.isSupportPetNative(this.mCameraDevice.getModel())) {
            this.settingItemPetPush.setVisibility(8);
        }
        getAlarmConfig();
        hor.O000000o().updateCustomScene(this.mDid, this.mListener);
    }

    public void refreshUI() {
        this.settingItemMotionPush.setChecked(this.alarmConfigV2.O0000o0);
        this.settingItemHumanPush.setChecked(this.alarmConfigV2.O0000oO);
        this.settingItemAIPush.setChecked(this.alarmConfigV2.O0000o0O);
        this.settingItemBabyCryPush.setChecked(this.alarmConfigV2.O0000o0o);
        this.settingItemPetPush.setChecked(this.alarmConfigV2.O0000oO0);
    }

    public void getAlarmConfig() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            this.alarmManagerV2.O000000o(this.mCameraDevice.getModel(), jSONObject, new cle.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass7 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmEventTypeSettingActivity.this.isFinishing()) {
                        AlarmEventTypeSettingActivity.this.alarmConfigV2.O000000o(AlarmEventTypeSettingActivity.this.alarmManagerV2.f14020O000000o);
                        AlarmEventTypeSettingActivity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmEventTypeSettingActivity.this.isFinishing()) {
                        AlarmEventTypeSettingActivity.this.alarmConfigV2.O000000o(AlarmEventTypeSettingActivity.this.alarmManagerV2.f14020O000000o);
                        AlarmEventTypeSettingActivity.this.refreshUI();
                    }
                }
            });
        } catch (JSONException unused) {
            this.alarmConfigV2.O000000o(this.alarmManagerV2.f14020O000000o);
            refreshUI();
        }
    }

    public void processNetResult() {
        if (!isFinishing()) {
            if (this.mCameraSpecDevice != null) {
                this.alarmConfigV2.O0000o0O = this.alarmManagerV2.f14020O000000o.O0000o0O;
                this.alarmConfigV2.O0000o0 = this.alarmManagerV2.f14020O000000o.O0000o0;
                this.alarmConfigV2.O0000o0o = this.alarmManagerV2.f14020O000000o.O0000o0o;
                this.alarmConfigV2.O0000oO0 = this.alarmManagerV2.f14020O000000o.O0000oO0;
                this.alarmConfigV2.O0000oO = this.alarmManagerV2.f14020O000000o.O0000oO;
            } else {
                this.alarmConfigV2.O000000o(this.alarmManagerV2.f14020O000000o);
            }
            refreshUI();
        }
    }

    public void setAreaPush(boolean z) {
        this.alarmManagerV2.O000000o(z, new cle.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass8 */

            public void onSuccess(Object obj, Object obj2) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }

            public void onFailure(int i, String str) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }
        });
    }

    public void putHumanPush(boolean z) {
        this.alarmManagerV2.O00000Oo(z, new cle.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass9 */

            public void onSuccess(Object obj, Object obj2) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }

            public void onFailure(int i, String str) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }
        });
    }

    public void putBabyPush(boolean z) {
        this.alarmManagerV2.O00000oO(z, new cle.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass10 */

            public void onSuccess(Object obj, Object obj2) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }

            public void onFailure(int i, String str) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }
        });
    }

    public void putAIPush(boolean z) {
        this.alarmManagerV2.O00000o(z, new cle.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass11 */

            public void onSuccess(Object obj, Object obj2) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }

            public void onFailure(int i, String str) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }
        });
    }

    public void putPetPush(boolean z) {
        this.alarmManagerV2.O00000o0(z, new cle.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmEventTypeSettingActivity.AnonymousClass12 */

            public void onSuccess(Object obj, Object obj2) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }

            public void onFailure(int i, String str) {
                AlarmEventTypeSettingActivity.this.processNetResult();
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            finish();
        }
    }
}
