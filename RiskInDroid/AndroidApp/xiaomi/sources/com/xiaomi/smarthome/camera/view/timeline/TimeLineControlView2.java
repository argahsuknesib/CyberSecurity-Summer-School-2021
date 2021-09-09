package com.xiaomi.smarthome.camera.view.timeline;

import _m_j.civ;
import _m_j.clq;
import _m_j.mi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.timeline.ImageDrawable2;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoChildListData;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeMap;

public class TimeLineControlView2 extends View implements ScaleGestureDetector.OnScaleGestureListener {
    public static final String TAG = "TimeLineControlView2";
    protected boolean ai = true;
    protected boolean areaMove = true;
    protected boolean babyCry = true;
    int boundsBottom;
    int boundsTop;
    int drawablePadding = 50;
    protected boolean face = true;
    int height;
    int height_1_14;
    private boolean isCloudVip = true;
    int lastDrawPos = -20;
    int lastDrawPos_Event = -20;
    long lastEndTime = 0;
    long lastEndTime_Event = 0;
    int lastStartPos_Event = -20;
    long lastStartTime_Event = 0;
    protected Drawable mAIBg;
    protected Drawable mAreaMoveBg;
    protected Drawable mBabyCryBg;
    long mBeforeScaleTime;
    protected int mBottomPadding;
    long mCurrentTime;
    protected Drawable mFaceBg;
    int mHalfW;
    Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView2.AnonymousClass1 */

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                TimeLineControlView2.this.handlerNotifyUpdate();
            } else if (i != 2) {
                if (i == 3) {
                    if (TimeLineControlView2.this.mIsLastPress) {
                        TimeLineControlView2 timeLineControlView2 = TimeLineControlView2.this;
                        timeLineControlView2.mIsLastLongPress = true;
                        timeLineControlView2.movePressLast();
                        TimeLineControlView2.this.mHandler.sendEmptyMessageDelayed(3, 50);
                        return;
                    }
                    TimeLineControlView2.this.mHandler.removeMessages(3);
                }
            } else if (TimeLineControlView2.this.mIsNextPress) {
                TimeLineControlView2 timeLineControlView22 = TimeLineControlView2.this;
                timeLineControlView22.mIsNextLongPress = true;
                timeLineControlView22.movePressNext();
                TimeLineControlView2.this.mHandler.sendEmptyMessageDelayed(2, 50);
            } else {
                TimeLineControlView2.this.mHandler.removeMessages(2);
            }
        }
    };
    ArrayList<ImageDrawable2> mImageDrawables = new ArrayList<>();
    boolean mIsLastLongPress = false;
    boolean mIsLastPress = false;
    boolean mIsNextLongPress = false;
    boolean mIsNextPress = false;
    boolean mIsPress = false;
    ImageDrawable2 mLastDrawable;
    protected int mLastDrawableWidth;
    protected int mLineLen = 5001;
    boolean mMediaPlayer = false;
    boolean mNeedNextButton = true;
    ImageDrawable2 mNextDrawable;
    long mOffsetCurrentTime;
    int mOffsetPos;
    boolean mOnscaleBegin = false;
    Paint mPaint;
    protected Drawable mPeopleMoveBg;
    protected Drawable mPetMoveBg;
    ScaleGestureDetector mScaleGestureDetector;
    int mTimeBarW;
    List<TimeItem> mTimeItems = new ArrayList();
    TimeLineCallback mTimeLineCallback;
    protected Drawable mTimelMotionBg;
    protected Drawable mTimelineBg;
    protected Drawable mTimelinePointer;
    protected Drawable mTimelineSaveSelBg;
    protected Drawable mTimelineSelBg;
    int mTopH;
    int mTouchStartX;
    int mWidthPer5Minutes;
    int mWidthPer5MinutesBase;
    float mWidthScaleFators = 1.0f;
    protected boolean peopleMove = true;
    protected boolean petMove = true;
    int timeTextSize = 30;
    protected TreeMap<Long, List<CloudVideoChildListData>> treeMapDatas;
    protected TreeMap<Long, List<AlarmVideo>> treeMapEvents;
    int width;

    public interface TimeLineCallback {
        void onCancel();

        void onChangeTime(long j);

        void onPlayLive();

        void onSelectTime(long j);

        void onUpdateTime(long j);
    }

    /* access modifiers changed from: protected */
    public CloudVideoChildListData getNeedItemForCloud(long j, boolean z) {
        return null;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* access modifiers changed from: protected */
    public void handlerNotifyUpdate() {
        if (this.mTimeLineCallback != null) {
            this.mCurrentTime = System.currentTimeMillis() + this.mOffsetCurrentTime;
            if (Math.abs(this.mCurrentTime - getSelectTime()) < 15000) {
                setLivePlay();
                civ.O00000o(TAG, " selectTime near now ");
            } else if (this.mTimeItems.isEmpty()) {
                updatePlayTime(System.currentTimeMillis());
                TimeLineCallback timeLineCallback = this.mTimeLineCallback;
                if (timeLineCallback != null) {
                    timeLineCallback.onCancel();
                }
            } else {
                TimeLineCallback timeLineCallback2 = this.mTimeLineCallback;
                if (timeLineCallback2 != null) {
                    timeLineCallback2.onSelectTime(getSelectTime());
                }
            }
            this.mIsPress = false;
        }
    }

    public void setCloudVip(boolean z) {
        this.isCloudVip = z;
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

    /* access modifiers changed from: protected */
    public void setTimeItems(TreeMap<Long, List<CloudVideoChildListData>> treeMap) {
        this.treeMapDatas = treeMap;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void setTimeEventItems(TreeMap<Long, List<AlarmVideo>> treeMap) {
        this.treeMapEvents = treeMap;
        invalidate();
    }

    public TimeLineControlView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
        Resources resources = getContext().getResources();
        this.mTopH = resources.getDimensionPixelSize(R.dimen.time_line_topbar_h);
        this.mTimeBarW = resources.getDimensionPixelSize(R.dimen.time_line_timebar_w2);
        this.mWidthPer5MinutesBase = resources.getDimensionPixelSize(R.dimen.time_line_time_5m_w);
        this.mWidthPer5Minutes = (int) (((float) this.mWidthPer5MinutesBase) * this.mWidthScaleFators);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mTimelineBg = new ColorDrawable(getResources().getColor(R.color.mjcamera_sdcard_timeline_bg));
        this.mTimelineSelBg = new ColorDrawable(Color.parseColor("#A2A2A2"));
        this.mTimelMotionBg = resources.getDrawable(R.drawable.progress_bg_02);
        this.mTimelineSaveSelBg = resources.getDrawable(R.drawable.progress_bg_03);
        this.mPeopleMoveBg = new ColorDrawable(Color.parseColor("#44CECA"));
        this.mAreaMoveBg = new ColorDrawable(Color.parseColor("#FDC541"));
        this.mBabyCryBg = new ColorDrawable(Color.parseColor("#9B91FF"));
        this.mFaceBg = new ColorDrawable(Color.parseColor("#2DB0FF"));
        this.mAIBg = new ColorDrawable(Color.parseColor("#7DA6E0"));
        this.mPetMoveBg = new ColorDrawable(Color.parseColor("#2DB800"));
        this.mBottomPadding = 0;
        this.mTimelinePointer = new ColorDrawable(getResources().getColor(R.color.mj_color_gray_heavier));
        if (this.mNeedNextButton) {
            this.mLastDrawable = new ImageDrawable2(resources.getDrawable(R.drawable.progress_button_last_nor2), resources.getDrawable(R.drawable.progress_button_last_pres2));
            this.mNextDrawable = new ImageDrawable2(resources.getDrawable(R.drawable.progress_button_next_nor2), resources.getDrawable(R.drawable.progress_button_next_pres2));
            this.mLastDrawableWidth = resources.getDimensionPixelOffset(R.dimen.time_line_last_w2);
            this.mImageDrawables.add(this.mLastDrawable);
            this.mImageDrawables.add(this.mNextDrawable);
            this.mLastDrawable.setOnTouchListener(new ImageDrawable2.OnTouchListener() {
                /* class com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView2.AnonymousClass2 */

                public void onActionDown() {
                    civ.O000000o("TimeLine", "last down");
                    TimeLineControlView2.this.mHandler.removeMessages(1);
                    TimeLineControlView2 timeLineControlView2 = TimeLineControlView2.this;
                    timeLineControlView2.mIsPress = true;
                    timeLineControlView2.mIsLastLongPress = false;
                    timeLineControlView2.mIsLastPress = true;
                    timeLineControlView2.mHandler.sendEmptyMessageDelayed(3, 1000);
                }

                public void onActionUp() {
                    civ.O000000o("TimeLine", "last up");
                    TimeLineControlView2 timeLineControlView2 = TimeLineControlView2.this;
                    timeLineControlView2.mIsLastPress = false;
                    timeLineControlView2.mHandler.removeMessages(3);
                    if (!TimeLineControlView2.this.mIsLastLongPress) {
                        TimeLineControlView2.this.movePrev();
                    }
                    TimeLineControlView2 timeLineControlView22 = TimeLineControlView2.this;
                    timeLineControlView22.mIsLastLongPress = false;
                    timeLineControlView22.notifyUpdate();
                }
            });
            this.mNextDrawable.setOnTouchListener(new ImageDrawable2.OnTouchListener() {
                /* class com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView2.AnonymousClass3 */

                public void onActionDown() {
                    civ.O000000o("TimeLine", "next down");
                    TimeLineControlView2.this.mHandler.removeMessages(1);
                    TimeLineControlView2 timeLineControlView2 = TimeLineControlView2.this;
                    timeLineControlView2.mIsPress = true;
                    timeLineControlView2.mIsNextLongPress = false;
                    timeLineControlView2.mIsNextPress = true;
                    timeLineControlView2.mHandler.sendEmptyMessageDelayed(2, 1000);
                }

                public void onActionUp() {
                    civ.O000000o("TimeLine", "next up");
                    TimeLineControlView2 timeLineControlView2 = TimeLineControlView2.this;
                    timeLineControlView2.mIsNextPress = false;
                    timeLineControlView2.mHandler.removeMessages(2);
                    boolean moveNext = !TimeLineControlView2.this.mIsNextLongPress ? TimeLineControlView2.this.moveNext() : true;
                    TimeLineControlView2 timeLineControlView22 = TimeLineControlView2.this;
                    timeLineControlView22.mIsNextLongPress = false;
                    if (moveNext) {
                        timeLineControlView22.notifyUpdate();
                    }
                }
            });
        }
    }

    public void setFull(boolean z) {
        if (z) {
            this.mTimelineBg = new ColorDrawable(Color.parseColor("#262626"));
            this.mTimelinePointer = new ColorDrawable(Color.parseColor("#ffffff"));
        } else {
            this.mTimelineBg = new ColorDrawable(getResources().getColor(R.color.mjcamera_sdcard_timeline_bg));
            this.mTimelinePointer = new ColorDrawable(getResources().getColor(R.color.mj_color_gray_heavier));
        }
        invalidate();
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

    /* access modifiers changed from: protected */
    public void setPlayTime(long j) {
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
        this.width = getWidth();
        this.height = getHeight() - this.mBottomPadding;
        int i5 = this.height;
        this.height_1_14 = i5 / 14;
        int i6 = this.height_1_14;
        this.boundsTop = (this.timeTextSize * 3) + i6;
        this.boundsBottom = this.boundsTop + i6;
        this.mHalfW = (i3 - i) / 2;
        if (this.mNeedNextButton) {
            int i7 = this.boundsBottom;
            float f = (((float) ((i5 - i7) - this.mLastDrawableWidth)) / 2.0f) + ((float) i7);
            this.mLastDrawable.setPadding(this.drawablePadding);
            this.mNextDrawable.setPadding(this.drawablePadding);
            ImageDrawable2 imageDrawable2 = this.mLastDrawable;
            int i8 = this.drawablePadding;
            int i9 = (int) f;
            int i10 = this.mLastDrawableWidth;
            imageDrawable2.setRect(i8, i9, i10 + i8, (int) (((float) i10) + f));
            ImageDrawable2 imageDrawable22 = this.mNextDrawable;
            int i11 = this.width;
            int i12 = this.mLastDrawableWidth;
            int i13 = this.drawablePadding;
            imageDrawable22.setRect((i11 - i12) - i13, i9, i11 - i13, (int) (f + ((float) i12)));
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TimeLineCallback timeLineCallback;
        if (isEnabled() && this.isCloudVip) {
            if (!this.mMediaPlayer) {
                Iterator<ImageDrawable2> it = this.mImageDrawables.iterator();
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
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean getIsPress() {
        return this.mIsPress;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i;
        Canvas canvas2 = canvas;
        super.dispatchDraw(canvas);
        long j = this.mCurrentTime;
        this.mCurrentTime = System.currentTimeMillis() + this.mOffsetCurrentTime;
        this.mOffsetPos += (int) (((this.mCurrentTime - j) * ((long) this.mWidthPer5Minutes)) / 300000);
        this.mTimelineBg.setBounds(0, 0, this.width, this.height);
        this.mTimelineBg.draw(canvas2);
        canvas.save();
        canvas2.clipRect(new Rect(0, 0, this.width, this.height + 1));
        TimeDay timeDay = new TimeDay(getTime(-52));
        timeDay.minute = (timeDay.minute / 5) * 5;
        timeDay.second = 0;
        timeDay.updateTimeInMillis();
        int i2 = timeDay.minute;
        this.lastDrawPos = -20;
        this.lastEndTime = 0;
        int i3 = this.height;
        int i4 = this.boundsBottom;
        float f = (((float) (i3 - i4)) / 2.0f) + ((float) i4);
        drawEventList(canvas2, 0);
        this.mPaint.setTextSize((float) this.timeTextSize);
        this.mPaint.setStrokeWidth(1.0f);
        int pos = getPos(timeDay.millis) + 0;
        int i5 = timeDay.hour + 1;
        int i6 = i2;
        while (true) {
            i = this.width;
            if (pos >= i + 50) {
                break;
            }
            if (i6 == 60) {
                this.mPaint.setColor(-5852989);
                int i7 = this.mLastDrawableWidth;
                int i8 = this.drawablePadding;
                if (pos >= (i8 * 2) + i7 && pos <= (this.width - i7) - (i8 * 2)) {
                    canvas2.drawCircle((float) pos, f, 3.0f, this.mPaint);
                }
                float f2 = (float) pos;
                canvas.drawLine(f2, 0.0f, f2, (float) (this.height_1_14 + 0), this.mPaint);
                if (i5 == 24) {
                    i5 = 0;
                }
                this.mPaint.setColor(-8353911);
                StringBuilder sb = new StringBuilder();
                sb.append(i5 > 9 ? Integer.valueOf(i5) : "0".concat(String.valueOf(i5)));
                sb.append(":00");
                canvas2.drawText(sb.toString(), (float) (pos - 40), (float) (this.height_1_14 + 0 + this.timeTextSize), this.mPaint);
                i5++;
                i6 = 0;
            } else if (i6 == 30) {
                this.mPaint.setColor(-5852989);
                int i9 = this.mLastDrawableWidth;
                int i10 = this.drawablePadding;
                if (pos >= (i10 * 2) + i9 && pos <= (this.width - i9) - (i10 * 2)) {
                    canvas2.drawCircle((float) pos, f, 3.0f, this.mPaint);
                }
                float f3 = (float) pos;
                canvas.drawLine(f3, 0.0f, f3, (float) (this.height_1_14 + 0), this.mPaint);
                this.mPaint.setColor(-8353911);
                int i11 = i5 - 1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i11 > 9 ? Integer.valueOf(i11) : "0".concat(String.valueOf(i11)));
                sb2.append(":30");
                canvas2.drawText(sb2.toString(), (float) (pos - 40), (float) (this.height_1_14 + 0 + this.timeTextSize), this.mPaint);
            }
            i6 += 5;
            pos += this.mWidthPer5Minutes;
        }
        if (this.isCloudVip) {
            Drawable drawable = this.mTimelinePointer;
            int i12 = this.mTimeBarW;
            drawable.setBounds(((i / 2) + 0) - (i12 / 2), this.height_1_14 + this.timeTextSize + 15, (i / 2) + 0 + (i12 / 2), this.height + 0 + this.mBottomPadding);
            this.mTimelinePointer.draw(canvas2);
        }
        canvas.restore();
        if (!this.mMediaPlayer) {
            Iterator<ImageDrawable2> it = this.mImageDrawables.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawEventList(Canvas canvas, int i) {
        for (int i2 = 0; i2 < this.mTimeItems.size(); i2++) {
            TimeItem timeItem = this.mTimeItems.get(i2);
            int pos = getPos(timeItem.f5243O000000o) + i;
            long j = timeItem.f5243O000000o + timeItem.O00000Oo;
            long j2 = this.mCurrentTime;
            if (j2 <= j) {
                j = j2;
            }
            int pos2 = getPos(j);
            if (pos <= this.width && pos2 >= 0 && pos2 >= this.lastDrawPos) {
                if (timeItem.f5243O000000o > this.lastEndTime) {
                    long j3 = timeItem.f5243O000000o;
                    long j4 = this.lastEndTime;
                    if (j3 - j4 < ((long) this.mLineLen)) {
                        pos = getPos(j4);
                    }
                }
                int i3 = this.lastDrawPos;
                int i4 = pos < i3 ? i3 : pos;
                int O000000o2 = clq.O000000o(timeItem.f5243O000000o);
                if (O000000o2 != 0) {
                    if (O000000o2 != 1) {
                        if (O000000o2 == 2 || O000000o2 == 3) {
                            if (this.petMove) {
                                this.mPetMoveBg.setBounds(i4, this.boundsTop, pos2, this.boundsBottom);
                                this.mPetMoveBg.draw(canvas);
                            } else {
                                drawNoEventBg(i4, this.boundsTop, pos2, this.boundsBottom, canvas);
                            }
                        } else if (O000000o2 == 4 || O000000o2 == 5) {
                            if (this.face) {
                                this.mFaceBg.setBounds(i4, this.boundsTop, pos2, this.boundsBottom);
                                this.mFaceBg.draw(canvas);
                            } else {
                                drawNoEventBg(i4, this.boundsTop, pos2, this.boundsBottom, canvas);
                            }
                        } else if (O000000o2 != 7) {
                            drawNoEventBg(i4, this.boundsTop, pos2, this.boundsBottom, canvas);
                        } else if (this.babyCry) {
                            this.mBabyCryBg.setBounds(i4, this.boundsTop, pos2, this.boundsBottom);
                            this.mBabyCryBg.draw(canvas);
                        } else {
                            drawNoEventBg(i4, this.boundsTop, pos2, this.boundsBottom, canvas);
                        }
                    } else if (this.peopleMove) {
                        this.mPeopleMoveBg.setBounds(i4, this.boundsTop, pos2, this.boundsBottom);
                        this.mPeopleMoveBg.draw(canvas);
                    } else {
                        drawNoEventBg(i4, this.boundsTop, pos2, this.boundsBottom, canvas);
                    }
                } else if (this.areaMove) {
                    this.mAreaMoveBg.setBounds(i4, this.boundsTop, pos2, this.boundsBottom);
                    this.mAreaMoveBg.draw(canvas);
                } else {
                    drawNoEventBg(i4, this.boundsTop, pos2, this.boundsBottom, canvas);
                }
                this.lastDrawPos = pos2;
                this.lastEndTime = j;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawNoEventBg(int i, int i2, int i3, int i4, Canvas canvas) {
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

    /* access modifiers changed from: protected */
    public TimeItem getNeedItem(long j, boolean z) {
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

    public void setAi(boolean z) {
        this.ai = z;
        invalidate();
    }

    public void setFace(boolean z) {
        this.face = z;
        invalidate();
    }

    public void setPetMove(boolean z) {
        this.petMove = z;
        invalidate();
    }
}
