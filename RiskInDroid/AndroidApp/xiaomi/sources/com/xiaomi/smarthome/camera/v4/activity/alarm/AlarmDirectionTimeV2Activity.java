package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.chr;
import _m_j.civ;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.HourNumberPicker;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import java.text.DecimalFormat;

public class AlarmDirectionTimeV2Activity extends CameraBaseActivity implements View.OnClickListener {
    public String endTime;
    private View mAllDayCheck;
    private View mCustomCheck;
    private TextView mCustomTitle;
    private View mDayCheck;
    private DecimalFormat mDf;
    private View mNightCheck;
    int mTimeHourBegin;
    int mTimeHourEnd;
    int mTimeMinuteBegin;
    int mTimeMinuteEnd;
    public String startTime;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_alarm_direction_time);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.alarm_direction_time);
        this.startTime = getIntent().getStringExtra("startTime");
        this.endTime = getIntent().getStringExtra("endTime");
        this.mDf = new DecimalFormat("00");
        initView();
    }

    private void initView() {
        findViewById(R.id.title_bar_more).setVisibility(8);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.time_all_day).setOnClickListener(this);
        findViewById(R.id.time_day).setOnClickListener(this);
        findViewById(R.id.time_night).setOnClickListener(this);
        findViewById(R.id.time_custom).setOnClickListener(this);
        this.mCustomTitle = (TextView) findViewById(R.id.time_custom_title);
        this.mAllDayCheck = findViewById(R.id.icon_all_day);
        this.mDayCheck = findViewById(R.id.icon_day);
        this.mNightCheck = findViewById(R.id.icon_night);
        this.mCustomCheck = findViewById(R.id.icon_custom);
        changeCheck();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.time_all_day) {
            chr.O000000o(chr.O000O0oo, "type", (Object) 1);
            this.startTime = "00:00:00";
            this.endTime = "23:59:59";
            changeCheck();
        } else if (id == R.id.time_day) {
            chr.O000000o(chr.O000O0oo, "type", (Object) 2);
            this.startTime = "08:00:00";
            this.endTime = "20:00:00";
            changeCheck();
        } else if (id == R.id.time_night) {
            chr.O000000o(chr.O000O0oo, "type", (Object) 3);
            this.startTime = "20:00:00";
            this.endTime = "08:00:00";
            changeCheck();
        } else if (id == R.id.time_custom) {
            chr.O000000o(chr.O000O0oo, "type", (Object) 4);
            customChoice();
        }
    }

    public void changeCheck() {
        this.mAllDayCheck.setVisibility(8);
        this.mDayCheck.setVisibility(8);
        this.mNightCheck.setVisibility(8);
        this.mCustomCheck.setVisibility(8);
        civ.O000000o("AlarmDirectionTimeV2Activity", "startTime:" + this.startTime + " endTime:" + this.endTime);
        if (!TextUtils.isEmpty(this.startTime) && !TextUtils.isEmpty(this.endTime)) {
            if ("00:00:00".equals(this.startTime) && ("23:59:59".equals(this.endTime) || this.endTime.contains("23:59"))) {
                this.mAllDayCheck.setVisibility(0);
                this.mCustomTitle.setText(getString(R.string.alarm_direction_custom_subtitle));
            } else if ("08:00:00".equals(this.startTime) && "20:00:00".equals(this.endTime)) {
                this.mDayCheck.setVisibility(0);
                this.mCustomTitle.setText(getString(R.string.alarm_direction_custom_subtitle));
            } else if (!"20:00:00".equals(this.startTime) || !"08:00:00".equals(this.endTime)) {
                this.mCustomCheck.setVisibility(0);
                this.mCustomTitle.setText(getString(R.string.alarm_direction_custom_title, new Object[]{this.startTime, this.endTime}));
            } else {
                this.mNightCheck.setVisibility(0);
                this.mCustomTitle.setText(getString(R.string.alarm_direction_custom_subtitle));
            }
        }
    }

    private void customChoice() {
        int i;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.alarm_direction_time_choose, (ViewGroup) null);
        builder.O000000o(inflate);
        HourNumberPicker hourNumberPicker = (HourNumberPicker) inflate.findViewById(R.id.number_picker_hour_begin);
        HourNumberPicker hourNumberPicker2 = (HourNumberPicker) inflate.findViewById(R.id.number_picker_hour_end);
        hourNumberPicker.setMinValue(0);
        hourNumberPicker.setMaxValue(143);
        hourNumberPicker2.setMinValue(6);
        hourNumberPicker2.setMaxValue(144);
        hourNumberPicker.setFormatter(HourNumberPicker.HOUR_MINUTE_DIGIT_FORMATTER);
        hourNumberPicker2.setFormatter(HourNumberPicker.HOUR_MINUTE_DIGIT_FORMATTER);
        this.mTimeHourBegin = Integer.valueOf(this.startTime.split(":")[0]).intValue();
        this.mTimeMinuteBegin = Integer.valueOf(this.startTime.split(":")[1]).intValue();
        this.mTimeHourEnd = Integer.valueOf(this.endTime.split(":")[0]).intValue();
        this.mTimeMinuteEnd = Integer.valueOf(this.endTime.split(":")[1]).intValue();
        hourNumberPicker.setValue(((this.mTimeHourBegin * 60) + this.mTimeMinuteBegin) / 10);
        int i2 = this.mTimeHourEnd;
        if (i2 == 23 && (i = this.mTimeMinuteEnd) == 59) {
            hourNumberPicker2.setValue((((i2 * 60) + i) + 1) / 10);
        } else {
            hourNumberPicker2.setValue(((this.mTimeHourEnd * 60) + this.mTimeMinuteEnd) / 10);
        }
        hourNumberPicker.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDirectionTimeV2Activity.AnonymousClass1 */

            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                int i3 = i2 / 6;
                int i4 = (i2 % 6) * 10;
                if (i3 == AlarmDirectionTimeV2Activity.this.mTimeHourEnd && i4 == AlarmDirectionTimeV2Activity.this.mTimeMinuteEnd) {
                    Button[] buttonArr = r5;
                    if (buttonArr[0] != null) {
                        buttonArr[0].setClickable(false);
                        r5[0].setTextColor(Color.rgb(200, 200, 200));
                    }
                } else {
                    Button[] buttonArr2 = r5;
                    if (buttonArr2[0] != null) {
                        buttonArr2[0].setClickable(true);
                        r5[0].setTextColor(r6[0]);
                    }
                }
                AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity = AlarmDirectionTimeV2Activity.this;
                alarmDirectionTimeV2Activity.mTimeHourBegin = i3;
                alarmDirectionTimeV2Activity.mTimeMinuteBegin = i4;
            }
        });
        hourNumberPicker2.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDirectionTimeV2Activity.AnonymousClass2 */

            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                int i3 = i2 / 6;
                int i4 = (i2 % 6) * 10;
                if (i3 == AlarmDirectionTimeV2Activity.this.mTimeHourBegin && i4 == AlarmDirectionTimeV2Activity.this.mTimeMinuteBegin) {
                    Button[] buttonArr = r5;
                    if (buttonArr[0] != null) {
                        buttonArr[0].setClickable(false);
                        r5[0].setTextColor(Color.rgb(200, 200, 200));
                    }
                } else {
                    Button[] buttonArr2 = r5;
                    if (buttonArr2[0] != null) {
                        buttonArr2[0].setClickable(true);
                        r5[0].setTextColor(r6[0]);
                    }
                }
                AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity = AlarmDirectionTimeV2Activity.this;
                alarmDirectionTimeV2Activity.mTimeHourEnd = i3;
                alarmDirectionTimeV2Activity.mTimeMinuteEnd = i4;
            }
        });
        builder.O000000o(getResources().getString(R.string.camera_sure), (DialogInterface.OnClickListener) null);
        builder.O00000Oo(getResources().getString(R.string.camera_cancel), (DialogInterface.OnClickListener) null);
        final MLAlertDialog O00000oo = builder.O00000oo();
        Button button = O00000oo.getButton(-1);
        final Button[] buttonArr = {button};
        final int[] iArr = {button.getCurrentTextColor()};
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDirectionTimeV2Activity.AnonymousClass3 */

            public void onClick(View view) {
                if (AlarmDirectionTimeV2Activity.this.mTimeHourBegin < 10) {
                    if (AlarmDirectionTimeV2Activity.this.mTimeMinuteBegin < 10) {
                        AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity = AlarmDirectionTimeV2Activity.this;
                        alarmDirectionTimeV2Activity.startTime = "0" + AlarmDirectionTimeV2Activity.this.mTimeHourBegin + ":0" + AlarmDirectionTimeV2Activity.this.mTimeMinuteBegin + ":00";
                    } else {
                        AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity2 = AlarmDirectionTimeV2Activity.this;
                        alarmDirectionTimeV2Activity2.startTime = "0" + AlarmDirectionTimeV2Activity.this.mTimeHourBegin + ":" + AlarmDirectionTimeV2Activity.this.mTimeMinuteBegin + ":00";
                    }
                } else if (AlarmDirectionTimeV2Activity.this.mTimeMinuteBegin < 10) {
                    AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity3 = AlarmDirectionTimeV2Activity.this;
                    alarmDirectionTimeV2Activity3.startTime = AlarmDirectionTimeV2Activity.this.mTimeHourBegin + ":0" + AlarmDirectionTimeV2Activity.this.mTimeMinuteBegin + ":00";
                } else {
                    AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity4 = AlarmDirectionTimeV2Activity.this;
                    alarmDirectionTimeV2Activity4.startTime = AlarmDirectionTimeV2Activity.this.mTimeHourBegin + ":" + AlarmDirectionTimeV2Activity.this.mTimeMinuteBegin + ":00";
                }
                if (AlarmDirectionTimeV2Activity.this.mTimeHourEnd < 10) {
                    if (AlarmDirectionTimeV2Activity.this.mTimeMinuteEnd < 10) {
                        AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity5 = AlarmDirectionTimeV2Activity.this;
                        alarmDirectionTimeV2Activity5.endTime = "0" + AlarmDirectionTimeV2Activity.this.mTimeHourEnd + ":0" + AlarmDirectionTimeV2Activity.this.mTimeMinuteEnd + ":00";
                    } else {
                        AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity6 = AlarmDirectionTimeV2Activity.this;
                        alarmDirectionTimeV2Activity6.endTime = "0" + AlarmDirectionTimeV2Activity.this.mTimeHourEnd + ":" + AlarmDirectionTimeV2Activity.this.mTimeMinuteEnd + ":00";
                    }
                } else if (AlarmDirectionTimeV2Activity.this.mTimeMinuteEnd < 10) {
                    AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity7 = AlarmDirectionTimeV2Activity.this;
                    alarmDirectionTimeV2Activity7.endTime = AlarmDirectionTimeV2Activity.this.mTimeHourEnd + ":0" + AlarmDirectionTimeV2Activity.this.mTimeMinuteEnd + ":00";
                } else {
                    AlarmDirectionTimeV2Activity alarmDirectionTimeV2Activity8 = AlarmDirectionTimeV2Activity.this;
                    alarmDirectionTimeV2Activity8.endTime = AlarmDirectionTimeV2Activity.this.mTimeHourEnd + ":" + AlarmDirectionTimeV2Activity.this.mTimeMinuteEnd + ":00";
                }
                AlarmDirectionTimeV2Activity.this.changeCheck();
                O00000oo.dismiss();
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("startTime", this.startTime);
        intent.putExtra("endTime", this.endTime);
        setResult(-1, intent);
        super.onBackPressed();
    }
}
