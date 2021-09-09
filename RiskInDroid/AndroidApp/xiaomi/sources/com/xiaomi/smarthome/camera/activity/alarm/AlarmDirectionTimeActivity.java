package com.xiaomi.smarthome.camera.activity.alarm;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.mijia.model.alarm.AlarmDirectionBean;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.HourNumberPicker;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import java.text.DecimalFormat;

public class AlarmDirectionTimeActivity extends CameraBaseActivity implements View.OnClickListener {
    private View mAllDayCheck;
    AlarmDirectionBean mBean;
    private View mCustomCheck;
    private TextView mCustomTitle;
    private View mDayCheck;
    private DecimalFormat mDf;
    private View mNightCheck;
    int mTimeHourBegin;
    int mTimeHourEnd;
    int mTimeMinuteBegin;
    int mTimeMinuteEnd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_direction_time);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.alarm_direction_time);
        this.mBean = (AlarmDirectionBean) getIntent().getParcelableExtra("data");
        if (this.mBean == null) {
            this.mBean = new AlarmDirectionBean();
        }
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
        if (this.mBean.f5240O000000o != 4) {
            this.mCustomTitle.setText(getString(R.string.alarm_direction_custom_subtitle));
        } else {
            this.mCustomTitle.setText(getString(R.string.alarm_direction_custom_title, new Object[]{this.mDf.format((long) (this.mBean.O00000Oo / 60)) + ":" + this.mDf.format((long) (this.mBean.O00000Oo % 60)), this.mDf.format((long) (this.mBean.O00000o0 / 60)) + ":" + this.mDf.format((long) (this.mBean.O00000o0 % 60))}));
        }
        changeCheck();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.time_all_day) {
            this.mBean.f5240O000000o = 1;
            changeCheck();
        } else if (id == R.id.time_day) {
            this.mBean.f5240O000000o = 2;
            changeCheck();
        } else if (id == R.id.time_night) {
            this.mBean.f5240O000000o = 3;
            changeCheck();
        } else if (id == R.id.time_custom) {
            customChoice();
        }
    }

    public void changeCheck() {
        this.mAllDayCheck.setVisibility(8);
        this.mDayCheck.setVisibility(8);
        this.mNightCheck.setVisibility(8);
        this.mCustomCheck.setVisibility(8);
        int i = this.mBean.f5240O000000o;
        if (i == 1) {
            this.mAllDayCheck.setVisibility(0);
        } else if (i == 2) {
            this.mDayCheck.setVisibility(0);
        } else if (i == 3) {
            this.mNightCheck.setVisibility(0);
        } else if (i == 4) {
            this.mCustomCheck.setVisibility(0);
            this.mCustomTitle.setText(getString(R.string.alarm_direction_custom_title, new Object[]{this.mDf.format((long) (this.mBean.O00000Oo / 60)) + ":" + this.mDf.format((long) (this.mBean.O00000Oo % 60)), this.mDf.format((long) (this.mBean.O00000o0 / 60)) + ":" + this.mDf.format((long) (this.mBean.O00000o0 % 60))}));
        }
    }

    private void customChoice() {
        int i;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.camera_alarm_direction_time_choose, (ViewGroup) null);
        builder.O000000o(inflate);
        HourNumberPicker hourNumberPicker = (HourNumberPicker) inflate.findViewById(R.id.number_picker_hour_begin);
        HourNumberPicker hourNumberPicker2 = (HourNumberPicker) inflate.findViewById(R.id.number_picker_hour_end);
        hourNumberPicker.setMinValue(0);
        hourNumberPicker.setMaxValue(143);
        hourNumberPicker2.setMinValue(6);
        hourNumberPicker2.setMaxValue(144);
        hourNumberPicker.setFormatter(HourNumberPicker.HOUR_MINUTE_DIGIT_FORMATTER);
        hourNumberPicker2.setFormatter(HourNumberPicker.HOUR_MINUTE_DIGIT_FORMATTER);
        this.mTimeHourBegin = this.mBean.O00000Oo / 60;
        this.mTimeMinuteBegin = this.mBean.O00000Oo % 60;
        this.mTimeHourEnd = this.mBean.O00000o0 / 60;
        this.mTimeMinuteEnd = this.mBean.O00000o0 % 60;
        hourNumberPicker.setValue(((this.mTimeHourBegin * 60) + this.mTimeMinuteBegin) / 10);
        int i2 = this.mTimeHourEnd;
        if (i2 == 23 && (i = this.mTimeMinuteEnd) == 59) {
            hourNumberPicker2.setValue((((i2 * 60) + i) + 1) / 10);
        } else {
            hourNumberPicker2.setValue(((this.mTimeHourEnd * 60) + this.mTimeMinuteEnd) / 10);
        }
        hourNumberPicker.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDirectionTimeActivity.AnonymousClass1 */

            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                int i3 = i2 / 6;
                int i4 = (i2 % 6) * 10;
                if (i3 == AlarmDirectionTimeActivity.this.mTimeHourEnd && i4 == AlarmDirectionTimeActivity.this.mTimeMinuteEnd) {
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
                AlarmDirectionTimeActivity alarmDirectionTimeActivity = AlarmDirectionTimeActivity.this;
                alarmDirectionTimeActivity.mTimeHourBegin = i3;
                alarmDirectionTimeActivity.mTimeMinuteBegin = i4;
            }
        });
        hourNumberPicker2.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDirectionTimeActivity.AnonymousClass2 */

            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                int i3 = i2 / 6;
                int i4 = (i2 % 6) * 10;
                if (i3 == AlarmDirectionTimeActivity.this.mTimeHourBegin && i4 == AlarmDirectionTimeActivity.this.mTimeMinuteBegin) {
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
                AlarmDirectionTimeActivity alarmDirectionTimeActivity = AlarmDirectionTimeActivity.this;
                alarmDirectionTimeActivity.mTimeHourEnd = i3;
                alarmDirectionTimeActivity.mTimeMinuteEnd = i4;
            }
        });
        builder.O000000o(getResources().getString(R.string.camera_sure), (DialogInterface.OnClickListener) null);
        builder.O00000Oo(getResources().getString(R.string.camera_cancel), (DialogInterface.OnClickListener) null);
        final MLAlertDialog O00000oo = builder.O00000oo();
        Button button = O00000oo.getButton(-1);
        final Button[] buttonArr = {button};
        final int[] iArr = {button.getCurrentTextColor()};
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDirectionTimeActivity.AnonymousClass3 */

            public void onClick(View view) {
                AlarmDirectionTimeActivity.this.mBean.O00000Oo = (AlarmDirectionTimeActivity.this.mTimeHourBegin * 60) + AlarmDirectionTimeActivity.this.mTimeMinuteBegin;
                AlarmDirectionTimeActivity.this.mBean.O00000o0 = (AlarmDirectionTimeActivity.this.mTimeHourEnd * 60) + AlarmDirectionTimeActivity.this.mTimeMinuteEnd;
                AlarmDirectionTimeActivity.this.mBean.f5240O000000o = 4;
                AlarmDirectionTimeActivity.this.changeCheck();
                O00000oo.dismiss();
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data", this.mBean);
        setResult(-1, intent);
        super.onBackPressed();
    }
}
