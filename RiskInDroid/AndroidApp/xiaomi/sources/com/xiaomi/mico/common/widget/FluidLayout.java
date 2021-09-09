package com.xiaomi.mico.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FluidLayout extends ViewGroup {
    private int mGravity;
    private List<Integer> mLineHeight;
    private List<List<View>> mViews;

    public FluidLayout(Context context) {
        this(context, null);
    }

    public FluidLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FluidLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = -1;
        this.mViews = new ArrayList();
        this.mLineHeight = new ArrayList();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i4 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i10 = i7 + measuredWidth;
                if (i10 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i6 = Math.max(i6, i7);
                    i9 += i8;
                } else {
                    measuredHeight = Math.max(i8, measuredHeight);
                    measuredWidth = i10;
                }
                if (i5 == childCount - 1) {
                    i6 = Math.max(measuredWidth, i6);
                    i9 += measuredHeight;
                }
                i8 = measuredHeight;
                i7 = measuredWidth;
            } else {
                i4 = size2;
            }
            i5++;
            size2 = i4;
        }
        int i11 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + i6 + getPaddingLeft();
        }
        if (mode2 == 1073741824) {
            i3 = i11;
        } else {
            i3 = getPaddingBottom() + i9 + getPaddingTop();
        }
        setMeasuredDimension(size, i3);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int measuredHeight;
        this.mViews.clear();
        this.mLineHeight.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        ArrayList arrayList2 = arrayList;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight2 = childAt.getMeasuredHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (measuredWidth + i7 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                this.mLineHeight.add(Integer.valueOf(i6));
                this.mViews.add(arrayList2);
                i6 = marginLayoutParams.topMargin + measuredHeight2 + marginLayoutParams.bottomMargin;
                arrayList2 = new ArrayList();
                i7 = 0;
            }
            i7 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i6 = Math.max(i6, measuredHeight2 + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList2.add(childAt);
        }
        this.mLineHeight.add(Integer.valueOf(i6));
        this.mViews.add(arrayList2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.mViews.size();
        int i9 = paddingLeft;
        for (int i10 = 0; i10 < size; i10++) {
            List list = this.mViews.get(i10);
            int intValue = this.mLineHeight.get(i10).intValue();
            int size2 = list.size();
            int i11 = i9;
            for (int i12 = 0; i12 < size2; i12++) {
                View view = (View) list.get(i12);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i13 = this.mGravity;
                    if (i13 == 0) {
                        measuredHeight = (((intValue - marginLayoutParams2.topMargin) - marginLayoutParams2.bottomMargin) - view.getMeasuredHeight()) / 2;
                    } else if (i13 == 1) {
                        measuredHeight = ((intValue - marginLayoutParams2.topMargin) - marginLayoutParams2.bottomMargin) - view.getMeasuredHeight();
                    } else {
                        i5 = paddingTop;
                        int i14 = marginLayoutParams2.leftMargin + i11;
                        int i15 = i5 + marginLayoutParams2.topMargin;
                        view.layout(i14, i15, view.getMeasuredWidth() + i14, view.getMeasuredHeight() + i15);
                        i11 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                    }
                    i5 = measuredHeight + paddingTop;
                    int i142 = marginLayoutParams2.leftMargin + i11;
                    int i152 = i5 + marginLayoutParams2.topMargin;
                    view.layout(i142, i152, view.getMeasuredWidth() + i142, view.getMeasuredHeight() + i152);
                    i11 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            i9 = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
