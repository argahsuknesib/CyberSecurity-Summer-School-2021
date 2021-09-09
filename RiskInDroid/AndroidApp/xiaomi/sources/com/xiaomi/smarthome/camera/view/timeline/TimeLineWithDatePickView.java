package com.xiaomi.smarthome.camera.view.timeline;

import _m_j.cki;
import _m_j.gqg;
import _m_j.mi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class TimeLineWithDatePickView extends LinearLayout implements TimeLineControlView.TimeLineCallback {
    public CAMERA_FUNC_STATUS cameraFuncStatus = CAMERA_FUNC_STATUS.STATUS_DEFAULT;
    int mCurrentSelectView = -1;
    ArrayList<DateItem> mDateItems = new ArrayList<>();
    RecyclerView mHorizontalScrollView;
    boolean mIsRealPlay = true;
    long mLastRecordTime;
    LayoutInflater mLayoutInflater;
    int mOrientation = 1;
    TimeLineControlView.TimeLineCallback mTimeLineCallback;
    TimeLineControlView mTimeLineControlView;
    MyAdapter myAdapter = new MyAdapter();

    public enum CAMERA_FUNC_STATUS {
        STATUS_DEFAULT,
        STATUS_SPEAK,
        STATUS_LISTEN
    }

    public boolean isPlayRealTime() {
        return false;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mTimeLineControlView.setEnabled(z);
        this.myAdapter.notifyDataSetChanged();
    }

    public TimeLineWithDatePickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onUpdateTime(long j) {
        TimeLineControlView.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onUpdateTime(j);
        }
        setSeletciontTime(j);
    }

    public void onSelectTime(long j) {
        TimeLineControlView.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onSelectTime(j);
        }
        setSeletciontTime(j);
    }

    public void onPlayLive() {
        TimeLineControlView.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onPlayLive();
        }
        setSeletction(this.mDateItems.size() - 1);
    }

    public void onCancel() {
        TimeLineControlView.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
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
        this.mTimeLineControlView = (TimeLineControlView) findViewById(R.id.time_line_control);
        this.mTimeLineControlView.setTimeLineCallback(this);
        this.mHorizontalScrollView = (RecyclerView) findViewById(R.id.date_pick_scroll);
        this.mHorizontalScrollView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mHorizontalScrollView.setAdapter(this.myAdapter);
        this.mHorizontalScrollView.setHasFixedSize(true);
    }

    class MyAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private MyAdapter() {
        }

        public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyHolder(LayoutInflater.from(TimeLineWithDatePickView.this.getContext()).inflate((int) R.layout.time_line_date_pick_item, (ViewGroup) null));
        }

        public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            final MyHolder myHolder = (MyHolder) o000OOo0;
            DateItem dateItem = TimeLineWithDatePickView.this.mDateItems.get(i);
            final TextView textView = myHolder.textView;
            if (TimeLineWithDatePickView.this.mCurrentSelectView != i) {
                if (TimeLineWithDatePickView.this.mOrientation == 1) {
                    textView.setBackgroundResource(R.drawable.player_button_02);
                } else {
                    textView.setBackgroundResource(R.drawable.player_button_02_land);
                }
                textView.setTextColor(ColorStateList.valueOf(-5066062));
            } else {
                if (TimeLineWithDatePickView.this.mOrientation == 1) {
                    textView.setBackgroundResource(R.drawable.player_button_01);
                } else {
                    textView.setBackgroundResource(R.drawable.player_button_01_land);
                }
                textView.setTextColor(ColorStateList.valueOf(-1));
            }
            textView.setTag(dateItem);
            textView.setText(dateItem.dateStr);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.view.timeline.TimeLineWithDatePickView.MyAdapter.AnonymousClass1 */

                public void onClick(View view) {
                    TimeLineWithDatePickView.this.mCurrentSelectView = TimeLineWithDatePickView.this.mHorizontalScrollView.getChildAdapterPosition(myHolder.itemView);
                    Object tag = textView.getTag();
                    if (tag != null && (tag instanceof DateItem)) {
                        TimeLineWithDatePickView.this.selectDate(textView, (DateItem) tag);
                    }
                    MyAdapter.this.notifyDataSetChanged();
                }
            });
            textView.setEnabled(TimeLineWithDatePickView.this.mTimeLineControlView.isEnabled());
        }

        public int getItemCount() {
            return TimeLineWithDatePickView.this.mDateItems.size();
        }

        class MyHolder extends RecyclerView.O000OOo0 {
            TextView textView;

            public MyHolder(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.date_txt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshDate() {
        this.myAdapter.notifyDataSetChanged();
        setSeletciontTime(getSelectTime());
        cki.O000000o("TimeLineWithDatePickView", "refreshDate .....");
    }

    /* access modifiers changed from: package-private */
    public void selectDate(View view, DateItem dateItem) {
        updatePlayTime(dateItem.startTime, false);
        TimeLineControlView.TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onSelectTime(dateItem.startTime);
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeletciontTime(long j) {
        if (isPlayRealTime() || j == 0) {
            setSeletction(this.mDateItems.size() - 1);
            return;
        }
        String O00000o = mi.O00000o(j);
        for (int i = 0; i < this.mDateItems.size(); i++) {
            if (O00000o.equals(this.mDateItems.get(i).dateStr)) {
                setSeletction(i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeletctionView(int i) {
        this.myAdapter.notifyDataSetChanged();
        if (this.mCurrentSelectView != i) {
            this.mCurrentSelectView = i;
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeletction(int i) {
        if (i >= 0 && i < this.myAdapter.getItemCount()) {
            setSeletctionView(i);
        }
    }

    public void setTimeLineCallback(TimeLineControlView.TimeLineCallback timeLineCallback) {
        this.mTimeLineCallback = timeLineCallback;
    }

    public void setTimeItems(List<TimeItem> list) {
        if (list.size() > 0) {
            this.mLastRecordTime = list.get(list.size() - 1).O00000o0;
        }
        this.mTimeLineControlView.setTimeItems(list);
        long j = 0;
        this.mDateItems.clear();
        for (int i = 0; i < list.size(); i++) {
            TimeItem timeItem = list.get(i);
            if (timeItem.f5243O000000o >= j) {
                DateItem dateItem = new DateItem();
                dateItem.startTime = timeItem.f5243O000000o;
                dateItem.dateStr = mi.O00000o(timeItem.f5243O000000o);
                this.mDateItems.add(dateItem);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeZone(mi.O000000o());
                gregorianCalendar.setTimeInMillis(timeItem.f5243O000000o);
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                gregorianCalendar2.setTimeZone(mi.O000000o());
                gregorianCalendar.setTimeInMillis(gregorianCalendar2.getTimeInMillis() + 86400010);
                j = gregorianCalendar.getTimeInMillis();
            }
        }
        if (this.mCurrentSelectView == -1) {
            this.mCurrentSelectView = this.mDateItems.size() - 1;
        }
        refreshDate();
    }

    public void synCurrentTime(long j) {
        if (j != 0) {
            this.mTimeLineControlView.synCurrentTime(j);
        }
    }

    public void updatePlayTime(long j, boolean z) {
        this.mTimeLineControlView.updatePlayTime(j);
        setSeletciontTime(j);
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
        refreshDate();
    }
}
