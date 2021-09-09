package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class ListViewWithFixedHeight extends ListView {
    public ListViewWithFixedHeight(Context context) {
        this(context, null);
    }

    public ListViewWithFixedHeight(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ListViewWithFixedHeight(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
