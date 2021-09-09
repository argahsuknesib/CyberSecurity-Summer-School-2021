package com.xiaomi.smarthome.newui.widget;

import _m_j.bn;
import _m_j.cb;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;

public class FlowLayoutCopy extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10307O000000o;
    private int O00000Oo;
    private int O00000o;
    private boolean O00000o0;

    public FlowLayoutCopy(Context context) {
        this(context, null);
    }

    public FlowLayoutCopy(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayoutCopy(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = 1;
        this.O00000o0 = false;
        O000000o(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayoutCopy(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.O00000o = 1;
        this.O00000o0 = false;
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.itemSpacing_copy, R.attr.lineSpacing_copy}, 0, 0);
        this.f10307O000000o = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.O00000Oo = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    public int getLineSpacing() {
        return this.f10307O000000o;
    }

    public void setLineSpacing(int i) {
        this.f10307O000000o = i;
    }

    public int getItemSpacing() {
        return this.O00000Oo;
    }

    public void setItemSpacing(int i) {
        this.O00000Oo = i;
    }

    public void setSingleLine(boolean z) {
        this.O00000o0 = z;
    }

    public int getLines() {
        return this.O00000o;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        this.O00000o = 1;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i5 - getPaddingRight();
        int i6 = paddingLeft;
        int i7 = paddingTop;
        int i8 = i7;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i3 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
                int i11 = i6;
                if (i6 + i3 + childAt.getMeasuredWidth() > paddingRight && !this.O00000o0) {
                    int paddingLeft2 = getPaddingLeft();
                    i8 = this.f10307O000000o + i7;
                    this.O00000o++;
                    i11 = paddingLeft2;
                }
                int measuredWidth = i11 + i3 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                i7 = measuredHeight;
                i6 = i11 + i3 + i4 + childAt.getMeasuredWidth() + this.O00000Oo;
            }
        }
        setMeasuredDimension(O000000o(size, mode, i9), O000000o(size2, mode2, i7 + getPaddingBottom()));
    }

    private static int O000000o(int i, int i2, int i3) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 1073741824 ? i3 : i;
        }
        return Math.min(i3, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() != 0) {
            boolean z2 = true;
            if (cb.O0000Oo0(this) != 1) {
                z2 = false;
            }
            int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int i7 = (i3 - i) - paddingLeft;
            int i8 = paddingRight;
            int i9 = paddingTop;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i5 = bn.O000000o(marginLayoutParams);
                        i6 = bn.O00000Oo(marginLayoutParams);
                    } else {
                        i6 = 0;
                        i5 = 0;
                    }
                    int measuredWidth = i8 + i5 + childAt.getMeasuredWidth();
                    if (!this.O00000o0 && measuredWidth > i7) {
                        i9 = paddingTop + this.f10307O000000o;
                        i8 = paddingRight;
                    }
                    int i11 = i8 + i5;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i11;
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    if (z2) {
                        childAt.layout(i7 - measuredWidth2, i9, (i7 - i8) - i5, measuredHeight);
                    } else {
                        childAt.layout(i11, i9, measuredWidth2, measuredHeight);
                    }
                    i8 += i5 + i6 + childAt.getMeasuredWidth() + this.O00000Oo;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        requestLayout();
    }
}
