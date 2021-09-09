package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class BottomFadingListView extends ListView {
    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public BottomFadingListView(Context context) {
        super(context);
    }

    public BottomFadingListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BottomFadingListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
