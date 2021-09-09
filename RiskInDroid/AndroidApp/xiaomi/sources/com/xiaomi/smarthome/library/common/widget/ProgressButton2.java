package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.xiaomi.smarthome.R;

public class ProgressButton2 extends AppCompatButton {
    private float mCornerRadius = 0.0f;
    private GradientDrawable mDrawableButton;
    private GradientDrawable mDrawableProgress;
    private GradientDrawable mDrawableProgressBackground;
    private boolean mFinish;
    private int mMaxProgress = 100;
    private int mMinProgress = 0;
    private int mProgress;
    private float mProgressMargin = 0.0f;

    public ProgressButton2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet);
    }

    public ProgressButton2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void initialize(Context context, AttributeSet attributeSet) {
        this.mDrawableProgressBackground = new GradientDrawable();
        this.mDrawableProgress = new GradientDrawable();
        this.mDrawableButton = new GradientDrawable();
        int color = getResources().getColor(R.color.mj_color_btn_green_nor, null);
        int color2 = getResources().getColor(R.color.mj_color_btn_green_pres, null);
        int color3 = getResources().getColor(R.color.mj_color_btn_green_nor, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.buttonColor, R.attr.cornerRadius, R.attr.maxProgress, R.attr.minProgress, R.attr.progress, R.attr.progressBackColor, R.attr.progressMargin, R.attr.progress_color});
        try {
            this.mProgressMargin = obtainStyledAttributes.getDimension(6, this.mProgressMargin);
            this.mCornerRadius = obtainStyledAttributes.getDimension(1, this.mCornerRadius);
            this.mDrawableButton.setColor(obtainStyledAttributes.getColor(0, color));
            this.mDrawableProgressBackground.setColor(obtainStyledAttributes.getColor(5, color3));
            this.mDrawableProgress.setColor(obtainStyledAttributes.getColor(7, color2));
            this.mProgress = obtainStyledAttributes.getInteger(4, this.mProgress);
            this.mMinProgress = obtainStyledAttributes.getInteger(3, this.mMinProgress);
            this.mMaxProgress = obtainStyledAttributes.getInteger(2, this.mMaxProgress);
            obtainStyledAttributes.recycle();
            this.mDrawableButton.setCornerRadius(this.mCornerRadius);
            this.mDrawableProgressBackground.setCornerRadius(this.mCornerRadius);
            setBackgroundDrawable(this.mDrawableButton);
            this.mFinish = false;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070  */
    public void onDraw(Canvas canvas) {
        int i = this.mProgress;
        if (i > this.mMinProgress && i <= this.mMaxProgress && !this.mFinish) {
            int i2 = this.mProgress;
            int i3 = this.mMinProgress;
            float measuredWidth = ((float) getMeasuredWidth()) * ((((float) (i2 - i3)) / ((float) this.mMaxProgress)) - ((float) i3));
            float f = this.mCornerRadius;
            if (measuredWidth < f) {
                measuredWidth = f;
            } else {
                float f2 = this.mCornerRadius;
                if (measuredWidth > ((float) getMeasuredWidth()) - f2) {
                    float f3 = f2 - this.mProgressMargin;
                    setCornerRadii(this.mDrawableProgress, f3, f3, f3, f3);
                    GradientDrawable gradientDrawable = this.mDrawableProgress;
                    float f4 = this.mProgressMargin;
                    gradientDrawable.setBounds((int) f4, (int) f4, (int) (measuredWidth - f4), getMeasuredHeight() - ((int) this.mProgressMargin));
                    this.mDrawableProgress.draw(canvas);
                    if (this.mProgress == this.mMaxProgress) {
                        setBackgroundDrawable(this.mDrawableProgressBackground);
                        this.mFinish = true;
                    }
                }
            }
            float f5 = this.mCornerRadius - this.mProgressMargin;
            setCornerRadii(this.mDrawableProgress, f5, 0.0f, 0.0f, f5);
            GradientDrawable gradientDrawable2 = this.mDrawableProgress;
            float f42 = this.mProgressMargin;
            gradientDrawable2.setBounds((int) f42, (int) f42, (int) (measuredWidth - f42), getMeasuredHeight() - ((int) this.mProgressMargin));
            this.mDrawableProgress.draw(canvas);
            if (this.mProgress == this.mMaxProgress) {
            }
        }
        super.onDraw(canvas);
    }

    public void setProgress(int i) {
        if (!this.mFinish) {
            this.mProgress = i;
            setBackgroundDrawable(this.mDrawableProgressBackground);
            invalidate();
        }
    }

    public void setMaxProgress(int i) {
        this.mMaxProgress = i;
    }

    public void setMinProgress(int i) {
        this.mMinProgress = i;
    }

    public void reset() {
        this.mFinish = false;
        this.mProgress = this.mMinProgress;
    }

    private void setCornerRadii(GradientDrawable gradientDrawable, float f, float f2, float f3, float f4) {
        gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
    }
}
