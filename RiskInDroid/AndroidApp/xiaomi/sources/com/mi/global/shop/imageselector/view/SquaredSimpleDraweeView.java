package com.mi.global.shop.imageselector.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;

public class SquaredSimpleDraweeView extends SimpleDraweeView {
    public SquaredSimpleDraweeView(Context context) {
        super(context);
    }

    public SquaredSimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
