package com.facebook.react.views.scroll;

import _m_j.az;
import _m_j.cb;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup {
    private static Field sScrollerField = null;
    private static boolean sTriedToGetScrollerField = false;
    public boolean mActivelyScrolling;
    private Rect mClippingRect;
    private float mDecelerationRate;
    private boolean mDisableIntervalMomentum;
    private boolean mDragging;
    private Drawable mEndBackground;
    private int mEndFillColor;
    private FpsListener mFpsListener;
    private final OnScrollDispatchHelper mOnScrollDispatchHelper;
    private String mOverflow;
    private boolean mPagedArrowScrolling;
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
    private final Rect mTempRect;
    private final VelocityHelper mVelocityHelper;

    public ReactHorizontalScrollView(Context context) {
        this(context, null);
    }

    public ReactHorizontalScrollView(Context context, FpsListener fpsListener) {
        super(context);
        this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
        this.mVelocityHelper = new VelocityHelper();
        this.mRect = new Rect();
        this.mOverflow = "hidden";
        this.mPagingEnabled = false;
        this.mScrollEnabled = true;
        this.mFpsListener = null;
        this.mEndFillColor = 0;
        this.mDisableIntervalMomentum = false;
        this.mSnapInterval = 0;
        this.mDecelerationRate = 0.985f;
        this.mSnapToStart = true;
        this.mSnapToEnd = true;
        this.mPagedArrowScrolling = false;
        this.mTempRect = new Rect();
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mFpsListener = fpsListener;
        this.mScroller = getOverScrollerFromParent();
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.w("ReactNative", "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
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
            Log.w("ReactNative", "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e);
        }
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
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

    public void setDisableIntervalMomentum(boolean z) {
        this.mDisableIntervalMomentum = z;
    }

    public void setSendMomentumEvents(boolean z) {
        this.mSendMomentumEvents = z;
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
    public void onDraw(Canvas canvas) {
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        if (((str.hashCode() == 466743410 && str.equals("visible")) ? (char) 0 : 65535) != 0) {
            canvas.clipRect(this.mRect);
        }
        super.onDraw(canvas);
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

    public void requestChildFocus(View view, View view2) {
        if (view2 != null && !this.mPagingEnabled) {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (!this.mPagingEnabled || this.mPagedArrowScrolling) {
            super.addFocusables(arrayList, i, i2);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i, i2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (isScrolledInView(view) || isPartiallyScrolledInView(view) || view.isFocused()) {
                arrayList.add(view);
            }
        }
    }

    private int getScrollDelta(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    }

    private boolean isScrolledInView(View view) {
        return getScrollDelta(view) == 0;
    }

    private boolean isPartiallyScrolledInView(View view) {
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.mTempRect);
        return scrollDelta != 0 && Math.abs(scrollDelta) < this.mTempRect.width();
    }

    private boolean isMostlyScrolledInView(View view) {
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.mTempRect);
        return scrollDelta != 0 && Math.abs(scrollDelta) < this.mTempRect.width() / 2;
    }

    private void scrollToChild(View view) {
        int scrollDelta = getScrollDelta(view);
        if (scrollDelta != 0) {
            scrollBy(scrollDelta, 0);
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

    public boolean pageScroll(int i) {
        boolean pageScroll = super.pageScroll(i);
        if (this.mPagingEnabled && pageScroll) {
            handlePostTouchScrolling(0, 0);
        }
        return pageScroll;
    }

    public boolean arrowScroll(int i) {
        if (!this.mPagingEnabled) {
            return super.arrowScroll(i);
        }
        boolean z = true;
        this.mPagedArrowScrolling = true;
        if (getChildCount() > 0) {
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus(), i);
            View childAt = getChildAt(0);
            if (childAt == null || findNextFocus == null || findNextFocus.getParent() != childAt) {
                smoothScrollToNextPage(i);
            } else {
                if (!isScrolledInView(findNextFocus) && !isMostlyScrolledInView(findNextFocus)) {
                    smoothScrollToNextPage(i);
                }
                findNextFocus.requestFocus();
            }
        } else {
            z = false;
        }
        this.mPagedArrowScrolling = false;
        return z;
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
        if (this.mScrollEnabled || (keyCode != 21 && keyCode != 22)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void fling(int i) {
        int abs = (int) (((float) Math.abs(i)) * Math.signum(this.mOnScrollDispatchHelper.getXFlingVelocity()));
        if (this.mPagingEnabled) {
            flingAndSnap(abs);
        } else if (this.mScroller != null) {
            int width = (getWidth() - cb.O0000OoO(this)) - cb.O0000Ooo(this);
            this.mScroller.fling(getScrollX(), getScrollY(), abs, 0, 0, Integer.MAX_VALUE, 0, 0, width / 2, 0);
            cb.O00000oo(this);
        } else {
            super.fling(abs);
        }
        handlePostTouchScrolling(abs, 0);
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

    private int getSnapInterval() {
        int i = this.mSnapInterval;
        if (i != 0) {
            return i;
        }
        return getWidth();
    }

    public void setEndFillColor(int i) {
        if (i != this.mEndFillColor) {
            this.mEndFillColor = i;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        int computeHorizontalScrollRange;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null && !overScroller.isFinished() && this.mScroller.getCurrX() != this.mScroller.getFinalX() && i >= (computeHorizontalScrollRange = computeHorizontalScrollRange() - getWidth())) {
            this.mScroller.abortAnimation();
            i = computeHorizontalScrollRange;
        }
        super.onOverScrolled(i, i2, z, z2);
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

    public void draw(Canvas canvas) {
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getRight() >= getWidth())) {
                this.mEndBackground.setBounds(childAt.getRight(), 0, getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    private void handlePostTouchScrolling(int i, int i2) {
        if ((this.mSendMomentumEvents || this.mPagingEnabled || isScrollPerfLoggingEnabled()) && this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i, i2);
            }
            this.mActivelyScrolling = false;
            this.mPostTouchRunnable = new Runnable() {
                /* class com.facebook.react.views.scroll.ReactHorizontalScrollView.AnonymousClass1 */
                private boolean mSnappingToPage = false;

                public void run() {
                    if (ReactHorizontalScrollView.this.mActivelyScrolling) {
                        ReactHorizontalScrollView reactHorizontalScrollView = ReactHorizontalScrollView.this;
                        reactHorizontalScrollView.mActivelyScrolling = false;
                        cb.O000000o(reactHorizontalScrollView, this, 20);
                    } else if (!ReactHorizontalScrollView.this.mPagingEnabled || this.mSnappingToPage) {
                        if (ReactHorizontalScrollView.this.mSendMomentumEvents) {
                            ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
                        }
                        ReactHorizontalScrollView reactHorizontalScrollView2 = ReactHorizontalScrollView.this;
                        reactHorizontalScrollView2.mPostTouchRunnable = null;
                        reactHorizontalScrollView2.disableFpsListener();
                    } else {
                        this.mSnappingToPage = true;
                        ReactHorizontalScrollView.this.flingAndSnap(0);
                        cb.O000000o(ReactHorizontalScrollView.this, this, 20);
                    }
                }
            };
            cb.O000000o(this, this.mPostTouchRunnable, 20);
        }
    }

    private int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
        int width = ((getWidth() - cb.O0000OoO(this)) - cb.O0000Ooo(this)) / 2;
        overScroller.fling(getScrollX(), getScrollY(), i, 0, 0, max, 0, 0, width, 0);
        return overScroller.getFinalX();
    }

    private void smoothScrollAndSnap(int i) {
        double snapInterval = (double) getSnapInterval();
        double scrollX = (double) getScrollX();
        double predictFinalScrollPosition = (double) predictFinalScrollPosition(i);
        Double.isNaN(scrollX);
        Double.isNaN(snapInterval);
        double d = scrollX / snapInterval;
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
        if (d3 != scrollX) {
            this.mActivelyScrolling = true;
            smoothScrollTo((int) d3, getScrollY());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0155  */
    public void flingAndSnap(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        OverScroller overScroller;
        int i7;
        if (getChildCount() > 0) {
            if (this.mSnapInterval == 0 && this.mSnapOffsets == null) {
                smoothScrollAndSnap(i);
                return;
            }
            int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
            int predictFinalScrollPosition = predictFinalScrollPosition(i);
            if (this.mDisableIntervalMomentum) {
                predictFinalScrollPosition = getScrollX();
            }
            int width = (getWidth() - cb.O0000OoO(this)) - cb.O0000Ooo(this);
            boolean z = az.O000000o(Locale.getDefault()) == 1;
            if (z) {
                predictFinalScrollPosition = max - predictFinalScrollPosition;
                i2 = -i;
            } else {
                i2 = i;
            }
            List<Integer> list = this.mSnapOffsets;
            if (list != null) {
                int intValue = list.get(0).intValue();
                List<Integer> list2 = this.mSnapOffsets;
                i5 = list2.get(list2.size() - 1).intValue();
                int i8 = max;
                i3 = 0;
                for (int i9 = 0; i9 < this.mSnapOffsets.size(); i9++) {
                    int intValue2 = this.mSnapOffsets.get(i9).intValue();
                    if (intValue2 <= predictFinalScrollPosition && predictFinalScrollPosition - intValue2 < predictFinalScrollPosition - i3) {
                        i3 = intValue2;
                    }
                    if (intValue2 >= predictFinalScrollPosition && intValue2 - predictFinalScrollPosition < i8 - predictFinalScrollPosition) {
                        i8 = intValue2;
                    }
                }
                i4 = intValue;
                i6 = i8;
            } else {
                double snapInterval = (double) getSnapInterval();
                double d = (double) predictFinalScrollPosition;
                Double.isNaN(d);
                Double.isNaN(snapInterval);
                double d2 = d / snapInterval;
                double floor = Math.floor(d2);
                Double.isNaN(snapInterval);
                double ceil = Math.ceil(d2);
                Double.isNaN(snapInterval);
                i6 = Math.min((int) (ceil * snapInterval), max);
                i5 = max;
                i3 = (int) (floor * snapInterval);
                i4 = 0;
            }
            int i10 = predictFinalScrollPosition - i3;
            int i11 = i6 - predictFinalScrollPosition;
            int i12 = i10 < i11 ? i3 : i6;
            int scrollX = getScrollX();
            if (z) {
                scrollX = max - scrollX;
            }
            if (this.mSnapToEnd || predictFinalScrollPosition < i5) {
                if (this.mSnapToStart || predictFinalScrollPosition > i4) {
                    if (i2 > 0) {
                        double d3 = (double) i11;
                        Double.isNaN(d3);
                        i2 += (int) (d3 * 10.0d);
                        i12 = i6;
                    } else if (i2 < 0) {
                        double d4 = (double) i10;
                        Double.isNaN(d4);
                        i2 -= (int) (d4 * 10.0d);
                        i12 = i3;
                    }
                    int min = Math.min(Math.max(0, i12), max);
                    if (z) {
                        min = max - min;
                        i2 = -i2;
                    }
                    overScroller = this.mScroller;
                    if (overScroller == null) {
                        this.mActivelyScrolling = true;
                        int scrollX2 = getScrollX();
                        int scrollY = getScrollY();
                        if (i2 != 0) {
                            i7 = i2;
                        } else {
                            i7 = min - getScrollX();
                        }
                        overScroller.fling(scrollX2, scrollY, i7, 0, min, min, 0, 0, (min == 0 || min == max) ? width / 2 : 0, 0);
                        postInvalidateOnAnimation();
                        return;
                    }
                    smoothScrollTo(min, getScrollY());
                    return;
                } else if (scrollX > i4) {
                    i12 = i4;
                    int min2 = Math.min(Math.max(0, i12), max);
                    if (z) {
                    }
                    overScroller = this.mScroller;
                    if (overScroller == null) {
                    }
                }
            } else if (scrollX < i5) {
                i12 = i5;
                int min22 = Math.min(Math.max(0, i12), max);
                if (z) {
                }
                overScroller = this.mScroller;
                if (overScroller == null) {
                }
            }
            i12 = predictFinalScrollPosition;
            int min222 = Math.min(Math.max(0, i12), max);
            if (z) {
            }
            overScroller = this.mScroller;
            if (overScroller == null) {
            }
        }
    }

    private void smoothScrollToNextPage(int i) {
        int width = getWidth();
        int scrollX = getScrollX();
        int i2 = scrollX / width;
        if (scrollX % width != 0) {
            i2++;
        }
        int i3 = i == 17 ? i2 - 1 : i2 + 1;
        if (i3 < 0) {
            i3 = 0;
        }
        smoothScrollTo(i3 * width, getScrollY());
        handlePostTouchScrolling(0, 0);
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
