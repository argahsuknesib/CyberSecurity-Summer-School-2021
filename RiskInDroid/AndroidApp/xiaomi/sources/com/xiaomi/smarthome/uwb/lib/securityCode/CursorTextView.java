package com.xiaomi.smarthome.uwb.lib.securityCode;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;

@SuppressLint({"AppCompatCustomView"})
public class CursorTextView extends TextView {
    int mAlpha;
    ValueAnimator mAlphaAnimator;
    boolean mIsAdd;
    boolean mIsDrawLine = false;
    int mLineHeight;
    Paint mPaint;

    public CursorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* access modifiers changed from: package-private */
    public void init() {
        this.mLineHeight = UIUtils.dp2px(getContext(), 18.0f);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth((float) UIUtils.dp2px(getContext(), 1.0f));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(getResources().getColor(R.color.edit_view_cursor));
        this.mAlphaAnimator = new ValueAnimator();
        this.mIsAdd = true;
        this.mAlphaAnimator.setIntValues(0, 255);
        this.mAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.CursorTextView.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CursorTextView.this.mAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.mAlphaAnimator.addListener(new AnimatorListenerAdapter() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.CursorTextView.AnonymousClass2 */

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CursorTextView cursorTextView = CursorTextView.this;
                cursorTextView.mIsAdd = !cursorTextView.mIsAdd;
                if (CursorTextView.this.mIsAdd) {
                    CursorTextView.this.mAlphaAnimator.setIntValues(0, 255);
                } else {
                    CursorTextView.this.mAlphaAnimator.setIntValues(255, 0);
                }
                if (CursorTextView.this.mIsDrawLine) {
                    CursorTextView.this.mAlphaAnimator.start();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (!TextUtils.isEmpty(getText())) {
            super.onDraw(canvas);
        } else if (this.mIsDrawLine) {
            int i = (height - this.mLineHeight) / 2;
            this.mPaint.setAlpha(this.mAlpha);
            float f = (float) (width / 2);
            canvas.drawLine(f, (float) i, f, (float) (i + this.mLineHeight), this.mPaint);
            invalidate();
        }
    }

    public void setDrawLine(boolean z) {
        this.mIsDrawLine = z;
        if (!this.mIsDrawLine) {
            this.mAlphaAnimator.cancel();
        } else {
            this.mAlphaAnimator.start();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAlphaAnimator.cancel();
    }
}
