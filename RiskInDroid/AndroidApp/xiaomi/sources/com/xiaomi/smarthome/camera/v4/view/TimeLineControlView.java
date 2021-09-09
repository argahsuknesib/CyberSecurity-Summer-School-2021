package com.xiaomi.smarthome.camera.v4.view;

import _m_j.civ;
import _m_j.mi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.v4.view.ImageDrawable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class TimeLineControlView extends View implements ScaleGestureDetector.OnScaleGestureListener {
    long mBeforeScaleTime;
    int mBottomPadding;
    long mCurrentTime;
    int mHalfW;
    Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.camera.v4.view.TimeLineControlView.AnonymousClass1 */

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (TimeLineControlView.this.mIsLastPress) {
                            TimeLineControlView timeLineControlView = TimeLineControlView.this;
                            timeLineControlView.mIsLastLongPress = true;
                            timeLineControlView.movePressLast();
                            TimeLineControlView.this.mHandler.sendEmptyMessageDelayed(3, 50);
                            return;
                        }
                        TimeLineControlView.this.mHandler.removeMessages(3);
                    }
                } else if (TimeLineControlView.this.mIsNextPress) {
                    TimeLineControlView timeLineControlView2 = TimeLineControlView.this;
                    timeLineControlView2.mIsNextLongPress = true;
                    timeLineControlView2.movePressNext();
                    TimeLineControlView.this.mHandler.sendEmptyMessageDelayed(2, 50);
                } else {
                    TimeLineControlView.this.mHandler.removeMessages(2);
                }
            } else if (TimeLineControlView.this.mTimeLineCallback != null) {
                TimeLineControlView.this.mCurrentTime = System.currentTimeMillis() + TimeLineControlView.this.mOffsetCurrentTime;
                if (Math.abs(TimeLineControlView.this.mCurrentTime - TimeLineControlView.this.getSelectTime()) < 15000) {
                    TimeLineControlView.this.setLivePlay();
                    civ.O00000o("TimeLine", " selectTime near now ");
                } else if (TimeLineControlView.this.mTimeItems.isEmpty()) {
                    TimeLineControlView.this.updatePlayTime(System.currentTimeMillis());
                    if (TimeLineControlView.this.mTimeLineCallback != null) {
                        TimeLineControlView.this.mTimeLineCallback.onCancel();
                    }
                } else if (TimeLineControlView.this.mTimeLineCallback != null) {
                    TimeLineControlView.this.mTimeLineCallback.onSelectTime(TimeLineControlView.this.getSelectTime());
                }
                TimeLineControlView.this.mIsPress = false;
            }
        }
    };
    ArrayList<ImageDrawable> mImageDrawables = new ArrayList<>();
    boolean mIsLastLongPress = false;
    boolean mIsLastPress = false;
    boolean mIsNextLongPress = false;
    boolean mIsNextPress = false;
    boolean mIsPress = false;
    ImageDrawable mLastDrawable;
    int mLastDrawableWidth;
    private int mLineLen = 5001;
    boolean mMediaPlayer = false;
    boolean mNeedNextButton = true;
    ImageDrawable mNextDrawable;
    long mOffsetCurrentTime;
    int mOffsetPos;
    boolean mOnscaleBegin = false;
    Paint mPaint;
    ScaleGestureDetector mScaleGestureDetector;
    int mTimeBarW;
    List<TimeItem> mTimeItems = new ArrayList();
    TimeLineCallback mTimeLineCallback;
    Drawable mTimelMotionBg;
    Drawable mTimelineBg;
    Drawable mTimelinePointer;
    Drawable mTimelineSaveSelBg;
    Drawable mTimelineSelBg;
    int mTopH;
    int mTouchStartX;
    int mWidthPer5Minutes;
    int mWidthPer5MinutesBase;
    float mWidthScaleFators = 1.0f;

    public interface TimeLineCallback {
        void onCancel();

        void onPlayLive();

        void onSelectTime(long j);

        void onUpdateTime(long j);
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public void setNeedNextButton(boolean z) {
        this.mNeedNextButton = z;
    }

    public void setTimeLineCallback(TimeLineCallback timeLineCallback) {
        this.mTimeLineCallback = timeLineCallback;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.mWidthScaleFators *= scaleGestureDetector.getScaleFactor();
        scale(this.mWidthScaleFators);
        return true;
    }

    public void scale(float f) {
        this.mWidthScaleFators = f;
        if (this.mWidthScaleFators > 10.0f) {
            this.mWidthScaleFators = 10.0f;
        }
        if (this.mWidthScaleFators < 0.5f) {
            this.mWidthScaleFators = 0.5f;
        }
        this.mWidthPer5Minutes = (int) (((float) this.mWidthPer5MinutesBase) * this.mWidthScaleFators);
        this.mOffsetPos = (int) (((this.mCurrentTime - this.mBeforeScaleTime) * ((long) this.mWidthPer5Minutes)) / 300000);
        invalidate();
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.mOnscaleBegin = true;
        this.mBeforeScaleTime = getSelectTime();
        return true;
    }

    public void setTimeItems(List<TimeItem> list) {
        this.mTimeItems = list;
        invalidate();
    }

    public TimeLineControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        Resources resources = getContext().getResources();
        this.mTopH = resources.getDimensionPixelSize(R.dimen.time_line_topbar_h);
        this.mTimeBarW = resources.getDimensionPixelSize(R.dimen.time_line_timebar_w);
        this.mWidthPer5MinutesBase = resources.getDimensionPixelSize(R.dimen.time_line_time_5m_w);
        this.mWidthPer5Minutes = (int) (((float) this.mWidthPer5MinutesBase) * this.mWidthScaleFators);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mTimelineBg = resources.getDrawable(R.drawable.progress_bg_01);
        this.mTimelineSelBg = resources.getDrawable(R.drawable.progress_bg_02);
        this.mTimelMotionBg = resources.getDrawable(R.drawable.progress_bg_02);
        this.mTimelineSaveSelBg = resources.getDrawable(R.drawable.progress_bg_03);
        this.mBottomPadding = 0;
        this.mTimelinePointer = resources.getDrawable(R.drawable.progress_components_pointer_nor);
        if (this.mNeedNextButton) {
            this.mLastDrawable = new ImageDrawable(resources.getDrawable(R.drawable.progress_button_last_nor), resources.getDrawable(R.drawable.progress_button_last_pres));
            this.mNextDrawable = new ImageDrawable(resources.getDrawable(R.drawable.progress_button_next_nor), resources.getDrawable(R.drawable.progress_button_next_pres));
            this.mLastDrawableWidth = resources.getDimensionPixelOffset(R.dimen.time_line_last_w);
            this.mImageDrawables.add(this.mLastDrawable);
            this.mImageDrawables.add(this.mNextDrawable);
            this.mLastDrawable.setOnTouchListener(new ImageDrawable.OnTouchListener() {
                /* class com.xiaomi.smarthome.camera.v4.view.TimeLineControlView.AnonymousClass2 */

                public void onActionDown() {
                    civ.O000000o("TimeLine", "last down");
                    TimeLineControlView timeLineControlView = TimeLineControlView.this;
                    timeLineControlView.mIsPress = true;
                    timeLineControlView.mIsLastLongPress = false;
                    timeLineControlView.mIsLastPress = true;
                    timeLineControlView.mHandler.sendEmptyMessageDelayed(3, 1000);
                }

                public void onActionUp() {
                    civ.O000000o("TimeLine", "last up");
                    TimeLineControlView timeLineControlView = TimeLineControlView.this;
                    timeLineControlView.mIsLastPress = false;
                    timeLineControlView.mHandler.removeMessages(3);
                    if (!TimeLineControlView.this.mIsLastLongPress) {
                        TimeLineControlView.this.movePrev();
                    }
                    TimeLineControlView timeLineControlView2 = TimeLineControlView.this;
                    timeLineControlView2.mIsLastLongPress = false;
                    timeLineControlView2.notifyUpdate();
                }
            });
            this.mNextDrawable.setOnTouchListener(new ImageDrawable.OnTouchListener() {
                /* class com.xiaomi.smarthome.camera.v4.view.TimeLineControlView.AnonymousClass3 */

                public void onActionDown() {
                    civ.O000000o("TimeLine", "next down");
                    TimeLineControlView timeLineControlView = TimeLineControlView.this;
                    timeLineControlView.mIsPress = true;
                    timeLineControlView.mIsNextLongPress = false;
                    timeLineControlView.mIsNextPress = true;
                    timeLineControlView.mHandler.sendEmptyMessageDelayed(2, 1000);
                }

                public void onActionUp() {
                    civ.O000000o("TimeLine", "next up");
                    TimeLineControlView timeLineControlView = TimeLineControlView.this;
                    timeLineControlView.mIsNextPress = false;
                    timeLineControlView.mHandler.removeMessages(2);
                    if (!TimeLineControlView.this.mIsNextLongPress) {
                        TimeLineControlView.this.moveNext();
                    }
                    TimeLineControlView timeLineControlView2 = TimeLineControlView.this;
                    timeLineControlView2.mIsNextLongPress = false;
                    timeLineControlView2.notifyUpdate();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void movePrev() {
        if (this.mTimeItems.size() != 0) {
            long selectTime = getSelectTime() - ((long) ((int) (30000.0f / this.mWidthScaleFators)));
            if (selectTime >= this.mTimeItems.get(0).f5243O000000o) {
                if (selectTime < this.mTimeItems.get(0).O00000o0) {
                    setPlayTime(this.mTimeItems.get(0).f5243O000000o);
                    return;
                }
                TimeItem needItem = getNeedItem(selectTime, false);
                if (needItem != null) {
                    setPlayTime(needItem.f5243O000000o);
                } else {
                    setPlayTime(this.mTimeItems.get(0).f5243O000000o);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void movePressLast() {
        if (this.mTimeItems.size() != 0) {
            long j = (long) ((int) (30000.0f / this.mWidthScaleFators));
            long selectTime = getSelectTime() - j;
            if (selectTime >= this.mTimeItems.get(0).f5243O000000o) {
                if (selectTime < this.mTimeItems.get(0).O00000o0) {
                    setPlayTime(selectTime);
                    return;
                }
                int size = this.mTimeItems.size();
                int i = 1;
                while (i < size) {
                    if (selectTime < this.mTimeItems.get(i).f5243O000000o) {
                        int i2 = i - 1;
                        if (selectTime < this.mTimeItems.get(i2).O00000o0 - j) {
                            setPlayTime(selectTime);
                            return;
                        } else {
                            setPlayTime(this.mTimeItems.get(i2).O00000o0 - j);
                            return;
                        }
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void moveNext() {
        if (this.mTimeItems.size() != 0) {
            long selectTime = getSelectTime() + ((long) ((int) (30000.0f / this.mWidthScaleFators)));
            List<TimeItem> list = this.mTimeItems;
            if (selectTime <= list.get(list.size() - 1).O00000o0) {
                List<TimeItem> list2 = this.mTimeItems;
                if (selectTime >= list2.get(list2.size() - 1).f5243O000000o) {
                    setLivePlay();
                    return;
                }
                TimeItem needItem = getNeedItem(selectTime, true);
                if (needItem != null) {
                    setPlayTime(needItem.f5243O000000o);
                } else {
                    setLivePlay();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void movePressNext() {
        if (this.mTimeItems.size() != 0) {
            long selectTime = getSelectTime() + ((long) ((int) (30000.0f / this.mWidthScaleFators)));
            List<TimeItem> list = this.mTimeItems;
            if (selectTime <= list.get(list.size() - 1).O00000o0) {
                List<TimeItem> list2 = this.mTimeItems;
                if (selectTime >= list2.get(list2.size() - 1).f5243O000000o) {
                    setPlayTime(selectTime);
                    return;
                }
                int size = this.mTimeItems.size() - 2;
                while (size >= 0) {
                    TimeItem timeItem = this.mTimeItems.get(size);
                    if (selectTime <= timeItem.f5243O000000o) {
                        size--;
                    } else if (selectTime < timeItem.O00000o0) {
                        setPlayTime(selectTime);
                        return;
                    } else {
                        setPlayTime(this.mTimeItems.get(size + 1).f5243O000000o);
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyUpdate() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 1200);
    }

    /* access modifiers changed from: package-private */
    public void setLivePlay() {
        this.mHandler.removeMessages(1);
        setPlayTime(this.mCurrentTime);
        TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onPlayLive();
        }
    }

    public void setMediaPlayer(boolean z) {
        this.mMediaPlayer = z;
    }

    public void synCurrentTime(long j) {
        this.mOffsetCurrentTime = j - System.currentTimeMillis();
        this.mCurrentTime = j;
        postInvalidate();
    }

    public void updatePlayTime(long j) {
        if (j == 0) {
            j = this.mCurrentTime;
        }
        this.mOffsetPos -= (int) (((j - getSelectTime()) * ((long) this.mWidthPer5Minutes)) / 300000);
        postInvalidate();
    }

    private void setPlayTime(long j) {
        this.mOffsetPos -= (int) (((j - getSelectTime()) * ((long) this.mWidthPer5Minutes)) / 300000);
        postInvalidate();
        TimeLineCallback timeLineCallback = this.mTimeLineCallback;
        if (timeLineCallback != null) {
            timeLineCallback.onUpdateTime(j);
        }
    }

    public void setJustPlayTime(long j) {
        this.mOffsetPos -= (int) (((j - getSelectTime()) * ((long) this.mWidthPer5Minutes)) / 300000);
        postInvalidate();
    }

    public boolean isPlayRealTime() {
        long selectTime = getSelectTime();
        List<TimeItem> list = this.mTimeItems;
        if (list == null || list.size() <= 0) {
            return false;
        }
        List<TimeItem> list2 = this.mTimeItems;
        return selectTime > list2.get(list2.size() - 1).O00000o0;
    }

    public long getSelectTime() {
        return getTime(this.mHalfW);
    }

    /* access modifiers changed from: package-private */
    public long getTime(int i) {
        return this.mCurrentTime + ((((long) ((i - this.mHalfW) - this.mOffsetPos)) * 300000) / ((long) this.mWidthPer5Minutes));
    }

    /* access modifiers changed from: package-private */
    public int getPos(long j) {
        return (int) ((((j - this.mCurrentTime) * ((long) this.mWidthPer5Minutes)) / 300000) + ((long) this.mHalfW) + ((long) this.mOffsetPos));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        this.mHalfW = i5 / 2;
        if (this.mNeedNextButton) {
            int i6 = i4 - i2;
            this.mLastDrawable.setRect(0, 3, this.mLastDrawableWidth, (i6 - this.mBottomPadding) - 3);
            this.mNextDrawable.setRect(i5 - this.mLastDrawableWidth, 3, i5, (i6 - this.mBottomPadding) - 3);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TimeLineCallback timeLineCallback;
        if (!this.mMediaPlayer) {
            Iterator<ImageDrawable> it = this.mImageDrawables.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().onTouchEvent(motionEvent)) {
                    z = true;
                }
            }
            if (z) {
                invalidate();
                return true;
            }
        }
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        if (this.mOnscaleBegin) {
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.mOnscaleBegin = false;
                notifyUpdate();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.mIsPress = true;
            this.mHandler.removeMessages(1);
            this.mTouchStartX = (int) motionEvent.getX();
        } else if (motionEvent.getAction() == 2) {
            this.mOffsetPos += (int) (motionEvent.getX() - ((float) this.mTouchStartX));
            long selectTime = getSelectTime();
            this.mCurrentTime = System.currentTimeMillis() + this.mOffsetCurrentTime;
            long j = this.mCurrentTime;
            if (selectTime > j) {
                setJustPlayTime(System.currentTimeMillis());
                civ.O00000o0("TimeLine", "only update currentTime");
            } else if (j - selectTime > 2000 && (timeLineCallback = this.mTimeLineCallback) != null) {
                timeLineCallback.onUpdateTime(getSelectTime());
            }
            this.mTouchStartX = (int) motionEvent.getX();
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.mTouchStartX = 0;
            notifyUpdate();
        }
        invalidate();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean getIsPress() {
        return this.mIsPress;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3  */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        int i;
        long j;
        int i2;
        int i3;
        Canvas canvas3;
        int i4;
        Canvas canvas4 = canvas;
        super.dispatchDraw(canvas);
        int width = getWidth();
        int height = getHeight() - this.mBottomPadding;
        this.mCurrentTime = System.currentTimeMillis() + this.mOffsetCurrentTime;
        int i5 = 0;
        this.mTimelineBg.setBounds(0, 0, width, height);
        this.mTimelineBg.draw(canvas4);
        canvas.save();
        int i6 = this.mLastDrawableWidth;
        canvas4.clipRect(new Rect(i6 + 0, 0, width - i6, height + 1));
        TimeDay timeDay = new TimeDay(getTime(-52));
        timeDay.minute = (timeDay.minute / 5) * 5;
        timeDay.second = 0;
        timeDay.updateTimeInMillis();
        long j2 = timeDay.millis;
        int pos = getPos(timeDay.millis) + 0;
        int i7 = timeDay.hour + 1;
        int i8 = timeDay.minute;
        long j3 = 0;
        int i9 = 0;
        int i10 = -20;
        while (i9 < this.mTimeItems.size()) {
            TimeItem timeItem = this.mTimeItems.get(i9);
            int pos2 = getPos(timeItem.f5243O000000o) + i5;
            int i11 = i9;
            int i12 = width;
            long j4 = timeItem.f5243O000000o + timeItem.O00000Oo;
            long j5 = this.mCurrentTime;
            if (j5 <= j4) {
                j4 = j5;
            }
            int pos3 = getPos(j4);
            int i13 = i12;
            if (pos2 > i13 || pos3 < 0 || pos3 < i10) {
                canvas3 = canvas;
                j = j2;
                i2 = i8;
                i = pos;
                i3 = i13;
            } else {
                j = j2;
                if (timeItem.f5243O000000o > j3) {
                    i2 = i8;
                    i = pos;
                    if (timeItem.f5243O000000o - j3 < ((long) this.mLineLen)) {
                        i4 = getPos(j3);
                        if (i4 < i10) {
                            i4 = i10;
                        }
                        if (timeItem.O00000oO != 1) {
                            this.mTimelineSaveSelBg.setBounds(i4, 0, pos3, height);
                            canvas3 = canvas;
                            this.mTimelineSaveSelBg.draw(canvas3);
                        } else {
                            canvas3 = canvas;
                            if (timeItem.O00000oo) {
                                this.mTimelMotionBg.setBounds(i4, 0, pos3, height);
                                this.mTimelMotionBg.draw(canvas3);
                            } else {
                                this.mTimelineSelBg.setBounds(i4, 0, pos3, height);
                                i3 = i13;
                                this.mTimelineSelBg.draw(canvas3);
                                i10 = pos3;
                                j3 = j4;
                            }
                        }
                        i3 = i13;
                        i10 = pos3;
                        j3 = j4;
                    }
                } else {
                    i2 = i8;
                    i = pos;
                }
                i4 = pos2;
                if (i4 < i10) {
                }
                if (timeItem.O00000oO != 1) {
                }
                i3 = i13;
                i10 = pos3;
                j3 = j4;
            }
            i9 = i11 + 1;
            canvas4 = canvas3;
            width = i3;
            i8 = i2;
            j2 = j;
            pos = i;
            i5 = 0;
        }
        long j6 = j2;
        Canvas canvas5 = canvas4;
        int i14 = width;
        this.mPaint.setTextSize(30.0f);
        this.mPaint.setStrokeWidth(1.0f);
        int i15 = i7;
        int i16 = i8;
        int i17 = pos;
        while (i17 < i14 + 50) {
            if (i16 == 60) {
                this.mPaint.setColor(-5852989);
                float f = (float) i17;
                int i18 = this.mTopH;
                int i19 = height + 0;
                canvas2 = canvas5;
                canvas.drawLine(f, (float) ((i18 * 3) + 0), f, (float) (i19 - (i18 * 2)), this.mPaint);
                if (i15 == 24) {
                    i15 = 0;
                }
                if (i15 == 0 || i15 == 23) {
                    this.mPaint.setColor(-8355712);
                    canvas2.drawText(mi.O00000o0(j6), (float) (i17 + 5), 50.0f, this.mPaint);
                }
                this.mPaint.setColor(-8353911);
                canvas2.drawText(i15 + ":00", (float) (i17 + 10), (float) ((i19 - (this.mTopH * 2)) - 10), this.mPaint);
                i15++;
                i16 = 0;
            } else {
                canvas2 = canvas5;
                if (i16 == 30) {
                    this.mPaint.setColor(-5852989);
                    float f2 = (float) i17;
                    int i20 = this.mTopH;
                    int i21 = height + 0;
                    canvas.drawLine(f2, (float) ((i20 * 3) + 0), f2, (float) (i21 - (i20 * 2)), this.mPaint);
                    this.mPaint.setColor(-8353911);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i15 - 1);
                    sb.append(":30");
                    canvas2.drawText(sb.toString(), (float) (i17 + 10), (float) ((i21 - (this.mTopH * 2)) - 10), this.mPaint);
                } else {
                    this.mPaint.setColor(-5852989);
                    float f3 = (float) i17;
                    int i22 = this.mTopH;
                    canvas.drawLine(f3, (float) ((i22 * 9) + 0), f3, (float) ((height + 0) - (i22 * 10)), this.mPaint);
                }
            }
            i16 += 5;
            j6 += 300000;
            i17 += this.mWidthPer5Minutes;
            canvas5 = canvas2;
        }
        Canvas canvas6 = canvas5;
        Drawable drawable = this.mTimelinePointer;
        int i23 = (i14 / 2) + 0;
        int i24 = this.mTimeBarW;
        drawable.setBounds(i23 - (i24 / 2), 0, i23 + (i24 / 2), height + 0 + this.mBottomPadding);
        this.mTimelinePointer.draw(canvas6);
        canvas.restore();
        if (!this.mMediaPlayer) {
            Iterator<ImageDrawable> it = this.mImageDrawables.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas6);
            }
        }
    }

    public static class TimeDay {
        public int day;
        public int hour;
        public long millis;
        public int minute;
        public int month;
        public int second;
        public int year;

        public TimeDay(long j) {
            updateTime(j);
        }

        public void updateTime(long j) {
            this.millis = j;
            GregorianCalendar gregorianCalendar = new GregorianCalendar(mi.O000000o());
            gregorianCalendar.setTimeInMillis(this.millis);
            this.year = gregorianCalendar.get(1);
            this.month = gregorianCalendar.get(2) + 1;
            this.day = gregorianCalendar.get(5);
            this.hour = gregorianCalendar.get(11);
            this.minute = gregorianCalendar.get(12);
            this.second = gregorianCalendar.get(13);
        }

        public void updateTimeInMillis() {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
            gregorianCalendar.set(this.year, this.month - 1, this.day, this.hour, this.minute, this.second);
            this.millis = gregorianCalendar.getTimeInMillis();
        }
    }

    private TimeItem getNeedItem(long j, boolean z) {
        if (z) {
            int size = this.mTimeItems.size() - 1;
            TimeItem timeItem = null;
            boolean z2 = false;
            for (int i = 0; i <= size; i++) {
                TimeItem timeItem2 = this.mTimeItems.get(i);
                if (!z2) {
                    timeItem = timeItem2;
                }
                if (i < size && this.mTimeItems.get(i + 1).f5243O000000o - timeItem2.O00000o0 <= ((long) this.mLineLen)) {
                    z2 = true;
                } else if (i == size - 1 && z2) {
                    return null;
                } else {
                    if (timeItem.f5243O000000o >= j) {
                        return timeItem;
                    }
                    z2 = false;
                }
            }
            return null;
        }
        for (int size2 = this.mTimeItems.size() - 1; size2 >= 0; size2--) {
            TimeItem timeItem3 = this.mTimeItems.get(size2);
            if ((size2 <= 0 || timeItem3.f5243O000000o - this.mTimeItems.get(size2 - 1).O00000o0 > ((long) this.mLineLen)) && timeItem3.f5243O000000o <= j) {
                return timeItem3;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.mLastDrawable.mPressedDrawable = getResources().getDrawable(R.drawable.progress_button_last_land_pres);
            this.mNextDrawable.mPressedDrawable = getResources().getDrawable(R.drawable.progress_button_next_land_pres);
            return;
        }
        this.mLastDrawable.mPressedDrawable = getResources().getDrawable(R.drawable.progress_button_last_pres);
        this.mNextDrawable.mPressedDrawable = getResources().getDrawable(R.drawable.progress_button_next_pres);
    }
}
