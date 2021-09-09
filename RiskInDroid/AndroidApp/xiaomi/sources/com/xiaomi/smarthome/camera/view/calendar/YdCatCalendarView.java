package com.xiaomi.smarthome.camera.view.calendar;

import _m_j.civ;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.calendar.CEn7DayRecyclerAdapterNew;
import java.util.ArrayList;
import java.util.List;

public class YdCatCalendarView extends LinearLayout {
    public static final String TAG = "YdCatCalendarView";
    private static final String[] arrMonth = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
    View btn_calendar_left_page;
    View btn_calendar_right_page;
    RecyclerView customRecycler_calendar;
    ImageView iv_arrow_left;
    ImageView iv_arrow_right;
    boolean leftCanClick = true;
    List<CalendarDate> mCalendarDay = new ArrayList();
    public CEn7DayRecyclerAdapterNew mCalendarDayAdapter;
    YdCatCalendarListener mCalendarListener;
    private long mCurrentTimeMillis = System.currentTimeMillis();
    private int mShowDaysAfterNow = 30;
    private int mShowDaysBeforeNow = 30;
    boolean rightCanClick = false;
    TextView tv_calendar;

    public interface YdCatCalendarListener {
        void clickOnDate(CalendarDate calendarDate, View view);

        void clickOnLeftPage();

        void clickOnRightPage();
    }

    public YdCatCalendarView(Context context) {
        super(context);
        initView(context);
    }

