package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.Collection;

class MonthAdapter extends BaseAdapter {
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    public boolean hasStableIds() {
        return true;
    }

    MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
        this.previouslySelectedDates = dateSelector2.getSelectedDays();
    }

    public Long getItem(int i) {
        if (i < this.month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i)));
    }

    public long getItemId(int i) {
        return (long) (i / this.month.daysInWeek);
    }

    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    /* JADX WARN: Type inference failed for: r7v11, types: [android.view.View] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    public TextView getView(int i, View view, ViewGroup viewGroup) {
        initializeStyles(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i - firstPositionInMonth();
        if (firstPositionInMonth < 0 || firstPositionInMonth >= this.month.daysInMonth) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i2 = firstPositionInMonth + 1;
            textView.setTag(this.month);
            textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
            long day = this.month.getDay(i2);
            if (this.month.year == Month.current().year) {
                textView.setContentDescription(DateStrings.getMonthDayOfWeekDay(day));
            } else {
                textView.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(day));
            }
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        updateSelectedState(textView, item.longValue());
        return textView;
    }

    public void updateSelectedStates(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.previouslySelectedDates) {
            updateSelectedStateForDate(materialCalendarGridView, longValue.longValue());
        }
        DateSelector<?> dateSelector2 = this.dateSelector;
        if (dateSelector2 != null) {
            for (Long longValue2 : dateSelector2.getSelectedDays()) {
                updateSelectedStateForDate(materialCalendarGridView, longValue2.longValue());
            }
            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.create(j).equals(this.month)) {
            updateSelectedState((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(this.month.getDayOfMonth(j)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    private void updateSelectedState(TextView textView, long j) {
        CalendarItemStyle calendarItemStyle;
        if (textView != null) {
            if (this.calendarConstraints.getDateValidator().isValid(j)) {
                textView.setEnabled(true);
                if (isSelected(j)) {
                    calendarItemStyle = this.calendarStyle.selectedDay;
                } else if (UtcDates.getTodayCalendar().getTimeInMillis() == j) {
                    calendarItemStyle = this.calendarStyle.todayDay;
                } else {
                    calendarItemStyle = this.calendarStyle.day;
                }
            } else {
                textView.setEnabled(false);
                calendarItemStyle = this.calendarStyle.invalidDay;
            }
            calendarItemStyle.styleItem(textView);
        }
    }

    private boolean isSelected(long j) {
        for (Long longValue : this.dateSelector.getSelectedDays()) {
            if (UtcDates.canonicalYearMonthDay(j) == UtcDates.canonicalYearMonthDay(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    /* access modifiers changed from: package-private */
    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    /* access modifiers changed from: package-private */
    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    /* access modifiers changed from: package-private */
    public int positionToDay(int i) {
        return (i - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    /* access modifiers changed from: package-private */
    public int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    /* access modifiers changed from: package-private */
    public boolean withinMonth(int i) {
        return i >= firstPositionInMonth() && i <= lastPositionInMonth();
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstInRow(int i) {
        return i % this.month.daysInWeek == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isLastInRow(int i) {
        return (i + 1) % this.month.daysInWeek == 0;
    }
}
