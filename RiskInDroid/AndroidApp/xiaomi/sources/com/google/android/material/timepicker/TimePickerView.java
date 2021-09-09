package com.google.android.material.timepicker;

import _m_j.bh;
import _m_j.cb;
import _m_j.oOO0OOo0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import com.xiaomi.smarthome.R;
import java.util.Locale;

class TimePickerView extends ConstraintLayout implements TimePickerControls {
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    public OnDoubleTapListener onDoubleTapListener;
    public OnPeriodChangeListener onPeriodChangeListener;
    public OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    interface OnDoubleTapListener {
        void onDoubleTap();
    }

    interface OnPeriodChangeListener {
        void onPeriodChange(int i);
    }

    interface OnSelectionChange {
        void onSelectionChanged(int i);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectionListener = new View.OnClickListener() {
            /* class com.google.android.material.timepicker.TimePickerView.AnonymousClass1 */

            public void onClick(View view) {
                if (TimePickerView.this.onSelectionChangeListener != null) {
                    TimePickerView.this.onSelectionChangeListener.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate((int) R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        this.toggle = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            /* class com.google.android.material.timepicker.TimePickerView.AnonymousClass2 */

            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
                int i2 = i == R.id.material_clock_period_pm_button ? 1 : 0;
                if (TimePickerView.this.onPeriodChangeListener != null && z) {
                    TimePickerView.this.onPeriodChangeListener.onPeriodChange(i2);
                }
            }
        });
        this.minuteView = (Chip) findViewById(R.id.material_minute_tv);
        this.hourView = (Chip) findViewById(R.id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.google.android.material.timepicker.TimePickerView.AnonymousClass3 */

            public boolean onDoubleTap(MotionEvent motionEvent) {
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                if (TimePickerView.this.onDoubleTapListener != null) {
                    TimePickerView.this.onDoubleTapListener.onDoubleTap();
                }
                return onDoubleTap;
            }
        });
        AnonymousClass4 r1 = new View.OnTouchListener() {
            /* class com.google.android.material.timepicker.TimePickerView.AnonymousClass4 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.minuteView.setOnTouchListener(r1);
        this.hourView.setOnTouchListener(r1);
    }

    public void setMinuteHourDelegate(bh bhVar) {
        cb.O000000o(this.hourView, bhVar);
    }

    public void setHourClickDelegate(bh bhVar) {
        cb.O000000o(this.minuteView, bhVar);
    }

    private void setUpDisplay() {
        this.minuteView.setTag(R.id.selection_type, 12);
        this.hourView.setTag(R.id.selection_type, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }

    public void setValues(String[] strArr, int i) {
        this.clockFace.setValues(strArr, i);
    }

    public void setHandRotation(float f) {
        this.clockHandView.setHandRotation(f);
    }

    public void setHandRotation(float f, boolean z) {
        this.clockHandView.setHandRotation(f, z);
    }

    public void setAnimateOnTouchUp(boolean z) {
        this.clockHandView.setAnimateOnTouchUp(z);
    }

    @SuppressLint({"DefaultLocale"})
    public void updateTime(int i, int i2, int i3) {
        this.toggle.check(i == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(i3));
        String format2 = String.format(locale, "%02d", Integer.valueOf(i2));
        this.minuteView.setText(format);
        this.hourView.setText(format2);
    }

    public void setActiveSelection(int i) {
        boolean z = true;
        this.minuteView.setChecked(i == 12);
        Chip chip = this.hourView;
        if (i != 10) {
            z = false;
        }
        chip.setChecked(z);
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    /* access modifiers changed from: package-private */
    public void setOnPeriodChangeListener(OnPeriodChangeListener onPeriodChangeListener2) {
        this.onPeriodChangeListener = onPeriodChangeListener2;
    }

    /* access modifiers changed from: package-private */
    public void setOnSelectionChangeListener(OnSelectionChange onSelectionChange) {
        this.onSelectionChangeListener = onSelectionChange;
    }

    /* access modifiers changed from: package-private */
    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener2) {
        this.onDoubleTapListener = onDoubleTapListener2;
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            updateToggleConstraints();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() == 0) {
            oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
            ooo0ooo0.O00000Oo(this);
            int i = 1;
            if (cb.O0000Oo0(this) == 0) {
                i = 2;
            }
            ooo0ooo0.O000000o(i);
            ooo0ooo0.O00000o0(this);
        }
    }
}
