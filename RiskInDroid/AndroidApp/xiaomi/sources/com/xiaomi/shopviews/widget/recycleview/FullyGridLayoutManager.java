package com.xiaomi.shopviews.widget.recycleview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FullyGridLayoutManager extends GridLayoutManager {

    /* renamed from: O000000o  reason: collision with root package name */
    private int[] f3990O000000o = new int[2];

    public FullyGridLayoutManager(Context context) {
        super(context, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    public void onMeasure(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i, int i2) {
        int i3;
        int i4;
        RecyclerView.O000O0OO o000o0oo2 = o000o0oo;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int itemCount = getItemCount();
        int spanCount = getSpanCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < itemCount) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, i5);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, i5);
            int[] iArr = this.f3990O000000o;
            if (i6 < getItemCount()) {
                try {
                    View O00000Oo = o000o0oo2.O00000Oo(i5);
                    if (O00000Oo != null) {
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) O00000Oo.getLayoutParams();
                        i4 = size;
                        i3 = size2;
                        try {
                            O00000Oo.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                            iArr[0] = O00000Oo.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                            iArr[1] = O00000Oo.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
                            o000o0oo2.O000000o(O00000Oo);
                        } catch (Exception e) {
                            e = e;
                        }
                        if (getOrientation() == 0) {
                            if (i6 % spanCount == 0) {
                                i7 += this.f3990O000000o[0];
                            }
                            if (i6 == 0) {
                                i8 = this.f3990O000000o[1];
                            }
                        } else {
                            if (i6 % spanCount == 0) {
                                i8 += this.f3990O000000o[1];
                            }
                            if (i6 == 0) {
                                i7 = this.f3990O000000o[0];
                                i6++;
                                size = i4;
                                size2 = i3;
                                i5 = 0;
                            }
                        }
                        i6++;
                        size = i4;
                        size2 = i3;
                        i5 = 0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i4 = size;
                    i3 = size2;
                    e.printStackTrace();
                    if (getOrientation() == 0) {
                    }
                    i6++;
                    size = i4;
                    size2 = i3;
                    i5 = 0;
                }
            }
            i4 = size;
            i3 = size2;
            if (getOrientation() == 0) {
            }
            i6++;
            size = i4;
            size2 = i3;
            i5 = 0;
        }
        int i9 = size;
        int i10 = size2;
        if (mode == 1073741824) {
            i7 = i9;
        }
        if (mode2 == 1073741824) {
            i8 = i10;
        }
        setMeasuredDimension(i7, i8);
    }
}
