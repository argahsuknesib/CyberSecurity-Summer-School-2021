package com.sina.weibo.sdk.web.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class LoadingBar extends TextView {
    private Handler mHander;
    private Paint mPaint;
    public int mProgress;
    private int mProgressColor;
    private Runnable mRunnable = new Runnable() {
        /* class com.sina.weibo.sdk.web.view.LoadingBar.AnonymousClass1 */

        public final void run() {
            LoadingBar.this.mProgress++;
            LoadingBar loadingBar = LoadingBar.this;
            loadingBar.drawProgress(loadingBar.mProgress);
        }
    };

    public LoadingBar(Context context) {
        super(context);
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mHander = new Handler();
        this.mPaint = new Paint();
        initSkin();
    }

    public void initSkin() {
        this.mProgressColor = -11693826;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.mProgressColor);
        canvas.drawRect(getRect(), this.mPaint);
    }

    private Rect getRect() {
        int left = getLeft();
        int top = getTop();
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.mProgress) / 100)) - left, getBottom() - top);
    }

    public void drawProgress(int i) {
        if (i < 7) {
            this.mHander.postDelayed(this.mRunnable, 70);
        } else {
            this.mHander.removeCallbacks(this.mRunnable);
            this.mProgress = i;
        }
        invalidate();
    }
}
