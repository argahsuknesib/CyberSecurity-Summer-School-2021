package com.google.android.material.appbar;

import _m_j.ak;
import _m_j.bk;
import _m_j.cb;
import _m_j.ci;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int overlayTop;
    final Rect tempRect1 = new Rect();
    final Rect tempRect2 = new Rect();
    private int verticalLayoutGap = 0;

    private static int resolveGravity(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public abstract View findFirstDependency(List<View> list);

    /* access modifiers changed from: package-private */
    public float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior() {
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View findFirstDependency;
        ci lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (cb.O0000ooo(findFirstDependency) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.O00000Oo() + lastWindowInsets.O00000o();
        }
        int scrollRange = size + getScrollRange(findFirstDependency);
        int measuredHeight = findFirstDependency.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild()) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            scrollRange -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(scrollRange, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (findFirstDependency != null) {
            CoordinatorLayout.O00000o o00000o = (CoordinatorLayout.O00000o) view.getLayoutParams();
            Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + o00000o.leftMargin, findFirstDependency.getBottom() + o00000o.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - o00000o.rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - o00000o.bottomMargin);
            ci lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && cb.O0000ooo(coordinatorLayout) && !cb.O0000ooo(view)) {
                rect.left += lastWindowInsets.O000000o();
                rect.right -= lastWindowInsets.O00000o0();
            }
            Rect rect2 = this.tempRect2;
            bk.O000000o(resolveGravity(o00000o.O00000o0), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.verticalLayoutGap = rect2.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i);
        this.verticalLayoutGap = 0;
    }

    /* access modifiers changed from: package-private */
    public final int getOverlapPixelsForOffset(View view) {
        if (this.overlayTop == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int i = this.overlayTop;
        return ak.O000000o((int) (overlapRatioForOffset * ((float) i)), 0, i);
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public final void setOverlayTop(int i) {
        this.overlayTop = i;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }
}
