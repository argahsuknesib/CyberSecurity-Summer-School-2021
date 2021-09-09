package androidx.viewpager.widget;

import _m_j.bh;
import _m_j.bw;
import _m_j.cb;
import _m_j.ci;
import _m_j.cl;
import _m_j.jz;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
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
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final Comparator<O00000Oo> COMPARATOR = new Comparator<O00000Oo>() {
        /* class androidx.viewpager.widget.ViewPager.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((O00000Oo) obj).O00000Oo - ((O00000Oo) obj2).O00000Oo;
        }
    };
    static final int[] LAYOUT_ATTRS = {16842931};
    protected static final Interpolator sInterpolator = new Interpolator() {
        /* class androidx.viewpager.widget.ViewPager.AnonymousClass2 */

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final O0000o00 sPositionComparator = new O0000o00();
    private int mActivePointerId = -1;
    jz mAdapter;
    private List<O00000o> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        /* class androidx.viewpager.widget.ViewPager.AnonymousClass3 */

        public final void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    };
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    public boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private O0000O0o mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<O00000Oo> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private O0000Oo0 mObserver;
    private int mOffscreenPageLimit = 1;
    private O0000O0o mOnPageChangeListener;
    private List<O0000O0o> mOnPageChangeListeners;
    private int mPageMargin;
    private O0000OOo mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    public Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final O00000Oo mTempItem = new O00000Oo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface O000000o {
    }

    public interface O00000o {
        void onAdapterChanged(ViewPager viewPager, jz jzVar, jz jzVar2);
    }

    public interface O0000O0o {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public interface O0000OOo {
        void transformPage(View view, float f);
    }

    public static class O0000Oo implements O0000O0o {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        Object f3035O000000o;
        int O00000Oo;
        float O00000o;
        boolean O00000o0;
        float O00000oO;

        O00000Oo() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [androidx.viewpager.widget.ViewPager, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    /* access modifiers changed from: package-private */
    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        cb.O000000o(this, new O00000o0());
        if (cb.O0000O0o(this) == 0) {
            cb.O00000oO((View) this, 1);
        }
        cb.O000000o(this, new bw() {
            /* class androidx.viewpager.widget.ViewPager.AnonymousClass4 */
            private final Rect O00000Oo = new Rect();

            public final ci onApplyWindowInsets(View view, ci ciVar) {
                ci O000000o2 = cb.O000000o(view, ciVar);
                if (O000000o2.O00000Oo.O00000Oo()) {
                    return O000000o2;
                }
                Rect rect = this.O00000Oo;
                rect.left = O000000o2.O000000o();
                rect.top = O000000o2.O00000Oo();
                rect.right = O000000o2.O00000o0();
                rect.bottom = O000000o2.O00000o();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ci O00000Oo2 = cb.O00000Oo(ViewPager.this.getChildAt(i), O000000o2);
                    rect.left = Math.min(O00000Oo2.O000000o(), rect.left);
                    rect.top = Math.min(O00000Oo2.O00000Oo(), rect.top);
                    rect.right = Math.min(O00000Oo2.O00000o0(), rect.right);
                    rect.bottom = Math.min(O00000Oo2.O00000o(), rect.bottom);
                }
                return O000000o2.O000000o(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [androidx.viewpager.widget.ViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void */
    public void setAdapter(jz jzVar) {
        jz jzVar2 = this.mAdapter;
        if (jzVar2 != null) {
            jzVar2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                O00000Oo o00000Oo = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, o00000Oo.O00000Oo, o00000Oo.f3035O000000o);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        jz jzVar3 = this.mAdapter;
        this.mAdapter = jzVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new O0000Oo0();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<O00000o> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mAdapterChangeListeners.get(i2).onAdapterChanged(this, jzVar3, jzVar);
            }
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f3034O000000o) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public jz getAdapter() {
        return this.mAdapter;
    }

    public void addOnAdapterChangeListener(O00000o o00000o) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(o00000o);
    }

    public void removeOnAdapterChangeListener(O00000o o00000o) {
        List<O00000o> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(o00000o);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        jz jzVar = this.mAdapter;
        if (jzVar == null || jzVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            boolean z3 = true;
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            int i4 = this.mCurItem;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                    this.mItems.get(i5).O00000o0 = true;
                }
            }
            if (this.mCurItem == i) {
                z3 = false;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3) {
                    dispatchOnPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        O00000Oo infoForPosition = infoForPosition(i);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.O00000oO, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(O0000O0o o0000O0o) {
        this.mOnPageChangeListener = o0000O0o;
    }

    public void addOnPageChangeListener(O0000O0o o0000O0o) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(o0000O0o);
    }

    public void removeOnPageChangeListener(O0000O0o o0000O0o) {
        List<O0000O0o> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(o0000O0o);
        }
    }

    public void clearOnPageChangeListeners() {
        List<O0000O0o> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setPageTransformer(boolean z, O0000OOo o0000OOo) {
        setPageTransformer(z, o0000OOo, 2);
    }

    public void setPageTransformer(boolean z, O0000OOo o0000OOo, int i) {
        int i2 = 1;
        boolean z2 = o0000OOo != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = o0000OOo;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.mDrawingOrder = i2;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).O00000oo;
    }

    /* access modifiers changed from: package-private */
    public O0000O0o setInternalPageChangeListener(O0000O0o o0000O0o) {
        O0000O0o o0000O0o2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = o0000O0o;
        return o0000O0o2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat.O000000o(getContext(), i));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i, int i2, int i3) {
        int i4;
        int i5;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            i4 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i4 = getScrollX();
        }
        int i6 = i4;
        int scrollY = getScrollY();
        int i7 = i - i6;
        int i8 = i2 - scrollY;
        if (i7 == 0 && i8 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i9 = clientWidth / 2;
        float f = (float) clientWidth;
        float f2 = (float) i9;
        float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i7)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i7)) / ((f * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i5, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i6, scrollY, i7, i8, min);
        cb.O00000oo(this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.instantiateItem(android.view.ViewGroup, int):java.lang.Object
     arg types: [androidx.viewpager.widget.ViewPager, int]
     candidates:
      _m_j.jz.instantiateItem(android.view.View, int):java.lang.Object
      _m_j.jz.instantiateItem(android.view.ViewGroup, int):java.lang.Object */
    /* access modifiers changed from: package-private */
    public O00000Oo addNewItem(int i, int i2) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.O00000Oo = i;
        o00000Oo.f3035O000000o = this.mAdapter.instantiateItem((ViewGroup) this, i);
        o00000Oo.O00000o = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(o00000Oo);
        } else {
            this.mItems.add(i2, o00000Oo);
        }
        return o00000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [androidx.viewpager.widget.ViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void */
    /* access modifiers changed from: package-private */
    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i = this.mCurItem;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mItems.size()) {
            O00000Oo o00000Oo = this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(o00000Oo.f3035O000000o);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, o00000Oo.O00000Oo, o00000Oo.f3035O000000o);
                    if (this.mCurItem == o00000Oo.O00000Oo) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                    }
                } else if (o00000Oo.O00000Oo != itemPosition) {
                    if (o00000Oo.O00000Oo == this.mCurItem) {
                        i = itemPosition;
                    }
                    o00000Oo.O00000Oo = itemPosition;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.f3034O000000o) {
                    layoutParams.O00000o0 = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void populate() {
        populate(this.mCurItem);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [androidx.viewpager.widget.ViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.setPrimaryItem(android.view.ViewGroup, int, java.lang.Object):void
     arg types: [androidx.viewpager.widget.ViewPager, int, java.lang.Object]
     candidates:
      _m_j.jz.setPrimaryItem(android.view.View, int, java.lang.Object):void
      _m_j.jz.setPrimaryItem(android.view.ViewGroup, int, java.lang.Object):void */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (r8.O00000Oo == r0.mCurItem) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r8 = null;
     */
    public void populate(int i) {
        O00000Oo o00000Oo;
        String str;
        O00000Oo o00000Oo2;
        O00000Oo infoForChild;
        float f;
        float f2;
        O00000Oo o00000Oo3;
        int i2 = i;
        int i3 = this.mCurItem;
        if (i3 != i2) {
            o00000Oo = infoForPosition(i3);
            this.mCurItem = i2;
        } else {
            o00000Oo = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int i4 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i4);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, this.mCurItem + i4);
            if (count == this.mExpectedAdapterCount) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.mItems.size()) {
                        break;
                    }
                    o00000Oo2 = this.mItems.get(i5);
                    if (o00000Oo2.O00000Oo < this.mCurItem) {
                        i5++;
                    }
                }
                if (o00000Oo2 == null && count > 0) {
                    o00000Oo2 = addNewItem(this.mCurItem, i5);
                }
                if (o00000Oo2 != null) {
                    int i6 = i5 - 1;
                    O00000Oo o00000Oo4 = i6 >= 0 ? this.mItems.get(i6) : null;
                    int clientWidth = getClientWidth();
                    if (clientWidth <= 0) {
                        f = 0.0f;
                    } else {
                        f = (2.0f - o00000Oo2.O00000o) + (((float) getPaddingLeft()) / ((float) clientWidth));
                    }
                    int i7 = i6;
                    int i8 = i5;
                    float f3 = 0.0f;
                    for (int i9 = this.mCurItem - 1; i9 >= 0; i9--) {
                        if (f3 >= f && i9 < max) {
                            if (o00000Oo4 == null) {
                                break;
                            }
                            if (i9 == o00000Oo4.O00000Oo && !o00000Oo4.O00000o0) {
                                this.mItems.remove(i7);
                                this.mAdapter.destroyItem((ViewGroup) this, i9, o00000Oo4.f3035O000000o);
                                i7--;
                                i8--;
                                if (i7 >= 0) {
                                    o00000Oo3 = this.mItems.get(i7);
                                    o00000Oo4 = o00000Oo3;
                                }
                            }
                        } else if (o00000Oo4 == null || i9 != o00000Oo4.O00000Oo) {
                            f3 += addNewItem(i9, i7 + 1).O00000o;
                            i8++;
                            if (i7 >= 0) {
                                o00000Oo3 = this.mItems.get(i7);
                                o00000Oo4 = o00000Oo3;
                            }
                        } else {
                            f3 += o00000Oo4.O00000o;
                            i7--;
                            if (i7 >= 0) {
                                o00000Oo3 = this.mItems.get(i7);
                                o00000Oo4 = o00000Oo3;
                            }
                        }
                        o00000Oo3 = null;
                        o00000Oo4 = o00000Oo3;
                    }
                    float f4 = o00000Oo2.O00000o;
                    int i10 = i8 + 1;
                    if (f4 < 2.0f) {
                        O00000Oo o00000Oo5 = i10 < this.mItems.size() ? this.mItems.get(i10) : null;
                        if (clientWidth <= 0) {
                            f2 = 0.0f;
                        } else {
                            f2 = (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                        }
                        int i11 = this.mCurItem;
                        while (true) {
                            i11++;
                            if (i11 >= count) {
                                break;
                            }
                            if (f4 >= f2 && i11 > min) {
                                if (o00000Oo5 == null) {
                                    break;
                                } else if (i11 == o00000Oo5.O00000Oo && !o00000Oo5.O00000o0) {
                                    this.mItems.remove(i10);
                                    this.mAdapter.destroyItem((ViewGroup) this, i11, o00000Oo5.f3035O000000o);
                                    if (i10 < this.mItems.size()) {
                                        o00000Oo5 = this.mItems.get(i10);
                                    }
                                }
                            } else if (o00000Oo5 == null || i11 != o00000Oo5.O00000Oo) {
                                O00000Oo addNewItem = addNewItem(i11, i10);
                                i10++;
                                f4 += addNewItem.O00000o;
                                if (i10 < this.mItems.size()) {
                                    o00000Oo5 = this.mItems.get(i10);
                                }
                            } else {
                                f4 += o00000Oo5.O00000o;
                                i10++;
                                if (i10 < this.mItems.size()) {
                                    o00000Oo5 = this.mItems.get(i10);
                                }
                            }
                            o00000Oo5 = null;
                        }
                    }
                    calculatePageOffsets(o00000Oo2, i8, o00000Oo);
                    this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, o00000Oo2.f3035O000000o);
                }
                this.mAdapter.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.O00000oo = i12;
                    if (!layoutParams.f3034O000000o && layoutParams.O00000o0 == 0.0f && (infoForChild = infoForChild(childAt)) != null) {
                        layoutParams.O00000o0 = infoForChild.O00000o;
                        layoutParams.O00000oO = infoForChild.O00000Oo;
                    }
                }
                sortChildDrawingOrder();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    O00000Oo infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                    if (infoForAnyChild == null || infoForAnyChild.O00000Oo != this.mCurItem) {
                        int i13 = 0;
                        while (i13 < getChildCount()) {
                            View childAt2 = getChildAt(i13);
                            O00000Oo infoForChild2 = infoForChild(childAt2);
                            if (infoForChild2 == null || infoForChild2.O00000Oo != this.mCurItem || !childAt2.requestFocus(2)) {
                                i13++;
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
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    private void calculatePageOffsets(O00000Oo o00000Oo, int i, O00000Oo o00000Oo2) {
        O00000Oo o00000Oo3;
        O00000Oo o00000Oo4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (o00000Oo2 != null) {
            int i2 = o00000Oo2.O00000Oo;
            if (i2 < o00000Oo.O00000Oo) {
                float f2 = o00000Oo2.O00000oO + o00000Oo2.O00000o + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= o00000Oo.O00000Oo && i4 < this.mItems.size()) {
                    O00000Oo o00000Oo5 = this.mItems.get(i4);
                    while (true) {
                        o00000Oo4 = o00000Oo5;
                        if (i3 > o00000Oo4.O00000Oo && i4 < this.mItems.size() - 1) {
                            i4++;
                            o00000Oo5 = this.mItems.get(i4);
                        }
                    }
                    while (i3 < o00000Oo4.O00000Oo) {
                        f2 += this.mAdapter.getPageWidth(i3) + f;
                        i3++;
                    }
                    o00000Oo4.O00000oO = f2;
                    f2 += o00000Oo4.O00000o + f;
                    i3++;
                }
            } else if (i2 > o00000Oo.O00000Oo) {
                int size = this.mItems.size() - 1;
                float f3 = o00000Oo2.O00000oO;
                while (true) {
                    i2--;
                    if (i2 < o00000Oo.O00000Oo || size < 0) {
                        break;
                    }
                    O00000Oo o00000Oo6 = this.mItems.get(size);
                    while (true) {
                        o00000Oo3 = o00000Oo6;
                        if (i2 < o00000Oo3.O00000Oo && size > 0) {
                            size--;
                            o00000Oo6 = this.mItems.get(size);
                        }
                    }
                    while (i2 > o00000Oo3.O00000Oo) {
                        f3 -= this.mAdapter.getPageWidth(i2) + f;
                        i2--;
                    }
                    f3 -= o00000Oo3.O00000o + f;
                    o00000Oo3.O00000oO = f3;
                }
            }
        }
        int size2 = this.mItems.size();
        float f4 = o00000Oo.O00000oO;
        int i5 = o00000Oo.O00000Oo - 1;
        this.mFirstOffset = o00000Oo.O00000Oo == 0 ? o00000Oo.O00000oO : -3.4028235E38f;
        int i6 = count - 1;
        this.mLastOffset = o00000Oo.O00000Oo == i6 ? (o00000Oo.O00000oO + o00000Oo.O00000o) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            O00000Oo o00000Oo7 = this.mItems.get(i7);
            while (i5 > o00000Oo7.O00000Oo) {
                f4 -= this.mAdapter.getPageWidth(i5) + f;
                i5--;
            }
            f4 -= o00000Oo7.O00000o + f;
            o00000Oo7.O00000oO = f4;
            if (o00000Oo7.O00000Oo == 0) {
                this.mFirstOffset = f4;
            }
            i7--;
            i5--;
        }
        float f5 = o00000Oo.O00000oO + o00000Oo.O00000o + f;
        int i8 = o00000Oo.O00000Oo + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            O00000Oo o00000Oo8 = this.mItems.get(i9);
            while (i8 < o00000Oo8.O00000Oo) {
                f5 += this.mAdapter.getPageWidth(i8) + f;
                i8++;
            }
            if (o00000Oo8.O00000Oo == i6) {
                this.mLastOffset = (o00000Oo8.O00000o + f5) - 1.0f;
            }
            o00000Oo8.O00000oO = f5;
            f5 += o00000Oo8.O00000o + f;
            i9++;
            i8++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.viewpager.widget.ViewPager.SavedState.AnonymousClass1 */

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
        int f3038O000000o;
        Parcelable O00000Oo;
        ClassLoader O00000o0;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3038O000000o);
            parcel.writeParcelable(this.O00000Oo, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3038O000000o + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f3038O000000o = parcel.readInt();
            this.O00000Oo = parcel.readParcelable(classLoader);
            this.O00000o0 = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3038O000000o = this.mCurItem;
        jz jzVar = this.mAdapter;
        if (jzVar != null) {
            savedState.O00000Oo = jzVar.saveState();
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
        jz jzVar = this.mAdapter;
        if (jzVar != null) {
            jzVar.restoreState(savedState.O00000Oo, savedState.O00000o0);
            setCurrentItemInternal(savedState.f3038O000000o, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.f3038O000000o;
        this.mRestoredAdapterState = savedState.O00000Oo;
        this.mRestoredClassLoader = savedState.O00000o0;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.f3034O000000o |= isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams);
        } else if (layoutParams2 == null || !layoutParams2.f3034O000000o) {
            layoutParams2.O00000o = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(O000000o.class) != null;
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public O00000Oo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            O00000Oo o00000Oo = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, o00000Oo.f3035O000000o)) {
                return o00000Oo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public O00000Oo infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public O00000Oo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            O00000Oo o00000Oo = this.mItems.get(i2);
            if (o00000Oo.O00000Oo == i) {
                return o00000Oo;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb  */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = measuredHeight;
        int i7 = paddingLeft;
        int i8 = 0;
        while (true) {
            boolean z = true;
            int i9 = 1073741824;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.f3034O000000o)) {
                int i10 = layoutParams2.O00000Oo & 7;
                int i11 = layoutParams2.O00000Oo & 112;
                boolean z2 = i11 == 48 || i11 == 80;
                if (!(i10 == 3 || i10 == 5)) {
                    z = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z2) {
                    i12 = 1073741824;
                } else if (z) {
                    i3 = 1073741824;
                    if (layoutParams2.width == -2) {
                        i4 = layoutParams2.width != -1 ? layoutParams2.width : i7;
                        i12 = 1073741824;
                    } else {
                        i4 = i7;
                    }
                    if (layoutParams2.height == -2) {
                        i5 = layoutParams2.height != -1 ? layoutParams2.height : i6;
                    } else {
                        i5 = i6;
                        i9 = i3;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i12), View.MeasureSpec.makeMeasureSpec(i5, i9));
                    if (!z2) {
                        i6 -= childAt.getMeasuredHeight();
                    } else if (z) {
                        i7 -= childAt.getMeasuredWidth();
                    }
                }
                i3 = Integer.MIN_VALUE;
                if (layoutParams2.width == -2) {
                }
                if (layoutParams2.height == -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i12), View.MeasureSpec.makeMeasureSpec(i5, i9));
                if (!z2) {
                }
            }
            i8++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f3034O000000o)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) i7) * layoutParams.O00000o0), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.mPageMargin;
            recomputeScrollPosition(i, i3, i5, i5);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            O00000Oo infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.O00000oO, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3))), getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        O00000Oo infoForChild;
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = paddingBottom;
        int i10 = 0;
        int i11 = paddingTop;
        int i12 = paddingLeft;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3034O000000o) {
                    int i14 = layoutParams.O00000Oo & 7;
                    int i15 = layoutParams.O00000Oo & 112;
                    if (i14 == 1) {
                        i5 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, i12);
                    } else if (i14 == 3) {
                        i5 = i12;
                        i12 = childAt.getMeasuredWidth() + i12;
                    } else if (i14 != 5) {
                        i5 = i12;
                    } else {
                        i5 = (i7 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i15 == 16) {
                        i6 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, i11);
                    } else if (i15 == 48) {
                        i6 = i11;
                        i11 = childAt.getMeasuredHeight() + i11;
                    } else if (i15 != 80) {
                        i6 = i11;
                    } else {
                        i6 = (i8 - i9) - childAt.getMeasuredHeight();
                        i9 += childAt.getMeasuredHeight();
                    }
                    int i16 = i5 + scrollX;
                    childAt.layout(i16, i6, childAt.getMeasuredWidth() + i16, i6 + childAt.getMeasuredHeight());
                    i10++;
                }
            }
        }
        int i17 = (i7 - i12) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f3034O000000o && (infoForChild = infoForChild(childAt2)) != null) {
                    float f = (float) i17;
                    int i19 = ((int) (infoForChild.O00000oO * f)) + i12;
                    if (layoutParams2.O00000o) {
                        layoutParams2.O00000o = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.O00000o0), 1073741824), View.MeasureSpec.makeMeasureSpec((i8 - i11) - i9, 1073741824));
                    }
                    childAt2.layout(i19, i11, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + i11);
                }
            }
        }
        this.mTopPageBounds = i11;
        this.mBottomPageBounds = i8 - i9;
        this.mDecorChildCount = i10;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        cb.O00000oo(this);
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            O00000Oo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin;
            int i3 = clientWidth + i2;
            float f = (float) clientWidth;
            int i4 = infoForCurrentScrollPosition.O00000Oo;
            float f2 = ((((float) i) / f) - infoForCurrentScrollPosition.O00000oO) / (infoForCurrentScrollPosition.O00000o + (((float) i2) / f));
            this.mCalledSuper = false;
            onPageScrolled(i4, f2, (int) (((float) i3) * f2));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    public void onPageScrolled(int i, float f, int i2) {
        int i3;
        int left;
        int i4;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = paddingRight;
            int i6 = paddingLeft;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3034O000000o) {
                    int i8 = layoutParams.O00000Oo & 7;
                    if (i8 != 1) {
                        if (i8 == 3) {
                            i3 = childAt.getWidth() + i6;
                        } else if (i8 != 5) {
                            i3 = i6;
                        } else {
                            i4 = (width - i5) - childAt.getMeasuredWidth();
                            i5 += childAt.getMeasuredWidth();
                        }
                        left = (i6 + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        i6 = i3;
                    } else {
                        i4 = Math.max((width - childAt.getMeasuredWidth()) / 2, i6);
                    }
                    int i9 = i4;
                    i3 = i6;
                    i6 = i9;
                    left = (i6 + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    i6 = i3;
                }
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt2 = getChildAt(i10);
                if (!((LayoutParams) childAt2.getLayoutParams()).f3034O000000o) {
                    this.mPageTransformer.transformPage(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        O0000O0o o0000O0o = this.mOnPageChangeListener;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i, f, i2);
        }
        List<O0000O0o> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                O0000O0o o0000O0o2 = this.mOnPageChangeListeners.get(i3);
                if (o0000O0o2 != null) {
                    o0000O0o2.onPageScrolled(i, f, i2);
                }
            }
        }
        O0000O0o o0000O0o3 = this.mInternalPageChangeListener;
        if (o0000O0o3 != null) {
            o0000O0o3.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        O0000O0o o0000O0o = this.mOnPageChangeListener;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(i);
        }
        List<O0000O0o> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                O0000O0o o0000O0o2 = this.mOnPageChangeListeners.get(i2);
                if (o0000O0o2 != null) {
                    o0000O0o2.onPageSelected(i);
                }
            }
        }
        O0000O0o o0000O0o3 = this.mInternalPageChangeListener;
        if (o0000O0o3 != null) {
            o0000O0o3.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        O0000O0o o0000O0o = this.mOnPageChangeListener;
        if (o0000O0o != null) {
            o0000O0o.onPageScrollStateChanged(i);
        }
        List<O0000O0o> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                O0000O0o o0000O0o2 = this.mOnPageChangeListeners.get(i2);
                if (o0000O0o2 != null) {
                    o0000O0o2.onPageScrollStateChanged(i);
                }
            }
        }
        O0000O0o o0000O0o3 = this.mInternalPageChangeListener;
        if (o0000O0o3 != null) {
            o0000O0o3.onPageScrollStateChanged(i);
        }
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i = 0; i < this.mItems.size(); i++) {
            O00000Oo o00000Oo = this.mItems.get(i);
            if (o00000Oo.O00000o0) {
                o00000Oo.O00000o0 = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            cb.O000000o(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private boolean isGutterDrag(float f, float f2) {
        if (f >= ((float) this.mGutterSize) || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f;
        }
        return true;
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent2.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.mActivePointerId;
            if (i != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i);
                float x2 = motionEvent2.getX(findPointerIndex);
                float f = x2 - this.mLastMotionX;
                float abs = Math.abs(f);
                float y2 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                if (f == 0.0f || isGutterDrag(this.mLastMotionX, f) || !canScroll(this, false, (int) f, (int) x2, (int) y2)) {
                    if (abs > ((float) this.mTouchSlop) && abs * 0.5f > abs2) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        this.mLastMotionX = f > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                        this.mLastMotionY = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.mTouchSlop)) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged && performDrag(x2)) {
                        cb.O00000oo(this);
                    }
                } else {
                    this.mLastMotionX = x2;
                    this.mLastMotionY = y2;
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        jz jzVar;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (jzVar = this.mAdapter) == null || jzVar.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z = resetTouch();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.mLastMotionX);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.mLastMotionY);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f = this.mInitialMotionX;
                            this.mLastMotionX = x2 - f > 0.0f ? f + ((float) this.mTouchSlop) : f - ((float) this.mTouchSlop);
                            this.mLastMotionY = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                z = resetTouch();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            O00000Oo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            float f2 = (float) clientWidth;
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.O00000Oo, ((((float) scrollX) / f2) - infoForCurrentScrollPosition.O00000oO) / (infoForCurrentScrollPosition.O00000o + (((float) this.mPageMargin) / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            z = resetTouch();
        }
        if (z) {
            cb.O00000oo(this);
        }
        return true;
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        boolean z2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f2;
        float clientWidth = (float) getClientWidth();
        float f3 = this.mFirstOffset * clientWidth;
        float f4 = this.mLastOffset * clientWidth;
        boolean z3 = false;
        O00000Oo o00000Oo = this.mItems.get(0);
        ArrayList<O00000Oo> arrayList = this.mItems;
        O00000Oo o00000Oo2 = arrayList.get(arrayList.size() - 1);
        if (o00000Oo.O00000Oo != 0) {
            f3 = o00000Oo.O00000oO * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (o00000Oo2.O00000Oo != this.mAdapter.getCount() - 1) {
            f4 = o00000Oo2.O00000oO * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.mLastMotionX += scrollX - ((float) i);
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z3;
    }

    private O00000Oo infoForCurrentScrollPosition() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        O00000Oo o00000Oo = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.mItems.size()) {
            O00000Oo o00000Oo2 = this.mItems.get(i2);
            if (!z && o00000Oo2.O00000Oo != (i = i3 + 1)) {
                o00000Oo2 = this.mTempItem;
                o00000Oo2.O00000oO = f2 + f3 + f;
                o00000Oo2.O00000Oo = i;
                o00000Oo2.O00000o = this.mAdapter.getPageWidth(o00000Oo2.O00000Oo);
                i2--;
            }
            f2 = o00000Oo2.O00000oO;
            float f4 = o00000Oo2.O00000o + f2 + f;
            if (!z && scrollX < f2) {
                return o00000Oo;
            }
            if (scrollX < f4 || i2 == this.mItems.size() - 1) {
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

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) (f + (i >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        ArrayList<O00000Oo> arrayList = this.mItems;
        return Math.max(this.mItems.get(0).O00000Oo, Math.min(i, arrayList.get(arrayList.size() - 1).O00000Oo));
    }

    public void draw(Canvas canvas) {
        jz jzVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (jzVar = this.mAdapter) != null && jzVar.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
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
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.mPageMargin) / f4;
            int i = 0;
            O00000Oo o00000Oo = this.mItems.get(0);
            float f6 = o00000Oo.O00000oO;
            int size = this.mItems.size();
            int i2 = o00000Oo.O00000Oo;
            int i3 = this.mItems.get(size - 1).O00000Oo;
            while (i2 < i3) {
                while (i2 > o00000Oo.O00000Oo && i < size) {
                    i++;
                    o00000Oo = this.mItems.get(i);
                }
                if (i2 == o00000Oo.O00000Oo) {
                    f2 = (o00000Oo.O00000oO + o00000Oo.O00000o) * f4;
                    f = o00000Oo.O00000oO + o00000Oo.O00000o + f5;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i2);
                    f = f6 + pageWidth + f5;
                    f2 = (f6 + pageWidth) * f4;
                }
                if (((float) this.mPageMargin) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.mMarginDrawable.setBounds(Math.round(f2), this.mTopPageBounds, Math.round(((float) this.mPageMargin) + f2), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                } else {
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i2++;
                    f6 = f;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                O00000Oo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.O00000Oo, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.O00000oO) / infoForCurrentScrollPosition.O00000o, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            float clientWidth = (float) getClientWidth();
            float f2 = this.mFirstOffset * clientWidth;
            float f3 = this.mLastOffset * clientWidth;
            O00000Oo o00000Oo = this.mItems.get(0);
            ArrayList<O00000Oo> arrayList = this.mItems;
            O00000Oo o00000Oo2 = arrayList.get(arrayList.size() - 1);
            if (o00000Oo.O00000Oo != 0) {
                f2 = o00000Oo.O00000oO * clientWidth;
            }
            if (o00000Oo2.O00000Oo != this.mAdapter.getCount() - 1) {
                f3 = o00000Oo2.O00000oO * clientWidth;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            pageScrolled(i);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
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
                    if (canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i)) {
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return pageRight();
                } else {
                    return arrowScroll(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return pageLeft();
            } else {
                return arrowScroll(17);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b9, code lost:
        if (r7 != 2) goto L_0x00c4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c6  */
    public boolean arrowScroll(int i) {
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
            if (i == 17) {
                z2 = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left < getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageLeft();
            } else if (i == 66) {
                int i2 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                int i3 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view == null || i2 > i3) {
                    z2 = findNextFocus.requestFocus();
                }
            }
            if (z2) {
            }
            return z2;
        } else if (i == 17 || i == 1) {
            z2 = pageLeft();
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z2;
        } else if (i != 66) {
        }
        z2 = pageRight();
        if (z2) {
        }
        return z2;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
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

    /* access modifiers changed from: package-private */
    public boolean pageLeft() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageRight() {
        jz jzVar = this.mAdapter;
        if (jzVar == null || this.mCurItem >= jzVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        O00000Oo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.O00000Oo == this.mCurItem) {
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
        O00000Oo infoForChild;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.O00000Oo == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        O00000Oo infoForChild;
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
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.O00000Oo == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i3 += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        O00000Oo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.O00000Oo == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

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
            accessibilityEvent.setScrollable(O000000o());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
                accessibilityEvent.setItemCount(ViewPager.this.mAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            clVar.O00000Oo((CharSequence) ViewPager.class.getName());
            clVar.O0000OoO(O000000o());
            if (ViewPager.this.canScrollHorizontally(1)) {
                clVar.O000000o(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                clVar.O000000o(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
                return true;
            }
        }

        private boolean O000000o() {
            return ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.getCount() > 1;
        }
    }

    class O0000Oo0 extends DataSetObserver {
        O0000Oo0() {
        }

        public final void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public final void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f3034O000000o;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.O00000Oo = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class O0000o00 implements Comparator<View> {
        O0000o00() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.f3034O000000o != layoutParams2.f3034O000000o) {
                return layoutParams.f3034O000000o ? 1 : -1;
            }
            return layoutParams.O00000oO - layoutParams2.O00000oO;
        }
    }
}
