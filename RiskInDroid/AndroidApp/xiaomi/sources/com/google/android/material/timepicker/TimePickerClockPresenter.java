package com.google.android.material.timepicker;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import com.xiaomi.smarthome.R;

class TimePickerClockPresenter implements ClockHandView.OnActionUpListener, ClockHandView.OnRotateListener, TimePickerPresenter, TimePickerView.OnPeriodChangeListener, TimePickerView.OnSelectionChange {
    private static final String[] HOUR_CLOCK_24_VALUES = {"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};
    private static final String[] HOUR_CLOCK_VALUES = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    private static final String[] MINUTE_CLOCK_VALUES = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    private boolean broadcasting = false;
    private float hourRotation;
    private float minuteRotation;
    private TimeModel time;
    private TimePickerView timePickerView;

    public TimePickerClockPresenter(TimePickerView timePickerView2, TimeModel timeModel) {
        this.timePickerView = timePickerView2;
        this.time = timeModel;
        initialize();
    }

    public void initialize() {
        if (this.time.format == 0) {
            this.timePickerView.showToggle();
        }
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    public void invalidate() {
        this.hourRotation = (float) (this.time.getHourForDisplay() * getDegreesPerHour());
        this.minuteRotation = (float) (this.time.minute * 6);
        setSelection(this.time.selection, false);
        updateTime();
    }

    public void show() {
        this.timePickerView.setVisibility(0);
    }

    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    private String[] getHourClockValues() {
        return this.time.format == 1 ? HOUR_CLOCK_24_VALUES : HOUR_CLOCK_VALUES;
    }

    private int getDegreesPerHour() {
        return this.time.format == 1 ? 15 : 30;
    }

    public void onRotate(float f, boolean z) {
        if (!this.broadcasting) {
            int i = this.time.hour;
            int i2 = this.time.minute;
            int round = Math.round(f);
            if (this.time.selection == 12) {
                this.time.setMinute((round + 3) / 6);
                this.minuteRotation = (float) Math.floor((double) (this.time.minute * 6));
            } else {
                this.time.setHour((round + (getDegreesPerHour() / 2)) / getDegreesPerHour());
                this.hourRotation = (float) (this.time.getHourForDisplay() * getDegreesPerHour());
            }
            if (!z) {
                updateTime();
                performHapticFeedback(i, i2);
            }
        }
    }

    private void performHapticFeedback(int i, int i2) {
        if (this.time.minute != i2 || this.time.hour != i) {
            this.timePickerView.performHapticFeedback(Build.VERSION.SDK_INT >= 21 ? 4 : 1);
        }
    }

    public void onSelectionChanged(int i) {
        setSelection(i, true);
    }

    public void onPeriodChange(int i) {
        this.time.setPeriod(i);
    }

    /* access modifiers changed from: package-private */
    public void setSelection(int i, boolean z) {
        String[] strArr;
        boolean z2 = i == 12;
        this.timePickerView.setAnimateOnTouchUp(z2);
        this.time.selection = i;
        TimePickerView timePickerView2 = this.timePickerView;
        if (z2) {
            strArr = MINUTE_CLOCK_VALUES;
        } else {
            strArr = getHourClockValues();
        }
        timePickerView2.setValues(strArr, z2 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.timePickerView.setHandRotation(z2 ? this.minuteRotation : this.hourRotation, z);
        this.timePickerView.setActiveSelection(i);
        TimePickerView timePickerView3 = this.timePickerView;
        timePickerView3.setMinuteHourDelegate(new ClickActionDelegate(timePickerView3.getContext(), R.string.material_hour_selection));
        TimePickerView timePickerView4 = this.timePickerView;
        timePickerView4.setHourClickDelegate(new ClickActionDelegate(timePickerView4.getContext(), R.string.material_minute_selection));
    }

    public void onActionUp(float f, boolean z) {
        this.broadcasting = true;
        int i = this.time.minute;
        int i2 = this.time.hour;
        if (this.time.selection == 10) {
            this.timePickerView.setHandRotation(this.hourRotation, false);
            if (!((AccessibilityManager) ContextCompat.O000000o(this.timePickerView.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                setSelection(12, true);
            }
        } else {
            int round = Math.round(f);
            if (!z) {
                this.time.setMinute(((round + 15) / 30) * 5);
                this.minuteRotation = (float) (this.time.minute * 6);
            }
            this.timePickerView.setHandRotation(this.minuteRotation, z);
        }
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(i2, i);
    }

    private void updateTime() {
        this.timePickerView.updateTime(this.time.period, this.time.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, "%d");
        updateValues(HOUR_CLOCK_24_VALUES, "%d");
        updateValues(MINUTE_CLOCK_VALUES, "%02d");
    }

    private void updateValues(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = TimeModel.formatText(this.timePickerView.getResources(), strArr[i], str);
        }
    }
}
