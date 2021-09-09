package com.xiaomi.smarthome.library.common.widget;

import _m_j.aq;
import _m_j.ar;
import _m_j.cb;
import _m_j.cc;
import _m_j.gqu;
import _m_j.gsy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
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
import java.util.ArrayList;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    private static final Comparator<O00000Oo> O00000Oo = new Comparator<O00000Oo>() {
        /* class com.xiaomi.smarthome.library.common.widget.ViewPager.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((O00000Oo) obj).O00000Oo - ((O00000Oo) obj2).O00000Oo;
        }
    };
    private static final Interpolator O00000o0 = new Interpolator() {
        /* class com.xiaomi.smarthome.library.common.widget.ViewPager.AnonymousClass2 */

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f9284O000000o = true;
    private final ArrayList<O00000Oo> O00000o = new ArrayList<>();
    private gqu O00000oO;
    private int O00000oo;
    private int O0000O0o = -1;
    private Parcelable O0000OOo = null;
    private Scroller O0000Oo;
    private ClassLoader O0000Oo0 = null;
    private gqu.O000000o O0000OoO;
    private int O0000Ooo;
    private boolean O0000o;
    private int O0000o0;
    private Drawable O0000o00;
    private int O0000o0O;
    private boolean O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private int O0000oOO = 0;
    private boolean O0000oOo;
    private int O0000oo;
    private boolean O0000oo0;
    private float O0000ooO;
    private float O0000ooo;
    private VelocityTracker O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private boolean O000O0o;
    private float O000O0o0;
    private EdgeEffectCompat O000O0oO;
    private EdgeEffectCompat O000O0oo;
    private int O000OO = 0;
    private boolean O000OO00 = true;
    private O00000o0 O000OO0o;
    private boolean O000OOOo = true;
    private float O00oOoOo;
    private float O00oOooO;
    private int O00oOooo = -1;

    public interface O00000o0 {
        void b_(int i);

        void c_(int i);
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        Object f9286O000000o;
        int O00000Oo;
        boolean O00000o0;

        O00000Oo() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        O000000o();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    private void O000000o() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.O0000Oo = new Scroller(context, O00000o0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O0000oo = cc.O000000o(viewConfiguration);
        this.O000O0OO = viewConfiguration.getScaledMinimumFlingVelocity();
        this.O000O0Oo = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O000O0oO = new EdgeEffectCompat(context);
        this.O000O0oo = new EdgeEffectCompat(context);
        this.O00oOoOo = context.getResources().getDisplayMetrics().density * 2500.0f;
        this.O000O0o0 = 0.8f;
    }

    private void setScrollState(int i) {
        if (this.O000OO != i) {
            this.O000OO = i;
            O00000o0 o00000o0 = this.O000OO0o;
            if (o00000o0 != null) {
                o00000o0.b_(i);
            }
        }
    }

    public void setAdapter(gqu gqu) {
        gqu gqu2 = this.O00000oO;
        if (gqu2 != null) {
            gqu2.O00000o0 = null;
            for (int i = 0; i < this.O00000o.size(); i++) {
                this.O00000oO.O000000o(this.O00000o.get(i).f9286O000000o);
            }
            this.O00000oO.O00000Oo();
            this.O00000o.clear();
            removeAllViews();
            this.O00000oo = 0;
            scrollTo(0, 0);
        }
        this.O00000oO = gqu;
        if (this.O00000oO != null) {
            if (this.O0000OoO == null) {
                this.O0000OoO = new O000000o(this, (byte) 0);
            }
            this.O00000oO.O00000o0 = this.O0000OoO;
            this.O0000oO0 = false;
            int i2 = this.O0000O0o;
            if (i2 >= 0) {
                O000000o(i2, false, true);
                this.O0000O0o = -1;
                this.O0000OOo = null;
                this.O0000Oo0 = null;
                return;
            }
            O00000Oo();
        }
    }

    public gqu getAdapter() {
        return this.O00000oO;
    }

    public void setCurrentItem(int i) {
        this.O0000oO0 = false;
        O000000o(i, !this.O000OO00, false);
    }

    public final void O000000o(int i, boolean z) {
        this.O0000oO0 = false;
        O000000o(i, z, false);
    }

    public int getCurrentItem() {
        return this.O00000oo;
    }

    private void O000000o(int i, boolean z, boolean z2) {
        O000000o(i, z, z2, 0);
    }

    private void O000000o(int i, boolean z, boolean z2, int i2) {
        O00000o0 o00000o0;
        O00000o0 o00000o02;
        gqu gqu = this.O00000oO;
        if (gqu == null || gqu.O000000o() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.O00000oo != i || this.O00000o.size() == 0) {
            boolean z3 = true;
            if (i < 0) {
                i = 0;
            } else if (i >= this.O00000oO.O000000o()) {
                i = this.O00000oO.O000000o() - 1;
            }
            int i3 = this.O0000oOO;
            int i4 = this.O00000oo;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.O00000o.size(); i5++) {
                    this.O00000o.get(i5).O00000o0 = true;
                }
            }
            if (this.O00000oo == i) {
                z3 = false;
            }
            this.O00000oo = i;
            O00000Oo();
            int width = (getWidth() + this.O0000Ooo) * i;
            if (z) {
                O000000o(width, i2);
                if (z3 && (o00000o02 = this.O000OO0o) != null) {
                    o00000o02.c_(i);
                    return;
                }
                return;
            }
            if (z3 && (o00000o0 = this.O000OO0o) != null) {
                o00000o0.c_(i);
            }
            O00000o0();
            scrollTo(width, 0);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setOnPageChangeListener(O00000o0 o00000o0) {
        this.O000OO0o = o00000o0;
    }

    public int getOffscreenPageLimit() {
        return this.O0000oOO;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 0) {
            gsy.O000000o(5, "ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 0");
            i = 0;
        }
        if (i != this.O0000oOO) {
            this.O0000oOO = i;
            O00000Oo();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.O0000Ooo;
        this.O0000Ooo = i;
        int width = getWidth();
        O000000o(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.O0000Ooo;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.O0000o00 = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.O0000o00;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.O0000o00;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private void O000000o(int i, int i2) {
        int i3;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = 0 - scrollY;
        if (i4 == 0 && i5 == 0) {
            O00000o0();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        this.O0000oO = true;
        setScrollState(2);
        double abs = (double) ((((float) Math.abs(i4)) / ((float) (getWidth() + this.O0000Ooo))) * 100.0f);
        Double.isNaN(abs);
        int i6 = (int) (abs * 2.0d);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            float f = (float) i6;
            i3 = (int) (f + ((f / (((float) abs2) / this.O00oOoOo)) * this.O000O0o0));
        } else {
            i3 = i6 + 350;
        }
        this.O0000Oo.startScroll(scrollX, scrollY, i4, i5, Math.min(i3, 600));
        invalidate();
    }

    private void O00000Oo(int i, int i2) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.O00000Oo = i;
        o00000Oo.f9286O000000o = this.O00000oO.O000000o(this, i);
        if (i2 < 0) {
            this.O00000o.add(o00000Oo);
        } else {
            this.O00000o.add(i2, o00000Oo);
        }
    }

    private void O00000Oo() {
        int i;
        O00000Oo o00000Oo;
        O00000Oo o00000Oo2;
        if (this.O00000oO != null && !this.O0000oO0 && getWindowToken() != null) {
            int i2 = this.O0000oOO;
            int i3 = 0;
            int max = Math.max(0, this.O00000oo - i2);
            int min = Math.min(this.O00000oO.O000000o() - 1, this.O00000oo + i2);
            int i4 = 0;
            int i5 = -1;
            while (i4 < this.O00000o.size()) {
                O00000Oo o00000Oo3 = this.O00000o.get(i4);
                if ((o00000Oo3.O00000Oo < max || o00000Oo3.O00000Oo > min) && !o00000Oo3.O00000o0) {
                    this.O00000o.remove(i4);
                    i4--;
                    this.O00000oO.O000000o(o00000Oo3.f9286O000000o);
                } else if (i5 < min && o00000Oo3.O00000Oo > max) {
                    int i6 = i5 + 1;
                    if (i6 < max) {
                        i6 = max;
                    }
                    while (i6 <= min && i6 < o00000Oo3.O00000Oo) {
                        O00000Oo(i6, i4);
                        i6++;
                        i4++;
                    }
                }
                i5 = o00000Oo3.O00000Oo;
                i4++;
            }
            if (this.O00000o.size() > 0) {
                ArrayList<O00000Oo> arrayList = this.O00000o;
                i = arrayList.get(arrayList.size() - 1).O00000Oo;
            } else {
                i = -1;
            }
            if (i < min) {
                int i7 = i + 1;
                if (i7 > max) {
                    max = i7;
                }
                while (max <= min) {
                    O00000Oo(max, -1);
                    max++;
                }
            }
            int i8 = 0;
            while (true) {
                o00000Oo = null;
                if (i8 >= this.O00000o.size()) {
                    o00000Oo2 = null;
                    break;
                } else if (this.O00000o.get(i8).O00000Oo == this.O00000oo) {
                    o00000Oo2 = this.O00000o.get(i8);
                    break;
                } else {
                    i8++;
                }
            }
            this.O00000oO.O00000Oo(o00000Oo2 != null ? o00000Oo2.f9286O000000o : null);
            this.O00000oO.O00000Oo();
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    o00000Oo = O00000Oo(findFocus);
                }
                if (o00000Oo == null || o00000Oo.O00000Oo != this.O00000oo) {
                    while (i3 < getChildCount()) {
                        View childAt = getChildAt(i3);
                        O00000Oo O000000o2 = O000000o(childAt);
                        if (O000000o2 == null || O000000o2.O00000Oo != this.O00000oo || !childAt.requestFocus(2)) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = aq.O000000o(new ar<SavedState>() {
            /* class com.xiaomi.smarthome.library.common.widget.ViewPager.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        });

        /* renamed from: O000000o  reason: collision with root package name */
        int f9287O000000o;
        Parcelable O00000Oo;
        ClassLoader O00000o0;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9287O000000o);
            parcel.writeParcelable(this.O00000Oo, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f9287O000000o + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f9287O000000o = parcel.readInt();
            this.O00000Oo = parcel.readParcelable(classLoader);
            this.O00000o0 = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f9287O000000o = this.O00000oo;
        if (this.O00000oO != null) {
            savedState.O00000Oo = null;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.O00000oO != null) {
            O000000o(savedState.f9287O000000o, false, true);
            return;
        }
        this.O0000O0o = savedState.f9287O000000o;
        this.O0000OOo = savedState.O00000Oo;
        this.O0000Oo0 = savedState.O00000o0;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.O0000o0o) {
            addViewInLayout(view, i, layoutParams);
            view.measure(this.O0000o0, this.O0000o0O);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private O00000Oo O000000o(View view) {
        for (int i = 0; i < this.O00000o.size(); i++) {
            O00000Oo o00000Oo = this.O00000o.get(i);
            if (this.O00000oO.O000000o(view, o00000Oo.f9286O000000o)) {
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

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O000OO00 = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        this.O0000o0 = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        this.O0000o0O = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        this.O0000o0o = true;
        O00000Oo();
        this.O0000o0o = false;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                childAt.measure(this.O0000o0, this.O0000o0O);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.O0000Ooo;
            O000000o(i, i3, i5, i5);
        }
    }

    private void O000000o(int i, int i2, int i3, int i4) {
        int i5 = i + i3;
        if (i2 > 0) {
            int scrollX = getScrollX();
            int i6 = i2 + i4;
            int i7 = scrollX / i6;
            int i8 = (int) ((((float) i7) + (((float) (scrollX % i6)) / ((float) i6))) * ((float) i5));
            scrollTo(i8, getScrollY());
            if (!this.O0000Oo.isFinished()) {
                this.O0000Oo.startScroll(i8, 0, this.O00000oo * i5, 0, this.O0000Oo.getDuration() - this.O0000Oo.timePassed());
                return;
            }
            return;
        }
        int i9 = this.O00000oo * i5;
        if (i9 != getScrollX()) {
            O00000o0();
            scrollTo(i9, getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        O00000Oo O000000o2;
        this.O0000o0o = true;
        O00000Oo();
        this.O0000o0o = false;
        int childCount = getChildCount();
        int i5 = i3 - i;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (!(childAt.getVisibility() == 8 || (O000000o2 = O000000o(childAt)) == null)) {
                int paddingLeft = getPaddingLeft() + ((this.O0000Ooo + i5) * O000000o2.O00000Oo);
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            }
        }
        this.O000OO00 = false;
    }

    public void computeScroll() {
        if (this.O0000Oo.isFinished() || !this.O0000Oo.computeScrollOffset()) {
            O00000o0();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.O0000Oo.getCurrX();
        int currY = this.O0000Oo.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
        }
        if (this.O000OO0o != null) {
            getWidth();
        }
        invalidate();
    }

    private void O00000o0() {
        boolean z = this.O0000oO;
        if (z) {
            setScrollingCacheEnabled(false);
            this.O0000Oo.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.O0000Oo.getCurrX();
            int currY = this.O0000Oo.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            setScrollState(0);
        }
        this.O0000oO0 = false;
        this.O0000oO = false;
        boolean z2 = z;
        for (int i = 0; i < this.O00000o.size(); i++) {
            O00000Oo o00000Oo = this.O00000o.get(i);
            if (o00000Oo.O00000o0) {
                o00000Oo.O00000o0 = false;
                z2 = true;
            }
        }
        if (z2) {
            O00000Oo();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        gqu gqu;
        if (!this.f9284O000000o) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.O0000oOo = false;
            this.O0000oo0 = false;
            this.O00oOooo = -1;
            return false;
        }
        if (action != 0) {
            if (this.O0000oOo) {
                return true;
            }
            if (this.O0000oo0) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.O0000ooO = x;
            this.O0000ooo = x;
            this.O00oOooO = motionEvent.getY();
            this.O00oOooo = motionEvent.getPointerId(0);
            if (this.O000OO == 2) {
                this.O0000oOo = true;
                this.O0000oo0 = false;
                setScrollState(1);
            } else {
                O00000o0();
                this.O0000oOo = false;
                this.O0000oo0 = false;
            }
        } else if (action == 2) {
            int i = this.O00oOooo;
            if (i != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(findPointerIndex);
                float f = x2 - this.O0000ooo;
                float abs = Math.abs(f);
                float y = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y - this.O00oOooO);
                int scrollX = getScrollX();
                if ((f <= 0.0f || scrollX != 0) && f < 0.0f && (gqu = this.O00000oO) != null) {
                    gqu.O000000o();
                    getWidth();
                }
                if (O000000o(this, false, (int) f, (int) x2, (int) y)) {
                    this.O0000ooo = x2;
                    this.O0000ooO = x2;
                    this.O00oOooO = y;
                    return false;
                } else if (abs > ((float) this.O0000oo) && abs > abs2) {
                    this.O0000oOo = true;
                    setScrollState(1);
                    this.O0000ooo = x2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.O0000oo)) {
                    this.O0000oo0 = true;
                }
            }
        } else if (action == 6) {
            O000000o(motionEvent);
        }
        return this.O0000oOo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean, boolean, int):void
     arg types: [int, int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, int, int, int):void
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean, boolean, int):void */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        gqu gqu;
        boolean O000000o2;
        boolean O000000o3;
        if (!this.f9284O000000o) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.O000O0o || !this.O000OOOo) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (gqu = this.O00000oO) == null || gqu.O000000o() == 0) {
            return false;
        }
        if (this.O000O00o == null) {
            this.O000O00o = VelocityTracker.obtain();
        }
        this.O000O00o.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.O0000oOo) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.O00oOooo);
                        float x = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x - this.O0000ooo);
                        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.O00oOooO);
                        if (abs > ((float) this.O0000oo) && abs > abs2) {
                            this.O0000oOo = true;
                            this.O0000ooo = x;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                        }
                    }
                    if (this.O0000oOo) {
                        float x2 = motionEvent.getX(motionEvent.findPointerIndex(this.O00oOooo));
                        float f = this.O0000ooo - x2;
                        this.O0000ooo = x2;
                        float scrollX = ((float) getScrollX()) + f;
                        int width = getWidth();
                        int i = this.O0000Ooo + width;
                        int O000000o4 = this.O00000oO.O000000o() - 1;
                        float max = (float) Math.max(0, (this.O00000oo - 1) * i);
                        float min = (float) (Math.min(this.O00000oo + 1, O000000o4) * i);
                        if (scrollX < max) {
                            if (max == 0.0f) {
                                z = this.O000O0oO.O000000o((-scrollX) / ((float) width));
                            }
                            scrollX = max;
                        } else if (scrollX > min) {
                            if (min == ((float) (O000000o4 * i))) {
                                z = this.O000O0oo.O000000o((scrollX - min) / ((float) width));
                            }
                            scrollX = min;
                        }
                        int i2 = (int) scrollX;
                        this.O0000ooo += scrollX - ((float) i2);
                        scrollTo(i2, getScrollY());
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.O0000ooo = motionEvent.getX(actionIndex);
                        this.O00oOooo = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        O000000o(motionEvent);
                        this.O0000ooo = motionEvent.getX(motionEvent.findPointerIndex(this.O00oOooo));
                    }
                } else if (this.O0000oOo) {
                    O000000o(this.O00000oo, true, true);
                    this.O00oOooo = -1;
                    O00000o();
                    O000000o2 = this.O000O0oO.O000000o();
                    O000000o3 = this.O000O0oo.O000000o();
                }
            } else if (this.O0000oOo) {
                VelocityTracker velocityTracker = this.O000O00o;
                velocityTracker.computeCurrentVelocity(1000, (float) this.O000O0Oo);
                int xVelocity = (int) velocityTracker.getXVelocity(this.O00oOooo);
                this.O0000oO0 = true;
                int scrollX2 = getScrollX() / (getWidth() + this.O0000Ooo);
                if (xVelocity <= 0) {
                    scrollX2++;
                }
                O000000o(scrollX2, true, true, xVelocity);
                this.O00oOooo = -1;
                O00000o();
                O000000o2 = this.O000O0oO.O000000o();
                O000000o3 = this.O000O0oo.O000000o();
            }
            z = O000000o2 | O000000o3;
        } else {
            O00000o0();
            float x3 = motionEvent.getX();
            this.O0000ooO = x3;
            this.O0000ooo = x3;
            this.O00oOooo = motionEvent.getPointerId(0);
        }
        if (z) {
            invalidate();
        }
        return true;
    }

    public void draw(Canvas canvas) {
        gqu gqu;
        try {
            super.draw(canvas);
        } catch (Exception unused) {
        }
        int O000000o2 = cb.O000000o((View) this);
        boolean z = false;
        int i = 1;
        if (O000000o2 == 0 || (O000000o2 == 1 && (gqu = this.O00000oO) != null && gqu.O000000o() > 1)) {
            if (!this.O000O0oO.f2846O000000o.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), 0.0f);
                this.O000O0oO.O000000o(height, getWidth());
                z = false | this.O000O0oO.O000000o(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.O000O0oo.f2846O000000o.isFinished()) {
                int save2 = canvas.save();
                int width = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                gqu gqu2 = this.O00000oO;
                if (gqu2 != null) {
                    i = gqu2.O000000o();
                }
                canvas.rotate(90.0f);
                int i2 = this.O0000Ooo;
                canvas.translate((float) (-getPaddingTop()), (float) (((-i) * (width + i2)) + i2));
                this.O000O0oo.O000000o(height2, width);
                z |= this.O000O0oo.O000000o(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.O000O0oO.f2846O000000o.finish();
            this.O000O0oo.f2846O000000o.finish();
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
        }
        if (this.O0000Ooo > 0 && this.O0000o00 != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int i = this.O0000Ooo;
            int i2 = scrollX % (width + i);
            if (i2 != 0) {
                int i3 = (scrollX - i2) + width;
                this.O0000o00.setBounds(i3, 0, i + i3, getHeight());
                this.O0000o00.draw(canvas);
            }
        }
    }

    public void setPagingEnabled(boolean z) {
        this.O000OOOo = z;
    }

    private void O00000o() {
        this.O0000oOo = false;
        this.O0000oo0 = false;
        VelocityTracker velocityTracker = this.O000O00o;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O000O00o = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.O0000o != z) {
            this.O0000o = z;
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
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom()) {
                    if (O000000o(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !cb.O000000o(view, -i)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[RETURN] */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 21) {
                    z = O000000o(17);
                } else if (keyCode == 22) {
                    z = O000000o(66);
                } else if (keyCode == 61) {
                    if (keyEvent.hasNoModifiers()) {
                        z = O000000o(2);
                    } else if (keyEvent.hasModifiers(1)) {
                        z = O000000o(1);
                    }
                }
                return !z;
            }
            z = false;
            if (!z) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        if (r6 != 2) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    private boolean O000000o(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        boolean z = false;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus != null && findNextFocus != findFocus) {
            if (i == 17) {
                z = (findFocus == null || findNextFocus.getLeft() < findFocus.getLeft()) ? findNextFocus.requestFocus() : O00000oO();
            } else if (i == 66) {
                if (findFocus == null || findNextFocus.getLeft() > findFocus.getLeft()) {
                    z = findNextFocus.requestFocus();
                }
            }
            if (z) {
            }
            return z;
        } else if (i == 17 || i == 1) {
            z = O00000oO();
            if (z) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z;
        } else if (i != 66) {
        }
        z = O00000oo();
        if (z) {
        }
        return z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, int):void
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void */
    private boolean O00000oO() {
        int i = this.O00000oo;
        if (i <= 0) {
            return false;
        }
        O000000o(i - 1, true);
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, int):void
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void */
    private boolean O00000oo() {
        gqu gqu = this.O00000oO;
        if (gqu == null || this.O00000oo >= gqu.O000000o() - 1) {
            return false;
        }
        O000000o(this.O00000oo + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        O00000Oo O000000o2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000oo) {
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
            if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000oo) {
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
            if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000oo && childAt.requestFocus(i, rect)) {
                return true;
            }
            i3 += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        O00000Oo O000000o2;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (O000000o2 = O000000o(childAt)) != null && O000000o2.O00000Oo == this.O00000oo && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    class O000000o implements gqu.O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(ViewPager viewPager, byte b) {
            this();
        }
    }

    private void O000000o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O00oOooo) {
            int i = actionIndex == 0 ? 1 : 0;
            this.O0000ooo = motionEvent.getX(i);
            this.O00oOooo = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.O000O00o;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }
}
