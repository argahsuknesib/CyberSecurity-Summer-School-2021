package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FlowGroupV2 extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9184O000000o;
    protected int O00000Oo = 0;
    protected int O00000o = 0;
    protected boolean O00000o0 = false;
    protected List<View> O00000oO = new ArrayList();
    private int O00000oo;
    private int O0000O0o = 0;
    private int O0000OOo = Integer.MAX_VALUE;
    private View O0000Oo;
    private int O0000Oo0;
    private View O0000OoO;

    public FlowGroupV2(Context context) {
        super(context);
        O000000o();
    }

    public FlowGroupV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public FlowGroupV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.f9184O000000o = gri.O000000o(10.0f);
        this.O00000oo = gri.O000000o(13.0f);
        this.O0000Oo0 = (getResources().getDisplayMetrics().widthPixels * 2) / 5;
    }

    public void setMaxRows(int i) {
        this.O0000OOo = i;
    }

    public int getMaxRows() {
        return this.O0000OOo;
    }

    public void setMoreView(View view) {
        this.O0000Oo = view;
    }

    public void setAddView(View view) {
        this.O0000OoO = view;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int size = this.O00000oO.size();
        if (size == 0) {
            super.onMeasure(i, i2);
            return;
        }
        View view = this.O0000Oo;
        if (view != null) {
            view.measure(0, 0);
            i3 = this.O0000Oo.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        View view2 = this.O0000OoO;
        if (view2 != null) {
            view2.measure(0, 0);
            i3 = Math.max(i3, this.O0000OoO.getMeasuredWidth());
        }
        int size2 = View.MeasureSpec.getSize(i);
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            View view3 = this.O00000oO.get(i4);
            if (view3.getVisibility() != 8) {
                if (view3.getParent() == null) {
                    addView(view3);
                }
                view3.measure(View.MeasureSpec.makeMeasureSpec(this.O0000Oo0, Integer.MIN_VALUE), 0);
                int measuredWidth = view3.getMeasuredWidth();
                int measuredHeight = getChildAt(0).getMeasuredHeight() + this.O00000oo;
                int i8 = i5 + measuredWidth;
                int i9 = this.f9184O000000o + i8;
                if (i6 >= this.O0000OOo && (this.O0000Oo != null || this.O0000OoO != null)) {
                    if (i9 >= (size2 - i3) - this.f9184O000000o) {
                        this.O00000Oo = i4 + 1;
                        break;
                    }
                } else if (i8 > size2) {
                    i6++;
                    i7 += measuredHeight;
                    i5 = 0;
                }
                i5 += measuredWidth + this.f9184O000000o;
            }
            i4++;
        }
        if (this.O00000Oo == 0) {
            this.O00000Oo = i4 + 1;
        }
        this.O0000O0o = i6;
        setMeasuredDimension(size2, i7 + getChildAt(0).getMeasuredHeight() + gri.O000000o(26.0f));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int size = this.O00000oO.size();
        if (size != 0) {
            int i5 = i3 - i;
            int i6 = this.O00000Oo;
            if (i6 == 0) {
                i6 = size;
            }
            this.O00000Oo = i6;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 <= size - 1 && i7 < this.O00000Oo - 1) {
                View view = this.O00000oO.get(i7);
                if (view.getVisibility() != 8) {
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    if (i8 + measuredWidth > i5) {
                        i9 += this.O00000oo + measuredHeight;
                        i8 = 0;
                    }
                    view.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
                    i8 += view.getWidth() + this.f9184O000000o;
                }
                i7++;
            }
            if (this.O00000o0) {
                return;
            }
            if (this.O0000Oo != null || this.O0000OoO != null) {
                View view2 = this.O00000Oo == size + 1 ? this.O0000OoO : this.O0000Oo;
                view2.layout(i8, i9, view2.getMeasuredWidth() + i8, view2.getMeasuredHeight() + i9);
                if (view2 != null && view2.getParent() == null) {
                    addView(view2);
                    this.O00000o0 = true;
                }
            }
        }
    }
}
