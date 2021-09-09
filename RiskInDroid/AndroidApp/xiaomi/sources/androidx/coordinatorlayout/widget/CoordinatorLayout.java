package androidx.coordinatorlayout.widget;

import _m_j.ab;
import _m_j.bd;
import _m_j.bk;
import _m_j.bt;
import _m_j.bu;
import _m_j.bv;
import _m_j.bw;
import _m_j.cb;
import _m_j.ci;
import _m_j.oOOO000o;
import _m_j.oOOO00Oo;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools;
import androidx.customview.view.AbsSavedState;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements bt, bu {
    static final Class<?>[] CONSTRUCTOR_PARAMS = {Context.class, AttributeSet.class};
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = new ThreadLocal<>();
    private static final Pools.O000000o<Rect> sRectPool = new Pools.O00000Oo(12);
    private bw mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final oOOO000o<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private ci mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final bv mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private O0000O0o mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public interface O000000o {
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface O00000Oo {
        Class<? extends Behavior> O000000o();
    }

    private static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = packageR != null ? packageR.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new O0000OOo();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
    }

    private static Rect acquireTempRect() {
        Rect acquire = sRectPool.acquire();
        return acquire == null ? new Rect() : acquire;
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new oOOO000o<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new bv();
        if (i == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.keylines, R.attr.statusBarBackground}, 0, 2132739205);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.keylines, R.attr.statusBarBackground}, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, new int[]{R.attr.keylines, R.attr.statusBarBackground}, attributeSet, typedArray, 0, 2132739205);
            } else {
                saveAttributeDataForStyleable(context, new int[]{R.attr.keylines, R.attr.statusBarBackground}, attributeSet, typedArray, i, 0);
            }
        }
        int resourceId = typedArray.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.mKeylines;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
            }
        }
        this.mStatusBarBackground = typedArray.getDrawable(1);
        typedArray.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new O00000o0());
        if (cb.O0000O0o(this) == 0) {
            cb.O00000oO((View) this, 1);
        }
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new O0000O0o();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && cb.O0000ooo(this)) {
            cb.O0000ooO(this);
        }
        this.mIsAttachedToWindow = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            Drawable drawable4 = this.mStatusBarBackground;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                ab.O00000Oo(this.mStatusBarBackground, cb.O0000Oo0(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            cb.O00000oo(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.O000000o(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    /* access modifiers changed from: package-private */
    public final ci setWindowInsets(ci ciVar) {
        if (bd.O000000o(this.mLastInsets, ciVar)) {
            return ciVar;
        }
        this.mLastInsets = ciVar;
        boolean z = true;
        this.mDrawStatusBarBackground = ciVar != null && ciVar.O00000Oo.O0000O0o().O00000o0 > 0;
        if (this.mDrawStatusBarBackground || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        ci dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(ciVar);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    public final ci getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behavior = ((O00000o) childAt.getLayoutParams()).f2811O000000o;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((O00000o) getChildAt(i2).getLayoutParams()).O0000o00 = false;
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2 = motionEvent;
        int i2 = i;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z3 = false;
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            O00000o o00000o = (O00000o) view.getLayoutParams();
            Behavior behavior = o00000o.f2811O000000o;
            boolean z5 = true;
            if ((!z3 && !z4) || actionMasked == 0) {
                if (!z3 && behavior != null) {
                    if (i2 == 0) {
                        z3 = behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    } else if (i2 == 1) {
                        z3 = behavior.onTouchEvent(this, view, motionEvent2);
                    }
                    if (z3) {
                        this.mBehaviorTouchView = view;
                    }
                }
                if (o00000o.f2811O000000o == null) {
                    o00000o.O0000o00 = false;
                }
                boolean z6 = o00000o.O0000o00;
                if (o00000o.O0000o00) {
                    z = true;
                } else {
                    boolean z7 = o00000o.O0000o00;
                    if (o00000o.f2811O000000o != null) {
                        z2 = o00000o.f2811O000000o.blocksInteractionBelow(this, view);
                    } else {
                        z2 = false;
                    }
                    z = z2 | z7;
                    o00000o.O0000o00 = z;
                }
                if (!z || z6) {
                    z5 = false;
                }
                if (z && !z5) {
                    break;
                }
                z4 = z5;
            } else if (behavior != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    behavior.onInterceptTouchEvent(this, view, motionEvent3);
                } else if (i2 == 1) {
                    behavior.onTouchEvent(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z3;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mBehaviorTouchView == null) {
            z2 = performIntercept(motionEvent3, 1);
        } else {
            z2 = false;
        }
        Behavior behavior = ((O00000o) this.mBehaviorTouchView.getLayoutParams()).f2811O000000o;
        if (behavior != null) {
            z = behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent3);
            motionEvent2 = null;
            if (this.mBehaviorTouchView != null) {
                z |= super.onTouchEvent(motionEvent);
            } else if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked == 1 || actionMasked == 3) {
                resetTouchBehaviors(false);
            }
            return z;
        }
        z = false;
        motionEvent2 = null;
        if (this.mBehaviorTouchView != null) {
        }
        if (motionEvent2 != null) {
        }
        resetTouchBehaviors(false);
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    private int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + '.' + str;
        }
        try {
            Map map = sConstructors.get();
            if (map == null) {
                map = new HashMap();
                sConstructors.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str)), e);
        }
    }

    /* access modifiers changed from: package-private */
    public O00000o getResolvedLayoutParams(View view) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        if (!o00000o.O00000Oo) {
            if (view instanceof O000000o) {
                Behavior behavior = ((O000000o) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                o00000o.O000000o(behavior);
                o00000o.O00000Oo = true;
            } else {
                O00000Oo o00000Oo = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    o00000Oo = (O00000Oo) cls.getAnnotation(O00000Oo.class);
                    if (o00000Oo != null) {
                        break;
                    }
                }
                if (o00000Oo != null) {
                    try {
                        o00000o.O000000o((Behavior) o00000Oo.O000000o().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e("CoordinatorLayout", "Default behavior class " + o00000Oo.O000000o().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
                o00000o.O00000Oo = true;
            }
        }
        return o00000o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r5 != false) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0168 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011d  */
    private void prepareChildren() {
        boolean z;
        boolean z2;
        this.mDependencySortedChildren.clear();
        oOOO000o<View> oooo000o = this.mChildDag;
        int size = oooo000o.O00000Oo.size();
        for (int i = 0; i < size; i++) {
            ArrayList O00000o02 = oooo000o.O00000Oo.O00000o0(i);
            if (O00000o02 != null) {
                O00000o02.clear();
                oooo000o.f2309O000000o.release(O00000o02);
            }
        }
        oooo000o.O00000Oo.clear();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            O00000o resolvedLayoutParams = getResolvedLayoutParams(childAt);
            if (resolvedLayoutParams.O00000oo == -1) {
                resolvedLayoutParams.O0000Ooo = null;
                resolvedLayoutParams.O0000OoO = null;
            } else {
                if (resolvedLayoutParams.O0000OoO != null) {
                    if (resolvedLayoutParams.O0000OoO.getId() == resolvedLayoutParams.O00000oo) {
                        View view = resolvedLayoutParams.O0000OoO;
                        ViewParent parent = resolvedLayoutParams.O0000OoO.getParent();
                        while (parent != this) {
                            if (parent == null || parent == childAt) {
                                resolvedLayoutParams.O0000Ooo = null;
                                resolvedLayoutParams.O0000OoO = null;
                            } else {
                                if (parent instanceof View) {
                                    view = (View) parent;
                                }
                                parent = parent.getParent();
                            }
                        }
                        resolvedLayoutParams.O0000Ooo = view;
                        z2 = true;
                    }
                    z2 = false;
                    break;
                }
                resolvedLayoutParams.O0000OoO = findViewById(resolvedLayoutParams.O00000oo);
                if (resolvedLayoutParams.O0000OoO != null) {
                    if (resolvedLayoutParams.O0000OoO != this) {
                        View view2 = resolvedLayoutParams.O0000OoO;
                        ViewParent parent2 = resolvedLayoutParams.O0000OoO.getParent();
                        while (true) {
                            if (parent2 == this || parent2 == null) {
                                resolvedLayoutParams.O0000Ooo = view2;
                            } else if (parent2 != childAt) {
                                if (parent2 instanceof View) {
                                    view2 = (View) parent2;
                                }
                                parent2 = parent2.getParent();
                            } else if (isInEditMode()) {
                                resolvedLayoutParams.O0000Ooo = null;
                                resolvedLayoutParams.O0000OoO = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                    } else if (isInEditMode()) {
                        resolvedLayoutParams.O0000Ooo = null;
                        resolvedLayoutParams.O0000OoO = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    resolvedLayoutParams.O0000Ooo = null;
                    resolvedLayoutParams.O0000OoO = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(resolvedLayoutParams.O00000oo) + " to anchor view " + childAt);
                }
            }
            this.mChildDag.O000000o(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (childAt2 != resolvedLayoutParams.O0000Ooo) {
                        int O0000Oo0 = cb.O0000Oo0(this);
                        int O000000o2 = bk.O000000o(((O00000o) childAt2.getLayoutParams()).O0000O0o, O0000Oo0);
                        if (!(O000000o2 != 0 && (bk.O000000o(resolvedLayoutParams.O0000OOo, O0000Oo0) & O000000o2) == O000000o2) && (resolvedLayoutParams.f2811O000000o == null || !resolvedLayoutParams.f2811O000000o.layoutDependsOn(this, childAt, childAt2))) {
                            z = false;
                            if (!z) {
                                continue;
                            } else {
                                if (!this.mChildDag.O00000Oo.containsKey(childAt2)) {
                                    this.mChildDag.O000000o(childAt2);
                                }
                                oOOO000o<View> oooo000o2 = this.mChildDag;
                                if (!oooo000o2.O00000Oo.containsKey(childAt2) || !oooo000o2.O00000Oo.containsKey(childAt)) {
                                    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                                }
                                ArrayList arrayList = oooo000o2.O00000Oo.get(childAt2);
                                if (arrayList == null) {
                                    arrayList = oooo000o2.f2309O000000o.acquire();
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    oooo000o2.O00000Oo.put(childAt2, arrayList);
                                }
                                arrayList.add(childAt);
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.O000000o());
        Collections.reverse(this.mDependencySortedChildren);
    }

    /* access modifiers changed from: package-private */
    public void getDescendantRect(View view, Rect rect) {
        oOOO00Oo.O000000o(this, view, rect);
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0121, code lost:
        if (r0.onMeasureChild(r1, r20, r11, r21, r23, 0) == false) goto L_0x0130;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0124  */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Behavior behavior;
        int i10;
        int i11;
        O00000o o00000o;
        int i12;
        prepareChildren();
        ensurePreDrawListener();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int O0000Oo0 = cb.O0000Oo0(this);
        boolean z = O0000Oo0 == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i13 = paddingLeft + paddingRight;
        int i14 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.mLastInsets != null && cb.O0000ooo(this);
        int size3 = this.mDependencySortedChildren.size();
        int i15 = suggestedMinimumWidth;
        int i16 = suggestedMinimumHeight;
        int i17 = 0;
        int i18 = 0;
        while (i18 < size3) {
            View view = this.mDependencySortedChildren.get(i18);
            if (view.getVisibility() != 8) {
                O00000o o00000o2 = (O00000o) view.getLayoutParams();
                if (o00000o2.O00000oO < 0 || mode == 0) {
                    i6 = i16;
                } else {
                    int keyline = getKeyline(o00000o2.O00000oO);
                    int O000000o2 = bk.O000000o(resolveKeylineGravity(o00000o2.O00000o0), O0000Oo0) & 7;
                    i6 = i16;
                    if ((O000000o2 == 3 && !z) || (O000000o2 == 5 && z)) {
                        i7 = Math.max(0, (size - paddingRight) - keyline);
                        if (z2) {
                        }
                        i9 = i;
                        i8 = i2;
                        behavior = o00000o2.f2811O000000o;
                        if (behavior != null) {
                        }
                        onMeasureChild(view, i9, i7, i8, 0);
                        O00000o o00000o3 = o00000o;
                        int max = Math.max(i10, i13 + view.getMeasuredWidth() + o00000o3.leftMargin + o00000o3.rightMargin);
                        i5 = Math.max(i12, i14 + view.getMeasuredHeight() + o00000o3.topMargin + o00000o3.bottomMargin);
                        i15 = max;
                        i17 = View.combineMeasuredStates(i11, view.getMeasuredState());
                    } else if ((O000000o2 == 5 && !z) || (O000000o2 == 3 && z)) {
                        i7 = Math.max(0, keyline - paddingLeft);
                        if (z2 || cb.O0000ooo(view)) {
                            i9 = i;
                            i8 = i2;
                        } else {
                            i9 = View.MeasureSpec.makeMeasureSpec(size - (this.mLastInsets.O00000Oo.O0000O0o().O00000Oo + this.mLastInsets.O00000Oo.O0000O0o().O00000o), mode);
                            i8 = View.MeasureSpec.makeMeasureSpec(size2 - (this.mLastInsets.O00000Oo.O0000O0o().O00000o0 + this.mLastInsets.O00000Oo.O0000O0o().O00000oO), mode2);
                        }
                        behavior = o00000o2.f2811O000000o;
                        if (behavior != null) {
                            o00000o = o00000o2;
                            i12 = i6;
                            i11 = i17;
                            i10 = i15;
                            i4 = i18;
                            i3 = size3;
                        } else {
                            o00000o = o00000o2;
                            i11 = i17;
                            i10 = i15;
                            i3 = size3;
                            i12 = i6;
                            i4 = i18;
                        }
                        onMeasureChild(view, i9, i7, i8, 0);
                        O00000o o00000o32 = o00000o;
                        int max2 = Math.max(i10, i13 + view.getMeasuredWidth() + o00000o32.leftMargin + o00000o32.rightMargin);
                        i5 = Math.max(i12, i14 + view.getMeasuredHeight() + o00000o32.topMargin + o00000o32.bottomMargin);
                        i15 = max2;
                        i17 = View.combineMeasuredStates(i11, view.getMeasuredState());
                    }
                }
                i7 = 0;
                if (z2) {
                }
                i9 = i;
                i8 = i2;
                behavior = o00000o2.f2811O000000o;
                if (behavior != null) {
                }
                onMeasureChild(view, i9, i7, i8, 0);
                O00000o o00000o322 = o00000o;
                int max22 = Math.max(i10, i13 + view.getMeasuredWidth() + o00000o322.leftMargin + o00000o322.rightMargin);
                i5 = Math.max(i12, i14 + view.getMeasuredHeight() + o00000o322.topMargin + o00000o322.bottomMargin);
                i15 = max22;
                i17 = View.combineMeasuredStates(i11, view.getMeasuredState());
            } else {
                i5 = i16;
                i4 = i18;
                i3 = size3;
            }
            i16 = i5;
            i18 = i4 + 1;
            size3 = i3;
        }
        int i19 = i17;
        setMeasuredDimension(View.resolveSizeAndState(i15, i, -16777216 & i19), View.resolveSizeAndState(i16, i2, i19 << 16));
    }

    public void onLayoutChild(View view, int i) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        if (o00000o.O0000OoO == null && o00000o.O00000oo != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (o00000o.O0000OoO != null) {
            layoutChildWithAnchor(view, o00000o.O0000OoO, i);
        } else if (o00000o.O00000oO >= 0) {
            layoutChildWithKeyline(view, o00000o.O00000oO, i);
        } else {
            layoutChild(view, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behavior;
        int O0000Oo0 = cb.O0000Oo0(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8 && ((behavior = ((O00000o) view.getLayoutParams()).f2811O000000o) == null || !behavior.onLayoutChild(this, view, O0000Oo0))) {
                onLayoutChild(view, O0000Oo0);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            ci ciVar = this.mLastInsets;
            if (ciVar != null) {
                i = ciVar.O00000Oo.O0000O0o().O00000o0;
            } else {
                i = 0;
            }
            if (i > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    /* access modifiers changed from: package-private */
    public void recordLastChildRect(View view, Rect rect) {
        ((O00000o) view.getLayoutParams()).O0000o0O.set(rect);
    }

    /* access modifiers changed from: package-private */
    public void getLastChildRect(View view, Rect rect) {
        rect.set(((O00000o) view.getLayoutParams()).O0000o0O);
    }

    /* access modifiers changed from: package-private */
    public void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, O00000o o00000o, int i2, int i3) {
        int i4;
        int i5;
        int O000000o2 = bk.O000000o(resolveAnchoredChildGravity(o00000o.O00000o0), i);
        int O000000o3 = bk.O000000o(resolveGravity(o00000o.O00000o), i);
        int i6 = O000000o2 & 7;
        int i7 = O000000o2 & 112;
        int i8 = O000000o3 & 7;
        int i9 = O000000o3 & 112;
        if (i8 == 1) {
            i4 = rect.left + (rect.width() / 2);
        } else if (i8 != 5) {
            i4 = rect.left;
        } else {
            i4 = rect.right;
        }
        if (i9 == 16) {
            i5 = rect.top + (rect.height() / 2);
        } else if (i9 != 80) {
            i5 = rect.top;
        } else {
            i5 = rect.bottom;
        }
        if (i6 == 1) {
            i4 -= i2 / 2;
        } else if (i6 != 5) {
            i4 -= i2;
        }
        if (i7 == 16) {
            i5 -= i3 / 2;
        } else if (i7 != 80) {
            i5 -= i3;
        }
        rect2.set(i4, i5, i2 + i4, i3 + i5);
    }

    private void constrainChildRect(O00000o o00000o, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + o00000o.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - o00000o.rightMargin));
        int max2 = Math.max(getPaddingTop() + o00000o.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - o00000o.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    /* access modifiers changed from: package-private */
    public void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, o00000o, measuredWidth, measuredHeight);
        constrainChildRect(o00000o, rect2, measuredWidth, measuredHeight);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        int O000000o2 = bk.O000000o(resolveKeylineGravity(o00000o.O00000o0), i2);
        int i3 = O000000o2 & 7;
        int i4 = O000000o2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        int i5 = 0;
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + o00000o.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - o00000o.rightMargin));
        int max2 = Math.max(getPaddingTop() + o00000o.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - o00000o.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void layoutChild(View view, int i) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + o00000o.leftMargin, getPaddingTop() + o00000o.topMargin, (getWidth() - getPaddingRight()) - o00000o.rightMargin, (getHeight() - getPaddingBottom()) - o00000o.bottomMargin);
        if (this.mLastInsets != null && cb.O0000ooo(this) && !cb.O0000ooo(view)) {
            acquireTempRect.left += this.mLastInsets.O00000Oo.O0000O0o().O00000Oo;
            acquireTempRect.top += this.mLastInsets.O00000Oo.O0000O0o().O00000o0;
            acquireTempRect.right -= this.mLastInsets.O00000Oo.O0000O0o().O00000o;
            acquireTempRect.bottom -= this.mLastInsets.O00000Oo.O0000O0o().O00000oO;
        }
        Rect acquireTempRect2 = acquireTempRect();
        bk.O000000o(resolveGravity(o00000o.O00000o0), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        if (o00000o.f2811O000000o != null) {
            float scrimOpacity = o00000o.f2811O000000o.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(o00000o.f2811O000000o.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: package-private */
    public final void onChildViewsChanged(int i) {
        boolean z;
        int i2 = i;
        int O0000Oo0 = cb.O0000Oo0(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.mDependencySortedChildren.get(i3);
            O00000o o00000o = (O00000o) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (o00000o.O0000Ooo == this.mDependencySortedChildren.get(i4)) {
                        offsetChildToAnchor(view, O0000Oo0);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (o00000o.O0000O0o != 0 && !acquireTempRect2.isEmpty()) {
                    int O000000o2 = bk.O000000o(o00000o.O0000O0o, O0000Oo0);
                    int i5 = O000000o2 & 112;
                    if (i5 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i5 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i6 = O000000o2 & 7;
                    if (i6 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i6 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (o00000o.O0000OOo != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, O0000Oo0);
                }
                if (i2 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i7 = i3 + 1; i7 < size; i7++) {
                    View view2 = this.mDependencySortedChildren.get(i7);
                    O00000o o00000o2 = (O00000o) view2.getLayoutParams();
                    Behavior behavior = o00000o2.f2811O000000o;
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (i2 != 0 || !o00000o2.O0000o0) {
                            if (i2 != 2) {
                                z = behavior.onDependentViewChanged(this, view2, view);
                            } else {
                                behavior.onDependentViewRemoved(this, view2, view);
                                z = true;
                            }
                            if (i2 == 1) {
                                o00000o2.O0000o0 = z;
                            }
                        } else {
                            o00000o2.O0000o0 = false;
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (cb.O000O0oO(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            O00000o o00000o = (O00000o) view.getLayoutParams();
            Behavior behavior = o00000o.f2811O000000o;
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behavior == null || !behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
                acquireTempRect.set(acquireTempRect2);
            } else if (!acquireTempRect2.contains(acquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int O000000o2 = bk.O000000o(o00000o.O0000OOo, i);
            if ((O000000o2 & 48) != 48 || (i3 = (acquireTempRect.top - o00000o.topMargin) - o00000o.O0000Oo) >= rect.top) {
                z = false;
            } else {
                setInsetOffsetY(view, rect.top - i3);
                z = true;
            }
            if ((O000000o2 & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - o00000o.bottomMargin) + o00000o.O0000Oo) < rect.bottom) {
                setInsetOffsetY(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view, 0);
            }
            if ((O000000o2 & 3) != 3 || (i2 = (acquireTempRect.left - o00000o.leftMargin) - o00000o.O0000Oo0) >= rect.left) {
                z2 = false;
            } else {
                setInsetOffsetX(view, rect.left - i2);
                z2 = true;
            }
            if ((O000000o2 & 5) == 5 && (width = ((getWidth() - acquireTempRect.right) - o00000o.rightMargin) + o00000o.O0000Oo0) < rect.right) {
                setInsetOffsetX(view, width - rect.right);
                z2 = true;
            }
            if (!z2) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    private void setInsetOffsetX(View view, int i) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        if (o00000o.O0000Oo0 != i) {
            cb.O0000Oo(view, i - o00000o.O0000Oo0);
            o00000o.O0000Oo0 = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        O00000o o00000o = (O00000o) view.getLayoutParams();
        if (o00000o.O0000Oo != i) {
            cb.O0000Oo0(view, i - o00000o.O0000Oo);
            o00000o.O0000Oo = i;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        List O00000Oo2 = this.mChildDag.O00000Oo(view);
        if (O00000Oo2 != null && !O00000Oo2.isEmpty()) {
            for (int i = 0; i < O00000Oo2.size(); i++) {
                View view2 = (View) O00000Oo2.get(i);
                Behavior behavior = ((O00000o) view2.getLayoutParams()).f2811O000000o;
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public List<View> getDependencies(View view) {
        oOOO000o<View> oooo000o = this.mChildDag;
        int size = oooo000o.O00000Oo.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList O00000o02 = oooo000o.O00000Oo.O00000o0(i);
            if (O00000o02 != null && O00000o02.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(oooo000o.O00000Oo.O00000Oo(i));
            }
        }
        this.mTempDependenciesList.clear();
        if (arrayList != null) {
            this.mTempDependenciesList.addAll(arrayList);
        }
        return this.mTempDependenciesList;
    }

    public List<View> getDependents(View view) {
        List O00000Oo2 = this.mChildDag.O00000Oo(view);
        this.mTempDependenciesList.clear();
        if (O00000Oo2 != null) {
            this.mTempDependenciesList.addAll(O00000Oo2);
        }
        return this.mTempDependenciesList;
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    /* access modifiers changed from: package-private */
    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z == this.mNeedsPreDrawListener) {
            return;
        }
        if (z) {
            addPreDrawListener();
        } else {
            removePreDrawListener();
        }
    }

    private boolean hasDependencies(View view) {
        oOOO000o<View> oooo000o = this.mChildDag;
        int size = oooo000o.O00000Oo.size();
        for (int i = 0; i < size; i++) {
            ArrayList O00000o02 = oooo000o.O00000Oo.O00000o0(i);
            if (O00000o02 != null && O00000o02.contains(view)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new O0000O0o();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    /* access modifiers changed from: package-private */
    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    /* access modifiers changed from: package-private */
    public void offsetChildToAnchor(View view, int i) {
        Behavior behavior;
        View view2 = view;
        O00000o o00000o = (O00000o) view.getLayoutParams();
        if (o00000o.O0000OoO != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(o00000o.O0000OoO, acquireTempRect);
            boolean z = false;
            getChildRect(view2, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i2 = measuredHeight;
            getDesiredAnchoredChildRectWithoutConstraints(view, i, acquireTempRect, acquireTempRect3, o00000o, measuredWidth, measuredHeight);
            if (!(acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top)) {
                z = true;
            }
            constrainChildRect(o00000o, acquireTempRect3, measuredWidth, i2);
            int i3 = acquireTempRect3.left - acquireTempRect2.left;
            int i4 = acquireTempRect3.top - acquireTempRect2.top;
            if (i3 != 0) {
                cb.O0000Oo(view2, i3);
            }
            if (i4 != 0) {
                cb.O0000Oo0(view2, i4);
            }
            if (z && (behavior = o00000o.f2811O000000o) != null) {
                behavior.onDependentViewChanged(this, view2, o00000o.O0000OoO);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left && acquireTempRect.bottom >= acquireTempRect2.top) {
                z = true;
            }
            return z;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    public O00000o generateLayoutParams(AttributeSet attributeSet) {
        return new O00000o(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public O00000o generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof O00000o) {
            return new O00000o((O00000o) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new O00000o((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new O00000o(layoutParams);
    }

    /* access modifiers changed from: protected */
    public O00000o generateDefaultLayoutParams() {
        return new O00000o(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof O00000o) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                O00000o o00000o = (O00000o) childAt.getLayoutParams();
                Behavior behavior = o00000o.f2811O000000o;
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    o00000o.O000000o(i3, onStartNestedScroll);
                    z |= onStartNestedScroll;
                } else {
                    o00000o.O000000o(i3, false);
                }
            }
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        Behavior behavior;
        this.mNestedScrollingParentHelper.O000000o(i, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            O00000o o00000o = (O00000o) childAt.getLayoutParams();
            if (o00000o.O000000o(i2) && (behavior = o00000o.f2811O000000o) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
            }
        }
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.O000000o(i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            O00000o o00000o = (O00000o) childAt.getLayoutParams();
            if (o00000o.O000000o(i)) {
                Behavior behavior = o00000o.f2811O000000o;
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i);
                }
                o00000o.O000000o(i, false);
                o00000o.O0000o0 = false;
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Behavior behavior;
        int i6;
        int i7;
        int childCount = getChildCount();
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                O00000o o00000o = (O00000o) childAt.getLayoutParams();
                if (o00000o.O000000o(i5) && (behavior = o00000o.f2811O000000o) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    if (i3 > 0) {
                        i6 = Math.max(i8, this.mBehaviorConsumed[0]);
                    } else {
                        i6 = Math.min(i8, this.mBehaviorConsumed[0]);
                    }
                    if (i4 > 0) {
                        i7 = Math.max(i9, this.mBehaviorConsumed[1]);
                    } else {
                        i7 = Math.min(i9, this.mBehaviorConsumed[1]);
                    }
                    i8 = i6;
                    i9 = i7;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Behavior behavior;
        int i4;
        int i5;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                O00000o o00000o = (O00000o) childAt.getLayoutParams();
                if (o00000o.O000000o(i3) && (behavior = o00000o.f2811O000000o) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    if (i > 0) {
                        i4 = Math.max(i6, this.mBehaviorConsumed[0]);
                    } else {
                        i4 = Math.min(i6, this.mBehaviorConsumed[0]);
                    }
                    if (i2 > 0) {
                        i5 = Math.max(i7, this.mBehaviorConsumed[1]);
                    } else {
                        i5 = Math.min(i7, this.mBehaviorConsumed[1]);
                    }
                    i6 = i4;
                    i7 = i5;
                    z = true;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                O00000o o00000o = (O00000o) childAt.getLayoutParams();
                if (o00000o.O000000o(0) && (behavior = o00000o.f2811O000000o) != null) {
                    z2 |= behavior.onNestedFling(this, childAt, view, f, f2, z);
                }
            }
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                O00000o o00000o = (O00000o) childAt.getLayoutParams();
                if (o00000o.O000000o(0) && (behavior = o00000o.f2811O000000o) != null) {
                    z |= behavior.onNestedPreFling(this, childAt, view, f, f2);
                }
            }
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.O000000o();
    }

    class O0000O0o implements ViewTreeObserver.OnPreDrawListener {
        O0000O0o() {
        }

        public final boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    static class O0000OOo implements Comparator<View> {
        O0000OOo() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            float O000O0oo = cb.O000O0oo((View) obj);
            float O000O0oo2 = cb.O000O0oo((View) obj2);
            if (O000O0oo > O000O0oo2) {
                return -1;
            }
            return O000O0oo < O000O0oo2 ? 1 : 0;
        }
    }

    public static abstract class Behavior<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public ci onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, ci ciVar) {
            return ciVar;
        }

        public void onAttachedToLayoutParams(O00000o o00000o) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public static void setTag(View view, Object obj) {
            ((O00000o) view.getLayoutParams()).O0000o0o = obj;
        }

        public static Object getTag(View view) {
            return ((O00000o) view.getLayoutParams()).O0000o0o;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    public static class O00000o extends ViewGroup.MarginLayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public Behavior f2811O000000o;
        boolean O00000Oo = false;
        public int O00000o = 0;
        public int O00000o0 = 0;
        public int O00000oO = -1;
        public int O00000oo = -1;
        public int O0000O0o = 0;
        public int O0000OOo = 0;
        int O0000Oo;
        int O0000Oo0;
        View O0000OoO;
        View O0000Ooo;
        private boolean O0000o;
        boolean O0000o0;
        boolean O0000o00;
        final Rect O0000o0O = new Rect();
        Object O0000o0o;
        private boolean O0000oO0;

        public O00000o(int i, int i2) {
            super(i, i2);
        }

        O00000o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842931, R.attr.layout_anchor, R.attr.layout_anchorGravity, R.attr.layout_behavior, R.attr.layout_dodgeInsetEdges, R.attr.layout_insetEdge, R.attr.layout_keyline});
            this.O00000o0 = obtainStyledAttributes.getInteger(0, 0);
            this.O00000oo = obtainStyledAttributes.getResourceId(1, -1);
            this.O00000o = obtainStyledAttributes.getInteger(2, 0);
            this.O00000oO = obtainStyledAttributes.getInteger(6, -1);
            this.O0000O0o = obtainStyledAttributes.getInt(5, 0);
            this.O0000OOo = obtainStyledAttributes.getInt(4, 0);
            this.O00000Oo = obtainStyledAttributes.hasValue(3);
            if (this.O00000Oo) {
                this.f2811O000000o = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(3));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f2811O000000o;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public O00000o(O00000o o00000o) {
            super((ViewGroup.MarginLayoutParams) o00000o);
        }

        public O00000o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public O00000o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void O000000o(Behavior behavior) {
            Behavior behavior2 = this.f2811O000000o;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.f2811O000000o = behavior;
                this.O0000o0o = null;
                this.O00000Oo = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, boolean z) {
            if (i == 0) {
                this.O0000o = z;
            } else if (i == 1) {
                this.O0000oO0 = z;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(int i) {
            if (i == 0) {
                return this.O0000o;
            }
            if (i != 1) {
                return false;
            }
            return this.O0000oO0;
        }
    }

    class O00000o0 implements ViewGroup.OnHierarchyChangeListener {
        O00000o0() {
        }

        public final void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f2814O000000o;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).f2811O000000o;
            if (!(id == -1 || behavior == null || (parcelable2 = sparseArray.get(id)) == null)) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((O00000o) childAt.getLayoutParams()).f2811O000000o;
            if (!(id == -1 || behavior == null || (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) == null)) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.f2814O000000o = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((O00000o) view.getLayoutParams()).f2811O000000o;
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (cb.O0000ooo(this)) {
                if (this.mApplyWindowInsetsListener == null) {
                    this.mApplyWindowInsetsListener = new bw() {
                        /* class androidx.coordinatorlayout.widget.CoordinatorLayout.AnonymousClass1 */

                        public final ci onApplyWindowInsets(View view, ci ciVar) {
                            return CoordinatorLayout.this.setWindowInsets(ciVar);
                        }
                    };
                }
                cb.O000000o(this, this.mApplyWindowInsetsListener);
                setSystemUiVisibility(1280);
                return;
            }
            cb.O000000o(this, (bw) null);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.AnonymousClass1 */

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
        SparseArray<Parcelable> f2814O000000o;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2814O000000o = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f2814O000000o.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f2814O000000o;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f2814O000000o.keyAt(i2);
                parcelableArr[i2] = this.f2814O000000o.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    private ci dispatchApplyWindowInsetsToBehaviors(ci ciVar) {
        Behavior behavior;
        if (ciVar.O00000Oo.O00000Oo()) {
            return ciVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (cb.O0000ooo(childAt) && (behavior = ((O00000o) childAt.getLayoutParams()).f2811O000000o) != null) {
                ciVar = behavior.onApplyWindowInsets(this, childAt, ciVar);
                if (ciVar.O00000Oo.O00000Oo()) {
                    break;
                }
            }
        }
        return ciVar;
    }
}
