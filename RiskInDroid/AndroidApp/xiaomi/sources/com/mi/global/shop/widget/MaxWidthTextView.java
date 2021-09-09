package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.mi.util.Device;

public class MaxWidthTextView extends CustomTextView {
    private int maxWidth = (Device.f5099O000000o / 3);

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public MaxWidthTextView(Context context) {
        super(context);
    }

    public MaxWidthTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxWidthTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE && size > (i3 = this.maxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
