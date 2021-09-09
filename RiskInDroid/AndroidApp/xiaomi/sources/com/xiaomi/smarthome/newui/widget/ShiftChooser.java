package com.xiaomi.smarthome.newui.widget;

import _m_j.gpc;
import _m_j.gsy;
import _m_j.hzf;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.xiaomi.smarthome.R;

public class ShiftChooser extends AppCompatImageView {
    private boolean mAutoTopPadding;
    private Paint mBgPaint;
    private boolean mCanChoose;
    private int mCurrentShift;
    private O000000o mOnShiftChangedListener;
    private RectF mRectLayout;
    private final int mShiftColor;
    private Paint mShiftPaint;
    private final int mShiftSelectColor;
    private String mText;
    private final float mTextMargin;
    private Paint mTextPaint;
    private int mThumbColor;
    private final float mThumbHeight;
    private RectF mThumbLayout;
    private Paint mThumbPaint;
    private final int mThumbUnableColor;
    private String[] mTitles;
    private int mTotalShifts;

    public interface O000000o {
        void O000000o(int i);

        void O00000Oo(int i);
    }

    public ShiftChooser(Context context) {
        this(context, null);
    }

    public ShiftChooser(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShiftChooser(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanChoose = true;
        this.mRectLayout = new RectF();
        this.mThumbLayout = new RectF();
        this.mShiftPaint = new Paint(1);
        this.mBgPaint = new Paint(1);
        this.mThumbPaint = new Paint(1);
        this.mTextPaint = new Paint(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.auto_toppadding, R.attr.bg_color, R.attr.max_shifts, R.attr.shift_color, R.attr.shift_color_select, R.attr.shift_radius, R.attr.text_color, R.attr.text_size, R.attr.text_topmargin, R.attr.thumb_color, R.attr.thumb_height}, i, 0);
        setBackgroundColor(obtainStyledAttributes.getColor(1, getResources().getColor(R.color.mj_color_background)));
        setThumbColor(obtainStyledAttributes.getColor(9, getResources().getColor(R.color.mj_color_text_blue_bg)));
        this.mThumbUnableColor = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.mj_color_gray_lighter));
        this.mShiftColor = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.mj_color_gray_lighter));
        this.mAutoTopPadding = obtainStyledAttributes.getBoolean(0, false);
        this.mTextMargin = obtainStyledAttributes.getDimension(8, (float) gpc.O000000o(6.0f));
        this.mThumbHeight = obtainStyledAttributes.getDimension(10, (float) gpc.O000000o(43.33f));
        this.mShiftSelectColor = obtainStyledAttributes.getColor(4, getResources().getColor(R.color.mj_color_white_100_transparent));
        setTextPaint(obtainStyledAttributes.getColor(6, getResources().getColor(R.color.mj_color_gray_heavier)), (int) obtainStyledAttributes.getDimension(7, (float) gpc.O000000o(11.0f)));
        this.mTotalShifts = obtainStyledAttributes.getInteger(2, 5);
        obtainStyledAttributes.recycle();
        this.mThumbPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        float f = (float) (fontMetricsInt.descent - fontMetricsInt.ascent);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, ((int) Math.ceil((double) (this.mThumbHeight + ((f + this.mTextMargin) * ((float) (this.mAutoTopPadding ? 2 : 1)))))) + getPaddingTop() + getPaddingBottom()), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        String str;
        try {
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            float f = (float) (fontMetricsInt.descent - fontMetricsInt.ascent);
            float paddingTop = ((float) getPaddingTop()) + (this.mAutoTopPadding ? this.mTextMargin + f : 0.0f);
            float height = (((float) (getHeight() - getPaddingBottom())) - f) - this.mTextMargin;
            float f2 = height - paddingTop;
            if (f2 > this.mThumbHeight) {
                float f3 = (f2 - this.mThumbHeight) * 0.5f;
                paddingTop += f3;
                height -= f3;
            }
            this.mRectLayout.set((float) getPaddingLeft(), paddingTop, (float) (getWidth() - getPaddingRight()), height);
            float height2 = this.mRectLayout.height() / 2.0f;
            float height3 = this.mRectLayout.height() / 10.0f;
            float height4 = this.mRectLayout.height() / 10.0f;
            float width = (this.mRectLayout.width() - (height4 * 2.0f)) / ((float) this.mTotalShifts);
            canvas.drawRoundRect(this.mRectLayout, height2, height2, this.mBgPaint);
            if (this.mCurrentShift >= 0) {
                float f4 = height2 - height4;
                float f5 = this.mRectLayout.left + (((float) this.mCurrentShift) * width) + height4;
                this.mThumbLayout.set(f5, this.mRectLayout.top + height4, f5 + width, this.mRectLayout.bottom - height4);
                if (isEnabled()) {
                    this.mThumbPaint.setColor(this.mThumbColor);
                } else {
                    this.mThumbPaint.setColor(this.mThumbUnableColor);
                }
                canvas.drawRoundRect(this.mThumbLayout, f4, f4, this.mThumbPaint);
                if (!TextUtils.isEmpty(this.mText)) {
                    str = this.mText;
                } else if (this.mTitles != null && this.mTitles.length > this.mCurrentShift && this.mTitles[this.mCurrentShift] != null) {
                    str = this.mTitles[this.mCurrentShift];
                } else {
                    return;
                }
                float centerX = this.mThumbLayout.centerX();
                float measureText = this.mTextPaint.measureText(str) / 2.0f;
                if (centerX - measureText < this.mRectLayout.left) {
                    centerX = this.mRectLayout.left + measureText;
                } else if (centerX + measureText > this.mRectLayout.right) {
                    centerX = this.mRectLayout.right - measureText;
                }
                canvas.drawText(str, centerX, ((this.mRectLayout.bottom + this.mTextMargin) + (f / 2.0f)) - (((float) (fontMetricsInt.bottom + fontMetricsInt.top)) * 0.5f), this.mTextPaint);
            }
            for (int i = 0; i < this.mTotalShifts; i++) {
                if (i == this.mCurrentShift) {
                    this.mShiftPaint.setColor(this.mShiftSelectColor);
                } else {
                    this.mShiftPaint.setColor(this.mShiftColor);
                }
                canvas.drawCircle(this.mRectLayout.left + height4 + (width / 2.0f) + (((float) i) * width), this.mRectLayout.centerY(), height3, this.mShiftPaint);
            }
        } catch (Exception e) {
            gsy.O000000o(6, "ShiftChooser", Log.getStackTraceString(e));
        }
    }

    public void setAutoTopPadding(boolean z) {
        this.mAutoTopPadding = z;
        requestLayout();
    }

    public void setBackgroundColor(int i) {
        this.mBgPaint.setColor(i);
    }

    public void setThumbColor(int i) {
        this.mThumbColor = i;
        invalidate();
    }

    public void setTextPaint(int i, int i2) {
        this.mTextPaint.setColor(i);
        this.mTextPaint.setTextSize((float) i2);
    }

    public void setText(String str) {
        this.mText = str;
        invalidate();
    }

    public void scrollToShift(int i, boolean z) {
        gsy.O000000o(6, "ShiftChooser", "which: ".concat(String.valueOf(i)));
        this.mCurrentShift = i;
        invalidate();
        O000000o o000000o = this.mOnShiftChangedListener;
        if (o000000o != null && z) {
            o000000o.O000000o(this.mCurrentShift);
            this.mOnShiftChangedListener.O00000Oo(this.mCurrentShift);
        }
    }

    public int getCurrentShift() {
        return this.mCurrentShift;
    }

    public int getTotalShifts() {
        return this.mTotalShifts;
    }

    public void setTotalShifts(int i) {
        this.mTotalShifts = i;
        invalidate();
    }

    public void setShiftsTitles(String[] strArr) {
        if (strArr.length == this.mTotalShifts) {
            this.mTitles = strArr;
            invalidate();
            return;
        }
        throw new IllegalArgumentException("titles length not equals mTotalShifts!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r7 != 3) goto L_0x006d;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanChoose) {
            return false;
        }
        int max = Math.max(0, Math.min(this.mTotalShifts - 1, (int) ((motionEvent.getX() - this.mRectLayout.left) / (this.mRectLayout.width() / ((float) this.mTotalShifts)))));
        int action = motionEvent.getAction();
        if (this.mOnShiftChangedListener != null) {
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                if (isHapticFeedbackEnabled()) {
                    hzf.O00000o(this);
                }
                this.mOnShiftChangedListener.O00000Oo(this.mCurrentShift);
            } else if (isHapticFeedbackEnabled()) {
                hzf.O00000o(this);
            }
            if (max != this.mCurrentShift) {
                this.mCurrentShift = max;
                this.mOnShiftChangedListener.O000000o(this.mCurrentShift);
                if (isHapticFeedbackEnabled()) {
                    hzf.O00000Oo(this);
                }
                invalidate();
            }
        }
        return true;
    }

    public void setCanChoose(boolean z) {
        this.mCanChoose = z;
    }

    public void updateEnableUI(boolean z) {
        setEnabled(z);
    }

    public void setOnShiftChangedListener(O000000o o000000o) {
        this.mOnShiftChangedListener = o000000o;
    }
}
