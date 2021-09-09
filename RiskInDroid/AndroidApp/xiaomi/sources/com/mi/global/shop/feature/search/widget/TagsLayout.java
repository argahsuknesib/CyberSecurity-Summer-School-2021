package com.mi.global.shop.feature.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class TagsLayout extends ViewGroup {
    private int deviceWidth;

    public TagsLayout(Context context) {
        this(context, null);
    }

    public TagsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deviceWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int size = View.MeasureSpec.getSize(i);
        if (childCount > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            i3 = paddingTop + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        } else {
            i3 = 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            measureChild(childAt2, i, i2);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            int measuredWidth = childAt2.getMeasuredWidth();
            int measuredHeight = childAt2.getMeasuredHeight();
            i4 = i4 + layoutParams2.leftMargin + measuredWidth;
            if (i4 + paddingLeft > getMeasuredWidth()) {
                i3 = i3 + measuredHeight + layoutParams2.topMargin + layoutParams2.bottomMargin;
                i4 = layoutParams2.leftMargin;
            }
        }
        setMeasuredDimension(size, i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingLeft2 = getPaddingLeft();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i7 = paddingLeft2 + layoutParams.leftMargin;
            if (i7 + measuredWidth + paddingLeft > getMeasuredWidth()) {
                i5 = i5 + measuredHeight + layoutParams.topMargin;
                i7 = layoutParams.leftMargin + getPaddingLeft();
            }
            childAt.layout(i7, i5, i7 + measuredWidth, measuredHeight + i5);
            paddingLeft2 = i7 + measuredWidth + layoutParams.rightMargin;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public boolean visible = true;

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
}
