package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.xiaomi.mico.common.widget.NumberPicker;
import com.xiaomi.smarthome.R;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class AlarmTimePicker extends FrameLayout {
    private static final OnTimeChangedListener NO_OP_CHANGE_LISTENER = new OnTimeChangedListener() {
        /* class com.xiaomi.mico.common.widget.AlarmTimePicker.AnonymousClass1 */

        public final void onTimeChanged(AlarmTimePicker alarmTimePicker, int i, int i2) {
        }
    };
    private final String[] mAmPmStrings;
    private Locale mCurrentLocale;
    public final NumberPicker mHourSpinner;
    private boolean mIs24HourView;
    public boolean mIsAm;
    private boolean mIsEnabled;
    public final NumberPicker mMinuteSpinner;
    private OnTimeChangedListener mOnTimeChangedListener;
    private Calendar mTempCalendar;

    public interface OnTimeChangedListener {
        void onTimeChanged(AlarmTimePicker alarmTimePicker, int i, int i2);
    }

    /* access modifiers changed from: package-private */
    public void callOnTimeChanged() {
        onTimeChanged();
    }

    class OnMinuteChangeListener implements NumberPicker.OnValueChangeListener {
        OnMinuteChangeListener() {
        }

        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            AlarmTimePicker.this.callOnTimeChanged();
        }
    }

    public AlarmTimePicker(Context context) {
        this(context, null);
    }

    public AlarmTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.AlarmTimePicker, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public AlarmTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate((int) R.layout.widget_alarm_time_picker, (ViewGroup) this, true);
        this.mIs24HourView = true;
        this.mHourSpinner = (NumberPicker) findViewById(R.id.hour);
        this.mHourSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.xiaomi.mico.common.widget.AlarmTimePicker.AnonymousClass2 */

            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                if (!AlarmTimePicker.this.is24HourView() && ((i == 11 && i2 == 12) || (i == 12 && i2 == 11))) {
                    AlarmTimePicker alarmTimePicker = AlarmTimePicker.this;
                    alarmTimePicker.mIsAm = !alarmTimePicker.mIsAm;
                }
                AlarmTimePicker.this.onTimeChanged();
            }
        });
        this.mHourSpinner.setLabelTextSize(24);
        this.mHourSpinner.setLabelTextColor(getResources().getColor(R.color.mj_color_black));
        this.mMinuteSpinner = (NumberPicker) findViewById(R.id.minute);
        this.mMinuteSpinner.setMinValue(0);
        this.mMinuteSpinner.setMaxValue(59);
        this.mMinuteSpinner.setOnLongPressUpdateInterval(100);
        this.mMinuteSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        this.mMinuteSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.xiaomi.mico.common.widget.AlarmTimePicker.AnonymousClass3 */

            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                int minValue = AlarmTimePicker.this.mMinuteSpinner.getMinValue();
                int maxValue = AlarmTimePicker.this.mMinuteSpinner.getMaxValue();
                if (i == maxValue && i2 == minValue) {
                    int value = AlarmTimePicker.this.mHourSpinner.getValue() + 1;
                    if (!AlarmTimePicker.this.is24HourView() && value == 12) {
                        AlarmTimePicker alarmTimePicker = AlarmTimePicker.this;
                        alarmTimePicker.mIsAm = !alarmTimePicker.mIsAm;
                    }
                    AlarmTimePicker.this.mHourSpinner.setValue(value);
                } else if (i == minValue && i2 == maxValue) {
                    int value2 = AlarmTimePicker.this.mHourSpinner.getValue() - 1;
                    if (!AlarmTimePicker.this.is24HourView() && value2 == 11) {
                        AlarmTimePicker alarmTimePicker2 = AlarmTimePicker.this;
                        alarmTimePicker2.mIsAm = !alarmTimePicker2.mIsAm;
                    }
                    AlarmTimePicker.this.mHourSpinner.setValue(value2);
                }
                AlarmTimePicker.this.onTimeChanged();
            }
        });
        this.mMinuteSpinner.setLabelTextSize(24);
        this.mMinuteSpinner.setLabelTextColor(getResources().getColor(R.color.mj_color_black));
        this.mMinuteSpinner.setOnValueChangedListener(new OnMinuteChangeListener());
        this.mAmPmStrings = new DateFormatSymbols().getAmPmStrings();
        updateHourControl();
        setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);
        setCurrentHour(Integer.valueOf(this.mTempCalendar.get(11)));
        setCurrentMinute(Integer.valueOf(this.mTempCalendar.get(12)));
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setEnabled(boolean z) {
        if (this.mIsEnabled != z) {
            super.setEnabled(z);
            this.mMinuteSpinner.setEnabled(z);
            this.mHourSpinner.setEnabled(z);
            this.mIsEnabled = z;
        }
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.mCurrentLocale)) {
            this.mCurrentLocale = locale;
            this.mTempCalendar = Calendar.getInstance(locale);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.mico.common.widget.AlarmTimePicker.SavedState.AnonymousClass1 */

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mHour;
        private final int mMinute;

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue());
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.getHour()));
        setCurrentMinute(Integer.valueOf(savedState.getMinute()));
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public Integer getCurrentHour() {
        int value = this.mHourSpinner.getValue();
        if (is24HourView()) {
            return Integer.valueOf(value);
        }
        if (this.mIsAm) {
            return Integer.valueOf(value % 12);
        }
        return Integer.valueOf((value % 12) + 12);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num != getCurrentHour()) {
            if (!is24HourView()) {
                if (num.intValue() >= 12) {
                    this.mIsAm = false;
                    if (num.intValue() > 12) {
                        num = Integer.valueOf(num.intValue() - 12);
                    }
                } else {
                    this.mIsAm = true;
                    if (num.intValue() == 0) {
                        num = 12;
                    }
                }
            }
            this.mHourSpinner.setValue(num.intValue());
            onTimeChanged();
        }
    }

    public void setIs24HourView(Boolean bool) {
        if (this.mIs24HourView != bool.booleanValue()) {
            this.mIs24HourView = bool.booleanValue();
            int intValue = getCurrentHour().intValue();
            updateHourControl();
            setCurrentHour(Integer.valueOf(intValue));
        }
    }

    public boolean is24HourView() {
        return this.mIs24HourView;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mMinuteSpinner.getValue());
    }

    public void setCurrentMinute(Integer num) {
        if (num != getCurrentMinute()) {
            this.mMinuteSpinner.setValue(num.intValue());
            onTimeChanged();
        }
    }

    public int getBaseline() {
        return this.mHourSpinner.getBaseline();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onPopulateAccessibilityEvent(accessibilityEvent);
        }
        int i = this.mIs24HourView ? 129 : 65;
        this.mTempCalendar.set(11, getCurrentHour().intValue());
        this.mTempCalendar.set(12, getCurrentMinute().intValue());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.mTempCalendar.getTimeInMillis(), i));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
        accessibilityEvent.setClassName(AlarmTimePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(AlarmTimePicker.class.getName());
        }
    }

    private void updateHourControl() {
        if (is24HourView()) {
            this.mHourSpinner.setMinValue(0);
            this.mHourSpinner.setMaxValue(23);
            this.mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
            return;
        }
        this.mHourSpinner.setMinValue(1);
        this.mHourSpinner.setMaxValue(12);
        this.mHourSpinner.setFormatter(null);
    }

    public void onTimeChanged() {
        sendAccessibilityEvent(4);
        OnTimeChangedListener onTimeChangedListener = this.mOnTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    private void trySetContentDescription(View view, int i, int i2) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            findViewById.setContentDescription(getContext().getString(i2));
        }
    }
}
