package com.xiaomi.smarthome.device;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class HeightChangeableView extends View {
    public HeightChangeableView(Context context) {
        super(context);
    }

    public HeightChangeableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HeightChangeableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }
}
