package com.xiaomi.smarthome.camera.v4.view;

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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.v4.view.TimeLineControlView;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class TimeLineWithDatePickView extends LinearLayout implements TimeLineControlView.TimeLineCallback {
    public CAMERA_FUNC_STATUS cameraFuncStatus = CAMERA_FUNC_STATUS.STATUS_DEFAULT;
    TextView mCurrentSelectView;
    ArrayList<DateItem> mDateItems = new ArrayList<>();
    LinearLayout mDatePick;
    HorizontalScrollView mHorizontalScrollView;
    boolean mIsRealPlay = true;
    long mLastRecordTime;
    LayoutInflater mLayoutInflater;
    int mOrientation = 1;
    TimeLineControlView.TimeLineCallback mTimeLineCallback;
    TimeLineControlView mTimeLineControlView;

    public enum CAMERA_FUNC_STATUS {
        STATUS_DEFAULT,
        STATUS_SPEAK,
        STATUS_LISTEN
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
        this.mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.date_pick_scroll);
        this.mDatePick = (LinearLayout) findViewById(R.id.date_pick);
    }

    /* access modifiers changed from: package-private */
    public void refreshDate() {
        this.mDatePick.removeAllViews();
        for (int i = 0; i < this.mDateItems.size(); i++) {
            DateItem dateItem = this.mDateItems.get(i);
            View inflate = this.mLayoutInflater.inflate((int) R.layout.time_line_date_pick_item, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.date_txt);
            if (this.mOrientation == 1) {
                textView.setBackgroundResource(R.drawable.player_button_02);
            } else {
                textView.setBackgroundResource(R.drawable.player_button_02_land);
            }
            textView.setTag(dateItem);
            textView.setText(dateItem.dateStr);
            textView.setTextColor(ColorStateList.valueOf(-5066062));
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.view.TimeLineWithDatePickView.AnonymousClass1 */

                public void onClick(View view) {
                    TimeLineWithDatePickView.this.setSeletctionView(textView);
                    Object tag = TimeLineWithDatePickView.this.mCurrentSelectView.getTag();
                    if (tag != null && (tag instanceof DateItem)) {
                        TimeLineWithDatePickView timeLineWithDatePickView = TimeLineWithDatePickView.this;
                        timeLineWithDatePickView.selectDate(timeLineWithDatePickView.mCurrentSelectView, (DateItem) tag);
                    }
                }
            });
            this.mDatePick.addView(inflate);
        }
        setSeletciontTime(getSelectTime());
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
        String O00000o0 = mi.O00000o0(j);
        for (int i = 0; i < this.mDateItems.size(); i++) {
            if (O00000o0.equals(this.mDateItems.get(i).dateStr)) {
                setSeletction(i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeletctionView(TextView textView) {
        TextView textView2 = this.mCurrentSelectView;
        if (textView2 != textView) {
            if (textView2 != null) {
                if (this.mOrientation == 1) {
                    textView2.setBackgroundResource(R.drawable.player_button_02);
                } else {
                    textView2.setBackgroundResource(R.drawable.player_button_02_land);
                }
                this.mCurrentSelectView.setTextColor(ColorStateList.valueOf(-5066062));
            }
            this.mCurrentSelectView = textView;
            if (this.mOrientation == 1) {
                this.mCurrentSelectView.setBackgroundResource(R.drawable.player_button_01);
            } else {
                this.mCurrentSelectView.setBackgroundResource(R.drawable.player_button_01_land);
            }
            this.mCurrentSelectView.setTextColor(ColorStateList.valueOf(-1));
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeletction(int i) {
        if (i >= 0 && i < this.mDatePick.getChildCount()) {
            View findViewById = this.mDatePick.getChildAt(i).findViewById(R.id.date_txt);
            setSeletctionView((TextView) findViewById);
            this.mHorizontalScrollView.requestChildFocus(this.mDatePick, findViewById);
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
        this.mDateItems.clear();
        long j = 0;
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
        DateItem dateItem2 = new DateItem();
        dateItem2.startTime = 0;
        dateItem2.dateStr = getResources().getString(R.string.real_play);
        this.mDateItems.add(dateItem2);
        refreshDate();
    }

    public void synCurrentTime(long j) {
        if (j != 0) {
            this.mTimeLineControlView.synCurrentTime(j);
        }
    }

    public void updatePlayTime(long j, boolean z) {
        this.mIsRealPlay = z;
        if (j > this.mLastRecordTime || j == 0) {
            this.mIsRealPlay = true;
        }
        if (this.mIsRealPlay) {
            synCurrentTime(j);
        }
        this.mTimeLineControlView.updatePlayTime(j);
        setSeletciontTime(j);
    }

    public long getSelectTime() {
        return this.mTimeLineControlView.getSelectTime();
    }

    public boolean isPlayRealTime() {
        return this.mIsRealPlay;
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
