package com.xiaomi.smarthome.camera.view.timeline;

import _m_j.civ;
import _m_j.clq;
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
import com.xiaomi.smarthome.camera.view.timeline.ImageDrawable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class TimeLineControlView extends View implements ScaleGestureDetector.OnScaleGestureListener {
    private boolean areaMove = true;
    private boolean babyCry = true;
    Drawable mAreaMoveBg;
    Drawable mBabyCryBg;
    long mBeforeScaleTime;
    int mBottomPadding;
    long mCurrentTime;
    int mHalfW;
    Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView.AnonymousClass1 */

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
    Drawable mPeopleMoveBg;
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
    private boolean peopleMove = true;

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
        this.mPeopleMoveBg = resources.getDrawable(R.drawable.time_line_people_move_bg);
        this.mAreaMoveBg = resources.getDrawable(R.drawable.time_line_area_move_bg);
        this.mBabyCryBg = resources.getDrawable(R.drawable.time_line_baby_cry_bg);
        this.mBottomPadding = 0;
        this.mTimelinePointer = resources.getDrawable(R.drawable.progress_components_pointer_nor);
        if (this.mNeedNextButton) {
            this.mLastDrawable = new ImageDrawable(resources.getDrawable(R.drawable.progress_button_last_nor), resources.getDrawable(R.drawable.progress_button_last_pres));
            this.mNextDrawable = new ImageDrawable(resources.getDrawable(R.drawable.progress_button_next_nor), resources.getDrawable(R.drawable.progress_button_next_pres));
            this.mLastDrawableWidth = resources.getDimensionPixelOffset(R.dimen.time_line_last_w);
            this.mImageDrawables.add(this.mLastDrawable);
            this.mImageDrawables.add(this.mNextDrawable);
            this.mLastDrawable.setOnTouchListener(new ImageDrawable.OnTouchListener() {
                /* class com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView.AnonymousClass2 */

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
                /* class com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView.AnonymousClass3 */

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
                    boolean moveNext = !TimeLineControlView.this.mIsNextLongPress ? TimeLineControlView.this.moveNext() : true;
                    TimeLineControlView timeLineControlView2 = TimeLineControlView.this;
                    timeLineControlView2.mIsNextLongPress = false;
                    if (moveNext) {
                        timeLineControlView2.notifyUpdate();
                    }
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
    public boolean moveNext() {
        if (!isEnabled() || this.mTimeItems.size() == 0) {
            return false;
        }
        long selectTime = getSelectTime() + ((long) ((int) (30000.0f / this.mWidthScaleFators)));
        List<TimeItem> list = this.mTimeItems;
        if (selectTime > list.get(list.size() - 1).O00000o0) {
            setLivePlay();
            return false;
        }
        List<TimeItem> list2 = this.mTimeItems;
        if (selectTime >= list2.get(list2.size() - 1).f5243O000000o) {
            setLivePlay();
            return false;
        }
        TimeItem needItem = getNeedItem(selectTime, true);
        if (needItem != null) {
            setPlayTime(needItem.f5243O000000o);
            return true;
        }
        setLivePlay();
        return false;
    }

    /* access modifiers changed from: package-private */
    public void movePressNext() {
        if (isEnabled() && this.mTimeItems.size() != 0) {
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
        if (!isEnabled()) {
            return true;
        }
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
    public void dispatchDraw(Canvas canvas) {
        int i;
        long j;
        TimeLineControlView timeLineControlView = this;
        Canvas canvas2 = canvas;
        super.dispatchDraw(canvas);
        int width = getWidth();
        int height = getHeight() - timeLineControlView.mBottomPadding;
        long j2 = timeLineControlView.mCurrentTime;
        timeLineControlView.mCurrentTime = System.currentTimeMillis() + timeLineControlView.mOffsetCurrentTime;
        timeLineControlView.mOffsetPos += (int) (((timeLineControlView.mCurrentTime - j2) * ((long) timeLineControlView.mWidthPer5Minutes)) / 300000);
        int i2 = 0;
        timeLineControlView.mTimelineBg.setBounds(0, 0, width, height);
        timeLineControlView.mTimelineBg.draw(canvas2);
        canvas.save();
        int i3 = timeLineControlView.mLastDrawableWidth;
        canvas2.clipRect(new Rect(i3 + 0, 0, width - i3, height + 1));
        TimeDay timeDay = new TimeDay(timeLineControlView.getTime(-52));
        timeDay.minute = (timeDay.minute / 5) * 5;
        timeDay.second = 0;
        timeDay.updateTimeInMillis();
        long j3 = timeDay.millis;
        int pos = timeLineControlView.getPos(timeDay.millis) + 0;
        int i4 = timeDay.hour + 1;
        int i5 = timeDay.minute;
        int i6 = -20;
        long j4 = 0;
        int i7 = 0;
        while (i7 < timeLineControlView.mTimeItems.size()) {
            TimeItem timeItem = timeLineControlView.mTimeItems.get(i7);
            int i8 = i7;
            int i9 = i5;
            int pos2 = timeLineControlView.getPos(timeItem.f5243O000000o) + i2;
            long j5 = j3;
            int i10 = pos;
            long j6 = timeItem.f5243O000000o + timeItem.O00000Oo;
            long j7 = timeLineControlView.mCurrentTime;
            if (j7 > j6) {
                j7 = j6;
            }
            int pos3 = timeLineControlView.getPos(j7);
            if (pos2 > width || pos3 < 0 || pos3 < i6) {
                i = i8;
            } else {
                if (timeItem.f5243O000000o > j4) {
                    timeLineControlView = this;
                    j = j7;
                    if (timeItem.f5243O000000o - j4 < ((long) timeLineControlView.mLineLen)) {
                        pos2 = timeLineControlView.getPos(j4);
                    }
                } else {
                    timeLineControlView = this;
                    j = j7;
                }
                int i11 = pos2 < i6 ? i6 : pos2;
                int O000000o2 = clq.O000000o(timeItem.f5243O000000o);
                if (O000000o2 == 0) {
                    i = i8;
                    if (timeLineControlView.areaMove) {
                        timeLineControlView.mAreaMoveBg.setBounds(i11, 0, pos3, height);
                        timeLineControlView.mAreaMoveBg.draw(canvas2);
                    } else {
                        drawNoEventBg(i11, 0, pos3, height, canvas);
                    }
                } else if (O000000o2 == 1) {
                    i = i8;
                    if (timeLineControlView.peopleMove) {
                        timeLineControlView.mPeopleMoveBg.setBounds(i11, 0, pos3, height);
                        timeLineControlView.mPeopleMoveBg.draw(canvas2);
                    } else {
                        drawNoEventBg(i11, 0, pos3, height, canvas);
                    }
                } else if (O000000o2 != 7) {
                    i = i8;
                    drawNoEventBg(i11, 0, pos3, height, canvas);
                } else {
                    i = i8;
                    if (timeLineControlView.babyCry) {
                        timeLineControlView.mBabyCryBg.setBounds(i11, 0, pos3, height);
                        timeLineControlView.mBabyCryBg.draw(canvas2);
                    } else {
                        drawNoEventBg(i11, 0, pos3, height, canvas);
                    }
                }
                i6 = pos3;
                j4 = j;
            }
            i7 = i + 1;
            i5 = i9;
            j3 = j5;
            pos = i10;
            i2 = 0;
        }
        long j8 = j3;
        timeLineControlView.mPaint.setTextSize(30.0f);
        timeLineControlView.mPaint.setStrokeWidth(1.0f);
        int i12 = i5;
        int i13 = i4;
        for (int i14 = pos; i14 < width + 50; i14 += timeLineControlView.mWidthPer5Minutes) {
            if (i12 == 60) {
                timeLineControlView.mPaint.setColor(-5852989);
                float f = (float) i14;
                int i15 = timeLineControlView.mTopH;
                int i16 = height + 0;
                canvas.drawLine(f, (float) ((i15 * 3) + 0), f, (float) (i16 - (i15 * 2)), timeLineControlView.mPaint);
                if (i13 == 24) {
                    i13 = 0;
                }
                if (i13 == 0 || i13 == 23) {
                    timeLineControlView.mPaint.setColor(-8355712);
                    canvas2.drawText(mi.O00000o0(j8), (float) (i14 + 5), 50.0f, timeLineControlView.mPaint);
                }
                timeLineControlView.mPaint.setColor(-8353911);
                canvas2.drawText(i13 + ":00", (float) (i14 + 10), (float) ((i16 - (timeLineControlView.mTopH * 2)) - 10), timeLineControlView.mPaint);
                i13++;
                i12 = 0;
            } else if (i12 == 30) {
                timeLineControlView.mPaint.setColor(-5852989);
                float f2 = (float) i14;
                int i17 = timeLineControlView.mTopH;
                int i18 = height + 0;
                canvas.drawLine(f2, (float) ((i17 * 3) + 0), f2, (float) (i18 - (i17 * 2)), timeLineControlView.mPaint);
                timeLineControlView.mPaint.setColor(-8353911);
                StringBuilder sb = new StringBuilder();
                sb.append(i13 - 1);
                sb.append(":30");
                canvas2.drawText(sb.toString(), (float) (i14 + 10), (float) ((i18 - (timeLineControlView.mTopH * 2)) - 10), timeLineControlView.mPaint);
            } else {
                timeLineControlView.mPaint.setColor(-5852989);
                float f3 = (float) i14;
                int i19 = timeLineControlView.mTopH;
                canvas.drawLine(f3, (float) ((i19 * 9) + 0), f3, (float) ((height + 0) - (i19 * 10)), timeLineControlView.mPaint);
            }
            i12 += 5;
            j8 += 300000;
        }
        Drawable drawable = timeLineControlView.mTimelinePointer;
        int i20 = (width / 2) + 0;
        int i21 = timeLineControlView.mTimeBarW;
        drawable.setBounds(i20 - (i21 / 2), 0, i20 + (i21 / 2), height + 0 + timeLineControlView.mBottomPadding);
        timeLineControlView.mTimelinePointer.draw(canvas2);
        canvas.restore();
        if (!timeLineControlView.mMediaPlayer) {
            Iterator<ImageDrawable> it = timeLineControlView.mImageDrawables.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas2);
            }
        }
    }

    private void drawNoEventBg(int i, int i2, int i3, int i4, Canvas canvas) {
        this.mTimelineSelBg.setBounds(i, i2, i3, i4);
        this.mTimelineSelBg.draw(canvas);
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

    public void setPeopleMove(boolean z) {
        this.peopleMove = z;
        invalidate();
    }

    public void setAreaMove(boolean z) {
        this.areaMove = z;
        invalidate();
    }

    public void setBabyCry(boolean z) {
        this.babyCry = z;
        invalidate();
    }
}
