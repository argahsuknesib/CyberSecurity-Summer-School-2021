package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.xiaomi.smarthome.R;

public class EllipsesProgressTextView extends AppCompatTextView {
    private boolean mAnimating = false;
    private int mCurrentEllipseCount = 0;
    private int mEllipseCount = 3;
    private Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.library.common.widget.EllipsesProgressTextView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                EllipsesProgressTextView.this.stepForward();
            }
        }
    };
    private int mSpeed = 500;
    private StringBuilder stringBuilder = new StringBuilder();

    public EllipsesProgressTextView(Context context) {
        super(context);
        init(context, null);
    }

    public EllipsesProgressTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public EllipsesProgressTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ellipses_count, R.attr.ellipses_speed});
        this.mEllipseCount = obtainStyledAttributes.getDimensionPixelSize(0, 3);
        if (this.mEllipseCount <= 1) {
            this.mEllipseCount = 2;
        }
        this.mSpeed = obtainStyledAttributes.getDimensionPixelSize(1, 500);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopProgressAnim();
    }

    public boolean isAnimating() {
        return this.mAnimating;
    }

    public void startProgressAnim() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mCurrentEllipseCount = this.mEllipseCount;
        this.mHandler.sendEmptyMessage(1);
        this.mAnimating = true;
    }

    public void stopProgressAnim() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mCurrentEllipseCount = this.mEllipseCount;
        this.mAnimating = false;
    }

    private void updateUI() {
        int i = this.mCurrentEllipseCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.stringBuilder.append(".");
        }
        setText(this.stringBuilder.toString());
        StringBuilder sb = this.stringBuilder;
        sb.delete(0, sb.length());
    }

    public void stepForward() {
        this.mCurrentEllipseCount = (this.mCurrentEllipseCount % this.mEllipseCount) + 1;
        updateUI();
        this.mHandler.sendEmptyMessageDelayed(1, (long) this.mSpeed);
    }
}
