package com.tmall.wireless.vaf.virtualview.view.vh;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class VHView extends ViewGroup {
    protected int O00000Oo = 1;
    protected int O00000o = 0;
    protected int O00000o0 = 0;
    protected int O00000oO = 0;
    protected int O00000oo = 0;

    public VHView(Context context) {
        super(context);
    }

    public void setOrientation(int i) {
        this.O00000Oo = i;
    }

    public void setItemMargin(int i) {
        this.O00000o0 = i;
    }

    public void setItemWidth(int i) {
        this.O00000o = i;
    }

    public void setItemHeight(int i) {
        this.O00000oO = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.O00000oo = getChildCount();
        int i3 = this.O00000Oo;
        int i4 = 0;
        if (i3 == 0) {
            int size = View.MeasureSpec.getSize(i2);
            if (this.O00000o == 0) {
                this.O00000o = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            }
            if (this.O00000oO == 0) {
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int i5 = this.O00000o0;
                int i6 = this.O00000oo;
                int i7 = paddingTop + (i5 * (i6 - 1));
                if (i6 > 1) {
                    this.O00000oO = (size - i7) / i6;
                } else {
                    this.O00000oO = size - i7;
                }
            } else if (this.O00000oo > 0) {
                int paddingTop2 = getPaddingTop() + getPaddingBottom();
                int i8 = this.O00000o0;
                int i9 = this.O00000oO;
                size = paddingTop2 + ((i8 + i9) * (this.O00000oo - 1)) + i9;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.O00000o, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.O00000oO, 1073741824);
            int childCount = getChildCount();
            while (i4 < childCount) {
                getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
                i4++;
            }
            setMeasuredDimension(this.O00000o + getPaddingLeft() + getPaddingRight(), size);
        } else if (i3 != 1) {
            Log.e("VHView_TMTEST", "onMeasure invalidate orientation:" + this.O00000Oo);
        } else {
            int size2 = View.MeasureSpec.getSize(i);
            if (this.O00000oO == 0) {
                this.O00000oO = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
            }
            if (this.O00000o == 0) {
                int paddingLeft = getPaddingLeft() + getPaddingRight();
                int i10 = this.O00000o0;
                int i11 = this.O00000oo;
                int i12 = paddingLeft + (i10 * (i11 - 1));
                if (i11 > 1) {
                    this.O00000o = (size2 - i12) / i11;
                } else {
                    this.O00000o = size2 - i12;
                }
            } else if (this.O00000oo > 0) {
                int paddingLeft2 = getPaddingLeft() + getPaddingRight();
                int i13 = this.O00000o0;
                int i14 = this.O00000o;
                size2 = paddingLeft2 + ((i13 + i14) * (this.O00000oo - 1)) + i14;
            }
            int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(this.O00000o, 1073741824);
            int makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(this.O00000oO, 1073741824);
            int childCount2 = getChildCount();
            while (i4 < childCount2) {
                getChildAt(i4).measure(makeMeasureSpec3, makeMeasureSpec4);
                i4++;
            }
            setMeasuredDimension(size2, this.O00000oO + getPaddingTop() + getPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.O00000Oo;
        int i6 = 0;
        if (i5 == 0) {
            int paddingLeft = getPaddingLeft();
            int i7 = this.O00000o + paddingLeft;
            int paddingTop = getPaddingTop();
            while (i6 < this.O00000oo) {
                getChildAt(i6).layout(paddingLeft, paddingTop, i7, this.O00000oO + paddingTop);
                paddingTop += this.O00000oO + this.O00000o0;
                i6++;
            }
        } else if (i5 != 1) {
            Log.e("VHView_TMTEST", "onLayout invalidate orientation:" + this.O00000Oo);
        } else {
            int paddingLeft2 = getPaddingLeft();
            int paddingTop2 = getPaddingTop();
            int i8 = this.O00000oO + paddingTop2;
            while (i6 < this.O00000oo) {
                getChildAt(i6).layout(paddingLeft2, paddingTop2, this.O00000o + paddingLeft2, i8);
                paddingLeft2 += this.O00000o + this.O00000o0;
                i6++;
            }
        }
    }
}
