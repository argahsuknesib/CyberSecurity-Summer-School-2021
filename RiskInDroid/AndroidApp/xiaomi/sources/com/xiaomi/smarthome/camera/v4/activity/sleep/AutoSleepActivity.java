package com.xiaomi.smarthome.camera.v4.activity.sleep;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import java.util.Calendar;

public class AutoSleepActivity extends CameraBaseActivity implements View.OnClickListener {
    public AutoSleepBean mOffTime;
    private View mOffView;
    public AutoSleepBean mOnTime;
    private View mOnView;
    private CommonTimer mOriginTimer;
    public boolean[] mSelectedItems;
    SettingsItemView mSleepEnd;
    SettingsItemView mSleepStart;
    SettingsItemView mSleepTimes;
    private TimePicker timePickerOff;
    private TimePicker timePickerOn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_auto_sleep);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.sleep_auto_setting);
        this.mOriginTimer = (CommonTimer) getIntent().getParcelableExtra("auto_sleep_add");
        if (this.mOriginTimer == null) {
            finish();
        }
        initView();
    }

    private void initView() {
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mSleepStart = (SettingsItemView) findViewById(R.id.sleep_start);
        this.mSleepEnd = (SettingsItemView) findViewById(R.id.sleep_end);
        this.mSleepTimes = (SettingsItemView) findViewById(R.id.sleep_times);
        this.mOnView = findViewById(R.id.view_tp_on);
        this.mOffView = findViewById(R.id.view_tp_off);
        this.mSleepTimes.setOnClickListener(this);
        this.mSleepStart.setOnClickListener(this);
        this.mSleepEnd.setOnClickListener(this);
        this.timePickerOn.setIs24HourView(Boolean.TRUE);
        this.timePickerOn.setCurrentHour(Integer.valueOf(this.mOnTime.hour));
        this.timePickerOn.setCurrentMinute(Integer.valueOf(this.mOnTime.minute));
        this.timePickerOn.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.v4.activity.sleep.AutoSleepActivity.AnonymousClass1 */

            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
            }
        });
        this.timePickerOff.setIs24HourView(Boolean.TRUE);
        this.timePickerOff.setCurrentHour(Integer.valueOf(this.mOffTime.hour));
        this.timePickerOff.setCurrentMinute(Integer.valueOf(this.mOffTime.minute));
        this.timePickerOff.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.v4.activity.sleep.AutoSleepActivity.AnonymousClass2 */

            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.sleep_start) {
            this.mOffView.setVisibility(0);
            this.mOnView.setVisibility(8);
        } else if (id == R.id.sleep_end) {
            this.mOffView.setVisibility(8);
            this.mOnView.setVisibility(0);
        } else if (id == R.id.sleep_times) {
            showRepeatDialog();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void showRepeatDialog() {
        int repeatType = this.mOnTime.getRepeatType();
        new MLAlertDialog.Builder(this).O000000o(new String[]{getString(R.string.sleep_auto_times_onetime), getString(R.string.sleep_auto_times_everyday), getString(R.string.sleep_auto_times_workday), getString(R.string.sleep_auto_times_weekend), getString(R.string.sleep_auto_times_sef_define)}, repeatType, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.sleep.AutoSleepActivity.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    AutoSleepActivity.this.mOnTime.setRepeat(0);
                    AutoSleepActivity.this.mOffTime.setRepeat(0);
                } else if (i == 1) {
                    AutoSleepActivity.this.mOnTime.setRepeat(127);
                    AutoSleepActivity.this.mOffTime.setRepeat(127);
                } else if (i == 2) {
                    AutoSleepActivity.this.mOnTime.setRepeat(62);
                    AutoSleepActivity.this.mOffTime.setRepeat(62);
                } else if (i == 3) {
                    AutoSleepActivity.this.mOnTime.setRepeat(65);
                    AutoSleepActivity.this.mOffTime.setRepeat(65);
                } else if (i == 4) {
                    AutoSleepActivity.this.showSubRepeatDialog();
                }
                dialogInterface.cancel();
            }
        }).O00000oo();
    }

    public void showSubRepeatDialog() {
        this.mSelectedItems = (boolean[]) this.mOnTime.weeks.clone();
        new MLAlertDialog.Builder(this).O000000o((int) R.string.sleep_auto_times).O000000o(new String[]{getString(R.string.sleep_auto_times_sunday), getString(R.string.sleep_auto_times_monday), getString(R.string.sleep_auto_times_tuesday), getString(R.string.sleep_auto_times_wednesday), getString(R.string.sleep_auto_times_thursday), getString(R.string.sleep_auto_times_friday), getString(R.string.sleep_auto_times_saturday)}, this.mSelectedItems, new DialogInterface.OnMultiChoiceClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.sleep.AutoSleepActivity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                AutoSleepActivity.this.mSelectedItems[i] = z;
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.sleep.AutoSleepActivity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                for (int i2 = 0; i2 < AutoSleepActivity.this.mOnTime.weeks.length; i2++) {
                    AutoSleepActivity.this.mSelectedItems[i2] = AutoSleepActivity.this.mOnTime.weeks[i2];
                }
            }
        }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.sleep.AutoSleepActivity.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
                boolean z = false;
                for (boolean z2 : AutoSleepActivity.this.mSelectedItems) {
                    z |= z2;
                }
                if (z) {
                    for (int i2 = 0; i2 < AutoSleepActivity.this.mSelectedItems.length; i2++) {
                        AutoSleepActivity.this.mOnTime.setWeekday(i2, AutoSleepActivity.this.mSelectedItems[i2]);
                        AutoSleepActivity.this.mOffTime.setWeekday(i2, AutoSleepActivity.this.mSelectedItems[i2]);
                    }
                }
            }
        }).O00000oo();
    }

    private void fixOnceTimeDiff() {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        int i = (instance.get(11) * 60) + instance.get(12);
        if (i >= (this.mOnTime.hour * 60) + this.mOnTime.minute) {
            instance2.setTimeInMillis(instance.getTimeInMillis() + 86400000);
        }
        this.mOnTime.day = instance2.get(5);
        this.mOnTime.month = instance2.get(2) + 1;
        if (i >= (this.mOffTime.hour * 60) + this.mOffTime.minute) {
            instance2.setTimeInMillis(instance.getTimeInMillis() + 86400000);
        }
        this.mOffTime.day = instance2.get(5);
        this.mOffTime.month = instance2.get(2) + 1;
        if (i >= (this.mOnTime.hour * 60) + this.mOnTime.minute) {
            instance2.setTimeInMillis(instance.getTimeInMillis() + 86400000);
            this.mOffTime.day = instance2.get(5);
            this.mOffTime.month = instance2.get(2) + 1;
        }
        if ((this.mOnTime.hour * 60) + this.mOnTime.minute >= (this.mOffTime.hour * 60) + this.mOffTime.minute) {
            instance2.set(5, this.mOnTime.day);
            instance2.set(2, this.mOnTime.month - 1);
            instance2.add(5, 1);
            this.mOffTime.day = instance2.get(5);
            this.mOffTime.month = instance2.get(2) + 1;
            return;
        }
        instance2.set(5, this.mOnTime.day);
        instance2.set(2, this.mOnTime.month - 1);
        this.mOffTime.day = instance2.get(5);
        this.mOffTime.month = instance2.get(2) + 1;
    }

    private CommonTimer buildTimerFromUi() {
        this.mOriginTimer.name = getString(R.string.auto_sleep_title);
        CommonTimer commonTimer = this.mOriginTimer;
        AutoSleepBean autoSleepBean = this.mOnTime;
        commonTimer.onTime = autoSleepBean;
        commonTimer.offTime = this.mOffTime;
        if (autoSleepBean.getRepeatType() == 0) {
            fixOnceTimeDiff();
        } else {
            fixTimeDiff();
        }
        return this.mOriginTimer;
    }

    private void fixTimeDiff() {
        if ((this.mOnTime.hour * 60) + this.mOnTime.minute >= (this.mOffTime.hour * 60) + this.mOffTime.minute) {
            this.mOffTime.shiftWeekday(1);
        }
    }
}
