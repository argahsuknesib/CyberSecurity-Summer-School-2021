package com.xiaomi.smarthome.camera.view.widget;

import _m_j.chp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class BottomScrollView extends ViewGroup {
    private int mChildWidth = -1;

    public BottomScrollView(Context context) {
        super(context);
    }

    public BottomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BottomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount;
        if (getChildCount() >= 2 && (childCount = getChildCount()) > 0) {
            int measuredWidth = getChildAt(0).getMeasuredWidth();
            if (measuredWidth > 0) {
                this.mChildWidth = measuredWidth;
            }
            if (childCount > 0) {
                getChildAt(0).layout(i, i2, i3, i4);
            }
            if (childCount == 2) {
                getChildAt(1).layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        getChildAt(0).measure(i, i2);
        getChildAt(1).measure(i, i2);
        super.onMeasure(i, i2);
    }

    public int getChildWidth() {
        int i = this.mChildWidth;
        if (i > 0) {
            return i;
        }
        return (int) (((float) chp.f13827O000000o) - (chp.O00000o0 * 72.0f));
    }
}
