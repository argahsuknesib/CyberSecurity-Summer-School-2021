package androidx.recyclerview.widget;

import _m_j.gs;
import _m_j.gz;
import _m_j.hc;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements gs.O00000o, RecyclerView.O000OO00.O00000Oo {
    final O000000o mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final O00000Oo mLayoutChunkResult;
    private O00000o0 mLayoutState;
    int mOrientation;
    gz mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, O000000o o000000o, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new O000000o();
        this.mLayoutChunkResult = new O00000Oo();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new O000000o();
        this.mLayoutChunkResult = new O00000Oo();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.O000O0OO o000o0oo) {
        super.onDetachedFromWindow(recyclerView, o000o0oo);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(o000o0oo);
            o000o0oo.O000000o();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.O00000o0 = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.O00000Oo = this.mOrientationHelper.O00000o0() - this.mOrientationHelper.O00000Oo(childClosestToEnd);
                savedState2.f2935O000000o = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.f2935O000000o = getPosition(childClosestToStart);
                savedState2.O00000Oo = this.mOrientationHelper.O000000o(childClosestToStart) - this.mOrientationHelper.O00000Oo();
            }
        } else {
            savedState2.f2935O000000o = -1;
        }
        return savedState2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            if (i != this.mOrientation || this.mOrientationHelper == null) {
                this.mOrientationHelper = gz.O000000o(this, i);
                this.mAnchorInfo.f2932O000000o = this.mOrientationHelper;
                this.mOrientation = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            z = this.mReverseLayout;
        } else if (this.mReverseLayout) {
            z = false;
        }
        this.mShouldReverseLayout = z;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    /* access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(RecyclerView.O000OO0o o000OO0o, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(o000OO0o);
        if (this.mLayoutState.O00000oo == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayout) {
            i2 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void onLayoutChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View findViewByPosition;
        int i7;
        int i8;
        int i9 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && o000OO0o.O000000o() == 0) {
            removeAndRecycleAllViews(o000o0oo);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.O000000o()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f2935O000000o;
        }
        ensureLayoutState();
        this.mLayoutState.f2934O000000o = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.O00000oO || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.O000000o();
            O000000o o000000o = this.mAnchorInfo;
            o000000o.O00000o = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(o000o0oo, o000OO0o, o000000o);
            this.mAnchorInfo.O00000oO = true;
        } else if (focusedChild != null && (this.mOrientationHelper.O000000o(focusedChild) >= this.mOrientationHelper.O00000o0() || this.mOrientationHelper.O00000Oo(focusedChild) <= this.mOrientationHelper.O00000Oo())) {
            this.mAnchorInfo.O000000o(focusedChild, getPosition(focusedChild));
        }
        O00000o0 o00000o0 = this.mLayoutState;
        o00000o0.O00000oo = o00000o0.O0000OoO >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(o000OO0o, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.O00000Oo();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.O00000oo();
        if (!(!o000OO0o.O0000O0o || (i6 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i6)) == null)) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.O00000o0() - this.mOrientationHelper.O00000Oo(findViewByPosition);
                i8 = this.mPendingScrollPositionOffset;
            } else {
                i8 = this.mOrientationHelper.O000000o(findViewByPosition) - this.mOrientationHelper.O00000Oo();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i10 = i7 - i8;
            if (i10 > 0) {
                max += i10;
            } else {
                max2 -= i10;
            }
        }
        if (!this.mAnchorInfo.O00000o ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i9 = 1;
        }
        onAnchorReady(o000o0oo, o000OO0o, this.mAnchorInfo, i9);
        detachAndScrapAttachedViews(o000o0oo);
        this.mLayoutState.O0000o00 = resolveIsInfinite();
        this.mLayoutState.O0000Oo = o000OO0o.O0000O0o;
        this.mLayoutState.O0000Oo0 = 0;
        if (this.mAnchorInfo.O00000o) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            O00000o0 o00000o02 = this.mLayoutState;
            o00000o02.O0000OOo = max;
            fill(o000o0oo, o00000o02, o000OO0o, false);
            i2 = this.mLayoutState.O00000Oo;
            int i11 = this.mLayoutState.O00000o;
            if (this.mLayoutState.O00000o0 > 0) {
                max2 += this.mLayoutState.O00000o0;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            O00000o0 o00000o03 = this.mLayoutState;
            o00000o03.O0000OOo = max2;
            o00000o03.O00000o += this.mLayoutState.O00000oO;
            fill(o000o0oo, this.mLayoutState, o000OO0o, false);
            i = this.mLayoutState.O00000Oo;
            if (this.mLayoutState.O00000o0 > 0) {
                int i12 = this.mLayoutState.O00000o0;
                updateLayoutStateToFillStart(i11, i2);
                O00000o0 o00000o04 = this.mLayoutState;
                o00000o04.O0000OOo = i12;
                fill(o000o0oo, o00000o04, o000OO0o, false);
                i2 = this.mLayoutState.O00000Oo;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            O00000o0 o00000o05 = this.mLayoutState;
            o00000o05.O0000OOo = max2;
            fill(o000o0oo, o00000o05, o000OO0o, false);
            i = this.mLayoutState.O00000Oo;
            int i13 = this.mLayoutState.O00000o;
            if (this.mLayoutState.O00000o0 > 0) {
                max += this.mLayoutState.O00000o0;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            O00000o0 o00000o06 = this.mLayoutState;
            o00000o06.O0000OOo = max;
            o00000o06.O00000o += this.mLayoutState.O00000oO;
            fill(o000o0oo, this.mLayoutState, o000OO0o, false);
            i2 = this.mLayoutState.O00000Oo;
            if (this.mLayoutState.O00000o0 > 0) {
                int i14 = this.mLayoutState.O00000o0;
                updateLayoutStateToFillEnd(i13, i);
                O00000o0 o00000o07 = this.mLayoutState;
                o00000o07.O0000OOo = i14;
                fill(o000o0oo, o00000o07, o000OO0o, false);
                i = this.mLayoutState.O00000Oo;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i, o000o0oo, o000OO0o, true);
                i5 = i2 + fixLayoutEndGap;
                i3 = i + fixLayoutEndGap;
                i4 = fixLayoutStartGap(i5, o000o0oo, o000OO0o, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i2, o000o0oo, o000OO0o, true);
                i5 = i2 + fixLayoutStartGap;
                i3 = i + fixLayoutStartGap;
                i4 = fixLayoutEndGap(i3, o000o0oo, o000OO0o, false);
            }
            i2 = i5 + i4;
            i = i3 + i4;
        }
        layoutForPredictiveAnimations(o000o0oo, o000OO0o, i2, i);
        if (!o000OO0o.O0000O0o) {
            gz gzVar = this.mOrientationHelper;
            gzVar.O00000Oo = gzVar.O00000oO();
        } else {
            this.mAnchorInfo.O000000o();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView.O000OO0o o000OO0o) {
        super.onLayoutCompleted(o000OO0o);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.O000000o();
    }

    private void updateAnchorInfoForLayout(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, O000000o o000000o) {
        if (!updateAnchorFromPendingData(o000OO0o, o000000o) && !updateAnchorFromChildren(o000o0oo, o000OO0o, o000000o)) {
            o000000o.O00000Oo();
            o000000o.O00000Oo = this.mStackFromEnd ? o000OO0o.O000000o() - 1 : 0;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, O000000o o000000o) {
        View view;
        int i;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) focusedChild.getLayoutParams();
            if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < o000OO0o.O000000o()) {
                o000000o.O000000o(focusedChild, getPosition(focusedChild));
                return true;
            }
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (o000000o.O00000o) {
            view = findReferenceChildClosestToEnd(o000o0oo, o000OO0o);
        } else {
            view = findReferenceChildClosestToStart(o000o0oo, o000OO0o);
        }
        if (view == null) {
            return false;
        }
        o000000o.O00000Oo(view, getPosition(view));
        if (!o000OO0o.O0000O0o && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.O000000o(view) >= this.mOrientationHelper.O00000o0() || this.mOrientationHelper.O00000Oo(view) < this.mOrientationHelper.O00000Oo()) {
                z = true;
            }
            if (z) {
                if (o000000o.O00000o) {
                    i = this.mOrientationHelper.O00000o0();
                } else {
                    i = this.mOrientationHelper.O00000Oo();
                }
                o000000o.O00000o0 = i;
            }
        }
        return true;
    }

    private int fixLayoutEndGap(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, boolean z) {
        int O00000o02;
        int O00000o03 = this.mOrientationHelper.O00000o0() - i;
        if (O00000o03 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-O00000o03, o000o0oo, o000OO0o);
        int i3 = i + i2;
        if (!z || (O00000o02 = this.mOrientationHelper.O00000o0() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.O000000o(O00000o02);
        return O00000o02 + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, boolean z) {
        int O00000Oo2;
        int O00000Oo3 = i - this.mOrientationHelper.O00000Oo();
        if (O00000Oo3 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(O00000Oo3, o000o0oo, o000OO0o);
        int i3 = i + i2;
        if (!z || (O00000Oo2 = i3 - this.mOrientationHelper.O00000Oo()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.O000000o(-O00000Oo2);
        return i2 - O00000Oo2;
    }

    private void updateLayoutStateToFillEnd(O000000o o000000o) {
        updateLayoutStateToFillEnd(o000000o.O00000Oo, o000000o.O00000o0);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.O00000o0 = this.mOrientationHelper.O00000o0() - i2;
        this.mLayoutState.O00000oO = this.mShouldReverseLayout ? -1 : 1;
        O00000o0 o00000o0 = this.mLayoutState;
        o00000o0.O00000o = i;
        o00000o0.O00000oo = 1;
        o00000o0.O00000Oo = i2;
        o00000o0.O0000O0o = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(O000000o o000000o) {
        updateLayoutStateToFillStart(o000000o.O00000Oo, o000000o.O00000o0);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.O00000o0 = i2 - this.mOrientationHelper.O00000Oo();
        O00000o0 o00000o0 = this.mLayoutState;
        o00000o0.O00000o = i;
        o00000o0.O00000oO = this.mShouldReverseLayout ? 1 : -1;
        O00000o0 o00000o02 = this.mLayoutState;
        o00000o02.O00000oo = -1;
        o00000o02.O00000Oo = i2;
        o00000o02.O0000O0o = Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: package-private */
    public O00000o0 createLayoutState() {
        return new O00000o0();
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f2935O000000o = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f2935O000000o = -1;
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, o000o0oo, o000OO0o);
    }

    public int scrollVerticallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, o000o0oo, o000OO0o);
    }

    public int computeHorizontalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        return computeScrollOffset(o000OO0o);
    }

    public int computeVerticalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        return computeScrollOffset(o000OO0o);
    }

    public int computeHorizontalScrollExtent(RecyclerView.O000OO0o o000OO0o) {
        return computeScrollExtent(o000OO0o);
    }

    public int computeVerticalScrollExtent(RecyclerView.O000OO0o o000OO0o) {
        return computeScrollExtent(o000OO0o);
    }

    public int computeHorizontalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        return computeScrollRange(o000OO0o);
    }

    public int computeVerticalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        return computeScrollRange(o000OO0o);
    }

    private int computeScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        gz gzVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return hc.O000000o(o000OO0o, gzVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        gz gzVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return hc.O000000o(o000OO0o, gzVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        gz gzVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return hc.O00000Oo(o000OO0o, gzVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.O000OO0o o000OO0o) {
        int i3;
        this.mLayoutState.O0000o00 = resolveIsInfinite();
        this.mLayoutState.O00000oo = i;
        int[] iArr = this.mReusableIntPair;
        boolean z2 = false;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(o000OO0o, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i == 1) {
            z2 = true;
        }
        this.mLayoutState.O0000OOo = z2 ? max2 : max;
        O00000o0 o00000o0 = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        o00000o0.O0000Oo0 = max;
        int i4 = -1;
        if (z2) {
            this.mLayoutState.O0000OOo += this.mOrientationHelper.O00000oo();
            View childClosestToEnd = getChildClosestToEnd();
            O00000o0 o00000o02 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i4 = 1;
            }
            o00000o02.O00000oO = i4;
            this.mLayoutState.O00000o = getPosition(childClosestToEnd) + this.mLayoutState.O00000oO;
            this.mLayoutState.O00000Oo = this.mOrientationHelper.O00000Oo(childClosestToEnd);
            i3 = this.mOrientationHelper.O00000Oo(childClosestToEnd) - this.mOrientationHelper.O00000o0();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.O0000OOo += this.mOrientationHelper.O00000Oo();
            O00000o0 o00000o03 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i4 = 1;
            }
            o00000o03.O00000oO = i4;
            this.mLayoutState.O00000o = getPosition(childClosestToStart) + this.mLayoutState.O00000oO;
            this.mLayoutState.O00000Oo = this.mOrientationHelper.O000000o(childClosestToStart);
            i3 = (-this.mOrientationHelper.O000000o(childClosestToStart)) + this.mOrientationHelper.O00000Oo();
        }
        O00000o0 o00000o04 = this.mLayoutState;
        o00000o04.O00000o0 = i2;
        if (z) {
            o00000o04.O00000o0 -= i3;
        }
        this.mLayoutState.O0000O0o = i3;
    }

    /* access modifiers changed from: package-private */
    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.O0000O0o() == 0 && this.mOrientationHelper.O00000o() == 0;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.O000OO0o o000OO0o, O00000o0 o00000o0, RecyclerView.LayoutManager.O000000o o000000o) {
        int i = o00000o0.O00000o;
        if (i >= 0 && i < o000OO0o.O000000o()) {
            o000000o.O000000o(i, Math.max(0, o00000o0.O0000O0o));
        }
    }

    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.O000000o o000000o) {
        int i2;
        boolean z;
        SavedState savedState = this.mPendingSavedState;
        int i3 = -1;
        if (savedState == null || !savedState.O000000o()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = this.mPendingSavedState.O00000o0;
            i2 = this.mPendingSavedState.f2935O000000o;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            o000000o.O000000o(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.O000OO0o o000OO0o, RecyclerView.LayoutManager.O000000o o000000o) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            ensureLayoutState();
            updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, o000OO0o);
            collectPrefetchPositionsForLayoutState(o000OO0o, this.mLayoutState, o000000o);
        }
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f2934O000000o = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, o000OO0o);
        int fill = this.mLayoutState.O0000O0o + fill(o000o0oo, this.mLayoutState, o000OO0o, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.O000000o(-i);
        this.mLayoutState.O0000OoO = i;
        return i;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(RecyclerView.O000O0OO o000o0oo, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, o000o0oo);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, o000o0oo);
                i--;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.O000O0OO o000o0oo, int i, int i2) {
        if (i >= 0) {
            int i3 = i - i2;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i4 = childCount - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View childAt = getChildAt(i5);
                    if (this.mOrientationHelper.O00000Oo(childAt) > i3 || this.mOrientationHelper.O00000o0(childAt) > i3) {
                        recycleChildren(o000o0oo, i4, i5);
                        return;
                    }
                }
                return;
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (this.mOrientationHelper.O00000Oo(childAt2) > i3 || this.mOrientationHelper.O00000o0(childAt2) > i3) {
                    recycleChildren(o000o0oo, 0, i6);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.O000O0OO o000o0oo, int i, int i2) {
        int childCount = getChildCount();
        if (i >= 0) {
            int O00000o = (this.mOrientationHelper.O00000o() - i) + i2;
            if (this.mShouldReverseLayout) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (this.mOrientationHelper.O000000o(childAt) < O00000o || this.mOrientationHelper.O00000o(childAt) < O00000o) {
                        recycleChildren(o000o0oo, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (this.mOrientationHelper.O000000o(childAt2) < O00000o || this.mOrientationHelper.O00000o(childAt2) < O00000o) {
                    recycleChildren(o000o0oo, i4, i5);
                    return;
                }
            }
        }
    }

    private void recycleByLayoutState(RecyclerView.O000O0OO o000o0oo, O00000o0 o00000o0) {
        if (o00000o0.f2934O000000o && !o00000o0.O0000o00) {
            int i = o00000o0.O0000O0o;
            int i2 = o00000o0.O0000Oo0;
            if (o00000o0.O00000oo == -1) {
                recycleViewsFromEnd(o000o0oo, i, i2);
            } else {
                recycleViewsFromStart(o000o0oo, i, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int fill(RecyclerView.O000O0OO o000o0oo, O00000o0 o00000o0, RecyclerView.O000OO0o o000OO0o, boolean z) {
        int i = o00000o0.O00000o0;
        if (o00000o0.O0000O0o != Integer.MIN_VALUE) {
            if (o00000o0.O00000o0 < 0) {
                o00000o0.O0000O0o += o00000o0.O00000o0;
            }
            recycleByLayoutState(o000o0oo, o00000o0);
        }
        int i2 = o00000o0.O00000o0 + o00000o0.O0000OOo;
        O00000Oo o00000Oo = this.mLayoutChunkResult;
        while (true) {
            if ((!o00000o0.O0000o00 && i2 <= 0) || !o00000o0.O000000o(o000OO0o)) {
                break;
            }
            o00000Oo.f2933O000000o = 0;
            o00000Oo.O00000Oo = false;
            o00000Oo.O00000o0 = false;
            o00000Oo.O00000o = false;
            layoutChunk(o000o0oo, o000OO0o, o00000o0, o00000Oo);
            if (o00000Oo.O00000Oo) {
                break;
            }
            o00000o0.O00000Oo += o00000Oo.f2933O000000o * o00000o0.O00000oo;
            if (!o00000Oo.O00000o0 || o00000o0.O0000Ooo != null || !o000OO0o.O0000O0o) {
                o00000o0.O00000o0 -= o00000Oo.f2933O000000o;
                i2 -= o00000Oo.f2933O000000o;
            }
            if (o00000o0.O0000O0o != Integer.MIN_VALUE) {
                o00000o0.O0000O0o += o00000Oo.f2933O000000o;
                if (o00000o0.O00000o0 < 0) {
                    o00000o0.O0000O0o += o00000o0.O00000o0;
                }
                recycleByLayoutState(o000o0oo, o00000o0);
            }
            if (z && o00000Oo.O00000o) {
                break;
            }
        }
        return i - o00000o0.O00000o0;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, O00000o0 o00000o0, O00000Oo o00000Oo) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View O000000o2 = o00000o0.O000000o(o000o0oo);
        if (O000000o2 == null) {
            o00000Oo.O00000Oo = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) O000000o2.getLayoutParams();
        if (o00000o0.O0000Ooo == null) {
            if (this.mShouldReverseLayout == (o00000o0.O00000oo == -1)) {
                addView(O000000o2);
            } else {
                addView(O000000o2, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (o00000o0.O00000oo == -1)) {
                addDisappearingView(O000000o2);
            } else {
                addDisappearingView(O000000o2, 0);
            }
        }
        measureChildWithMargins(O000000o2, 0, 0);
        o00000Oo.f2933O000000o = this.mOrientationHelper.O00000oO(O000000o2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i5 = getWidth() - getPaddingRight();
                i4 = i5 - this.mOrientationHelper.O00000oo(O000000o2);
            } else {
                i4 = getPaddingLeft();
                i5 = this.mOrientationHelper.O00000oo(O000000o2) + i4;
            }
            if (o00000o0.O00000oo == -1) {
                int i6 = o00000o0.O00000Oo;
                i3 = o00000o0.O00000Oo - o00000Oo.f2933O000000o;
                i2 = i5;
                i = i6;
            } else {
                int i7 = o00000o0.O00000Oo;
                i = o00000o0.O00000Oo + o00000Oo.f2933O000000o;
                i2 = i5;
                i3 = i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int O00000oo = this.mOrientationHelper.O00000oo(O000000o2) + paddingTop;
            if (o00000o0.O00000oo == -1) {
                i3 = paddingTop;
                i2 = o00000o0.O00000Oo;
                i = O00000oo;
                i4 = o00000o0.O00000Oo - o00000Oo.f2933O000000o;
            } else {
                int i8 = o00000o0.O00000Oo;
                i2 = o00000o0.O00000Oo + o00000Oo.f2933O000000o;
                i3 = paddingTop;
                i = O00000oo;
                i4 = i8;
            }
        }
        layoutDecoratedWithMargins(O000000o2, i4, i3, i2, i);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            o00000Oo.O00000o0 = true;
        }
        o00000Oo.O00000o = O000000o2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(o000o0oo, o000OO0o);
        }
        return findLastReferenceChild(o000o0oo, o000OO0o);
    }

    private View findReferenceChildClosestToStart(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(o000o0oo, o000OO0o);
        }
        return findFirstReferenceChild(o000o0oo, o000OO0o);
    }

    private View findFirstReferenceChild(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        return findReferenceChild(o000o0oo, o000OO0o, 0, getChildCount(), o000OO0o.O000000o());
    }

    private View findLastReferenceChild(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        return findReferenceChild(o000o0oo, o000OO0o, getChildCount() - 1, -1, o000OO0o.O000000o());
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i, int i2, int i3) {
        ensureLayoutState();
        int O00000Oo2 = this.mOrientationHelper.O00000Oo();
        int O00000o02 = this.mOrientationHelper.O00000o0();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.O000000o(childAt) < O00000o02 && this.mOrientationHelper.O00000Oo(childAt) >= O00000Oo2) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.O000000o(i, i2, i4, i3);
        }
        return this.mVerticalBoundCheck.O000000o(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.O000000o(getChildAt(i)) < this.mOrientationHelper.O00000Oo()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.O000000o(i, i2, i4, i3);
        }
        return this.mVerticalBoundCheck.O000000o(i, i2, i4, i3);
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.O00000oO()) * 0.33333334f), false, o000OO0o);
        O00000o0 o00000o0 = this.mLayoutState;
        o00000o0.O0000O0o = Integer.MIN_VALUE;
        o00000o0.f2934O000000o = false;
        fill(o000o0oo, o00000o0, o000OO0o, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    private void logChildren() {
        Log.d("LinearLayoutManager", "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d("LinearLayoutManager", "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.O000000o(childAt));
        }
        Log.d("LinearLayoutManager", "==============");
    }

    /* access modifiers changed from: package-private */
    public void validateChildOrder() {
        Log.d("LinearLayoutManager", "validating child count " + getChildCount());
        if (getChildCount() > 0) {
            boolean z = false;
            int position = getPosition(getChildAt(0));
            int O000000o2 = this.mOrientationHelper.O000000o(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i = 1;
                while (i < getChildCount()) {
                    View childAt = getChildAt(i);
                    int position2 = getPosition(childAt);
                    int O000000o3 = this.mOrientationHelper.O000000o(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                        if (O000000o3 < O000000o2) {
                            z = true;
                        }
                        sb.append(z);
                        throw new RuntimeException(sb.toString());
                    } else if (O000000o3 <= O000000o2) {
                        i++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i2 = 1;
            while (i2 < getChildCount()) {
                View childAt2 = getChildAt(i2);
                int position3 = getPosition(childAt2);
                int O000000o4 = this.mOrientationHelper.O000000o(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                    if (O000000o4 < O000000o2) {
                        z = true;
                    }
                    sb2.append(z);
                    throw new RuntimeException(sb2.toString());
                } else if (O000000o4 >= O000000o2) {
                    i2++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : 65535;
        if (this.mShouldReverseLayout) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.O00000o0() - (this.mOrientationHelper.O000000o(view2) + this.mOrientationHelper.O00000oO(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.O00000o0() - this.mOrientationHelper.O00000Oo(view2));
            }
        } else if (c == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.O000000o(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.O00000Oo(view2) - this.mOrientationHelper.O00000oO(view));
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2934O000000o = true;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        int O0000O0o;
        int O0000OOo = 0;
        boolean O0000Oo = false;
        int O0000Oo0 = 0;
        int O0000OoO;
        List<RecyclerView.O000OOo0> O0000Ooo = null;
        boolean O0000o00;

        O00000o0() {
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(RecyclerView.O000OO0o o000OO0o) {
            int i = this.O00000o;
            return i >= 0 && i < o000OO0o.O000000o();
        }

        /* access modifiers changed from: package-private */
        public final View O000000o(RecyclerView.O000O0OO o000o0oo) {
            if (this.O0000Ooo != null) {
                return O000000o();
            }
            View O00000o02 = o000o0oo.O00000o0(this.O00000o);
            this.O00000o += this.O00000oO;
            return O00000o02;
        }

        private View O000000o() {
            int size = this.O0000Ooo.size();
            int i = 0;
            while (i < size) {
                View view = this.O0000Ooo.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.isItemRemoved() || this.O00000o != layoutParams.getViewLayoutPosition()) {
                    i++;
                } else {
                    O000000o(view);
                    return view;
                }
            }
            return null;
        }

        public final void O000000o(View view) {
            View O00000Oo2 = O00000Oo(view);
            if (O00000Oo2 == null) {
                this.O00000o = -1;
            } else {
                this.O00000o = ((RecyclerView.LayoutParams) O00000Oo2.getLayoutParams()).getViewLayoutPosition();
            }
        }

        private View O00000Oo(View view) {
            int viewLayoutPosition;
            int size = this.O0000Ooo.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.O0000Ooo.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.O00000o) * this.O00000oO) >= 0 && viewLayoutPosition < i) {
                    if (viewLayoutPosition == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.recyclerview.widget.LinearLayoutManager.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f2935O000000o;
        int O00000Oo;
        boolean O00000o0;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2935O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f2935O000000o = savedState.f2935O000000o;
            this.O00000Oo = savedState.O00000Oo;
            this.O00000o0 = savedState.O00000o0;
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return this.f2935O000000o >= 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2935O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0 ? 1 : 0);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        gz f2932O000000o;
        int O00000Oo;
        boolean O00000o;
        int O00000o0;
        boolean O00000oO;

        O000000o() {
            O000000o();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.O00000Oo = -1;
            this.O00000o0 = Integer.MIN_VALUE;
            this.O00000o = false;
            this.O00000oO = false;
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            int i;
            if (this.O00000o) {
                i = this.f2932O000000o.O00000o0();
            } else {
                i = this.f2932O000000o.O00000Oo();
            }
            this.O00000o0 = i;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.O00000Oo + ", mCoordinate=" + this.O00000o0 + ", mLayoutFromEnd=" + this.O00000o + ", mValid=" + this.O00000oO + '}';
        }

        public final void O000000o(View view, int i) {
            int O000000o2 = this.f2932O000000o.O000000o();
            if (O000000o2 >= 0) {
                O00000Oo(view, i);
                return;
            }
            this.O00000Oo = i;
            if (this.O00000o) {
                int O00000o02 = (this.f2932O000000o.O00000o0() - O000000o2) - this.f2932O000000o.O00000Oo(view);
                this.O00000o0 = this.f2932O000000o.O00000o0() - O00000o02;
                if (O00000o02 > 0) {
                    int O00000oO2 = this.O00000o0 - this.f2932O000000o.O00000oO(view);
                    int O00000Oo2 = this.f2932O000000o.O00000Oo();
                    int min = O00000oO2 - (O00000Oo2 + Math.min(this.f2932O000000o.O000000o(view) - O00000Oo2, 0));
                    if (min < 0) {
                        this.O00000o0 += Math.min(O00000o02, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int O000000o3 = this.f2932O000000o.O000000o(view);
            int O00000Oo3 = O000000o3 - this.f2932O000000o.O00000Oo();
            this.O00000o0 = O000000o3;
            if (O00000Oo3 > 0) {
                int O00000o03 = (this.f2932O000000o.O00000o0() - Math.min(0, (this.f2932O000000o.O00000o0() - O000000o2) - this.f2932O000000o.O00000Oo(view))) - (O000000o3 + this.f2932O000000o.O00000oO(view));
                if (O00000o03 < 0) {
                    this.O00000o0 -= Math.min(O00000Oo3, -O00000o03);
                }
            }
        }

        public final void O00000Oo(View view, int i) {
            if (this.O00000o) {
                this.O00000o0 = this.f2932O000000o.O00000Oo(view) + this.f2932O000000o.O000000o();
            } else {
                this.O00000o0 = this.f2932O000000o.O000000o(view);
            }
            this.O00000Oo = i;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2933O000000o;
        public boolean O00000Oo;
        public boolean O00000o;
        public boolean O00000o0;

        protected O00000Oo() {
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.O000OO0o o000OO0o) {
        if (o000OO0o.f2951O000000o != -1) {
            return this.mOrientationHelper.O00000oO();
        }
        return 0;
    }

    private void layoutForPredictiveAnimations(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i, int i2) {
        RecyclerView.O000O0OO o000o0oo2 = o000o0oo;
        RecyclerView.O000OO0o o000OO0o2 = o000OO0o;
        if (o000OO0o2.O0000OoO && getChildCount() != 0 && !o000OO0o2.O0000O0o && supportsPredictiveItemAnimations()) {
            List<RecyclerView.O000OOo0> list = o000o0oo2.O00000o;
            int size = list.size();
            int position = getPosition(getChildAt(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.O000OOo0 o000OOo0 = list.get(i5);
                if (!o000OOo0.isRemoved()) {
                    char c = 1;
                    if ((o000OOo0.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                        c = 65535;
                    }
                    if (c == 65535) {
                        i3 += this.mOrientationHelper.O00000oO(o000OOo0.itemView);
                    } else {
                        i4 += this.mOrientationHelper.O00000oO(o000OOo0.itemView);
                    }
                }
            }
            this.mLayoutState.O0000Ooo = list;
            if (i3 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                O00000o0 o00000o0 = this.mLayoutState;
                o00000o0.O0000OOo = i3;
                o00000o0.O00000o0 = 0;
                o00000o0.O000000o((View) null);
                fill(o000o0oo2, this.mLayoutState, o000OO0o2, false);
            }
            if (i4 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                O00000o0 o00000o02 = this.mLayoutState;
                o00000o02.O0000OOo = i4;
                o00000o02.O00000o0 = 0;
                o00000o02.O000000o((View) null);
                fill(o000o0oo2, this.mLayoutState, o000OO0o2, false);
            }
            this.mLayoutState.O0000Ooo = null;
        }
    }

    private boolean updateAnchorFromPendingData(RecyclerView.O000OO0o o000OO0o, O000000o o000000o) {
        int i;
        int i2;
        boolean z = false;
        if (!o000OO0o.O0000O0o && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= o000OO0o.O000000o()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                o000000o.O00000Oo = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.O000000o()) {
                    o000000o.O00000o = this.mPendingSavedState.O00000o0;
                    if (o000000o.O00000o) {
                        o000000o.O00000o0 = this.mOrientationHelper.O00000o0() - this.mPendingSavedState.O00000Oo;
                    } else {
                        o000000o.O00000o0 = this.mOrientationHelper.O00000Oo() + this.mPendingSavedState.O00000Oo;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if ((this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout) {
                                z = true;
                            }
                            o000000o.O00000o = z;
                        }
                        o000000o.O00000Oo();
                    } else if (this.mOrientationHelper.O00000oO(findViewByPosition) > this.mOrientationHelper.O00000oO()) {
                        o000000o.O00000Oo();
                        return true;
                    } else if (this.mOrientationHelper.O000000o(findViewByPosition) - this.mOrientationHelper.O00000Oo() < 0) {
                        o000000o.O00000o0 = this.mOrientationHelper.O00000Oo();
                        o000000o.O00000o = false;
                        return true;
                    } else if (this.mOrientationHelper.O00000o0() - this.mOrientationHelper.O00000Oo(findViewByPosition) < 0) {
                        o000000o.O00000o0 = this.mOrientationHelper.O00000o0();
                        o000000o.O00000o = true;
                        return true;
                    } else {
                        if (o000000o.O00000o) {
                            i2 = this.mOrientationHelper.O00000Oo(findViewByPosition) + this.mOrientationHelper.O000000o();
                        } else {
                            i2 = this.mOrientationHelper.O000000o(findViewByPosition);
                        }
                        o000000o.O00000o0 = i2;
                    }
                    return true;
                } else {
                    boolean z2 = this.mShouldReverseLayout;
                    o000000o.O00000o = z2;
                    if (z2) {
                        o000000o.O00000o0 = this.mOrientationHelper.O00000o0() - this.mPendingScrollPositionOffset;
                    } else {
                        o000000o.O00000o0 = this.mOrientationHelper.O00000Oo() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
