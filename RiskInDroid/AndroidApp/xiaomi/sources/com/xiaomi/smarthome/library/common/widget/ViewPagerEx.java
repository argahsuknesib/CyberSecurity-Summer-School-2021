package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

public class ViewPagerEx extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    protected O000000o f9288O000000o = null;
    private O00000Oo O00000Oo;
    private Boolean O00000o0 = Boolean.TRUE;

    public interface O00000Oo {
    }

    public ViewPagerEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public ViewPagerEx(Context context) {
        super(context);
        O000000o(context);
    }

    private void O000000o(Context context) {
        Class<ViewPager> cls = ViewPager.class;
        try {
            Field declaredField = cls.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            this.f9288O000000o = new O000000o(context, (Interpolator) declaredField2.get(null));
            declaredField.set(this, this.f9288O000000o);
        } catch (Exception unused) {
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.O00000o0.booleanValue()) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O00000o0.booleanValue()) {
            return false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setScrollable(boolean z) {
        this.O00000o0 = Boolean.valueOf(z);
    }

    public void setViewPagerDuration(int i) {
        this.f9288O000000o.f9289O000000o = i;
    }

    public void computeScroll() {
        if (this.f9288O000000o.computeScrollOffset()) {
            this.f9288O000000o.computeScrollOffset();
        }
        super.computeScroll();
    }

    public Scroller getScroller() {
        return this.f9288O000000o;
    }

    public void setPagerFinishedListener(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    class O000000o extends Scroller {

        /* renamed from: O000000o  reason: collision with root package name */
        int f9289O000000o = 500;

        public O000000o(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public final void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.f9289O000000o);
        }
    }
}
