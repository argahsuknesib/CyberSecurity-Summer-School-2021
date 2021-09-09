package com.xiaomi.smarthome.camera.view;

import _m_j.gsy;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.xiaomi.smarthome.R;

public class RoundProgressBar extends View {
    private int max;
    private Paint paint;
    private int progress;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int style;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.max, R.attr.roundColor, R.attr.roundProgressColor, R.attr.roundWidth, R.attr.style, R.attr.textColor, R.attr.textIsDisplayable, R.attr.textSize});
        this.roundColor = obtainStyledAttributes.getColor(1, -65536);
        this.roundProgressColor = obtainStyledAttributes.getColor(2, -16711936);
        this.textColor = obtainStyledAttributes.getColor(5, -16711936);
        this.textSize = obtainStyledAttributes.getDimension(7, 10.0f);
        this.roundWidth = obtainStyledAttributes.getDimension(3, 5.0f);
        this.max = obtainStyledAttributes.getInteger(0, 100);
        this.textIsDisplayable = obtainStyledAttributes.getBoolean(6, true);
        this.style = obtainStyledAttributes.getInt(4, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = (float) width;
        int i = (int) (f - (this.roundWidth / 2.0f));
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        canvas.drawCircle(f, f, (float) i, this.paint);
        gsy.O000000o(6, "log", String.valueOf(width));
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        int i2 = (int) ((((float) this.progress) / ((float) this.max)) * 100.0f);
        Paint paint2 = this.paint;
        float measureText = paint2.measureText(i2 + "%");
        if (this.textIsDisplayable && i2 != 0 && this.style == 0) {
            canvas.drawText(i2 + "%", f - (measureText / 2.0f), f + (this.textSize / 2.0f), this.paint);
        }
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        float f2 = (float) (width - i);
        float f3 = (float) (width + i);
        RectF rectF = new RectF(f2, f2, f3, f3);
        int i3 = this.style;
        if (i3 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, -90.0f, (float) ((this.progress * 360) / this.max), false, this.paint);
        } else if (i3 == 1) {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            int i4 = this.progress;
            if (i4 != 0) {
                canvas.drawArc(rectF, -90.0f, (float) ((i4 * 360) / this.max), true, this.paint);
            }
        }
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized void setMax(int i) {
        if (i >= 0) {
            this.max = i;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
        invalidate();
    }

    public int getCricleColor() {
        return this.roundColor;
    }

    public void setCricleColor(int i) {
        this.roundColor = i;
    }

    public int getCricleProgressColor() {
        return this.roundProgressColor;
    }

    public void setCricleProgressColor(int i) {
        this.roundProgressColor = i;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public void setRoundWidth(float f) {
        this.roundWidth = f;
    }

    public void setProgressWithAnim(int i) {
        this.progress = i;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", 0.0f, (float) i);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat);
        animatorSet.start();
    }
}
