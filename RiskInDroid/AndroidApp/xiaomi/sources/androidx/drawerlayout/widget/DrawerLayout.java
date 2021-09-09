package androidx.drawerlayout.widget;

import _m_j.ab;
import _m_j.bh;
import _m_j.bk;
import _m_j.cb;
import _m_j.cl;
import _m_j.dh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    static final boolean CAN_HIDE_DESCENDANTS = (Build.VERSION.SDK_INT >= 19);
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    private static final int[] THEME_ATTRS = {16843828};
    private final O00000Oo mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final O00000o mLeftCallback;
    private final dh mLeftDragger;
    private O00000o0 mListener;
    private List<O00000o0> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final O00000o mRightCallback;
    private final dh mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    public interface O00000o0 {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        SET_DRAWER_SHADOW_FROM_ELEVATION = z;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [androidx.drawerlayout.widget.DrawerLayout, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildAccessibilityDelegate = new O00000Oo();
        this.mScrimColor = -1728053248;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.mLeftCallback = new O00000o(3);
        this.mRightCallback = new O00000o(5);
        this.mLeftDragger = dh.O000000o(this, 1.0f, this.mLeftCallback);
        dh dhVar = this.mLeftDragger;
        dhVar.O0000Oo0 = 1;
        dhVar.O0000O0o = f2;
        this.mLeftCallback.O00000Oo = dhVar;
        this.mRightDragger = dh.O000000o(this, 1.0f, this.mRightCallback);
        dh dhVar2 = this.mRightDragger;
        dhVar2.O0000Oo0 = 2;
        dhVar2.O0000O0o = f2;
        this.mRightCallback.O00000Oo = dhVar2;
        setFocusableInTouchMode(true);
        cb.O00000oO((View) this, 1);
        cb.O000000o(this, new O000000o());
        setMotionEventSplittingEnabled(false);
        if (cb.O0000ooo(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    /* class androidx.drawerlayout.widget.DrawerLayout.AnonymousClass1 */

                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
                try {
                    this.mStatusBarBackground = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.mStatusBarBackground = null;
            }
        }
        this.mDrawerElevation = f * 10.0f;
        this.mNonDrawerViews = new ArrayList<>();
    }

    public void setDrawerElevation(float f) {
        this.mDrawerElevation = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt)) {
                cb.O0000Oo(childAt, this.mDrawerElevation);
            }
        }
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    public void setChildInsets(Object obj, boolean z) {
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            if ((i & 8388611) == 8388611) {
                this.mShadowStart = drawable;
            } else if ((i & 8388613) == 8388613) {
                this.mShadowEnd = drawable;
            } else if ((i & 3) == 3) {
                this.mShadowLeft = drawable;
            } else if ((i & 5) == 5) {
                this.mShadowRight = drawable;
            } else {
                return;
            }
            resolveShadowDrawables();
            invalidate();
        }
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(ContextCompat.O000000o(getContext(), i), i2);
    }

    public void setScrimColor(int i) {
        this.mScrimColor = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(O00000o0 o00000o0) {
        O00000o0 o00000o02 = this.mListener;
        if (o00000o02 != null) {
            removeDrawerListener(o00000o02);
        }
        if (o00000o0 != null) {
            addDrawerListener(o00000o0);
        }
        this.mListener = o00000o0;
    }

    public void addDrawerListener(O00000o0 o00000o0) {
        if (o00000o0 != null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList();
            }
            this.mListeners.add(o00000o0);
        }
    }

    public void removeDrawerListener(O00000o0 o00000o0) {
        List<O00000o0> list;
        if (o00000o0 != null && (list = this.mListeners) != null) {
            list.remove(o00000o0);
        }
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        View findDrawerWithGravity;
        int O000000o2 = bk.O000000o(i2, cb.O0000Oo0(this));
        if (i2 == 3) {
            this.mLockModeLeft = i;
        } else if (i2 == 5) {
            this.mLockModeRight = i;
        } else if (i2 == 8388611) {
            this.mLockModeStart = i;
        } else if (i2 == 8388613) {
            this.mLockModeEnd = i;
        }
        if (i != 0) {
            (O000000o2 == 3 ? this.mLeftDragger : this.mRightDragger).O000000o();
        }
        if (i == 1) {
            View findDrawerWithGravity2 = findDrawerWithGravity(O000000o2);
            if (findDrawerWithGravity2 != null) {
                closeDrawer(findDrawerWithGravity2);
            }
        } else if (i == 2 && (findDrawerWithGravity = findDrawerWithGravity(O000000o2)) != null) {
            openDrawer(findDrawerWithGravity);
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (isDrawerView(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).f2852O000000o);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public int getDrawerLockMode(int i) {
        int i2;
        int i3;
        int i4;
        int O0000Oo0 = cb.O0000Oo0(this);
        if (i == 3) {
            int i5 = this.mLockModeLeft;
            if (i5 != 3) {
                return i5;
            }
            int i6 = O0000Oo0 == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        } else if (i == 5) {
            int i7 = this.mLockModeRight;
            if (i7 != 3) {
                return i7;
            }
            if (O0000Oo0 == 0) {
                i2 = this.mLockModeEnd;
            } else {
                i2 = this.mLockModeStart;
            }
            if (i2 != 3) {
                return i2;
            }
            return 0;
        } else if (i == 8388611) {
            int i8 = this.mLockModeStart;
            if (i8 != 3) {
                return i8;
            }
            if (O0000Oo0 == 0) {
                i3 = this.mLockModeLeft;
            } else {
                i3 = this.mLockModeRight;
            }
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i != 8388613) {
            return 0;
        } else {
            int i9 = this.mLockModeEnd;
            if (i9 != 3) {
                return i9;
            }
            if (O0000Oo0 == 0) {
                i4 = this.mLockModeRight;
            } else {
                i4 = this.mLockModeLeft;
            }
            if (i4 != 3) {
                return i4;
            }
            return 0;
        }
    }

    public int getDrawerLockMode(View view) {
        if (isDrawerView(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).f2852O000000o);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int O000000o2 = bk.O000000o(i, cb.O0000Oo0(this));
        if (O000000o2 == 3) {
            this.mTitleLeft = charSequence;
        } else if (O000000o2 == 5) {
            this.mTitleRight = charSequence;
        }
    }

    public CharSequence getDrawerTitle(int i) {
        int O000000o2 = bk.O000000o(i, cb.O0000Oo0(this));
        if (O000000o2 == 3) {
            return this.mTitleLeft;
        }
        if (O000000o2 == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    private boolean isInBoundsOfChild(float f, float f2, View view) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        view.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) f, (int) f2);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.mChildInvertedMatrix == null) {
                this.mChildInvertedMatrix = new Matrix();
            }
            matrix.invert(this.mChildInvertedMatrix);
            obtain.transform(this.mChildInvertedMatrix);
        }
        return obtain;
    }

    /* access modifiers changed from: package-private */
    public void updateDrawerState(int i, int i2, View view) {
        int i3 = this.mLeftDragger.f14629O000000o;
        int i4 = this.mRightDragger.f14629O000000o;
        int i5 = 2;
        if (i3 == 1 || i4 == 1) {
            i5 = 1;
        } else if (!(i3 == 2 || i4 == 2)) {
            i5 = 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.O00000Oo == 0.0f) {
                dispatchOnDrawerClosed(view);
            } else if (layoutParams.O00000Oo == 1.0f) {
                dispatchOnDrawerOpened(view);
            }
        }
        if (i5 != this.mDrawerState) {
            this.mDrawerState = i5;
            List<O00000o0> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerStateChanged(i5);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDrawerClosed(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.O00000o & 1) == 1) {
            layoutParams.O00000o = 0;
            List<O00000o0> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerClosed(view);
                }
            }
            updateChildrenImportantForAccessibility(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDrawerOpened(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.O00000o & 1) == 0) {
            layoutParams.O00000o = 1;
            List<O00000o0> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerOpened(view);
                }
            }
            updateChildrenImportantForAccessibility(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || isDrawerView(childAt)) && (!z || childAt != view)) {
                cb.O00000oO(childAt, 4);
            } else {
                cb.O00000oO(childAt, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDrawerSlide(View view, float f) {
        List<O00000o0> list = this.mListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onDrawerSlide(view, f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setDrawerViewOffset(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.O00000Oo) {
            layoutParams.O00000Oo = f;
            dispatchOnDrawerSlide(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    public float getDrawerViewOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).O00000Oo;
    }

    /* access modifiers changed from: package-private */
    public int getDrawerViewAbsoluteGravity(View view) {
        return bk.O000000o(((LayoutParams) view.getLayoutParams()).f2852O000000o, cb.O0000Oo0(this));
    }

    /* access modifiers changed from: package-private */
    public boolean checkDrawerViewAbsoluteGravity(View view, int i) {
        return (getDrawerViewAbsoluteGravity(view) & i) == i;
    }

    /* access modifiers changed from: package-private */
    public View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).O00000o & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void moveDrawerToOffset(View view, float f) {
        float drawerViewOffset = getDrawerViewOffset(view);
        float width = (float) view.getWidth();
        int i = ((int) (width * f)) - ((int) (drawerViewOffset * width));
        if (!checkDrawerViewAbsoluteGravity(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        setDrawerViewOffset(view, f);
    }

    /* access modifiers changed from: package-private */
    public View findDrawerWithGravity(int i) {
        int O000000o2 = bk.O000000o(i, cb.O0000Oo0(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == O000000o2) {
                return childAt;
            }
        }
        return null;
    }

    static String gravityToString(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.mLastInsets != null && cb.O0000ooo(this);
        int O0000Oo0 = cb.O0000Oo0(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int O000000o2 = bk.O000000o(layoutParams.f2852O000000o, O0000Oo0);
                    if (cb.O0000ooo(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.mLastInsets;
                            if (O000000o2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (O000000o2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.mLastInsets;
                        if (O000000o2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (O000000o2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (isDrawerView(childAt)) {
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                        float O0000oOO = cb.O0000oOO(childAt);
                        float f = this.mDrawerElevation;
                        if (O0000oOO != f) {
                            cb.O0000Oo(childAt, f);
                        }
                    }
                    int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(childAt) & 7;
                    boolean z4 = drawerViewAbsoluteGravity == 3;
                    if ((!z4 || !z2) && (z4 || !z3)) {
                        if (z4) {
                            z2 = true;
                        } else {
                            z3 = true;
                        }
                        childAt.measure(getChildMeasureSpec(i, this.mMinDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                        i4++;
                        i3 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(drawerViewAbsoluteGravity) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i4++;
            i3 = 0;
        }
    }

    private void resolveShadowDrawables() {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            this.mShadowLeftResolved = resolveLeftShadow();
            this.mShadowRightResolved = resolveRightShadow();
        }
    }

    private Drawable resolveLeftShadow() {
        int O0000Oo0 = cb.O0000Oo0(this);
        if (O0000Oo0 == 0) {
            Drawable drawable = this.mShadowStart;
            if (drawable != null) {
                mirror(drawable, O0000Oo0);
                return this.mShadowStart;
            }
        } else {
            Drawable drawable2 = this.mShadowEnd;
            if (drawable2 != null) {
                mirror(drawable2, O0000Oo0);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int O0000Oo0 = cb.O0000Oo0(this);
        if (O0000Oo0 == 0) {
            Drawable drawable = this.mShadowEnd;
            if (drawable != null) {
                mirror(drawable, O0000Oo0);
                return this.mShadowEnd;
            }
        } else {
            Drawable drawable2 = this.mShadowStart;
            if (drawable2 != null) {
                mirror(drawable2, O0000Oo0);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }

    private boolean mirror(Drawable drawable, int i) {
        if (drawable == null || !ab.O000000o(drawable)) {
            return false;
        }
        ab.O00000Oo(drawable, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        this.mInLayout = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f2 = (float) measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.O00000Oo * f2));
                        f = ((float) (measuredWidth + i5)) / f2;
                    } else {
                        float f3 = (float) measuredWidth;
                        int i8 = i6 - ((int) (layoutParams.O00000Oo * f3));
                        f = ((float) (i6 - i8)) / f3;
                        i5 = i8;
                    }
                    boolean z2 = f != layoutParams.O00000Oo;
                    int i9 = layoutParams.f2852O000000o & 112;
                    if (i9 == 16) {
                        int i10 = i4 - i2;
                        int i11 = (i10 - measuredHeight) / 2;
                        if (i11 < layoutParams.topMargin) {
                            i11 = layoutParams.topMargin;
                        } else if (i11 + measuredHeight > i10 - layoutParams.bottomMargin) {
                            i11 = (i10 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                    } else if (i9 != 80) {
                        childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i12 = i4 - i2;
                        childAt.layout(i5, (i12 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i12 - layoutParams.bottomMargin);
                    }
                    if (z2) {
                        setDrawerViewOffset(childAt, f);
                    }
                    int i13 = layoutParams.O00000Oo > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i13) {
                        childAt.setVisibility(i13);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).O00000Oo);
        }
        this.mScrimOpacity = f;
        boolean O00000o02 = this.mLeftDragger.O00000o0();
        boolean O00000o03 = this.mRightDragger.O00000o0();
        if (O00000o02 || O00000o03) {
            cb.O00000oo(this);
        }
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public void setStatusBarBackground(int i) {
        this.mStatusBarBackground = i != 0 ? ContextCompat.O000000o(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.mStatusBarBackground = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        resolveShadowDrawables();
    }

    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.mLastInsets) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        View view2 = view;
        int height = getHeight();
        boolean isContentView = isContentView(view2);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (isContentView) {
            int childCount = getChildCount();
            i = width;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view2 && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i) {
                            i = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, i, getHeight());
            i2 = i3;
        } else {
            i = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.mScrimOpacity;
        if (f > 0.0f && isContentView) {
            int i5 = this.mScrimColor;
            this.mScrimPaint.setColor((i5 & 16777215) | (((int) (((float) ((-16777216 & i5) >>> 24)) * f)) << 24));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.mScrimPaint);
        } else if (this.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view2, 3)) {
            int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.mLeftDragger.O0000OOo), 1.0f));
            this.mShadowLeftResolved.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.mShadowLeftResolved.setAlpha((int) (max * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
        } else if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view2, 5)) {
            int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.mRightDragger.O0000OOo), 1.0f));
            this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.mShadowRightResolved.setAlpha((int) (max2 * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public boolean isContentView(View view) {
        return ((LayoutParams) view.getLayoutParams()).f2852O000000o == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isDrawerView(View view) {
        int O000000o2 = bk.O000000o(((LayoutParams) view.getLayoutParams()).f2852O000000o, cb.O0000Oo0(view));
        return ((O000000o2 & 3) == 0 && (O000000o2 & 5) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0 != 3) goto L_0x006d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A[LOOP:0: B:8:0x0024->B:17:0x0055, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0053 A[SYNTHETIC] */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View O00000Oo2;
        boolean z2;
        boolean z3;
        int actionMasked = motionEvent.getActionMasked();
        boolean O000000o2 = this.mLeftDragger.O000000o(motionEvent) | this.mRightDragger.O000000o(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    dh dhVar = this.mLeftDragger;
                    int length = dhVar.O00000o0.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z2 = false;
                            break;
                        }
                        if (dhVar.O000000o(i)) {
                            float f = dhVar.O00000oO[i] - dhVar.O00000o0[i];
                            float f2 = dhVar.O00000oo[i] - dhVar.O00000o[i];
                            if ((f * f) + (f2 * f2) > ((float) (dhVar.O00000Oo * dhVar.O00000Oo))) {
                                z3 = true;
                                if (!z3) {
                                    z2 = true;
                                    break;
                                }
                                i++;
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    if (z2) {
                        this.mLeftCallback.O000000o();
                        this.mRightCallback.O000000o();
                    }
                }
                z = false;
            }
            closeDrawers(true);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            z = this.mScrimOpacity > 0.0f && (O00000Oo2 = this.mLeftDragger.O00000Oo((int) x, (int) y)) != null && isContentView(O00000Oo2);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        }
        return O000000o2 || z || hasPeekingDrawer() || this.mChildrenCanceledTouch;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.mScrimOpacity <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (isInBoundsOfChild(x, y, childAt) && !isContentView(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View findOpenDrawer;
        this.mLeftDragger.O00000Oo(motionEvent);
        this.mRightDragger.O00000Oo(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        } else if (action == 1) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            View O00000Oo2 = this.mLeftDragger.O00000Oo((int) x2, (int) y2);
            if (O00000Oo2 != null && isContentView(O00000Oo2)) {
                float f = x2 - this.mInitialMotionX;
                float f2 = y2 - this.mInitialMotionY;
                int i = this.mLeftDragger.O00000Oo;
                if (!((f * f) + (f2 * f2) >= ((float) (i * i)) || (findOpenDrawer = findOpenDrawer()) == null || getDrawerLockMode(findOpenDrawer) == 2)) {
                    z = false;
                    closeDrawers(z);
                    this.mDisallowInterceptRequested = false;
                }
            }
            z = true;
            closeDrawers(z);
            this.mDisallowInterceptRequested = false;
        } else if (action == 3) {
            closeDrawers(true);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.mDisallowInterceptRequested = z;
        if (z) {
            closeDrawers(true);
        }
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    /* access modifiers changed from: package-private */
    public void closeDrawers(boolean z) {
        boolean z2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z || layoutParams.O00000o0)) {
                int width = childAt.getWidth();
                if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                    z2 = this.mLeftDragger.O000000o(childAt, -width, childAt.getTop());
                } else {
                    z2 = this.mRightDragger.O000000o(childAt, getWidth(), childAt.getTop());
                }
                z3 |= z2;
                layoutParams.O00000o0 = false;
            }
        }
        this.mLeftCallback.O000000o();
        this.mRightCallback.O000000o();
        if (z3) {
            invalidate();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.drawerlayout.widget.DrawerLayout.openDrawer(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      androidx.drawerlayout.widget.DrawerLayout.openDrawer(int, boolean):void
      androidx.drawerlayout.widget.DrawerLayout.openDrawer(android.view.View, boolean):void */
    public void openDrawer(View view) {
        openDrawer(view, true);
    }

    public void openDrawer(View view, boolean z) {
        if (isDrawerView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.O00000Oo = 1.0f;
                layoutParams.O00000o = 1;
                updateChildrenImportantForAccessibility(view, true);
            } else if (z) {
                layoutParams.O00000o |= 2;
                if (checkDrawerViewAbsoluteGravity(view, 3)) {
                    this.mLeftDragger.O000000o(view, 0, view.getTop());
                } else {
                    this.mRightDragger.O000000o(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, 1.0f);
                updateDrawerState(layoutParams.f2852O000000o, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.drawerlayout.widget.DrawerLayout.openDrawer(int, boolean):void
     arg types: [int, int]
     candidates:
      androidx.drawerlayout.widget.DrawerLayout.openDrawer(android.view.View, boolean):void
      androidx.drawerlayout.widget.DrawerLayout.openDrawer(int, boolean):void */
    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void openDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            openDrawer(findDrawerWithGravity, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.drawerlayout.widget.DrawerLayout.closeDrawer(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      androidx.drawerlayout.widget.DrawerLayout.closeDrawer(int, boolean):void
      androidx.drawerlayout.widget.DrawerLayout.closeDrawer(android.view.View, boolean):void */
    public void closeDrawer(View view) {
        closeDrawer(view, true);
    }

    public void closeDrawer(View view, boolean z) {
        if (isDrawerView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.O00000Oo = 0.0f;
                layoutParams.O00000o = 0;
            } else if (z) {
                layoutParams.O00000o |= 4;
                if (checkDrawerViewAbsoluteGravity(view, 3)) {
                    this.mLeftDragger.O000000o(view, -view.getWidth(), view.getTop());
                } else {
                    this.mRightDragger.O000000o(view, getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, 0.0f);
                updateDrawerState(layoutParams.f2852O000000o, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.drawerlayout.widget.DrawerLayout.closeDrawer(int, boolean):void
     arg types: [int, int]
     candidates:
      androidx.drawerlayout.widget.DrawerLayout.closeDrawer(android.view.View, boolean):void
      androidx.drawerlayout.widget.DrawerLayout.closeDrawer(int, boolean):void */
    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public void closeDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            closeDrawer(findDrawerWithGravity, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
    }

    public boolean isDrawerOpen(View view) {
        if (isDrawerView(view)) {
            return (((LayoutParams) view.getLayoutParams()).O00000o & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerOpen(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerOpen(findDrawerWithGravity);
        }
        return false;
    }

    public boolean isDrawerVisible(View view) {
        if (isDrawerView(view)) {
            return ((LayoutParams) view.getLayoutParams()).O00000Oo > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerVisible(findDrawerWithGravity);
        }
        return false;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).O00000o0) {
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
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!isDrawerView(childAt)) {
                    this.mNonDrawerViews.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            }
            if (!z) {
                int size = this.mNonDrawerViews.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.mNonDrawerViews.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.mNonDrawerViews.clear();
        }
    }

    private boolean hasVisibleDrawer() {
        return findVisibleDrawer() != null;
    }

    /* access modifiers changed from: package-private */
    public View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void cancelChildViewTouch() {
        if (!this.mChildrenCanceledTouch) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !hasVisibleDrawer()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View findVisibleDrawer = findVisibleDrawer();
        if (findVisibleDrawer != null && getDrawerLockMode(findVisibleDrawer) == 0) {
            closeDrawers();
        }
        return findVisibleDrawer != null;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View findDrawerWithGravity;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.f2856O000000o == 0 || (findDrawerWithGravity = findDrawerWithGravity(savedState.f2856O000000o)) == null)) {
            openDrawer(findDrawerWithGravity);
        }
        if (savedState.O00000Oo != 3) {
            setDrawerLockMode(savedState.O00000Oo, 3);
        }
        if (savedState.O00000o0 != 3) {
            setDrawerLockMode(savedState.O00000o0, 5);
        }
        if (savedState.O00000o != 3) {
            setDrawerLockMode(savedState.O00000o, 8388611);
        }
        if (savedState.O00000oO != 3) {
            setDrawerLockMode(savedState.O00000oO, 8388613);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z = true;
            boolean z2 = layoutParams.O00000o == 1;
            if (layoutParams.O00000o != 2) {
                z = false;
            }
            if (z2 || z) {
                savedState.f2856O000000o = layoutParams.f2852O000000o;
            } else {
                i++;
            }
        }
        savedState.O00000Oo = this.mLockModeLeft;
        savedState.O00000o0 = this.mLockModeRight;
        savedState.O00000o = this.mLockModeStart;
        savedState.O00000oO = this.mLockModeEnd;
        return savedState;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (findOpenDrawer() != null || isDrawerView(view)) {
            cb.O00000oO(view, 4);
        } else {
            cb.O00000oO(view, 1);
        }
        if (!CAN_HIDE_DESCENDANTS) {
            cb.O000000o(view, this.mChildAccessibilityDelegate);
        }
    }

    static boolean includeChildForAccessibility(View view) {
        return (cb.O0000O0o(view) == 4 || cb.O0000O0o(view) == 2) ? false : true;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.drawerlayout.widget.DrawerLayout.SavedState.AnonymousClass1 */

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f2856O000000o = 0;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2856O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
            this.O00000o = parcel.readInt();
            this.O00000oO = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2856O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
            parcel.writeInt(this.O00000o);
            parcel.writeInt(this.O00000oO);
        }
    }

    class O00000o extends dh.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f2854O000000o;
        dh O00000Oo;
        private final Runnable O00000o = new Runnable() {
            /* class androidx.drawerlayout.widget.DrawerLayout.O00000o.AnonymousClass1 */

            public final void run() {
                View view;
                int i;
                O00000o o00000o = O00000o.this;
                int i2 = o00000o.O00000Oo.O0000OOo;
                int i3 = 0;
                boolean z = o00000o.f2854O000000o == 3;
                if (z) {
                    view = DrawerLayout.this.findDrawerWithGravity(3);
                    if (view != null) {
                        i3 = -view.getWidth();
                    }
                    i = i3 + i2;
                } else {
                    view = DrawerLayout.this.findDrawerWithGravity(5);
                    i = DrawerLayout.this.getWidth() - i2;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                    o00000o.O00000Oo.O000000o(view, i, view.getTop());
                    ((LayoutParams) view.getLayoutParams()).O00000o0 = true;
                    DrawerLayout.this.invalidate();
                    o00000o.O00000Oo();
                    DrawerLayout.this.cancelChildViewTouch();
                }
            }
        };

        public final boolean onEdgeLock(int i) {
            return false;
        }

        O00000o(int i) {
            this.f2854O000000o = i;
        }

        public final void O000000o() {
            DrawerLayout.this.removeCallbacks(this.O00000o);
        }

        public final boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.isDrawerView(view) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, this.f2854O000000o) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }

        public final void onViewDragStateChanged(int i) {
            DrawerLayout.this.updateDrawerState(this.f2854O000000o, i, this.O00000Oo.O0000Oo);
        }

        public final void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                f = (float) (i + width);
            } else {
                f = (float) (DrawerLayout.this.getWidth() - i);
            }
            float f2 = f / ((float) width);
            DrawerLayout.this.setDrawerViewOffset(view, f2);
            view.setVisibility(f2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public final void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).O00000o0 = false;
            O00000Oo();
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            int i = 3;
            if (this.f2854O000000o == 3) {
                i = 5;
            }
            View findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(i);
            if (findDrawerWithGravity != null) {
                DrawerLayout.this.closeDrawer(findDrawerWithGravity);
            }
        }

        public final void onViewReleased(View view, float f, float f2) {
            int i;
            float drawerViewOffset = DrawerLayout.this.getDrawerViewOffset(view);
            int width = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.O00000Oo.O000000o(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public final void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.O00000o, 160);
        }

        public final void onEdgeDragStarted(int i, int i2) {
            View view;
            if ((i & 1) == 1) {
                view = DrawerLayout.this.findDrawerWithGravity(3);
            } else {
                view = DrawerLayout.this.findDrawerWithGravity(5);
            }
            if (view != null && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.O00000Oo.O000000o(view, i2);
            }
        }

        public final int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.isDrawerView(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public final int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2852O000000o = 0;
        float O00000Oo;
        int O00000o;
        boolean O00000o0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.f2852O000000o = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f2852O000000o = layoutParams.f2852O000000o;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class O000000o extends bh {
        private final Rect O00000Oo = new Rect();

        O000000o() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(view, clVar);
            } else {
                cl O000000o2 = cl.O000000o(clVar);
                super.onInitializeAccessibilityNodeInfo(view, O000000o2);
                clVar.O00000Oo(view);
                ViewParent O0000Oo = cb.O0000Oo(view);
                if (O0000Oo instanceof View) {
                    clVar.O00000o((View) O0000Oo);
                }
                Rect rect = this.O00000Oo;
                O000000o2.O000000o(rect);
                clVar.O00000Oo(rect);
                O000000o2.O00000o0(rect);
                clVar.O00000o(rect);
                clVar.O00000oO(O000000o2.O00000Oo());
                clVar.O000000o(O000000o2.f13980O000000o.getPackageName());
                clVar.O00000Oo(O000000o2.f13980O000000o.getClassName());
                clVar.O00000oO(O000000o2.f13980O000000o.getContentDescription());
                clVar.O0000Oo(O000000o2.f13980O000000o.isEnabled());
                clVar.O0000OOo(O000000o2.f13980O000000o.isClickable());
                clVar.O00000o0(O000000o2.f13980O000000o.isFocusable());
                clVar.O00000o(O000000o2.f13980O000000o.isFocused());
                clVar.O00000oo(O000000o2.O00000o0());
                clVar.O0000O0o(O000000o2.f13980O000000o.isSelected());
                clVar.O0000Oo0(O000000o2.f13980O000000o.isLongClickable());
                clVar.O000000o(O000000o2.f13980O000000o.getActions());
                O000000o2.f13980O000000o.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.includeChildForAccessibility(childAt)) {
                        clVar.O00000o0(childAt);
                    }
                }
            }
            clVar.O00000Oo((CharSequence) DrawerLayout.class.getName());
            clVar.O00000o0(false);
            clVar.O00000o(false);
            clVar.O00000Oo(cl.O000000o.f13981O000000o);
            clVar.O00000Oo(cl.O000000o.O00000Oo);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence drawerTitle;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View findVisibleDrawer = DrawerLayout.this.findVisibleDrawer();
            if (findVisibleDrawer == null || (drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(findVisibleDrawer))) == null) {
                return true;
            }
            text.add(drawerTitle);
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class O00000Oo extends bh {
        O00000Oo() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            if (!DrawerLayout.includeChildForAccessibility(view)) {
                clVar.O00000o((View) null);
            }
        }
    }
}
