package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePicker extends FrameLayout {
    private static final String O0000O0o = "DatePicker";

    /* renamed from: O000000o  reason: collision with root package name */
    public final NumberPicker f9168O000000o;
    public final NumberPicker O00000Oo;
    O000000o O00000o;
    public final NumberPicker O00000o0;
    public Calendar O00000oO;
    public Calendar O00000oo;
    private final LinearLayout O0000OOo;
    private String[] O0000Oo;
    private Locale O0000Oo0;
    private final DateFormat O0000OoO;
    private int O0000Ooo;
    private Calendar O0000o0;
    private Calendar O0000o00;
    private boolean O0000o0O;

    public interface O000000o {
    }

    public CalendarView getCalendarView() {
        return null;
    }

    public boolean getCalendarViewShown() {
        return false;
    }

    public void setCalendarViewShown(boolean z) {
    }

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.DatePicker, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OoO = new SimpleDateFormat("MM/dd/yyyy");
        this.O0000o0O = true;
        this.O00000oO = Calendar.getInstance();
        this.O0000o00 = Calendar.getInstance();
        this.O0000o0 = Calendar.getInstance();
        this.O00000oo = Calendar.getInstance();
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate((int) R.layout.sm_widget_date_picker, (ViewGroup) this, true);
        AnonymousClass1 r10 = new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.library.common.widget.DatePicker.AnonymousClass1 */

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                DatePicker.this.O00000oO.setTimeInMillis(DatePicker.this.O00000oo.getTimeInMillis());
                if (numberPicker == DatePicker.this.f9168O000000o) {
                    DatePicker.this.O00000oO.add(5, i2 - i);
                } else if (numberPicker == DatePicker.this.O00000Oo) {
                    DatePicker.this.O00000oO.add(2, i2 - i);
                } else if (numberPicker == DatePicker.this.O00000o0) {
                    DatePicker.this.O00000oO.set(1, i2);
                } else {
                    throw new IllegalArgumentException();
                }
                DatePicker datePicker = DatePicker.this;
                datePicker.O000000o(datePicker.O00000oO.get(1), DatePicker.this.O00000oO.get(2), DatePicker.this.O00000oO.get(5));
                DatePicker.this.O000000o();
                DatePicker datePicker2 = DatePicker.this;
                datePicker2.sendAccessibilityEvent(4);
                if (datePicker2.O00000o != null) {
                    datePicker2.getYear();
                    datePicker2.getMonth();
                    datePicker2.getDayOfMonth();
                }
            }
        };
        this.O0000OOo = (LinearLayout) findViewById(R.id.pickers);
        this.f9168O000000o = (NumberPicker) findViewById(R.id.day);
        this.f9168O000000o.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        this.f9168O000000o.setOnLongPressUpdateInterval(100);
        this.f9168O000000o.setOnValueChangedListener(r10);
        this.O00000Oo = (NumberPicker) findViewById(R.id.month);
        this.O00000Oo.setMinValue(0);
        this.O00000Oo.setMaxValue(this.O0000Ooo - 1);
        this.O00000Oo.setDisplayedValues(this.O0000Oo);
        this.O00000Oo.setOnLongPressUpdateInterval(200);
        this.O00000Oo.setOnValueChangedListener(r10);
        this.O00000o0 = (NumberPicker) findViewById(R.id.year);
        this.O00000o0.setOnLongPressUpdateInterval(100);
        this.O00000o0.setOnValueChangedListener(r10);
        setSpinnersShown(true);
        setCalendarViewShown(false);
        this.O00000oO.setTimeInMillis(0);
        this.O00000oO.set(1900, 0, 1, 0, 0, 0);
        setMinDate(this.O00000oO.getTimeInMillis());
        this.O00000oO.setTimeInMillis(0);
        this.O00000oO.set(2100, 11, 31, 0, 0, 0);
        setMaxDate(this.O00000oO.getTimeInMillis());
        this.O00000oo.setTimeInMillis(System.currentTimeMillis());
        O000000o(this.O00000oo.get(1), this.O00000oo.get(2), this.O00000oo.get(5));
        O000000o();
        this.O00000o = null;
        O00000Oo();
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public long getMinDate() {
        return this.O0000o00.getTimeInMillis();
    }

    public void setMinDate(long j) {
        this.O00000oO.setTimeInMillis(j);
        if (this.O00000oO.get(1) != this.O0000o00.get(1) || this.O00000oO.get(6) == this.O0000o00.get(6)) {
            this.O0000o00.setTimeInMillis(j);
            if (this.O00000oo.before(this.O0000o00)) {
                this.O00000oo.setTimeInMillis(this.O0000o00.getTimeInMillis());
            }
            O000000o();
        }
    }

    public long getMaxDate() {
        return this.O0000o0.getTimeInMillis();
    }

    public void setMaxDate(long j) {
        this.O00000oO.setTimeInMillis(j);
        if (this.O00000oO.get(1) != this.O0000o0.get(1) || this.O00000oO.get(6) == this.O0000o0.get(6)) {
            this.O0000o0.setTimeInMillis(j);
            if (this.O00000oo.after(this.O0000o0)) {
                this.O00000oo.setTimeInMillis(this.O0000o0.getTimeInMillis());
            }
            O000000o();
        }
    }

    public void setEnabled(boolean z) {
        if (this.O0000o0O != z) {
            super.setEnabled(z);
            this.f9168O000000o.setEnabled(z);
            this.O00000Oo.setEnabled(z);
            this.O00000o0.setEnabled(z);
            this.O0000o0O = z;
        }
    }

    public boolean isEnabled() {
        return this.O0000o0O;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.O00000oo.getTimeInMillis(), 16));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(DatePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public boolean getSpinnersShown() {
        return this.O0000OOo.isShown();
    }

    public void setSpinnersShown(boolean z) {
        this.O0000OOo.setVisibility(z ? 0 : 8);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.O0000Oo0)) {
            this.O0000Oo0 = locale;
            this.O00000oO = O000000o(this.O00000oO, locale);
            this.O0000o00 = O000000o(this.O0000o00, locale);
            this.O0000o0 = O000000o(this.O0000o0, locale);
            this.O00000oo = O000000o(this.O00000oo, locale);
            this.O0000Ooo = this.O00000oO.getActualMaximum(2) + 1;
            this.O0000Oo = new DateFormatSymbols().getShortMonths();
            if (Character.isDigit(this.O0000Oo[0].charAt(0))) {
                this.O0000Oo = new String[this.O0000Ooo];
                int i = 0;
                while (i < this.O0000Ooo) {
                    int i2 = i + 1;
                    this.O0000Oo[i] = String.format("%d", Integer.valueOf(i2));
                    i = i2;
                }
            }
        }
    }

    private static Calendar O000000o(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar instance = Calendar.getInstance(locale);
        instance.setTimeInMillis(timeInMillis);
        return instance;
    }

    private void O00000Oo() {
        this.O0000OOo.removeAllViews();
        char[] dateFormatOrder = android.text.format.DateFormat.getDateFormatOrder(getContext());
        int length = dateFormatOrder.length;
        for (int i = 0; i < length; i++) {
            char c = dateFormatOrder[i];
            if (c == 'M') {
                this.O0000OOo.addView(this.O00000Oo);
                O000000o(this.O00000Oo, length, i);
            } else if (c == 'd') {
                this.O0000OOo.addView(this.f9168O000000o);
                O000000o(this.f9168O000000o, length, i);
            } else if (c == 'y') {
                this.O0000OOo.addView(this.O00000o0);
                O000000o(this.O00000o0, length, i);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), (byte) 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        O000000o(savedState.f9170O000000o, savedState.O00000Oo, savedState.O00000o0);
        O000000o();
    }

    public final void O000000o(int i, int i2, int i3) {
        this.O00000oo.set(i, i2, i3, 0, 0, 0);
        if (this.O00000oo.before(this.O0000o00)) {
            this.O00000oo.setTimeInMillis(this.O0000o00.getTimeInMillis());
        } else if (this.O00000oo.after(this.O0000o0)) {
            this.O00000oo.setTimeInMillis(this.O0000o0.getTimeInMillis());
        }
    }

    public final void O000000o() {
        this.f9168O000000o.setDisplayedValues(null);
        this.f9168O000000o.setMinValue(1);
        this.f9168O000000o.setMaxValue(this.O00000oo.getActualMaximum(5));
        this.f9168O000000o.setWrapSelectorWheel(true);
        this.O00000Oo.setDisplayedValues(null);
        this.O00000Oo.setMinValue(0);
        this.O00000Oo.setMaxValue(11);
        this.O00000Oo.setWrapSelectorWheel(true);
        if (this.O00000oo.get(1) == this.O0000o00.get(1)) {
            this.O00000Oo.setMinValue(this.O0000o00.get(2));
            this.O00000Oo.setWrapSelectorWheel(false);
            if (this.O00000oo.get(2) == this.O0000o00.get(2)) {
                this.f9168O000000o.setMinValue(this.O0000o00.get(5));
                this.f9168O000000o.setWrapSelectorWheel(false);
            }
        }
        if (this.O00000oo.get(1) == this.O0000o0.get(1)) {
            this.O00000Oo.setMaxValue(this.O0000o0.get(2));
            this.O00000Oo.setWrapSelectorWheel(false);
            this.O00000Oo.setDisplayedValues(null);
            if (this.O00000oo.get(2) == this.O0000o0.get(2)) {
                this.f9168O000000o.setMaxValue(this.O0000o0.get(5));
                this.f9168O000000o.setWrapSelectorWheel(false);
            }
        }
        this.O00000Oo.setDisplayedValues(this.O0000Oo);
        this.O00000o0.setMinValue(this.O0000o00.get(1));
        this.O00000o0.setMaxValue(this.O0000o0.get(1));
        this.O00000o0.setWrapSelectorWheel(false);
        this.O00000o0.setValue(this.O00000oo.get(1));
        this.O00000Oo.setValue(this.O00000oo.get(2));
        this.f9168O000000o.setValue(this.O00000oo.get(5));
    }

    public int getYear() {
        return this.O00000oo.get(1);
    }

    public int getMonth() {
        return this.O00000oo.get(2);
    }

    public int getDayOfMonth() {
        return this.O00000oo.get(5);
    }

    private static void O000000o(NumberPicker numberPicker, int i, int i2) {
        ((TextView) numberPicker.findViewById(R.id.numberpicker_input)).setImeOptions(i2 < i + -1 ? 5 : 6);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.library.common.widget.DatePicker.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f9170O000000o;
        public final int O00000Oo;
        public final int O00000o0;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i, int i2, int i3, byte b) {
            this(parcelable, i, i2, i3);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.f9170O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f9170O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9170O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
        }
    }
}
