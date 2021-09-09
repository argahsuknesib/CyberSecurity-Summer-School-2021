package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

public class NoScrollExpandableListView extends ExpandableListView {
    public NoScrollExpandableListView(Context context) {
        super(context);
    }

    public NoScrollExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
