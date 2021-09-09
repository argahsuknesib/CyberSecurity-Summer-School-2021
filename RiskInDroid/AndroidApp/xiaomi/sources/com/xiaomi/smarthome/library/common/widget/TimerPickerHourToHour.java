package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.TimePicker;

public class TimerPickerHourToHour extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f9279O000000o;
    public int O00000Oo;
    private TimePicker O00000o;
    private TimePicker O00000o0;
    private TextView O00000oO;

    public TimerPickerHourToHour(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public TimerPickerHourToHour(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O00000Oo() {
        LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_timer_picker_hour_to_hour, this);
        this.O00000oO = (TextView) findViewById(R.id.hint);
        this.O00000o0 = (TimePicker) findViewById(R.id.timer_from);
        this.O00000o0.setAmPmSpinnerVisibility(8);
        this.O00000o0.setMinuteSpinnerVisibility(8);
        this.O00000o0.setIs24HourView(Boolean.TRUE);
        this.O00000o0.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.library.common.widget.TimerPickerHourToHour.AnonymousClass1 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                TimerPickerHourToHour timerPickerHourToHour = TimerPickerHourToHour.this;
                timerPickerHourToHour.f9279O000000o = i;
                timerPickerHourToHour.O000000o();
            }
        });
        this.O00000o = (TimePicker) findViewById(R.id.timer_to);
        this.O00000o.setAmPmSpinnerVisibility(8);
        this.O00000o.setMinuteSpinnerVisibility(8);
        this.O00000o.setIs24HourView(Boolean.TRUE);
        this.O00000o.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.library.common.widget.TimerPickerHourToHour.AnonymousClass2 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                TimerPickerHourToHour timerPickerHourToHour = TimerPickerHourToHour.this;
                timerPickerHourToHour.O00000Oo = i;
                timerPickerHourToHour.O000000o();
            }
        });
        this.O00000o.setCurrentHour(Integer.valueOf(this.O00000Oo));
        this.O00000o0.setCurrentHour(Integer.valueOf(this.f9279O000000o));
    }

    public int[] getHourFromTo() {
        return new int[]{this.f9279O000000o, this.O00000Oo};
    }

    public final void O000000o() {
        this.O00000oO.setVisibility(0);
        TextView textView = this.O00000oO;
        textView.setText(this.f9279O000000o + ":00~" + this.O00000Oo + ":00");
    }
}
