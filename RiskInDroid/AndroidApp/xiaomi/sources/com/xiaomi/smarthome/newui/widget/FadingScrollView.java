package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class FadingScrollView extends ScrollView {
    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public FadingScrollView(Context context) {
        super(context);
    }

    public FadingScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FadingScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
