package com.facebook.react.views.scroll;

import _m_j.cb;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
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
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.List;

public class ReactScrollView extends ScrollView implements View.OnLayoutChangeListener, ViewGroup.OnHierarchyChangeListener, ReactClippingViewGroup {
    private static Field sScrollerField = null;
    private static boolean sTriedToGetScrollerField = false;
    public boolean mActivelyScrolling;
    private Rect mClippingRect;
    private View mContentView;
    private float mDecelerationRate;
    private boolean mDragging;
    private Drawable mEndBackground;
    private int mEndFillColor;
    private FpsListener mFpsListener;
    private final OnScrollDispatchHelper mOnScrollDispatchHelper;
    private String mOverflow;
    public boolean mPagingEnabled;
    public Runnable mPostTouchRunnable;
    private ReactViewBackgroundManager mReactBackgroundManager;
    private final Rect mRect;
    private boolean mRemoveClippedSubviews;
    private boolean mScrollEnabled;
    private String mScrollPerfTag;
    private final OverScroller mScroller;
    public boolean mSendMomentumEvents;
    private int mSnapInterval;
    private List<Integer> mSnapOffsets;
    private boolean mSnapToEnd;
    private boolean mSnapToStart;
    private final VelocityHelper mVelocityHelper;

    public ReactScrollView(ReactContext reactContext) {
        this(reactContext, null);
    }

    public ReactScrollView(ReactContext reactContext, FpsListener fpsListener) {
        super(reactContext);
        this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
        this.mVelocityHelper = new VelocityHelper();
        this.mRect = new Rect();
        this.mOverflow = "hidden";
        this.mPagingEnabled = false;
        this.mScrollEnabled = true;
        this.mFpsListener = null;
        this.mEndFillColor = 0;
        this.mSnapInterval = 0;
        this.mDecelerationRate = 0.985f;
        this.mSnapToStart = true;
        this.mSnapToEnd = true;
        this.mFpsListener = fpsListener;
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mScroller = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.w("ReactNative", "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = sScrollerField;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            Log.w("ReactNative", "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from ScrollView!", e);
        }
    }

