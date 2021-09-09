package com.xiaomi.smarthome.camera.lowpower.timerange;

import _m_j.gnp;
import _m_j.gsy;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.lowpower.entity.EffectiveTimeSpan;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class CreateTimeEdit2Activity extends BaseActivity implements View.OnClickListener {
    private EffectiveTimeSpan effectiveTimeSpan;
    private int flag = 0;
    private boolean isAllday;
    ImageView mConfirmView;
    TextView mExecuteFrom;
    TimePicker mExecuteFromPicker;
    TextView mExecuteFromTitle;
    TextView mExecuteTo;
    TimePicker mExecuteToPicker;
    TextView mExecuteToTitle;
    SwitchButton mIsAlldaySwitch;
    public int mOffsetHours = 0;
    private String[] mRepeatArray;
    TextView mRepeatDayHint;
    public boolean mRepeatTrigger;
    private EffectiveTimeSpan mTempTimeSpan;
    TextView mTitleView;
    public boolean[] mTriggerDays = new boolean[7];

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_camera_create_time_edit2);
        ButterKnife.bind(this);
        this.effectiveTimeSpan = (EffectiveTimeSpan) getIntent().getParcelableExtra("time_span");
        if (this.effectiveTimeSpan == null) {
            this.effectiveTimeSpan = new EffectiveTimeSpan();
        }
        this.mTempTimeSpan = new EffectiveTimeSpan();
        this.mRepeatArray = new String[]{getString(R.string.smarthome_scene_timer_everyday), getString(R.string.smarthome_scene_timer_workday), getString(R.string.smarthome_scene_custom)};
        findViews();
        initSceneTimer();
        initView();
        initTitle();
    }

    private void findViews() {
        this.mTitleView = (TextView) findViewById(R.id.module_a_3_return_title);
        this.mConfirmView = (ImageView) findViewById(R.id.module_a_3_right_btn);
        this.mRepeatDayHint = (TextView) findViewById(R.id.smarthome_scene_timer_day_hint);
        this.mIsAlldaySwitch = (SwitchButton) findViewById(R.id.all_day_switch);
        this.mExecuteFromTitle = (TextView) findViewById(R.id.execute_from_title);
        this.mExecuteFrom = (TextView) findViewById(R.id.execute_from_hint);
        this.mExecuteTo = (TextView) findViewById(R.id.execute_to_hint);
        this.mExecuteToTitle = (TextView) findViewById(R.id.execute_to_title);
        this.mExecuteFromPicker = (TimePicker) findViewById(R.id.execute_from_picker);
        this.mExecuteToPicker = (TimePicker) findViewById(R.id.execute_to_picker);
    }

    public void onBackPressed() {
        backConfig();
    }

    @OnClick({7504, 7511, 7794, 6922, 6926})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            backConfig();
        } else if (id == R.id.module_a_3_right_btn) {
            saveTimerSettings();
        } else if (id == R.id.repeat_setting) {
            showDayOptions();
        } else if (id == R.id.execute_from_layout) {
            if (!this.mIsAlldaySwitch.isChecked()) {
                if (this.mExecuteFromPicker.getVisibility() == 0) {
                    this.mExecuteFromPicker.setVisibility(8);
                } else {
                    this.mExecuteFromPicker.setVisibility(0);
                }
                this.mExecuteToPicker.setVisibility(8);
            }
        } else if (id == R.id.execute_to_layout && !this.mIsAlldaySwitch.isChecked()) {
            if (this.mExecuteToPicker.getVisibility() == 0) {
                this.mExecuteToPicker.setVisibility(8);
            } else {
                this.mExecuteToPicker.setVisibility(0);
            }
            this.mExecuteFromPicker.setVisibility(8);
        }
    }

    private void initTitle() {
        this.mTitleView.setText((int) R.string.smarthome_scene_effective_timer_title);
        this.mConfirmView.setVisibility(0);
        this.mConfirmView.setImageResource(R.drawable.title_right_tick_drawable);
    }

    public void setTimerPikerUsable(boolean z) {
        if (z) {
            this.mExecuteFromPicker.setCurrentHour(0);
            this.mExecuteFromPicker.setCurrentMinute(0);
            this.mExecuteToPicker.setCurrentHour(0);
            this.mExecuteToPicker.setCurrentMinute(0);
            this.mExecuteFromPicker.setVisibility(8);
            this.mExecuteToPicker.setVisibility(8);
            showNextTriggerHint(this.mOffsetHours);
            this.mExecuteFromTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_gray_normal));
            this.mExecuteToTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_gray_normal));
            return;
        }
        this.mExecuteFromTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_black_100_transparent));
        this.mExecuteToTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_black_100_transparent));
    }

    private void initView() {
        this.mIsAlldaySwitch.setChecked(this.isAllday);
        setTimerPikerUsable(this.isAllday);
        this.mIsAlldaySwitch.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CreateTimeEdit2Activity.this.mIsAlldaySwitch.setChecked(z);
                CreateTimeEdit2Activity.this.setTimerPikerUsable(z);
            }
        });
        generateShortcutDaysHint();
        this.mOffsetHours = (int) TimeUnit.HOURS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        this.mExecuteFromPicker.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass2 */

            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                CreateTimeEdit2Activity createTimeEdit2Activity = CreateTimeEdit2Activity.this;
                createTimeEdit2Activity.showNextTriggerHint(createTimeEdit2Activity.mOffsetHours);
            }
        });
        this.mExecuteToPicker.setIs24HourView(Boolean.TRUE);
        this.mExecuteToPicker.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass3 */

            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                CreateTimeEdit2Activity createTimeEdit2Activity = CreateTimeEdit2Activity.this;
                createTimeEdit2Activity.showNextTriggerHint(createTimeEdit2Activity.mOffsetHours);
            }
        });
        if (this.mIsAlldaySwitch.isChecked()) {
            this.mExecuteFromPicker.setCurrentHour(0);
            this.mExecuteFromPicker.setCurrentMinute(0);
            this.mExecuteToPicker.setCurrentHour(0);
            this.mExecuteToPicker.setCurrentMinute(0);
            return;
        }
        showNextTriggerHint(this.mOffsetHours);
    }

    private void backConfig() {
        if (this.mTempTimeSpan == null) {
            finish();
        }
        int intValue = this.mExecuteFromPicker.getCurrentHour().intValue();
        int intValue2 = this.mExecuteFromPicker.getCurrentMinute().intValue();
        int intValue3 = this.mExecuteToPicker.getCurrentHour().intValue();
        int intValue4 = this.mExecuteToPicker.getCurrentMinute().intValue();
        int convert = (int) TimeUnit.HOURS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        EffectiveTimeSpan effectiveTimeSpan2 = this.mTempTimeSpan;
        effectiveTimeSpan2.fromHour = (((intValue - convert) + 8) + 24) % 24;
        effectiveTimeSpan2.fromMin = intValue2;
        effectiveTimeSpan2.toHour = (((intValue3 - convert) + 8) + 24) % 24;
        effectiveTimeSpan2.toMin = intValue4;
        if (this.mRepeatTrigger) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 7; i++) {
                if (this.mTriggerDays[i]) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            this.mTempTimeSpan.wDay = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.mTempTimeSpan.wDay[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
        }
        if (this.mTempTimeSpan.isEqual(this.effectiveTimeSpan)) {
            finish();
        } else {
            new MLAlertDialog.Builder(this).O00000Oo((int) R.string.smarthome_scene_quit).O000000o((int) R.string.smarthome_scene_quest_ok, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass5 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    CreateTimeEdit2Activity.this.finish();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).O00000oo();
        }
    }

    private void saveTimerSettings() {
        int intValue = this.mExecuteFromPicker.getCurrentHour().intValue();
        int intValue2 = this.mExecuteFromPicker.getCurrentMinute().intValue();
        int intValue3 = this.mExecuteToPicker.getCurrentHour().intValue();
        int intValue4 = this.mExecuteToPicker.getCurrentMinute().intValue();
        TimeZone timeZone = new GregorianCalendar().getTimeZone();
        EffectiveTimeSpan effectiveTimeSpan2 = this.effectiveTimeSpan;
        effectiveTimeSpan2.fromHour = intValue;
        effectiveTimeSpan2.fromMin = intValue2;
        effectiveTimeSpan2.toHour = intValue3;
        effectiveTimeSpan2.toMin = intValue4;
        if (this.mRepeatTrigger) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 7; i++) {
                if (this.mTriggerDays[i]) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            this.effectiveTimeSpan.wDay = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.effectiveTimeSpan.wDay[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
        }
        this.effectiveTimeSpan.timezone = timeZone.getID();
        Intent intent = new Intent();
        intent.putExtra("time_span", this.effectiveTimeSpan);
        setResult(-1, intent);
        finish();
    }

    private void showDayOptions() {
        int i = 0;
        this.flag = 0;
        for (int i2 = 0; i2 < 7; i2++) {
            this.flag <<= 1;
            if (this.mTriggerDays[i2]) {
                this.flag++;
            }
        }
        int i3 = this.flag;
        if (i3 != 127) {
            i = i3 == 62 ? 1 : 2;
        }
        MLAlertDialog O00000o = new MLAlertDialog.Builder(this).O000000o(this.mRepeatArray, i, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    CreateTimeEdit2Activity createTimeEdit2Activity = CreateTimeEdit2Activity.this;
                    createTimeEdit2Activity.mRepeatTrigger = true;
                    createTimeEdit2Activity.mTriggerDays = new boolean[]{true, true, true, true, true, true, true};
                    createTimeEdit2Activity.generateShortcutDaysHint();
                    CreateTimeEdit2Activity createTimeEdit2Activity2 = CreateTimeEdit2Activity.this;
                    createTimeEdit2Activity2.showNextTriggerHint(createTimeEdit2Activity2.mOffsetHours);
                    dialogInterface.dismiss();
                } else if (i == 1) {
                    CreateTimeEdit2Activity createTimeEdit2Activity3 = CreateTimeEdit2Activity.this;
                    createTimeEdit2Activity3.mRepeatTrigger = true;
                    createTimeEdit2Activity3.mTriggerDays = new boolean[]{false, true, true, true, true, true, false};
                    createTimeEdit2Activity3.generateShortcutDaysHint();
                    CreateTimeEdit2Activity createTimeEdit2Activity4 = CreateTimeEdit2Activity.this;
                    createTimeEdit2Activity4.showNextTriggerHint(createTimeEdit2Activity4.mOffsetHours);
                    dialogInterface.dismiss();
                } else if (i == 2) {
                    final boolean[] zArr = (boolean[]) CreateTimeEdit2Activity.this.mTriggerDays.clone();
                    dialogInterface.dismiss();
                    MLAlertDialog O00000o = new MLAlertDialog.Builder(CreateTimeEdit2Activity.this).O000000o((int) R.array.weekday, zArr, new DialogInterface.OnMultiChoiceClickListener() {
                        /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass6.AnonymousClass3 */

                        public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                            zArr[i] = z;
                        }
                    }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass6.AnonymousClass2 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            boolean z = CreateTimeEdit2Activity.this.mRepeatTrigger;
                            boolean[] zArr = CreateTimeEdit2Activity.this.mTriggerDays;
                            CreateTimeEdit2Activity.this.mRepeatTrigger = true;
                            CreateTimeEdit2Activity.this.mTriggerDays = zArr;
                            if (!CreateTimeEdit2Activity.this.generateShortcutDaysHint()) {
                                CreateTimeEdit2Activity.this.mRepeatTrigger = z;
                                CreateTimeEdit2Activity.this.mTriggerDays = zArr;
                                izb.O000000o(CreateTimeEdit2Activity.this, (int) R.string.smarthome_span_error, 0).show();
                                return;
                            }
                            CreateTimeEdit2Activity.this.showNextTriggerHint(CreateTimeEdit2Activity.this.mOffsetHours);
                            ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity.AnonymousClass6.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                        }
                    }).O00000o();
                    O00000o.show();
                    gnp.O000000o(O00000o.getContext(), O00000o);
                }
            }
        }).O00000o();
        O00000o.show();
        gnp.O000000o(O00000o.getContext(), O00000o);
    }

    public boolean generateShortcutDaysHint() {
        String str;
        this.flag = 0;
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.weekday_short);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            this.flag <<= 1;
            if (this.mTriggerDays[i]) {
                this.flag++;
                sb.append(". ");
                sb.append(obtainTypedArray.getString(i));
            }
        }
        int i2 = this.flag;
        if (i2 == 0) {
            obtainTypedArray.recycle();
            return false;
        }
        this.mRepeatTrigger = true;
        if (i2 == 62) {
            str = getResources().getString(R.string.smarthome_scene_timer_workday);
        } else if (i2 != 127) {
            str = sb.substring(1);
        } else {
            str = getResources().getString(R.string.smarthome_scene_timer_everyday);
        }
        this.mRepeatDayHint.setText(str);
        obtainTypedArray.recycle();
        return true;
    }

    public void showNextTriggerHint(int i) {
        int intValue = this.mExecuteFromPicker.getCurrentHour().intValue();
        int intValue2 = this.mExecuteFromPicker.getCurrentMinute().intValue();
        int intValue3 = this.mExecuteToPicker.getCurrentHour().intValue();
        int intValue4 = this.mExecuteToPicker.getCurrentMinute().intValue();
        if (this.mExecuteFromPicker.getVisibility() == 0) {
            this.mExecuteFrom.setText(formatTime(intValue, intValue2));
        } else if (this.mExecuteToPicker.getVisibility() == 0) {
            if (intValue3 < intValue) {
                TextView textView = this.mExecuteTo;
                textView.setText(formatTime(intValue3, intValue4) + "(" + getResources().getString(R.string.scene_exetime_second_day) + ")");
                return;
            }
            this.mExecuteTo.setText(formatTime(intValue3, intValue4));
        } else if (this.mExecuteFromPicker.getVisibility() != 8 || this.mExecuteToPicker.getVisibility() != 8) {
        } else {
            if (this.mIsAlldaySwitch.isChecked()) {
                this.mExecuteFrom.setText(formatTime(0, 0));
                this.mExecuteTo.setText(formatTime(0, 0));
                return;
            }
            this.mExecuteFrom.setText(formatTime((((this.effectiveTimeSpan.fromHour + i) - 8) + 24) % 24, this.effectiveTimeSpan.fromMin));
            this.mExecuteTo.setText(formatTime((((this.effectiveTimeSpan.toHour + i) - 8) + 24) % 24, this.effectiveTimeSpan.toMin));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    private void initSceneTimer() {
        int i = 0;
        Arrays.fill(this.mTriggerDays, false);
        int rawOffset = new GregorianCalendar().getTimeZone().getRawOffset();
        int convert = (int) TimeUnit.HOURS.convert((long) rawOffset, TimeUnit.MILLISECONDS);
        LogType logType = LogType.SCENE;
        gsy.O000000o(logType, "timeeditv2", "offsetHOser----" + convert + "--mGTMoffeset---" + rawOffset);
        this.mExecuteFromPicker.setIs24HourView(Boolean.TRUE);
        this.mExecuteFromPicker.setCurrentHour(Integer.valueOf((((this.effectiveTimeSpan.fromHour + convert) + -8) + 24) % 24));
        this.mExecuteFromPicker.setCurrentMinute(Integer.valueOf(this.effectiveTimeSpan.fromMin));
        this.mExecuteToPicker.setIs24HourView(Boolean.TRUE);
        this.mExecuteToPicker.setCurrentHour(Integer.valueOf((((this.effectiveTimeSpan.toHour + convert) - 8) + 24) % 24));
        this.mExecuteToPicker.setCurrentMinute(Integer.valueOf(this.effectiveTimeSpan.toMin));
        if (this.effectiveTimeSpan.fromHour == this.effectiveTimeSpan.toHour && this.effectiveTimeSpan.fromMin == this.effectiveTimeSpan.toMin) {
            this.isAllday = true;
        } else {
            this.isAllday = false;
        }
        if (this.effectiveTimeSpan.wDay != null) {
            while (i < this.effectiveTimeSpan.wDay.length && i < 7 && this.effectiveTimeSpan.wDay[i] < 7) {
                this.mTriggerDays[this.effectiveTimeSpan.wDay[i]] = true;
                i++;
            }
            this.mRepeatTrigger = true;
            return;
        }
        Arrays.fill(this.mTriggerDays, true);
        this.effectiveTimeSpan.wDay = new int[this.mTriggerDays.length];
        while (i < this.mTriggerDays.length) {
            this.effectiveTimeSpan.wDay[i] = i;
            i++;
        }
    }

    private String formatTime(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i < 0 || i >= 10) {
            sb.append(i);
        } else {
            sb.append("0".concat(String.valueOf(i)));
        }
        sb.append(":");
        if (i2 < 0 || i2 >= 10) {
            sb.append(i2);
        } else {
            sb.append("0".concat(String.valueOf(i2)));
        }
        return sb.toString();
    }
}
