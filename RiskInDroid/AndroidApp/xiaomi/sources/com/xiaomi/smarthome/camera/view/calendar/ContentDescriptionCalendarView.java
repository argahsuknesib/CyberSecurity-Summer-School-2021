package com.xiaomi.smarthome.camera.view.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentDescriptionCalendarView extends RelativeLayout {
    public CalendarDate date;

    public ContentDescriptionCalendarView(Context context) {
        super(context);
    }

    public ContentDescriptionCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContentDescriptionCalendarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        return this.date.getDateFormat("yyyy月M日d");
    }
}
