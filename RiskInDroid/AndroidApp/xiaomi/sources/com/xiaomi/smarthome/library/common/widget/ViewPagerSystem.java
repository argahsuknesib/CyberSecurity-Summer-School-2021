package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerSystem extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f9290O000000o = true;

    public ViewPagerSystem(Context context) {
        super(context);
    }

    public ViewPagerSystem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f9290O000000o) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        this.f9290O000000o = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f9290O000000o) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
