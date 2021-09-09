package com.google.android.material.datepicker;

import _m_j.cb;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.xiaomi.smarthome.R;

class MonthsPagerAdapter extends RecyclerView.O000000o<ViewHolder> {
    private final CalendarConstraints calendarConstraints;
    private final Context context;
    private final DateSelector<?> dateSelector;
    private final int itemHeight;
    public final MaterialCalendar.OnDayClickListener onDayClickListener;

    MonthsPagerAdapter(Context context2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2, MaterialCalendar.OnDayClickListener onDayClickListener2) {
        Month start = calendarConstraints2.getStart();
        Month end = calendarConstraints2.getEnd();
        Month openAt = calendarConstraints2.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (openAt.compareTo(end) <= 0) {
            int dayHeight = MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(context2);
            int dayHeight2 = MaterialDatePicker.isFullscreen(context2) ? MaterialCalendar.getDayHeight(context2) : 0;
            this.context = context2;
            this.itemHeight = dayHeight + dayHeight2;
            this.calendarConstraints = calendarConstraints2;
            this.dateSelector = dateSelector2;
            this.onDayClickListener = onDayClickListener2;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public static class ViewHolder extends RecyclerView.O000OOo0 {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            this.monthTitle = (TextView) linearLayout.findViewById(R.id.month_title);
            cb.O000OOoo(this.monthTitle);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z) {
                this.monthTitle.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(linearLayout, true);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Month monthsLater = this.calendarConstraints.getStart().monthsLater(i);
        viewHolder.monthTitle.setText(monthsLater.getLongName(viewHolder.itemView.getContext()));
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().updateSelectedStates(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.google.android.material.datepicker.MonthsPagerAdapter.AnonymousClass1 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (materialCalendarGridView.getAdapter().withinMonth(i)) {
                    MonthsPagerAdapter.this.onDayClickListener.onDayClick(materialCalendarGridView.getAdapter().getItem(i).longValue());
                }
            }
        });
    }

    public long getItemId(int i) {
        return this.calendarConstraints.getStart().monthsLater(i).getStableId();
    }

    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    /* access modifiers changed from: package-private */
    public CharSequence getPageTitle(int i) {
        return getPageMonth(i).getLongName(this.context);
    }

    /* access modifiers changed from: package-private */
    public Month getPageMonth(int i) {
        return this.calendarConstraints.getStart().monthsLater(i);
    }

    /* access modifiers changed from: package-private */
    public int getPosition(Month month) {
        return this.calendarConstraints.getStart().monthsUntil(month);
    }
}
