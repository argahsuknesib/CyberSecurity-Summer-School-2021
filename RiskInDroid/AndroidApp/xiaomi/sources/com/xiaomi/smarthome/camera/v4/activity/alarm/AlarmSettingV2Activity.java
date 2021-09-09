package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.chr;
import _m_j.cla;
import _m_j.cld;
import _m_j.clf;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.iaj;
import _m_j.izb;
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
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmSettingV2Activity extends CameraBaseActivity implements View.OnClickListener {
    private final int BIND_WX_CODE = 1005;
    cla alarmConfigV2 = new cla();
    cld alarmManagerV2 = null;
    SettingsItemView mAlarmHumanOnly;
    SettingsItemView mAlarmItem;
    SettingsItemView mAlarmLevel;
    SettingsItemView mAlarmMove;
    private View mAlarmOpenLayout;
    SettingsItemView mAlarmPush;
    SettingsItemView mAlarmPushTime;
    SettingsItemView mAlarmTime;
    private boolean mJump = false;
    public int mLastLevel = 0;
    public int mLevel = -1;
    private String mMinute = "";
    SettingsItemView mWxPush;
    private XQProgressDialog mXQProgressDialog;

    /* access modifiers changed from: package-private */
    public void showProgressDialog() {
        dismissProgressDialog();
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
        this.mXQProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$0Q4munuDphq51udTpgFbeOvmbY */

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
        setContentView((int) R.layout.activity_setting_alarm);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.more_alarm_setting_v4);
        this.mMinute = getString(R.string.tip_time_minute);
        this.mJump = getIntent().getBooleanExtra("jump", false);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mAlarmItem = (SettingsItemView) findViewById(R.id.settings_alarm);
        this.mAlarmItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$CDsmmKlmyJjTOyseVVLZDZFkKPM */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$1$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmPushTime = (SettingsItemView) findViewById(R.id.settings_alarm_push_time);
        this.mAlarmPushTime.setOnClickListener(this);
        this.mAlarmPush = (SettingsItemView) findViewById(R.id.settings_alarm_push);
        this.mAlarmPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$DsEDCp5Xje8LD9t8DJLYgLQzxoM */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$2$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmHumanOnly = (SettingsItemView) findViewById(R.id.settings_only_people_push);
        this.mAlarmHumanOnly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$YpPeVbHMH07P2_FCJbc77FMKtrY */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$3$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmMove = (SettingsItemView) findViewById(R.id.settings_alarm_move);
        this.mAlarmMove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$EP4IZ_QezIiTnPYM2dYzx4A */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AlarmSettingV2Activity.this.lambda$doCreate$4$AlarmSettingV2Activity(compoundButton, z);
            }
        });
        this.mAlarmTime = (SettingsItemView) findViewById(R.id.settings_alarm_time);
        this.mAlarmLevel = (SettingsItemView) findViewById(R.id.settings_alarm_level);
        this.mAlarmTime.setOnClickListener(this);
        this.mAlarmLevel.setOnClickListener(this);
        this.alarmManagerV2 = this.mCameraDevice.O0000o0O();
        this.mAlarmOpenLayout = findViewById(R.id.alarm_open_layout);
        chr.O000000o(chr.O000O00o);
    }

    public /* synthetic */ void lambda$doCreate$1$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        chr.O000000o(chr.O00O0oOO, "type", Integer.valueOf(z ? 1 : 2));
        chr.O000000o(chr.O000O0OO);
        setMotionDetection(z, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, this.alarmConfigV2.O0000Oo0);
    }

    public /* synthetic */ void lambda$doCreate$2$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        chr.O000000o(chr.O000O0o);
        chr.O000000o(chr.O00O0ooO, "type", Integer.valueOf(z ? 1 : 2));
        setPush(z);
    }

    public /* synthetic */ void lambda$doCreate$3$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        chr.O000000o(chr.O000O0oO);
        chr.O000000o(chr.O00O0ooo, "type", Integer.valueOf(z ? 1 : 2));
        setHumanOnly(z);
    }

    public /* synthetic */ void lambda$doCreate$4$AlarmSettingV2Activity(CompoundButton compoundButton, boolean z) {
        setMotionDetection(this.alarmConfigV2.f13985O000000o, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, z);
        chr.O000000o(chr.O00O0oo, "type", Integer.valueOf(z ? 1 : 2));
    }

    public void onResume() {
        super.onResume();
        getAlarmConfig();
        refreshUI();
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
        if (!this.alarmConfigV2.f13985O000000o) {
            this.mAlarmItem.setChecked(false);
            this.mAlarmOpenLayout.setVisibility(8);
            return;
        }
        this.mAlarmItem.setChecked(true);
        this.mAlarmOpenLayout.setVisibility(0);
        this.mAlarmTime.setInfo(getAlarmTimeInfo());
        if (this.alarmConfigV2.O00000oO > 0) {
            this.mAlarmPushTime.setVisibility(0);
            SettingsItemView settingsItemView = this.mAlarmPushTime;
            settingsItemView.setInfo(this.alarmConfigV2.O00000oO + this.mMinute);
        } else {
            this.mAlarmPushTime.setVisibility(8);
        }
        this.mAlarmHumanOnly.setChecked(this.alarmConfigV2.O00000oo);
        this.mAlarmPush.setChecked(this.alarmConfigV2.O00000o);
        this.mAlarmMove.setChecked(this.alarmConfigV2.O0000Oo0);
        if (this.mAlarmPush.isChecked()) {
            this.mAlarmHumanOnly.setVisibility(0);
        } else {
            this.mAlarmHumanOnly.setVisibility(8);
        }
        String globalSettingServer = XmPluginHostApi.instance().getGlobalSettingServer();
        if (!TextUtils.isEmpty(globalSettingServer) && "cn".equals(globalSettingServer)) {
            this.mAlarmMove.setVisibility(0);
        }
        int i = this.mLevel;
        if (i == 0) {
            this.mAlarmLevel.setInfo(getString(R.string.alarm_level_low));
        } else if (i == 1) {
            this.mAlarmLevel.setInfo(getString(R.string.alarm_level_high));
        }
    }

    public void finish() {
        super.finish();
        if (!this.mJump) {
            return;
        }
        if (clf.O00000oO()) {
            startActivity(new Intent(this, AlarmV2Activity.class));
            overridePendingTransition(0, 0);
            return;
        }
        startActivity(new Intent(this, AlarmActivity.class));
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("startTime");
            String stringExtra2 = intent.getStringExtra("endTime");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                cla cla = this.alarmConfigV2;
                cla.O00000Oo = stringExtra;
                cla.O00000o0 = stringExtra2;
                setMotionDetection(cla.f13985O000000o, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, this.alarmConfigV2.O0000Oo0);
            }
            refreshUI();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.settings_alarm_time) {
            chr.O000000o(chr.O000O0Oo);
            Intent intent = new Intent();
            intent.putExtra("startTime", this.alarmConfigV2.O00000Oo);
            intent.putExtra("endTime", this.alarmConfigV2.O00000o0);
            intent.setClass(this, AlarmDirectionTimeV2Activity.class);
            startActivityForResult(intent, 1001);
        } else if (id == R.id.settings_alarm_level) {
            chr.O000000o(chr.O00oOoOo);
            setLevel();
        } else if (id == R.id.settings_alarm_push_time) {
            chr.O000000o(chr.O000O0o0);
            showSetTime();
        }
    }

    private void showSetTime() {
        int i;
        cla cla = new cla();
        cla.O000000o(this.alarmConfigV2);
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
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
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$X8vQnnb3mLTuqkGsCoLm2Y3q78 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmSettingV2Activity.lambda$showSetTime$5(cla.this, dialogInterface, i);
            }
        });
        builder.O000000o((int) R.string.settings_alarm_push_time);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(cla) {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$IwvcT8GqusacpvKjgB70GWkjIh4 */
            private final /* synthetic */ cla f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmSettingV2Activity.this.lambda$showSetTime$6$AlarmSettingV2Activity(this.f$1, dialogInterface, i);
            }
        });
        builder.O00000oo();
    }

    static /* synthetic */ void lambda$showSetTime$5(cla cla, DialogInterface dialogInterface, int i) {
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                cla.O00000oO = 5;
            } else if (i == 2) {
                cla.O00000oO = 10;
                i2 = 3;
            } else if (i == 3) {
                cla.O00000oO = 30;
                i2 = 4;
            }
            chr.O000000o(chr.O00O0oo0, "type", Integer.valueOf(i2));
        }
        cla.O00000oO = 3;
        i2 = 1;
        chr.O000000o(chr.O00O0oo0, "type", Integer.valueOf(i2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    public /* synthetic */ void lambda$showSetTime$6$AlarmSettingV2Activity(cla cla, DialogInterface dialogInterface, int i) {
        int i2 = cla.O00000oO;
        if (i2 == 3) {
            chr.O000000o(chr.O000OO0o, "type", (Object) 1);
        } else if (i2 == 5) {
            chr.O000000o(chr.O000OO0o, "type", (Object) 2);
        } else if (i2 == 10) {
            chr.O000000o(chr.O000OO0o, "type", (Object) 3);
        } else if (i2 == 30) {
            chr.O000000o(chr.O000OO0o, "type", (Object) 4);
        }
        this.alarmConfigV2.O000000o(cla);
        setMotionDetection(this.alarmConfigV2.f13985O000000o, this.alarmConfigV2.O00000oO, this.alarmConfigV2.O00000Oo, this.alarmConfigV2.O00000o0, this.alarmConfigV2.O0000Oo0);
        refreshUI();
    }

    private void setLevel() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.alarm_level);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.file_setting_record_item, (ViewGroup) null);
        builder.O000000o(inflate);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$4TcRZHkJ0nVcqoHLYy0jJnaWiw */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmSettingV2Activity.this.lambda$setLevel$7$AlarmSettingV2Activity(dialogInterface, i);
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
        $$Lambda$AlarmSettingV2Activity$clIr2t7DWhQ0okU11Wa0kgW0eNU r8 = r0;
        TextView textView5 = textView4;
        View findViewById = inflate.findViewById(R.id.layout2);
        $$Lambda$AlarmSettingV2Activity$clIr2t7DWhQ0okU11Wa0kgW0eNU r0 = new View.OnClickListener(imageView2, textView2, textView4, imageView, textView, textView3) {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$clIr2t7DWhQ0okU11Wa0kgW0eNU */
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
                AlarmSettingV2Activity.this.lambda$setLevel$8$AlarmSettingV2Activity(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, view);
            }
        };
        findViewById.setOnClickListener(r8);
        inflate.findViewById(R.id.layout1).setOnClickListener(new View.OnClickListener(imageView, textView, textView3, imageView2, textView2, textView5) {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$6NR2fAeYBap6WI2mGIaKwDhB4k */
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
        });
        O00000o.show();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    public /* synthetic */ void lambda$setLevel$7$AlarmSettingV2Activity(DialogInterface dialogInterface, int i) {
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
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!AlarmSettingV2Activity.this.isFinishing()) {
                            AlarmSettingV2Activity.this.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$1$LBjL_Mkr0qS28l96MVy9xjD4ck4 */

                                public final void run() {
                                    AlarmSettingV2Activity.AnonymousClass1.this.lambda$onSuccess$0$AlarmSettingV2Activity$1();
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onSuccess$0$AlarmSettingV2Activity$1() {
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
        dialogInterface.dismiss();
    }

    public /* synthetic */ void lambda$setLevel$8$AlarmSettingV2Activity(ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, View view) {
        imageView.setVisibility(0);
        textView.setSelected(true);
        textView2.setSelected(true);
        imageView2.setVisibility(4);
        textView3.setSelected(false);
        textView4.setSelected(false);
        this.mLastLevel = 0;
    }

    public /* synthetic */ void lambda$setLevel$9$AlarmSettingV2Activity(ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, View view) {
        imageView.setVisibility(0);
        textView.setSelected(true);
        textView2.setSelected(true);
        imageView2.setVisibility(4);
        textView3.setSelected(false);
        textView4.setSelected(false);
        this.mLastLevel = 1;
    }

    public void getAlarmConfig() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            this.alarmManagerV2.O000000o(this.mCameraDevice.getModel(), jSONObject, new cld.O000000o() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass2 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.O0000OOo);
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
                        AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.O0000OOo);
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }
            });
        } catch (JSONException unused) {
            this.alarmConfigV2.O000000o(this.alarmManagerV2.O0000OOo);
            refreshUI();
        }
    }

    public void setHumanOnly(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
            cld cld = this.alarmManagerV2;
            String model = this.mCameraDevice.getModel();
            AnonymousClass3 r2 = new cld.O000000o() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass3 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.O0000OOo);
                        AlarmSettingV2Activity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmSettingV2Activity$3$5BdMtLm2OzdpxZ3o1x0JJGR3QN8 */

                            public final void run() {
                                AlarmSettingV2Activity.AnonymousClass3.this.lambda$onSuccess$0$AlarmSettingV2Activity$3();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$AlarmSettingV2Activity$3() {
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
                    /* class _m_j.cld.AnonymousClass7 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ JSONObject f14017O000000o;
                    final /* synthetic */ O000000o O00000Oo;

                    {
                        this.f14017O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            civ.O000000o("AlarmManager", "jsonObject:" + jSONObject.toString());
                            if (jSONObject.optInt("code") == 0) {
                                cld.this.O0000OOo.O00000oo = this.f14017O000000o.optBoolean("open");
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
                        civ.O00000o0("AlarmManager", "putHumanDetectionPush i:" + i + " s:" + str);
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
            cld cld = this.alarmManagerV2;
            String model = this.mCameraDevice.getModel();
            AnonymousClass4 r6 = new cld.O000000o() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass4 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.O0000OOo);
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.mAlarmItem.setChecked(AlarmSettingV2Activity.this.alarmConfigV2.f13985O000000o);
                        AlarmSettingV2Activity.this.refreshUI();
                    }
                }
            };
            if (!TextUtils.isEmpty(model)) {
                gsy.O00000Oo("AlarmManager", "params 1:" + jSONObject.toString());
                clf.O000000o().O00000o0(model, jSONObject.toString(), new Callback<JSONObject>(jSONObject, r6) {
                    /* class _m_j.cld.AnonymousClass5 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ JSONObject f14015O000000o;
                    final /* synthetic */ O000000o O00000Oo;

                    {
                        this.f14015O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            gsy.O00000Oo("AlarmManager", "params 2:" + jSONObject.toString());
                            if (jSONObject.optInt("code") == 0) {
                                cld.this.O0000OOo.f13985O000000o = this.f14015O000000o.optBoolean("open");
                                cld.this.O0000OOo.O00000oO = this.f14015O000000o.optInt("interval");
                                cld.this.O0000OOo.O0000Oo0 = this.f14015O000000o.optBoolean("trackSwitch");
                                String optString = this.f14015O000000o.optString("startTime");
                                if (!TextUtils.isEmpty(optString)) {
                                    mj.O000000o();
                                    String O00000Oo2 = mj.O00000Oo(optString);
                                    if (!TextUtils.isEmpty(O00000Oo2)) {
                                        cld.this.O0000OOo.O00000Oo = O00000Oo2;
                                    } else {
                                        cld.this.O0000OOo.O00000Oo = optString;
                                    }
                                } else {
                                    cld.this.O0000OOo.O00000Oo = "00:00:00";
                                }
                                String optString2 = this.f14015O000000o.optString("endTime");
                                if (!TextUtils.isEmpty(optString2)) {
                                    mj.O000000o();
                                    String O00000Oo3 = mj.O00000Oo(optString2);
                                    if (!TextUtils.isEmpty(O00000Oo3)) {
                                        cld.this.O0000OOo.O00000o0 = O00000Oo3;
                                    } else {
                                        cld.this.O0000OOo.O00000o0 = optString2;
                                    }
                                } else {
                                    cld.this.O0000OOo.O00000o0 = "23:59:59";
                                }
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
                        PrintStream printStream = System.out;
                        printStream.println("mytest:setAlarmConfig i:" + i + " s:" + str);
                        civ.O00000o0("AlarmManager", "setAlarmConfig i:" + i + " s:" + str);
                        O000000o o000000o = this.O00000Oo;
                        if (o000000o != null) {
                            o000000o.onFailure(i, str);
                        }
                    }
                });
            }
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
            cld cld = this.alarmManagerV2;
            String model = this.mCameraDevice.getModel();
            AnonymousClass5 r2 = new cld.O000000o() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass5 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.alarmConfigV2.O000000o(AlarmSettingV2Activity.this.alarmManagerV2.O0000OOo);
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
                    /* class _m_j.cld.AnonymousClass6 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ JSONObject f14016O000000o;
                    final /* synthetic */ O000000o O00000Oo;

                    {
                        this.f14016O000000o = r2;
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
                            cld.this.O0000OOo.O00000o = this.f14016O000000o.optBoolean("open");
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
                        civ.O00000o0("AlarmManager", "putPush i:" + i + " s:" + str);
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
        if (this.alarmConfigV2.O00000Oo.equals("00:00:00") && (this.alarmConfigV2.O00000o0.equals("23:59:59") || this.alarmConfigV2.O00000o0.equals("23:59:00"))) {
            return getString(R.string.alarm_time_all);
        }
        if (this.alarmConfigV2.O00000Oo.equals("08:00:00") && this.alarmConfigV2.O00000o0.equals("20:00:00")) {
            return getString(R.string.alarm_time_day);
        }
        if (!this.alarmConfigV2.O00000Oo.equals("20:00:00") || !this.alarmConfigV2.O00000o0.equals("08:00:00")) {
            return getString(R.string.alarm_time_user);
        }
        return getString(R.string.alarm_time_night);
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

    public void initWxStatus() {
        String globalSettingServer = XmPluginHostApi.instance().getGlobalSettingServer();
        boolean z = !TextUtils.isEmpty(globalSettingServer) && globalSettingServer.toLowerCase().equals("cn");
        if (XmPluginHostApi.instance().getApiLevel() >= 75 && z && this.mDeviceStat != null && this.mCameraDevice.isOwner()) {
            this.mWxPush.setVisibility(0);
            iaj.O000000o().O000000o(this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), new Callback<Boolean>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass6 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Boolean bool) {
                    if (!AlarmSettingV2Activity.this.isFinishing()) {
                        AlarmSettingV2Activity.this.wxPushRefresh(bool.booleanValue());
                    }
                }
            });
        }
    }

    private void setWxPush(final boolean z) {
        iaj.O000000o().O000000o(this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), z, new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass7 */

            public void onSuccess(Boolean bool) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
                    AlarmSettingV2Activity.this.wxPushRefresh(z);
                    gqg.O000000o((int) R.string.smb_tip_set_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                    AlarmSettingV2Activity.this.initWxStatus();
                }
            }
        });
    }

    private void changeWxPush(final boolean z) {
        if (!z) {
            setWxPush(false);
            return;
        }
        this.mWxPush.setEnabled(false);
        iaj.O000000o().O000000o(this, this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), z, 1005, new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.AnonymousClass8 */

            public void onSuccess(Boolean bool) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
                    AlarmSettingV2Activity.this.wxPushRefresh(z);
                    gqg.O000000o((int) R.string.smb_tip_set_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSettingV2Activity.this.isFinishing()) {
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
