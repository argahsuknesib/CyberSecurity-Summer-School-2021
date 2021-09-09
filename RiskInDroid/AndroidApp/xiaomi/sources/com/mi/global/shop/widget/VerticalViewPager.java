package com.mi.global.shop.widget;

import _m_j.aq;
import _m_j.ar;
import _m_j.bh;
import _m_j.cb;
import _m_j.cc;
import _m_j.cl;
import _m_j.cn;
import _m_j.jz;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VerticalViewPager extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int[] f4965O000000o = {16842931};
    private static final Comparator<O00000Oo> O00000oO = new Comparator<O00000Oo>() {
        /* class com.mi.global.shop.widget.VerticalViewPager.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((O00000Oo) obj).O00000Oo - ((O00000Oo) obj2).O00000Oo;
        }
    };
    private static final Interpolator O00000oo = new Interpolator() {
        /* class com.mi.global.shop.widget.VerticalViewPager.AnonymousClass2 */

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final O0000OOo O000Oooo = new O0000OOo();
    public jz O00000Oo;
    private int O00000o;
    public int O00000o0;
    private final ArrayList<O00000Oo> O0000O0o = new ArrayList<>();
    private final O00000Oo O0000OOo = new O00000Oo();
    private int O0000Oo = -1;
    private final Rect O0000Oo0 = new Rect();
    private Parcelable O0000OoO = null;
    private ClassLoader O0000Ooo = null;
    private int O0000o;
    private O0000O0o O0000o0;
    private Scroller O0000o00;
    private int O0000o0O;
    private Drawable O0000o0o;
    private float O0000oO = -3.4028235E38f;
    private int O0000oO0;
    private float O0000oOO = Float.MAX_VALUE;
    private int O0000oOo;
    private boolean O0000oo;
    private int O0000oo0;
    private boolean O0000ooO;
    private boolean O0000ooo;
    private boolean O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private float O000O0o;
    private float O000O0o0;
    private float O000O0oO;
    private float O000O0oo;
    private int O000OO;
    private int O000OO00 = -1;
    private VelocityTracker O000OO0o;
    private int O000OOOo;
    private int O000OOo;
    private int O000OOo0;
    private boolean O000OOoO;
    private EdgeEffectCompat O000OOoo;
    private boolean O000Oo0 = true;
    private EdgeEffectCompat O000Oo00;
    private boolean O000Oo0O = false;
    private boolean O000Oo0o;
    private ViewPager.O0000O0o O000OoO;
    private int O000OoO0;
    private O00000o O000OoOO;
    private ViewPager.O0000OOo O000OoOo;
    private int O000Ooo;
    private Method O000Ooo0;
    private ArrayList<View> O000OooO;
    private int O000o00 = 0;
    private final Runnable O000o000 = new Runnable() {
        /* class com.mi.global.shop.widget.VerticalViewPager.AnonymousClass3 */

        public final void run() {
            VerticalViewPager.this.setScrollState(0);
            VerticalViewPager.this.O00000Oo();
        }
    };
    private ViewPager.O0000O0o O00O0Oo;
    private int O00oOoOo;
    private int O00oOooO = 1;
    private boolean O00oOooo;

    interface O000000o {
    }

    interface O00000o {
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        Object f4968O000000o;
        int O00000Oo;
        float O00000o;
        boolean O00000o0;
        float O00000oO;

        O00000Oo() {
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        O00000o0();
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [com.mi.global.shop.widget.VerticalViewPager, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    private void O00000o0() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.O0000o00 = new Scroller(context, O00000oo);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.O00oOoOo = cc.O000000o(viewConfiguration);
        this.O000OO = (int) (400.0f * f);
        this.O000OOOo = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O000OOoo = new EdgeEffectCompat(context);
        this.O000Oo00 = new EdgeEffectCompat(context);
        this.O000OOo0 = (int) (25.0f * f);
        this.O000OOo = (int) (2.0f * f);
        this.O000O0OO = (int) (f * 16.0f);
        cb.O000000o(this, new O00000o0());
        if (cb.O0000O0o(this) == 0) {
            cb.O00000oO((View) this, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.O000o000);
        super.onDetachedFromWindow();
    }

    public void setScrollState(int i) {
        if (this.O000o00 != i) {
            this.O000o00 = i;
            if (this.O000OoOo != null) {
                boolean z = i != 0;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    cb.O0000O0o(getChildAt(i2), z ? 2 : 0);
                }
            }
            ViewPager.O0000O0o o0000O0o = this.O00O0Oo;
            if (o0000O0o != null) {
                o0000O0o.onPageScrollStateChanged(i);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [com.mi.global.shop.widget.VerticalViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, float, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(com.mi.global.shop.widget.VerticalViewPager$O00000Oo, int, com.mi.global.shop.widget.VerticalViewPager$O00000Oo):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void */
    public void setAdapter(jz jzVar) {
        jz jzVar2 = this.O00000Oo;
        if (jzVar2 != null) {
            jzVar2.unregisterDataSetObserver(this.O0000o0);
            this.O00000Oo.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.O0000O0o.size(); i++) {
                O00000Oo o00000Oo = this.O0000O0o.get(i);
                this.O00000Oo.destroyItem((ViewGroup) this, o00000Oo.O00000Oo, o00000Oo.f4968O000000o);
            }
            this.O00000Oo.finishUpdate((ViewGroup) this);
            this.O0000O0o.clear();
            int i2 = 0;
            while (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f4967O000000o) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
            this.O00000o0 = 0;
            scrollTo(0, 0);
        }
        this.O00000Oo = jzVar;
        this.O00000o = 0;
        if (this.O00000Oo != null) {
            if (this.O0000o0 == null) {
                this.O0000o0 = new O0000O0o(this, (byte) 0);
            }
            this.O00000Oo.registerDataSetObserver(this.O0000o0);
            this.O0000ooo = false;
            boolean z = this.O000Oo0;
            this.O000Oo0 = true;
            this.O00000o = this.O00000Oo.getCount();
            if (this.O0000Oo >= 0) {
                this.O00000Oo.restoreState(this.O0000OoO, this.O0000Ooo);
                O000000o(this.O0000Oo, false, true);
                this.O0000Oo = -1;
                this.O0000OoO = null;
                this.O0000Ooo = null;
            } else if (!z) {
                O00000Oo();
            } else {
                requestLayout();
            }
        }
    }

    public jz getAdapter() {
        return this.O00000Oo;
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(O00000o o00000o) {
        this.O000OoOO = o00000o;
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void
     arg types: [int, boolean, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, float, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(com.mi.global.shop.widget.VerticalViewPager$O00000Oo, int, com.mi.global.shop.widget.VerticalViewPager$O00000Oo):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void */
    public void setCurrentItem(int i) {
        this.O0000ooo = false;
        O000000o(i, !this.O000Oo0, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, float, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(com.mi.global.shop.widget.VerticalViewPager$O00000Oo, int, com.mi.global.shop.widget.VerticalViewPager$O00000Oo):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void */
    private void setCurrentItem$2563266(int i) {
        this.O0000ooo = false;
        O000000o(i, true, false);
    }

    public int getCurrentItem() {
        return this.O00000o0;
    }

    private void O000000o(int i, boolean z, boolean z2) {
        O000000o(i, z, z2, 0);
    }

    private void O000000o(int i, boolean z, boolean z2, int i2) {
        ViewPager.O0000O0o o0000O0o;
        ViewPager.O0000O0o o0000O0o2;
        jz jzVar = this.O00000Oo;
        if (jzVar == null || jzVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.O00000o0 != i || this.O0000O0o.size() == 0) {
            boolean z3 = true;
            if (i < 0) {
                i = 0;
            } else if (i >= this.O00000Oo.getCount()) {
                i = this.O00000Oo.getCount() - 1;
            }
            int i3 = this.O00oOooO;
            int i4 = this.O00000o0;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.O0000O0o.size(); i5++) {
                    this.O0000O0o.get(i5).O00000o0 = true;
                }
            }
            if (this.O00000o0 == i) {
                z3 = false;
            }
            if (this.O000Oo0) {
                this.O00000o0 = i;
                if (z3 && (o0000O0o2 = this.O00O0Oo) != null) {
                    o0000O0o2.onPageSelected(i);
                }
                if (z3 && (o0000O0o = this.O000OoO) != null) {
                    o0000O0o.onPageSelected(i);
                }
                requestLayout();
                return;
            }
            O00000Oo(i);
            O000000o(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void O000000o(int i, boolean z, int i2, boolean z2) {
        ViewPager.O0000O0o o0000O0o;
        ViewPager.O0000O0o o0000O0o2;
        ViewPager.O0000O0o o0000O0o3;
        ViewPager.O0000O0o o0000O0o4;
        O00000Oo O00000o02 = O00000o0(i);
        int clientHeight = O00000o02 != null ? (int) (((float) getClientHeight()) * Math.max(this.O0000oO, Math.min(O00000o02.O00000oO, this.O0000oOO))) : 0;
        if (z) {
            O000000o(clientHeight, i2);
            if (z2 && (o0000O0o4 = this.O00O0Oo) != null) {
                o0000O0o4.onPageSelected(i);
            }
            if (z2 && (o0000O0o3 = this.O000OoO) != null) {
                o0000O0o3.onPageSelected(i);
                return;
            }
            return;
        }
        if (z2 && (o0000O0o2 = this.O00O0Oo) != null) {
            o0000O0o2.onPageSelected(i);
        }
        if (z2 && (o0000O0o = this.O000OoO) != null) {
            o0000O0o.onPageSelected(i);
        }
        O000000o(false);
        scrollTo(0, clientHeight);
        O00000o(clientHeight);
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O00O0Oo = o0000O0o;
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.O000Ooo0 == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    this.O000Ooo0 = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.O000Ooo0.invoke(this, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.O000Ooo == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.O000OooO.get(i2).getLayoutParams()).O00000oo;
    }

    public int getOffscreenPageLimit() {
        return this.O00oOooO;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.O00oOooO) {
            this.O00oOooO = i;
            O00000Oo();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.O0000o0O;
        this.O0000o0O = i;
        int height = getHeight();
        O000000o(height, height, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.O0000o0O;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.O0000o0o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.O0000o0o;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.O0000o0o;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private static float O000000o(float f) {
        double d = (double) (f - 0.5f);
        Double.isNaN(d);
        return (float) Math.sin((double) ((float) (d * 0.4712389167638204d)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private void O000000o(int i, int i2) {
        int i3;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = 0 - scrollX;
        int i5 = i - scrollY;
        if (i4 == 0 && i5 == 0) {
            O000000o(false);
            O00000Oo();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i6 = clientHeight / 2;
        float f = (float) clientHeight;
        float f2 = (float) i6;
        float O000000o2 = f2 + (O000000o(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i3 = Math.round(Math.abs(O000000o2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i3 = (int) (((((float) Math.abs(i4)) / ((f * this.O00000Oo.getPageWidth(this.O00000o0)) + ((float) this.O0000o0O))) + 1.0f) * 100.0f);
        }
        this.O0000o00.startScroll(scrollX, scrollY, i4, i5, Math.min(i3, 600));
        cb.O00000oo(this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.instantiateItem(android.view.ViewGroup, int):java.lang.Object
     arg types: [com.mi.global.shop.widget.VerticalViewPager, int]
     candidates:
      _m_j.jz.instantiateItem(android.view.View, int):java.lang.Object
      _m_j.jz.instantiateItem(android.view.ViewGroup, int):java.lang.Object */
    private O00000Oo O00000Oo(int i, int i2) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.O00000Oo = i;
        o00000Oo.f4968O000000o = this.O00000Oo.instantiateItem((ViewGroup) this, i);
        o00000Oo.O00000o = this.O00000Oo.getPageWidth(i);
        if (i2 < 0 || i2 >= this.O0000O0o.size()) {
            this.O0000O0o.add(o00000Oo);
        } else {
            this.O0000O0o.add(i2, o00000Oo);
        }
        return o00000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [com.mi.global.shop.widget.VerticalViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, float, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(com.mi.global.shop.widget.VerticalViewPager$O00000Oo, int, com.mi.global.shop.widget.VerticalViewPager$O00000Oo):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void */
    /* access modifiers changed from: package-private */
    public final void O000000o() {
        int count = this.O00000Oo.getCount();
        this.O00000o = count;
        boolean z = this.O0000O0o.size() < (this.O00oOooO * 2) + 1 && this.O0000O0o.size() < count;
        int i = this.O00000o0;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.O0000O0o.size()) {
            O00000Oo o00000Oo = this.O0000O0o.get(i2);
            int itemPosition = this.O00000Oo.getItemPosition(o00000Oo.f4968O000000o);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.O0000O0o.remove(i2);
                    i2--;
                    if (!z2) {
                        this.O00000Oo.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.O00000Oo.destroyItem((ViewGroup) this, o00000Oo.O00000Oo, o00000Oo.f4968O000000o);
                    if (this.O00000o0 == o00000Oo.O00000Oo) {
                        i = Math.max(0, Math.min(this.O00000o0, count - 1));
                    }
                } else if (o00000Oo.O00000Oo != itemPosition) {
                    if (o00000Oo.O00000Oo == this.O00000o0) {
                        i = itemPosition;
                    }
                    o00000Oo.O00000Oo = itemPosition;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.O00000Oo.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.O0000O0o, O00000oO);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.f4967O000000o) {
                    layoutParams.O00000o0 = 0.0f;
                }
            }
            O000000o(i, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        O00000Oo(this.O00000o0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [com.mi.global.shop.widget.VerticalViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.setPrimaryItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [com.mi.global.shop.widget.VerticalViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.setPrimaryItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.setPrimaryItem(android.view.ViewGroup, int, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        if (r9.O00000Oo == r0.O00000o0) goto L_0x0075;
     */
    private void O00000Oo(int i) {
        O00000Oo o00000Oo;
        int i2;
        String str;
        O00000Oo o00000Oo2;
        O00000Oo O000000o2;
        float f;
        float f2;
        O00000Oo o00000Oo3;
        int i3 = i;
        int i4 = this.O00000o0;
        if (i4 != i3) {
            i2 = i4 < i3 ? 130 : 33;
            o00000Oo = O00000o0(this.O00000o0);
            this.O00000o0 = i3;
        } else {
            i2 = 2;
            o00000Oo = null;
        }
        if (this.O00000Oo == null) {
            O00000o();
        } else if (this.O0000ooo) {
            O00000o();
        } else if (getWindowToken() != null) {
            this.O00000Oo.startUpdate((ViewGroup) this);
            int i5 = this.O00oOooO;
            int max = Math.max(0, this.O00000o0 - i5);
            int count = this.O00000Oo.getCount();
            int min = Math.min(count - 1, this.O00000o0 + i5);
            if (count == this.O00000o) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.O0000O0o.size()) {
                        break;
                    }
                    o00000Oo2 = this.O0000O0o.get(i6);
                    if (o00000Oo2.O00000Oo < this.O00000o0) {
                        i6++;
                    }
                }
                o00000Oo2 = null;
                if (o00000Oo2 == null && count > 0) {
                    o00000Oo2 = O00000Oo(this.O00000o0, i6);
                }
                if (o00000Oo2 != null) {
                    int i7 = i6 - 1;
                    O00000Oo o00000Oo4 = i7 >= 0 ? this.O0000O0o.get(i7) : null;
                    int clientHeight = getClientHeight();
                    if (clientHeight <= 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) getPaddingLeft()) / ((float) clientHeight)) + (2.0f - o00000Oo2.O00000o);
                    }
                    int i8 = i7;
                    int i9 = i6;
                    float f3 = 0.0f;
                    for (int i10 = this.O00000o0 - 1; i10 >= 0; i10--) {
                        if (f3 >= f && i10 < max) {
                            if (o00000Oo4 == null) {
                                break;
                            }
                            if (i10 == o00000Oo4.O00000Oo && !o00000Oo4.O00000o0) {
                                this.O0000O0o.remove(i8);
                                this.O00000Oo.destroyItem((ViewGroup) this, i10, o00000Oo4.f4968O000000o);
                                i8--;
                                i9--;
                                if (i8 >= 0) {
                                    o00000Oo3 = this.O0000O0o.get(i8);
                                    o00000Oo4 = o00000Oo3;
                                }
                            }
                        } else if (o00000Oo4 == null || i10 != o00000Oo4.O00000Oo) {
                            f3 += O00000Oo(i10, i8 + 1).O00000o;
                            i9++;
                            if (i8 >= 0) {
                                o00000Oo3 = this.O0000O0o.get(i8);
                                o00000Oo4 = o00000Oo3;
                            }
                        } else {
                            f3 += o00000Oo4.O00000o;
                            i8--;
                            if (i8 >= 0) {
                                o00000Oo3 = this.O0000O0o.get(i8);
                                o00000Oo4 = o00000Oo3;
                            }
                        }
                        o00000Oo3 = null;
                        o00000Oo4 = o00000Oo3;
                    }
                    float f4 = o00000Oo2.O00000o;
                    int i11 = i9 + 1;
                    if (f4 < 2.0f) {
                        O00000Oo o00000Oo5 = i11 < this.O0000O0o.size() ? this.O0000O0o.get(i11) : null;
                        if (clientHeight <= 0) {
                            f2 = 0.0f;
                        } else {
                            f2 = (((float) getPaddingRight()) / ((float) clientHeight)) + 2.0f;
                        }
                        int i12 = this.O00000o0;
                        while (true) {
                            i12++;
                            if (i12 >= count) {
                                break;
                            }
                            if (f4 >= f2 && i12 > min) {
                                if (o00000Oo5 == null) {
                                    break;
                                } else if (i12 == o00000Oo5.O00000Oo && !o00000Oo5.O00000o0) {
                                    this.O0000O0o.remove(i11);
                                    this.O00000Oo.destroyItem((ViewGroup) this, i12, o00000Oo5.f4968O000000o);
                                    if (i11 < this.O0000O0o.size()) {
                                        o00000Oo5 = this.O0000O0o.get(i11);
                                    }
                                }
                            } else if (o00000Oo5 == null || i12 != o00000Oo5.O00000Oo) {
                                O00000Oo O00000Oo2 = O00000Oo(i12, i11);
                                i11++;
                                f4 += O00000Oo2.O00000o;
                                if (i11 < this.O0000O0o.size()) {
                                    o00000Oo5 = this.O0000O0o.get(i11);
                                }
                            } else {
                                f4 += o00000Oo5.O00000o;
                                i11++;
                                if (i11 < this.O0000O0o.size()) {
                                    o00000Oo5 = this.O0000O0o.get(i11);
                                }
                            }
                            o00000Oo5 = null;
                        }
                    }
                    O000000o(o00000Oo2, i9, o00000Oo);
                }
                this.O00000Oo.setPrimaryItem((ViewGroup) this, this.O00000o0, o00000Oo2 != null ? o00000Oo2.f4968O000000o : null);
                this.O00000Oo.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.O00000oo = i13;
                    if (!layoutParams.f4967O000000o) {
                        if (layoutParams.O00000o0 == 0.0f && (O000000o2 = O000000o(childAt)) != null) {
                            layoutParams.O00000o0 = O000000o2.O00000o;
                            layoutParams.O00000oO = O000000o2.O00000Oo;
                        }
                    }
                }
                O00000o();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    O00000Oo O00000Oo3 = findFocus != null ? O00000Oo(findFocus) : null;
                    if (O00000Oo3 == null || O00000Oo3.O00000Oo != this.O00000o0) {
                        int i14 = 0;
                        while (i14 < getChildCount()) {
                            View childAt2 = getChildAt(i14);
                            O00000Oo O000000o3 = O000000o(childAt2);
                            if (O000000o3 == null || O000000o3.O00000Oo != this.O00000o0 || !childAt2.requestFocus(i2)) {
                                i14++;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                str = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                str = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.O00000o + ", found: " + count + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.O00000Oo.getClass());
        }
    }

    private void O00000o() {
        if (this.O000Ooo != 0) {
            ArrayList<View> arrayList = this.O000OooO;
            if (arrayList == null) {
                this.O000OooO = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.O000OooO.add(getChildAt(i));
            }
            Collections.sort(this.O000OooO, O000Oooo);
        }
    }

    private void O000000o(O00000Oo o00000Oo, int i, O00000Oo o00000Oo2) {
        O00000Oo o00000Oo3;
        O00000Oo o00000Oo4;
        int count = this.O00000Oo.getCount();
        int clientHeight = getClientHeight();
        float f = clientHeight > 0 ? ((float) this.O0000o0O) / ((float) clientHeight) : 0.0f;
        if (o00000Oo2 != null) {
            int i2 = o00000Oo2.O00000Oo;
            if (i2 < o00000Oo.O00000Oo) {
                float f2 = o00000Oo2.O00000oO + o00000Oo2.O00000o + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= o00000Oo.O00000Oo && i4 < this.O0000O0o.size()) {
                    O00000Oo o00000Oo5 = this.O0000O0o.get(i4);
                    while (true) {
                        o00000Oo4 = o00000Oo5;
                        if (i3 > o00000Oo4.O00000Oo && i4 < this.O0000O0o.size() - 1) {
                            i4++;
                            o00000Oo5 = this.O0000O0o.get(i4);
                        }
                    }
                    while (i3 < o00000Oo4.O00000Oo) {
                        f2 += this.O00000Oo.getPageWidth(i3) + f;
                        i3++;
                    }
                    o00000Oo4.O00000oO = f2;
                    f2 += o00000Oo4.O00000o + f;
                    i3++;
                }
            } else if (i2 > o00000Oo.O00000Oo) {
                int size = this.O0000O0o.size() - 1;
                float f3 = o00000Oo2.O00000oO;
                while (true) {
                    i2--;
                    if (i2 < o00000Oo.O00000Oo || size < 0) {
                        break;
                    }
                    O00000Oo o00000Oo6 = this.O0000O0o.get(size);
                    while (true) {
                        o00000Oo3 = o00000Oo6;
                        if (i2 < o00000Oo3.O00000Oo && size > 0) {
                            size--;
                            o00000Oo6 = this.O0000O0o.get(size);
                        }
                    }
                    while (i2 > o00000Oo3.O00000Oo) {
                        f3 -= this.O00000Oo.getPageWidth(i2) + f;
                        i2--;
                    }
                    f3 -= o00000Oo3.O00000o + f;
                    o00000Oo3.O00000oO = f3;
                }
            }
        }
        int size2 = this.O0000O0o.size();
        float f4 = o00000Oo.O00000oO;
        int i5 = o00000Oo.O00000Oo - 1;
        this.O0000oO = o00000Oo.O00000Oo == 0 ? o00000Oo.O00000oO : -3.4028235E38f;
        int i6 = count - 1;
        this.O0000oOO = o00000Oo.O00000Oo == i6 ? (o00000Oo.O00000oO + o00000Oo.O00000o) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            O00000Oo o00000Oo7 = this.O0000O0o.get(i7);
            while (i5 > o00000Oo7.O00000Oo) {
                f4 -= this.O00000Oo.getPageWidth(i5) + f;
                i5--;
            }
            f4 -= o00000Oo7.O00000o + f;
            o00000Oo7.O00000oO = f4;
            if (o00000Oo7.O00000Oo == 0) {
                this.O0000oO = f4;
            }
            i7--;
            i5--;
        }
        float f5 = o00000Oo.O00000oO + o00000Oo.O00000o + f;
        int i8 = o00000Oo.O00000Oo + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            O00000Oo o00000Oo8 = this.O0000O0o.get(i9);
            while (i8 < o00000Oo8.O00000Oo) {
                f5 += this.O00000Oo.getPageWidth(i8) + f;
                i8++;
            }
            if (o00000Oo8.O00000Oo == i6) {
                this.O0000oOO = (o00000Oo8.O00000o + f5) - 1.0f;
            }
            o00000Oo8.O00000oO = f5;
            f5 += o00000Oo8.O00000o + f;
            i9++;
            i8++;
        }
        this.O000Oo0O = false;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = aq.O000000o(new ar<SavedState>() {
            /* class com.mi.global.shop.widget.VerticalViewPager.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        });

        /* renamed from: O000000o  reason: collision with root package name */
        int f4971O000000o;
        Parcelable O00000Oo;
        ClassLoader O00000o0;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4971O000000o);
            parcel.writeParcelable(this.O00000Oo, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f4971O000000o + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f4971O000000o = parcel.readInt();
            this.O00000Oo = parcel.readParcelable(classLoader);
            this.O00000o0 = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4971O000000o = this.O00000o0;
        jz jzVar = this.O00000Oo;
        if (jzVar != null) {
            savedState.O00000Oo = jzVar.saveState();
        }
        return savedState;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, float, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(com.mi.global.shop.widget.VerticalViewPager$O00000Oo, int, com.mi.global.shop.widget.VerticalViewPager$O00000Oo):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean):void */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        jz jzVar = this.O00000Oo;
        if (jzVar != null) {
            jzVar.restoreState(savedState.O00000Oo, savedState.O00000o0);
            O000000o(savedState.f4971O000000o, false, true);
            return;
        }
        this.O0000Oo = savedState.f4971O000000o;
        this.O0000OoO = savedState.O00000Oo;
        this.O0000Ooo = savedState.O00000o0;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.f4967O000000o |= view instanceof O000000o;
        if (!this.O0000oo) {
            super.addView(view, i, layoutParams);
        } else if (layoutParams2 == null || !layoutParams2.f4967O000000o) {
            layoutParams2.O00000o = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.O0000oo) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private O00000Oo O000000o(View view) {
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            O00000Oo o00000Oo = this.O0000O0o.get(i);
            if (this.O00000Oo.isViewFromObject(view, o00000Oo.f4968O000000o)) {
                return o00000Oo;
            }
        }
        return null;
    }

    private O00000Oo O00000Oo(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return O000000o(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    private O00000Oo O00000o0(int i) {
        for (int i2 = 0; i2 < this.O0000O0o.size(); i2++) {
            O00000Oo o00000Oo = this.O0000O0o.get(i2);
            if (o00000Oo.O00000Oo == i) {
                return o00000Oo;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O000Oo0 = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredHeight = getMeasuredHeight();
        this.O000O0Oo = Math.min(measuredHeight / 10, this.O000O0OO);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = paddingTop;
        int i7 = 0;
        while (true) {
            boolean z = true;
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.f4967O000000o)) {
                int i9 = layoutParams2.O00000Oo & 7;
                int i10 = layoutParams2.O00000Oo & 112;
                boolean z2 = i10 == 48 || i10 == 80;
                if (!(i9 == 3 || i9 == 5)) {
                    z = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z2) {
                    i11 = 1073741824;
                } else if (z) {
                    i3 = 1073741824;
                    if (layoutParams2.width == -2) {
                        i4 = layoutParams2.width != -1 ? layoutParams2.width : measuredWidth;
                        i11 = 1073741824;
                    } else {
                        i4 = measuredWidth;
                    }
                    if (layoutParams2.height == -2) {
                        i5 = layoutParams2.height != -1 ? layoutParams2.height : i6;
                    } else {
                        i5 = i6;
                        i8 = i3;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i8));
                    if (!z2) {
                        i6 -= childAt.getMeasuredHeight();
                    } else if (z) {
                        measuredWidth -= childAt.getMeasuredWidth();
                    }
                }
                i3 = Integer.MIN_VALUE;
                if (layoutParams2.width == -2) {
                }
                if (layoutParams2.height == -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i8));
                if (!z2) {
                }
            }
            i7++;
        }
        this.O0000oOo = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.O0000oo0 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        this.O0000oo = true;
        O00000Oo();
        this.O0000oo = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f4967O000000o)) {
                childAt2.measure(this.O0000oOo, View.MeasureSpec.makeMeasureSpec((int) (((float) i6) * layoutParams.O00000o0), 1073741824));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            int i5 = this.O0000o0O;
            O000000o(i2, i4, i5, i5);
        }
    }

    private void O000000o(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.O0000O0o.isEmpty()) {
            O00000Oo O00000o02 = O00000o0(this.O00000o0);
            int min = (int) ((O00000o02 != null ? Math.min(O00000o02.O00000oO, this.O0000oOO) : 0.0f) * ((float) ((i - getPaddingTop()) - getPaddingBottom())));
            if (min != getScrollY()) {
                O000000o(false);
                scrollTo(getScrollX(), min);
                return;
            }
            return;
        }
        int scrollY = (int) ((((float) getScrollY()) / ((float) (((i2 - getPaddingTop()) - getPaddingBottom()) + i4))) * ((float) (((i - getPaddingTop()) - getPaddingBottom()) + i3)));
        scrollTo(getScrollX(), scrollY);
        if (!this.O0000o00.isFinished()) {
            this.O0000o00.startScroll(0, scrollY, 0, (int) (O00000o0(this.O00000o0).O00000oO * ((float) i)), this.O0000o00.getDuration() - this.O0000o00.timePassed());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, int, boolean):void
     arg types: [int, int, int, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, int, int, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, int, boolean):void */
    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        O00000Oo O000000o2;
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i9 = paddingRight;
        int i10 = 0;
        int i11 = paddingLeft;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4967O000000o) {
                    int i13 = layoutParams.O00000Oo & 7;
                    int i14 = layoutParams.O00000Oo & 112;
                    if (i13 == 1) {
                        i5 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, i11);
                    } else if (i13 == 3) {
                        i5 = i11;
                        i11 = childAt.getMeasuredWidth() + i11;
                    } else if (i13 != 5) {
                        i5 = i11;
                    } else {
                        i5 = (i7 - i9) - childAt.getMeasuredWidth();
                        i9 += childAt.getMeasuredWidth();
                    }
                    if (i14 == 16) {
                        i6 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    } else if (i14 == 48) {
                        i6 = paddingTop;
                        paddingTop = childAt.getMeasuredHeight() + paddingTop;
                    } else if (i14 != 80) {
                        i6 = paddingTop;
                    } else {
                        i6 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                        paddingBottom += childAt.getMeasuredHeight();
                    }
                    int i15 = i6 + scrollY;
                    childAt.layout(i5, i15, childAt.getMeasuredWidth() + i5, i15 + childAt.getMeasuredHeight());
                    i10++;
                }
            }
        }
        int i16 = (i8 - paddingTop) - paddingBottom;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f4967O000000o && (O000000o2 = O000000o(childAt2)) != null) {
                    float f = (float) i16;
                    int i18 = ((int) (O000000o2.O00000oO * f)) + paddingTop;
                    if (layoutParams2.O00000o) {
                        layoutParams2.O00000o = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i7 - i11) - i9, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.O00000o0), 1073741824));
                    }
                    childAt2.layout(i11, i18, childAt2.getMeasuredWidth() + i11, childAt2.getMeasuredHeight() + i18);
                }
            }
        }
        this.O0000o = i11;
        this.O0000oO0 = i7 - i9;
        this.O000OoO0 = i10;
        if (this.O000Oo0) {
            z2 = false;
            O000000o(this.O00000o0, false, 0, false);
        } else {
            z2 = false;
        }
        this.O000Oo0 = z2;
    }

    public void computeScroll() {
        if (this.O0000o00.isFinished() || !this.O0000o00.computeScrollOffset()) {
            O000000o(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.O0000o00.getCurrX();
        int currY = this.O0000o00.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!O00000o(currY)) {
                this.O0000o00.abortAnimation();
                scrollTo(currX, 0);
            }
        }
        cb.O00000oo(this);
    }

    private boolean O00000o(int i) {
        if (this.O0000O0o.size() == 0) {
            this.O000Oo0o = false;
            O000000o(0, 0.0f, 0);
            if (this.O000Oo0o) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        O00000Oo O00000oo2 = O00000oo();
        int clientHeight = getClientHeight();
        int i2 = this.O0000o0O;
        int i3 = clientHeight + i2;
        float f = (float) clientHeight;
        int i4 = O00000oo2.O00000Oo;
        float f2 = ((((float) i) / f) - O00000oo2.O00000oO) / (O00000oo2.O00000o + (((float) i2) / f));
        this.O000Oo0o = false;
        O000000o(i4, f2, (int) (((float) i3) * f2));
        if (this.O000Oo0o) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    private void O000000o(int i, float f, int i2) {
        int i3;
        int top;
        int i4;
        if (this.O000OoO0 > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            int i5 = paddingBottom;
            int i6 = paddingTop;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4967O000000o) {
                    int i8 = layoutParams.O00000Oo & 112;
                    if (i8 != 16) {
                        if (i8 == 48) {
                            i3 = childAt.getHeight() + i6;
                        } else if (i8 != 80) {
                            i3 = i6;
                        } else {
                            i4 = (height - i5) - childAt.getMeasuredHeight();
                            i5 += childAt.getMeasuredHeight();
                        }
                        top = (i6 + scrollY) - childAt.getTop();
                        if (top != 0) {
                            childAt.offsetTopAndBottom(top);
                        }
                        i6 = i3;
                    } else {
                        i4 = Math.max((height - childAt.getMeasuredHeight()) / 2, i6);
                    }
                    int i9 = i4;
                    i3 = i6;
                    i6 = i9;
                    top = (i6 + scrollY) - childAt.getTop();
                    if (top != 0) {
                    }
                    i6 = i3;
                }
            }
        }
        ViewPager.O0000O0o o0000O0o = this.O00O0Oo;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i, f, i2);
        }
        ViewPager.O0000O0o o0000O0o2 = this.O000OoO;
        if (o0000O0o2 != null) {
            o0000O0o2.onPageScrolled(i, f, i2);
        }
        if (this.O000OoOo != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt2 = getChildAt(i10);
                if (!((LayoutParams) childAt2.getLayoutParams()).f4967O000000o) {
                    this.O000OoOo.transformPage(childAt2, ((float) (childAt2.getTop() - scrollY2)) / ((float) getClientHeight()));
                }
            }
        }
        this.O000Oo0o = true;
    }

    private void O000000o(boolean z) {
        boolean z2 = this.O000o00 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.O0000o00.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.O0000o00.getCurrX();
            int currY = this.O0000o00.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.O0000ooo = false;
        boolean z3 = z2;
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            O00000Oo o00000Oo = this.O0000O0o.get(i);
            if (o00000Oo.O00000o0) {
                o00000Oo.O00000o0 = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            cb.O000000o(this, this.O000o000);
        } else {
            this.O000o000.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        try {
            int action = motionEvent.getAction() & 255;
            if (action != 3) {
                if (action != 1) {
                    if (action != 0) {
                        if (this.O00oOooo) {
                            return true;
                        }
                        if (this.O000O00o) {
                            return false;
                        }
                    }
                    if (action == 0) {
                        float x = motionEvent.getX();
                        this.O000O0oO = x;
                        this.O000O0o0 = x;
                        float y = motionEvent.getY();
                        this.O000O0oo = y;
                        this.O000O0o = y;
                        this.O000OO00 = motionEvent2.getPointerId(0);
                        this.O000O00o = false;
                        this.O0000o00.computeScrollOffset();
                        if (this.O000o00 != 2 || Math.abs(this.O0000o00.getFinalY() - this.O0000o00.getCurrY()) <= this.O000OOo) {
                            O000000o(false);
                            this.O00oOooo = false;
                        } else {
                            this.O0000o00.abortAnimation();
                            this.O0000ooo = false;
                            O00000Oo();
                            this.O00oOooo = true;
                            O00000oO();
                            setScrollState(1);
                        }
                    } else if (action == 2) {
                        int i = this.O000OO00;
                        if (i != -1) {
                            int findPointerIndex = motionEvent2.findPointerIndex(i);
                            float y2 = motionEvent2.getY(findPointerIndex);
                            float f = y2 - this.O000O0o;
                            float abs = Math.abs(f);
                            float x2 = motionEvent2.getX(findPointerIndex);
                            float abs2 = Math.abs(x2 - this.O000O0oO);
                            if (f != 0.0f) {
                                float f2 = this.O000O0o;
                                if (!((f2 < ((float) this.O000O0Oo) && f > 0.0f) || (f2 > ((float) (getHeight() - this.O000O0Oo)) && f < 0.0f)) && O000000o(this, false, (int) f, (int) x2, (int) y2)) {
                                    this.O000O0o0 = x2;
                                    this.O000O0o = y2;
                                    this.O000O00o = true;
                                    return false;
                                }
                            }
                            if (abs > ((float) this.O00oOoOo) && abs * 0.5f > abs2) {
                                this.O00oOooo = true;
                                O00000oO();
                                setScrollState(1);
                                this.O000O0o = f > 0.0f ? this.O000O0oo + ((float) this.O00oOoOo) : this.O000O0oo - ((float) this.O00oOoOo);
                                this.O000O0o0 = x2;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > ((float) this.O00oOoOo)) {
                                this.O000O00o = true;
                            }
                            if (this.O00oOooo && O00000Oo(y2)) {
                                cb.O00000oo(this);
                            }
                        }
                    } else if (action == 6) {
                        O000000o(motionEvent);
                    }
                    if (this.O000OO0o == null) {
                        this.O000OO0o = VelocityTracker.obtain();
                    }
                    this.O000OO0o.addMovement(motionEvent2);
                    return this.O00oOooo;
                }
            }
            this.O00oOooo = false;
            this.O000O00o = false;
            this.O000OO00 = -1;
            if (this.O000OO0o != null) {
                this.O000OO0o.recycle();
                this.O000OO0o = null;
            }
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, int, boolean):void
     arg types: [int, int, int, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, int, int, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, int, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean, int):void
     arg types: [int, int, int, int]
     candidates:
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, int, int, int):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, int, boolean):void
      com.mi.global.shop.widget.VerticalViewPager.O000000o(int, boolean, boolean, int):void */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01be A[Catch:{ IllegalArgumentException -> 0x01c3 }] */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean O000000o2;
        boolean O000000o3;
        try {
            if (this.O000OOoO) {
                return true;
            }
            if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && this.O00000Oo != null) {
                if (this.O00000Oo.getCount() != 0) {
                    if (this.O000OO0o == null) {
                        this.O000OO0o = VelocityTracker.obtain();
                    }
                    this.O000OO0o.addMovement(motionEvent);
                    int action = motionEvent.getAction() & 255;
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                if (!this.O00oOooo) {
                                    int findPointerIndex = motionEvent.findPointerIndex(this.O000OO00);
                                    float y = motionEvent.getY(findPointerIndex);
                                    float abs = Math.abs(y - this.O000O0o);
                                    float x = motionEvent.getX(findPointerIndex);
                                    float abs2 = Math.abs(x - this.O000O0o0);
                                    if (abs > ((float) this.O00oOoOo) && abs > abs2) {
                                        this.O00oOooo = true;
                                        O00000oO();
                                        this.O000O0o = y - this.O000O0oo > 0.0f ? this.O000O0oo + ((float) this.O00oOoOo) : this.O000O0oo - ((float) this.O00oOoOo);
                                        this.O000O0o0 = x;
                                        setScrollState(1);
                                        setScrollingCacheEnabled(true);
                                        ViewParent parent = getParent();
                                        if (parent != null) {
                                            parent.requestDisallowInterceptTouchEvent(true);
                                        }
                                    }
                                }
                                if (this.O00oOooo) {
                                    z = O00000Oo(motionEvent.getY(motionEvent.findPointerIndex(this.O000OO00))) | false;
                                    if (z) {
                                        cb.O00000oo(this);
                                    }
                                    return true;
                                }
                            } else if (action != 3) {
                                if (action == 5) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    this.O000O0o = motionEvent.getY(actionIndex);
                                    this.O000OO00 = motionEvent.getPointerId(actionIndex);
                                } else if (action == 6) {
                                    O000000o(motionEvent);
                                    this.O000O0o = motionEvent.getY(motionEvent.findPointerIndex(this.O000OO00));
                                }
                            } else if (this.O00oOooo) {
                                O000000o(this.O00000o0, true, 0, false);
                                this.O000OO00 = -1;
                                O0000O0o();
                                O000000o2 = this.O000OOoo.O000000o();
                                O000000o3 = this.O000Oo00.O000000o();
                            }
                        } else if (this.O00oOooo) {
                            VelocityTracker velocityTracker = this.O000OO0o;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.O000OOOo);
                            int yVelocity = (int) velocityTracker.getYVelocity(this.O000OO00);
                            this.O0000ooo = true;
                            int clientHeight = getClientHeight();
                            int scrollY = getScrollY();
                            O00000Oo O00000oo2 = O00000oo();
                            int i = O00000oo2.O00000Oo;
                            float f = ((((float) scrollY) / ((float) clientHeight)) - O00000oo2.O00000oO) / O00000oo2.O00000o;
                            if (Math.abs((int) (motionEvent.getY(motionEvent.findPointerIndex(this.O000OO00)) - this.O000O0oo)) <= this.O000OOo0 || Math.abs(yVelocity) <= this.O000OO) {
                                i = (int) (((float) i) + f + (i >= this.O00000o0 ? 0.9f : 0.1f));
                            } else if (yVelocity <= 0) {
                                i++;
                            }
                            if (this.O0000O0o.size() > 0) {
                                i = Math.max(this.O0000O0o.get(0).O00000Oo, Math.min(i, this.O0000O0o.get(this.O0000O0o.size() - 1).O00000Oo));
                            }
                            O000000o(i, true, true, yVelocity);
                            this.O000OO00 = -1;
                            O0000O0o();
                            O000000o2 = this.O000OOoo.O000000o();
                            O000000o3 = this.O000Oo00.O000000o();
                        }
                        z = O000000o2 | O000000o3;
                        if (z) {
                        }
                        return true;
                    }
                    this.O0000o00.abortAnimation();
                    this.O0000ooo = false;
                    O00000Oo();
                    float x2 = motionEvent.getX();
                    this.O000O0oO = x2;
                    this.O000O0o0 = x2;
                    float y2 = motionEvent.getY();
                    this.O000O0oo = y2;
                    this.O000O0o = y2;
                    this.O000OO00 = motionEvent.getPointerId(0);
                    z = false;
                    if (z) {
                    }
                    return true;
                }
            }
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void O00000oO() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean O00000Oo(float f) {
        boolean z;
        float f2 = this.O000O0o - f;
        this.O000O0o = f;
        float scrollY = ((float) getScrollY()) + f2;
        float clientHeight = (float) getClientHeight();
        float f3 = this.O0000oO * clientHeight;
        float f4 = this.O0000oOO * clientHeight;
        boolean z2 = false;
        O00000Oo o00000Oo = this.O0000O0o.get(0);
        ArrayList<O00000Oo> arrayList = this.O0000O0o;
        boolean z3 = true;
        O00000Oo o00000Oo2 = arrayList.get(arrayList.size() - 1);
        if (o00000Oo.O00000Oo != 0) {
            f3 = o00000Oo.O00000oO * clientHeight;
            z = false;
        } else {
            z = true;
        }
        if (o00000Oo2.O00000Oo != this.O00000Oo.getCount() - 1) {
            f4 = o00000Oo2.O00000oO * clientHeight;
            z3 = false;
        }
        if (scrollY < f3) {
            if (z) {
                z2 = this.O000OOoo.O000000o(Math.abs(f3 - scrollY) / clientHeight);
            }
            scrollY = f3;
        } else if (scrollY > f4) {
            if (z3) {
                z2 = this.O000Oo00.O000000o(Math.abs(scrollY - f4) / clientHeight);
            }
            scrollY = f4;
        }
        int i = (int) scrollY;
        this.O000O0o0 += scrollY - ((float) i);
        scrollTo(getScrollX(), i);
        O00000o(i);
        return z2;
    }

    private O00000Oo O00000oo() {
        int i;
        int clientHeight = getClientHeight();
        float scrollY = clientHeight > 0 ? ((float) getScrollY()) / ((float) clientHeight) : 0.0f;
        float f = clientHeight > 0 ? ((float) this.O0000o0O) / ((float) clientHeight) : 0.0f;
        O00000Oo o00000Oo = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.O0000O0o.size()) {
            O00000Oo o00000Oo2 = this.O0000O0o.get(i2);
            if (!z && o00000Oo2.O00000Oo != (i = i3 + 1)) {
                o00000Oo2 = this.O0000OOo;
                o00000Oo2.O00000oO = f2 + f3 + f;
                o00000Oo2.O00000Oo = i;
                o00000Oo2.O00000o = this.O00000Oo.getPageWidth(o00000Oo2.O00000Oo);
                i2--;
            }
            f2 = o00000Oo2.O00000oO;
            float f4 = o00000Oo2.O00000o + f2 + f;
            if (!z && scrollY < f2) {
                return o00000Oo;
            }
            if (scrollY < f4 || i2 == this.O0000O0o.size() - 1) {
                return o00000Oo2;
            }
            i3 = o00000Oo2.O00000Oo;
            f3 = o00000Oo2.O00000o;
            i2++;
            o00000Oo = o00000Oo2;
            z = false;
        }
        return o00000Oo;
    }

    public void draw(Canvas canvas) {
        jz jzVar;
        super.draw(canvas);
        int O000000o2 = cb.O000000o((View) this);
        boolean z = false;
        if (O000000o2 == 0 || (O000000o2 == 1 && (jzVar = this.O00000Oo) != null && jzVar.getCount() > 1)) {
            if (!this.O000OOoo.f2846O000000o.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), this.O0000oO * ((float) height));
                this.O000OOoo.O000000o(width, height);
                z = false | this.O000OOoo.O000000o(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.O000Oo00.f2846O000000o.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((float) ((-width2) - getPaddingLeft()), (-(this.O0000oOO + 1.0f)) * ((float) height2));
                this.O000Oo00.O000000o(width2, height2);
                z |= this.O000Oo00.O000000o(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.O000OOoo.f2846O000000o.finish();
            this.O000Oo00.f2846O000000o.finish();
        }
        if (z) {
            cb.O00000oo(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.O0000o0O > 0 && this.O0000o0o != null && this.O0000O0o.size() > 0 && this.O00000Oo != null) {
            int scrollY = getScrollY();
            int height = getHeight();
            float f4 = (float) height;
            float f5 = ((float) this.O0000o0O) / f4;
            int i = 0;
            O00000Oo o00000Oo = this.O0000O0o.get(0);
            float f6 = o00000Oo.O00000oO;
            int size = this.O0000O0o.size();
            int i2 = o00000Oo.O00000Oo;
            int i3 = this.O0000O0o.get(size - 1).O00000Oo;
            while (i2 < i3) {
                while (i2 > o00000Oo.O00000Oo && i < size) {
                    i++;
                    o00000Oo = this.O0000O0o.get(i);
                }
                if (i2 == o00000Oo.O00000Oo) {
                    f2 = (o00000Oo.O00000oO + o00000Oo.O00000o) * f4;
                    f = o00000Oo.O00000oO + o00000Oo.O00000o + f5;
                } else {
                    float pageWidth = this.O00000Oo.getPageWidth(i2);
                    f = f6 + pageWidth + f5;
                    f2 = (f6 + pageWidth) * f4;
                }
                int i4 = this.O0000o0O;
                if (((float) i4) + f2 > ((float) scrollY)) {
                    f3 = f5;
                    this.O0000o0o.setBounds(this.O0000o, (int) f2, this.O0000oO0, (int) (((float) i4) + f2 + 0.5f));
                    this.O0000o0o.draw(canvas);
                } else {
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollY + height))) {
                    i2++;
                    f6 = f;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    private void O0000O0o() {
        this.O00oOooo = false;
        this.O000O00o = false;
        VelocityTracker velocityTracker = this.O000OO0o;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O000OO0o = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.O0000ooO != z) {
            this.O0000ooO = z;
        }
    }

    public final boolean O000000o(int i) {
        if (this.O00000Oo == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i < 0) {
            if (scrollY > ((int) (((float) clientHeight) * this.O0000oO))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollY >= ((int) (((float) clientHeight) * this.O0000oOO))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean O000000o(View view, boolean z, int i, int i2, int i3) {
        int i4;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i3 + scrollY;
                if (i5 >= childAt.getTop() && i5 < childAt.getBottom() && (i4 = i2 + scrollX) >= childAt.getLeft() && i4 < childAt.getRight()) {
                    if (O000000o(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !cb.O00000Oo(view, -i)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e A[RETURN] */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 21) {
                    z = O00000oO(17);
                } else if (keyCode == 22) {
                    z = O00000oO(66);
                } else if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                    if (keyEvent.hasNoModifiers()) {
                        z = O00000oO(2);
                    } else if (keyEvent.hasModifiers(1)) {
                        z = O00000oO(1);
                    }
                }
                return !z;
            }
            z = false;
            if (!z) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b9, code lost:
        if (r7 != 2) goto L_0x00c4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c6  */
    private boolean O00000oO(int i) {
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 33) {
                z2 = (view == null || O000000o(this.O0000Oo0, findNextFocus).top < O000000o(this.O0000Oo0, view).top) ? findNextFocus.requestFocus() : O0000OOo();
            } else if (i == 130) {
                int i2 = O000000o(this.O0000Oo0, findNextFocus).bottom;
                int i3 = O000000o(this.O0000Oo0, view).bottom;
                if (view == null || i2 > i3) {
                    z2 = findNextFocus.requestFocus();
                }
            }
            if (z2) {
            }
            return z2;
        } else if (i == 33 || i == 1) {
            z2 = O0000OOo();
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z2;
        } else if (i != 130) {
        }
        z2 = O0000Oo0();
        if (z2) {
        }
        return z2;
    }

    private Rect O000000o(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private boolean O0000OOo() {
        int i = this.O00000o0;
        if (i <= 0) {
            return false;
        }
        setCurrentItem$2563266(i - 1);
        return true;
    }

    private boolean O0000Oo0() {
        jz jzVar = this.O00000Oo;
        if (jzVar == null || this.O00000o0 >= jzVar.getCount() - 1) {
            return false;
        }
        setCurrentItem$2563266(this.O00000o0 + 1);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        O00000Oo O000000o2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000o0) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        O00000Oo O000000o2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000o0) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        O00000Oo O000000o2;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000o0 && childAt.requestFocus(i, rect)) {
                return true;
            }
            i3 += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        O00000Oo O000000o2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000o0 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    class O00000o0 extends bh {
        O00000o0() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            cn O000000o2 = cn.O000000o();
            O000000o2.O000000o(O000000o());
            if (accessibilityEvent.getEventType() == 4096 && VerticalViewPager.this.O00000Oo != null) {
                O000000o2.O000000o(VerticalViewPager.this.O00000Oo.getCount());
                O000000o2.O00000Oo(VerticalViewPager.this.O00000o0);
                O000000o2.O00000o0(VerticalViewPager.this.O00000o0);
            }
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            clVar.O00000Oo((CharSequence) ViewPager.class.getName());
            clVar.O0000OoO(O000000o());
            if (VerticalViewPager.this.O000000o(1)) {
                clVar.O000000o(4096);
            }
            if (VerticalViewPager.this.O000000o(-1)) {
                clVar.O000000o(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !VerticalViewPager.this.O000000o(-1)) {
                    return false;
                }
                VerticalViewPager verticalViewPager = VerticalViewPager.this;
                verticalViewPager.setCurrentItem(verticalViewPager.O00000o0 - 1);
                return true;
            } else if (!VerticalViewPager.this.O000000o(1)) {
                return false;
            } else {
                VerticalViewPager verticalViewPager2 = VerticalViewPager.this;
                verticalViewPager2.setCurrentItem(verticalViewPager2.O00000o0 + 1);
                return true;
            }
        }

        private boolean O000000o() {
            return VerticalViewPager.this.O00000Oo != null && VerticalViewPager.this.O00000Oo.getCount() > 1;
        }
    }

    class O0000O0o extends DataSetObserver {
        private O0000O0o() {
        }

        /* synthetic */ O0000O0o(VerticalViewPager verticalViewPager, byte b) {
            this();
        }

        public final void onChanged() {
            VerticalViewPager.this.O000000o();
        }

        public final void onInvalidated() {
            VerticalViewPager.this.O000000o();
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f4967O000000o;
        public int O00000Oo;
        boolean O00000o;
        float O00000o0 = 0.0f;
        int O00000oO;
        int O00000oo;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.f4965O000000o);
            this.O00000Oo = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class O0000OOo implements Comparator<View> {
        O0000OOo() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.f4967O000000o != layoutParams2.f4967O000000o) {
                return layoutParams.f4967O000000o ? 1 : -1;
            }
            return layoutParams.O00000oO - layoutParams2.O00000oO;
        }
    }

    private void O000000o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O000OO00) {
            int i = actionIndex == 0 ? 1 : 0;
            this.O000O0o = motionEvent.getY(i);
            this.O000OO00 = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.O000OO0o;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }
}
