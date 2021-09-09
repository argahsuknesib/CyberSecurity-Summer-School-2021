package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class SafeScrollView extends ScrollView {
    public SafeScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeScrollView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        try {
            super.onSizeChanged(i, i2, i3, i4);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
