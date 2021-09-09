package com.xiaomi.smarthome.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class FixNoScrollViewPager extends ViewPager {
    private boolean mNoScroll;

    public FixNoScrollViewPager(Context context) {
        super(context);
    }

    public FixNoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mNoScroll) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setNoScroll(boolean z) {
        this.mNoScroll = z;
    }
}
