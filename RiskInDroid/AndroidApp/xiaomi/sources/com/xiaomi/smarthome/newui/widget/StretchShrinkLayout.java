package com.xiaomi.smarthome.newui.widget;

import _m_j.gsy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class StretchShrinkLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10335O000000o;
    private int O00000Oo;

    public StretchShrinkLayout(Context context) {
        super(context);
    }

    public StretchShrinkLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public StretchShrinkLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    public StretchShrinkLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        this.f10335O000000o = attributeSet.getAttributeIntValue(null, "stretch", 0);
        this.O00000Oo = attributeSet.getAttributeIntValue(null, "shrink", 0);
        gsy.O000000o(4, "StretchShrinkLayout", "stretch:" + this.f10335O000000o + " shrink:" + this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            childAt.measure(makeMeasureSpec, makeMeasureSpec2);
            if (childAt.getVisibility() != 8) {
                i5 = i5 + childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                paddingTop = paddingTop + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
        }
        View view = null;
        if (getOrientation() == 0) {
            if (i5 > measuredWidth) {
                int i7 = this.O00000Oo;
                if (i7 < childCount) {
                    view = getChildAt(i7);
                }
            } else if (i5 < measuredWidth && (i4 = this.f10335O000000o) < childCount) {
                view = getChildAt(i4);
            }
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, measuredWidth - (i5 - view.getMeasuredWidth())), 1073741824), makeMeasureSpec2);
                return;
            }
            return;
        }
        if (paddingTop > measuredHeight) {
            int i8 = this.O00000Oo;
            if (i8 < childCount) {
                view = getChildAt(i8);
            }
        } else if (paddingTop < measuredHeight && (i3 = this.f10335O000000o) < childCount) {
            view = getChildAt(i3);
        }
        if (view != null) {
            view.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(0, measuredHeight - (paddingTop - view.getMeasuredHeight())), 1073741824));
        }
    }
}
