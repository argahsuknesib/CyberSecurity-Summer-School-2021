package _m_j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.scroll.FpsListener;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.scroll.VelocityHelper;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;

public final class gdm extends ScrollView implements View.OnLayoutChangeListener, ViewGroup.OnHierarchyChangeListener, ReactClippingViewGroup {
    private static boolean O0000Oo = false;
    private static Field O0000OoO;

    /* renamed from: O000000o  reason: collision with root package name */
    public final ReactViewBackgroundManager f17562O000000o;
    public boolean O00000Oo;
    FpsListener O00000o;
    String O00000o0;
    public boolean O00000oO;
    public int O00000oo = 0;
    public boolean O0000O0o = false;
    public Runnable O0000OOo;
    public float O0000Oo0 = 0.2f;
    private final OnScrollDispatchHelper O0000Ooo = new OnScrollDispatchHelper();
    private String O0000o = "hidden";
    private final VelocityHelper O0000o0 = new VelocityHelper();
    private final OverScroller O0000o00;
    private final Rect O0000o0O = new Rect();
    private Rect O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private boolean O0000oOO = true;
    private Drawable O0000oOo;
    private float O0000oo = 0.985f;
    private int O0000oo0 = 0;
    private View O0000ooO;
    private gdn O0000ooo;
    private float O000O00o;
    private boolean O000O0OO;
    private ValueAnimator O000O0Oo;
    private int O00oOooO = 0;
    private int O00oOooo = 250;

    public gdm(ReactContext reactContext, FpsListener fpsListener) {
        super(reactContext);
        this.O00000o = fpsListener;
        this.f17562O000000o = new ReactViewBackgroundManager(this);
        this.O0000o00 = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
    }