    public void setSendMomentumEvents(boolean z) {
        this.mSendMomentumEvents = z;
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void setPagingEnabled(boolean z) {
        this.mPagingEnabled = z;
    }

    public void setDecelerationRate(float f) {
        this.mDecelerationRate = f;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - this.mDecelerationRate);
        }
    }

    public void setSnapInterval(int i) {
        this.mSnapInterval = i;
    }

    public void setSnapOffsets(List<Integer> list) {
        this.mSnapOffsets = list;
    }

    public void setSnapToStart(boolean z) {
        this.mSnapToStart = z;
    }

    public void setSnapToEnd(boolean z) {
        this.mSnapToEnd = z;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null) {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void scrollToChild(View view) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mActivelyScrolling = true;
        if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
            if (this.mRemoveClippedSubviews) {
                updateClippingRect();
            }
            ReactScrollViewHelper.emitScrollEvent(this, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                ReactScrollViewHelper.emitScrollBeginDragEvent(this);
                this.mDragging = true;
                enableFpsListener();
                return true;
            }
        } catch (IllegalArgumentException e) {
            Log.w("ReactNative", "Error intercepting touch event.", e);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        this.mVelocityHelper.calculateVelocity(motionEvent);
        if ((motionEvent.getAction() & 255) == 1 && this.mDragging) {
            float xVelocity = this.mVelocityHelper.getXVelocity();
            float yVelocity = this.mVelocityHelper.getYVelocity();
            ReactScrollViewHelper.emitScrollEndDragEvent(this, xVelocity, yVelocity);
            this.mDragging = false;
            handlePostTouchScrolling(Math.round(xVelocity), Math.round(yVelocity));
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mScrollEnabled || (keyCode != 19 && keyCode != 20)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.mClippingRect == null) {
            this.mClippingRect = new Rect();
        }
        this.mRemoveClippedSubviews = z;
        updateClippingRect();
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).updateClippingRect();
            }
        }
    }

    public void getClippingRect(Rect rect) {
        rect.set((Rect) Assertions.assertNotNull(this.mClippingRect));
    }

    public void fling(int i) {
        float signum = Math.signum(this.mOnScrollDispatchHelper.getYFlingVelocity());
        if (signum == 0.0f) {
            signum = Math.signum((float) i);
        }
        int abs = (int) (((float) Math.abs(i)) * signum);
        if (this.mPagingEnabled) {
            flingAndSnap(abs);
        } else if (this.mScroller != null) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, abs, 0, 0, 0, Integer.MAX_VALUE, 0, height / 2);
            cb.O00000oo(this);
        } else {
            super.fling(abs);
        }
        handlePostTouchScrolling(0, abs);
    }

    private void enableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.enable(this.mScrollPerfTag);
        }
    }

    public void disableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.disable(this.mScrollPerfTag);
        }
    }

    private boolean isScrollPerfLoggingEnabled() {
        String str;
        return (this.mFpsListener == null || (str = this.mScrollPerfTag) == null || str.isEmpty()) ? false : true;
    }

    private int getMaxScrollY() {
        return Math.max(0, this.mContentView.getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    public void draw(Canvas canvas) {
        char c = 0;
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.mEndBackground.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        if (str.hashCode() != 466743410 || !str.equals("visible")) {
            c = 65535;
        }
        if (c != 0) {
            canvas.clipRect(this.mRect);
        }
        super.draw(canvas);
    }

    private void handlePostTouchScrolling(int i, int i2) {
        if ((this.mSendMomentumEvents || this.mPagingEnabled || isScrollPerfLoggingEnabled()) && this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                enableFpsListener();
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i, i2);
            }
            this.mActivelyScrolling = false;
            this.mPostTouchRunnable = new Runnable() {
                /* class com.facebook.react.views.scroll.ReactScrollView.AnonymousClass1 */
                private boolean mSnappingToPage = false;

                public void run() {
                    if (ReactScrollView.this.mActivelyScrolling) {
                        ReactScrollView reactScrollView = ReactScrollView.this;
                        reactScrollView.mActivelyScrolling = false;
                        cb.O000000o(reactScrollView, this, 20);
                    } else if (!ReactScrollView.this.mPagingEnabled || this.mSnappingToPage) {
                        if (ReactScrollView.this.mSendMomentumEvents) {
                            ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactScrollView.this);
                        }
                        ReactScrollView reactScrollView2 = ReactScrollView.this;
                        reactScrollView2.mPostTouchRunnable = null;
                        reactScrollView2.disableFpsListener();
                    } else {
                        this.mSnappingToPage = true;
                        ReactScrollView.this.flingAndSnap(0);
                        cb.O000000o(ReactScrollView.this, this, 20);
                    }
                }
            };
            cb.O000000o(this, this.mPostTouchRunnable, 20);
        }
    }

    private int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        int maxScrollY = getMaxScrollY();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2;
        overScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, maxScrollY, 0, height);
        return overScroller.getFinalY();
    }

    private void smoothScrollAndSnap(int i) {
        double snapInterval = (double) getSnapInterval();
        double scrollY = (double) getScrollY();
        double predictFinalScrollPosition = (double) predictFinalScrollPosition(i);
        Double.isNaN(scrollY);
        Double.isNaN(snapInterval);
        double d = scrollY / snapInterval;
        int floor = (int) Math.floor(d);
        int ceil = (int) Math.ceil(d);
        int round = (int) Math.round(d);
        Double.isNaN(predictFinalScrollPosition);
        Double.isNaN(snapInterval);
        int round2 = (int) Math.round(predictFinalScrollPosition / snapInterval);
        if (i > 0 && ceil == floor) {
            ceil++;
        } else if (i < 0 && floor == ceil) {
            floor--;
        }
        if (i > 0 && round < ceil && round2 > floor) {
            round = ceil;
        } else if (i < 0 && round > floor && round2 < ceil) {
            round = floor;
        }
        double d2 = (double) round;
        Double.isNaN(d2);
        Double.isNaN(snapInterval);
        double d3 = d2 * snapInterval;
        if (d3 != scrollY) {
            this.mActivelyScrolling = true;
            smoothScrollTo(getScrollX(), (int) d3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0130  */
    public void flingAndSnap(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        OverScroller overScroller;
        if (getChildCount() > 0) {
            if (this.mSnapInterval == 0 && this.mSnapOffsets == null) {
                smoothScrollAndSnap(i);
                return;
            }
            int maxScrollY = getMaxScrollY();
            int predictFinalScrollPosition = predictFinalScrollPosition(i);
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            List<Integer> list = this.mSnapOffsets;
            if (list != null) {
                int intValue = list.get(0).intValue();
                List<Integer> list2 = this.mSnapOffsets;
                int intValue2 = list2.get(list2.size() - 1).intValue();
                int i7 = maxScrollY;
                int i8 = 0;
                for (int i9 = 0; i9 < this.mSnapOffsets.size(); i9++) {
                    int intValue3 = this.mSnapOffsets.get(i9).intValue();
                    if (intValue3 <= predictFinalScrollPosition && predictFinalScrollPosition - intValue3 < predictFinalScrollPosition - i8) {
                        i8 = intValue3;
                    }
                    if (intValue3 >= predictFinalScrollPosition && intValue3 - predictFinalScrollPosition < i7 - predictFinalScrollPosition) {
                        i7 = intValue3;
                    }
                }
                i3 = intValue2;
                i4 = i7;
                int i10 = i8;
                i2 = intValue;
                i5 = i10;
            } else {
                double snapInterval = (double) getSnapInterval();
                double d = (double) predictFinalScrollPosition;
                Double.isNaN(d);
                Double.isNaN(snapInterval);
                double d2 = d / snapInterval;
                double floor = Math.floor(d2);
                Double.isNaN(snapInterval);
                i5 = (int) (floor * snapInterval);
                double ceil = Math.ceil(d2);
                Double.isNaN(snapInterval);
                i4 = Math.min((int) (ceil * snapInterval), maxScrollY);
                i3 = maxScrollY;
                i2 = 0;
            }
            int i11 = predictFinalScrollPosition - i5;
            int i12 = i4 - predictFinalScrollPosition;
            int i13 = i11 < i12 ? i5 : i4;
            if (this.mSnapToEnd || predictFinalScrollPosition < i3) {
                if (this.mSnapToStart || predictFinalScrollPosition > i2) {
                    if (i > 0) {
                        double d3 = (double) i12;
                        Double.isNaN(d3);
                        i6 = i + ((int) (d3 * 10.0d));
                        predictFinalScrollPosition = i4;
                    } else if (i < 0) {
                        double d4 = (double) i11;
                        Double.isNaN(d4);
                        int i14 = i5;
                        i6 = i - ((int) (d4 * 10.0d));
                        predictFinalScrollPosition = i14;
                    } else {
                        i6 = i;
                        predictFinalScrollPosition = i13;
                    }
                    int min = Math.min(Math.max(0, predictFinalScrollPosition), maxScrollY);
                    overScroller = this.mScroller;
                    if (overScroller == null) {
                        this.mActivelyScrolling = true;
                        int scrollX = getScrollX();
                        int scrollY = getScrollY();
                        if (i6 == 0) {
                            i6 = min - getScrollY();
                        }
                        overScroller.fling(scrollX, scrollY, 0, i6, 0, 0, min, min, 0, (min == 0 || min == maxScrollY) ? height / 2 : 0);
                        postInvalidateOnAnimation();
                        return;
                    }
                    smoothScrollTo(getScrollX(), min);
                    return;
                } else if (getScrollY() > i2) {
                    i6 = i;
                    predictFinalScrollPosition = i2;
                    int min2 = Math.min(Math.max(0, predictFinalScrollPosition), maxScrollY);
                    overScroller = this.mScroller;
                    if (overScroller == null) {
                    }
                }
            } else if (getScrollY() < i3) {
                i6 = i;
                predictFinalScrollPosition = i3;
                int min22 = Math.min(Math.max(0, predictFinalScrollPosition), maxScrollY);
                overScroller = this.mScroller;
                if (overScroller == null) {
                }
            }
            i6 = i;
            int min222 = Math.min(Math.max(0, predictFinalScrollPosition), maxScrollY);
            overScroller = this.mScroller;
            if (overScroller == null) {
            }
        }
    }

    private int getSnapInterval() {
        int i = this.mSnapInterval;
        if (i != 0) {
            return i;
        }
        return getHeight();
    }

    public void setEndFillColor(int i) {
        if (i != this.mEndFillColor) {
            this.mEndFillColor = i;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        int maxScrollY;
        OverScroller overScroller = this.mScroller;
        if (!(overScroller == null || this.mContentView == null || overScroller.isFinished() || this.mScroller.getCurrY() == this.mScroller.getFinalY() || i2 < (maxScrollY = getMaxScrollY()))) {
            this.mScroller.abortAnimation();
            i2 = maxScrollY;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    public void onChildViewAdded(View view, View view2) {
        this.mContentView = view2;
        this.mContentView.addOnLayoutChangeListener(this);
    }

    public void onChildViewRemoved(View view, View view2) {
        this.mContentView.removeOnLayoutChangeListener(this);
        this.mContentView = null;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int maxScrollY;
        if (this.mContentView != null && getScrollY() > (maxScrollY = getMaxScrollY())) {
            scrollTo(getScrollX(), maxScrollY);
        }
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }
}
