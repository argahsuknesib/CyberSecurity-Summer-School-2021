package com.xiaomi.smarthome.camera.v4.view.widget;

import _m_j.chp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class ViewPagerIndicator extends View {
    private int mCount;
    private int mCurrentIndex;
    private int mLineWidth;
    private Paint mNormalPain;
    private float mOffset;
    private int mOffsetWidth;
    private float mRadius;
    private Paint mSelectPain;

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLineWidth = 0;
        this.mOffsetWidth = 0;
        this.mRadius = 0.0f;
        this.mCount = 2;
        this.mCurrentIndex = 0;
        this.mOffset = 0.0f;
        init();
    }

    private void init() {
        this.mSelectPain = new Paint();
        this.mSelectPain.setAntiAlias(true);
        this.mSelectPain.setStyle(Paint.Style.FILL);
        this.mSelectPain.setColor(getResources().getColor(R.color.mj_color_gray_heavy));
        this.mNormalPain = new Paint();
        this.mNormalPain.setAntiAlias(true);
        this.mNormalPain.setStyle(Paint.Style.FILL);
        this.mNormalPain.setColor(getResources().getColor(R.color.mj_color_gray_heavier));
        this.mRadius = chp.O00000o0 * 4.0f;
        this.mLineWidth = (int) (this.mRadius * 2.0f);
        this.mOffsetWidth = (int) (chp.O00000o0 * 8.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i2 = this.mCount;
        if (i2 > 1) {
            i = (this.mLineWidth * i2) + (this.mOffsetWidth * (i2 - 1));
        } else {
            i = this.mLineWidth;
        }
        int i3 = (width / 2) - (i / 2);
        int i4 = 0;
        for (int i5 = 0; i5 < this.mCount; i5++) {
            canvas.drawCircle((float) i3, (float) (height / 2), this.mRadius, this.mNormalPain);
            if (i5 == this.mCurrentIndex) {
                float f = this.mOffset;
                i4 = (f != 0.0f ? (int) (((float) (this.mLineWidth + this.mOffsetWidth)) * f) : 0) + i3;
            }
            i3 = i3 + this.mLineWidth + this.mOffsetWidth;
        }
        canvas.drawCircle((float) i4, (float) (height / 2), this.mRadius, this.mSelectPain);
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
        this.mOffset = 0.0f;
        invalidate();
    }

    public void changeOffset(int i, float f) {
        if (i == this.mCurrentIndex) {
            this.mOffset = f;
        } else {
            this.mOffset = -(1.0f - f);
        }
        invalidate();
    }
}
