package androidx.core.widget;

import _m_j.bh;
import _m_j.bq;
import _m_j.br;
import _m_j.bu;
import _m_j.bv;
import _m_j.bz;
import _m_j.cb;
import _m_j.cl;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements bq, bu, bz {
    private static final O000000o O0000oo = new O000000o();
    private static final int[] O0000ooO = {16843130};

    /* renamed from: O000000o  reason: collision with root package name */
    private long f2847O000000o;
    private final Rect O00000Oo;
    private EdgeEffect O00000o;
    private OverScroller O00000o0;
    private EdgeEffect O00000oO;
    private int O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private boolean O0000Oo;
    private View O0000Oo0;
    private VelocityTracker O0000OoO;
    private boolean O0000Ooo;
    private int O0000o;
    private int O0000o0;
    private boolean O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private final int[] O0000oO;
    private final int[] O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private SavedState O0000oo0;
    private final bv O0000ooo;
    private O00000Oo O000O00o;
    private final br O00oOooO;
    private float O00oOooo;

    public interface O00000Oo {
        void O000000o(NestedScrollView nestedScrollView);
    }

    private static int O00000Oo(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = new Rect();
        this.O0000O0o = true;
        this.O0000OOo = false;
        this.O0000Oo0 = null;
        this.O0000Oo = false;
        this.O0000o00 = true;
        this.O0000o = -1;
        this.O0000oO0 = new int[2];
        this.O0000oO = new int[2];
        this.O00000o0 = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.O0000o0 = viewConfiguration.getScaledTouchSlop();
        this.O0000o0O = viewConfiguration.getScaledMinimumFlingVelocity();
        this.O0000o0o = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O0000ooO, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.O0000ooo = new bv();
        this.O00oOooO = new br(this);
        setNestedScrollingEnabled(true);
        cb.O000000o(this, O0000oo);
    }

    private void O000000o(int i, int i2, int[] iArr, int i3, int[] iArr2) {
        this.O00oOooO.O000000o(0, i, 0, i2, iArr, i3, iArr2);
    }

    private boolean O000000o(int i, int i2) {
        return this.O00oOooO.O000000o(i, i2);
    }

    private void O00000o0(int i) {
        this.O00oOooO.O00000Oo(i);
    }

    private boolean O00000o(int i) {
        return this.O00oOooO.O000000o(i);
    }

    private boolean O000000o(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.O00oOooO.O000000o(i, i2, iArr, iArr2, i3);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.O00oOooO.O000000o(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.O00oOooO.f13211O000000o;
    }

    public boolean startNestedScroll(int i) {
        return O000000o(i, 0);
    }

    public void stopNestedScroll() {
        O00000o0(0);
    }

    public boolean hasNestedScrollingParent() {
        return O00000o(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.O00oOooO.O000000o(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return O000000o(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.O00oOooO.O000000o(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.O00oOooO.O000000o(f, f2);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        O000000o(i4, i5, iArr);
    }

    private void O000000o(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.O00oOooO.O000000o(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.O0000ooo.O000000o(i, i2);
        O000000o(2, i2);
    }

    public void onStopNestedScroll(View view, int i) {
        this.O0000ooo.O000000o(i);
        O00000o0(i);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        O000000o(i4, i5, (int[]) null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        O000000o(i, i2, iArr, (int[]) null, i3);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        O000000o(i4, 0, (int[]) null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        O00000Oo((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.O0000ooo.O000000o();
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(O00000Oo o00000Oo) {
        this.O000O00o = o00000Oo;
    }

    private boolean O000000o() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.O0000Ooo) {
            this.O0000Ooo = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.O0000o00 = z;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        O00000Oo o00000Oo = this.O000O00o;
        if (o00000Oo != null) {
            o00000Oo.O000000o(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.O0000Ooo && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || O000000o(keyEvent);
    }

    public final boolean O000000o(KeyEvent keyEvent) {
        this.O00000Oo.setEmpty();
        int i = 130;
        if (!O000000o()) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View findFocus = findFocus();
                if (findFocus == this) {
                    findFocus = null;
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
                if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                    return false;
                }
                return true;
            }
            return false;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i = 33;
                    }
                    O00000oO(i);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return O0000O0o(130);
                } else {
                    return O00000oo(130);
                }
            } else if (!keyEvent.isAltPressed()) {
                return O0000O0o(33);
            } else {
                return O00000oo(33);
            }
        }
    }

    private void O00000Oo() {
        if (this.O0000OoO == null) {
            this.O0000OoO = VelocityTracker.obtain();
        }
    }

    private void O00000o0() {
        VelocityTracker velocityTracker = this.O0000OoO;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O0000OoO = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            O00000o0();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db  */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        if (action == 2 && this.O0000Oo) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.O0000o;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.O00000oo) > this.O0000o0 && (2 & getNestedScrollAxes()) == 0) {
                                this.O0000Oo = true;
                                this.O00000oo = y;
                                O00000Oo();
                                this.O0000OoO.addMovement(motionEvent);
                                this.O0000oOO = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        O000000o(motionEvent);
                    }
                }
            }
            this.O0000Oo = false;
            this.O0000o = -1;
            O00000o0();
            if (this.O00000o0.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                cb.O00000oo(this);
            }
            O00000o0(0);
        } else {
            int y2 = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y2 >= childAt.getTop() - scrollY && y2 < childAt.getBottom() - scrollY && x >= childAt.getLeft() && x < childAt.getRight()) {
                    z = true;
                    if (z) {
                        this.O0000Oo = false;
                        O00000o0();
                    } else {
                        this.O00000oo = y2;
                        this.O0000o = motionEvent.getPointerId(0);
                        VelocityTracker velocityTracker = this.O0000OoO;
                        if (velocityTracker == null) {
                            this.O0000OoO = VelocityTracker.obtain();
                        } else {
                            velocityTracker.clear();
                        }
                        this.O0000OoO.addMovement(motionEvent);
                        this.O00000o0.computeScrollOffset();
                        this.O0000Oo = !this.O00000o0.isFinished();
                        O000000o(2, 0);
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return this.O0000Oo;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        MotionEvent motionEvent2 = motionEvent;
        O00000Oo();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.O0000oOO = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.O0000oOO);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.O0000OoO;
                velocityTracker.computeCurrentVelocity(1000, (float) this.O0000o0o);
                int yVelocity = (int) velocityTracker.getYVelocity(this.O0000o);
                if (Math.abs(yVelocity) >= this.O0000o0O) {
                    int i = -yVelocity;
                    float f = (float) i;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        O00000Oo(i);
                    }
                } else if (this.O00000o0.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    cb.O00000oo(this);
                }
                this.O0000o = -1;
                O00000oO();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent2.findPointerIndex(this.O0000o);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.O0000o + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent2.getY(findPointerIndex);
                    int i2 = this.O00000oo - y;
                    if (!this.O0000Oo && Math.abs(i2) > this.O0000o0) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.O0000Oo = true;
                        i2 = i2 > 0 ? i2 - this.O0000o0 : i2 + this.O0000o0;
                    }
                    int i3 = i2;
                    if (this.O0000Oo) {
                        if (O000000o(0, i3, this.O0000oO, this.O0000oO0, 0)) {
                            i3 -= this.O0000oO[1];
                            this.O0000oOO += this.O0000oO0[1];
                        }
                        this.O00000oo = y - this.O0000oO0[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (O000000o(i3, 0, getScrollY(), scrollRange) && !O00000o(0)) {
                            this.O0000OoO.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.O0000oO;
                        iArr[1] = 0;
                        O000000o(scrollY2, i3 - scrollY2, this.O0000oO0, 0, iArr);
                        int i4 = this.O00000oo;
                        int[] iArr2 = this.O0000oO0;
                        this.O00000oo = i4 - iArr2[1];
                        this.O0000oOO += iArr2[1];
                        if (z) {
                            int i5 = i3 - this.O0000oO[1];
                            O00000oo();
                            int i6 = scrollY + i5;
                            if (i6 < 0) {
                                EdgeEffectCompat.O000000o(this.O00000o, ((float) i5) / ((float) getHeight()), motionEvent2.getX(findPointerIndex) / ((float) getWidth()));
                                if (!this.O00000oO.isFinished()) {
                                    this.O00000oO.onRelease();
                                }
                            } else if (i6 > scrollRange) {
                                EdgeEffectCompat.O000000o(this.O00000oO, ((float) i5) / ((float) getHeight()), 1.0f - (motionEvent2.getX(findPointerIndex) / ((float) getWidth())));
                                if (!this.O00000o.isFinished()) {
                                    this.O00000o.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.O00000o;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.O00000oO.isFinished())) {
                                cb.O00000oo(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.O0000Oo && getChildCount() > 0 && this.O00000o0.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    cb.O00000oo(this);
                }
                this.O0000o = -1;
                O00000oO();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.O00000oo = (int) motionEvent2.getY(actionIndex);
                this.O0000o = motionEvent2.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                O000000o(motionEvent);
                this.O00000oo = (int) motionEvent2.getY(motionEvent2.findPointerIndex(this.O0000o));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z2 = !this.O00000o0.isFinished();
            this.O0000Oo = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.O00000o0.isFinished()) {
                O00000o();
            }
            this.O00000oo = (int) motionEvent.getY();
            this.O0000o = motionEvent2.getPointerId(0);
            O000000o(2, 0);
        }
        VelocityTracker velocityTracker2 = this.O0000OoO;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void O000000o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O0000o) {
            int i = actionIndex == 0 ? 1 : 0;
            this.O00000oo = (int) motionEvent.getY(i);
            this.O0000o = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.O0000OoO;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.O0000Oo) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    verticalScrollFactorCompat = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    verticalScrollFactorCompat = scrollRange;
                }
                if (verticalScrollFactorCompat != scrollY) {
                    super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                    return true;
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.O00oOooo == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.O00oOooo = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.O00oOooo;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean O000000o(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i5 = i2 + 0;
        int i6 = i + i3;
        int i7 = i4 + 0;
        if (i5 <= 0 && i5 >= 0) {
            z = false;
        } else {
            i5 = 0;
            z = true;
        }
        if (i6 > i7) {
            z2 = true;
        } else if (i6 < 0) {
            z2 = true;
            i7 = 0;
        } else {
            i7 = i6;
            z2 = false;
        }
        if (z2 && !O00000o(1)) {
            this.O00000o0.springBack(i5, i7, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i5, i7, z, z2);
        return z || z2;
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    private View O000000o(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (!z4) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private boolean O00000oO(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.O00000Oo.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.O00000Oo.top + height > bottom) {
                    this.O00000Oo.top = bottom - height;
                }
            }
        } else {
            this.O00000Oo.top = getScrollY() - height;
            if (this.O00000Oo.top < 0) {
                this.O00000Oo.top = 0;
            }
        }
        Rect rect = this.O00000Oo;
        rect.bottom = rect.top + height;
        return O000000o(i, this.O00000Oo.top, this.O00000Oo.bottom);
    }

    private boolean O00000oo(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.O00000Oo;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.O00000Oo.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.O00000Oo;
            rect2.top = rect2.bottom - height;
        }
        return O000000o(i, this.O00000Oo.top, this.O00000Oo.bottom);
    }

    private boolean O000000o(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View O000000o2 = O000000o(z2, i2, i3);
        if (O000000o2 == null) {
            O000000o2 = this;
        }
        if (i2 < scrollY || i3 > i4) {
            O0000OOo(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (O000000o2 != findFocus()) {
            O000000o2.requestFocus(i);
        }
        return z;
    }

    private boolean O0000O0o(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !O000000o(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            O0000OOo(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.O00000Oo);
            offsetDescendantRectToMyCoords(findNextFocus, this.O00000Oo);
            O0000OOo(O000000o(this.O00000Oo));
            findNextFocus.requestFocus(i);
        }
        if (findFocus == null || !findFocus.isFocused() || !O000000o(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    private boolean O000000o(View view) {
        return !O000000o(view, 0, getHeight());
    }

    private boolean O000000o(View view, int i, int i2) {
        view.getDrawingRect(this.O00000Oo);
        offsetDescendantRectToMyCoords(view, this.O00000Oo);
        return this.O00000Oo.bottom + i >= getScrollY() && this.O00000Oo.top - i <= getScrollY() + i2;
    }

    private void O0000OOo(int i) {
        if (i == 0) {
            return;
        }
        if (this.O0000o00) {
            O0000Oo0(i);
        } else {
            scrollBy(0, i);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.core.widget.NestedScrollView.O000000o(int, int, int, boolean):void
     arg types: [int, int, int, int]
     candidates:
      androidx.core.widget.NestedScrollView.O000000o(int, int, int, int):boolean
      androidx.core.widget.NestedScrollView.O000000o(int, int, int, boolean):void */
    private void O0000Oo0(int i) {
        O000000o(0, i, 250, false);
    }

    private void O000000o(int i, int i2, int i3, boolean z) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2847O000000o > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.O00000o0;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, 250);
                O000000o(z);
            } else {
                if (!this.O00000o0.isFinished()) {
                    O00000o();
                }
                scrollBy(i, i2);
            }
            this.f2847O000000o = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void computeScroll() {
        if (!this.O00000o0.isFinished()) {
            this.O00000o0.computeScrollOffset();
            int currY = this.O00000o0.getCurrY();
            int i = currY - this.O0000oOo;
            this.O0000oOo = currY;
            int[] iArr = this.O0000oO;
            boolean z = false;
            iArr[1] = 0;
            O000000o(0, i, iArr, (int[]) null, 1);
            int i2 = i - this.O0000oO[1];
            int scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                O000000o(i2, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i2 - scrollY2;
                int[] iArr2 = this.O0000oO;
                iArr2[1] = 0;
                O000000o(scrollY2, i3, this.O0000oO0, 1, iArr2);
                i2 = i3 - this.O0000oO[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z = true;
                }
                if (z) {
                    O00000oo();
                    if (i2 < 0) {
                        if (this.O00000o.isFinished()) {
                            this.O00000o.onAbsorb((int) this.O00000o0.getCurrVelocity());
                        }
                    } else if (this.O00000oO.isFinished()) {
                        this.O00000oO.onAbsorb((int) this.O00000o0.getCurrVelocity());
                    }
                }
                O00000o();
            }
            if (!this.O00000o0.isFinished()) {
                cb.O00000oo(this);
            } else {
                O00000o0(1);
            }
        }
    }

    private void O000000o(boolean z) {
        if (z) {
            O000000o(2, 1);
        } else {
            O00000o0(1);
        }
        this.O0000oOo = getScrollY();
        cb.O00000oo(this);
    }

    private void O00000o() {
        this.O00000o0.abortAnimation();
        O00000o0(1);
    }

    private void O00000Oo(View view) {
        view.getDrawingRect(this.O00000Oo);
        offsetDescendantRectToMyCoords(view, this.O00000Oo);
        int O000000o2 = O000000o(this.O00000Oo);
        if (O000000o2 != 0) {
            scrollBy(0, O000000o2);
        }
    }

    private int O000000o(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i4;
            }
            return Math.min(i2 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        } else if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        } else {
            if (rect.height() > height) {
                i = 0 - (i4 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            return Math.max(i, -getScrollY());
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.O0000O0o) {
            O00000Oo(view2);
        } else {
            this.O0000Oo0 = view2;
        }
        super.requestChildFocus(view, view2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View view;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (view != null && !O000000o(view)) {
            return view.requestFocus(i, rect);
        }
        return false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int O000000o2 = O000000o(rect);
        boolean z2 = O000000o2 != 0;
        if (z2) {
            if (z) {
                scrollBy(0, O000000o2);
            } else {
                O0000Oo0(O000000o2);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.O0000O0o = true;
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.O0000O0o = false;
        View view = this.O0000Oo0;
        if (view != null && O000000o(view, this)) {
            O00000Oo(this.O0000Oo0);
        }
        this.O0000Oo0 = null;
        if (!this.O0000OOo) {
            if (this.O0000oo0 != null) {
                scrollTo(getScrollX(), this.O0000oo0.f2848O000000o);
                this.O0000oo0 = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int O00000Oo2 = O00000Oo(scrollY, paddingTop, i5);
            if (O00000Oo2 != scrollY) {
                scrollTo(getScrollX(), O00000Oo2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.O0000OOo = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O0000OOo = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && O000000o(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.O00000Oo);
            offsetDescendantRectToMyCoords(findFocus, this.O00000Oo);
            O0000OOo(O000000o(this.O00000Oo));
        }
    }

    private static boolean O000000o(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !O000000o((View) parent, view2)) {
            return false;
        }
        return true;
    }

    public final void O00000Oo(int i) {
        if (getChildCount() > 0) {
            this.O00000o0.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            O000000o(true);
        }
    }

    private void O00000oO() {
        this.O0000Oo = false;
        O00000o0();
        O00000o0(0);
        EdgeEffect edgeEffect = this.O00000o;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.O00000oO.onRelease();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int O00000Oo2 = O00000Oo(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int O00000Oo3 = O00000Oo(i2, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (O00000Oo2 != getScrollX() || O00000Oo3 != getScrollY()) {
                super.scrollTo(O00000Oo2, O00000Oo3);
            }
        }
    }

    private void O00000oo() {
        if (getOverScrollMode() == 2) {
            this.O00000o = null;
            this.O00000oO = null;
        } else if (this.O00000o == null) {
            Context context = getContext();
            this.O00000o = new EdgeEffect(context);
            this.O00000oO = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.O00000o != null) {
            int scrollY = getScrollY();
            int i2 = 0;
            if (!this.O00000o.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = getPaddingLeft() + 0;
                } else {
                    i = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i, (float) min);
                this.O00000o.setSize(width, height);
                if (this.O00000o.draw(canvas)) {
                    cb.O00000oo(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.O00000oO.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i2 = 0 + getPaddingLeft();
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i2 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.O00000oO.setSize(width2, height2);
                if (this.O00000oO.draw(canvas)) {
                    cb.O00000oo(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O0000oo0 = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2848O000000o = getScrollY();
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.core.widget.NestedScrollView.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2848O000000o;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2848O000000o = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2848O000000o);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2848O000000o + "}";
        }
    }

    static class O000000o extends bh {
        O000000o() {
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.O000000o(max);
                    return true;
                } else if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.O000000o(min);
            return true;
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            clVar.O00000Oo((CharSequence) ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                clVar.O0000OoO(true);
                if (nestedScrollView.getScrollY() > 0) {
                    clVar.O000000o(cl.O000000o.O0000o0);
                    clVar.O000000o(cl.O000000o.O0000ooo);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    clVar.O000000o(cl.O000000o.O0000o00);
                    clVar.O000000o(cl.O000000o.O00oOooo);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            int scrollX = nestedScrollView.getScrollX();
            if (Build.VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollX(scrollX);
            }
            int scrollRange = nestedScrollView.getScrollRange();
            if (Build.VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollY(scrollRange);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.core.widget.NestedScrollView.O000000o(int, int, int, boolean):void
     arg types: [int, int, int, int]
     candidates:
      androidx.core.widget.NestedScrollView.O000000o(int, int, int, int):boolean
      androidx.core.widget.NestedScrollView.O000000o(int, int, int, boolean):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        O000000o(0 - getScrollX(), i - getScrollY(), 250, true);
    }
}
