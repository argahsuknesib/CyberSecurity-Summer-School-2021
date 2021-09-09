package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class PagingViewPager extends ViewPager {
    private boolean mPagingEnabled = true;

    public PagingViewPager(Context context) {
        super(context);
    }

    public PagingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mPagingEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mPagingEnabled && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        this.mPagingEnabled = z;
    }
}
