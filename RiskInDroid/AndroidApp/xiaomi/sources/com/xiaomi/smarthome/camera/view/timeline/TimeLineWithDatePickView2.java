package com.xiaomi.smarthome.camera.view.timeline;

import _m_j.civ;
import _m_j.gqg;
import _m_j.mi;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.sdcard.fragment.DateRecyclerAdapter;
import com.xiaomi.smarthome.camera.view.calendar.DateUtils;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView2;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoChildListData;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TreeMap;

public class TimeLineWithDatePickView2 extends LinearLayout implements TimeLineControlView2.TimeLineCallback {
    private int beforeFullVisibility;
    public CAMERA_FUNC_STATUS cameraFuncStatus = CAMERA_FUNC_STATUS.STATUS_DEFAULT;
    private long currentDay0 = 0;
    List<CloudVideoDate> dateListDays = new ArrayList();
    public DateRecyclerAdapter dateListViewAdapter;
    TextView mCurrentSelectView;
    ArrayList<DateItem> mDateItems = new ArrayList<>();
    LinearLayout mDatePick;
    HorizontalScrollView mHorizontalScrollView;
    boolean mIsRealPlay = true;
    long mLastRecordTime;
    LayoutInflater mLayoutInflater;
    int mOrientation = 1;
    TimeLineControlView2.TimeLineCallback mTimeLineCallback;
    TimeLineControlView2 mTimeLineControlView;
    ImageView next_day;
    ImageView pre_day;
    final SimpleDateFormat sdfDays = new SimpleDateFormat("yyyy-MM-dd");
    RecyclerView time_line_date_list;
    RelativeLayout time_line_title;
    TextView tv_time_line_title;
    private String[] weeks;

    public enum CAMERA_FUNC_STATUS {
        STATUS_DEFAULT,
        STATUS_SPEAK,
        STATUS_LISTEN
    }

    public boolean isPlayRealTime() {
        return false;
    }

    public void setCloudVip(boolean z) {
        this.mTimeLineControlView.setCloudVip(z);
    }

    public void setFull(boolean z) {
        if (z) {
            this.beforeFullVisibility = this.time_line_date_list.getVisibility();
            this.time_line_title.setVisibility(8);
            this.time_line_date_list.setVisibility(8);
        } else {
            this.time_line_title.setVisibility(0);
            this.time_line_date_list.setVisibility(this.beforeFullVisibility);
        }
        this.mTimeLineControlView.setFull(z);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mTimeLineControlView.setEnabled(z);
        try {
            this.mDatePick.setEnabled(z);
            for (int i = 0; i < this.mDatePick.getChildCount(); i++) {
                this.mDatePick.getChildAt(i).findViewById(R.id.date_txt).setEnabled(z);
            }
        } catch (Exception e) {
            civ.O00000o0("TimeLineWithDatePickView", e.toString());
        }
    }

