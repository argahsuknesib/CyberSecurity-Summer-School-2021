package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import java.util.Calendar;
import java.util.Locale;

public class MinSecTimerPicker extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O000000o f9217O000000o = new O000000o() {
        /* class com.xiaomi.smarthome.library.common.widget.MinSecTimerPicker.AnonymousClass1 */

        public final void O000000o(MinSecTimerPicker minSecTimerPicker) {
        }
    };
    private final NumberPicker O00000Oo;
    private boolean O00000o;
    private final NumberPicker O00000o0;
    private O000000o O00000oO;
    private Calendar O00000oo;
    private Locale O0000O0o;

    public interface O000000o {
        void O000000o(MinSecTimerPicker minSecTimerPicker);
    }

    public MinSecTimerPicker(Context context) {
        this(context, null);
    }

    public MinSecTimerPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.MinSecTimerPicker, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public MinSecTimerPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = true;
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate((int) R.layout.sm_widget_min_sec_timer_picker, (ViewGroup) this, true);
        this.O00000Oo = (NumberPicker) findViewById(R.id.min);
        this.O00000Oo.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.library.common.widget.MinSecTimerPicker.AnonymousClass2 */

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                MinSecTimerPicker.this.O000000o();
            }
        });
        this.O00000o0 = (NumberPicker) findViewById(R.id.sec);
        this.O00000o0.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.library.common.widget.MinSecTimerPicker.AnonymousClass3 */

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                MinSecTimerPicker.this.O000000o();
            }
        });
        this.O00000Oo.setMinValue(0);
        this.O00000Oo.setMaxValue(59);
        this.O00000Oo.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        this.O00000o0.setMinValue(0);
        this.O00000o0.setMaxValue(59);
        this.O00000o0.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        setOnTimeChangedListener(f9217O000000o);
        setCurrentMin(0);
        setCurrentSec(0);
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setEnabled(boolean z) {
        if (this.O00000o != z) {
            super.setEnabled(z);
            this.O00000Oo.setEnabled(z);
            this.O00000o0.setEnabled(z);
            this.O00000o = z;
        }
    }

    public boolean isEnabled() {
        return this.O00000o;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.O0000O0o)) {
            this.O0000O0o = locale;
            this.O00000oo = Calendar.getInstance(locale);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.library.common.widget.MinSecTimerPicker.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        final int f9220O000000o;
        final int O00000Oo;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i, int i2, byte b) {
            this(parcelable, i, i2);
        }

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.f9220O000000o = i;
            this.O00000Oo = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f9220O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9220O000000o);
            parcel.writeInt(this.O00000Oo);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentMin().intValue(), getCurrentSec().intValue(), (byte) 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentMin(Integer.valueOf(savedState.f9220O000000o));
        setCurrentSec(Integer.valueOf(savedState.O00000Oo));
    }

    public void setOnTimeChangedListener(O000000o o000000o) {
        this.O00000oO = o000000o;
    }

    public Integer getCurrentMin() {
        return Integer.valueOf(this.O00000Oo.getValue());
    }

    public Integer getCurrentSec() {
        return Integer.valueOf(this.O00000o0.getValue());
    }

    public void setCurrentMin(Integer num) {
        if (num != null && num != getCurrentMin()) {
            this.O00000Oo.setValue(num.intValue());
            O000000o();
        }
    }

    public void setCurrentSec(Integer num) {
        if (num != null && num != getCurrentSec()) {
            this.O00000o0.setValue(num.intValue());
            O000000o();
        }
    }

    public int getBaseline() {
        return this.O00000Oo.getBaseline();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HourSpanPicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HourSpanPicker.class.getName());
    }

    public final void O000000o() {
        sendAccessibilityEvent(4);
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            getCurrentMin().intValue();
            getCurrentMin().intValue();
            o000000o.O000000o(this);
        }
    }
}
