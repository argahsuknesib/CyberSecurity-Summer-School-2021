package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class ExpandListView extends ListView {
    public ExpandListView(Context context) {
        super(context);
    }

    public ExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
        setFocusable(false);
    }
}
