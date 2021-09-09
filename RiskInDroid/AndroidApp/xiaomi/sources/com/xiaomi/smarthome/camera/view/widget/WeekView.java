package com.xiaomi.smarthome.camera.view.widget;

import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class WeekView extends LinearLayout implements View.OnClickListener {
    private int mBgSqareWidth;
    private int mCurrentDay = 0;
    private long mCurrentTime;
    private int mDayTextSize;
    private List<View> mDayViewList;
    private int mEndTime;
    private int mMonthTextSize;
    private OnDayChangeListener mOnDayChangeListener;
    private int mStartTime;

    public interface OnDayChangeListener {
        void onDayChange(boolean z, int i, int i2, int i3);
    }

    public interface OnNewEventListener {
        void onNewEvent(int i, int i2);
    }

    public WeekView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WeekView(Context context) {
        super(context);
        init(context);
    }

    public void setOnDayChangeListener(OnDayChangeListener onDayChangeListener) {
        this.mOnDayChangeListener = onDayChangeListener;
    }

    public void processNewEvent(OnNewEventListener onNewEventListener) {
        Date date = new Date(this.mCurrentTime);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        onNewEventListener.onNewEvent((int) (date.getTime() / 1000), (int) (date.getTime() / 1000));
    }

    public int getCurrentDay() {
        return this.mCurrentDay;
    }

    public int getCurrentStartTime() {
        return this.mStartTime;
    }

    public int getCurrentEndTime() {
        return this.mEndTime;
    }

    public void forceSwitchToToday() {
        resetDayView();
        this.mDayViewList.get(0).setBackgroundResource(R.drawable.camera_weekview_day_bg);
        LinearLayout linearLayout = (LinearLayout) this.mDayViewList.get(0);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(Color.rgb(255, 255, 255));
            }
        }
        if (this.mOnDayChangeListener != null) {
            Date date = new Date(this.mCurrentTime);
            date.setHours(0);
            date.setMinutes(0);
            date.setSeconds(0);
            int time = (int) (date.getTime() / 1000);
            date.setHours(23);
            date.setMinutes(59);
            date.setSeconds(59);
            int time2 = (int) (date.getTime() / 1000);
            this.mStartTime = time;
            this.mEndTime = time2;
            this.mOnDayChangeListener.onDayChange(true, 0, time, time2);
        }
    }

    private void initTime(long j) {
        Date date = new Date(j);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        this.mStartTime = (int) (date.getTime() / 1000);
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        this.mEndTime = (int) (date.getTime() / 1000);
    }

    private void initTextSize(Context context) {
        getContext().getSystemService("window");
        this.mBgSqareWidth = (int) ((((float) hyy.O00000Oo(context instanceof Activity ? ((Activity) context).getIntent() : null).widthPixels) * 0.9f) / 7.0f);
        int i = this.mBgSqareWidth;
        this.mMonthTextSize = (int) (((float) i) / 4.0f);
        this.mDayTextSize = (int) (((float) i) / 3.0f);
    }

    private void init(Context context) {
        initTextSize(context);
        this.mDayViewList = new ArrayList();
        setOrientation(0);
        setPadding(0, dip2px(context, 9.0f), 0, dip2px(context, 9.0f));
        setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        long currentTimeMillis = System.currentTimeMillis();
        this.mCurrentTime = currentTimeMillis;
        initTime(currentTimeMillis);
        for (int i = 6; i >= 0; i--) {
            Date date = new Date(currentTimeMillis - (((long) i) * 86400000));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            View prepareDayView = prepareDayView(date.getMonth() + 1, date.getDate());
            prepareDayView.setTag(Integer.valueOf(i));
            prepareDayView.setOnClickListener(this);
            addView(prepareDayView, layoutParams);
        }
        if (this.mDayViewList.size() > 0) {
            int size = this.mDayViewList.size() - 1;
            this.mDayViewList.get(size).setBackgroundResource(R.drawable.camera_weekview_day_bg);
            for (int i2 = 0; i2 < ((LinearLayout) this.mDayViewList.get(size)).getChildCount(); i2++) {
                View childAt = ((LinearLayout) this.mDayViewList.get(size)).getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(Color.rgb(255, 255, 255));
                }
            }
        }
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private String getCharacterMonth(int i) {
        switch (i) {
            case 1:
                return getContext().getResources().getString(R.string.january);
            case 2:
                return getContext().getResources().getString(R.string.february);
            case 3:
                return getContext().getResources().getString(R.string.march);
            case 4:
                return getContext().getResources().getString(R.string.april);
            case 5:
                return getContext().getResources().getString(R.string.may);
            case 6:
                return getContext().getResources().getString(R.string.june);
            case 7:
                return getContext().getResources().getString(R.string.july);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return getContext().getResources().getString(R.string.august);
            case 9:
                return getContext().getResources().getString(R.string.september);
            case 10:
                return getContext().getResources().getString(R.string.october);
            case 11:
                return getContext().getResources().getString(R.string.november);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return getContext().getResources().getString(R.string.december);
            default:
                return "NO";
        }
    }

    private View prepareDayView(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(i2));
        textView.setTextSize(0, (float) this.mDayTextSize);
        textView.setTextColor(getResources().getColor(R.color.mj_color_black_70_transparent));
        textView.setTag(0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(getContext());
        textView2.setText(getCharacterMonth(i));
        textView2.setTextSize(0, (float) this.mMonthTextSize);
        textView2.setTextColor(getResources().getColor(R.color.mj_color_black_60_transparent));
        textView2.setTag(1);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(17);
        int i3 = this.mBgSqareWidth;
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(i3, i3));
        this.mDayViewList.add(linearLayout);
        return linearLayout2;
    }

    private void resetDayView() {
        for (int i = 0; i < this.mDayViewList.size(); i++) {
            LinearLayout linearLayout = (LinearLayout) this.mDayViewList.get(i);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
            for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt instanceof TextView) {
                    if (((Integer) childAt.getTag()).intValue() == 0) {
                        ((TextView) childAt).setTextColor(getResources().getColor(R.color.mj_color_black_70_transparent));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(R.color.mj_color_black_60_transparent));
                    }
                }
            }
        }
    }

    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        this.mCurrentDay = intValue;
        if (intValue >= 0 && intValue < this.mDayViewList.size()) {
            resetDayView();
            int i = 6 - intValue;
            this.mDayViewList.get(i).setBackgroundResource(R.drawable.camera_weekview_day_bg);
            LinearLayout linearLayout = (LinearLayout) this.mDayViewList.get(i);
            for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(Color.rgb(255, 255, 255));
                }
            }
            if (this.mOnDayChangeListener != null) {
                Date date = new Date(this.mCurrentTime - (((long) intValue) * 86400000));
                date.setHours(0);
                date.setMinutes(0);
                date.setSeconds(0);
                int time = (int) (date.getTime() / 1000);
                date.setHours(23);
                date.setMinutes(59);
                date.setSeconds(59);
                int time2 = (int) (date.getTime() / 1000);
                if (time == this.mStartTime && time2 == this.mEndTime) {
                    this.mOnDayChangeListener.onDayChange(false, intValue, time, time2);
                    return;
                }
                this.mStartTime = time;
                this.mEndTime = time2;
                this.mOnDayChangeListener.onDayChange(true, intValue, time, time2);
            }
        }
    }
}