    public YdCatCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public YdCatCalendarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(1);
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.layout_cen_calendar_view_new, (ViewGroup) null);
        addView(inflate);
        this.tv_calendar = (TextView) inflate.findViewById(R.id.tv_calendar);
        this.btn_calendar_left_page = inflate.findViewById(R.id.btn_calendar_left_page);
        this.btn_calendar_right_page = inflate.findViewById(R.id.btn_calendar_right_page);
        this.iv_arrow_right = (ImageView) inflate.findViewById(R.id.iv_arrow_right);
        this.iv_arrow_left = (ImageView) inflate.findViewById(R.id.iv_arrow_left);
        this.btn_calendar_left_page.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.view.calendar.YdCatCalendarView.AnonymousClass1 */

            public void onClick(View view) {
                if (YdCatCalendarView.this.leftCanClick) {
                    CalendarDate calendarDate = DateUtils.getCalendarDate(YdCatCalendarView.this.mCalendarDay.get(YdCatCalendarView.this.mCalendarDay.size() / 2).time - 2592000000L);
                    YdCatCalendarView.this.mCalendarDay.clear();
                    YdCatCalendarView.this.initCalender(calendarDate);
                    YdCatCalendarView.this.mCalendarDayAdapter.resetWithNotifyData(calendarDate.year, calendarDate.month);
                    String str = YdCatCalendarView.TAG;
                    civ.O000000o(str, "left click:" + calendarDate.year + "/" + calendarDate.month + "/" + calendarDate.day);
                    YdCatCalendarView.this.checkCalendarLimit(calendarDate);
                    if (YdCatCalendarView.this.mCalendarListener != null) {
                        YdCatCalendarView.this.mCalendarListener.clickOnLeftPage();
                    }
                }
            }
        });
        this.btn_calendar_right_page.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.view.calendar.YdCatCalendarView.AnonymousClass2 */

            public void onClick(View view) {
                if (YdCatCalendarView.this.rightCanClick) {
                    CalendarDate calendarDate = DateUtils.getCalendarDate(YdCatCalendarView.this.mCalendarDay.get(YdCatCalendarView.this.mCalendarDay.size() / 2).time + 2592000000L);
                    YdCatCalendarView.this.mCalendarDay.clear();
                    YdCatCalendarView.this.initCalender(calendarDate);
                    YdCatCalendarView.this.mCalendarDayAdapter.resetWithNotifyData(calendarDate.year, calendarDate.month);
                    String str = YdCatCalendarView.TAG;
                    civ.O000000o(str, "right click:" + calendarDate.year + "/" + calendarDate.month + "/" + calendarDate.day);
                    YdCatCalendarView.this.checkCalendarLimit(calendarDate);
                    if (YdCatCalendarView.this.mCalendarListener != null) {
                        YdCatCalendarView.this.mCalendarListener.clickOnRightPage();
                    }
                }
            }
        });
        this.customRecycler_calendar = (RecyclerView) inflate.findViewById(R.id.customRecycler_calendar);
    }

    class MyGridLayoutManager extends GridLayoutManager {
        public MyGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
            super(context, attributeSet, i, i2);
        }

        public MyGridLayoutManager(Context context, int i) {
            super(context, i);
        }

        public MyGridLayoutManager(Context context, int i, int i2, boolean z) {
            super(context, i, i2, z);
        }

        public void onLayoutChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
            try {
                super.onLayoutChildren(o000o0oo, o000OO0o);
            } catch (Exception unused) {
            }
        }
    }

    public void initRecycler(Context context) {
        this.mCalendarDay.clear();
        CalendarDate calendarDate = DateUtils.getCalendarDate(this.mCurrentTimeMillis);
        initCalender(calendarDate);
        this.customRecycler_calendar.setLayoutManager(new MyGridLayoutManager(context, 7));
        this.mCalendarDayAdapter = new CEn7DayRecyclerAdapterNew(context, this.mCalendarDay, calendarDate);
        this.customRecycler_calendar.setAdapter(this.mCalendarDayAdapter);
        this.mCalendarDayAdapter.chooseDate(calendarDate);
        this.mCalendarDayAdapter.setListener(new CEn7DayRecyclerAdapterNew.CEn7DayListener() {
            /* class com.xiaomi.smarthome.camera.view.calendar.YdCatCalendarView.AnonymousClass3 */

            public void onClickItem(int i, View view) {
                if (YdCatCalendarView.this.mCalendarListener != null) {
                    YdCatCalendarView.this.mCalendarListener.clickOnDate(YdCatCalendarView.this.mCalendarDay.get(i), view);
                }
            }
        });
        checkCalendarLimit(calendarDate);
    }

    public void initCalender(CalendarDate calendarDate) {
        int i;
        int parseInt = Integer.parseInt(calendarDate.month) + 1;
        TextView textView = this.tv_calendar;
        StringBuilder sb = new StringBuilder();
        sb.append(calendarDate.year);
        sb.append("-");
        sb.append(parseInt <= 9 ? "0".concat(String.valueOf(parseInt)) : String.valueOf(parseInt));
        textView.setText(sb.toString());
        CalendarDate calendarDate2 = DateUtils.getCalendarDate(calendarDate.time - (CEn7DayRecyclerAdapterNew.CLOUD_DAYS * 86400000));
        int parseInt2 = Integer.parseInt(calendarDate2.way);
        String str = TAG;
        civ.O000000o(str, "firstDay=" + calendarDate2.month + "-" + calendarDate2.day);
        civ.O000000o(TAG, "plus=".concat(String.valueOf(parseInt2)));
        this.mShowDaysBeforeNow = (int) (((long) parseInt2) + CEn7DayRecyclerAdapterNew.CLOUD_DAYS);
        String str2 = TAG;
        civ.O000000o(str2, "mShowDaysBeforeNow=" + this.mShowDaysBeforeNow);
        long j = 0;
        while (true) {
            i = 0;
            if (j >= ((long) this.mShowDaysBeforeNow)) {
                break;
            }
            CalendarDate calendarDate3 = DateUtils.getCalendarDate(calendarDate.time - (j * 86400000));
            String str3 = TAG;
            civ.O000000o(str3, calendarDate3.month + "-" + calendarDate3.day);
            this.mCalendarDay.add(0, calendarDate3);
            j++;
        }
        List<CalendarDate> list = this.mCalendarDay;
        CalendarDate calendarDate4 = list.get(list.size() - 1);
        int parseInt3 = 7 - Integer.parseInt(calendarDate4.way);
        while (i < parseInt3) {
            i++;
            this.mCalendarDay.add(DateUtils.getCalendarDate(calendarDate4.time + (((long) i) * 86400000)));
        }
    }

    public void setChooseDate(long j) {
        this.mCalendarDayAdapter.chooseDate(DateUtils.getCalendarDate(j));
    }

    public CalendarDate getChoosedDate() {
        return this.mCalendarDayAdapter.getChooseDate();
    }

    public void setCalendarListener(YdCatCalendarListener ydCatCalendarListener) {
        this.mCalendarListener = ydCatCalendarListener;
    }

    public void addHaveVideoDay(CalendarDate calendarDate) {
        this.mCalendarDayAdapter.addHaveRecordDayIntoAll(calendarDate);
    }

    public void addHaveWarningDay(CalendarDate calendarDate) {
        this.mCalendarDayAdapter.addHaveEventDayIntoAll(calendarDate);
    }

    public void refreshFlag() {
        this.mCalendarDayAdapter.resetRecordAndEventFlag();
        List<CalendarDate> list = this.mCalendarDay;
        CalendarDate calendarDate = list.get(list.size() / 2);
        String str = TAG;
        civ.O000000o(str, "refreshFlag:" + calendarDate.year + "/" + calendarDate.month + "/" + calendarDate.day);
        checkCalendarLimit(calendarDate);
    }

    public List<CalendarDate> getCalendarDays() {
        return this.mCalendarDay;
    }

    public int getCalendarDayIndex(CalendarDate calendarDate) {
        int size = this.mCalendarDay.size();
        for (int i = 0; i < size; i++) {
            if (this.mCalendarDay.get(i).getDateFormat("yyyyMMdd").equals(calendarDate.getDateFormat("yyyyMMdd"))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0109  */
    public void checkCalendarLimit(CalendarDate calendarDate) {
        boolean z;
        CalendarDate calendarDate2 = DateUtils.getCalendarDate(this.mCurrentTimeMillis);
        String str = TAG;
        civ.O000000o(str, "date:" + calendarDate.year + "/" + calendarDate.month + "/" + calendarDate.day);
        String str2 = TAG;
        civ.O000000o(str2, "current:" + calendarDate2.year + "/" + calendarDate2.month + "/" + calendarDate2.day);
        if (!calendarDate.year.equals(calendarDate2.year) || !calendarDate.month.equals(calendarDate2.month)) {
            this.iv_arrow_right.setBackgroundResource(R.drawable.icon_arrow_right);
            this.rightCanClick = true;
            this.btn_calendar_right_page.setClickable(true);
        } else {
            this.iv_arrow_right.setBackgroundResource(R.drawable.icon_arrow_right_alpha);
            this.rightCanClick = false;
            this.btn_calendar_right_page.setClickable(false);
        }
        List<CalendarDate> list = this.mCalendarDayAdapter.getmHaveEventDayAll();
        List<CalendarDate> list2 = this.mCalendarDayAdapter.getmHaveRecordDayAll();
        if (!(list == null || list.size() == 0)) {
            CalendarDate calendarDate3 = list.get(list.size() - 1);
            if (Integer.parseInt(calendarDate.year) > Integer.parseInt(calendarDate3.year) || Integer.parseInt(calendarDate.month) > Integer.parseInt(calendarDate3.month)) {
                z = false;
                if (!(list2 == null || list2.size() == 0)) {
                    CalendarDate calendarDate4 = list2.get(list2.size() - 1);
                    if (Integer.parseInt(calendarDate.year) > Integer.parseInt(calendarDate4.year) || Integer.parseInt(calendarDate.month) > Integer.parseInt(calendarDate4.month)) {
                        z = false;
                    }
                }
                if (!z) {
                    this.iv_arrow_left.setBackgroundResource(R.drawable.icon_arrow_left_alpha);
                    this.leftCanClick = false;
                    this.btn_calendar_left_page.setClickable(false);
                    return;
                }
                this.iv_arrow_left.setBackgroundResource(R.drawable.icon_arrow_left);
                this.leftCanClick = true;
                this.btn_calendar_left_page.setClickable(true);
                return;
            }
        }
        z = true;
        CalendarDate calendarDate42 = list2.get(list2.size() - 1);
        z = false;
        if (!z) {
        }
    }
}
