package com.payu.custombrowser.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.util.Timer;
import java.util.TimerTask;

public class SnoozeLoaderView extends View {
    private Paint activeBarPaint;
    public int blinkPosition = 0;
    private Rect firstBar;
    private Paint firstBarPaint;
    private Paint inActiveBarPaint;
    private int mActiveColor = Color.parseColor("#00adf2");
    Activity mActivity;
    private int mAnimationSpeed = 200;
    private int mBarHeight = 120;
    private int mBarHeightRatio = (this.mBarHeight / 3);
    private int mBarSpace = 70;
    private int mBarWidth = 40;
    private int mInActiveColor = Color.parseColor("#b0eafc");
    private Rect secondBar;
    private Paint secondBarPaint;
    public boolean shouldStartAnimation = false;
    private Rect thirdBar;
    private Paint thirdBarPaint;
    private Timer timer;

    public SnoozeLoaderView(Context context) {
        super(context);
        this.mActivity = (Activity) context;
        init();
    }

    public SnoozeLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivity = (Activity) context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.activeBarColor, R.attr.animationSpeed, R.attr.barHeight, R.attr.barSpace, R.attr.barWidth, R.attr.inActiveBarColor, R.attr.startAnimate}, 0, 0);
        try {
            this.shouldStartAnimation = obtainStyledAttributes.getBoolean(6, this.shouldStartAnimation);
            this.mActiveColor = obtainStyledAttributes.getColor(0, this.mActiveColor);
            this.mInActiveColor = obtainStyledAttributes.getColor(5, this.mInActiveColor);
            this.mBarWidth = obtainStyledAttributes.getDimensionPixelSize(4, this.mBarWidth);
            this.mBarHeight = obtainStyledAttributes.getDimensionPixelSize(2, this.mBarHeight);
            this.mBarHeightRatio = this.mBarHeight / 3;
            this.mBarSpace = obtainStyledAttributes.getDimensionPixelSize(3, this.mBarSpace);
            this.mAnimationSpeed = obtainStyledAttributes.getInt(1, this.mAnimationSpeed);
            init();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public SnoozeLoaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivity = (Activity) context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.activeBarColor, R.attr.animationSpeed, R.attr.barHeight, R.attr.barSpace, R.attr.barWidth, R.attr.inActiveBarColor, R.attr.startAnimate}, 0, 0);
        try {
            this.shouldStartAnimation = obtainStyledAttributes.getBoolean(6, this.shouldStartAnimation);
            this.mActiveColor = obtainStyledAttributes.getColor(0, this.mActiveColor);
            this.mInActiveColor = obtainStyledAttributes.getColor(5, this.mInActiveColor);
            this.mBarWidth = obtainStyledAttributes.getDimensionPixelSize(4, this.mBarWidth);
            this.mBarHeight = obtainStyledAttributes.getDimensionPixelSize(2, this.mBarHeight);
            this.mBarHeightRatio = this.mBarHeight / 3;
            this.mBarSpace = obtainStyledAttributes.getDimensionPixelSize(3, this.mBarSpace);
            init();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.firstBar, this.firstBarPaint);
        canvas.drawRect(this.secondBar, this.secondBarPaint);
        canvas.drawRect(this.thirdBar, this.thirdBarPaint);
    }

    public void updateBar(int i) {
        if (i == 0) {
            Paint paint = this.inActiveBarPaint;
            this.firstBarPaint = paint;
            this.secondBarPaint = paint;
            this.thirdBarPaint = paint;
        } else if (i == 1) {
            this.firstBarPaint = this.activeBarPaint;
            Paint paint2 = this.inActiveBarPaint;
            this.secondBarPaint = paint2;
            this.thirdBarPaint = paint2;
        } else if (i == 2) {
            Paint paint3 = this.activeBarPaint;
            this.firstBarPaint = paint3;
            this.secondBarPaint = paint3;
            this.thirdBarPaint = this.inActiveBarPaint;
        } else if (i != 3) {
            Paint paint4 = this.inActiveBarPaint;
            this.firstBarPaint = paint4;
            this.secondBarPaint = paint4;
            this.thirdBarPaint = paint4;
        } else {
            Paint paint5 = this.activeBarPaint;
            this.firstBarPaint = paint5;
            this.secondBarPaint = paint5;
            this.thirdBarPaint = paint5;
        }
        this.mActivity.runOnUiThread(new Runnable() {
            /* class com.payu.custombrowser.widgets.SnoozeLoaderView.AnonymousClass1 */

            public void run() {
                SnoozeLoaderView.this.invalidate();
            }
        });
    }

    private void init() {
        this.activeBarPaint = new Paint();
        this.activeBarPaint.setColor(this.mActiveColor);
        this.activeBarPaint.setStyle(Paint.Style.FILL);
        this.inActiveBarPaint = new Paint();
        this.inActiveBarPaint.setColor(this.mInActiveColor);
        this.inActiveBarPaint.setStyle(Paint.Style.FILL);
        Paint paint = this.inActiveBarPaint;
        this.firstBarPaint = paint;
        this.secondBarPaint = paint;
        this.thirdBarPaint = paint;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i / 2;
        int i6 = i2 / 2;
        int i7 = this.mBarWidth;
        int i8 = i5 - (i7 / 2);
        int i9 = this.mBarHeight;
        int i10 = i6 - (i9 / 2);
        int i11 = this.mBarSpace;
        int i12 = ((i5 - i7) - i11) - (i7 / 2);
        int i13 = this.mBarHeightRatio;
        int i14 = (i6 - (i9 / 2)) - i13;
        int i15 = i5 + (i7 / 2) + i11;
        int i16 = (i6 - (i9 / 2)) + i13;
        this.secondBar = new Rect(i8, i10, i8 + i7, i10 + i9);
        this.firstBar = new Rect(i12, i14, i12 + i7, i14 + i9 + i13 + i13);
        this.thirdBar = new Rect(i15, i16, i7 + i15, ((i9 + i16) - i13) - i13);
        if (this.shouldStartAnimation) {
            startAnimation();
        }
    }

    public void startAnimation() {
        this.shouldStartAnimation = true;
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            /* class com.payu.custombrowser.widgets.SnoozeLoaderView.AnonymousClass2 */

            public void run() {
                if (SnoozeLoaderView.this.blinkPosition == 4) {
                    SnoozeLoaderView.this.blinkPosition = 0;
                } else {
                    SnoozeLoaderView.this.blinkPosition++;
                }
                if (SnoozeLoaderView.this.shouldStartAnimation) {
                    SnoozeLoaderView snoozeLoaderView = SnoozeLoaderView.this;
                    snoozeLoaderView.updateBar(snoozeLoaderView.blinkPosition);
                    return;
                }
                cancel();
            }
        }, 0, (long) this.mAnimationSpeed);
    }

    public void cancelAnimation() {
        this.shouldStartAnimation = false;
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer.purge();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension((this.mBarWidth * 3) + (this.mBarSpace * 2) + getPaddingLeft() + getPaddingRight(), this.mBarHeight + (this.mBarHeightRatio * 2) + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.shouldStartAnimation = false;
    }
}
