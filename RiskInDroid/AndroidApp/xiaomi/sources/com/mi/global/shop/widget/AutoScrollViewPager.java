package com.mi.global.shop.widget;

import _m_j.jz;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class AutoScrollViewPager extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f4944O000000o = 5000;
    int O00000Oo = 1;
    boolean O00000o = true;
    boolean O00000o0 = true;
    public boolean O00000oO = false;
    private boolean O00000oo = true;
    private boolean O0000O0o = false;
    private int O0000OOo = 0;
    private boolean O0000Oo = false;
    private Handler O0000Oo0;
    private float O0000OoO = 0.0f;
    private float O0000Ooo = 0.0f;
    private Scroller O0000o00 = null;

    public AutoScrollViewPager(Context context) {
        super(context);
        O000000o();
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    private void O000000o() {
        this.O0000Oo0 = new O000000o(this);
        O00000o();
    }

    private void O00000Oo() {
        this.O00000oO = true;
        O000000o(this.f4944O000000o);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            O00000Oo();
        } else {
            O00000o0();
        }
    }

    private void O00000o0() {
        this.O00000oO = false;
        this.O0000Oo0.removeMessages(0);
    }

    public final void O000000o(long j) {
        this.O0000Oo0.removeMessages(0);
        this.O0000Oo0.sendEmptyMessageDelayed(0, j);
    }

    private void O00000o() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            this.O0000o00 = new CustomDurationScroller(getContext(), (Interpolator) declaredField2.get(null));
            declaredField.set(this, this.O0000o00);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        try {
            if (this.O00000oo && motionEvent.getAction() == 1 && this.O0000Oo && !this.O0000O0o) {
                O00000Oo();
            }
            if (this.O0000OOo == 2 || this.O0000OOo == 1) {
                this.O0000OoO = motionEvent.getX();
                if (motionEvent.getAction() == 0) {
                    this.O0000Ooo = this.O0000OoO;
                }
                int currentItem = getCurrentItem();
                jz adapter = getAdapter();
                if (adapter == null) {
                    i = 0;
                } else {
                    i = adapter.getCount();
                }
                if ((currentItem == 0 && this.O0000Ooo <= this.O0000OoO) || (currentItem == i - 1 && this.O0000Ooo >= this.O0000OoO)) {
                    if (this.O0000OOo == 2) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        if (i > 1) {
                            setCurrentItem((i - currentItem) - 1, this.O00000o);
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return super.onTouchEvent(motionEvent);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.O00000oo && motionEvent.getAction() == 0 && this.O00000oO) {
                this.O0000Oo = true;
                O00000o0();
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<AutoScrollViewPager> f4945O000000o;

        public O000000o(AutoScrollViewPager autoScrollViewPager) {
            this.f4945O000000o = new WeakReference<>(autoScrollViewPager);
        }

        public final void handleMessage(Message message) {
            int count;
            super.handleMessage(message);
            AutoScrollViewPager autoScrollViewPager = this.f4945O000000o.get();
            if (autoScrollViewPager != null && message.what == 0) {
                Rect rect = new Rect();
                autoScrollViewPager.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    jz adapter = autoScrollViewPager.getAdapter();
                    int currentItem = autoScrollViewPager.getCurrentItem();
                    if (adapter != null && (count = adapter.getCount()) > 1) {
                        int i = autoScrollViewPager.O00000Oo == 0 ? currentItem - 1 : currentItem + 1;
                        if (i < 0) {
                            if (autoScrollViewPager.O00000o0) {
                                autoScrollViewPager.setCurrentItem(count - 1, autoScrollViewPager.O00000o);
                            }
                        } else if (i != count) {
                            autoScrollViewPager.setCurrentItem(i, true);
                        } else if (autoScrollViewPager.O00000o0) {
                            autoScrollViewPager.setCurrentItem(0, autoScrollViewPager.O00000o);
                        }
                    }
                }
                autoScrollViewPager.O000000o(autoScrollViewPager.f4944O000000o);
            }
        }
    }

    public long getInterval() {
        return this.f4944O000000o;
    }

    public void setInterval(long j) {
        this.f4944O000000o = j;
    }

    public int getDirection() {
        return this.O00000Oo == 0 ? 0 : 1;
    }

    public void setDirection(int i) {
        this.O00000Oo = i;
    }

    public void setCycle(boolean z) {
        this.O00000o0 = z;
    }

    public void setStopScrollWhenTouch(boolean z) {
        this.O00000oo = z;
    }

    public void setStopScrollWhenTouched(boolean z) {
        this.O0000O0o = z;
    }

    public int getSlideBorderMode() {
        return this.O0000OOo;
    }

    public void setSlideBorderMode(int i) {
        this.O0000OOo = i;
    }

    public void setBorderAnimation(boolean z) {
        this.O00000o = z;
    }
}
