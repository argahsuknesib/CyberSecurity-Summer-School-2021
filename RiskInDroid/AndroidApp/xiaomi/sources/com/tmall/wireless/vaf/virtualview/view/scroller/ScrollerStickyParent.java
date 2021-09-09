package com.tmall.wireless.vaf.virtualview.view.scroller;

import _m_j.dpc;
import android.content.Context;
import android.widget.FrameLayout;

public class ScrollerStickyParent extends FrameLayout implements dpc {
    public ScrollerStickyParent(Context context) {
        super(context);
    }

    public void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    public void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }
}
