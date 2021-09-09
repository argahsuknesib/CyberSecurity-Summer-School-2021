package com.reactnativecommunity.viewpager;

import _m_j.ctw;
import _m_j.ctx;
import _m_j.cty;
import _m_j.jz;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import java.util.ArrayList;
import java.util.List;

public class ReactViewPager extends ViewPager {
    public final EventDispatcher mEventDispatcher;
    public boolean mIsCurrentItemFromJs;
    private boolean mScrollEnabled = true;
    public final Runnable measureAndLayout = new Runnable() {
        /* class com.reactnativecommunity.viewpager.ReactViewPager.AnonymousClass1 */

        public final void run() {
            ReactViewPager reactViewPager = ReactViewPager.this;
            reactViewPager.measure(View.MeasureSpec.makeMeasureSpec(reactViewPager.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ReactViewPager.this.getHeight(), 1073741824));
            ReactViewPager reactViewPager2 = ReactViewPager.this;
            reactViewPager2.layout(reactViewPager2.getLeft(), ReactViewPager.this.getTop(), ReactViewPager.this.getRight(), ReactViewPager.this.getBottom());
        }
    };

    class O000000o extends jz {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<View> f5498O000000o;
        boolean O00000Oo;

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private O000000o() {
            this.f5498O000000o = new ArrayList();
            this.O00000Oo = false;
        }

        /* synthetic */ O000000o(ReactViewPager reactViewPager, byte b) {
            this();
        }

        public final int getCount() {
            return this.f5498O000000o.size();
        }

        public final int getItemPosition(Object obj) {
            if (this.O00000Oo || !this.f5498O000000o.contains(obj)) {
                return -2;
            }
            return this.f5498O000000o.indexOf(obj);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.f5498O000000o.get(i);
            viewGroup.addView(view, 0, ReactViewPager.this.generateDefaultLayoutParams());
            ReactViewPager reactViewPager = ReactViewPager.this;
            reactViewPager.post(reactViewPager.measureAndLayout);
            return view;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    class O00000Oo implements ViewPager.O0000O0o {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(ReactViewPager reactViewPager, byte b) {
            this();
        }

        public final void onPageScrolled(int i, float f, int i2) {
            ReactViewPager.this.mEventDispatcher.dispatchEvent(new ctw(ReactViewPager.this.getId(), i, f));
        }

        public final void onPageSelected(int i) {
            if (!ReactViewPager.this.mIsCurrentItemFromJs) {
                ReactViewPager.this.mEventDispatcher.dispatchEvent(new cty(ReactViewPager.this.getId(), i));
            }
        }

        public final void onPageScrollStateChanged(int i) {
            String str;
            if (i == 0) {
                str = "idle";
            } else if (i == 1) {
                str = "dragging";
            } else if (i == 2) {
                str = "settling";
            } else {
                throw new IllegalStateException("Unsupported pageScrollState");
            }
            ReactViewPager.this.mEventDispatcher.dispatchEvent(new ctx(ReactViewPager.this.getId(), str));
        }
    }

    public ReactViewPager(ReactContext reactContext) {
        super(reactContext);
        this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.mIsCurrentItemFromJs = false;
        setOnPageChangeListener(new O00000Oo(this, (byte) 0));
        setAdapter(new O000000o(this, (byte) 0));
    }

    public O000000o getAdapter() {
        return (O000000o) super.getAdapter();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                return true;
            }
        } catch (IllegalArgumentException e) {
            FLog.w("ReactNative", "Error intercepting touch event.", e);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            FLog.w("ReactNative", "Error handling touch event.", e);
            return false;
        }
    }

    public void setCurrentItemFromJs(int i, boolean z) {
        this.mIsCurrentItemFromJs = true;
        setCurrentItem(i, z);
        this.mEventDispatcher.dispatchEvent(new cty(getId(), i));
        this.mIsCurrentItemFromJs = false;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestLayout();
        post(this.measureAndLayout);
    }

    /* access modifiers changed from: package-private */
    public void addViewToAdapter(View view, int i) {
        O000000o adapter = getAdapter();
        adapter.f5498O000000o.add(i, view);
        adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void removeViewFromAdapter(int i) {
        O000000o adapter = getAdapter();
        adapter.f5498O000000o.remove(i);
        adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public int getViewCountInAdapter() {
        return getAdapter().getCount();
    }

    /* access modifiers changed from: package-private */
    public View getViewFromAdapter(int i) {
        return getAdapter().f5498O000000o.get(i);
    }

    public void setViews(List<View> list) {
        O000000o adapter = getAdapter();
        adapter.f5498O000000o.clear();
        adapter.f5498O000000o.addAll(list);
        adapter.notifyDataSetChanged();
        adapter.O00000Oo = false;
    }

    public void removeAllViewsFromAdapter() {
        O000000o adapter = getAdapter();
        adapter.f5498O000000o.clear();
        removeAllViews();
        adapter.O00000Oo = true;
    }
}
