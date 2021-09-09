package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.xiaomi.smarthome.R;

public class ConstraintHeightListView extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f9157O000000o;

    public ConstraintHeightListView(Context context) {
        this(context, null);
    }

    public ConstraintHeightListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConstraintHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9157O000000o = (float) gri.O000000o(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.maxHeight}, 0, i);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                this.f9157O000000o = obtainStyledAttributes.getDimension(index, -1.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void setMaxHeight(int i) {
        float f = (float) i;
        if (f != this.f9157O000000o) {
            this.f9157O000000o = f;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        float f = this.f9157O000000o;
        if (f <= ((float) size) && f > -1.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec(Float.valueOf(f).intValue(), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
