package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chr;
import _m_j.cid;
import _m_j.cla;
import _m_j.cle;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.ftl;
import _m_j.ftn;
import _m_j.gqg;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmAISwitchActivity extends CameraBaseActivity implements View.OnClickListener {
    cla alarmConfigV2 = new cla();
    cle alarmManagerV2 = null;
    private SettingsItemView settingItemBabyCry;
    private SettingsItemView settingItemFace;
    private SettingsItemView settingItemFaceManager;
    private SettingsItemView settingItemPet;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_ai_switch);
        this.alarmManagerV2 = this.mCameraDevice.O0000o0o();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.settingItemFace = (SettingsItemView) findViewById(R.id.settting_item_face);
        this.settingItemFaceManager = (SettingsItemView) findViewById(R.id.settting_item_face_manager);
        if (DeviceConstant.isSupportNewUI(this.mCameraDevice.getModel()) && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.settingItemFaceManager.setVisibility(0);
            this.settingItemFaceManager.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmAISwitchActivity$80_3H7SM_S8vNyP7Q1oMwXQX4eU */

                public final void onClick(View view) {
                    AlarmAISwitchActivity.this.lambda$doCreate$0$AlarmAISwitchActivity(view);
                }
            });
        }
        this.settingItemBabyCry = (SettingsItemView) findViewById(R.id.settting_item_baby_cry);
        if ((DeviceConstant.isSupportBabyCryNative(this.mCameraDevice.getModel()) || this.mCameraDevice.O00000oO().O00000Oo()) && (!"chuangmi.camera.021a04".equals(this.mCameraDevice.getModel()) || !"IN".equalsIgnoreCase(ftl.O000000o()))) {
            this.settingItemBabyCry.setVisibility(0);
        } else {
            this.settingItemBabyCry.setVisibility(8);
        }
        if (!this.mCameraDevice.O00000oO().O00000Oo() && !DeviceConstant.isSupportFaceNative(this.mCameraDevice.getModel())) {
            this.settingItemFace.setVisibility(8);
        }
        this.settingItemFace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmAISwitchActivity$fJKFT5lK2HgZBa8sbjpoSnaagsg */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmAISwitchActivity.this.lambda$doCreate$1$AlarmAISwitchActivity(compoundButton, z);
            }
        });
        this.settingItemBabyCry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmAISwitchActivity$YCwiMAFnEnpqyt1cMwlStH8Gd44 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmAISwitchActivity.this.lambda$doCreate$2$AlarmAISwitchActivity(compoundButton, z);
            }
        });
        this.settingItemPet = (SettingsItemView) findViewById(R.id.setting_item_pet);
        if (!DeviceConstant.isSupportPetNative(this.mCameraDevice.getModel())) {
            this.settingItemPet.setVisibility(8);
        }
        this.settingItemPet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmAISwitchActivity$W_NWoa2xd3CdqdDYY8rtPFyxk0 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmAISwitchActivity.this.lambda$doCreate$3$AlarmAISwitchActivity(compoundButton, z);
            }
        });
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.face_ai_setting);
        getAlarmConfig();
    }

    public /* synthetic */ void lambda$doCreate$0$AlarmAISwitchActivity(View view) {
        chr.O000000o(chr.O000oo0O);
        if (this.mCameraDevice.isShared()) {
            gqg.O000000o(getString(R.string.no_permit_for_face_tips));
        } else {
            openFaceManagerActivity(this.mCameraDevice, this);
        }
    }

    public /* synthetic */ void lambda$doCreate$1$AlarmAISwitchActivity(CompoundButton compoundButton, boolean z) {
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("chuangmi-ai");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "face-switch");
            if (!(O000000o2 == null || O000000o3 == null)) {
                this.alarmConfigV2.O0000Ooo = z;
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmAISwitchActivity.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!AlarmAISwitchActivity.this.isFinishing()) {
                            AlarmAISwitchActivity.this.refreshUI();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!AlarmAISwitchActivity.this.isFinishing()) {
                            AlarmAISwitchActivity.this.refreshUI();
                        }
                    }
                });
                return;
            }
        }
        this.alarmManagerV2.O00000oo(z, new cle.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmAISwitchActivity.AnonymousClass2 */

            public void onSuccess(Object obj, Object obj2) {
                AlarmAISwitchActivity.this.alarmConfigV2.O000000o(AlarmAISwitchActivity.this.alarmManagerV2.f14020O000000o);
                AlarmAISwitchActivity.this.refreshUI();
            }

            public void onFailure(int i, String str) {
                AlarmAISwitchActivity.this.alarmConfigV2.O000000o(AlarmAISwitchActivity.this.alarmManagerV2.f14020O000000o);
                AlarmAISwitchActivity.this.refreshUI();
            }
        });
    }

    public /* synthetic */ void lambda$doCreate$2$AlarmAISwitchActivity(CompoundButton compoundButton, boolean z) {
        this.alarmManagerV2.O0000O0o(z, new cle.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmAISwitchActivity.AnonymousClass3 */

            public void onSuccess(Object obj, Object obj2) {
                AlarmAISwitchActivity.this.alarmConfigV2.O000000o(AlarmAISwitchActivity.this.alarmManagerV2.f14020O000000o);
                AlarmAISwitchActivity.this.refreshUI();
            }

            public void onFailure(int i, String str) {
                AlarmAISwitchActivity.this.alarmConfigV2.O000000o(AlarmAISwitchActivity.this.alarmManagerV2.f14020O000000o);
                AlarmAISwitchActivity.this.refreshUI();
            }
        });
    }

    public /* synthetic */ void lambda$doCreate$3$AlarmAISwitchActivity(CompoundButton compoundButton, boolean z) {
        this.alarmConfigV2.O0000o00 = z;
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("chuangmi-ai");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "pet-switch");
            if (O000000o2 != null && O000000o3 != null) {
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmAISwitchActivity.AnonymousClass4 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!AlarmAISwitchActivity.this.isFinishing()) {
                            AlarmAISwitchActivity.this.refreshUI();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!AlarmAISwitchActivity.this.isFinishing()) {
                            AlarmAISwitchActivity.this.refreshUI();
                        }
                    }
                });
            } else if (!isFinishing()) {
                refreshUI();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public static void openFaceManagerActivity(cid cid, Activity activity) {
        if (!cid.O00000oO().O00000Oo()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_vip_user", false);
                jSONObject.put("is_from_camera", true);
                if (cid != null && DeviceConstant.isSupportFaceNative(cid.getModel())) {
                    jSONObject.put("is_using_service", true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            fsp.O000000o().O0000Oo.openFaceManagerActivity(546, activity, cid.getDid(), jSONObject.toString());
            return;
        }
        fsp.O000000o().O0000Oo.openFaceManagerActivity(activity, cid.getDid());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            finish();
        }
    }

    public void refreshUI() {
        this.settingItemFace.setChecked(this.alarmConfigV2.O0000Ooo);
        this.settingItemBabyCry.setChecked(this.alarmConfigV2.O0000OoO);
        this.settingItemPet.setChecked(this.alarmConfigV2.O0000o00);
    }

    public void getAlarmConfig() {
        Object propertyValueFromCache = getPropertyValueFromCache("chuangmi-ai", "pet-switch");
        if (propertyValueFromCache != null) {
            this.alarmConfigV2.O0000o00 = ((Boolean) propertyValueFromCache).booleanValue();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            this.alarmManagerV2.O000000o(this.mCameraDevice.getModel(), jSONObject, new cle.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmAISwitchActivity.AnonymousClass5 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmAISwitchActivity.this.isFinishing()) {
                        AlarmAISwitchActivity.this.alarmConfigV2.O000000o(AlarmAISwitchActivity.this.alarmManagerV2.f14020O000000o);
                        Object propertyValueFromCache = AlarmAISwitchActivity.this.getPropertyValueFromCache("chuangmi-ai", "face-switch");
                        if (propertyValueFromCache != null) {
                            AlarmAISwitchActivity.this.alarmConfigV2.O0000Ooo = ((Boolean) propertyValueFromCache).booleanValue();
                        }
                        AlarmAISwitchActivity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmAISwitchActivity.this.isFinishing()) {
                        AlarmAISwitchActivity.this.alarmConfigV2.O000000o(AlarmAISwitchActivity.this.alarmManagerV2.f14020O000000o);
                        Object propertyValueFromCache = AlarmAISwitchActivity.this.getPropertyValueFromCache("chuangmi-ai", "face-switch");
                        if (propertyValueFromCache != null) {
                            AlarmAISwitchActivity.this.alarmConfigV2.O0000Ooo = ((Boolean) propertyValueFromCache).booleanValue();
                        }
                        AlarmAISwitchActivity.this.refreshUI();
                    }
                }
            });
        } catch (JSONException unused) {
            this.alarmConfigV2.O000000o(this.alarmManagerV2.f14020O000000o);
            refreshUI();
        }
    }
}
