package com.xiaomi.smarthome.scene.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

public class ExpandableListViewWithScrollView extends ExpandableListView {
    public ExpandableListViewWithScrollView(Context context) {
        super(context);
    }

    public ExpandableListViewWithScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandableListViewWithScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
