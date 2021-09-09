package com.tmall.wireless.vaf.virtualview.view.grid;

import _m_j.dos;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class GridView extends ViewGroup {
    protected int O00000o = 2;
    protected int O00000oO;
    protected int O00000oo = 0;
    protected int O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo = 0;
    protected int O0000Oo0 = 0;
    protected int O0000OoO = 0;
    protected float O0000Ooo = 1.0f;
    protected float O0000o00 = 1.0f;

    public GridView(Context context) {
        super(context);
    }

    public void setAutoDimDirection(int i) {
        this.O0000OoO = i;
    }

    public void setAutoDimX(float f) {
        this.O0000Ooo = f;
    }

    public void setAutoDimY(float f) {
        this.O0000o00 = f;
    }

    public void setColumnCount(int i) {
        this.O00000o = i;
    }

    public void setItemHorizontalMargin(int i) {
        this.O0000Oo0 = i;
    }

    public void setItemVerticalMargin(int i) {
        this.O0000Oo = i;
    }

    public void setItemHeight(int i) {
        this.O00000oo = i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a2 A[LOOP:0: B:19:0x00a0->B:20:0x00a2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d0  */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = this.O0000OoO;
        if (i5 > 0) {
            if (i5 != 1) {
                if (i5 == 2 && 1073741824 == View.MeasureSpec.getMode(i2)) {
                    i = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i2)) * this.O0000Ooo) / this.O0000o00), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i)) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i)) * this.O0000o00) / this.O0000Ooo), 1073741824);
            }
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getMode(i);
        int mode = View.MeasureSpec.getMode(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight() + (this.O0000Oo0 * (this.O00000o - 1));
        int childCount = getChildCount();
        this.O0000O0o = (size - paddingLeft) / this.O00000o;
        int i6 = this.O00000oo;
        int i7 = 0;
        if (i6 > 0) {
            this.O0000OOo = i6;
        } else if (childCount > 0) {
            View childAt = getChildAt(0);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(this.O0000O0o, 1073741824), i2);
            this.O0000OOo = childAt.getMeasuredHeight();
            i3 = 1;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.O0000O0o, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.O0000OOo, 1073741824);
            while (i3 < childCount) {
                getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
                i3++;
            }
            i4 = this.O00000o;
            int i8 = childCount / i4;
            if (childCount % i4 > 0) {
                i7 = 1;
            }
            this.O00000oO = i8 + i7;
            int i9 = this.O00000oO;
            int paddingTop = (this.O0000OOo * i9) + ((i9 - 1) * this.O0000Oo) + getPaddingTop() + getPaddingBottom();
            if (mode != 0) {
                paddingTop = Math.min(size2, paddingTop);
            }
            setMeasuredDimension(size, paddingTop);
        } else {
            this.O0000OOo = (size2 - getPaddingTop()) - getPaddingBottom();
        }
        i3 = 0;
        int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(this.O0000O0o, 1073741824);
        int makeMeasureSpec22 = View.MeasureSpec.makeMeasureSpec(this.O0000OOo, 1073741824);
        while (i3 < childCount) {
        }
        i4 = this.O00000o;
        int i82 = childCount / i4;
        if (childCount % i4 > 0) {
        }
        this.O00000oO = i82 + i7;
        int i92 = this.O00000oO;
        int paddingTop2 = (this.O0000OOo * i92) + ((i92 - 1) * this.O0000Oo) + getPaddingTop() + getPaddingBottom();
        if (mode != 0) {
        }
        setMeasuredDimension(size, paddingTop2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i5 = paddingTop;
        int i6 = 0;
        int i7 = 0;
        while (i6 < this.O00000oO) {
            int i8 = paddingLeft;
            int i9 = i7;
            for (int i10 = 0; i10 < this.O00000o && i9 < childCount; i10++) {
                View childAt = getChildAt(i9);
                int O000000o2 = dos.O000000o(dos.O000000o(), 0, i3 - i, i8, this.O0000O0o);
                childAt.layout(O000000o2, i5, this.O0000O0o + O000000o2, this.O0000OOo + i5);
                i9++;
                i8 += this.O0000O0o + this.O0000Oo0;
            }
            i5 += this.O0000OOo + this.O0000Oo;
            i6++;
            i7 = i9;
        }
    }
}
