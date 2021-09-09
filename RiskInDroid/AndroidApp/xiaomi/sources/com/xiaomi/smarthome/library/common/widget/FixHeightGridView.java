package com.xiaomi.smarthome.library.common.widget;

import _m_j.gsy;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

public class FixHeightGridView extends GridView {

    /* renamed from: O000000o  reason: collision with root package name */
    private ListAdapter f9180O000000o;
    private DataSetObserver O00000Oo = new DataSetObserver() {
        /* class com.xiaomi.smarthome.library.common.widget.FixHeightGridView.AnonymousClass1 */

        public final void onChanged() {
            ViewGroup.LayoutParams layoutParams = FixHeightGridView.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -2;
                gsy.O000000o(4, "FixHeightGridView", "onChanged");
            }
        }
    };

    public FixHeightGridView(Context context) {
        super(context);
    }

    public FixHeightGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixHeightGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            i3 = View.MeasureSpec.getSize(i2);
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i3);
        gsy.O000000o(4, "FixHeightGridView", "onMeasure getMeasuredHeight:" + getMeasuredHeight());
        setFocusable(false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (childCount > 0 && layoutParams != null && layoutParams.height < 0 && (childAt = getChildAt(childCount - 1)) != null) {
            int bottom = childAt.getBottom() + getPaddingBottom();
            int i5 = i4 - i2;
            if (i5 < bottom) {
                layoutParams.height = bottom;
                requestLayout();
            }
            gsy.O000000o(4, "FixHeightGridView", "onLayout  tagetHeight:" + bottom + "  currentHeight:" + i5);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            ListAdapter listAdapter2 = this.f9180O000000o;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(this.O00000Oo);
            }
            this.f9180O000000o = listAdapter;
            this.f9180O000000o.registerDataSetObserver(this.O00000Oo);
            this.O00000Oo.onChanged();
        }
        super.setAdapter(listAdapter);
    }
}
