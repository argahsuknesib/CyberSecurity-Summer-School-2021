package com.xiaomi.smarthome.camera.view;

import _m_j.clu;
import _m_j.clv;
import _m_j.gsy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;

public class HourOfDayView extends View {
    private int mDay = 0;
    Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.camera.view.HourOfDayView.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message.what == 1) {
                HourOfDayView.this.mHandler.removeMessages(1);
                HourOfDayView.this.onLongClick();
            }
        }
    };
    boolean mIsMultiSelect = false;
    int mLineColor = -3355444;
    HourOfDayViewListener mOnClickListener;
    Paint mPaint;
    int mRedPointMargin;
    int mRedPointSize;
    int mSaveBgColor = -4891;
    boolean[] mSelecled = new boolean[24];
    Drawable mSelectedDrawable;
    int mTextColor = -8355712;
    int mTextSaveColor = -38610;
    int mTextSize;
    int mTextVideoColor = -14840321;
    clu mTimeItemDay;
    clv[] mTimeItemHours = new clv[24];
    int mVideoBgColor = -1707265;

    public interface HourOfDayViewListener {
        void onClick(int i, int i2);

        void onLongClick();

        void onSelectChanged();
    }

    public void setHourOfDayViewListener(HourOfDayViewListener hourOfDayViewListener) {
        this.mOnClickListener = hourOfDayViewListener;
    }

    public void setMultiSelect(boolean z) {
        this.mIsMultiSelect = z;
        postInvalidate();
    }

    public void setTimeItemDay(clu clu, int i) {
        this.mDay = i;
        this.mTimeItemDay = clu;
        this.mTimeItemHours = new clv[24];
        this.mSelecled = this.mTimeItemDay.O0000OOo;
        for (int i2 = 0; i2 < this.mTimeItemDay.O0000O0o.size(); i2++) {
            clv clv = this.mTimeItemDay.O0000O0o.get(i2);
            if (clv.f14114O000000o < 0 || clv.f14114O000000o >= 24) {
                gsy.O000000o(6, "HourOfDayView", "setTimeItemDay error hour:" + clv.f14114O000000o);
            } else {
                this.mTimeItemHours[clv.f14114O000000o] = clv;
            }
        }
        postInvalidate();
    }

    public HourOfDayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRedPointSize = context.getResources().getDimensionPixelSize(R.dimen.hour_of_day_hour_red_point_size);
        this.mTextSize = context.getResources().getDimensionPixelSize(R.dimen.hour_of_day_hour_txt_size);
        this.mRedPointMargin = context.getResources().getDimensionPixelOffset(R.dimen.hour_of_day_hour_red_point_margin);
        this.mSelectedDrawable = context.getResources().getDrawable(R.drawable.camera_day_choose_pres);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i = width / 6;
        int i2 = height / 4;
        Rect rect = new Rect();
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 6; i4++) {
                rect.left = (i4 * i) + paddingLeft;
                rect.top = (i3 * i2) + paddingTop;
                rect.right = rect.left + i;
                rect.bottom = rect.top + i2;
                drawItem((i3 * 6) + i4, rect, canvas);
            }
        }
        this.mPaint.setColor(this.mLineColor);
        this.mPaint.setStrokeWidth(1.0f);
        for (int i5 = 1; i5 < 4; i5++) {
            float f = (float) ((i5 * i2) + paddingTop);
            Canvas canvas2 = canvas;
            canvas2.drawLine((float) paddingLeft, f, (float) (paddingLeft + width), f, this.mPaint);
        }
        float f2 = (float) (paddingTop + 2);
        int i6 = width + paddingLeft;
        Canvas canvas3 = canvas;
        float f3 = (float) paddingLeft;
        float f4 = (float) i6;
        canvas3.drawLine(f3, f2, f4, f2, this.mPaint);
        int i7 = height + paddingTop;
        float f5 = (float) (i7 - 2);
        canvas3.drawLine(f3, f5, f4, f5, this.mPaint);
        for (int i8 = 1; i8 < 6; i8++) {
            float f6 = (float) ((i8 * i) + paddingLeft);
            canvas.drawLine(f6, (float) paddingTop, f6, (float) i7, this.mPaint);
        }
        float f7 = (float) (paddingLeft + 2);
        Canvas canvas4 = canvas;
        float f8 = (float) paddingTop;
        float f9 = (float) i7;
        canvas4.drawLine(f7, f8, f7, f9, this.mPaint);
        float f10 = (float) (i6 - 2);
        canvas4.drawLine(f10, f8, f10, f9, this.mPaint);
    }

    /* access modifiers changed from: package-private */
    public void drawItem(int i, Rect rect, Canvas canvas) {
        String format = String.format("%1$02d:00", Integer.valueOf(i));
        this.mPaint.setTextSize((float) this.mTextSize);
        if (!hasVideo(i)) {
            this.mPaint.setColor(this.mTextColor);
        } else if (!hasSave(i)) {
            this.mPaint.setColor(this.mSaveBgColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect, this.mPaint);
            this.mPaint.setColor(this.mTextSaveColor);
        } else {
            this.mPaint.setColor(this.mVideoBgColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect, this.mPaint);
            this.mPaint.setColor(this.mTextVideoColor);
        }
        Rect rect2 = new Rect();
        this.mPaint.getTextBounds(format, 0, format.length(), rect2);
        canvas.drawText(format, (float) (rect.left + ((rect.width() - rect2.width()) / 2)), (float) (rect.top + (((int) ((((float) rect.height()) - this.mPaint.descent()) - this.mPaint.ascent())) / 2)), this.mPaint);
        if (hasVideo(i)) {
            int i2 = (rect.right - this.mRedPointMargin) - (this.mRedPointSize / 2);
            int i3 = rect.top + this.mRedPointMargin;
            int i4 = this.mRedPointSize;
            int i5 = i3 + (i4 / 2);
            if (this.mIsMultiSelect && this.mSelecled[i]) {
                this.mSelectedDrawable.setBounds(i2 - i4, i5 - i4, i2 + i4, i5 + i4);
                this.mSelectedDrawable.draw(canvas);
            }
        }
    }

    public boolean hasVideo(int i) {
        clv[] clvArr = this.mTimeItemHours;
        return clvArr[i] != null && clvArr[i].O00000o0.size() > 0;
    }

    public boolean hasSave(int i) {
        clv clv = this.mTimeItemHours[i];
        if (clv != null && !clv.O00000o0.isEmpty()) {
            for (TimeItem timeItem : clv.O00000o0) {
                if (timeItem.O00000oO == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, 1000);
        } else if (motionEvent.getAction() == 1) {
            if (this.mHandler.hasMessages(1)) {
                this.mHandler.removeMessages(1);
                onClick(motionEvent);
            }
        } else if (motionEvent.getAction() == 3) {
            this.mHandler.removeMessages(1);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onClick(MotionEvent motionEvent) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int x = ((int) motionEvent.getX()) - paddingLeft;
        int y = (((int) motionEvent.getY()) - paddingTop) / (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 4);
        int i = x / (width / 6);
        if (y >= 0 && y < 4 && i >= 0 && i < 6) {
            int i2 = (y * 6) + i;
            if (this.mIsMultiSelect) {
                if (this.mTimeItemHours[i2] != null) {
                    boolean[] zArr = this.mSelecled;
                    zArr[i2] = !zArr[i2];
                    if (this.mOnClickListener != null && hasVideo(i2)) {
                        this.mOnClickListener.onSelectChanged();
                    }
                    postInvalidate();
                }
            } else if (this.mOnClickListener != null && hasVideo(i2)) {
                this.mOnClickListener.onClick(this.mDay, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onLongClick() {
        HourOfDayViewListener hourOfDayViewListener = this.mOnClickListener;
        if (hourOfDayViewListener != null) {
            hourOfDayViewListener.onLongClick();
        }
    }
}