    public TimeLineWithDatePickView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.weeks = new String[]{context.getString(R.string.sunday1), context.getString(R.string.monday1), context.getString(R.string.tuesday1), context.getString(R.string.wednesday1), context.getString(R.string.thursday1), context.getString(R.string.friday1), context.getString(R.string.saturday1)};
    }

    public void onUpdateTime(long j) {
        civ.O000000o("TimeLineWithDatePickView", "onUpdateTime=" + mi.O00000Oo(j));
        setSeletciontTime2(j);
        TimeLineControlView2.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onUpdateTime(j);
        }
    }

    public void onSelectTime(long j) {
        civ.O000000o("TimeLineWithDatePickView", "onSelectTime=" + mi.O00000Oo(j));
        setSeletciontTime2(j);
        TimeLineControlView2.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onSelectTime(j);
        }
    }

    public void onChangeTime(long j) {
        TimeLineControlView2.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onChangeTime(j);
        }
    }

    public void onPlayLive() {
        TimeLineControlView2.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onPlayLive();
        }
        setSeletction2(this.dateListViewAdapter.getItemCount() - 1);
    }

    public void onCancel() {
        TimeLineControlView2.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onCancel();
        }
    }

    public void setPeopleMove(boolean z) {
        this.mTimeLineControlView.setPeopleMove(z);
    }

    public void setAreaMove(boolean z) {
        this.mTimeLineControlView.setAreaMove(z);
    }

    public void setBabyCry(boolean z) {
        this.mTimeLineControlView.setBabyCry(z);
    }

    public void setFace(boolean z) {
        this.mTimeLineControlView.setFace(z);
    }

    public void setAi(boolean z) {
        this.mTimeLineControlView.setAi(z);
    }

    public void setPetMove(boolean z) {
        this.mTimeLineControlView.setPetMove(z);
    }

    static class DateItem {
        String dateStr;
        long startTime;

        DateItem() {
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mLayoutInflater = LayoutInflater.from(getContext());
        this.mTimeLineControlView = (TimeLineControlView2) findViewById(R.id.time_line_control);
        this.mTimeLineControlView.setTimeLineCallback(this);
        this.mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.date_pick_scroll);
        this.mDatePick = (LinearLayout) findViewById(R.id.date_pick);
        this.time_line_title = (RelativeLayout) findViewById(R.id.time_line_title);
        this.tv_time_line_title = (TextView) findViewById(R.id.tv_time_line_title);
        this.tv_time_line_title.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.view.timeline.$$Lambda$TimeLineWithDatePickView2$aN_ccWZpGODq1bAKNNjJUGBl4_Q */

            public final void onClick(View view) {
                TimeLineWithDatePickView2.this.lambda$onFinishInflate$0$TimeLineWithDatePickView2(view);
            }
        });
        this.time_line_date_list = (RecyclerView) findViewById(R.id.time_line_date_list);
        this.dateListViewAdapter = new DateRecyclerAdapter(getContext());
        this.time_line_date_list.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.time_line_date_list.setAdapter(this.dateListViewAdapter);
        this.dateListViewAdapter.setListener(new DateRecyclerAdapter.IItemClickListener() {
            /* class com.xiaomi.smarthome.camera.view.timeline.$$Lambda$TimeLineWithDatePickView2$ccur9z2d8LPfxNhRVMc5sEcsSng */

            public final void onItemClick(View view, int i, Object obj) {
                TimeLineWithDatePickView2.this.lambda$onFinishInflate$1$TimeLineWithDatePickView2(view, i, (CloudVideoDate) obj);
            }
        });
        this.pre_day = (ImageView) findViewById(R.id.pre_day);
        this.next_day = (ImageView) findViewById(R.id.next_day);
        ImageView imageView = this.pre_day;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.view.timeline.$$Lambda$TimeLineWithDatePickView2$IeTAc6_WsDp2Lt0VHuQJLU06H2A */

                public final void onClick(View view) {
                    TimeLineWithDatePickView2.this.lambda$onFinishInflate$2$TimeLineWithDatePickView2(view);
                }
            });
        }
        ImageView imageView2 = this.next_day;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.view.timeline.$$Lambda$TimeLineWithDatePickView2$oE7j1XaizMND59AHhVe4kkUSRtA */

                public final void onClick(View view) {
                    TimeLineWithDatePickView2.this.lambda$onFinishInflate$3$TimeLineWithDatePickView2(view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onFinishInflate$0$TimeLineWithDatePickView2(View view) {
        if (this.time_line_date_list.getVisibility() == 0) {
            this.time_line_date_list.setVisibility(8);
        } else {
            this.time_line_date_list.setVisibility(0);
        }
    }

    public /* synthetic */ void lambda$onFinishInflate$1$TimeLineWithDatePickView2(View view, int i, CloudVideoDate cloudVideoDate) {
        if (cloudVideoDate.isHasVideo) {
            selectDate(cloudVideoDate);
        }
    }

    public /* synthetic */ void lambda$onFinishInflate$2$TimeLineWithDatePickView2(View view) {
        int i = this.dateListViewAdapter.selectedItemPosition;
        while (i > 0) {
            i--;
            CloudVideoDate cloudVideoDate = (CloudVideoDate) this.dateListViewAdapter.getItem(i);
            if (cloudVideoDate != null && cloudVideoDate.isHasVideo) {
                this.time_line_date_list.scrollToPosition(i);
                this.dateListViewAdapter.selectedItemPosition = i;
                selectDate(cloudVideoDate);
                this.dateListViewAdapter.notifyDataSetChanged();
                return;
            }
        }
    }

    public /* synthetic */ void lambda$onFinishInflate$3$TimeLineWithDatePickView2(View view) {
        int i = this.dateListViewAdapter.selectedItemPosition;
        while (i < this.dateListViewAdapter.getItemCount()) {
            i++;
            CloudVideoDate cloudVideoDate = (CloudVideoDate) this.dateListViewAdapter.getItem(i);
            if (cloudVideoDate != null && cloudVideoDate.isHasVideo) {
                this.time_line_date_list.scrollToPosition(i);
                this.dateListViewAdapter.selectedItemPosition = i;
                selectDate(cloudVideoDate);
                this.dateListViewAdapter.notifyDataSetChanged();
                return;
            }
        }
    }

    public void setDateList(List<CloudVideoDate> list) {
        this.dateListDays = list;
        this.dateListViewAdapter.setData(this.dateListDays);
        if (this.dateListViewAdapter.selectedItemPosition == -1) {
            int itemCount = this.dateListViewAdapter.getItemCount() - 1;
            while (itemCount >= 0) {
                CloudVideoDate cloudVideoDate = this.dateListDays.get(itemCount);
                if (cloudVideoDate == null || !cloudVideoDate.isHasVideo) {
                    itemCount--;
                } else {
                    if (this.dateListViewAdapter.selectedItemPosition != itemCount) {
                        this.time_line_date_list.scrollToPosition(itemCount);
                        DateRecyclerAdapter dateRecyclerAdapter = this.dateListViewAdapter;
                        dateRecyclerAdapter.selectedItemPosition = itemCount;
                        dateRecyclerAdapter.notifyDataSetChanged();
                    }
                    updateTitleTime(cloudVideoDate);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void selectDate(CloudVideoDate cloudVideoDate) {
        updateTitleTime(cloudVideoDate);
        updatePlayTime(cloudVideoDate.startTime, false);
        TimeLineControlView2.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onSelectTime(cloudVideoDate.startTime);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateTitleTime(CloudVideoDate cloudVideoDate) {
        long dayTS0 = CloudVideoUtils.getDayTS0(cloudVideoDate.startTime);
        if (this.currentDay0 != dayTS0) {
            this.currentDay0 = dayTS0;
            if (dayTS0 == CloudVideoUtils.getCurrentDayTS0()) {
                this.tv_time_line_title.setText((int) R.string.today);
            } else {
                this.tv_time_line_title.setText(String.format("%s %s", DateUtils.getMonthDay(cloudVideoDate.startTime), this.weeks[cloudVideoDate.week]));
            }
            onChangeTime(cloudVideoDate.startTime);
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeletciontTime2(long j) {
        if (isPlayRealTime() || j == 0) {
            setSeletction2(this.dateListViewAdapter.getItemCount() - 1);
            return;
        }
        long dayTS0 = CloudVideoUtils.getDayTS0(j);
        civ.O000000o("TimeLineWithDatePickView", "str=" + mi.O00000Oo(dayTS0) + "  " + this.dateListViewAdapter.selectedItemPosition);
        int i = this.dateListViewAdapter.selectedItemPosition;
        int i2 = i;
        while (true) {
            if (i >= this.dateListDays.size() && i2 < 0) {
                return;
            }
            if (i2 >= 0 && dayTS0 == this.dateListDays.get(i2).timeStamp) {
                updateTitleTime(this.dateListDays.get(i2));
                setSeletction2(i2);
                return;
            } else if (i < 0 || i >= this.dateListDays.size() || dayTS0 != this.dateListDays.get(i).timeStamp) {
                i++;
                i2--;
            } else {
                updateTitleTime(this.dateListDays.get(i));
                setSeletction2(i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeletction2(int i) {
        if (this.dateListViewAdapter.selectedItemPosition != i) {
            this.time_line_date_list.scrollToPosition(i);
            DateRecyclerAdapter dateRecyclerAdapter = this.dateListViewAdapter;
            dateRecyclerAdapter.selectedItemPosition = i;
            dateRecyclerAdapter.notifyDataSetChanged();
        }
    }

    public void setTimeLineCallback(TimeLineControlView2.TimeLineCallback timeLineCallback) {
        this.mTimeLineCallback = timeLineCallback;
    }

    public void setTimeItems(List<TimeItem> list) {
        int i;
        long currentDayTS0 = CloudVideoUtils.getCurrentDayTS0();
        Calendar instance = Calendar.getInstance();
        this.dateListDays.clear();
        int i2 = 29;
        while (true) {
            i = 0;
            if (i2 < 0) {
                break;
            }
            CloudVideoDate cloudVideoDate = new CloudVideoDate();
            long j = currentDayTS0 - (((long) i2) * 86400000);
            instance.setTime(new Date(j));
            String format = this.sdfDays.format(Long.valueOf(j));
            cloudVideoDate.day = format.split("-")[2];
            cloudVideoDate.month = format.split("-")[1];
            cloudVideoDate.year = format.split("-")[0];
            cloudVideoDate.week = instance.get(7) - 1;
            cloudVideoDate.timeStamp = j;
            cloudVideoDate.isHasVideo = false;
            this.dateListDays.add(cloudVideoDate);
            i2--;
        }
        if (list.size() > 0) {
            this.mLastRecordTime = list.get(list.size() - 1).O00000o0;
        }
        this.mTimeLineControlView.setTimeItems(list);
        this.mDateItems.clear();
        long j2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            TimeItem timeItem = list.get(i3);
            if (timeItem.f5243O000000o >= j2) {
                DateItem dateItem = new DateItem();
                dateItem.startTime = timeItem.f5243O000000o;
                dateItem.dateStr = mi.O00000o0(timeItem.f5243O000000o);
                this.mDateItems.add(dateItem);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeZone(mi.O000000o());
                gregorianCalendar.setTimeInMillis(timeItem.f5243O000000o);
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                gregorianCalendar2.setTimeZone(mi.O000000o());
                gregorianCalendar.setTimeInMillis(gregorianCalendar2.getTimeInMillis() + 86400010);
                j2 = gregorianCalendar.getTimeInMillis();
            }
        }
        int i4 = 0;
        while (i < this.mDateItems.size() && i4 < this.dateListDays.size()) {
            DateItem dateItem2 = this.mDateItems.get(i);
            CloudVideoDate cloudVideoDate2 = this.dateListDays.get(i4);
            if (CloudVideoUtils.getDayTS0(dateItem2.startTime) == cloudVideoDate2.timeStamp) {
                cloudVideoDate2.isHasVideo = true;
                cloudVideoDate2.startTime = dateItem2.startTime;
                cloudVideoDate2.dateStr = dateItem2.dateStr;
                civ.O000000o("TimeLineWithDatePickView", mi.O00000o0(dateItem2.startTime));
                i++;
            } else if (CloudVideoUtils.getDayTS0(dateItem2.startTime) < cloudVideoDate2.timeStamp) {
                i++;
            } else if (CloudVideoUtils.getDayTS0(dateItem2.startTime) <= cloudVideoDate2.timeStamp) {
            }
            i4++;
        }
        setDateList(this.dateListDays);
    }

    public void setTimeItems(TreeMap<Long, List<CloudVideoChildListData>> treeMap) {
        this.mTimeLineControlView.setTimeItems(treeMap);
    }

    public void setTimeEventItems(TreeMap<Long, List<AlarmVideo>> treeMap) {
        this.mTimeLineControlView.setTimeEventItems(treeMap);
    }

    public void synCurrentTime(long j) {
        if (j != 0) {
            this.mTimeLineControlView.synCurrentTime(j);
        }
    }

    public void updatePlayTime(long j, boolean z) {
        this.mTimeLineControlView.updatePlayTime(j);
        setSeletciontTime2(j);
    }

    public long getSelectTime() {
        return this.mTimeLineControlView.getSelectTime();
    }

    public boolean getIsPress() {
        return this.mTimeLineControlView.getIsPress();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cameraFuncStatus != CAMERA_FUNC_STATUS.STATUS_SPEAK) {
            return super.dispatchTouchEvent(motionEvent);
        }
        getContext();
        gqg.O000000o((int) R.string.speaking_block);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mOrientation = configuration.orientation;
    }
}
