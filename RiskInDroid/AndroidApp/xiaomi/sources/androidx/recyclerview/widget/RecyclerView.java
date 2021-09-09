package androidx.recyclerview.widget;

import _m_j.as;
import _m_j.bf;
import _m_j.bh;
import _m_j.bp;
import _m_j.bq;
import _m_j.br;
import _m_j.bz;
import _m_j.cb;
import _m_j.cc;
import _m_j.ck;
import _m_j.cl;
import _m_j.gk;
import _m_j.gn;
import _m_j.go;
import _m_j.gq;
import _m_j.gr;
import _m_j.hb;
import _m_j.hf;
import _m_j.hg;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements bp, bq, bz {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (Build.VERSION.SDK_INT >= 23);
    static final boolean ALLOW_THREAD_GAP_WORK = (Build.VERSION.SDK_INT >= 21);
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = (Build.VERSION.SDK_INT <= 15);
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = (Build.VERSION.SDK_INT <= 15);
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    static final boolean POST_UPDATES_ON_ANIMATION = (Build.VERSION.SDK_INT >= 16);
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass3 */

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    hb mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    public O000000o mAdapter;
    public gk mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private O00000o mChildDrawingOrderCallback;
    public gn mChildHelper;
    boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private O0000O0o mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    gr mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private O0000o mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    O0000OOo mItemAnimator;
    private O0000OOo.O000000o mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<O0000Oo> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    public LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final O000O0o mObserver;
    private List<O0000o00> mOnChildAttachStateListeners;
    private O0000o0 mOnFlingListener;
    private final ArrayList<O0000o> mOnItemTouchListeners;
    final List<O000OOo0> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    public gr.O000000o mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    public final O000O0OO mRecycler;
    O000O0o0 mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private O00oOooO mScrollListener;
    private List<O00oOooO> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private br mScrollingChildHelper;
    public final O000OO0o mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final O000OOOo mViewFlinger;
    private final hg.O00000Oo mViewInfoProcessCallback;
    final hg mViewInfoStore;

    public interface O00000o {
        int O000000o(int i, int i2);
    }

    public interface O0000o {
        void O000000o(boolean z);

        boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent);

        void O00000Oo(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class O0000o0 {
        public abstract boolean O000000o(int i, int i2);
    }

    public interface O0000o00 {
        void O000000o(View view);

        void O00000Oo(View view);
    }

    public interface O000O0o0 {
        void O000000o(O000OOo0 o000OOo0);
    }

    public static abstract class O000OO {
        public abstract View O000000o();
    }

    public static abstract class O00oOooO {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        this.mObserver = new O000O0o();
        this.mRecycler = new O000O0OO();
        this.mViewInfoStore = new hg();
        this.mUpdateChildViewsRunnable = new Runnable() {
            /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass1 */

            public final void run() {
                if (RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.mLayoutSuppressed) {
                        RecyclerView.this.mLayoutWasDefered = true;
                    } else {
                        RecyclerView.this.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new O0000O0o();
        this.mItemAnimator = new go();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new O000OOOo();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new gr.O000000o() : null;
        this.mState = new O000OO0o();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new O0000Oo0();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass2 */

            public final void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.O000000o();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new hg.O00000Oo() {
            /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass4 */

            public final void O000000o(O000OOo0 o000OOo0, O0000OOo.O00000Oo o00000Oo, O0000OOo.O00000Oo o00000Oo2) {
                RecyclerView.this.mRecycler.O00000Oo(o000OOo0);
                RecyclerView.this.animateDisappearance(o000OOo0, o00000Oo, o00000Oo2);
            }

            public final void O00000Oo(O000OOo0 o000OOo0, O0000OOo.O00000Oo o00000Oo, O0000OOo.O00000Oo o00000Oo2) {
                RecyclerView.this.animateAppearance(o000OOo0, o00000Oo, o00000Oo2);
            }

            public final void O00000o0(O000OOo0 o000OOo0, O0000OOo.O00000Oo o00000Oo, O0000OOo.O00000Oo o00000Oo2) {
                o000OOo0.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.O000000o(o000OOo0, o000OOo0, o00000Oo, o00000Oo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.O00000o0(o000OOo0, o00000Oo, o00000Oo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            public final void O000000o(O000OOo0 o000OOo0) {
                RecyclerView.this.mLayout.removeAndRecycleView(o000OOo0.itemView, RecyclerView.this.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = cc.O000000o(viewConfiguration, context2);
        this.mScaledVerticalScrollFactor = cc.O00000Oo(viewConfiguration, context2);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.O0000OOo = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (cb.O0000O0o(this) == 0) {
            cb.O00000oO((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new hb(this));
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, new int[]{16842948, 16842987, 16842993, R.attr.fastScrollEnabled, R.attr.fastScrollHorizontalThumbDrawable, R.attr.fastScrollHorizontalTrackDrawable, R.attr.fastScrollVerticalThumbDrawable, R.attr.fastScrollVerticalTrackDrawable, R.attr.layoutManager, R.attr.reverseLayout, R.attr.spanCount, R.attr.stackFromEnd}, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, new int[]{16842948, 16842987, 16842993, R.attr.fastScrollEnabled, R.attr.fastScrollHorizontalThumbDrawable, R.attr.fastScrollHorizontalTrackDrawable, R.attr.fastScrollVerticalThumbDrawable, R.attr.fastScrollVerticalTrackDrawable, R.attr.layoutManager, R.attr.reverseLayout, R.attr.spanCount, R.attr.stackFromEnd}, attributeSet, obtainStyledAttributes, i, 0);
        }
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(1, true);
        this.mEnableFastScroller = obtainStyledAttributes.getBoolean(3, false);
        if (this.mEnableFastScroller) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(6), obtainStyledAttributes.getDrawable(7), (StateListDrawable) obtainStyledAttributes.getDrawable(4), obtainStyledAttributes.getDrawable(5));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet2, NESTED_SCROLLING_ATTRS, i2, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    /* access modifiers changed from: package-private */
    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o(android.view.View, int):void
     arg types: [androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      _m_j.cb.O00000o(android.view.View, float):void
      _m_j.cb.O00000o(android.view.View, int):void */
    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (cb.O00000Oo(this) == 0) {
            cb.O00000o((View) this, 8);
        }
    }

    public hb getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(hb hbVar) {
        this.mAccessibilityDelegate = hbVar;
        cb.O000000o(this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e3);
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e7);
                }
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new gn(new gn.O00000Oo() {
            /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass5 */

            public final int O000000o() {
                return RecyclerView.this.getChildCount();
            }

            public final void O000000o(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.dispatchChildAttached(view);
            }

            public final int O000000o(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public final void O000000o(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            public final View O00000Oo(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public final O000OOo0 O00000Oo(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            public final void O000000o(View view, int i, ViewGroup.LayoutParams layoutParams) {
                O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public final void O00000o0(int i) {
                O000OOo0 childViewHolderInt;
                View O00000Oo = O00000Oo(i);
                if (!(O00000Oo == null || (childViewHolderInt = RecyclerView.getChildViewHolderInt(O00000Oo)) == null)) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public final void O00000o0(View view) {
                O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public final void O00000o(View view) {
                O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            public final void O00000Oo() {
                int childCount = RecyclerView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View O00000Oo = O00000Oo(i);
                    RecyclerView.this.dispatchChildDetached(O00000Oo);
                    O00000Oo.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initAdapterManager() {
        this.mAdapterHelper = new gk(new gk.O000000o() {
            /* class androidx.recyclerview.widget.RecyclerView.AnonymousClass6 */

            public final O000OOo0 O000000o(int i) {
                O000OOo0 findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.O00000o(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                return null;
            }

            public final void O000000o(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.O00000o0 += i2;
            }

            public final void O00000Oo(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public final void O000000o(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            public final void O000000o(gk.O00000Oo o00000Oo) {
                O00000o0(o00000Oo);
            }

            private void O00000o0(gk.O00000Oo o00000Oo) {
                int i = o00000Oo.f17924O000000o;
                if (i == 1) {
                    RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, o00000Oo.O00000Oo, o00000Oo.O00000o);
                } else if (i == 2) {
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, o00000Oo.O00000Oo, o00000Oo.O00000o);
                } else if (i == 4) {
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, o00000Oo.O00000Oo, o00000Oo.O00000o, o00000Oo.O00000o0);
                } else if (i == 8) {
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, o00000Oo.O00000Oo, o00000Oo.O00000o, 1);
                }
            }

            public final void O00000Oo(gk.O00000Oo o00000Oo) {
                O00000o0(o00000Oo);
            }

            public final void O00000o0(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public final void O00000o(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(O000000o o000000o, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(o000000o, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(O000000o o000000o) {
        setLayoutFrozen(false);
        setAdapterInternal(o000000o, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void removeAndRecycleViews() {
        O0000OOo o0000OOo = this.mItemAnimator;
        if (o0000OOo != null) {
            o0000OOo.O00000o();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.O000000o();
    }

    private void setAdapterInternal(O000000o o000000o, boolean z, boolean z2) {
        O000000o o000000o2 = this.mAdapter;
        if (o000000o2 != null) {
            o000000o2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.O000000o();
        O000000o o000000o3 = this.mAdapter;
        this.mAdapter = o000000o;
        if (o000000o != null) {
            o000000o.registerAdapterDataObserver(this.mObserver);
            o000000o.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(o000000o3, this.mAdapter);
        }
        O000O0OO o000o0oo = this.mRecycler;
        O000000o o000000o4 = this.mAdapter;
        o000o0oo.O000000o();
        O000O00o O00000o2 = o000o0oo.O00000o();
        if (o000000o3 != null) {
            O00000o2.O00000o0();
        }
        if (!z && O00000o2.O00000Oo == 0) {
            O00000o2.O000000o();
        }
        if (o000000o4 != null) {
            O00000o2.O00000Oo();
        }
        this.mState.O00000oo = true;
    }

    public O000000o getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(O000O0o0 o000O0o0) {
        this.mRecyclerListener = o000O0o0;
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(O0000o00 o0000o00) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(o0000o00);
    }

    public void removeOnChildAttachStateChangeListener(O0000o00 o0000o00) {
        List<O0000o00> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(o0000o00);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<O0000o00> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                O0000OOo o0000OOo = this.mItemAnimator;
                if (o0000OOo != null) {
                    o0000OOo.O00000o();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.O000000o();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
                this.mLayout = null;
            } else {
                this.mRecycler.O000000o();
            }
            gn gnVar = this.mChildHelper;
            gn.O000000o o000000o = gnVar.O00000Oo;
            while (true) {
                o000000o.f18034O000000o = 0;
                if (o000000o.O00000Oo == null) {
                    break;
                }
                o000000o = o000000o.O00000Oo;
            }
            for (int size = gnVar.O00000o0.size() - 1; size >= 0; size--) {
                gnVar.f18033O000000o.O00000o(gnVar.O00000o0.get(size));
                gnVar.O00000o0.remove(size);
            }
            gnVar.f18033O000000o.O00000Oo();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView == null) {
                    this.mLayout.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
                }
            }
            this.mRecycler.O00000Oo();
            requestLayout();
        }
    }

    public void setOnFlingListener(O0000o0 o0000o0) {
        this.mOnFlingListener = o0000o0;
    }

    public O0000o0 getOnFlingListener() {
        return this.mOnFlingListener;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.f2953O000000o = savedState2.f2953O000000o;
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.f2953O000000o = layoutManager.onSaveInstanceState();
            } else {
                savedState.f2953O000000o = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        if (this.mLayout != null && this.mPendingSavedState.f2953O000000o != null) {
            this.mLayout.onRestoreInstanceState(this.mPendingSavedState.f2953O000000o);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(O000OOo0 o000OOo0) {
        View view = o000OOo0.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.O00000Oo(getChildViewHolder(view));
        if (o000OOo0.isTmpDetached()) {
            this.mChildHelper.O000000o(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.O000000o(view, -1, true);
        } else {
            gn gnVar = this.mChildHelper;
            int O000000o2 = gnVar.f18033O000000o.O000000o(view);
            if (O000000o2 >= 0) {
                gnVar.O00000Oo.O000000o(O000000o2);
                gnVar.O000000o(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        gn gnVar = this.mChildHelper;
        int O000000o2 = gnVar.f18033O000000o.O000000o(view);
        boolean z = true;
        if (O000000o2 == -1) {
            gnVar.O00000Oo(view);
        } else if (gnVar.O00000Oo.O00000o0(O000000o2)) {
            gnVar.O00000Oo.O00000o(O000000o2);
            gnVar.O00000Oo(view);
            gnVar.f18033O000000o.O000000o(O000000o2);
        } else {
            z = false;
        }
        if (z) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.O00000Oo(childViewHolderInt);
            this.mRecycler.O000000o(childViewHolderInt);
        }
        stopInterceptRequestLayout(!z);
        return z;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public O000O00o getRecycledViewPool() {
        return this.mRecycler.O00000o();
    }

    public void setRecycledViewPool(O000O00o o000O00o) {
        O000O0OO o000o0oo = this.mRecycler;
        if (o000o0oo.O0000O0o != null) {
            o000o0oo.O0000O0o.O00000o0();
        }
        o000o0oo.O0000O0o = o000O00o;
        if (o000o0oo.O0000O0o != null && RecyclerView.this.getAdapter() != null) {
            o000o0oo.O0000O0o.O00000Oo();
        }
    }

    public void setViewCacheExtension(O000OO o000oo) {
        this.mRecycler.O0000OOo = o000oo;
    }

    public void setItemViewCacheSize(int i) {
        O000O0OO o000o0oo = this.mRecycler;
        o000o0oo.O00000oO = i;
        o000o0oo.O00000Oo();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void addItemDecoration(O0000Oo o0000Oo, int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(o0000Oo);
        } else {
            this.mItemDecorations.add(i, o0000Oo);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(O0000Oo o0000Oo) {
        addItemDecoration(o0000Oo, -1);
    }

    public O0000Oo getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeItemDecoration(O0000Oo o0000Oo) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(o0000Oo);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(O00000o o00000o) {
        if (o00000o != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = o00000o;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(O00oOooO o00oOooO) {
        this.mScrollListener = o00oOooO;
    }

    public void addOnScrollListener(O00oOooO o00oOooO) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(o00oOooO);
    }

    public void removeOnScrollListener(O00oOooO o00oOooO) {
        List<O00oOooO> list = this.mScrollListeners;
        if (list != null) {
            list.remove(o00oOooO);
        }
    }

    public void clearOnScrollListeners() {
        List<O00oOooO> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.smoothScrollToPosition(this, this.mState, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        as.O000000o("RV Scroll");
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        as.O000000o();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    /* access modifiers changed from: package-private */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            as.O000000o("RV FullInvalidate");
            dispatchLayout();
            as.O000000o();
        } else if (this.mAdapterHelper.O00000o()) {
            if (this.mAdapterHelper.O000000o(4) && !this.mAdapterHelper.O000000o(11)) {
                as.O000000o("RV PartialInvalidate");
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.O00000Oo();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.O00000o0();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                as.O000000o();
            } else if (this.mAdapterHelper.O00000o()) {
                as.O000000o("RV FullInvalidate");
                dispatchLayout();
                as.O000000o();
            }
        }
    }

    private boolean hasUpdatedView() {
        int O000000o2 = this.mChildHelper.O000000o();
        for (int i = 0; i < O000000o2; i++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000Oo(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i7, i8, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i5 = i10;
            i6 = i9;
            i4 = i7 - i9;
            i3 = i8 - i10;
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i11 = i6;
        dispatchNestedScroll(i6, i5, i4, i3, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i12 = i4 - iArr4[0];
        int i13 = i3 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i14 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i14 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    pullGlows(motionEvent.getX(), (float) i12, motionEvent.getY(), (float) i13);
                }
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        int i15 = i11;
        if (!(i15 == 0 && i5 == 0)) {
            dispatchOnScrolled(i15, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i15 == 0 && i5 == 0) ? false : true;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth <= 0) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i4 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                if (i3 == Integer.MIN_VALUE || i3 > 0) {
                    if (z) {
                        if (i != 0) {
                            i4 = 1;
                        }
                        if (i2 != 0) {
                            i4 |= 2;
                        }
                        startNestedScroll(i4, 1);
                    }
                    this.mViewFlinger.O000000o(i, i2, i3, interpolator);
                    return;
                }
                scrollBy(i, i2);
            }
        }
    }

    public boolean fling(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            int i3 = (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) ? 0 : i;
            int i4 = (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : i2;
            if (i3 == 0 && i4 == 0) {
                return false;
            }
            float f = (float) i3;
            float f2 = (float) i4;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f, f2, z);
                O0000o0 o0000o0 = this.mOnFlingListener;
                if (o0000o0 != null && o0000o0.O000000o(i3, i4)) {
                    return true;
                }
                if (z) {
                    if (canScrollVertically) {
                        canScrollHorizontally |= true;
                    }
                    startNestedScroll(canScrollHorizontally ? 1 : 0, 1);
                    int i5 = this.mMaxFlingVelocity;
                    int max = Math.max(-i5, Math.min(i3, i5));
                    int i6 = this.mMaxFlingVelocity;
                    int max2 = Math.max(-i6, Math.min(i4, i6));
                    O000OOOo o000OOOo = this.mViewFlinger;
                    RecyclerView.this.setScrollState(2);
                    o000OOOo.O00000Oo = 0;
                    o000OOOo.f2952O000000o = 0;
                    Interpolator interpolator = o000OOOo.O00000o;
                    Interpolator interpolator2 = sQuinticInterpolator;
                    if (interpolator != interpolator2) {
                        o000OOOo.O00000o = interpolator2;
                        o000OOOo.O00000o0 = new OverScroller(RecyclerView.this.getContext(), sQuinticInterpolator);
                    }
                    o000OOOo.O00000o0.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    o000OOOo.O000000o();
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.O00000Oo();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    private void pullGlows(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 < 0.0f) {
            ensureLeftGlow();
            EdgeEffectCompat.O000000o(this.mLeftGlow, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
        } else if (f2 > 0.0f) {
            ensureRightGlow();
            EdgeEffectCompat.O000000o(this.mRightGlow, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
        } else {
            z = false;
            if (f4 >= 0.0f) {
                ensureTopGlow();
                EdgeEffectCompat.O000000o(this.mTopGlow, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
            } else if (f4 > 0.0f) {
                ensureBottomGlow();
                EdgeEffectCompat.O000000o(this.mBottomGlow, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
            } else {
                z2 = z;
            }
            if (!z2 || f2 != 0.0f || f4 != 0.0f) {
                cb.O00000oo(this);
            }
            return;
        }
        z = true;
        if (f4 >= 0.0f) {
        }
        if (!z2) {
        }
        cb.O00000oo(this);
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            cb.O00000oo(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            cb.O00000oo(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i != 0 || i2 != 0) {
            cb.O00000oo(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = O0000O0o.O000000o(this);
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = O0000O0o.O000000o(this);
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = O0000O0o.O000000o(this);
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = O0000O0o.O000000o(this);
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(O0000O0o o0000O0o) {
        bf.O000000o(o0000O0o);
        this.mEdgeEffectFactory = o0000O0o;
        invalidateGlows();
    }

    public O0000O0o getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z2 || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || !z2) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                int i2 = i == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                z = instance.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (isPreferredNextFocus(view, view2, i)) {
                return view2;
            }
            return super.focusSearch(view, i);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            requestChildOnScreen(view2, null);
            return view;
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i3 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i2 = 1;
        } else {
            i2 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c = 0;
        }
        if (i == 1) {
            return c < 0 || (c == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return c > 0 || (c == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return c < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return c > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    public void onAttachedToWindow() {
        float f;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z = false;
        }
        this.mFirstLayoutComplete = z;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            this.mGapWorker = gr.f18171O000000o.get();
            if (this.mGapWorker == null) {
                this.mGapWorker = new gr();
                Display O000OOOo2 = cb.O000OOOo(this);
                if (!isInEditMode() && O000OOOo2 != null) {
                    f = O000OOOo2.getRefreshRate();
                }
                f = 60.0f;
                this.mGapWorker.O00000o = (long) (1.0E9f / f);
                gr.f18171O000000o.set(this.mGapWorker);
            }
            this.mGapWorker.O00000Oo.add(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        gr grVar;
        super.onDetachedFromWindow();
        O0000OOo o0000OOo = this.mItemAnimator;
        if (o0000OOo != null) {
            o0000OOo.O00000o();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        hg.O000000o.O00000Oo();
        if (ALLOW_THREAD_GAP_WORK && (grVar = this.mGapWorker) != null) {
            grVar.O00000Oo.remove(this);
            this.mGapWorker = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    /* access modifiers changed from: package-private */
    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(O0000o o0000o) {
        this.mOnItemTouchListeners.add(o0000o);
    }

    public void removeOnItemTouchListener(O0000o o0000o) {
        this.mOnItemTouchListeners.remove(o0000o);
        if (this.mInterceptingOnItemTouchListener == o0000o) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        O0000o o0000o = this.mInterceptingOnItemTouchListener;
        if (o0000o != null) {
            o0000o.O00000Oo(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            O0000o o0000o = this.mOnItemTouchListeners.get(i);
            if (!o0000o.O000000o(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mInterceptingOnItemTouchListener = o0000o;
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i = x2 - this.mInitialTouchX;
                int i2 = y2 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i2) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).O000000o(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f5  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = motionEvent;
        boolean z2 = false;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.mScrollPointerId = motionEvent2.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.addMovement(obtain);
            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
            float f = canScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
            float f2 = canScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
            if ((f == 0.0f && f2 == 0.0f) || !fling((int) f, (int) f2)) {
                setScrollState(0);
            }
            resetScroll();
            z2 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent2.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent2.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent2.getY(findPointerIndex) + 0.5f);
            int i = this.mLastTouchX - x2;
            int i2 = this.mLastTouchY - y2;
            if (this.mScrollState != 1) {
                if (canScrollHorizontally) {
                    if (i > 0) {
                        i = Math.max(0, i - this.mTouchSlop);
                    } else {
                        i = Math.min(0, i + this.mTouchSlop);
                    }
                    if (i != 0) {
                        z = true;
                        if (canScrollVertically) {
                            if (i2 > 0) {
                                i2 = Math.max(0, i2 - this.mTouchSlop);
                            } else {
                                i2 = Math.min(0, i2 + this.mTouchSlop);
                            }
                            if (i2 != 0) {
                                z = true;
                            }
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                }
                z = false;
                if (canScrollVertically) {
                }
                if (z) {
                }
            }
            int i3 = i;
            int i4 = i2;
            if (this.mScrollState == 1) {
                int[] iArr3 = this.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (dispatchNestedPreScroll(canScrollHorizontally ? i3 : 0, canScrollVertically ? i4 : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                    int[] iArr4 = this.mReusableIntPair;
                    i3 -= iArr4[0];
                    i4 -= iArr4[1];
                    int[] iArr5 = this.mNestedOffsets;
                    int i5 = iArr5[0];
                    int[] iArr6 = this.mScrollOffset;
                    iArr5[0] = i5 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i6 = i4;
                int[] iArr7 = this.mScrollOffset;
                this.mLastTouchX = x2 - iArr7[0];
                this.mLastTouchY = y2 - iArr7[1];
                if (scrollByInternal(canScrollHorizontally ? i3 : 0, canScrollVertically ? i6 : 0, motionEvent2)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (!(this.mGapWorker == null || (i3 == 0 && i6 == 0))) {
                    this.mGapWorker.O000000o(this, i3, i6);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent2.getPointerId(actionIndex);
            int x3 = (int) (motionEvent2.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent2.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (!z2) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    f = motionEvent.getAxisValue(10);
                    if (!(f2 == 0.0f && f == 0.0f)) {
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f2 = -axisValue;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f = axisValue;
                        f2 = 0.0f;
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f2 = 0.0f;
            }
            f = 0.0f;
            scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.mAdapter != null) {
                if (this.mState.O00000o == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i, i2);
                this.mState.O0000Oo0 = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.O0000Oo0 = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.O0000OoO) {
                    this.mState.O0000O0o = true;
                } else {
                    this.mAdapterHelper.O00000oO();
                    this.mState.O0000O0o = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.O0000OoO) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            O000000o o000000o = this.mAdapter;
            if (o000000o != null) {
                this.mState.O00000oO = o000000o.getItemCount();
            } else {
                this.mState.O00000oO = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.O0000O0o = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), cb.O0000o0O(this)), LayoutManager.chooseSize(i2, getPaddingTop() + getPaddingBottom(), cb.O0000o0o(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(O0000OOo o0000OOo) {
        O0000OOo o0000OOo2 = this.mItemAnimator;
        if (o0000OOo2 != null) {
            o0000OOo2.O00000o();
            this.mItemAnimator.O0000OOo = null;
        }
        this.mItemAnimator = o0000OOo;
        O0000OOo o0000OOo3 = this.mItemAnimator;
        if (o0000OOo3 != null) {
            o0000OOo3.O0000OOo = this.mItemAnimatorListener;
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter <= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            ck.O000000o(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent == null || Build.VERSION.SDK_INT < 19) {
            i = 0;
        } else {
            i = accessibilityEvent.getContentChangeTypes();
        }
        if (i == 0) {
            i = 0;
        }
        this.mEatenAccessibilityChangeFlags = i | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public O0000OOo getItemAnimator() {
        return this.mItemAnimator;
    }

    /* access modifiers changed from: package-private */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            cb.O000000o(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.O000000o();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.O00000Oo();
        } else {
            this.mAdapterHelper.O00000oO();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.O0000Oo = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        O000OO0o o000OO0o = this.mState;
        if (o000OO0o.O0000Oo && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        o000OO0o.O0000OoO = z;
    }

    /* access modifiers changed from: package-private */
    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            O000OO0o o000OO0o = this.mState;
            boolean z = false;
            o000OO0o.O0000Oo0 = false;
            if (o000OO0o.O00000o == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                gk gkVar = this.mAdapterHelper;
                if (!gkVar.O00000Oo.isEmpty() && !gkVar.f17923O000000o.isEmpty()) {
                    z = true;
                }
                if (!z && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                } else {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                    dispatchLayoutStep2();
                }
            }
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        int i;
        O000OOo0 o000OOo0 = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            o000OOo0 = findContainingViewHolder(focusedChild);
        }
        if (o000OOo0 == null) {
            resetFocusInfo();
            return;
        }
        this.mState.O0000o00 = this.mAdapter.hasStableIds() ? o000OOo0.getItemId() : -1;
        O000OO0o o000OO0o = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i = -1;
        } else if (o000OOo0.isRemoved()) {
            i = o000OOo0.mOldPosition;
        } else {
            i = o000OOo0.getAdapterPosition();
        }
        o000OO0o.O0000Ooo = i;
        this.mState.O0000o0 = getDeepestFocusedViewWithId(o000OOo0.itemView);
    }

    private void resetFocusInfo() {
        O000OO0o o000OO0o = this.mState;
        o000OO0o.O0000o00 = -1;
        o000OO0o.O0000Ooo = -1;
        o000OO0o.O0000o0 = -1;
    }

    private View findNextViewToFocus() {
        O000OOo0 findViewHolderForAdapterPosition;
        int i = this.mState.O0000Ooo != -1 ? this.mState.O0000Ooo : 0;
        int O000000o2 = this.mState.O000000o();
        int i2 = i;
        while (i2 < O000000o2) {
            O000OOo0 findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i2++;
            }
        }
        int min = Math.min(O000000o2, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    private void recoverFocusFromState() {
        View view;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.O00000o(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.O000000o() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                O000OOo0 findViewHolderForItemId = (this.mState.O0000o00 == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.O0000o00);
                if (findViewHolderForItemId != null && !this.mChildHelper.O00000o(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view2 = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.O000000o() > 0) {
                    view2 = findNextViewToFocus();
                }
                if (view2 != null) {
                    if (((long) this.mState.O0000o0) == -1 || (view = view2.findViewById(this.mState.O0000o0)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* access modifiers changed from: package-private */
    public final void fillRemainingScrollValues(O000OO0o o000OO0o) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.O00000o0;
            o000OO0o.O0000o0O = overScroller.getFinalX() - overScroller.getCurrX();
            o000OO0o.O0000o0o = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        o000OO0o.O0000o0O = 0;
        o000OO0o.O0000o0o = 0;
    }

    private void dispatchLayoutStep1() {
        this.mState.O000000o(1);
        fillRemainingScrollValues(this.mState);
        this.mState.O0000Oo0 = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.O000000o();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        O000OO0o o000OO0o = this.mState;
        o000OO0o.O0000OOo = o000OO0o.O0000Oo && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        O000OO0o o000OO0o2 = this.mState;
        o000OO0o2.O0000O0o = o000OO0o2.O0000OoO;
        this.mState.O00000oO = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.O0000Oo) {
            int O000000o2 = this.mChildHelper.O000000o();
            for (int i = 0; i < O000000o2; i++) {
                O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000Oo(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    O0000OOo.O00000oO(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    this.mViewInfoStore.O000000o(childViewHolderInt, new O0000OOo.O00000Oo().O000000o(childViewHolderInt));
                    if (this.mState.O0000OOo && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.O000000o(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.O0000OoO) {
            saveOldPositions();
            boolean z = this.mState.O00000oo;
            O000OO0o o000OO0o3 = this.mState;
            o000OO0o3.O00000oo = false;
            this.mLayout.onLayoutChildren(this.mRecycler, o000OO0o3);
            this.mState.O00000oo = z;
            for (int i2 = 0; i2 < this.mChildHelper.O000000o(); i2++) {
                O000OOo0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.O00000Oo(i2));
                if (!childViewHolderInt2.shouldIgnore()) {
                    hg.O000000o o000000o = this.mViewInfoStore.f18890O000000o.get(childViewHolderInt2);
                    if (!((o000000o == null || (o000000o.f18891O000000o & 4) == 0) ? false : true)) {
                        O0000OOo.O00000oO(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                        childViewHolderInt2.getUnmodifiedPayloads();
                        O0000OOo.O00000Oo O000000o3 = new O0000OOo.O00000Oo().O000000o(childViewHolderInt2);
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, O000000o3);
                        } else {
                            hg hgVar = this.mViewInfoStore;
                            hg.O000000o o000000o2 = hgVar.f18890O000000o.get(childViewHolderInt2);
                            if (o000000o2 == null) {
                                o000000o2 = hg.O000000o.O000000o();
                                hgVar.f18890O000000o.put(childViewHolderInt2, o000000o2);
                            }
                            o000000o2.f18891O000000o |= 2;
                            o000000o2.O00000Oo = O000000o3;
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.O00000o = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.O000000o(6);
        this.mAdapterHelper.O00000oO();
        this.mState.O00000oO = this.mAdapter.getItemCount();
        O000OO0o o000OO0o = this.mState;
        o000OO0o.O00000o0 = 0;
        o000OO0o.O0000O0o = false;
        this.mLayout.onLayoutChildren(this.mRecycler, o000OO0o);
        O000OO0o o000OO0o2 = this.mState;
        o000OO0o2.O00000oo = false;
        this.mPendingSavedState = null;
        o000OO0o2.O0000Oo = o000OO0o2.O0000Oo && this.mItemAnimator != null;
        this.mState.O00000o = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.O000000o(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        O000OO0o o000OO0o = this.mState;
        o000OO0o.O00000o = 1;
        if (o000OO0o.O0000Oo) {
            for (int O000000o2 = this.mChildHelper.O000000o() - 1; O000000o2 >= 0; O000000o2--) {
                O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000Oo(O000000o2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    O0000OOo.O00000Oo O000000o3 = new O0000OOo.O00000Oo().O000000o(childViewHolderInt);
                    O000OOo0 O000000o4 = this.mViewInfoStore.O00000Oo.O000000o(changedHolderKey, null);
                    if (O000000o4 != null && !O000000o4.shouldIgnore()) {
                        boolean O000000o5 = this.mViewInfoStore.O000000o(O000000o4);
                        boolean O000000o6 = this.mViewInfoStore.O000000o(childViewHolderInt);
                        if (!O000000o5 || O000000o4 != childViewHolderInt) {
                            O0000OOo.O00000Oo O000000o7 = this.mViewInfoStore.O000000o(O000000o4, 4);
                            this.mViewInfoStore.O00000Oo(childViewHolderInt, O000000o3);
                            O0000OOo.O00000Oo O000000o8 = this.mViewInfoStore.O000000o(childViewHolderInt, 8);
                            if (O000000o7 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, O000000o4);
                            } else {
                                animateChange(O000000o4, childViewHolderInt, O000000o7, O000000o8, O000000o5, O000000o6);
                            }
                        }
                    }
                    this.mViewInfoStore.O00000Oo(childViewHolderInt, O000000o3);
                }
            }
            hg hgVar = this.mViewInfoStore;
            hg.O00000Oo o00000Oo = this.mViewInfoProcessCallback;
            for (int size = hgVar.f18890O000000o.size() - 1; size >= 0; size--) {
                O000OOo0 O00000Oo2 = hgVar.f18890O000000o.O00000Oo(size);
                hg.O000000o O00000o2 = hgVar.f18890O000000o.O00000o(size);
                if ((O00000o2.f18891O000000o & 3) == 3) {
                    o00000Oo.O000000o(O00000Oo2);
                } else if ((O00000o2.f18891O000000o & 1) != 0) {
                    if (O00000o2.O00000Oo == null) {
                        o00000Oo.O000000o(O00000Oo2);
                    } else {
                        o00000Oo.O000000o(O00000Oo2, O00000o2.O00000Oo, O00000o2.O00000o0);
                    }
                } else if ((O00000o2.f18891O000000o & 14) == 14) {
                    o00000Oo.O00000Oo(O00000Oo2, O00000o2.O00000Oo, O00000o2.O00000o0);
                } else if ((O00000o2.f18891O000000o & 12) == 12) {
                    o00000Oo.O00000o0(O00000Oo2, O00000o2.O00000Oo, O00000o2.O00000o0);
                } else if ((O00000o2.f18891O000000o & 4) != 0) {
                    o00000Oo.O000000o(O00000Oo2, O00000o2.O00000Oo, null);
                } else if ((O00000o2.f18891O000000o & 8) != 0) {
                    o00000Oo.O00000Oo(O00000Oo2, O00000o2.O00000Oo, O00000o2.O00000o0);
                }
                hg.O000000o.O000000o(O00000o2);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        O000OO0o o000OO0o2 = this.mState;
        o000OO0o2.O00000Oo = o000OO0o2.O00000oO;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        O000OO0o o000OO0o3 = this.mState;
        o000OO0o3.O0000Oo = false;
        o000OO0o3.O0000OoO = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.O00000Oo != null) {
            this.mRecycler.O00000Oo.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            LayoutManager layoutManager = this.mLayout;
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.O00000Oo();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.O000000o();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j, O000OOo0 o000OOo0, O000OOo0 o000OOo02) {
        int O000000o2 = this.mChildHelper.O000000o();
        int i = 0;
        while (i < O000000o2) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000Oo(i));
            if (childViewHolderInt == o000OOo0 || getChangedHolderKey(childViewHolderInt) != j) {
                i++;
            } else {
                O000000o o000000o = this.mAdapter;
                if (o000000o == null || !o000000o.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + o000OOo0 + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + o000OOo0 + exceptionLabel());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + o000OOo02 + " cannot be found but it is necessary for " + o000OOo0 + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void recordAnimationInfoIfBouncedHiddenView(O000OOo0 o000OOo0, O0000OOo.O00000Oo o00000Oo) {
        o000OOo0.setFlags(0, 8192);
        if (this.mState.O0000OOo && o000OOo0.isUpdated() && !o000OOo0.isRemoved() && !o000OOo0.shouldIgnore()) {
            this.mViewInfoStore.O000000o(getChangedHolderKey(o000OOo0), o000OOo0);
        }
        this.mViewInfoStore.O000000o(o000OOo0, o00000Oo);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int O000000o2 = this.mChildHelper.O000000o();
        if (O000000o2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < O000000o2; i3++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000Oo(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        O000OOo0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    /* access modifiers changed from: package-private */
    public long getChangedHolderKey(O000OOo0 o000OOo0) {
        return this.mAdapter.hasStableIds() ? o000OOo0.getItemId() : (long) o000OOo0.mPosition;
    }

    /* access modifiers changed from: package-private */
    public void animateAppearance(O000OOo0 o000OOo0, O0000OOo.O00000Oo o00000Oo, O0000OOo.O00000Oo o00000Oo2) {
        o000OOo0.setIsRecyclable(false);
        if (this.mItemAnimator.O00000Oo(o000OOo0, o00000Oo, o00000Oo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateDisappearance(O000OOo0 o000OOo0, O0000OOo.O00000Oo o00000Oo, O0000OOo.O00000Oo o00000Oo2) {
        addAnimatingView(o000OOo0);
        o000OOo0.setIsRecyclable(false);
        if (this.mItemAnimator.O000000o(o000OOo0, o00000Oo, o00000Oo2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(O000OOo0 o000OOo0, O000OOo0 o000OOo02, O0000OOo.O00000Oo o00000Oo, O0000OOo.O00000Oo o00000Oo2, boolean z, boolean z2) {
        o000OOo0.setIsRecyclable(false);
        if (z) {
            addAnimatingView(o000OOo0);
        }
        if (o000OOo0 != o000OOo02) {
            if (z2) {
                addAnimatingView(o000OOo02);
            }
            o000OOo0.mShadowedHolder = o000OOo02;
            addAnimatingView(o000OOo0);
            this.mRecycler.O00000Oo(o000OOo0);
            o000OOo02.setIsRecyclable(false);
            o000OOo02.mShadowingHolder = o000OOo0;
        }
        if (this.mItemAnimator.O000000o(o000OOo0, o000OOo02, o00000Oo, o00000Oo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        as.O000000o("RV OnLayout");
        dispatchLayout();
        as.O000000o();
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void markItemDecorInsetsDirty() {
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        for (int i = 0; i < O00000Oo2; i++) {
            ((LayoutParams) this.mChildHelper.O00000o0(i).getLayoutParams()).mInsetsDirty = true;
        }
        O000O0OO o000o0oo = this.mRecycler;
        int size = o000o0oo.O00000o0.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutParams layoutParams = (LayoutParams) o000o0oo.O00000o0.get(i2).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.O00000Oo()) {
            z2 = true;
        }
        if (z2) {
            cb.O00000oo(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public boolean isAnimating() {
        O0000OOo o0000OOo = this.mItemAnimator;
        return o0000OOo != null && o0000OOo.O00000Oo();
    }

    /* access modifiers changed from: package-private */
    public void saveOldPositions() {
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        for (int i = 0; i < O00000Oo2; i++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearOldPositions() {
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        for (int i = 0; i < O00000Oo2; i++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        O000O0OO o000o0oo = this.mRecycler;
        int size = o000o0oo.O00000o0.size();
        for (int i2 = 0; i2 < size; i2++) {
            o000o0oo.O00000o0.get(i2).clearOldPosition();
        }
        int size2 = o000o0oo.f2948O000000o.size();
        for (int i3 = 0; i3 < size2; i3++) {
            o000o0oo.f2948O000000o.get(i3).clearOldPosition();
        }
        if (o000o0oo.O00000Oo != null) {
            int size3 = o000o0oo.O00000Oo.size();
            for (int i4 = 0; i4 < size3; i4++) {
                o000o0oo.O00000Oo.get(i4).clearOldPosition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i9 = 0; i9 < O00000Oo2; i9++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i9));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i3, false);
                }
                this.mState.O00000oo = true;
            }
        }
        O000O0OO o000o0oo = this.mRecycler;
        if (i < i2) {
            i8 = i;
            i7 = i2;
            i6 = -1;
        } else {
            i7 = i;
            i8 = i2;
            i6 = 1;
        }
        int size = o000o0oo.O00000o0.size();
        for (int i10 = 0; i10 < size; i10++) {
            O000OOo0 o000OOo0 = o000o0oo.O00000o0.get(i10);
            if (o000OOo0 != null && o000OOo0.mPosition >= i8 && o000OOo0.mPosition <= i7) {
                if (o000OOo0.mPosition == i) {
                    o000OOo0.offsetPosition(i2 - i, false);
                } else {
                    o000OOo0.offsetPosition(i6, false);
                }
            }
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForInsert(int i, int i2) {
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        for (int i3 = 0; i3 < O00000Oo2; i3++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.O00000oo = true;
            }
        }
        O000O0OO o000o0oo = this.mRecycler;
        int size = o000o0oo.O00000o0.size();
        for (int i4 = 0; i4 < size; i4++) {
            O000OOo0 o000OOo0 = o000o0oo.O00000o0.get(i4);
            if (o000OOo0 != null && o000OOo0.mPosition >= i) {
                o000OOo0.offsetPosition(i2, true);
            }
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        for (int i4 = 0; i4 < O00000Oo2; i4++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.O00000oo = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.O00000oo = true;
                }
            }
        }
        O000O0OO o000o0oo = this.mRecycler;
        for (int size = o000o0oo.O00000o0.size() - 1; size >= 0; size--) {
            O000OOo0 o000OOo0 = o000o0oo.O00000o0.get(size);
            if (o000OOo0 != null) {
                if (o000OOo0.mPosition >= i3) {
                    o000OOo0.offsetPosition(-i2, z);
                } else if (o000OOo0.mPosition >= i) {
                    o000OOo0.addFlags(8);
                    o000o0oo.O00000o(size);
                }
            }
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void viewRangeUpdate(int i, int i2, Object obj) {
        int i3;
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        int i4 = i2 + i;
        for (int i5 = 0; i5 < O00000Oo2; i5++) {
            View O00000o02 = this.mChildHelper.O00000o0(i5);
            O000OOo0 childViewHolderInt = getChildViewHolderInt(O00000o02);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i4) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) O00000o02.getLayoutParams()).mInsetsDirty = true;
            }
        }
        O000O0OO o000o0oo = this.mRecycler;
        for (int size = o000o0oo.O00000o0.size() - 1; size >= 0; size--) {
            O000OOo0 o000OOo0 = o000o0oo.O00000o0.get(size);
            if (o000OOo0 != null && (i3 = o000OOo0.mPosition) >= i && i3 < i4) {
                o000OOo0.addFlags(2);
                o000o0oo.O00000o(size);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canReuseUpdatedViewHolder(O000OOo0 o000OOo0) {
        O0000OOo o0000OOo = this.mItemAnimator;
        return o0000OOo == null || o0000OOo.O000000o(o000OOo0, o000OOo0.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: package-private */
    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    /* access modifiers changed from: package-private */
    public void markKnownViewsInvalid() {
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        for (int i = 0; i < O00000Oo2; i++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        O000O0OO o000o0oo = this.mRecycler;
        int size = o000o0oo.O00000o0.size();
        for (int i2 = 0; i2 < size; i2++) {
            O000OOo0 o000OOo0 = o000o0oo.O00000o0.get(i2);
            if (o000OOo0 != null) {
                o000OOo0.addFlags(6);
                o000OOo0.addChangePayload(null);
            }
        }
        if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
            o000o0oo.O00000o0();
        }
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public O000OOo0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public O000OOo0 findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public static O000OOo0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        O000OOo0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        O000OOo0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        O000OOo0 childViewHolderInt;
        O000000o o000000o = this.mAdapter;
        if (o000000o == null || !o000000o.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public O000OOo0 findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public O000OOo0 findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public O000OOo0 findViewHolderForAdapterPosition(int i) {
        O000OOo0 o000OOo0 = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        for (int i2 = 0; i2 < O00000Oo2; i2++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (!this.mChildHelper.O00000o(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                o000OOo0 = childViewHolderInt;
            }
        }
        return o000OOo0;
    }

    /* access modifiers changed from: package-private */
    public O000OOo0 findViewHolderForPosition(int i, boolean z) {
        int O00000Oo2 = this.mChildHelper.O00000Oo();
        O000OOo0 o000OOo0 = null;
        for (int i2 = 0; i2 < O00000Oo2; i2++) {
            O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.mChildHelper.O00000o(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                o000OOo0 = childViewHolderInt;
            }
        }
        return o000OOo0;
    }

    public O000OOo0 findViewHolderForItemId(long j) {
        O000000o o000000o = this.mAdapter;
        O000OOo0 o000OOo0 = null;
        if (o000000o != null && o000000o.hasStableIds()) {
            int O00000Oo2 = this.mChildHelper.O00000Oo();
            for (int i = 0; i < O00000Oo2; i++) {
                O000OOo0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.O00000o0(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (!this.mChildHelper.O00000o(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    o000OOo0 = childViewHolderInt;
                }
            }
        }
        return o000OOo0;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int O000000o2 = this.mChildHelper.O000000o() - 1; O000000o2 >= 0; O000000o2--) {
            View O00000Oo2 = this.mChildHelper.O00000Oo(O000000o2);
            float translationX = O00000Oo2.getTranslationX();
            float translationY = O00000Oo2.getTranslationY();
            if (f >= ((float) O00000Oo2.getLeft()) + translationX && f <= ((float) O00000Oo2.getRight()) + translationX && f2 >= ((float) O00000Oo2.getTop()) + translationY && f2 <= ((float) O00000Oo2.getBottom()) + translationY) {
                return O00000Oo2;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        int O000000o2 = this.mChildHelper.O000000o();
        for (int i2 = 0; i2 < O000000o2; i2++) {
            this.mChildHelper.O00000Oo(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        int O000000o2 = this.mChildHelper.O000000o();
        for (int i2 = 0; i2 < O000000o2; i2++) {
            this.mChildHelper.O00000Oo(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.O0000O0o && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        O00oOooO o00oOooO = this.mScrollListener;
        if (o00oOooO != null) {
            o00oOooO.onScrolled(this, i, i2);
        }
        List<O00oOooO> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrollStateChanged(int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        O00oOooO o00oOooO = this.mScrollListener;
        if (o00oOooO != null) {
            o00oOooO.onScrollStateChanged(this, i);
        }
        List<O00oOooO> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.O00000o();
    }

    class O000OOOo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2952O000000o;
        int O00000Oo;
        Interpolator O00000o = RecyclerView.sQuinticInterpolator;
        OverScroller O00000o0;
        private boolean O00000oo = false;
        private boolean O0000O0o = false;

        O000OOOo() {
            this.O00000o0 = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public final void run() {
            int i;
            int i2;
            if (RecyclerView.this.mLayout == null) {
                O00000Oo();
                return;
            }
            this.O0000O0o = false;
            this.O00000oo = true;
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.O00000o0;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f2952O000000o;
                int i4 = currY - this.O00000Oo;
                this.f2952O000000o = currX;
                this.O00000Oo = currY;
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.dispatchNestedPreScroll(i3, i4, recyclerView.mReusableIntPair, null, 1)) {
                    i3 -= RecyclerView.this.mReusableIntPair[0];
                    i4 -= RecyclerView.this.mReusableIntPair[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.scrollStep(i3, i4, recyclerView2.mReusableIntPair);
                    i2 = RecyclerView.this.mReusableIntPair[0];
                    i = RecyclerView.this.mReusableIntPair[1];
                    i3 -= i2;
                    i4 -= i;
                    O000OO00 o000oo00 = RecyclerView.this.mLayout.mSmoothScroller;
                    if (o000oo00 != null && !o000oo00.isPendingInitialRun() && o000oo00.isRunning()) {
                        int O000000o2 = RecyclerView.this.mState.O000000o();
                        if (O000000o2 == 0) {
                            o000oo00.stop();
                        } else {
                            if (o000oo00.getTargetPosition() >= O000000o2) {
                                o000oo00.setTargetPosition(O000000o2 - 1);
                            }
                            o000oo00.onAnimation(i2, i);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.dispatchNestedScroll(i2, i, i3, i4, null, 1, recyclerView3.mReusableIntPair);
                int i5 = i3 - RecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - RecyclerView.this.mReusableIntPair[1];
                if (!(i2 == 0 && i == 0)) {
                    RecyclerView.this.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                O000OO00 o000oo002 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((o000oo002 != null && o000oo002.isPendingInitialRun()) || !z) {
                    O000000o();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.O000000o(RecyclerView.this, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.O000000o();
                    }
                }
            }
            O000OO00 o000oo003 = RecyclerView.this.mLayout.mSmoothScroller;
            if (o000oo003 != null && o000oo003.isPendingInitialRun()) {
                o000oo003.onAnimation(0, 0);
            }
            this.O00000oo = false;
            if (this.O0000O0o) {
                O00000o0();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            if (this.O00000oo) {
                this.O0000O0o = true;
            } else {
                O00000o0();
            }
        }

        private void O00000o0() {
            RecyclerView.this.removeCallbacks(this);
            cb.O000000o(RecyclerView.this, this);
        }

        public final void O000000o(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = O000000o(i, i2);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.O00000o != interpolator) {
                this.O00000o = interpolator;
                this.O00000o0 = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.O00000Oo = 0;
            this.f2952O000000o = 0;
            RecyclerView.this.setScrollState(2);
            this.O00000o0.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.O00000o0.computeScrollOffset();
            }
            O000000o();
        }

        private static float O000000o(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        private int O000000o(int i, int i2) {
            int i3;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i4 = width / 2;
            float f = (float) width;
            float f2 = (float) i4;
            float O000000o2 = f2 + (O000000o(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i3 = Math.round(Math.abs(O000000o2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i3 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(i3, 2000);
        }

        public final void O00000Oo() {
            RecyclerView.this.removeCallbacks(this);
            this.O00000o0.abortAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    public void repositionShadowingViews() {
        int O000000o2 = this.mChildHelper.O000000o();
        for (int i = 0; i < O000000o2; i++) {
            View O00000Oo2 = this.mChildHelper.O00000Oo(i);
            O000OOo0 childViewHolder = getChildViewHolder(O00000Oo2);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = O00000Oo2.getLeft();
                int top = O00000Oo2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    class O000O0o extends O00000o0 {
        O000O0o() {
        }

        public final void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.O00000oo = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.O00000o()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
            if (r0.f17923O000000o.size() == 1) goto L_0x0026;
         */
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            gk gkVar = RecyclerView.this.mAdapterHelper;
            boolean z = true;
            if (i2 > 0) {
                gkVar.f17923O000000o.add(gkVar.O000000o(4, i, i2, obj));
                gkVar.O0000O0o |= 4;
            }
            z = false;
            if (z) {
                O000000o();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
            if (r0.f17923O000000o.size() == 1) goto L_0x0025;
         */
        public final void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            gk gkVar = RecyclerView.this.mAdapterHelper;
            boolean z = true;
            if (i2 > 0) {
                gkVar.f17923O000000o.add(gkVar.O000000o(1, i, i2, null));
                gkVar.O0000O0o |= 1;
            }
            z = false;
            if (z) {
                O000000o();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
            if (r0.f17923O000000o.size() == 1) goto L_0x0026;
         */
        public final void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            gk gkVar = RecyclerView.this.mAdapterHelper;
            boolean z = true;
            if (i2 > 0) {
                gkVar.f17923O000000o.add(gkVar.O000000o(2, i, i2, null));
                gkVar.O0000O0o |= 2;
            }
            z = false;
            if (z) {
                O000000o();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
            if (r0.f17923O000000o.size() == 1) goto L_0x0031;
         */
        public final void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            gk gkVar = RecyclerView.this.mAdapterHelper;
            boolean z = true;
            if (i != i2) {
                if (i3 == 1) {
                    gkVar.f17923O000000o.add(gkVar.O000000o(8, i, i2, null));
                    gkVar.O0000O0o |= 8;
                } else {
                    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
                }
            }
            z = false;
            if (z) {
                O000000o();
            }
        }

        private void O000000o() {
            if (!RecyclerView.POST_UPDATES_ON_ANIMATION || !RecyclerView.this.mHasFixedSize || !RecyclerView.this.mIsAttached) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mAdapterUpdateDuringMeasure = true;
                recyclerView.requestLayout();
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            cb.O000000o(recyclerView2, recyclerView2.mUpdateChildViewsRunnable);
        }
    }

    public static class O0000O0o {
        protected static EdgeEffect O000000o(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static class O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        SparseArray<O000000o> f2946O000000o = new SparseArray<>();
        int O00000Oo = 0;

        static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            final ArrayList<O000OOo0> f2947O000000o = new ArrayList<>();
            int O00000Oo = 5;
            long O00000o = 0;
            long O00000o0 = 0;

            O000000o() {
            }
        }

        public final void O000000o() {
            for (int i = 0; i < this.f2946O000000o.size(); i++) {
                this.f2946O000000o.valueAt(i).f2947O000000o.clear();
            }
        }

        public final void O000000o(int i, int i2) {
            O000000o O00000Oo2 = O00000Oo(i);
            O00000Oo2.O00000Oo = i2;
            ArrayList<O000OOo0> arrayList = O00000Oo2.f2947O000000o;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public final O000OOo0 O000000o(int i) {
            O000000o o000000o = this.f2946O000000o.get(i);
            if (o000000o == null || o000000o.f2947O000000o.isEmpty()) {
                return null;
            }
            ArrayList<O000OOo0> arrayList = o000000o.f2947O000000o;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public final void O000000o(O000OOo0 o000OOo0) {
            int itemViewType = o000OOo0.getItemViewType();
            ArrayList<O000OOo0> arrayList = O00000Oo(itemViewType).f2947O000000o;
            if (this.f2946O000000o.get(itemViewType).O00000Oo > arrayList.size()) {
                o000OOo0.resetInternal();
                arrayList.add(o000OOo0);
            }
        }

        static long O000000o(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, long j) {
            O000000o O00000Oo2 = O00000Oo(i);
            O00000Oo2.O00000o0 = O000000o(O00000Oo2.O00000o0, j);
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(int i, long j, long j2) {
            long j3 = O00000Oo(i).O00000o0;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            this.O00000Oo++;
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0() {
            this.O00000Oo--;
        }

        /* access modifiers changed from: package-private */
        public final O000000o O00000Oo(int i) {
            O000000o o000000o = this.f2946O000000o.get(i);
            if (o000000o != null) {
                return o000000o;
            }
            O000000o o000000o2 = new O000000o();
            this.f2946O000000o.put(i, o000000o2);
            return o000000o2;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(O000OOo0 o000OOo0) {
        if (o000OOo0.mNestedRecyclerView != null) {
            View view = o000OOo0.mNestedRecyclerView.get();
            while (view != null) {
                if (view != o000OOo0.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            o000OOo0.mNestedRecyclerView = null;
        }
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public final class O000O0OO {

        /* renamed from: O000000o  reason: collision with root package name */
        final ArrayList<O000OOo0> f2948O000000o = new ArrayList<>();
        ArrayList<O000OOo0> O00000Oo = null;
        final List<O000OOo0> O00000o = Collections.unmodifiableList(this.f2948O000000o);
        final ArrayList<O000OOo0> O00000o0 = new ArrayList<>();
        int O00000oO = 2;
        int O00000oo = 2;
        O000O00o O0000O0o;
        O000OO O0000OOo;

        public O000O0OO() {
        }

        public final void O000000o() {
            this.f2948O000000o.clear();
            O00000o0();
        }

        public final void O00000Oo() {
            this.O00000oo = this.O00000oO + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.O00000o0.size() - 1; size >= 0 && this.O00000o0.size() > this.O00000oo; size--) {
                O00000o(size);
            }
        }

        private boolean O00000o0(O000OOo0 o000OOo0) {
            if (o000OOo0.isRemoved()) {
                return RecyclerView.this.mState.O0000O0o;
            }
            if (o000OOo0.mPosition < 0 || o000OOo0.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + o000OOo0 + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.O0000O0o && RecyclerView.this.mAdapter.getItemViewType(o000OOo0.mPosition) != o000OOo0.getItemViewType()) {
                return false;
            } else {
                if (!RecyclerView.this.mAdapter.hasStableIds() || o000OOo0.getItemId() == RecyclerView.this.mAdapter.getItemId(o000OOo0.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        private boolean O000000o(O000OOo0 o000OOo0, int i, int i2, long j) {
            o000OOo0.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = o000OOo0.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE) {
                long j2 = this.O0000O0o.O00000Oo(itemViewType).O00000o;
                if (!(j2 == 0 || j2 + nanoTime < j)) {
                    return false;
                }
            }
            RecyclerView.this.mAdapter.bindViewHolder(o000OOo0, i);
            long nanoTime2 = RecyclerView.this.getNanoTime();
            O000O00o.O000000o O00000Oo2 = this.O0000O0o.O00000Oo(o000OOo0.getItemViewType());
            O00000Oo2.O00000o = O000O00o.O000000o(O00000Oo2.O00000o, nanoTime2 - nanoTime);
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = o000OOo0.itemView;
                if (cb.O0000O0o(view) == 0) {
                    cb.O00000oO(view, 1);
                }
                if (RecyclerView.this.mAccessibilityDelegate != null) {
                    bh itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                    if (itemDelegate instanceof hb.O000000o) {
                        hb.O000000o o000000o = (hb.O000000o) itemDelegate;
                        bh O00000o2 = cb.O00000o(view);
                        if (!(O00000o2 == null || O00000o2 == o000000o)) {
                            o000000o.O00000Oo.put(view, O00000o2);
                        }
                    }
                    cb.O000000o(view, itemDelegate);
                }
            }
            if (RecyclerView.this.mState.O0000O0o) {
                o000OOo0.mPreLayoutPosition = i2;
            }
            return true;
        }

        public final int O000000o(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.O000000o()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.O000000o() + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.O0000O0o) {
                return i;
            } else {
                return RecyclerView.this.mAdapterHelper.O00000Oo(i);
            }
        }

        public final View O00000Oo(int i) {
            return O00000o0(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean, long):androidx.recyclerview.widget.RecyclerView$O000OOo0
         arg types: [int, int, int]
         candidates:
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(long, int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean, long):androidx.recyclerview.widget.RecyclerView$O000OOo0 */
        public final View O00000o0(int i) {
            return O000000o(i, false, Long.MAX_VALUE).itemView;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
         arg types: [int, int]
         candidates:
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0 */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(long, int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
         arg types: [long, int, int]
         candidates:
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean, long):androidx.recyclerview.widget.RecyclerView$O000OOo0
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(long, int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0 */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0191  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01e1  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x01ef  */
        public final O000OOo0 O000000o(int i, boolean z, long j) {
            boolean z2;
            O000OOo0 o000OOo0;
            O000OOo0 o000OOo02;
            boolean z3;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            RecyclerView findNestedRecyclerView;
            O000OO o000oo;
            View O000000o2;
            int i2 = i;
            if (i2 < 0 || i2 >= RecyclerView.this.mState.O000000o()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i2 + "(" + i2 + "). Item count:" + RecyclerView.this.mState.O000000o() + RecyclerView.this.exceptionLabel());
            }
            boolean z4 = true;
            if (RecyclerView.this.mState.O0000O0o) {
                o000OOo0 = O00000oO(i);
                if (o000OOo0 != null) {
                    z2 = true;
                    if (o000OOo0 == null && (o000OOo0 = O000000o(i2, false)) != null) {
                        if (O00000o0(o000OOo0)) {
                            o000OOo0.addFlags(4);
                            if (o000OOo0.isScrap()) {
                                RecyclerView.this.removeDetachedView(o000OOo0.itemView, false);
                                o000OOo0.unScrap();
                            } else if (o000OOo0.wasReturnedFromScrap()) {
                                o000OOo0.clearReturnedFromScrapFlag();
                            }
                            O000000o(o000OOo0);
                            o000OOo0 = null;
                        } else {
                            z2 = true;
                        }
                    }
                    if (o000OOo0 == null) {
                        int O00000Oo2 = RecyclerView.this.mAdapterHelper.O00000Oo(i2);
                        if (O00000Oo2 < 0 || O00000Oo2 >= RecyclerView.this.mAdapter.getItemCount()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i2 + "(offset:" + O00000Oo2 + ").state:" + RecyclerView.this.mState.O000000o() + RecyclerView.this.exceptionLabel());
                        }
                        int itemViewType = RecyclerView.this.mAdapter.getItemViewType(O00000Oo2);
                        if (RecyclerView.this.mAdapter.hasStableIds() && (o000OOo0 = O000000o(RecyclerView.this.mAdapter.getItemId(O00000Oo2), itemViewType, false)) != null) {
                            o000OOo0.mPosition = O00000Oo2;
                            z2 = true;
                        }
                        if (!(o000OOo0 != null || (o000oo = this.O0000OOo) == null || (O000000o2 = o000oo.O000000o()) == null)) {
                            o000OOo0 = RecyclerView.this.getChildViewHolder(O000000o2);
                            if (o000OOo0 == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                            } else if (o000OOo0.shouldIgnore()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                            }
                        }
                        if (o000OOo0 == null && (o000OOo0 = O00000o().O000000o(itemViewType)) != null) {
                            o000OOo0.resetInternal();
                            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                O00000o(o000OOo0);
                            }
                        }
                        if (o000OOo0 == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j != Long.MAX_VALUE && !this.O0000O0o.O000000o(itemViewType, nanoTime, j)) {
                                return null;
                            }
                            o000OOo0 = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, itemViewType);
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(o000OOo0.itemView)) != null) {
                                o000OOo0.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                            }
                            this.O0000O0o.O000000o(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                        }
                    }
                    o000OOo02 = o000OOo0;
                    boolean z5 = z2;
                    if (z5 && !RecyclerView.this.mState.O0000O0o && o000OOo02.hasAnyOfTheFlags(8192)) {
                        o000OOo02.setFlags(0, 8192);
                        if (RecyclerView.this.mState.O0000Oo) {
                            O0000OOo.O00000oO(o000OOo02);
                            o000OOo02.getUnmodifiedPayloads();
                            RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(o000OOo02, O0000OOo.O00000o(o000OOo02));
                        }
                    }
                    if (!RecyclerView.this.mState.O0000O0o && o000OOo02.isBound()) {
                        o000OOo02.mPreLayoutPosition = i2;
                    } else if (!o000OOo02.isBound() || o000OOo02.needsUpdate() || o000OOo02.isInvalid()) {
                        z3 = O000000o(o000OOo02, RecyclerView.this.mAdapterHelper.O00000Oo(i2), i, j);
                        layoutParams = o000OOo02.itemView.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                            o000OOo02.itemView.setLayoutParams(layoutParams2);
                        } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                            layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                            o000OOo02.itemView.setLayoutParams(layoutParams2);
                        } else {
                            layoutParams2 = (LayoutParams) layoutParams;
                        }
                        layoutParams2.mViewHolder = o000OOo02;
                        if (!z5 || !z3) {
                            z4 = false;
                        }
                        layoutParams2.mPendingInvalidate = z4;
                        return o000OOo02;
                    }
                    z3 = false;
                    layoutParams = o000OOo02.itemView.getLayoutParams();
                    if (layoutParams == null) {
                    }
                    layoutParams2.mViewHolder = o000OOo02;
                    z4 = false;
                    layoutParams2.mPendingInvalidate = z4;
                    return o000OOo02;
                }
            } else {
                o000OOo0 = null;
            }
            z2 = false;
            if (O00000o0(o000OOo0)) {
            }
            if (o000OOo0 == null) {
            }
            o000OOo02 = o000OOo0;
            boolean z52 = z2;
            o000OOo02.setFlags(0, 8192);
            if (RecyclerView.this.mState.O0000Oo) {
            }
            if (!RecyclerView.this.mState.O0000O0o) {
            }
            z3 = O000000o(o000OOo02, RecyclerView.this.mAdapterHelper.O00000Oo(i2), i, j);
            layoutParams = o000OOo02.itemView.getLayoutParams();
            if (layoutParams == null) {
            }
            layoutParams2.mViewHolder = o000OOo02;
            z4 = false;
            layoutParams2.mPendingInvalidate = z4;
            return o000OOo02;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void
         arg types: [android.view.ViewGroup, int]
         candidates:
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void */
        private void O00000o(O000OOo0 o000OOo0) {
            if (o000OOo0.itemView instanceof ViewGroup) {
                O000000o((ViewGroup) o000OOo0.itemView, false);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void
         arg types: [android.view.ViewGroup, int]
         candidates:
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void */
        private void O000000o(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    O000000o((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void O000000o(View view) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            O000000o(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.O00000o0(childViewHolderInt);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0() {
            for (int size = this.O00000o0.size() - 1; size >= 0; size--) {
                O00000o(size);
            }
            this.O00000o0.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.O000000o();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
         arg types: [androidx.recyclerview.widget.RecyclerView$O000OOo0, int]
         candidates:
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void */
        /* access modifiers changed from: package-private */
        public final void O00000o(int i) {
            O000000o(this.O00000o0.get(i), true);
            this.O00000o0.remove(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
         arg types: [androidx.recyclerview.widget.RecyclerView$O000OOo0, int]
         candidates:
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(int, boolean):androidx.recyclerview.widget.RecyclerView$O000OOo0
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(android.view.ViewGroup, boolean):void
          androidx.recyclerview.widget.RecyclerView.O000O0OO.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void */
        /* access modifiers changed from: package-private */
        public final void O000000o(O000OOo0 o000OOo0) {
            boolean z;
            boolean z2 = false;
            if (o000OOo0.isScrap() || o000OOo0.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(o000OOo0.isScrap());
                sb.append(" isAttached:");
                if (o000OOo0.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (o000OOo0.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + o000OOo0 + RecyclerView.this.exceptionLabel());
            } else if (!o000OOo0.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = o000OOo0.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(o000OOo0)) || o000OOo0.isRecyclable()) {
                    if (this.O00000oo <= 0 || o000OOo0.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.O00000o0.size();
                        if (size >= this.O00000oo && size > 0) {
                            O00000o(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.O000000o(o000OOo0.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.mPrefetchRegistry.O000000o(this.O00000o0.get(i).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.O00000o0.add(size, o000OOo0);
                        z = true;
                    }
                    if (!z) {
                        O000000o(o000OOo0, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.mViewInfoStore.O00000o(o000OOo0);
                if (!z && !z2 && doesTransientStatePreventRecycling) {
                    o000OOo0.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
        }

        public final void O000000o(O000OOo0 o000OOo0, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(o000OOo0);
            View view = o000OOo0.itemView;
            if (RecyclerView.this.mAccessibilityDelegate != null) {
                bh itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                cb.O000000o(view, itemDelegate instanceof hb.O000000o ? ((hb.O000000o) itemDelegate).O000000o(view) : null);
            }
            if (z) {
                O00000oO(o000OOo0);
            }
            o000OOo0.mOwnerRecyclerView = null;
            O00000o().O000000o(o000OOo0);
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(View view) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            O000000o(childViewHolderInt);
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0(View view) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.O00000Oo == null) {
                    this.O00000Oo = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.O00000Oo.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f2948O000000o.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(O000OOo0 o000OOo0) {
            if (o000OOo0.mInChangeScrap) {
                this.O00000Oo.remove(o000OOo0);
            } else {
                this.f2948O000000o.remove(o000OOo0);
            }
            o000OOo0.mScrapContainer = null;
            o000OOo0.mInChangeScrap = false;
            o000OOo0.clearReturnedFromScrapFlag();
        }

        private O000OOo0 O00000oO(int i) {
            int size;
            int O000000o2;
            ArrayList<O000OOo0> arrayList = this.O00000Oo;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    O000OOo0 o000OOo0 = this.O00000Oo.get(i3);
                    if (o000OOo0.wasReturnedFromScrap() || o000OOo0.getLayoutPosition() != i) {
                        i3++;
                    } else {
                        o000OOo0.addFlags(32);
                        return o000OOo0;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (O000000o2 = RecyclerView.this.mAdapterHelper.O000000o(i, 0)) > 0 && O000000o2 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(O000000o2);
                    while (i2 < size) {
                        O000OOo0 o000OOo02 = this.O00000Oo.get(i2);
                        if (o000OOo02.wasReturnedFromScrap() || o000OOo02.getItemId() != itemId) {
                            i2++;
                        } else {
                            o000OOo02.addFlags(32);
                            return o000OOo02;
                        }
                    }
                }
            }
            return null;
        }

        private O000OOo0 O000000o(int i, boolean z) {
            View view;
            int size = this.f2948O000000o.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                O000OOo0 o000OOo0 = this.f2948O000000o.get(i3);
                if (o000OOo0.wasReturnedFromScrap() || o000OOo0.getLayoutPosition() != i || o000OOo0.isInvalid() || (!RecyclerView.this.mState.O0000O0o && o000OOo0.isRemoved())) {
                    i3++;
                } else {
                    o000OOo0.addFlags(32);
                    return o000OOo0;
                }
            }
            if (!z) {
                gn gnVar = RecyclerView.this.mChildHelper;
                int size2 = gnVar.O00000o0.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        view = null;
                        break;
                    }
                    view = gnVar.O00000o0.get(i4);
                    O000OOo0 O00000Oo2 = gnVar.f18033O000000o.O00000Oo(view);
                    if (O00000Oo2.getLayoutPosition() == i && !O00000Oo2.isInvalid() && !O00000Oo2.isRemoved()) {
                        break;
                    }
                    i4++;
                }
                if (view != null) {
                    O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                    gn gnVar2 = RecyclerView.this.mChildHelper;
                    int O000000o2 = gnVar2.f18033O000000o.O000000o(view);
                    if (O000000o2 < 0) {
                        throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
                    } else if (gnVar2.O00000Oo.O00000o0(O000000o2)) {
                        gnVar2.O00000Oo.O00000Oo(O000000o2);
                        gnVar2.O00000Oo(view);
                        int O00000o02 = RecyclerView.this.mChildHelper.O00000o0(view);
                        if (O00000o02 != -1) {
                            RecyclerView.this.mChildHelper.O00000o(O00000o02);
                            O00000o0(view);
                            childViewHolderInt.addFlags(8224);
                            return childViewHolderInt;
                        }
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    } else {
                        throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
                    }
                }
            }
            int size3 = this.O00000o0.size();
            while (i2 < size3) {
                O000OOo0 o000OOo02 = this.O00000o0.get(i2);
                if (o000OOo02.isInvalid() || o000OOo02.getLayoutPosition() != i || o000OOo02.isAttachedToTransitionOverlay()) {
                    i2++;
                } else {
                    if (!z) {
                        this.O00000o0.remove(i2);
                    }
                    return o000OOo02;
                }
            }
            return null;
        }

        private O000OOo0 O000000o(long j, int i, boolean z) {
            for (int size = this.f2948O000000o.size() - 1; size >= 0; size--) {
                O000OOo0 o000OOo0 = this.f2948O000000o.get(size);
                if (o000OOo0.getItemId() == j && !o000OOo0.wasReturnedFromScrap()) {
                    if (i == o000OOo0.getItemViewType()) {
                        o000OOo0.addFlags(32);
                        if (o000OOo0.isRemoved() && !RecyclerView.this.mState.O0000O0o) {
                            o000OOo0.setFlags(2, 14);
                        }
                        return o000OOo0;
                    } else if (!z) {
                        this.f2948O000000o.remove(size);
                        RecyclerView.this.removeDetachedView(o000OOo0.itemView, false);
                        O00000Oo(o000OOo0.itemView);
                    }
                }
            }
            int size2 = this.O00000o0.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                O000OOo0 o000OOo02 = this.O00000o0.get(size2);
                if (o000OOo02.getItemId() == j && !o000OOo02.isAttachedToTransitionOverlay()) {
                    if (i == o000OOo02.getItemViewType()) {
                        if (!z) {
                            this.O00000o0.remove(size2);
                        }
                        return o000OOo02;
                    } else if (!z) {
                        O00000o(size2);
                        return null;
                    }
                }
            }
        }

        private void O00000oO(O000OOo0 o000OOo0) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.O000000o(o000OOo0);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(o000OOo0);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.O00000o(o000OOo0);
            }
        }

        /* access modifiers changed from: package-private */
        public final O000O00o O00000o() {
            if (this.O0000O0o == null) {
                this.O0000O0o = new O000O00o();
            }
            return this.O0000O0o;
        }
    }

    public static abstract class O000000o<VH extends O000OOo0> {
        private boolean mHasStableIds = false;
        private final O00000Oo mObservable = new O00000Oo();

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                as.O000000o("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                as.O000000o();
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: VH
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public final void bindViewHolder(VH r3, int r4) {
            /*
                r2 = this;
                r3.mPosition = r4
                boolean r0 = r2.hasStableIds()
                if (r0 == 0) goto L_0x000e
                long r0 = r2.getItemId(r4)
                r3.mItemId = r0
            L_0x000e:
                r0 = 519(0x207, float:7.27E-43)
                r1 = 1
                r3.setFlags(r1, r0)
                java.lang.String r0 = "RV OnBindView"
                _m_j.as.O000000o(r0)
                java.util.List r0 = r3.getUnmodifiedPayloads()
                r2.onBindViewHolder(r3, r4, r0)
                r3.clearPayload()
                android.view.View r3 = r3.itemView
                android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
                boolean r4 = r3 instanceof androidx.recyclerview.widget.RecyclerView.LayoutParams
                if (r4 == 0) goto L_0x0031
                androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
                r3.mInsetsDirty = r1
            L_0x0031:
                _m_j.as.O000000o()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.O000000o.bindViewHolder(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):void");
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.O000000o();
        }

        public void registerAdapterDataObserver(O00000o0 o00000o0) {
            this.mObservable.registerObserver(o00000o0);
        }

        public void unregisterAdapterDataObserver(O00000o0 o00000o0) {
            this.mObservable.unregisterObserver(o00000o0);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.O00000Oo();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.O000000o(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.O000000o(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.O000000o(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.O000000o(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.O00000Oo(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.O00000o(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.O00000Oo(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.O00000o0(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.O00000o0(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildDetached(View view) {
        O000OOo0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        O000000o o000000o = this.mAdapter;
        if (!(o000000o == null || childViewHolderInt == null)) {
            o000000o.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<O0000o00> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).O00000Oo(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildAttached(View view) {
        O000OOo0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        O000000o o000000o = this.mAdapter;
        if (!(o000000o == null || childViewHolderInt == null)) {
            o000000o.onViewAttachedToWindow(childViewHolderInt);
        }
        List<O0000o00> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).O000000o(view);
            }
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure = false;
        gn mChildHelper;
        private int mHeight;
        private int mHeightMode;
        hf mHorizontalBoundCheck = new hf(this.mHorizontalBoundCheckCallback);
        private final hf.O00000Oo mHorizontalBoundCheckCallback = new hf.O00000Oo() {
            /* class androidx.recyclerview.widget.RecyclerView.LayoutManager.AnonymousClass1 */

            public final View O000000o(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            public final int O000000o() {
                return LayoutManager.this.getPaddingLeft();
            }

            public final int O00000Oo() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            public final int O000000o(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int O00000Oo(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        };
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        O000OO00 mSmoothScroller;
        hf mVerticalBoundCheck = new hf(this.mVerticalBoundCheckCallback);
        private final hf.O00000Oo mVerticalBoundCheckCallback = new hf.O00000Oo() {
            /* class androidx.recyclerview.widget.RecyclerView.LayoutManager.AnonymousClass2 */

            public final View O000000o(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            public final int O000000o() {
                return LayoutManager.this.getPaddingTop();
            }

            public final int O00000Oo() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            public final int O000000o(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int O00000Oo(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        };
        private int mWidth;
        private int mWidthMode;

        public interface O000000o {
            void O000000o(int i, int i2);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, O000OO0o o000OO0o, O000000o o000000o) {
        }

        public void collectInitialPrefetchPositions(int i, O000000o o000000o) {
        }

        public int computeHorizontalScrollExtent(O000OO0o o000OO0o) {
            return 0;
        }

        public int computeHorizontalScrollOffset(O000OO0o o000OO0o) {
            return 0;
        }

        public int computeHorizontalScrollRange(O000OO0o o000OO0o) {
            return 0;
        }

        public int computeVerticalScrollExtent(O000OO0o o000OO0o) {
            return 0;
        }

        public int computeVerticalScrollOffset(O000OO0o o000OO0o) {
            return 0;
        }

        public int computeVerticalScrollRange(O000OO0o o000OO0o) {
            return 0;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getSelectionModeForAccessibility(O000O0OO o000o0oo, O000OO0o o000OO0o) {
            return 0;
        }

        public boolean isLayoutHierarchical(O000O0OO o000o0oo, O000OO0o o000OO0o) {
            return false;
        }

        public void onAdapterChanged(O000000o o000000o, O000000o o000000o2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i, O000O0OO o000o0oo, O000OO0o o000OO0o) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onLayoutCompleted(O000OO0o o000OO0o) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityActionForItem(O000O0OO o000o0oo, O000OO0o o000OO0o, View view, int i, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i, O000O0OO o000o0oo, O000OO0o o000OO0o) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, O000O0OO o000o0oo, O000OO0o o000OO0o) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            this.mWidthMode = View.MeasureSpec.getMode(i);
            if (this.mWidthMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.mHeightMode = View.MeasureSpec.getMode(i2);
            if (this.mHeightMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i3, i4, i5, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.O00000Oo();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        /* access modifiers changed from: package-private */
        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void dispatchDetachedFromWindow(RecyclerView recyclerView, O000O0OO o000o0oo) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, o000o0oo);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                cb.O000000o(recyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, O000O0OO o000o0oo) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void onLayoutChildren(O000O0OO o000o0oo, O000OO0o o000OO0o) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, O000OO0o o000OO0o, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(O000OO00 o000oo00) {
            O000OO00 o000oo002 = this.mSmoothScroller;
            if (!(o000oo002 == null || o000oo00 == o000oo002 || !o000oo002.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = o000oo00;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            O000OO00 o000oo00 = this.mSmoothScroller;
            return o000oo00 != null && o000oo00.isRunning();
        }

        public int getLayoutDirection() {
            return cb.O0000Oo0(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.O00000o0(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        private void addViewInt(View view, int i, boolean z) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.O00000Oo(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.O00000o0(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.O000000o(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int O00000o0 = this.mChildHelper.O00000o0(view);
                if (i == -1) {
                    i = this.mChildHelper.O000000o();
                }
                if (O00000o0 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (O00000o0 != i) {
                    this.mRecyclerView.mLayout.moveView(O00000o0, i);
                }
            } else {
                this.mChildHelper.O000000o(view, i, false);
                layoutParams.mInsetsDirty = true;
                O000OO00 o000oo00 = this.mSmoothScroller;
                if (o000oo00 != null && o000oo00.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public void removeView(View view) {
            gn gnVar = this.mChildHelper;
            int O000000o2 = gnVar.f18033O000000o.O000000o(view);
            if (O000000o2 >= 0) {
                if (gnVar.O00000Oo.O00000o(O000000o2)) {
                    gnVar.O00000Oo(view);
                }
                gnVar.f18033O000000o.O000000o(O000000o2);
            }
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.O000000o(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.O000000o(childCount);
            }
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.O00000o(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.O0000O0o || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int O00000o0 = this.mChildHelper.O00000o0(view);
            if (O00000o0 >= 0) {
                detachViewInternal(O00000o0, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.O00000o(i);
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.O00000Oo(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.O00000o0(childViewHolderInt);
            }
            this.mChildHelper.O000000o(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        public void detachAndScrapView(View view, O000O0OO o000o0oo) {
            scrapOrRecycleView(o000o0oo, this.mChildHelper.O00000o0(view), view);
        }

        public void detachAndScrapViewAt(int i, O000O0OO o000o0oo) {
            scrapOrRecycleView(o000o0oo, i, getChildAt(i));
        }

        public void removeAndRecycleView(View view, O000O0OO o000o0oo) {
            removeView(view);
            o000o0oo.O000000o(view);
        }

        public void removeAndRecycleViewAt(int i, O000O0OO o000o0oo) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            o000o0oo.O000000o(childAt);
        }

        public int getChildCount() {
            gn gnVar = this.mChildHelper;
            if (gnVar != null) {
                return gnVar.O000000o();
            }
            return 0;
        }

        public View getChildAt(int i) {
            gn gnVar = this.mChildHelper;
            if (gnVar != null) {
                return gnVar.O00000Oo(i);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return cb.O0000OoO(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return cb.O0000Ooo(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.O00000o(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            O000000o adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
            this.mRecyclerView.mViewInfoStore.O00000o(childViewHolderInt);
        }

        public void stopIgnoringView(View view) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(O000O0OO o000o0oo) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(o000o0oo, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(O000O0OO o000o0oo, int i, View view) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i);
                    o000o0oo.O00000o0(view);
                    this.mRecyclerView.mViewInfoStore.O00000o0(childViewHolderInt);
                    return;
                }
                removeViewAt(i);
                o000o0oo.O000000o(childViewHolderInt);
            }
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i2, layoutParams.height);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i2, layoutParams.height);
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i4, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @Deprecated
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = i - i2;
            int i5 = 0;
            int max = Math.max(0, i4);
            if (!z) {
                if (i3 < 0) {
                    if (i3 != -1) {
                        if (i3 == -2) {
                            i5 = Integer.MIN_VALUE;
                            return View.MeasureSpec.makeMeasureSpec(max, i5);
                        }
                    }
                    i5 = 1073741824;
                    return View.MeasureSpec.makeMeasureSpec(max, i5);
                }
                max = i3;
                i5 = 1073741824;
                return View.MeasureSpec.makeMeasureSpec(max, i5);
            }
            max = 0;
            return View.MeasureSpec.makeMeasureSpec(max, i5);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int i5 = i - i3;
            int i6 = 0;
            int max = Math.max(0, i5);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 != Integer.MIN_VALUE) {
                            if (i2 != 0) {
                            }
                        }
                        i4 = max;
                        i6 = i2;
                        return View.MeasureSpec.makeMeasureSpec(i4, i6);
                    }
                    i4 = 0;
                    return View.MeasureSpec.makeMeasureSpec(i4, i6);
                }
            } else if (i4 < 0) {
                if (i4 != -1) {
                    if (i4 == -2) {
                        if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                            i6 = Integer.MIN_VALUE;
                        }
                        i4 = max;
                        return View.MeasureSpec.makeMeasureSpec(i4, i6);
                    }
                    i4 = 0;
                    return View.MeasureSpec.makeMeasureSpec(i4, i6);
                }
                i4 = max;
                i6 = i2;
                return View.MeasureSpec.makeMeasureSpec(i4, i6);
            }
            i6 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(i4, i6);
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i + rect.left + layoutParams.leftMargin, i2 + rect.top + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.O000000o(view) && this.mVerticalBoundCheck.O000000o(view);
            if (z) {
                return z3;
            }
            return !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i >= width || rect.right - i <= paddingLeft || rect.top - i2 >= height || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, O000OO0o o000OO0o, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onMeasure(O000O0OO o000o0oo, O000OO0o o000OO0o, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return cb.O0000o0O(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return cb.O0000o0o(this.mRecyclerView);
        }

        /* access modifiers changed from: package-private */
        public void stopSmoothScroller() {
            O000OO00 o000oo00 = this.mSmoothScroller;
            if (o000oo00 != null) {
                o000oo00.stop();
            }
        }

        /* access modifiers changed from: package-private */
        public void onSmoothScrollerStopped(O000OO00 o000oo00) {
            if (this.mSmoothScroller == o000oo00) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(O000O0OO o000o0oo) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, o000o0oo);
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(cl clVar) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, clVar);
        }

        public void onInitializeAccessibilityNodeInfo(O000O0OO o000o0oo, O000OO0o o000OO0o, cl clVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                clVar.O000000o(8192);
                clVar.O0000OoO(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                clVar.O000000o(4096);
                clVar.O0000OoO(true);
            }
            clVar.O000000o(cl.O00000Oo.O000000o(getRowCountForAccessibility(o000o0oo, o000OO0o), getColumnCountForAccessibility(o000o0oo, o000OO0o), isLayoutHierarchical(o000o0oo, o000OO0o), getSelectionModeForAccessibility(o000o0oo, o000OO0o)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(O000O0OO o000o0oo, O000OO0o o000OO0o, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.mRecyclerView.mAdapter != null) {
                    accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, cl clVar) {
            O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.O00000o(childViewHolderInt.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, clVar);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(O000O0OO o000o0oo, O000OO0o o000OO0o, View view, cl clVar) {
            clVar.O00000Oo(cl.O00000o0.O000000o(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getRowCountForAccessibility(O000O0OO o000o0oo, O000OO0o o000OO0o) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getColumnCountForAccessibility(O000O0OO o000o0oo, O000OO0o o000OO0o) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        public boolean performAccessibilityAction(O000O0OO o000o0oo, O000OO0o o000OO0o, int i, Bundle bundle) {
            int i2;
            int i3;
            int i4;
            int i5;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                i4 = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    i5 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                }
                i2 = i4;
                i3 = 0;
                if (i2 != 0) {
                }
                this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
                return true;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
                if (i2 != 0 && i3 == 0) {
                    return false;
                }
                this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
                return true;
            } else {
                i4 = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    i5 = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                }
                i2 = i4;
                i3 = 0;
                if (i2 != 0) {
                }
                this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
                return true;
            }
            i2 = i4;
            i3 = i5;
            if (i2 != 0) {
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948, 16842987, 16842993, R.attr.fastScrollEnabled, R.attr.fastScrollHorizontalThumbDrawable, R.attr.fastScrollHorizontalTrackDrawable, R.attr.fastScrollVerticalThumbDrawable, R.attr.fastScrollVerticalTrackDrawable, R.attr.layoutManager, R.attr.reverseLayout, R.attr.spanCount, R.attr.stackFromEnd}, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(0, 1);
            properties.spanCount = obtainStyledAttributes.getInt(10, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(9, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        /* access modifiers changed from: package-private */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void removeAndRecycleScrapInt(O000O0OO o000o0oo) {
            int size = o000o0oo.f2948O000000o.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = o000o0oo.f2948O000000o.get(i).itemView;
                O000OOo0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.O00000o0(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    o000o0oo.O00000Oo(view);
                }
            }
            o000o0oo.f2948O000000o.clear();
            if (o000o0oo.O00000Oo != null) {
                o000o0oo.O00000Oo.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }
    }

    public static abstract class O0000Oo {
        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, O000OO0o o000OO0o) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, O000OO0o o000OO0o) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, O000OO0o o000OO0o) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    public static abstract class O000OOo0 {
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        protected RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        public int mPosition = -1;
        int mPreLayoutPosition = -1;
        O000O0OO mScrapContainer = null;
        O000OOo0 mShadowedHolder = null;
        O000OOo0 mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public O000OOo0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public boolean shouldIgnore() {
            return (this.mFlags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.O00000Oo(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(O000O0OO o000o0oo, boolean z) {
            this.mScrapContainer = o000o0oo;
            this.mInChangeScrap = z;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (i2 ^ -1));
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = cb.O0000O0o(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i = this.mIsRecyclableCount;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ".concat(String.valueOf(this)));
            } else if (!z && i == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !cb.O00000oO(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && cb.O00000oO(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setChildImportantForAccessibilityInternal(O000OOo0 o000OOo0, int i) {
        if (isComputingLayout()) {
            o000OOo0.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(o000OOo0);
            return false;
        }
        cb.O00000oO(o000OOo0.itemView, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            O000OOo0 o000OOo0 = this.mPendingAccessibilityImportanceChange.get(size);
            if (o000OOo0.itemView.getParent() == this && !o000OOo0.shouldIgnore() && (i = o000OOo0.mPendingAccessibilityState) != -1) {
                cb.O00000oO(o000OOo0.itemView, i);
                o000OOo0.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    /* access modifiers changed from: package-private */
    public int getAdapterPositionFor(O000OOo0 o000OOo0) {
        if (o000OOo0.hasAnyOfTheFlags(524) || !o000OOo0.isBound()) {
            return -1;
        }
        gk gkVar = this.mAdapterHelper;
        int i = o000OOo0.mPosition;
        int size = gkVar.f17923O000000o.size();
        for (int i2 = 0; i2 < size; i2++) {
            gk.O00000Oo o00000Oo = gkVar.f17923O000000o.get(i2);
            int i3 = o00000Oo.f17924O000000o;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (o00000Oo.O00000Oo == i) {
                            i = o00000Oo.O00000o;
                        } else {
                            if (o00000Oo.O00000Oo < i) {
                                i--;
                            }
                            if (o00000Oo.O00000o <= i) {
                                i++;
                            }
                        }
                    }
                } else if (o00000Oo.O00000Oo > i) {
                    continue;
                } else if (o00000Oo.O00000Oo + o00000Oo.O00000o > i) {
                    return -1;
                } else {
                    i -= o00000Oo.O00000o;
                }
            } else if (o00000Oo.O00000Oo <= i) {
                i += o00000Oo.O00000o;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new gq(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().O000000o(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f13211O000000o;
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().O000000o(i, 0);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().O000000o(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().O00000Oo(0);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().O00000Oo(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().O000000o(0);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().O000000o(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().O000000o(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().O00000Oo(i, i2, i3, i4, iArr, i5, null);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().O000000o(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().O000000o(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().O000000o(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().O000000o(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().O000000o(f, f2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets = new Rect();
        boolean mInsetsDirty = true;
        boolean mPendingInvalidate = false;
        O000OOo0 mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getAdapterPosition();
        }
    }

    public static abstract class O00000o0 {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    public static abstract class O000OO00 {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final O000000o mRecyclingAction = new O000000o();
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        public interface O00000Oo {
            PointF computeScrollVectorForPosition(int i);
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(int i, int i2, O000OO0o o000OO0o, O000000o o000000o);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(View view, O000OO0o o000OO0o, O000000o o000000o);

        /* access modifiers changed from: package-private */
        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.O00000Oo();
            if (this.mStarted) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            if (this.mTargetPosition != -1) {
                this.mRecyclerView.mState.f2951O000000o = this.mTargetPosition;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.O000000o();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof O00000Oo) {
                return ((O00000Oo) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + O00000Oo.class.getCanonicalName());
            return null;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f2951O000000o = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        /* access modifiers changed from: package-private */
        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (!(!this.mPendingInitialRun || this.mTargetView != null || this.mLayoutManager == null || (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) == null || (computeScrollVectorForPosition.x == 0.0f && computeScrollVectorForPosition.y == 0.0f))) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), null);
            }
            boolean z = false;
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.O000000o(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                if (this.mRecyclingAction.f2950O000000o >= 0) {
                    z = true;
                }
                this.mRecyclingAction.O000000o(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.O000000o();
                }
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        /* access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            int f2950O000000o;
            private int O00000Oo;
            private int O00000o;
            private int O00000o0;
            private Interpolator O00000oO;
            private boolean O00000oo;
            private int O0000O0o;

            public O000000o() {
                this(0, 0);
            }

            private O000000o(int i, int i2) {
                this.f2950O000000o = -1;
                this.O00000oo = false;
                this.O0000O0o = 0;
                this.O00000Oo = 0;
                this.O00000o0 = 0;
                this.O00000o = Integer.MIN_VALUE;
                this.O00000oO = null;
            }

            /* access modifiers changed from: package-private */
            public final void O000000o(RecyclerView recyclerView) {
                int i = this.f2950O000000o;
                if (i >= 0) {
                    this.f2950O000000o = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.O00000oo = false;
                } else if (this.O00000oo) {
                    O000000o();
                    recyclerView.mViewFlinger.O000000o(this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO);
                    this.O0000O0o++;
                    if (this.O0000O0o > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.O00000oo = false;
                } else {
                    this.O0000O0o = 0;
                }
            }

            private void O000000o() {
                if (this.O00000oO != null && this.O00000o <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.O00000o <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public final void O000000o(int i, int i2, int i3, Interpolator interpolator) {
                this.O00000Oo = i;
                this.O00000o0 = i2;
                this.O00000o = i3;
                this.O00000oO = interpolator;
                this.O00000oo = true;
            }
        }
    }

    static class O00000Oo extends Observable<O00000o0> {
        O00000Oo() {
        }

        public final boolean O000000o() {
            return !this.mObservers.isEmpty();
        }

        public final void O00000Oo() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((O00000o0) this.mObservers.get(size)).onChanged();
            }
        }

        public final void O000000o(int i, int i2) {
            O000000o(i, i2, null);
        }

        public final void O000000o(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((O00000o0) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public final void O00000Oo(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((O00000o0) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public final void O00000o0(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((O00000o0) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public final void O00000o(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((O00000o0) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.recyclerview.widget.RecyclerView.SavedState.AnonymousClass1 */

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
        Parcelable f2953O000000o;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2953O000000o = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f2953O000000o, 0);
        }
    }

    public static class O000OO0o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2951O000000o = -1;
        int O00000Oo = 0;
        public int O00000o = 1;
        int O00000o0 = 0;
        public int O00000oO = 0;
        boolean O00000oo = false;
        public boolean O0000O0o = false;
        public boolean O0000OOo = false;
        boolean O0000Oo = false;
        public boolean O0000Oo0 = false;
        boolean O0000OoO = false;
        int O0000Ooo;
        private SparseArray<Object> O0000o;
        int O0000o0;
        long O0000o00;
        int O0000o0O;
        int O0000o0o;

        /* access modifiers changed from: package-private */
        public final void O000000o(int i) {
            if ((this.O00000o & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.O00000o));
            }
        }

        public final int O000000o() {
            return this.O0000O0o ? this.O00000Oo - this.O00000o0 : this.O00000oO;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.f2951O000000o + ", mData=" + this.O0000o + ", mItemCount=" + this.O00000oO + ", mIsMeasuring=" + this.O0000Oo0 + ", mPreviousLayoutItemCount=" + this.O00000Oo + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.O00000o0 + ", mStructureChanged=" + this.O00000oo + ", mInPreLayout=" + this.O0000O0o + ", mRunSimpleAnimations=" + this.O0000Oo + ", mRunPredictiveAnimations=" + this.O0000OoO + '}';
        }
    }

    class O0000Oo0 implements O0000OOo.O000000o {
        O0000Oo0() {
        }

        public final void O000000o(O000OOo0 o000OOo0) {
            o000OOo0.setIsRecyclable(true);
            if (o000OOo0.mShadowedHolder != null && o000OOo0.mShadowingHolder == null) {
                o000OOo0.mShadowedHolder = null;
            }
            o000OOo0.mShadowingHolder = null;
            if (!o000OOo0.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(o000OOo0.itemView) && o000OOo0.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(o000OOo0.itemView, false);
            }
        }
    }

    public static abstract class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        private ArrayList<Object> f2943O000000o = new ArrayList<>();
        O000000o O0000OOo = null;
        public long O0000Oo = 120;
        public long O0000Oo0 = 120;
        public long O0000OoO = 250;
        public long O0000Ooo = 250;

        interface O000000o {
            void O000000o(O000OOo0 o000OOo0);
        }

        public abstract void O000000o();

        public abstract boolean O000000o(O000OOo0 o000OOo0, O00000Oo o00000Oo, O00000Oo o00000Oo2);

        public abstract boolean O000000o(O000OOo0 o000OOo0, O000OOo0 o000OOo02, O00000Oo o00000Oo, O00000Oo o00000Oo2);

        public abstract boolean O00000Oo();

        public abstract boolean O00000Oo(O000OOo0 o000OOo0, O00000Oo o00000Oo, O00000Oo o00000Oo2);

        public abstract void O00000o();

        public abstract void O00000o0(O000OOo0 o000OOo0);

        public abstract boolean O00000o0(O000OOo0 o000OOo0, O00000Oo o00000Oo, O00000Oo o00000Oo2);

        public boolean O0000O0o(O000OOo0 o000OOo0) {
            return true;
        }

        static int O00000oO(O000OOo0 o000OOo0) {
            int i = o000OOo0.mFlags & 14;
            if (o000OOo0.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = o000OOo0.getOldPosition();
            int adapterPosition = o000OOo0.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public final void O00000oo(O000OOo0 o000OOo0) {
            O000000o o000000o = this.O0000OOo;
            if (o000000o != null) {
                o000000o.O000000o(o000OOo0);
            }
        }

        public boolean O000000o(O000OOo0 o000OOo0, List<Object> list) {
            return O0000O0o(o000OOo0);
        }

        public final void O00000oO() {
            int size = this.f2943O000000o.size();
            for (int i = 0; i < size; i++) {
                this.f2943O000000o.get(i);
            }
            this.f2943O000000o.clear();
        }

        public static class O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public int f2944O000000o;
            public int O00000Oo;
            public int O00000o;
            public int O00000o0;

            public final O00000Oo O000000o(O000OOo0 o000OOo0) {
                View view = o000OOo0.itemView;
                this.f2944O000000o = view.getLeft();
                this.O00000Oo = view.getTop();
                this.O00000o0 = view.getRight();
                this.O00000o = view.getBottom();
                return this;
            }
        }

        public static O00000Oo O00000o(O000OOo0 o000OOo0) {
            return new O00000Oo().O000000o(o000OOo0);
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        O00000o o00000o = this.mChildDrawingOrderCallback;
        if (o00000o == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return o00000o.O000000o(i, i2);
    }

    private br getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new br(this);
        }
        return this.mScrollingChildHelper;
    }
}
