package androidx.recyclerview.widget;

import _m_j.cl;
import _m_j.gv;
import _m_j.gz;
import _m_j.hc;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.O000OO00.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2954O000000o = -1;
    public O00000Oo[] O00000Oo;
    gz O00000o;
    gz O00000o0;
    public int O00000oO;
    public boolean O00000oo = false;
    boolean O0000O0o = false;
    int O0000OOo = -1;
    LazySpanLookup O0000Oo = new LazySpanLookup();
    int O0000Oo0 = Integer.MIN_VALUE;
    private int O0000OoO;
    private final gv O0000Ooo;
    private SavedState O0000o;
    private int O0000o0 = 2;
    private BitSet O0000o00;
    private boolean O0000o0O;
    private boolean O0000o0o;
    private final Rect O0000oO = new Rect();
    private int O0000oO0;
    private final O000000o O0000oOO = new O000000o();
    private boolean O0000oOo = false;
    private int[] O0000oo;
    private boolean O0000oo0 = true;
    private final Runnable O0000ooO = new Runnable() {
        /* class androidx.recyclerview.widget.StaggeredGridLayoutManager.AnonymousClass1 */

        public final void run() {
            StaggeredGridLayoutManager.this.O000000o();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 == 0 || i3 == 1) {
            assertNotInLayoutOrScroll(null);
            if (i3 != this.O00000oO) {
                this.O00000oO = i3;
                gz gzVar = this.O00000o0;
                this.O00000o0 = this.O00000o;
                this.O00000o = gzVar;
                requestLayout();
            }
            O000000o(properties.spanCount);
            O000000o(properties.reverseLayout);
            this.O0000Ooo = new gv();
            O00000Oo();
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public StaggeredGridLayoutManager(int i) {
        this.O00000oO = i;
        O000000o(2);
        this.O0000Ooo = new gv();
        O00000Oo();
    }

    public boolean isAutoMeasureEnabled() {
        return this.O0000o0 != 0;
    }

    private void O00000Oo() {
        this.O00000o0 = gz.O000000o(this, this.O00000oO);
        this.O00000o = gz.O000000o(this, 1 - this.O00000oO);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        int i;
        int i2;
        if (getChildCount() == 0 || this.O0000o0 == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.O0000O0o) {
            i2 = O0000OOo();
            i = O0000Oo0();
        } else {
            i2 = O0000Oo0();
            i = O0000OOo();
        }
        if (i2 == 0 && O00000o0() != null) {
            this.O0000Oo.O000000o();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.O0000oOo) {
            return false;
        } else {
            int i3 = this.O0000O0o ? -1 : 1;
            int i4 = i + 1;
            LazySpanLookup.FullSpanItem O000000o2 = this.O0000Oo.O000000o(i2, i4, i3);
            if (O000000o2 == null) {
                this.O0000oOo = false;
                this.O0000Oo.O000000o(i4);
                return false;
            }
            LazySpanLookup.FullSpanItem O000000o3 = this.O0000Oo.O000000o(i2, O000000o2.f2958O000000o, i3 * -1);
            if (O000000o3 == null) {
                this.O0000Oo.O000000o(O000000o2.f2958O000000o);
            } else {
                this.O0000Oo.O000000o(O000000o3.f2958O000000o + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            O000000o();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.O000O0OO o000o0oo) {
        super.onDetachedFromWindow(recyclerView, o000o0oo);
        removeCallbacks(this.O0000ooO);
        for (int i = 0; i < this.f2954O000000o; i++) {
            this.O00000Oo[i].O00000o0();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r10 == r11) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        if (r10 == r11) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        r10 = false;
     */
    private View O00000o0() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.f2954O000000o);
        bitSet.set(0, this.f2954O000000o, true);
        int i3 = -1;
        char c = (this.O00000oO != 1 || !O00000oO()) ? (char) 65535 : 1;
        if (this.O0000O0o) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        if (childCount < i) {
            i3 = 1;
        }
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.f2956O000000o.O00000oO)) {
                if (O000000o(layoutParams.f2956O000000o)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.f2956O000000o.O00000oO);
            }
            if (!layoutParams.O00000Oo && (i2 = childCount + i3) != i) {
                View childAt2 = getChildAt(i2);
                if (this.O0000O0o) {
                    int O00000Oo2 = this.O00000o0.O00000Oo(childAt);
                    int O00000Oo3 = this.O00000o0.O00000Oo(childAt2);
                    if (O00000Oo2 < O00000Oo3) {
                        return childAt;
                    }
                } else {
                    int O000000o2 = this.O00000o0.O000000o(childAt);
                    int O000000o3 = this.O00000o0.O000000o(childAt2);
                    if (O000000o2 > O000000o3) {
                        return childAt;
                    }
                }
                boolean z = true;
                if (!z) {
                    continue;
                } else {
                    if ((layoutParams.f2956O000000o.O00000oO - ((LayoutParams) childAt2.getLayoutParams()).f2956O000000o.O00000oO < 0) != (c < 0)) {
                        return childAt;
                    }
                }
            }
            childCount += i3;
        }
        return null;
    }

    private boolean O000000o(O00000Oo o00000Oo) {
        return this.O0000O0o ? o00000Oo.O00000Oo() < this.O00000o0.O00000o0() && !((LayoutParams) o00000Oo.f2960O000000o.get(o00000Oo.f2960O000000o.size() - 1).getLayoutParams()).O00000Oo : o00000Oo.O000000o() > this.O00000o0.O00000Oo() && !((LayoutParams) o00000Oo.f2960O000000o.get(0).getLayoutParams()).O00000Oo;
    }

    private void O000000o(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.f2954O000000o) {
            this.O0000Oo.O000000o();
            requestLayout();
            this.f2954O000000o = i;
            this.O0000o00 = new BitSet(this.f2954O000000o);
            this.O00000Oo = new O00000Oo[this.f2954O000000o];
            for (int i2 = 0; i2 < this.f2954O000000o; i2++) {
                this.O00000Oo[i2] = new O00000Oo(i2);
            }
            requestLayout();
        }
    }

    private void O000000o(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.O0000o;
        if (!(savedState == null || savedState.O0000OOo == z)) {
            this.O0000o.O0000OOo = z;
        }
        this.O00000oo = z;
        requestLayout();
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.O0000o == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void O00000o() {
        boolean z = true;
        if (this.O00000oO == 1 || !O00000oO()) {
            z = this.O00000oo;
        } else if (this.O00000oo) {
            z = false;
        }
        this.O0000O0o = z;
    }

    private boolean O00000oO() {
        return getLayoutDirection() == 1;
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.O00000oO == 1) {
            i4 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            i3 = chooseSize(i, (this.O0000OoO * this.f2954O000000o) + paddingLeft, getMinimumWidth());
        } else {
            i3 = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            i4 = chooseSize(i2, (this.O0000OoO * this.f2954O000000o) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void onLayoutCompleted(RecyclerView.O000OO0o o000OO0o) {
        super.onLayoutCompleted(o000OO0o);
        this.O0000OOo = -1;
        this.O0000Oo0 = Integer.MIN_VALUE;
        this.O0000o = null;
        this.O0000oOO.O000000o();
    }

    private void O00000Oo(int i) {
        this.O0000OoO = i / this.f2954O000000o;
        this.O0000oO0 = View.MeasureSpec.makeMeasureSpec(i, this.O00000o.O0000O0o());
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.O0000o == null;
    }

    public final int[] O000000o(int[] iArr) {
        int i;
        if (2 >= this.f2954O000000o) {
            for (int i2 = 0; i2 < this.f2954O000000o; i2++) {
                O00000Oo o00000Oo = this.O00000Oo[i2];
                if (StaggeredGridLayoutManager.this.O00000oo) {
                    i = o00000Oo.O000000o(0, o00000Oo.f2960O000000o.size(), true);
                } else {
                    i = o00000Oo.O000000o(o00000Oo.f2960O000000o.size() - 1, -1, true);
                }
                iArr[i2] = i;
            }
            return iArr;
        }
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f2954O000000o + ", array size:2");
    }

    public int computeHorizontalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        return O000000o(o000OO0o);
    }

    private int O000000o(RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0) {
            return 0;
        }
        return hc.O000000o(o000OO0o, this.O00000o0, O00000Oo(!this.O0000oo0), O00000o0(!this.O0000oo0), this, this.O0000oo0, this.O0000O0o);
    }

    public int computeVerticalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        return O000000o(o000OO0o);
    }

    public int computeHorizontalScrollExtent(RecyclerView.O000OO0o o000OO0o) {
        return O00000Oo(o000OO0o);
    }

    private int O00000Oo(RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0) {
            return 0;
        }
        return hc.O000000o(o000OO0o, this.O00000o0, O00000Oo(!this.O0000oo0), O00000o0(!this.O0000oo0), this, this.O0000oo0);
    }

    public int computeVerticalScrollExtent(RecyclerView.O000OO0o o000OO0o) {
        return O00000Oo(o000OO0o);
    }

    public int computeHorizontalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        return O00000o0(o000OO0o);
    }

    private int O00000o0(RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0) {
            return 0;
        }
        return hc.O00000Oo(o000OO0o, this.O00000o0, O00000Oo(!this.O0000oo0), O00000o0(!this.O0000oo0), this, this.O0000oo0);
    }

    public int computeVerticalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        return O00000o0(o000OO0o);
    }

    private void O000000o(View view, LayoutParams layoutParams) {
        if (layoutParams.O00000Oo) {
            if (this.O00000oO == 1) {
                O000000o(view, this.O0000oO0, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), false);
            } else {
                O000000o(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.O0000oO0, false);
            }
        } else if (this.O00000oO == 1) {
            O000000o(view, getChildMeasureSpec(this.O0000OoO, getWidthMode(), 0, layoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), false);
        } else {
            O000000o(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), getChildMeasureSpec(this.O0000OoO, getHeightMode(), 0, layoutParams.height, false), false);
        }
    }

    private void O000000o(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.O0000oO);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int O000000o2 = O000000o(i, layoutParams.leftMargin + this.O0000oO.left, layoutParams.rightMargin + this.O0000oO.right);
        int O000000o3 = O000000o(i2, layoutParams.topMargin + this.O0000oO.top, layoutParams.bottomMargin + this.O0000oO.bottom);
        if (shouldMeasureChild(view, O000000o2, O000000o3, layoutParams)) {
            view.measure(O000000o2, O000000o3);
        }
    }

    private static int O000000o(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.O0000o = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i;
        View view;
        int i2;
        int i3;
        SavedState savedState = this.O0000o;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.O0000OOo = this.O00000oo;
        savedState2.O0000Oo0 = this.O0000o0O;
        savedState2.O0000Oo = this.O0000o0o;
        LazySpanLookup lazySpanLookup = this.O0000Oo;
        if (lazySpanLookup == null || lazySpanLookup.f2957O000000o == null) {
            savedState2.O00000oO = 0;
        } else {
            savedState2.O00000oo = this.O0000Oo.f2957O000000o;
            savedState2.O00000oO = savedState2.O00000oo.length;
            savedState2.O0000O0o = this.O0000Oo.O00000Oo;
        }
        int i4 = -1;
        if (getChildCount() > 0) {
            if (this.O0000o0O) {
                i = O0000OOo();
            } else {
                i = O0000Oo0();
            }
            savedState2.f2961O000000o = i;
            if (this.O0000O0o) {
                view = O00000o0(true);
            } else {
                view = O00000Oo(true);
            }
            if (view != null) {
                i4 = getPosition(view);
            }
            savedState2.O00000Oo = i4;
            int i5 = this.f2954O000000o;
            savedState2.O00000o0 = i5;
            savedState2.O00000o = new int[i5];
            for (int i6 = 0; i6 < this.f2954O000000o; i6++) {
                if (this.O0000o0O) {
                    i2 = this.O00000Oo[i6].O00000Oo(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.O00000o0.O00000o0();
                    } else {
                        savedState2.O00000o[i6] = i2;
                    }
                } else {
                    i2 = this.O00000Oo[i6].O000000o(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.O00000o0.O00000Oo();
                    } else {
                        savedState2.O00000o[i6] = i2;
                    }
                }
                i2 -= i3;
                savedState2.O00000o[i6] = i2;
            }
        } else {
            savedState2.f2961O000000o = -1;
            savedState2.O00000Oo = -1;
            savedState2.O00000o0 = 0;
        }
        return savedState2;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, View view, cl clVar) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, clVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i3 = 1;
        int i4 = -1;
        if (this.O00000oO == 0) {
            int O000000o2 = layoutParams2.O000000o();
            if (layoutParams2.O00000Oo) {
                i3 = this.f2954O000000o;
            }
            i4 = O000000o2;
            i2 = -1;
            i = -1;
        } else {
            i = layoutParams2.O000000o();
            i2 = layoutParams2.O00000Oo ? this.f2954O000000o : 1;
            i3 = -1;
        }
        clVar.O00000Oo(cl.O00000o0.O000000o(i4, i3, i, i2, false));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View O00000Oo2 = O00000Oo(false);
            View O00000o02 = O00000o0(false);
            if (O00000Oo2 != null && O00000o02 != null) {
                int position = getPosition(O00000Oo2);
                int position2 = getPosition(O00000o02);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public int getRowCountForAccessibility(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.O00000oO == 0) {
            return this.f2954O000000o;
        }
        return super.getRowCountForAccessibility(o000o0oo, o000OO0o);
    }

    public int getColumnCountForAccessibility(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.O00000oO == 1) {
            return this.f2954O000000o;
        }
        return super.getColumnCountForAccessibility(o000o0oo, o000OO0o);
    }

    private View O00000Oo(boolean z) {
        int O00000Oo2 = this.O00000o0.O00000Oo();
        int O00000o02 = this.O00000o0.O00000o0();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int O000000o2 = this.O00000o0.O000000o(childAt);
            if (this.O00000o0.O00000Oo(childAt) > O00000Oo2 && O000000o2 < O00000o02) {
                if (O000000o2 >= O00000Oo2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View O00000o0(boolean z) {
        int O00000Oo2 = this.O00000o0.O00000Oo();
        int O00000o02 = this.O00000o0.O00000o0();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int O000000o2 = this.O00000o0.O000000o(childAt);
            int O00000Oo3 = this.O00000o0.O00000Oo(childAt);
            if (O00000Oo3 > O00000Oo2 && O000000o2 < O00000o02) {
                if (O00000Oo3 <= O00000o02 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void O000000o(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, boolean z) {
        int O00000o02;
        int O0000OOo2 = O0000OOo(Integer.MIN_VALUE);
        if (O0000OOo2 != Integer.MIN_VALUE && (O00000o02 = this.O00000o0.O00000o0() - O0000OOo2) > 0) {
            int i = O00000o02 - (-O000000o(-O00000o02, o000o0oo, o000OO0o));
            if (z && i > 0) {
                this.O00000o0.O000000o(i);
            }
        }
    }

    private void O00000Oo(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, boolean z) {
        int O00000Oo2;
        int O0000O0o2 = O0000O0o(Integer.MAX_VALUE);
        if (O0000O0o2 != Integer.MAX_VALUE && (O00000Oo2 = O0000O0o2 - this.O00000o0.O00000Oo()) > 0) {
            int O000000o2 = O00000Oo2 - O000000o(O00000Oo2, o000o0oo, o000OO0o);
            if (z && O000000o2 > 0) {
                this.O00000o0.O000000o(-O000000o2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    private void O000000o(int i, RecyclerView.O000OO0o o000OO0o) {
        int i2;
        int i3;
        int i4;
        gv gvVar = this.O0000Ooo;
        boolean z = false;
        gvVar.O00000Oo = 0;
        gvVar.O00000o0 = i;
        if (!isSmoothScrolling() || (i4 = o000OO0o.f2951O000000o) == -1) {
            i3 = 0;
        } else {
            if (this.O0000O0o == (i4 < i)) {
                i3 = this.O00000o0.O00000oO();
            } else {
                i2 = this.O00000o0.O00000oO();
                i3 = 0;
                if (!getClipToPadding()) {
                    this.O0000Ooo.O00000oo = this.O00000o0.O00000Oo() - i2;
                    this.O0000Ooo.O0000O0o = this.O00000o0.O00000o0() + i3;
                } else {
                    this.O0000Ooo.O0000O0o = this.O00000o0.O00000o() + i3;
                    this.O0000Ooo.O00000oo = -i2;
                }
                gv gvVar2 = this.O0000Ooo;
                gvVar2.O0000OOo = false;
                gvVar2.f18328O000000o = true;
                if (this.O00000o0.O0000O0o() == 0 && this.O00000o0.O00000o() == 0) {
                    z = true;
                }
                gvVar2.O0000Oo0 = z;
            }
        }
        i2 = 0;
        if (!getClipToPadding()) {
        }
        gv gvVar22 = this.O0000Ooo;
        gvVar22.O0000OOo = false;
        gvVar22.f18328O000000o = true;
        z = true;
        gvVar22.O0000Oo0 = z;
    }

    private void O00000o0(int i) {
        gv gvVar = this.O0000Ooo;
        gvVar.O00000oO = i;
        int i2 = 1;
        if (this.O0000O0o != (i == -1)) {
            i2 = -1;
        }
        gvVar.O00000o = i2;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f2954O000000o; i2++) {
            this.O00000Oo[i2].O00000o(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f2954O000000o; i2++) {
            this.O00000Oo[i2].O00000o(i);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        O00000Oo(i, i2, 2);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        O00000Oo(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.O0000Oo.O000000o();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        O00000Oo(i, i2, 8);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        O00000Oo(i, i2, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    private void O00000Oo(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int O0000OOo2 = this.O0000O0o ? O0000OOo() : O0000Oo0();
        if (i3 != 8) {
            i6 = i + i2;
        } else if (i < i2) {
            i6 = i2 + 1;
        } else {
            i4 = i + 1;
            i5 = i2;
            this.O0000Oo.O00000Oo(i5);
            if (i3 != 1) {
                this.O0000Oo.O00000Oo(i, i2);
            } else if (i3 == 2) {
                this.O0000Oo.O000000o(i, i2);
            } else if (i3 == 8) {
                this.O0000Oo.O000000o(i, 1);
                this.O0000Oo.O00000Oo(i2, 1);
            }
            if (i4 <= O0000OOo2) {
                if (i5 <= (this.O0000O0o ? O0000Oo0() : O0000OOo())) {
                    requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        i4 = i6;
        i5 = i;
        this.O0000Oo.O00000Oo(i5);
        if (i3 != 1) {
        }
        if (i4 <= O0000OOo2) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private int O000000o(RecyclerView.O000O0OO o000o0oo, gv gvVar, RecyclerView.O000OO0o o000OO0o) {
        int i;
        int i2;
        int i3;
        O00000Oo o00000Oo;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        RecyclerView.O000O0OO o000o0oo2 = o000o0oo;
        gv gvVar2 = gvVar;
        int i13 = 0;
        this.O0000o00.set(0, this.f2954O000000o, true);
        if (this.O0000Ooo.O0000Oo0) {
            i = gvVar2.O00000oO == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (gvVar2.O00000oO == 1) {
                i12 = gvVar2.O0000O0o + gvVar2.O00000Oo;
            } else {
                i12 = gvVar2.O00000oo - gvVar2.O00000Oo;
            }
            i = i12;
        }
        O000000o(gvVar2.O00000oO, i);
        if (this.O0000O0o) {
            i2 = this.O00000o0.O00000o0();
        } else {
            i2 = this.O00000o0.O00000Oo();
        }
        int i14 = i2;
        boolean z2 = false;
        while (gvVar.O000000o(o000OO0o) && (this.O0000Ooo.O0000Oo0 || !this.O0000o00.isEmpty())) {
            View O000000o2 = gvVar2.O000000o(o000o0oo2);
            LayoutParams layoutParams = (LayoutParams) O000000o2.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int O00000o02 = this.O0000Oo.O00000o0(viewLayoutPosition);
            boolean z3 = O00000o02 == -1;
            if (z3) {
                o00000Oo = layoutParams.O00000Oo ? this.O00000Oo[i13] : O000000o(gvVar2);
                this.O0000Oo.O000000o(viewLayoutPosition, o00000Oo);
            } else {
                o00000Oo = this.O00000Oo[O00000o02];
            }
            O00000Oo o00000Oo2 = o00000Oo;
            layoutParams.f2956O000000o = o00000Oo2;
            if (gvVar2.O00000oO == 1) {
                addView(O000000o2);
            } else {
                addView(O000000o2, i13);
            }
            O000000o(O000000o2, layoutParams);
            if (gvVar2.O00000oO == 1) {
                if (layoutParams.O00000Oo) {
                    i11 = O0000OOo(i14);
                } else {
                    i11 = o00000Oo2.O00000Oo(i14);
                }
                int O00000oO2 = this.O00000o0.O00000oO(O000000o2) + i11;
                if (z3 && layoutParams.O00000Oo) {
                    LazySpanLookup.FullSpanItem O00000o2 = O00000o(i11);
                    O00000o2.O00000Oo = -1;
                    O00000o2.f2958O000000o = viewLayoutPosition;
                    this.O0000Oo.O000000o(O00000o2);
                }
                i4 = O00000oO2;
                i5 = i11;
            } else {
                if (layoutParams.O00000Oo) {
                    i10 = O0000O0o(i14);
                } else {
                    i10 = o00000Oo2.O000000o(i14);
                }
                i5 = i10 - this.O00000o0.O00000oO(O000000o2);
                if (z3 && layoutParams.O00000Oo) {
                    LazySpanLookup.FullSpanItem O00000oO3 = O00000oO(i10);
                    O00000oO3.O00000Oo = 1;
                    O00000oO3.f2958O000000o = viewLayoutPosition;
                    this.O0000Oo.O000000o(O00000oO3);
                }
                i4 = i10;
            }
            if (layoutParams.O00000Oo && gvVar2.O00000o == -1) {
                if (!z3) {
                    if (gvVar2.O00000oO == 1) {
                        z = O00000oo();
                    } else {
                        z = O0000O0o();
                    }
                    if (!z) {
                        LazySpanLookup.FullSpanItem O00000o3 = this.O0000Oo.O00000o(viewLayoutPosition);
                        if (O00000o3 != null) {
                            O00000o3.O00000o = true;
                        }
                    }
                }
                this.O0000oOo = true;
            }
            O000000o(O000000o2, layoutParams, gvVar2);
            if (!O00000oO() || this.O00000oO != 1) {
                if (layoutParams.O00000Oo) {
                    i8 = this.O00000o.O00000Oo();
                } else {
                    i8 = (o00000Oo2.O00000oO * this.O0000OoO) + this.O00000o.O00000Oo();
                }
                i7 = i8;
                i6 = this.O00000o.O00000oO(O000000o2) + i8;
            } else {
                if (layoutParams.O00000Oo) {
                    i9 = this.O00000o.O00000o0();
                } else {
                    i9 = this.O00000o.O00000o0() - (((this.f2954O000000o - 1) - o00000Oo2.O00000oO) * this.O0000OoO);
                }
                i6 = i9;
                i7 = i9 - this.O00000o.O00000oO(O000000o2);
            }
            if (this.O00000oO == 1) {
                layoutDecoratedWithMargins(O000000o2, i7, i5, i6, i4);
            } else {
                layoutDecoratedWithMargins(O000000o2, i5, i7, i4, i6);
            }
            if (layoutParams.O00000Oo) {
                O000000o(this.O0000Ooo.O00000oO, i);
            } else {
                O000000o(o00000Oo2, this.O0000Ooo.O00000oO, i);
            }
            O000000o(o000o0oo2, this.O0000Ooo);
            if (this.O0000Ooo.O0000OOo && O000000o2.hasFocusable()) {
                if (layoutParams.O00000Oo) {
                    this.O0000o00.clear();
                } else {
                    this.O0000o00.set(o00000Oo2.O00000oO, false);
                }
            }
            z2 = true;
            i13 = 0;
        }
        if (!z2) {
            O000000o(o000o0oo2, this.O0000Ooo);
        }
        if (this.O0000Ooo.O00000oO == -1) {
            i3 = this.O00000o0.O00000Oo() - O0000O0o(this.O00000o0.O00000Oo());
        } else {
            i3 = O0000OOo(this.O00000o0.O00000o0()) - this.O00000o0.O00000o0();
        }
        if (i3 > 0) {
            return Math.min(gvVar2.O00000Oo, i3);
        }
        return 0;
    }

    private LazySpanLookup.FullSpanItem O00000o(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.O00000o0 = new int[this.f2954O000000o];
        for (int i2 = 0; i2 < this.f2954O000000o; i2++) {
            fullSpanItem.O00000o0[i2] = i - this.O00000Oo[i2].O00000Oo(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem O00000oO(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.O00000o0 = new int[this.f2954O000000o];
        for (int i2 = 0; i2 < this.f2954O000000o; i2++) {
            fullSpanItem.O00000o0[i2] = this.O00000Oo[i2].O000000o(i) - i;
        }
        return fullSpanItem;
    }

    private void O000000o(View view, LayoutParams layoutParams, gv gvVar) {
        if (gvVar.O00000oO == 1) {
            if (layoutParams.O00000Oo) {
                O000000o(view);
            } else {
                layoutParams.f2956O000000o.O00000Oo(view);
            }
        } else if (layoutParams.O00000Oo) {
            O00000Oo(view);
        } else {
            layoutParams.f2956O000000o.O000000o(view);
        }
    }

    private void O000000o(RecyclerView.O000O0OO o000o0oo, gv gvVar) {
        int i;
        int i2;
        if (gvVar.f18328O000000o && !gvVar.O0000Oo0) {
            if (gvVar.O00000Oo == 0) {
                if (gvVar.O00000oO == -1) {
                    O00000Oo(o000o0oo, gvVar.O0000O0o);
                } else {
                    O000000o(o000o0oo, gvVar.O00000oo);
                }
            } else if (gvVar.O00000oO == -1) {
                int O00000oo2 = gvVar.O00000oo - O00000oo(gvVar.O00000oo);
                if (O00000oo2 < 0) {
                    i2 = gvVar.O0000O0o;
                } else {
                    i2 = gvVar.O0000O0o - Math.min(O00000oo2, gvVar.O00000Oo);
                }
                O00000Oo(o000o0oo, i2);
            } else {
                int O0000Oo02 = O0000Oo0(gvVar.O0000O0o) - gvVar.O0000O0o;
                if (O0000Oo02 < 0) {
                    i = gvVar.O00000oo;
                } else {
                    i = Math.min(O0000Oo02, gvVar.O00000Oo) + gvVar.O00000oo;
                }
                O000000o(o000o0oo, i);
            }
        }
    }

    private void O000000o(View view) {
        for (int i = this.f2954O000000o - 1; i >= 0; i--) {
            this.O00000Oo[i].O00000Oo(view);
        }
    }

    private void O00000Oo(View view) {
        for (int i = this.f2954O000000o - 1; i >= 0; i--) {
            this.O00000Oo[i].O000000o(view);
        }
    }

    private void O000000o(int i, int i2) {
        for (int i3 = 0; i3 < this.f2954O000000o; i3++) {
            if (!this.O00000Oo[i3].f2960O000000o.isEmpty()) {
                O000000o(this.O00000Oo[i3], i, i2);
            }
        }
    }

    private int O00000oo(int i) {
        int O000000o2 = this.O00000Oo[0].O000000o(i);
        for (int i2 = 1; i2 < this.f2954O000000o; i2++) {
            int O000000o3 = this.O00000Oo[i2].O000000o(i);
            if (O000000o3 > O000000o2) {
                O000000o2 = O000000o3;
            }
        }
        return O000000o2;
    }

    private int O0000O0o(int i) {
        int O000000o2 = this.O00000Oo[0].O000000o(i);
        for (int i2 = 1; i2 < this.f2954O000000o; i2++) {
            int O000000o3 = this.O00000Oo[i2].O000000o(i);
            if (O000000o3 < O000000o2) {
                O000000o2 = O000000o3;
            }
        }
        return O000000o2;
    }

    private boolean O00000oo() {
        int O00000Oo2 = this.O00000Oo[0].O00000Oo(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2954O000000o; i++) {
            if (this.O00000Oo[i].O00000Oo(Integer.MIN_VALUE) != O00000Oo2) {
                return false;
            }
        }
        return true;
    }

    private boolean O0000O0o() {
        int O000000o2 = this.O00000Oo[0].O000000o(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2954O000000o; i++) {
            if (this.O00000Oo[i].O000000o(Integer.MIN_VALUE) != O000000o2) {
                return false;
            }
        }
        return true;
    }

    private int O0000OOo(int i) {
        int O00000Oo2 = this.O00000Oo[0].O00000Oo(i);
        for (int i2 = 1; i2 < this.f2954O000000o; i2++) {
            int O00000Oo3 = this.O00000Oo[i2].O00000Oo(i);
            if (O00000Oo3 > O00000Oo2) {
                O00000Oo2 = O00000Oo3;
            }
        }
        return O00000Oo2;
    }

    private int O0000Oo0(int i) {
        int O00000Oo2 = this.O00000Oo[0].O00000Oo(i);
        for (int i2 = 1; i2 < this.f2954O000000o; i2++) {
            int O00000Oo3 = this.O00000Oo[i2].O00000Oo(i);
            if (O00000Oo3 < O00000Oo2) {
                O00000Oo2 = O00000Oo3;
            }
        }
        return O00000Oo2;
    }

    private void O000000o(RecyclerView.O000O0OO o000o0oo, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.O00000o0.O00000Oo(childAt) <= i && this.O00000o0.O00000o0(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.O00000Oo) {
                    int i2 = 0;
                    while (i2 < this.f2954O000000o) {
                        if (this.O00000Oo[i2].f2960O000000o.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f2954O000000o; i3++) {
                        this.O00000Oo[i3].O00000oO();
                    }
                } else if (layoutParams.f2956O000000o.f2960O000000o.size() != 1) {
                    layoutParams.f2956O000000o.O00000oO();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, o000o0oo);
            } else {
                return;
            }
        }
    }

    private void O00000Oo(RecyclerView.O000O0OO o000o0oo, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.O00000o0.O000000o(childAt) >= i && this.O00000o0.O00000o(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.O00000Oo) {
                    int i2 = 0;
                    while (i2 < this.f2954O000000o) {
                        if (this.O00000Oo[i2].f2960O000000o.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f2954O000000o; i3++) {
                        this.O00000Oo[i3].O00000o();
                    }
                } else if (layoutParams.f2956O000000o.f2960O000000o.size() != 1) {
                    layoutParams.f2956O000000o.O00000o();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, o000o0oo);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean O0000Oo(int i) {
        if (this.O00000oO == 0) {
            return (i == -1) != this.O0000O0o;
        }
        return ((i == -1) == this.O0000O0o) == O00000oO();
    }

    private O00000Oo O000000o(gv gvVar) {
        int i;
        int i2;
        int i3 = -1;
        if (O0000Oo(gvVar.O00000oO)) {
            i2 = this.f2954O000000o - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.f2954O000000o;
            i = 1;
        }
        O00000Oo o00000Oo = null;
        if (gvVar.O00000oO == 1) {
            int i4 = Integer.MAX_VALUE;
            int O00000Oo2 = this.O00000o0.O00000Oo();
            while (i2 != i3) {
                O00000Oo o00000Oo2 = this.O00000Oo[i2];
                int O00000Oo3 = o00000Oo2.O00000Oo(O00000Oo2);
                if (O00000Oo3 < i4) {
                    o00000Oo = o00000Oo2;
                    i4 = O00000Oo3;
                }
                i2 += i;
            }
            return o00000Oo;
        }
        int i5 = Integer.MIN_VALUE;
        int O00000o02 = this.O00000o0.O00000o0();
        while (i2 != i3) {
            O00000Oo o00000Oo3 = this.O00000Oo[i2];
            int O000000o2 = o00000Oo3.O000000o(O00000o02);
            if (O000000o2 > i5) {
                o00000Oo = o00000Oo3;
                i5 = O000000o2;
            }
            i2 += i;
        }
        return o00000Oo;
    }

    public boolean canScrollVertically() {
        return this.O00000oO == 1;
    }

    public boolean canScrollHorizontally() {
        return this.O00000oO == 0;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        return O000000o(i, o000o0oo, o000OO0o);
    }

    public int scrollVerticallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        return O000000o(i, o000o0oo, o000OO0o);
    }

    private int O0000OoO(int i) {
        if (getChildCount() == 0) {
            return this.O0000O0o ? 1 : -1;
        }
        return (i < O0000Oo0()) != this.O0000O0o ? -1 : 1;
    }

    public PointF computeScrollVectorForPosition(int i) {
        int O0000OoO2 = O0000OoO(i);
        PointF pointF = new PointF();
        if (O0000OoO2 == 0) {
            return null;
        }
        if (this.O00000oO == 0) {
            pointF.x = (float) O0000OoO2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) O0000OoO2;
        }
        return pointF;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public void scrollToPosition(int i) {
        SavedState savedState = this.O0000o;
        if (!(savedState == null || savedState.f2961O000000o == i)) {
            SavedState savedState2 = this.O0000o;
            savedState2.O00000o = null;
            savedState2.O00000o0 = 0;
            savedState2.f2961O000000o = -1;
            savedState2.O00000Oo = -1;
        }
        this.O0000OOo = i;
        this.O0000Oo0 = Integer.MIN_VALUE;
        requestLayout();
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.O000OO0o o000OO0o, RecyclerView.LayoutManager.O000000o o000000o) {
        int i3;
        int i4;
        if (this.O00000oO != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            O00000Oo(i, o000OO0o);
            int[] iArr = this.O0000oo;
            if (iArr == null || iArr.length < this.f2954O000000o) {
                this.O0000oo = new int[this.f2954O000000o];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.f2954O000000o; i6++) {
                if (this.O0000Ooo.O00000o == -1) {
                    i4 = this.O0000Ooo.O00000oo;
                    i3 = this.O00000Oo[i6].O000000o(this.O0000Ooo.O00000oo);
                } else {
                    i4 = this.O00000Oo[i6].O00000Oo(this.O0000Ooo.O0000O0o);
                    i3 = this.O0000Ooo.O0000O0o;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.O0000oo[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.O0000oo, 0, i5);
            for (int i8 = 0; i8 < i5 && this.O0000Ooo.O000000o(o000OO0o); i8++) {
                o000000o.O000000o(this.O0000Ooo.O00000o0, this.O0000oo[i8]);
                this.O0000Ooo.O00000o0 += this.O0000Ooo.O00000o;
            }
        }
    }

    private void O00000Oo(int i, RecyclerView.O000OO0o o000OO0o) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = O0000OOo();
            i2 = 1;
        } else {
            i3 = O0000Oo0();
            i2 = -1;
        }
        this.O0000Ooo.f18328O000000o = true;
        O000000o(i3, o000OO0o);
        O00000o0(i2);
        gv gvVar = this.O0000Ooo;
        gvVar.O00000o0 = i3 + gvVar.O00000o;
        this.O0000Ooo.O00000Oo = Math.abs(i);
    }

    private int O000000o(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        O00000Oo(i, o000OO0o);
        int O000000o2 = O000000o(o000o0oo, this.O0000Ooo, o000OO0o);
        if (this.O0000Ooo.O00000Oo >= O000000o2) {
            i = i < 0 ? -O000000o2 : O000000o2;
        }
        this.O00000o0.O000000o(-i);
        this.O0000o0O = this.O0000O0o;
        gv gvVar = this.O0000Ooo;
        gvVar.O00000Oo = 0;
        O000000o(o000o0oo, gvVar);
        return i;
    }

    private int O0000OOo() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    private int O0000Oo0() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.O00000oO == 0) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r9.O00000oO == 1) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        if (r9.O00000oO == 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        if (O00000oO() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        if (O00000oO() == false) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f  */
    public View onFocusSearchFailed(View view, int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        View findContainingItemView;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View O000000o2;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        O00000o();
        if (i == 1) {
            if (this.O00000oO != 1) {
            }
            i2 = -1;
            if (i2 == Integer.MIN_VALUE) {
            }
        } else if (i != 2) {
            if (i != 17) {
                if (i != 33) {
                    if (i == 66) {
                    }
                }
            }
            i2 = Integer.MIN_VALUE;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
            boolean z = layoutParams.O00000Oo;
            O00000Oo o00000Oo = layoutParams.f2956O000000o;
            if (i2 == 1) {
                i3 = O0000OOo();
            } else {
                i3 = O0000Oo0();
            }
            O000000o(i3, o000OO0o);
            O00000o0(i2);
            gv gvVar = this.O0000Ooo;
            gvVar.O00000o0 = gvVar.O00000o + i3;
            this.O0000Ooo.O00000Oo = (int) (((float) this.O00000o0.O00000oO()) * 0.33333334f);
            gv gvVar2 = this.O0000Ooo;
            gvVar2.O0000OOo = true;
            gvVar2.f18328O000000o = false;
            O000000o(o000o0oo, gvVar2, o000OO0o);
            this.O0000o0O = this.O0000O0o;
            if (!z && (O000000o2 = o00000Oo.O000000o(i3, i2)) != null && O000000o2 != findContainingItemView) {
                return O000000o2;
            }
            if (O0000Oo(i2)) {
                for (int i7 = this.f2954O000000o - 1; i7 >= 0; i7--) {
                    View O000000o3 = this.O00000Oo[i7].O000000o(i3, i2);
                    if (O000000o3 != null && O000000o3 != findContainingItemView) {
                        return O000000o3;
                    }
                }
            } else {
                for (int i8 = 0; i8 < this.f2954O000000o; i8++) {
                    View O000000o4 = this.O00000Oo[i8].O000000o(i3, i2);
                    if (O000000o4 != null && O000000o4 != findContainingItemView) {
                        return O000000o4;
                    }
                }
            }
            boolean z2 = (this.O00000oo ^ true) == (i2 == -1);
            if (!z) {
                if (z2) {
                    i6 = o00000Oo.O00000oo();
                } else {
                    i6 = o00000Oo.O0000O0o();
                }
                View findViewByPosition = findViewByPosition(i6);
                if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                    return findViewByPosition;
                }
            }
            if (O0000Oo(i2)) {
                for (int i9 = this.f2954O000000o - 1; i9 >= 0; i9--) {
                    if (i9 != o00000Oo.O00000oO) {
                        if (z2) {
                            i5 = this.O00000Oo[i9].O00000oo();
                        } else {
                            i5 = this.O00000Oo[i9].O0000O0o();
                        }
                        View findViewByPosition2 = findViewByPosition(i5);
                        if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                            return findViewByPosition2;
                        }
                    }
                }
            } else {
                for (int i10 = 0; i10 < this.f2954O000000o; i10++) {
                    if (z2) {
                        i4 = this.O00000Oo[i10].O00000oo();
                    } else {
                        i4 = this.O00000Oo[i10].O0000O0o();
                    }
                    View findViewByPosition3 = findViewByPosition(i4);
                    if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                        return findViewByPosition3;
                    }
                }
            }
            return null;
        } else if (this.O00000oO != 1) {
        }
        i2 = 1;
        if (i2 == Integer.MIN_VALUE) {
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        O00000Oo f2956O000000o;
        public boolean O00000Oo;

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

        public final int O000000o() {
            O00000Oo o00000Oo = this.f2956O000000o;
            if (o00000Oo == null) {
                return -1;
            }
            return o00000Oo.O00000oO;
        }
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public ArrayList<View> f2960O000000o = new ArrayList<>();
        int O00000Oo = Integer.MIN_VALUE;
        int O00000o = 0;
        int O00000o0 = Integer.MIN_VALUE;
        final int O00000oO;

        O00000Oo(int i) {
            this.O00000oO = i;
        }

        /* access modifiers changed from: package-private */
        public final int O000000o(int i) {
            int i2 = this.O00000Oo;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2960O000000o.size() == 0) {
                return i;
            }
            O0000OOo();
            return this.O00000Oo;
        }

        private void O0000OOo() {
            LazySpanLookup.FullSpanItem O00000o2;
            View view = this.f2960O000000o.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.O00000Oo = StaggeredGridLayoutManager.this.O00000o0.O000000o(view);
            if (layoutParams.O00000Oo && (O00000o2 = StaggeredGridLayoutManager.this.O0000Oo.O00000o(layoutParams.getViewLayoutPosition())) != null && O00000o2.O00000Oo == -1) {
                this.O00000Oo -= O00000o2.O000000o(this.O00000oO);
            }
        }

        /* access modifiers changed from: package-private */
        public final int O000000o() {
            int i = this.O00000Oo;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            O0000OOo();
            return this.O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final int O00000Oo(int i) {
            int i2 = this.O00000o0;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2960O000000o.size() == 0) {
                return i;
            }
            O0000Oo0();
            return this.O00000o0;
        }

        private void O0000Oo0() {
            LazySpanLookup.FullSpanItem O00000o2;
            ArrayList<View> arrayList = this.f2960O000000o;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.O00000o0 = StaggeredGridLayoutManager.this.O00000o0.O00000Oo(view);
            if (layoutParams.O00000Oo && (O00000o2 = StaggeredGridLayoutManager.this.O0000Oo.O00000o(layoutParams.getViewLayoutPosition())) != null && O00000o2.O00000Oo == 1) {
                this.O00000o0 += O00000o2.O000000o(this.O00000oO);
            }
        }

        /* access modifiers changed from: package-private */
        public final int O00000Oo() {
            int i = this.O00000o0;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            O0000Oo0();
            return this.O00000o0;
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0() {
            this.f2960O000000o.clear();
            O0000Oo();
            this.O00000o = 0;
        }

        private void O0000Oo() {
            this.O00000Oo = Integer.MIN_VALUE;
            this.O00000o0 = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0(int i) {
            this.O00000Oo = i;
            this.O00000o0 = i;
        }

        /* access modifiers changed from: package-private */
        public final void O00000o() {
            int size = this.f2960O000000o.size();
            View remove = this.f2960O000000o.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.f2956O000000o = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.O00000o -= StaggeredGridLayoutManager.this.O00000o0.O00000oO(remove);
            }
            if (size == 1) {
                this.O00000Oo = Integer.MIN_VALUE;
            }
            this.O00000o0 = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void O00000oO() {
            View remove = this.f2960O000000o.remove(0);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.f2956O000000o = null;
            if (this.f2960O000000o.size() == 0) {
                this.O00000o0 = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.O00000o -= StaggeredGridLayoutManager.this.O00000o0.O00000oO(remove);
            }
            this.O00000Oo = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void O00000o(int i) {
            int i2 = this.O00000Oo;
            if (i2 != Integer.MIN_VALUE) {
                this.O00000Oo = i2 + i;
            }
            int i3 = this.O00000o0;
            if (i3 != Integer.MIN_VALUE) {
                this.O00000o0 = i3 + i;
            }
        }

        public final int O00000oo() {
            if (StaggeredGridLayoutManager.this.O00000oo) {
                return O00000Oo(this.f2960O000000o.size() - 1, -1);
            }
            return O00000Oo(0, this.f2960O000000o.size());
        }

        public final int O0000O0o() {
            if (StaggeredGridLayoutManager.this.O00000oo) {
                return O00000Oo(0, this.f2960O000000o.size());
            }
            return O00000Oo(this.f2960O000000o.size() - 1, -1);
        }

        private int O000000o(int i, int i2, boolean z, boolean z2, boolean z3) {
            int O00000Oo2 = StaggeredGridLayoutManager.this.O00000o0.O00000Oo();
            int O00000o02 = StaggeredGridLayoutManager.this.O00000o0.O00000o0();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f2960O000000o.get(i);
                int O000000o2 = StaggeredGridLayoutManager.this.O00000o0.O000000o(view);
                int O00000Oo3 = StaggeredGridLayoutManager.this.O00000o0.O00000Oo(view);
                boolean z4 = false;
                boolean z5 = !z3 ? O000000o2 < O00000o02 : O000000o2 <= O00000o02;
                if (!z3 ? O00000Oo3 > O00000Oo2 : O00000Oo3 >= O00000Oo2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (O000000o2 < O00000Oo2 || O00000Oo3 > O00000o02) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (O000000o2 >= O00000Oo2 && O00000Oo3 <= O00000o02) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public final int O000000o(int i, int i2, boolean z) {
            return O000000o(i, i2, z, true, false);
        }

        private int O00000Oo(int i, int i2) {
            return O000000o(i, i2, false, false, true);
        }

        public final View O000000o(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f2960O000000o.size() - 1;
                while (size >= 0) {
                    View view2 = this.f2960O000000o.get(size);
                    if ((StaggeredGridLayoutManager.this.O00000oo && StaggeredGridLayoutManager.this.getPosition(view2) >= i) || ((!StaggeredGridLayoutManager.this.O00000oo && StaggeredGridLayoutManager.this.getPosition(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f2960O000000o.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f2960O000000o.get(i3);
                    if ((StaggeredGridLayoutManager.this.O00000oo && StaggeredGridLayoutManager.this.getPosition(view3) <= i) || ((!StaggeredGridLayoutManager.this.O00000oo && StaggeredGridLayoutManager.this.getPosition(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f2956O000000o = this;
            this.f2960O000000o.add(0, view);
            this.O00000Oo = Integer.MIN_VALUE;
            if (this.f2960O000000o.size() == 1) {
                this.O00000o0 = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.O00000o += StaggeredGridLayoutManager.this.O00000o0.O00000oO(view);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f2956O000000o = this;
            this.f2960O000000o.add(view);
            this.O00000o0 = Integer.MIN_VALUE;
            if (this.f2960O000000o.size() == 1) {
                this.O00000Oo = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.O00000o += StaggeredGridLayoutManager.this.O00000o0.O00000oO(view);
            }
        }
    }

    static class LazySpanLookup {

        /* renamed from: O000000o  reason: collision with root package name */
        int[] f2957O000000o;
        List<FullSpanItem> O00000Oo;

        LazySpanLookup() {
        }

        /* access modifiers changed from: package-private */
        public final int O000000o(int i) {
            List<FullSpanItem> list = this.O00000Oo;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.O00000Oo.get(size).f2958O000000o >= i) {
                        this.O00000Oo.remove(size);
                    }
                }
            }
            return O00000Oo(i);
        }

        /* access modifiers changed from: package-private */
        public final int O00000Oo(int i) {
            int[] iArr = this.f2957O000000o;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int O0000O0o = O0000O0o(i);
            if (O0000O0o == -1) {
                int[] iArr2 = this.f2957O000000o;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f2957O000000o.length;
            }
            int i2 = O0000O0o + 1;
            Arrays.fill(this.f2957O000000o, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final int O00000o0(int i) {
            int[] iArr = this.f2957O000000o;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, O00000Oo o00000Oo) {
            O00000oo(i);
            this.f2957O000000o[i] = o00000Oo.O00000oO;
        }

        private int O00000oO(int i) {
            int length = this.f2957O000000o.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        private void O00000oo(int i) {
            int[] iArr = this.f2957O000000o;
            if (iArr == null) {
                this.f2957O000000o = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f2957O000000o, -1);
            } else if (i >= iArr.length) {
                this.f2957O000000o = new int[O00000oO(i)];
                System.arraycopy(iArr, 0, this.f2957O000000o, 0, iArr.length);
                int[] iArr2 = this.f2957O000000o;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            int[] iArr = this.f2957O000000o;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.O00000Oo = null;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, int i2) {
            int[] iArr = this.f2957O000000o;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                O00000oo(i3);
                int[] iArr2 = this.f2957O000000o;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f2957O000000o;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                O00000o0(i, i2);
            }
        }

        private void O00000o0(int i, int i2) {
            List<FullSpanItem> list = this.O00000Oo;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.O00000Oo.get(size);
                    if (fullSpanItem.f2958O000000o >= i) {
                        if (fullSpanItem.f2958O000000o < i3) {
                            this.O00000Oo.remove(size);
                        } else {
                            fullSpanItem.f2958O000000o -= i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(int i, int i2) {
            int[] iArr = this.f2957O000000o;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                O00000oo(i3);
                int[] iArr2 = this.f2957O000000o;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f2957O000000o, i, i3, -1);
                O00000o(i, i2);
            }
        }

        private void O00000o(int i, int i2) {
            List<FullSpanItem> list = this.O00000Oo;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.O00000Oo.get(size);
                    if (fullSpanItem.f2958O000000o >= i) {
                        fullSpanItem.f2958O000000o += i2;
                    }
                }
            }
        }

        private int O0000O0o(int i) {
            if (this.O00000Oo == null) {
                return -1;
            }
            FullSpanItem O00000o = O00000o(i);
            if (O00000o != null) {
                this.O00000Oo.remove(O00000o);
            }
            int size = this.O00000Oo.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.O00000Oo.get(i2).f2958O000000o >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.O00000Oo.remove(i2);
            return this.O00000Oo.get(i2).f2958O000000o;
        }

        public final void O000000o(FullSpanItem fullSpanItem) {
            if (this.O00000Oo == null) {
                this.O00000Oo = new ArrayList();
            }
            int size = this.O00000Oo.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.O00000Oo.get(i);
                if (fullSpanItem2.f2958O000000o == fullSpanItem.f2958O000000o) {
                    this.O00000Oo.remove(i);
                }
                if (fullSpanItem2.f2958O000000o >= fullSpanItem.f2958O000000o) {
                    this.O00000Oo.add(i, fullSpanItem);
                    return;
                }
            }
            this.O00000Oo.add(fullSpanItem);
        }

        public final FullSpanItem O00000o(int i) {
            List<FullSpanItem> list = this.O00000Oo;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.O00000Oo.get(size);
                if (fullSpanItem.f2958O000000o == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem O000000o(int i, int i2, int i3) {
            List<FullSpanItem> list = this.O00000Oo;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.O00000Oo.get(i4);
                if (fullSpanItem.f2958O000000o >= i2) {
                    return null;
                }
                if (fullSpanItem.f2958O000000o >= i && (i3 == 0 || fullSpanItem.O00000Oo == i3 || fullSpanItem.O00000o)) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* class androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }
            };

            /* renamed from: O000000o  reason: collision with root package name */
            int f2958O000000o;
            int O00000Oo;
            boolean O00000o;
            int[] O00000o0;

            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.f2958O000000o = parcel.readInt();
                this.O00000Oo = parcel.readInt();
                this.O00000o = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.O00000o0 = new int[readInt];
                    parcel.readIntArray(this.O00000o0);
                }
            }

            FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            public final int O000000o(int i) {
                int[] iArr = this.O00000o0;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2958O000000o);
                parcel.writeInt(this.O00000Oo);
                parcel.writeInt(this.O00000o ? 1 : 0);
                int[] iArr = this.O00000o0;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.O00000o0);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2958O000000o + ", mGapDir=" + this.O00000Oo + ", mHasUnwantedGapAfter=" + this.O00000o + ", mGapPerSpan=" + Arrays.toString(this.O00000o0) + '}';
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f2961O000000o;
        int O00000Oo;
        int[] O00000o;
        int O00000o0;
        int O00000oO;
        int[] O00000oo;
        List<LazySpanLookup.FullSpanItem> O0000O0o;
        boolean O0000OOo;
        boolean O0000Oo;
        boolean O0000Oo0;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2961O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
            int i = this.O00000o0;
            if (i > 0) {
                this.O00000o = new int[i];
                parcel.readIntArray(this.O00000o);
            }
            this.O00000oO = parcel.readInt();
            int i2 = this.O00000oO;
            if (i2 > 0) {
                this.O00000oo = new int[i2];
                parcel.readIntArray(this.O00000oo);
            }
            boolean z = false;
            this.O0000OOo = parcel.readInt() == 1;
            this.O0000Oo0 = parcel.readInt() == 1;
            this.O0000Oo = parcel.readInt() == 1 ? true : z;
            this.O0000O0o = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.O00000o0 = savedState.O00000o0;
            this.f2961O000000o = savedState.f2961O000000o;
            this.O00000Oo = savedState.O00000Oo;
            this.O00000o = savedState.O00000o;
            this.O00000oO = savedState.O00000oO;
            this.O00000oo = savedState.O00000oo;
            this.O0000OOo = savedState.O0000OOo;
            this.O0000Oo0 = savedState.O0000Oo0;
            this.O0000Oo = savedState.O0000Oo;
            this.O0000O0o = savedState.O0000O0o;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2961O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
            if (this.O00000o0 > 0) {
                parcel.writeIntArray(this.O00000o);
            }
            parcel.writeInt(this.O00000oO);
            if (this.O00000oO > 0) {
                parcel.writeIntArray(this.O00000oo);
            }
            parcel.writeInt(this.O0000OOo ? 1 : 0);
            parcel.writeInt(this.O0000Oo0 ? 1 : 0);
            parcel.writeInt(this.O0000Oo ? 1 : 0);
            parcel.writeList(this.O0000O0o);
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2959O000000o;
        int O00000Oo;
        boolean O00000o;
        boolean O00000o0;
        boolean O00000oO;
        int[] O00000oo;

        O000000o() {
            O000000o();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.f2959O000000o = -1;
            this.O00000Oo = Integer.MIN_VALUE;
            this.O00000o0 = false;
            this.O00000o = false;
            this.O00000oO = false;
            int[] iArr = this.O00000oo;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.StaggeredGridLayoutManager.O000000o(androidx.recyclerview.widget.RecyclerView$O000O0OO, androidx.recyclerview.widget.RecyclerView$O000OO0o, boolean):void
     arg types: [androidx.recyclerview.widget.RecyclerView$O000O0OO, androidx.recyclerview.widget.RecyclerView$O000OO0o, int]
     candidates:
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O000000o(int, int, int):int
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O000000o(int, androidx.recyclerview.widget.RecyclerView$O000O0OO, androidx.recyclerview.widget.RecyclerView$O000OO0o):int
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O000000o(androidx.recyclerview.widget.RecyclerView$O000O0OO, _m_j.gv, androidx.recyclerview.widget.RecyclerView$O000OO0o):int
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O000000o(android.view.View, androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams, _m_j.gv):void
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O000000o(androidx.recyclerview.widget.StaggeredGridLayoutManager$O00000Oo, int, int):void
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O000000o(androidx.recyclerview.widget.RecyclerView$O000O0OO, androidx.recyclerview.widget.RecyclerView$O000OO0o, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.StaggeredGridLayoutManager.O00000Oo(androidx.recyclerview.widget.RecyclerView$O000O0OO, androidx.recyclerview.widget.RecyclerView$O000OO0o, boolean):void
     arg types: [androidx.recyclerview.widget.RecyclerView$O000O0OO, androidx.recyclerview.widget.RecyclerView$O000OO0o, int]
     candidates:
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O00000Oo(int, int, int):void
      androidx.recyclerview.widget.StaggeredGridLayoutManager.O00000Oo(androidx.recyclerview.widget.RecyclerView$O000O0OO, androidx.recyclerview.widget.RecyclerView$O000OO0o, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x044f A[LOOP:0: B:1:0x0003->B:244:0x044f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0457 A[SYNTHETIC] */
    public void onLayoutChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        boolean z;
        SavedState savedState;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z3 = true;
        while (true) {
            O000000o o000000o = this.O0000oOO;
            if (!(this.O0000o == null && this.O0000OOo == -1) && o000OO0o.O000000o() == 0) {
                removeAndRecycleAllViews(o000o0oo);
                o000000o.O000000o();
                return;
            }
            boolean z4 = (o000000o.O00000oO && this.O0000OOo == -1 && this.O0000o == null) ? false : true;
            if (z4) {
                o000000o.O000000o();
                SavedState savedState2 = this.O0000o;
                if (savedState2 != null) {
                    if (savedState2.O00000o0 > 0) {
                        if (this.O0000o.O00000o0 == this.f2954O000000o) {
                            for (int i8 = 0; i8 < this.f2954O000000o; i8++) {
                                this.O00000Oo[i8].O00000o0();
                                int i9 = this.O0000o.O00000o[i8];
                                if (i9 != Integer.MIN_VALUE) {
                                    if (this.O0000o.O0000Oo0) {
                                        i7 = this.O00000o0.O00000o0();
                                    } else {
                                        i7 = this.O00000o0.O00000Oo();
                                    }
                                    i9 += i7;
                                }
                                this.O00000Oo[i8].O00000o0(i9);
                            }
                        } else {
                            SavedState savedState3 = this.O0000o;
                            savedState3.O00000o = null;
                            savedState3.O00000o0 = 0;
                            savedState3.O00000oO = 0;
                            savedState3.O00000oo = null;
                            savedState3.O0000O0o = null;
                            savedState3.f2961O000000o = savedState3.O00000Oo;
                        }
                    }
                    this.O0000o0o = this.O0000o.O0000Oo;
                    O000000o(this.O0000o.O0000OOo);
                    O00000o();
                    if (this.O0000o.f2961O000000o != -1) {
                        this.O0000OOo = this.O0000o.f2961O000000o;
                        o000000o.O00000o0 = this.O0000o.O0000Oo0;
                    } else {
                        o000000o.O00000o0 = this.O0000O0o;
                    }
                    if (this.O0000o.O00000oO > 1) {
                        this.O0000Oo.f2957O000000o = this.O0000o.O00000oo;
                        this.O0000Oo.O00000Oo = this.O0000o.O0000O0o;
                    }
                } else {
                    O00000o();
                    o000000o.O00000o0 = this.O0000O0o;
                }
                if (!o000OO0o.O0000O0o && (i3 = this.O0000OOo) != -1) {
                    if (i3 < 0 || i3 >= o000OO0o.O000000o()) {
                        this.O0000OOo = -1;
                        this.O0000Oo0 = Integer.MIN_VALUE;
                    } else {
                        SavedState savedState4 = this.O0000o;
                        if (savedState4 == null || savedState4.f2961O000000o == -1 || this.O0000o.O00000o0 <= 0) {
                            View findViewByPosition = findViewByPosition(this.O0000OOo);
                            if (findViewByPosition != null) {
                                if (this.O0000O0o) {
                                    i5 = O0000OOo();
                                } else {
                                    i5 = O0000Oo0();
                                }
                                o000000o.f2959O000000o = i5;
                                if (this.O0000Oo0 != Integer.MIN_VALUE) {
                                    if (o000000o.O00000o0) {
                                        o000000o.O00000Oo = (this.O00000o0.O00000o0() - this.O0000Oo0) - this.O00000o0.O00000Oo(findViewByPosition);
                                    } else {
                                        o000000o.O00000Oo = (this.O00000o0.O00000Oo() + this.O0000Oo0) - this.O00000o0.O000000o(findViewByPosition);
                                    }
                                } else if (this.O00000o0.O00000oO(findViewByPosition) > this.O00000o0.O00000oO()) {
                                    if (o000000o.O00000o0) {
                                        i6 = this.O00000o0.O00000o0();
                                    } else {
                                        i6 = this.O00000o0.O00000Oo();
                                    }
                                    o000000o.O00000Oo = i6;
                                } else {
                                    int O000000o2 = this.O00000o0.O000000o(findViewByPosition) - this.O00000o0.O00000Oo();
                                    if (O000000o2 < 0) {
                                        o000000o.O00000Oo = -O000000o2;
                                    } else {
                                        int O00000o02 = this.O00000o0.O00000o0() - this.O00000o0.O00000Oo(findViewByPosition);
                                        if (O00000o02 < 0) {
                                            o000000o.O00000Oo = O00000o02;
                                        } else {
                                            o000000o.O00000Oo = Integer.MIN_VALUE;
                                        }
                                    }
                                }
                            } else {
                                o000000o.f2959O000000o = this.O0000OOo;
                                int i10 = this.O0000Oo0;
                                if (i10 == Integer.MIN_VALUE) {
                                    o000000o.O00000o0 = O0000OoO(o000000o.f2959O000000o) == 1;
                                    if (o000000o.O00000o0) {
                                        i4 = StaggeredGridLayoutManager.this.O00000o0.O00000o0();
                                    } else {
                                        i4 = StaggeredGridLayoutManager.this.O00000o0.O00000Oo();
                                    }
                                    o000000o.O00000Oo = i4;
                                } else if (o000000o.O00000o0) {
                                    o000000o.O00000Oo = StaggeredGridLayoutManager.this.O00000o0.O00000o0() - i10;
                                } else {
                                    o000000o.O00000Oo = StaggeredGridLayoutManager.this.O00000o0.O00000Oo() + i10;
                                }
                                o000000o.O00000o = true;
                            }
                        } else {
                            o000000o.O00000Oo = Integer.MIN_VALUE;
                            o000000o.f2959O000000o = this.O0000OOo;
                        }
                        z2 = true;
                        if (!z2) {
                            if (this.O0000o0O) {
                                int O000000o3 = o000OO0o.O000000o();
                                int childCount = getChildCount() - 1;
                                while (true) {
                                    if (childCount >= 0) {
                                        i2 = getPosition(getChildAt(childCount));
                                        if (i2 >= 0 && i2 < O000000o3) {
                                            break;
                                        }
                                        childCount--;
                                    } else {
                                        break;
                                    }
                                }
                            } else {
                                int O000000o4 = o000OO0o.O000000o();
                                int childCount2 = getChildCount();
                                int i11 = 0;
                                while (true) {
                                    if (i11 < childCount2) {
                                        int position = getPosition(getChildAt(i11));
                                        if (position >= 0 && position < O000000o4) {
                                            i2 = position;
                                            break;
                                        }
                                        i11++;
                                    } else {
                                        break;
                                    }
                                }
                                o000000o.f2959O000000o = i2;
                                o000000o.O00000Oo = Integer.MIN_VALUE;
                            }
                            i2 = 0;
                            o000000o.f2959O000000o = i2;
                            o000000o.O00000Oo = Integer.MIN_VALUE;
                        }
                        o000000o.O00000oO = true;
                    }
                }
                z2 = false;
                if (!z2) {
                }
                o000000o.O00000oO = true;
            }
            if (this.O0000o == null && this.O0000OOo == -1 && !(o000000o.O00000o0 == this.O0000o0O && O00000oO() == this.O0000o0o)) {
                this.O0000Oo.O000000o();
                o000000o.O00000o = true;
            }
            if (getChildCount() > 0 && ((savedState = this.O0000o) == null || savedState.O00000o0 <= 0)) {
                if (o000000o.O00000o) {
                    for (int i12 = 0; i12 < this.f2954O000000o; i12++) {
                        this.O00000Oo[i12].O00000o0();
                        if (o000000o.O00000Oo != Integer.MIN_VALUE) {
                            this.O00000Oo[i12].O00000o0(o000000o.O00000Oo);
                        }
                    }
                } else if (z4 || this.O0000oOO.O00000oo == null) {
                    for (int i13 = 0; i13 < this.f2954O000000o; i13++) {
                        O00000Oo o00000Oo = this.O00000Oo[i13];
                        boolean z5 = this.O0000O0o;
                        int i14 = o000000o.O00000Oo;
                        if (z5) {
                            i = o00000Oo.O00000Oo(Integer.MIN_VALUE);
                        } else {
                            i = o00000Oo.O000000o(Integer.MIN_VALUE);
                        }
                        o00000Oo.O00000o0();
                        if (i != Integer.MIN_VALUE && ((!z5 || i >= StaggeredGridLayoutManager.this.O00000o0.O00000o0()) && (z5 || i <= StaggeredGridLayoutManager.this.O00000o0.O00000Oo()))) {
                            if (i14 != Integer.MIN_VALUE) {
                                i += i14;
                            }
                            o00000Oo.O00000o0 = i;
                            o00000Oo.O00000Oo = i;
                        }
                    }
                    O000000o o000000o2 = this.O0000oOO;
                    O00000Oo[] o00000OoArr = this.O00000Oo;
                    int length = o00000OoArr.length;
                    if (o000000o2.O00000oo == null || o000000o2.O00000oo.length < length) {
                        o000000o2.O00000oo = new int[StaggeredGridLayoutManager.this.O00000Oo.length];
                    }
                    for (int i15 = 0; i15 < length; i15++) {
                        o000000o2.O00000oo[i15] = o00000OoArr[i15].O000000o(Integer.MIN_VALUE);
                    }
                } else {
                    for (int i16 = 0; i16 < this.f2954O000000o; i16++) {
                        O00000Oo o00000Oo2 = this.O00000Oo[i16];
                        o00000Oo2.O00000o0();
                        o00000Oo2.O00000o0(this.O0000oOO.O00000oo[i16]);
                    }
                }
            }
            detachAndScrapAttachedViews(o000o0oo);
            this.O0000Ooo.f18328O000000o = false;
            this.O0000oOo = false;
            O00000Oo(this.O00000o.O00000oO());
            O000000o(o000000o.f2959O000000o, o000OO0o);
            if (o000000o.O00000o0) {
                O00000o0(-1);
                O000000o(o000o0oo, this.O0000Ooo, o000OO0o);
                O00000o0(1);
                this.O0000Ooo.O00000o0 = o000000o.f2959O000000o + this.O0000Ooo.O00000o;
                O000000o(o000o0oo, this.O0000Ooo, o000OO0o);
            } else {
                O00000o0(1);
                O000000o(o000o0oo, this.O0000Ooo, o000OO0o);
                O00000o0(-1);
                this.O0000Ooo.O00000o0 = o000000o.f2959O000000o + this.O0000Ooo.O00000o;
                O000000o(o000o0oo, this.O0000Ooo, o000OO0o);
            }
            if (this.O00000o.O0000O0o() != 1073741824) {
                int childCount3 = getChildCount();
                float f = 0.0f;
                for (int i17 = 0; i17 < childCount3; i17++) {
                    View childAt = getChildAt(i17);
                    float O00000oO2 = (float) this.O00000o.O00000oO(childAt);
                    if (O00000oO2 >= f) {
                        if (((LayoutParams) childAt.getLayoutParams()).O00000Oo) {
                            O00000oO2 = (O00000oO2 * 1.0f) / ((float) this.f2954O000000o);
                        }
                        f = Math.max(f, O00000oO2);
                    }
                }
                int i18 = this.O0000OoO;
                int round = Math.round(f * ((float) this.f2954O000000o));
                if (this.O00000o.O0000O0o() == Integer.MIN_VALUE) {
                    round = Math.min(round, this.O00000o.O00000oO());
                }
                O00000Oo(round);
                if (this.O0000OoO != i18) {
                    for (int i19 = 0; i19 < childCount3; i19++) {
                        View childAt2 = getChildAt(i19);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.O00000Oo) {
                            if (!O00000oO() || this.O00000oO != 1) {
                                int i20 = layoutParams.f2956O000000o.O00000oO * this.O0000OoO;
                                int i21 = layoutParams.f2956O000000o.O00000oO * i18;
                                if (this.O00000oO == 1) {
                                    childAt2.offsetLeftAndRight(i20 - i21);
                                } else {
                                    childAt2.offsetTopAndBottom(i20 - i21);
                                }
                            } else {
                                childAt2.offsetLeftAndRight(((-((this.f2954O000000o - 1) - layoutParams.f2956O000000o.O00000oO)) * this.O0000OoO) - ((-((this.f2954O000000o - 1) - layoutParams.f2956O000000o.O00000oO)) * i18));
                            }
                        }
                    }
                }
            }
            if (getChildCount() > 0) {
                if (this.O0000O0o) {
                    O000000o(o000o0oo, o000OO0o, true);
                    O00000Oo(o000o0oo, o000OO0o, false);
                } else {
                    O00000Oo(o000o0oo, o000OO0o, true);
                    O000000o(o000o0oo, o000OO0o, false);
                }
            }
            if (z3 && !o000OO0o.O0000O0o) {
                if (this.O0000o0 != 0 && getChildCount() > 0 && (this.O0000oOo || O00000o0() != null)) {
                    removeCallbacks(this.O0000ooO);
                    if (O000000o()) {
                        z = true;
                        if (o000OO0o.O0000O0o) {
                            this.O0000oOO.O000000o();
                        }
                        this.O0000o0O = o000000o.O00000o0;
                        this.O0000o0o = O00000oO();
                        if (!z) {
                            this.O0000oOO.O000000o();
                            z3 = false;
                        } else {
                            return;
                        }
                    }
                }
            }
            z = false;
            if (o000OO0o.O0000O0o) {
            }
            this.O0000o0O = o000000o.O00000o0;
            this.O0000o0o = O00000oO();
            if (!z) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O000000o(O00000Oo o00000Oo, int i, int i2) {
        int i3 = o00000Oo.O00000o;
        if (i == -1) {
            if (o00000Oo.O000000o() + i3 <= i2) {
                this.O0000o00.set(o00000Oo.O00000oO, false);
            }
        } else if (o00000Oo.O00000Oo() - i3 >= i2) {
            this.O0000o00.set(o00000Oo.O00000oO, false);
        }
    }
}
