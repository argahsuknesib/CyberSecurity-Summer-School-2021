package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.mi.util.Device;

public class MaxHeightListView extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f4956O000000o = (Device.O00000Oo / 2);

    public int getMaxHeight() {
        return this.f4956O000000o;
    }

    public void setMaxHeight(int i) {
        this.f4956O000000o = i;
    }

    public MaxHeightListView(Context context) {
        super(context);
    }

    public MaxHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && size > (i3 = this.f4956O000000o)) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
