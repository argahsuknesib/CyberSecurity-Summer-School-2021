package com.xiaomi.smarthome.library.common.widget;

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
import android.widget.Button;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class TimePicker extends FrameLayout {
    private static final O00000Oo O00000oO = new O00000Oo() {
        /* class com.xiaomi.smarthome.library.common.widget.TimePicker.AnonymousClass1 */

        public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f9272O000000o;
    public boolean O00000Oo;
    public final NumberPicker O00000o;
    public final NumberPicker O00000o0;
    private final NumberPicker O00000oo;
    private final Button O0000O0o;
    private final String[] O0000OOo;
    private O00000Oo O0000Oo;
    private boolean O0000Oo0;
    private Calendar O0000OoO;
    private Locale O0000Ooo;

    public interface O00000Oo {
        void onTimeChanged(TimePicker timePicker, int i, int i2);
    }

    class O000000o implements NumberPicker.O0000Oo0 {
        O000000o() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            TimePicker.this.O00000Oo();
        }
    }

    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.TimePicker, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public TimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo0 = true;
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate((int) R.layout.sm_widget_time_picker, (ViewGroup) this, true);
        this.O00000o0 = (NumberPicker) findViewById(R.id.hour);
        this.O00000o0.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.library.common.widget.TimePicker.AnonymousClass2 */

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                if (!TimePicker.this.f9272O000000o && ((i == 11 && i2 == 12) || (i == 12 && i2 == 11))) {
                    TimePicker timePicker = TimePicker.this;
                    timePicker.O00000Oo = !timePicker.O00000Oo;
                    TimePicker.this.O000000o();
                }
                TimePicker.this.O00000Oo();
            }
        });
        this.O00000o = (NumberPicker) findViewById(R.id.minute);
        this.O00000o.setMinValue(0);
        this.O00000o.setMaxValue(59);
        this.O00000o.setOnLongPressUpdateInterval(100);
        this.O00000o.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        this.O00000o.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.library.common.widget.TimePicker.AnonymousClass3 */

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                int minValue = TimePicker.this.O00000o.getMinValue();
                int maxValue = TimePicker.this.O00000o.getMaxValue();
                if (i == maxValue && i2 == minValue) {
                    int value = TimePicker.this.O00000o0.getValue() + 1;
                    if (!TimePicker.this.f9272O000000o && value == 12) {
                        TimePicker timePicker = TimePicker.this;
                        timePicker.O00000Oo = !timePicker.O00000Oo;
                        TimePicker.this.O000000o();
                    }
                    TimePicker.this.O00000o0.setValue(value);
                } else if (i == minValue && i2 == maxValue) {
                    int value2 = TimePicker.this.O00000o0.getValue() - 1;
                    if (!TimePicker.this.f9272O000000o && value2 == 11) {
                        TimePicker timePicker2 = TimePicker.this;
                        timePicker2.O00000Oo = !timePicker2.O00000Oo;
                        TimePicker.this.O000000o();
                    }
                    TimePicker.this.O00000o0.setValue(value2);
                }
                TimePicker.this.O00000Oo();
            }
        });
        this.O00000o.setOnValueChangedListener(new O000000o());
        this.O0000OOo = new DateFormatSymbols().getAmPmStrings();
        View findViewById = findViewById(R.id.amPm);
        if (findViewById instanceof Button) {
            this.O00000oo = null;
            this.O0000O0o = (Button) findViewById;
            this.O0000O0o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.library.common.widget.TimePicker.AnonymousClass4 */

                public final void onClick(View view) {
                    view.requestFocus();
                    TimePicker timePicker = TimePicker.this;
                    timePicker.O00000Oo = !timePicker.O00000Oo;
                    TimePicker.this.O000000o();
                    TimePicker.this.O00000Oo();
                }
            });
        } else {
            this.O0000O0o = null;
            this.O00000oo = (NumberPicker) findViewById;
            this.O00000oo.setMinValue(0);
            this.O00000oo.setMaxValue(1);
            this.O00000oo.setDisplayedValues(this.O0000OOo);
            this.O00000oo.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
                /* class com.xiaomi.smarthome.library.common.widget.TimePicker.AnonymousClass5 */

                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    numberPicker.requestFocus();
                    TimePicker timePicker = TimePicker.this;
                    timePicker.O00000Oo = !timePicker.O00000Oo;
                    TimePicker.this.O000000o();
                    TimePicker.this.O00000Oo();
                }
            });
        }
        O00000o0();
        O000000o();
        setOnTimeChangedListener(O00000oO);
        setCurrentHour(Integer.valueOf(this.O0000OoO.get(11)));
        setCurrentMinute(Integer.valueOf(this.O0000OoO.get(12)));
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setEnabled(boolean z) {
        if (this.O0000Oo0 != z) {
            super.setEnabled(z);
            this.O00000o.setEnabled(z);
            this.O00000o0.setEnabled(z);
            NumberPicker numberPicker = this.O00000oo;
            if (numberPicker != null) {
                numberPicker.setEnabled(z);
            } else {
                this.O0000O0o.setEnabled(z);
            }
            this.O0000Oo0 = z;
        }
    }

    public boolean isEnabled() {
        return this.O0000Oo0;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.O0000Ooo)) {
            this.O0000Ooo = locale;
            this.O0000OoO = Calendar.getInstance(locale);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.library.common.widget.TimePicker.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        final int f9278O000000o;
        final int O00000Oo;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i, int i2, byte b) {
            this(parcelable, i, i2);
        }

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.f9278O000000o = i;
            this.O00000Oo = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f9278O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9278O000000o);
            parcel.writeInt(this.O00000Oo);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue(), (byte) 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.f9278O000000o));
        setCurrentMinute(Integer.valueOf(savedState.O00000Oo));
    }

    public void setOnTimeChangedListener(O00000Oo o00000Oo) {
        this.O0000Oo = o00000Oo;
    }

    public Integer getCurrentHour() {
        int value = this.O00000o0.getValue();
        if (this.f9272O000000o) {
            return Integer.valueOf(value);
        }
        if (this.O00000Oo) {
            return Integer.valueOf(value % 12);
        }
        return Integer.valueOf((value % 12) + 12);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num != getCurrentHour()) {
            if (!this.f9272O000000o) {
                if (num.intValue() >= 12) {
                    this.O00000Oo = false;
                    if (num.intValue() > 12) {
                        num = Integer.valueOf(num.intValue() - 12);
                    }
                } else {
                    this.O00000Oo = true;
                    if (num.intValue() == 0) {
                        num = 12;
                    }
                }
                O000000o();
            }
            this.O00000o0.setValue(num.intValue());
            O00000Oo();
        }
    }

    public void setIs24HourView(Boolean bool) {
        if (this.f9272O000000o != bool.booleanValue()) {
            this.f9272O000000o = bool.booleanValue();
            int intValue = getCurrentHour().intValue();
            O00000o0();
            setCurrentHour(Integer.valueOf(intValue));
            O000000o();
        }
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.O00000o.getValue());
    }

    public void setCurrentMinute(Integer num) {
        if (num != getCurrentMinute()) {
            this.O00000o.setValue(num.intValue());
            O00000Oo();
        }
    }

    public int getBaseline() {
        return this.O00000o0.getBaseline();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        int i = this.f9272O000000o ? 129 : 65;
        this.O0000OoO.set(11, getCurrentHour().intValue());
        this.O0000OoO.set(12, getCurrentMinute().intValue());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.O0000OoO.getTimeInMillis(), i));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TimePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    public void setAmPmSpinnerVisibility(int i) {
        NumberPicker numberPicker = this.O00000oo;
        if (numberPicker != null) {
            numberPicker.setVisibility(i);
        }
    }

    public void setMinuteSpinnerVisibility(int i) {
        NumberPicker numberPicker = this.O00000o;
        if (numberPicker != null) {
            numberPicker.setVisibility(i);
        }
    }

    public final void O00000Oo() {
        sendAccessibilityEvent(4);
        O00000Oo o00000Oo = this.O0000Oo;
        if (o00000Oo != null) {
            o00000Oo.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    private void O00000o0() {
        if (this.f9272O000000o) {
            this.O00000o0.setMinValue(0);
            this.O00000o0.setMaxValue(23);
            this.O00000o0.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
            return;
        }
        this.O00000o0.setMinValue(1);
        this.O00000o0.setMaxValue(12);
        this.O00000o0.setFormatter(null);
    }

    public final void O000000o() {
        if (this.f9272O000000o) {
            NumberPicker numberPicker = this.O00000oo;
            if (numberPicker != null) {
                numberPicker.setVisibility(8);
            } else {
                this.O0000O0o.setVisibility(8);
            }
        } else {
            int i = !this.O00000Oo;
            NumberPicker numberPicker2 = this.O00000oo;
            if (numberPicker2 != null) {
                numberPicker2.setValue(i);
                this.O00000oo.setVisibility(0);
            } else {
                this.O0000O0o.setText(this.O0000OOo[i]);
                this.O0000O0o.setVisibility(0);
            }
        }
        sendAccessibilityEvent(4);
    }
}
