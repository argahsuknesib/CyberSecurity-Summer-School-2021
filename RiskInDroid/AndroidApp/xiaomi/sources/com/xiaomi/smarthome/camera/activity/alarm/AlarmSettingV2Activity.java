package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chq;
import _m_j.chr;
import _m_j.cin;
import _m_j.cki;
import _m_j.cla;
import _m_j.cle;
import _m_j.clf;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftl;
import _m_j.ftn;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.iaj;
import _m_j.izb;
import _m_j.jdn;
import _m_j.me;
import _m_j.mj;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew;
import com.xiaomi.smarthome.camera.activity.utils.SpecConstantUtils;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.face.activity.DailyStorySettingActivity;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmSettingV2Activity extends CameraBaseActivity implements View.OnClickListener {
    private final int BIND_WX_CODE = 1005;
    cla alarmConfigV2 = new cla();
    cle alarmManagerV2 = null;
    private View mAlarmAiOpenLayout;
    SettingsItemView mAlarmDisappear;
    SettingsItemView mAlarmEventType;
    SettingsItemView mAlarmHumanOnly;
    SettingsItemView mAlarmItem;
    SettingsItemView mAlarmLevel;
    private SettingsItemView mAlarmMove;
    private View mAlarmOpenLayout;
    SettingsItemView mAlarmPush;
    SettingsItemView mAlarmPushTime;
    SettingsItemView mAlarmTime;
    SettingsItemView mDailyStory;
    private boolean mJump = false;
    public int mLastLevel;
    public int mLevel;
    private String mMinute = "";
    SettingsItemView mWxPush;
    private XQProgressDialog mXQProgressDialog;
    SettingsItemView settings_baby_sleep;
    SettingsItemView settings_idm_cast_screen;

    /* access modifiers changed from: package-private */
    public void showProgressDialog() {
        dismissProgressDialog();
        this.mXQProgressDialog = new XQProgressDialog(activity());
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
        this.mXQProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$_ZgXukq6BVjFKuu25OFaBTxdnco */

            public final void onCancel(DialogInterface dialogInterface) {
                AlarmSettingV2Activity.this.lambda$showProgressDialog$0$AlarmSettingV2Activity(dialogInterface);
            }
        });
        this.mXQProgressDialog.show();
    }

    public /* synthetic */ void lambda$showProgressDialog$0$AlarmSettingV2Activity(DialogInterface dialogInterface) {
        if (this.mCameraDevice.O0000o0O().O00000oo == null) {
            finish();
        }
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.mXQProgressDialog;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
            this.mXQProgressDialog = null;
        }
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_setting_alarm_v2);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.more_alarm_setting);
        this.mMinute = getString(R.string.tip_time_minute);
        this.mJump = getIntent().getBooleanExtra("jump", false);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mAlarmItem = (SettingsItemView) findViewById(R.id.settings_alarm);
        this.mAlarmItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$gXtJxP9BI3ZAj_sqM8upctcIY2w */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$1$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmPushTime = (SettingsItemView) findViewById(R.id.settings_alarm_push_time);
        this.mAlarmPushTime.setOnClickListener(this);
        this.mAlarmPush = (SettingsItemView) findViewById(R.id.settings_alarm_push);
        this.mAlarmPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$4nw2WIfIVxYOIZmVTFBrMK6qobQ */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$2$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmHumanOnly = (SettingsItemView) findViewById(R.id.settings_alarm_human_only);
        this.mAlarmHumanOnly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$96FW4VUooFRJlYpeXLbSkBjP0Yc */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$3$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmMove = (SettingsItemView) findViewById(R.id.settings_alarm_move);
        String O000000o2 = ftl.O000000o();
        if (!TextUtils.isEmpty(O000000o2) && "cn".equalsIgnoreCase(O000000o2) && this.isV4 && !DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
            this.mAlarmMove.setVisibility(0);
        }
        this.mAlarmMove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$FNXVzbXMX1FLP5GOp7K7XxqwI8s */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$4$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmHumanOnly.setVisibility(8);
        this.mWxPush = (SettingsItemView) findViewById(R.id.settings_alarm_wx_push);
        this.mWxPush.setVisibility(8);
        this.mWxPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$NunxU5gMgjsUBH_8VZd_aqvbKWg */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$5$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmTime = (SettingsItemView) findViewById(R.id.settings_alarm_time);
        this.mAlarmLevel = (SettingsItemView) findViewById(R.id.settings_alarm_level);
        if (this.mCameraDevice.O0000oOO()) {
            this.mAlarmLevel.setTitle(getString(R.string.alarm_sensivity_setting));
        }
        this.mAlarmEventType = (SettingsItemView) findViewById(R.id.settings_alarm_event_type);
        if (!this.mCameraDevice.isReadOnlyShared()) {
            this.mAlarmEventType.setVisibility(0);
            this.mAlarmEventType.setOnClickListener(this);
        } else {
            this.mAlarmEventType.setVisibility(8);
        }
        this.mAlarmTime.setOnClickListener(this);
        this.mAlarmLevel.setOnClickListener(this);
        this.alarmManagerV2 = this.mCameraDevice.O0000o0o();
        this.mAlarmOpenLayout = findViewById(R.id.alarm_open_layout);
        this.mAlarmAiOpenLayout = findViewById(R.id.alarm_ai_open_layout);
        chr.O000000o(chr.O000O00o);
        this.mDailyStory = (SettingsItemView) findViewById(R.id.daily_story);
        this.settings_baby_sleep = (SettingsItemView) findViewById(R.id.settings_baby_sleep);
        this.settings_baby_sleep.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$XPv6gX4e_B_dkj0zS82CY3sxi8c */

            public final void onClick(View view) {
                AlarmSettingV2Activity.this.lambda$doCreate$6$AlarmSettingV2Activity(view);
            }
        });
        this.settings_idm_cast_screen = (SettingsItemView) findViewById(R.id.settings_idm_cast_screen);
        if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            this.mDailyStory.setVisibility(0);
            this.mDailyStory.setOnClickListener(this);
            if (cin.O00000o0(this.mCameraDevice.O00000o0(), "4.1.6_0078") >= 0) {
                this.settings_idm_cast_screen.setVisibility(0);
            }
        }
        this.settings_idm_cast_screen.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$CrJgynsSyXc8YP6fdRWnyXYAGL4 */

            public final void onClick(View view) {
                AlarmSettingV2Activity.this.lambda$doCreate$7$AlarmSettingV2Activity(view);
            }
        });
        this.mAlarmDisappear = (SettingsItemView) findViewById(R.id.settings_alarm_long_time);
        this.mAlarmDisappear.setOnClickListener(this);
        initWxStatus();
        if (this.mCameraSpecDevice != null) {
            loadCacheAlarmData();
        }
        getAlarmLevel();
        getAlarmConfig();
        refreshUI();
    }

    public /* synthetic */ void lambda$doCreate$1$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        chr.O000000o(chr.O00O0oOO, "type", Integer.valueOf(z ? 1 : 2));
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("motion-detection");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "motion-detection");
            if (O000000o2 == null || O000000o3 == null) {
                refreshUI();
            } else {
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.loadCacheAlarmData();
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }
                });
            }
        } else {
            setMotionDetection(z, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, this.alarmConfigV2.O0000Oo0);
        }
    }

    public /* synthetic */ void lambda$doCreate$2$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        chr.O000000o(chr.O00O0ooO, "type", Integer.valueOf(z ? 1 : 2));
        setPush(z);
    }

    public /* synthetic */ void lambda$doCreate$3$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        setHumanOnly(z);
        chr.O000000o(chr.O00O0ooo, "type", Integer.valueOf(z ? 1 : 2));
    }

    public /* synthetic */ void lambda$doCreate$4$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        setMotionDetection(this.alarmConfigV2.f13985O000000o, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, z);
        chr.O000000o(chr.O00O0oo, "type", Integer.valueOf(z ? 1 : 2));
    }

    public /* synthetic */ void lambda$doCreate$5$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        changeWxPush(z);
        chr.O000000o(chr.O00OOoO, "type", Integer.valueOf(z ? 1 : 2));
    }

    public /* synthetic */ void lambda$doCreate$6$AlarmSettingV2Activity(View view) {
        Intent intent = new Intent(this, SettinsBabySleepActivity.class);
        File file = chq.O00000o0;
        intent.putExtra("babySleepImgPath", me.O000000o("SETTINGS_BABY_SLEEP_IMG_" + this.mCameraDevice.getDid(), this.mCameraDevice.getDid()));
        startActivity(intent);
    }

    public /* synthetic */ void lambda$doCreate$7$AlarmSettingV2Activity(View view) {
        startActivity(new Intent(this, IDMSettingsActivity.class));
    }

    public void onResume() {
        super.onResume();
    }

    private void getAlarmLevel() {
        if (this.mCameraDevice.O0000oOO() && this.mCameraSpecDevice == null) {
            this.mCameraDevice.O0000o0O().O00000o(new Callback<JSONArray>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass2 */

                public void onSuccess(JSONArray jSONArray) {
                    if (!AlarmSettingV2Activity.this.isFinishing() && jSONArray != null && jSONArray.length() > 0) {
                        AlarmSettingV2Activity.this.refresAlarmLevel(jSONArray.optInt(0));
                    }
                }

                public void onFailure(int i, String str) {
                    if (AlarmSettingV2Activity.this.isFinishing()) {
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        XQProgressDialog xQProgressDialog = this.mXQProgressDialog;
        if (xQProgressDialog != null) {
            if (xQProgressDialog.isShowing()) {
                this.mXQProgressDialog.dismiss();
            }
            this.mXQProgressDialog = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshUI() {
        if (!isFinishing()) {
            if (!this.alarmConfigV2.f13985O000000o) {
                this.mAlarmItem.setChecked(false);
                this.mAlarmOpenLayout.setVisibility(8);
                this.mAlarmAiOpenLayout.setVisibility(8);
                this.settings_baby_sleep.setVisibility(8);
                this.mAlarmTime.setVisibility(8);
                return;
            }
            this.mAlarmItem.setChecked(true);
            this.mAlarmOpenLayout.setVisibility(0);
            if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel()) && cin.O00000o0(this.mCameraDevice.O00000o0(), "4.1.6_0070") >= 0) {
                this.mAlarmAiOpenLayout.setVisibility(0);
                if (cin.O00000o0(this.mCameraDevice.O00000o0(), "4.1.6_0073") > 0) {
                    this.settings_baby_sleep.setVisibility(0);
                }
            }
            this.mAlarmTime.setVisibility(0);
            this.mAlarmTime.setInfo(getAlarmTimeInfo());
            if (this.alarmConfigV2.O00000oO > 0) {
                this.mAlarmPushTime.setVisibility(0);
                SettingsItemView settingsItemView = this.mAlarmPushTime;
                settingsItemView.setInfo(this.alarmConfigV2.O00000oO + this.mMinute);
            } else {
                this.mAlarmPushTime.setVisibility(8);
            }
            if (this.isV4 || this.mCameraSpecDevice != null) {
                int i = this.mLevel;
                if (i == 0) {
                    this.mAlarmLevel.setInfo(getString(R.string.alarm_level_low));
                } else if (i == 1) {
                    this.mAlarmLevel.setInfo(getString(R.string.alarm_level_high));
                }
            }
            this.mAlarmHumanOnly.setChecked(this.alarmConfigV2.O00000oo);
            this.mAlarmPush.setChecked(this.alarmConfigV2.O00000o);
            if (!this.mAlarmPush.isChecked()) {
                this.mAlarmEventType.setVisibility(8);
                this.mAlarmHumanOnly.setVisibility(8);
            } else if (!this.mCameraDevice.isReadOnlyShared()) {
                this.mAlarmEventType.setVisibility(0);
            }
            if (this.mCameraDevice.O00000oO().O00000Oo()) {
                this.mAlarmHumanOnly.setVisibility(8);
                if (!DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
                    this.mAlarmPushTime.setVisibility(8);
                }
            }
            this.mAlarmMove.setChecked(this.alarmConfigV2.O0000Oo0);
        }
    }

    public void finish() {
        super.finish();
        if (!this.mJump) {
            return;
        }
        if (!DeviceConstant.isSupportNewAlarm(this.mCameraDevice.getModel()) || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            startActivity(new Intent(this, AlarmVideoActivity.class));
            overridePendingTransition(0, 0);
            return;
        }
        startActivity(new Intent(this, AlarmVideoActivityNew.class));
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            if (i2 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("startTime");
                String stringExtra2 = intent.getStringExtra("endTime");
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                    refreshUI();
                    return;
                }
                cla cla = this.alarmConfigV2;
                cla.O00000Oo = stringExtra;
                cla.O00000o0 = stringExtra2;
                if (this.mCameraSpecDevice != null) {
                    final SpecService O000000o2 = this.mCameraSpecDevice.O000000o("motion-detection");
                    SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "motion-detection-start-time");
                    final SpecProperty O000000o4 = this.mCameraSpecDevice.O000000o(O000000o2, "motion-detection-end-time");
                    if (O000000o2 == null || O000000o3 == null) {
                        refreshUI();
                    } else {
                        faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, cin.O00000Oo(this.alarmConfigV2.O00000Oo), new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass3 */

                            public void onSuccess(JSONObject jSONObject) {
                                if (AlarmSettingV2Activity.this.isFinishing()) {
                                    cki.O00000oO("AlarmSettingV2Activity", "isFinishing");
                                }
                                if (O000000o2 == null || O000000o4 == null) {
                                    AlarmSettingV2Activity.this.refreshUI();
                                } else {
                                    faw.O000000o().setDeviceProp(AlarmSettingV2Activity.this.mCameraDevice.getDid(), O000000o4, cin.O00000Oo(AlarmSettingV2Activity.this.alarmConfigV2.O00000o0), new fsm<JSONObject, fso>() {
                                        /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass3.AnonymousClass1 */

                                        public void onSuccess(JSONObject jSONObject) {
                                            if (!AlarmSettingV2Activity.this.isFinishing()) {
                                                AlarmSettingV2Activity.this.loadCacheAlarmData();
                                                AlarmSettingV2Activity.this.refreshUI();
                                            }
                                        }

                                        public void onFailure(fso fso) {
                                            if (!AlarmSettingV2Activity.this.isFinishing()) {
                                                gsy.O000000o(6, "AlarmSettingV2Activity", "specPropertyEndTime failed");
                                                AlarmSettingV2Activity.this.refreshUI();
                                            }
                                        }
                                    });
                                }
                            }

                            public void onFailure(fso fso) {
                                if (!AlarmSettingV2Activity.this.isFinishing()) {
                                    gsy.O000000o(6, "AlarmSettingV2Activity", "specPropertyStartTime failed");
                                    AlarmSettingV2Activity.this.refreshUI();
                                }
                            }
                        });
                    }
                } else {
                    setMotionDetection(this.alarmConfigV2.f13985O000000o, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, this.alarmConfigV2.O0000Oo0);
                }
            }
        } else if (i == 1005) {
            if (i2 == -1) {
                iaj.O000000o().O000000o(this, this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), new Callback<Boolean>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass4 */

                    public void onSuccess(Boolean bool) {
                        AlarmSettingV2Activity.this.wxPushRefresh(true);
                    }

                    public void onFailure(int i, String str) {
                        AlarmSettingV2Activity.this.wxPushRefresh(false);
                    }
                });
            } else {
                wxPushRefresh(false);
            }
        } else if (i == 1100 && i2 == -1 && intent != null) {
            refresAlarmLevel(intent.getIntExtra("alarmLevel", 0));
        }
    }

    public void refresAlarmLevel(int i) {
        if (this.mCameraDevice.O0000oOO()) {
            if (i == 1) {
                this.mAlarmLevel.setInfo(getString(R.string.alarm_level_low_info));
            } else if (i == 2) {
                this.mAlarmLevel.setInfo(getString(R.string.alarm_sensivity_middle_info));
            } else if (i == 3) {
                this.mAlarmLevel.setInfo(getString(R.string.alarm_level_high_info));
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.settings_alarm_time) {
            Intent intent = new Intent(this, AlarmDirectionTimeV2Activity.class);
            intent.putExtra("startTime", this.alarmConfigV2.O00000Oo);
            intent.putExtra("endTime", this.alarmConfigV2.O00000o0);
            startActivityForResult(intent, 1001);
        } else if (view.getId() == R.id.settings_alarm_level) {
            if (!this.isV4) {
                Intent intent2 = new Intent(this, !"isa.camera.hlc6".equals(this.mDeviceStat.model) ? AlarmSelectV2Activity.class : AlarmSensitivityActivity.class);
                intent2.putExtra("sensitive", this.alarmConfigV2.O0000O0o);
                startActivityForResult(intent2, 1100);
            } else {
                setLevel();
            }
            chr.O000000o("u5v.u1o.4k5.qf1");
        } else if (view.getId() == R.id.settings_alarm_push_time) {
            showSetTime();
        } else if (view.getId() == R.id.settings_alarm_event_type) {
            startActivityForResult(new Intent(this, AlarmEventTypeSettingActivity.class), 1002);
            chr.O000000o(chr.O00OO0O);
        } else if (view.getId() == R.id.daily_story) {
            hxi.O00000o.f952O000000o.O000000o("MonitoringSetting_DailyStory_ClickNum", new Object[0]);
            startActivity(new Intent(this, DailyStorySettingActivity.class));
        } else if (view.getId() == R.id.settings_alarm_long_time) {
            chr.O000000o(chr.O00OOoo);
            LongTimeAlarmListActivity.startLongTimeAlarmListActivity(this, this.mDid);
        }
    }

    private void setLevel() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.alarm_level);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.file_setting_record_item, (ViewGroup) null);
        builder.O000000o(inflate);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$9xtaC31cFtvIwzrWvL2y2nV2Tlk */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmSettingV2Activity.this.lambda$setLevel$8$AlarmSettingV2Activity(dialogInterface, i);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.text1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.text2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.title1);
        TextView textView4 = (TextView) inflate.findViewById(R.id.title2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.select_icon1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.select_icon2);
        MLAlertDialog O00000o = builder.O00000o();
        inflate.findViewById(R.id.layout3).setVisibility(8);
        inflate.findViewById(R.id.list_item_line3).setVisibility(8);
        textView.setText((int) R.string.alarm_level_high);
        textView3.setText((int) R.string.alarm_level_high_title);
        textView2.setText((int) R.string.alarm_level_low);
        textView4.setText((int) R.string.alarm_level_low_title);
        if (this.mLevel == 1) {
            imageView.setVisibility(0);
            textView.setSelected(true);
            textView3.setSelected(true);
            imageView2.setVisibility(4);
            textView2.setSelected(false);
            textView4.setSelected(false);
        } else {
            imageView2.setVisibility(0);
            textView2.setSelected(true);
            textView4.setSelected(true);
            imageView.setVisibility(4);
            textView.setSelected(false);
            textView3.setSelected(false);
        }
        $$Lambda$AlarmSettingV2Activity$4hnLLnBbd9cGbh22M0ra8VdMo r8 = r0;
        TextView textView5 = textView4;
        View findViewById = inflate.findViewById(R.id.layout2);
        $$Lambda$AlarmSettingV2Activity$4hnLLnBbd9cGbh22M0ra8VdMo r0 = new View.OnClickListener(imageView2, textView2, textView4, imageView, textView, textView3) {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$4hnLLnBbd9cGbh22M0ra8VdMo */
            private final /* synthetic */ ImageView f$1;
            private final /* synthetic */ TextView f$2;
            private final /* synthetic */ TextView f$3;
            private final /* synthetic */ ImageView f$4;
            private final /* synthetic */ TextView f$5;
            private final /* synthetic */ TextView f$6;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void onClick(View view) {
                AlarmSettingV2Activity.this.lambda$setLevel$9$AlarmSettingV2Activity(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, view);
            }
        };
        findViewById.setOnClickListener(r8);
        inflate.findViewById(R.id.layout1).setOnClickListener(new View.OnClickListener(imageView, textView, textView3, imageView2, textView2, textView5) {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$C6tw_nAvNLbYyFqnAS5BeisNN10 */
            private final /* synthetic */ ImageView f$1;
            private final /* synthetic */ TextView f$2;
            private final /* synthetic */ TextView f$3;
            private final /* synthetic */ ImageView f$4;
            private final /* synthetic */ TextView f$5;
            private final /* synthetic */ TextView f$6;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void onClick(View view) {
                AlarmSettingV2Activity.this.lambda$setLevel$10$AlarmSettingV2Activity(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, view);
            }
        });
        O00000o.show();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    public /* synthetic */ void lambda$setLevel$8$AlarmSettingV2Activity(DialogInterface dialogInterface, int i) {
        if (this.mLevel != this.mLastLevel) {
            int[][] iArr = (int[][]) Array.newInstance(int.class, 4, 8);
            int i2 = 1;
            if (this.mLastLevel == 0) {
                for (int i3 = 0; i3 < 4; i3++) {
                    for (int i4 = 0; i4 < 8; i4++) {
                        iArr[i3][i4] = 1;
                    }
                }
            } else {
                for (int i5 = 0; i5 < 4; i5++) {
                    for (int i6 = 0; i6 < 8; i6++) {
                        iArr[i5][i6] = 3;
                    }
                }
            }
            if (this.mLastLevel == 0) {
                chr.O000000o(chr.O000OO00, "type", (Object) 1);
            } else {
                chr.O000000o(chr.O000OO00, "type", (Object) 3);
            }
            String str = chr.O00O0oOo;
            if (this.mLastLevel != 0) {
                i2 = 2;
            }
            chr.O000000o(str, "type", Integer.valueOf(i2));
            if (this.mCameraSpecDevice != null) {
                SpecService O000000o2 = this.mCameraSpecDevice.O000000o("motion-detection");
                SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "detection-sensitivity");
                if (O000000o2 == null || O000000o3 == null) {
                    refreshUI();
                } else {
                    faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Integer.valueOf(this.mLastLevel), new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass5 */

                        public void onSuccess(JSONObject jSONObject) {
                            if (!AlarmSettingV2Activity.this.isFinishing()) {
                                Object propertyValueFromCache = AlarmSettingV2Activity.this.getPropertyValueFromCache("motion-detection", "detection-sensitivity");
                                AlarmSettingV2Activity.this.mLastLevel = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 0;
                                AlarmSettingV2Activity alarmSettingV2Activity = AlarmSettingV2Activity.this;
                                alarmSettingV2Activity.mLevel = alarmSettingV2Activity.mLastLevel;
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000O0o[0] = AlarmSettingV2Activity.this.mLevel;
                                AlarmSettingV2Activity.this.runOnUiThread(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$5$p2z_RMtiXnpMpJb6Wv_NCA1XrHs */

                                    public final void run() {
                                        AlarmSettingV2Activity.AnonymousClass5.this.lambda$onSuccess$0$AlarmSettingV2Activity$5();
                                    }
                                });
                            }
                        }

                        public /* synthetic */ void lambda$onSuccess$0$AlarmSettingV2Activity$5() {
                            AlarmSettingV2Activity.this.refreshUI();
                            izb.O000000o(AlarmSettingV2Activity.this, (int) R.string.settings_set_success, 0).show();
                        }

                        public void onFailure(fso fso) {
                            if (!AlarmSettingV2Activity.this.isFinishing()) {
                                AlarmSettingV2Activity.this.runOnUiThread(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$5$PYgaNIv9odVsjyO02DwkHDPlZ4 */

                                    public final void run() {
                                        AlarmSettingV2Activity.AnonymousClass5.this.lambda$onFailure$1$AlarmSettingV2Activity$5();
                                    }
                                });
                            }
                        }

                        public /* synthetic */ void lambda$onFailure$1$AlarmSettingV2Activity$5() {
                            AlarmSettingV2Activity.this.refreshUI();
                            izb.O000000o(AlarmSettingV2Activity.this, (int) R.string.set_failed, 0).show();
                        }
                    });
                }
            } else {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("did", this.mCameraDevice.getDid());
                    hashMap.put("region", Locale.getDefault().getCountry());
                    JSONArray jSONArray = new JSONArray();
                    for (int put : dimension2ToDimension1(iArr)) {
                        jSONArray.put(put);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sensitive", jSONArray);
                    hashMap.put("sensitive", jSONObject.toString());
                    clf.O000000o().O00000oo(this.mCameraDevice.getModel(), hashMap.toString(), new Callback<JSONObject>() {
                        /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass6 */

                        public void onSuccess(JSONObject jSONObject) {
                            if (!AlarmSettingV2Activity.this.isFinishing()) {
                                AlarmSettingV2Activity.this.runOnUiThread(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$6$1eWPPp6NR3OmZ2eslShkGEhhjE */

                                    public final void run() {
                                        AlarmSettingV2Activity.AnonymousClass6.this.lambda$onSuccess$0$AlarmSettingV2Activity$6();
                                    }
                                });
                            }
                        }

                        public /* synthetic */ void lambda$onSuccess$0$AlarmSettingV2Activity$6() {
                            if (!AlarmSettingV2Activity.this.isFinishing()) {
                                AlarmSettingV2Activity alarmSettingV2Activity = AlarmSettingV2Activity.this;
                                alarmSettingV2Activity.mLevel = alarmSettingV2Activity.mLastLevel;
                                izb.O000000o(AlarmSettingV2Activity.this, (int) R.string.settings_set_success, 0).show();
                                AlarmSettingV2Activity.this.refreshUI();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!AlarmSettingV2Activity.this.isFinishing()) {
                                izb.O000000o(AlarmSettingV2Activity.this, (int) R.string.set_failed, 0).show();
                            }
                        }
                    });
                } catch (JSONException unused) {
                }
            }
        }
        dialogInterface.dismiss();
    }

    public /* synthetic */ void lambda$setLevel$9$AlarmSettingV2Activity(ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, View view) {
        imageView.setVisibility(0);
        textView.setSelected(true);
        textView2.setSelected(true);
        imageView2.setVisibility(4);
        textView3.setSelected(false);
        textView4.setSelected(false);
        this.mLastLevel = 0;
    }

    public /* synthetic */ void lambda$setLevel$10$AlarmSettingV2Activity(ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, View view) {
        imageView.setVisibility(0);
        textView.setSelected(true);
        textView2.setSelected(true);
        imageView2.setVisibility(4);
        textView3.setSelected(false);
        textView4.setSelected(false);
        this.mLastLevel = 1;
    }

    private int[] dimension2ToDimension1(int[][] iArr) {
        int[] iArr2 = new int[32];
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < 8) {
                iArr2[i3] = iArr[i][i4];
                i4++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        return iArr2;
    }

    private void showSetTime() {
        int i;
        cla cla = new cla();
        cla.O000000o(this.alarmConfigV2);
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
        int i2 = cla.O00000oO;
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 == 10) {
                    i = 2;
                } else if (i2 == 30) {
                    i = 3;
                }
            }
            i = 1;
        } else {
            i = 0;
        }
        builder.O000000o(new String[]{"3" + this.mMinute, "5" + this.mMinute, "10" + this.mMinute, "30" + this.mMinute}, i, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$0CTEVlP1fr4aVPYyGqFMe8vfFDs */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmSettingV2Activity.lambda$showSetTime$11(cla.this, dialogInterface, i);
            }
        });
        builder.O000000o((int) R.string.settings_alarm_push_time);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(cla) {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$kCav7ePx3vXponBmyMGITiEL9n4 */
            private final /* synthetic */ cla f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmSettingV2Activity.this.lambda$showSetTime$12$AlarmSettingV2Activity(this.f$1, dialogInterface, i);
            }
        });
        builder.O00000oo();
    }

    static /* synthetic */ void lambda$showSetTime$11(cla cla, DialogInterface dialogInterface, int i) {
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                cla.O00000oO = 5;
            } else if (i == 2) {
                cla.O00000oO = 10;
                i2 = 3;
            } else if (i == 3) {
                i2 = 4;
                cla.O00000oO = 30;
            }
            chr.O000000o(chr.O00O0oo0, "type", Integer.valueOf(i2));
        }
        cla.O00000oO = 3;
        i2 = 1;
        chr.O000000o(chr.O00O0oo0, "type", Integer.valueOf(i2));
    }

    public /* synthetic */ void lambda$showSetTime$12$AlarmSettingV2Activity(final cla cla, DialogInterface dialogInterface, int i) {
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("motion-detection");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "alarm-interval");
            if (O000000o2 == null || O000000o3 == null) {
                refreshUI();
            } else {
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Integer.valueOf(cla.O00000oO), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass7 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.alarmConfigV2.O00000oO = cla.O00000oO;
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }
                });
            }
        } else {
            this.alarmConfigV2.O000000o(cla);
            setMotionDetection(this.alarmConfigV2.f13985O000000o, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, this.alarmConfigV2.O0000Oo0);
        }
        refreshUI();
    }

    public void loadCacheAlarmData() {
        boolean z;
        int i;
        try {
            z = ((Boolean) getPropertyValueFromCache("motion-detection", "motion-detection")).booleanValue();
        } catch (Exception e) {
            cki.O00000o0("AlarmSettingV2Activity", "isOn Exception:" + e.getLocalizedMessage());
            z = false;
        }
        this.alarmConfigV2.f13985O000000o = z;
        int i2 = 5;
        try {
            i2 = ((Integer) getPropertyValueFromCache("motion-detection", "alarm-interval")).intValue();
        } catch (Exception e2) {
            cki.O00000o0("AlarmSettingV2Activity", "interval Exception:" + e2.getLocalizedMessage());
        }
        this.alarmConfigV2.O00000oO = i2;
        try {
            i = ((Integer) getPropertyValueFromCache("motion-detection", "detection-sensitivity")).intValue();
        } catch (Exception e3) {
            cki.O00000o0("AlarmSettingV2Activity", "sensitive Exception:" + e3.getLocalizedMessage());
            i = 0;
        }
        this.alarmConfigV2.O0000O0o[0] = i;
        if (this.alarmConfigV2.O0000O0o[0] == 0) {
            this.mLastLevel = 0;
            this.mLevel = 0;
        } else {
            this.mLastLevel = 1;
            this.mLevel = 1;
        }
        Object propertyValueFromCache = getPropertyValueFromCache("motion-detection", "motion-detection-start-time");
        String str = "00:00:00";
        if (propertyValueFromCache != null) {
            try {
                str = cin.O00000o0(String.valueOf(propertyValueFromCache).replace(jdn.f1779O000000o, ""));
            } catch (Exception e4) {
                cki.O00000o0("AlarmSettingV2Activity", "startTime Exception:" + e4.getLocalizedMessage());
            }
        }
        this.alarmConfigV2.O00000Oo = str;
        Object propertyValueFromCache2 = getPropertyValueFromCache("motion-detection", "motion-detection-end-time");
        String str2 = "23:59:59";
        if (propertyValueFromCache2 != null) {
            try {
                str2 = cin.O00000o0(String.valueOf(propertyValueFromCache2).replace(jdn.f1779O000000o, ""));
            } catch (Exception e5) {
                cki.O00000o0("AlarmSettingV2Activity", "endTime Exception:" + e5.getLocalizedMessage());
            }
        }
        this.alarmConfigV2.O00000o0 = str2;
        gsy.O00000Oo("AlarmSettingV2Activity", "startTime::" + this.alarmConfigV2.O00000Oo + " endTime::" + this.alarmConfigV2.O00000o0);
        if (i2 <= 0) {
            try {
                if (this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = this.mCameraSpecDevice.O000000o("motion-detection");
                    SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "alarm-interval");
                    if (O000000o2 != null && O000000o3 != null) {
                        faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Integer.valueOf(this.alarmConfigV2.O00000oO), new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass8 */

                            public void onSuccess(JSONObject jSONObject) {
                                cki.O00000oO("AlarmSettingV2Activity", "set default alarm-interval onSuccess ".concat(String.valueOf(jSONObject)));
                            }

                            public void onFailure(fso fso) {
                                cki.O00000oO("AlarmSettingV2Activity", "set default alarm-interval onFailure ".concat(String.valueOf(fso)));
                            }
                        });
                    }
                }
            } catch (Exception e6) {
                cki.O00000oO("AlarmSettingV2Activity", e6.toString());
            }
        }
    }

    public void getAlarmConfig() {
        if (this.mCameraSpecDevice != null) {
            loadPropertiesFromServer(SpecConstantUtils.MotionDetectionSpecKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass9 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<PropertyParam>) ((List) obj));
                }

                public void onSuccess(List<PropertyParam> list) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.loadCacheAlarmData();
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }
            });
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", this.mCameraDevice.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                clf.O000000o().O000000o(this.mCameraDevice.getModel(), jSONObject.toString(), new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass10 */

                    public void onSuccess(JSONObject jSONObject) {
                        JSONObject optJSONObject;
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            if (!(jSONObject == null || jSONObject.optInt("code") != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null)) {
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("motionDetectionSwitch");
                                if (optJSONObject2 != null) {
                                    AlarmSettingV2Activity.this.alarmConfigV2.O0000Oo0 = optJSONObject2.optBoolean("trackSwitch", false);
                                }
                                AlarmSettingV2Activity.this.alarmConfigV2.O00000oo = optJSONObject.optBoolean("pedestrianDetectionPushSwitch", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O00000o = optJSONObject.optBoolean("pushSwitch", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000OoO = optJSONObject.optBoolean("babyCrySwitch", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000Ooo = optJSONObject.optBoolean("faceSwitch", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000o0o = optJSONObject.optBoolean("babyPush", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000o = optJSONObject.optBoolean("facePush", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000o0O = optJSONObject.optBoolean("aiPush", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000o0 = optJSONObject.optBoolean("areaPush", false);
                                AlarmSettingV2Activity.this.alarmConfigV2.O0000oO = optJSONObject.optBoolean("pedestrianDetectionPushSwitch", false);
                            }
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }
                });
            } catch (JSONException unused) {
                refreshUI();
            }
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("did", this.mCameraDevice.getDid());
                jSONObject2.put("region", Locale.getDefault().getCountry());
                this.alarmManagerV2.O000000o(this.mCameraDevice.getModel(), jSONObject2, new cle.O000000o() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass11 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.f14020O000000o);
                            if (AlarmSettingV2Activity.this.alarmConfigV2.O0000O0o[0] == 1) {
                                AlarmSettingV2Activity alarmSettingV2Activity = AlarmSettingV2Activity.this;
                                alarmSettingV2Activity.mLastLevel = 0;
                                alarmSettingV2Activity.mLevel = 0;
                            } else {
                                AlarmSettingV2Activity alarmSettingV2Activity2 = AlarmSettingV2Activity.this;
                                alarmSettingV2Activity2.mLastLevel = 1;
                                alarmSettingV2Activity2.mLevel = 1;
                            }
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.f14020O000000o);
                            AlarmSettingV2Activity.this.refreshUI();
                        }
                    }
                });
            } catch (JSONException unused2) {
                this.alarmConfigV2.O000000o(this.alarmManagerV2.f14020O000000o);
                refreshUI();
            }
        }
    }

    public void setHumanOnly(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
            cle cle = this.alarmManagerV2;
            String model = this.mCameraDevice.getModel();
            AnonymousClass12 r2 = new cle.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass12 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.f14020O000000o);
                        AlarmSettingV2Activity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$AlarmSettingV2Activity$12$5ScE9fk6WWg9aJ5RuwJ5Yis1UdA */

                            public final void run() {
                                AlarmSettingV2Activity.AnonymousClass12.this.lambda$onSuccess$0$AlarmSettingV2Activity$12();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$AlarmSettingV2Activity$12() {
                    AlarmSettingV2Activity.this.refreshUI();
                }

                public void onFailure(int i, String str) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.mAlarmHumanOnly.setChecked(AlarmSettingV2Activity.this.alarmConfigV2.O00000oo);
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }
            };
            if (!TextUtils.isEmpty(model)) {
                clf.O000000o().O00000oO(model, jSONObject.toString(), new Callback<JSONObject>(jSONObject, r2) {
                    /* class _m_j.cle.AnonymousClass13 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ JSONObject f14025O000000o;
                    final /* synthetic */ O000000o O00000Oo;

                    {
                        this.f14025O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            civ.O000000o("AlarmManagerV2", "jsonObject:" + jSONObject.toString());
                            if (jSONObject.optInt("code") == 0) {
                                cle.this.f14020O000000o.O00000oo = this.f14025O000000o.optBoolean("open");
                                O000000o o000000o = this.O00000Oo;
                                if (o000000o != null) {
                                    o000000o.onSuccess(null, null);
                                    return;
                                }
                                return;
                            }
                            O000000o o000000o2 = this.O00000Oo;
                            if (o000000o2 != null) {
                                o000000o2.onFailure(-90002, "code is not 0");
                                return;
                            }
                            return;
                        }
                        O000000o o000000o3 = this.O00000Oo;
                        if (o000000o3 != null) {
                            o000000o3.onFailure(-90002, "jsonObject is null");
                        }
                    }

                    public final void onFailure(int i, String str) {
                        civ.O00000o0("AlarmManagerV2", "putHumanDetectionPush i:" + i + " s:" + str);
                        O000000o o000000o = this.O00000Oo;
                        if (o000000o != null) {
                            o000000o.onFailure(i, str);
                        }
                    }
                });
            }
        } catch (JSONException unused) {
            this.mAlarmHumanOnly.setChecked(this.alarmConfigV2.O00000oo);
            refreshUI();
        }
    }

    private void setMotionDetection(boolean z, int i, String str, String str2, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                mj.O000000o();
                String O000000o2 = mj.O000000o(str);
                if (!TextUtils.isEmpty(O000000o2)) {
                    str = O000000o2;
                }
            } else {
                str = "00:00:00";
            }
            if (!TextUtils.isEmpty(str2)) {
                mj.O000000o();
                String O000000o3 = mj.O000000o(str2);
                if (!TextUtils.isEmpty(O000000o3)) {
                    str2 = O000000o3;
                }
            } else {
                str2 = "23:59:59";
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
            jSONObject.put("interval", i);
            jSONObject.put("startTime", str);
            jSONObject.put("endTime", str2);
            jSONObject.put("trackSwitch", z2);
            this.alarmManagerV2.O00000Oo(this.mCameraDevice.getModel(), jSONObject, new cle.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass13 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.f14020O000000o);
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.mAlarmItem.setChecked(AlarmSettingV2Activity.this.alarmConfigV2.f13985O000000o);
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }
            });
        } catch (JSONException unused) {
            this.mAlarmItem.setChecked(this.alarmConfigV2.f13985O000000o);
            refreshUI();
        }
    }

    private void setPush(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
            cle cle = this.alarmManagerV2;
            String model = this.mCameraDevice.getModel();
            AnonymousClass14 r2 = new cle.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass14 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        if (AlarmSettingV2Activity.this.mCameraSpecDevice != null) {
                            AlarmSettingV2Activity.this.alarmConfigV2.O00000o = AlarmSettingV2Activity.this.alarmManagerV2.f14020O000000o.O00000o;
                        } else {
                            AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.f14020O000000o);
                        }
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.mAlarmPush.setChecked(AlarmSettingV2Activity.this.alarmConfigV2.O00000o);
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }
            };
            if (!TextUtils.isEmpty(model)) {
                clf.O000000o().O00000o(model, jSONObject.toString(), new Callback<JSONObject>(jSONObject, r2) {
                    /* class _m_j.cle.AnonymousClass12 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ JSONObject f14024O000000o;
                    final /* synthetic */ O000000o O00000Oo;

                    {
                        this.f14024O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject == null) {
                            O000000o o000000o = this.O00000Oo;
                            if (o000000o != null) {
                                o000000o.onFailure(-90002, "jsonObject is null");
                            }
                        } else if (jSONObject.optInt("code") == 0) {
                            cle.this.f14020O000000o.O00000o = this.f14024O000000o.optBoolean("open");
                            O000000o o000000o2 = this.O00000Oo;
                            if (o000000o2 != null) {
                                o000000o2.onSuccess(null, null);
                            }
                        } else {
                            O000000o o000000o3 = this.O00000Oo;
                            if (o000000o3 != null) {
                                o000000o3.onFailure(-90002, "code is not 0");
                            }
                        }
                    }

                    public final void onFailure(int i, String str) {
                        civ.O00000o0("AlarmManagerV2", "putPush i:" + i + " s:" + str);
                        O000000o o000000o = this.O00000Oo;
                        if (o000000o != null) {
                            o000000o.onFailure(i, str);
                        }
                    }
                });
            }
        } catch (JSONException unused) {
            this.mAlarmPush.setChecked(this.alarmConfigV2.O00000o);
            refreshUI();
        }
    }

    private String getAlarmTimeInfo() {
        gsy.O00000Oo("AlarmSettingV2Activity", "getAlarmTimeInfo startTime:" + this.alarmConfigV2.O00000Oo + " endTime:" + this.alarmConfigV2.O00000o0);
        if (this.alarmConfigV2.O00000Oo.equals("00:00:00") && (this.alarmConfigV2.O00000o0.equals("23:59:59") || this.alarmConfigV2.O00000o0.contains("23:59"))) {
            return getString(R.string.alarm_time_all);
        }
        if (Math.abs(cin.O00000o(this.alarmConfigV2.O00000Oo) - cin.O00000o("00:00:00")) < 180000 && Math.abs(cin.O00000o(this.alarmConfigV2.O00000o0) - cin.O00000o("23:59:59")) < 180000) {
            return getString(R.string.alarm_time_all);
        }
        if (this.alarmConfigV2.O00000Oo.equals("08:00:00") && this.alarmConfigV2.O00000o0.equals("20:00:00")) {
            return getString(R.string.alarm_time_day);
        }
        if (Math.abs(cin.O00000o(this.alarmConfigV2.O00000Oo) - cin.O00000o("08:00:00")) < 180000 && Math.abs(cin.O00000o(this.alarmConfigV2.O00000o0) - cin.O00000o("20:00:00")) < 180000) {
            return getString(R.string.alarm_time_day);
        }
        if (this.alarmConfigV2.O00000Oo.equals("20:00:00") && this.alarmConfigV2.O00000o0.equals("08:00:00")) {
            return getString(R.string.alarm_time_night);
        }
        if (Math.abs(cin.O00000o(this.alarmConfigV2.O00000Oo) - cin.O00000o("20:00:00")) >= 180000 || Math.abs(cin.O00000o(this.alarmConfigV2.O00000o0) - cin.O00000o("08:00:00")) >= 180000) {
            return getString(R.string.alarm_time_user);
        }
        return getString(R.string.alarm_time_night);
    }

    public void initWxStatus() {
        if (!this.isV4 && !DeviceConstant.isSupportNewUI(this.mCameraDevice.getModel()) && !this.mCameraDevice.O0000oOO()) {
            String globalSettingServer = XmPluginHostApi.instance().getGlobalSettingServer();
            boolean z = !TextUtils.isEmpty(globalSettingServer) && globalSettingServer.toLowerCase().equals("cn");
            if (XmPluginHostApi.instance().getApiLevel() >= 75 && z && this.mDeviceStat != null && this.mCameraDevice.isOwner()) {
                this.mWxPush.setVisibility(0);
                XmPluginHostApi.instance().getWxPushSwitchState(this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), new Callback<Boolean>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass15 */

                    public void onFailure(int i, String str) {
                    }

                    public void onSuccess(Boolean bool) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.mWxPush.setChecked(bool.booleanValue());
                        }
                    }
                });
            }
        }
    }

    private void setWxPush(final boolean z) {
        iaj.O000000o().O000000o(this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), z, new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass16 */

            public void onSuccess(Boolean bool) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
                    AlarmSettingV2Activity.this.wxPushRefresh(z);
                    gqg.O000000o((int) R.string.smb_tip_set_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
                    AlarmSettingV2Activity.this.activity();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                    AlarmSettingV2Activity.this.initWxStatus();
                }
            }
        });
    }

    private void changeWxPush(boolean z) {
        if (!z) {
            setWxPush(false);
            return;
        }
        this.mWxPush.setEnabled(false);
        XmPluginHostApi.instance().setWxPush(this, this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), z, 1005, new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity.AnonymousClass17 */

            public void onSuccess(Boolean bool) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
                    AlarmSettingV2Activity.this.wxPushRefresh(true);
                    gqg.O000000o((int) R.string.smb_tip_set_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
                    AlarmSettingV2Activity.this.activity();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                    AlarmSettingV2Activity.this.initWxStatus();
                }
            }
        });
    }

    public void wxPushRefresh(boolean z) {
        this.mWxPush.setEnabled(true);
        this.mWxPush.setChecked(z);
    }
}
