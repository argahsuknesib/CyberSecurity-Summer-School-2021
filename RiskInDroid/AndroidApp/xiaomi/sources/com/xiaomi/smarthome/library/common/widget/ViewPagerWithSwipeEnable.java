package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ViewPagerWithSwipeEnable extends ViewPager {
    private boolean O00000Oo = true;

    public ViewPagerWithSwipeEnable(Context context) {
        super(context);
    }

    public ViewPagerWithSwipeEnable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSwipeEnabled(boolean z) {
        this.O00000Oo = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O00000Oo) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O00000Oo) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }
}
