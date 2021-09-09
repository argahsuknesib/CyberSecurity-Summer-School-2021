package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.xiaomi.smarthome.R;

public class RatioImageView extends AppCompatImageView {
    private Drawable mForeground;
    private float mRatio = 1.0f;

    public RatioImageView(Context context) {
        super(context);
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_foreground, R.attr.mc_ratio});
            this.mRatio = obtainStyledAttributes.getFloat(1, 1.0f);
            int color = obtainStyledAttributes.getColor(0, -1);
            if (color != -1) {
                this.mForeground = new ColorDrawable(color);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public float getRatio() {
        return this.mRatio;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, (int) (((float) size) / this.mRatio));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
            this.mForeground.draw(canvas);
        }
    }
}
