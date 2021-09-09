package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<List<View>> f12250O000000o;
    protected List<Integer> O00000Oo;
    private int O00000o;
    protected List<Integer> O00000o0;
    private List<View> O00000oO;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12250O000000o = new ArrayList();
        this.O00000Oo = new ArrayList();
        this.O00000o0 = new ArrayList();
        this.O00000oO = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.max_select, R.attr.tag_gravity});
        this.O00000o = obtainStyledAttributes.getInt(1, -1);
        obtainStyledAttributes.recycle();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                if (i5 == childCount - 1) {
                    i6 = Math.max(i7, i6);
                    i9 += i8;
                }
                i4 = size2;
            } else {
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
            i3 = i9 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        this.f12250O000000o.clear();
        this.O00000Oo.clear();
        this.O00000o0.clear();
        this.O00000oO.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i8 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.O00000Oo.add(Integer.valueOf(i7));
                    this.f12250O000000o.add(this.O00000oO);
                    this.O00000o0.add(Integer.valueOf(i8));
                    i7 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.O00000oO = new ArrayList();
                    i8 = 0;
                }
                i8 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i7 = Math.max(i7, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.O00000oO.add(childAt);
            }
        }
        this.O00000Oo.add(Integer.valueOf(i7));
        this.O00000o0.add(Integer.valueOf(i8));
        this.f12250O000000o.add(this.O00000oO);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f12250O000000o.size();
        int i10 = paddingLeft;
        int i11 = 0;
        while (i11 < size) {
            this.O00000oO = this.f12250O000000o.get(i11);
            int intValue = this.O00000Oo.get(i11).intValue();
            int intValue2 = this.O00000o0.get(i11).intValue();
            int i12 = this.O00000o;
            if (i12 != -1) {
                if (i12 == 0) {
                    i6 = (width - intValue2) / 2;
                    i5 = getPaddingLeft();
                } else if (i12 == 1) {
                    i6 = width - intValue2;
                    i5 = getPaddingLeft();
                }
                i10 = i6 + i5;
            } else {
                i10 = getPaddingLeft();
            }
            int i13 = i10;
            for (int i14 = 0; i14 < this.O00000oO.size(); i14++) {
                View view = this.O00000oO.get(i14);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i15 = marginLayoutParams2.leftMargin + i13;
                    int i16 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i15, i16, view.getMeasuredWidth() + i15, view.getMeasuredHeight() + i16);
                    i13 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingTop += intValue;
            i11++;
            i10 = i13;
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
