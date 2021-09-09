package androidx.recyclerview.widget;

import _m_j.cl;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    O00000Oo mSpanSizeLookup = new O000000o();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(getProperties(context, attributeSet, i, i2).spanCount);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        setSpanCount(i);
    }

    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public int getRowCountForAccessibility(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (o000OO0o.O000000o() <= 0) {
            return 0;
        }
        return getSpanGroupIndex(o000o0oo, o000OO0o, o000OO0o.O000000o() - 1) + 1;
    }

    public int getColumnCountForAccessibility(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (o000OO0o.O000000o() <= 0) {
            return 0;
        }
        return getSpanGroupIndex(o000o0oo, o000OO0o, o000OO0o.O000000o() - 1) + 1;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, View view, cl clVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, clVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(o000o0oo, o000OO0o, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            clVar.O00000Oo(cl.O00000o0.O000000o(layoutParams2.f2931O000000o, layoutParams2.O00000Oo, spanGroupIndex, 1, false));
        } else {
            clVar.O00000Oo(cl.O00000o0.O000000o(spanGroupIndex, 1, layoutParams2.f2931O000000o, layoutParams2.O00000Oo, false));
        }
    }

    public void onLayoutCompleted(RecyclerView.O000OO0o o000OO0o) {
        super.onLayoutCompleted(o000OO0o);
        this.mPendingSpanCountChange = false;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.O00000Oo);
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.f2931O000000o);
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setSpanSizeLookup(O00000Oo o00000Oo) {
        this.mSpanSizeLookup = o00000Oo;
    }

    public O00000Oo getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    private void updateMeasurements() {
        int i;
        int i2;
        if (getOrientation() == 1) {
            i2 = getWidth() - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = getHeight() - getPaddingBottom();
            i = getPaddingTop();
        }
        calculateItemBorders(i2 - i);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i4 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i3 = chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i3 = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i4 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    private void calculateItemBorders(int i) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
    }

    static int[] calculateItemBorders(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public int getSpaceForSpanRange(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.mCachedBorders;
        int i3 = this.mSpanCount;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, LinearLayoutManager.O000000o o000000o, int i) {
        super.onAnchorReady(o000o0oo, o000OO0o, o000000o, i);
        updateMeasurements();
        if (o000OO0o.O000000o() > 0 && !o000OO0o.O0000O0o) {
            ensureAnchorIsInCorrectSpan(o000o0oo, o000OO0o, o000000o, i);
        }
        ensureViewSet();
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, o000o0oo, o000OO0o);
    }

    public int scrollVerticallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, o000o0oo, o000OO0o);
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, LinearLayoutManager.O000000o o000000o, int i) {
        boolean z = i == 1;
        int spanIndex = getSpanIndex(o000o0oo, o000OO0o, o000000o.O00000Oo);
        if (z) {
            while (spanIndex > 0 && o000000o.O00000Oo > 0) {
                o000000o.O00000Oo--;
                spanIndex = getSpanIndex(o000o0oo, o000OO0o, o000000o.O00000Oo);
            }
            return;
        }
        int O000000o2 = o000OO0o.O000000o() - 1;
        int i2 = o000000o.O00000Oo;
        while (i2 < O000000o2) {
            int i3 = i2 + 1;
            int spanIndex2 = getSpanIndex(o000o0oo, o000OO0o, i3);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i2 = i3;
            spanIndex = spanIndex2;
        }
        o000000o.O00000Oo = i2;
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i, int i2, int i3) {
        ensureLayoutState();
        int O00000Oo2 = this.mOrientationHelper.O00000Oo();
        int O00000o0 = this.mOrientationHelper.O00000o0();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && getSpanIndex(o000o0oo, o000OO0o, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.O000000o(childAt) < O00000o0 && this.mOrientationHelper.O00000Oo(childAt) >= O00000Oo2) {
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

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.O000OO0o o000OO0o, LinearLayoutManager.O00000o0 o00000o0, RecyclerView.LayoutManager.O000000o o000000o) {
        int i = this.mSpanCount;
        for (int i2 = 0; i2 < this.mSpanCount && o00000o0.O000000o(o000OO0o) && i > 0; i2++) {
            int i3 = o00000o0.O00000o;
            o000000o.O000000o(i3, Math.max(0, o00000o0.O0000O0o));
            i -= this.mSpanSizeLookup.getSpanSize(i3);
            o00000o0.O00000o += o00000o0.O00000oO;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.measureChild(android.view.View, int, boolean):void
     arg types: [android.view.View, int, int]
     candidates:
      androidx.recyclerview.widget.RecyclerView.LayoutManager.measureChild(android.view.View, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.measureChild(android.view.View, int, boolean):void */
    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, LinearLayoutManager.O00000o0 o00000o0, LinearLayoutManager.O00000Oo o00000Oo) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        View O000000o2;
        RecyclerView.O000O0OO o000o0oo2 = o000o0oo;
        RecyclerView.O000OO0o o000OO0o2 = o000OO0o;
        LinearLayoutManager.O00000o0 o00000o02 = o00000o0;
        LinearLayoutManager.O00000Oo o00000Oo2 = o00000Oo;
        int O0000OOo = this.mOrientationHelper.O0000OOo();
        boolean z = false;
        boolean z2 = O0000OOo != 1073741824;
        int i11 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z2) {
            updateMeasurements();
        }
        boolean z3 = o00000o02.O00000oO == 1;
        int i12 = this.mSpanCount;
        if (!z3) {
            i12 = getSpanIndex(o000o0oo2, o000OO0o2, o00000o02.O00000o) + getSpanSize(o000o0oo2, o000OO0o2, o00000o02.O00000o);
        }
        int i13 = i12;
        int i14 = 0;
        while (i14 < this.mSpanCount && o00000o02.O000000o(o000OO0o2) && i13 > 0) {
            int i15 = o00000o02.O00000o;
            int spanSize = getSpanSize(o000o0oo2, o000OO0o2, i15);
            if (spanSize <= this.mSpanCount) {
                i13 -= spanSize;
                if (i13 < 0 || (O000000o2 = o00000o02.O000000o(o000o0oo2)) == null) {
                    break;
                }
                this.mSet[i14] = O000000o2;
                i14++;
            } else {
                throw new IllegalArgumentException("Item at position " + i15 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        if (i14 == 0) {
            o00000Oo2.O00000Oo = true;
            return;
        }
        float f = 0.0f;
        assignSpans(o000o0oo2, o000OO0o2, i14, z3);
        int i16 = 0;
        int i17 = 0;
        while (i16 < i14) {
            View view = this.mSet[i16];
            if (o00000o02.O0000Ooo == null) {
                if (z3) {
                    addView(view);
                } else {
                    addView(view, z);
                }
            } else if (z3) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, z ? 1 : 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, O0000OOo, z);
            int O00000oO = this.mOrientationHelper.O00000oO(view);
            if (O00000oO > i17) {
                i17 = O00000oO;
            }
            float O00000oo = (((float) this.mOrientationHelper.O00000oo(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).O00000Oo);
            if (O00000oo > f) {
                f = O00000oo;
            }
            i16++;
            z = false;
        }
        if (z2) {
            guessMeasurement(f, i11);
            i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                View view2 = this.mSet[i18];
                measureChild(view2, 1073741824, true);
                int O00000oO2 = this.mOrientationHelper.O00000oO(view2);
                if (O00000oO2 > i17) {
                    i17 = O00000oO2;
                }
            }
        }
        for (int i19 = 0; i19 < i14; i19++) {
            View view3 = this.mSet[i19];
            if (this.mOrientationHelper.O00000oO(view3) != i17) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i20 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i21 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.f2931O000000o, layoutParams.O00000Oo);
                if (this.mOrientation == 1) {
                    i10 = getChildMeasureSpec(spaceForSpanRange, 1073741824, i21, layoutParams.width, false);
                    i9 = View.MeasureSpec.makeMeasureSpec(i17 - i20, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - i21, 1073741824);
                    i9 = getChildMeasureSpec(spaceForSpanRange, 1073741824, i20, layoutParams.height, false);
                    i10 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i10, i9, true);
            }
        }
        int i22 = 0;
        o00000Oo2.f2933O000000o = i17;
        if (this.mOrientation == 1) {
            if (o00000o02.O00000oo == -1) {
                int i23 = o00000o02.O00000Oo;
                i3 = i23 - i17;
                i2 = i23;
            } else {
                int i24 = o00000o02.O00000Oo;
                i2 = i24 + i17;
                i3 = i24;
            }
            i4 = 0;
            i = 0;
        } else if (o00000o02.O00000oo == -1) {
            i = o00000o02.O00000Oo;
            i4 = i - i17;
            i3 = 0;
            i2 = 0;
        } else {
            int i25 = o00000o02.O00000Oo;
            int i26 = i25 + i17;
            i3 = 0;
            i2 = 0;
            int i27 = i25;
            i = i26;
            i4 = i27;
        }
        while (i22 < i14) {
            View view4 = this.mSet[i22];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.f2931O000000o];
                i8 = i4;
                i7 = paddingTop;
                i5 = this.mOrientationHelper.O00000oo(view4) + paddingTop;
                i6 = i;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.f2931O000000o];
                i6 = paddingLeft;
                i7 = i3;
                i5 = i2;
                i8 = paddingLeft - this.mOrientationHelper.O00000oo(view4);
            } else {
                int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.f2931O000000o];
                i8 = paddingLeft2;
                i7 = i3;
                i5 = i2;
                i6 = this.mOrientationHelper.O00000oo(view4) + paddingLeft2;
            }
            layoutDecoratedWithMargins(view4, i8, i7, i6, i5);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                o00000Oo2.O00000o0 = true;
            }
            o00000Oo2.O00000o |= view4.hasFocusable();
            i22++;
            i4 = i8;
            i3 = i7;
            i = i6;
            i2 = i5;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    private void measureChild(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.f2931O000000o, layoutParams.O00000Oo);
        if (this.mOrientation == 1) {
            i2 = getChildMeasureSpec(spaceForSpanRange, i, i5, layoutParams.width, false);
            i3 = getChildMeasureSpec(this.mOrientationHelper.O00000oO(), getHeightMode(), i4, layoutParams.height, true);
        } else {
            int childMeasureSpec = getChildMeasureSpec(spaceForSpanRange, i, i4, layoutParams.height, false);
            int childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.O00000oO(), getWidthMode(), i5, layoutParams.width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i2, i3, z);
    }

    private void guessMeasurement(float f, int i) {
        calculateItemBorders(Math.max(Math.round(f * ((float) this.mSpanCount)), i));
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = shouldReMeasureChild(view, i, i2, layoutParams);
        } else {
            z2 = shouldMeasureChild(view, i, i2, layoutParams);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    private void assignSpans(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = i - 1;
            i2 = -1;
        }
        while (i3 != i5) {
            View view = this.mSet[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.O00000Oo = getSpanSize(o000o0oo, o000OO0o, getPosition(view));
            layoutParams.f2931O000000o = i4;
            i4 += layoutParams.O00000Oo;
            i3 += i2;
        }
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void setSpanCount(int i) {
        if (i != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i > 0) {
                this.mSpanCount = i;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(i)));
        }
    }

    public static abstract class O00000Oo {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public abstract int getSpanSize(int i);

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanGroupIndex(int i, int i2) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i, i2);
            }
            int i3 = this.mSpanGroupIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            this.mSpanGroupIndexCache.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        public int getSpanIndex(int i, int i2) {
            int i3;
            int i4;
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            if (!this.mCacheSpanIndices || (i4 = findFirstKeyLessThan(this.mSpanIndexCache, i)) < 0) {
                i4 = 0;
                i3 = 0;
            } else {
                i3 = this.mSpanIndexCache.get(i4) + getSpanSize(i4);
                i4++;
            }
            if (i4 < i) {
                int spanSize2 = getSpanSize(i4);
                i3 += spanSize2;
                if (i3 == i2) {
                    i3 = 0;
                } else if (i3 > i2) {
                    i3 = spanSize2;
                }
                i4++;
                if (i4 < i) {
                }
            }
            if (spanSize + i3 <= i2) {
                return i3;
            }
            return 0;
        }

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int getSpanGroupIndex(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i)) == -1) {
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                i4 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i3 = findFirstKeyLessThan + 1;
                i5 = getSpanSize(findFirstKeyLessThan) + getCachedSpanIndex(findFirstKeyLessThan, i2);
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                }
            }
            int spanSize = getSpanSize(i);
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                int i6 = i5 + spanSize2;
                if (i6 == i2) {
                    i4++;
                    i6 = 0;
                } else if (i6 > i2) {
                    i4++;
                    i6 = spanSize2;
                }
                i3++;
            }
            return i5 + spanSize > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d5, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f5, code lost:
        if (r13 == r14) goto L_0x00b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0103  */
    public View onFocusSearchFailed(View view, int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View view2;
        int i7;
        int i8;
        int i9;
        boolean z;
        RecyclerView.O000O0OO o000o0oo2 = o000o0oo;
        RecyclerView.O000OO0o o000OO0o2 = o000OO0o;
        View findContainingItemView = findContainingItemView(view);
        View view3 = null;
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i10 = layoutParams.f2931O000000o;
        int i11 = layoutParams.f2931O000000o + layoutParams.O00000Oo;
        if (super.onFocusSearchFailed(view, i, o000o0oo, o000OO0o) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout) {
            i4 = getChildCount() - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = getChildCount();
            i4 = 0;
            i2 = 1;
        }
        boolean z2 = this.mOrientation == 1 && isLayoutRTL();
        int spanGroupIndex = getSpanGroupIndex(o000o0oo2, o000OO0o2, i4);
        View view4 = null;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        int i15 = -1;
        while (i4 != i3) {
            int spanGroupIndex2 = getSpanGroupIndex(o000o0oo2, o000OO0o2, i4);
            View childAt = getChildAt(i4);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i16 = layoutParams2.f2931O000000o;
                view2 = findContainingItemView;
                i6 = i3;
                int i17 = layoutParams2.f2931O000000o + layoutParams2.O00000Oo;
                if (childAt.hasFocusable() && i16 == i10 && i17 == i11) {
                    return childAt;
                }
                if ((!childAt.hasFocusable() || view3 != null) && (childAt.hasFocusable() || view4 != null)) {
                    int min = Math.min(i17, i11) - Math.max(i16, i10);
                    if (childAt.hasFocusable()) {
                        if (min <= i13) {
                            if (min == i13) {
                            }
                        }
                    } else if (view3 == null) {
                        i7 = i12;
                        i5 = spanGroupIndex;
                        z = true;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i9 = i14;
                            if (min > i9) {
                                i8 = i15;
                                if (z) {
                                    if (childAt.hasFocusable()) {
                                        int i18 = layoutParams2.f2931O000000o;
                                        i13 = Math.min(i17, i11) - Math.max(i16, i10);
                                        i14 = i9;
                                        i15 = i8;
                                        i12 = i18;
                                        view3 = childAt;
                                        i4 += i2;
                                        spanGroupIndex = i5;
                                        o000o0oo2 = o000o0oo;
                                        o000OO0o2 = o000OO0o;
                                        findContainingItemView = view2;
                                        i3 = i6;
                                    } else {
                                        int i19 = layoutParams2.f2931O000000o;
                                        view4 = childAt;
                                        i14 = Math.min(i17, i11) - Math.max(i16, i10);
                                        i15 = i19;
                                        i12 = i7;
                                        i4 += i2;
                                        spanGroupIndex = i5;
                                        o000o0oo2 = o000o0oo;
                                        o000OO0o2 = o000OO0o;
                                        findContainingItemView = view2;
                                        i3 = i6;
                                    }
                                }
                            } else {
                                if (min == i9) {
                                    i8 = i15;
                                    if (i16 <= i8) {
                                        z = false;
                                    }
                                }
                                i8 = i15;
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        i9 = i14;
                        i8 = i15;
                        z = false;
                        if (z) {
                        }
                    }
                    i7 = i12;
                    i5 = spanGroupIndex;
                    i9 = i14;
                    i8 = i15;
                    z = false;
                    if (z) {
                    }
                }
                i7 = i12;
                i5 = spanGroupIndex;
                i9 = i14;
                i8 = i15;
                z = true;
                if (z) {
                }
            } else if (view3 != null) {
                break;
            } else {
                view2 = findContainingItemView;
                i7 = i12;
                i6 = i3;
                i5 = spanGroupIndex;
                i9 = i14;
                i8 = i15;
            }
            i14 = i9;
            i15 = i8;
            i12 = i7;
            i4 += i2;
            spanGroupIndex = i5;
            o000o0oo2 = o000o0oo;
            o000OO0o2 = o000OO0o;
            findContainingItemView = view2;
            i3 = i6;
        }
        return view3 != null ? view3 : view4;
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    public int computeHorizontalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(o000OO0o);
        }
        return super.computeHorizontalScrollRange(o000OO0o);
    }

    public int computeVerticalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(o000OO0o);
        }
        return super.computeVerticalScrollRange(o000OO0o);
    }

    public int computeHorizontalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(o000OO0o);
        }
        return super.computeHorizontalScrollOffset(o000OO0o);
    }

    public int computeVerticalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(o000OO0o);
        }
        return super.computeVerticalScrollOffset(o000OO0o);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.mUsingSpansToEstimateScrollBarDimensions = z;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.O000OO0o o000OO0o) {
        if (!(getChildCount() == 0 || o000OO0o.O000000o() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(o000OO0o.O000000o() - 1, this.mSpanCount) + 1;
                }
                int O00000Oo2 = this.mOrientationHelper.O00000Oo(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.O000000o(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) O00000Oo2) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1))) * ((float) (this.mSpanSizeLookup.getCachedSpanGroupIndex(o000OO0o.O000000o() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.O000OO0o o000OO0o) {
        int i;
        if (!(getChildCount() == 0 || o000OO0o.O000000o() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(o000OO0o.O000000o() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i;
                }
                return Math.round((((float) i) * (((float) Math.abs(this.mOrientationHelper.O00000Oo(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.O000000o(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.O00000Oo() - this.mOrientationHelper.O000000o(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    public static final class O000000o extends O00000Oo {
        public final int getSpanSize(int i) {
            return 1;
        }

        public final int getSpanIndex(int i, int i2) {
            return i % i2;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2931O000000o = -1;
        public int O00000Oo = 0;

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
    }

    public void onLayoutChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (o000OO0o.O0000O0o) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(o000o0oo, o000OO0o);
        clearPreLayoutSpanMappingCache();
    }

    private int getSpanGroupIndex(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i) {
        if (!o000OO0o.O0000O0o) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
        }
        int O000000o2 = o000o0oo.O000000o(i);
        if (O000000o2 != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(O000000o2, this.mSpanCount);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. ".concat(String.valueOf(i)));
        return 0;
    }

    private int getSpanIndex(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i) {
        if (!o000OO0o.O0000O0o) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int O000000o2 = o000o0oo.O000000o(i);
        if (O000000o2 != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(O000000o2, this.mSpanCount);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:".concat(String.valueOf(i)));
        return 0;
    }

    private int getSpanSize(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i) {
        if (!o000OO0o.O0000O0o) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int O000000o2 = o000o0oo.O000000o(i);
        if (O000000o2 != -1) {
            return this.mSpanSizeLookup.getSpanSize(O000000o2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:".concat(String.valueOf(i)));
        return 1;
    }
}