    private OverScroller getOverScrollerFromParent() {
        if (!O0000Oo) {
            O0000Oo = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                O0000OoO = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                gsy.O000000o(5, "ReactNative", "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = O0000OoO;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            gsy.O000000o(5, "ReactNative", "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from ScrollView!", e);
        }
    }

    public final void setSendMomentumEvents(boolean z) {
        this.O00000Oo = z;
    }

    public final void setScrollPerfTag(String str) {
        this.O00000o0 = str;
    }

    public final void setScrollEnabled(boolean z) {
        this.O0000oOO = z;
    }

    public final void setPagingEnabled(boolean z) {
        this.O00000oO = z;
    }

    public final void setDecelerationRate(float f) {
        this.O0000oo = f;
        OverScroller overScroller = this.O0000o00;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - this.O0000oo);
        }
    }

    public final void setScrollListener(gdn gdn) {
        this.O0000ooo = gdn;
    }

    public final void O000000o() {
        awakenScrollBars();
    }

    public final void setOverflow(String str) {
        this.O0000o = str;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY());
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.O0000oO) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.O0000oO) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        gdn gdn = this.O0000ooo;
        if (gdn != null) {
            gdn.O000000o(Math.min(i2, getSnapHeight()));
        }
        if (this.O0000Ooo.onScrollChanged(i, i2)) {
            if (this.O0000oO) {
                updateClippingRect();
            }
            ReactScrollViewHelper.emitScrollEvent(this, this.O0000Ooo.getXFlingVelocity(), this.O0000Ooo.getYFlingVelocity());
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O0000oOO && !this.O0000O0o) {
            if ((motionEvent.getAction() & 255) == 0) {
                this.O00000oo = 0;
                this.O000O00o = motionEvent.getY();
            }
            try {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                    ReactScrollViewHelper.emitScrollBeginDragEvent(this);
                    this.O0000oO0 = true;
                    return true;
                }
            } catch (IllegalArgumentException e) {
                Log.w("ReactNative", "Error intercepting touch event.", e);
            }
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.O0000oOO || this.O0000O0o) {
            return false;
        }
        this.O0000o0.calculateVelocity(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.O00000oo = 0;
            this.O000O00o = motionEvent.getY();
        } else if (action == 1 && this.O0000oO0) {
            float xVelocity = this.O0000o0.getXVelocity();
            float yVelocity = this.O0000o0.getYVelocity();
            ReactScrollViewHelper.emitScrollEndDragEvent(this, xVelocity, yVelocity);
            this.O0000oO0 = false;
            if (motionEvent.getY() - this.O000O00o < 0.0f) {
                z = true;
            }
            this.O000O0OO = z;
            Runnable runnable = this.O0000OOo;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.O0000OOo = null;
            }
            O000000o(Math.round(xVelocity), Math.round(yVelocity));
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void O000000o(int i) {
        int scrollY = getScrollY();
        ValueAnimator valueAnimator = this.O000O0Oo;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.O000O0Oo.cancel();
            }
            this.O000O0Oo.removeAllUpdateListeners();
            this.O000O0Oo.removeAllListeners();
        }
        this.O000O0Oo = ValueAnimator.ofInt(scrollY, i).setDuration((long) this.O00oOooo);
        this.O000O0Oo.setInterpolator(new gdl());
        this.O000O0Oo.addListener(new AnimatorListenerAdapter() {
            /* class _m_j.gdm.AnonymousClass1 */

            public final void onAnimationCancel(Animator animator) {
                gdm.this.O0000O0o = false;
            }

            public final void onAnimationEnd(Animator animator) {
                gdm.this.O0000O0o = false;
            }

            public final void onAnimationStart(Animator animator) {
                gdm.this.O0000O0o = true;
            }
        });
        this.O000O0Oo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class _m_j.$$Lambda$gdm$bI9YTzkEjaycBUg1KgadwIX2D8 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                gdm.this.O000000o(valueAnimator);
            }
        });
        this.O000O0Oo.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ValueAnimator valueAnimator) {
        scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void O000000o(int i, int i2) {
        if ((this.O00000Oo || this.O00000oO) && this.O0000OOo == null) {
            if (this.O00000Oo) {
                O00000o0();
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i, i2);
            }
            this.O0000OOo = new Runnable() {
                /* class _m_j.gdm.AnonymousClass2 */
                private boolean O00000Oo = false;

                public final void run() {
                    int scrollY = gdm.this.getScrollY();
                    if (gdm.this.O00000oo != scrollY) {
                        gdm gdm = gdm.this;
                        gdm.O00000oo = scrollY;
                        cb.O000000o(gdm, this, 20);
                    } else if (!gdm.this.O00000oO || this.O00000Oo) {
                        if (gdm.this.O00000Oo) {
                            ReactScrollViewHelper.emitScrollMomentumEndEvent(gdm.this);
                        }
                        gdm gdm2 = gdm.this;
                        gdm2.O0000OOo = null;
                        if (gdm2.O00000Oo()) {
                            Assertions.assertNotNull(gdm2.O00000o);
                            Assertions.assertNotNull(gdm2.O00000o0);
                            gdm2.O00000o.disable(gdm2.O00000o0);
                        }
                    } else {
                        this.O00000Oo = true;
                        gdm.this.O00000Oo(0);
                        cb.O000000o(gdm.this, this, 20);
                    }
                }
            };
            cb.O000000o(this, this.O0000OOo, 20);
        }
    }

    public final void fling(int i) {
        int abs = (int) (((float) Math.abs(i)) * Math.signum(this.O0000Ooo.getYFlingVelocity()));
        if (this.O00000oO) {
            O00000Oo(abs);
        } else if (this.O0000o00 != null) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.O0000o00.fling(getScrollX(), getScrollY(), 0, abs, 0, 0, 0, Integer.MAX_VALUE, 0, height / 2);
            cb.O00000oo(this);
        } else {
            super.fling(abs);
        }
        O000000o(0, abs);
    }

    public final void O00000Oo(int i) {
        int i2;
        if (getChildCount() > 0) {
            int snapHeight = getSnapHeight();
            int O00000o02 = O00000o0(i);
            float f = this.O0000Oo0;
            float f2 = (float) snapHeight;
            int i3 = (int) (f * f2);
            int i4 = (int) ((1.0f - f) * f2);
            int min = Math.min(Math.max(0, O00000o02), getMaxScrollY());
            int i5 = (getScrollY() >= snapHeight ? min >= snapHeight : min <= snapHeight) ? min : snapHeight;
            if ((i5 >= i4 && i5 < snapHeight) || (i5 > i3 && i5 < i4 && this.O000O0OO)) {
                O000000o(snapHeight);
            } else if ((i5 <= 0 || i5 > i3) && (i5 <= i3 || i5 >= i4 || this.O000O0OO)) {
                OverScroller overScroller = this.O0000o00;
                if (overScroller != null) {
                    int scrollX = getScrollX();
                    int scrollY = getScrollY();
                    if (i != 0) {
                        i2 = i;
                    } else {
                        i2 = i5 - getScrollY();
                    }
                    overScroller.fling(scrollX, scrollY, 0, i2, 0, 0, i5, i5, 0, 0);
                    postInvalidateOnAnimation();
                    return;
                }
                smoothScrollTo(getScrollX(), i5);
            } else {
                O000000o(0);
            }
        }
    }

    private int O00000o0(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.O0000oo);
        int maxScrollY = getMaxScrollY();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2;
        overScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, maxScrollY, 0, height);
        return overScroller.getFinalY();
    }

    private void O00000o0() {
        if (O00000Oo()) {
            Assertions.assertNotNull(this.O00000o);
            Assertions.assertNotNull(this.O00000o0);
            this.O00000o.enable(this.O00000o0);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo() {
        String str;
        return (this.O00000o == null || (str = this.O00000o0) == null || str.isEmpty()) ? false : true;
    }

    public final void setRemoveClippedSubviews(boolean z) {
        if (z && this.O0000o0o == null) {
            this.O0000o0o = new Rect();
        }
        this.O0000oO = z;
        updateClippingRect();
    }

    public final boolean getRemoveClippedSubviews() {
        return this.O0000oO;
    }

    public final void updateClippingRect() {
        if (this.O0000oO) {
            Assertions.assertNotNull(this.O0000o0o);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.O0000o0o);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).updateClippingRect();
            }
        }
    }

    public final void getClippingRect(Rect rect) {
        rect.set((Rect) Assertions.assertNotNull(this.O0000o0o));
    }

    public final int getMaxScrollY() {
        return Math.max(0, this.O0000ooO.getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    public final void draw(Canvas canvas) {
        char c = 0;
        if (this.O0000oo0 != 0) {
            View childAt = getChildAt(0);
            if (!(this.O0000oOo == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.O0000oOo.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.O0000oOo.draw(canvas);
            }
        }
        getDrawingRect(this.O0000o0O);
        String str = this.O0000o;
        if (str.hashCode() != 466743410 || !str.equals("visible")) {
            c = 65535;
        }
        if (c != 0) {
            canvas.clipRect(this.O0000o0O);
        }
        super.draw(canvas);
    }

    public final void setEndFillColor(int i) {
        if (i != this.O0000oo0) {
            this.O0000oo0 = i;
            this.O0000oOo = new ColorDrawable(this.O0000oo0);
        }
    }

    /* access modifiers changed from: protected */
    public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        int maxScrollY;
        OverScroller overScroller = this.O0000o00;
        if (overScroller != null && !overScroller.isFinished() && this.O0000o00.getCurrY() != this.O0000o00.getFinalY() && i2 >= (maxScrollY = getMaxScrollY())) {
            this.O0000o00.abortAnimation();
            i2 = maxScrollY;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    public final void onChildViewAdded(View view, View view2) {
        this.O0000ooO = view2;
        this.O0000ooO.addOnLayoutChangeListener(this);
    }

    public final void onChildViewRemoved(View view, View view2) {
        this.O0000ooO.removeOnLayoutChangeListener(this);
        this.O0000ooO = null;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int maxScrollY;
        if (this.O0000ooO != null && getScrollY() > (maxScrollY = getMaxScrollY())) {
            scrollTo(getScrollX(), maxScrollY);
        }
    }

    public final int getSnapHeight() {
        if (this.O00oOooO != 0 || getChildCount() <= 0) {
            return this.O00oOooO;
        }
        return getChildAt(0).getHeight();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void setOffsetPercent(float f) {
        this.O0000Oo0 = Math.min(Math.max(f, 0.0f), 0.5f);
    }

    public final void setSnapHeight(int i) {
        this.O00oOooO = i;
    }

    public final void setScrollYDuration(int i) {
        this.O00oOooo = i;
    }

    public final void setBackgroundColor(int i) {
        this.f17562O000000o.setBackgroundColor(i);
    }

    public final void setBorderRadius(float f) {
        this.f17562O000000o.setBorderRadius(f);
    }

    public final void setBorderStyle(String str) {
        this.f17562O000000o.setBorderStyle(str);
    }
}
