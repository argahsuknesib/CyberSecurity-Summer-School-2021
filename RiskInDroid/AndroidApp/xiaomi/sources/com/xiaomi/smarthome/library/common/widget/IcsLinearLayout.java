package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

final class IcsLinearLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f9199O000000o = {16843049, 16843561, 16843562};
    private Drawable O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;

    public IcsLinearLayout(Context context) {
        super(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f9199O000000o, R.attr.vpiTabPageIndicatorStyle, 0);
        this.O00000oo = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.O00000oO = obtainStyledAttributes.getInteger(1, 0);
        obtainStyledAttributes.recycle();
    }

    public final void setDividerDrawable(Drawable drawable) {
        if (drawable != this.O00000Oo) {
            this.O00000Oo = drawable;
            boolean z = false;
            if (drawable != null) {
                this.O00000o0 = drawable.getIntrinsicWidth();
                this.O00000o = drawable.getIntrinsicHeight();
            } else {
                this.O00000o0 = 0;
                this.O00000o = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int indexOfChild = indexOfChild(view);
        int orientation = getOrientation();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (O000000o(indexOfChild)) {
            if (orientation == 1) {
                layoutParams.topMargin = this.O00000o;
            } else {
                layoutParams.leftMargin = this.O00000o0;
            }
        }
        int childCount = getChildCount();
        if (indexOfChild == childCount - 1 && O000000o(childCount)) {
            if (orientation == 1) {
                layoutParams.bottomMargin = this.O00000o;
            } else {
                layoutParams.rightMargin = this.O00000o0;
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (this.O00000Oo != null) {
            int i3 = 0;
            if (getOrientation() == 1) {
                int childCount = getChildCount();
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !O000000o(i3))) {
                        O000000o(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
                    }
                    i3++;
                }
                if (O000000o(childCount)) {
                    View childAt2 = getChildAt(childCount - 1);
                    if (childAt2 == null) {
                        i2 = (getHeight() - getPaddingBottom()) - this.O00000o;
                    } else {
                        i2 = childAt2.getBottom();
                    }
                    O000000o(canvas, i2);
                }
            } else {
                int childCount2 = getChildCount();
                while (i3 < childCount2) {
                    View childAt3 = getChildAt(i3);
                    if (!(childAt3 == null || childAt3.getVisibility() == 8 || !O000000o(i3))) {
                        O00000Oo(canvas, childAt3.getLeft() - ((LinearLayout.LayoutParams) childAt3.getLayoutParams()).leftMargin);
                    }
                    i3++;
                }
                if (O000000o(childCount2)) {
                    View childAt4 = getChildAt(childCount2 - 1);
                    if (childAt4 == null) {
                        i = (getWidth() - getPaddingRight()) - this.O00000o0;
                    } else {
                        i = childAt4.getRight();
                    }
                    O00000Oo(canvas, i);
                }
            }
        }
        super.onDraw(canvas);
    }

    private void O000000o(Canvas canvas, int i) {
        this.O00000Oo.setBounds(getPaddingLeft() + this.O00000oo, i, (getWidth() - getPaddingRight()) - this.O00000oo, this.O00000o + i);
        this.O00000Oo.draw(canvas);
    }

    private void O00000Oo(Canvas canvas, int i) {
        this.O00000Oo.setBounds(i, getPaddingTop() + this.O00000oo, this.O00000o0 + i, (getHeight() - getPaddingBottom()) - this.O00000oo);
        this.O00000Oo.draw(canvas);
    }

    private boolean O000000o(int i) {
        if (i == 0 || i == getChildCount() || (this.O00000oO & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }
}
