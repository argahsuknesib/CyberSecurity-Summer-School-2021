package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.Calendar;
import java.util.Locale;

class DaysOfWeekAdapter extends BaseAdapter {
    private static final int CALENDAR_DAY_STYLE = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);
    private final Calendar calendar = UtcDates.getUtcCalendar();
    private final int daysInWeek = this.calendar.getMaximum(7);
    private final int firstDayOfWeek = this.calendar.getFirstDayOfWeek();

    public long getItemId(int i) {
        return 0;
    }

    public Integer getItem(int i) {
        if (i >= this.daysInWeek) {
            return null;
        }
        return Integer.valueOf(positionToDayOfWeek(i));
    }

    public int getCount() {
        return this.daysInWeek;
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [android.view.View] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.calendar.set(7, positionToDayOfWeek(i));
        textView.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    private int positionToDayOfWeek(int i) {
        int i2 = i + this.firstDayOfWeek;
        int i3 = this.daysInWeek;
        return i2 > i3 ? i2 - i3 : i2;
    }
}
