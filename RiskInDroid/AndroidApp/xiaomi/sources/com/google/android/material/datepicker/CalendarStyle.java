package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.xiaomi.smarthome.R;

final class CalendarStyle {
    final CalendarItemStyle day;
    final CalendarItemStyle invalidDay;
    final Paint rangeFill = new Paint();
    final CalendarItemStyle selectedDay;
    final CalendarItemStyle selectedYear;
    final CalendarItemStyle todayDay;
    final CalendarItemStyle todayYear;
    final CalendarItemStyle year;

    CalendarStyle(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{16843277, R.attr.dayInvalidStyle, R.attr.daySelectedStyle, R.attr.dayStyle, R.attr.dayTodayStyle, R.attr.nestedScrollable, R.attr.rangeFillColor, R.attr.yearSelectedStyle, R.attr.yearStyle, R.attr.yearTodayStyle});
        this.day = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(3, 0));
        this.invalidDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(1, 0));
        this.selectedDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(2, 0));
        this.todayDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(4, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, 6);
        this.year = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(8, 0));
        this.selectedYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(7, 0));
        this.todayYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(9, 0));
        this.rangeFill.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
