package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.chr;
import _m_j.cid;
import _m_j.civ;
import _m_j.ckz;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.lang.reflect.Array;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    private View mAlarOpenLayout;
    ckz mAlarmConfig = new ckz();
    SettingsItemView mAlarmItem;
    SettingsItemView mAlarmLevel;
    SettingsItemView mAlarmOnlyPeoplePush;
    SettingsItemView mAlarmPush;
    SettingsItemView mAlarmPushTime;
    SettingsItemView mAlarmTime;
    private boolean mJump = false;
    public int mLastLevel = 0;
    public int mLevel = -1;
    private String mMinute = "";
    public int mPeoplePush = -1;
    private String mServer;
    private XQProgressDialog mXQProgressDialog;

    /* access modifiers changed from: package-private */
    public void showProgressDialog() {
        dismissProgressDialog();
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
        this.mXQProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass1 */

            public void onCancel(DialogInterface dialogInterface) {
                if (AlarmSettingActivity.this.mCameraDevice.O0000o0O().O00000oo == null) {
                    AlarmSettingActivity.this.finish();
                }
            }
        });
        this.mXQProgressDialog.show();
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
        setContentView((int) R.layout.activity_setting_alarm);
        this.mServer = XmPluginHostApi.instance().getGlobalSettingServer();
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.more_alarm_setting_v4);
        this.mMinute = getString(R.string.tip_time_minute);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mJump = getIntent().getBooleanExtra("jump", false);
        this.mAlarmItem = (SettingsItemView) findViewById(R.id.settings_alarm);
        this.mAlarmItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingActivity.this.mAlarmConfig.f13979O000000o = z ? 1 : 0;
                AlarmSettingActivity.this.mAlarmConfig.O00000oo = z;
                AlarmSettingActivity alarmSettingActivity = AlarmSettingActivity.this;
                alarmSettingActivity.mPeoplePush = z ^ true ? 1 : 0;
                alarmSettingActivity.refreshUI();
            }
        });
        this.mAlarmPushTime = (SettingsItemView) findViewById(R.id.settings_alarm_push_time);
        this.mAlarmPushTime.setOnClickListener(this);
        this.mAlarmPush = (SettingsItemView) findViewById(R.id.settings_alarm_push);
        this.mAlarmPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingActivity.this.mAlarmConfig.O00000oo = z ? 1 : 0;
                AlarmSettingActivity.this.refreshUI();
            }
        });
        this.mAlarmOnlyPeoplePush = (SettingsItemView) findViewById(R.id.settings_only_people_push);
        cid cid = this.mCameraDevice;
        AnonymousClass4 r7 = new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass4 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Boolean bool) {
                AlarmSettingActivity.this.mAlarmOnlyPeoplePush.setChecked(bool.booleanValue());
            }
        };
        if (XmPluginHostApi.instance().getApiLevel() >= 58) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", cid.mDeviceStat.did);
                jSONObject.put("region", "CN");
                XmPluginHostApi.instance().callSmartHomeApi(cid.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/alarmSwitch", "GET", jSONObject, r7, new Parser<Boolean>() {
                    /* class _m_j.cid.AnonymousClass3 */

                    public final /* synthetic */ Object parse(String str) throws JSONException {
                        return Boolean.valueOf(new JSONObject(str).getJSONObject("data").getBoolean("pedestrianDetectionPushSwitch"));
                    }
                });
            } catch (JSONException unused) {
                r7.onFailure(-10000, null);
            }
        } else {
            r7.onFailure(-1, "api level low");
        }
        this.mAlarmOnlyPeoplePush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass5 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingActivity.this.mCameraDevice.O000000o(z, new Callback<String>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass5.AnonymousClass1 */

                    public void onSuccess(String str) {
                    }

                    public void onFailure(int i, String str) {
                        AlarmSettingActivity.this.mAlarmOnlyPeoplePush.setChecked(false);
                    }
                });
            }
        });
        this.mAlarmTime = (SettingsItemView) findViewById(R.id.settings_alarm_time);
        this.mAlarmLevel = (SettingsItemView) findViewById(R.id.settings_alarm_level);
        this.mAlarmTime.setOnClickListener(this);
        this.mAlarmLevel.setOnClickListener(this);
        ckz ckz = this.mCameraDevice.O0000o0O().O00000oo;
        if (ckz == null) {
            showProgressDialog();
        } else {
            this.mAlarmConfig.O000000o(ckz);
        }
        this.mCameraDevice.O0000o0O().O00000o0(new Callback<ckz>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass6 */

            public void onSuccess(ckz ckz) {
                if (!AlarmSettingActivity.this.isFinishing()) {
                    if (AlarmSettingActivity.this.mAlarmConfig != null) {
                        AlarmSettingActivity.this.mAlarmConfig.O000000o(ckz);
                    }
                    AlarmSettingActivity.this.dismissProgressDialog();
                    AlarmSettingActivity.this.refreshUI();
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSettingActivity.this.isFinishing()) {
                    AlarmSettingActivity.this.dismissProgressDialog();
                    izb.O000000o(AlarmSettingActivity.this, (int) R.string.settings_update_failed, 0).show();
                    if (AlarmSettingActivity.this.mCameraDevice.O0000o0O().O00000oo == null) {
                        AlarmSettingActivity.this.finish();
                    }
                }
            }
        });
        this.mAlarOpenLayout = findViewById(R.id.alarm_open_layout);
        this.mCameraDevice.O0000o0O().O00000Oo(new Callback<int[][]>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass7 */

            public void onSuccess(int[][] iArr) {
                if (!AlarmSettingActivity.this.isFinishing()) {
                    if (iArr == null) {
                        civ.O00000o("alarm", " alarm level null ");
                    } else if (iArr[0][0] == 1) {
                        AlarmSettingActivity.this.mAlarmLevel.setInfo(AlarmSettingActivity.this.getString(R.string.alarm_level_low));
                        AlarmSettingActivity alarmSettingActivity = AlarmSettingActivity.this;
                        alarmSettingActivity.mLastLevel = 0;
                        alarmSettingActivity.mLevel = 0;
                    } else {
                        AlarmSettingActivity.this.mAlarmLevel.setInfo(AlarmSettingActivity.this.getString(R.string.alarm_level_high));
                        AlarmSettingActivity alarmSettingActivity2 = AlarmSettingActivity.this;
                        alarmSettingActivity2.mLastLevel = 1;
                        alarmSettingActivity2.mLevel = 1;
                    }
                }
            }

            public void onFailure(int i, String str) {
                civ.O00000o("alarm", " alarm level ".concat(String.valueOf(str)));
            }
        });
        chr.O000000o(chr.O000O00o);
        findViewById(R.id.settings_alarm_event_type).setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        refreshUI();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mAlarmConfig = null;
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
        if (this.mAlarmConfig.f13979O000000o == 0) {
            this.mAlarmItem.setChecked(false);
            this.mAlarOpenLayout.setVisibility(8);
            return;
        }
        this.mAlarmItem.setChecked(true);
        this.mAlarOpenLayout.setVisibility(0);
        SettingsItemView settingsItemView = this.mAlarmPushTime;
        settingsItemView.setInfo(this.mAlarmConfig.O0000O0o + this.mMinute);
        this.mAlarmPush.setChecked(this.mAlarmConfig.O00000oo != 0);
        int i = this.mPeoplePush;
        if (i != -1) {
            this.mAlarmOnlyPeoplePush.setChecked(i == 0);
        }
        this.mAlarmOnlyPeoplePush.setVisibility(this.mAlarmConfig.O00000oo == 0 ? 8 : 0);
        if (this.mAlarmConfig.O0000O0o == 0 || this.mCameraDevice.O00000oO().O00000Oo()) {
            this.mAlarmPushTime.setVisibility(8);
        } else {
            this.mAlarmPushTime.setVisibility(0);
        }
        if (this.mAlarmConfig.f13979O000000o == 1) {
            this.mAlarmTime.setInfo(getString(R.string.alarm_time_all));
        } else if (this.mAlarmConfig.f13979O000000o == 2) {
            int i2 = (this.mAlarmConfig.O00000Oo * 60) + this.mAlarmConfig.O00000o0;
            int i3 = (this.mAlarmConfig.O00000o * 60) + this.mAlarmConfig.O00000oO;
            if (i2 == 480 && i3 == 1200) {
                this.mAlarmTime.setInfo(getString(R.string.alarm_time_day));
            } else if (i2 == 1200 && i3 == 480) {
                this.mAlarmTime.setInfo(getString(R.string.alarm_time_night));
            } else {
                this.mAlarmTime.setInfo(getString(R.string.alarm_time_user));
            }
        }
        int i4 = this.mLevel;
        if (i4 == 0) {
            this.mAlarmLevel.setInfo(getString(R.string.alarm_level_low));
        } else if (i4 == 1) {
            this.mAlarmLevel.setInfo(getString(R.string.alarm_level_high));
        }
    }

    public void finish() {
        super.finish();
        if (this.mJump) {
            startActivity(new Intent(this, AlarmActivity.class));
        }
    }

    public void onBackPressed() {
        if (this.mPeoplePush != -1) {
            this.mCameraDevice.O000000o(this.mPeoplePush == 0, (Callback<String>) null);
        }
        ckz ckz = this.mCameraDevice.O0000o0O().O00000oo;
        if (ckz != null) {
            if (!ckz.equals(this.mAlarmConfig)) {
                showProgressDialog();
                this.mCameraDevice.O0000o0O().O000000o(this.mAlarmConfig, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass8 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!AlarmSettingActivity.this.isFinishing()) {
                            AlarmSettingActivity.this.runMainThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass8.AnonymousClass1 */

                                public void run() {
                                    AlarmSettingActivity.this.dismissProgressDialog();
                                    izb.O000000o(AlarmSettingActivity.this, (int) R.string.settings_set_success, 0).show();
                                    AlarmSettingActivity.this.finish();
                                }
                            });
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!AlarmSettingActivity.this.isFinishing()) {
                            AlarmSettingActivity.this.runMainThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass8.AnonymousClass2 */

                                public void run() {
                                    AlarmSettingActivity.this.dismissProgressDialog();
                                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(AlarmSettingActivity.this);
                                    builder.O00000Oo((int) R.string.settings_set_failed);
                                    builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass8.AnonymousClass2.AnonymousClass1 */

                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            AlarmSettingActivity.this.finish();
                                        }
                                    });
                                    builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                                    builder.O00000oo();
                                }
                            });
                        }
                    }
                });
                return;
            }
            super.onBackPressed();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AlarmDirectionBean alarmDirectionBean;
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null && (alarmDirectionBean = (AlarmDirectionBean) intent.getParcelableExtra("data")) != null) {
            setTime(alarmDirectionBean);
            refreshUI();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.settings_alarm_time) {
            Intent intent = new Intent();
            AlarmDirectionBean alarmDirectionBean = new AlarmDirectionBean();
            if (this.mAlarmConfig.f13979O000000o == 1) {
                alarmDirectionBean.mTimeType = this.mAlarmConfig.f13979O000000o;
                intent.putExtra("data", alarmDirectionBean);
                intent.setClass(this, AlarmDirectionTimeActivity.class);
                startActivityForResult(intent, 1001);
            } else if (this.mAlarmConfig.f13979O000000o == 2) {
                int i = (this.mAlarmConfig.O00000Oo * 60) + this.mAlarmConfig.O00000o0;
                int i2 = (this.mAlarmConfig.O00000o * 60) + this.mAlarmConfig.O00000oO;
                if (i == 480 && i2 == 1200) {
                    alarmDirectionBean.mTimeType = 2;
                } else if (i == 1200 && i2 == 480) {
                    alarmDirectionBean.mTimeType = 3;
                } else {
                    alarmDirectionBean.mTimeType = 4;
                    alarmDirectionBean.mStartTime = i;
                    alarmDirectionBean.mEndTime = i2;
                }
                intent.putExtra("data", alarmDirectionBean);
                intent.setClass(this, AlarmDirectionTimeActivity.class);
                startActivityForResult(intent, 1001);
            }
        } else if (id == R.id.settings_alarm_level) {
            setLevel();
        } else if (id == R.id.settings_alarm_push_time) {
            showSetTime();
        }
    }

    private void setTime(AlarmDirectionBean alarmDirectionBean) {
        if (alarmDirectionBean.mTimeType == 1) {
            this.mAlarmConfig.f13979O000000o = 1;
        } else if (alarmDirectionBean.mTimeType == 2) {
            ckz ckz = this.mAlarmConfig;
            ckz.f13979O000000o = 2;
            ckz.O00000Oo = 8;
            ckz.O00000o0 = 0;
            ckz.O00000o = 20;
            ckz.O00000oO = 0;
        } else if (alarmDirectionBean.mTimeType == 3) {
            ckz ckz2 = this.mAlarmConfig;
            ckz2.f13979O000000o = 2;
            ckz2.O00000Oo = 20;
            ckz2.O00000o0 = 0;
            ckz2.O00000o = 8;
            ckz2.O00000oO = 0;
        } else if (alarmDirectionBean.mTimeType == 4) {
            ckz ckz3 = this.mAlarmConfig;
            ckz3.f13979O000000o = 2;
            ckz3.O00000Oo = alarmDirectionBean.mStartTime / 60;
            this.mAlarmConfig.O00000o0 = alarmDirectionBean.mStartTime % 60;
            this.mAlarmConfig.O00000o = alarmDirectionBean.mEndTime / 60;
            this.mAlarmConfig.O00000oO = alarmDirectionBean.mEndTime % 60;
        }
    }

    private void showSetTime() {
        int i;
        final ckz ckz = new ckz();
        ckz.O000000o(this.mAlarmConfig);
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        int i2 = this.mAlarmConfig.O0000O0o;
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
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass9 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ckz.O0000O0o = 3;
                } else if (i == 1) {
                    ckz.O0000O0o = 5;
                } else if (i == 2) {
                    ckz.O0000O0o = 10;
                } else if (i != 3) {
                    ckz.O0000O0o = 5;
                } else {
                    ckz.O0000O0o = 30;
                }
            }
        });
        builder.O000000o((int) R.string.settings_alarm_push_time);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass10 */

            public void onClick(DialogInterface dialogInterface, int i) {
                AlarmSettingActivity.this.mAlarmConfig.O000000o(ckz);
                AlarmSettingActivity.this.refreshUI();
            }
        });
        builder.O00000oo();
    }

    private void setLevel() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.alarm_level);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.file_setting_record_item, (ViewGroup) null);
        builder.O000000o(inflate);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass11 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (AlarmSettingActivity.this.mLevel != AlarmSettingActivity.this.mLastLevel) {
                    int[][] iArr = (int[][]) Array.newInstance(int.class, 4, 8);
                    if (AlarmSettingActivity.this.mLastLevel == 0) {
                        for (int i2 = 0; i2 < 4; i2++) {
                            for (int i3 = 0; i3 < 8; i3++) {
                                iArr[i2][i3] = 1;
                            }
                        }
                    } else {
                        for (int i4 = 0; i4 < 4; i4++) {
                            for (int i5 = 0; i5 < 8; i5++) {
                                iArr[i4][i5] = 3;
                            }
                        }
                    }
                    AlarmSettingActivity.this.mCameraDevice.O0000o0O().O000000o(new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass11.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            if (!AlarmSettingActivity.this.isFinishing()) {
                                AlarmSettingActivity.this.mLevel = AlarmSettingActivity.this.mLastLevel;
                                izb.O000000o(AlarmSettingActivity.this, (int) R.string.settings_set_success, 0).show();
                                AlarmSettingActivity.this.refreshUI();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!AlarmSettingActivity.this.isFinishing()) {
                                izb.O000000o(AlarmSettingActivity.this, (int) R.string.set_failed, 0).show();
                            }
                        }
                    }, iArr);
                }
                dialogInterface.dismiss();
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
        final ImageView imageView3 = imageView2;
        final TextView textView5 = textView2;
        final TextView textView6 = textView4;
        final ImageView imageView4 = imageView;
        AnonymousClass12 r8 = r0;
        final TextView textView7 = textView;
        TextView textView8 = textView4;
        View findViewById = inflate.findViewById(R.id.layout2);
        final TextView textView9 = textView3;
        AnonymousClass12 r0 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass12 */

            public void onClick(View view) {
                imageView3.setVisibility(0);
                textView5.setSelected(true);
                textView6.setSelected(true);
                imageView4.setVisibility(4);
                textView7.setSelected(false);
                textView9.setSelected(false);
                AlarmSettingActivity.this.mLastLevel = 0;
            }
        };
        findViewById.setOnClickListener(r8);
        final ImageView imageView5 = imageView;
        final TextView textView10 = textView;
        final TextView textView11 = textView3;
        final ImageView imageView6 = imageView2;
        final TextView textView12 = textView2;
        final TextView textView13 = textView8;
        inflate.findViewById(R.id.layout1).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity.AnonymousClass13 */

            public void onClick(View view) {
                imageView5.setVisibility(0);
                textView10.setSelected(true);
                textView11.setSelected(true);
                imageView6.setVisibility(4);
                textView12.setSelected(false);
                textView13.setSelected(false);
                AlarmSettingActivity.this.mLastLevel = 1;
            }
        });
        O00000o.show();
    }
}
