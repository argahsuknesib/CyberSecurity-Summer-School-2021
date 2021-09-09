package com.payu.custombrowser.custombar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class DotsProgressBar extends View {
    private int heightSize;
    public boolean isDotProgressStopped;
    public int mDotCount = 5;
    public final Handler mHandler = new Handler();
    public int mIndex = 0;
    private float mOuterRadius;
    private final Paint mPaint = new Paint(1);
    private final Paint mPaintFill = new Paint(1);
    private float mRadius;
    public final Runnable mRunnable = new Runnable() {
        /* class com.payu.custombrowser.custombar.DotsProgressBar.AnonymousClass1 */

        public void run() {
            DotsProgressBar.this.mIndex += DotsProgressBar.this.step;
            if (DotsProgressBar.this.mIndex < 0) {
                DotsProgressBar dotsProgressBar = DotsProgressBar.this;
                dotsProgressBar.mIndex = 1;
                dotsProgressBar.step = 1;
            } else if (DotsProgressBar.this.mIndex > DotsProgressBar.this.mDotCount - 1) {
                DotsProgressBar dotsProgressBar2 = DotsProgressBar.this;
                dotsProgressBar2.mIndex = 0;
                dotsProgressBar2.step = 1;
            }
            if (!DotsProgressBar.this.isDotProgressStopped) {
                DotsProgressBar.this.invalidate();
                DotsProgressBar.this.mHandler.postDelayed(DotsProgressBar.this.mRunnable, 400);
            }
        }
    };
    private final int margin = 10;
    public int step = 1;
    private int widthSize;

    public DotsProgressBar(Context context) {
        super(context);
        init(context);
    }

    public DotsProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DotsProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mRadius = context.getResources().getDimension(R.dimen.cb_circle_indicator_radius);
        this.mOuterRadius = context.getResources().getDimension(R.dimen.cb_circle_indicator_outer_radius);
        this.mPaintFill.setStyle(Paint.Style.FILL);
        this.mPaintFill.setColor(context.getResources().getColor(R.color.cb_payu_blue));
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(855638016);
        start();
    }

    public void setDotsCount(int i) {
        this.mDotCount = i;
    }

    public void start() {
        this.mIndex = -1;
        this.isDotProgressStopped = false;
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.post(this.mRunnable);
    }

    public void stop() {
        Runnable runnable;
        Handler handler = this.mHandler;
        if (handler != null && (runnable = this.mRunnable) != null) {
            this.isDotProgressStopped = true;
            handler.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = this.mRadius;
        int i3 = this.mDotCount;
        this.widthSize = (int) ((2.0f * f * ((float) i3)) + ((float) (i3 * 10)) + 10.0f + (this.mOuterRadius - f));
        this.heightSize = (((int) f) * 2) + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(this.widthSize, this.heightSize);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.mDotCount;
        float f = ((((float) this.widthSize) - ((((float) i) * this.mRadius) * 2.0f)) - ((float) ((i - 1) * 10))) / 2.0f;
        float f2 = (float) (this.heightSize / 2);
        for (int i2 = 0; i2 < this.mDotCount; i2++) {
            if (i2 == this.mIndex) {
                canvas.drawCircle(f, f2, this.mOuterRadius, this.mPaintFill);
            } else {
                canvas.drawCircle(f, f2, this.mRadius, this.mPaint);
            }
            f += (this.mRadius * 2.0f) + 10.0f;
        }
    }
}
