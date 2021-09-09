package com.xiaomi.smarthome.scene.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class SceneTabViewPagerWithSwipeEnable extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f11323O000000o = true;

    public SceneTabViewPagerWithSwipeEnable(Context context) {
        super(context);
    }

    public SceneTabViewPagerWithSwipeEnable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSwipeEnabled(boolean z) {
        this.f11323O000000o = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11323O000000o) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f11323O000000o) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }
}
