package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class AutofitTextView extends TextView {
    public AutofitTextView(Context context) {
        super(context);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int measuredHeight = getMeasuredHeight();
        resize();
        setMeasuredDimension(size, measuredHeight);
    }

    private void resize() {
        String charSequence = getText().toString();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables[0] != null) {
            paddingLeft += compoundDrawables[0].getIntrinsicWidth() + getCompoundDrawablePadding();
        }
        if (compoundDrawables[2] != null) {
            paddingLeft += compoundDrawables[2].getIntrinsicWidth() + getCompoundDrawablePadding();
        }
        float sp2px = (float) sp2px(8);
        Paint paint = new Paint(getPaint());
        int measuredWidth = (getMeasuredWidth() - paddingLeft) - 1;
        paint.setTextSize(sp2px);
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        float width = (float) rect.width();
        while (true) {
            float f = (float) measuredWidth;
            if (width < f) {
                sp2px += 1.0f;
                paint.setTextSize(sp2px);
                float measureText = paint.measureText(charSequence);
                if (measureText >= f) {
                    sp2px -= 1.0f;
                }
                width = measureText;
            } else {
                setTextSize(0, sp2px);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        resize();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3) {
            resize();
        }
    }

    private int px2sp(float f) {
        return (int) ((f / getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private int sp2px(int i) {
        return (int) (((float) i) * getResources().getDisplayMetrics().scaledDensity);
    }
}
