package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.TextView;

public class MaskableTextView extends TextView {
    private static final float DEFAULT_MASK_MOVE_SPEED = (((float) gri.O000000o(1.0f)) / 20.0f);
    public Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.library.common.widget.MaskableTextView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                MaskableTextView.this.invalidate();
                sendEmptyMessageDelayed(1, 10);
            } else if (i == 2) {
                MaskableTextView.this.mHandler.removeMessages(1);
            }
        }
    };
    private Animation.AnimationListener mListener = null;
    private float mMaskMoveSpeed = DEFAULT_MASK_MOVE_SPEED;
    private Rect mRect = new Rect();
    private boolean mRunning = false;
    private long mStartTime = 0;

    public MaskableTextView(Context context) {
        super(context);
    }

    public MaskableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaskableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mRunning) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mStartTime == 0) {
                this.mStartTime = currentTimeMillis;
                Animation.AnimationListener animationListener = this.mListener;
                if (animationListener != null) {
                    animationListener.onAnimationStart(null);
                }
            }
            float f = ((float) (currentTimeMillis - this.mStartTime)) * this.mMaskMoveSpeed;
            this.mRect.set(0, 0, (int) f, getHeight());
            if (f > ((float) getMeasuredWidth())) {
                this.mHandler.removeMessages(1);
                this.mRect.set(0, 0, getWidth(), getHeight());
                Animation.AnimationListener animationListener2 = this.mListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationEnd(null);
                }
                this.mRunning = false;
            }
        }
        canvas.clipRect(this.mRect);
        super.onDraw(canvas);
    }

    public void reset() {
        this.mRunning = false;
        this.mHandler.removeMessages(1);
        this.mRect.set(0, 0, 0, getHeight());
        this.mStartTime = 0;
        postInvalidate();
    }

    public void startAnim(Animation.AnimationListener animationListener) {
        this.mHandler.sendEmptyMessage(1);
        this.mRunning = true;
        this.mListener = animationListener;
    }

    public void setMaskSpeed(float f) {
        this.mMaskMoveSpeed = f;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
