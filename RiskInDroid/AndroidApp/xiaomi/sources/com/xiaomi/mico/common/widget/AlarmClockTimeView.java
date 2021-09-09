package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class AlarmClockTimeView extends LinearLayout {
    ImageView hourTens;
    ImageView hourUnits;
    private int mHour;
    private int mHourTens;
    private int mHourUnits;
    private int mMinutes;
    private int mMinutesTens;
    private int mMinutesUnits;
    ImageView minuteTens;
    ImageView minuteUnits;
    private HashMap<String, Integer> resources;

    public AlarmClockTimeView(Context context) {
        super(context);
    }

    public AlarmClockTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlarmClockTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.hourTens = (ImageView) findViewById(R.id.hour_tens);
        this.hourUnits = (ImageView) findViewById(R.id.hour_units);
        this.minuteTens = (ImageView) findViewById(R.id.minute_tens);
        this.minuteUnits = (ImageView) findViewById(R.id.minute_units);
        this.resources = new HashMap<>();
    }

    public void updateTime(int i, int i2) {
        this.mHour = i;
        this.mMinutes = i2;
        int i3 = i / 10;
        int i4 = i % 10;
        if (this.mHourTens != i3) {
            this.hourTens.setBackgroundResource(getDrawableResId("clock_time_".concat(String.valueOf(i3))));
            this.mHourTens = i3;
        }
        if (this.mHourUnits != i4) {
            this.hourUnits.setBackgroundResource(getDrawableResId("clock_time_".concat(String.valueOf(i4))));
            this.mHourUnits = i4;
        }
        int i5 = i2 / 10;
        int i6 = i2 % 10;
        if (this.mMinutesTens != i5) {
            this.minuteTens.setBackgroundResource(getDrawableResId("clock_time_".concat(String.valueOf(i5))));
            this.mMinutesTens = i5;
        }
        if (this.mMinutesUnits != i6) {
            this.minuteUnits.setBackgroundResource(getDrawableResId("clock_time_".concat(String.valueOf(i6))));
            this.mMinutesUnits = i6;
        }
    }

    public long getTimeStamp(boolean z) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        if (z) {
            gregorianCalendar.set(11, this.mHour);
            gregorianCalendar.set(12, this.mMinutes);
            gregorianCalendar.set(13, 0);
        } else {
            gregorianCalendar.add(11, this.mHour);
            gregorianCalendar.add(12, this.mMinutes);
        }
        return gregorianCalendar.getTimeInMillis();
    }

    private int getDrawableResId(String str) {
        Integer num = this.resources.get(str);
        if (num != null) {
            return num.intValue();
        }
        int identifier = getContext().getResources().getIdentifier(str, "drawable", "com.xiaomi.mico");
        this.resources.put(str, Integer.valueOf(identifier));
        return identifier;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.resources.clear();
    }
}
