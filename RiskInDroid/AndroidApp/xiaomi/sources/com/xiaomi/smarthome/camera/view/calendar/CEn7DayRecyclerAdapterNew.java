package com.xiaomi.smarthome.camera.view.calendar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CEn7DayRecyclerAdapterNew extends RecyclerView.O000000o<CEn7DayViewHolder> {
    public static long CLOUD_DAYS = 7;
    public static final String TAG = "CEn7DayRecyclerAdapterNew";
    public static final String[] arrWeek = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    private Context CTX;
    public CEn7DayListener listener;
    private CalendarDate mChooseDate;
    private boolean[] mChose;
    private String mCurrentMonth;
    private String mCurrentYear;
    public List<CalendarDate> mDataInCurrentPage = new ArrayList();
    private List<CalendarDate> mHaveEventDayAll = new ArrayList();
    private List<Boolean> mHaveEventDayInCurrentPage = new ArrayList();
    private List<CalendarDate> mHaveRecordDayAll = new ArrayList();
    private List<Boolean> mHaveRecordDayInCurrentPage = new ArrayList();
    private LayoutInflater mInflater;
    private CalendarDate mToday;

    public interface CEn7DayListener {
        void onClickItem(int i, View view);
    }

    public CEn7DayRecyclerAdapterNew(Context context, List<CalendarDate> list, CalendarDate calendarDate) {
        this.CTX = context;
        this.mInflater = LayoutInflater.from(this.CTX);
        this.mDataInCurrentPage = list;
        this.mToday = calendarDate;
        this.mCurrentMonth = this.mToday.month;
        this.mCurrentYear = this.mToday.year;
        this.mChose = new boolean[this.mDataInCurrentPage.size()];
        for (int i = 0; i < this.mDataInCurrentPage.size(); i++) {
            this.mHaveRecordDayInCurrentPage.add(Boolean.FALSE);
            this.mHaveEventDayInCurrentPage.add(Boolean.FALSE);
        }
        int size = this.mDataInCurrentPage.size() - 1;
        while (size >= 0) {
            if (!this.mDataInCurrentPage.get(size).getMonth().equals(getMonth(System.currentTimeMillis())) || !this.mDataInCurrentPage.get(size).getDay().equals(getDay(System.currentTimeMillis()))) {
                size--;
            } else {
                this.mChose[size] = true;
                return;
            }
        }
    }

    public void addHaveRecordDayIntoAll(CalendarDate calendarDate) {
        this.mHaveRecordDayAll.add(calendarDate);
    }

    public void addHaveEventDayIntoAll(CalendarDate calendarDate) {
        this.mHaveEventDayAll.add(calendarDate);
    }

    public List<CalendarDate> getmHaveRecordDayAll() {
        return this.mHaveRecordDayAll;
    }

    public List<CalendarDate> getmHaveEventDayAll() {
        return this.mHaveEventDayAll;
    }

    public void setListener(CEn7DayListener cEn7DayListener) {
        this.listener = cEn7DayListener;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public CEn7DayViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mInflater.inflate((int) R.layout.item_week_new, viewGroup, false);
        inflate.getLayoutParams().width = viewGroup.getMeasuredWidth() / 7;
        return new CEn7DayViewHolder(inflate);
    }

    public void onBindViewHolder(CEn7DayViewHolder cEn7DayViewHolder, final int i) {
        CalendarDate calendarDate = this.mDataInCurrentPage.get(i);
        cEn7DayViewHolder.tv_date.setText(this.mDataInCurrentPage.get(i).getDay());
        final boolean z = true;
        cEn7DayViewHolder.tv_way.setText(arrWeek[Integer.parseInt(calendarDate.getWay()) - 1]);
        final boolean z2 = calendarDate.time > this.mToday.time;
        if (calendarDate.getDayStartAndEndTimeMillis()[0] >= this.mToday.getDayStartAndEndTimeMillis()[0] - (CLOUD_DAYS * 86400000)) {
            z = false;
        }
        if (calendarDate.year.equals(this.mCurrentYear)) {
            calendarDate.month.equals(this.mCurrentMonth);
        }
        if (z2) {
            cEn7DayViewHolder.tv_date.setTextColor(Color.parseColor("#33aaaaaa"));
        } else if (z) {
            cEn7DayViewHolder.tv_date.setTextColor(Color.parseColor("#33aaaaaa"));
        } else {
            CalendarDate calendarDate2 = this.mChooseDate;
            if (calendarDate2 == null || !calendarDate.equalsDate(calendarDate2)) {
                cEn7DayViewHolder.tv_date.setTextColor(cEn7DayViewHolder.itemView.getResources().getColor(R.color.mj_color_black));
            } else {
                cEn7DayViewHolder.tv_date.setTextColor(Color.parseColor("#ffffff"));
            }
        }
        CalendarDate calendarDate3 = this.mChooseDate;
        if (calendarDate3 == null || !calendarDate.equalsDate(calendarDate3)) {
            cEn7DayViewHolder.view_choose.setVisibility(4);
        } else {
            cEn7DayViewHolder.view_choose.setVisibility(0);
            cEn7DayViewHolder.tv_date.setTextColor(Color.parseColor("#ffffff"));
        }
        cEn7DayViewHolder.view_flag_1.setVisibility(8);
        cEn7DayViewHolder.view_flag_2.setVisibility(8);
        if (cEn7DayViewHolder.view_flag_1.getVisibility() == 0 && cEn7DayViewHolder.view_flag_2.getVisibility() == 0) {
            cEn7DayViewHolder.view_between.setVisibility(0);
        } else {
            cEn7DayViewHolder.view_between.setVisibility(8);
        }
        cEn7DayViewHolder.container.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.view.calendar.CEn7DayRecyclerAdapterNew.AnonymousClass1 */

            public void onClick(View view) {
                CEn7DayRecyclerAdapterNew.this.mDataInCurrentPage.get(i);
                if (!z2 && !z) {
                    CEn7DayRecyclerAdapterNew.this.chooseDate(i);
                    if (CEn7DayRecyclerAdapterNew.this.listener != null) {
                        CEn7DayRecyclerAdapterNew.this.listener.onClickItem(i, view);
                    }
                }
            }
        });
        cEn7DayViewHolder.container.date = calendarDate;
    }

    public int getItemCount() {
        return this.mDataInCurrentPage.size();
    }

    class CEn7DayViewHolder extends RecyclerView.O000OOo0 {
        ContentDescriptionCalendarView container;
        View itemView;
        TextView tv_date;
        TextView tv_way;
        View view_between;
        View view_choose;
        View view_flag_1;
        View view_flag_2;
        View view_locate;

        public CEn7DayViewHolder(View view) {
            super(view);
            this.itemView = view;
            this.tv_date = (TextView) view.findViewById(R.id.tv_date);
            this.tv_way = (TextView) view.findViewById(R.id.tv_way);
            this.view_choose = view.findViewById(R.id.view_choose);
            this.view_locate = view.findViewById(R.id.view_locate);
            this.view_flag_1 = view.findViewById(R.id.view_flag_1);
            this.view_flag_2 = view.findViewById(R.id.view_flag_2);
            this.view_between = view.findViewById(R.id.view_between);
            this.container = (ContentDescriptionCalendarView) view.findViewById(R.id.container);
        }
    }

    public String getDay(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(instance.get(5));
    }

    public String getMonth(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(instance.get(2) + 1);
    }

    public void chooseDate(int i) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.mChose;
            if (i2 < zArr.length) {
                zArr[i2] = false;
                i2++;
            } else {
                this.mChooseDate = this.mDataInCurrentPage.get(i);
                this.mChose[i] = true;
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void chooseDate(CalendarDate calendarDate) {
        int i = 0;
        while (true) {
            boolean[] zArr = this.mChose;
            if (i >= zArr.length) {
                break;
            }
            zArr[i] = false;
            i++;
        }
        for (int i2 = 0; i2 < this.mDataInCurrentPage.size(); i2++) {
            CalendarDate calendarDate2 = this.mDataInCurrentPage.get(i2);
            if (calendarDate2.month.equals(calendarDate.month) && calendarDate2.day.equals(calendarDate.day)) {
                this.mChooseDate = calendarDate2;
                this.mChose[i2] = true;
            }
        }
        notifyDataSetChanged();
    }

    public CalendarDate getChooseDate() {
        return this.mChooseDate;
    }

    private void reset(String str, String str2) {
        this.mCurrentYear = str;
        this.mCurrentMonth = str2;
        this.mChose = new boolean[this.mDataInCurrentPage.size()];
        this.mHaveEventDayInCurrentPage.clear();
        this.mHaveRecordDayInCurrentPage.clear();
        for (int i = 0; i < this.mDataInCurrentPage.size(); i++) {
            this.mHaveRecordDayInCurrentPage.add(Boolean.FALSE);
            this.mHaveEventDayInCurrentPage.add(Boolean.FALSE);
        }
        resetRecordAndEventFlag();
    }

    public void resetRecordAndEventFlag() {
        for (int i = 0; i < this.mDataInCurrentPage.size(); i++) {
            for (int i2 = 0; i2 < this.mHaveRecordDayAll.size(); i2++) {
                if (this.mHaveRecordDayAll.get(i2).equalsDate(this.mDataInCurrentPage.get(i))) {
                    this.mHaveRecordDayInCurrentPage.set(i, Boolean.TRUE);
                }
            }
            for (int i3 = 0; i3 < this.mHaveEventDayAll.size(); i3++) {
                if (this.mHaveEventDayAll.get(i3).equalsDate(this.mDataInCurrentPage.get(i))) {
                    this.mHaveEventDayInCurrentPage.set(i, Boolean.TRUE);
                }
            }
        }
        notifyItemRangeChanged(0, this.mDataInCurrentPage.size());
    }

    public void resetWithNotifyData(String str, String str2) {
        reset(str, str2);
        notifyItemRangeChanged(0, this.mDataInCurrentPage.size());
    }
}
