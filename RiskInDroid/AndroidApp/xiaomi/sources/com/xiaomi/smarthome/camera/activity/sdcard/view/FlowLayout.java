package com.xiaomi.smarthome.camera.activity.sdcard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    private List<List<View>> mAllViews;
    private List<Integer> mLineHeight;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAllViews = new ArrayList();
        this.mLineHeight = new ArrayList();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getMode(i);
        int mode = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i3 = Math.max(i3, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            i4 = Math.max(i4, i3);
            i5 += measuredWidth;
            if (i5 > (size - getPaddingLeft()) - getPaddingRight()) {
                i4 += i3;
                i5 = measuredWidth;
            }
        }
        if (mode != 1073741824) {
            size2 = i4 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mAllViews.clear();
        this.mLineHeight.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        ArrayList arrayList2 = arrayList;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredWidth + i6 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                this.mLineHeight.add(Integer.valueOf(i5));
                this.mAllViews.add(arrayList2);
                i5 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                arrayList2 = new ArrayList();
                i6 = 0;
            }
            i6 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i5 = Math.max(i5, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList2.add(childAt);
        }
        this.mLineHeight.add(Integer.valueOf(i5));
        this.mAllViews.add(arrayList2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.mAllViews.size();
        int i8 = paddingTop;
        int i9 = paddingLeft;
        for (int i10 = 0; i10 < size; i10++) {
            List list = this.mAllViews.get(i10);
            int intValue = this.mLineHeight.get(i10).intValue();
            int i11 = i9;
            for (int i12 = 0; i12 < list.size(); i12++) {
                View view = (View) list.get(i12);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int i13 = marginLayoutParams2.leftMargin + i11;
                int i14 = marginLayoutParams2.topMargin + i8;
                view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                i11 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
            }
            i9 = getPaddingLeft();
            i8 += intValue;
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
