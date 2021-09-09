package com.brentvatne.exoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f3566O000000o;
    private int O00000Oo;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000Oo = 0;
    }

    public final void setAspectRatio(float f) {
        if (this.f3566O000000o != f) {
            this.f3566O000000o = f;
            requestLayout();
        }
    }

    public final float getAspectRatio() {
        return this.f3566O000000o;
    }

    public final void setResizeMode(int i) {
        if (this.O00000Oo != i) {
            this.O00000Oo = i;
            requestLayout();
        }
    }

    public final int getResizeMode() {
        return this.O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.f3566O000000o != 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f3 = (float) measuredWidth;
            float f4 = (float) measuredHeight;
            float f5 = (this.f3566O000000o / (f3 / f4)) - 1.0f;
            if (Math.abs(f5) > 0.01f) {
                int i3 = this.O00000Oo;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                int i4 = (int) (this.f3566O000000o * f4);
                                if (i4 < measuredWidth) {
                                    float f6 = (float) i4;
                                    float f7 = f3 / f6;
                                    measuredWidth = (int) (f6 * f7);
                                    measuredHeight = (int) (f4 * f7);
                                } else {
                                    measuredWidth = i4;
                                }
                            } else if (f5 > 0.0f) {
                                f = this.f3566O000000o;
                            } else {
                                f2 = this.f3566O000000o;
                            }
                        }
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                    }
                    f2 = this.f3566O000000o;
                    measuredWidth = (int) (f4 * f2);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                }
                f = this.f3566O000000o;
                measuredHeight = (int) (f3 / f);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }
}
