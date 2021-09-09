package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f4957O000000o = false;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return this.f4957O000000o && super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return this.f4957O000000o && super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getScroll() {
        return this.f4957O000000o;
    }

    public void setScroll(boolean z) {
        this.f4957O000000o = z;
    }
}
