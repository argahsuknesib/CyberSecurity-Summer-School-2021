package com.xiaomi.mico.setting.alarm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.AlarmCircle;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.AlarmEditTitleBar;
import com.xiaomi.mico.common.widget.AlarmSettingItem;
import com.xiaomi.mico.common.widget.AlarmTimePicker;
import com.xiaomi.mico.common.widget.dialog.InputViewDialog;
import com.xiaomi.mico.setting.alarm.ring.AlarmRingActivity;
import com.xiaomi.smarthome.R;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class AlarmSettingActivity extends MicoBaseActivity {
    private static String ALARM_TYPE = "alarm_type";
    private static String ALARM_TYPE_RING = "alarm_select_ring";
    private Remote.Response.Alarm alarm;
    private Remote.Response.AlarmRing alarmRing;
    private MicoAlarm alarmType;
    AlarmSettingItem commentItem;
    private int cycle;
    private String event;
    private String extra;
    AlarmSettingItem repeatItem;
    AlarmSettingItem ringItem;
    AlarmTimePicker timePicker;
    private long timestamp;
    AlarmEditTitleBar titleBar;
    private int volume;
    AlarmSettingItem volumeItem;

    public boolean isDarkMode() {
        return true;
    }

    public static Intent buildIntent(Context context, String str) {
        Intent intent = new Intent(context, AlarmSettingActivity.class);
        intent.putExtra(ALARM_TYPE, str);
        return intent;
    }

    public static Intent buildIntent(Context context, String str, boolean z) {
        Intent intent = new Intent(context, AlarmSettingActivity.class);
        intent.putExtra(ALARM_TYPE, str);
        intent.putExtra(ALARM_TYPE_RING, z);
        return intent;
    }

    public static Intent buildIntent(Context context, Remote.Response.Alarm alarm2) {
        Intent intent = new Intent(context, AlarmSettingActivity.class);
        intent.putExtra("data", alarm2);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_alarm_setting);
        this.titleBar = (AlarmEditTitleBar) findViewById(R.id.alarm_setting_title_bar);
        this.repeatItem = (AlarmSettingItem) findViewById(R.id.item_repeat);
        this.repeatItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmSettingActivity$kLJ6Jggx8rQ6vcWj6WDX8bzZPEs */

            public final void onClick(View view) {
                AlarmSettingActivity.this.lambda$onCreate$0$AlarmSettingActivity(view);
            }
        });
        this.ringItem = (AlarmSettingItem) findViewById(R.id.item_ring);
        this.ringItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmSettingActivity$YQ0dmmn0M3qAWRz2j06BID0TXT0 */

            public final void onClick(View view) {
                AlarmSettingActivity.this.lambda$onCreate$1$AlarmSettingActivity(view);
            }
        });
        this.commentItem = (AlarmSettingItem) findViewById(R.id.item_comment);
        this.commentItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmSettingActivity$M0MZyAv_1f6YjpXU6tACdYh37q4 */

            public final void onClick(View view) {
                AlarmSettingActivity.this.lambda$onCreate$2$AlarmSettingActivity(view);
            }
        });
        this.timePicker = (AlarmTimePicker) findViewById(R.id.time_picker);
        this.titleBar.setOnLeftButtonClickListener(new AlarmEditTitleBar.OnLeftButtonClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$Xz9LjzxCxJjjFznOa2Nt1blMUus */

            public final void onLeftButtonClick() {
                AlarmSettingActivity.this.onBackPressed();
            }
        });
        this.titleBar.setOnRightButtonClickListener(new AlarmEditTitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmSettingActivity$_9_YPQ6bojUPmYw8__k3NW3xvmE */

            public final void onRightButtonClick() {
                AlarmSettingActivity.this.lambda$onCreate$3$AlarmSettingActivity();
            }
        });
        this.timePicker.setOnTimeChangedListener(new AlarmTimePicker.OnTimeChangedListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmSettingActivity$d58qTQvWAXMIuf1t4coGrf9SLw */

            public final void onTimeChanged(AlarmTimePicker alarmTimePicker, int i, int i2) {
                AlarmSettingActivity.this.lambda$onCreate$4$AlarmSettingActivity(alarmTimePicker, i, i2);
            }
        });
        if (getIntent() == null || !getIntent().hasExtra("data")) {
            this.alarm = new Remote.Response.Alarm();
            this.volume = MicoManager.getInstance().getCurrentMico().getHardwareType().getAlarmVolume();
            this.cycle = AlarmCircle.ONCE.getCircle();
            this.timestamp = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5);
            this.alarmType = MicoAlarm.valueOfType(getIntent().getStringExtra(ALARM_TYPE));
            this.alarmRing = getDefaulAlarmtRing(this.alarmType);
            if (this.alarmRing == null) {
                this.alarmRing = AlarmHelper.getSystemAlarmRing();
                this.alarmType = MicoAlarm.valueOfType("音乐");
            }
        } else {
            this.alarm = (Remote.Response.Alarm) getIntent().getSerializableExtra("data");
            this.timestamp = this.alarm.timestamp;
            this.cycle = this.alarm.circle;
            this.extra = this.alarm.extra;
            this.volume = this.alarm.volume;
            this.event = this.alarm.event;
            this.alarmRing = AlarmHelper.getAlarmRing(this.alarm);
            this.alarmType = MicoAlarm.valueOfType(AlarmHelper.getAlarmRingType(this.alarmRing));
            if (!TextUtils.isEmpty(this.alarm.event)) {
                this.commentItem.setDescription(this.event);
            }
        }
        setTimePickerCurrentTime(this.timestamp);
        this.titleBar.setAlarmEditType(this.alarmType);
        int i = this.volume;
        if (i > 0) {
            this.volumeItem.setProgress(i);
        } else {
            this.volumeItem.setVisibility(8);
        }
        setRepeatItemDesc();
        setRingItemDesc(this.alarmRing);
        loadData();
    }

    public /* synthetic */ void lambda$onCreate$4$AlarmSettingActivity(AlarmTimePicker alarmTimePicker, int i, int i2) {
        this.timestamp = calculateTimeStamp();
        if (this.cycle == AlarmCircle.ONCE.getCircle()) {
            setRepeatItemDesc();
        }
    }

    /* renamed from: com.xiaomi.mico.setting.alarm.AlarmSettingActivity$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$mico$setting$alarm$MicoAlarm = new int[MicoAlarm.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$xiaomi$mico$setting$alarm$MicoAlarm[MicoAlarm.SYSTEM.ordinal()] = 1;
            $SwitchMap$com$xiaomi$mico$setting$alarm$MicoAlarm[MicoAlarm.MUSIC.ordinal()] = 2;
            $SwitchMap$com$xiaomi$mico$setting$alarm$MicoAlarm[MicoAlarm.NATURE.ordinal()] = 3;
            $SwitchMap$com$xiaomi$mico$setting$alarm$MicoAlarm[MicoAlarm.FUN.ordinal()] = 4;
            $SwitchMap$com$xiaomi$mico$setting$alarm$MicoAlarm[MicoAlarm.VIDEO.ordinal()] = 5;
        }
    }

    private Remote.Response.AlarmRing getDefaulAlarmtRing(MicoAlarm micoAlarm) {
        int i = AnonymousClass2.$SwitchMap$com$xiaomi$mico$setting$alarm$MicoAlarm[micoAlarm.ordinal()];
        if (i == 1) {
            return AlarmHelper.getSystemAlarmRing();
        }
        if (i == 2) {
            return AlarmHelper.getMusicAlarmDefaultRing();
        }
        if (i == 3) {
            return AlarmHelper.getNatureAlarmDefaultRing();
        }
        if (i == 4) {
            return AlarmHelper.getFunAlarmDefaultRing();
        }
        if (i != 5) {
            return AlarmHelper.getSystemAlarmRing();
        }
        return AlarmHelper.getVideoAlarmDefaultRing();
    }

    private void setRepeatItemDesc() {
        if (this.cycle == AlarmCircle.ONCE.getCircle() && this.timestamp > 0) {
            this.repeatItem.setDescription(AlarmHelper.formatAlarmDateTime(getContext(), this.timestamp));
        } else if (this.cycle != AlarmCircle.CUSTOM.getCircle() || TextUtils.isEmpty(this.extra)) {
            this.repeatItem.setDescription(getRepeatOptionStr(AlarmCircle.circle2index(this.cycle, 2)));
        } else {
            this.repeatItem.setDescription(getString(R.string.weekly, new Object[]{AlarmHelper.getCustomRepeatStr(getContext(), this.extra)}));
        }
    }

    private void setRingItemDesc(Remote.Response.AlarmRing alarmRing2) {
        MicoAlarm micoAlarm = this.alarmType;
        if (micoAlarm != null) {
            String string = getString(micoAlarm.nameId);
            if (!TextUtils.isEmpty(alarmRing2.name)) {
                string = string + " - " + alarmRing2.name;
            }
            this.ringItem.setDescription(string);
        }
    }

    private void setTimePickerCurrentTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        this.timePicker.setCurrentHour(Integer.valueOf(instance.get(11)));
        this.timePicker.setCurrentMinute(Integer.valueOf(instance.get(12)));
    }

    private String getRepeatOptionStr(int i) {
        String[] alarmRepeatOption = getAlarmRepeatOption();
        return (i < 0 || i >= alarmRepeatOption.length) ? "" : alarmRepeatOption[i];
    }

    private String[] getAlarmRepeatOption() {
        return getResources().getStringArray(R.array.alarm_repeat_option_v2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: onClick */
    public void lambda$onCreate$2$AlarmSettingActivity(View view) {
        int id = view.getId();
        if (id == R.id.item_repeat) {
            startActivityForResult(AlarmRepeatActivity.buildIntent(getContext(), this.cycle, this.extra, this.timestamp), 100);
        } else if (id == R.id.item_ring) {
            startActivityForResult(AlarmRingActivity.buildIntent(getContext(), this.alarmRing), 200);
        } else if (id == R.id.item_comment) {
            onCommentSettingClick();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Remote.Response.AlarmRing alarmRing2;
        if (i == 100 && i2 == -1) {
            this.cycle = intent.getIntExtra("cycle", 0);
            String stringExtra = intent.getStringExtra("extra");
            long longExtra = intent.getLongExtra("timestamp", -1);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.extra = stringExtra;
            }
            if (this.timestamp > 0) {
                this.timestamp = longExtra;
            }
            setRepeatItemDesc();
        } else if (i == 200 && i2 == -1 && (alarmRing2 = (Remote.Response.AlarmRing) intent.getSerializableExtra("CURRENT_RING")) != null) {
            this.alarmRing = alarmRing2;
            this.alarmType = MicoAlarm.valueOfType(AlarmHelper.getAlarmRingType(alarmRing2));
            this.titleBar.setAlarmEditType(this.alarmType);
            setRingItemDesc(alarmRing2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: saveAlarm */
    public void lambda$onCreate$3$AlarmSettingActivity() {
        Remote.Response.Alarm alarm2 = this.alarm;
        if (alarm2 != null) {
            alarm2.timestamp = this.timestamp;
            alarm2.circle = this.cycle;
            alarm2.extra = this.extra;
            alarm2.event = this.event;
            alarm2.volume = this.volumeItem.getProgress();
            if (this.alarmRing != null) {
                if (this.alarmType == MicoAlarm.VIDEO) {
                    this.alarm.ringToneVideo = this.alarmRing.video;
                    if (!TextUtils.isEmpty(this.alarmRing.videoImage)) {
                        this.alarm.ringToneVideoImage = this.alarmRing.videoImage;
                    }
                    this.alarm.ringToneQuery = null;
                } else {
                    Remote.Response.Alarm alarm3 = this.alarm;
                    alarm3.ringToneVideo = null;
                    alarm3.ringToneVideoImage = null;
                    alarm3.ringToneQuery = this.alarmRing.query;
                }
                this.alarm.ringToneType = this.alarmRing.id;
                if (!TextUtils.isEmpty(this.alarmRing.name)) {
                    this.alarm.displayTxt = Uri.encode(this.alarmRing.name);
                }
            }
            this.alarm.timeReminder = buildTimeReminder(this.timestamp, this.event);
            showProgressDialog(null);
            ApiHelper.createOrUpdateAlarmV2(this.alarm, new ApiRequest.Listener<Remote.Response.NullInfo>() {
                /* class com.xiaomi.mico.setting.alarm.AlarmSettingActivity.AnonymousClass1 */

                public void onSuccess(Remote.Response.NullInfo nullInfo) {
                    AlarmSettingActivity.this.dismissProgressDialog();
                    ToastUtil.showToast((int) R.string.alarm_save_success, 0);
                    AlarmSettingActivity.this.finish();
                }

                public void onFailure(ApiError apiError) {
                    AlarmSettingActivity.this.dismissProgressDialog();
                    ToastUtil.showToast((int) R.string.alarm_save_fail, 0);
                }
            });
        }
    }

    private void loadData() {
        AlarmHelper.loadConfig();
    }

    /* access modifiers changed from: package-private */
    public void onCommentSettingClick() {
        new InputViewDialog(this).setLengthUnit(1).setMaxInputLength(20).setMinInputLength(0).setTitle((int) R.string.tool_timer_comment).setInitText(!this.commentItem.getDescription().equals(getString(R.string.tool_timer_comment_hint)) ? this.commentItem.getDescription() : "").setListener(new InputViewDialog.Listener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmSettingActivity$kgXMHdWy8Wi8oBeMT76Jb6P3g24 */

            public final void onFinish(String str) {
                AlarmSettingActivity.this.lambda$onCommentSettingClick$5$AlarmSettingActivity(str);
            }
        }).show();
    }

    public /* synthetic */ void lambda$onCommentSettingClick$5$AlarmSettingActivity(String str) {
        this.commentItem.setDescription(str);
        this.event = str;
    }

    public long calculateTimeStamp() {
        int intValue = this.timePicker.getCurrentHour().intValue();
        int intValue2 = this.timePicker.getCurrentMinute().intValue();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.timestamp);
        instance.set(11, intValue);
        instance.set(12, intValue2);
        instance.set(13, 0);
        instance.set(14, 0);
        if (instance.getTimeInMillis() < System.currentTimeMillis()) {
            instance.setTimeInMillis(instance.getTimeInMillis() + 86400000);
        }
        return instance.getTimeInMillis();
    }

    private String buildTimeReminder(long j, String str) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (TextUtils.isEmpty(str)) {
            return getString(R.string.alarm_time_reminder, new Object[]{Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12))});
        }
        return getString(R.string.alarm_time_reminder_event, new Object[]{Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), str});
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
